(defproject setup-test "0.1.0-SNAPSHOT"

  :description "Test training setup, depends on half of the internet just to populate your local .m2 caches"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]

                 ;; Tooling:

                 [org.clojure/tools.namespace "0.3.0-alpha3"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/tools.reader "1.3.2"]

                 ;; Common:

                 [org.clojure/core.async "0.4.490"]
                 [prismatic/schema "1.1.10"]
                 [prismatic/plumbing "0.5.5"]
                 [metosin/potpuri "0.5.2"]

                 ;; Backend:

                 [mount "0.1.16"]
                 [metosin/schema-tools "0.11.0"]
                 [metosin/lokit "0.1.0"]
                 [clj-http "3.9.1"]

                 ; HTTP:

                 [http-kit "2.3.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-devel "1.7.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring-webjars "0.2.0"]
                 [ring-middleware-format "0.7.4"]
                 [metosin/ring-http-response "0.9.1"]
                 [metosin/compojure-api "1.1.12"]
                 [metosin/ring-swagger-ui "3.20.1"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]

                 ; DB:

                 [org.clojure/java.jdbc "0.7.9"]
                 [org.postgresql/postgresql "42.2.5"]
                 [hikari-cp "2.7.1"]
                 [com.layerware/hugsql "0.4.9"]
                 [org.flywaydb/flyway-core "5.2.4"]
                 [com.h2database/h2 "1.4.199" :scope "test"]

                 ;; Frontend:

                 [reagent "0.8.1"]
                 [cljs-http "0.1.46"]
                 [ring-webjars "0.2.0"]
                 [org.webjars/bootstrap "4.3.1"]
                 [org.webjars/font-awesome "5.8.1"]
                 [org.webjars/es5-shim "4.5.9"]
                 [binaryage/devtools "0.9.10"]
                 [metosin/reagent-dev-tools "0.2.0"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.18" :exclusions [org.clojure/clojure]]
            [lein-ring "0.12.5"]
            [lein-deps-tree "0.1.2"]
            [lein-ancient "0.6.15" :exclusions [org.clojure/clojure]]
            [com.jakemccrary/lein-test-refresh "0.24.1"]]

  :source-paths ["src/clj"]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/setup.js"
                                   :optimizations :whitespace}}]}

  :repl-options {:init-ns setup.server}
  :ring {:handler setup.server/app}

  :min-lein-version "2.5.3"

  :aliases {"welcome" [["do" "clean" ["cljsbuild" "once"] ["ring" "server"]]]})
