
public class mergeArrays {
	
	public static void main(String[] args){
		int[] shortar = {1,4,5};
		int k=0;
		int[] longar ={2,3,6,0,0,0};
		
//		for(int i=0;i<longar.length;i++ ){
//			if(longar[i]==0){
//				longar[i]=shortar[k];
//				k++;
//			}
		domerge(shortar,longar);
		}
		
		public static void domerge(int[] shortar, int [] longar){
			
			int i= shortar.length-1;
			int j = longar.length-1;
			int k = shortar.length-1;
			while(i>=0 && k>=0){
				if(shortar[i]>longar[k]){
					longar[j]=shortar[i];
					j--;
					i--;
				}
				if(longar[k]>shortar[i]){
					longar[j]=longar[k];
					longar[k]=0;
					j--;
					k--;
				}
			}
			if(k<0){
				while(i>=0){
				longar[j]=shortar[i];
				i--;
				j--;
				}
			}
			
			if(i<0){
				while(k>=0){
					longar[j]=longar[k];
					k--;
					j--;
				}
			}
			
		}
	}


