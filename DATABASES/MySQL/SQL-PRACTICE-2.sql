-- RESOURCES: https://www.w3resource.com/sql-exercises/sql-retrieve-from-table.php


/*
24. write a SQL query to find the details of 1970 Nobel Prize winners. Order the results by subject, ascending except for 'Chemistry' and ‘Economics’ which will come at the end of the result set. Return year, subject, winner, country, and category.
*/
SELECT *
FROM nobel_win
WHERE year=1970 
ORDER BY 
	CASE 
		WHEN subject IN ('Economics','Chemistry') THEN 1
        ELSE 0
	END ASC,
    subject,
    winner;

-- 26. query to calculate the average price for a manufacturer code of 16. 
SELECT AVG(pro_price) FROM item_mast 
  WHERE pro_com=16;

-- 10. Write a SQL query that displays order number, purchase amount, and the achieved and unachieved percentage (%) for those orders that exceed 50% of the target value of 6000.
-- link - https://www.w3resource.com/sql-exercises/sql-boolean-operator-exercise-10.php

SELECT ord_no,purch_amt, 
(100*purch_amt)/6000 AS "Achieved %", 
(100*(6000-purch_amt)/6000) AS "Unachieved %" 
FROM  orders 
WHERE (100*purch_amt)/6000>50;

-- 7. query to retrieve the details of the salespeople whose names begin with any letter between 'A' and 'L' (not inclusive). Return salesman_id, name, city, commission.
-- link : https://www.w3resource.com/sql-exercises/sql-wildcard-special-operator-exercise-7.php

SELECT *
FROM salesman
WHERE name BETWEEN 'A' and 'L';

-- 12. query to find those rows where col1 contains the escape character underscore ( _ )
-- https://docs.progress.com/bundle/datadirect-openaccess/page/topics/sqlref/escape-clause-in-like-operator.html
-- https://www.w3resource.com/sql-exercises/sql-wildcard-special-operator-exercise-12.php
SELECT *
FROM emp
WHERE name LIKE '%/_%' ESCAPE '/';

-- 14. From the following table, write a SQL query to find rows in which col1 contains the forward slash character ( / ).
-- https://www.w3resource.com/sql-exercises/sql-wildcard-special-operator-exercise-14.php
SELECT *
FROM testtable
WHERE col1 LIKE '%//%' ESCAPE '/';

-- 16. query to find those rows where col1 contains the string ( _/ ). 
-- https://www.w3resource.com/sql-exercises/sql-wildcard-special-operator-exercise-16.php

SELECT *
FROM testtable
WHERE col1 LIKE '%/_//%' ESCAPE '/';

-- 18. query to find those rows where col1 contains the character percent ( % ).
-- https://www.w3resource.com/sql-exercises/sql-wildcard-special-operator-exercise-18.php
SELECT *
FROM testtable
WHERE col1 LIKE '%/%%' ESCAPE'/';

-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-3.php
-- 3. query that counts the number of unique salespeople. Return number of salespeople.

SELECT count(DISTINCT salesman_id)
FROM orders;

-- 5. query to determine the number of customers who received at least one grade for their activity.
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-5.php
-- resource of "all in sql" : https://youtu.be/AB8w5tTrBjs

SELECT COUNT (ALL points)
FROM customers;

 
-- 8. query to find the highest grade of the customers in each city.
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-8.php

SELECT city,MAX(grade) 
FROM customer 
GROUP BY city;



-- 9. query to find the highest purchase amount ordered by each customer.
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-9.php

SELECT customer_id, MAX(purch_amt) 
FROM orders 
GROUP BY customer_id;

-- query to find the highest purchase amount ordered by each customer on a particular date.
-- 10. https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-10.php

SELECT customer_id,ord_date,MAX(purch_amt) 
FROM orders 
GROUP BY customer_id,ord_date;


/*
note: 
The difference between the having and where clause in SQL is that 
the where clause cannot be used with aggregates, but the having clause can.

*/
-- Do it 12
/*
 query to find the highest order (purchase) amount by each customer on a particular order date. Filter the result by highest order (purchase) amount above 2000.00. 
 https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-12.php
*/

