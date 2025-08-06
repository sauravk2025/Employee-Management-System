import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class t2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
        try{
        Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","1234");
	    Statement stm=con.createStatement();
        JFrame frame = new JFrame("Employee Management System");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        ImageIcon backgroundImage = new ImageIcon("java1.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null);
         background.setBounds(0, 0, 500, 350);

        



        JLabel userLabel = new JLabel("Username:");
        JLabel cname = new JLabel("ALPHABET");
        cname.setBounds(165,5,200,50);
        Font f1 = cname.getFont();
        cname.setFont(new Font(f1.getName(),f1.getStyle(),30));
        cname.setForeground(Color.WHITE);
        userLabel.setBounds(50, 50, 80, 30);
        JTextField userText = new JTextField();
        userText.setBounds(150, 50, 180, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 80, 30);
        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 100, 180, 30);

        JButton employeeLoginButton = new JButton("Employee Login");
        employeeLoginButton.setBounds(50, 150, 140, 30);

        JButton managerLoginButton = new JButton("Manager Login");
        managerLoginButton.setBounds(210, 150, 140, 30);

        frame.setContentPane(background);
        frame.setVisible(true);

        background.add(userLabel);
        background.add(userText);
        background.add(passLabel);
        background.add(passText);
        background.add(employeeLoginButton);
        background.add(managerLoginButton);
        background.add(cname);

         employeeLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                String user1 = userText.getText();
                String pass1 = passText.getText();
                String s1 = "select * from employee where eid ='"+user1+"'and epass='"+pass1+"'";
                ResultSet rs1=stm.executeQuery(s1);
                if(rs1.next())
                {
                JFrame employeeFrame = new JFrame("Employee Information");
                employeeFrame.setSize(500, 350);
                employeeFrame.setLayout(null);

                ImageIcon backgroundImage1 = new ImageIcon("java1.jpg");
                JLabel background1 = new JLabel(backgroundImage1);
                background1.setLayout(null);
              background1.setBounds(0, 0, 500, 350);






                JLabel idLabel = new JLabel("ID:");
                idLabel.setBounds(50, 50, 80, 30);
                JTextField idText = new JTextField();
                idText.setBounds(150, 50, 180, 30);
                idText.setText(user1);

                JLabel nameLabel = new JLabel("Name:");
                nameLabel.setBounds(50, 90, 80, 30);
                JTextField nameText = new JTextField();
                nameText.setBounds(150, 90, 180, 30);

                JLabel projectLabel = new JLabel("Current Project:");
                projectLabel.setBounds(50, 130, 100, 30);
                JTextField projectText = new JTextField();
                projectText.setBounds(150, 130, 180, 30);







                 String s6 = "select ename,epid from employee where eid='"+user1+"'";
                ResultSet rs6 = stm.executeQuery(s6);
                rs6.next();
                nameText.setText(rs6.getString(1));

                if (rs6.getString(2) == null)
                { projectText.setText("");}
                else{
                 String s7 = "select pname from project where pid='"+rs6.getString(2)+"'";
                ResultSet rs7 = stm.executeQuery(s7);
                rs7.next();
                projectText.setText(rs7.getString(1));
                }

                JButton projectCompletedButton = new JButton("Project Completed");
                projectCompletedButton.setBounds(100, 180, 200, 30);
                 projectCompletedButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    try{
                    String p1 = projectText.getText();
                    if (p1.equalsIgnoreCase(""))
                    {JOptionPane.showMessageDialog(null,"No Active Projects");}
                    else{
                                String s8 = "update employee set epid = NULL where eid ='"+user1+"'";
                                stm.executeUpdate(s8);
                                JOptionPane.showMessageDialog(null, "Project Completed!");
                                projectText.setText("");

                        }
                        }
                    catch(SQLException k)
                     {
	                    System.out.println(k);
                     }
                    }
                 });

                 employeeFrame.setContentPane(background1);
                 employeeFrame.setVisible(true);

            
                background1.add(idLabel);
                background1.add(idText);
                background1.add(nameLabel);
                background1.add(nameText);
                background1.add(projectLabel);
                background1.add(projectText);
                background1.add(projectCompletedButton);
                background1.add(cname);

                background1.setVisible(true);
            }
             else
             {
                JOptionPane.showMessageDialog(null, "Invalid Credentials!");
             }
            }
            catch(ArithmeticException f)
      {
         System.out.println(f);
      }   
      catch(SQLException f)
      {
	 System.out.println(f);
      }
            }
        });

        managerLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                 String user1 = userText.getText();
                String pass1 = passText.getText();
                String s2 = "select * from manager where mid ='"+user1+"'and mpass='"+pass1+"'";
                ResultSet rs2=stm.executeQuery(s2);
                if(rs2.next())
              { //if 
                JFrame managerFrame = new JFrame("Manager Information");
                managerFrame.setSize(500, 350);
                managerFrame.setLayout(null);
                
                ImageIcon backgroundImage2 = new ImageIcon("java1.jpg");
                JLabel background2 = new JLabel(backgroundImage2);
                background2.setLayout(null);
              background2.setBounds(0, 0, 500, 350);







                String v2 = rs2.getString(1);
                JLabel managerLabel = new JLabel("Manager Name:");
                managerLabel.setBounds(50, 50, 120, 30);
                JTextField managerText = new JTextField();
                managerText.setBounds(180, 50, 150, 30);
                managerText.setText(rs2.getString(3));

                JLabel projectLabel = new JLabel("Project ID:");
                projectLabel.setBounds(50, 90, 100, 30);
                JTextField projectText = new JTextField();
                projectText.setBounds(180, 90, 150, 30);
                projectText.setText(rs2.getString(4));

                JButton removeEmployeeButton = new JButton("Remove Employee");
                removeEmployeeButton.setBounds(50, 150, 150, 30);

                JButton assignEmployeeButton = new JButton("Assign Employee");
                assignEmployeeButton.setBounds(210, 150, 150, 30);

                managerFrame.setContentPane(background2);
                managerFrame.setVisible(true);

                background2.add(managerLabel);
                background2.add(managerText);
                background2.add(projectLabel);
                background2.add(projectText);
                background2.add(removeEmployeeButton);
                background2.add(assignEmployeeButton);
                background2.add(cname);
                background2.setVisible(true);
                

                removeEmployeeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame removeFrame = new JFrame("Remove Employee");
                        removeFrame.setSize(500, 350);
                        removeFrame.setLayout(null);

                        ImageIcon backgroundImage3 = new ImageIcon("java1.jpg");
                        JLabel background3 = new JLabel(backgroundImage3);
                        background3.setLayout(null);
                        background3.setBounds(0, 0, 500, 350);

                        JLabel userIdLabel = new JLabel("User ID:");
                        userIdLabel.setBounds(50, 50, 80, 30);
                        JTextField userIdText = new JTextField();
                        userIdText.setBounds(150, 50, 120, 30);

                        JLabel nameLabel = new JLabel("Name:");
                        nameLabel.setBounds(50, 90, 80, 30);

                        JButton verifyButton = new JButton("Verify");
                        verifyButton.setBounds(100, 130, 100, 30);
                        JTextField vname = new JTextField();
                        vname.setBounds(150, 90, 120, 30);


                        verifyButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                            try{
                            String v1 = userIdText.getText();
                            String s3 = "select ename from employee where eid ='"+v1+"' and emid ='"+v2+"'";
                            ResultSet rs3=stm.executeQuery(s3);
                            if(rs3.next())
                            {
                            vname.setText(rs3.getString(1));
                            }
                            else{JOptionPane.showMessageDialog(null, "!!Invalid User id!!");
                                 userIdText.setText("");}
                            }
                            catch(SQLException g)
                              {
	                           System.out.println(g);
                              }


                            }
                        });

                        JButton removeButton = new JButton("REMOVE");
                        removeButton.setBounds(210, 130, 100, 30);

                        removeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try{
                            String v1 = userIdText.getText();
                            String v3 = vname.getText();
                             if (v1.equalsIgnoreCase(""))
                            {JOptionPane.showMessageDialog(null, "!!Invalid User id!!");}
                            else if(v3.equalsIgnoreCase(""))
                            {JOptionPane.showMessageDialog(null, "!!Initiate verification!!");}
                            else 
                            {

                                String s4 = "update employee set epid = NULL where eid ='"+v1+"'";
                                stm.executeUpdate(s4);
                                JOptionPane.showMessageDialog(null, "Employee removed successfully!");
                                userIdText.setText("");
                                vname.setText("");
                                }
                                }
                                catch(SQLException h)
                              {
	                           System.out.println(h);
                              }
                            }
                        });
                        removeFrame.setContentPane(background3);
                        removeFrame.setVisible(true);




                        background3.add(userIdLabel);
                        background3.add(userIdText);
                        background3.add(nameLabel);
                        background3.add(verifyButton);
                        background3.add(removeButton);
                        background3.add(vname);
                        background3.add(cname);
                        background3.setVisible(true);
                    }
                });


                assignEmployeeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame assignFrame = new JFrame("Assign Employee");
                        assignFrame.setSize(500, 350);
                        assignFrame.setLayout(null);

                        ImageIcon backgroundImage4 = new ImageIcon("java1.jpg");
                        JLabel background4 = new JLabel(backgroundImage4);
                        background4.setLayout(null);
                        background4.setBounds(0, 0, 500, 350);



                        JButton checkButton = new JButton("Check");
                        checkButton.setBounds(150, 50, 100, 30);

                        JLabel userIdLabel = new JLabel("User ID:");
                        userIdLabel.setBounds(50, 90, 80, 30);
                        JTextField userIdText = new JTextField();
                        userIdText.setBounds(150, 90, 120, 30);

                        JButton assignButton = new JButton("Assign");
                        assignButton.setBounds(150, 130, 100, 30);

                        assignButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try{
                            String v1 = userIdText.getText();
                             if (v1.equalsIgnoreCase(""))
                            {JOptionPane.showMessageDialog(null, "!!Initiate Checking");}
                            else if (v1.equalsIgnoreCase("  "))
                            {JOptionPane.showMessageDialog(null, "!!No available employee");}
                            else{
                                String s1 = userText.getText();
                                String s2 = "select mpid from manager where mid ='"+s1+"'";
                                ResultSet rs6 = stm.executeQuery(s2);
                                rs6.next();
                                String s3 = "update employee set epid ='"+rs6.getString(1)+"'where eid ='"+v1+"'";
                                stm.executeUpdate(s3);
                                JOptionPane.showMessageDialog(null, "Employee assigned successfully!");
                                userIdText.setText("");
                            }
                                }
                                catch(SQLException j)
                              {
	                           System.out.println(j);
                              }

                            }
                        });

                        checkButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try{
                                String s1 = userText.getText();
                                String s2 ="select eid from employee where epid is NULL and emid ='"+s1+"'";
                                ResultSet rs5 = stm.executeQuery(s2);
                                if(rs5.next())
                                {
                                userIdText.setText(rs5.getString(1));
                                JOptionPane.showMessageDialog(null, "Employee available!");
                                }
                                else{
                                    userIdText.setText("  ");
                                    JOptionPane.showMessageDialog(null, "Employee not available!");}
                                }
                                catch(SQLException i)
                              {
	                           System.out.println(i);
                              }

                            }
                        });
                        assignFrame.setContentPane(background4);
                        assignFrame.setVisible(true);

                        background4.add(checkButton);
                        background4.add(userIdLabel);
                        background4.add(userIdText);
                        background4.add(assignButton);
                        background4.add(cname);

                        background4.setVisible(true);
                    }
                });

                managerFrame.setVisible(true);
              }//if
              else
                {JOptionPane.showMessageDialog(null, "Invalid Credentials!");}
                }//try
                catch(SQLException f)
                {
	                System.out.println(f);
                 }
            
            }
            });

        frame.setVisible(true);
    }
     catch(ArithmeticException e)
      {
         System.out.println(e);
      }   
      catch(ClassNotFoundException e)
      {
	 System.out.println(e);
      }
      catch(SQLException e)
      {
	 System.out.println(e);
      }
    });
    }
}
