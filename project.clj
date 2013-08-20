(defproject adventure "0.1.0-SNAPSHOT"
  :description "A web-based story engine"
  :url "http://adventure.inchingforward.com"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [lib-noir "0.6.6"]
                 [compojure "1.1.5"]
                 [ring-server "0.2.8"]
                 [selmer "0.3.6"]
                 [com.taoensso/timbre "2.1.2"]
                 [com.postspectacular/rotor "0.1.0"]
                 [com.taoensso/tower "1.7.1"]
                 [markdown-clj "0.9.28"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [korma "0.3.0-RC5"]
                 [lobos "1.0.0-beta1"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler adventure.handler/war-handler
         :init    adventure.handler/init
         :destroy adventure.handler/destroy
         :port    3030}
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.1.8"]]}}
  :min-lein-version "2.0.0")
