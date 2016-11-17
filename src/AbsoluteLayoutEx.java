import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AbsoluteLayoutEx extends JFrame {

    public AbsoluteLayoutEx() {

        initUI();
    }

    private void initUI() {

        setLayout(null);

        JButton okBtn = new JButton("OK");
        okBtn.setBounds(50, 50, 80, 25);

        JButton clsBtn = new JButton("Close");
        clsBtn.setBounds(150, 50, 80, 25);

        add(okBtn);
        add(clsBtn);

        setTitle("Absolute positioning");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            AbsoluteLayoutEx ex = new AbsoluteLayoutEx();
            ex.setVisible(true);
        });
    }
}