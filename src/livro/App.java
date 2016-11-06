package livro;

import java.io.IOException;

public class App {

	public static void main(String[] args) {

		Livro a = new Livro();
		try{
			a.lerLivro("src/arquivos/livro.txt");
		}catch(IOException e){

		}
	}
}