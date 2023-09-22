SHOW DATABASES;

USE sql_store;

-- ### 	 SELECT CLAUSE	###
SELECT *
FROM customers
-- WHERE customer_id = 1
ORDER BY first_name;

-- PERFORM ARITHMETIC OPERATION AND GIVE THE COLUMN NAME
SELECT 
	first_name,
    points,
    (points + 10) * 23 as 'discount given'
FROM customers;

-- CHOOSE UNIQUE STATE
SELECT DISTINCT state FROM customers;

-- EXERCISE
SELECT
	name,
    unit_price as 'unit price',
    (unit_price * 1.1) as 'new price'
FROM products;

-- ### 	 WHERE CLAUSE	###

SELECT *
FROM customers
WHERE state = 'va';

-- Note: != , <> both are same [ not equal sign ]
SELECT *
FROM customers
WHERE state <> 'va';

SELECT *
FROM customers
WHERE birth_date > '1990-01-01';

SELECT *
FROM orders
WHERE order_date > '2019-01-01';

SELECT *
FROM customers
WHERE birth_date > '1990-01-01'
AND points > 1000;

SELECT *
FROM customers
WHERE birth_date > '1990-01-01' 
OR (points > 1000 AND state = 'VA');

SELECT *
FROM customers
WHERE NOT (birth_date > '1990-01-01' OR points > 1000);

-- EXERCISE

SELECT *
FROM order_items
WHERE order_id = 6 AND (unit_price * quantity > 30);



-- ### 	IN Operator 	###
SELECT *
FROM customers
WHERE state = 'VA' OR state = 'GA' OR state = 'FL';

-- below is same as above 
-- note: in In operator, order doesn't matter
SELECT *
FROM customers
WHERE state IN ('VA', 'GA', 'FL');

-- Exercise
SELECT *
FROM products
WHERE quantity_in_stock IN (49, 38, 72);


-- ### 	 BETWEEN Operator	### 
SELECT *
FROM customers
WHERE points >= 1000 AND points <= 3000;
-- below is same as above 

SELECT *
FROM customers
WHERE points BETWEEN 1000 AND 3000;

-- Exercise
SELECT * 
FROM customers
WHERE birth_date BETWEEN '1990-01-01' AND '2000-01-01';

