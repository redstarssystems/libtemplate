(ns org.rssys.libtemplate
  (:require
    [clojure.pprint :as pprint]))


(defn data-fn
  "Example data-fn handler.
  Result is merged onto existing options data."
  [data]
  ;; returning nil means no changes to options data
  data
  nil)


(defn template-fn
  "Example template-fn handler.
  Result is used as the EDN for the template."
  [edn data]
  ;; must return the whole EDN hash map
  (println "\nCreate new project with the following settings" \newline)
  (pprint/pprint data)
  (println)
  edn)
