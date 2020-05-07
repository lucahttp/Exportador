package estrategias.exportacion.pdf;

import exportables.Exportable;

import java.io.IOException;

public interface AdapterExportadorAPDF {
    public String exportar(Exportable exportable) throws IOException;
}
