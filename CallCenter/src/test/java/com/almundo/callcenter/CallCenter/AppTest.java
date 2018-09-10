package com.almundo.callcenter.CallCenter;

import com.almundo.callcenter.controller.CallCenterController;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private CallCenterController callCenterController;

	/**
	 * Prueba para tres llamadas entrantes.
	 */
	public void testTresLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 3; i++) {
			System.out.println("Llamada " + (i + 1));
			callCenterController.atenderLlamada(String.valueOf(i + 1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba para cuatro llamadas entrantes.
	 */
	public void testCuatroLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 4; i++) {
			System.out.println("Llamada " + (i + 1));
			callCenterController.atenderLlamada(String.valueOf(i + 1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba para diez llamadas entrantes.
	 */
	public void testDiezLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 10; i++) {
			System.out.println("Llamada " + (i + 1));
			callCenterController.atenderLlamada(String.valueOf(i + 1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba para doce llamadas entrantes por lo tanto quedaran dos llamadas en
	 * espera de que un asesor lo pueda atender.
	 */
	public void testLlamadasPendientes() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 12; i++) {
			System.out.println("Llamada " + (i + 1));
			callCenterController.atenderLlamada(String.valueOf(i + 1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
