import java.util.*;
import PolynomialsDnC.*;
import PolynomialsBF.*;

class Driver{
	public static void main(String args[]){
		BFPolynomialsMultiplier calcBF = new BFPolynomialsMultiplier();
		DnCPolynomialsMultiplier calcDnC = new DnCPolynomialsMultiplier();
		Scanner scan = new Scanner(System.in);
		int n;

		System.out.print("n = ");

		n = scan.nextInt();

		int[] inp1 = generateRandom(n);
		int[] inp2 = generateRandom(n);

		System.out.println("Polinom 1: " + Arrays.toString(inp1));
		System.out.println("Polinom 2: " + Arrays.toString(inp2));

		System.out.println();

		int[] arr1 = calcBF.multiply(inp1, inp2);
		System.out.println("Hasil BF: " + Arrays.toString(arr1));
		System.out.println("Perkalian: " + calcBF.getMultiplications());
		System.out.println("Penjumlahan: " + calcBF.getAdditions());


		System.out.println();

		int[] arr2 = calcDnC.multiply(inp1, inp2);
		System.out.println("Hasil DnC: " + Arrays.toString(arr2));
		System.out.println("Perkalian: " + calcDnC.getMultiplications());
		System.out.println("Penjumlahan: " + calcDnC.getAdditions());
	}

	public static int[] generateRandom(int sz){

		int[] ret = new int[sz];
		int randInt;

		for(int i=0; i<sz; i++){
			randInt = (int)(200.0 * Math.random()) - 100;
			ret[i] = randInt;
		}

		return ret;

	}
}