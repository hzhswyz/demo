package com.hzh.demo.service;

import com.hzh.demo.mapper.RviMapper;
import com.hzh.demo.model.Rvi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RviService {
    @Autowired
    private RviMapper rviMapper;

    @Transactional
    public void insert(Rvi rvi){
        rviMapper.insert(rvi);
    }

    public void delete(String userid){
        rviMapper.deleteByPrimaryKey(userid);
    }

    public Rvi select(String userid){
        return rviMapper.selectByPrimaryKey(userid);
    }

    @Transactional
    public boolean validationInformation(String userid,String verificationCode){
        Rvi rvi = select(userid);
        if(rvi.getVerificationCode().equals(verificationCode)){
            delete(userid);
            return true;
        }
        else {
            return false;
        }
    }

}
