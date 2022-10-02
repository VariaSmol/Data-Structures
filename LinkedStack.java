package Rec4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedStack(){
        list = new LinkedList<>();
    }


    @Override
    public void push(E element) {
        list.add(0 ,element);
    }

    public boolean isEmpty() {
        return list.size() ==0;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is Empty");
        return list.removeFirst();
    }

    @Override
    public E peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return list.get(0);
    }

    public int size(){
        LinkedStack<E> t = new LinkedStack<>();
        int size = 0;
        while(!this.isEmpty() ){
            t.push(this.pop());
            size++;
        }
        while (!t.isEmpty())
            this.push(t.pop());
        return size;
    }

    public int search(E element) {
        int position = 1;
        LinkedStack<E> t = new LinkedStack<>();
        while(!this.isEmpty())  // to fill temporary stack with this's elements
            t.push(this.pop());


        while (!t.isEmpty()) {
                if (t.peek() == element) {
                    while (!t.isEmpty()) // to return elements back
                        this.push(t.pop());
                    return position;
                }
                else {
                    position++;
                    this.push(t.pop());
                }
        }
        return -1;
    }


    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int searchPosition1 = stack.search(2);
        System.out.println((searchPosition1==-1)?"No such element":searchPosition1);
        int searchPosition2 = stack.search(10);
        System.out.println((searchPosition2==-1)?"No such element":searchPosition2);
    }
}

