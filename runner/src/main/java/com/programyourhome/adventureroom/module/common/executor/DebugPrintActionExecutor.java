package com.programyourhome.adventureroom.module.common.executor;

import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.module.common.model.DebugPrintAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;

public class DebugPrintActionExecutor implements ActionExecutor<DebugPrintAction> {

    @Override
    public void execute(DebugPrintAction action, ExecutionContext context) {
        System.out.println(action.message);
    }

    @Override
    public void stop(ExecutionContext context) {
        // Printing is instant, so no stop needed.
    }

}
