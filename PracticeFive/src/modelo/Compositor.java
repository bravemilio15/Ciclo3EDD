package modelo;

public class Compositor {

    private Integer id;
    private String nombre;
    private Integer albunes;
    private String genero;
    private Integer id_obra;

    public Compositor() {
    }

    public Compositor(int id, String nombre, String genero, int albunes, int id_obra) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.albunes = albunes;
        this.id_obra = id_obra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAlbunes() {
        return albunes;
    }

    public void setAlbunes(Integer albunes) {
        this.albunes = albunes;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getId_obra() {
        return id_obra;
    }

    public void setId_obra(Integer id_obra) {
        this.id_obra = id_obra;
    }

    public static class CompositorComparator implements Comparator<Compositor> {

        @Override
        public int compare(Compositor a, Compositor b) {
            String nombreA = a.getNombre();
            String nombreB = b.getNombre();

            if (nombreA == null || nombreB == null) {
                if (nombreA == null && nombreB == null) {
                    return 0;
                } else if (nombreA == null) {
                    return -1;
                } else {
                    return 1;
                }
            }

            return nombreA.compareTo(nombreB);
        }
    }

    public static class CompositorComparatorAlbunes implements Comparator<Compositor> {

        @Override
        public int compare(Compositor a, Compositor b) {
            return a.getAlbunes().compareTo(b.getAlbunes());
        }
    }

    public String toString() {
        return "Compositor [nombre=" + nombre + "]";
    }
}
