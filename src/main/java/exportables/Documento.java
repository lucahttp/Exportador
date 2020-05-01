package exportables;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<String> getDoc() {
        //https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java
        //this.datos.put(clave, new ArrayList<String>());
        //List<String> values = new List<(this.datos.values())>;
        //return this.datos.values()[1];
        //return  this.datos.get(datos.keySet().toArray()[0]);

        return datos.keySet().stream()
                .map((key) -> key + ": " + datos.get(key))
                .collect(Collectors.toList());
        //return datos.get();
    }
    public Object getKey() {
        //https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java
        //this.datos.put(clave, new ArrayList<String>());
        //List<String> values = new List<(this.datos.values())>;
        //return this.datos.values()[1];
        //return  this.datos.get(datos.keySet().toArray()[0]);

        //return datos.get(datos.keySet().toArray()[0]);
        return  this.datos.keySet().stream().findFirst().get();
        //return datos.get();
    }

    public List<String> getData() {
        //https://stackoverflow.com/questions/12960265/retrieve-all-values-from-hashmap-keys-in-an-arraylist-java
        //this.datos.put(clave, new ArrayList<String>());
        //List<String> values = new List<(this.datos.values())>;
        //return this.datos.values()[1];
        return this.datos.get(datos.keySet().toArray()[0]);
        /*
        return datos.keySet().stream()
                .map((key) -> key + ": " + datos.get(key))
                .collect(Collectors.toList());*/
        //return datos.get();
    }
}