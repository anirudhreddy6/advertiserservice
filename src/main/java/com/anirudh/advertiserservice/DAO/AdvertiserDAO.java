package com.anirudh.advertiserservice.DAO;


import com.anirudh.advertiserservice.model.Advertiser;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdvertiserDAO {

    private static Map<Integer,Advertiser> advertisers;
    static{
        advertisers = new HashMap<Integer,Advertiser>(){

            {

            }
        };
    }


    public Collection<Advertiser> getALLAdvertisers() {

        return this.advertisers.values();
    }


    public Advertiser insertStudent(Advertiser ad) {

        advertisers.put(100,ad);
        return ad;
    }

}
