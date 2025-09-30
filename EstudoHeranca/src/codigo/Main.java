package codigo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Animal> animais = new ArrayList<Animal>();
		
		Animal cachorro = new Cachorro("Coelho");
		Animal gato = new Gato("Gate");
		
		animais.add(cachorro);
		animais.add(gato);
		
		cachorro.emitirSom();
		gato.emitirSom();

		
		Animal cachorroAnimal = cachorro;
		Animal gatoAnimal = gato;
	
		cachorroAnimal.emitirSom();
		gatoAnimal.emitirSom();
		
	}

}
