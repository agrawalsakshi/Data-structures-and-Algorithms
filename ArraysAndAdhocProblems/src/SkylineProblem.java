import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

//You are given a set of nn rectangles in no particular order. They have varying widths and heights,
//but their bottom edges are collinear, so that they look like buildings on a skyline. 
//For each rectangle, you’re given the x position of the left edge, the x position of the right edge, and the height.
//Your task is to draw an outline around the set of rectangles so that you can see
//what the skyline would look like when silhouetted at night.

//https://github.com/andreimaximov/algorithms/blob/master/leetcode/algorithms/skyline/Solution.java
// Break each building in critical points
//sort the critical points
//build skyline and treeset to keep track of largest height
class CriticalPoint{
	int x;
	int height;
	boolean isStart;
	
	public CriticalPoint(int x, int height, boolean isStart){
		//2,10,true  9,10,false
		this.x=x;
		this.height=height;
		this.isStart=isStart;
	}
}	
	  class criticalPointComparator implements Comparator<CriticalPoint>{

		@Override
		public int compare(CriticalPoint o1, CriticalPoint o2) {
			// TODO Auto-generated method stub
			if(o1.x != o2.x){	
			return o1.x-o2.x;
		}
			else if(o1.isStart && o2.isStart){
				return o2.height-o1.height;
			}
			
			else if( !o1.isStart && !o2.isStart){
				return o1.height-o2.height;
			}
			
			else{
				return o1.isStart?-1:1;
			}
		
	}
}
public class SkylineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//start,height,end
	//	{1,10,8},{5,6,11}
		//{1,5,12},{4,10,8},{6,8,10}
		//{1,11,5},{2,6,7},{3,13,9},{12,7,16},{14,3,25},{19,18,22},{23,13,29},{24,4,28}
		int [][] buildings= {
				{2,10,9},{3,15,7},{5,12,12},{15,10,20},{19,8,24}
		};
		
		getSkyLine(buildings);
	}
	
	public static void getSkyLine(int[][] buildings){
		
		ArrayList<CriticalPoint> criticalPointsList = new ArrayList<CriticalPoint>();
		for(int[] building:buildings){
			criticalPointsList.add(new CriticalPoint(building[0],building[1],true));
			criticalPointsList.add(new CriticalPoint(building[2],building[1],false));
		}
		Collections.sort(criticalPointsList,new criticalPointComparator());
		
		List<int[]> skyline = new ArrayList<int[]>();
		TreeSet<Integer> heightSet = new TreeSet<Integer>();
		
		for(int i=0;i<criticalPointsList.size();i++){
			if(criticalPointsList.get(i).isStart){
				if( heightSet.isEmpty() || heightSet.last()<criticalPointsList.get(i).height){
					skyline.add(new int[] {criticalPointsList.get(i).x,criticalPointsList.get(i).height});
				}
				heightSet.add(criticalPointsList.get(i).height);
			}
			else if(! criticalPointsList.get(i).isStart){ 
				heightSet.remove(criticalPointsList.get(i).height);
				
				if(!heightSet.isEmpty() && criticalPointsList.get(i).height > heightSet.last())
					skyline.add(new int[] {criticalPointsList.get(i).x,heightSet.last()});
				else if (heightSet.isEmpty())
					skyline.add(new int[] {criticalPointsList.get(i).x,0});
			}
		}
		
		for(int[] arr: skyline){
			System.out.print(arr[0]+","+ arr[1]+"  ");
		}
		
		
	}


}


