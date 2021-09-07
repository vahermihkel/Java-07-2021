package ee.mihkel.webshopbackend.service;

import ee.mihkel.webshopbackend.exception.ItemNotFoundException;
import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    // kustutamiseks
    // muutmiseks
    // üksiku vaatamiseks

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void editItem(Item item) {
        itemRepository.save(item);
    }

    // ÜKSIKU VAATAMINE        getItem()
    public Item getItem(Long id) {
        if (itemRepository.findById(id).isEmpty()) {
            throw new ItemNotFoundException("Üksikut toodet vaadates eset ei leitud: " + id);
        } else {
            return itemRepository.findById(id).get();
        }
    }
}
