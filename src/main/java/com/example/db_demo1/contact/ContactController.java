package com.example.db_demo1.contact;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class ContactController {
  @Autowired
  private ContactDao contactDao;

  @GetMapping("/contact/add")
  public ModelAndView save() {
    return new ModelAndView("contact/add");
  }

  @PostMapping("/contact/add")
  public ModelAndView save(@ModelAttribute Contact contact) {
    System.out.println(contact);
    contactDao.save(contact);
    return new ModelAndView("redirect:/contact/list");
  }

  @GetMapping("/contact/list")
  public ModelAndView findAll() {
    return new ModelAndView("contact/list").addObject("contacts", contactDao.findAll());
  }

  @GetMapping("/contact/read")
  public ModelAndView findById(@RequestParam Integer cno) {
    Contact contact = contactDao.findById(cno);
    return new ModelAndView("contact/read").addObject("contact", contact);
  }

  @PostMapping("/contact/update")
  public ModelAndView update(@ModelAttribute Contact contact) {
    contactDao.update(contact);
    return new ModelAndView("redirect:/contact/read?cno=" + contact.getCno());
  }

  @PostMapping("/contact/delete")
  public ModelAndView delete(@RequestParam Integer cno) {
    contactDao.delete(cno);
    return new ModelAndView("redirect:/contact/list");
  }
}
