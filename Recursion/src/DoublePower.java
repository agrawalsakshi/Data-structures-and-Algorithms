import java.util.Scanner;

public class DoublePower {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double num = scan.nextDouble();
		int p = scan.nextInt();
		scan.close();
		
		double r= calcResult(num,p);
		System.out.println(r);
	}
	
	public static double calcResult(double num ,int p) {
		if(p==0) {
			return 1;
		}
		
		else if(p>0) {
			return num * calcResult(num,p-1);
		}
		else  {
			return (1/num) * calcResult(num, p+1);
		}
	}

}
