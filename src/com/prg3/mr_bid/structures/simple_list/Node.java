package com.prg3.mr_bid.structures.simple_list;

/**
 * Clase Node.java - Nodo de la lista simple
 *
 * @author Yohan Caro
 * @version 1.- 23/05/2019 
 * @param <T> Tipo de dato
 */
public class Node<T> {

	protected T info;
	protected Node<T> next;
	
	/**
	 * Constructor que crea un nodo con un dato y la información
	 * del siguinete
	 * @param info dato
	 * @param next infomacion del siguinete
	 */
	public Node(T info, Node<T> next) {
		this.info = info;
		this.next = next;
	}
	
	/**
	 * Constructor que crea un nodo con un dato
	 * @param info dato
	 */
	public Node(T info) {
		this.info = info;
	}
	
	/**
	 * Obtiene el dato del nodo
	 * @return info dato
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Obtiene el siguiente nodo
	 * @return next siguiente nodo
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * Cambia la información del nodo
	 * @param info dato
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * Cambia la información del siguiente nodo
	 * @param next siguinete nodo
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
