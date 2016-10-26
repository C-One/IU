package gray.c.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by jykang on 2016. 10. 20..
 */
@Data
@AllArgsConstructor
public class Information {

    private Location location;
    private String time;

    public Information(){}
}
