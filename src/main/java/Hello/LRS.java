package Hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@RestController
public class LRS {
    public static void main(String[] args) {
        SpringApplication.run(LRS.class, args);
    }

    ArrayList<String> arr;
    int MethArrCount = 0;
    HashMap<String, String> hash;
    int MethHashCount = 0;

    @GetMapping("/update-array")
    public String UAL(@RequestParam("arg") String arg) {
        ++MethArrCount;
        if (MethArrCount == 1) {
            arr = new ArrayList<>();
            arr.add(arg);
        } else arr.add(arg);
        return "Success!";
    }

    @GetMapping("/show-array")
    public String SAL(@RequestParam(defaultValue = " ") String arg) {
        if (MethArrCount > 0) return String.valueOf(arr);
        else return ("The array is empty yet!");
    }

    @GetMapping("/update-map")
    public String UHS(@RequestParam("arg1") String arg1,@RequestParam("arg2") String arg2) {
        ++MethHashCount;
        if (MethHashCount == 1) {
            hash = new HashMap<>();
            hash.put(arg1, arg2);
        } else hash.put(arg1, arg2);
        return "Success!";
    }

    @GetMapping("/show-map")
    public String SHM(@RequestParam(defaultValue = " ") String arg) {
        if (MethHashCount > 0) return String.valueOf(hash);
        else return ("The map is empty yet!");
    }

    @GetMapping("/show-all-length")
    public String SHAL(@RequestParam(defaultValue = " ") String arg) {
        if (MethHashCount > 0 & MethArrCount > 0) {
            return List.of(arr,hash).toString();
        }
        if (MethHashCount > 0 & MethArrCount < 1) {
            return String.valueOf(hash);
        }
        if (MethHashCount < 1 & MethArrCount > 0) {
            return String.valueOf(arr);
        }
        else return ("The array and map is empty yet!");
    }
}