public class Caja {
    private boolean estadoUso;
    private boolean estadoDeApertura;
    private double tiempoDeApertura;
    private double tiempoFinal;
    private double tiempoEnUso;
    private Cliente cliente;
    private ColaCircular<Cliente> filaCaja;
    private int atendidos;

    public static final boolean ABIERTO = true;
    public static final boolean CERRADO = false;
    public static final boolean OCUPADO = true;
    public static final boolean VACIO = false;

    public Caja() {
        this.estadoDeApertura = CERRADO;
        this.estadoUso = VACIO;
        this.atendidos = 0;
        this.tiempoDeApertura = -1;
        this.tiempoEnUso = 0;
    }

    public void setEstadoDeApertura(boolean estado) {
        this.estadoDeApertura = estado;
    }

    public boolean getEstadoDeApertura() {
        return this.estadoDeApertura;
    }

    public void setEstadoUso(boolean estadoUso) {
        this.estadoUso = estadoUso;
    }

    public boolean getEstadoUso() {
        return this.estadoUso;
    }

    public boolean isOcupado() {
        return estadoUso;
    }

    public boolean isEmpty() {
        return !estadoUso;
    }

    public void setTiempoDeApertura(double tiempoDeApertura) {
        this.tiempoDeApertura = tiempoDeApertura;
    }

    public double getTiempoDeApertura() {
        return this.tiempoDeApertura;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void cerrarCaja(double tiempoActual) {
        if (this.estadoDeApertura == ABIERTO && this.tiempoDeApertura >= 0) {
            this.tiempoEnUso += (tiempoActual - this.tiempoDeApertura);
        }
        this.tiempoFinal = tiempoActual;
        this.estadoDeApertura = CERRADO;
    }

    public int getAtendidos() {
        return atendidos;
    }

    public void aumentarAtendidos() {
        this.atendidos++;
    }

    public void setFilaCaja(ColaCircular<Cliente> filaCaja) {
        this.filaCaja = filaCaja;
    }

    public ColaCircular<Cliente> getFilaCaja() {
        return filaCaja;
    }

    public void setTiempoFinal(double tiempoFinal) {
        if (this.estadoDeApertura == ABIERTO && this.tiempoDeApertura >= 0) {
            this.tiempoEnUso += (tiempoFinal - this.tiempoDeApertura);
        }
        this.tiempoFinal = tiempoFinal;
    }

    public double getTiempoEnUso() {
        return this.tiempoEnUso;
    }

    public double getTiempoEnUsoActual(double tiempoActual) {
        double tiempoTotal = this.tiempoEnUso;
        if (this.estadoDeApertura == ABIERTO && this.tiempoDeApertura >= 0) {
            tiempoTotal += (tiempoActual - this.tiempoDeApertura);
        }
        return tiempoTotal;
    }
}