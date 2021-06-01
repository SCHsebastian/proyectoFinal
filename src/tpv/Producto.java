package tpv;

public class Producto { 
    
  
    private String nombre;

    private double precio;
    
    private String tipo;

    private String foto;

    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getFoto() {
    	return foto;
    }
    
    public Producto(String nombre, double precio, String tipo) {
		this.nombre=nombre;
		this.precio=precio;
		this.tipo=tipo;
    }
    
    public Producto(String nombre, double precio, String tipo, String foto) {
    	this.nombre=nombre;
    	this.precio=precio;
    	this.tipo=tipo;
    	this.foto=foto;
    }

}