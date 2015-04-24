(defproject setup-test "0.1.0-SNAPSHOT"
  :description "Test training setup, depend on half of the internet to populate local .m2 caches"
  :license {:name "Eclipse Public License" :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0-beta1"]
                 [org.clojure/tools.reader "0.9.2"]
                 [org.clojure/clojurescript "0.0-3211"]

                 ; Server:
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-devel "1.3.2"]

                 ; Not used by this project, but included in here so that thet
                 ; get pulled to your local .m2 repo before training.
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [prismatic/schema "0.4.1"]
                 [prismatic/plumbing "0.4.2"]

                 [com.stuartsierra/component "0.2.3"]

                 [clj-http "1.1.1"]
                 [cljs-http "0.1.30"]

                 [clj-time "0.9.0"]
                 [com.andrewmcveigh/cljs-time "0.3.4"]

                 [com.novemberain/monger "2.1.0"]

                 [enlive "1.1.5"]
                 [hiccup "1.0.5"]

                 [reagent "0.5.0"]
                 [garden "1.2.5"]
                 [prismatic/dommy "1.0.0"]
                 [com.domkm/silk "0.0.4"]

                 [ring-webjars "0.1.0"]
                 [org.webjars/bootstrap "3.3.2-1"]
                 [org.webjars/font-awesome "4.3.0-1"]
                 [org.webjars/es5-shim "4.0.6"]

                 [metosin/potpuri "0.2.2"]
                 [metosin/compojure-api "0.19.3"]
                 [metosin/ring-swagger-ui "2.1.0-M2-2"]
                 [metosin/ring-http-response "0.6.1"]

                 [im.chit/purnam.test "0.5.2"]]

  :source-paths ["src/clj" "src/cljs"]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :plugins [[lein-ring "0.9.3"]
                             [lein-cljsbuild "1.0.5"]]}
             :uberjar {:hooks [leiningen.cljsbuild]
                       :source-paths ["src/clj" "src/main"]
                       :main setup.main
                       :aot [setup.main]
                       :cljsbuild {:builds {:client {:compiler {:optimizations :advanced
                                                                :elide-asserts true
                                                                :pretty-print false}}
                                            ; uncomment this if you're on mac and have growlnotify installed
                                            ; :notify-command ["growlnotify" "-n" "cljsbuild" "-m"]
                                            }}}}
  :cljsbuild {:builds {:client {:source-paths ["src/cljs"]
                                :compiler {:output-to "resources/public/setup.js"
                                           :output-dir "target/js/out"
                                           :optimizations :whitespace
                                           :pretty-print true}}}}
  :repl-options {:init-ns setup.server}
  :ring {:handler setup.server/app}
  :uberjar-name "setup.jar"
  :min-lein-version "2.3.4")
