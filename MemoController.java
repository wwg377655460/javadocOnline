package com.save.controller;

import com.save.util.UrlUtils.Online;
import com.save.util.UrlUtils.UrlUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wsdevotion on 15/10/17.
 */
@Controller
public class MemoController {

    @RequestMapping("/getMemoMes")
    @Transactional(rollbackFor = {Exception.class})
    public String getMemoMes(Model model){
        List<String> className = UrlUtil.getClassName("com.save.controller");
        List<Online> lists = UrlUtil.getUrl(className);
        model.addAttribute("lists", lists);
        return "url";
    }
}