-- ### 	LIKE OPERATOR 	###
-- patterns like : 'b%', '%b', '%b%', '%y', '_y'
-- '_____y'
-- note: [ % represents any no. of characters
-- note: [ _ represents any no. of characters]

SELECT * 
FROM customers
WHERE last_name LIKE '_____y';


-- EXERCISE

SELECT * 
FROM customers
WHERE phone 
LIKE '%9';


SELECT * 
FROM customers
WHERE address 
LIKE '%TRAIL%' 
OR address LIKE '%AVENUE%';

-- ### 	 REGEXP [regular expression] OPERATOR	###
SELECT *
FROM customers
WHERE last_name REGEXP 'field';
-- below code is same as this
SELECT * 
FROM customers
WHERE last_name 
LIKE '%field%';

-- note: ^ <- this sign is used to start string at the begining
-- note: $ <- this sign is used to end string at the end
-- note: | <- this sign (logical or) is used to find both string at any pos of the cols
-- note: [] <- this sign is used to put the letter before or after any letter matches.
-- note: [a-d] <- this sign is used to find a range. [here between a to d]
SELECT *
FROM customers
WHERE last_name REGEXP '^Na';

SELECT *
FROM customers
WHERE last_name REGEXP 'field$';

SELECT *
FROM customers
WHERE last_name REGEXP 'fiel%|mac|rose';


SELECT *
FROM customers
WHERE last_name REGEXP 'e[l]';

SELECT *
FROM customers
WHERE last_name REGEXP '[a-l]e';


-- EXERCISE

SELECT *
FROM customers
WHERE first_name REGEXP 'ELKA|AMBUR';

SELECT *
FROM customers
WHERE last_name REGEXP 'EY$|ON$';

SELECT *
FROM customers
WHERE last_name REGEXP '^MY|SE';

SELECT *
FROM customers
WHERE last_name REGEXP 'B[RU]';

-- ### 	 IS NULL Operator	###
SELECT *
FROM customers
WHERE phone IS NULL;

-- EXERCISE

SELECT *
FROM orders
WHERE shipped_date IS NULL;

-- ### 	 ORDER BY CLAUSE	###

SELECT *
FROM customers
ORDER BY state, first_name;

-- don't use 1 or 2 like below

SELECT first_name, last_name, 10 AS points
FROM customers
ORDER BY 1, 2;

-- always use columns name
SELECT first_name, last_name, 10 AS points
FROM customers
ORDER BY first_name, last_name;


-- EXERCISE
SELECT *,  (quantity * unit_price) AS total_price
FROM order_items
WHERE order_id = 2
ORDER BY total_price DESC;

-- ### 	 LIMIT clause	###

SELECT *
FROM customers
LIMIT 6, 3; -- LIMIT X, Y SAYS THAT SKIP FIRST X RECORD AND print after three records

-- EXERCISE
-- note: LIMIT clause always come at the end
SELECT *
FROM customers
ORDER BY points DESC
LIMIT 3;


-- ### 	 INNER JOINS	###
-- In SQL, you can write either INNER JOIN or JOIN

SELECT o.order_id, c.customer_id, first_name, last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id;

-- EXERCISE

SELECT order_id, p.product_id, name, 
quantity, o.unit_price
FROM products p
INNER JOIN order_items o 
ON o.product_id = p.product_id;

-- ### 	 JOINING ACROSS DATABASES	###

-- note: if you currently using any databases, you can use
-- directly it's column instead of database_name.column
-- if not use database_name.column

SELECT order_id, p.product_id, name, 
quantity, o.unit_price
FROM sql_inventory.products p
INNER JOIN sql_store.order_items o 
ON o.product_id = p.product_id;


-- ### 	 Self Joins	###

SELECT e.employee_id, 
e.first_name AS 'employee first name',
m.first_name AS 'manager first name'
FROM employees e
JOIN employees m
ON e.reports_to = m.employee_id;


-- ### 	 JOIN MULTIPLE TABLES	###

SELECT o.order_id, o.order_date,
c.first_name, c.last_name, os.name AS status
FROM orders o
JOIN customers c
	ON o.customer_id = c.customer_id
JOIN order_statuses os
	ON o.status = os.order_status_id;

-- below code is same as above
SELECT o.order_id, o.order_date,
c.first_name, c.last_name, os.name
FROM orders o, customers c, order_statuses os
WHERE os.order_status_id = o.status
AND c.customer_id = o.customer_id
ORDER BY order_id ASC;

-- EXERCISE

SELECT p.date, p.invoice_id,
p.amount, c.name, pm.name AS 'payment method'
FROM payments p
JOIN clients c
	ON c.client_id = p.client_id
JOIN payment_methods pm
	ON p.payment_method = pm.payment_method_id;

-- ### 	 COMPOUND JOIN CONDITION	###

-- note: composite primary key means in a table, there are two columns that are primary keys of the table

SELECT *
FROM order_items oi
JOIN order_item_notes oin
	ON oi.order_id = oin.order_id
    AND oi.product_id = oin.product_id;

-- ### 	 IMPLICIT JOIN SYNTEX	###

SELECT *
FROM orders o
JOIN customers c
	ON o.customer_id = c.customer_id;
-- note: always write join using EXPLICIT JOIN SYNTEX


-- ### 	 OUTER JOIN	###
-- LEFT JOIN

SELECT 
	c.customer_id,
    c.first_name,
    o.order_id
FROM customers c
LEFT JOIN orders o
	ON c.customer_id = o.customer_id
    ORDER BY c.customer_id;


-- RIGHT JOIN

SELECT 
	c.customer_id,
    c.first_name,
    o.order_id
FROM customers c
RIGHT JOIN orders o
	ON c.customer_id = o.customer_id
    ORDER BY c.customer_id;

-- EXERCISE

SELECT p.product_id, p.name, oi.quantity
FROM products p
LEFT JOIN order_items oi
	ON p.product_id = oi.product_id;
    
-- ### 	 OUTER JOIN BETWEEN MULTIPLE TABLES	###

SELECT 
	c.customer_id,
    c.first_name,
    o.order_id,
    s.name AS shipper
FROM customers c
LEFT JOIN orders o
	ON c.customer_id = o.customer_id
LEFT JOIN shippers s
	ON o.shipper_id = s.shipper_id
ORDER BY c.customer_id;

-- EXERCISE

SELECT 
	o.order_date,
    o.order_id,
    c.first_name,
    s.name AS shipper,
    os.name AS status
FROM orders o
LEFT JOIN customers c
	ON c.customer_id = o.customer_id
LEFT JOIN shippers s
	ON o.shipper_id = s.shipper_id
LEFT JOIN order_statuses os
	ON o.status = os.order_status_id
ORDER BY status;


-- ### 	 SELF OUTER JOIN	###

SELECT 
	e.employee_id, 
	e.first_name AS 'employee first name',
	m.first_name AS 'manager first name'
FROM employees e
LEFT JOIN employees m
	ON e.reports_to = m.employee_id;



-- ### 	USING CLAUSE 	###
-- note: ON c.customer_id = o.customer_id is same as USING (customer_id)

SELECT 
	c.customer_id,
    c.first_name,
    o.order_id,
    s.name AS shipper
FROM orders o
LEFT JOIN customers c
	USING ( customer_id )
LEFT JOIN shippers s
	USING ( shipper_id )
ORDER BY shipper;

SELECT *
FROM order_items oi
JOIN order_item_notes oin
	USING (order_id, product_id);
	
-- note: ON oi.order_id = oin.order_id AND oi.product_id = oin.product_id; is same as USING (order_id, product_id)
    
-- EXERCISE

SELECT 
	p.date,
    c.name,
    p.amount,
    pm.name AS payment_method
FROM payments p
JOIN clients c
	USING (client_id)
JOIN payment_methods pm
	ON p.payment_method = pm.payment_method_id;

-- ### 	 NATURAL JOINS	###
-- we don't have to specify the condition, it'll automatically take it
-- note: it produces some times unexpected result
-- so don't use it always

SELECT 
	o.order_id,
    c.first_name
FROM orders o
NATURAL JOIN customers c;

-- ### 	 CROSS JOIN 	###
SELECT 
	c.first_name as customer,
	p.name as product
FROM customers c, products p
ORDER BY customer;

-- above code is same as this
SELECT 
	c.first_name as customer,
	p.name as product
FROM customers c
CROSS JOIN products p
ORDER BY customer;

-- EXERCISE

SELECT s.name AS shipper, p.name as product
FROM shippers s,products p;

-- above code is same as this
SELECT s.name AS shipper, p.name as product
FROM shippers s
CROSS JOIN products p;


-- ### 	 Unions	###
-- note: unions is used when two tables have same no. of cols.

SELECT order_id, order_date, 'active' AS status
FROM orders
WHERE order_date >= '2019-01-01'
UNION
SELECT order_id, order_date, 'archived' AS status
FROM orders
WHERE order_date < '2019-01-01';


-- combine two tables that have same no. of cols. below using union
-- note: name of the cols will be based on first use of table's col

SELECT first_name
FROM customers
UNION
SELECT name
FROM shippers;

-- combine two tables that don't have same no. of cols. error will occurred
-- below code will show error

SELECT first_name, last_name
FROM customers
UNION
SELECT name
FROM shippers;


-- EXERCISE

SELECT customer_id, first_name, points, 'Bronze' AS type
FROM customers
WHERE points < 2000
UNION
SELECT customer_id, first_name, points, 'Silver' AS type
FROM customers
WHERE points BETWEEN 2000 AND 3000
UNION
SELECT customer_id, first_name, points, 'Gold' AS type
FROM customers
WHERE points > 3000
ORDER BY first_name;

-- ### 	 COLUMN ATTRIBUTE	###

-- ### 	 INSERT RECORD	###
INSERT INTO customers
VALUES(
	default,
	'Dj',
    'Bravo',
    '1992-02-09',
    '312-480-8498',
    'California',
    'Los Ani',
    'DL',
    '92');
    
INSERT INTO shippers (name)
VALUES  ('Shipper1'),
		('Shipper2'),
        ('Shipper3');


-- ### 	 INSERTING HIERARCHICAL ROWS	###

INSERT INTO orders ( customer_id, order_date, status)
VALUES (1, '2019-02-08', 1);

INSERT INTO order_items
VALUES ( LAST_INSERT_ID(), 1, 1, 1 ),
	   ( LAST_INSERT_ID(), 2, 1, 1 );

-- ### 	 CREATING COPY OF FILES	###

CREATE TABLE orders_archived AS
SELECT * FROM orders;

INSERT INTO orders_archived
SELECT * FROM orders
WHERE order_date < '2019-01-01';

-- EXERCISE

CREATE TABLE invoices_archived AS
SELECT i.invoice_id, i.number, c.name as client,
	   i.invoice_total, i.payment_total,
       i.invoice_date, i.due_date, i.payment_date
FROM invoices i 
JOIN  clients c
	USING (client_id)
WHERE payment_date IS NOT NULL;

-- ### 	 UPDATE A SINGLE ROW	###

UPDATE invoices
SET payment_total = 50, payment_date = '2018-11-12'
WHERE invoice_id = 1;

UPDATE invoices
SET 
	payment_total = invoice_total * 0.5, 
	payment_date = due_date
WHERE invoice_id = 3;



-- ### 	 UPDATE MULTIPLE RECORDS	###

UPDATE invoices
SET 
	payment_total = invoice_total * 0.5, 
	payment_date = due_date
WHERE client_id IN(3,4);

-- EXERCISE

UPDATE customers
SET points = points + 50
WHERE birth_date < '1990-01-01';

-- ### 	 USING SUBQUERIES IN UPDATES	###

UPDATE invoices
SET 
	payment_total = invoice_total * 0.5, 
	payment_date = due_date
WHERE client_id =
		( SELECT client_id
          FROM clients
          WHERE name = 'Myworks');

UPDATE invoices
SET 
	payment_total = invoice_total * 0.5, 
	payment_date = due_date
WHERE client_id IN
		( SELECT client_id
          FROM clients
          WHERE state IN ('NY', 'CA'));
-- EXERCISE

UPDATE orders
SET comments = 'Gold Customers'
WHERE customer_id IN 
		(SELECT customer_id
         FROM customers
         WHERE points > 3000);


-- ### 	 DELETE ROWS	###

DELETE FROM invoices
WHERE client_id = (
	SELECT * 
	FROM clients 
	WHERE name = 'Myworks');

-- ### 	 	###


-- EXERCISE
