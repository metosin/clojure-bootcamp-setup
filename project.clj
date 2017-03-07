(defproject setup-test "0.1.0-SNAPSHOT"

  :description "Test training setup, depends on half of the internet just to populate your local .m2 caches"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.456"]

                 ;; Tooling:

                 [org.clojure/tools.namespace "0.3.0-alpha3"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.reader "1.0.0-beta3"]

                 ;; Common:

                 [org.clojure/core.async "0.3.441"]
                 [prismatic/schema "1.1.3"]
                 [prismatic/plumbing "0.5.3"]
                 [metosin/potpuri "0.4.0"]

                 ;; Backend:

                 [mount "0.1.11"]
                 [metosin/schema-tools "0.10.0-20160425.120043-1"]
                 [metosin/lokit "0.1.0"]
                 [clj-http "3.4.1"]

                 ; HTTP:

                 [http-kit "2.2.0"]
                 [ring/ring-core "1.5.1"]
                 [ring/ring-devel "1.5.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring-webjars "0.1.1"]
                 [ring-middleware-format "0.7.2"]
                 [metosin/ring-http-response "0.8.2"]
                 [metosin/compojure-api "1.1.10"]
                 [metosin/ring-swagger-ui "2.2.8"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]

                 ; DB:

                 [org.clojure/java.jdbc "0.6.2-alpha3"]
                 [org.postgresql/postgresql "42.0.0"]
                 [hikari-cp "1.7.5"]
                 [com.layerware/hugsql "0.4.7"]
                 [org.flywaydb/flyway-core "4.1.2"]
                 [com.h2database/h2 "1.4.193" :scope "test"]

                 ;; Frontend:

                 [reagent "0.6.0"]
                 [cljs-http "0.1.42"]
                 [ring-webjars "0.1.1"]
                 [org.webjars/bootstrap "4.0.0-alpha.6-1"]
                 [org.webjars/font-awesome "4.7.0"]
                 [org.webjars/es5-shim "4.5.9"]
                 [binaryage/devtools "0.9.2"]
                 [metosin/reagent-dev-tools "0.1.0"]]

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
