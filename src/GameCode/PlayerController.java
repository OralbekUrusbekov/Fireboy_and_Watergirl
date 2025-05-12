package GameCode;

import java.util.HashMap;
import java.util.Map;

public class PlayerController {
    private Map<Character, Command> keyBindings = new HashMap<>();

    public void bindKey(char key, Command command) {
        keyBindings.put(key, command);
    }

    public void keyPressed(char key) {
        if (keyBindings.containsKey(key)) {
            keyBindings.get(key).execute();
        }
    }
}
