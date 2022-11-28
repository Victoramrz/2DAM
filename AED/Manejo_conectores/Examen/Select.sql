SELECT nombre_emp, direccion_emp FROM empleados INNER JOIN oficinas ON empleados.cod_ofic = oficinas.cod_ofi Where cargo='Comercial' AND localidad='Telde' ORDER BY nombre_emp DESC
SELECT NOMBRE_OFI, COUNT(nombre_emp) FROM OFICINAS, empleados WHERE OFICINAS.COD_OFI = EMPLEADOS.COD_OFIC 
Select MAX(cargo), MIN(cargo) From Empleados,oficinas Where empleados.cod_ofic = oficinas.cod_ofi AND localidad='Telde'
