public class Cola<T> {
    private T[] cola;
    private int inicio;
    private int fin;
    private int max;

    public Cola(int tamaño) {
        this.max = tamaño;
        cola = (T[]) new Object[max];
        inicio = 0;
        fin = 0;
    }

    // Insertar dato por detras
    public void insertarDato(T dato) {
        if (fin < max) {
            cola[fin] = dato;
            fin++;
            if (fin == 1) {
                inicio = 1; // sigue tu pseudocódigo
            }
        } else {
            System.out.println("Desbordamiento: la cola está llena");
        }
    }

    // Eliminar dato por delante
    public T eliminarDato() {
        if (inicio != 0) {
            T dato = cola[inicio - 1]; // ajustar índice porque Java empieza en 0
            if (inicio == fin) {
                inicio = 0;
                fin = 0;
            } else {
                inicio++;
            }
            return dato;
        } else {
            System.out.println("Subdesbordamiento: la cola está vacía");
            return null;
        }
    }

    public boolean estaVacia() {
        return inicio == 0;
    }

    public boolean estaLlena() {
        return fin == max;
    }

    public int size() {
        if (inicio == 0) return 0;
        return fin - inicio + 1;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
        } else {
            System.out.print("Cola: ");
            for (int i = inicio - 1; i < fin; i++) {
                System.out.print(cola[i] + " ");
            }
            System.out.println();
        }
    }
}
