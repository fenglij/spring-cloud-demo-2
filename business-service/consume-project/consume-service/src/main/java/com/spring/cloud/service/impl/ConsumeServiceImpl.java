package com.spring.cloud.service.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.spring.cloud.constant.CatConstants;
import com.spring.cloud.facade.ProduceApiFacade;
import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.command.TestCmd;
import com.spring.cloud.model.dto.AddDTO;
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
    private ProduceApiFacade produceApiFacade;

    public String testFeign(String str) {
        Transaction t = Cat.newTransaction(CatConstants.TRANSACTION_TYPE, CatConstants.TRANSACTION_FEIGN_TEST);
        try {
            String s = produceApiFacade.testFeign(str);
            t.setStatus(Transaction.SUCCESS);
            return s;
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
        return null;
    }

    @Override
    public AddDTO testFeign2(TestCmd cmd) {
        AddCmd addCmd = new AddCmd();
        addCmd.setName(cmd.getName());
        AddDTO dto = produceApiFacade.testFeign2(addCmd);
        return dto;
    }
}
