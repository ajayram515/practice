package com.ajay.practice.controllers.arraysAndHashing;

import com.ajay.practice.service.DuplicatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contains-duplicates")
public class DuplicatesController {
  private final DuplicatesService duplicatesService;

  @Autowired
  public DuplicatesController(DuplicatesService duplicatesService) {
    this.duplicatesService = duplicatesService;
  }

  @PostMapping()
  public Boolean checkDuplicates(@RequestBody List<Integer> list) {
    return duplicatesService.checkDuplicates(list);
  }

}
