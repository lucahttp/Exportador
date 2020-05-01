import estrategias.exportacion.excel.ExportarAExcel;
import exportables.Documento;
import exportador.Exportador;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class exportarTest1 {

	@Test
	public void Test() {
		System.out.println("Test");
		//JUnitHelloWorld tester = new JUnitHelloWorld();
		//assertTrue("Num 1 is greater than Num 2", tester.isGreater(2, 3));
		Documento testdoc = new Documento();
		testdoc.agregarDato("luca","pollo","gato","papas fritas");
		testdoc.agregarDato("robert","vaca","perro","papas fritas con cheddar");
		System.out.println("getData");
		System.out.println(testdoc.getData());
		System.out.println("getDoc");
		System.out.println(testdoc.getDoc());
		System.out.println("getKey");
		System.out.println(testdoc.getKey());
		Exportador aExcel = new Exportador();
		aExcel.setExportable(testdoc);
		aExcel.cambiarEstrategia(new ExportarAExcel());
		aExcel.exportar();
	}

}
