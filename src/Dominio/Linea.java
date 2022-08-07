package Dominio;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class Linea {
	
	protected ArrayList<Bus> buses;
	protected String color;  // Posible modificación  en un futuro
	protected String nombre;
	protected int capacidad;
	protected int velocidad;
	protected final double tarifa = 10;
	
	ArrayList<Bus> getBuses() {
		return buses;
	}
	
	public void setBuses(Bus bus) {
		this.buses.add(bus);
	}
	
	public String getColor() {
		return color;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public double getPrecio() {
		return tarifa;
	}
	/*
	Retorna todas las rutas que realiza una linea
	*/
	public ArrayList<Ruta> getTrayectoLinea(Gestor g) {
		
		ArrayList<Ruta> aux = new ArrayList<Ruta>();
		
		buses.stream()
			 .map(b -> b.getRutas(g)).forEach(new Consumer<ArrayList<Ruta>>() {
				 @Override
				public void accept(ArrayList<Ruta> r) {
					aux.addAll(r);
				}
			 });
		return aux;
	}
	
}
