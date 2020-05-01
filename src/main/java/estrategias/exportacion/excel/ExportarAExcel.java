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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
///


public class ExportarAExcel implements EstrategiaDeExportacion {

    private String nombreDelArchivo;

    public String exportar(Exportable exportable) {
        System.out.println("exportable");
        System.out.println(exportable);
        System.out.println("testing");
        //return null;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();
        data.put("1", new Object[]{"Year", "WinnerCountryName", "LosserCountryName","By"});
        data.put("2", new Object[]{"1975", "WestInddies", "Australia","17 Run"});
        data.put("3", new Object[]{"1979", "WestInddies", "England","92 Run"});
        data.put("4", new Object[]{"1983", "India", "WestIndies","43 Run"});
        data.put("5", new Object[]{"1987", "Argentina", "England","7 Run"});
        data.put("6", new Object[]{"1992", "Bolivia", "England","22 Run"});
        data.put("7", new Object[]{"1996", "Sri Lanka", "Australia","7 Wicket"});
        data.put("8", new Object[]{"1999", "Australia", "Pakistan","8 Wicket"});
        data.put("9", new Object[]{"2003", "Australia", "India","125 Run"});
        data.put("10", new Object[]{"2007", "Australia", "Srilanka","53 Run"});
        data.put("123123", new Object[]{"2011", "India", "Srilanka","6 Wicket"});
        data.put("12124", new Object[]{"2015", "Australia", "New Zeland","7 Wicket"});
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
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
        try {
            //FileOutputStream out = new FileOutputStream(new File("D:\\Ashish\\Personal\\WebApplication1\\iccworldcuplistwrite.xls"));
            this.nombreDelArchivo = "iccworldcuplistwrite.xls";
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

    public void setNombreDelArchivo(String nombre){
        this.nombreDelArchivo = nombre;
    }
    

}
