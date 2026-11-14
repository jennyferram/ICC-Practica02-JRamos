/**
 * Clase que representa una fecha (día, mes y año).
 * Permite crear fechas, modificarlas, compararlas, sumar/restar días,
 * calcular diferencias y mostrarlas como texto.
 * Tiene en cuenta los años bisiestos.
 *
 * @author Jennyfer Ramos Montes
 * @version 1.0
 */
public class Fecha {

    /**Atributos */

    private int dia;
    private int mes;
    private int anio;

    /**
     * Devuelve el día de la fecha.
     *
     * @return el día
     */
    public int obtenerDia() {
        return dia;
    }

    /**
     * Devuelve el mes de la fecha.
     *
     * @return el mes
     */
    public int obtenerMes() {
        return mes;
    }

    /**
     * Devuelve el año de la fecha.
     *
     * @return el año
     */
    public int obtenerAnio() {
        return anio;
    }


    /**
     * Indica si un año es bisiesto.
     *
     * @param a año a comprobar
     * @return true si el año es bisiesto, false en otro caso
     */
    private boolean esBisiesto(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    /**
     * Devuelve cuántos días tiene un mes en un año determinado.
     *
     * @param m  mes (1 a 12)
     * @param a  año
     * @return número de días del mes
     */
    private int diasDelMes(int m, int a) {
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        }
        if (m == 2) {
            if (esBisiesto(a)) {
                return 29;
            }
            return 28;
        }
        return 31;
    }

    /**
     * Asigna el día validando el mes y el año 
     *
     * @param d  nuevo día
     */
    public void asignarDia(int d) {
        if (d >= 1 && d <= diasDelMes(mes, anio)) {
            dia = d;
        } else {
            System.out.println("El día " + d + " no es válido para " + mes + "/" + anio);
        }
    }

    /**
     * Asigna el mes validando que esté entre 1 y 12.
     *
     * @param m nuevo mes
     */
    public void asignarMes(int m) {
        if (m >= 1 && m <= 12) {
            mes = m;
        } else {
            System.out.println("El mes " + m + " no es válido");
        }
    }

    /**
     * Asigna el año validando que sea positivo.
     *
     * @param a  nuevo año
     */
    public void asignarAnio(int a) {
        if (a > 0) {
            anio = a;
        } else {
            System.out.println("El año " + a + " no es válido");
        }
    }

    
    /**
     * Convierte el nombre de un mes en su número.
     *
     * @param nombre  nombre del mes
     * @return número del mes (1 a 12)
     */
    private int numeroDeMes(String nombre) {
        if (nombre.equals("enero"))      return 1;
        if (nombre.equals("febrero"))    return 2;
        if (nombre.equals("marzo"))      return 3;
        if (nombre.equals("abril"))      return 4;
        if (nombre.equals("mayo"))       return 5;
        if (nombre.equals("junio"))      return 6;
        if (nombre.equals("julio"))      return 7;
        if (nombre.equals("agosto"))     return 8;
        if (nombre.equals("septiembre")) return 9;
        if (nombre.equals("octubre"))    return 10;
        if (nombre.equals("noviembre"))  return 11;
        if (nombre.equals("diciembre"))  return 12;
        System.out.println("Mes no reconocido: " + nombre);
        return -1;
    }

    /**
     * Convierte el número de un mes en su nombre.
     *
     * @param m  número del mes
     * @return nombre del mes
     */
    private String nombreDeMes(int m) {
        if (m == 1)  return "enero";
        if (m == 2)  return "febrero";
        if (m == 3)  return "marzo";
        if (m == 4)  return "abril";
        if (m == 5)  return "mayo";
        if (m == 6)  return "junio";
        if (m == 7)  return "julio";
        if (m == 8)  return "agosto";
        if (m == 9)  return "septiembre";
        if (m == 10) return "octubre";
        if (m == 11) return "noviembre";
        return "diciembre";
    }


