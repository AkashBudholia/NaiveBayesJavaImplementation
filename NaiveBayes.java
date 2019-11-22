
package dwm.bayes;
import java.sql.*;
import java.util.*;

class NaiveBayes
{
    public static void main(String args[])
    {
		try
		{
			/*
			c1 and c2 denote class 1 & class 2. 
			class1 :- Customer buys computer
			class2 :- Customer doesn't buy computer
			*/
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "bayes";
			String userName = "root";
			String password = "root";
		
		
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, userName, password);
			Statement s = con.createStatement();
			String query = null;
			ResultSet rs = null;
			int c1=0 ,c2=0 ,n=0;

			query ="SELECT     COUNT(*) AS Expr1    FROM   info WHERE (class = 'yes') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					
					c1=Integer.parseInt(rs.getString(1));

			query ="SELECT     COUNT(*) AS Expr1    FROM   info WHERE (class = 'no') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					
					c2=Integer.parseInt(rs.getString(1)); 

			query = "SELECT     COUNT(*) AS Expr1   FROM  info ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					
					n = Integer.parseInt(rs.getString(1)); 

			float pc1 = (float)c1/n; 
			float pc2 = (float)c2/n; 

			System.out.println("c1= " +c1 +"\nc2="+c2+"\ntotal="+n);
			System.out.println("p(c1)="+pc1);
			System.out.println("p(c2)="+pc2);

			Scanner sc = new Scanner(System.in);

			String age,income,student,c_rating,class1;
			
			
			System.out.println("Enter age: (youth/middle/senior)");
			age = sc.next();

			System.out.println("Enter income:(low/medium/high)");
			income = sc.next();

			System.out.println("Enter student:(yes/no)");
			student = sc.next();

			System.out.println("Enter c_rating:(fair/excellent)");
			c_rating = sc.next();


			float pinc1=0,pinc2=0;
			
				
			pinc1 = pfind(age,income,student,c_rating,"yes");
			pinc2 = pfind(age,income,student,c_rating,"no");

			pinc1 = pinc1 * pc1;
			pinc2 = pinc2 * pc2;

			
			if(pinc1 > pinc2)
				System.out.println("He will buy computer");
			else
				System.out.println("He will not buy computer");

			s.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+ e);
		}
	}

	public static float pfind(String age,String income,String student,String c_rating,String class1)
	{
		float ans = 0;
		try{
			Scanner sc = new Scanner(System.in);
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:ecompany");*/
			
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bayes",
                    "root","root");
			Statement s = con.createStatement();
			String query = null;
			ResultSet rs = null;
			int a=0 , b=0 , c=0 , d=0 , total=0;
			
			

			query ="SELECT    COUNT(*) AS Expr1     FROM   info WHERE   (age = '"+ age + "' ) AND (class = '" +class1 +"') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					a=Integer.parseInt(rs.getString(1));

			query ="SELECT    COUNT(*) AS Expr1     FROM   info WHERE   ( income = '"+ income + "' ) AND (class = '" +class1 +"') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					b=Integer.parseInt(rs.getString(1));


			query ="SELECT    COUNT(*) AS Expr1     FROM   info WHERE   ( student = '"+ student + "' ) AND (class = '" +class1 +"') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					c=Integer.parseInt(rs.getString(1));


			query ="SELECT    COUNT(*) AS Expr1     FROM   info WHERE   ( c_rating = '"+ c_rating + "' ) AND (class = '" +class1 +"')";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					d=Integer.parseInt(rs.getString(1)); 
			query ="SELECT    COUNT(*) AS Expr1     FROM   info WHERE   (class = '" +class1 +"') ";
			s.execute(query);
			rs= s.getResultSet();
			if(rs.next())
					total=Integer.parseInt(rs.getString(1)); 

			ans = (float)a / (float)total  * (float)b /(float)total * (float)c /(float)total * (float)d /(float)total ;
			
			s.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+ e);
		}
		return ans;
	}
}

/* OUTPUT:-

Enter age: (youth/middle/senior)
youth
Enter income:(low/medium/high)
medium
Enter student:(yes/no)
yes
Enter c_rating:(fair/excellent)
fair
He will buy computer
*/
