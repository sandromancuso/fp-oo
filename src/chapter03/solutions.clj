(ns chapter03.solutions
  (:use chapter03.add_and_a))

(def add-points
  (fn [point1 point2]
    (Point (+ (:x point1) (:x point2)) 
         (+ (:y point1) (:y point2)))))

(def add-points-using-shift
  (fn [point1 point2]
    (shift point1 (:x point2) (:y point2))))


