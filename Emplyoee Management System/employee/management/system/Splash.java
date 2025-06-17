package employee.management.system;//collection of all related classes together

import javax.swing.*;//JLabel,JFrame used,it used to create GUI
import java.awt.*;//used for scaling an image

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));//icons picked from sourse foulder,Class loader load image from directory into sourse code
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);//scaleing image according to our frame
        ImageIcon i3 = new ImageIcon(i2);//we cannot take the scaled image directly
        JLabel image = new JLabel(i3);//setting image
        image.setBounds(0,0,1170,650);//setting image position and size
        add(image);


        setSize(1170,650);//setting window size
        setLocation(200,50);//set the frame in the middle,for settinng its position
        setLayout(null);//it is so so that we manually change window
        setVisible(true);//by default visiblity is null,to keep the windoow visible

        try{     //setting time holder
            Thread.sleep(5000); //5sec,holds the splash screen for 5 second
            setVisible(false);//closing the splash screen
            new Login(); //to open login page
        }catch (Exception e){//handling exception that might occur
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {//entry point of program
        new Splash();//to create instance of class
    }
}