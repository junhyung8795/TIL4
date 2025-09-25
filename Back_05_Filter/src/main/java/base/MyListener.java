package base;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
//		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("웹 어플리케이션 종료될때 호출");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		ServletContextListener.super.contextInitialized(sce);
		System.out.println("웹 어플리케이션 시작될때 호출");

	}
	
	

}
