package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.dao.PointDAO;
import service.models.Point;

import javax.validation.Valid;

@Controller
@RequestMapping("/points")
@ResponseBody
public class PointController {

    private final PointDAO pointDAO;

    @Autowired
    public PointController(PointDAO pointDAO) { this.pointDAO = pointDAO; }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("points", pointDAO.index());
        return "points/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("point", pointDAO.show(id));
        return "points/show";
    }
}
