
## Sorting in Linear Time
### Introduction 
There are many ways existing algorithms which sort collections of things, usually in the forms of arrays, trees, heaps, etc into a prefixed order (usually increasing or decreasing).

The most time efficient sorting algorithms known to mankind operate in $O(n\log n)$ time. 

However, if there are size/range restrictions on the elements to be sorted, then there exist sorting algorithms that operate in linear $O(n)$ time. 

### Counting Sort

Counting sort assumes all elements are integers in a range, WLOG $[0, k-1]$ for a finite $k$. In short, the main characteristc of counting sort is that it uses an array with size $k$ to store the repetition counts of every element in the range. 

#### Algorithm
Here are the steps:

1. Create an array $A$ with size $k$, where $A[i]$ stores the number of times $i$ appears in the original array. We can do this by initializing $A$ to all $0$, and then as we read through the original array $O[i]$, we increment $A[O[i]]$ by $1$.
2. At this point, $A$ is an frequency count array across all $k$ elements in range. Next, we update $A$ as follows - we want $A[i]$ to be the sum of all $A[j]$ where $j < i$ in the previous iteration of $A$. This way, the new updated $A$ is organized so that $A[i]$ contains one more than the number of elements to come before it $i$ is to be in the array at all. 
3. Here comes the step where we actually create the sorted array. Initialize an empty array $S$ with the same size as original $O$. 
4. We iterate the following step as we loop through $O$: If $O[i]$ is currently the element in question, then we set $S[A[O[i]]]$ to be $O[i]$ (this is equivalent to inserting $O[i]$ into the $A[O[i]]$th position in the new array $S$). Then, we update $A$ by decrementing $A[O[i]]$ by $1$ so in case a future $O[\ell] = O[i]$.) 
5. By the end of this process, the array $S$ should be a sorted copy of original $O$. 

#### Example

Original Array $O$:

| 4 | 2 | 1 | 8 | 2 | 5 | 7 | 4 |
|---|---|---|---|---|---|---|---|

Determine in $O(n)$ that the maximal element of the array is $8$, so we restrict the range from $0$ to $8$. Then create array $A$:

| 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
|---|---|---|---|---|---|---|---|---|

Fill in frequencies. Array $A$:

| 0 | 1 | 2 | 0 | 2 | 1 | 0 | 1 | 1 |
|---|---|---|---|---|---|---|---|---|

Update array $A$: 

| 0 | 1 | 3 | 3 | 5 | 6 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|

Create Array $S$:

| | | | | | | | |
|---|---|---|---|---|---|---|---|

Fill in the first element, $4$, into the right position, $2$. Then, update $4$ count. 
Array $S$:
| | | | | 4 | | | |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 1 | 3 | 3 | 4 | 6 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|

Fill in the second element, $2$, into the right position, $3$. Then, update $2$ count. 
Array $S$:
| | | 2| | 4 | | | |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 1 | 2 | 3 | 4 | 6 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|

Fill in the third element, $1$, into the right position, $1$. Then, update $1$ count. 
Array $S$:
| 1| | 2| | 4 | | | |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 2 | 3 | 4 | 6 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|

Fill in the fourth element, $8$, into the right position, $8$. Then, update $8$ count. 
Array $S$:
| 1| | 2| | 4 | | | 8 |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 2 | 3 | 4 | 6 | 6 | 7 | 7 |
|---|---|---|---|---|---|---|---|---|

Fill in the fifth element, $2$, into the right position, $2$. Then, update $2$ count. 
Array $S$:
| 1| 2 | 2| | 4 | | | 8 |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 1 | 3 | 4 | 6 | 6 | 7 | 7 |
|---|---|---|---|---|---|---|---|---|

Fill in the sixth element, $5$, into the right position, $6$. Then, update $5$ count. 
Array $S$:
| 1| 2 | 2| | 4 | 5 | | 8 |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 1 | 3 | 4 | 5 | 6 | 7 | 7 |
|---|---|---|---|---|---|---|---|---|

Fill in the seventh element, $7$, into the right position, $7$. Then, update $7$ count. 
Array $S$:
| 1| 2 | 2| | 4 | 5 | 7 | 8 |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 1 | 3 | 4 | 5 | 6 | 6 | 7 |
|---|---|---|---|---|---|---|---|---|

Fill in the seventh element, $4$, into the right position, $4$. Then, update $4$ count. 
Array $S$:
| 1| 2 | 2| 4 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|---|---|---|

Array $A$:
| 0 | 0 | 1 | 3 | 3 | 5 | 6 | 6 | 7 |
|---|---|---|---|---|---|---|---|---|

And now $S$ is the sorted array!

#### Runtime

Step 1 takes $O(n)$, Step 2 takes $O(k)$, Step 3 takes $O(n)$, Step 4 takes $O(n)$, so the overall runtime is $O(n)$ since $O(k)$ is constant. 

No matter what the initial array $O$ is, the same steps are performed, so the runtime is always $O(n)$, best, worst, and average. 


#### Coded Implementation (Java)

```
class CountingSort {
  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    // Determine range from maximal element in array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    // Initialize frequency count array with all zeros.
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Store the the frequency of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Store the cummulative frequency count of every element
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

  // Driver code
  public static void main(String args[]) {
    int[] data = { 4, 2, 1, 8, 2, 5, 4 };
    int size = data.length;
    CountingSort cs = new CountingSort();
    cs.countSort(data, size);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}
```
#### Sources

Introduction - https://www.programiz.com/dsa/counting-sort

Algorithm Description + Visual Motiations - https://www.programiz.com/dsa/counting-sort

Implementation - https://www.javatpoint.com/counting-sort

Markdown Support - https://support.typora.io/Draw-Diagrams-With-Markdown/



