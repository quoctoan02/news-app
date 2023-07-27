package com.example.mobile.controller;

import com.example.mobile.dto.NewsDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "scraper")
public class ScraperController {

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public NewsDto getHttp(@RequestParam(name = "url") String url){
        // @RequestParam(name = "source_id", value = "") String source) {
        try {
            Document doc = Jsoup.connect(url).get();
            List<String> listImgUrl = Collections.emptyList();
            List<String> listContent = Collections.emptyList();
            String imgLogo = "";
//            switch (source) {
//                case "vnexpress": {
//
//                }
//            }

            // List<String> content = doc.getElementsByTag("img").eachAttr("src");
            listImgUrl = doc.select(":not(a.logo) > img").eachAttr("data-src");
            if(listImgUrl.size() == 0) {
                listImgUrl = doc.select("figure img").eachAttr("src");
            }
            if(listImgUrl.size() == 0) {
                listImgUrl = doc.select(":not(a.logo) > img").eachAttr("src");
            }
            if(listImgUrl.size() == 0) {
                listImgUrl = doc.select(":not(a) > img").eachAttr("src");
            }
            if(listImgUrl.size() == 0) {
                listImgUrl = doc.select("img").eachAttr("src");
            }

            imgLogo = doc.select("a.logo > img").attr("src");

            listContent = doc.select("article >p").select("p").eachText();
            if(listContent.size() == 0) {
                listContent = doc.select("div:has(>img):has(>p)").select("p").eachText();
            }
            if(listContent.size() == 0) {
                String content1 = doc.select("div:has(>p):has(a>img)").select("p").text();
                String content2 = doc.select("div:has(>p):has(:not(a)>img)").select("p").text();
                if(content1.length() != 0 && content2.length() != 0) {
                    if(content2.contains(content1) || content1.contains(content2)){
                        listContent = content1.length() < content2.length() ? doc.selectFirst("div:has(>p):has(a>img)").select("p").eachText() :
                                doc.selectFirst("div:has(>p):has(:not(a)>img)").select("p").eachText();
                    } else {
                        listContent = content1.length() > content2.length() ? doc.selectFirst("div:has(>p):has(a>img)").select("p").eachText() :
                                doc.selectFirst("div:has(>p):has(:not(a)>img)").select("p").eachText();
                    }
                } else if(content1.length() == 0 && content2.length() != 0) {
                    listContent = doc.selectFirst("div:has(>p):has(:not(a)>img)").select("p").eachText();
                }  else if(content2.length() == 0 && content1.length() != 0){
                    listContent = doc.selectFirst("div:has(>p):has(a>img)").select("p").eachText();
                } else {
                    listContent = doc.select("div:has(img):has(>p)").select("p").eachText();
                    if(listContent.size() > 0) {
                        listContent = doc.selectFirst("div:has(img):has(>p)").select("p").eachText();
                    }
                }
            }
            if(listContent.size() == 0) {
                listContent = doc.select("div:has(img, p)").select("p").eachText();
                if(listContent.size() > 0) {
                    listContent = doc.selectFirst("div:has(img, p)").select("p").eachText();
                }
            }
            if(listContent.size() == 0) {
                listContent = doc.selectFirst("div:has(>p)").select("p").eachText();
            }
//                int index = 0;
//                int elementLength = listContent.get(0).length();
//                for(int i=1; i< listContent.size(); i++) {
//                    if(listContent.get(i).length() > elementLength) {
//                        index = i; elementLength = listContent.get(i).length();
//                    }
//                }
            // return listContent.get(index);
            return new NewsDto( imgLogo, listContent, listImgUrl);
        } catch (IOException e) {
            //  throw new RuntimeException(e);
            return new NewsDto();
        }
    }
}
