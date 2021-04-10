package ru.kpfu.itis.tyapa.filemanager;

public abstract class AbstractApp {

    public AbstractApp(){
        init();
        start();
    }

    protected abstract void init();
    protected abstract void start();
}
