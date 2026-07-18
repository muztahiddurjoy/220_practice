/* =====================================================================
   LAB 2 : COMBINED SUBMISSION (Part 1 + Part 2)
   ---------------------------------------------------------------------
   Name    : ______________________
   ID      : ______________________
   Section : ______________________
   ---------------------------------------------------------------------
   Language : Java  (no library is imported, not even Scanner,
                     because all sample inputs are built inside main)

   PART 1 (Singly Linked List)        PART 2 (Dummy Headed Circular)
   Task 1 : Building Blocks           Task 5 : Sum Odd Append
   Task 2 : Organize Books            Task 6 : Pair Join
   Task 3 : Alternate Merge           Task 7 : Range Move
   Task 4 : ID Generator

   HOW TO RUN:
       javac Lab2Solution.java
       java Lab2Solution
   ===================================================================== */

/* =====================================================================
   THE NODE CLASS
   ---------------------------------------------------------------------
   elem -> the data stored inside the node. Its type is Object, so the
           same class can hold a number (5) or a text ("Red").
   next -> the link to the NEXT node.
   prev -> the link to the PREVIOUS node. Only the doubly linked list
           tasks of Part 2 use it. The Part 1 tasks simply ignore it.
   ===================================================================== */
class Node {
    Object elem;
    Node next;
    Node prev;

    Node(Object elem) {
        this.elem = elem;
        this.next = null;
        this.prev = null;
    }
}

public class Lab2Solution {

