/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.busqueda.BusquedaBinaria;
import controlador.busqueda.BusquedaLinealBinaria;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ordenacion.MergeSort;
import java.io.IOException;
import modelo.Comparator;
import modelo.Compositor;
import modelo.Obra;

/**
 *
 * @author emilio
 */
public class CompositorDAO extends AdaptadorDao<Compositor> implements InterfazDao<Compositor> {

    private Compositor compositor;
    private ObraDAO obraDAO; // Agrega una instancia de ObraDAO

    public CompositorDAO() {
        super(Compositor.class);
        obraDAO = new ObraDAO(); // Inicializa la instancia de ObraDAO
    }

    public Compositor getCompositor() {
        if (compositor == null) {
            this.compositor = new Compositor();
        }
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public void guardar() throws IOException {
        this.guardar(compositor);

    }

    public void modificar(Integer pos) throws IOException, VacioException, PosicionException {
        Compositor objeto = obtener(pos);
        if (objeto != null) {
            objeto.setId(pos); // Asignar el valor de "pos" a la propiedad "id"
            super.modificar(objeto, pos);
        }
    }

    private Integer generarID() {
        return listar().size() + 1;

    }

    //Esta Funcionando BIEN
    public ListaEnlazada<Compositor> BusquedaPorNombre(String nombre, int metodoBusqueda) throws VacioException, PosicionException {
        ListaEnlazada<Compositor> resultados = new ListaEnlazada<>();
        ListaEnlazada<Compositor> lista = listar();

        Comparator<Compositor> nombreComparator = new Comparator<Compositor>() {
            @Override
            public int compare(Compositor a, Compositor b) {
                return a.getNombre().compareToIgnoreCase(b.getNombre());
            }
        };

        switch (metodoBusqueda) {
            case 0:
                // Búsqueda binaria
                BusquedaBinaria<Compositor> busquedaBinaria = new BusquedaBinaria<>(nombreComparator);
                Compositor buscado = new Compositor();
                buscado.setNombre(nombre);
                int index = busquedaBinaria.search(lista, buscado);

                if (index != -1) {
                    resultados.insertar(lista.get(index));
                }
                break;

            case 1:
                // Búsqueda lineal binaria
                BusquedaLinealBinaria<Compositor> busquedaLinealBinaria = new BusquedaLinealBinaria<>(nombreComparator);
                ListaEnlazada<Compositor> keys = new ListaEnlazada<>();
                Compositor compositorKey = new Compositor();
                compositorKey.setNombre(nombre);
                keys.insertar(compositorKey);

                // Realizar la búsqueda lineal binaria
                resultados = busquedaLinealBinaria.search(lista, keys);

                break;

            default:
                throw new IllegalArgumentException("Método de búsqueda no válido.");
        }

        return resultados;
    }

    //Esta Funcionando Bien
    public ListaEnlazada<Compositor> BusquedaPorGenero(String dato, int metodoBusqueda) throws VacioException, PosicionException {
        ListaEnlazada<Compositor> resultados = new ListaEnlazada<>();
        ListaEnlazada<Compositor> lista = listar();

        Comparator<Compositor> generoComparator = new Comparator<Compositor>() {
            @Override
            public int compare(Compositor a, Compositor b) {
                return a.getGenero().compareToIgnoreCase(b.getGenero());
            }
        };

        switch (metodoBusqueda) {
            case 0:
                BusquedaBinaria<Compositor> busquedaBinaria = new BusquedaBinaria<>(generoComparator);
                Compositor buscado = new Compositor();
                buscado.setGenero(dato);
                int index = busquedaBinaria.search(lista, buscado);

                if (index != -1) {
                    resultados.insertar(lista.get(index));
                }
                break;
            case 1:
                BusquedaLinealBinaria<Compositor> busquedaLinealBinaria = new BusquedaLinealBinaria<>(generoComparator);
                ListaEnlazada<Compositor> keys = new ListaEnlazada<>();
                Compositor compositorKey = new Compositor();
                compositorKey.setGenero(dato);
                keys.insertar(compositorKey);
                resultados = busquedaLinealBinaria.search(lista, keys);
                break;
            default:
                throw new IllegalArgumentException("Método de búsqueda no válido.");
        }

        return resultados;
    }

    //Busqueda Lineal NO USAR No necesito para el proyecto
    public ListaEnlazada<Compositor> buscarPorGeneroLista(String genero) throws Exception {
        ListaEnlazada<Compositor> lista = listar(); // Obtener la lista de compositores

        ListaEnlazada<Compositor> resultados = new ListaEnlazada<>();
        for (int i = 0; i < lista.size(); i++) {
            Compositor compositor = lista.get(i);
            if (compositor.getGenero().equalsIgnoreCase(genero)) {
                resultados.insertar(compositor);
            }
        }

        return resultados;
    }

    public ListaEnlazada<Compositor> buscarPorAlbunes(Integer albunes, int metodoBusqueda) throws VacioException, PosicionException {
        // Obtener la lista de compositores
        ListaEnlazada<Compositor> lista = listar();

        switch (metodoBusqueda) {
            case 0:
                // Búsqueda binaria por álbumes
                BusquedaBinaria<Compositor> busquedaBinariaAlbunes = new BusquedaBinaria<>(new Compositor.CompositorComparatorAlbunes());
                Compositor compositorBusquedaAlbunes = new Compositor();
                compositorBusquedaAlbunes.setAlbunes(albunes);
                int posicionAlbunes = busquedaBinariaAlbunes.search(lista, compositorBusquedaAlbunes);

                ListaEnlazada<Compositor> resultadoAlbunesBinario = new ListaEnlazada<>();
                if (posicionAlbunes != -1) {
                    resultadoAlbunesBinario.insertar(lista.get(posicionAlbunes));
                }
                return resultadoAlbunesBinario;

            case 1:
                // Búsqueda lineal binaria por álbumes
                ListaEnlazada<Compositor> resultadoAlbunesLinealBinario = new ListaEnlazada<>();
                for (int i = 0; i < lista.size(); i++) {
                    Compositor compositor = lista.get(i);
                    if (compositor.getAlbunes().equals(albunes)) {
                        resultadoAlbunesLinealBinario.insertar(compositor);
                    }
                }
                return resultadoAlbunesLinealBinario;

            default:
                throw new IllegalArgumentException("Método de búsqueda no válido.");
        }
    }

    //Esta Funcionando BIEN
    public ListaEnlazada<Compositor> buscarPorObra(String nombreObra, int metodoBusqueda) throws VacioException, PosicionException, Exception {
        ListaEnlazada<Compositor> resultado = new ListaEnlazada<>();
        Comparator<Compositor> nombreComparator = new Comparator.NombreComparator();

        if (nombreObra != null) {
            ObraDAO obraDAO = new ObraDAO();
            Obra obra = obraDAO.buscarPorNombre(nombreObra);

            if (obra != null) {
                Integer idObra = obra.getId();
                ListaEnlazada<Compositor> listaCompositores = listar();

                switch (metodoBusqueda) {
                    case 0:
                        // Búsqueda binaria por nombre
                        BusquedaBinaria<Compositor> busquedaBinaria = new BusquedaBinaria<>(nombreComparator);
                        Compositor compositorKey0 = new Compositor();
                        compositorKey0.setNombre(nombreObra);
                        int index0 = busquedaBinaria.search(listaCompositores, compositorKey0);
                        if (index0 != -1) {
                            resultado.insertar(listaCompositores.get(index0));
                        }
                        break;

                    case 1:
                        // Búsqueda lineal binaria por nombre
                        BusquedaLinealBinaria<Compositor> busquedaLinealBinaria = new BusquedaLinealBinaria<>(nombreComparator);
                        ListaEnlazada<Compositor> keys = new ListaEnlazada<>();
                        Compositor compositorKey1 = new Compositor();
                        compositorKey1.setNombre(nombreObra);
                        keys.insertar(compositorKey1);
                        resultado = busquedaLinealBinaria.search(listaCompositores, keys);
                        break;

                    default:
                        throw new IllegalArgumentException("Método de búsqueda no válido.");
                }

                // Establecer la id de la obra en cada compositor de la lista
                for (int i = 0; i < resultado.size(); i++) {
                    Compositor compositor = resultado.get(i);
                    compositor.setId_obra(idObra);
                }

                // Ordenar la lista de compositores por nombre utilizando Merge Sort
                MergeSort<Compositor> mergeSort = new MergeSort<>(nombreComparator);
                mergeSort.sort(resultado);
            }
        }

        return resultado;
    }

    public static void main(String[] args) throws VacioException, PosicionException {
        CompositorDAO cs = new CompositorDAO();
        
        cs.BusquedaPorNombre("Emilio", 1).imprimir();

    }

}
