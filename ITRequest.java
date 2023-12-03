public class ITRequest {
    // Mandatory field
    private int priority;

    // Custom field
    private String description;
    private String requester;
    private float cost;

    // Contructors
    public ITRequest() {
    }

    /**
     * Create a new ITRequest instance
     *
     * @param priority    integer betwen 1 an 3
     * @param description description text
     * @param requester   requester name
     * @param cost        the cost value of request
     */
    public ITRequest(int priority, String description, String requester, float cost) {
        this.priority = priority;
        this.description = description;
        this.requester = requester;
        this.cost = cost;
    }

    // Getters and Setters
    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getRequester() {
        return requester;
    }

    public float getCost() {
        return cost;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "IT Request: Priority -->" + priorityStatus() + " Description: " + this.description + " Requester: "
                + this.requester + " Cost E: " + this.cost;
    }

    // Methods
    /**
     * Get priority status as text
     *
     * @return priority string
     */
    public String priorityStatus() {
        if (this.priority == 1) {
            return "High";
        } else if (this.priority == 2) {
            return "Medium";
        } else {
            return "Low";
        }
    }


    /**
     * Get priority status as text
     *
     * @return priority string
     */
    public static String priorityStatus(int priority) {
        if (priority == 1) {
            return "High";
        } else if (priority == 2) {
            return "Medium";
        } else {
            return "Low";
        }
    }

}


