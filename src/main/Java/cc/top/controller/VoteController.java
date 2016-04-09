package cc.top.controller;

import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Zus on 4/9/16.
 */
@Controller
@RequestMapping("/atc")
public class VoteController {


    @Autowired private VoteService voteService;

    @RequestMapping("vote")
    public void vote(Vote vote){

        Vote DBvote  = voteService.getMechine(vote);

        Double rate = 1.00;

        DBvote.setCount(DBvote.getCount()+1);
        Date date = new Date();
        DBvote.setDate(date);
        DBvote.setRate(rate);
        voteService.updateVote(DBvote);

    }



}
