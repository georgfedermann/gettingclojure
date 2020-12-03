(ns prime.core
  (:gen-class))

(def books ["War and Peace", "The secret garden", "1984", "Fahrenheit 451"])
(def book {:title "War and Peace" :author "Leo Tolstoy" :published 1869})

;; call-threading: enhance this using call-threading
(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))
;; call-threading applied
(defn transform-thread [person]
  (-> person
    (assoc :hair-color :gray)
    (update :age inc)))

;; syntactical sugar: map keys to arg variables
(defn print-book [{:keys [author title]}] (println "Book" title "authored by" author))

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
