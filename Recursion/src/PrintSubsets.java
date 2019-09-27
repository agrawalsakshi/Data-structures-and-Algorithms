

public class PrintSubsets {
// print subsets of a set
	/*public static void main(String[] args) {
		
		         Enter your code here. Read input from STDIN. Print output to STDOUT 
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        //sc.nextLine();
		        Set<Object> set = new HashSet<Object>();
		        for(int i=0;i<n;i++){
		           // int element = sc.nextInt();
		            set.add(sc.next());
		        }
		        sc.close();
		        Set<Object> output = new HashSet<Object>();
		        printSubsets(set,output);
}
	
public static void printSubsets(Set input, Set output){
		if(input.isEmpty()) {
			printSubsets(output);
			return;
		}
		//Iterator itr = input.iterator();
		Object next =  input.iterator().next();
		input.remove(next);
		printSubsets(input,output);
		output.add(next);
		printSubsets(input,output);
		boolean element = output.remove(next);
		input.add(next);
	}
	
	public static void printSubsets(Set output){
		if(output.isEmpty()){
			System.out.print("{"+""+"}");
		}
		else{
		Iterator itr = output.iterator();
		System.out.print("{");
		while(itr.hasNext()){
			System.out.print(itr.next());
			
		}
		System.out.print("}");
		}
		System.out.println();
	}
*/
	
	
	/// ==================================== code to find elements in array if equal to given sum

//	
//	public static boolean result=false;
//public static void main(String[] args){
//	Scanner scan = new Scanner(System.in);
//	int n = scan .nextInt();
//	int [] arr = new int [n];
//	for(int i=0;i<n;i++){
//		arr[i]=scan.nextInt();
//	}
//	int target = scan.nextInt();
//	scan.close();
//	
//	 findElements(arr,target);
//	//System.out.println(result);
//}
//
//public static void findElements(int[]arr,int target){
//	
//	Set output=new HashSet();
//	Set input = new HashSet();
//	for(int i=0;i<arr.length;i++){
//		input.add(arr[i]);
//	}
//	
//	findCombinations(input,output,target);
//	//return r;
//}
//
//public static void findCombinations(Set input, Set output, int target){
//	//boolean result= false;
//	if(input.isEmpty()  ){
//		if(!output.isEmpty() && result== false){
//		checkSum(output,target);
//		
//		}
//		return;
//	}
//	int next = (int) input.iterator().next();
//	input.remove(next);
//	findCombinations(input, output,target);
//	output.add(next);
//	findCombinations(input,output,target);
//	output.remove(next);
//	 input.add(next);
//	// return result;
//	
//}
//
//public static void checkSum(Set output,int target){
//	
//		int sum =0;
//		Iterator itr = output.iterator();
//		while(itr.hasNext()){
//			sum = sum + (int)itr.next();
//		}
//		if(sum == target){
//			result = true;
//			System.out.println(result);
//			//return result;
//		}
//	
//	else result= false;
//}
//
//
//	
//	}

// =============================program to print all subsets in an array
    
public static void main(String [] args){
	
	int[] inputArr ={3,5,6,7};
	
	int[] outputArr=new int[inputArr.length];
	
	printSubsets(inputArr,0,outputArr,0);
}

public static void printSubsets(int[] inputArr, int inputSize, int[] outputArr, int outputSize){
	
	if(inputSize>=inputArr.length){
		print(outputArr,outputSize);
		return;
	}
	int element = inputArr[inputSize++];	
	printSubsets(inputArr,inputSize,outputArr,outputSize);
	
	outputArr[outputSize++]=element;
	printSubsets(inputArr,inputSize,outputArr,outputSize);
	
	outputSize--;
	inputSize++;
	
	
}

public static void print(int[] arr, int times){
	for (int i=0;i<times;i++){
		if(arr[i]==0){
			i++;
		}
		else{
		System.out.print(arr[i]);
		//i++;
		
		}
	}
	System.out.println();
}
}
	

//[]
//a b c d
//d
//c cd
//b bd bc bcd
//a ad ac acd ab abd abc abcd
	
	
	
	
	

