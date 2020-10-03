public class Process implements Comparable<Process> {
    private int timeToFinish;
    private int arrivalTime;
    private int priorityLevel;
    private int timeNotProcessed;

    public Process(int timeToFinish, int arrivalTime, int priorityLevel) {
        this.timeToFinish = timeToFinish;
        this.arrivalTime = arrivalTime;
        this.priorityLevel = priorityLevel;
        timeNotProcessed = 0;
    }

    public int getTimeRemaining() {
        return timeToFinish;
    }

    public void reduceTimeRemaining() {
        timeToFinish--;
    }

    public boolean finish() {
        return timeToFinish <= 0;
    }

    public int getPriority() {
        return priorityLevel;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void resetTimeNotProcessed() {
        timeNotProcessed = 0;
    }

    public void incrementTimeNotProcessed() {
        timeNotProcessed++;
    }

    public int getTimeNotProcessed() {
        return timeNotProcessed;
    }

    public void setTimeNotProcessed(int time) {
        timeNotProcessed = time;
    }

    public void incrementPriority() {
        priorityLevel++;
    }

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
