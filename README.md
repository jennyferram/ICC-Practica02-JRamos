ICC-Practica02-JRamos

Profesor: Salvador López Mendoza

Ayudante: Yanahí Demerio Torres

Ayudante de Laboratorio: Rosa Victoria Villa Padilla

@author Jennyfer Ramos Montes



// Descripción
Práctica 02 de ICC. Incluye dos programas: una clase para manejar fechas y otra que simula una inversión.

// Contenido

// `Fecha.java`
Clase que representa una fecha (día, mes y año). Permite:
- Crear fechas (con día/mes/año o con nombre del mes).
- Asignar y obtener día, mes y año.
- Calcular la diferencia en días entre dos fechas.
- Sumar o restar días a una fecha.
- Comparar fechas y saber si son iguales.
- Convertir entre nombre y número de mes.
- Calcular los días transcurridos en el año.
- Mostrar la fecha como texto (dd/mes/aaaa).
- Tiene en cuenta los años bisiestos.

// `TiempoDeInversion.java`
Programa con main que simula una inversión:
- Pide el nombre del inversionista y el monto a invertir.
- Pide la fecha de inicio y la fecha de fin.
- Calcula los días de la inversión y el rendimiento al 12%.
- Permite hacer varias simulaciones seguidas.
## Cómo compilar y ejecutar
Desde la carpeta `practica02/src/icc/`:
```bash
# Compilar los dos archivos
javac Fecha.java
javac TiempoDeInversion.java

# Ejecutar el programa
java TiempoDeInversion

