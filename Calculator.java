import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener{
JTextField t;
JButton add,sub,mul,div,AC,del,zero,zzero,rem,eq,dec;
JButton btn[]=new JButton[10];
Font f1=new Font("Ice.Free",Font.BOLD,38);
Font f2=new Font("Ice.Free",Font.BOLD,25);
char opr;
double num1,num2=0,result;
JPanel p;
Calculator(){
setLocation(600,230);
setCursor(new Cursor(Cursor.HAND_CURSOR));
setTitle("Calculator");
setResizable(false);
setSize(550,690);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

t=new JTextField("0");
t.setBounds(25,30,494,80);
t.setFont(f1);
t.setHorizontalAlignment(JTextField.RIGHT);
t.setEditable(false);
t.setBackground(new Color(224,224,224));
add(t);
getContentPane().setBackground(new Color(100,100,100));

p=new JPanel(new GridLayout(5,4));
p.setBounds(25,130,494,500);
for(int i=1;i<10;i++){
btn[i]=new JButton(String.valueOf(i));
btn[i].setBackground(new Color(40,40,40));
btn[i].setForeground(Color.WHITE);
btn[i].setFont(f2);
btn[i].addActionListener(this);
}
add=new JButton("+");
add.setBackground(new Color(40,40,40));
add.setForeground(Color.GREEN);
add.setFont(f2);

sub=new JButton("-");
sub.setBackground(new Color(40,40,40));
sub.setForeground(Color.GREEN);
sub.setFont(f2);
mul=new JButton("x");
mul.setBackground(new Color(40,40,40));
mul.setForeground(Color.GREEN);
mul.setFont(f2);
div=new JButton("/");
div.setBackground(new Color(40,40,40));
div.setForeground(Color.GREEN);
div.setFont(f2);
rem=new JButton("%");
rem.setBackground(new Color(40,40,40));
rem.setForeground(Color.GREEN);
rem.setFont(f2);
del=new JButton("Del");
del.setBackground(new Color(40,40,40));
del.setForeground(Color.RED);
del.setFont(f2);
zero=new JButton("0");
zero.setBackground(new Color(40,40,40));
zero.setForeground(Color.WHITE);
zero.setFont(f2);
zzero=new JButton("00");
zzero.setBackground(new Color(40,40,40));
zzero.setForeground(Color.WHITE);
zzero.setFont(f2);
AC=new JButton("AC");
AC.setBackground(new Color(40,40,40));
AC.setForeground(Color.ORANGE);
AC.setFont(f2);
dec=new JButton(".");
dec.setBackground(new Color(40,40,40));
dec.setForeground(Color.GREEN);
dec.setFont(f2);
eq=new JButton("=");
eq.setBackground(new Color(255,255,0));
eq.setForeground(Color.BLACK);
eq.setFont(f2);
p.add(AC);
p.add(del);
p.add(div);
p.add(rem);
p.add(btn[7]);
p.add(btn[8]);
p.add(btn[9]);
p.add(add);
p.add(btn[4]);
p.add(btn[5]);
p.add(btn[6]);
p.add(sub);
p.add(btn[1]);
p.add(btn[2]);
p.add(btn[3]);
p.add(mul);
p.add(zero);
p.add(zzero);
p.add(dec);
p.add(eq);
add(p);
AC.addActionListener(this);
dec.addActionListener(this);
eq.addActionListener(this);
zero.addActionListener(this);
zzero.addActionListener(this);
del.addActionListener(this);
add.addActionListener(this);
sub.addActionListener(this);
mul.addActionListener(this);
div.addActionListener(this);
rem.addActionListener(this);
setLayout(null);
setVisible(true);

}
public void actionPerformed(ActionEvent ae){
    for(int i=1;i<10;i++){
if(ae.getSource()==btn[i]){
    t.setText(t.getText().concat(String.valueOf(i)));
}
    }
    if(ae.getSource()==zero){
        t.setText(t.getText().concat("0"));
    }
    if(ae.getSource()==zzero){
        t.setText(t.getText().concat("00"));
    }
    if(ae.getSource()==dec){
        t.setText(t.getText().concat("."));
    }
    if(ae.getSource()==AC){
        t.setText("");
    }
    if(ae.getSource()==add){
        num1=Double.parseDouble(t.getText());
        opr='+';
        t.setText("");
    }
    if(ae.getSource()==sub){
        num1=Double.parseDouble(t.getText());
        opr='-';
        t.setText("");
    }
    if(ae.getSource()==mul){
        num1=Double.parseDouble(t.getText());
        opr='*';
        t.setText("");
    }
    if(ae.getSource()==div){
        num1=Double.parseDouble(t.getText());
        opr='/';
        t.setText("");
    }
    if(ae.getSource()==rem){
        num1=Double.parseDouble(t.getText());
        opr='%';
        t.setText("");
    }
    if(ae.getSource()==del){
        String s="";
        if(t.getText().length()>0){
            StringBuilder str=new StringBuilder(t.getText());
            str.deleteCharAt(t.getText().length()-1);
            s=str.toString();
            t.setText(s);
        }
    }
    if(ae.getSource()==eq){
        
        try{
        num2=Double.parseDouble(t.getText());    
        switch (opr) {
            case '+':
                t.setText(num1+" + "+num2+"   =  "+String.valueOf(num1+num2));
                break;
            case '-':
                t.setText(num1+" - "+num2+"   =  "+String.valueOf(num1-num2));
                break;
             case '*':
                t.setText(num1+" x "+num2+"   =  "+String.valueOf(num1*num2));
                break;
             case '/':
                t.setText(num1+" / "+num2+"   =  "+String.valueOf(num1/num2));
                break;
             case '%':
                t.setText(num1+" % "+num2+"   =  "+String.valueOf(num1%num2));
                break;
        }
    }catch(Exception e ){
        JOptionPane.showMessageDialog(null,"Invalid Syntax");
        t.setText("");
    }
    }
}
public static void main(String args[]){
new Calculator();
}
}