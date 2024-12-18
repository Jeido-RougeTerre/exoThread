package com.jeido.thread.exercises.exercise13;

import com.jeido.thread.ui.Ansi;

import java.util.ArrayList;
import java.util.List;


public class SharedResource {
    private final List<Integer> list = new ArrayList<>();

    public void getList() {
        System.out.printf("Final state of list : %s%n", list);
    }

    public void add(Integer value) {
        list.add(value);
        System.out.printf("%s%s added %d%s%n", Ansi.GREEN.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
    }

    public void remove(Integer value) {
        if (list.contains(value)) {
            list.remove(value);
            System.out.printf("%s%s removed %d%s%n", Ansi.RED.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
        } else {
            System.out.printf("%s%s couldn't remove %d%s%n", Ansi.RED_BOLD.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
        }
    }
}
