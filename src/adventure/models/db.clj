(ns adventure.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [adventure.models.schema :as schema]))

(defdb db schema/db-spec)
