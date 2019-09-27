
public class printSnakeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      String str ="Google Worked";
//      char [] [] arr = new char [str.length()] [3];
//      int i=0;int k=0;int j=0;
//     
//      while(i<str.length()){
//    	  String str1="";
//          String str2="";
//    	  for(j=i+1;j<=2;j++){
//    		  str1=str1+" ";
//    		  if(i<str.length()){
//    		  System.out.println(str1+str.charAt(k));
//    		  }
//    		  k++;i++;
//    	  }
//    	  for(j=1;j>=0;j--){
//    		  str2=str2+" ";
//    		  if(i<str.length()){
//    		  System.out.println(str1+str.charAt(k));
//    		  k++;i++;
//    		  }
//    	  }
//      }
//      
//     // for(i=0;i<)
//	}
		int num = 4;
		for (double y = 2; y >= 0; y-=0.4) {
		  for (double x = 0; x <= num; x+=0.4) {
		    if ( (0.1+x >= Math.asin(y-1)) && (x-0.1 <= Math.asin(y-1)) ||
		    	     (0.1+x >= Math.PI - Math.asin(y-1)) && (x-0.1 <= Math.PI - Math.asin(y-1)) ||
		    	     (2*Math.PI -(0.1 + x) <= -Math.asin(y-1)) && (2*Math.PI -(x-0.1) >= -Math.asin(y-1))  )
		      System.out.print('*');
		    else
		      System.out.print(' ');
		  }
		  System.out.println();
		}
	}	
}
