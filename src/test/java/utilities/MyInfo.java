package utilities;

import lombok.Data;

@Data
public class MyInfo {
    private String address;
    private String city;
    private String visa;


    public MyInfo() {
        this.address = "123 Fake Street";
        this.city = "Kochi";
        this.visa = "12345678910";
    }
}
