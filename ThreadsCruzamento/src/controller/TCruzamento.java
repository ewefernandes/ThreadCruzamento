package controller;
import java.util.concurrent.Semaphore;

public class TCruzamento extends Thread {
	
	private String sentido;
	private Semaphore s;
	private int idCarro;

	public TCruzamento(int idCarro, Semaphore s, String sentido) {
		this.idCarro = idCarro;
		this.s = s;
		this.sentido = sentido;
	}

	public void run() {
		ChegarCruzamento();
		try {
			s.acquire();
			Cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			s.release();
		}
		PassarCruzamento();
	}
	
	private void ChegarCruzamento() {
		int distancia = 16;
		int deslocamento = (int)((Math.random()*2.00002) + 4);
		int distPercorrida = 0;
		int tempo = 1000;
		
		while (distPercorrida < distancia) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O carro #" +idCarro+ " chegou no cruzamento.");
		
	}
	
	private void Cruzar() {
		System.out.println("O carro #" +idCarro+ " esta cruzando na direcao " +sentido+ " e os outros aguardam.");
		int distCruzamento = 20;
		int tempo = 1000;
		int deslocamento = (int)((Math.random()*2.00002) + 4);
		int distPercorrida = 0;
		
		while (distPercorrida < distCruzamento) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void PassarCruzamento() {
		System.out.println("O carro #" +idCarro+ " passou do cruzamento.");
	}
	
	
}
