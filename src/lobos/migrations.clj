(ns lobos.migrations
  (:refer-clojure
   :exclude [alter drop bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]] core schema config)))

(defmigration add-adventure-table
  (up [] (create
          (table :adventure
                 (bigint :id :primary-key :auto-inc)
                 (text :title :not-null)
                 (text :details)
                 (text :author :not-null)
                 (text :salt)
                 (text :password)
                 (timestamp :created_on (default (now))))))
  (down [] (drop (table :adventure))))

(defmigration add-scene-table
  (up [] (create
          (table :scene
                 (bigint :id :primary-key :auto-inc)
                 (bigint :adventure_id [:refer :adventure :id] :not-null)
                 (text :title :not-null)
                 (text :body :not-null))))
  (down [] (drop (table :scene))))

(defmigration add-scene-nav-table
  (up [] (create
          (table :scene_nav
                 (bigint :id :primary-key :auto-inc)
                 (bigint :scene_id [:refer :scene :id] :not-null)
                 (bigint :next_scene_id [:refer :scene :id] :not-null)
                 (text :title :not-null))))
  (down [] (drop (table :scene_nav))))

(defmigration add-adventure-starting-scene
  (up []
      (alter :add
             (table :adventure
                    (bigint :starting_scene_id [:refer :scene :id]))))
  (down []
        (alter :drop
               (table :adventure
                      (column :starting_scene_id)))))

