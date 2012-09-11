(ns chapter05.exercises)


(def a
  (fn [class & args]
    (let [seeded {:__class_symbol__ (:__own_symbol__ class)}
          constructor (:add-instance-values (:__instance_methods__ class))]
      (apply constructor seeded args))))

(def send-to
  (fn [instance message & args]
    (let [class (eval (:__class_symbol__ instance))
          method (message (:__instance_methods__ class))]
      (apply method instance args))))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__ 
     {
       :add-instance-values (fn [this x y]            
                              (assoc this :x x :y y)) 
           
       :class :__class_symbol__
       :shift (fn [this xinc yinc]
                       (a Point (+ (:x this) xinc
                                (+ (:y this) yinc)))) 
                         }
   })

(def my-point (a Point 1 2))
;; (prn (send-to my-point :x))
;; (prn (send-to my-point :y))
(prn (send-to my-point :shift [-1 -100]))
;; (prn (send-to my-point :add-instance-values 2 2))