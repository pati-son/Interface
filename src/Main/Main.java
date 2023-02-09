package Main;
import Matrix.*;

public class Main {

	public static void main(String[] args) {
		
		long time1 = System.currentTimeMillis();
		IMatrix m1 = new SparseMatrix (100, 100);
		IMatrix m2 = new SparseMatrix(100, 100);
		
		for(int i = 0; i < 100; i++) 
			for(int j = 0; j < 100; j++) 
				if(i == j) {
					m1.setElement(i, j, 1);
					m2.setElement(i,  j,  1);
				}
		//System.out.println(m1);
		m1 = m1.product(m2);
		
		long time2 = System.currentTimeMillis();
		time1 = time2 - time1;
		
		System.out.println("TIME: " + time1);
		
		long time3 = System.currentTimeMillis();
		IMatrix m3 = new SparseMatrix2 (100, 100);
		IMatrix m4 = new SparseMatrix2 (100, 100);
		for(int i = 0; i < 100; i++) 
			for(int j = 0; j < 100; j++) 
				if(i == j) {
					m3.setElement(i, j, 1);
					m4.setElement(i, j, 1);
				}
		
		m3 = m3.product(m4);
		long time4 = System.currentTimeMillis();
		time3 = time4 - time3;
		System.out.println("TIME: " + time3);
		//IMatrix msum1 = m2.sum(m1);
		//IMatrix msum2 = m3.sum(m1);
		//System.out.println(msum1.equals(msum2));
		
		/*IMatrix mprod1 = m2.product(m1);
		IMatrix mprod2 = m3.product(m1);
		System.out.println(mprod1.equals(mprod2));*/
	}

}
