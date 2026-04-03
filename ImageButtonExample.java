/*4c.Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).

*/


package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample extends JFrame implements ActionListener{

JButton digitalBtn;
JButton hourGlassBtn;
JLabel messageLabel;

public ImageButtonExample(){

setTitle("Image Button Example");
setSize(500,300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

// Top message
messageLabel=new JLabel("Press any button",JLabel.CENTER);
messageLabel.setFont(new Font("Verdana",Font.BOLD,18));
add(messageLabel,BorderLayout.NORTH);

//  Center panel for buttons
JPanel panel=new JPanel();
panel.setLayout(new FlowLayout(FlowLayout.CENTER,40,20)); 

// Load and resize Digital Clock image
ImageIcon digitalIcon=new ImageIcon(
ImageButtonExample.class.getResource("/images/digital_clock.png"));
Image img1=digitalIcon.getImage();
digitalIcon=new ImageIcon(img1.getScaledInstance(80,80,Image.SCALE_SMOOTH));

// Load and resize Hour Glass image
ImageIcon hourGlassIcon=new ImageIcon(
ImageButtonExample.class.getResource("/images/Hour_glass.png"));
Image img2=hourGlassIcon.getImage();
hourGlassIcon=new ImageIcon(img2.getScaledInstance(80,80,Image.SCALE_SMOOTH));

// Buttons
digitalBtn=new JButton(digitalIcon);
hourGlassBtn=new JButton(hourGlassIcon);

// Remove extra button borders (optional for clean look)
digitalBtn.setBorderPainted(false);
hourGlassBtn.setBorderPainted(false);

// Add listeners
digitalBtn.addActionListener(this);
hourGlassBtn.addActionListener(this);

// Add buttons to panel
panel.add(digitalBtn);
panel.add(hourGlassBtn);

// Add panel to CENTER
add(panel,BorderLayout.CENTER);

setVisible(true);
}

// Event handling
public void actionPerformed(ActionEvent e){

if(e.getSource()==digitalBtn){
messageLabel.setText("Digital Clock is pressed");
}
else{
messageLabel.setText("Hour Glass is pressed");
}

}

public static void main(String[] args){
new ImageButtonExample();
}
}