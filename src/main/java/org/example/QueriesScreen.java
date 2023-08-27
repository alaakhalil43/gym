package org.example;
import org.example.model.*;
import org.example.repos.MemberListRepo;
import org.example.repos.SavaSubscribeRepo;
import org.example.repos.SubscribeTypeRepo;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class QueriesScreen {
    JComboBox<CombBoxModel> namesComboBox = new JComboBox<>();
    JComboBox<CombBoxModel> namesComboBox2 = new JComboBox<>();
    Font f = new Font("Arial", Font.PLAIN, 17);
    public void Queries_Screen() {

        // Create the main JFrame
        JFrame jf = new JFrame("Queries page");
        jf.getContentPane().setBackground(Color.gray);
        jf.setSize(tools.screenWidth, tools.screenHeight);
        jf.setLayout(null); // Use null layout for custom component placement


        jf.add(getMemberChoice());
        jf.add(getSubscribeChoice());
        jf.add(jButton());
        jf.setLayout(new BorderLayout());
        jf.add(DrawTable(), BorderLayout.SOUTH); // وضع الجدول في منطقة BorderLayout.SOUTH
        jf.setVisible(true);
    }


    public JPanel getMemberChoice() {
        // Create a JPanel for additional content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a JComboBox and add items
        DefaultComboBoxModel<CombBoxModel> namesComboBoxModel = new DefaultComboBoxModel<>();
        namesComboBox.setModel(namesComboBoxModel);

        MemberListRepo memberListRepo = new MemberListRepo();
        List<MemberList> memberList = memberListRepo.getDataFromSql();

        for (MemberList s : memberList) {
            CombBoxModel box = new CombBoxModel(s.getName(), s.getId());
            //  System.out.println(s.getId() + "    "+s.getName()+" ");
            namesComboBoxModel.addElement(box);
        }
        namesComboBox.setEditable(true);

        // Add autocomplete functionality to the JComboBox
        AutoCompleteDecorator.decorate(namesComboBox);

        // Add the JComboBox to the contentPanel
        contentPanel.add(namesComboBox, BorderLayout.CENTER);

        // Set position and size of the contentPanel to cover the screen
        contentPanel.setBounds(100, 200, 140, 50);
        return contentPanel;
    }


    public JPanel getSubscribeChoice() {
        // Create a JPanel for additional content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a JComboBox and add items
        DefaultComboBoxModel<CombBoxModel> namesComboBoxModel = new DefaultComboBoxModel<>();
        namesComboBox2.setModel(namesComboBoxModel);

        SubscribeTypeRepo SubscribeTypeRepo = new SubscribeTypeRepo();
        List<SubscribeType> SubscribeType = SubscribeTypeRepo.getAll();

        for (SubscribeType s : SubscribeType) {
            CombBoxModel box = new CombBoxModel(s.getName(), s.getId());
            // System.out.println(s.getId() + "    "+s.getName()+" ");
            namesComboBoxModel.addElement(box);
        }
        namesComboBox2.setEditable(true);

        // Add autocomplete functionality to the JComboBox
        AutoCompleteDecorator.decorate(namesComboBox2);

        // Add the JComboBox to the contentPanel
        contentPanel.add(namesComboBox2, BorderLayout.CENTER);

        // Set position and size of the contentPanel to cover the screen
        contentPanel.setBounds(400, 200, 100, 50);
        return contentPanel;
    }

    public JButton jButton() {
        JButton jb = new JButton("Save");
        jb.setFont(f);
        jb.setHorizontalAlignment(JTextField.CENTER);
        jb.setBounds(700, 200, 100, 40);
        jb.addActionListener(new ActionListener() {
            GetSubscribeDetails g=new GetSubscribeDetails();
            @Override
            public void actionPerformed(ActionEvent e) {
                CombBoxModel selected = (CombBoxModel) namesComboBox.getSelectedItem();
                g.id1=selected.getId();
                CombBoxModel selected2 = (CombBoxModel) namesComboBox2.getSelectedItem();
                g.id2=selected2.getId();

                SavaSubscribeRepo save=new SavaSubscribeRepo();
                save.inservalues(g);

            }
        });

        return jb;
    }

    public JScrollPane DrawTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"id", "Name", "subscribe_type", "price", "date_start"}, 0);
        SavaSubscribeRepo m1 = new SavaSubscribeRepo();
        List<SubscribeList> data = m1.GetDataFromSql();

        for (SubscribeList member : data) {
            Object[] row = {member.getId() , member.getMember_id() ,member.getSubType(),member.getPrice(),member.getDate_start()};
            model.addRow(row);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        return  scrollPane ;
    }

}
