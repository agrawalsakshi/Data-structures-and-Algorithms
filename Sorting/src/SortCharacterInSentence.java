
public class SortCharacterInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "The quick brown fox jumps over the lazy dog";
		
		char [] chArray= str.trim().toCharArray();
		
		sort(chArray);
		String output = new String(chArray);
		System.out.println(output);
	//	for(int k=0;k<chArray.length;k++){
		//	System.out.print(chArray[k]+" ");
		//}
	}
	
	public static void sort(char[] chArr){
		int n= chArr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(chArr, n,i);
		}
		
		for(int j=n-1;j>=0;j--){
			char swap=chArr[0];
			chArr[0]=chArr[j];
			chArr[j]=swap;
			heapify(chArr,j,0);
		}
	}
	
	public static void heapify(char[] chArr,int n, int i){
	//	int smallest=i;
		int largest =i;
		int l = 2*i+1;
		int r= 2*i+2;
		if(l<n && chArr[l]>chArr[largest]){
			largest=l;
		}
		if(r<n && chArr[r]>chArr[largest]){
			largest=r;
		}
		if(largest!=i){
			char swap = chArr[i];
			chArr[i]=chArr[largest];
			chArr[largest]=swap;
			heapify(chArr,n,largest);
		}
				
	}

}
