(ns chapter04.point)

(def a
  (fn [type & params]
    (apply type params)))

(def Point
  (fn [x y]
    {;; initializing instance variables
     :x x
     :y y
     
     ;; Metadata
     :__class_symbol__ 'Point
     :__methods__ {
         :class :__class_symbol__
         :shift
             (fn [this xinc yinc]
               (a Point (+ (:x this) xinc)
                        (+ (:y this) yinc)))
                  }
     }))

(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))