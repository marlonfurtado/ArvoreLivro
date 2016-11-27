package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import arvore.GeneralTreeOfString;


public class Livro extends EstruturaLivro {

	private GeneralTreeOfString arv;
	private GeneralTreeOfString arvSumario;
	private BufferedReader lerLivro;
	public static BufferedWriter gravarLivro;
	public ArrayList<String> linha;


	public Livro(String ler, String gravar) throws IOException {
		super();
		arv = new GeneralTreeOfString();
		arvSumario = new GeneralTreeOfString();
		lerLivro = new BufferedReader(new FileReader(ler));
		gravarLivro = new BufferedWriter(new FileWriter(gravar));
		linha = new ArrayList<>();
	}


	public void lerLivro() throws IOException{

		// Lê cada linha do livro, e guarda no Array 'linha'

		String auxLinha = lerLivro.readLine();
		while (auxLinha != null){
			linha.add(auxLinha);
			auxLinha = lerLivro.readLine();
		}
		lerLivro.close();
	}

	public GeneralTreeOfString gerarLivro() throws IOException{

		for (String auxLinha : linha) {

			String primeiraLetra = auxLinha.substring(0 , 2);

			switch (primeiraLetra){
			
			case "L ":
				// ADICIONAR NA ÁRVORE
				String titulo = auxLinha.replaceFirst(primeiraLetra, "");

				arv.add(titulo, null);

				setRefTitulo(titulo);


				// GRAVAR LIVRO
				gravarLivro.write("-------------------------------------\n");
				for (int i = 1; i <= 15; i++) {
					gravarLivro.write(String.valueOf(i));
					if (i == 7)
						gravarLivro.write("              "+titulo);

					gravarLivro.newLine();

					if (i == 15)
						gravarLivro.write("---------------------------------Capa\n");
				}


				// GERAR SUMARIO 
				arvSumario.add("", null);

				break;

			case "C ":
				// ADICIONAR NA ÁRVORE
				String capitulo = auxLinha.replaceFirst(primeiraLetra, "");

				arv.add(capitulo, getRefTitulo());
				
				countCapitulo++;

				setRefCapitulo(capitulo);

				// GRAVAR LIVRO
				if(getCountCapitulo() > 1){
					// A CADA NOVO CAPITULO, MUDA DE PAGINA
					controleLinhas(99);
				}
				gravarLivro.write(String.valueOf(getControleLinhas())+"   ");
				gravarLivro.write(getCountCapitulo()+". "+capitulo);
				gravarLivro.newLine();


				// GERAR SUMÁRIO
				String capituloSumario = getCountCapitulo() + ". " + capitulo
						+ "..............." + (getPagina()+1);
				
				arvSumario.add(capituloSumario, "");

				setRefCapitulo(capituloSumario);


				break;

			case "S ":
				// ADICIONAR NA ÁRVORE
				String secao = auxLinha.replaceFirst(primeiraLetra, "");

		arv.add(secao, getRefCapitulo());

				countSecao++;
				
				setRefSecao(secao);
				

				// GRAVAR LIVRO
				controleLinhas(1);
				gravarLivro.write(String.valueOf(getControleLinhas())+"   ");
				gravarLivro.write(getCountCapitulo()+"."+getCountSecao()+". "+secao);
				gravarLivro.newLine();


				// GERAR SUMARIO
				String secaoSumario = getCountCapitulo() +"."+ getCountSecao() + " " + secao
						+ "..............." + (getPagina()+1);
				arvSumario.add(secaoSumario, getRefCapitulo());

				setRefSecao(secaoSumario);


				break;

			case "SS":
				// ADICIONAR NA ÁRVORE
				String subsecao = auxLinha.replaceFirst(primeiraLetra, "");

				arv.add(subsecao, getRefSecao());

				countSubsecao++;
				
				setRefSubsecao(subsecao);
				
				
				// GRAVAR LIVRO
				controleLinhas(1);
				gravarLivro.write(String.valueOf(getControleLinhas())+"   ");
				gravarLivro.write(getCountCapitulo()+"."+getCountSecao()+"."+getCountSubsecao()+". "+subsecao);
				gravarLivro.newLine();


				// GERAR SUMARIO
				String subsecaoSumario = getCountCapitulo() + "." + getCountSecao() + "." + getCountSubsecao() + " " + subsecao
						+ "..............." + (getPagina()+1); 
				arvSumario.add(subsecaoSumario, getRefSecao());

				break;

			case "P ":
				String paragrafo = auxLinha.replaceFirst(primeiraLetra, "");

				// ADICIONAR NA ÁRVORE COMO FILHO DE 'SUBSECAO'
				if(arv.contains(getRefSubsecao())
						&& arv.getFather(getRefSubsecao()).equals(getRefSecao())){

					arv.add(paragrafo, getRefSubsecao());

					
					// GRAVAR LIVRO
					int intParagrafo = Integer.parseInt(paragrafo);
					for (int i = 1; i <= intParagrafo; i++) {
						controleLinhas(1);
						gravarLivro.write(String.valueOf(getControleLinhas())+"   ");

						gravarLivro.write("Lorem Ipsum "+String.valueOf(i));
						gravarLivro.newLine();
					}
				}
				
				else{
					// ADICIONAR NA ÁRVORE COMO FILHO DE 'SECAO'
					arv.add(paragrafo, getRefSecao());

					// GRAVAR LIVRO
					int intParagrafo = Integer.parseInt(paragrafo);
					for (int i = 1; i <= intParagrafo; i++) {
						controleLinhas(1);
						gravarLivro.write(String.valueOf(getControleLinhas())+"   ");


						gravarLivro.write("Lorem Ipsum "+String.valueOf(i));
						gravarLivro.newLine();
					}
				}

				countParagrafo++;
				break;
			}
		}
		return arv;
	}



	public void gravarLivro() throws IOException{
		gravarLivro.flush();
		gravarLivro.close();
	}

	public void gerarSumario() throws IOException{
		
		gravarLivro.newLine();
		gravarLivro.write("\nSUMÁRIO \n");

		for (String auxLinha : arvSumario.positionsPre()) {
			gravarLivro.write(auxLinha);
			gravarLivro.newLine();
		}

	}


}
