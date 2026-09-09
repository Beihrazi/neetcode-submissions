class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        mainStack.add(val);
        if(minStack.isEmpty()){
            minStack.add(val);
        }else if(!minStack.isEmpty() && val < minStack.peek()){
            minStack.add(val);
        }else{
            minStack.add(minStack.peek());
        }
    }
    
    public void pop() {
        if(!minStack.isEmpty() && !mainStack.isEmpty()){
            minStack.pop();
            mainStack.pop();
        }
    }
    
    public int top() {
        if(!mainStack.isEmpty()){
            return mainStack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}
