package com.programyourhome.adventureroom.module.common.executor;

import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.module.common.model.WaitAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;

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
