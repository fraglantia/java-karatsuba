package PolynomialsDnC;
import java.util.*;


public class DnCPolynomialsMultiplier{

	int multiplications;
	int additions;

	public DnCPolynomialsMultiplier(){
		multiplications = 0;
		additions = 0;
	}

	private int[] add(int[] p, int[] q){
		// length may differ, pad to highest

		int n = Math.max(p.length, q.length)-1;
		int[] sum = new int[n+1];

		for(int i=0; i<=n; i++){
			sum[i] = 0;
		}

		for(int i=0; i<p.length; i++){
			sum[i] += p[i];
		}

		for(int i=0; i<q.length; i++){
			sum[i] += q[i];
		}

		additions += 1;

		return sum;
	}

	private int[] subtract(int[] p, int[] q){
		// length may differ, pad to highest

		int n = Math.max(p.length, q.length)-1;
		int[] sum = new int[n+1];

		for(int i=0; i<=n; i++){
			sum[i] = 0;
		}

		for(int i=0; i<p.length; i++){
			sum[i] += p[i];
		}

		for(int i=0; i<q.length; i++){
			sum[i] -= q[i];
		}

		additions += 1;

		return sum;
	}

	private int[] timesXpow(int[] p, int x){
		int n = p.length-1;

		int[] product = new int[n+1+x];

		for(int i=0; i<=n+x; i++){
			if(i<x){
				product[i] = 0;
			}
			else{
				product[i] = p[i-x];
			}
		}

		return product;
	}

	private int[] multiplyHelper(int[] p, int[] q){
		int n = p.length;

		if(n == 1){
			int[] ret = new int[1];
			ret[0] = p[0]*q[0];
			multiplications += 1;
			return ret;
		}

		int[] p0 = Arrays.copyOfRange(p, 0, (n/2));
		int[] p1 = Arrays.copyOfRange(p, (n/2), n);
		int[] q0 = Arrays.copyOfRange(q, 0, (n/2));
		int[] q1 = Arrays.copyOfRange(q, (n/2), n);

		int[] y = multiplyHelper(add(p0, p1), add(q0, q1));
		int[] u = multiplyHelper(p0, q0);
		int[] z = multiplyHelper(p1, q1);

		return add(add(u, timesXpow(subtract(subtract(y, u), z), (n/2))), timesXpow(z, 2*(n/2)));
		

	}

	public int[] multiply(int[] p, int[] q){

		if(p.length != q.length){
			int[] err = {-1};
			return err;
		}

		return multiplyHelper(p, q);
	}

	public int getMultiplications(){
		return multiplications;
	}

	public int getAdditions(){
		return additions;
	}
}