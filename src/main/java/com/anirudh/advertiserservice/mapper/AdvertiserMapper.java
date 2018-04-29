package com.anirudh.advertiserservice.mapper;


import com.anirudh.advertiserservice.model.Advertiser;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AdvertiserMapper {

    @Select("select * from Advertiser")
    public Collection<Advertiser> findAll();

    @Insert("insert into Advertiser(Advertiser_Name,Contact_Name,Credit_Limit) values(#{advertiserName},#{contactName},#{creditLimit})")
    public void insertAdvertiser(Advertiser advertiser);

    @Select("select * from Advertiser where Advertiser_Name=#{name}")
    Advertiser selectAdvertiser(String name);

    @Delete("DELETE from Advertiser WHERE Advertiser_Name = #{name}")
    public void deleterAdvertiserByName(String name);

    @Update("UPDATE Advertiser SET Contact_Name=#{contactName},Credit_Limit=#{creditLimit} where Advertiser_Name=#{advertiserName}")
    public void updateAdvertiserByName(Advertiser advertiser);
}
