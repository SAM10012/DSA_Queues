/*
Problem Statement: Implement Queue using Stacks (LeetCode 232)

Design and implement a queue using only stack data structures.

The queue should support the following operations:
1. enqueue(x) – Insert element x at the back of the queue.
2. dequeue()  – Remove and return the element from the front of the queue.
3. peek()     – Return the front element without removing it.
4. empty()    – Return true if the queue is empty, otherwise false.

Constraints:
- Only standard stack operations are allowed: push, pop, peek, and isEmpty.
- All operations are guaranteed to be valid.
- At most 100 calls will be made to enqueue, dequeue, peek, and empty.

Approach:
- Use two stacks:
  • 'in' stack for enqueue operations.
  • 'out' stack for dequeue and peek operations.
- When 'out' stack is empty, transfer all elements from 'in' to 'out'.
- This reversal ensures FIFO (First-In-First-Out) behavior.

Time Complexity (TC):
- enqueue() → O(1)
- dequeue() → Amortized O(1)
- peek()    → Amortized O(1)
- empty()   → O(1)

Space Complexity (SC):
- O(n), where n is the number of elements in the queue.
- Two stacks are used to store the elements.
*/


import java.util.Stack;

public class Queue_using_Stacks {

    public static class Queue{
        private Stack<Integer> in;
        private Stack<Integer> out;

        public Queue(){
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        public void enqueue(int n)
        {
            in.push(n);
        }

        public boolean empty()
        {
            return in.isEmpty() && out.isEmpty();
        }

        public int peek()
        {
            if(empty())
                throw new RuntimeException("No data in the Queue");

            if(out.isEmpty())
            {
                while(!in.isEmpty())
                {
                    out.push(in.pop());
                }
            }

            return out.peek();
        }

        public int dequeue()
        {
            if(empty())
                throw new RuntimeException("No data in Queue");

            if(out.isEmpty())
            {
                while(!in.isEmpty())
                {
                    out.push(in.pop());
                }
            }

            return out.pop();
        }

    }

    public static void main(String[] args)
    {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("Peeked Element: " + queue.peek());
        System.out.println("Popped Element: " + queue.dequeue());
        System.out.println("Peeked Element: " + queue.peek());
        queue.enqueue(5);
        System.out.println("Peeked Element: " + queue.peek());
        System.out.println("Popped Element: " + queue.dequeue());
        System.out.println("Peeked Element: " + queue.peek());
        System.out.println("Popped Element: " + queue.dequeue());
        System.out.println("Peeked Element: " + queue.peek());
        System.out.println("Popped Element: " + queue.dequeue());
        System.out.println("Peeked Element: " + queue.peek());
        //System.out.println("Popped Element: " + queue.dequeue());

    }
}
