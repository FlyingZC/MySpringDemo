package com.baobaotao.editor;

import java.beans.PropertyEditorSupport;

/**
 * 1.为Car类型提供一个自定义的属性编辑器，这样，我们就通过字面值为Boss的car属性提供配置值
 */
public class CustomCarEditor extends PropertyEditorSupport {
    // 2.该方法负责将配置文件以字符串提供的字面值转换为Car对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {// 参数text为xml中配置的Car对象的value值
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        setValue(car);// 设置到car对象中
    }
}
