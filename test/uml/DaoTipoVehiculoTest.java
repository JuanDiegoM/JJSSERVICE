
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoTipoVehiculoTest {
    Random r = new Random();
    public DaoTipoVehiculoTest() {
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
     * Test of registrarTipoVehiculo method, of class DaoTipoVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarTipoVehiculo() throws Exception {
        System.out.println("Tipo de vehículo registrado");
        String tipoVehiculo = "Volqueta";
        DaoTipoVehiculo instance = new DaoTipoVehiculo();
        boolean expResult = false;
        boolean result = instance.registrarTipoVehiculo(tipoVehiculo);
        if (result == true) {
             expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarTipoVehiculo method, of class DaoTipoVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarTipoVehiculo() throws Exception {
        System.out.println("Tipo de vehículo editado");
        int idTipoVehiculo = 0;
        String tipoVehiculo = "Buseta";
        DaoTipoVehiculo instance = new DaoTipoVehiculo();
        boolean expResult = false;
        idTipoVehiculo = r.randomIdTipoVehiculo();
        boolean result = instance.editarTipoVehiculo(idTipoVehiculo, tipoVehiculo);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipoVehiculo method, of class DaoTipoVehiculo.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarTipoVehiculo() throws Exception {
        System.out.println("No se puede eliminar el tipo de vehiculo");
        int idTipoVehiculo = 0;
        DaoTipoVehiculo instance = new DaoTipoVehiculo();
        boolean expResult = false;
        idTipoVehiculo = r.randomIdTipoVehiculo();
        boolean result = instance.eliminarTipoVehiculo(idTipoVehiculo);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
