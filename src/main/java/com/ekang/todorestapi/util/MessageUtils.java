package com.ekang.todorestapi.util;

import com.ekang.todorestapi.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {
    private final MessageSource messageSource;

    public MessageDto get(String key) {
        return new MessageDto(messageSource.getMessage(key, null, LocaleContextHolder.getLocale()));
    }

    public MessageDto get(String key, String... values) {
        return new MessageDto(messageSource.getMessage(key, values, LocaleContextHolder.getLocale()));
    }

    public String getString(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public String getString(String key, String ... values) {
        return messageSource.getMessage(key, values, LocaleContextHolder.getLocale());
    }
}
