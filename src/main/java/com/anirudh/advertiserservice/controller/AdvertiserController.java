package com.anirudh.advertiserservice.controller;
/*

*/

import com.anirudh.advertiserservice.mapper.AdvertiserMapper;
import com.anirudh.advertiserservice.model.Advertiser;
import com.anirudh.advertiserservice.service.AdvertiserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/advertiser")
@Api(value = "Advertiser",description = "Operations allowed on the Advertiser Resource")
public class AdvertiserController {

    @Autowired
    private AdvertiserService advertiserService;


    //##GET ALL ADVERTISERS##

    @GetMapping
    @ApiOperation(value = "Return All Advertisers")
    public ResponseEntity<?> getAllAdvertisers() {

        return new ResponseEntity(advertiserService.getALLAdvertisers(), HttpStatus.OK);
    }



    //##GET ADVERTIRSER BY Name

    @ApiOperation(value="Get Advertiser by Name")
    @GetMapping(value="/{name}")
    public ResponseEntity<Advertiser> getAdvertiserByName(@PathVariable("name") String name)
    {
        return new ResponseEntity(advertiserService.getAdvertiserByName(name),HttpStatus.OK);
    }


    //##Delete ADVERTISER
    @DeleteMapping(value="/{name}")
    @ApiOperation(value="Delete Adbertiser By Name")
    public ResponseEntity deleteAdvertiserByName(@PathVariable("name") String name)
    {
        advertiserService.deleteAdvertiserByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
    @ApiOperation(value = "Create an Advertiser")
    public ResponseEntity<List<Advertiser>> createAdvertiser(@RequestBody Advertiser advertiser)
    {
        return new ResponseEntity(advertiserService.createAdvertiser(advertiser),HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
    @ApiOperation(value="Update an Advertiser")
    public ResponseEntity<Advertiser> updateAdvertiser(@RequestBody Advertiser advertiser)
    {
        return new ResponseEntity(advertiserService.updateAdvertiser(advertiser),HttpStatus.OK);
    }

    @GetMapping(value = "checkTransaction/{name}/{transactionAmount}")
    @ApiOperation(value = "Returns a boolean value which tells us if the trasaction is possible or not")
    public ResponseEntity checkTransaction(@RequestParam(value="name",required = true) String name,@RequestParam(value="transactionAmount",required=true) int transactionAmount)
    {
            return new ResponseEntity(advertiserService.checkTransaction(name,transactionAmount),HttpStatus.OK);
    }

}