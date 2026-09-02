class MedianFinder {

    // smallheap elements <= bigheap elements
    // size diff ~= 1 allowed else remove from small and add to big heap or vice versa
    // and if size diff = 1 check small heap max element and big heap small element here small heap < big heap else remove and add in big heap again

    PriorityQueue<Integer> bh = new PriorityQueue<>();
    PriorityQueue<Integer> sh = new PriorityQueue<>((a,b) -> Integer.compare(b,a));


    public MedianFinder() {
        
    }
    //3,2,1 - 5,7


    public void addNum(int num) {
        sh.add(num);
        
        //element check
        if(!bh.isEmpty() && sh.peek() > bh.peek()){
            int pop = sh.poll();
            bh.add(pop);
        }

        int sizedif = sh.size() - bh.size();

        if(sizedif > 1){
            int pop = sh.poll();
            bh.add(pop);
        }else if(sizedif < 0){
            int pop = bh.poll();
            sh.add(pop);
        }
    }
    
    public double findMedian() {
        if(sh.size() == bh.size()){
            double sum = sh.peek() + bh.peek();
            return sum/2;

        }
       else if(sh.size() < bh.size()){
            int pop =  bh.peek();
            return (double) pop;
       }else{
            int pop =  sh.peek();
            return (double) pop;
       }
       
    }
}
