package com.programyourhome.adventureroom.module.common.executor;

import com.programyourhome.adventureroom.model.execution.ExecutionContext;
import com.programyourhome.adventureroom.module.common.model.SetPropertyAction;
import com.programyourhome.iotadventure.runner.action.executor.ActionExecutor;

public class SetPropertyActionExecutor implements ActionExecutor<SetPropertyAction> {

    @Override
    public void execute(SetPropertyAction action, ExecutionContext context) {
        if (!context.isPropertyDefined(action.name)) {
            throw new IllegalStateException("Can only update values of existing properties. For new values to store, use variables.");
        }
        Object currentValue = context.getPropertyValue(action.name);
        Class<?> valueClass = currentValue.getClass();
        Object convertedValue = context.getToolbox().getConversionService().convert(currentValue, valueClass);
        context.setPropertyValue(action.name, convertedValue);
    }

    @Override
    public void stop(ExecutionContext context) {
        // Since the execute is non-blocking and non time consuming, there is no need for an explicit stop implementation.
    }

}
