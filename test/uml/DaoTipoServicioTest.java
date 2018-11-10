/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaoTipoServicioTest {
    Random r = new Random();
    public DaoTipoServicioTest() {
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
     * Test of registrarTiposervicio method, of class DaoTipoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarTiposervicio() throws Exception {
        System.out.println("Registrar Tipo Servicio");
        String tipoServicio = "Alineación";
        DaoTipoServicio instance = new DaoTipoServicio();
        boolean expResult = false;
        boolean result = instance.registrarTiposervicio(tipoServicio);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarTipoServicio method, of class DaoTipoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditarTipoServicio() throws Exception {
        System.out.println("Editar Tipo Servicio");
        int idTipoServicio = 0;
        String tipoServicio = "Cambio de pastas de frenos";
        DaoTipoServicio instance = new DaoTipoServicio();
        boolean expResult = false;
        idTipoServicio = r.randomIdTipoServicio();
        boolean result = instance.editarTipoServicio(idTipoServicio, tipoServicio);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipoServicio method, of class DaoTipoServicio.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarTipoServicio() throws Exception {
        System.out.println("Eliminar tipo de servicio");
        int idTipoServicio = 0;
        DaoTipoServicio instance = new DaoTipoServicio();
        boolean expResult = false;
        idTipoServicio = r.randomIdTipoServicio();
        boolean result = instance.eliminarTipoServicio(idTipoServicio);
        if (result == true) {
            expResult = true;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
