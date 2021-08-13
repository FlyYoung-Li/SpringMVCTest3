package com.atguigu2.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/7/13 14:54
 */
public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置响应的内容格式，这里的render（），是创建了view对象后自动调用的
        response.setContentType("text/html");
        response.getWriter().write("这是我自己的视图对象，现在已经渲染成功，你想要的内容即将呈现");
        List<String> videos = (List<String>) model.get("videos");
        for (String string:videos
             ) {
        response.getWriter().write(">下载"+string+"</a><br>");

        }
        response.getWriter().write("<script type=\"text/javascript\">"
                +"var aEl = document.getElementByTagName('a');" +
                "aEl[0].onclick=function(){" +
                "alert('想下载么，叫学费')" +
                "}"+
                ""+"</script>");
    }
}
