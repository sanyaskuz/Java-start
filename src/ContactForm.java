import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ContactForm extends JFrame {
     JTextField name_field;
     JTextField email_field;

     JRadioButton mael;
     JRadioButton female;
     JCheckBox check;
    public ContactForm() {
        super("Контактна Форма");
        super.setBounds(200, 100, 300, 230);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2,10));


        JLabel name = new JLabel("Your name");
         name_field = new JTextField("", 1);
        JLabel email = new JLabel("Your email");
         email_field = new JTextField("@", 1);


        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);



        mael = new JRadioButton("Man");
        female = new JRadioButton("Women");
        check = new JCheckBox("Yes?", false);
        JButton send_button = new JButton("Go form");

        mael.setSelected(true);
        container.add(mael);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(mael);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());



    }
    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = email_field.getText();




            String isMan = "Man";
            if(!mael.isSelected())
                isMan = "woman";


            boolean checkBox = check.isSelected();

            User user = new User(name,email);

            JOptionPane.showMessageDialog(null, "Your Email: " + email + "\nYour gender: " + isMan + "\n You Yes ? " + checkBox, "Hallo :" + name , JOptionPane.PLAIN_MESSAGE);

            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserFile.bit"))) {
                oos.writeObject(user);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ReadOdject readOdject = new ReadOdject();

        }
    }

}
