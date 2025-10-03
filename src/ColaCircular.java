public class ColaCircular<T> {
    private T[] datos;
    private int frente;
    private int fin;
    private int tamaño;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.datos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    public boolean push(T elemento) {
        if (isFull()) {
            return false;
        }
        fin = (fin + 1) % capacidad;
        datos[fin] = elemento;
        tamaño++;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T elemento = datos[frente];
        datos[frente] = null;
        frente = (frente + 1) % capacidad;
        tamaño--;
        return elemento;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return datos[frente];
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public boolean isFull() {
        return tamaño == capacidad;
    }

    public int size() {
        return tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }
}