package ee.mihkel.webshopbackend.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class ItemCache {

    @Autowired
    ItemService itemService;

    private final LoadingCache<Long, Item> itemsCache =
            CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
                    .removalListener(removalNotification -> System.out.println(removalNotification.getCause()))
                    .build(new CacheLoader<>() {
                        @Override
                        public Item load(Long id) throws ExecutionException {
                            return itemService.getItemFromDatabase(id);
                        }
                    });

    public Item getById(Long id) throws ExecutionException {
        updateCacheIfEmpty(null);
        return itemsCache.get(id);
    }

    public void update(Item item) {
        itemsCache.put(item.getId(), item);
    }

    public void delete(Long id) {
        itemsCache.invalidate(id);
    }

    public List<Item> getAllItems() {
        updateCacheIfEmpty(null);
        return new ArrayList<>(itemsCache.asMap().values());
    }

    public void updateCacheIfEmpty(Item item) {
        if (itemsCache.asMap().values().isEmpty()) {
            itemService.getItemsFromDatabase().forEach(this::update);
            System.out.println("VÕTAN KUNA ON TÜHI");
        }
        if (item != null) {
            System.out.println("LISAN UUT ESET CACHE'i");
            update(item);
        }
    }
}
// int = 0, String = "", char ' ', Item (Objectid) tühi väärtus on null