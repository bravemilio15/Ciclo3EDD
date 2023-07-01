package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import modelo.Comparator;

public class QuickSort<E> {

    private final Comparator<E> comparator;

    public QuickSort(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void sort(ListaEnlazada<E> lista, int orden) throws VacioException, PosicionException {
        quickSort(lista, 0, lista.getSize() - 1, orden);
    }

    private void quickSort(ListaEnlazada<E> lista, int low, int high, int orden) throws VacioException, PosicionException {
        if (low < high) {
            int pivot = partition(lista, low, high, orden);
            quickSort(lista, low, pivot - 1, orden);
            quickSort(lista, pivot + 1, high, orden);
        }
    }

    private int partition(ListaEnlazada<E> lista, int low, int high, int orden) throws VacioException, PosicionException {
        E pivot = lista.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int comparisonResult;
            switch (orden) {
                case 0: // Ascendente
                    comparisonResult = comparator.compare(lista.get(j), pivot);
                    break;
                case 1: // Descendente
                    comparisonResult = comparator.compare(pivot, lista.get(j));
                    break;
                default:
                    throw new IllegalArgumentException("Orden no válido: " + orden);
            }

            if (comparisonResult <= 0) {
                i++;

                E temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        E temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);

        return i + 1;
    }
}

