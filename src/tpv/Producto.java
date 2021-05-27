package tpv;

public class Producto { 
    
  
    private String nombre;

    private double precio;

    private String foto;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getFoto() {
    	return foto;
    }
    
    public Producto(String nombre, double precio) {
		this.nombre=nombre;
		this.precio=precio;
    }
    
    public Producto(String nombre, double precio, String foto) {
    	this.nombre=nombre;
    	this.precio=precio;
    	this.foto=foto;
    }

}