(ns wombats-web-client.components.cards.wombat
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent]
            [wombats-web-client.components.modals.delete-wombat-modal :refer [delete-wombat-modal]]
            [wombats-web-client.components.modals.wombat-modal :refer [wombat-modal]]))

(defn open-delete-wombat-modal [id]
  (fn []
    (re-frame/dispatch [:set-modal {:fn #(delete-wombat-modal id)
                                    :show-overlay? true}])))

(defn open-edit-wombat-modal [id name url]
  (fn []
    (re-frame/dispatch [:set-modal {:fn #(wombat-modal {:wombat-id id
                                                               :name name
                                                               :url url})
                                    :show-overlay? true}])))

(defn wombat-information
  [cmpnt-state name id url]
  (let [user-hovering (:user-hovering @cmpnt-state)]
    [:div.wombat-information {:class (when user-hovering "hovering")}
     [:div.name name]
     (when user-hovering
       [:div.hover-state-edit
        [:input.edit {:type "button"
                      :value "EDIT"
                      :on-click (open-edit-wombat-modal id name url)}]
        [:input.delete {:type "button"
                        :value "DELETE"
                        :on-click (open-delete-wombat-modal id)}]])]))

(defn root [wombat]
  (let [cmpnt-state (reagent/atom {:user-hovering false})
        {id :wombat/id
         name :wombat/name
         url :wombat/url} wombat]
    [:div.wombat-card {:key id
                       :onMouseOver #(swap! cmpnt-state assoc :user-hovering true)
                       :onMouseOut #(swap! cmpnt-state assoc :user-hovering false)}
     [:img.wombat-image {:src (str "/images/naked_wombat.png")}]
     [wombat-information cmpnt-state name id url]]))
