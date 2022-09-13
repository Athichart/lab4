package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/index2")
public class CashierView extends VerticalLayout {
    private TextField rec_mon, t1000,t500,t100,t20,t10,t5,t1;
    private Button btn;
    public CashierView(){
        rec_mon = new TextField("เงินทอน");
        btn = new Button("คำนวณเงินทอน");
        t1000 = new TextField("$1000: ");
        t500 = new TextField("$500: ");
        t100 = new TextField("$100: ");
        t20 = new TextField("$20: ");
        t10 = new TextField("$10: ");
        t5 = new TextField("$5: ");
        t1 = new TextField("$1: ");

        this.add(rec_mon,btn,t1000,t500,t100,t20,t10,t5,t1);
        btn.addClickListener(event ->{
            int money = Integer.parseInt(rec_mon.getValue());
            Change output = WebClient.create()//สร้างช่องทางการสื่อสาร
                    .get()//กำหนดรูปแบบการสื่อสาร
                    .uri("http://localhost:8080/getChange/"+ money)//กำหนดที่อยู่ของ Service+Data
                    .retrieve()//ให้รอรับข้อมูลกลับมา
                    .bodyToMono(Change.class)//กำหนด spec ของ Response
                    .block();// Blocking thread
            t1000.setValue(output.getB1000()+"");
            t500.setValue(output.getB500()+"");
            t100.setValue(output.getB100()+"");
            t20.setValue(output.getB20()+"");
            t10.setValue(output.getB10()+"");
            t5.setValue(output.getB5()+"");
            t1.setValue(output.getB1()+"");
        });
    }
}
