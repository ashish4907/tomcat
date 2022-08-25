import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eid = Integer.parseInt(request.getParameter("eid"));
		String ename = request.getParameter("ename");
		int esal = Integer.parseInt(request.getParameter("esalary"));
		try {
			insertData(eid, ename, esal);
		} catch (Exception e) {

			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();

		pw.println("Id is " + eid);
		pw.println("Name is " + ename);
		pw.println("Salary is " + esal);
		pw.println("Successfully Inserted");
	}

	public static String insertData(int eid, String ename, int esal) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
		String query = "INSERT INTO employee VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, eid);
		ps.setString(2, ename);
		ps.setInt(3, esal);

		ps.executeUpdate();
		ps.close();
		conn.close();
		return query;

	}

}
