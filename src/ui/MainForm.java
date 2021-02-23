package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private String name;
    private String phone;

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

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

                if (listSelectionEvent.getValueIsAdjusting()) {

                    name = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                    phone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    contactBusiness.delete(name, phone);
                    loadContacts();

                    name = "";
                    phone = "";

                }catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                }
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
