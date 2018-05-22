package Autoevaluacion7_agustin;

/** 
 *  Implementa el concepto de Empleado en una aplicación de gestión según el enunciado del examen
 *  @source: Empleado.java
 *  @version: 1.3 - 2018.04.04
 *  @author: ajp
 */
public class Empleado {

    private String nombre;
    private int sueldo;
    private int edad;
    private PuestoTrabajo puesto;

    /**
     * Constructor convencional.
     * Utiliza llamadas a métodos set...() para resolver las verificaciones.
     * @param nombre
     * @param sueldo
     * @param edad
     * @param puesto
     */
    public Empleado(String nombre, int sueldo, int edad, PuestoTrabajo puesto)  throws Exception {
        setNombre(nombre);
        setSueldo(sueldo);
        setEdad(edad);
        setPuesto(puesto);
    }

    /**
     * Constructor por defecto
     */
    public Empleado() throws Exception {
        // Utiliza constructor convencional.
        this("Nommbre y apellidos", 1000, 16, new PuestoTrabajo());
    }

    /**
     * Constructor copia
     * @param empleado, el Empleado a clonar
     */
    public Empleado(Empleado empleado) {
    	assert empleado != null;
        this.nombre = new String(empleado.nombre);
        this.sueldo = empleado.sueldo;
        this.edad = empleado.edad;
        this.puesto = empleado.puesto;  
    }

    /**
     * @param nombre, a cambiar.
     */
    public void setNombre(String nombre) throws Exception {	
    	assert nombre != null;
        if (nombreValido(nombre)) {
    	    this.nombre = nombre;
        }
else { 
throw new Exception("Empleado: formato de nombre no válido."); 
        }
    }

    /**
     * @param nombre, a validar.
     * @return false, si recibe un valor 
     * nulo, indefinido o en blanco.
     */
    private boolean nombreValido(String nombre) {
     	return nombre.matches("^[A-ZÁÉÍÓÚÑ][áéíóúña-z \\w]+");
    }

    /**
     * @param sueldo, a cambiar.
     */
    public void setSueldo(int sueldo) throws Exception {
    	if (sueldoValido(sueldo)) {
            this.sueldo = sueldo; 
        }
else {
throw new Exception("Empleado: sueldo no válido.");
        }
    }

	/**
     * @param sueldo, a validar.
     * @return false, si recibe un valor no permitido.
     */
    private boolean sueldoValido(int sueldo) {
    	if (sueldo < 1000) {
            return false;
        }
	return true;
    }

	/**
     * @param edad, a cambiar.
     */
    public void setEdad(int edad) throws Exception {
    	if (edadValida(edad)) {
            this.edad = edad;
        }
else { 
throw new Exception("Empleado: edad no válida.");
        }
    }

	/**
     * @param edad, a validar,
     * @return false, si recibe un valor 
     * menor de 16 o mayor de 65.
     */
    private boolean edadValida(int edad) {
      	if (edad < 16 || edad >= 65) {
            return false;
        }
	return true;
    }

    /**
     * @param puesto, a cambiar.
     */
    public void setPuesto(PuestoTrabajo puesto) {
    	assert puesto != null;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public int getEdad() {
        return edad;
    }

    public PuestoTrabajo getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return String.format(
                   "%s, %s, %s, %s",
                   nombre, sueldo, edad, "puesto");
    }

    /**
	 * hashCode() complementa al método equals y sirve para comparar objetos de forma 
	 * rápida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al método hashcode y luego el equals.
	 * @return un número entero de 32 bit.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puesto == null) ? 0 : puesto.hashCode());
		result = prime * result + sueldo;
		return result;
	}

	/**
	 * Dos objetos son iguales si: 
	 * Son de la misma clase.
	 * Tienen los mismos valores en los atributos; o son el mismo objeto.
	 * @return falso si no cumple las condiciones.
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (nombre.equals(((Empleado) obj).nombre) &&
					sueldo == ((Empleado) obj).sueldo &&
					edad == ((Empleado) obj).edad &&
					puesto.equals(((Empleado) obj).puesto)
					) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Genera un clon del propio objeto realizando una copia profunda.
	 * @return el objeto clonado.
	*/
	@Override
	public Object clone() {
		// Utiliza el constructor copia.
		return new Empleado(this);
	}
    
} //class

