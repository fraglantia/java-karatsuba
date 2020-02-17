package PolynomialsBF;

public class BFPolynomialsMultiplier{

	int multiplications;
	int additions;

	public BFPolynomialsMultiplier(){
		multiplications = 0;
		additions = 0;
	}

	public int[] multiply(int[] p, int[] q){

		if(p.length != q.length){
			int[] err = {-1};
			return err;
		}

		int n = p.length-1;
		int[] product = new int[n*2+1];

		for(int i=0; i<=n*2; i++){
			product[i] = 0;
		}

		for(int i=0; i<=n; i++){
			for(int j=0; j<=n; j++){
				product[i+j] += p[i]*q[j];
				
				additions += 1;
				multiplications += 1;
			}
		}

		return product;
	}

	public int getMultiplications(){
		return multiplications;
	}

	public int getAdditions(){
		return additions;
	}
}