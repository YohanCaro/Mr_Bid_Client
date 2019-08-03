package com.prg3.mr_bid.structures.simple_list;

/**
 * Clase Cursor - Maneja el cursor que se va a mover en la lista!
 * Fecha - 31/08/2018
 * @author Yohan Caro
 */
public class Cursor<T> extends SimpleList<T> {
    
    private Node<T> cursor;

    public Cursor(SimpleList<T> simpleList) {
        super(simpleList);
        this.cursor = this.head;
    }
    
    public boolean isOut() {
        return this.cursor == null;
    }
    
    public void reset() {
        this.cursor = this.head;
    }
    
    public boolean isLast() {
        return this.cursor.next == null;
    }
    
    public T getInfo() {
        return this.cursor.info;
    }
    
    public void next() {
        this.cursor = cursor.next;
    }
    
    public T nextAndGetInfo() {
        T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
    }
    
}
