import java.util.ArrayList;
import java.util.List;

public class LinkedNode<T> {
    public final T val;
    public LinkedNode<T> next;

    public LinkedNode(T val) {
        this.val = val;
    }

    public List<T> dumpVals() {
        LinkedNode<T> last = this;
        ArrayList<T> vals = new ArrayList<>();
        while (last != null) {
            vals.add(last.val);
            last = last.next;
        }
        return vals;
    }

}
