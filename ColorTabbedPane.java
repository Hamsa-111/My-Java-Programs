/*5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and display the concerned color whenever the specific tab is selected in the Pan*/


package Swings;

import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;

public class ColorTabbedPane{

JFrame f;
JTabbedPane tp;

ColorTabbedPane(){

f=new JFrame();

JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();

p1.setBackground(Color.CYAN);
p2.setBackground(Color.MAGENTA);
p3.setBackground(Color.YELLOW);

tp=new JTabbedPane();

tp.setBounds(50,50,250,200);

tp.add("CYAN",p1);
tp.add("MAGENTA",p2);
tp.add("YELLOW",p3);

// Change Listener
tp.addChangeListener(new ChangeListener(){
public void stateChanged(ChangeEvent e){

int index=tp.getSelectedIndex();
String title=tp.getTitleAt(index);

System.out.println("Selected Color: "+title);
}
});

f.add(tp);

f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args){
new ColorTabbedPane();
}
}