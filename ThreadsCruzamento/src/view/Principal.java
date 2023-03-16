package view;

import java.util.concurrent.Semaphore;
import controller.TCruzamento;

public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore s = new Semaphore(permissao);
		String sentido="";
		
		for (int idCarro = 0; idCarro < 4; idCarro++) {
			if (idCarro == 0) {
				sentido = "norte";
			} else if (idCarro == 1) {
				sentido = "sul";
			} else if (idCarro == 2) {
				sentido = "leste";
			} else {
				sentido = "oeste";
			}
			Thread tCarros = new TCruzamento(idCarro, s, sentido);
			tCarros.start();
		}
	}

}
