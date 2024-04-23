package de.christian2003.budgetplan;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;


    private final ExecutorService executorService;


    public App() {
        executorService = Executors.newFixedThreadPool(4);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }


    public static Context getContext() {
        return context;
    }

}
