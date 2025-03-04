-- Write your MySQL query statement below

select customer_id
from (
    select customer_id,
    count(distinct product_key) counts
    from Customer c
    group by customer_id
) group_counts
where counts =  (
    select count(product_key) from Product
) 

-- SELECT customer_id
-- FROM Customer
-- GROUP BY customer_id
-- HAVING COUNT(DISTINCT product_key) = (
--     SELECT COUNT(product_key)
--     FROM Product
-- )
-- ORDER BY customer_id ASC