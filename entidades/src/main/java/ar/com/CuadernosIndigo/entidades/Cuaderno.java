package ar.com.CuadernosIndigo.entidades;

import ar.com.CuadernosIndigo.enums.Interiores;

public class Cuaderno {
	
	private int id;
	
	private int tapas;
	
	private Interiores interiores;

	public Cuaderno() {
		super();
	}

	public Cuaderno(int id) {
		super();
		this.id = id;
	}
	

	public Cuaderno(int tapas, Interiores interiores) {
		super();
		this.tapas = tapas;
		this.interiores = interiores;
	}

	public Cuaderno(int id, int tapas, Interiores interiores) {
		super();
		this.id = id;
		this.tapas = tapas;
		this.interiores = interiores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTapas() {
		return tapas;
	}

	public void setTapas(int tapas) {
		this.tapas = tapas;
	}

	public Interiores getInteriores() {
		return interiores;
	}

	public void setInteriores(Interiores interiores) {
		this.interiores = interiores;
	}

	@Override
	public String toString() {
		return "Cuaderno [id=" + id + ", tapas=" + tapas + ", interiores=" + interiores + "]";
	}
	
	
	

}
