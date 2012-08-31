(ns chapter03.point)

(def Point 
  (fn [x y]
    {:x x
     :y y
     :__class_symbol__ 'Point}))

;;(def x 
;; (fn [this] (get this :x)))  >> verbose

;;(def x
;;  (fn [this] (:x this))      >> less verbose

(def x :x)  ;; >> much simpler. Keywords are callable
;; invoke like >> (x (Point 1 2)) -> Returns 1

(def class :__class_symbol__)
;; invoke like >> (class (Point 1 2)) -> Returns 'Point'

(def shift 
  (fn [this xinc yinc]
    (Point (+ (:x this) xinc)
           (+ (:y this) yinc))))

;; invoke like >> (shift (Point 1 200) -1 -200)