package cn.dev.controller;

import cn.dev.model.Base;
import cn.dev.model.CommonResp;
import cn.dev.service.BaseService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("base")
public class BaseController {
    @Autowired
    BaseService baseService;

    @Value("${limit}")
    Integer searchlimit;

    @ApiOperation(value = "根基id或者name获取单条", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResp get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer id) {
        CommonResp resp = new CommonResp();
        if (name != null) {
            resp.setResult(baseService.getByName(name));
        } else if (id != null) {
            resp.setResult(baseService.getByID(id));
        } else {
            resp.setCode(-1);
            resp.setMessage("name or id need");
        }
        return resp;
    }

    @ApiOperation(value = "根据name搜索Base", notes = "")
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public CommonResp search(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        CommonResp resp = new CommonResp();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();


        Base base = JSON.parseObject(JSON.toJSONString(request.getParameterMap()), Base.class);
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = searchlimit;
        }
        resp.setResult(baseService.filter(base, offset, limit));
        return resp;
    }

    @ApiOperation(value = "根基id删除base", notes = "")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public CommonResp search(@RequestParam Integer id) {
        CommonResp resp = new CommonResp();
        resp.setResult(baseService.deleteBaseByID(id));
        return resp;
    }

    @ApiOperation(value = "根基id更新base", notes = "")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public CommonResp update(@RequestParam Integer id, @RequestBody Base base) {
        CommonResp resp = new CommonResp();
        resp.setResult(baseService.updateByID(base));
        return resp;
    }

    @ApiOperation(value = "根基id替换base", notes = "")
    @RequestMapping(value = "replace", method = RequestMethod.PUT)
    public CommonResp replace(@RequestParam Integer id, @RequestBody Base base) {
        CommonResp resp = new CommonResp();
        resp.setResult(baseService.replacebyID(base));
        return resp;
    }


    @ApiOperation(value = "创建base", notes = "")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResp insert(@RequestBody Base base) {
        CommonResp resp = new CommonResp();
        resp.setResult(baseService.addBase(base));
        return resp;
    }
}
