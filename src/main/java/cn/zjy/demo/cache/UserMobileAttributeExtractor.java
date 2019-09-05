package cn.zjy.demo.cache;

import cn.zjy.demo.bean.model.User;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.attribute.AttributeExtractor;
import net.sf.ehcache.search.attribute.AttributeExtractorException;

public class UserMobileAttributeExtractor implements AttributeExtractor {
    @Override
    public Object attributeFor(Element element, String s) throws AttributeExtractorException {
        User user = (User) element.getObjectValue();
        return user.getMobile();
    }
}
