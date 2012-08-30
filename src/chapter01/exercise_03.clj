;; Implement add-squares

(ns chapter01.exercise_03)

(defn add-squares [numbers]
    (apply + (map * numbers numbers)))

