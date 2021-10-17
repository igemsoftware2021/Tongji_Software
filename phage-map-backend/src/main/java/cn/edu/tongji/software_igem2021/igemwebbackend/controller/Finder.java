package cn.edu.tongji.software_igem2021.igemwebbackend.controller;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.service.FinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/search")
public class Finder {

    @Autowired
    private FinderService finderService;

    @RequestMapping(value = "/bacteria", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getBacteriaSearchResult(@RequestParam(name = "key") String key) {
        List<ScoreWithNameEntity> result = finderService.searchForBacteria(key);
        return result.subList(0, Math.min(result.size(), 501));
    }

    @RequestMapping(value = "/phage", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getPhageSearchResult(@RequestParam(name = "key") String key) {
        List<ScoreWithNameEntity> result = finderService.searchForPhage(key);
        return result.subList(0, Math.min(result.size(), 501));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getAllSearchResult(@RequestParam(name = "key") String key) {

        if (key.length() <= 3) {
            return new ArrayList();
        }
        List<ScoreWithNameEntity> result = finderService.searchForAll(key);
        return result.subList(0, Math.min(result.size(), 501));
    }

    @RequestMapping(value = "/bacteria/suggestion", method = RequestMethod.GET)
    @ResponseBody
    public List<BacAndPhageInfo> getBacteriaSearchSuggestion(String key, int pageNum) {
        return finderService.querySuggestionForBacteria(key, pageNum);
    }

    @RequestMapping(value = "/phage/suggestion", method = RequestMethod.GET)
    @ResponseBody
    public List<BacAndPhageInfo> getPhageSearchSuggestion(String key, int pageNum) {
        return finderService.querySuggestionForPhage(key, pageNum);
    }

    @RequestMapping(value = "/all/suggestion", method = RequestMethod.GET)
    @ResponseBody
    public List<BacAndPhageInfo> getAllSearchSuggestion(String key, int pageNum) {
        return finderService.querySuggestionForAll(key, pageNum);
    }
}
