package estrategias.exportacion.excel;

import estrategias.exportacion.EstrategiaDeExportacion;
import exportables.Exportable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


///
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
///


public class ExportarAExcel implements EstrategiaDeExportacion {

    private String nombreDelArchivo = "HelloWorld.xls";

    public String exportar(Exportable exportable) {


        ////////////////////////////

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
        System.out.println("Printing the super Array from excel");
        //System.out.println(mySuperArrayList);
        /*

        for (List a : mySuperArrayList) {
            for (Object s : a) {
                System.out.println(s);
            }
        }
        */


            ////////////////////////////
            System.out.println("exportable");
            System.out.println(exportable);
            System.out.println("testing");
            //return null;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sample sheet");

            Set<String> keyset = exportable.datos().keySet();



            int rownum = 0;


            System.out.println("-- Iterating HashSet - using iterator --");


            System.out.println("-- the end --");



            for (int i = mySuperArrayList.size() - 1; i >= 0; i--) {

                Row row = sheet.createRow(rownum++);

                int cellnum = 0;

                for (Object s : mySuperArrayList.get(i)) {
                    System.out.println(s);
                    Cell cell = row.createCell(cellnum++);
                    if (s instanceof Date) {
                        cell.setCellValue((Date) s);
                    } else if (s instanceof Boolean) {
                        cell.setCellValue((Boolean) s);
                    } else if (s instanceof String) {
                        cell.setCellValue((String) s);
                    } else if (s instanceof Double) {
                        cell.setCellValue((Double) s);
                    }
                }
            }



/*
        for (String key : keyset) {
                Row row = sheet.createRow(rownum++);

                ArrayList<String> elements = new ArrayList<String>();
                elements.add(key);
                for (Object gg : exportable.datos().get(key).toArray()) {
                    elements.add((String) gg);
                }

                //objArr = (Object[][]) exportable.datos().get(key).toArray();

                Object[] objArr = elements.toArray();

                //objArr = (Object[][]) exportable.datos().get(key).toArray();
                //Object[] objArr = exportable.datos().get(key).toArray();
                int cellnum = 0;


                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    }
                }

            }
 */


            try {
                //FileOutputStream out = new FileOutputStream(new File("D:\\Ashish\\Personal\\WebApplication1\\iccworldcuplistwrite.xls"));
                //this.nombreDelArchivo = "iccworldcuplistwrite.xls";
                //FileOutputStream out = new FileOutputStream(new File("iccworldcuplistwrite.xls"));
                FileOutputStream out = new FileOutputStream(new File(this.nombreDelArchivo));
                workbook.write(out);
                out.close();
                System.out.println("Excel written successfully..");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this.nombreDelArchivo;

        }

        public void setNombreDelArchivo (String nombre){
            this.nombreDelArchivo = nombre;
        }


}
