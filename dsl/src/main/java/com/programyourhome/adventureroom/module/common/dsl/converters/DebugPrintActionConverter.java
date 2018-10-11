package com.programyourhome.adventureroom.module.common.dsl.converters;

import java.util.Map;

import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.module.common.model.DebugPrintAction;

public class DebugPrintActionConverter implements RegexActionConverter<DebugPrintAction> {

    @Override
    public Map<String, String> getRegexMap() {
        return this.createRegexes(DEFAULT, "debug print " + TEXT);
    }

    @Override
    public DebugPrintAction convert(MatchResult matchResult, Adventure adventure) {
        DebugPrintAction action = new DebugPrintAction();
        action.message = matchResult.getValue(TEXT);
        return action;
    }

}
