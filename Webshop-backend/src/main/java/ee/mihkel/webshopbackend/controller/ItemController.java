package ee.mihkel.webshopbackend.controller;

import ee.mihkel.webshopbackend.exception.ItemNotFoundException;
import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Items API endpoints")
public class ItemController {

    // cache
    // jwt json web token autent
    // erinevad mediatypesid
    // custom annotation

    @Autowired
    ItemService itemService;

    @ApiOperation(value = "Get all items from webshop")
    @GetMapping("items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @ApiOperation(value = "Add new item")
    @PostMapping("add-item")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @ApiOperation(value = "Delete item")
    @DeleteMapping("delete-item/{id}")
    public void deleteItem(@PathVariable Long id) throws ItemNotFoundException {
        try {
            this.itemService.deleteItem(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNotFoundException("Kustutades eset ei leitud: " + id);
        }
    }

    @ApiOperation(value = "Edit item")
    @PostMapping("edit-item")
    public void editItem(@RequestBody Item item) {
        itemService.editItem(item);
    }

    @ApiOperation(value = "View one item")
    @GetMapping(value = "view-item/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }
}
