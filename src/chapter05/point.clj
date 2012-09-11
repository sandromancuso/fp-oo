(ns chapter05.point)

(def a
  (fn [class & args]
    (let [allocated {}
          seeded (assoc allocated
                             :__class_symbol__ (:__own_symbol__ class))
          constructor (:add-instance-values (:__instance_methods__ class))]
      (apply constructor seeded args))))

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

(def send-to
  (fn [instance message & args]
    (let [class (eval (:__class_symbol__ instance))
          method (message (:__instance_methods__ class))]
      (apply method instance args))))