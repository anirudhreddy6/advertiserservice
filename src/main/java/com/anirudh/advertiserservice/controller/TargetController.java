package com.anirudh.advertiserservice.controller;

import com.anirudh.advertiserservice.model.Target;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path="target")
@Api(value = "Target",description = "Operations allowed on the Target Resource")
public class TargetController {


    @GetMapping
    public List<Target> getTargets() throws Exception{
        ArrayList<Target> samplelist= new ArrayList<Target>();
        samplelist.add(new Target("anirudh","500034"));

        return samplelist;
    }
    }

