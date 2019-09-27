
public class isPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 1;int b=4; int c=5; int d=9;
    boolean res = isPossible(a,b,c,d);
    //(1,2) -->(3,2)
	}

	
	public static boolean isPossible(int a, int b, int c,int d){
		boolean rs=false;
		int sumL= 0;
		int sumR =0;
		while(sumL<=c && sumR<=d  ){
		   sumL= findSum(a,b);
		   sumR= findSum(a,b);
		   if(sumL==c && sumR==d){
			   rs=true;
			   return rs;
		   }
		}
		return rs;
	}
	
	public static findSum(int a, int b){
		
		return
	}
}
