package gray.c.one.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by jykang on 2016. 10. 20..
 */
@Data
public class Information {

    private Location location;
    private LocalDateTime time;

    @Data
    private class Location {

        private double x;
        private double y;
    }
}
