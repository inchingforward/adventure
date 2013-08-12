(ns adventure.routes.home
  (:use compojure.core)
  (:require [adventure.views.layout :as layout]
            [adventure.util :as util]
            [adventure.models.db :as db]))

(defn home-page []
  (layout/render
    "home.html" {:adventures (db/get-adventures)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
