(defproject setup-test "0.1.0-SNAPSHOT"
  :description "Test training setup, depend on half of the internet to populate local .m2 caches"
  :license {:name "Eclipse Public License" :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [prismatic/schema "0.3.1"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.3.1"]
                 [ring/ring-devel "1.3.1"]
                 [compojure "1.2.1"]
                 [metosin/ring-http-response "0.5.1"]
                 [org.clojure/clojurescript "0.0-2371"]
                 ; pull these in users local .m2 repo before training
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [camel-snake-kebab "0.2.5" :exclusions [org.clojure/clojure]]
                 [cheshire "5.3.1"]
                 [com.novemberain/monger "2.0.0"]
                 [slingshot "0.12.1"]
                 [clj-http "1.0.0"]
                 [enlive "1.1.5"]
                 [hiccup "1.0.5"]
                 [clj-time "0.8.0"]
                 [garden "1.2.5"]
                 [prismatic/dommy "1.0.0"]
                 [om "0.7.3"]
                 [prismatic/om-tools "0.3.6" :exclusions [org.clojure/clojure]]
                 [cljs-ajax "0.3.3"]
                 [com.andrewmcveigh/cljs-time "0.2.3"]
                 [im.chit/purnam.test "0.5.1"]
                 [sablono "0.2.22"]]
  :pedantic? false
  :source-paths ["src/clj" "src/cljs"]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :plugins [[lein-ring "0.8.10"]
                             [lein-cljsbuild "1.0.3"]
                             [com.keminglabs/cljx "0.4.0"]]}
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
