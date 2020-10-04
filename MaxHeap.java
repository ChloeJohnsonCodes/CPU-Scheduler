import java.util.ArrayList;

/**
 * The MaxHeap class uses an array list to build a maxheap that contains processes.
 * Processes are inserted at the back of the list and moved up depending on their
 * priority. Processes with greater priorities will be at the top of the list.
 * Maximum priority processes are removed first.
 *
 * @author chloejohnson
 *
 * @param <Process>
 */

public class MaxHeap<Process extends Comparable<? super Process>> {
    private ArrayList<Process> heap;
    private int n;

    /**
     * Creates a new heap from the given array list, and number of processes.
     *
     * @param h
     * @param num
     */
    public MaxHeap(ArrayList<Process> h, int num) {
        heap = h;
        n = num;
    }

    /**
     * Gets the process in the heap at the given position.
     *
     * @param pos
     * @return Process
     */
    public Process getProcess(int pos) {
        return heap.get(pos);
    }

    /**
     * Checks to see if a position is a leaf in the heap. If it is a leaf,
     * the position returns true.
     * @param pos
     * @return boolean
     */
    public boolean isLeaf(int pos) {
        return (pos >= n/2) && (pos < n);
    }

    /**
     * If a position has a left child, this method returns the position of its child.
     * @param pos
     * @return int
     */
    public int leftChild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    /**
     * If a position has a parent, this method returns the position of the parent.
     * @param pos
     * @return int
     */
    public int parent(int pos) {
        assert pos > 0 : "Position has no parent";
        return (pos-1)/2;
    }

    /**
     * Swaps the position of two processes in the heap.
     * @param curr
     * @param parent
     */
    public void swap(int curr, int parent) {
        Process currentElement = heap.get(curr);
        heap.set(curr, heap.get(parent));
        heap.set(parent, currentElement);
    }

    /**
     * Adds a process to the back of the heap and moves it up when necessary.
     * @param val
     */
    public void insert(Process val) {
        int curr = n++;
        heap.add(curr, val);
        while ((curr != 0) && (heap.get(curr).compareTo(heap.get(parent(curr))) > 0)) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    /**
     * Rearranges the heap so that higher priority items are on top.
     */
    public void buildHeap() {
        for(int i = n/2-1; i>=0; i--) {
            siftdown(i);
        }
    }

    /**
     * Removes the process on the top of the heap and returns it.
     * @return Process
     */
    public Process extractMax() {
        assert n > 0 : "No max to extract";
        swap(0, --n);
        if (n != 0) {
            siftdown(0);
        }
        return heap.get(n);
    }

    /**
     * Moves a process down to the correct place.
     * @param pos
     */
    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        while(!isLeaf(pos)) {
            int j = leftChild(pos);
            if ((j < (n-1)) && (heap.get(j).compareTo(heap.get(j+1)) < 0)) {
                j++;
            }
            if (heap.get(pos).compareTo(heap.get(j)) >= 0) return;
            swap(pos, j);
            pos = j;
        }
    }
}
