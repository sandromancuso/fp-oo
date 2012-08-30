;; Check if the first sequence is the prefix of the second 
;; sequence

(ns chapter01.exercise_06)

(defn prefix-of? [candidate sequence]
  (= candidate (take (count candidate) sequence)))