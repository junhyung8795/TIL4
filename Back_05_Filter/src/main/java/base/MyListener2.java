package base;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener2 implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyListener2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("웹 어플리케이션 종료될때 호출2");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		System.out.println("웹 어플리케이션 시작될때 호출2");
		System.out.println(context.getInitParameter("welcome"));//welcome에 뭘 등록할지는? -> web.xml에 설정

	}
	
	

}
