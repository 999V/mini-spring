package org.springframework.beans;


import java.util.ArrayList;
import java.util.List;

/**
 * 特性列表包装类
 *
 * @author zhengxin
 * @since 1.0.0
 */
public class PropertyValues {

    /**
     * 属性值列表
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();


    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
