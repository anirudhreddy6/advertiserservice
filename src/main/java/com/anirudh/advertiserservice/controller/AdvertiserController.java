package com.anirudh.advertiserservice.controller;
/*

*/

import com.anirudh.advertiserservice.model.Advertiser;
import com.anirudh.advertiserservice.service.AdvertiserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/advertiser")
@Api(value = "Advertiser",description = "Operations allowed on the Advertiser Resource")
public class AdvertiserController {

    @Autowired
    private AdvertiserService advertiserService;


    //##GET ALL ADVERTISERS##

    @GetMapping
    @ApiOperation(value = "List All Advertisers")
    public ResponseEntity<List<Advertiser>> getAllAdvertisers() {

        return new ResponseEntity(advertiserService.getALLAdvertisers(), HttpStatus.OK);
    }



    //##GET ADVERTIRSER BY Name

    @ApiOperation(value="Get Advertiser by Name")
    @GetMapping(value="/{name}")
    public ResponseEntity<Advertiser> getAdvertiserByName(@PathVariable("name") String name) throws Exception
    {
        if(advertiserService.getAdvertiserByName(name) == null)
        {
            throw new Exception("Advertiser with the Name does not exist.Please check the Name!!!!");
        }
        return new ResponseEntity(advertiserService.getAdvertiserByName(name),HttpStatus.OK);
    }


    //##Delete ADVERTISER
    @DeleteMapping(value="/{name}")
    @ApiOperation(value="Delete Advertiser By Name")
    public ResponseEntity deleteAdvertiserByName(@PathVariable("name") String name) throws Exception
    {
        if(advertiserService.getAdvertiserByName(name) == null)
        {
            throw new Exception("Advertiser with this name does not exist.");
        }
        advertiserService.deleteAdvertiserByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
    @ApiOperation(value = "Create an Advertiser")
    public ResponseEntity<Advertiser> createAdvertiser(@RequestBody Advertiser advertiser) throws Exception
    {
        if(advertiser.getAdvertiserName() == null || advertiser.getContactName() == null)
        {
            throw new Exception("Request parameter AdvertiserName and ContactName cannot be null. ");
        }
        return new ResponseEntity(advertiserService.createAdvertiser(advertiser),HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
    @ApiOperation(value="Update an Advertiser")
    public ResponseEntity<Advertiser> updateAdvertiser(@RequestBody Advertiser advertiser) throws Exception
    {
        if(advertiser.getAdvertiserName() == null || advertiser.getContactName() == null || advertiserService.getAdvertiserByName(advertiser.getAdvertiserName()) == null)
        {
            throw new Exception(" Please check the request body for AdvertiserName and ContactName.");
        }
        return new ResponseEntity(advertiserService.updateAdvertiser(advertiser),HttpStatus.OK);
    }

    @GetMapping(value = "checkTransaction/{name}/{transactionAmount}")
    @ApiOperation(value = "Returns a boolean value which describes if the Advertiser has enough credit limit or not.")
    public ResponseEntity<Boolean> checkTransaction(@RequestParam(value="name",required = true) String name,@RequestParam(value="transactionAmount",required=true) double transactionAmount) throws Exception
    {
            if(advertiserService.getAdvertiserByName(name) == null || transactionAmount <=0)
            {
                throw new Exception("Transaction amount should be a positive number(positivie integer or of type dobule).Also please check if the AdvertiserName is a valid name.");
            }
            return new ResponseEntity(advertiserService.checkTransaction(name,transactionAmount),HttpStatus.OK);
    }

    @PostMapping(value="postTransaction/{name}/{transactionAmount}")
    @ApiOperation(value="Deducts the credit limt of the Advertiser")
    public ResponseEntity<Advertiser> postTransaction(@RequestParam(value="name",required = true) String name,@RequestParam(value="transactionAmount",required=true) double transactionAmount) throws Exception
    {
        if(advertiserService.getAdvertiserByName(name) == null || transactionAmount <=0 || transactionAmount>advertiserService.getAdvertiserByName(name).getCreditLimit())
        {
            throw new RuntimeException("Transaction amount should be a positive number(positivie integer or of type dobule) and be less than the credit limit of the Advertiser.Also please check if the AdvertiserName is a valid name.");
        }
        return new ResponseEntity(advertiserService.postTransaction(name,transactionAmount),HttpStatus.OK);
    }

}
