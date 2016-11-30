package gray.c.one.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import gray.c.one.model.Blog;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jykang on 2016. 11. 23..
 */
@Slf4j
public class Parser {

    private static XStream xStream = new XStream(new DomDriver());

    public static Blog xmlParser(String data) {
        log.info("data : {}", data);
        xStream.alias("rss", Blog.class);
        xStream.alias("channel", Blog.class);
        xStream.alias("item", Blog.Item.class);

        System.out.println(xStream.fromXML(data));
        return null;
    }
}
