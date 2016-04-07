package cc.top.controller;

import cc.top.model.iot.entity.Iot;
import cc.top.model.iot.service.IotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zus on 4/6/16.
 */

@Controller
@RequestMapping("/iot")
public class IotController {
    @Autowired private IotService iotService;

    @RequestMapping("submit")
    public void insertIot(Iot iot, HttpServletRequest request , HttpServletResponse response){

        response.setContentType("text/html;charset=UTF-8");
        String callbackFunName =request.getParameter("callback");

        String jsonData =  "{\"success\":\"success\"}";

        iotService.insertIot(iot);

        try {
            response.getWriter().write(callbackFunName + "("+jsonData+")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("imin")
    public String index(){
        return "redirect:html/top.html";
    }

}
