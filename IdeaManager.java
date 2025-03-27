// import java.util.ArrayList;
// import java.util.List;

// public class IdeaManager {
//     private List<Idea> ideas = new ArrayList<>();

//     public void submitIdea(String title, String description) {
//         ideas.add(new Idea(title, description));
//     }

//     public List<Idea> getAllIdeas() {
//         return ideas;
//     }

//     public void approveIdea(int id) {
//         for (Idea idea : ideas) {
//             if (idea.getId() == id) {
//                 idea.setStatus("Approved");
//                 return;
//             }
//         }
//     }

//     public void rejectIdea(int id) {
//         for (Idea idea : ideas) {
//             if (idea.getId() == id) {
//                 idea.setStatus("Rejected");
//                 return;
//             }
//         }
//     }

//     public void voteIdea(int id) {
//         for (Idea idea : ideas) {
//             if (idea.getId() == id && idea.getStatus().equals("Approved")) {
//                 idea.setVotes(idea.getVotes() + 1);
//                 return;
//             }
//         }
//     }
// }

import java.util.ArrayList;
import java.util.List;

public class IdeaManager {
    private List<Idea> ideas = new ArrayList<>();

    // Submit a new idea
    public void submitIdea(String title, String description) {
        ideas.add(new Idea(title, description));
    }

    // Get all ideas
    public List<Idea> getAllIdeas() {
        return ideas;
    }

    // Approve an idea
    public void approveIdea(int id) {
        for (Idea idea : ideas) {
            if (idea.getId() == id) {
                idea.setStatus("Approved");
                return;
            }
        }
    }

    // Reject an idea
    public void rejectIdea(int id) {
        for (Idea idea : ideas) {
            if (idea.getId() == id) {
                idea.setStatus("Rejected");
                return;
            }
        }
    }

    // Cast a vote for an idea (Only for Approved ideas)
    public boolean voteIdea(int id) {
        for (Idea idea : ideas) {
            if (idea.getId() == id) {
                if (idea.getStatus().equals("Approved")) {
                    idea.setVotes(idea.getVotes() + 1);
                    return true; // Successfully voted
                }
                return false; // Idea is not approved
            }
        }
        return false; // Idea not found
    }
}

