package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.dto.DemoDTO;
import com.shzhong.mqorder.util.R;
import com.shzhong.mqorder.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/test")
@Slf4j
@RestController
public class TestController {

    @GetMapping("/demo")
    public Object testDemo(Integer age) {
        // query string
        System.out.println("age = " + age);
        ApplicationContext context = SpringContextUtil.getApplicationContext();
        Object config = context.getBean("rabbitMqConfig");
        log.info("config,{}", config);
        return R.ok();
    }

    @PostMapping("/demo1")
    public Object testDemo1(@RequestBody Map<String, Object> demoReq) {
        //application/json
        log.info(demoReq.get("name").toString());
        log.info(demoReq.get("age").toString());
        return R.ok(demoReq);
    }

    @PostMapping("/demo2")
    public Object testDemo2(@RequestBody DemoDTO demoDTO) {
        //application/json
        System.out.println(demoDTO);
        System.out.println(demoDTO.getName());
        return R.ok(demoDTO);
    }


    @PostMapping("/demo3")
    public Object testDemo3(String name, Integer age) {
        //解析x-www-form-urlencoded
        log.info(name);
        log.info(age.toString());
        return R.ok();
    }


    @GetMapping("main")
    public Object demo4(HttpServletRequest request) {
        // get query string
        String name = request.getParameter("name");
        System.out.println(name);
        return R.ok();
    }

    @PostMapping("post")
    public Object demo5(HttpServletRequest request) {
        // 解析x-www-form-urlencoded
        String name = request.getParameter("name");
        System.out.println(name);
        return R.ok();
    }

    @PostMapping("/upload")
    public Object upload(HttpServletRequest request) {
        // multipart/form-data
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        String name = params.getParameter("name"); // 获取一般field
        List<MultipartFile> files = params.getFiles("file"); // 获取file列表
        return R.ok();
    }

    /**
     * 更多例子 https://hewei0928.github.io/2018/06/20/Spring%E4%B9%8B%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E4%B8%8EMultipartFile/
     *
     * @param file
     * @return
     */
    @PostMapping("/upload1")
    public Object upload1(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return "上传成功";

        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
