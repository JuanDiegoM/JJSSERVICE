
package uml;

import java.sql.SQLException;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoServicioTest {
    Random r = new Random();
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
    public void testRegistrarServicioConDescuento() throws Exception {
        System.out.println("Registrar nuevo servicio con descuento");        
        String cedulaCliente = "768906576";
        String placaVehiculo = "kjl098";
        double subtotal = 445000;
        int porcentajeDescuento = 20;
        double valorDescuento = 89000;
        double valorTotalServicio = 356000;
        int[] idTipoServicio;
        idTipoServicio = new int[4];
        for (int i = 0; i < idTipoServicio.length; i++) {
            idTipoServicio[i] = r.randomIdTipoServicio();
        }
        double[] valorServicio = {50000, 75000, 14000, 180000};
        int idTipoVehiculo = r.randomIdTipoVehiculo();
        DaoServicio instance = new DaoServicio();
        boolean expResult = false;
        boolean result = instance.registrarServicio(cedulaCliente, placaVehiculo, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, idTipoServicio, valorServicio, idTipoVehiculo);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRegistrarServicio() throws SQLException, ParseException{
        System.out.println("Registrar servicio sin descuento");
        String cedulaCliente = "7898989";
        String placaVehiculo = "tpt186";
        double subtotal = 50000;
        int porcentajeDescuento = 0;
        double valorDescuento = 0;
        double valorTotalServicio = 50000;
        int[] idTipoServicio;
        idTipoServicio = new int[1];
        for (int i = 0; i < idTipoServicio.length; i++) {
            idTipoServicio[i] = r.randomIdTipoServicio();
        }
        double[] valorServicio = {50000};
        int idTipoVehiculo = r.randomIdTipoVehiculo();
        DaoServicio instance = new DaoServicio();
        boolean expResult = false;
        boolean result = instance.registrarServicio(cedulaCliente, placaVehiculo, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, idTipoServicio, valorServicio, idTipoVehiculo);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of finalizarServicio method, of class DaoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testFinalizarServicio() throws Exception {
        System.out.println("finalizar Servicio");
        int idServicio = 0;
        DaoServicio instance = new DaoServicio();
        boolean expResult = false;
        idServicio = r.randomIdServicio();
        boolean result = instance.finalizarServicio(idServicio);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarServicio method, of class DaoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarServicio() throws Exception {
        System.out.println("Eliminar Servicio");
        int idServicio = 0;
        DaoServicio instance = new DaoServicio();
        boolean expResult = false;
        idServicio = r.randomIdServicio();
        boolean result = instance.eliminarServicio(idServicio);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
