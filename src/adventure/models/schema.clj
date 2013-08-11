(ns adventure.models.schema
  (:require [clojure.java.jdbc :as sql]
            [adventure.util :as util]))

(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/adventure"
   :user (util/env-var "ADV_DB_USER")
   :password (util/env-var "ADV_DB_PASS")})
