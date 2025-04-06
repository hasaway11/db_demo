package com.example.db_demo1.supply;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class SupplyController {
  @Autowired
  private SupplyDao supplyDao;

  @GetMapping("/supply/add")
  public ModelAndView save() {
    return new ModelAndView("supply/add");
  }

  @PostMapping("/supply/add")
  public ModelAndView save(@ModelAttribute Supply supply) {
    supplyDao.save(supply);
    return new ModelAndView("redirect:/supply/list");
  }

  @GetMapping("/supply/list")
  public ModelAndView findAll() {
    return new ModelAndView("supply/list").addObject("supplies", supplyDao.findAll());
  }

  @GetMapping("/supply/read")
  public ModelAndView findById(@RequestParam Integer sno) {
    Supply supply = supplyDao.findById(sno);
    return new ModelAndView("supply/read").addObject("supply", supply);
  }

  @PostMapping("/supply/inc")
  public ModelAndView inc(@RequestParam Integer sno) {
    supplyDao.inc(sno);
    return new ModelAndView("redirect:/supply/read?sno="+sno);
  }

  @PostMapping("/supply/dec")
  public ModelAndView dec(@RequestParam Integer sno) {
    int quantity = supplyDao.findById(sno).getQuantity();
    if(quantity>1)
      supplyDao.dec(sno);
    return new ModelAndView("redirect:/supply/read?sno="+sno);
  }

  @PostMapping("/supply/delete")
  public ModelAndView delete(@RequestParam Integer sno) {
    supplyDao.delete(sno);
    return new ModelAndView("redirect:/supply/list");
  }
}
