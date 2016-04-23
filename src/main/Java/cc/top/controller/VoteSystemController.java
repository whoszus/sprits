package cc.top.controller;

import cc.top.fundation.BASEDAO.JsonUtils;
import cc.top.fundation.ExportExcel;
import cc.top.model.ATC.dto.voteResult;
import cc.top.model.ATC.entity.*;
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

    //http://localhost:8080/atc/userVote?voteId=2&result=100010001&userId=2
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
            v.setDate(new Date());
            voteService.updateVote(v1,v);
            String json = "{\"message\":\"此次投票中已经投过的选项将不再写入数据库！\"}";
            JsonUtils.writeJson(json, request, response);
        }
    }

    //http://localhost:8080/atc/getResults?voteId=1
    @RequestMapping("getResults")
    @ResponseBody
    public void getResults(int voteId,HttpServletRequest request,HttpServletResponse response){
       // List<Result> results = voteService.getResult(voteId);
        List<voteResult> results = voteService.getResultInfo(voteId);
        JsonUtils.writeJson(new Gson().toJson(results), request, response);
    }

    //http://localhost:8080/atc/creatVote?startTime=2015-3-12&endTime=2015-4-2&voteName=第三次
    @RequestMapping("creatVote")
    @ResponseBody
    public void addVoteList(VoteList voteList,HttpServletRequest request,HttpServletResponse response){
        if(voteList.getVoteName()==null){
            return;
        }

        String json;
       if(voteService.IsFindVoteListByName(voteList.getVoteName())){
            json = "{\"success\":\"existed\"}";
       }else{
           voteService.addVoteList(voteList);
           json = "{\"success\":\"success\"}";
       }

        JsonUtils.writeJson(json, request, response);
    }


   //http://localhost:8080/atc/export?voteId=2
    @RequestMapping("export")
    public void exportExcel(HttpServletResponse response,int voteId){
        ExportExcel excel=new ExportExcel();

        List<voteResult> list = voteService.getResultInfo(voteId);

        String [] Title = {"设备名","投票总人数","非常满意人数","满意人数","一般满意人数","不满意人数","满意度"};

        VoteList voteList =  voteService.findByVoteId(voteId);
        String name=voteList.getVoteName()+"投票结果.xls";
        excel.exportExcel(response,name ,Title,list);

    }
    //http://localhost:8080/atc/getMechines
    @RequestMapping("getMechines")
    @ResponseBody
    public void  getMechines(HttpServletRequest request,HttpServletResponse response){
        List<Mechine>  mechines = voteService.getMechines();
        JsonUtils.writeJson(new Gson().toJson(mechines), request, response);
    }
}

