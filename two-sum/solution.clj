(ns two-sum
  (:require [clojure.test :refer :all]))

;; comment: any problems that involve returning index seems to not ideal for functional

;; simplest
(defn first-equal
  [nums target]
  (first (remove nil? (map-indexed (fn [idx x]
                                     (when (= target x)
                                      idx))
                                   nums))))
(defn solution
  [nums target]
  (first (remove nil? (map-indexed (fn [idx x]
                                     (when-let [second-idx (first-equal (drop (inc idx) nums) (- target x))]
                                       [idx (+ (inc idx) second-idx)]))
                                   nums))))


(deftest test-cases
  (is (= [0 1]
         (solution [2 7 11 15] 9)))

  (is (= [1 2]
         (solution [3 2 4] 6)))

  (is (= [0 1]
         (solution [3 3] 6))))
