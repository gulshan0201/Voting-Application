// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;

// public class SystemUI {
//     private static IdeaManager ideaManager = new IdeaManager();

//     public static void launchUI() {
//         JFrame frame = new JFrame("IMS-Connect System");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);

//         JPanel panel = new JPanel(new BorderLayout());

//         // Table to display ideas
//         String[] columns = {"ID", "Title", "Description", "Status", "Votes"};
//         DefaultTableModel model = new DefaultTableModel(columns, 0);
//         JTable table = new JTable(model);
//         JScrollPane scrollPane = new JScrollPane(table);
//         panel.add(scrollPane, BorderLayout.CENTER);

//         // Form to submit ideas
//         JPanel formPanel = new JPanel(new FlowLayout());
//         JTextField titleField = new JTextField(10);
//         JTextField descriptionField = new JTextField(15);
//         JButton submitButton = new JButton("Submit Idea");
//         formPanel.add(new JLabel("Title:"));
//         formPanel.add(titleField);
//         formPanel.add(new JLabel("Description:"));
//         formPanel.add(descriptionField);
//         formPanel.add(submitButton);
//         panel.add(formPanel, BorderLayout.NORTH);

//         // Buttons for actions
//         JPanel buttonPanel = new JPanel(new FlowLayout());
//         JButton approveButton = new JButton("Approve Idea");
//         JButton rejectButton = new JButton("Reject Idea");
//         JButton voteButton = new JButton("Vote Idea");
//         buttonPanel.add(approveButton);
//         buttonPanel.add(rejectButton);
//         buttonPanel.add(voteButton);
//         panel.add(buttonPanel, BorderLayout.SOUTH);

//         // Submit Idea Action
//         submitButton.addActionListener((ActionEvent e) -> {
//             String title = titleField.getText();
//             String description = descriptionField.getText();
//             ideaManager.submitIdea(title, description);
//             updateTable(model);
//             titleField.setText("");
//             descriptionField.setText("");
//         });

//         // Approve Idea Action
//         approveButton.addActionListener((ActionEvent e) -> {
//             String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Approve:");
//             int id = Integer.parseInt(idStr);
//             ideaManager.approveIdea(id);
//             updateTable(model);
//         });

//         // Reject Idea Action
//         rejectButton.addActionListener((ActionEvent e) -> {
//             String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Reject:");
//             int id = Integer.parseInt(idStr);
//             ideaManager.rejectIdea(id);
//             updateTable(model);
//         });

//         // Vote Idea Action
//         voteButton.addActionListener((ActionEvent e) -> {
//             String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Vote:");
//             int id = Integer.parseInt(idStr);
//             ideaManager.voteIdea(id);
//             updateTable(model);
//         });

//         frame.add(panel);
//         frame.setVisible(true);
//     }

//     private static void updateTable(DefaultTableModel model) {
//         model.setRowCount(0);
//         for (Idea idea : ideaManager.getAllIdeas()) {
//             model.addRow(new Object[]{idea.getId(), idea.getTitle(), idea.getDescription(), idea.getStatus(), idea.getVotes()});
//         }
//     }
// }


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SystemUI {
    private static IdeaManager ideaManager = new IdeaManager();

    public static void launchUI() {
        JFrame frame = new JFrame("IMS-Connect System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new BorderLayout());

        // Table to display ideas
        String[] columns = {"ID", "Title", "Description", "Status", "Votes"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Form to submit ideas
        JPanel formPanel = new JPanel(new FlowLayout());
        JTextField titleField = new JTextField(10);
        JTextField descriptionField = new JTextField(15);
        JButton submitButton = new JButton("Submit Idea");
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descriptionField);
        formPanel.add(submitButton);
        panel.add(formPanel, BorderLayout.NORTH);

        // Buttons for actions
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton approveButton = new JButton("Approve Idea");
        JButton rejectButton = new JButton("Reject Idea");
        JButton voteButton = new JButton("Vote Idea");
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(voteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Submit Idea Action
        submitButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String description = descriptionField.getText();
            ideaManager.submitIdea(title, description);
            updateTable(model);
            titleField.setText("");
            descriptionField.setText("");
        });

        // Approve Idea Action
        approveButton.addActionListener((ActionEvent e) -> {
            String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Approve:");
            try {
                int id = Integer.parseInt(idStr);
                ideaManager.approveIdea(id);
                updateTable(model);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID entered!");
            }
        });

        // Reject Idea Action
        rejectButton.addActionListener((ActionEvent e) -> {
            String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Reject:");
            try {
                int id = Integer.parseInt(idStr);
                ideaManager.rejectIdea(id);
                updateTable(model);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID entered!");
            }
        });

        // Vote Idea Action
        voteButton.addActionListener((ActionEvent e) -> {
            String idStr = JOptionPane.showInputDialog(frame, "Enter Idea ID to Vote:");
            try {
                int id = Integer.parseInt(idStr);
                boolean voted = ideaManager.voteIdea(id);
                if (voted) {
                    updateTable(model);
                    JOptionPane.showMessageDialog(frame, "Vote added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Cannot vote on this idea. Make sure it is approved!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID entered!");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void updateTable(DefaultTableModel model) {
        model.setRowCount(0);
        for (Idea idea : ideaManager.getAllIdeas()) {
            model.addRow(new Object[]{idea.getId(), idea.getTitle(), idea.getDescription(), idea.getStatus(), idea.getVotes()});
        }
    }
}
