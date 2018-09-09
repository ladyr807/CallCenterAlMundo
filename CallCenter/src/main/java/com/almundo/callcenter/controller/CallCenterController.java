package com.almundo.callcenter.controller;

import com.almundo.callcenter.business.CallCenter;

public class CallCenterController {

	public void atenderLlamada(String numeroLlamada) {
		Thread llamada = new Thread(new CallCenter(numeroLlamada));
		llamada.start();
	}
}
