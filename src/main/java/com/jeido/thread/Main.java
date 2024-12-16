package com.jeido.thread;

import com.jeido.thread.ui.ExerciseLogger;

public class Main {
    public static void main(String[] args) {
        ExerciseLogger el = ExerciseLogger.getInstance();
        el.menu();
    }
}