(ns wombats-web-client.constants.urls)

<<<<<<< HEAD
(def base-api-url "//54.145.152.66")
=======
(def base-api-url "http://dev.wombats.io")
>>>>>>> 9a2dc21... Update base url, add modal flow, add button component

(def self-url (str base-api-url "/api/v1/self"))
(def github-signout-url (str base-api-url "/api/v1/auth/github/signout"))
(def github-signin-url (str base-api-url "/api/v1/auth/github/signin"))

<<<<<<< HEAD
(def game-url (str "ws:" base-api-url "/ws/game"))
=======
(defn my-wombats-url
  [id]
  (str base-api-url "/api/v1/users/" id "/wombats"))
>>>>>>> 25ca65d... submitting a new wombat, success & error cbs
