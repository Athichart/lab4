package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{num}", method = RequestMethod.GET)
        public Change getChange(@PathVariable("num") int rec_monney){
        Change num = new Change();
        if(rec_monney >= 1000){
            int ans = rec_monney/1000;
            rec_monney = rec_monney-(1000*ans);
            num.setB1000(ans);
        }
        if(rec_monney >= 500){
            int ans = rec_monney/500;
            rec_monney = rec_monney-(500*ans);
            num.setB500(ans);
        }
        if(rec_monney >= 100){
            int ans = rec_monney/100;
            rec_monney = rec_monney-(100*ans);
            num.setB100(ans);
        }
        if(rec_monney >= 20){
            int ans = rec_monney/20;
            rec_monney = rec_monney-(20*ans);
            num.setB20(ans);
        }
        if(rec_monney >= 10){
            int ans = rec_monney/10;
            rec_monney = rec_monney-(10*ans);
            num.setB10(ans);
        }
        if(rec_monney >= 5){
            int ans = rec_monney/5;
            rec_monney = rec_monney-(5*ans);
            num.setB5(ans);
        }
        if(rec_monney >= 1){
            int ans = rec_monney/1;
            rec_monney = rec_monney-(1*ans);
            num.setB1(ans);
        }
        return num;
    }


}
