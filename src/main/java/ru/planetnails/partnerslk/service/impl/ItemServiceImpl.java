package ru.planetnails.partnerslk.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.planetnails.partnerslk.model.item.Item;
import ru.planetnails.partnerslk.model.item.dto.ItemAddDto;
import ru.planetnails.partnerslk.model.item.dto.ItemDtoOut;
import ru.planetnails.partnerslk.model.item.dto.ItemDtoOutGroups;
import ru.planetnails.partnerslk.model.item.dto.ItemMapper;
import ru.planetnails.partnerslk.repository.itemRepository.ItemRepository;
import ru.planetnails.partnerslk.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Override
    public ItemAddDto add(ItemAddDto itemAddDto) {
        log.info("Add item {}", itemAddDto);

        Item item = ItemMapper.fromItemAddDtoToItem(itemAddDto);

        try {
            itemRepository.save(item);

        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return ItemMapper.toItemAddDto(item);
    }

    @Override
    @Transactional
    @Async
    public void add(List<ItemAddDto> itemsAddDto) {
        log.info("Add items as List ");
        List<Item> items = itemsAddDto.stream().map(x -> ItemMapper.fromItemAddDtoToItem(x)).collect(Collectors.toList());
        try {
            itemRepository.saveAll(items);

        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }

    @Override
    public List<ItemDtoOut> getFilteredItems(String groupId, Integer from, Integer size) {
        List<Item> items = itemRepository.getFilteredItems(groupId, from, size);
        return items.stream().map(ItemMapper::toItemDtoOut).collect(Collectors.toList());

    }

    @Override
    public List<ItemDtoOutGroups> getFilteredGroups(Integer level, String parentId) {
        List<Item> items = itemRepository.getFilteredGroups(level, parentId);
        return items.stream().map(ItemMapper::toItemDtoOutShort).collect(Collectors.toList());
    }


}
