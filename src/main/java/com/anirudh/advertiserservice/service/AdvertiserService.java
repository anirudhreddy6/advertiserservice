package com.anirudh.advertiserservice.service;

        import com.anirudh.advertiserservice.mapper.AdvertiserMapper;
        import com.anirudh.advertiserservice.model.Advertiser;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.List;

@Service
public class AdvertiserService {



    @Autowired
    private AdvertiserMapper advertiserMapper;

    public Collection<Advertiser> getALLAdvertisers(){

        return advertiserMapper.findAll();
    }

    public Advertiser createAdvertiser(Advertiser advertiser)
    {

        advertiserMapper.insertAdvertiser(advertiser);
        return advertiserMapper.selectAdvertiser(advertiser.getAdvertiserName());
    }

    public Advertiser getAdvertiserByName(String name) {
        return advertiserMapper.selectAdvertiser(name);
    }

    public void deleteAdvertiserByName(String name) {
        advertiserMapper.deleterAdvertiserByName(name);
    }

    public Advertiser updateAdvertiser(Advertiser advertiser) {

    advertiserMapper.updateAdvertiserByName(advertiser);
    return getAdvertiserByName(advertiser.getAdvertiserName());

    }

    public boolean checkTransaction(String name,double transactionAmount) {
    Advertiser advertiser = advertiserMapper.selectAdvertiser(name);

        if(advertiser != null && advertiser.getCreditLimit() >= transactionAmount)
        {

                return true;

        }
        return false;
    }

    public Advertiser postTransaction(String name,double transactionAmount)
    {
        Advertiser advertiser = advertiserMapper.selectAdvertiser(name);
        advertiser.setCreditLimit(advertiser.getCreditLimit()-transactionAmount);
        advertiserMapper.updateAdvertiserByName(advertiser);
        return getAdvertiserByName(name);
    }

}
