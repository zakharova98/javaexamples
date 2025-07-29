package org.example.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewObject {

    private String name;
    private UUID uuid;
    private int priority;
    private List<Command> commands;

    public NewObject(String name, UUID uuid, int priority) {
        this.name = name;
        this.uuid = uuid;
        this.priority = priority;
        commands = new ArrayList<Command>();
    }

    public void addCommand(Command command) {
        if (commands == null) commands = new ArrayList<>();
        commands.add(command);
    }

}
