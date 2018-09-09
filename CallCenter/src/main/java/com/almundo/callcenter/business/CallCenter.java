package com.almundo.callcenter.business;

import com.almundo.callcenter.dto.Empleado;

public class CallCenter implements Runnable {
	
	private Dispatcher dispatcher;
	private String numeroLlamada;
	
	public CallCenter(String numeroLlamada) {
		super();
		this.dispatcher = Dispatcher.getInstance();
		this.numeroLlamada = numeroLlamada;
	}
	
	public void run() {
		int callTime = (int) (Math.random() * 5) + 5;
		Empleado empleadoEnLlamada = dispatcher.dispatchCall(numeroLlamada);
		if (empleadoEnLlamada == null) {
			System.out.println(
					"En este momento todos nuestros asesores están ocupados. Su número ha sido registrado y lo contactaremos más tarde. feliz día!");
		} else {
			System.out.println("Llamada: " + numeroLlamada + " iniciada, atendida por: "
					+ empleadoEnLlamada.getIdEmpleado() + " Tiempo de llamada: " + callTime);
			try {
				Thread.sleep(callTime * 1000);
			} catch (Exception e) {
				System.out.println("Error en llamada " + numeroLlamada + "...Exception: " + e);
			} finally {
				dispatcher.endCall(empleadoEnLlamada);
				System.out.println(
						"Fin de la llamada " + numeroLlamada + " atendida por: " + empleadoEnLlamada.getIdEmpleado());
			}
		}
	}
}
