import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class LoginForm implements ActionListener {
    JFrame frame = new JFrame("Login");
    Container con = frame.getContentPane();
    JLabel lhead, lusername, lpassword;
    JTextField tusername;
    JPasswordField pass;
    JButton login, reset;


    LoginForm() {
        frame.setBounds(150, 90, 300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(null);
        con.setBackground(Color.PINK);

        Font bodyF = new Font("Courier New", Font.PLAIN, 12);

        lhead = new JLabel("Login");
        lhead.setBounds(115, 2, 200, 35);
        lhead.setFont(bodyF);
        lhead.setForeground(Color.green);
        con.add(lhead);


        lusername = new JLabel("Username");
        lusername.setFont(bodyF);
        lusername.setBounds(20, 25, 60, 30);
        con.add(lusername);

        lpassword = new JLabel("Password");
        lpassword.setFont(bodyF);
        lpassword.setBounds(20, 50, 60, 30);
        con.add(lpassword);

        tusername = new JTextField();
        tusername.setBounds(100, 32, 80, 15);
        con.add(tusername);

        pass = new JPasswordField();
        pass.setBounds(100, 54, 80, 15);
        con.add(pass);

        login = new JButton("LOGIN");
        login.setBounds(150, 80, 75, 20);
        con.add(login);

        reset = new JButton("RESET");
        reset.setBounds(50, 80, 75, 20);
        con.add(reset);

        login.addActionListener(this);
        reset.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String choice = e.getActionCommand();



     if (choice == "LOGIN" )
     {
         if (tusername.getText().equals("admin") & pass.getText().equals("admin1234") )
         {
                 frame.setVisible(false);
                 RegisForm r = new RegisForm();
         }
         else if (tusername.getText().equals("user") & pass.getText().equals("user1234"))
             {
                 frame.setVisible(false);
                 UserForm f = new UserForm();

             }
         else
             {
                 JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
             }


     }



        if (choice == "RESET")
        {
            tusername.setText(null);
            pass.setText(null);
        }
    }
}


    class RegisForm implements ActionListener {
        JFrame frame = new JFrame("Registration Form");
        Container con = frame.getContentPane();
        JLabel lhead, lname, lemail, lmobile, lgender, ldob, laddress, lsearch, ldelete;
        JTextField tname, temail, tmobile, tsearch, tdelete, taddress;
        JRadioButton r1, r2;
        ButtonGroup gender = new ButtonGroup();
        JComboBox<String> day;
        JComboBox<String> month;
        JComboBox<String> year;
        JCheckBox term;
        JButton submit, reset, showall, search, delete;
        JTextArea display;


        RegisForm() {
            frame.setBounds(150, 90, 1000, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            con.setLayout(null);
            con.setBackground(Color.PINK);

            Font mainF = new Font("Courier New", Font.PLAIN, 25);
            Font bodyF = new Font("Courier New", Font.PLAIN, 12);

            lhead = new JLabel("Registration Form");
            lhead.setBounds(230, 5, 400, 35);
            lhead.setFont(mainF);
            lhead.setForeground(Color.green);
            con.add(lhead);

            lname = new JLabel("Name");
            lname.setFont(bodyF);
            lname.setBounds(50, 50, 60, 30);
            con.add(lname);

            lemail = new JLabel("Email");
            lemail.setFont(bodyF);
            lemail.setBounds(50, 250, 60, 30);
            con.add(lemail);

            lmobile = new JLabel("Mobile-No");
            lmobile.setFont(bodyF);
            lmobile.setBounds(50, 200, 60, 30);
            con.add(lmobile);

            lgender = new JLabel("Gender");
            lgender.setFont(bodyF);
            lgender.setBounds(50, 100, 60, 30);
            con.add(lgender);

            ldob = new JLabel("D.O.B");
            ldob.setFont(bodyF);
            ldob.setBounds(50, 150, 60, 30);
            con.add(ldob);


            laddress = new JLabel("Address");
            laddress.setFont(bodyF);
            laddress.setBounds(50, 300, 60, 30);
            con.add(laddress);

            tname = new JTextField();
            tname.setBounds(130, 53, 180, 20);
            con.add(tname);

            r1 = new JRadioButton("Male");
            r1.setBounds(130, 103, 80, 30);
            r1.setFont(bodyF);
            r1.setBackground(Color.pink);
            con.add(r1);

            r2 = new JRadioButton("Female");
            r2.setBounds(230, 103, 80, 30);
            r2.setFont(bodyF);
            r2.setBackground(Color.pink);
            con.add(r2);

            gender.add(r1);
            gender.add(r2);

            temail = new JTextField();
            temail.setBounds(130, 253, 180, 20);
            con.add(temail);

            tmobile = new JTextField();
            tmobile.setBounds(130, 203, 180, 20);
            con.add(tmobile);


            taddress = new JTextField();
            taddress.setBounds(130, 303, 180, 20);
            con.add(taddress);

            String[] daylist = new String[31];
            for (int i = 1; i < 31; i++) {
                daylist[i - 1] = Integer.toString(i);
            }
            day = new JComboBox(daylist);
            day.setBounds(130, 153, 40, 25);
            day.setEditable(true);
            con.add(day);

            String[] monthlist = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            month = new JComboBox(monthlist);
            month.setBounds(185, 153, 50, 25);
            month.setEditable(true);
            con.add(month);

            String[] yearlist = new String[100];
            for (int i = 1951; i <= 2050; i++) {
                yearlist[i - 1951] = Integer.toString(i);
            }
            year = new JComboBox(yearlist);
            year.setBounds(250, 153, 60, 25);
            year.setEditable(true);
            con.add(year);

            term = new JCheckBox("I Accept Terms & Conditions");
            term.setBounds(70, 340, 250, 25);
            term.setBackground(Color.pink);
            con.add(term);

            submit = new JButton("SUBMIT");
            submit.setFont(bodyF);
            submit.setBounds(100, 380, 80, 25);
            con.add(submit);

            reset = new JButton("RESET");
            reset.setFont(bodyF);
            reset.setBounds(200, 380, 80, 25);
            con.add(reset);

            display = new JTextArea();
            display.setBounds(650, 50, 300, 450);
            con.add(display);
            display.setFont(bodyF);
            display.setBackground(Color.gray);
            display.setForeground(Color.white);
            display.setEditable(false);


            showall = new JButton("SHOW DATA");
            showall.setBounds(370, 80, 200, 30);
            con.add(showall);

            lsearch = new JLabel("Search Name");
            lsearch.setFont(bodyF);
            lsearch.setBounds(420, 160, 250, 30);
            con.add(lsearch);

            tsearch = new JTextField();
            tsearch.setBounds(370, 200, 200, 20);
            con.add(tsearch);

            search = new JButton("SEARCH");
            search.setBounds(390, 240, 140, 30);
            con.add(search);

            ldelete = new JLabel("Delete Name");
            ldelete.setBounds(420, 320, 250, 30);
            ldelete.setFont(bodyF);
            con.add(ldelete);

            tdelete = new JTextField();
            tdelete.setBounds(370, 360, 200, 20);
            con.add(tdelete);

            delete = new JButton("DELETE");
            delete.setBounds(390, 400, 140, 30);
            con.add(delete);

            submit.addActionListener(this);
            reset.addActionListener(this);
            showall.addActionListener(this);
            search.addActionListener(this);
            delete.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if (choice == "SUBMIT") {                   // SUBMIT BUTTON
                if (term.isSelected()) {
                    String name = tname.getText();
                    String email = temail.getText();
                    String mobile = tmobile.getText();
                    String address = taddress.getText();
                    String gen = "Male";
                    if (r2.isSelected()) {
                        gen = "Female";
                    }
                    String date = (String) day.getSelectedItem();
                    String mon = (String) month.getSelectedItem();
                    String yr = (String) year.getSelectedItem();

                    try {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                        } catch (ClassNotFoundException ce) {
                            display.setText("Loading Driver Failed");

                        }

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "admin", "admin1234");


                        String sql = "insert into users(name,gender,day,month,year,mobile,email,address) values(?,?,?,?,?,?,?,?)";

                        PreparedStatement st = conn.prepareStatement(sql);
                        st.setString(1, name);
                        st.setString(2, gen);
                        st.setString(3, date);
                        st.setString(4, mon);
                        st.setString(5, yr);
                        st.setString(6, mobile);
                        st.setString(7, email);
                        st.setString(8, address);

                        st.executeUpdate();
                        display.setText("Registration Successful");


                    } catch (SQLException throwables)  // CAN BE CHANGED LATER !!!
                    {
                        throwables.printStackTrace();
                    }


                    display.setText("Data saved Successfully");
                } else {
                    display.setText("Please agree to the terms & condition to continue");
                }
            } else if (choice == "SHOW DATA")                            // SHOW DATA BUTTON
            {
                try {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ce) {
                        display.setText("Loading Driver Failed");

                    }

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "admin", "admin1234");

                    String sql = "select * from users";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        String name = rs.getString("name");
                        String gender = rs.getString("gender");
                        String date = rs.getString("day");
                        String mon = rs.getString("month");
                        String yr = rs.getString("year");
                        String mobile = rs.getString("mobile");
                        String email = rs.getString("email");
                        String address = rs.getString("address");

                        display.setText("\n\n\nName:" + name + "\nEmail: " + email + "\nMobile : " + mobile + "\nDate of Birth: " + date + " " + mon + " " +
                                yr + "\nGender: " + gender + "\nAddress: " + address + "\n");

                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } else if (choice == "SEARCH")                       // SEARCH BUTTON
            {
                try {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ce) {
                        display.setText("Loading Driver Failed");

                    }

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "admin", "admin1234");

                    String s1 = tsearch.getText();
                    String sql = "select * from users where name =?";
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, s1);

                    ResultSet rs = st.executeQuery();

                    while (rs.next()) {
                        String name = rs.getString("name");
                        String gender = rs.getString("gender");
                        String date = rs.getString("day");
                        String mon = rs.getString("month");
                        String yr = rs.getString("year");
                        String mobile = rs.getString("mobile");
                        String email = rs.getString("email");
                        String address = rs.getString("address");

                        display.setText("\n\n\nName:" + name + "\nEmail: " + email + "\nMobile : " + mobile + "\nDate of Birth: " + date + " " + mon + " " +
                                yr + "\nGender: " + gender + "\nAddress: " + address + "\n");

                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            } else if (choice == "DELETE")                     // DELETE BUTTON
            {
                try {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ce) {
                        display.setText("Loading Driver Failed");

                    }

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "admin", "admin1234");

                    String s1 = tdelete.getText();
                    String sql = "delete from users where name =?";
                    PreparedStatement st = conn.prepareStatement(sql);

                    st.setString(1, s1);
                    st.executeUpdate();
                    display.setText("Deleted Successfully");


                } catch (SQLException throwables)  // CAN BE CHANGED LATER !!!
                {
                    throwables.printStackTrace();
                }


            } else {
                tname.setText(null);
                temail.setText(null);
                tmobile.setText(null);
                taddress.setText(null);
                display.setText(null);

                gender.clearSelection();
                term.setSelected(false);
                day.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);


            }

        }


    }


    public class Registration {
        public static void main(String[] args) {


            LoginForm l = new LoginForm();
        }
    }

