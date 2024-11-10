package jdbcexample;
/*
    JDBC (Java Database Connectivity) is an API in Java that allows applications to interact with relational databases. It provides a way to connect to a database, execute SQL queries, retrieve results, and manage transactions. 
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String sql = "INSERT INTO `department`(`dept_name`, `building`, `budget`) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "aaaaa");
            statement.setString(2, "fgffffhhgf");
            statement.setString(3, "10");

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Success!");
            } else {
                System.out.println("Failed");
            }
            statement.close();
            
            //---------------------------------------
            String query = "SELECT * FROM department";
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("dept_name"));
                System.out.println(resultSet.getInt("budget"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Steps to Connect to a Database using JDBC:
    -Load the JDBC Driver
    -Establish a Connection
    -Create a Statement
    -Execute Queries
    -Process the Result
    -Close the Connection
*/

/*
Here's how to add the JDBC driver to your project:

1. Download the JDBC Driver
For MySQL, download the MySQL Connector/J driver (usually a .jar file).

2. Add the JDBC Driver to Your Project's Classpath
For IDEs (like IntelliJ IDEA or Eclipse)
IntelliJ IDEA:

Go to File > Project Structure.
Select Libraries on the left sidebar.
Click + (Add), then Java.
Locate the downloaded .jar file and click Open.
Click OK to add it to your project.
Eclipse:

Right-click on your project in the Project Explorer.
Select Build Path > Configure Build Path.
Go to the Libraries tab.
Click Add External JARs... and select the downloaded JDBC .jar file.
Click Apply and Close.
For Maven Projects
If you're using Maven, you can add the JDBC driver directly by adding the following dependency to your pom.xml file:

xml
Copy code
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version> <!-- Use the latest version here -->
</dependency>
*/

/*
3. Verify the Setup
To confirm the driver is correctly added, try running a basic JDBC connection to your database. If there’s a class not found error (e.g., ClassNotFoundException: com.mysql.cj.jdbc.Driver), it means the driver is missing from your classpath.

Adding the JDBC driver to your classpath ensures that your Java application can locate and use the required classes to establish a connection with the database.
*/