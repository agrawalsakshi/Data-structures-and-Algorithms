
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* Given a set of n nuts of different sizes and n bolts of different sizes.
 *  There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
 *  You can choose any nut & any bolt together, from which you can determine whether nut is larger than bolt,smaller than bolt or matches 
 *  the bolt exactly.
 *  However, there is no way to compare 2 bolts together or 2 nuts together.(i.e.,we cannot sort all nuts or sort all bolts 
 *  Every nut has exactly one matching bolt and vice versa*/

public class MatchingNutsAndBolts {
	static int RankNut=0;
	static int RankBolt=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String [] nuts ={"N2","N4","N1","N3"}; 
	String [] bolts ={"B1","B4","B3","B2"}; 
	
	
		matchPairs(nuts,bolts,0,nuts.length-1);
	}
	
	public static void matchPairs(String[] nuts, String[] bolts,int start, int end){
		if(start>end) return;
			RankNut=findRankInNut(nuts,start,end);
			//RankNut=partition(nuts_copy,nuts,0,nuts.length-1);
			
			findRankInBolt(bolts,RankNut,start,end);
			System.out.println(nuts[RankNut]+" "+bolts[RankBolt]);
			matchPairs(nuts,bolts,start,RankNut-1);
			matchPairs(nuts,bolts,RankNut+1,end);
			
				}
			
	public static int findRankInNut(String[] nuts,int start,int end){
		return partition(nuts,start,end);
	}
	
	public static void findRankInBolt(String[] bolts, int rank, int start, int end){
		 RankBolt =partition(bolts,start,end);
		
		 if( RankBolt>rank){
			findRankInBolt(bolts,rank,start,RankBolt-1);
		}
		else if(RankBolt<rank){
			findRankInBolt(bolts,rank,RankBolt+1,bolts.length-1);
		}
	
		
	}
	
	public static  int partition(String [] arr, int start,int end){
		
//		String pivot = arr[start]; // taking first element as pivot 
//		while (start <= end) { //searching number which is greater than pivot, bottom up
//			while (start<end && arr[start].compareToIgnoreCase(pivot)<=0) {
//				start++; } //searching number which is less than pivot, top down 
//			while (start<end && arr[end].compareToIgnoreCase(pivot)>0) { 
//				end--; 
//				} // swap the values 
//			if (start < end) {
//				String tmp = arr[start];
//				arr[start] = arr[end];
//				arr[end] = tmp; //increment left index and decrement right index
//				start++; 
//				end--;
//				}
//			} 
//		return start; 
//		
//			
//		}

		//Read more: http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html#ixzz4ewb3pjuw
	String pivotElement = arr[start];
		int left = start+1;
		int right = end;
		while(left<=right){
			while(left<=right && arr[left].compareToIgnoreCase(pivotElement)<=0){
				left++;
			}
			while(left<=right && arr[right].compareToIgnoreCase(pivotElement)>0){
				right--;
			}
			if(left<right){
				String swap =  arr[left];
				arr[left]=arr[right];
				arr[right]=swap;	
			}
		}
		
		String swap = arr[start];
		arr[start]=arr[right];
		arr[right]=swap;
	
		return right;
	}	
		
	}
	


