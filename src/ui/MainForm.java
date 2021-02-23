package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {

    private JPanel rootPanel;
    private JButton buttonRemove;
    private JButton buttonNewContact;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness contactBusiness;

    public MainForm() {

        //Methods belongs Jframe, use to init frame for our viewers
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        //Put the painel in the middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2 );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contactBusiness = new ContactBusiness();

        setListeners();
        loadContacts();
    }

    private void setListeners() {

        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm();
                dispose();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void loadContacts() {

        List<ContactEntity> contactList = contactBusiness.getList();

        String[] columnNames = {"Name", "Phone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for(ContactEntity i : contactList) {

            Object[] o = new Object[2];

            o[0] = i.getName();
            o[1] = i.getPhone();

            model.addRow(o);
        }

        tableContacts.clearSelection();
        tableContacts.setModel(model);

        labelContactCount.setText(contactBusiness.getContactCountDescription());
    }
}
