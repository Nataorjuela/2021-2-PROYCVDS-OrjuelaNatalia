package edu.eci.cvds.services;
import com.google.inject.Injector;
//import edu.eci.cvds.persistence.*;
//import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.impl.ServicioSolidaridadImpl;
import org.mybatis.guice.XMLMyBatisModule;
import java.util.Optional;
import static com.google.inject.Guice.createInjector;
public class ServicioSolidaridadFactory {

    private static ServicioSolidaridadFactory instance = new ServicioSolidaridadFactory();
    private static Optional<Injector> optInjector;
    private ServicioSolidaridadFactory() {
        optInjector = Optional.empty();
    }

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ServicioSolidaridad.class).to(ServicioSolidaridadImpl.class);
            }
        });
    }

    public ServicioSolidaridad getSolidaridadServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServicioSolidaridad.class);
    }


    public ServicioSolidaridad getSolidaridadServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServicioSolidaridad.class);
    }


    public static ServicioSolidaridadFactory getInstance(){
        return instance;
    }
}
