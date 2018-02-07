import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java .sql.*;

class loginform extends Frame implements ActionListener
{
Connection con=null;
Statement st1;
ResultSet rs;

Label llogin;
Label luname;
Label lpass;
Button bfpass;
Label lnewuser;
Button bsignup;

TextField tuname;
TextField tpass;

Checkbox cbox;

Button blogin;

loginform()
{
llogin=new Label("ACCOUNT LOGIN");
luname=new Label("USERNAME");
lpass=new Label("PASSWORD");
bfpass=new Button("Forgot Password?");
lnewuser=new Label("New User?");
bsignup=new Button("Sign up here");

tuname=new TextField();
tpass=new TextField();

cbox=new Checkbox("Show Password");

blogin=new Button("LOG IN");

llogin.setBounds(200,150,170,30);
luname.setBounds(200,210,100,15);
tuname.setBounds(200,230,380,35);
lpass.setBounds(200,280,100,15);
tpass.setBounds(200,300,380,35);
cbox.setBounds(200,350,100,20);
bfpass.setBounds(470,350,110,20);
blogin.setBounds(200,400,380,40);
lnewuser.setBounds(200,450,100,20);
bsignup.setBounds(200,470,100,20);

tpass.setEchoChar('*');
Color c=new Color(100,239,255);
setBackground(Color.BLACK);
llogin.setBackground(Color.WHITE);
luname.setBackground(Color.WHITE);
lpass.setBackground(Color.WHITE);
cbox.setBackground(Color.WHITE);
bfpass.setBackground(Color.WHITE);
lnewuser.setBackground(Color.WHITE);
bsignup.setBackground(Color.WHITE);

Font f=new Font("Cambria Math",Font.BOLD,20);
llogin.setFont(f);
Color w=new Color(0,128,255);
llogin.setForeground(w);
bfpass.setForeground(w);
blogin.setBackground(w);
bsignup.setForeground(w);

blogin.setForeground(Color.WHITE);
Color e=new Color(221,221,221);
tuname.setBackground(e);
tpass.setBackground(e);

add(llogin);add(luname);add(tuname);add(tpass);add(lpass);add(cbox);add(bfpass);add(blogin);
add(bsignup);add(lnewuser);
blogin.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==blogin)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:nk");
st1=con.createStatement();
rs=st1.executeQuery("Select * from Details");
while(rs.next())
{
String a=rs.getString(1);	
String b=rs.getString(2);
String c=tuname.getText();
String d=tpass.getText();
if(c.equals(a)&&d.equals(b))
{
studentform log=new studentform();

log.setSize(820,730);
log.setVisible(true);
dispose();
}
else
{
tuname.setText("");
tpass.setText("");
}}}
catch(Exception f)
{
	System.out.println("Error");
}}}

public static void main(String args[])
{
loginform logg=new loginform();
logg.setLayout(null);
logg.setVisible(true);
logg.setSize(820,730);
}
public void update(Graphics g)
{
	paint(g);
}
public void paint(Graphics g)
{
g.setColor(Color.WHITE);
g.fillRect(150,100,500,450);
Color r=new Color(0,128,255);
g.setColor(r);
g.fillRect(650,100,20,450);
}
}
