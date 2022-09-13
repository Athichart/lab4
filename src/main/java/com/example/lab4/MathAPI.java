package com.example.lab4;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public Double myPlus(@PathVariable("n1") double num1,
                       @PathVariable("n2") double num2){
        return num1 + num2;
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public Double myMinus(@PathVariable("n1") double num1,
                       @PathVariable("n2") double num2){
        return num1 - num2;
    }
    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public Double myDivide(@PathVariable("n1") double num1,
                       @PathVariable("n2") double num2){
        return num1 / num2;
    }
    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public Double myMulti(@PathVariable("n1") double num1,
                       @PathVariable("n2") double num2){
        return num1 * num2;
    }
    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public Double myMod(@PathVariable("n1") double num1,
                       @PathVariable("n2") double num2){
        return num1 % num2;
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestParam("num1") double num1,
                       @RequestParam("num2") double num2){
        if(num1 <= num2){
            return num2 + "";
        }
        else {
            return num1+"";
        }
    }

}
