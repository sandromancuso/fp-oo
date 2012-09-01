(ns chapter03.solutions
  (:use chapter03.add_and_a))

;; Exercise one

(def add-points
  (fn [point1 point2]
    (Point (+ (:x point1) (:x point2)) 
         (+ (:y point1) (:y point2)))))

(def add-points-using-shift
  (fn [point1 point2]
    (shift point1 (:x point2) (:y point2))))

;; Exercise two

(def a
  (fn [type & params]
    (apply type params)))

(prn (a Triangle (a Point 1 2)
                 (a Point 1 3)
                 (a Point 3 1)))

;; Exercise three

(def equal-triangles? =)

(equal-triangles? right-triangle right-triangle)
(equal-triangles? right-triangle equal-right-triangle)
(equal-triangles? right-triangle different-triangle)

;; Exercise four
;; Previous definition already works since '=' function takes one or more args

;; Exercise five

(def valid-triangle? 
  (fn [point1 point2 point3]
    (= 3 
       (count (distinct (list point1 point2 point3))) 
       )))

(valid-triangle? (Point 1 2) (Point 3 4) (Point 5 6)) ;; true
(valid-triangle? (Point 1 2) (Point 3 4) (Point 3 4)) ;; false
(valid-triangle? (Point 5 6) (Point 3 4) (Point 5 6)) ;; false
(valid-triangle? (Point 1 2) (Point 1 2) (Point 5 6)) ;; false