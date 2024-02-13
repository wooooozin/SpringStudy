package hello.itemservice.web.basic;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {

  private final ItemRepository itemRepository;

  /**
   * 테스트용 데이터 추가
   */
  @PostConstruct
  public void init() {
    itemRepository.save(new Item("베이글", 10000, 10));
    itemRepository.save(new Item("우유", 3800, 10));
  }

  @GetMapping
  public String items(Model model) {
    List<Item> items = itemRepository.findAll();
    model.addAttribute("items", items);
    return "basic/items";
  }

  @GetMapping("/{itemId}")
  public String item(@PathVariable Long itemId, Model model) {
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item", item);
    return "basic/item";
  }

  @GetMapping("/add")
  public String addForm() {
    return "basic/addForm";
  }

//  @PostMapping("/add")
//  public String save(
//      @RequestParam String itemName,
//      @RequestParam Integer price,
//      @RequestParam Integer quantity,
//      Model model
//  ) {
//    Item item = new Item(itemName, price, quantity);
//    itemRepository.save(item);
//    model.addAttribute("item", item);
//    return "basic/item";
//  }

  @PostMapping("/add")
  public String addV1(
      @ModelAttribute("item") Item item,
      Model model
  ) {

    itemRepository.save(item);
//    model.addAttribute("item", item);
    return "basic/item";
  }

  @GetMapping("{itemId}/edit")
  public String editForm(
    @PathVariable Long itemId, Model model
  ) {
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item", item);
    return "basic/editForm";
  }

  @PostMapping("{itemId}/edit")
  public String editSaveForm(
      @PathVariable Long itemId, @ModelAttribute Item item
  ) {
    itemRepository.update(itemId, item);
    return "redirect:/basic/items/{itemId}";
  }
}
