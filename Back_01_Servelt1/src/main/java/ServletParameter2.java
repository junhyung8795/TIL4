import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletParameter2")
public class ServletParameter2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet active");
		resp.setContentType("text/html; charset=UTF-8");
		int dan = Integer.parseInt(req.getParameter("dan"));

		PrintWriter writer = resp.getWriter();

		writer.write("""
				<html>
				<head></head>
				<body>
					<h1>구구단</h1>
				""");
		for (int i = 1; i <= 9; i++) {
			writer.write(dan * i);
		}
		writer.write("</body></html>");

	}

}
