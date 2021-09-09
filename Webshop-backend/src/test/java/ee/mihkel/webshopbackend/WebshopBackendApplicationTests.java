package ee.mihkel.webshopbackend;

import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebshopBackendApplicationTests {

    @Autowired
    ItemService itemService;

    @Test
    public void findProduct() throws ExecutionException {
        long id = 99;
        itemService.addItem(new Item(id,"www.ee", "Ese1", 12.0, "category"));

        Item item = itemService.getItem(id);

        System.out.println(item.getTitle());

        assertEquals("Ese1",item.getTitle());
    }
}
