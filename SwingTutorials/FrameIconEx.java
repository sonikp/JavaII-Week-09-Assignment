import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameIconEx extends JFrame {

    public FrameIconEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        ImageIcon webIcon = new ImageIcon("/Users/Shared/Java-Libraries/CourseCD/mediasources/arch.jpg");

        setIconImage(webIcon.getImage());

        setTitle("Icon");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            FrameIconEx ex = new FrameIconEx();
            ex.setVisible(true);
        });
    }
}