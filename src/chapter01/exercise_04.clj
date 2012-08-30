;; Using range and apply, implement a bizarre version of 
;; factorial that uses neither iteration nor recursion

(ns chapter01.exercise_04)

(defn factorialOf [number]
  (apply * (range 1 (+ number 1))))

