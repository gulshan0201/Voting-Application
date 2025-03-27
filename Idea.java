public class Idea {
    private static int counter = 1;
    private int id;
    private String title;
    private String description;
    private String status; // Submitted, Approved, Rejected
    private int votes;

    public Idea(String title, String description) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.status = "Submitted";
        this.votes = 0;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }
}
