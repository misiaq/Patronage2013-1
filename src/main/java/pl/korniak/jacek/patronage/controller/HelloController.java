package pl.korniak.jacek.patronage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.korniak.jacek.patronage.model.Message;

@Controller
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)

    public  @ResponseBody Message hello(@RequestParam(value = "param") String param) {

        Message message = new Message();
        message.setMessage(param);

        return message;

    }


}
