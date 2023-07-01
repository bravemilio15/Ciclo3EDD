package controlador.ordenacion;


import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import modelo.Comparator;


public class MergeSort<E> {

    private final Comparator<E> comparator;

    public MergeSort(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void sort(ListaEnlazada<E> lista, int orden) throws VacioException, PosicionException {
        if (lista.getSize() < 2) {
            return;
        }

        int midIndex = lista.getSize() / 2;

        ListaEnlazada<E> leftList = new ListaEnlazada<>();
        for (int i = 0; i < midIndex; i++) {
            leftList.insertar(lista.get(i));
        }

        ListaEnlazada<E> rightList = new ListaEnlazada<>();
        for (int i = midIndex; i < lista.getSize(); i++) {
            rightList.insertar(lista.get(i));
        }

        sort(leftList, orden);
        sort(rightList, orden);

        merge(leftList, rightList, lista, orden);
    }

    private void merge(ListaEnlazada<E> left, ListaEnlazada<E> right, ListaEnlazada<E> lista, int orden) throws VacioException, PosicionException {
        int leftIndex = 0, rightIndex = 0, listIndex = 0;

        while (leftIndex < left.getSize() && rightIndex < right.getSize()) {
            int comparisonResult;
            switch (orden) {
                case 0: // Ascendente
                    comparisonResult = comparator.compare(left.get(leftIndex), right.get(rightIndex));
                    break;
                case 1: // Descendente
                    comparisonResult = comparator.compare(right.get(rightIndex), left.get(leftIndex));
                    break;
                default:
                    throw new IllegalArgumentException("Orden no válido: " + orden);
            }

            if (comparisonResult <= 0) {
                lista.set(listIndex++, left.get(leftIndex++));
            } else {
                lista.set(listIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.getSize()) {
            lista.set(listIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.getSize()) {
            lista.set(listIndex++, right.get(rightIndex++));
        }
    }
}
