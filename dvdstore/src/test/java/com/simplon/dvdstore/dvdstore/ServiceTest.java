package com.simplon.dvdstore.dvdstore;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoIdMovies;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceMovies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Test que pour les tests unitaires donc ne prend pas de risque
// @RunWith : ce qui permet de lancer le processus de test dans mon serveur
@RunWith(SpringRunner.class)
// @SpringBootTest : configuration du test, on spécifie la librairie de test et la classe contenant le main
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DvdStoreApplication.class)
// @AutoConfigureMockMvc : c'est un bean on mapp
@AutoConfigureMockMvc
// @TestPropertySource : application properties. Le mieux c'est d'avoir une autre application properties pour les tests dans les ressources
@TestPropertySource(
        locations = "classpath:application.properties")
public class ServiceTest {
    // @Autowired : C'est ce qu'on souhaite tester, il existe une alternative avec Mockito qui peut simuler un objet ou une classe qui seront supprimés après le test
    @Autowired
    private DvdStoreServiceMovies dvdStoreService;

    /*private DvdStoreRepositoryModelMovies createDvdStoreR(Long id) {
        return id;
    }/**/

    // private dvd service etc... on crée dvdservice avec lequel on fait le test
    private DvdStoreRepositoryModelMovies createDvdStoreRepositoryModelMovies(String genre, String name, Long quantity, float price, String imgPath, String synopsis) {
        DvdStoreRepositoryModelMovies dvd = new DvdStoreRepositoryModelMovies();
        dvd.setGenre(genre);
        dvd.setName(name);
        dvd.setQuantity(quantity);
        dvd.setPrice(price);
        dvd.setImgPath(imgPath);
        dvd.setSynopsis(synopsis);
        return dvd;
    }

    // @Test : le premier test unitaire
    @Test
    public void save_dvd_returns_true() throws Exception {// Nom de la fonction est fait d'après la valeur de retour attendue en fonction des paramètres de la fonction
        DvdStoreRepositoryModelMovies dvd = createDvdStoreRepositoryModelMovies("matrix", "sci-fi", 1L, 50.2F, "0dvd.jpg", "resumer film test");

        assertEquals(dvdStoreService.save(dvd), dvd );
    }

   @Test
    public void save_dvd_returns_false_if_property_name_is_null() throws Exception {
        DvdStoreRepositoryModelMovies dvd = createDvdStoreRepositoryModelMovies(null, null, null, 50.2F, null, null);
        assertNotNull(dvdStoreService.save(dvd));
    }

   /*@Test
    public void find_dvd_by_id_returns_valid_dvd() {
        DvdStoreRepositoryModelMovies dvdId = createDvdStoreR(2L);
        assertEquals(dvdStoreService.findById(dvdId.getId()), dvdId );

    }/**/

    @Test
    public void find_all_returns_list_of_dtos() {
        List<DvdStoreDtoIdMovies> result = dvdStoreService.findAll();
        // on regarde si la liste n'est pas null et si elle n'est pas vide.
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void delete_dvd_returns_false_if_property_id_is_null() throws Exception {
       assertTrue(dvdStoreService.delete(0L));
    }


}