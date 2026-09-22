/**
 * Clase ArbolInventario (La Lógica del Árbol Binario de Búsqueda).
 * Contiene los métodos recursivos para insertar, realizar el recorrido inorden
 * y buscar productos por ID.
 */
public class ArbolInventario {

    // Referencia a la raíz del árbol
    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // ------------------------------------------------------------
    // INSERTAR
    // ------------------------------------------------------------

    /**
     * Inserta un nuevo producto en el árbol.
     * @param id Identificador único del producto (clave del BST).
     * @param nombre Nombre del producto.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto nodoActual, int id, String nombre) {
        // Caso base: llegamos a un espacio vacío, aquí va el nuevo nodo
        if (nodoActual == null) {
            return new Producto(id, nombre);
        }

        // Decide si ir a la izquierda o a la derecha según el id
        if (id < nodoActual.getId()) {
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, id, nombre);
        } else if (id > nodoActual.getId()) {
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, id, nombre);
        } else {
            // IDs duplicados: no se permite, se informa por consola
            System.out.println("Aviso: ya existe un producto con ID " + id + ". No se insertó.");
        }

        return nodoActual;
    }

    // ------------------------------------------------------------
    // BUSCAR POR ID
    // ------------------------------------------------------------

    /**
     * Busca un producto por su ID.
     * @param id ID a buscar.
     * @return El Producto encontrado o null si no existe.
     */
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto nodoActual, int id) {
        if (nodoActual == null) {
            return null; // No se encontró
        }

        if (id == nodoActual.getId()) {
            return nodoActual; // Encontrado
        } else if (id < nodoActual.getId()) {
            return buscarRecursivo(nodoActual.izquierdo, id);
        } else {
            return buscarRecursivo(nodoActual.derecho, id);
        }
    }

    // ------------------------------------------------------------
    // RECORRIDO INORDEN (imprime en orden ascendente de ID)
    // ------------------------------------------------------------

    public void mostrarInorden() {
        System.out.println("--- Inventario (ordenado por ID) ---");
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto nodoActual) {
        if (nodoActual != null) {
            inordenRecursivo(nodoActual.izquierdo);
            System.out.println(nodoActual);
            inordenRecursivo(nodoActual.derecho);
        }
    }
}
