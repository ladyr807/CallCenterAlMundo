package com.almundo.callcenter.business;

import com.almundo.callcenter.dto.Empleado;

/**
 * Clase que ejecuta la llamada entrante.
 * 
 * @author Leidy
 *
 */
public class CallCenter implements Runnable {

	private Dispatcher dispatcher;
	private String numeroLlamada;

	/**
	 * Constructor inicializador que crea una instancia del Dispatcher.
	 * 
	 * @param numeroLlamada,
	 *            String con el número de la llamada entrante.
	 */
	public CallCenter(String numeroLlamada) {
		super();
		this.dispatcher = Dispatcher.getInstance();
		this.numeroLlamada = numeroLlamada;
	}

	public void run() {
		int tiempoLlamada = (int) (Math.random() * 5) + 5;
		// Se asigna la llamada a un asesor y se recibe la información de éste.
		Empleado empleadoEnLlamada = dispatcher.dispatchCall(numeroLlamada);

		// Si empleadoEnLlamada es igual a null, es porque no hay asesores
		// disponibles
		if (empleadoEnLlamada == null) {
			System.out.println(
					"En este momento todos nuestros asesores están ocupados. Su número ha sido registrado y lo contactaremos más tarde. feliz día!");
		} else {
			System.out.println("Llamada: " + numeroLlamada + " iniciada, atendida por: "
					+ empleadoEnLlamada.getIdEmpleado() + " Tiempo de llamada: " + tiempoLlamada);
			try {
				// Esperamos unos milisegundos para poder ver la información de
				// la llamada en los tests.
				Thread.sleep(tiempoLlamada * 1000);
			} catch (Exception e) {
				System.out.println("Error en llamada " + numeroLlamada + "...Exception: " + e);
			} finally {
				// Se termina la llamada del empleadoEnLlamada para volverlo a
				// poner disponible.
				dispatcher.endCall(empleadoEnLlamada);
				System.out.println(
						"Fin de la llamada " + numeroLlamada + " atendida por: " + empleadoEnLlamada.getIdEmpleado());
			}
		}
	}
}
