package com.softuni.web;

import com.softuni.model.binding.ExerceseAddBindingModel;
import com.softuni.model.service.ExerciseServiceModel;
import com.softuni.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("exerceseAddBindingModel")){
            model.addAttribute("exerceseAddBindingModel", new ExerceseAddBindingModel());
        }

        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ExerceseAddBindingModel exerceseAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("exerceseAddBindingModel", exerceseAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exerceseAddBindingModel", bindingResult);
            return "redirect:add";
        }

        exerciseService.addEx(modelMapper.map(exerceseAddBindingModel, ExerciseServiceModel.class));

        return "redirect:/";

    }
}
