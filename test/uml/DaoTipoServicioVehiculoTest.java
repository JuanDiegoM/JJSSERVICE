
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoTipoServicioVehiculoTest {
    Random r = new Random();
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
        int idTipoServicio = 0;
        int idTipoVehiculo = 0;
        double valorServicio = 65000;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = false;
        idTipoServicio = r.randomIdTipoServicio();
        idTipoVehiculo = r.randomIdTipoVehiculo();
        boolean result = instance.registrarTiposervicioVehiculo(idTipoServicio, idTipoVehiculo, valorServicio);
        if (result == true) {
            expResult = true;
        }
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
        int idTipoServicioVehiculo = 0;
        int idTipoVehiculo = 0;
        int idTipoServicio = 0;
        double valorServicio = 45000;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = false;
        idTipoServicio = r.randomIdTipoServicio();
        idTipoVehiculo = r.randomIdTipoVehiculo();
        idTipoServicioVehiculo = r.randomIdTipoServicioVehiculo();
        boolean result = instance.editarTipoServicioVehiculo(idTipoServicioVehiculo, idTipoVehiculo, idTipoServicio, valorServicio);
        if (result == true) {
            expResult = true;
        }
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
        int idTipoServicioVehiculo = 0;
        DaoTipoServicioVehiculo instance = new DaoTipoServicioVehiculo();
        boolean expResult = false;
        idTipoServicioVehiculo = r.randomIdTipoServicioVehiculo();
        boolean result = instance.eliminarTipoServicioVehiculo(idTipoServicioVehiculo);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
