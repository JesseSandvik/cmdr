package com.sp3.cmdr;

import com.sp3.cmdr.models.Option;
import com.sp3.cmdr.models.PositionalParameter;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

public interface ICommand extends Callable<Integer> {
    Properties getProperties();
    void setProperties(Properties properties);
    String getName();
    void setName(String name);
    String getVersion();
    void setVersion(String version);
    String getSynopsis();
    void setSynopsis(String synopsis);
    String getDescription();
    void setDescription(String description);
    Boolean getExecutesWithoutArguments();
    void setExecutesWithoutArguments(Boolean executesWithoutArguments);
    String[] getOriginalArguments();
    void setOriginalArguments(String[] originalArguments);
    List<PositionalParameter> getPositionalParameters();
    void addPositionalParameter(PositionalParameter positionalParameter);
    List<Option> getOptions();
    void addOption(Option option);
    List<Command> getSubcommands();
    void addSubcommand(Command subcommand);
    Integer call();
}
