package gray.c.one.service;

import gray.c.one.model.Blog;

/**
 * Created by jykang on 2016. 10. 26..
 */
public interface SearchService {

    String search(String keyword);

    Blog searchByBlog(String keyword);
}
