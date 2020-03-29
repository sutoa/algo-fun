/**
 *
 * Time: O(n+m)
 * Space: O(1)
 */
public class MergeTwoSortedLists<T extends Comparable<T>> {
    public LinkedNode<T> merge(LinkedNode<T> sortedList1, LinkedNode<T> sortedList2) {

        if (sortedList1 == null) {
            return sortedList2;
        }

        if (sortedList2 == null) {
            return sortedList1;
        }

        LinkedNode<T> head = new LinkedNode<>(sortedList1.val);
        LinkedNode<T> tail = head;
        LinkedNode<T> list1Head = sortedList1;
        LinkedNode<T> list2Head = sortedList2;

        while (list1Head != null && list2Head != null) {
            if(list1Head.val.compareTo(list2Head.val) < 0) {
                tail.next = list1Head;
                tail = list1Head;
                list1Head = list1Head.next;
            } else {
                tail.next = list2Head;
                tail = list2Head;
                list2Head = list2Head.next;
            }
        }

        if(list1Head == null) {
            tail.next = list2Head;
        }

        if(list2Head == null) {
            tail.next = list1Head;
        }

        return head.next;
    }
}
