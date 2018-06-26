package com.programyourhome.adventureroom.common.module;

import java.util.Arrays;
import java.util.Collection;

import com.programyourhome.adventureroom.common.dsl.converters.WaitActionConverter;
import com.programyourhome.adventureroom.dsl.regex.AbstractRegexDslAdventureModule;
import com.programyourhome.adventureroom.dsl.regex.RegexActionConverter;

public class CommonAdventureModule extends AbstractRegexDslAdventureModule {

    public static final String ID = "common";

    private CommonConfig config;

    public CommonAdventureModule() {
        this.initConfig();
    }

    private void initConfig() {
        this.config = new CommonConfig();
        this.config.id = ID;
        this.config.name = "Common";
        this.config.description = "Module with common actions";
    }

    @Override
    public CommonConfig getConfig() {
        return this.config;
    }

    @Override
    protected Collection<RegexActionConverter<?>> getRegexActionConverters() {
        return Arrays.asList(new WaitActionConverter());
    }

    @Override
    public void stop() {
        // Nothing to do here.
    }

}
