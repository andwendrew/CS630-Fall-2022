class Stack
{
    private int arr[]; // array to store stack
    private int top; // variable to track rightmost element of stack
    private int capacity; // maximum possible size of stack
 
    // Constructor of stack, which initializes with size
    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1; 
    }
 
    // This method adds (or pushes) an element in from the right
    public void push(int n)
    {
        if(top < capacity - 1){ // checks to make sure stack is not full or not
            top++;
            arr[top] = n;
        }
    }
 
    // This method returns (or pops) the rightmost element back out
    public int pop()
    {
        if(top > -1){ // checks to make sure stack is nonempty
            return arr[top--];
        }
        else{
            return -900;
        }
    }
 
    // Checks rightmost element of stack 
    public int peek()
    {
        if (top > -1) { // checks stack is nonempty
            return arr[top];
        }
        else{
            return -900;
        }
    }
    
    // Returns size
    public int size()
    {
        return top + 1;
    }
}
 
class Main
{
    public static boolean testpeek(int n){ // performs test on peek method by initializing stack of capacity n and random initial size
        Stack stack = new Stack(n);
        int rsize = (int) (n*Math.random()); // determine random initial size of stack (cannot be full)
        for(int i = 0; i < rsize; i++){
            stack.push((int) (100*Math.random())); // initialize random stack with randomized size
        }
        int topush = (int) (100*Math.random()); 
        stack.push(topush);
        if(stack.peek() == topush){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean testpop(int n){ // performs test on pop method by initializing stack of capacity n and random initial size
        Stack stack = new Stack(n);
        int rsize = 1 + (int) (n*Math.random()); // determine random initial size of stack (nonempty)
        for(int i = 0; i < rsize; i++){
            stack.push((int) (100*Math.random())); // initialize random stack with randomized size
        }
        if(stack.peek() == stack.pop()){
            if(stack.size() == rsize - 1){ // nested criteria checks popped value is last array element and size decreases by 1
                return true;
            }
            return false; 
        }
        else{
            return false;
        }
    }
    
    public static boolean testpush(int n){ // performs test on pop method by initializing stack of capacity n and random initial size
        Stack stack = new Stack(n);
        int rsize = (int) (n*Math.random()); // determine random initial size of stack (not full)
        for(int i = 0; i < rsize; i++){
            stack.push((int) (100*Math.random())); // initialize random stack with randomized size
        }
        int tobepushed = (int) (100*Math.random());
        stack.push(tobepushed);
        if(stack.peek() == tobepushed){ 
            if(stack.size() == rsize + 1){ // nested criteria checks if pushed value is at top and size increases by 1
                return true;
            }
            return false; 
        }
        else{
            return false;
        }
    }
    
    public static void main (String[] args)
    {
        // peek testing - loop through 4 distinct peek tests for distinct n up to 20
        for(int i = 0; i < 4; i++){
            System.out.println(testpeek((int) (20*Math.random())));
        }
        
        // pop testing - loop through 4 distinct pop tests for distinct n up to 20
        for(int i = 0; i < 4; i++){
            System.out.println(testpop((int) (20*Math.random())));
        }
        
        // push testing - loop through 4 distinct push tests for distinct n up to 20
        for(int i = 0; i < 4; i++){
            System.out.println(testpush((int) (20*Math.random())));
        }
        
    }
}