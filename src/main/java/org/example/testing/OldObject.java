package org.example.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OldObject {

    private String name;
    private UUID uuid;
    private int priority;
    private List<String> commands;

    public OldObject(String name, int priority) {
        this.name = name;
        this.priority = priority;
        uuid = UUID.randomUUID();
        commands = new ArrayList<String>();
    }

    public void addCommand(String command) {
        if (commands == null) commands = new ArrayList<>();
        commands.add(command);
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public List<String> getCommands() {
        return commands;
    }
}
