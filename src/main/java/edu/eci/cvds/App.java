package edu.eci.cvds;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.persistence.MyDAOImplement.Mappers.NecesidadMapper;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.CategoriaMapper;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.UsuarioMapper;


public class App 
{
	
	public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }
	public static void main(String args[]) throws SQLException {
        
        SqlSessionFactory sessionfact = getSqlSessionFactory();

 

        SqlSession sqlss = sessionfact.openSession();
       
       // ServiciosLab sA= ServiciosLabFactory.getInstance().getServiciosLab();

 

        
        //Crear el mapper y usarlo: 
        UsuarioMapper cm= sqlss.getMapper(UsuarioMapper.class);
        CategoriaMapper ca= sqlss.getMapper(CategoriaMapper.class);
        NecesidadMapper cn= sqlss.getMapper(NecesidadMapper.class);
       
        //cm...
        System.out.println("Consulta Usuarios");
        System.out.println(cm.consultarUsuarios());
        System.out.println("----------------------");
        System.out.println("----------------------");
        
        System.out.println("Consulta Categorias");
        System.out.println(ca.consultarCategoria());
        
        System.out.println("----------------------");
        System.out.println("----------------------");
        
        
        System.out.println("Elimina Categoria");
        ca.eliminarCategoria(1);
        
        System.out.println("----------------------");
        System.out.println("----------------------");


        System.out.println("Consulta Necesidad");
        System.out.println(cn.consultarNecesidad());
       

        sqlss.commit();
        
        
        sqlss.close();

 

        
        
    }

	
}