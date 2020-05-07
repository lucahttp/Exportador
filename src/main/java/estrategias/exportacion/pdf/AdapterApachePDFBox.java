package estrategias.exportacion.pdf;

import exportables.Exportable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class AdapterApachePDFBox implements AdapterExportadorAPDF {

    private String nombreDelArchivo = "HelloWorld.pdf";

    public String exportar(Exportable exportable) throws IOException {
        String filename = "HelloWorld.pdf";


        Map<String, List<String>> hmapx = exportable.datos();


        List<String> myArrayList = new ArrayList<>();

        List<List> mySuperArrayList = new ArrayList<>();


        for (Map.Entry me : hmapx.entrySet()) {

            ArrayList<String> alist = new ArrayList<String>();

            String firstValue = (String) me.getKey();

            alist.add(firstValue);


            ArrayList contentOf = (ArrayList) me.getValue();



            for (int i = 0; i < contentOf.size(); i++) {
                alist.add((String) contentOf.get(i));
            }
            //System.out.println("Printing ArrayList");
            //System.out.println(alist);



            //System.out.println("Printing only Array");
            String[] strArray = alist.stream().toArray(String[]::new);
            //System.out.println(Arrays.toString(strArray));

            mySuperArrayList.add(Arrays.asList(strArray));


        }
        //System.out.println("Printing the super Array");
        /*
        System.out.println(mySuperArrayList);

        for (List a : mySuperArrayList) {
            for (Object s : a) {
                System.out.println(s);
            }
        }
        */
        for (int i = mySuperArrayList.size() - 1; i >= 0; i--) {
            for (Object s : mySuperArrayList.get(i)) {
                System.out.println(s);
            }
        }



        //////////////////////////////

        PDDocument doc = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

/*
        String[][] content =   {{"a","b", "1"},
                {"c","d", "2"},
                {"e","f", "3"},
                {"g","h", "4"},
                {"i","j", "5"}} ;
                */


        drawTable(page, contentStream, 700, 100, mySuperArrayList);
        contentStream.close();
        doc.save(this.nombreDelArchivo);
        System.out.println("Ohhhhhhhhhh Si");

        //////////////////////////////
        return this.nombreDelArchivo;
    }




    public static void drawTable(PDPage page, PDPageContentStream contentStream,
                                 float y, float margin,
                                 List<List> content) throws IOException {

        final int rows = content.size();
        final int cols = content.get(0).size();
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - margin - margin;
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        float textx = margin + cellMargin;
        float texty = y - 15;
        /*
        for (int i = mySuperArrayList.size() - 1; i >= 0; i--) {
            for (Object s : mySuperArrayList.get(i)) {
                System.out.println(s);
            }
        }
        */


        for (int i = content.size() - 1; i >= 0; i--) {
            for (int j = 0; j < content.get(i).size(); j++) {
                String text = (String) content.get(i).get(j);
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
        /*
        //OLD
        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).size(); j++) {
                String text = (String) content.get(i).get(j);
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
        */
    }
    public void setNombreDelArchivo(String nombre){
        this.nombreDelArchivo = nombre;
    }

}



