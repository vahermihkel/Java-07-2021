package ee.mihkel.webshopbackend.service;

import ee.mihkel.webshopbackend.cache.ItemCache;
import ee.mihkel.webshopbackend.exception.ItemNotFoundException;
import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ItemService {

   // @Value("${is-cache-enabled}")
    boolean isCacheEnabled = true;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemCache itemCache;

    public List<Item> getItems() {
        if (isCacheEnabled) {
            return itemCache.getAllItems();
        } else {
            return getItemsFromDatabase();
        }
    }

    public List<Item> getItemsFromDatabase() {
        System.out.println("VÕTAN ESEMEID ANDMEBAASIST");
        return itemRepository.findAll();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
        System.out.println("SALVESTAN");
        itemCache.updateCacheIfEmpty(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
        itemCache.delete(id);
    }

    public void editItem(Item item) {
        itemRepository.save(item);
        itemCache.updateCacheIfEmpty(item);
    }

    public Item getItemFromDatabase(Long id) {
        System.out.println("VÕTAN ÜKSIKUT ESET ANDMEBAASIST");
        if (itemRepository.findById(id).isEmpty()) {
            throw new ItemNotFoundException("Üksikut toodet vaadates eset ei leitud: " + id);
        } else {
            return itemRepository.findById(id).get();
        }
    }

    public Item getItem(Long id) throws ExecutionException {
        if (isCacheEnabled) {
           return itemCache.getById(id);
        } else {
            return getItemFromDatabase(id);
        }

    }
}
