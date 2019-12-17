package com.littlexx.SpringMvcDemo.web;

import com.littlexx.SpringMvcDemo.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }
    
    @RequestMapping()
    public String Spittle(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 3));
        return "spittles";
    }
}
