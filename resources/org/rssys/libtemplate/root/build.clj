(ns build
  (:refer-clojure :exclude [test])
  (:require [org.corfield.build :as bb]
            [clojure.pprint :as pprint]))

(def artifact '{{group/id}}/{{artifact/id}})
(def version "{{version}}")
;; (format "1.0.%s" (System/getenv "git-rev-count"))

(def project-env {:artifact            artifact
                  :version             version
                  :build-time          (System/getenv "build-time")
                  :build-timestamp     (Long/parseLong (System/getenv "build-timestamp"))
                  :target-folder       (System/getenv "target-folder")
                  :release-branches    (System/getenv "release-branches")
                  :deployable-branches (System/getenv "deployable-branches")
                  :git-url             (System/getenv "git-url")
                  :git-branch          (System/getenv "git-branch")
                  :git-sha             (System/getenv "git-sha")
                  :git-rev-count       (System/getenv "git-rev-count")
                  :release?            (Boolean/parseBoolean (System/getenv "release?"))
                  :snapshot?           (Boolean/parseBoolean (System/getenv "snapshot?"))
                  :deployable?         (Boolean/parseBoolean (System/getenv "deployable?"))})

(println "Project settings:")
(clojure.pprint/pprint project-env)

(defn jar
  "Build the JAR."
  [opts]
  (-> opts
      (assoc :lib (:artifact project-env) :version (:version project-env))
      (bb/jar)))

(defn install
  "Install the JAR locally."
  [opts]
  (-> opts
      (assoc :lib (:artifact project-env) :version (:version project-env))
      (bb/install)))

(defn deploy
  "Deploy the JAR to Clojars."
  [opts]
  (-> opts
      (assoc :lib (:artifact project-env) :version (:version project-env))
      (bb/deploy)))
