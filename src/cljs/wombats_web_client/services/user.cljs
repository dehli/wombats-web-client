(ns wombats-web-client.services.user
  (:require [ajax.core :refer [GET]]
            [wombats-web-client.utils.auth :refer [add-auth-header]]
            [wombats-web-client.constants.urls :refer [self-url github-signout-url]]))

(defn get-current-user
  "fetches the current user object"
  [on-success on-error]
  (GET self-url {:response-format :json
                 :keywords? true
                 :headers (add-auth-header {})
                 :handler on-success
                 :error-handler on-error}))

(defn sign-out-user
  "signs out user from server and removes their auth token"
  [on-success on-error]
  (GET github-signout-url {:response-format :json
                           :keywords? true
                           :headers (add-auth-header {})
                           :handler on-success
                           :error-handler on-error}))

