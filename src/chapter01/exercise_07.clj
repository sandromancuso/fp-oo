;; Returns a sequence of successively smaller subsequences of the argument

(ns chapter01.exercise_07)

(def tails
     (fn [sequence]
       (map drop
            (range (inc (count sequence)))
            (repeat (inc (count sequence)) sequence))))
