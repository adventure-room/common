package com.programyourhome.adventureroom.module.common.dsl.converters;

import java.util.Map;

import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.dsl.regex.RegexVariable;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.module.common.model.StartScriptAction;

public class StartScriptActionConverter implements RegexActionConverter<StartScriptAction> {

    private static final RegexVariable SCRIPT_NAME = WORD.withName("scriptName");

    @Override
    public Map<String, String> getRegexMap() {
        return this.createRegexes(DEFAULT, "start script " + SCRIPT_NAME);
    }

    @Override
    public StartScriptAction convert(MatchResult matchResult, Adventure adventure) {
        StartScriptAction action = new StartScriptAction();
        // We cannot get the 'real' script object at this moment yet, because when this code is called, script parsing is in progress.
        action.scriptName = matchResult.getValue(SCRIPT_NAME);
        return action;
    }

}
