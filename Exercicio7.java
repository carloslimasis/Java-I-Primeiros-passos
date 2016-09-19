public class Exercicio7 {
	public static void main (String[] args) {
        long fatorial = 1;
        for (long n = 1; n <= 20; n++) {
            fatorial = fatorial * n;
            System.out.println("fat(" + n + ") = " + fatorial);
        }
    }
}