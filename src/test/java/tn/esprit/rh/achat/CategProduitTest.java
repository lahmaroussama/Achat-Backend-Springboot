package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategProduitTest {
    @Mock
    CategorieProduitRepository categproduitRepository;

    @InjectMocks
    CategorieProduitServiceImpl mockcategproduitService;

    @Test
    public void testAddProduitcateg() {
        CategorieProduit categorie = new CategorieProduit();

        categorie.setLibelleCategorie("boisson");
        categorie.setCodeCategorie("codeB");

        when(categproduitRepository.save(categorie)).thenReturn(categorie);
        assertNotNull(mockcategproduitService.addCategorieProduit(categorie));


    }

    @Test
    public void testUpdateCategProduit() {
        CategorieProduit categ = new CategorieProduit();

        categ.setLibelleCategorie("machroubet");
        categ.getCodeCategorie("codeM");
        when(categproduitRepository.save(categ)).thenReturn(categ);
        CategorieProduit updatedCategory = mockcategproduitService.updateCategorieProduit(categ);
        assertNotNull(updatedCategory);
        assertEquals("machroubet",updatedCategory.getLibelleCategorie());
        assertEquals("codeM", updatedCategory.getCodeCategorie());

    }

    @Test
    public void testReadCategProduct() {

        CategorieProduit categ= mockcategproduitService.retrieveCategorieProduit(1L);

        assertNotNull(categ);
        assertEquals("boisson", categ.getLibelleCategorie()); // Adjust the expected values

    }

    @Test
    public void testDeleteCategProduct() {

        mockcategproduitService.deleteCategorieProduit(1L);

    }





}
