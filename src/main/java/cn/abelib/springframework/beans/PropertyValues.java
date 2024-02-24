package cn.abelib.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/11 23:23
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        this.propertyValueList = new ArrayList<>(0);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[this.propertyValueList.size()]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

    public PropertyValues addPropertyValue(PropertyValue pv) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentPv = this.propertyValueList.get(i);
            // TODO 参考Spring Merge逻辑
            if (!currentPv.getName().equals(pv.getName())) {
                this.propertyValueList.add(pv);
                return this;
            }
        }
        this.propertyValueList.add(pv);
        return this;
    }
}
