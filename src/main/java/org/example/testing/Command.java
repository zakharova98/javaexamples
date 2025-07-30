package org.example.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// Format:
// command arguments [priority]
// Example:
// command -v -a -c [5]
public class Command {

    private String command;
    private List<String> arguments;
    private int priority;

    public Command(String command, List<String> arguments, int priority) {
        this.command = command;
        this.arguments = arguments;
        this.priority = priority;
    }

    public Command(String command) {
        Pattern pattern = Pattern.compile("^([^-]*)?(-.*)?\\[([^]]*)?");
        Matcher matcher = pattern.matcher(command);
        this.arguments = new ArrayList<>();
        if (matcher.find()) {
            this.command = matcher.group(1).trim();
            this.priority = Integer.parseInt(matcher.group(3));

            String[] array = matcher.group(2).split("-");
            for (String arg : array) {
                if (!arg.isEmpty()) this.arguments.add(arg.trim());
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Command command1 = (Command) o;
        return priority == command1.priority && Objects.equals(command, command1.command) && Objects.equals(arguments, command1.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, arguments, priority);
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                ", arguments=" + arguments +
                ", priority=" + priority +
                '}';
    }
}
