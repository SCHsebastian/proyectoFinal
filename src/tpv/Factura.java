package tpv;

import java.util.*;

public class Factura {

    public Factura(ArrayList<Producto> productos, Descuento descuento, String cif) {
    	this.productos=productos;
    	this.descuento=descuento;
    	this.cif=cif;
    	for (Producto producto : productos) {
    		double suma = producto.getPrecio();
			total=total+suma;
		}
    	total=total*descuento.getCantidad();
    }

    private String cif;

    private ArrayList<Producto> productos;

    private Descuento descuento;

    private double total;

    public void getFactura() {
        
    }

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}