(ns org.rssys.libtemplate-test
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [clojure.spec.alpha :as s]
    [clojure.test :refer [deftest testing is]]
    [org.corfield.new]
    [org.rssys.libtemplate]))


(deftest valid-template-test
  (testing "template.edn is valid."
    (let [template (edn/read-string (slurp (io/resource "org/rssys/libtemplate/template.edn")))]
      (is (s/valid? :org.corfield.new/template template)
        (s/explain-str :org.corfield.new/template template)))))
