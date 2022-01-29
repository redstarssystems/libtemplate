(ns build
  (:refer-clojure :exclude [test])
  (:require [clojure.tools.build.api :as b]                 ;; for b/git-count-revs
            [org.corfield.build :as bb]
            [clojure.pprint :as pprint]))

(def lib '{{group/id}}/{{artifact/id}})
(def version "{{version}}") ;; alternatively, use MAJOR.MINOR.COMMITS:
;;(def version (format "1.0.%s" (b/git-count-revs nil)))

(defn jar
  "Build the JAR."
  [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/jar)))

(defn install
  "Install the JAR locally."
  [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/install)))

(defn deploy
  "Deploy the JAR to Clojars."
  [opts]
  (-> opts
      (assoc :lib lib :version version)
      (bb/deploy)))
