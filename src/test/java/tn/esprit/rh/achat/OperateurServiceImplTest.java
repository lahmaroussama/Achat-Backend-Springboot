package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OperateurServiceImplTest {

    @Autowired
    private OperateurRepository operateurRepository;

    @Autowired
    private OperateurServiceImpl operateurService;
/*
    @Test
    public void testRetrieveOperateur() {
        // Assuming an Operateur with ID 1 exists in the database
        Long id = 2L;

        Operateur operateur = operateurService.retrieveOperateur(id);

        assertNotNull(operateur);
        assertEquals("Fakher", operateur.getNom()); // Adjust the expected values
    }
*/

    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");
        operateur.setPassword("password");

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        assertNotNull(addedOperateur.getIdOperateur());
        assertEquals("John", addedOperateur.getNom());
        assertEquals("Doe", addedOperateur.getPrenom());
        assertEquals("password", addedOperateur.getPassword());
    }
    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L); // Assuming an Operateur with ID 1 exists in the database
        operateur.setNom("Fakher");

        Operateur updatedOperateur = operateurService.updateOperateur(operateur);

        assertEquals("UpdatedName", updatedOperateur.getNom());
    }/*
    @Test
    public void testDeleteOperateur() {
        // Assuming an Operateur with ID 1 exists in the database
        Long id = 1L;

        operateurService.deleteOperateur(id);

        // Verify that the Operateur is deleted (you can use Mockito to verify the delete method was called)
    }*/
    }

    // Write similar test methods for other service operations


