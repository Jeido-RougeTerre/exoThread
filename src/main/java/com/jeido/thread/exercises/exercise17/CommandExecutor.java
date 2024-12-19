package com.jeido.thread.exercises.exercise17;

import java.util.List;

public class CommandExecutor implements Runnable {
    private List<Command> commands;

    public CommandExecutor(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void run() {
        for (Command command : commands) {
            command.buy();
        }
    }
}
