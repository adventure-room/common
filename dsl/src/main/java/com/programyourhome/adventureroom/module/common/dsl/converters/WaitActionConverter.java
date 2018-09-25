package com.programyourhome.adventureroom.module.common.dsl.converters;

import java.util.Map;

import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.module.common.model.WaitAction;

public class WaitActionConverter implements RegexActionConverter<WaitAction> {

    @Override
    public Map<String, String> getRegexMap() {
        return this.createRegexes(DEFAULT, this.either("wait", "sleep") + " " + DURATION);
    }

    @Override
    public WaitAction convert(MatchResult matchResult, Adventure adventure) {
        WaitAction action = new WaitAction();
        action.duration = this.parseDuration(matchResult.getValue(DURATION));
        return action;
    }

}
