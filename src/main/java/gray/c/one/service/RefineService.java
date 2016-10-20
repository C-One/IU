package gray.c.one.service;

import gray.c.one.model.Information;
import org.springframework.stereotype.Service;

/**
 * Created by jykang on 2016. 10. 20..
 */
@Service
public class RefineService {

    public String refineMessage(Information information, String message){

        // TODO: 클라에서 받은 메시지를 원하는 값을 알맞게 정제 해서 리턴 해준다.


        return "대한민국 시간";
    }
}