-- NOTE: CHECK RESOURCE - https://youtu.be/iPEmGpI3OGU

SELECT customer_id, ord_date, MAX(purch_amt)
FROM orders 
WHERE purch_amt > 2000.00
GROUP BY customer_id, ord_date;

SELECT customer_id,ord_date,MAX(purch_amt) 
FROM orders 
GROUP BY customer_id,ord_date 
HAVING MAX(purch_amt)>2000.00;

-- 13. query to find the maximum order (purchase) amount in the range 2000 - 6000 (Begin and end values are included.) by combination of each customer and order date
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-13.php

SELECT customer_id, ord_date, MAX(purch_amt)
FROM orders
GROUP BY customer_id, ord_date
HAVING MAX (purch_amt) BETWEEN 2000 AND 6000;


-- 14.query to find the maximum order (purchase) amount based on the combination of each customer and order date. Filter the rows for maximum order (purchase) amount is either 2000, 3000, 5760, 6000.
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-14.php


SELECT customer_id, ord_date, MAX(purch_amt)
FROM orders
GROUP BY customer_id, ord_date
HAVING MAX (purch_amt) IN( 2000, 6000, 3000, 5760);


-- query to determine the maximum order amount for each customer. The customer ID should be in the range 3002 and 3007(Begin and end values are included.)
-- https://www.w3resource.com/sql-exercises/sql-aggregate-function-exercise-15.php

SELECT customer_id, MAX(purch_amt)
FROM orders
GROUP BY customer_id
HAVING customer_id BETWEEN 3002 AND 3007;

-- query to find the number of orders booked for each day. Return the result in a format like "For 2001-10-10 there are 15 orders".
-- https://www.w3resource.com/sql-exercises/sql-formatting-output-exercise-2.php
SELECT 'For ', ord_date, ',there are', count(ord_no),  'orders. '
FROM orders
GROUP BY ord_date;

-- query that calculates the maximum purchase amount generated by each salesperson for each order date. Sort the result-set by salesperson id and order date in ascending order.
-- https://www.w3resource.com/sql-exercises/sql-formatting-output-exercise-7.php
SELECT salesman_id,  ord_date, MAX(purch_amt)
FROM orders
GROUP BY salesman_id, ord_date
ORDER BY salesman_id, ord_date;


-- query to find all the customers. Sort the result-set in descending order on 3rd field.
-- https://www.w3resource.com/sql-exercises/sql-formatting-output-exercise-8.php
SELECT cust_name,city,grade 
FROM customer 
ORDER BY 3 DESC;

-- query that counts the unique orders and the highest purchase amount for each customer. Sort the result-set in descending order on 2nd field
-- https://www.w3resource.com/sql-exercises/sql-formatting-output-exercise-9.php
SELECT customer_id, COUNT(DISTINCT ord_no), MAX(purch_amt)
FROM orders
GROUP BY customer_id
ORDER BY 2 DESC;

-- query to calculate the summation of purchase amount, total commission (15% for all salespeople) by each order date. Sort the result-set on order date.
-- https://www.w3resource.com/sql-exercises/sql-formatting-output-exercise-10.php

SELECT ord_date, SUM(purch_amt), (SUM(purch_amt) * 0.15) AS commison
FROM orders
GROUP BY ord_date
ORDER BY ord_date;


-- query to find those salespeople who generated orders for their customers but are not located in the same city.
--https://www.w3resource.com/sql-exercises/sql-quering-on-multiple-table-exercise-3.php
SELECT od.ord_no, cs.cust_name, od.customer_id, od.salesman_id
FROM salesman sm,customer cs, orders od
WHERE cs.city <> sm.city
AND od.customer_id = cs.customer_id
AND sm.salesman_id = cs.salesman_id;

-- find those employees whose salaries are less than 6000. Return full name (first and last name), and salary.
-- https://www.w3resource.com/sql-exercises/sorting-and-filtering-hr/sql-sorting-and-filtering-hr-exercise-1.php

SELECT first_name ||' '||last_name AS Full_Name, salary
  FROM employees
    WHERE salary < 6000;
























































