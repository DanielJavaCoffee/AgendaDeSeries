package entity;

public class Canal {
	
	private String nome;
	private String tipoDoCanal;
	
	public Canal() {
		
	}
	
	public Canal(String nome, String tipoDoCanal) {
		this.nome = nome;
		this.tipoDoCanal = tipoDoCanal;
	}
	
	public String toString() {
		return "Nome Do Canal: " + this.nome + " Tipo Do Canal: " + this.tipoDoCanal;
	}
	
	public boolean equals(Canal canal){
		if(canal.getNome().equals(nome)) {
			return true;
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDoCanal() {
		return tipoDoCanal;
	}

	public void setTipoDoCanal(String tipoDoCanal) {
		this.tipoDoCanal = tipoDoCanal;
	}
}
