(ns {{top/ns}}.{{main/ns}}-test
  (:require [clojure.test :refer [deftest testing is]]
    [matcho.core :refer [match]]
    [{{top/ns}}.{{main/ns}} :as sut]))

(deftest ^:unit a-test
  (testing "simple test."
    (is (= 1 1))
    (match {:a 1} {:a int?})
    (match (sut/foo) nil)))
