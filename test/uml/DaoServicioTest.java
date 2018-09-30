
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoServicioTest {
    
    public DaoServicioTest() {
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
     * Test of registrarServicio method, of class DaoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarServicio() throws Exception {
        System.out.println("Servicio registrado");
        System.out.println("Detalle servicio registrado");
        String cedulaCliente = "76890";
        String placaVehiculo = "kjl098";
        double subtotal = 445000;
        int porcentajeDescuento = 20;
        double valorDescuento = 89000;
        double valorTotalServicio = 356000;
        int[] idTipoServicio = {12,13,14,15};
        double[] valorServicio = {50000, 75000, 14000, 180000};
        int idTipoVehiculo = 12;
        DaoServicio instance = new DaoServicio();
        boolean expResult = true;
        boolean result = instance.registrarServicio(cedulaCliente, placaVehiculo, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, idTipoServicio, valorServicio, idTipoVehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
