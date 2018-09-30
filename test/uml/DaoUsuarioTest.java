
package uml;

import java.util.List;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoUsuarioTest {
    
    public DaoUsuarioTest() {
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
     * Test of autenticacionUsuario method, of class DaoUsuario.
     */
    @Test
    public void testAutenticacionUsuario() {
        System.out.println("Autenticación incorrecta");
        String usuario = "diego";
        String contraseña = "1234";
        DaoUsuario instance = new DaoUsuario();
        Usuario expResult = null;
        Usuario result = instance.autenticacionUsuario(usuario, contraseña);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarUsuario method, of class DaoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarUsuario() throws Exception {
        System.out.println("Usuario registrado");
        String nombre = "julio";
        String contraseña = "123";
        int idTipoUsuario = 22;
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = true;
        boolean result = instance.registrarUsuario(nombre, contraseña, idTipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarUsuario method, of class DaoUsuario.
     */
    @Test
    public void testEliminarUsuario() throws Exception {
        System.out.println("Usuario eliminado");
        int idUsuario = 20;
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = true;
        boolean result = instance.eliminarUsuario(idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarUsuario method, of class DaoUsuario.
     */
    @Test
    public void testEditarUsuario() throws Exception {
        System.out.println("Usuario editado");
        int idUsuario = 22;
        String nombreUsuario = "Johan";
        String contraseña = "123";
        int idTipoUsuario = 1;
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = true;
        boolean result = instance.editarUsuario(idUsuario, nombreUsuario, contraseña, idTipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarUsuarioSinPassw method, of class DaoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarUsuarioSinPassw() throws Exception {
        System.out.println("editarUsuarioSinPassw");
        int idUsuario = 22;
        String nombreUsuario = "Joan";
        int idTipoUsuario = 20;
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = true;
        boolean result = instance.editarUsuarioSinPassw(idUsuario, nombreUsuario, idTipoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
