// https://stackabuse.com/sorting-algorithms-in-java/

/* Bubble Sort:
The reason this algorithm is called Bubble Sort is because 
all numbers move to their respective places bit by bit, left to right, 
like bubbles slowly rising from a body of water.

Time Complexity: O(n^2). because while loop can run the maximum of n times in worst case.
*/
public static void bubbleSort(int[] nums){
  boolean swap1 = true; //check if the swap happened or not.
  int temp = 0;
  
  while (swap1) {
    swap1 = false;
    
    for (int i = 0; i < nums.length-2; i++){
      if (nums[i] > nums[i+1]){ // >, not >=, the "=" would cause to infinite swap
        temp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = temp;
        swap1 = true;       
      }      
    }//end for    
  }//end while
}

//----------------------------------------------------------------------------------------------
/* Insertion Sort:
Insert one element from unsorted part (right) to sorted part (left) in a proper place at a time.

Time Complexity: O(n^2).
*/
public static void insertionSort(int[] nums){
  for (int i = 1; i < nums.length; i++) {
    int current = nums[i];
    int j = i - 1;   //i -> ritht, j -> left
    //compare value for nums[j] (and nums[i]), but update value nums[j+1]
    while (j >= 0 && nums[j] > current) {
      nums[j+1] = nums[j]; 
      j--;
    }
    //update value nums[j+1]
    nums[j+1] = current;
  } 
}

//-----------------------------------------------------------------------------------------------------
/* Selection Sort:
Select the minimum number from unsorted part (right), to the current position for the current iteration.

Time Complexity: O(n^2). 
*/
public static void selectionSort(int[] nums) {
  int min;
  int minIndex;
  int temp;
  
  for (int i = 0; i < nums.length; i++) {
    min = nums[i];
    minIndex = i;
    //find the min in unsorted part
    for (int j = i + 1; j < nums.length; j++) {
      if (nums[j] < min) {
        min = nums[j];
        minIndex = j;
      }
    }//end for
    //swap
    temp = nums[i];
    nums[i] = nums[minIndex]; //not nums[i] = nums[j] because j is always = (length-1)
    nums[minIndex] = temp;    
  }  
}

