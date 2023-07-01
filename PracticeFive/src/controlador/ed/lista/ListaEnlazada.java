/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.VacioException;
import controlador.ed.lista.exception.PosicionException;

public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size = 0;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public boolean isEmpty() {
        return cabecera == null;
    }

    public boolean insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (isEmpty()) {
            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            this.size++;
        }
        return true;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer size() {
        return size;
    }

    public void imprimir() throws VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("----------Lista Enlazada ----------");

            while (aux != null) {
                System.out.println(aux.getInformacion());
                aux = aux.getSiguiente();
            }

            System.out.println("---------Lista Enlazada Terminada--------");
        }
    }

    public void deleteAll() {
        this.cabecera = null;
        this.size = 0;
    }

    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSiguiente();
            }
            NodoLista<E> sig = aux.getSiguiente();
            aux.setSiguiente(nuevo);
            nuevo.setSiguiente(sig);
            size++;
        } else {
            throw new PosicionException();
        }
    }

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInformacion();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getInformacion();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public void update(Integer pos, E dato) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    cabecera.setInformacion(dato);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getInformacion();
                }
            } else {
                throw new PosicionException();
            }
        }
    }

    public E delete(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInformacion();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSiguiente();
                    }

                    NodoLista<E> aux1 = aux.getSiguiente();
                    dato = aux1.getInformacion();

                    NodoLista<E> proximo = aux1.getSiguiente();
                    aux.setSiguiente(proximo);
                    size--;
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public void set(Integer pos, E info) throws PosicionException {
        if (isEmpty()) {
            throw new PosicionException();
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            aux.setInformacion(info);
        } else {
            throw new PosicionException();
        }
    }

    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) java.lang.reflect.Array.newInstance(cabecera.getInformacion().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getInformacion();
                aux = aux.getSiguiente();
            }

        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.deleteAll();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista Enlazada:\n");

        NodoLista<E> current = cabecera;
        while (current != null) {
            sb.append(current.getInformacion().toString()).append("\n");
            current = current.getSiguiente();
        }

        return sb.toString();
    }

}
