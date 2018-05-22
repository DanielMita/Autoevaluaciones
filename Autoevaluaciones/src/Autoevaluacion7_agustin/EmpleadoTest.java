package Autoevaluacion7_agustin;

/** Clase para la prueba manual de las características de la clase Empleado según el enunciado del examen
 * @source: EmpleadoTest.java
 * @version: 1.3 - 2018.04.04
 * @author: ajp
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Autoevaluacion7_agustin.Empleado;
import Autoevaluacion7_agustin.PuestoTrabajo;

public class EmpleadoTest {
	private Empleado empleado1; 
	private Empleado empleado2;

	/**
	 * Método que se ejecuta antes de cada @Test para preparar datos de prueba.
	 */
	@Before
	public void iniciarlizarDatosPrueba() {
		try {
			// Objetos para la prueba.
			empleado1 = new Empleado(); 
			empleado2 = new Empleado("Pepe López Pérez", 2000, 35, new PuestoTrabajo());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que se ejecuta después de cada @Test para limpiar datos de prueba.
	 */
	@After 
	public void borrarDatosPrueba() {
		empleado1 = null;
	}

	// Test CON DATOS VALIDOS
	@Test
	public void testConstructorConvencional() {
		assertEquals(empleado2.getNombre(), "Pepe López Pérez");
		assertEquals(empleado2.getSueldo(), 2000);
		assertEquals(empleado2.getEdad(), 35);
		assertTrue(empleado2.getPuesto() != null);
	}

	@Test
	public void testConstructorDefecto() {
		assertEquals(empleado1.getNombre(), "Nombre y apellidos");
		assertEquals(empleado1.getSueldo(), 1000);
		assertEquals(empleado1.getEdad(), 16);
		assertTrue(empleado1.getPuesto() != null);
	}

	@Test
	public void testConstructorCopia() {
		assertEquals(empleado2, new Empleado(empleado2));
	}

	@Test
	public void testSetNombre() {
		try {
			empleado1.setNombre("Pepe López Pérez");
			assertEquals(empleado1.getNombre(), "Pepe López Pérez");
		} 
		catch (Exception e) {
			fail("No debe llegar aquí.");
		} 
	}

	@Test
	public void testSetSueldo() {
		try {
			empleado1.setSueldo(2000);
			assertEquals(empleado1.getSueldo(), 2000);
		} 
		catch (Exception e) {
			fail("No debe llegar aquí.");
		} 
	}

	@Test
	public void testSetEdad() {
		try {
			empleado1.setEdad(35);
			assertEquals(empleado1.getEdad(), 35);
		} 
		catch (Exception e) {
			fail("No debe llegar aquí.");
		} 
	}

	@Test
	public void testSetPuesto() {
		try {
			empleado1.setPuesto(new PuestoTrabajo());
			assertTrue(empleado1.getPuesto() != null);
		} 
		catch (Exception e) {
			fail("No debe llegar aquí.");
		} 
	}

	@Test
	public void testValidarNombre() {
		try {
			empleado1.setNombre("Pepe López Pérez");
		} 
		catch (Exception e) {
			fail("No debe llegar aquí");
		}
	}

	@Test
	public void testValidarSueldo() {
		try {
			empleado1.setSueldo(2000);
		} 
		catch (Exception e) {
			fail("No debe llegar aquí");
		}
	}

	@Test
	public void testValidarEdad() {
		try {
			empleado1.setEdad(35);
		} 
		catch (Exception e) {
			fail("No debe llegar aquí");
		}
	}

	@Test
	public void testToString() {
		assertEquals(empleado2.toString(), "Pepe López Pérez, 2000, 35, puesto");
	}

	@Test
	public void testEqualsObject() {
		empleado1 = new Empleado(empleado2);
		assertEquals(empleado1, empleado2);
	}

	@Test
	public void testClone() {
		assertNotSame(empleado2, empleado2.clone());
	}

	@Test
	public void testHashCode() {
		assertEquals(empleado1.hashCode(),-336233128);
	}

	// Test CON DATOS NO VALIDOS
	@Test
	public void testSetNombreNull() {
		try {
			empleado1.setNombre(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError | Exception e) { 
		}
	}

	@Test
	public void testSetPuestoNull() {
		try {
			empleado1.setPuesto(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
		}
	}

	@Test
	public void testSetNombreMalFormato() {
		try {
			empleado1.setNombre("pepe López Pérez");
			fail("No debe llegar aquí...");
		} 
		catch (Exception e) { 
		}
	}

	@Test
	public void testSetSueldoNoValido() {
		try {
			empleado1.setSueldo(900);
			fail("No debe llegar aquí...");
		} 
		catch (Exception e) { 
		}
	}

	@Test
	public void testSetEdadMenor() {
		try {
			empleado1.setEdad(15);
			fail("No debe llegar aquí...");
		} 
		catch (Exception e) { 
		}
	}

	@Test
	public void testSetEdadMayor() {
		try {
			empleado1.setEdad(65);
			fail("No debe llegar aquí...");
		} 
		catch (Exception e) { 
		}
	}

} //class