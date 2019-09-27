
public class TowerOfHanoi {

//	Step 1 − Move n-1 disks from source to aux
//	Step 2 − Move nth disk from source to dest
//	Step 3 − Move n-1 disks from aux to dest
//	IF disk == 1, THEN
//		      move disk from source to dest             
//		   ELSE
//		      Hanoi(disk - 1, source, aux, dest)     // Step 1
//		      move disk from source to dest          // Step 2
//		      Hanoi(disk - 1, aux, dest, source)     // Step 3
//		   END IF
//		   
//		END Procedure
//		STOP
	
	public static void main(String[] args) {
		
	   	 int n = 4;
	    String source="source";
	    String destination ="destination";
	    String aux="aux";
	    hanoi(3, source,destination,aux);
	   //	 String StepsToSolution;
	    
	   //	 StepsToSolution = hanoi(n, 1, 3);
	    
	 //  	 System.out.println(StepsToSolution);
	      }
	
	public static void hanoi(int disks, String source, String destination, String aux) {
		if(disks ==1) {
			//System.out.println("Inside if");
			System.out.println("Move disk 1 from "+source + " to "+destination);
		}
		else {
		hanoi(disks-1,source,aux,destination);
		System.out.println("Move disk "+disks+" from "+source + " to "+destination);
		hanoi(disks-1,aux,destination,source);
		}
		
	}

//	 public static String hanoi(int nDisks, int fromPeg, int toPeg)
//     {
//  	 int helpPeg;
//  	 String Sol1, Sol2, MyStep, mySol;   // Contains moves
//   
//  	 if ( nDisks == 1 )
//	 {
//  	    return fromPeg + " -> " + toPeg + "\n";
//	 }
//  	 else
//  	  {
//  	    helpPeg = 6 - fromPeg - toPeg;    // Because fromPeg + helpPeg + toPeg = 6    
//
//  	    Sol1 = hanoi(nDisks-1, fromPeg, helpPeg);    
//                                                        
//  	    MyStep = fromPeg + " -> " + toPeg + "\n";    
//                                                        
//  	    Sol2 = hanoi(nDisks-1, helpPeg, toPeg);      
//
//	    mySol = Sol1 + MyStep + Sol2;     // + = String concatenation !
//   
//  	    return mySol;
//  	  }
//     }

}
