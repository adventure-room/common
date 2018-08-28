package com.programyourhome.adventureroom.module.common.dsl.converters;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.module.common.model.WaitAction;

public class WaitActionConverter implements RegexActionConverter<WaitAction> {

    @Override
    public Map<String, String> getRegexMap() {
        return this.createRegexes(DEFAULT, "(wait|sleep) " + INTEGER + " " + NAME);
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
