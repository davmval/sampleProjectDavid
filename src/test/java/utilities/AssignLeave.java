package utilities;

import lombok.Data;

@Data
public class AssignLeave {
    private String completeName;

    public AssignLeave() {
        this.completeName = "John Smith";
    }
    public AssignLeave(String completeName) {
        this.completeName = completeName;
    }
}
