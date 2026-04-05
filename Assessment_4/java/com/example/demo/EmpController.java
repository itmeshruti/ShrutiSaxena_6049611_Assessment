package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    // VIEW ALL
    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("list", service.getAll());
        return "view";
    }

    // EDIT PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {  

        Emp emp = service.getById(id);

        EmpDTO dto = new EmpDTO();
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setDeptName(emp.getDeptName());

        model.addAttribute("emp", dto);

        return "edit";
    }

    // UPDATE
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("emp") EmpDTO dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        Emp emp = new Emp();
        emp.setEmpId(dto.getEmpId());
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setDeptName(dto.getDeptName());

        service.save(emp);

        model.addAttribute("msg", "Employee Edited Successfully");
        model.addAttribute("list", service.getAll());

        return "view";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {  

        service.delete(id);

        model.addAttribute("msg", "Employee Deleted Successfully");
        model.addAttribute("list", service.getAll());

        return "view";
    }
}