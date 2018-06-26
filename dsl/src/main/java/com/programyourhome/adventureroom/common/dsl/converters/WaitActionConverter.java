package com.programyourhome.adventureroom.common.dsl.converters;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.programyourhome.adventureroom.common.model.WaitAction;
import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.model.Adventure;

public class WaitActionConverter implements RegexActionConverter<WaitAction> {

    @Override
    public String getRegexLine() {
        return "wait " + INTEGER + " " + NAME;
    }

    @Override
    public WaitAction convert(MatchResult matchResult, Adventure adventure) {
        WaitAction action = new WaitAction();
        String temporalTypeString = matchResult.getValue(NAME);
        ChronoUnit chronoUnit = ChronoUnit.valueOf(temporalTypeString.toUpperCase());
        long amount = Long.parseLong(matchResult.getValue(INTEGER));
        action.duration = Duration.of(amount, chronoUnit);
        return action;
    }

}
