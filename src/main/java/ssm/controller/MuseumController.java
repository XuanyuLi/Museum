package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ssm.model.Museum;
import ssm.service.MuseumService;

@Controller
@RequestMapping("museum")
public class MuseumController extends BaseController {

    private final MuseumService museumService;

    @Autowired
    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }

    @RequestMapping("create")
    private String create(Museum museum) {
        museumService.create(museum);
        return "redirect:/museum/queryAll";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        museumService.remove(id);
        return "redirect:/museum/queryAll";
    }

    @RequestMapping("modify")
    private String modify(Museum museum) {
        museumService.modify(museum);
        return "redirect:/museum/queryAll";
    }

    @RequestMapping("queryAll/{page}")
    private String queryAll(@PathVariable int page) {
        session.setAttribute("pagination", museumService.queryAll(page));
        return "redirect:/museum/list.jsp";
    }

    @RequestMapping("queryAll")
    private String queryAll() {
        return queryAll(1);
    }

    @RequestMapping("queryById/{id}")
    private String queryById(@PathVariable("id") Integer id) {
        session.setAttribute("museum", museumService.queryById(id));
        return "redirect:/museum/edit.jsp";
    }

    @RequestMapping("queryMuseums/{currentPage")
    private String queryMuseums(@PathVariable int currentPage) {
        session.setAttribute("museum",museumService.query("queryMuseums",null, currentPage));
        return "redirect:/museum/museums.jsp";
    }

    @RequestMapping("queryMuseums")
    private String qqueryMuseums() {
        return queryMuseums(1);
    }
}