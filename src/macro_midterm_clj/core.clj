(ns macro-midterm-clj.core)

(defn rand-num [start end]
  (+ start (rand-int (- end start))))

(defn mandatory-statement
   ([result]
      (println "-------------------------------")
      (println "Hit enter to see the result...")
      (println "-------------------------------")
      (read-line)
      (println "ANSWER : " result)
      (println)
      (println "-------------------------------"))
  ([result extra]
    (println "-------------------------------")
    (println "Hit enter to see the result...")
    (println "-------------------------------")
    (read-line)
    (println "ANSWER : " result "" extra)
    (println)
    (println "-------------------------------")))


(defn rand-small [] (rand-num 50 200))

(defn interest-rate []
  (let [old-price (rand-num 90 130)
        sell-price (rand-num 90 130)
        time (rand-num 1 3)
        result (double (- (/ old-price sell-price) time))]
    (println "If the U.S. Treasury issues a one year bond with a face (maturity) value
      of $" old-price " and sold it for $" sell-price ". What is the " time " year 
      interest rate for this bond? ")
    (mandatory-statement result)
  )  
)

(defn loaf-problems []
  (let [foo (hash-map :year 2013 :loaf-price (rand-num 3 10) :loaves (rand-num 170 250) :bag-price 1.5 :bags (rand-num 30 60))
        bar (hash-map :year 2014 :loaf-price (rand-num 3 10) :loaves (rand-num 170 250) :bag-price 1.6 :bags (rand-num 30 60))
        baz (hash-map :year 2015 :loaf-price (rand-num 3 10) :loaves (rand-num 170 250) :bag-price 1.7 :bags (rand-num 30 60))
        result-one (+ (* (bar :loaf-price) (bar :loaves)) (* (bar :bag-price) (bar :bags)))
        result-two (+ (* (foo :loaf-price) (bar :loaves)) (* (foo :bag-price) (bar :bags)))
        result-three (* (/ result-one result-two) 100)]
        (println foo)
        (println bar)
        (println baz)
        (println "What is the nominal GDP in 2014?")
        (mandatory-statement result-one)
        (println "Assuming the base year is 2013, what is real GDP in 2014?")
        (mandatory-statement result-two)
        (println "Assuming the base year is 2013, what is the GDP deflator in 2014?")
        (mandatory-statement result-three))
        (println "Remember GDP inflation is the GDP deflator of the current year minus
        that of the previous year divided by the previous year times 100"))

(defn asset-problems []
  (let [foo (hash-map :deposits (rand-num 100 500) :net-worth (rand-num 50 150))
        bar (hash-map :gov-sec (rand-num 70 150) :reserves (rand-num 30 60))
        loans (- (+ (foo :deposits) (foo :net-worth)) (+ (bar :gov-sec) (bar :reserves)))
        reserve-requirement (rand-num 4 8)
        excess-reserves (long (- (bar :reserves) (* (foo :deposits) (/ reserve-requirement 100))))
        withdrawal (rand-num 30 70)
        monetary-base (rand-num 1 5)
        last-result (double (/ (* reserve-requirement  (- (foo :deposits) withdrawal)) 100))
        final-result (double (* monetary-base (/ 1 (/ reserve-requirement 100))))]
        (println "Assets (Loans : ???, Gov't Securities : " (bar :gov-sec) " million , Reserves " (bar :reserves) " million)")
        (println "Liabilities + Net Worth (Deposits : " (foo :deposits) "million, Net Worth : " (foo :net-worth) " million)")
        (println "If the reserve requirement is " reserve-requirement "%, what is the amount
        of loans this bank has?")
        (mandatory-statement loans "million")
        (println "If the reserve requirement is " reserve-requirement "%, what is the amount
          of excess reserves this bank holds?")
        (mandatory-statement excess-reserves "million")
        (println "Suppose one of the bank’s customers withdraws $" withdrawal  " million. If the bank did not wish to borrow to meet
        its reserve requirement (such as through the federal funds market), how much would the bank have to
        sell in government securities in order to exactly meet the reserve requirement?")
        (mandatory-statement last-result "million")
        (println "If the reserve requirement is " reserve-requirement "% and the monetary base is $" monetary-base " billion, what is the maximum money supply
        for the economy?")
        (mandatory-statement final-result "billion")))







(defn -main
  "I don't do a whole lot."
  [& args]
  (interest-rate)
  (loaf-problems)
  (asset-problems))

