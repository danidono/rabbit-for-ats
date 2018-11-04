
package cz.rohlik.smsprojekt.json_sms;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

    public String method;
    @JsonProperty("msg_type")
    public String msgType;
    public String uniq;
    @JsonProperty("text_sender")
    public String textSender;
    public String sender;
    public String recipient;
    public Integer dlr;
    public Integer validity;
    public Integer priority;
    public String opmid;
    public String kw;
    public String text;
    public String url;
    public List<Parts> parts = new ArrayList<>();

}
