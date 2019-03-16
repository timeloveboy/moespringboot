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

    public Base getByName(String name) {
        return baseMapper.findByName(name);
    }

    public Base getByID(Integer id) {
        return baseMapper.findById(id);
    }

    public List<Base> filter(Base base, int from, int limit) {
        List<Base> bases = baseMapper.filter(base, from, limit);
        return bases;
    }

    public String updateByID(Base base) {
        int count = baseMapper.updateById(base);
        return count + "";
    }

    public String replacebyID(Base base) {
        int count = baseMapper.replaceById(base);
        return count + "";
    }

    public String deleteBaseByID(Integer id) {
        int count = baseMapper.deleteById(id);
        return count + "";
    }

    public String addBase(Base base) {
        int count = baseMapper.add(base);
        return count + "";
    }
}
