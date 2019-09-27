
public class sortBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str = "RRGGBB";

sortBalls(str);
	}
	
	public static void sortBalls(String str){
		
		char [] chArr = str.toCharArray();
		boolean flag=false;
		int i=0;
		int j=chArr.length-1;
		int rCount=0;
		int bCount=chArr.length-1;
		while(i<=j){
			
//		while(i<chArr.length && chArr[i]=='R'){
//			i++;
//		}
//		while(j<chArr.length &&chArr[j]=='B'){
//			j--;
//		}
			while(i<chArr.length && chArr[i]!='R'){
				i++;
				if(i<chArr.length && chArr[i]=='R'){
					swap(chArr,i,rCount);
					flag=true;
					rCount++;
				}
					
			}
			
			
			//i++;
			
			while(j>=0 && chArr[j]!='B'){
				j--;
				if(j>=0  && chArr[j]=='B'){
					swap(chArr,j,bCount);
					flag=true;
					bCount--;
				}
			}
			
			if (flag == false){
				break;
			}
			
		//	j--;
			
			//if(i<=j){
			//	swap(chArr,i,j);
			}
		}
	
	
	public static void swap(char[] chArr, int i, int j){
		char swap =chArr[i];
	chArr[i]=chArr[j];
	chArr[j]=swap;
	}

}
