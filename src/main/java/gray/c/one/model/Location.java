package gray.c.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jykang on 2016. 10. 26..
 */
@Data
@AllArgsConstructor
public class Location {
    private double x;
    private double y;

    public Location(){}
}
