package collectionsFramework;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuePractice {

	public static void main(String[] args) {
		Queue<Integer> abq = new ArrayBlockingQueue<Integer>(3);
        
        // Throws NoSuchElement exception --- no items in queue yet
        // System.out.println("Head of queue is: " + q1.element());
         
		abq.add(84);
		abq.add(2);
		abq.add(64);
         
        System.out.println("Head of queue is: " + abq.element());
         
        try {
        	abq.add(82);
        } catch (IllegalStateException e) {
            System.out.println("Tried to add too many items to the queue.");
        }
         
        for(Integer value: abq) {
            System.out.println("Queue value: " + value);
        }
         
        System.out.println("Removed from queue: " + abq.remove());
        System.out.println("Removed from queue: " + abq.remove());
        System.out.println("Removed from queue: " + abq.remove());
         
        try {
            System.out.println("Removed from queue: " + abq.remove());
        } catch (NoSuchElementException e) {
            System.out.println("Tried to remove too many items from queue");
        }
        
        
        
        
        
        // USE OF offer, poll and peak
        
        
        Queue<Integer> abq2 = new ArrayBlockingQueue<Integer>(5);
        
        System.out.println("ArrayBlockingQueue 2 peek: " + abq2.peek());
         
        abq2.offer(54);
        abq2.offer(67);
        abq2.offer(98);
        abq2.offer(74);
        abq2.offer(568);
         
        System.out.println("ArrayBlockingQueue 2 peek: " + abq2.peek());
         
        if(abq2.offer(63) == false) {
            System.out.println("Offer failed to add third item.");
        }
         
        for(Integer value: abq2) {
            System.out.println("ArrayBlockingQueue 2 value: " + value);
        }
         
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        System.out.println("ArrayBlockingQueue 2 poll: " + abq2.poll());
        
        
	}

}
