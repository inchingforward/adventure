(ns adventure.routes.home
  (:use compojure.core)
  (:require [adventure.views.layout :as layout]
            [adventure.util :as util]
            [adventure.models.db :as db]))

(defn home-page []
  (layout/render
    "home.html" {:adventures (db/get-adventures)
                 :analytics-id (util/env-var "ADV_ANALYTICS_ID")}))

(defn about-page []
  (layout/render "about.html"))

(defn adventure-page [id]
  (layout/render "adventure.html" {:adventure (db/get-adventure (read-string id))}))

(defn scene-page [adventure-id scene-id]
  (layout/render "adventure.html" {:scene (db/get-scene adventure-id scene-id)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/adventure/:id" [id] (adventure-page id))
  (GET "/adventure/:a/scene/:s" [adventure-id scene-id] (scene-page adventure-id scene-id)))

