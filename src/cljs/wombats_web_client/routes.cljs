(ns wombats_web_client.routes
    (:require-macros [secretary.core :refer [defroute]])
    (:import goog.History)
    (:require [secretary.core :as secretary]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [re-frame.core :as re-frame]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
    (re-frame/dispatch [:set-active-panel :home-panel {}]))

  (defroute "/about" []
    (re-frame/dispatch [:set-active-panel :about-panel {}]))

  (defroute "/admin" []
    (re-frame/dispatch [:set-active-panel :admin-panel {}]))

  (defroute "/preview/:id" [id]
    (re-frame/dispatch [:set-active-panel :preview-game {:id id}]))

  (defroute "/settings" []
    (re-frame/dispatch [:set-active-panel :settings-panel {}]))

  (defroute "/signout" []
    (re-frame/dispatch [:sign-out])
    (re-frame/dispatch [:set-active-panel :home-panel])

    (set! (-> js/window .-location .-hash) "#/"))

  ;; --------------------
  (hook-browser-navigation!))
