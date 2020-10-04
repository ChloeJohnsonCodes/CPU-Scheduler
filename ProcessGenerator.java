import java.util.Random;

/**
 * The ProcessGenerator class creates new processes and checks if processes can be created.
 */
public class ProcessGenerator {
    private double probability;

    /**
     * Creates a ProcessGenerator with the given probability.
     * @param probability
     */
    public ProcessGenerator(double probability) {
        this.probability = probability;
    }

    /**
     * Gets a new process based on the given current time, the maximum process time,
     * and the maximum priority level. The time to finish the process and the priority
     * level are randomly generated.
     * @param currentTime
     * @param maxProcessTime
     * @param maxLevel
     * @return Process
     */
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
        Random rand = new Random();
        int timeToFinish = rand.nextInt(maxProcessTime-1) + 1;
        int priorityLevel = rand.nextInt(maxLevel-1) + 1;
        return new Process(timeToFinish, currentTime, priorityLevel);
    }

    /**
     * Checks if a new process can be created.
     * @return boolean
     */
    public boolean query() {
        return Math.random() < probability;
    }
}
