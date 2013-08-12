(ns adventure.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [adventure.models.schema :as schema]))

(defdb db schema/db-spec)

(declare adventure scene scene-nav)

(defentity adventure
  (has-many scene))

(defentity scene
  (belongs-to adventure)
  (has-many scene-nav))

(defentity scene-nav
  (table :scene_nav)
  (belongs-to scene))

(defn get-adventures
  "Returns all adventures."
  []
  (select adventure
    (order :created_on :DESC)))

(defn get-adventure
  "Gets an adventure by its id."
  [id]
  (first
    (select adventure
      (where {:id id}))))