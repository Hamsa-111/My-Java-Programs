/*5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the countries on console whenever the countries are selected on the list.*/


package Swings;

import javax.swing.*;
import javax.swing.event.*;
import java.util.HashMap;

public class CountryCapitalList extends JFrame{

private JList<String> countryList;
private HashMap<String,String> capitalMap;

public CountryCapitalList(){

// create model and add elements
DefaultListModel<String> listModel=new DefaultListModel<>();

listModel.addElement("USA");
listModel.addElement("India");
listModel.addElement("Vietnam");
listModel.addElement("Canada");
listModel.addElement("Denmark");
listModel.addElement("France");
listModel.addElement("Great Britain");
listModel.addElement("Japan");
listModel.addElement("Africa");
listModel.addElement("Greenland");
listModel.addElement("Singapore");

// create JList
countryList=new JList<>(listModel);
countryList.setVisibleRowCount(6);
countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

// create capital mapping
capitalMap=new HashMap<>();
capitalMap.put("USA","Washington, D.C.");
capitalMap.put("India","New Delhi");
capitalMap.put("Vietnam","Hanoi");
capitalMap.put("Canada","Ottawa");
capitalMap.put("Denmark","Copenhagen");
capitalMap.put("France","Paris");
capitalMap.put("Great Britain","London");
capitalMap.put("Japan","Tokyo");
capitalMap.put("Africa","No single capital");
capitalMap.put("Greenland","Nuuk");
capitalMap.put("Singapore","Singapore");

// add selection listener
countryList.addListSelectionListener(new ListSelectionListener(){
public void valueChanged(ListSelectionEvent e){

if(!e.getValueIsAdjusting()){

String selectedCountry=countryList.getSelectedValue();
String capital=capitalMap.get(selectedCountry);

System.out.println("Capital of "+selectedCountry+" is: "+capital);
}
}
});

// add scroll pane
add(new JScrollPane(countryList));

setTitle("Country Capital List");
setSize(250,250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}

public static void main(String[] args){
new CountryCapitalList();
}
}