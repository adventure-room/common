package com.programyourhome.adventureroom.module.common.executor;

import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.module.common.model.StartScriptAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;

public class StartScriptActionExecutor implements ActionExecutor<StartScriptAction> {

    @Override
    public void execute(StartScriptAction action, ExecutionContext context) {
        // Always start a new script async.
        new Thread(() -> {
            Adventure adventure = context.getAdventure();
            context.getToolbox().getAdventureService().startScript(adventure, adventure.getScript(action.scriptName));
        }).start();
    }

    @Override
    public void stop(ExecutionContext context) {
        // Script is started async, so no stop implementation needed.
    }

}
