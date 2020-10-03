import java.util.ArrayList;

public class MaxHeap<Process extends Comparable<? super Process>> {
    private ArrayList<Process> heap;
    private int n;
    private int size;

    public MaxHeap(ArrayList<Process> h, int num) {
        heap = h;
        n = num;
    }

    public Process getProcess(int pos) {
        return heap.get(pos);
    }

    public int heapSize() {
        return heap.size();
    }

    public void heapify(int pos) {
        if ((pos >= 0) && (pos < n) && (heap.get(pos).compareTo(heap.get(parent(pos))) > 0)) {
            Process currentElement = heap.get(pos);
            heap.set(pos, heap.get(parent(pos)));
            heap.set(parent(pos), currentElement);
            heapify(parent(pos));
        }
    }

    public boolean isLeaf(int pos) {
        return (pos >= n/2) && (pos < n);
    }

    public int leftChild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    public int rightChild(int pos) {
        assert pos < (n-1)/2 : "Position has no right child";
        return 2*pos + 2;
    }

    public int parent(int pos) {
        assert pos > 0 : "Position has no parent";
        return (pos-1)/2;
    }

    public void swap(int curr, int parent) {
        Process currentElement = heap.get(curr);
        heap.set(curr, heap.get(parent));
        heap.set(parent, currentElement);
    }

    public void insert(Process val) {
        int curr = n++;
        heap.add(curr, val);
//        while ((curr != 0) && (heap.get(curr).compareTo(heap.get(parent(curr))) > 0)) {
//            swap(curr, parent(curr));
//            curr = parent(curr);
//        }
        heapify(curr);
        buildHeap();
    }

    public void buildHeap() {
        for(int i = n/2-1; i>=0; i--) {
            siftdown(i);
        }
    }

    public Process extractMax() {
        assert n > 0 : "No max to extract";
        Process retVal = heap.remove(0);
        n--;
        siftdown(0);
        return retVal;
    }

    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) : "Illegal heap position";
        while(!isLeaf(pos)) {
            int j = 0;
            if (heap.get(leftChild(pos)).compareTo(heap.get(rightChild(pos))) < 0) {
                j = rightChild(pos);
            }
            else {
                j = leftChild(pos);
            }
            if ((j < (n-1)) && (heap.get(j).compareTo(heap.get(j+1)) < 0)) {
                j++;
            }
            if (heap.get(pos).compareTo(heap.get(j)) >= 0) return;
            swap(pos, j);
            pos = j;
        }
    }

    public String toString() {
        String retVal = "";
        for (int i = 0; i < n; i++) {
            retVal += heap.get(i).toString() + " ";
        }
        return retVal;
    }
}
