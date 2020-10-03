import java.util.Random;

public class ProcessGenerator {
    private double probability;

    public ProcessGenerator(double probability) {
        this.probability = probability;
    }

    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
        Random rand = new Random();
        int timeToFinish = rand.nextInt(maxProcessTime-1) + 1;
        int priorityLevel = rand.nextInt(maxLevel-1) + 1;
        return new Process(timeToFinish, currentTime, priorityLevel);
    }

    public boolean query() {
        return Math.random() < probability;
    }
}
