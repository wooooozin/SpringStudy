package hello.itemservice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {
  ItemRepository itemRepository = new ItemRepository();

  @AfterEach
  void afterEach() {
    itemRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Item item = new Item("itemA", 10000, 10);

    // when
    Item savedItem = itemRepository.save(item);

    // then
    Item findItem = itemRepository.findById(item.getId());
    assertThat(findItem).isEqualTo(savedItem);

  }

  @Test
  void findAll() {
    Item item1 = new Item("itemA", 10000, 10);
    Item item2 = new Item("itemB", 10000, 10);

    Item savedItem1 = itemRepository.save(item1);
    Item savedItem2 = itemRepository.save(item2);

    List<Item> result = itemRepository.findAll();

    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(item1, item2);

  }

  @Test
  void update() {
    Item item1 = new Item("itemA", 10000, 10);

    Item savedItem = itemRepository.save(item1);
    Long itemId = savedItem.getId();

    Item updateParam = new Item("itemB", 10000, 10);
    itemRepository.update(itemId, updateParam);

    Item findItem = itemRepository.findById(itemId);
    assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
  }

}