package app;

import java.io.IOException;
import java.util.ArrayList;

import arvore.GeneralTreeOfString;

public class App {

	public static void main(String[] args) {

		String ler, gravar = "";

		// Se não for passado nenhum parametro
		// Assume 'livro.txt, e 'livro_prod.txt' como default
		try{
			ler = args[0];
			gravar = args[1];
		}catch(Exception e){
			ler = "livro.txt";
			gravar = "livro_prod.txt";
		}

		try{
			Livro livro = new Livro(ler, gravar);
			GeneralTreeOfString arv = livro.gerarLivro();

			System.out.print("Carregando arquivo 'livro.txt' ...");
			livro.lerLivro();
			System.out.println(" OK");

			System.out.print("Gerando a árvore...");
			livro.gerarLivro();
			System.out.println(" OK");



			System.out.println("Linhas: "+livro.linha.size());
			System.out.println("Arvore: "+arv.size());


			System.out.println("\nCapitulos...: " + livro.getCountCapitulo());
			System.out.println("Seções...: " + livro.getCountSecao());
			System.out.println("Subseções...: " + livro.getCountSubsecao());
			System.out.println("Parágrafos...: " + livro.getCountParagrafo());
			System.out.println("");



			System.out.print("Gerando sumário...");
			livro.gerarSumario();
			System.out.println(" OK");


			System.out.print("Imprimindo o livro para o arquivo '"+gravar+"'...");
			livro.gravarLivro();
			System.out.println(" OK");



		}catch(IOException e){
			e.getMessage();
			e.getCause();
		}

	}
}