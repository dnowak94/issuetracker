package io.swagger.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.swagger.model.TaskStatus;

@Component
public class TaskStatusConverter implements Converter<String, TaskStatus> {
    @Override
    public TaskStatus convert(String value) {
        return TaskStatus.fromValue(value);
    }
}
