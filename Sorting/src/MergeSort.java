


	
	/* Java program for Merge Sort */
	class MergeSort
	{
		private int[] array;
	    private int[] tempMergArr;
	    private int length;
	//- See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.jP2FJ0CZ.dpuf
		public static void main(String[] args){
		 int[] inputArr = {0,-1,-2,5,4};
		 MergeSort mms = new MergeSort();
	       int [] in= mms.sort(inputArr);
	        for(int i:in){
	            System.out.print(i);
	            System.out.print(" ");
	        }
	    }
	     
	    public int[] sort(int inputArr[]) {
	     //   this.array = inputArr;
	        this.length = inputArr.length;
	        this.tempMergArr = new int[length];
	        doMergeSort(0, length - 1,inputArr);
	        return inputArr;
	    }
	 
	    private void doMergeSort(int lowerIndex, int higherIndex,int[] inputArr) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle,inputArr);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex,inputArr);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex,inputArr);
	        }
	    }
	 
	    private void mergeParts(int lowerIndex, int middle, int higherIndex, int[] inputArr) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = inputArr[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	            	inputArr[k] = tempMergArr[i];
	                i++;
	            } else {
	            	inputArr[k] = tempMergArr[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	        	inputArr[k] = tempMergArr[i];
	            k++;
	            i++;
	        }
	 
	    }
	//- See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.jP2FJ0CZ.dpuf
	}

