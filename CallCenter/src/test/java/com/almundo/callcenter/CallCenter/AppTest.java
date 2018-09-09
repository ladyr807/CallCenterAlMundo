package com.almundo.callcenter.CallCenter;

import com.almundo.callcenter.controller.CallCenterController;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private CallCenterController callCenterController;

	public void testTresLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 3; i++) {
			System.out.println("Llamada " + (i+1));
			callCenterController.atenderLlamada(String.valueOf(i+1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testCuatroLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 4; i++) {
			System.out.println("Llamada " + (i+1));
			callCenterController.atenderLlamada(String.valueOf(i+1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testDiezLlamadas() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 10; i++) {
			System.out.println("Llamada " + (i+1));
			callCenterController.atenderLlamada(String.valueOf(i+1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void testLlamadasPendientes() {
		callCenterController = new CallCenterController();
		for (int i = 0; i < 12; i++) {
			System.out.println("Llamada " + (i+1));
			callCenterController.atenderLlamada(String.valueOf(i+1));
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
