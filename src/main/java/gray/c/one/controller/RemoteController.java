package gray.c.one.controller;

import com.sun.org.apache.xerces.internal.util.HTTPInputSource;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import gray.c.one.model.Information;
import gray.c.one.service.RefineService;
import gray.c.one.service.SearchService;
import gray.c.one.util.InputCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jykang on 2016. 10. 20..
 */
@RestController
public class RemoteController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RefineService refineService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> receiveController(@RequestBody Information information,
                                                    @RequestParam("message") String message) {

        if (InputCheck.check(message)) {

            String refineMessage = refineService.refineMessage(information, message);

            String result = searchService.search(refineMessage);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

}













