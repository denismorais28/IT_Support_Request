import java.util.ArrayList;
import java.util.List;

public class ITStore {

    // Data sotre
    private List<ITRequest> requests;

    public ITStore() {
        this.requests = new ArrayList<>();
    }

    // Methods

    /**
     * Add a new ITRequest
     *
     * @param itRequest ITRequest instance
     */
    public void addITRequest(ITRequest itRequest) {
        requests.add(itRequest);
    }

    /**
     * Get the last inserted ITRequest
     *
     * @return A ITRequest instance
     */
    public ITRequest getLastITRequest() {
        if (requests.isEmpty()) {
            return null;

        }

        return requests.get(requests.size() - 1);

    }

    /**
     * Get the ITRequest wiht the highest priority at moment
     *
     * @return A IT Request instance
     */
    public ITRequest getHighestPriority() {
        ITRequest highestRequest = null;
        for (ITRequest request : requests) {
            if (highestRequest == null || request.getPriority() < highestRequest.getPriority()) {
                highestRequest = request;
            }

        }
        return highestRequest;
    }

    /**
     * Get the ITRequest wiht the lowest priority at moment
     *
     * @return AnITRequest instance
     */
    public ITRequest getLowestPriority() {
        ITRequest lowestRequest = null;
        for (ITRequest request : requests) {
            if (lowestRequest == null || request.getPriority() > lowestRequest.getPriority()) {
                lowestRequest = request;
            }

        }
        return lowestRequest;
    }

    /**
     * Get the average value of priorities
     *
     * @return The avg value
     */
    public float getAverageValue() {
        if (requests.isEmpty()) {
            return 0;
        }

        int prioritySum = 0;
        for (ITRequest request : requests) {
            prioritySum += request.getPriority();
        }
        return prioritySum / requests.size();
    }

    /**
     * Get the average priority
     *
     * @return Priority code
     */
    public int getAveragePriority() {
        if (requests.isEmpty()) {
            return 0;
        }
        int sumHigh, sumLow, sumMedium;
        sumHigh = sumLow = sumMedium = 0;
        for (ITRequest request : requests) {
            if (request.getPriority() == 1) {
                sumHigh++;
            } else if (request.getPriority() == 2) {
                sumMedium++;
            } else {
                sumLow++;

            }
        }
        if (sumHigh > sumMedium && sumHigh > sumLow) {
            return 1;
        } else if (sumMedium > sumHigh && sumMedium > sumLow) {
            return 2;
        } else if (sumLow > sumHigh && sumLow > sumMedium) {
            return 3;
        } else {
            return 4;
        }

    }
}

