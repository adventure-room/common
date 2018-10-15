package com.programyourhome.adventureroom.module.common.executor;

import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.model.util.IOUtil;
import com.programyourhome.adventureroom.module.common.model.WaitAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;

public class WaitActionExecutor implements ActionExecutor<WaitAction> {

    private boolean shouldStop;

    public WaitActionExecutor() {
        this.shouldStop = false;
    }

    @Override
    public void execute(WaitAction action, ExecutionContext context) {
        IOUtil.waitMillisWithCondition(action.duration.toMillis(), () -> this.shouldStop);
    }

    @Override
    public void stop(ExecutionContext context) {
        this.shouldStop = true;
    }

}
