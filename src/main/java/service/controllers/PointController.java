package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.dao.PointDAO;
import service.models.Point;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/points")
@ResponseBody
public class PointController {

    private final PointDAO pointDAO;

    @Autowired
    public PointController(PointDAO pointDAO) { this.pointDAO = pointDAO; }

//    @GetMapping()
//    public Point index(Model model) {
//        model.addAttribute("points", pointDAO.index());
//        return pointDAO.index().get(2);
//    }
    @GetMapping()
    public ResponseEntity<List<Point>> read() {
        final List<Point> points = pointDAO.index();

        return points != null && !points.isEmpty()
                ? new ResponseEntity<>(points, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/1")
    public ResponseEntity<Point> getPoint() {

                return ResponseEntity.ok().body(pointDAO.show(1));
    }

    @GetMapping("/{id}")
    public Point show(@PathVariable("id") int id, Model model) {
        model.addAttribute("point", pointDAO.show(id));
        return pointDAO.show(id);
    }
}
