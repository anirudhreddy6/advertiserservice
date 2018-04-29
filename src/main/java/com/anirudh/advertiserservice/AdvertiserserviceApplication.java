package com.anirudh.advertiserservice;

import com.anirudh.advertiserservice.model.Advertiser;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anirudh.advertiserservice.mapper")
@MappedTypes(Advertiser.class)
public class AdvertiserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertiserserviceApplication.class, args);
	}
}
