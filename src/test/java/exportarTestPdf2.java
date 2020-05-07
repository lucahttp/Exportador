import estrategias.exportacion.excel.ExportarAExcel;
import estrategias.exportacion.pdf.AdapterApachePDFBox;
import estrategias.exportacion.pdf.AdapterExportadorAPDF;
import estrategias.exportacion.pdf.ExportarAPDF;
import exportables.Documento;
import exportador.Exportador;
import org.junit.Test;

import java.io.IOException;

public class exportarTestPdf2 {

	@Test
	public void Test() throws IOException {
		System.out.println("Test PDF");
		//JUnitHelloWorld tester = new JUnitHelloWorld();
		//assertTrue("Num 1 is greater than Num 2", tester.isGreater(2, 3));
		Documento testdoc = new Documento();
		testdoc.agregarDato("luca","pollo","gato","papas fritas");
		testdoc.agregarDato("robert","toro","perro","papas fritas con cheddar");
		//System.out.println("getData");
		//System.out.println(testdoc.getData());
		//System.out.println("getDoc");
		//System.out.println(testdoc.getDoc());
		//System.out.println("getKey");
		//System.out.println(testdoc.getKey());

		//Excel
		Exportador aExcel = new Exportador();
		aExcel.setExportable(testdoc);
		aExcel.cambiarEstrategia(new ExportarAExcel());
		aExcel.exportar();


		Exportador aPDF = new Exportador();
		aPDF.setExportable(testdoc);
		aPDF.cambiarEstrategia(new ExportarAPDF(new AdapterApachePDFBox()));
		aPDF.exportar();
		System.out.println("Finalizo!!!");
	}

}
