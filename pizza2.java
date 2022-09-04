import java.awt.event.*;  
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;
class InvalidDetailsException extends Exception
{
  public InvalidDetailsException(String argu)
  {
      super(argu);
  }
}
class InvalidIdException extends Exception
{
  public InvalidIdException(String argu)
  {
      super(argu);
  }
}
class InvalidQuantityException extends Exception
{
  public InvalidQuantityException(String argu)
  {
      super(argu);
  }
}
class InvalidItemException extends Exception
{
  public InvalidItemException(String argu)
  {
      super(argu);
  }
}

class Compliments{
    int coke200ml=0;
	int sprite500ml=0;
	
}
class Pizza extends Compliments{
    int type[]=new int[4];
}
class Customers {
	int id,amount;
	String name,address;
	Pizza p;
	
}
public class pizza2 extends JFrame implements ActionListener
 {
	ArrayList<Customers> custarr=new  ArrayList<Customers>(10);
	String list[]= { "panner 50","mushroom 70","cheese 40", "veg 50"};
	JList<String> jl=new JList<String> (list);
	JPanel p =new JPanel();
    
	JLabel jl1=new JLabel("name");
   JLabel jl2=new JLabel("id");
    JLabel jl3=new JLabel("address");
    JLabel jl5=new JLabel("History:");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	JTextField t7=new JTextField();
	
	
	JTextArea ta1=new JTextArea();
                JTextArea ta2=new JTextArea();
	
	JButton jb1=new JButton("place-an-order");
	JButton jb2=new JButton("History");
	
	
	public pizza2(){
		JFrame jf=new JFrame();
          jf.setTitle("pizza order");
		  jf.setBounds(300, 90, 900, 900);
		  jf.setLayout(null);
          jf.setVisible(true);
		  p.add(jl);
		  jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		  
		  jl1.setBounds(100,20,100,100);
		  jf.add(jl1);
		  t1.setBounds(150,60,100,20);
		  jf.add(t1);
		  jl2.setBounds(100,50,100,100);
		  jf.add(jl2);
		  t2.setBounds(150,90,100,20);
		  jf.add(t2);
		  jl3.setBounds(100,70,100,100);
		  jf.add(jl3);
		  t3.setBounds(150,110,100,20);
		  jf.add(t3);
		  p.setBounds(100,150,100,200);
		  jf.add(p);
		  t4.setBounds(210,155,15,15);
		  jf.add(t4);
		  t5.setBounds(210,175,15,15);
		  jf.add(t5);
		  t6.setBounds(210,195,15,15);
		  jf.add(t6);
		  t7.setBounds(210,215,15,15);
		  jf.add(t7);
		  jb1.setBounds(100,240,150,20);
		  jf.add(jb1);
		  ta1.setBounds(100,320,200,200);
		  jf.add(ta1);
		  jb2.setBounds(320,40,100,20);
		  jf.add(jb2);
		  jl5.setBounds(320,40,100,100);
		  jf.add(jl5);
		  ta2.setBounds(320,100,500,700);
	      jf.add(ta2);
		  jb1.addActionListener(this);
		  jb2.addActionListener(this);
    }
	public boolean presentArray(int arr[], int type){
		for(int i=0;i<arr.length;i++){
			if(arr[i] == type) return true;
		}
		return false;
	}
	    public void actionPerformed(ActionEvent ae){
			int arr[];
			  int am =0;
			  String str="";
			  String s1,s2,s3;
			  
			  if (ae.getActionCommand()=="place-an-order"){
				  
				  Customers c1 = new Customers();
				  try{
				   s1=t1.getText();
				   s2=t2.getText();
				   s3=t3.getText();
				  if(s1 == null || s1.isEmpty()||s2 == null || s2.isEmpty()||s3 == null || s3.isEmpty())
					  throw new InvalidDetailsException("Enter customer details");
				  }
				  catch(InvalidDetailsException e){
					  ta1.setText(e.getMessage());
					  return;
				  }
				  try{
				  arr=(jl.getSelectedIndices());
				  String str4,str6,str7,str5;
				  str4 = t4.getText();
						 
				  if(!(str4 == null || str4.isEmpty()) && !presentArray(arr, 0)){
					throw new InvalidItemException("Select items with Quantity");
				  }
				   str5 = t5.getText();
						 
				  if(!(str5 == null || str5.isEmpty()) && !presentArray(arr, 1)){
					throw new InvalidItemException("Select items with Quantity");
				  }
				   str6 = t6.getText();
						 
				  if(!(str6 == null || str6.isEmpty()) && !presentArray(arr, 2)){
					throw new InvalidItemException("Select items with Quantity");
				  }
				  str7= t7.getText();
						 
				  if(!(str7 == null || str7.isEmpty()) && !presentArray(arr, 3)){
					throw new InvalidItemException("Select items with Quantity");
				  }
				  
				  Pizza p1=new Pizza();
				  for (int k=0;k<4;k++)
					  p1.type[k]=0;
				for (int i=0;i<arr.length;i++){
					int c=arr[i];
					switch(c){
						case 0:
						if(str4 == null || str4.isEmpty())
					  throw new InvalidQuantityException("Enter quantity for selected items");
						am=am+Integer.parseInt(str4)*50;
					    p1.type[0]=Integer.parseInt(str4);
						break;
						case 1:
						if(str5 == null || str5.isEmpty())
					  throw new InvalidQuantityException("Enter quantity for selected items");
						am=am+Integer.parseInt(str5)*70;
						p1.type[1]=Integer.parseInt(str5);
						break;
						case 2:
						if(str6== null || str6.isEmpty())
					  throw new InvalidQuantityException("Enter quantity for selected items");
						am=am+Integer.parseInt(str6)*40;
						p1.type[2]=Integer.parseInt(str6);
						break;
						case 3:
						if(str7 == null || str7.isEmpty())
					  throw new InvalidQuantityException("Enter quantity for selected items");
						 am=am+Integer.parseInt(str7)*50;
						 p1.type[3]=Integer.parseInt(str7);
						break;}
				}
				int id = Integer.parseInt(t2.getText());
				
               int custFound=0;				
			  for(int j=0;j<custarr.size();j++){
				  Customers curr = custarr.get(j);
				  if(curr.id == id){
					custFound =1;
					c1 = curr;
					break;
				  }
			    }
			  if(custFound==1)
                                                  {
				  c1.amount = am + c1.amount;
				  c1.p.type[0] += p1.type[0];
				  c1.p.type[1] += p1.type[1];
				  c1.p.type[2] += p1.type[2];
				  c1.p.type[3] += p1.type[3];
			  }
			  else {
				  
				  c1.id=Integer.parseInt(t2.getText());
				  c1.name=t1.getText();
				  c1.address=t3.getText();
				  c1.amount=am;
				  c1.p = p1;
				  custarr.add(c1);  
			  }
			  
			  if (am>500 && am<=1000)
				  c1.p.coke200ml=c1.p.coke200ml+1;
			  if (am>1000 && am<=1500)
				  c1.p.coke200ml=c1.p.coke200ml+2;
			  if (am>=1500 )
				  c1.p.sprite500ml=c1.p.sprite500ml+1;
			  
			  
			  for(int i=0;i<arr.length;i++){
				  if(c1.p.type[i] == 0)
					  continue;
				  str=str+list[arr[i]]+":"+c1.p.type[i]+"\n";
				 
			  }
			  ta1.setText("name:"+c1.name+"\n"+"id:"+c1.id+"\n"+str+"Total amount:"+c1.amount+"\n"+"compliments:"+"\n"+
				 "coke200ml:"+c1.p.coke200ml+"\n"+"sprite500ml:"+c1.p.sprite500ml);
				 }
				catch(InvalidQuantityException e){
					  ta1.setText(e.getMessage());
					  return;
				  }
				catch(InvalidItemException e){
					  ta1.setText(e.getMessage());
					  return;
				  }
			  
			}
			if (ae.getActionCommand()=="History"){
				String arrcon=new String();
				String str1 = new String();
				try{
				String stri=t2.getText();
				if(stri == null || stri.isEmpty())
					  throw new InvalidIdException("Enter customer id");
				}
				catch(InvalidIdException e){
					  ta2.setText(e.getMessage());
				  }
				  
				
		    for (int i = 0; i < custarr.size(); i++){
	            if(Integer.parseInt(t2.getText())==custarr.get(i).id){
				  for(int j=0;j<4;j++){
					 if(custarr.get(i).p.type[j] == 0)
					  continue;
				   str1=str1+list[j]+":"+custarr.get(i).p.type[j]+"\n";
				 
			     }
				arrcon=arrcon+"id:"+custarr.get(i).id+"\n"+"name:"+custarr.get(i).name+"\n"+str1+"amount:"+custarr.get(i).amount+"\n"+"compliments:"+"\n"+"coke200ml:"+custarr.get(i).p.coke200ml+"\n"+"sprite500ml:"+custarr.get(i).p.sprite500ml+"\n\n";
				ta2.setText(arrcon);}
			}
		}
	}
	
	   public static void main(String args[]){
       pizza2 sr=new pizza2();
	}
  }