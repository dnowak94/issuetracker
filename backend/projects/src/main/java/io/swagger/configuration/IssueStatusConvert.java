package io.swagger.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.swagger.model.IssueStatus;

@Component
public class IssueStatusConvert  implements Converter<String, IssueStatus> {
    @Override
    public IssueStatus convert(String value) {
        return IssueStatus.fromValue(value);
    }
}
