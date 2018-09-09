package com.almundo.callcenter.dto;

public class Empleado {

	private Integer idEmpleado;
	private String nombreCompleto;

	public Empleado(Integer idEmpleado, String nombreCompleto) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
}
