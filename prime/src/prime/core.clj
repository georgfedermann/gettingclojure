(ns prime.core
  (:gen-class))

(def book {:title "War and Peace" :author "Leo Tolstoy" :published 1869})

;; flatten a sequence
(reduce (fn add-element [collection element]
  (if (sequential? element)
    (if (not-empty element)
      (if (sequential? (first element))
        (add-element collection (first element))
        (add-element (conj collection (first element)) (rest element)))
      collection)
    (conj collection element))) []   '((((:a))))     )
;; testdata:
;; '((1 2) 3 [4 [5 6]])
;; ["a" ["b"] "c"]
;; '((((:a))))

;; filter non-uppercase characters out of string
(fn [s] (apply str (filter #(Character/isUpperCase %) (seq s))))
#(apply str (re-seq #"[A-Z]" %))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
