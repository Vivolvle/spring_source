package com.vivolvle.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liangzheng.wei
 * @Description: 自定义逻辑返回需要导入的组件
 * @date 2019/10/11 20:29
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata    当前标注@Import注解的所有注解信息
     * @return  导入到容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.vivolvle.bean.Yellow","com.vivolvle.bean.Blue"};
    }
}
