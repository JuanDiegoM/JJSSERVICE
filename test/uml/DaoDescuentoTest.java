
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class DaoDescuentoTest {
    Random r = new Random();
    public DaoDescuentoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarParametroDescuento method, of class DaoDescuento.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarParametroDescuento() throws Exception {
        System.out.println("Registrar Parametro Descuento");
        String descripcion = "Descuento mas de 3 servicios";
        int porcentajeDescuento = 15;
        DaoDescuento instance = new DaoDescuento();
        boolean expResult = false;
        boolean result = instance.registrarParametroDescuento(descripcion, porcentajeDescuento);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarPorcentajeDescuento method, of class DaoDescuento.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarPorcentajeDescuento() throws Exception {
        System.out.println("Editar Porcentaje Descuento");
        int idParametroDescuento = 0;
        String descripcion = "Porcentaje de descuento editado";
        int porcentajeDescuento = 20;
        DaoDescuento instance = new DaoDescuento();
        boolean expResult = false;
        idParametroDescuento = r.randomIdDescuento();
        boolean result = instance.editarPorcentajeDescuento(idParametroDescuento, descripcion, porcentajeDescuento);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarParametroDescuento method, of class DaoDescuento.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarParametroDescuento() throws Exception {
        System.out.println("Eliminar Parametro Descuento");
        int idParametroDescuento = 0;
        DaoDescuento instance = new DaoDescuento();
        boolean expResult = false;
        idParametroDescuento = r.randomIdDescuento();
        boolean result = instance.eliminarParametroDescuento(idParametroDescuento);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
