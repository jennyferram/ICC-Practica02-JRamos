import java.util.Scanner;
/**Este programa simula una inversión.Pide al usuario sus datos. Calcula los
 * dias de inversión y su rendimiento al 12%.
 * Usamos la clase Fecha en este programa.
 * 
 * @author Jennyfer Ramos Montes
 * @version 1.0
 */
public class TiempoDeInversion{

    /**
     * Creación del metodo main
     */
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenid@");
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.nextLine();


        String respuesta = "si";

        while(respuesta.equals("si")){
            System.out.println("Hola "+nombre + ". ¿Cúanto deseas invertir? ");
            double monto = entrada.nextDouble();

            entrada.nextLine();
            
            System.out.println("Ingresa la fecha de inicio de la inversión");
            System.out.println("Día: ");
            int diaInicial = entrada.nextInt();
            System.out.println("Mes: ");
            int mesInicial = entrada.nextInt();
            System.out.println("Año: ");
            int anioInicial = entrada.nextInt();
            entrada.nextLine();
            Fecha inicio = new Fecha(diaInicial, mesInicial, anioInicial);

            System.out.println("Ingresa la fecha de fin de la inversión");
            System.out.println("Día: ");
            int diaFin = entrada.nextInt();
            System.out.println("Mes: ");
            int mesFin = entrada.nextInt();
            System.out.println("Año; ");
            int anioFin = entrada.nextInt();
            entrada.nextLine();
            Fecha fin = new Fecha(diaFin,mesFin,anioFin);

            int dias = inicio.diferencia(fin);
            double rendimiento = monto * 0.12 * (dias / 365.0);
            System.out.println("Tu inversión duraría " + dias + " días.");
            System.out.println("Tu rendimiento al 12% sería: " + rendimiento);

            System.out.println("¿Deseas hacer otra simulación? (si/no)");
            respuesta = entrada.nextLine();

        }

        }
        
    }
