/**
 * The Process class represents a CPU process with an arrival time,
 * a priority level, and the time the process has to finish.
 */
public class Process implements Comparable<Process> {
    private int timeToFinish;
    private int arrivalTime;
    private int priorityLevel;
    private int timeNotProcessed;

    /**
     * Creates a process from the given time to finish, the given arrival time,
     * and the given priority level. It is also assigned the time not processed.
     *
     * @param timeToFinish
     * @param arrivalTime
     * @param priorityLevel
     */
    public Process(int timeToFinish, int arrivalTime, int priorityLevel) {
        this.timeToFinish = timeToFinish;
        this.arrivalTime = arrivalTime;
        this.priorityLevel = priorityLevel;
        timeNotProcessed = 0;
    }

    /**
     * Gets the time remaining for the process to finish.
     * @return int
     */
    public int getTimeRemaining() {
        return timeToFinish;
    }

    /**
     * Decrements the time remaining for the process to finish.
     */
    public void reduceTimeRemaining() {
        timeToFinish--;
    }

    /**
     * Checks if the time remaining for the process to finish is less or equal to
     * 0. If it is, it returns true.
     * @return boolean
     */
    public boolean finish() {
        return timeToFinish <= 0;
    }

    /**
     * Gets the priority of the process.
     * @return int
     */
    public int getPriority() {
        return priorityLevel;
    }

    /**
     * Gets the arrival time of the process.
     * @return int
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the time not processed to 0.
     */
    public void resetTimeNotProcessed() {
        timeNotProcessed = 0;
    }

    /**
     * Increments the time not processed.
     */
    public void incrementTimeNotProcessed() {
        timeNotProcessed++;
    }

    /**
     * Gets the time not processed.
     * @return int
     */
    public int getTimeNotProcessed() {
        return timeNotProcessed;
    }

    /**
     * Increments the priority level.
     */
    public void incrementPriority() {
        priorityLevel++;
    }

    /**
     * Compares the priority level and returns 1 if the priority level
     * is greater and -1 if the priority level is less. If the priority levels
     * are equal, it checks the arrival time and returns 1 if the arrival time is
     * less. If the arrival time is greater, it returns -1.
     * @param p
     * @return int
     */
    @Override
    public int compareTo(Process p) {
        if (priorityLevel > p.getPriority()) {
            return 1;
        }
        else if (priorityLevel < p.getPriority()){
            return -1;
        }
        else {
            if (arrivalTime > p.getArrivalTime()) {
                return -1;
            }
            else if (arrivalTime < p.getArrivalTime()) {
                return 1;
            }
        }
        return 0;
    }
}
