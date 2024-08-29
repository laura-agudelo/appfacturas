import java.util.Scanner;
import com.nombreCompania.appfacturas.model.Cliente;
import com.nombreCompania.appfacturas.model.producto;
import com.nombreCompania.appfacturas.model.itemFactura;
import com.nombreCompania.appfacturas.model.factura;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Andrés", "5555-5");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        String desc = s.nextLine();
        factura factura = new factura(desc, cliente);

        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese nombre del producto nº " + (i + 1) + ": ");
            String nombre = s.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio = s.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            int cantidad = s.nextInt();
            s.nextLine(); // Consumir el salto de línea

            producto producto = new producto(nombre, precio);
            itemFactura item = new itemFactura(producto, cantidad);
            factura.addItemFactura(item);

            System.out.println();
        }
        System.out.println(factura);
    }
}

