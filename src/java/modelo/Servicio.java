
package modelo;

import java.sql.*;

public class Servicio {
    
    private Date fechaServicio;
    private Time horaLlegada;
    private String cedulaCliente;
    private String placaVehiculo;
    private Time horaSalida;
    private int idTipoVehiculo;
    private int porcentajeDescuento;
    private double valorDescuento;
    private double subtotal;
    private double valorTotalServicio;
    private String estado;
    private String tiempoDuracion;

    public Servicio() {
    }

    public Servicio(Date fechaServicio, Time horaLlegada, String cedulaCliente, String placaVehiculo, Time horaSalida, int idTipoVehiculo, int porcentajeDescuento, double valorDescuento, double subtotal, double valorTotalServicio, String estado) {
        this.fechaServicio = fechaServicio;
        this.horaLlegada = horaLlegada;
        this.cedulaCliente = cedulaCliente;
        this.placaVehiculo = placaVehiculo;
        this.horaSalida = horaSalida;
        this.idTipoVehiculo = idTipoVehiculo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.valorDescuento = valorDescuento;
        this.subtotal = subtotal;
        this.valorTotalServicio = valorTotalServicio;
        this.estado = estado;
    }

    public Servicio(Date fechaServicio, Time horaLlegada, String cedulaCliente, String placaVehiculo, Time horaSalida, int porcentajeDescuento, double valorDescuento, double subtotal, double valorTotalServicio, String tiempoDuracion) {
        this.fechaServicio = fechaServicio;
        this.horaLlegada = horaLlegada;
        this.cedulaCliente = cedulaCliente;
        this.placaVehiculo = placaVehiculo;
        this.horaSalida = horaSalida;
        this.porcentajeDescuento = porcentajeDescuento;
        this.valorDescuento = valorDescuento;
        this.subtotal = subtotal;
        this.valorTotalServicio = valorTotalServicio;        
        this.tiempoDuracion = tiempoDuracion;
    }
    
    

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getValorTotalServicio() {
        return valorTotalServicio;
    }

    public void setValorTotalServicio(double valorTotalServicio) {
        this.valorTotalServicio = valorTotalServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTiempoDuracion() {
        return tiempoDuracion;
    }

    public void setTiempoDuracion(String tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }
    
    
    
    
}
