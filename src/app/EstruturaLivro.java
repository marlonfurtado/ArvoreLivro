package app;

import java.io.IOException;

public class EstruturaLivro {

	private String refTitulo;
	private String refCapitulo;
	private String refSecao;
	private String refSubsecao;
	private String refParagrafo;
	
	// REMOVER METODOS 'set'
	public int countCapitulo;
	public int countSecao;
	public int countSubsecao;
	public int countParagrafo;
	
	private int pagina;
	private int controleLinhas;

	public EstruturaLivro() {
		refTitulo = "";
		refCapitulo = "";
		refSecao = "";
		refSubsecao = "";
		refParagrafo = "";
		countCapitulo = 0;
		countSecao = 0;
		countSubsecao = 0;
		countParagrafo = 0;
		pagina = 0;
		controleLinhas = 1;
	}

	public String getRefTitulo() {
		return refTitulo;
	}

	public String getRefCapitulo() {
		return refCapitulo;
	}

	public String getRefSecao() {
		return refSecao;
	}

	public String getRefSubsecao() {
		return refSubsecao;
	}

	public String getRefParagrafo() {
		return refParagrafo;
	}

	public void setRefTitulo(String refTitulo) {
		this.refTitulo = refTitulo;
	}

	public void setRefCapitulo(String refCapitulo) {
		this.refCapitulo = refCapitulo;
	}

	public void setRefSecao(String refSecao) {
		this.refSecao = refSecao;
	}

	public void setRefSubsecao(String refSubsecao) {
		this.refSubsecao = refSubsecao;
	}

	public void setRefParagrafo(String refParagrafo) {
		this.refParagrafo = refParagrafo;
	}


	
	public int getCountCapitulo() {
		return countCapitulo;
	}

	public int getCountSecao() {
		return countSecao;
	}

	public int getCountSubsecao() {
		return countSubsecao;
	}

	public int getCountParagrafo() {
		return countParagrafo;
	}



	public int getPagina() {
		return pagina;
	}

	public int getControleLinhas() {
		return controleLinhas;
	}

	
	public void controleLinhas(int countLinha) throws IOException {
		this.controleLinhas += countLinha;
		
		if(this.controleLinhas >= 16){
			pagina++;
			this.controleLinhas = 1;
			
			Livro.gravarLivro.write("------------------------------------- Pg."+getPagina());
			Livro.gravarLivro.newLine();
		}
	}

}
