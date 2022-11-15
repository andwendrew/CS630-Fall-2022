class Queue
{
    // Here we implement a queue contained within an array, with arr[0] always representing the queue end and the variable front denoting the index of the TypeNotPresentException
    
    private int[] arr;      // array to store queue 
    private int front;      // index pointing to front of queue
    private int capacity;   // maximum capacity of the queue, i.e maximum size queue can take
 
    // Constructor which initializes a queue with given size and initially no elements
    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = -1;
    }
 
    // Method which dequeues element from the front and returns dequeued element
    public int dequeue()
    {
        if(front == -1) // if queue is already blank, do nothing and return placeholder
        { 
            return -900;
        }
        else
        {
            front--;
            return arr[front+1];
        }
    }
 
    // Method which queues in element from the end by shifting everything in the queue up one to the front
    public void queue(int item)
    {
        if (front == capacity - 1) // if queue is full then do nothing
        {
            
        }
        else
        {
            for(int i = front + 1; i >= 1; i--)
            {
                arr[i] =  arr[i-1]; // perform the shift
            }
            arr[0] = item;
            front++;
        }
    }
 
    // Method to return the front element of the queue
    public int peek()
    {
        return arr[front];
    }
    
    // Method to return size of queue
    public int size()
    {
        return front + 1;
    }
}

class Main
{   
    public static boolean testqueuepeek(int n) // jointly tests dequeue and peek methods on queue of capacity n and randomly generated size with nonnegative elements up to 100
    {
        Queue q = new Queue(n);
        
        int firstqueue = (int) (100*Math.random()); // this should always be returned from peek
        q.queue(firstqueue);
        
        int rsize = (int) (n*Math.random()); // generates random size of queue from empty to one from being full 
        for(int i = 0; i < rsize; i++) // generates rest of queue randomly
        { 
            q.queue((int) (100*Math.random()));
        }
        if(q.peek() == firstqueue && q.size() == rsize + 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean testdequeuepeek(int n) // jointly tests queue and peek methods on queue of capacity n and randomly generated size with nonnegative elements up to 100
    {
        Queue q = new Queue(n);
        
        int firstqueue = (int) (100*Math.random()); // first queued in
        q.queue(firstqueue);
        int secondqueue = (int) (100*Math.random()); // second queued in
        q.queue(secondqueue);
        
        int rsize = (int) ((n-1)*Math.random()); // generates random size of rest of queue from empty to 2 from being full 
        for(int i = 0; i < rsize; i++) // generates rest of queue randomly
        { 
            q.queue((int) (100*Math.random()));
        }
        if(q.dequeue() == firstqueue && q.peek() == secondqueue) // checks that the element dequeued is indeed the first element queued and the next front is the second element added
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        for(int i = 0; i < 4; i++)
        { // performs four distinct tests for randomly generated queues with randomly generated sizes with randomly generated capacities up to 20
            System.out.println(testqueuepeek((int) (20*Math.random())));
        }
        
        for(int i = 0; i < 4; i++)
        { // performs four distinct tests for randomly generated queues with randomly generated sizes with randomly generated capacities up to 20
            System.out.println(testdequeuepeek((int) (20*Math.random())));
        }
    }
    // Source: https://www.javatpoint.com/java-queue
}
