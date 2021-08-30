package ru.rahimyanov_aleks.KFClimat.exceptions;

import org.springframework.dao.DataAccessException;

public class CustomEmptyDataException extends DataAccessException {
    public CustomEmptyDataException(String msg) {
        super(msg);
    }

    public CustomEmptyDataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
