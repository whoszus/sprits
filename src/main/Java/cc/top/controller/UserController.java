package cc.top.controller;

import cc.top.fundation.WeixinTools;
import cc.top.model.TestModel.entity.User;
import cc.top.model.TestModel.service.IUserService;
import cc.top.model.webchat.entity.WebchatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linyanying on 2015/12/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("test")
    @ResponseBody
    public Map test(){
        Map map = new HashMap();
        map.put("hello","world");
        return map;
    }
    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(User user){
        User user1 = userService.getUser(user);
        return user1;
    }


    @RequestMapping("getWebc")
    public WebchatClient getWebc(HttpServletRequest req, HttpServletResponse res){
        WebchatClient webchatClient=null;
        try {
             webchatClient = WeixinTools.getUserInformationFromWeixin(req, res,"wxddcf7f3ec3203134","a98fe13dee2e2ac1623418642b62c997");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(webchatClient.getNickname());

        return webchatClient;
    }





}
