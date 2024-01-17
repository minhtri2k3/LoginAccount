import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JlistExample {
     public static void main(String[] args) {
        JFrame frame = new JFrame("JList Example");

        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        JList<String> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // This block of code will be executed when the selection changes
                    System.out.println("Selected: " + list.getSelectedValue());
                }
            }
        };

        // Adding the ListSelectionListener to the JList
        list.addListSelectionListener(selectionListener);

        JScrollPane scrollPane = new JScrollPane(list);
        frame.getContentPane().add(scrollPane);
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
