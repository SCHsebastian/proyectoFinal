package tpv;

import java.util.*;

public class Factura {

    public Factura() {
    }

    private String cif;

    private ArrayList<Producto> productos;

    private Descuento descuento;

    private int total;

    public void getFactura() {
        // TODO implement here
    }

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}