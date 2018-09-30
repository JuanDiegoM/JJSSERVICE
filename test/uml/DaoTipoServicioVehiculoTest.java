
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DaoTipoServicioVehiculoTest {
    
    public DaoTipoServicioVehiculoTest() {
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
     * Test of registrarTiposervicioVehiculo method, of class DaoTipoServicioVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarTiposervicioVehiculo() throws Exception {
        System.out.println("Parametro de costo de servicio creado");
        int idTipoServicio = 12;
        int idTipoVehiculo = 13;
        double valorServicio = 65000;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = true;
        boolean result = instance.registrarTiposervicioVehiculo(idTipoServicio, idTipoVehiculo, valorServicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarTipoServicioVehiculo method, of class DaoTipoServicioVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarTipoServicioVehiculo() throws Exception {
        System.out.println("Parametro costo de servicio editado");
        int idTipoServicioVehiculo = 23;
        int idTipoVehiculo = 1;
        int idTipoServicio = 11;
        double valorServicio = 45000;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = true;
        boolean result = instance.editarTipoServicioVehiculo(idTipoServicioVehiculo, idTipoVehiculo, idTipoServicio, valorServicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipoServicioVehiculo method, of class DaoTipoServicioVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarTipoServicioVehiculo() throws Exception {
        System.out.println("Parametro de costo de servicio eliminado");
        int idTipoServicioVehiculo = 28;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = true;
        boolean result = instance.eliminarTipoServicioVehiculo(idTipoServicioVehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
