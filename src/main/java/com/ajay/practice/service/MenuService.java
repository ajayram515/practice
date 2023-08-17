package com.ajay.practice.service;

import com.ajay.practice.model.swigito.Menu;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MenuService {

  private Map<String, Menu> menuRepository = new HashMap<>();

  public Menu addMenu(Menu menu) {
    if (menuRepository.containsKey(menu.getId())) {
      throw new RuntimeException("menu already exist");
    }
    return menuRepository.put(menu.getId(), menu);
  }

  public Menu removeMenu(String menuId) {
    if (!menuRepository.containsKey(menuId)) {
      throw new RuntimeException("menu doesn't exist");
    }
    Menu menu = menuRepository.get(menuId);
    menuRepository.remove(menuId);
    return menu;
  }
}
