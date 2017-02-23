package com.duongvantien.controller;

import com.duongvantien.model.Employee;
import com.duongvantien.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tienduongvan on 22/02/2017.
 *
 */
@Controller
public class EmployeeController {

    @Autowired(required=true)
    EmployeeService employeeService;

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("form")
    public ModelAndView getForm(@ModelAttribute Employee employee){
        return new ModelAndView("form");
    }

    @RequestMapping("register")
    public ModelAndView registerEmployee(@ModelAttribute Employee employee) {
        System.out.println("AAAAA - add : "+employeeService.addEmployee(employee));
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "list")
    public ModelAndView getList(Model model) {
        System.out.println("---- get list");
        List<Employee> employeeList = employeeService.getListEmployee();
        System.out.println(" size list : "+employeeService.getListEmployee());
        return new ModelAndView("list", "employeeList", employeeList);

//        model.addAttribute("employeeList", this.employeeService.getListEmployee());
//        return "list";
    }

    @RequestMapping("delete")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("edit")
    public ModelAndView editEmployee(@RequestParam int id) {
        Employee employeeObject = employeeService.getEmployeeById(id);
        return new ModelAndView("edit", "employeeObject", employeeObject);
    }

    @RequestMapping("update")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:list");
    }

}
