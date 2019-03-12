package cn.dev.service;


import cn.dev.dao.BaseMapper;
import cn.dev.model.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    BaseMapper baseMapper;

    public Base getBaseByName(String name) {
        return baseMapper.findByName(name);
    }

    public Base getBaseByID(Integer id) {
        return baseMapper.findById(id);
    }

    public List<Base> getBaselist(String name, int from, int limit) {
        List<Base> bases = baseMapper.getBaselist(name, from, limit);
        return bases;
    }

    public String updateBaseByID(Integer id, String name, String remarks) {
        int count = baseMapper.updateById(id, name, remarks);
        return count + "";
    }

    public String deleteBaseByID(Integer id) {
        int count = baseMapper.deleteById(id);
        return count + "";
    }

    public String addBase(Base base) {
        int count = baseMapper.addBase(base.getName(), base.getRemarks());
        return count + "";
    }
}
