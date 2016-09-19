public class Exercicio4 {
	public static void main(String[] args) {
		int soma = 0;
		int numero = 1;

		while(numero <= 1000) {
			soma += numero;
			numero++;
		}

		System.out.println("O valor da soma e " + soma);
	}
}