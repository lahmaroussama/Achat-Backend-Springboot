package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitTest {

    @Mock
    ProduitRepository mockproduitRepository;

    @InjectMocks
    ProduitServiceImpl mockproduitService;

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();

       produit.setLibelleProduit("Fanta");
       produit.setPrix(1);
       when(mockproduitRepository.save(produit)).thenReturn(produit);
       assertNotNull(mockproduitService.addProduit(produit));

    }
    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit();

        produit.setLibelleProduit("maadch Fanta");
        produit.setPrix(2);
        when(mockproduitRepository.save(produit)).thenReturn(produit);
        Produit updatedproduct = mockproduitService.updateProduit(produit);
        assertNotNull(updatedproduct);
        assertEquals("maadch Fanta",updatedproduct.getLibelleProduit());
        assertEquals(2, updatedproduct.getPrix());

    }

    @Test
    public void testReadProduct() {
        Long id =1L;
        Produit product= mockproduitService.retrieveProduit(id);

        assertNotNull(product);
        assertEquals("Fanta", product.getLibelleProduit()); // Adjust the expected values

    }

    @Test
    public void testDeleteProduct() {

        mockproduitService.deleteProduit(1L);
    }


}
