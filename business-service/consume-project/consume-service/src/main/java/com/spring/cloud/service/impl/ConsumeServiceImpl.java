package com.spring.cloud.service.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.constant.CatConstants;
import com.spring.cloud.feign.ProduceClientApi;
import com.spring.cloud.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fenglijian
 * @date 2022-10-13 18:36
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private ProduceClientApi produceClientApi;

    public String testFeign(String str) {
        Transaction t = Cat.newTransaction(CatConstants.TRANSACTION_TYPE, CatConstants.TRANSACTION_FEIGN_TEST);
        try {
            String s = produceClientApi.testFeign(str);
            return s;
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
        return null;
    }
}
