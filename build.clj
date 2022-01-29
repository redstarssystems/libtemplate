(ns build
  (:refer-clojure :exclude [test])
  (:require
    [clojure.tools.build.api :as b]
    ;; for b/git-count-revs
    [org.corfield.build :as bb]))


(def lib 'org.rssys/libtemplate)
(def version "0.1.0-SNAPSHOT")
;; (def version (format "1.0.%s" (b/git-count-revs nil))) ;; alternatively, use MAJOR.MINOR.COMMITS:


(defn test
  "Run the tests."
  [opts]
  (bb/run-tests opts))
