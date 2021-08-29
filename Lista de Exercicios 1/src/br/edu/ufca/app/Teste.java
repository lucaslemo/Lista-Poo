package br.edu.ufca.app;

import br.edu.ufca.camp.Campeonato;

public class Teste {
	public static void main(String[] args) {
		String [] times = {"Time a", "Time b", "Time c", "Time d", "Time e", "Time f", "Time g",
				"Time h", "Time i", "Time j", "Time k", "Time l", "Time m", "Time n", "Time o",
				"Time p", "Time q", "Time r", "Time s", "Time t"};
		
		Campeonato cnb = new Campeonato(20);
		for(int i = 0; i < 20; i++) {
			cnb.inscreverClubes(times[i]);
		}
		
		cnb.jogarCampeonato();
		
		System.out.println("Campeao: " + cnb.getCampeao().getNome() + "\n");
		
		cnb.mostrarTabela();
	}
}
