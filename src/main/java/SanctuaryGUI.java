import javax.swing.*;
import java.awt.*;

public class SanctuaryGUI extends JFrame {
    private Sanctuary sanctuary;
    private JTextField text;

    public SanctuaryGUI(){
        setTitle(sanctuary.getName());
        text = new JTextField();
        add(text);
    }

    public void setModel(Sanctuary s){
        this.sanctuary = s;
        setTitle(this.sanctuary.getName());
    }

    public void runSearch(){
        String t = text.getText().trim().toLowerCase();
    }
}
