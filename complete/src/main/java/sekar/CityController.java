package sekar;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping("/connected")
    public String connected(@RequestParam(value="origin") String city1, @RequestParam(value="destination") String city2) {

        String result = "No";
        if(city1 == null || city1.isEmpty()) throw new IllegalArgumentException("Need City1");
        if(city2 == null || city2.isEmpty()) throw new IllegalArgumentException("Need City2");
    try {
        boolean checkStatus = CityUtil.checkCityPresence(city1, city2);
        System.out.println("Test" + checkStatus);
        result = checkStatus ? "Yes" : "No";
    }
    catch(Exception ex)
    {
        System.out.println("Exception Occured" + ex.getMessage());
    }

        return result;
    }
}
