SELECT nombre_prod, nombre_prov, precio FROM product INNER JOIN proovedor ON proovedor.cod_prov = product.code_prov WHERE precio > 2000 ORDER BY precio DESC
SELECT nombre_prov, telefono FROM proovedor INNER JOIN product ON proovedor.cod_prov = product.code_prov WHERE nombre_prod LIKE '%Ordenador%'
SELECT nombre_prod FROM product WHERE stock < 20
SELECT cod_prod, nombre_prod, precio * 0.95 AS precio_rebajado FROM product INNER JOIN proovedor ON proovedor.cod_prov = product.code_prov WHERE bonifica = 0
SELECT nombre_prov, SUM (stock), AVG (precio) FROM product INNER JOIN proovedor ON proovedor.cod_prov = product.code_prov GROUP BY (nombre_prov)
SELECT nombre_prov, direccion, telefono, stock FROM proovedor INNER JOIN product ON proovedor.cod_prov = product.code_prov WHERE stock = (SELECT MAX(stock) FROM product)
