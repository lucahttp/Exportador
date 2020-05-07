package estrategias.exportacion.pdf;

import estrategias.exportacion.EstrategiaDeExportacion;
import exportables.Exportable;

import java.io.IOException;

public class ExportarAPDF implements EstrategiaDeExportacion {
    private AdapterExportadorAPDF adapter;

    public ExportarAPDF(AdapterExportadorAPDF adapter){
        this.adapter = adapter;
    }

    public ExportarAPDF() {

    }

    public String exportar(Exportable exportable) throws IOException {
        return this.adapter.exportar(exportable);
    }
}
