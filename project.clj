(defproject setup-test "0.1.0-SNAPSHOT"

  :description "Test training setup, depends on half of the internet just to populate your local .m2 caches"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]

                 ;; Tooling:

                 [org.clojure/tools.namespace "0.3.0-alpha3"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.reader "1.0.0-beta3"]

                 ;; Common:

                 [org.clojure/core.async "0.2.391"]
                 [prismatic/schema "1.1.3"]
                 [prismatic/plumbing "0.5.3"]
                 [metosin/potpuri "0.3.0"]

                 ;; Backend:

                 [mount "0.1.10"]
                 [metosin/schema-tools "0.10.0-20160425.120043-1"]
                 [metosin/compojure-api "1.1.8"]
                 [metosin/ring-swagger-ui "2.2.2-0"]
                 [metosin/lokit "0.1.0"]
                 [clj-http "3.2.0"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]

                 ; HTTP:

                 [http-kit "2.2.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-devel "1.5.0"]
                 [ring-webjars "0.1.1"]
                 [ring-middleware-format "0.7.0"]
                 [metosin/ring-http-response "0.8.0"]
                 [com.cognitect/transit-clj "0.8.288"]

                 ; DB:

                 [org.clojure/java.jdbc "0.6.2-alpha3"]
                 [org.postgresql/postgresql "9.4.1210.jre7"]
                 [hikari-cp "1.7.3"]
                 [com.layerware/hugsql "0.4.7"]
                 [org.flywaydb/flyway-core "4.0.3"]
                 [com.h2database/h2 "1.4.192" :scope "test"]

                 ;; Frontend:

                 [reagent "0.6.0-rc"]
                 [cljs-http "0.1.41"]
                 [ring-webjars "0.1.1"]
                 [org.webjars/bootstrap "4.0.0-alpha.3"]
                 [org.webjars/font-awesome "4.6.3"]
                 [org.webjars/es5-shim "4.5.9"]
                 [binaryage/devtools "0.8.1"]
                 [metosin/reagent-dev-tools "0.1.0"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-ring "0.9.3"]]

  :source-paths ["src/clj"]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/setup.js"
                                   :optimizations :whitespace}}]}

  :repl-options {:init-ns setup.server}
  :ring {:handler setup.server/app}

  :min-lein-version "2.5.3"

  :aliases {"welcome" [["do" "clean" ["cljsbuild" "once"] ["ring" "server"]]]})
