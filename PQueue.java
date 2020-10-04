import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * The PQueue class represents a priority queue that implements a maxheap. Processes
 * in the queue can be updated with the update method.
 *
 * @author chloejohnson
 */
public class PQueue {
    private ArrayList<Process> array;
    private MaxHeap<Process> queue;
    private int cnt;

    /**
     * Creates a new PQueue from a maxheap.
     */
    public PQueue() {
        array = new ArrayList<>();
        queue = new MaxHeap<Process>(array, 0);
        cnt = 0;
    }

    /**
     * Adds a process to the queue.
     * @param p
     */
    public void enPQueue(Process p) {
        cnt++;
        queue.insert(p);
    }

    /**
     * Checks if the queue is empty and returns true if it is.
     * @return boolean
     */
    public boolean isEmpty() {
        return (cnt == 0);
    }

    /**
     * Removes the highest priority element from the queue and returns it.
     * @return Process
     */
    public Process dePQueue() {
        cnt--;
        return queue.extractMax();
    }

    /**
     * Updates the queue if it isn't empty. For each process, the time not processed
     * is incremented. If the time not processed is greater or equal to the time
     * given to increment the level, the time not processed is reset to 0 and the
     * priority level is checked. If the priority level is less than the allowed
     * maximum level, the priority is incremented and the heap is rearranged so
     * each process is in the correct place.
     *
     * @param timeToIncrementLevel
     * @param maxLevel
     */
    public void update(int timeToIncrementLevel, int maxLevel) {
        if (!isEmpty()) {
            for (int i = 0; i < cnt; i++) {
                queue.getProcess(i).incrementTimeNotProcessed();
                if (queue.getProcess(i).getTimeNotProcessed() >= timeToIncrementLevel) {
                    queue.getProcess(i).resetTimeNotProcessed();
                    if (queue.getProcess(i).getPriority() < maxLevel) {
                        queue.getProcess(i).incrementPriority();
                        queue.buildHeap();
                    }
                }
            }
        }
    }
}
