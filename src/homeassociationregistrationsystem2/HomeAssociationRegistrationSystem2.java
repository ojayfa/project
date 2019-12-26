/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeassociationregistrationsystem2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class HomeAssociationRegistrationSystem2 {

    ArrayList<info> infolist = new ArrayList<info>();
    String header[] = new String[]{"House Type", "Name", "Address", "IC Number", "Plot Number"};
    DefaultTableModel dtm = new DefaultTableModel(header, 1);

    HomeAssociationRegistrationSystem2()  {

        JFrame frame = new JFrame("Home Owner Assosiation Registration System");
        frame.setSize(550, 550);

        JLabel jlabel = new JLabel("House Type");
        jlabel.setBounds(10, 10, 100, 20);
        frame.add(jlabel);

        JLabel jlabela = new JLabel("Owner Name");
        jlabela.setBounds(10, 30, 100, 20);
        frame.add(jlabela);

        JLabel jlabelb = new JLabel("Address");
        jlabelb.setBounds(10, 50, 100, 20);
        frame.add(jlabelb);

        JLabel jlabelc = new JLabel("IC Number");
        jlabelc.setBounds(10, 70, 100, 20);
        frame.add(jlabelc);

        JLabel jlabeld = new JLabel("Plot Number");
        jlabeld.setBounds(10, 90, 100, 20);
        frame.add(jlabeld);

        JTextField jtfhousetype = new JTextField();
        jtfhousetype.setBounds(110, 10, 200, 20);
        frame.add(jtfhousetype);

        JTextField jtfname= new JTextField();
        jtfname.setBounds(110, 30, 200, 20);
        frame.add(jtfname);

        JTextField jtfaddress = new JTextField();
        jtfaddress.setBounds(110, 50, 200, 20);
        frame.add(jtfaddress);

        JTextField jtficno = new JTextField();
        jtficno.setBounds(110, 70, 200, 20);
        frame.add(jtficno);

        JTextField jtfplotno = new JTextField();
        jtfplotno.setBounds(110, 90, 200, 20);
        frame.add(jtfplotno);

        JButton jbuttoninsert = new JButton("INSERT");
        jbuttoninsert.setBounds(110, 120, 90, 20);
        frame.add(jbuttoninsert);

        JButton jbuttondelete = new JButton("DELETE");
        jbuttondelete.setBounds(210, 120, 90, 20);
        frame.add(jbuttondelete);

        JButton jbuttonsearch = new JButton("SEARCH");
        jbuttonsearch.setBounds(110, 150, 90, 20);
        frame.add(jbuttonsearch);

        JButton jbuttonupdate = new JButton("UPDATE");
        jbuttonupdate.setBounds(210, 150, 90, 20);
        frame.add(jbuttonupdate);

        JButton jbuttonexit = new JButton("EXIT");
        jbuttonexit.setBounds(380, 460, 90, 20);
        frame.add(jbuttonexit);

        //table creation
        JTable jtable = new JTable();
        jtable.setBounds(20, 200, 400, 450);
        frame.add(jtable);
        jtable.setModel(dtm);
        JScrollPane scrollPane = new JScrollPane(jtable);
        scrollPane.setBounds(20, 200, 500, 250);
        frame.add(scrollPane);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(250);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(250);

        jbuttoninsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String housetype = jtfhousetype.getText();
                String name = jtfname.getText().toUpperCase();
                String address = jtfaddress.getText();
                String icno = jtficno.getText();
                String plotno = jtfplotno.getText();

                info info = new info (housetype, name, address, icno, plotno);
                infolist.add(info);//create object list array
                writeData();
            }
        });

        jbuttondelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String housetype = JOptionPane.showInputDialog("Type of House to delete?");
                if (housetype != null) {
                    System.out.println("not null");
                    JOptionPane.showMessageDialog(frame, "Deleted!!!");
                    for (int i = 0; i < infolist.size(); i++) {
                        if (infolist.get(i).gethousetype().equalsIgnoreCase(housetype)) {
                            infolist.remove(i);
                        }
                    }
                    writeData();
                }
            }
        });

        jbuttonsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String housetype = JOptionPane.showInputDialog("Enter Type of House?");
                if (housetype!= null) {
                    for (int i = 0; i < infolist.size(); i++) {
                        if (infolist.get(i).gethousetype().equalsIgnoreCase(housetype)) {
                            JOptionPane.showMessageDialog(frame, "Found!!!");
                            jtfhousetype.setText(infolist.get(i).gethousetype());
                            jtfname.setText(infolist.get(i).getname());
                            jtfaddress.setText(infolist.get(i).getaddress());
                            jtficno.setText(infolist.get(i).geticno());
                            jtfplotno.setText(infolist.get(i).getplotno());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Not Found!!!");
                }
            }
        });

        jbuttonupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String housetype = jtfhousetype.getText();
                String name = jtfname.getText();
                String address = jtfaddress.getText();
                String icno = jtficno.getText();
                String plotno = jtfplotno.getText();

                if (housetype != null) {
                    for (int i = 0; i < infolist.size(); i++) {
                        if (infolist.get(i).gethousetype().equalsIgnoreCase(housetype)) {
                            infolist.get(i).setname(name);
                            infolist.get(i).setaddress(address);
                            infolist.get(i).seticno(icno);
                            infolist.get(i).setplotno(plotno);
                            JOptionPane.showMessageDialog(frame, "Updated!!!");
                        }
                    }
                }
                writeData();
            }
        });
        jbuttonexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false); //you can't see me!
                frame.dispose();
            }
        });

        readData();
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jtable.getSelectedRow();
                jtfhousetype.setText(dtm.getValueAt(row, 0).toString());
                jtfname.setText(dtm.getValueAt(row, 1).toString());
                jtfaddress.setText(dtm.getValueAt(row, 2).toString());
                jtficno.setText(dtm.getValueAt(row, 3).toString());
                jtfplotno.setText(dtm.getValueAt(row, 4).toString());
            }
        });

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HomeAssociationRegistrationSystem2 homeassociationregistrationsystem = new HomeAssociationRegistrationSystem2();

    }

    void readData() { //read data from "data.txt" and display on table
        try {
            File file = new File("data.txt"); //create file
            file.createNewFile();//if not exit
            FileReader f = new FileReader("data.txt");
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '-') {
                    System.out.println(sb);
                    String infoarray[] = sb.toString().split(",");
                    info info = new info(infoarray[0], infoarray[1], infoarray[2], infoarray[3], infoarray[4]);
                    infolist.add(info);
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            dtm.setRowCount(0); //update table
            for (int i = 0; i < infolist.size(); i++) {//populate table using object list
                Object[] objs = {infolist.get(i).gethousetype(), infolist.get(i).getname(), infolist.get(i).getname(), infolist.get(i).geticno(), infolist.get(i).getplotno()};
                dtm.addRow(objs);
            }
        } catch (IOException e) {
        }
    }

    private void writeData() { //write data to file "data.txt"
        try (FileWriter f = new FileWriter("data.txt")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < infolist.size(); i++) {
                sb.append(infolist.get(i).gethousetype() + "," + infolist.get(i).getname() + "," + infolist.get(i).getaddress() + infolist.get(i).geticno() + "," + infolist.get(i).getplotno() + "-");
            }
            f.write(sb.toString());
            f.close();
        } catch (IOException e) {
            return;
        }
        dtm.setRowCount(0); //update table content
        for (int i = 0; i < infolist.size(); i++) {//populate table using object list
            Object[] objs = {infolist.get(i).gethousetype(), infolist.get(i).getname(), infolist.get(i).getaddress(), infolist.get(i).geticno(), infolist.get(i).getplotno()};
            dtm.addRow(objs);
        }
    }

    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    

}
