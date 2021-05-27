package tpv;

import java.util.*;

public class Recibo {

    public Recibo(ArrayList<Producto> productos, Descuento descuento) {
    	this.productos=productos;
    	this.descuento=descuento;
    	for (Producto producto : productos) {
    		double suma = producto.getPrecio();
			total=total+suma;
		}
    	total=total*descuento.getCantidad();
    }
    

    private ArrayList<Producto> productos;

    private Descuento descuento;

    private double total;

    public void getRecibo() {
        // TODO implement here
    }

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}