package ui;

import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {


    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton buttonCancel;
    private JButton buttonSave;

    private ContactBusiness contactBusiness;

    public ContactForm() {

        //Methods belongs Jframe, use to init frame for our viewers
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2 );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contactBusiness = new ContactBusiness();
        
        setListeners();
    }

    private void setListeners() {

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    String name = textName.getText();
                    String phone = textPhone.getText();

                    contactBusiness.save(name, phone);

                    new MainForm();
                    dispose();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MainForm();
                dispose();
            }
        });
    }
}
