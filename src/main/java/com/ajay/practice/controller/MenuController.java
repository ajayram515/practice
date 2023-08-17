package com.ajay.practice.controller;

import com.ajay.practice.model.Brand;
import com.ajay.practice.model.Menu;
import com.ajay.practice.service.MenuService;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {

  private final MenuService menuService;

  @PostMapping("/menu/add")
  public Menu addMenu(@RequestBody Menu menu) {
    return menuService.addMenu(menu);
  }

  @GetMapping("/menu/remove")
  public Menu removeMenu(@RequestParam(value = "id") String menuId) {
    return menuService.removeMenu(menuId);
  }
}
