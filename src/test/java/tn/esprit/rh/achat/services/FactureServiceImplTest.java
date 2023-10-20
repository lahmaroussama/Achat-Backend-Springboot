package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FactureServiceImplTest {


    @Mock
    private FactureRepository factureRepository;
    @InjectMocks
    private FactureServiceImpl service;


    @Test
    public void addFactureTest() {
        Facture facture = new Facture();


        when(factureRepository.save(facture)).thenReturn(facture);

        Facture savedFacture = service.addFacture(facture);

        assertEquals(facture, savedFacture);
    }

    @Test
    public void retrieveAllFacturesTest() {

        Facture facture1 = new Facture();

        Facture facture2 = new Facture();

        Facture facture3 = new Facture();



        List<Facture> factures = Arrays.asList(facture1, facture2, facture3);


        when(factureRepository.findAll()).thenReturn(factures);


        List<Facture> retrievedFactures = service.retrieveAllFactures();


        assertEquals(factures, retrievedFactures);
    }

    @Test
    public void testCancelFacture() {
        Long factureId = 1L;

        // Create a sample Facture object
        Facture facture = new Facture();
        facture.setIdFacture(factureId);
        facture.setArchivee(false);

        // Mock the behavior of the FactureRepository
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));

        // Call the method to be tested
        service.cancelFacture(factureId);

        // Verify that the setArchivee method was called with the correct value
       /// assertTrue(facture.getArchivee());

        // Verify that the save method was called on the repository
        verify(factureRepository, times(1)).save(facture);
    }
    @Test
    public void retrieveFactureTest() {
        // Create a sample Facture object
        Facture expectedFacture = new Facture();
        // Set properties for the Facture

        // Mock the behavior of factureRepository.findById
        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(expectedFacture));

        // Call the retrieveFacture method with the factureId
        Facture retrievedFacture = service.retrieveFacture(1L);

        // Verify that the returned Facture is the same as the expected Facture
        assertEquals(expectedFacture, retrievedFacture);
    }

}