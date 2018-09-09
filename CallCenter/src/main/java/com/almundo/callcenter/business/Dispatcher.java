package com.almundo.callcenter.business;

import java.util.ArrayList;
import java.util.List;

import com.almundo.callcenter.dto.Director;
import com.almundo.callcenter.dto.Empleado;
import com.almundo.callcenter.dto.Operador;
import com.almundo.callcenter.dto.Supervisor;

public class Dispatcher {

	private static Dispatcher instance;

	private List<Operador> operadores;
	private List<Supervisor> supervisores;
	private List<Director> directores;
	private List<String> llamadasPendientes;

	public static Dispatcher getInstance() {
		if (instance == null) {
			instance = new Dispatcher();
		}
		return instance;
	}

	public Dispatcher() {
		super();
		init();
	}

	private void init() {
		operadores = new ArrayList<Operador>();
		supervisores = new ArrayList<Supervisor>();
		directores = new ArrayList<Director>();
		llamadasPendientes = new ArrayList<String>();

		operadores.add(new Operador(1, ""));
		operadores.add(new Operador(2, ""));
		operadores.add(new Operador(3, ""));
		operadores.add(new Operador(4, ""));
		operadores.add(new Operador(5, ""));

		supervisores.add(new Supervisor(6, ""));
		supervisores.add(new Supervisor(7, ""));
		supervisores.add(new Supervisor(8, ""));

		directores.add(new Director(9, ""));
		directores.add(new Director(10, ""));
	}

	public synchronized Empleado dispatchCall(String numeroLlamada) {
		if (!operadores.isEmpty() || !supervisores.isEmpty() || !directores.isEmpty()) {
			if (!operadores.isEmpty()) {
				return operadores.remove(0);
			} else if (!supervisores.isEmpty()) {
				return supervisores.remove(0);
			} else if (!directores.isEmpty()) {
				return directores.remove(0);
			}
		} else {
			// Si no se encuentra ningún empleado disponible, se le pedirá al cliente que deje su número telefónico para contactarlo después.
			llamadasPendientes.add(numeroLlamada);
		}
		return null;
	}

	public synchronized void endCall(Empleado empleado) {
		if (empleado instanceof Operador) {
			operadores.add((Operador) empleado);
		} else if (empleado instanceof Supervisor) {
			supervisores.add((Supervisor) empleado);
		} else {
			directores.add((Director) empleado);
		}
		if (!llamadasPendientes.isEmpty()) {
			String llamadaPendiente = llamadasPendientes.remove(0);
			System.out.println("Iniciando llamada pendiente: " + llamadaPendiente);
			Thread llamada = new Thread(new CallCenter(llamadaPendiente));
			llamada.start();
		}

	}
}
