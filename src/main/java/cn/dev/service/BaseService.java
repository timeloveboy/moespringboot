package cn.dev.service;


import cn.dev.dao.BaseMapper;
import cn.dev.model.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map updateByID(Base base) {
        Map result = new HashMap();
        result.put("base update", baseMapper.updateById(base));
        return result;
    }

    public Map replacebyID(Base base) {
        Map result = new HashMap();
        result.put("base update", baseMapper.replaceById(base));
        return result;
    }

    public Map deleteBaseByID(Integer id) {
        Map result = new HashMap();
        result.put("base delete", baseMapper.deleteById(id));
        return result;
    }

    public Map addBase(Base base) {
        Map result = new HashMap();
        result.put("base add", baseMapper.add(base));
        return result;
    }
}
