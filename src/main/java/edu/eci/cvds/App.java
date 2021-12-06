package edu.eci.cvds;
import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

import edu.eci.cvds.persistence.MyDAOImplement.Mappers.OfertaMapper;
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
        OfertaMapper co= sqlss.getMapper(OfertaMapper.class);
       
        //cm...
        /*
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

        System.out.println("Actualizar Necesidad");
        cn.actualizarNecesidad(5,"en proceso");

        System.out.println("Consulta Necesidad2");
        System.out.println(cn.consultarNecesidad());
        sqlss.commit();

        ca.crearCategoria("deportiva","area deportes",new Date(2021-11-01),new Date(2021-11-02));
        System.out.println(ca.consultarCategoria());
        */
    /*
        co.crearOferta(2,"donacion","donacion de libros","en proceso",new Date(2021-11-01),new Date(2021-11-02));
        System.out.println("consultar ofertas");
        System.out.println(co.consultarOfertas());

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

        System.out.println("Actualizar Oferta");
        co.actualizarOferta(35,"finalizada");
        System.out.println(co.consultarOfertas());
    */
        cn.crearNecesidad(2,"escases de computadores","escases de computadores sala B","A",new Date(2021-11-01),"activa",new Date(2021-11-02));
        System.out.println("consultar necesidades");
        System.out.println(cn.consultarNecesidad());

        sqlss.close();
       
    }

	
}