(ns wombats_web_client.subs.user
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

;; Current User
(re-frame/register-sub
  :user
  (fn [db]
    (reaction (:user @db))))

;; All users (admin)
(re-frame/register-sub
  :users
  (fn [db _]
    (reaction (:users @db))))
