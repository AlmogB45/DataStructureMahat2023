import java.util.*;

public class Main {

    // Question 2
    public static void balance(Node<Integer> chain) {
        if (chain == null || chain.next == null)
            return;

        Node<Integer> slow = chain;
        Node<Integer> fast = chain.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        int sum = 0;
        Node<Integer> current = slow.next;
        while (current != null) {
            sum += current.value;
            current = current.next;
        }

        if (sum != 0) {
            current = slow;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(-sum);
        }
    }


    // Question 5 A
    public static boolean isSuper(Node<Integer> n) {

        int sumPrevNums = 0;
        Node<Integer> current = n;

        while (current != null) {
            if (current.value <= sumPrevNums) {
                return false;
            }
            sumPrevNums += current.value;
            current = current.next;
        }
        return true;
    }

    // Question 5 B
    public static boolean addToSuper(Node<Integer> n, int num) {
        if (n == null) {
            return false;
        }

        Node<Integer> current = n;
        Node<Integer> prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        if ( num <= current.value) {
            return false;
        }

        Node<Integer> newNode = new Node<>(num);
        current.next = newNode;

        return true;
    }

    // Question 5 C
    // The complexity of isSuper and addToSuper are O(n) as you need to iterate through the entire list

    // Question 10 (Will work if specified Interface is implemented in the code)
    public int getMin() {
        if (isEmpty()) {
            System.out.print("Set is empty!");
            return;
        }

        int currentMin = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < currentMin) {
                currentMin = num;
            }
        }

        return currentMin;
    }
}