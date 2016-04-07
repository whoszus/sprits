package cc.top.controller;

import cc.top.fundation.WeixinTools;
import cc.top.model.TestModel.entity.User;
import cc.top.model.TestModel.service.IUserService;
import cc.top.model.webchat.entity.WebchatClient;
import com.google.gson.Gson;
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
//    @RequestMapping(value="getUser",produces="application/json")
//    @RequestMapping(value="getUser",method = RequestMethod.GET,headers = {"Accept=text/xml, application/json"})
    @RequestMapping("getUser")
    public void getUser(User user,HttpServletRequest req,HttpServletResponse res ){
        res.setContentType("text/html;charset=UTF-8");
        String callbackFunName =req.getParameter("callback");
        User user1 = userService.getUser(user);
        Gson gson = new Gson();
        String json = gson.toJson(user1);

        try {
            res.getWriter().write(callbackFunName+"("+json+")");
        } catch (IOException e) {
            e.printStackTrace();
        }

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
