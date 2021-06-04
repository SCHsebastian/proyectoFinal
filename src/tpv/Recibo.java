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
    	total=total-descuento.getCantidad();
    	recibosCreados++;
    }
    
    public Recibo(ArrayList<Producto> productos) {
    	this.productos=productos;
    	for (Producto producto : productos) {
    		double suma = producto.getPrecio();
			total=total+suma;
		}
    	recibosCreados++;
    }

    private ArrayList<Producto> productos;
    private static int recibosCreados;
    private Descuento descuento;

    private double total;
    
    public Descuento getDescuento() {
    	return descuento;
    }

	public double getTotal() {
		return total;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public static void setRecibosCreados(int cantidad) {
		recibosCreados=cantidad;
	}

}