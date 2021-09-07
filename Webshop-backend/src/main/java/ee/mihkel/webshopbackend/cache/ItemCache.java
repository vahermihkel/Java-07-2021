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
                        public Item load(Long id) {
                            return itemService.getItem(id);
                        }
                    });

    public Item getById(Long id) throws ExecutionException {
        return itemsCache.get(id);
    }

    public void update(Item item) {
        itemsCache.put(item.getId(), item);
    }

    public void delete(Long id) {
        itemsCache.invalidate(id);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(itemsCache.asMap().values());
    }
}
