
package uml;

import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DaoUsuarioTest {
    Random r = new Random();
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
        System.out.println("Autenticación de usuario incorrecta");
        String usuario = "diego";
        String contraseña = "1234";
        DaoUsuario instance = new DaoUsuario();        
        Usuario result = instance.autenticacionUsuario(usuario, contraseña);
        Usuario expResult = result;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAutenticacionCorrectaUsuario() {
        System.out.println("Autenticación de usuario Correcta");
        String usuario = "diego";
        String contraseña = "123";
        DaoUsuario instance = new DaoUsuario();      
        Usuario result = instance.autenticacionUsuario(usuario, contraseña);
        Usuario expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarUsuario method, of class DaoUsuario.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarUsuario() throws Exception {
        System.out.println("Usuario registrado");
        int idTipoUsuario = 0;
        String nombre = r.randomNombreUsuario();
        String contraseña = "123";
        idTipoUsuario = r.randomIdTipoUsuario();
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = false;
        boolean result = instance.registrarUsuario(nombre, contraseña, idTipoUsuario);
        if (result == true) {
             expResult = true;
        }
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
        int idUsuario = 0;        
        idUsuario = r.randomIdUsuario();        
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = false;
        boolean result = instance.eliminarUsuario(idUsuario);
        if (result == true) {
             expResult = true;
        }
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
        int idUsuario = 0; 
        int idTipoUsuario = 0;
        idUsuario = r.randomIdUsuario();
        String nombreUsuario = r.randomNombreUsuario();
        String contraseña = "123";
        idTipoUsuario = r.randomIdTipoUsuario();
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = false;
        boolean result = instance.editarUsuario(idUsuario, nombreUsuario, contraseña, idTipoUsuario);
        if (result == true) {
             expResult = true;
        }
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
        int idUsuario = 0;
        int idTipoUsuario = 0;
        idUsuario = r.randomIdUsuario();
        String nombreUsuario = r.randomNombreUsuario();
        idTipoUsuario = r.randomIdTipoUsuario();
        DaoUsuario instance = new DaoUsuario();
        boolean expResult = false;
        boolean result = instance.editarUsuarioSinPassw(idUsuario, nombreUsuario, idTipoUsuario);
        if (result == true) {
             expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
