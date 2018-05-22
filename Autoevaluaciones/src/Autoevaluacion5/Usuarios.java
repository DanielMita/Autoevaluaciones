package Autoevaluacion5;
class Usuario {

	
    //Atributos
    public String nif;
    public String nombre;
    public String apellidos;
    public String correo;
    public String domicilio;
    public String fechaNacimiento;
    public String fechaAlta;
    public String claveAcceso;
    public String rol;

    
    
   
	public String toString() {
		return   			// Incluye identificador de objeto.
				"\n nif: \t\t" + nif 
				+ "\n nombre: \t" + nombre 
				+ "\n apellidos: \t" + apellidos 
				+ "\n domicilio: \t" + domicilio 
				+ "\n correo: \t" + correo 
				+ "\n fechaNacimiento:" + fechaNacimiento
				+ "\n fechaAlta: \t" + fechaAlta 
				+ "\n claveAcceso: \t" + claveAcceso
				+ "\n rol: \t\t" + rol ;
	}
} //class

public class Usuarios {
	
	final static int MAX_USUARIOS = 45;
	public static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	
	
	
	
	public static void main(String[] args) {
			
			
			
			int [] patron = {1,0,1,0,0,1};
			
			cargarDatosUsuariosPatron(patron);
	}
	
	
	
	public static void cargarDatosUsuariosPatron(int[]patron) {
		
		
		
		int longitud = patron.length-1;
		int indPatron = 0;
		for (int i = 0; i < datosUsuarios.length; i++) {
			
			Usuario usuarioAux = new Usuario();
		
			if(patron[indPatron] == 1) {
			usuarioAux.nif = i + "344556K";
			usuarioAux.nombre = "Pepe" + i; 
			usuarioAux.apellidos = "LÃ³pez" + " PÃ©rez" +i ;
			usuarioAux.domicilio = "C/Luna, 27 30132 Murcia";
			usuarioAux.correo = "pepe" + i + "@gmail.com";
			usuarioAux.fechaNacimiento = "1999.11.12";
			usuarioAux.fechaAlta = "2017.12.3";
			usuarioAux.claveAcceso = "Miau#" + i;
			usuarioAux.rol = "usuario normal";
			
			}
			else {
				usuarioAux = null;
			}
			
			
			/**
			 * LA CLAVE ESTÁ AQUI, IGUALAMOS UN OBJETO DEL VECTOR CON EL OBJETO QUE ACABAMOS DE MODIFICAR
			 * Se puede poner despues del if-else ya que en el else, se pone a null, asique no hay problema
			 */
			datosUsuarios[i] = usuarioAux;
			
			
			/**
			 * indPatron > longitud --> longitud vale 5, si indPatron vale mas que eso (6,7,etc) lo ponemos a 0
			 * De lo contrario (es decir, si vale 5, 5 no es mayor que 5, asique no entraria) itera el ultimo elemento
			 */
			indPatron++;
			if(indPatron > longitud) {
				indPatron = 0;
			}
		}
		
		
		
		//Metodo que ni recibe ni devuelve, solo muestra por pantalla
		mostrarTodosUsuarios();
		
	}
	
	

	
	static void mostrarTodosUsuarios() {
		for (Usuario u: datosUsuarios) {
			System.out.println("\n" + u);
		}
}

}
