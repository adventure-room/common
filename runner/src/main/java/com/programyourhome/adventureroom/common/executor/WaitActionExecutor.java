package com.programyourhome.adventureroom.common.executor;

import com.programyourhome.adventureroom.common.model.WaitAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;
import com.programyourhome.iotadventure.runner.context.ExecutionContext;

public class WaitActionExecutor implements ActionExecutor<WaitAction> {

    @Override
    public void execute(WaitAction action, ExecutionContext context) {
        try {
            Thread.sleep(action.duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
