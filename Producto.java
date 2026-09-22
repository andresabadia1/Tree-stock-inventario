/**
 * Clase Producto (El Nodo del Árbol Binario de Búsqueda).
 * Contiene los datos del producto (id, nombre) y las referencias
 * a los nodos hijos izquierdo y derecho.
 */
public class Producto {
    // Atributos del producto
    private int id;
    private String nombre;

    // Punteros / Referencias a los nodos subárboles
    public Producto izquierdo;
    public Producto derecho;

    /**
     * Constructor para inicializar un nuevo producto (nodo).
     * @param id Identificador único del producto (clave del BST).
     * @param nombre Nombre del producto.
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("[ID: %-5d | Nombre: %s]", id, nombre);
    }
}
