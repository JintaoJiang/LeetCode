class MyStack {
    Queue queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList();     
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue q = new LinkedList();
        q.add(x);
        q.add(queue);
        queue = q;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = (int) queue.poll();
        queue = (Queue) queue.poll();
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return (int) queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}