package employee.management.system;

import javax.swing.*;//GUI
import java.awt.*;//cutomizing GUI elements
import java.awt.event.ActionEvent;//handle events when button clicked
import java.awt.event.ActionListener;//for creating 

import java.sql.ResultSet;//to create database query result

public class Login extends JFrame implements ActionListener {

    JTextField tusername;//global declaration ,to enter id
    JPasswordField tpassword;//creating text field global variable
    JButton login, back;//creating buttons to perform actions

    Login(){//constructor

        JLabel username = new JLabel("Username");//to show text infront of frame jlabel usedd
        username.setBounds(40,20,100,30);//positing
        add(username);

        tusername = new JTextField();//whre text will be written
        tusername.setBounds(150,20,150,30);//to show infront of label
        add(tusername);

        JLabel password = new JLabel("Password");//for password
        password.setBounds(40,70,100,30);//to show below username
        add(password);

        tpassword = new JPasswordField();//to create a textfield
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login = new JButton("LOGIN");//JButton function
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);//bydefault blue
        login.setForeground(Color.WHITE);//colour of text visible bydefault black
        login.addActionListener(this);//performing action when login clicked
        add(login);

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);//setting size
        setLocation(450,200);
        setLayout(null);//bydefault border layout
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){//Checks if the source of the triggered event (e) is the login button.
                                                     //If the login button was clicked, the code inside this block will execute.
            try {
                String username = tusername.getText();//login button clicked,coomes in if condition
                String password = tpassword.getText();

                conn conn = new conn(); //connection to database Creates an instance of the conn class, which is likely a custom class designed to establish a connection to the database.
                                                           //This conn object is used to execute SQL queries.
                
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";//to check whether present in login table or not
                ResultSet resultSet = conn.statement.executeQuery(query);//to see whether id and password present in sql
                if (resultSet.next()){//to run query,to store result if condition true,moves cursor to next row
                    setVisible(false);//.next to see data has come or not,hides the current login frame
                    new Main_class();//main class opens if login successful
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();//Prints the stack trace of the exception,detailed information where exception occured
            }

        } else if (e.getSource() == back) {
            System.exit(90);//close the entire appplication
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
