package com.zszdevelop.planman.event;


public class ExitRegisterEvent {
    private boolean isExit;

    public ExitRegisterEvent(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }
}
