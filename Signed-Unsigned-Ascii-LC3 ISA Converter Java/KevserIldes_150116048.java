import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class KevserIldes_150116048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		/*Kevser ÝLDEÞ
		 * 150116048
		 */
		try {
			//Read data from text file 
			BufferedReader br=new BufferedReader(new FileReader("input.txt"));
			//Create new text file 
			File f=new File("output.txt");
			try {
				String str;
				int i=0;
				//Create a string array
				String[] s=new String[100];
				//Read the input text file line by line and then assign each line to the array's indexes by using while loop
				while((str=br.readLine()) != null){
					//Create a file writer object to write data to the text file
					FileWriter fWriter = new FileWriter(f,true);
					s[i]=str;
					String s1="";
					String s2="";
					if(s[i]!=null){
						//Separate the string array's each indexes from spaces to new two string 
						StringTokenizer st=new StringTokenizer(s[i],"\t",false);
						while(st.hasMoreTokens()){
							//s1 for binary value and s2 for ID  
							s1=String.valueOf(st.nextToken());
							s2=String.valueOf(st.nextToken());
						}
					}
					i++;
					int sum=0;
					//Check if the ID is equal UN
					if(s2.equalsIgnoreCase("UN")){
						//Do the process according to unsigned integer and find the value of the number
						for(i=0;i<16;){
							for(int j=15;j>=0;j--){
								if(s1.charAt(i)=='1')
									sum+=Math.pow(2,j);
								i++;
							}
						}
						String sum1=String.valueOf(sum);
						sum=0;
						//Write the value to the output file
						fWriter.write(sum1+"     ");
						fWriter.close();
					}
					//Check if the ID is equal S1
					if(s2.equalsIgnoreCase("S1")){
						//Do the process according to 1's complement integer and find the value of the number
						for(i=1;i<16;){
							for(int j=15;j>=0;j--){
								if(s1.charAt(0)=='0'){
									if(s1.charAt(j)=='1')
										sum+=Math.pow(2,j);
								}
								else
									if(s1.charAt(i)=='0')
										sum+=Math.pow(2,j);
								i++;
							}
						}
						String sum1=String.valueOf(sum);
						sum=0;
						//Write the value to the output file
						if(s1.charAt(0)=='0')
							fWriter.write(sum1+ "     ");
						else
							fWriter.write("-"+sum1+"     ");
						fWriter.close();
					}					
					//Check if the ID is equal S2
					if(s2.equalsIgnoreCase("S2")){
						//Do the process according to 2's complement integer and find the value of the number
						for(i=0;i<16;){
							for(int j=15;j>=0;j--){
								if(s1.charAt(0)=='0'){
									if(s1.charAt(i)=='1')
										sum+=Math.pow(2,j);
								}
								else
									if(s1.charAt(0)=='1'){
										if(s1.charAt(i)=='0'){
											sum+=Math.pow(2,j);
										}
									}
								i++;
							}
						}
						if(s1.charAt(0)=='1')
							sum++;
						String sum1=String.valueOf(sum);
						sum=0;
						//Write the value to the output file
						if(s1.charAt(0)=='0')
							fWriter.write(sum1+"     ");
						else
							fWriter.write("-"+sum1+"     ");
						fWriter.close();
					}
					//Check if the ID is equal CH
					if(s2.equalsIgnoreCase("CH")){
						//Do the process according to ASCII character and find the corresponding character
						for(i=0;i<16;){
							for(int j=15;j>=0;j--){
								if(s1.charAt(i)=='1')
									sum+=Math.pow(2,j);
								i++;
							}
						}
						char sum1=(char)sum;
						sum=0;
						//Write the character to the output file
						fWriter.write(sum1+"     ");
						fWriter.close();
					}
					//Check if the ID is equal INS
					if(s2.equalsIgnoreCase("INS")){
						//Do the process according to LC-3 instruction 
						//For ADD instruction
						if(s1.substring(0, 4).equals("0001")){
							int dr=0,sr1=0,sr2=0,imm=0;
							for(i=4;i<=6;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										dr+=Math.pow(2,j);
									i++;
								}
							}
							for(i=7;i<=9;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										sr1+=Math.pow(2,j);
									i++;
								}
							}
							if(s1.charAt(10)=='0'){
								for(i=13;i<=15;){
									for(int j=2;j>=0;j--){
										if(s1.charAt(i)=='1')
											sr2+=Math.pow(2,j);
										i++;
									}
								}
							}
							else if(s1.charAt(10)=='1'){
								for(i=11;i<16;){
									for(int j=4;j>=0;j--){
										if(s1.charAt(11)=='0'){
											if(s1.charAt(i)=='1')
												imm+=Math.pow(2,j);
										}
										else
											if(s1.charAt(11)=='1'){
												if(s1.charAt(i)=='0'){
													imm+=Math.pow(2,j);
												}
											}
										i++;
									}
								}
							}
							//Write the format to the output file
							if(s1.charAt(10)=='0')
								fWriter.write("ADD R"+dr+",R"+sr1+",R"+sr2+"     ");
							else if(s1.charAt(10)=='1' && s1.charAt(11)=='0')
								fWriter.write("ADD R"+dr+",R"+sr1+",#"+imm+"     ");
							else if(s1.charAt(10)=='1' && s1.charAt(11)=='1'){
								imm++;
								fWriter.write("ADD R"+dr+",R"+sr1+",#-"+imm+"     ");
							}
							fWriter.close();
							dr=0;
							sr1=0;
							sr2=0;
							imm=0;
						}
						//For AND instruction
						else if(s1.substring(0, 4).equals("0101")){
							int dr=0,sr1=0,sr2=0,imm=0;
							for(i=4;i<=6;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										dr+=Math.pow(2,j);
									i++;
								}
							}
							for(i=7;i<=9;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										sr1+=Math.pow(2,j);
									i++;
								}
							}
							if(s1.charAt(10)=='0'){
								for(i=13;i<=15;){
									for(int j=2;j>=0;j--){
										if(s1.charAt(i)=='1')
											sr2+=Math.pow(2,j);
										i++;
									}
								}

							}
							else if(s1.charAt(10)=='1'){
								for(i=11;i<16;){
									for(int j=4;j>=0;j--){
										if(s1.charAt(11)=='0'){
											if(s1.charAt(i)=='1')
												imm+=Math.pow(2,j);
										}
										else
											if(s1.charAt(11)=='1'){
												if(s1.charAt(i)=='0'){
													imm+=Math.pow(2,j);
												}
											}
										i++;
									}
								}
							}
							//Write the character to the output file
							if(s1.charAt(10)=='0')
								fWriter.write("AND R"+dr+",R"+sr1+",R"+sr2+"     ");
							else if(s1.charAt(10)=='1' && s1.charAt(11)=='0')
								fWriter.write("AND R"+dr+",R"+sr1+",#"+imm+"     ");
							else if(s1.charAt(10)=='1' && s1.charAt(11)=='1'){
								imm++;
								fWriter.write("AND R"+dr+",R"+sr1+",#-"+imm+"     ");
							}
							fWriter.close();
							dr=0;
							sr1=0;
							sr2=0;
							imm=0;
						}
						//For NOT instruction
						else if(s1.substring(0, 4).equals("1001")){
							int dr=0,sr=0;
							for(i=4;i<=6;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										dr+=Math.pow(2,j);
									i++;
								}
							}
							for(i=7;i<=9;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										sr+=Math.pow(2,j);
									i++;
								}
							}
							//Write the character to the output file
							fWriter.write("NOT R"+dr+",R"+sr+"     ");
							fWriter.close();
							dr=0;
							sr=0;
						}
						//For LEA instruction
						else if(s1.substring(0, 4).equals("1110")){
							int dr=0,offset=0;
							for(i=4;i<=6;){
								for(int j=2;j>=0;j--){
									if(s1.charAt(i)=='1')
										dr+=Math.pow(2,j);
									i++;
								}
							}
							for(i=7;i<16;){
								for(int j=8;j>=0;j--){
									if(s1.charAt(7)=='0'){
										if(s1.charAt(i)=='1')
											offset+=Math.pow(2,j);
									}
									else
										if(s1.charAt(7)=='1'){
											if(s1.charAt(i)=='0'){
												offset+=Math.pow(2,j);
											}
										}
									i++;
								}
							}
							if(s1.charAt(7)=='1')
								offset++;
							//Write the character to the output file
							if(s1.charAt(7)=='0')
								fWriter.write("LEA R"+dr+",#"+offset+"     ");
							else
								fWriter.write("LEA R"+dr+",#-"+offset+"     ");
							fWriter.close();
							dr=0;
							offset=0;
						}
					}
				}
				br.close();
			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


