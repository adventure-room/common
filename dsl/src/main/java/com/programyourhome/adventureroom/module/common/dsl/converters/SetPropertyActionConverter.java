package com.programyourhome.adventureroom.module.common.dsl.converters;

import java.util.Map;

import com.programyourhome.adventureroom.dsl.regex.MatchResult;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;
import com.programyourhome.adventureroom.dsl.regex.RegexVariable;
import com.programyourhome.adventureroom.model.Adventure;
import com.programyourhome.adventureroom.module.common.model.SetPropertyAction;

public class SetPropertyActionConverter implements RegexActionConverter<SetPropertyAction> {

    private static final RegexVariable PROPERTY_NAME = NAME_WITH_DASHES.withName("propertyName");
    private static final RegexVariable PROPERTY_VALUE = NAME.withName("propertyValue");

    @Override
    public Map<String, String> getRegexMap() {
        return this.createRegexes(DEFAULT, "set " + PROPERTY_NAME + " to " + PROPERTY_VALUE);
    }

    @Override
    public SetPropertyAction convert(MatchResult matchResult, Adventure adventure) {
        SetPropertyAction action = new SetPropertyAction();
        action.name = matchResult.getValue(PROPERTY_NAME);
        action.value = matchResult.getValue(PROPERTY_VALUE);
        return action;
    }

}
