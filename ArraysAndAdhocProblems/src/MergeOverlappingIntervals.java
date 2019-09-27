import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	
	public Interval(int start, int end){
		this.end=end;
		this.start=start;
	}
	
	
}

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Interval[] arr = new Interval[6];
       ArrayList<Interval> mergedarr = new ArrayList<Interval>();
       int k=0;
       arr[0]=new Interval(2,4);
       arr[1]=new Interval(1,3);
       arr[2]=new Interval(5,6);
       arr[3]=new Interval(6,8);
       arr[4]=new Interval(7,9);
       arr[5]=new Interval(15,25);
       
       
       Arrays.sort(arr, new Comparator<Interval>(){

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
    	   
       });
     //  mergedarr.add(arr[0]);
       int index=0;
       for(int i=0;i<arr.length;i++){
    	   if(index!=0 && arr[i].start<=arr[index-1].end){
    		   
    			   arr[index-1].start=Math.min(arr[index-1].start,arr[i].start);
    			   arr[index-1].end = Math.max(arr[i].end,arr[index-1].end);
    			   index--;
    		//   mergedarr.add(new Interval(arr[i-1].start,Math.max(arr[i-1].end,arr[i].end)));
    		//   k++;
    		 //  }
    	   }
    	   
    	   else{
    		   arr[index]=arr[i];
    		   
    		  // mergedarr.add(arr[i]);
    		  // k++;
    	   }
    	   index++;
    	
       }
       for(int i=0;i<index;i++)
    	   System.out.println(arr[i].start+","+arr[i].end);
	}
	
	

}
