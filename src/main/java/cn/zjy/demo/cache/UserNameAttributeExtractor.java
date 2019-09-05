package cn.zjy.demo.cache;

import cn.zjy.demo.bean.model.User;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.attribute.AttributeExtractor;
import net.sf.ehcache.search.attribute.AttributeExtractorException;

public class UserNameAttributeExtractor implements AttributeExtractor {
    private static final long serialVersionUID = 1326627979712661619L;

    @Override
    public Object attributeFor(Element element, String s) throws AttributeExtractorException {
        User user = (User) element.getObjectValue();
        return user.getName();
    }
}
