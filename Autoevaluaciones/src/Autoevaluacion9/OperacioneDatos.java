package Autoevaluacion9;

/** 
 *  Interfaz con las operaciones previstas del almacén de datos según el enunciado de examen.
 *  @source: OperacionesDatos.java
 *  @version: 1.2 - 2018.05.28
 *  @author: ajp
 */
import java.io.File;

public interface OperacioneDatos {

    /**
     *  Alta de un objeto en el almacén de datos.
     *  @param obj - Objeto a almacenar.
     *  @throws DatosException - si ya existe.
     */
    void alta(Object obj) throws DatosException;

    /**
     *  Importa datos a la base de datos desde un fichero con objetos serializados.
     *  @param fDatos - Fichero con los datos a importar.
     *  @throws DatosException - si hay errores.
     */
    void importar(File fDatos) throws DatosException;

} //interface