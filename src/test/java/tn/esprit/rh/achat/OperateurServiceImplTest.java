package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceImplTest {
@Autowired
    OperateurServiceImpl operateurService;
    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("Doghri");
        operateur.setPrenom("Fakher");
        operateur.setPassword("password");

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        assertNotNull(addedOperateur.getIdOperateur());
        assertEquals("Doghri", addedOperateur.getNom());
        assertEquals("Fakher", addedOperateur.getPrenom());
        assertEquals("password", addedOperateur.getPassword());
    }
    @Test
    public void testDeleteOperateur() {
        // Assuming an Operateur with ID 1 exists in the database
        Long id = 1L;

        operateurService.deleteOperateur(id);

        // Verify that the Operateur is deleted (you can use Mockito to verify the delete method was called)
    }

    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L); // Assuming an Operateur with ID 1 exists in the database
        operateur.setNom("m3allem");
        operateur.setPrenom("oussama");

        Operateur updatedOperateur = operateurService.updateOperateur(operateur);

        assertEquals("m3allem", updatedOperateur.getNom());
    }
    @Test
    public void testRetrieveOperateur() {
        // Assuming an Operateur with ID 1 exists in the database
        Long id = 1L;

        Operateur operateur = operateurService.retrieveOperateur(id);

        assertNotNull(operateur);
        assertEquals("Doghri", operateur.getNom()); // Adjust the expected values
    }

}
