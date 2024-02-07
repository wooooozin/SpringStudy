package hello.itemservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

  private Long id;
  private String itemName;
  private Integer price;
  private Integer quantity;

  public Item() { }

  public Item(Long id, String itemName, Integer price, Integer quantity) {
    this.id = id;
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }
}
