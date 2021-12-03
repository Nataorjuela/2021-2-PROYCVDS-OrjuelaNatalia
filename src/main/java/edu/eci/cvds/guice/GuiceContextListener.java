package edu.eci.cvds.guice;
import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.MyDAOImplement.UsuarioDAOImpl;
import edu.eci.cvds.security.LoggerImplements;
import edu.eci.cvds.security.Loggers;
import edu.eci.cvds.managedbeans.BasePageBean;
import edu.eci.cvds.managedbeans.UsuarioBean;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ServicioSolidaridad;
import edu.eci.cvds.services.impl.ServicioSolidaridadImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent){
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent){
        Injector injector = Guice.createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){

                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                //Servicios
                bind(BasePageBean.class).to(UsuarioBean.class);	
                bind(UsuarioDAO.class).to(UsuarioDAOImpl.class);
                bind(Loggers.class).to(LoggerImplements.class);
                
                
            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }
}