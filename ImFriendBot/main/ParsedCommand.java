import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ParsedCommand {
   Command command = Command.NONE;
   String text = "";

    ParsedCommand(Command command, String text) {
       super();
    }
    ParsedCommand() {
        super();
    }

    public Command getCommand() {
        return command;
    }

    public String getText() {
        return text;
    }

    public void setCommand(Command notforme) {
        command=notforme;
    }

    public void setText(Command value) {
        command=value;
    }

    public void setText(String value) {
        text=value;
    }
}
