package com.almundo.callcenter.business;

import java.util.ArrayList;
import java.util.List;

import com.almundo.callcenter.dto.Director;
import com.almundo.callcenter.dto.Empleado;
import com.almundo.callcenter.dto.Operador;
import com.almundo.callcenter.dto.Supervisor;

/**
 * Clase que encargada de asignar y terminar las llamadas a los empleados.
 * @author Leidy
 *
 */
public class Dispatcher {
	private static Dispatcher instance;

	private List<Operador> operadores;
	private List<Supervisor> supervisores;
	private List<Director> directores;
	private List<String> llamadasPendientes;

	/**
	 * Retorna una instancia de Dispatcher.
	 * 
	 * @return instance, instancia de Dispatcher
	 */
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

	/**
	 * Método que inicializa los empleados disponibles para atender las
	 * llamadas. (Esta información se puede cargar desde un archivo de
	 * propiedades).
	 */
	private void init() {
		operadores = new ArrayList<Operador>();
		supervisores = new ArrayList<Supervisor>();
		directores = new ArrayList<Director>();
		llamadasPendientes = new ArrayList<String>();

		operadores.add(new Operador(1, "Ricardo Torres"));
		operadores.add(new Operador(2, "Eliana Garcia"));
		operadores.add(new Operador(3, "Martha Gomez"));
		operadores.add(new Operador(4, "Esteban Zapata"));
		operadores.add(new Operador(5, "Pilar Perez"));

		supervisores.add(new Supervisor(6, "Camila Marín"));
		supervisores.add(new Supervisor(7, "Cesar Tamayo"));
		supervisores.add(new Supervisor(8, "Sofia Cardona"));

		directores.add(new Director(9, "Felipe Valencia"));
		directores.add(new Director(10, "Andrés Jurado"));
	}

	/**
	 * Método que asigna el numero de llamada a un empleado, validando que hayan
	 * operadores, supervisores o directores disponibles, de lo contrario la
	 * llamada se marca como llamadas pendientes.
	 * 
	 * @param numeroLlamada,
	 *            String con el número de la llamada entrante.
	 * @return Empleado, de acuerdo al tipo de empleado que esté disponible para
	 *         atender la llamada, ya sea operador, supervisor o director, de lo
	 *         contrario retorna null.
	 */
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
			// Si no se encuentra ningún empleado disponible, se le informará al
			// cliente que un asesor lo contactará después.
			llamadasPendientes.add(numeroLlamada);
		}
		return null;
	}

	/**
	 * Método que coloca al empleado, después de terminar una llamada, en la
	 * lista como disponible para atender de nuevo llamadas, si hay llamadas
	 * pendientes, se le asignará esa llamada al empleado.
	 * 
	 * @param empleado,
	 *            Empleado que terminó llamada.
	 */
	public synchronized void endCall(Empleado empleado) {
		if (empleado instanceof Operador) {
			operadores.add((Operador) empleado);
		} else if (empleado instanceof Supervisor) {
			supervisores.add((Supervisor) empleado);
		} else {
			directores.add((Director) empleado);
		}

		// Si existen llamadas pendientes, es porque no hay asesores
		// disponibles.
		if (!llamadasPendientes.isEmpty()) {
			String llamadaPendiente = llamadasPendientes.remove(0);
			System.out.println("Iniciando llamada pendiente: " + llamadaPendiente);
			// Se genera una nueva llamada con el número de llamada pendiente
			// para asignarle un asesor.
			Thread llamada = new Thread(new CallCenter(llamadaPendiente));
			llamada.start();
		}
	}
}
