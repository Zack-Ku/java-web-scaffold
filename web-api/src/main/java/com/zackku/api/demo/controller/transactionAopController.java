package com.zackku.api.demo.controller;

import com.zackku.common.core.Constant;
import com.zackku.common.core.Response;
import com.zackku.service.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zack
 * @date 2018/5/22
 */
@RestController
@RequestMapping("/demo")
public class transactionAopController {
    private TradeService tradeService;

    @Autowired
    public transactionAopController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping("/transaction")
    public Response testTransactionAop() {
        tradeService.createBidOffer();
        return new Response();
    }
}
