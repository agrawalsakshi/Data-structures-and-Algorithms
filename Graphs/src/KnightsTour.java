
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//import java.awt.Point;



public class KnightsTour {
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [][] chessboard = new int [7][7];
        
        int startX =0;
        int startY=0;
   		int endX=7;
   		int endY=7;
   		
   		findMinMoves(chessboard,startX,startY,endX,endY);
        		
	}
	
	public static int findMinMoves(int [][]chessboard,int startX,int startY,int endX,int endY){
		int[][] visited = new int[8][8];
		Map<java.awt.Point, java.awt.Point> map = new HashMap<java.awt.Point, java.awt.Point>();
		//int [][] neighbour= new int 
		map.put(new java.awt.Point(startX,startY), null);
		int count=0;
		for(int row=startX;row<chessboard.length;row++){
			for(int column =startY;column<chessboard[0].length;column++){
				if(visited[row][column]==0){
				count=	exhaust_cc(visited,row,column,endX,endY,map);
				}
			}
		}
		return count;
	}
	
	public static int exhaust_cc(int [][]visited,int row,int column,int endX,int endY, Map<java.awt.Point, java.awt.Point> map){
//		if(row==endX && column==endY){
//			System.out.println("found");
//			System.out.println(count);
//			return;
//		}
		if(visited[row][column]==1){
			return 0;
		}
		Queue<java.awt.Point> queue = new LinkedList();
		visited[row][column]=1;
		int [] rowNum ={2,2,1,1,-1,-1,-2,-2};
		int [] columnNbr={-1,1,-2,2,-2,2,-1,1};
		queue.add(new java.awt.Point(row,column));
		
	int count=0;
		while(queue.size()>0){
			
			java.awt.Point cur = queue.poll();
			if(cur.getX()==endX && cur.getY()==endY){
				java.awt.Point at = new java.awt.Point((int)cur.getX(), (int)cur.getY());
				while(at!=null){
					System.out.print(at.getX()+","+at.getY()+"   ");
					
					at= map.get(at);
					count= count+1;
					
				}
				System.out.println();
				System.out.print("count :"+count);
			}
			for(int k=0;k<8;k++){
				if(cur.getX()+rowNum[k]>=0 && cur.getX()+rowNum[k]<=7 && cur.getY()+columnNbr[k]>=0 && cur.getY()+columnNbr[k]<=7){
					if(!((visited[(int) (cur.getX()+rowNum[k])][(int) (cur.getY()+columnNbr[k])])==1)){
					visited[(int) (cur.getX()+rowNum[k])][(int) (cur.getY()+columnNbr[k])]=1;
					map.put(new java.awt.Point((int) (cur.getX()+rowNum[k]),(int) (cur.getY()+columnNbr[k])), new java.awt.Point((int)cur.getX(),(int)cur.getY()));
					queue.add(new java.awt.Point((int) (cur.getX()+rowNum[k]),(int) (cur.getY()+columnNbr[k])));
//					count=count+1;
//					exhaust_cc(visited,row+rowNum[k],column+columnNbr[k],endX,endY,count);
//					count=count-1;
					}
					
				}
			}
		}
		return count;
		
	}
}
	
	


