package estrategias.exportacion;

import exportables.Exportable;

import java.io.IOException;

public interface EstrategiaDeExportacion {
    public String exportar(Exportable exportable) throws IOException;
}
