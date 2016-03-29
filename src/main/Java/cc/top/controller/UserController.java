package cc.top.controller;

import cc.top.model.TestModel.entity.User;
import cc.top.model.TestModel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
