import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/*This program reads a file that consists of hexadecimal numbers and according to users choices converts them 
 *to corresponding decimal values and writes these values to a new file named "output.txt".
 */
public class BinaryConverter {
	/*Kevser İLDEŞ
	 * 150116048
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner cInput=new Scanner(System.in);
		//Create print writer object to write converted numbers to output file
		PrintWriter pw=new PrintWriter(new File("output.txt"));
		String fileName;
		String dataType;
		String bytOrdType;
		int size;
		//Take informations from user
		System.out.print("Enter the name of the file in format \"input.txt\" : ");
		fileName=cInput.nextLine();
		System.out.print("Enter the byte ordering type : ");
		bytOrdType=cInput.nextLine();
		System.out.print("Enter the data type : ");
		dataType=cInput.nextLine();
		System.out.print("Enter the size for "+dataType+" : ");
		size=cInput.nextInt();
		//Create file object to read specified file
		File f=new File(".\\"+fileName);
		String[] num=new String[size];
		Scanner input;
		int n;
		int[] bin=new int[2*size*4];
		try {
			int j=0,fl=0,sg=0,un=0,one=0;
			input = new Scanner(f);
			while(input.hasNext()){
				j=0;
				//read hex numbers from file
				for(int i=0;i<size;i++)
					num[i]=input.next();
				//Little Endian type
				if(bytOrdType.compareToIgnoreCase("Little Endian")==0){
					for(int i=size-1;i>=0;i--){
						for(int k=0;k<2;k++){
							//assign decimal values of hex values
							switch(num[i].charAt(k)){
							case 'a': n=10; break;
							case 'b': n=11; break;
							case 'c': n=12; break;
							case 'd': n=13; break;
							case 'e': n=14; break;
							case 'f': n=15; break;
							default: n=num[i].charAt(k)-'0'; break;
							}
							//convert numbers to binary
							bin[j+3]=n%2;
							n/=2;
							bin[j+2]=n%2;
							n/=2;
							bin[j+1]=n%2;
							n/=2;
							bin[j]=n%2;
							j+=4;
						}
					}
				}
				//Big Endian type
				else if(bytOrdType.compareToIgnoreCase("Big Endian")==0){
					for(int i=0;i<size;i++){
						for(int k=0;k<2;k++){
							//assign decimal values of hex values
							switch(num[i].charAt(k)){
							case 'a': n=10; break;
							case 'b': n=11; break;
							case 'c': n=12; break;
							case 'd': n=13; break;
							case 'e': n=14; break;
							case 'f': n=15; break;
							default: n=num[i].charAt(k)-'0'; break;
							}
							//convert numbers to binary
							bin[j+3]=n%2;
							n/=2;
							bin[j+2]=n%2;
							n/=2;
							bin[j+1]=n%2;
							n/=2;
							bin[j]=n%2;
							j+=4;
						}
					}
				}
				else System.exit(0);
				//print binary values to console
				int m=0;
				for(int i=0;i<2*size*4;i++){
					m++;
					System.out.print(bin[i]);
					if(m==4){
						m=0;
						System.out.print(" ");
					}
				}
				System.out.println();
				//for signed integers
				if(dataType.compareToIgnoreCase("signed integer")==0){
					long numS=0;
					//if sign bit is zero, then convert like unsigned
					if(bin[0]==0){
						numS=ubtd(2*size*4,bin);
					}
					else{
						//else convert as two's complement
						int a,s;
						for(a=2*size*4-1,s=0;a>0 && s<2*size*4;a--,s++){
							if(bin[a]==1){
								numS+=Math.pow(2,s);
							}
						}
						numS-=Math.pow(2,2*size*4-1);

					}
					System.out.println("Signed number : "+numS);
					//write corresponding decimal value to file
					if(sg%(12/size)==0 && sg!=0) pw.println();
					pw.write(numS+" ");
					pw.flush();
					sg++;
				}
				//for unsigned integers
				else if(dataType.compareToIgnoreCase("unsigned integer")==0){
					long numU;
					//call method to calculate decimal value
					System.out.println("Unsigned number : "+(numU=ubtd(2*size*4,bin)));
					//write to file
					if(un%(12/size)==0 && un!=0) pw.println();
					pw.write(numU+" ");
					pw.flush();
					un++;
				}
				//for floating point numbers
				else if(dataType.compareToIgnoreCase("floating point number")==0){
					//find corresponding exponent bit number according to size
					int expB=0;
					switch(size){
					case 1: expB=4;  break;
					case 2: expB=6;  break;
					case 3: expB=8;  break;
					case 4: expB=10;  break;
					case 6: expB=12;  break;
					default: System.exit(0); break;	//for invalid type
					}
					//calculate bias
					int bias=(int)Math.pow(2,expB-1)-1;
					//assign sign bit as first bit of binary number
					int sign=bin[0];
					//find exponent as binary
					int z=0,o=0,y=0;
					int[] exp=new int[expB];
					for(y=0;y<expB;y++){
						exp[y]=bin[y+1];
						if(exp[y]==0) z++;
						else if(exp[y]==1) o++;
					}
					//type of floating point
					char typ;
					double eNum=0;
					//if exponent is all ones assign type as special
					if(o==expB) typ='s';
					//if exponent is all zeros assign type as denormalized
					else if(z==expB) typ='d';
					//if exponent is neither all ones nor all zeros assign type as normalized
					else typ='n';
					if(typ=='n'){
						//calculate exponent as decimal by calling method
						eNum=ubtd(expB,exp);
					}
					//for fraction part
					int[] frac=new int[13];
					int hw=2,e=0;
					//assign length of fraction
					int len= size==1 || size==2 ? 2*size*4-(expB+1) : 13;
					//find fraction part as binary
					for(y=0;y<len;y++){
						frac[y]=bin[y+expB+1];
					}
					//round fraction according to round to even method
					if(size!=1 && size!=2){
						//if less than halfway
						if(bin[y+expB+1]==0){
							hw=-1;
						}
						else{
							for(e=y+expB+1;e<2*size*4;e++){
								//if halfway
								if(bin[e]==1){
									hw=1;
									break;
								}
							}
							//if greater than halfway
							if(hw!=1){
								hw=0;
								break;
							}
						}
						//round fraction
						switch(hw){
						case -1:break;
						case 0:
							if(frac[12]==1) frac[12]=0;
							break;
						case 1:
							int q;
							if(frac[12]==0) frac[12]=1;
							else{
								for(y=11;y>=0;y--){
									if(frac[y]==0){
										e=1;
										break;
									}
								}
								if(e==1){
									frac[y]=1;
									for(q=y+1;q<13;q++){
										frac[q]=0;
									}
								}
							}
							break;
						default: break;
						}
					}
					//calculate fraction part as decimal number according to type
					double fNum=0;
					switch(typ){
					case 'n':
						fNum=1; break;
					case 'd':
						fNum=0; break;
					}
					for(int q=0;q<13;q++){
						if(frac[q]==1){
							fNum+=Math.pow(2,(q+1)*-1);
						}
					}
					//calculate floating point number according to type
					double numF=0;
					switch(typ){
					case 'n':
						numF=Math.pow(-1,sign)*fNum*Math.pow(2,eNum-bias); break;
					case 'd':
						numF=Math.pow(-1,sign)*fNum*Math.pow(2,1-bias); break;
					case 's':
						if(fNum==0){
							if(sign==0){
								numF=Double.POSITIVE_INFINITY;
							}
							else{
								numF=Double.NEGATIVE_INFINITY;
							}
						}
						else{
							numF=Double.NaN;
						}
						break;
					default:break;

					}
					System.out.println(numF);
					//write to file according to size
					if(size!=1){
						if(fl%(12/size)==0 && fl!=0) pw.println();
						String h=numF+" ";
						int g=0;
						if(Double.isFinite(numF) && numF!=0){
							if(numF>0) g=7;
							else g=8;
							int in=h.indexOf('e');
							if(in==-1) in=h.indexOf('E');
							pw.print(h.substring(0, g)+ (in!=-1 ? h.substring(in):""));
						}
						else
							pw.print(numF+" ");
						pw.flush();
						fl++;
					}
					else{
						if(one%12==0 && one!=0){
							one=0;
							pw.println();
						}
						pw.print(numF+" ");
						pw.flush();
						one++;
					}
					pw.print("    ");
					pw.flush();
				}
				//for invalid type
				else System.exit(0);
			}

		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//unsigned binary to decimal
	public static long ubtd(int size,int[] bin){
		int a,s;
		long numU=0;
		for(a=size-1,s=0;a>=0 && s<size;a--,s++)
			if(bin[a]==1){
				numU+=Math.pow(2,s);
			}
		return numU;
	}
}
