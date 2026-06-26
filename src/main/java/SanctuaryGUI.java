import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class SanctuaryGUI extends JFrame implements ActionListener, KeyListener {
    private Sanctuary sanctuary;
    private JTextField text;
    private JComboBox<String> combo;
    private JCheckBox checkBx;
    private JLabel label;
    private JButton button;

    public SanctuaryGUI(){
        setTitle(sanctuary.getName());
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        text = new JTextField();
        add(text);
        combo = new JComboBox<>();
        add(combo);
        checkBx = new JCheckBox();
        add(checkBx);
        label = new JLabel();
        add(label);
        button = new JButton();
        add(button);
        button.addActionListener(this);
        text.addKeyListener(this);
    }

    public void setModel(Sanctuary s){
        this.sanctuary = s;
        setTitle(this.sanctuary.getName());
    }

    public void runSearch(){
        String t = text.getText().trim().toLowerCase();
        String type = (String) combo.getSelectedItem();
        boolean injuredOnly = checkBx.isSelected();

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(Animal a : sanctuary.getAnimals()){
            boolean match = true;

            if(!t.isEmpty()){
                boolean speciesMatch = a.getSpecies().toLowerCase().contains(t);
                boolean nicknameMatch = a.getNickname().toLowerCase().contains(t);

                if (!speciesMatch && !nicknameMatch)
                    match = false;
            }

            if (!type.equals("All")) {
                if (!a.getType().equals(type))
                    match = false;
            }

            if (injuredOnly) {
                String health = a.getHealthStatus();

                if (!(health.equals("Injured") || health.equals("Critical")))
                    match = false;
            }

            if (match) {
                sb.append(a.toString()).append("\n");
                count++;
            }
        }

        text.setText(sb.toString());

        if (count == 0)
            label.setText("No matches");
        else if (count == 1)
            label.setText("1 result");
        else
            label.setText(count + " results");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        runSearch();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        runSearch();
    }

    public static void main(String[] args){
        Sanctuary caroni = new Sanctuary("Caroni", "Trinidad", 20);

        Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird b2 = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird b3 = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile r = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile r2 = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine m = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(b);
        caroni.addAnimal(b2);
        caroni.addAnimal(b3);
        caroni.addAnimal(m);
        caroni.addAnimal(r);
        caroni.addAnimal(r2);

        SanctuaryGUI s = new SanctuaryGUI();

        s.setModel(caroni);

        s.setVisible(true);
    }

}
