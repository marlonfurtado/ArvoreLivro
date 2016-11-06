package livro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Livro {

	private GeneralTreeOfString arv;

	public Livro() {
		arv = new GeneralTreeOfString();
	}

	public void lerLivro(String livro) throws IOException{
		BufferedReader lerLivro = new BufferedReader(new FileReader(livro));
		String linha = lerLivro.readLine();

		while (linha != null){
			//System.out.println(linha);
			String aux = linha;
			String primeirasLetras = aux.substring(0 , 2);

			System.out.println(primeirasLetras);


			switch (primeirasLetras){
			case "L ":
				//arv.add(aux, null);	
				System.out.println("to no L");
				break;

			case "C ":
				System.out.println("to no C");
				break;

			case "S ":
				System.out.println("to no S");
				break;

			case "SS":
				System.out.println("to no SS");
				break;

			case "P ":
				System.out.println("to no P");
				break;

			}

			linha = lerLivro.readLine();

		}
		lerLivro.close();
	}



	public static void gravarLivro(Livro livro) throws IOException{

	}

}
