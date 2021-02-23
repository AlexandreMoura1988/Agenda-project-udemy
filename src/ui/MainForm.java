package ui;

import javax.swing.*;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonRemove;
    private JButton buttonNewContact;
    private JTable tableContacts;

    public MainForm() {

        //Methods belongs Jframe, use to init frame for our viewers
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);
    }
}
