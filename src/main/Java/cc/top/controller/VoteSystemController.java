package cc.top.controller;

import cc.top.fundation.BASEDAO.JsonUtils;
import cc.top.fundation.ExportExcel;
import cc.top.model.ATC.entity.Result;
import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.entity.VoteList;
import cc.top.model.ATC.entity.VoteUser;
import cc.top.model.ATC.service.IVoteService;
import cc.top.model.ATC.service.IVoteUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Zus on 4/9/16.
 */
@Controller
@RequestMapping("/atc")
public class VoteSystemController {

    @Autowired
    private IVoteUserService userService;
    @Autowired
    private IVoteService voteService;

    //http://localhost:8080/atc/login?account=123&password=123
    @RequestMapping("login")
    @ResponseBody
    public void login(VoteUser user, HttpServletRequest request, HttpServletResponse response){
        VoteUser u = userService.login(user);
        JsonUtils.writeJson(new Gson().toJson(u),request,response);
    }

    //http://localhost:8080/atc/regist?account=421&password=123&clsnum=20131222&tel=123456789
    @RequestMapping("regist")
    @ResponseBody
    public void regist(VoteUser user,HttpServletRequest request,HttpServletResponse response){
        userService.addUser(user);
        VoteUser u =userService.selectbyAP(user);
        JsonUtils.writeJson(new Gson().toJson(u),request,response);
    }

    //http://localhost:8080/atc/voteList
    @RequestMapping("voteList")
    @ResponseBody
    public void showVoteList(HttpServletRequest request,HttpServletResponse response){
       List<VoteList> vLists= voteService.getAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(vLists);
        JsonUtils.writeJson(json,request,response);
    }

    //http://localhost:8080/atc/userVote?voteId=2&result=10101&userId=2
    @RequestMapping("userVote")
    @ResponseBody
    public void addVote(Vote v,HttpServletRequest request,HttpServletResponse response){
        Vote v1 = voteService.selectByUIdAndVId(v);
        if(v1==null) {
            v.setDate(new Date());
            voteService.addVote(v);
            voteService.saveResultByUserVote(v);
            String json = "{\"success\":\"success\"}";
            JsonUtils.writeJson(json, request, response);
        }
        else{
            String json = "{\"message\":\"每个用户只能参加一次！\"}";
            JsonUtils.writeJson(json, request, response);
        }
    }

    //http://localhost:8080/atc/getResults?voteId=1
    @RequestMapping("getResults")
    @ResponseBody
    public void getResults(int voteId,HttpServletRequest request,HttpServletResponse response){
        List<Result> results = voteService.getResult(voteId);
        JsonUtils.writeJson(new Gson().toJson(results), request, response);
    }

    //http://localhost:8080/atc/creatVote?startTime=2015-3-12&endTime=2015-4-2&voteName=第三次
    @RequestMapping("creatVote")
    @ResponseBody
    public void addVoteList(VoteList voteList,HttpServletRequest request,HttpServletResponse response){
        voteService.addVoteList(voteList);
        String json = "{\"success\":\"success\"}";
        JsonUtils.writeJson(json, request, response);
    }

    /**
    //http://localhost:8080/atc/addResult?mechineId=1&rate=1&count=2&voteId=1&voteName=123
    @RequestMapping("addResult")
    @ResponseBody
    public void addResult(Result r,HttpServletRequest request,HttpServletResponse response){
       voteService.addResult(r);
        JsonUtils.writeJson(new Gson().toJson(r),request,response);
    }

    //http://localhost:8080/atc/updateResult?rate=7&count=4
    @RequestMapping("updateResult")
    @ResponseBody
    public void updateResult(Result r){
        voteService.updateReslut(r);
    }

    //http://localhost:8080/atc/selectByVIdAndMId?mechineId=1&voteId=1
    @RequestMapping("selectByVIdAndMId")
    @ResponseBody
    public void selectByVIdAndMId(Result r,HttpServletRequest request,HttpServletResponse response){
        Result r1 = voteService.selectByVIdAndMId(r);
        JsonUtils.writeJson(new Gson().toJson(r1),request,response);
    }



    //http://localhost:8080/atc/selectByUIdAndVId?userId=2&voteId=2
    @RequestMapping("selectByUIdAndVId")
    @ResponseBody
    public void  selectByUIdAndVId(Vote v,HttpServletRequest request,HttpServletResponse response){
        Vote v1 = voteService.selectByUIdAndVId(v);
        JsonUtils.writeJson(new Gson().toJson(v1),request,response);
    }
     */

    @RequestMapping("export")
    public void exportExcel(HttpServletResponse response,int voteId){
        ExportExcel excel=new ExportExcel();

        List<Result> list = voteService.getResult(voteId);

        String [] Title = {"ID","设备名","满意度","投票总人数"};

        excel.exportExcel(response,"vote.xls",Title,list);

    }




}

