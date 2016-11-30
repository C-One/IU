package gray.c.one.service;

import com.mashape.unirest.http.HttpResponse;
import gray.c.one.model.Blog;
import gray.c.one.util.Parser;
import gray.c.one.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jykang on 2016. 10. 20..
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private RestClient restClient;

    @Override
    public String search(String keyword){


        //TODO : 네이버 검색 API를 써서 검색 결과 받아서 리턴해주면 된다.

        return "12시 30분";
    }


    @Override
    public Blog searchByBlog(String keyword) {

        HttpResponse<String> response = restClient.searchByBlog(keyword);

//        return response.getBody();
        return Parser.xmlParser(response.getBody());
    }


}
