package linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
  private int data;
  private Node next;

  public Node(int new_data) {
    data = new_data;
    next = null;
  }

  public void set_data(int new_data) {
    data = new_data;
  }

  public int get_data() {
    return data;
  }

  public void set_next(Node new_node) {
    next = new_node;
  }

  public Node get_next() {
    return next;
  }
}

public class LinkedList {
  private Node head;

  public LinkedList() {
    head = null;
  }

  public void push(int new_data) {
    Node new_node = new Node(new_data);
    if(head != null) {
      new_node.set_next(head);
    }
    head = new_node;
  }

  public void pop() {
    if(head == null) {
      System.out.println("The Stack is empty");
      return;
    }
    Node del_node = head;
    head = del_node.get_next();
    System.out.println("The top of the stack was: " + del_node.get_data());
  }

  public void peek() {
    if(head == null) {
      System.out.println("The Stack is empty");
      return;
    }
    System.out.println("The top of the stack is: " + head.get_data());
  }

  public static void main(String[] args) {
    boolean continue_loop = true;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    LinkedList stack = new LinkedList();
    while(continue_loop) {
      try {
        System.out.println("\nWhat do you want to do in the Stack using LinkedList?");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice (1 - 4): ");
        int choice = Integer.parseInt(reader.readLine());
        switch(choice) {
          case 1:
            System.out.print("Enter the number to be pushed inside the stack: ");
            int data = Integer.parseInt(reader.readLine());
            stack.push(data);
            break;
          case 2:
            stack.pop();
            break;
          case 3:
            stack.peek();
            break;
          case 4:
            continue_loop = false;
            break;
          default:
            System.out.println("Invalid choice");
        }
      } catch(IOException e) {
        System.out.println("IOException has occurred");
      } catch(Exception e) {
        System.out.println("Exception has occurred");
      }
    }
  }
}