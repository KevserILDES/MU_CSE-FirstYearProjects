import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class mul {
	static int knoi;
	static int noi;
	static PrintWriter pw2;

	public static void main(String[] args) throws FileNotFoundException {
		Instant start = Instant.now();
		System.out.println("I couldnot create output file in right format, So I have 2 output files\nFile named \"outputItems\" is the one I cretaed to show which items are used for which knapsacks\n");
		int i;
		PrintWriter pw=new PrintWriter("output-test2e.dat");
		pw2=new PrintWriter("outputItems.dat");
		Scanner input=new Scanner(new File("2.txt"));
		noi=input.nextInt();
		knoi=input.nextInt();
		int[][] ws=new int[2][knoi];
		int[] v=new int[noi];
		int[] w=new int[noi];
		for(i=0;i<knoi;i++) {
			ws[0][i]=i;
			ws[1][i]=input.nextInt();
		}
		for(i=0;i<noi;i++) {
			v[i]=input.nextInt();
			w[i]=input.nextInt();
		}
		Instant start2 = Instant.now();

		double[][] rate=new double[2][noi];
		for(i=0;i<noi;i++) {
			rate[0][i]=i;
			rate[1][i]=(double)v[i]/w[i];
		}
		int j;
		double temp1,temp2;
		int t1,t2;
		for(i=1;i<noi;i++) {
			temp1=rate[0][i];
			temp2=rate[1][i];
			for(j=i-1;j>=0 && rate[1][j]<temp2;j--) {
				rate[1][j+1]=rate[1][j];
				rate[0][j+1]=rate[0][j];
			}
			rate[1][j+1]=temp2;
			rate[0][j+1]=temp1;
		}
		int[] vs=new int[knoi];
		pw2.println("For unsorted weights");
		pw2.println("------------------------");
		for(i=0;i<knoi;i++) {
			pw2.println("Items used in knapsack with weight "+ws[1][i]+" are: ");
			vs[i]=sack(rate,ws[1][i],v,w,i);
			pw2.println("\n-----------------------\n");
		}

		int sv[]= {0,0};
		for(i=0;i<knoi;i++) {
			sv[0]+=vs[i];
		}
		for(i=1;i<knoi;i++) {
			t1=ws[0][i];
			t2=ws[1][i];
			for(j=i-1;j>=0 && ws[1][j]<t2;j--) {
				ws[1][j+1]=ws[1][j];
				ws[0][j+1]=ws[0][j];
			}
			ws[1][j+1]=t2;
			ws[0][j+1]=t1;
		}
		pw2.println();
		pw2.println("For sorted weights");
		pw2.println("------------------------");
		for(i=0;i<knoi;i++) {
			pw2.println("Items used in knapsack with weight "+ws[1][i]+" are: ");
			vs[i]=sack(rate,ws[1][i],v,w,i);
			pw2.println("------------------------");
		}
		for(i=0;i<knoi;i++) {
			sv[1]+=vs[i];
		}	
		int tm=Math.max(sv[0], sv[1]);
		pw2.println("Total value for unsorted weights: "+sv[0]);
		pw2.println("Total value for sorted weights: "+sv[1]);
		Instant finish2 = Instant.now();
		pw.println(tm);
		pw.flush();
		pw2.flush();
		input.close();
		pw.close();
		pw2.close();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		long timeElapsed2 = Duration.between(start2, finish2).toMillis();
		System.out.println("Time btw before reading and after writing ,in Millis, is : "+timeElapsed);
		System.out.println("Time btw after reading and before writing ,in Millis, is : "+timeElapsed2);
		

	}
	static int c;
	public static int sack(double[][] r,int W,int[] v,int[] w,int i) {
		if(i+knoi<noi) {
			if(W==0 || W-w[(int)r[0][i]]<0)
				return 0;
			c=i;
			pw2.println("no: "+(int)r[0][i]+" val: "+v[(int)r[0][i]]+" w: "+w[(int)r[0][i]]);
			return v[(int)r[0][i]]+sack(r,W-w[(int)r[0][i]],v,w,i+knoi);
		}
		return 0;
	}

}
