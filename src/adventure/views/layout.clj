(ns adventure.views.layout
  (:use noir.request)
  (:require [selmer.parser :as parser]
            [selmer.filters :as filters]
            [markdown.core :as md]))

(filters/add-filter! :markdown
                     (fn [s]
                       [:safe (md/md-to-html-string s)]))

(def template-path "adventure/views/templates/")

(defn render [template & [params]]
  (parser/render-file (str template-path template)
                      (assoc params :servlet-context (:context *request*))))

