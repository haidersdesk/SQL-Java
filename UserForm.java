import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserForm implements ActionListener {
    JFrame frame = new JFrame("User Search");
    Container con = frame.getContentPane();
    JLabel lhead, lsearchName, lsearchEmail;
    JTextField tname, temail;
    JButton searchN, searchE, reset;
    JTextArea display;

    UserForm() {
        frame.setBounds(150, 90, 600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(null);
        con.setBackground(Color.PINK);

        Font bodyF = new Font("Courier New", Font.PLAIN, 12);
        Font mainF = new Font("Courier New", Font.PLAIN, 25);

        lhead = new JLabel("SEARCH RECORDS");
        lhead.setBounds(165, 2, 500, 35);
        lhead.setFont(mainF);
        lhead.setForeground(Color.green);
        con.add(lhead);

        lsearchName = new JLabel("Name");
        lsearchName.setFont(bodyF);
        lsearchName.setBounds(50, 50, 60, 30);
        con.add(lsearchName);

        lsearchEmail = new JLabel("Email");
        lsearchEmail.setFont(bodyF);
        lsearchEmail.setBounds(50, 150, 60, 30);
        con.add(lsearchEmail);

        tname = new JTextField();
        tname.setBounds(130, 50, 180, 20);
        con.add(tname);

        temail = new JTextField();
        temail.setBounds(130, 150, 180, 20);
        con.add(temail);

        searchN = new JButton("SEARCH-N");
        searchN.setBounds(325, 45, 140, 30);
        con.add(searchN);

        searchE = new JButton("SEARCH-E");
        searchE.setBounds(325, 145, 140, 30);
        con.add(searchE);

        display = new JTextArea();
        display.setBounds(130, 200, 200, 200);
        con.add(display);
        display.setFont(bodyF);
        display.setBackground(Color.gray);
        display.setForeground(Color.white);
        display.setEditable(false);

        reset = new JButton("RESET");
        reset.setFont(bodyF);
        reset.setBounds(130, 410, 80, 25);
        con.add(reset);

        searchE.addActionListener(this);
        searchN.addActionListener(this);
        reset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        if (choice == "SEARCH-N")                       // SEARCH BUTTON
        {
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ce) {
                    display.setText("Loading Driver Failed");

                }

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "user", "user1234");

                String s1 = tname.getText();
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


        } else if (choice == "SEARCH-E")                       // SEARCH BUTTON
        {
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ce) {
                    display.setText("Loading Driver Failed");

                }

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "user", "user1234");

                String s1 = temail.getText();
                String sql = "select * from users where email =?";
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


        }
        else
            {
            tname.setText(null);
            temail.setText(null);
            display.setText(null);

        }

    }
}

