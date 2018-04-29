package com.anirudh.advertiserservice.service;

        import com.anirudh.advertiserservice.DAO.AdvertiserDAO;
        import com.anirudh.advertiserservice.mapper.AdvertiserMapper;
        import com.anirudh.advertiserservice.model.Advertiser;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Collection;
        import java.util.List;

@Service
public class AdvertiserService {

    @Autowired
    private AdvertiserDAO advertiserDAO;

    @Autowired
    private AdvertiserMapper advertiserMapper;

    public Collection<Advertiser> getALLAdvertisers(){

        return advertiserMapper.findAll();
    }

    public Collection<Advertiser> createAdvertiser(Advertiser advertiser)
    {

        advertiserMapper.insertAdvertiser(advertiser);
        return advertiserMapper.findAll();
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

    public boolean checkTransaction(String name,int transactionAmount) {
    Advertiser advertiser = advertiserMapper.selectAdvertiser(name);

        if(advertiser != null)
        {
            if(advertiser.getCreditLimit() >= transactionAmount)
            {
                return true;
            }
        }
        return false;
    }
}
