package exportables;

import exportador.Exportador;

import java.util.*;

public class Documento implements Exportable {
    private Map<String, List<String>> datos;

    public Documento(){
        this.datos = new HashMap<String, List<String>>();
    }

    public Map<String, List<String>> datos() {
        return this.datos;
    }

    // documento.agregarDato("eze", "Escobar");
    // documento.agregarDato("eze", "Viamonte");
    // documento.agregarDato("eze", "otra cosa mas");
    // documento.agregarDato("eze", "Escobar", "Viamonte", "otra cosa");

    public void agregarDato(String clave, String ... valor){
        this.agregarClaveSiNoExiste(clave);
        Collections.addAll(this.datos.get(clave), valor);
        //imprimir test
        System.out.println(this.datos);
    }

    private void agregarClaveSiNoExiste(String clave) {
        if (!this.datos.containsKey(clave)) {
            this.datos.put(clave, new ArrayList<String>());
        }
    }
}