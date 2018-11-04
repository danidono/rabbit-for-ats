
package cz.rohlik.smsprojekt.json_sms;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sms {

    private Auth auth;
    private List<Message> messages = new ArrayList<>();



}
