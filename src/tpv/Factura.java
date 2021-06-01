package tpv;

import java.util.*;

public class Factura {

    public Factura(ArrayList<Producto> productos, Descuento descuento, String cif) {
    	this.productos=productos;
    	this.descuento=descuento;
    	this.cif=cif;
    	for (Producto producto : productos) {
    		double suma = producto.getPrecio();
			total+=suma;
		}
    	total=total*descuento.getCantidad();
    	numeroFactura=facturasCreadas;
    	facturasCreadas++;
    }
    
    private int numeroFactura;
	private String cif;
	private ArrayList<Producto> productos;
    private Descuento descuento;
    private double total;
	private static int facturasCreadas;

    public void getFactura() {
        
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
	
	 public int getNumeroFactura() {
			return numeroFactura;
		}
	 
	 public String getCif() {
			return cif;
		}

}