    /* =================================================================
       TASK 1 : BUILDING BLOCKS                 [Part 1 - Assignment 1]
       -----------------------------------------------------------------
       Two buildings are "Similar" only if they have the SAME colors in
       the SAME order AND the SAME number of blocks.

       IDEA:
       - Walk through both lists at the same time using two pointers.
       - If the colors at any position are different -> "Not Similar".
       - After the walk, if one building still has blocks left, their
         heights are different -> "Not Similar".
       - Otherwise -> "Similar".
       ================================================================= */
    public static String buildingBlocks(Node building1, Node building2) {
        Node temp1 = building1;
        Node temp2 = building2;

        // move through BOTH lists together, one block at a time
        while (temp1 != null && temp2 != null) {

            // the colors are text (String), so we must compare them
            // with .equals() and NOT with == (== compares references)
            if (temp1.elem.equals(temp2.elem) == false) {
                return "Not Similar"; // mismatch found at this position
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // if any building still has blocks left, the heights differ
        if (temp1 != null) {
            return "Not Similar"; // building 1 is taller
        }
        if (temp2 != null) {
            return "Not Similar"; // building 2 is taller
        }

        return "Similar";
    }

    /* =================================================================
       TASK 2 : ORGANIZE BOOKS                  [Part 1 - Assignment 2]
       -----------------------------------------------------------------
       Rearrange the books in DESCENDING order of popularity.
       Books with the SAME score must keep their original order.
       We are NOT allowed to create any new linked list, array or
       other data structure.

       IDEA (Bubble Sort on the list):
       - popularity[i] is the score of the book sitting at position i.
       - We compare NEIGHBOURING books. If the left one has a SMALLER
         score than the right one, they are in the wrong order, so we
         swap the two book titles AND we also swap their two scores.
         Swapping both keeps every score matched with its own book.
       - We only swap when the left score is STRICTLY smaller ( < ).
         Equal scores are never swapped, so books with the same score
         keep their original order automatically (this makes the sort
         "stable").
       - One full pass pushes the least popular book to the very back.
         Repeating the pass (n - 1) times sorts the whole list.
       ================================================================= */
    public static Node organizeBooks(Node head, int[] popularity) {
        int n = popularity.length; // number of books in the list

        int i = 0;
        while (i < n - 1) {              // repeat the pass (n - 1) times

            Node current = head;         // every pass starts at the head
            int j = 0;
            while (j < n - 1 - i) {      // compare positions j and j + 1
                Node nextNode = current.next;

                // wrong order? (left book is LESS popular than right)
                if (popularity[j] < popularity[j + 1]) {

                    // swap the two book titles inside the nodes
                    Object tempTitle = current.elem;
                    current.elem = nextNode.elem;
                    nextNode.elem = tempTitle;

                    // swap the two popularity scores as well
                    int tempScore = popularity[j];
                    popularity[j] = popularity[j + 1];
                    popularity[j + 1] = tempScore;
                }

                current = current.next;  // move one position to the right
                j = j + 1;
            }
            i = i + 1;
        }

        return head;
    }

    /* =================================================================
       TASK 3 : ALTERNATE MERGE                 [Part 1 - Assignment 3]
       -----------------------------------------------------------------
       Weave the two lists together: one node from list 1, then one
       node from list 2, then one from list 1 again, and so on.
       Space complexity must be O(1): we are NOT allowed to create any
       new node or new list. We only change the "next" links.

       IDEA:
       - Keep one pointer in each list (p1 and p2).
       - Before changing anything, SAVE where each list continues
         (next1 and next2). If we do not save them first, we lose the
         rest of the lists forever.
       - Then: p1 points to p2 (a list-2 node comes after a list-1
         node), and p2 points back to next1 (the list continues in
         list 1 again).
       - Special case: if next1 is null, list 1 is finished. Then p2
         must NOT be redirected. It simply keeps its own tail, so the
         remaining part of list 2 stays attached automatically.
       ================================================================= */
    public static Node alternateMerge(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != null && p2 != null) {

            // save where each list continues BEFORE changing any link
            Node next1 = p1.next;
            Node next2 = p2.next;

            // step 1: the node of list 2 comes right after p1
            p1.next = p2;

            // step 2: connect p2 back into list 1 (only if list 1
            //         still has nodes left)
            if (next1 != null) {
                p2.next = next1;
            }

            // move both pointers forward in their ORIGINAL lists
            p1 = next1;
            p2 = next2;
        }

        return head1; // the merged list always starts with list 1
    }

    /* =================================================================
       TASK 4 : ID GENERATOR                    [Part 1 - Assignment 4]
       -----------------------------------------------------------------
       Build a NEW singly linked list holding an 8 digit student ID.
       (Creating a new list is allowed here because the task itself
        says "generate another singly linked list".)

       - The first 4 digits  = the first list, but in REVERSE order.
       - The last 4 digits   = list2[i] + list3[i] (element by element,
         from the beginning). If a sum is >= 10 we keep only its last
         digit by taking (sum % 10).

       TWO SMALL TRICKS:
       1) To reverse list 1, insert every digit at the FRONT of the new
          list. Inserting at the front naturally reverses the order,
          just like stacking plates one on top of another.
       2) To add the sums at the BACK quickly, keep a "tail" pointer
          that always remembers the last node of the new list.
       ================================================================= */
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        Node idHead = null; // head of the new student ID list

        // ---- Step 1: first 4 digits = list 1 in REVERSE order ----
        Node temp = head1;
        while (temp != null) {
            Node newNode = new Node(temp.elem);
            newNode.next = idHead;  // new node points to the old front
            idHead = newNode;       // new node becomes the new front
            temp = temp.next;
        }

        // ---- Step 2: find the last node (tail) of the new list ----
        Node tail = idHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        // ---- Step 3: last 4 digits = list2 + list3, pair by pair ----
        Node t2 = head2;
        Node t3 = head3;
        while (t2 != null && t3 != null) {

            // elem is stored as Object, so convert it to int for math
            int digit2 = (int) t2.elem;
            int digit3 = (int) t3.elem;

            int sum = digit2 + digit3;
            if (sum >= 10) {
                sum = sum % 10; // keep only the last digit
            }

            Node newNode = new Node(sum);
            tail.next = newNode; // attach the new digit at the back
            tail = newNode;      // the new node is now the last one

            t2 = t2.next;
            t3 = t3.next;
        }

        return idHead;
    }

