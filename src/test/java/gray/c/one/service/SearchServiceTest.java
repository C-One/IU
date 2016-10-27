package gray.c.one.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jykang on 2016. 10. 26..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {


    @Autowired
    SearchService searchService;

    @Test
    public void test(){

        String result= searchService.searchByBlog("클래시로얄");

        System.out.println(result);

    }
}
