package controlador.busqueda;

import controlador.ed.lista.NodoLista;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ordenacion.MergeSort;
import modelo.Comparator;
import modelo.Compositor;

public class BusquedaLinealBinaria<E> {

    private final Comparator<E> comparator;

    public BusquedaLinealBinaria(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public ListaEnlazada<E> search(ListaEnlazada<E> lista, ListaEnlazada<E> keys) throws VacioException, PosicionException {
        // Ordenar la lista utilizando MergeSort
        MergeSort<E> mergeSort = new MergeSort<>(comparator);
        mergeSort.sort(lista);

        ListaEnlazada<E> results = new ListaEnlazada<>();

        NodoLista<E> currentKey = keys.getCabecera();
        while (currentKey != null) {
            E key = currentKey.getInformacion();

            int binaryIndex = binarySearch(lista, key);
            if (binaryIndex != -1) {
                // Utilizar búsqueda lineal desde el índice encontrado
                ListaEnlazada<E> linearResults = linearSearchFromIndex(lista, key, binaryIndex);
                NodoLista<E> currentNode = linearResults.getCabecera();
                while (currentNode != null) {
                    results.insertar(currentNode.getInformacion());
                    currentNode = currentNode.getSiguiente();
                }
            }

            currentKey = currentKey.getSiguiente();
        }

        return results;
    }

    private int binarySearch(ListaEnlazada<E> lista, E key) throws VacioException, PosicionException {
        int low = 0;
        int high = lista.getSize() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            E element = lista.get(mid);

            if (comparator.compare(element, key) == 0) {
                return mid;
            } else if (comparator.compare(element, key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private ListaEnlazada<E> linearSearchFromIndex(ListaEnlazada<E> lista, E key, int startIndex) throws VacioException, PosicionException {
        ListaEnlazada<E> results = new ListaEnlazada<>();

        for (int i = startIndex; i < lista.getSize(); i++) {
            if (comparator.compare(lista.get(i), key) == 0) {
                results.insertar(lista.get(i));
            } else {
                break;
            }
        }

        return results;
    }

}
