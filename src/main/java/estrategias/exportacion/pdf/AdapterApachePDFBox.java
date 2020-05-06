package estrategias.exportacion.pdf;

import exportables.Exportable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;

public class AdapterApachePDFBox implements AdapterExportadorAPDF {
    public String exportar(Exportable exportable) {
        String filename = "HelloWorld.pdf";
        return filename;
    }
}



