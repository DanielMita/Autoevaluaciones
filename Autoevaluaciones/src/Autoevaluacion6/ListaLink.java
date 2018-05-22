
package Autoevaluacion6;

/**
 * Representa la implementación parcial de una lista enlazada simple en la que
 * se tiene acceso directo al primer elemento.
 */
public class ListaLink {

    /**
     * La clase Nodo está anidada y representa la estructura de un elemento de
     * la lista enlazada simple.
     */
    class Nodo {

        //Atributos
        Object dato;
        Nodo siguiente;

        /**
         * Constructor que inicializa atributos al valor por defecto.
         */
        public Nodo() {
            dato = null;
            siguiente = null;
        }

    } //class Nodo


    //Atributos ListaLink
    private Nodo primero;
    private int numElementos;

    /**
     * Constructor que inicializa los atributos al valor por defecto
     */
    public ListaLink() {
        primero = null;
        numElementos = 0;
    }

} //class listaLink