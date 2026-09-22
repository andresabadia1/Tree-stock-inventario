import java.util.Scanner;

/**
 * Clase Main (La Interfaz).
 * Menú interactivo por consola para gestionar el inventario "Tree-Stock"
 * usando un Árbol Binario de Búsqueda.
 */
public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== TREE-STOCK: Sistema de Inventario =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validamos que se ingrese un número
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un número de opción: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarProducto(scanner, inventario);
                    break;
                case 2:
                    inventario.mostrarInorden();
                    break;
                case 3:
                    buscarProducto(scanner, inventario);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Solicita al usuario el ID y nombre de un producto y lo inserta en el árbol.
     */
    private static void registrarProducto(Scanner scanner, ArbolInventario inventario) {
        System.out.print("Ingrese el ID del producto: ");
        while (!scanner.hasNextInt()) {
            System.out.print("ID inválido. Ingrese un número entero: ");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar el salto de línea pendiente

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        inventario.insertar(id, nombre);
        System.out.println("Producto registrado correctamente.");
    }

    /**
     * Solicita un ID al usuario y verifica si el producto existe en el árbol.
     */
    private static void buscarProducto(Scanner scanner, ArbolInventario inventario) {
        System.out.print("Ingrese el ID del producto a buscar: ");
        while (!scanner.hasNextInt()) {
            System.out.print("ID inválido. Ingrese un número entero: ");
            scanner.next();
        }
        int id = scanner.nextInt();

        Producto encontrado = inventario.buscar(id);
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("No existe un producto con ID " + id + ".");
        }
    }
}
