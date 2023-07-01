package modelo;

public interface Comparator<E> {

    int compare(E a, E b);

    public class NombreComparator implements Comparator<Compositor> {

        @Override
        public int compare(Compositor a, Compositor b) {
            String nombreA = a.getNombre();
            String nombreB = b.getNombre();

            if (nombreA == null && nombreB == null) {
                return 0;
            } else if (nombreA == null) {
                return -1;
            } else if (nombreB == null) {
                return 1;
            } else {
                return nombreA.compareTo(nombreB);
            }
        }
    }

}

