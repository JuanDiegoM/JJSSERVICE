
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoTipoUsuarioTest {
    
    public DaoTipoUsuarioTest() {
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
     * Test of registrarTipoUsuario method, of class DaoTipoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarTipoUsuario() throws Exception {
        System.out.println("Tipo Usuario Regsitrado");
        String tipoUsuario = "Observador";
        DaoTipoUsuario instance = new DaoTipoUsuario();
        boolean expResult = true;
        boolean result = instance.registrarTipoUsuario(tipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipoUsuario method, of class DaoTipoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarTipoUsuario() throws Exception {
        System.out.println("No se puede eliminar el tipo de usuario");
        int idTipoUsuario = 1;
        DaoTipoUsuario instance = new DaoTipoUsuario();
        boolean expResult = false;
        boolean result = instance.eliminarTipoUsuario(idTipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarTipoUsuario method, of class DaoTipoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarTipoUsuario() throws Exception {
        System.out.println("editarTipoUsuario");
        int idTipoUsuario = 20;
        String tipoUsuario = "Colaborador";
        DaoTipoUsuario instance = new DaoTipoUsuario();
        boolean expResult = true;
        boolean result = instance.editarTipoUsuario(idTipoUsuario, tipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
