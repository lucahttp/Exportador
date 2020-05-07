package exportador;

import estrategias.exportacion.EstrategiaDeExportacion;
import exportables.Exportable;

import java.io.IOException;

public class Exportador {
    private EstrategiaDeExportacion estrategia;
    private Exportable exportable;

    public Exportador(EstrategiaDeExportacion estrategia){
        this.estrategia = estrategia;
    }

    public Exportador() {

    }

    public String exportar() throws IOException {
        return this.estrategia.exportar(this.exportable);
    }

    public void cambiarEstrategia(EstrategiaDeExportacion estrategia){
        this.estrategia = estrategia;
    }

    public void setExportable(Exportable exportable) {
        this.exportable = exportable;
    }
}