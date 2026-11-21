package LinkedList;

class Basic_LinkedList {
    public static void main(String[] args) {
        
    }
    
}


/*
 * **Definition & Structure:**
* A linear data structure where elements (`Node`s) are stored as separate objects in memory and linked together via references (`next`, and `prev` in doubly linked lists), starting from a `head` reference and ending at `null`.
* Unlike contiguous arrays or `ArrayList`s, nodes do not sit in adjacent memory blocks, so elements cannot be accessed directly by index in O(1) time.



* **Types of Linked Lists:**
* **Singly Linked List:** Each node stores `data` and a single `next` pointer; traversal moves in one direction (`head` to `null`).
* **Doubly Linked List:** Each node stores `data`, `next`, and `prev` pointers, allowing forward and backward traversal and easier deletion when you already hold a node reference.
* **Circular Linked List:** The last node's `next` points back to `head` (or another node) instead of `null`, forming a ring; useful for round-robin scheduling or cycle detection.


* **Time & Space Complexity:**
* **Access / Search by value or index:** O(n) time because you must walk node-by-node from `head`.
* **Insert or Delete at head:** O(1) time once you have the `head` reference (no shifting of elements like an array).
* **Insert or Delete at tail:** O(1) time only if you maintain a `tail` pointer (and `prev` in a doubly linked list for tail deletion); otherwise O(n) to reach the end.
* **Auxiliary Space:** O(1) for iterative pointer updates; O(n) call-stack space for recursive traversal or reversal.


* **Core Operations & Pointer Mechanics:**
* **Traversal:** Start `curr = head`, loop while `curr != null`, read `curr.val`, and advance `curr = curr.next`.
* **Insertion:** Point `newNode.next` to the target next node first so you do not lose the rest of the list, then update the predecessor's `next` (or `head`) to `newNode`.
* **Deletion:** Locate the node before the target (`prev`) and set `prev.next = prev.next.next` to bypass and unlink the target node.
* **Iterative Reversal:** Maintain `prev = null` and `curr = head`; in each step, save `nextTemp = curr.next`, set `curr.next = prev`, move `prev = curr`, and move `curr = nextTemp`, returning `prev` at the end.
* **Recursive Reversal:** Base case returns `head` when `head == null || head.next == null`; after recursing on `head.next`, attach `head` at the end via `head.next.next = head`, set `head.next = null`, and pass `newHead` upward.


* **High-Value Patterns for Your ADSA 1 Exam:**
* **Dummy (`Sentinel`) Head:** Create a fake node pointing to `head` (`dummy.next = head`) before deleting or rearranging nodes so removing or changing the actual `head` follows the exact same code path as any other node.
* **Fast & Slow Pointers (Tortoise & Hare):** Move `slow` by 1 step and `fast` by 2 steps (`slow = slow.next`, `fast = fast.next.next`) to find the middle node in a single pass or detect a cycle (`slow == fast`).
* **Bridge to Trees & Recursion:** Rewiring `next` links and returning updated node references up the call stack builds the exact mental model used in **BST insertion/deletion**, **Morris inorder traversal** (temporary threaded links), and **LCA** problems.


* **Common Pitfalls & Edge Cases:**
* **Losing the list or creating cycles:** Always save `curr.next` before overwriting `curr.next`, and never leave an old forward pointer dangling when reversing or re-linking.
* **NullPointerException on `curr.next` or `fast.next.next`:** Always check `curr != null` (or `fast != null && fast.next != null`) before dereferencing `.next`.
* **Empty list (`head == null`) or single-node list (`head.next == null`):** Test both explicitly on every function before moving on.
 */