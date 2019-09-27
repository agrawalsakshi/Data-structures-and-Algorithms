

class Point {
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y =y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public  int compare(Point p1, Point p2){
		int diffX = p1.getX()-p2.getX();
		if(diffX ==0){
			return p1.getY()-p2.getY();
		}
		return diffX;
	}

	public boolean compareTo(Point point) {
		// TODO Auto-generated method stub
		int diffX = this.getX()-point.getX();
		if(diffX ==0){
			return this.getY()-point.getY()<0;
		}
		return diffX<0;
	}
}
public class NnearestPointsIn2DSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10, k=5;
		int x=1,  y=2;
		Point P= new Point(0,0);
		Point [] points = new Point[n]; 
		
			points[0]= new Point(2,5);
			points[1]= new Point(7,6);
			points[2]= new Point(4,6);
			points[3]= new Point(4,8);
			points[4]= new Point(10,6);
			points[5]= new Point(3,6);
			points[6]= new Point(1,6);
			points[7]= new Point(6,6);
			points[8]= new Point(2,6);
			points[9]= new Point(9,6);
		
		
		Point [] pointK=sort(points,k);
		for(int i=0;i<k;i++){
			System.out.println(pointK[i].getX() +","+pointK[i].getY());
		}
		
		
	}
	
	public static Point[] sort(Point[] points, int k){
		int n = points.length;
		
		for(int i=n/2-1;i>=0;i--){
			heapify(points,n,i);
		}
		
		//Extract nearest k points
		
		Point [] pointK =extractMin(points,k);
		return pointK;
	}
	
	public static Point[] extractMin(Point[] points, int k){
		Point [] pointK = new Point[k];
		
		for(int i=0;i<k;i++){
			pointK[i]=points[0];
			deleteMin(points);
			heapify(points,points.length,0);
		}
		
		return pointK;
	}
	
	public static void deleteMin(Point[] points){
		for(int i=0;i<points.length-1;i++){
			points[i]=points[i+1];
		}
	}
	
	public static void heapify(Point[] points, int n, int i){
		int smallest=i;
		int l = 2*i+1;
		int r= 2*i+2;
		if(l<n && points[l].compareTo(points[smallest])){
	//	if(l<n && points[l].getX()<points[smallest].getX()){
			smallest=l;
		}
		if(r<n && points[r].compareTo(points[smallest])){
		//if(r<n && points[r].getX()<points[smallest].getX()){
			smallest =r;
		}
		if(smallest!=i){
			Point swap = points[i];
			points[i]=points[smallest];
			points[smallest]=swap;
			heapify(points,n,smallest);
		}
	}

}
