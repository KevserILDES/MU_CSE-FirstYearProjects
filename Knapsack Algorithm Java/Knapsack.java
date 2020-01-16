import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class Knapsack {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Time before reading
		Instant start = Instant.now();
		File f=new File("1.txt");
		Scanner input=new Scanner(f);
		PrintWriter pw=new PrintWriter(new File("output-test1d.dat"));
		
		//Read input file
		int numOfItems=input.nextInt();
		int weight=input.nextInt();
		int[] valIt=new int[numOfItems];
		int[] wIt=new int[numOfItems];
		int i=0;
		while(input.hasNext()){
			valIt[i]=input.nextInt();
			wIt[i]=input.nextInt();
			i++;			
		}
		//Time after reading
		Instant start2 = Instant.now();
		
		double[][] rate=new double[2][numOfItems];
		double temp1,temp2; //For sorting rate array according to second dimension
		//Find rates of items
		for(i=0;i<numOfItems;i++){
			rate[0][i]=i;
			rate[1][i]=(double)valIt[i]/wIt[i];
		}
		int j;
		//Sort rate array
		for(i=1;i<numOfItems;i++) {
			temp1=rate[0][i];
			temp2=rate[1][i];
			for(j=i-1;j>=0 && rate[1][j]<temp2;j--) {
				rate[1][j+1]=rate[1][j];
				rate[0][j+1]=rate[0][j];
			}
			rate[1][j+1]=temp2;
			rate[0][j+1]=temp1;
		}
		//Time for knapsack method (to compare with optimal, explained in report)
		Instant start3 = Instant.now();
		//Call knapsack method to find total value
		int val=sack(rate,weight,valIt,wIt,0);
		Instant finish3 = Instant.now();
		//Find which items are used
		int[] temps=new int[c+1];
		for(i=0;i<c+1;i++)
			temps[i]=(int)rate[0][i];
		//Sort items according to no's
		Arrays.sort(temps);
		//Time before writing
		Instant finish2 = Instant.now();
		//Write to output file
		pw.println(val);
		for(i=0,j=0;i<numOfItems && j<c+1;i++) {
			if(temps[j]==i) {
				pw.println(1);
				j++;
			}
			else
				pw.println(0);
		}
		pw.flush();
		input.close();
		pw.close();	
		//Time after writing
		Instant finish = Instant.now();
		//Find and print corresponding execution times
		long timeElapsed = Duration.between(start, finish).toMillis();
		long timeElapsed2 = Duration.between(start2, finish2).toMillis();
		long timeElapsed3 = Duration.between(start3, finish3).toMillis();
		System.out.println("Time btw before reading and after writing ,in Millis, is : "+timeElapsed);
		System.out.println("Time btw after reading and before writing ,in Millis, is : "+timeElapsed2);
	}   

	static int c;
	//Method for knapsack (finding total value)
	public static int sack(double[][] r,int W,int[] v,int[] w,int i) {
		if(W==0 || W-w[(int)r[0][i]]<0)
			return 0;
		c=i;
		return v[(int)r[0][i]]+sack(r,W-w[(int)r[0][i]],v,w,i+1);
	}

}
