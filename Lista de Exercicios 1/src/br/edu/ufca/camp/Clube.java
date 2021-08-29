package br.edu.ufca.camp;

public class Clube implements Comparable<Object>{
	private String nome;
	private int pontos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int saldoDeGols;
	private int jogos;
	
	public Clube(String nome) {
		this.nome = nome;
		this.pontos = 0;
		this.vitorias = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.saldoDeGols = 0;
		this.jogos = 0;
	}
	
	void ganhar(int saldoDeGols) {
		this.setVitorias(this.getVitorias() + 1);
		this.setPontos(this.getPontos() + 3);
		this.setSaldoDeGols(this.getSaldoDeGols() + saldoDeGols);
		this.setJogos(this.getJogos() + 1);
	}
	
	void empatar() {
		this.setEmpates(this.getEmpates() + 1);
		this.setPontos(this.getPontos() + 1);
		this.setJogos(this.getJogos() + 1);
	}
	
	void perder(int saldoDeGols) {
		this.setDerrotas(this.getDerrotas() + 1);
		this.setSaldoDeGols(this.getSaldoDeGols() + saldoDeGols);
		this.setJogos(this.getJogos() + 1);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return this.pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getVitorias() {
		return this.vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return this.empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return this.derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getSaldoDeGols() {
		return this.saldoDeGols;
	}

	public void setSaldoDeGols(int saldoDeGols) {
		this.saldoDeGols = saldoDeGols;
	}

	public int getJogos() {
		return jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Clube) {
			Clube aux = (Clube) obj;
			if (this.getPontos() > aux.getPontos()) {
				return -1;
			}
			else if (this.getPontos() == aux.getPontos()) {
				if (this.getSaldoDeGols() > aux.getSaldoDeGols()) {
					return -1;
				}
			}
			else if (this.getPontos() < aux.getPontos()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "| " + this.getNome() + " | Pontos: " + this.getPontos() + " | Jogos: " + this.getJogos() + 
		" | Vitorias: " + this.getVitorias() + " | Empates: " + this.getEmpates() + " | Derrotas: "
		+ this.getDerrotas() + " | Saldo de gols: " + this.getSaldoDeGols() + " |";
	}
}
