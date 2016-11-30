package gray.c.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jykang on 2016. 11. 24..
 */
@Data
public class Blog {

    private String title;
    private String link;
    private String description;
    private String lastBuildDate; // 검색결과 생성 시간
    private int total; // 검색결과 총 개수
    private int start; // 검색 결과 문서중 문서의 시작점
    private int display; //검색된 검색 결과의 개수
    private List<Item> item ;

    public Blog (){
        item = new ArrayList<>();
    }


    public void add(Item it ){
        item.add(it);
    }

    @AllArgsConstructor
    @Data
    public class Item {
        private String title;
        private String link;
        private String description;
        private String bloggerName;
        private String bloggerLink;

    }

}
