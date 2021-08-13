package com.atguigu2.viewsolver;

import com.atguigu2.view.MyView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO 自己的视图解析器
 * @date 2021/7/13 14:52
 */
public class MyViewResolver implements ViewResolver, Ordered {
    private int order = 0;
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        //viewName就是方法的返回值，根据前缀决定创建自己的view对象
        if (viewName.startsWith("meinv:")) {
            return new MyView();
        } else {
            return null;
        }
    }
//决定视图解析器的优先级
    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
