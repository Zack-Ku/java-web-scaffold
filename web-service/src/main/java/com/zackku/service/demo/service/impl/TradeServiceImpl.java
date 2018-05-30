package com.zackku.service.demo.service.impl;

import com.zackku.service.demo.bid.domain.Bid;
import com.zackku.service.demo.bid.mapper.BidMapper;
import com.zackku.service.demo.offer.domain.Offer;
import com.zackku.service.demo.offer.mapper.OfferMapper;
import com.zackku.service.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zack
 * @date 2018/5/25
 */
@Service
public class TradeServiceImpl implements TradeService {
    private BidMapper bidMapper;
    private OfferMapper offerMapper;

    @Autowired
    public TradeServiceImpl(BidMapper bidMapper, OfferMapper offerMapper) {
        this.bidMapper = bidMapper;
        this.offerMapper = offerMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBidOffer() {
        insertBidAndOffer();
    }

    public void insertBidAndOffer() {
        insertBid();
        throw new RuntimeException();
//        insertOffer();
    }

    private Bid insertBid() {
        Bid bid = new Bid();
        bid.setTotalAmount(100);
        bid.setRestAmount(100);
        bidMapper.insert(bid);
        return bid;
    }

    private Offer insertOffer() {
        Offer offer = new Offer();
        offer.setTotalAmount(100);
        offer.setRestAmount(100);
        offerMapper.insert(offer);
        return offer;
    }
}
