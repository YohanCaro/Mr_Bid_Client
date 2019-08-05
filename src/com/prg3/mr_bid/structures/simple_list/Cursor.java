package com.prg3.mr_bid.structures.simple_list;

/**
 * Clase Cursor - Maneja el cursor que se va a mover en la lista!
 * Fecha - 31/08/2018
 * @author Yohan Caro
 */
public class Cursor<T> extends SimpleList<T> {
    
    private Node<T> cursor;

    /**
     * Constructor que ingresa la lista que va a recorrer el cursor
     * @param simpleList list
     */
    public Cursor(SimpleList<T> simpleList) {
        super(simpleList);
        this.cursor = this.head;
    }
    
    /**
     * Verifica si el cursor está afuera de la lista
     * @return true-false
     */
    public boolean isOut() {
        return this.cursor == null;
    }
    
    /**
     * Resetea la lista
     */
    public void reset() {
        this.cursor = this.head;
    }
    
    /**
     * Veriifca si el cursor está en el ultimo elemento
     * @return true si si - false si no
     */
    public boolean isLast() {
        return this.cursor.next == null;
    }
    
    /**
     * Obtien el elemento en donde se encuenta el cursor
     * @return cursor.info dato
     */
    public T getInfo() {
        return this.cursor.info;
    }
    
    /**
     * Pasa a el siguiente elemento el cursor
     */
    public void next() {
        this.cursor = cursor.next;
    }
    
    /**
     * Pasa al siguiente elemento de la lista y recoge el elemento
     * @return T t
     */
    public T nextAndGetInfo() {
        T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
    }
    
}
