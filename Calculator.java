import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigInteger;
import java.sql.PreparedStatement;

class calc implements ActionListener
{
    double n1=0, n2=0, ans=0;
    char op;
    JFrame cal = new JFrame("Calculator");
    JTextField text;
    JPanel panel = new JPanel();
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[15];
    JButton plus,minus,mul,div,pow,neg,equal,root,dec,sin,cos,tan,clear,log,ncr,npr,fact,x2,pi,x3;
    calc()
    {
        Font myfont = new Font("Times New Roman",Font.BOLD,15);
        cal.setSize(375,550);
        cal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cal.getContentPane().setBackground(new Color(159,157,190));
        ImageIcon icon = new ImageIcon("img.png");
        cal.setIconImage(icon.getImage());
        cal.setResizable(false);
        cal.setLayout(null);
        for(int i=0;i<=9;i++)
        {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            numbers[i].setFont(myfont);
        }
        plus = new JButton("+");
        plus.setFont(myfont);
        minus = new JButton("-");
        minus.setFont(myfont);
        mul = new JButton("x");
        mul.setFont(myfont);
        div = new JButton("/");
        div.setFont(myfont);
        equal = new JButton("=");
        equal.setFont(myfont);
        pow = new JButton("^");
        pow.setFont(myfont);
        log = new JButton("log");
        log.setFont(myfont);
        dec = new JButton(".");
        dec.setFont(myfont);
        neg = new JButton("(-)");
        neg.setFont(myfont);
        ncr = new JButton("nCr");
        ncr.setFont(myfont);
        npr = new JButton("nPr");
        npr.setFont(myfont);
        clear = new JButton("AC");
        clear.setFont(myfont);
        root = new JButton("√");
        root.setFont(myfont);
        sin = new JButton("sin");
        sin.setFont(myfont);
        cos = new JButton("cos");
        cos.setFont(myfont);
        tan = new JButton("tan");
        tan.setFont(myfont);
        pi = new JButton("π");
        pi.setFont(myfont);
        x2 = new JButton("X^2");
        x2.setFont(myfont);
        x3 = new JButton("X^3");
        x3.setFont(myfont);
        fact = new JButton("x!");
        fact.setFont(myfont);


        plus.addActionListener(this);
        minus.addActionListener(this);
        mul.addActionListener(this);
        dec.addActionListener(this);
        div.addActionListener(this);
        pow.addActionListener(this);
        x2.addActionListener(this);
        x3.addActionListener(this);
        fact.addActionListener(this);
        pi.addActionListener(this);
        neg.addActionListener(this);
        root.addActionListener(this);
        ncr.addActionListener(this);
        npr.addActionListener(this);
        log.addActionListener(this);
        sin.addActionListener(this);
        clear.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        equal.addActionListener(this);

        text = new JTextField();
        text.setBorder(BorderFactory.createEmptyBorder());
        text.setBounds(5,10,350,80);
        text.setEditable(false);
        Font textfont = new Font("Times New Roman", Font.BOLD, 30);
        text.setFont(textfont);

        cal.add(text);
        panel.setBackground(new Color(159,158,190));
        panel.add(ncr);
        panel.add(npr);
        panel.add(pi);
        panel.add(fact);
        panel.add(x3);
        panel.add(log);
        panel.add(sin);
        panel.add(cos);
        panel.add(tan);
        panel.add(x2);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(plus);
        panel.add(pow);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(minus);
        panel.add(neg);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(mul);
        panel.add(root);
        panel.add(dec);
        panel.add(numbers[0]);
        panel.add(equal);
        panel.add(div);
        panel.add(clear);

        panel.setBounds(5, 100, 350, 400);
        panel.setLayout(new GridLayout(6,5,10,10));
        cal.add(panel);
        cal.setVisible(true);
    }
    public BigInteger factorial(int n)
    {
        int i=1;
        BigInteger ans= BigInteger.valueOf(1);
        while(i<=n)
        {
            ans=ans.multiply(BigInteger.valueOf(i));
            i++;
        }
        return ans;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0;i<=9;i++)
        {
            if(e.getSource()==numbers[i])
            {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==dec)
        {
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==plus) {
            n1 = Double.parseDouble(text.getText());
            op ='+';
            text.setText("");
        }
        if(e.getSource()==minus)
        {
            n1 = Double.parseDouble(text.getText());
            op = '-';
            text.setText("");
        }
        if(e.getSource()==mul)
        {
            n1 = Double.parseDouble(text.getText());
            op = '*';
            text.setText("");
        }
        if(e.getSource()==div)
        {
            n1 = Double.parseDouble(text.getText());
            op = '/';
            text.setText("");
        }
        if(e.getSource()==neg)
        {
            n1 = Double.parseDouble(text.getText());
            op='_';
            text.setText("");
        }
        if(e.getSource()==pow)
        {
            n1 = Double.parseDouble(text.getText());
            op = '^';
            text.setText("");
        }
        if(e.getSource()==clear)
        {
            text.setText("");
        }
        if(e.getSource()==x2)
        {
            n1 = Double.parseDouble(text.getText());
            op='s';
            text.setText("");
        }
        if(e.getSource()==x3)
        {
            n1 = Double.parseDouble(text.getText());
            op='c';
            text.setText("");
        }
        if(e.getSource()==pi)
        {
            n1 = 3.14159;
            op='|';
            text.setText(String.valueOf(n1));
        }
        if(e.getSource()==ncr)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'n';
            text.setText("");
        }
        if (e.getSource()==npr)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'p';
            text.setText("");
        }
        if(e.getSource()==root)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'r';
            text.setText("");
        }
        if(e.getSource()==fact)
        {
            n1 = Double.parseDouble(text.getText());
            op = '!';
            text.setText("");
        }
        if(e.getSource()==log)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'l';
            text.setText("");
        }
        if(e.getSource()==sin)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'S';
            text.setText("");
        }
        if(e.getSource()==cos)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'C';
            text.setText("");
        }
        if (e.getSource()==tan)
        {
            n1 = Double.parseDouble(text.getText());
            op = 'T';
            text.setText("");
        }
        if(e.getSource()==pow)
        {
            n1 = Double.parseDouble(text.getText());
            op = '^';
            text.setText("");
        }
        if(e.getSource()==equal) {
            if(op=='+'||op=='-'||op=='*'||op=='/'||op=='^'||op=='n'||op=='p')
            {
                n2 = Double.parseDouble(text.getText());
            }
            switch(op) {
                case'+':
                    ans=n1+n2;
                    break;
                case'-':
                    ans=n1-n2;
                    break;
                case'*':
                    ans=n1*n2;
                    break;
                case'/':
                    ans=n1/n2;
                    break;
                case'^':
                    ans = Math.pow(n1,n2);
                    break;
                case's':
                    n2=2;
                    ans = Math.pow(n1,n2);
                    break;
                case'c':
                    n2=3;
                    ans = Math.pow(n1,n2);
                    break;
                case'S':
                    ans = Math.sin(Math.toRadians(n1));
                    break;
                case'C':
                    ans = Math.cos(Math.toRadians(n1));
                    break;
                case'T':
                    ans = Math.tan(Math.toRadians(n1));
                    break;
                case 'l':
                    ans = Math.log10(n1);
                    break;
                case'r':
                    ans = Math.sqrt(n1);
                    break;
                case'_':
                    ans = -n1;
                    break;
                case'!':
                    int n = (int)n1;
                    BigInteger ans1 = this.factorial(n);
                    ans = Double.parseDouble(String.valueOf(ans1));
                    break;
                case'n':
                    int num1 = (int)n1;
                    int num2 = (int)n2;
                    BigInteger num = factorial(num1);
                    BigInteger den =  (factorial(num1-num2)).multiply((factorial(num2)));
                    BigInteger answer = num.divide(den);
                    ans = Double.parseDouble(String.valueOf(answer));
                    break;
                case'p':
                    int a = (int)n1;
                    int b = (int)n2;
                    BigInteger an = factorial(a).divide(factorial(a-b));
                    ans = Double.parseDouble(String.valueOf(an));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + op);
            }
            text.setText(String.valueOf(ans));
            n1=ans;
        }
    }
}
public class Calculator {
    public static void main(String[] args) {
        calc c = new calc();
    }
}
