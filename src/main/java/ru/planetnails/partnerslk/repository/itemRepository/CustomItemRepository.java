package ru.planetnails.partnerslk.repository.itemRepository;

import org.springframework.data.domain.PageRequest;
import ru.planetnails.partnerslk.model.item.Item;
import ru.planetnails.partnerslk.model.item.ItemQueryParams;

import java.util.List;

public interface CustomItemRepository {

    List<Item> getFilteredGroups(Integer level, String parentId);

    List<Item> getFilteredItems(String groupId, Integer from, Integer size);

    List<Item> getItemByParams(ItemQueryParams params);

}
