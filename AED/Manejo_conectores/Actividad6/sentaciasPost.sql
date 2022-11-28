SELECT "Nombre_prov", "Nombre_prod", "Precio" FROM product INNER JOIN proovedor ON "Code_prov" = "Cod_prov" Where "Precio" > 2000 ORDER BY "Precio"
SELECT "Nombre_prov", "Telefono" FROM product,proovedor Where "Code_prov" = "Cod_prov" AND "Nombre_prod"='Ordenador'
SELECT "Nombre_prod", "Stock" FROM product,proovedor Where "Code_prov" = "Cod_prov" AND "Stock"<20 ORDER BY "Stock"
SELECT "Nombre_prod", ("Precio"*0.95) FROM proovedor INNER JOIN product ON "Code_prov" = "Cod_prov" WHERE "Bonifica" = 0
SELECT "Nombre_prov", COUNT("Cod_prov") AS Num_Products, ROUND(AVG("Precio")) AS Media FROM product INNER JOIN proovedor ON "Code_prov" = "Cod_prov" GROUP BY "Nombre_prov"
SELECT "Nombre_prov", "Direccion", "Telefono" FROM product,proovedor Where "Code_prov" = "Cod_prov" AND "Stock"=(SELECT MAX("Stock") FROM product)