    /* =================================================================
       TASK 5 : SUM ODD APPEND                  [Part 2 - Assignment 5]
       -----------------------------------------------------------------
       The list is a DUMMY HEADED SINGLY CIRCULAR linked list:
       the last node points BACK to the dummy head, so a traversal
       ends when we arrive at the dummy head again (NOT at null).

       Remove every node with an ODD value while adding those values
       up. Finally insert ONE new node holding the total sum at the
       end of the list. (The rule allows exactly 1 new node, and the
       sum node is that single new node.)

       IDEA (the classic "prev + current" delete pattern):
       - prev    = the node just BEFORE current (starts at dummy head).
       - current = the node we are looking at.
       - If current is ODD  : add it to sum, then delete it by making
         prev skip over it (prev.next = current.next). IMPORTANT: prev
         does NOT move, because the node after the deleted one becomes
         its new neighbour and must be checked too.
       - If current is EVEN : keep it, so BOTH pointers move forward.
       - When the loop ends, prev is standing on the LAST remaining
         node, which is exactly where the sum node must be attached.
       ================================================================= */
    public static void sumOddAppend(Node dummyHead) {
        int sum = 0;

        Node prev = dummyHead;         // the node before current
        Node current = dummyHead.next; // the first real node

        // circular list: stop when we come back to the dummy head
        while (current != dummyHead) {

            int value = (int) current.elem;

            if (value % 2 != 0) {
                // ODD -> collect the value and remove the node
                sum = sum + value;
                prev.next = current.next; // skip over current
                current = current.next;   // prev stays where it is
            } else {
                // EVEN -> keep the node, move both pointers forward
                prev = current;
                current = current.next;
            }
        }

        // prev is now the last remaining node (or the dummy head
        // itself if every node was odd and got removed)

        // this is the ONLY new node we create in this task
        Node sumNode = new Node(sum);
        sumNode.next = dummyHead; // point back to X: circle stays intact
        prev.next = sumNode;      // attach the sum node at the end
    }

    /* =================================================================
       TASK 6 : PAIR JOIN                       [Part 2 - Assignment 6]
       -----------------------------------------------------------------
       Two dummy headed DOUBLY linked lists of EQUAL length are given.
       Weave them together in pairs:

           X-A-B-C-D  and  X-E-F-G-H   -->   X-A-E-B-F-C-G-D-H

       We CANNOT create any new node. We only rewire next/prev links.
       The first dummy head stays the head, and the second dummy head
       is simply left out (abandoned).

       IDEA:
       - a = current node of list 1,  b = current node of list 2.
       - For every pair, insert b RIGHT AFTER a. Because the lists are
         doubly linked, four links must be fixed each time:
             1) a.next = b          (a now leads to b)
             2) b.prev = a          (b points back to a)
             3) b.next = nextA      (b leads to a's old neighbour)
             4) nextA.prev = b      (that neighbour points back to b)
       - As always: SAVE nextA and nextB before touching any link.
       - Loop condition: for a circular list we stop when a returns to
         dummy head 1; the extra null check also makes the very same
         code work if the list is a plain (non-circular) doubly list.
       ================================================================= */
    public static void pairJoin(Node dummyHead1, Node dummyHead2) {
        Node a = dummyHead1.next; // first real node of list 1
        Node b = dummyHead2.next; // first real node of list 2

        // both lists have the same length, so checking list 1 is enough
        while (a != dummyHead1 && a != null) {

            // save where each list continues BEFORE rewiring
            Node nextA = a.next;
            Node nextB = b.next;

            // place b right after a (fix all four links)
            a.next = b;
            b.prev = a;
            b.next = nextA;
            if (nextA != null) {
                nextA.prev = b;
            }

            // move to the next pair
            a = nextA;
            b = nextB;
        }
    }

