(ns lobos.config
  (:use lobos.connectivity)
  (:require [adventure.models.schema :as schema]))

(open-global schema/db-spec)
