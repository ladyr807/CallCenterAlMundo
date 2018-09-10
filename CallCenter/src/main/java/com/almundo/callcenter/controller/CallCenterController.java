package com.almundo.callcenter.controller;

import com.almundo.callcenter.business.CallCenter;

/**
 * Controlador que inicializa el hilo de la llamada entrante.
 * 
 * @author Leidy
 *
 */
public class CallCenterController {

	/**
	 * Método que genera el hilo con el número de la llamada entrante al CallCenter.
	 * 
	 * @param numeroLlamada
	 */
	public void atenderLlamada(String numeroLlamada) {
		Thread llamada = new Thread(new CallCenter(numeroLlamada));
		llamada.start();
	}
}
