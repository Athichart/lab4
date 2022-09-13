package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;





@Route(value = "/index1")
public class MathView extends VerticalLayout {
    private TextField num1, num2, ans;
    private Button plus, minus, multi, divide, mod, btn_max;
    private Label lb1;

    public MathView(){
        num1 = new TextField("Number 1");
        num2 = new TextField("Number 2");
        lb1 = new Label("Operater");

        plus = new Button("+");
        minus = new Button("-");
        multi = new Button("*");
        divide = new Button("/");
        mod = new Button("%");
        btn_max = new Button("max");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(plus,minus,multi,divide,mod,btn_max);
        ans = new TextField("Answer");
        this.add(num1, num2, lb1, h1, ans);

       plus.addClickListener(event ->{
          double n1 = Double.parseDouble(num1.getValue());
          double n2 = Double.parseDouble(num2.getValue());

          String output = WebClient.create()//สร้างช่องทางการสื่อสาร
                  .get()//กำหนดรูปแบบการสื่อสาร
                  .uri("http://localhost:8080/plus/"+ n1 +"/"+ n2)//กำหนดที่อยู่ของ Service+Data
                  .retrieve()//ให้รอรับข้อมูลกลับมา
                  .bodyToMono(String.class)//กำหนด spec ของ Response
                  .block();// Blocking thread
          ans.setValue(output);
       });
        minus.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String output = WebClient.create().get().uri("http://localhost:8080/minus/"+ n1 +"/"+ n2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(output);
        });
        multi.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String output = WebClient.create().get().uri("http://localhost:8080/multi/"+ n1 +"/"+ n2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(output);
        });
        divide.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String output = WebClient.create().get().uri("http://localhost:8080/divide/"+ n1 +"/"+ n2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(output);
        });
        mod.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String output = WebClient.create().get().uri("http://localhost:8080/mod/"+ n1 +"/"+ n2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(output);
        });
        btn_max.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String output = WebClient.create().post().uri("http://localhost:8080/max?num1="+ n1 +"&num2="+ n2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(output);
        });
    }

}
