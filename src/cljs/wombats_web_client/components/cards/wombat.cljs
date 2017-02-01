(ns wombats-web-client.components.cards.wombat
  (:require [re-frame.core :as re-frame]
            [wombats-web-client.components.modals.delete-wombat-modal :refer [delete-wombat-modal]]))

(defn temp-modal []
  )
(defn open-delete-wombat-modal [id]
  (fn [id]
    (print "on delete click")
    (re-frame/dispatch [:set-modal #(delete-wombat-modal id)])))

(defn root [wombat]
  [:div.wombat-card {:key (:id wombat)}
   [:div "wombat image"]
   [:div (:name wombat)]
   [:div.hover-state-edit
    [:input {:type "button"
             :value "DELETE"
             :on-click (open-delete-wombat-modal (:id wombat))}]]])
