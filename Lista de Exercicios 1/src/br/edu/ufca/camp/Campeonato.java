package br.edu.ufca.camp;

import java.util.Arrays;
import java.util.Random;

public class Campeonato {
	private Clube [] clubes;
	private int qtdClubes;
	
	public Campeonato(int qtdClubes) {
		this.clubes = new Clube [qtdClubes];
		this.qtdClubes = qtdClubes;
	}
	
	public void inscreverClubes(String time) {
		int i = 0;
		while(this.getClubes()[i] != null && i < this.getQtdClubes()) {
			i++;
		}
		if(i < this.getQtdClubes()) {
			Clube novo = new Clube(time);
			setClubes(i, novo);
		}
	}
	
	public void jogarPartida(Clube casa, Clube fora) {
		Random random = new Random();
		int golsCasa = random.nextInt(6);
		int golsFora = random.nextInt(6);
		if(golsCasa > golsFora) {
			casa.ganhar(golsCasa - golsFora);
			fora.perder(golsFora - golsCasa);
		}
		else if(golsCasa < golsFora) {
			casa.perder(golsCasa - golsFora);
			fora.ganhar(golsFora - golsCasa);
		}
		else {
			casa.empatar();
			fora.empatar();
		}
	}
	
	public void jogarCampeonato() {
		for (int casa = 0; casa < this.getQtdClubes(); casa++) {
			for (int fora = 0; fora < this.getQtdClubes(); fora++) {
				if (casa != fora) {
					this.jogarPartida(this.getClubes()[casa], this.getClubes()[fora]);
				}
			}
		}
	}
	
	public Clube getCampeao() {
		Clube campeao = this.getClubes()[0];
		for (int i = 1; i < this.getQtdClubes(); i++) {
			if (this.getClubes()[i].getPontos() > campeao.getPontos()) {
				campeao = this.getClubes()[i];
			}
			else if (this.getClubes()[i].getPontos() == campeao.getPontos()) {
				if (this.getClubes()[i].getSaldoDeGols() > campeao.getSaldoDeGols()) {
					campeao = this.getClubes()[i];
				}
			}
		}
		return campeao;
	}

	public void mostrarTabela() {
		Arrays.sort(this.getClubes());
		for (int i = 0; i < this.getQtdClubes(); i++) {
			System.out.println(this.getClubes()[i].toString());
		}
	}
	
	public Clube [] getClubes() {
		return this.clubes;
	}
	
	public void setClubes(int i, Clube novo) {
		this.clubes[i] = novo;
	}

	public int getQtdClubes() {
		return qtdClubes;
	}

}
