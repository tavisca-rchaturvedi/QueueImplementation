public class Queue {
    private int capacity;
    private int[] Queue;
    private int start = 0;
    private int end = 0;
    private int defaultCapacity = 5;

    public Queue(){
        this.capacity = this.defaultCapacity;
        this.Queue = new int[this.capacity];
    }

    public Queue(int capacity){
        this.capacity = capacity;
        this.Queue = new int[this.capacity];
    }

    public void throwException(String exception) throws Exception{
        throw new Exception(exception);
    }

    public void add(int value) throws Exception{

        if(this.end == (this.start - 1) % this.capacity ){
            throwException("Overflow start is " + this.start + " and end is " + this.end);
        }

        if(this.end >= this.capacity){
            this.end %= this.capacity;
        }

        this.Queue[this.end] = value;
        this.end++;


    }

    public int remove() throws Exception{

        if(this.start == this.end){
            throwException("Underflow");
        }

        if(this.start >= this.capacity){

            this.start %= this.capacity;
        }

        int value = this.Queue[start];
        this.start++;
        return value;

    }


    public static void main(String[] args) throws Exception {
        //Queue q = new Queue(5);

        Queue q = new Queue();
        for(int i = 0; i < 5; i++){
            q.add(i);
        }

        for(int i = 0; i < 3 ; i++){
            System.out.println(q.remove());
        }

        for(int i = 0; i < 2 ; i++){
            q.add(i+6);
        }

        for(int i = 0; i < 4; i++){
            System.out.println(q.remove());
        }
    }
}
