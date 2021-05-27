package tpv;

public class Descuento {

    private String nombre;

    private double cantidad;

    public String getNombre() {
        return nombre;
    }
    public double getCantidad() {
    	return cantidad;
    }


    public Descuento(String nombre, double cantidad) {
    	this.nombre=nombre;
    	this.cantidad=cantidad;
    }

}