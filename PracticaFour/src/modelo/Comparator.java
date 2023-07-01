package modelo;

public interface Comparator<E> {

    int compare(E a, E b);

    public class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

}