    /* =================================================================
       TASK 7 : RANGE MOVE                      [Part 2 - Assignment 7]
       -----------------------------------------------------------------
       The list is a DUMMY HEADED DOUBLY CIRCULAR linked list.
       Move every node whose value v satisfies  start <= v <= end
       to the BACK of the list, keeping their original relative order.
       No new list and no new node may be created.

       IDEA:
       - First COUNT how many real nodes the list has. Why? Because
         while we work, we keep sending nodes to the back. If we simply
         walked "until we reach the dummy head", we would meet those
         moved nodes AGAIN at the back and might move them forever.
         Counting first lets us look at each ORIGINAL node exactly once.
       - For every node (visited through a SAVED next pointer):
           If its value is inside the range:
             a) DETACH it   : its two neighbours shake hands directly.
             b) APPEND it   : put it between the current last node
                              (dummyHead.prev) and the dummy head.
       - Because we scan left to right and always append at the back,
         the moved nodes automatically keep their original order.
       ================================================================= */
    public static void rangeMove(Node dummyHead, int start, int end) {

        // ---- Step 1: count the real nodes ----
        int count = 0;
        Node temp = dummyHead.next;
        while (temp != dummyHead) {
            count = count + 1;
            temp = temp.next;
        }

        // ---- Step 2: visit each ORIGINAL node exactly once ----
        Node current = dummyHead.next;
        int i = 0;
        while (i < count) {

            Node nextNode = current.next; // save BEFORE any rewiring

            int value = (int) current.elem;
            if (value >= start && value <= end) {

                // (a) DETACH current: neighbours connect to each other
                current.prev.next = current.next;
                current.next.prev = current.prev;

                // (b) APPEND current at the back (just before X)
                Node last = dummyHead.prev; // current last node
                last.next = current;
                current.prev = last;
                current.next = dummyHead;
                dummyHead.prev = current;
            }

            current = nextNode; // continue from the saved position
            i = i + 1;
        }
    }

    /* =================================================================
       HELPER METHODS (used only by main to build and print test lists;
       they are not part of any task's logic)
       ================================================================= */

    // builds a normal (non-dummy) SINGLY linked list from an array
    public static Node createSinglyList(Object[] values) {
        Node head = null;
        Node tail = null;
        int i = 0;
        while (i < values.length) {
            Node newNode = new Node(values[i]);
            if (head == null) {
                head = newNode; // very first node
                tail = newNode;
            } else {
                tail.next = newNode; // attach at the back
                tail = newNode;
            }
            i = i + 1;
        }
        return head;
    }

