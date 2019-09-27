import java.util.Scanner;

//nailed
//n4d , na3d,n3ed,n2led,na2ed,nai2d
//batch
//b3h,ba2h,b2ch
public class Neuronyms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan = new Scanner(System.in);
      String str = scan.nextLine();
      scan.close();

      for(int count=2; count<=(str.length()-2); count++)
		{
			for(int j=1; j+count<=(str.length()-1); j++)
			{
				System.out.print( str.substring(0, j) );
				System.out.print( count );
				System.out.print( str.substring(j+count, str.length()  ) );
				System.out.print( "\n" );
			}
		}
	}

}
