#include <stdio.h>
#include <string.h>
#include <math.h>
#define INFINITY 9999

int main(){
	char fileName[15];
	char dataType[25];
	char bytOrdType[20];
	int size=0,n=0;
	printf("Enter the name of the file in format \"input.txt\" : ");
	scanf("%s",fileName);
	printf("Enter the byte ordering type : ");
	scanf("%s",bytOrdType);
	printf("Enter the data type : ");
	scanf("%s",dataType);
	printf("Enter the size for %s : ",dataType);
	scanf("%d",&size);

	FILE *f=fopen(fileName,"r");
	n=2*size+(size-1);
	int a=n,i=0;
	char num[n];
	int no[2*size];
	int bin[2*size*4];
	while(!feof(f)){
		i=0;
		while(a){
			num[i]=getc(f);
			i++;
			a--;
		}a=n;i=0;
		int j=0;
		while(a && i<2*size){
			switch(num[j]){
				case 'a' : no[i]=10; break;
				case 'b' : no[i]=11; break;
				case 'c' : no[i]=12; break;
				case 'd' : no[i]=13; break;
				case 'e' : no[i]=14; break;
				case 'f' : no[i]=15; break;
				default :  if(num[j]<='9' && num[j]>='0'){ no[i]=(int)(num[j]-'0'); }else {
					j++; continue;
				} break; 
			}
			i++;
			j++;
			a--;
		}
		a=n;
		if(strcmp(bytOrdType,"Big")==0){
			i=0;
			j=0;
			int g;
			while(i<2*size,j<2*size*4){

				bin[j+3]=no[i]%2;
				no[i]/=2;
				bin[j+2]=no[i]%2;
				no[i]/=2;
				bin[j+1]=no[i]%2;
				no[i]/=2;
				bin[j]=no[i]%2;
				
				i++;;j+=4;
			}
		}
		if(strcmp(bytOrdType,"Little")==0){
			i=2*size-1;
			j=0;
			int g;
			while(i>=0,j<2*size*4){
				bin[j+7]=no[i]%2;
				no[i]/=2;
				bin[j+6]=no[i]%2;
				no[i]/=2;
				bin[j+5]=no[i]%2;
				no[i]/=2;
				bin[j+4]=no[i]%2;
				
				bin[j+3]=no[i-1]%2;
				no[i-1]/=2;
				bin[j+2]=no[i-1]%2;
				no[i-1]/=2;
				bin[j+1]=no[i-1]%2;
				no[i-1]/=2;
				bin[j]=no[i-1]%2;
				
				i-=2;j+=8;
			}
		}
	
		
		if(strcmp(dataType,"floating")==0){
			int expB;
			switch(size){
				case 1: expB=4;  break;
				case 2: expB=6;  break;
				case 3: expB=8;  break;
				case 4: expB=10;  break;
				case 6: expB=12;  break;
				default: exit(0); break;
			}
			int bias=pow(2,expB-1)-1;
			int sign=bin[0];
			int z,o,y;
			int exp[expB];
			for(y=0;y<expB;y++){
				exp[y]=bin[y+1];
				if(bin[y+1]==0) z++;
				else if(bin[y+1]==1) o++;				
			}

			char typ;
			int eNum;
			if(o==10) typ='s';
			else if(z==10) typ='d';
			else typ='n';
			if(typ=='n'){
				for(y=0,z=expB-1;y<expB,z>=0;y++,z--){                                                                    
					if(exp[z]==1){
						eNum+=pow(2,y);
					}
				}
			}
			
			int frac[13];
			int hw,e=0;
			for(y=0;y<13;y++){
				frac[y]=bin[y+expB+1];
			}
			if(bin[12+expB+1]==0){
				hw=-1;
				//goto fin;
			}
			else{
				for(e=y+1;e<32;e++){
					if(bin[e]==1){
						hw=1;
					//	break;
						goto fin;
					}
				}
				hw=0;
				goto fin;						
			}
			int q,x;

			fin:
			switch(hw){
				case -1:break;
				case 0: 
					if(frac[12]==1) frac[12]=0;
					break;
				case 1:
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
							for(q=y+1;q<13;q--){
								frac[q]=0;
							}
						}
					}
					break;
				default: break;
			}
	
			double fNum=0;
			switch(typ){
				case 'n':
					fNum=1; break;
				case 'd':
					fNum=0;
			}
			for(q=0;q<13;q++){
				if(frac[q]==1){
					fNum+=pow(2,(q+1)*-1);
				}
			}
			float numF;
			switch(typ){
				case 'n':
					numF=pow(-1,sign)*fNum*pow(2,eNum-bias); break;			
				case 'd':
					numF=pow(-1,sign)*fNum*pow(2,1-bias); break;
				case 's':
					if(fNum==0){
						if(sign==0){
							numF=INFINITY;
						}
						else{
							numF=INFINITY*-1;
						}
					}
					else{
						numF=1/0;						
					}
					break;
				default:break;
					
			}
			printf("\n%.5f\n",numF);
			
			
				
		
			
						
			
		}
		else if(strcmp(dataType,"signed")==0){
			int numS=0;
			if(bin[0]==0){
				int m,n;
				for(m=2*size*4-1,n=0;m>0,n<2*size*4-1;m--,n++){                                                                    
					if(bin[m]==1){
						numS+=pow(2,n);
					}
				}
			}
			else{
				int m,n;
				for(m=2*size*4-1,n=0;m>0,n<2*size*4-1;m--,n++){                                                                    
					if(bin[m]==1){
						numS+=pow(2,n);
					}
				}
				numS+=pow(2,(-1)*(2*size*4-1));
			}
			printf("\n%d\n",numS);

			
			
		}
		else if(strcmp(dataType,"unsigned")==0){
			int m,n,numU=0;
			for(m=2*size*4-1,n=0;m>=0,n<2*size*4;m--,n++){                                                                    
				if(bin[m]==1){
					numU+=pow(2,n);
				}
			}			
			printf("\n%d\n",numU);
		}

		
		
		
		
		break;
		a=n;
	}
}