    // prints a normal singly linked list:  a --> b --> ... --> None
    public static void printSinglyList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem);
            System.out.print(" --> ");
            temp = temp.next;
        }
        System.out.println("None");
    }

    // builds a DUMMY HEADED SINGLY CIRCULAR linked list
    public static Node createDummySinglyCircular(Object[] values) {
        Node dummyHead = new Node("X");
        Node tail = dummyHead;
        int i = 0;
        while (i < values.length) {
            Node newNode = new Node(values[i]);
            tail.next = newNode;
            tail = newNode;
            i = i + 1;
        }
        tail.next = dummyHead; // last node points back to the dummy head
        return dummyHead;
    }

    // prints a dummy headed singly circular list
    public static void printDummySinglyCircular(Node dummyHead) {
        System.out.print("X --> ");
        Node temp = dummyHead.next;
        while (temp != dummyHead) {
            System.out.print(temp.elem);
            System.out.print(" --> ");
            temp = temp.next;
        }
        System.out.println("(back to X)");
    }

    // builds a DUMMY HEADED DOUBLY CIRCULAR linked list
    public static Node createDummyDoublyCircular(Object[] values) {
        Node dummyHead = new Node("X");
        dummyHead.next = dummyHead; // an empty circle points to itself
        dummyHead.prev = dummyHead;

        int i = 0;
        while (i < values.length) {
            Node newNode = new Node(values[i]);
            Node last = dummyHead.prev; // current last node

            last.next = newNode;        // old last  -> new node
            newNode.prev = last;        // new node  -> old last
            newNode.next = dummyHead;   // new node  -> X (stay circular)
            dummyHead.prev = newNode;   // X         -> new node
            i = i + 1;
        }
        return dummyHead;
    }

    // prints a dummy headed doubly circular list going FORWARD
    public static void printDummyDoublyCircular(Node dummyHead) {
        System.out.print("X <--> ");
        Node temp = dummyHead.next;
        while (temp != dummyHead && temp != null) {
            System.out.print(temp.elem);
            System.out.print(" <--> ");
            temp = temp.next;
        }
        System.out.println("(back to X)");
    }

    // prints the same list BACKWARD using the prev links,
    // which proves that every prev pointer is wired correctly
    public static void printDummyDoublyCircularBackward(Node dummyHead) {
        System.out.print("X <--> ");
        Node temp = dummyHead.prev;
        while (temp != dummyHead && temp != null) {
            System.out.print(temp.elem);
            System.out.print(" <--> ");
            temp = temp.prev;
        }
        System.out.println("(back to X)   [printed backward]");
    }

    // prints an int array like [8, 10, 5, 10, 6]
    public static void printIntArray(int[] arr) {
        System.out.print("[");
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
            i = i + 1;
        }
        System.out.println("]");
    }

    /* =================================================================
       MAIN : runs every task with the sample inputs from the lab sheet
       ================================================================= */
    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println(" TASK 1 : BUILDING BLOCKS");
        System.out.println("=====================================================");

        Object[] b1a = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Object[] b2a = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node building1 = createSinglyList(b1a);
        Node building2 = createSinglyList(b2a);
        System.out.print("Case 1  building_1 : ");
        printSinglyList(building1);
        System.out.print("Case 1  building_2 : ");
        printSinglyList(building2);
        System.out.println("Output             : " + buildingBlocks(building1, building2));
        System.out.println();

        Object[] b1b = {"Red", "Green", "Yellow", "Red", "Yellow", "Green"};
        Object[] b2b = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        building1 = createSinglyList(b1b);
        building2 = createSinglyList(b2b);
        System.out.print("Case 2  building_1 : ");
        printSinglyList(building1);
        System.out.print("Case 2  building_2 : ");
        printSinglyList(building2);
        System.out.println("Output             : " + buildingBlocks(building1, building2));
        System.out.println();

        Object[] b1c = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Object[] b2c = {"Red", "Green", "Yellow", "Red", "Blue", "Green", "Blue"};
        building1 = createSinglyList(b1c);
        building2 = createSinglyList(b2c);
        System.out.print("Case 3  building_1 : ");
        printSinglyList(building1);
        System.out.print("Case 3  building_2 : ");
        printSinglyList(building2);
        System.out.println("Output             : " + buildingBlocks(building1, building2));
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 2 : ORGANIZE BOOKS");
        System.out.println("=====================================================");

        Object[] books1 = {"Dune", "IT", "Coraline", "Inferno", "Twilight"};
        int[] pop1 = {8, 10, 5, 10, 6};
        Node lib1 = createSinglyList(books1);
        System.out.print("Case 1  Given LL   : ");
        printSinglyList(lib1);
        System.out.print("Case 1  Popularity : ");
        printIntArray(pop1);
        lib1 = organizeBooks(lib1, pop1);
        System.out.print("Output             : ");
        printSinglyList(lib1);
        System.out.println();

        Object[] books2 = {"Hamlet", "Persuasion", "It", "Dracula", "Beloved"};
        int[] pop2 = {7, 9, 9, 6, 7};
        Node lib2 = createSinglyList(books2);
        System.out.print("Case 2  Given LL   : ");
        printSinglyList(lib2);
        System.out.print("Case 2  Popularity : ");
        printIntArray(pop2);
        lib2 = organizeBooks(lib2, pop2);
        System.out.print("Output             : ");
        printSinglyList(lib2);
        System.out.println();

        Object[] books3 = {"Matilda", "Franny", "Foundation", "Carrie", "Misery"};
        int[] pop3 = {5, 8, 8, 10, 6};
        Node lib3 = createSinglyList(books3);
        System.out.print("Case 3  Given LL   : ");
        printSinglyList(lib3);
        System.out.print("Case 3  Popularity : ");
        printIntArray(pop3);
        lib3 = organizeBooks(lib3, pop3);
        System.out.print("Output             : ");
        printSinglyList(lib3);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 3 : ALTERNATE MERGE");
        System.out.println("=====================================================");

        Object[] m1a = {1, 2, 6, 8, 11};
        Object[] m2a = {5, 7, 3, 9, 4};
        Node listA1 = createSinglyList(m1a);
        Node listA2 = createSinglyList(m2a);
        System.out.print("Case 1  List1 : ");
        printSinglyList(listA1);
        System.out.print("Case 1  List2 : ");
        printSinglyList(listA2);
        Node mergedA = alternateMerge(listA1, listA2);
        System.out.print("Output        : ");
        printSinglyList(mergedA);
        System.out.println();

        Object[] m1b = {5, 3, 2, -4};
        Object[] m2b = {-4, -6, 1};
        Node listB1 = createSinglyList(m1b);
        Node listB2 = createSinglyList(m2b);
        System.out.print("Case 2  List1 : ");
        printSinglyList(listB1);
        System.out.print("Case 2  List2 : ");
        printSinglyList(listB2);
        Node mergedB = alternateMerge(listB1, listB2);
        System.out.print("Output        : ");
        printSinglyList(mergedB);
        System.out.println();

        Object[] m1c = {4, 2, -2, -4};
        Object[] m2c = {8, 6, 5, -3};
        Node listC1 = createSinglyList(m1c);
        Node listC2 = createSinglyList(m2c);
        System.out.print("Case 3  List1 : ");
        printSinglyList(listC1);
        System.out.print("Case 3  List2 : ");
        printSinglyList(listC2);
        Node mergedC = alternateMerge(listC1, listC2);
        System.out.print("Output        : ");
        printSinglyList(mergedC);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 4 : ID GENERATOR");
        System.out.println("=====================================================");

        Object[] id1a = {0, 3, 2, 2};
        Object[] id2a = {5, 2, 2, 1};
        Object[] id3a = {4, 3, 2, 1};
        Node idL1 = createSinglyList(id1a);
        Node idL2 = createSinglyList(id2a);
        Node idL3 = createSinglyList(id3a);
        System.out.print("Case 1  List1 : ");
        printSinglyList(idL1);
        System.out.print("Case 1  List2 : ");
        printSinglyList(idL2);
        System.out.print("Case 1  List3 : ");
        printSinglyList(idL3);
        Node studentId1 = idGenerator(idL1, idL2, idL3);
        System.out.print("Output        : ");
        printSinglyList(studentId1);
        System.out.println();

        Object[] id1b = {0, 3, 9, 1};
        Object[] id2b = {3, 6, 5, 7};
        Object[] id3b = {2, 4, 3, 8};
        idL1 = createSinglyList(id1b);
        idL2 = createSinglyList(id2b);
        idL3 = createSinglyList(id3b);
        System.out.print("Case 2  List1 : ");
        printSinglyList(idL1);
        System.out.print("Case 2  List2 : ");
        printSinglyList(idL2);
        System.out.print("Case 2  List3 : ");
        printSinglyList(idL3);
        Node studentId2 = idGenerator(idL1, idL2, idL3);
        System.out.print("Output        : ");
        printSinglyList(studentId2);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 5 : SUM ODD APPEND");
        System.out.println("=====================================================");

        Object[] odds = {11, 22, 33, 44, 55, 66};
        Node circle = createDummySinglyCircular(odds);
        System.out.print("Given  : ");
        printDummySinglyCircular(circle);
        sumOddAppend(circle);
        System.out.print("Output : ");
        printDummySinglyCircular(circle);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 6 : PAIR JOIN");
        System.out.println("=====================================================");

        Object[] pj1 = {"A", "B", "C", "D"};
        Object[] pj2 = {"E", "F", "G", "H"};
        Node dummy1 = createDummyDoublyCircular(pj1);
        Node dummy2 = createDummyDoublyCircular(pj2);
        System.out.print("List 1 : ");
        printDummyDoublyCircular(dummy1);
        System.out.print("List 2 : ");
        printDummyDoublyCircular(dummy2);
        pairJoin(dummy1, dummy2);
        System.out.print("Output : ");
        printDummyDoublyCircular(dummy1);
        System.out.print("Check  : ");
        printDummyDoublyCircularBackward(dummy1);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println(" TASK 7 : RANGE MOVE");
        System.out.println("=====================================================");

        Object[] rm = {5, 3, 7, 1, 9, 6, 2, 4};
        Node rmList = createDummyDoublyCircular(rm);
        System.out.print("Given  : ");
        printDummyDoublyCircular(rmList);
        System.out.println("Range  : [start, end] = [5, 7]");
        rangeMove(rmList, 5, 7);
        System.out.print("Output : ");
        printDummyDoublyCircular(rmList);
        System.out.print("Check  : ");
        printDummyDoublyCircularBackward(rmList);
    }
}