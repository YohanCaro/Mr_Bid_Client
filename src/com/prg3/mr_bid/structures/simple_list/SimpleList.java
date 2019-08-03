package com.prg3.mr_bid.structures.simple_list;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Clase SimpleList - Crea un lista simplemente enlazada
 *
 * @author Yohan Caro
 * @version 1.0 - 23/05/2019 
 * @param <T> Clase del objeto
 */
public class SimpleList<T> {

	protected Node<T> head;
	private Comparator<T> comparator;
	
	/**
	 * Constructor que crea una lista vacia
	 */
	public SimpleList() {
		this.head = null;
	}
	
	/**
	 * Constructor que se crea una lista con un elemento
	 * @param head cabeza de la lista
	 */
	public SimpleList(Node<T> head) {
		this.head = head;
	}
	
	/**
	 * Construtor que crea una lista vacia con un comparador
	 * @param head cabeza
	 * @param comparator criterio de comparacion
	 */
	public SimpleList(Comparator<T> comparator) {
		this.head = null;
		this.comparator = comparator;
	}
	
	/**
	 * Constructor que crea una lista con la información de otra lista.
	 * @param simple lista 
	 */
	public SimpleList(SimpleList<T> simple) {
		this.head = simple.getHead();
	}
	
	/**
	 * Constructor que crea una lista con un array.
	 * @param array vector
	 */
	public SimpleList(T[] ts) {
		this.addArray(ts);
	}
	
	/**
	 * Verifica si la lista está vacia (No tiene elementos
	 * @return true si esta vacia / false si tiene al menos un elemento
	 */
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	/**
	 * Añade un elemento dependiendo si se le hadado el criterio de comparación
	 * @param info dato a añadir
	 */
	public void add(T info) {
		if (this.comparator != null) {
			this.addSort(info);
		} else {
			this.addLast(info);
		}
	}
	
	/**
	 * Añade un nuevo elemento a la lista
	 * @param info dato
	 */
	public void addLast(T info) {
		if (head == null) {
			head = new Node<T>(info);
		} else {
			Node<T> aux = this.head;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = new Node<T>(info);
//			for (Node<T> aux = this.head; aux.next != null; aux2 = aux, aux = aux.next); 
//			aux2.next = new Node<T>(info);
		}
	}
	
	/**
	 * Añade un nuevo elemento por la cabeza
	 * @param info dato a añadir
	 */
	public void insert(T info) {
		this.head = new Node<T>(info, this.head);
	}
	
	/**
	 * Adiciona un nuevo objeto a la lista en un orden determinado
	 * @param info dato
	 */
	private void addSort(T info) {
		if(this.head == null) {
            this.head = new Node<T>(info);
        } else {
            if (comparator.compare(info, this.head.info) < 0) {
                this.head = new Node<T>(info, this.head);
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                while (aux != null && comparator.compare(info, aux.info) > 0) {
                    ant = aux;
                    aux = aux.next;
                }
                ant.next = new Node<T>(info,aux);
            }
        }
	}
	
	/**
	 * Añade los elementos de una lista al final
	 * @param list lista
	 */
	public void addList(SimpleList<T> list) {
		if (this.head == null) {
			this.head = list.head;
		} else {
			Node<T> aux = this.head.next;
			while (aux.next != null) {
                aux = aux.next;
            }
			aux.next = list.head;
		}
	}
	
	/**
	 * Añade los elementos de otra lista al comienzo 
	 * @param list lista
	 */
	public void insertList(SimpleList<T> list) {
		if (!list.isEmpty()) {
			Node<T> aux = list.head.next;
			while (aux.next != null) {
                aux = aux.next;
            }
			aux.next = this.head;
			this.head = list.head;
		}
	}
	
