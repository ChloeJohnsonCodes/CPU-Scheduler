import java.util.ArrayList;
import java.util.PriorityQueue;

public class PQueue {
    private ArrayList<Process> array;
    private MaxHeap<Process> queue;
    private int cnt;

    public PQueue() {
        array = new ArrayList<>();
        queue = new MaxHeap<Process>(array, 0);
        cnt = 0;
    }

    public void enPQueue(Process p) {
        cnt++;
        queue.insert(p);
    }

    public boolean isEmpty() {
        return (cnt == 0);
    }

    public Process dePQueue() {
        cnt--;
        return queue.extractMax();
    }
    public void update(int timeToIncrementLevel, int maxLevel) {
        if (!isEmpty()) {
            for (int i = 0; i < cnt; i++) {
                queue.getProcess(i).incrementTimeNotProcessed();
                if (queue.getProcess(i).getTimeNotProcessed() >= timeToIncrementLevel) {
                    queue.getProcess(i).resetTimeNotProcessed();
                    if (queue.getProcess(i).getPriority() < maxLevel) {
                        queue.getProcess(i).incrementPriority();
                        queue.heapify(i);
                    }
                }
            }
        }
    }
}
