package com.jeido.thread.exercises.exercise12;

import com.jeido.thread.ui.Ansi;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private static final List<Integer> list = new ArrayList<>();
    private static final Object lock = new Object();

    public static void getList() {
        System.out.printf("Final state of list : %s%n", list);
    }

    public static void add(Integer value) {
        synchronized (lock) {
            list.add(value);
            System.out.printf("%s%s added %d%s%n", Ansi.GREEN.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
        }
    }

    public static void remove(Integer value) {
        synchronized (lock) {
            if (list.contains(value)) {
                list.remove(value);
                System.out.printf("%s%s removed %d%s%n", Ansi.RED.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
            } else {
                System.out.printf("%s%s couldn't remove %d%s%n", Ansi.RED_BOLD.getCode(), Thread.currentThread().getName(), value, Ansi.RESET.getCode());
            }
        }
    }
}