	/**
	 * Añade los elemtos de un array al final de la lista
	 * @param array vector estatico
	 */
	public void addArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			this.addLast(array[i]);
		}
	}
		
	/**
	 * Pasa los elementos de la lista a un array
	 * @return array con datos
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray(Class<T> classT) {
		Node<T> aux = this.head;
		T[] array = (T[]) Array.newInstance(classT, this.size());
		for (int i = 0; i < this.size(); i++, aux = aux.next) {
			array[i] = aux.info;
		}
		return array;
	}
	
	/**
	 * Elimina un elemento de la lista!
	 * @param info dato
	 */
	public void remove(T info) {
		if (this.comparator != null) {
			this.removeCompare(info);
		} else {
			this.removeNoCompare(info);
		}
	}
	
	/**
     * Metodo que elimina un objeto de la lista utilizando el comparador!
     * @param info elemento a eliminar.
     */
    private void removeCompare(T info) {
        if (this.head != null) {
            if (comparator.compare(head.info, info) == 0) {
                this.head = this.head.next;
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                while (aux != null) {
                    if (comparator.compare(aux.info, info) == 0) {
                        ant.next = aux.next;
                    }
                    ant = aux;
                    aux = aux.next;
                }
            }
        }
    }
    
	/**
     * Metodo que elimina un objeto de la lista!
     * @param info elemento a eliminar.
     */
    private void removeNoCompare(T info) {
        if (this.head != null) {
            if (this.head.info.equals(info)) {
                this.head = this.head.next;
            } else {
                Node<T> aux = this.head.next;
                Node<T> ant = this.head;
                while (aux != null) {
                    if (aux.info.equals(info)) {
                        ant.next = aux.next;
                    }
                    ant = aux;
                    aux = aux.next;
                }
            }
        }
    }
    
    public int getPos(T info) {
    	int pos = 0;
       	Node<T> aux = new Node<T>(info);
    	if (head != null) {
    		if (comparator.compare(head.info, info) == 0) { 
                aux.info = info;
            } else {
            	aux = this.head.next;
            	pos++;
            	while (aux != null && comparator.compare(aux.info, info) != 0) {
            		pos++;
            		aux = aux.next;
            	}
            	if (aux != null) {
            		aux = (comparator.compare(aux.info, info) == 0)? aux:null;
            	}
            }
    	}
    	return pos;
    }
    
    /**
     * Busca un elemento en la lista
     * @param info dato a buscar
     * @return el dato buscado o null si no lo encuentra
     */
    public Node<T> search(T info) {
    	return (this.comparator!=null)?this.searchCompare(info):this.searchNoCompare(info);
    }
    
    /**
     * Search a element that is entered as parameter
     * @param info Element to search
     * @return Node of element
     */
    private Node<T> searchCompare(T info) {
       	Node<T> aux = new Node<T>(info);
    	if (head != null) {
    		if (comparator.compare(head.info, info) == 0) { 
                aux.info = info;
            } else {
            	aux = this.head.next;
            	while (aux != null && comparator.compare(aux.info, info) != 0) {
            		aux = aux.next;
            	}
            	if (aux != null) {
            		aux = (comparator.compare(aux.info, info) == 0)? aux:null;
            	}
            }
    	}
    	return aux;
    }

    /**
     * Busca un objeto en la lista sin comparar
     * @param info elemento a buscar
     * @return aux elemento encontrado / o null si no
     */
    private Node<T> searchNoCompare(T info) {
        Node<T> aux = this.head;
        while (aux != null) {
            if (aux.info.equals(info)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }
    
	/**
	 * Elimina un elemento ubicado en la posicion index, y lo retorna
	 * 
	 * @param index Indice del elemento a borrar
	 * @return Elemento borrado
	 */
	public T removeAndGetElement(int index) {
		T element = this.get(index);
		this.remove(element);
		return element;
	}
    
	/**
	 * Obtiene el dato alojado en cierta posicion	 * 
	 * @param index ubicacion en la lista
	 * @return dato
	 */
	public T get(int index) {
		Node<T> aux = head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux.info;
	}
    
	/**
	 * Establece un elemento en la posicion dada	 * 
	 * @param index ubicacion
	 * @param data  dato a establecer
	 */
	public void set(int index, T data) {
		if (this.head != null && index >= 0 && index < this.size()) {
			if (index == 0) {
				this.head.info = data;
			} else {
				Node<T> aux = this.head;
				for (int i = 0; i < index; i++) {
					aux = aux.next;
				}
				aux.info = data;
			}
		}
	}
	
	/**
	 * Elimina un nodo por un indice
	 * @param index indice
	 */
	public void deleteByIndex(int index) {
		if (index == 0) {
			this.head = head.next;
		} else {
			Node<T> ant = head;
			Node<T> aux = head.next;
			for (int i = 0; i < index-1; i++) {
				ant = aux;
				aux = aux.next;
			}
			ant.next = aux.next;
		}
	}
    
    /**
     * Convierte la lista en un JsonArray
     * @return string json
     */
//    public String toJsonArray() {
//		return new Gson().toJson(this);
//    }
	
    /**
     * Give the size of the list
     * @return a integer with the size
     */
    public int size() {
    	if (head != null) {
    		int cont = 0;
    		Node<T> aux = this.head;
    		while (aux != null) {
    			aux = aux.next;
    			cont++;
    		}
    		return cont;
    	} else {
    		return -1;
    	}
    }
    
    /**
	 * Cambia 
	 * @param comparator the comparator to set
	 */
	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Obtiene la cabeza
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Cambia el valor de la cabeza
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
}
