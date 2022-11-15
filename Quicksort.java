import java.util.*; 
  
public class QuickSort
{     
    // We will be performing Quicksort with a randomly selected pivot
    
    public static int randompivot(int arr[]) // randomly select index of pivot in array
    { 
        int pivot = (int) (arr.length*Math.random()); 
        return pivot;
    }
      
    // The partition function moves all elements with valuation smaller than pivot before it and bigger after it
    public static int partition(int arr[], int low, int high) 
    { 
        // pivot chosen randomly 
        int pivot = randompivot(arr); 
        pivot = high;
      
        int counter = (low-1); // placeholder to swap higher valuated elements to a position before pivot
        for (int i = low; i <= high; i++) 
        { 
            if (arr[i] < arr[pivot]) // smaller elements get swapped to before the pivot
            { 
                counter++; 
  
                // move arr[i] to arr[counter] via swap
                int temp = arr[counter]; 
                arr[counter] = arr[i]; 
                arr[i] = temp; 
            } 
        }
        
        // by this point, counter+1 is kind of the real pivot
        
        int temp = arr[counter + 1];
        arr[counter+1] = arr[pivot];
        arr[pivot] = temp;
        return counter+1;
    } 
  
  
    // To actually do quicksort on an array arr[] we must call it with low = 0, high = arr.length - 1. 
    static void sort(int arr[], int low, int high) 
    { 
        if (low < high) // then the array still needs sorting
        { 
            int p = partition(arr, low, high); // create partition from random pivot
            sort(arr, low, p-1); // sort left partition
            sort(arr, p+1, high); //sort right partition
        } 
    } 
  
    // Method to print array
    static void printArray(int arr[]) 
    { 
        for (int i = 0; i < arr.length; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
  static boolean test(int n){ // generate random array with size n and elements from 0 to 100, then call quicksort and check if elements are nondecreasing
    int [] arr = new int[n];
      for(int i = 0; i < n; i++)
      {
          arr[i] = (int) (100*Math.random());
      }
      sort(arr, 0, n-1);
      for(int i = 0; i < n-1; i++)
      {
          if(arr[i] > arr[i+1])
            return false; 
      }
      return true;
  }
    public static void main(String args[]) 
    {
        for(int i = 0; i < 10; i++) // generates 10 random tests using the test method with random sizes of arrays from 0 to 20
        {
            System.out.println(test((int) (20*Math.random())));
        }
    } 
} 
