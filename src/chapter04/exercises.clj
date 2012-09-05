(ns chapter04.exercises)

(def a
  (fn [type & params]
    (apply type params)))

(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))

(def Point
  (fn [x y]
    {;; initializing instance variables
     :x x
     :y y
     
     ;; Metadata
     :__class_symbol__ 'Point
     :__methods__ {
         :x :x
         :y :y
         :class :__class_symbol__
         :shift (fn [this xinc yinc]
                   (a Point (+ (send-to this :x) xinc)
                            (+ (send-to this :y) yinc)))
         :add (fn [this other]
                (send-to this :shift (send-to other :x)
                                     (send-to other :y) ))
                  }
     }))

(def my-point (a Point 1 2))
(prn (send-to my-point :x))
(prn (send-to my-point :y))
(prn (send-to my-point :shift -1 -100))
(prn (send-to my-point :add (a Point -1 -100)))