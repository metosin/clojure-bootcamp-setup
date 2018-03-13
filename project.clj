(defproject setup-test "0.1.0-SNAPSHOT"

  :description "Test training setup, depends on half of the internet just to populate your local .m2 caches"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.145"]

                 ;; Tooling:

                 [org.clojure/tools.namespace "0.3.0-alpha3"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/tools.reader "1.2.2"]

                 ;; Common:

                 [org.clojure/core.async "0.4.474"]
                 [prismatic/schema "1.1.7"]
                 [prismatic/plumbing "0.5.5"]
                 [metosin/potpuri "0.5.1"]

                 ;; Backend:

                 [mount "0.1.12"]
                 [metosin/schema-tools "0.10.0-20160425.120043-1"]
                 [metosin/lokit "0.1.0"]
                 [clj-http "3.8.0"]

                 ; HTTP:

                 [http-kit "2.2.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-devel "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [ring-webjars "0.2.0"]
                 [ring-middleware-format "0.7.2"]
                 [metosin/ring-http-response "0.9.0"]
                 [metosin/compojure-api "1.1.12"]
                 [metosin/ring-swagger-ui "3.9.0"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]

                 ; DB:

                 [org.clojure/java.jdbc "0.7.5"]
                 [org.postgresql/postgresql "42.2.1"]
                 [hikari-cp "2.2.0"]
                 [com.layerware/hugsql "0.4.8"]
                 [org.flywaydb/flyway-core "5.0.7"]
                 [com.h2database/h2 "1.4.196" :scope "test"]

                 ;; Frontend:

                 [reagent "0.7.0"]
                 [cljs-http "0.1.44"]
                 [ring-webjars "0.2.0"]
                 [org.webjars/bootstrap "4.0.0-2"]
                 [org.webjars/font-awesome "5.0.6"]
                 [org.webjars/es5-shim "4.5.9"]
                 [binaryage/devtools "0.9.9"]
                 [metosin/reagent-dev-tools "0.2.0"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.9" :exclusions [org.clojure/clojure]]
            [lein-ring "0.11.0"]
            [lein-deps-tree "0.1.2"]
            [lein-ancient "0.6.10" :exclusions [org.clojure/clojure]]
            [com.jakemccrary/lein-test-refresh "0.18.1"]]

  :source-paths ["src/clj"]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/setup.js"
                                   :optimizations :whitespace}}]}

  :repl-options {:init-ns setup.server}
  :ring {:handler setup.server/app}

  :min-lein-version "2.5.3"

  :aliases {"welcome" [["do" "clean" ["cljsbuild" "once"] ["ring" "server"]]]})
