public class Cliente {
    private int numeroCliente;
    private double tiempoLlegada;
    private double tiempoInicioPago;
    private double tiempoFinalPago;
    private double tiempoDeEspera;
    private double tiempoPagando;

    public Estado estado;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
        this.estado = estado.FILA_UNICA;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public double getTiempoInicioPago() {
        return tiempoInicioPago;
    }

    public void setTiempoInicioPago(double tiempoInicioPago) {
        this.tiempoInicioPago = tiempoInicioPago;
        this.tiempoDeEspera = tiempoInicioPago - tiempoLlegada;
    }

    public double getTiempoFinalPago() {
        return tiempoFinalPago;
    }

    public void setTiempoFinalPago(double tiempoFinalPago) {
        this.tiempoFinalPago = tiempoFinalPago;
        this.tiempoPagando = tiempoFinalPago - tiempoInicioPago;
    }

    public double getTiempoDeEspera() {
        return tiempoDeEspera;
    }

    public double getTiempoPagando() {
        return tiempoPagando;
    }

    @Override
    public String toString() {
        return "Cliente " + numeroCliente +
                " | Espera=" + tiempoDeEspera +
                " | Pago=" + tiempoPagando;
    }
}
