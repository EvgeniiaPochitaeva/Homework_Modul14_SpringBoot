package Homework_Homework_Modul14_SpringBoot.testapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestControler {
        @RequestMapping(value = "/test", method = {RequestMethod.GET})
        public ModelAndView getTest() {
            ModelAndView result = new ModelAndView("test");
            return result;
        }

}