    /**
     * Constructor sin parametros
     */
    public Fecha() {
        this(30, 5, 1999);
    }

    /**
     * Constructor con día, mes y año.
     *
     * @param dia  día
     * @param mes  mes (1 a 12)
     * @param anio año (mayor que 0)
     */
    public Fecha(int dia, int mes, int anio) {
        //Valida cada uno
        asignarAnio(anio);
        asignarMes(mes);
        asignarDia(dia);
    }

    /**
     * Constructor con día, año y nombre del mes.
     *
     * @param dia día
     * @param anio año
     * @param nombreMes nombre del mes
     */
    public Fecha(int dia, int anio, String nombreMes) {
        this.dia = dia;
        this.anio = anio;
        this.mes = numeroDeMes(nombreMes);
    }

    /**
     * Constructor de copia.
     *
     * @param f  fecha que se va a copiar
     */
    public Fecha(Fecha f) {
        this(f.dia, f.mes, f.anio);
    }

    /**
     * Compara esta fecha con otra.
     *
     * @param f  fecha con la que se compara
     * @return negativo si esta es menor, 0 si son iguales,positivo si esta es mayor
     */
    public int comparar(Fecha f) {
        if (anio != f.anio) {
            return anio - f.anio;
        }
        if (mes != f.mes) {
            return mes - f.mes;
        }
        return dia - f.dia;
    }

    /**
     * Avanza esta fecha un día, ajustando mes y año si hace falta.
     */
    private void siguienteDia() {
        if (dia < diasDelMes(mes, anio)) {
            dia++;
        } else {
            dia = 1;
            if (mes < 12) {
                mes++;
            } else {
                mes = 1;
                anio++;
            }
        }
    }

    /**
     * Retrocede esta fecha un día, ajustando mes y año si hace falta.
     */
    private void diaAnterior() {
        if (dia > 1) {
            dia--;
        } else {
            if (mes > 1) {
                mes--;
            } else {
                mes = 12;
                anio--;
            }
            dia = diasDelMes(mes, anio);
        }
    }

    /**
     * Determina si dos fechas son iguales por su estado.
     *
     * @param o  objeto a comparar
     * @return true si representan la misma fecha
     */
    public boolean equals(Object o) {
        Fecha f = (Fecha) o;
        return dia == f.obtenerDia()
            && mes == f.obtenerMes()
            && anio == f.obtenerAnio();
    }


    /**
     * Calcula la diferencia en días entre esta fecha y otra.
     *
     * @param f  la otra fecha
     * @return número de días entre las dos fechas
     */
    public int diferencia(Fecha f) {
        Fecha menor;
        Fecha mayor;

        if (this.comparar(f) <= 0) {
            menor = new Fecha(this);
            mayor = f;
        } else {
            menor = new Fecha(f);
            mayor = this;
        }

        int contador = 0;
        while (!menor.equals(mayor)) {
            menor.siguienteDia();
            contador++;
        }
        return contador;
    }

    /**
     * Devuelve una fecha nueva desplazada n días.
     *
     * @param n  días
     * @return la fecha resultante
     */
    public Fecha sumarDias(int n) {
        Fecha resultado = new Fecha(this);

        if (n >= 0) {
            int i = 0;
            while (i < n) {
                resultado.siguienteDia();
                i++;
            }
        } else {
            int i = 0;
            while (i < -n) {
                resultado.diaAnterior();
                i++;
            }
        }
        return resultado;
    }

    /**
     * Devuelve los días transcurridos en el año hasta esta fecha.
     *
     * @return número de días transcurridos en el año
     */
    public int diasTranscurridos() {
        int total = 0;
        int m = 1;
        while (m < mes) {
            total += diasDelMes(m, anio);
            m++;
        }
        total += dia;
        return total;
    }

    /**
     * Devuelve la fecha en formato dd/mes/aaaa.
     *
     * @return la fecha como cadena de caracteres
     */
    public String toString() {
        return dia + "/" + nombreDeMes(mes) + "/" + anio;
    }
}
