package org.allsafeclinic.hospitaladministration.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ErrorCodes
 */
public class ErrorCodes {

    public enum ERROR_CODES{

        ERR_NOT_FOUND,
        ERR_VALIDATION_FAILURE,

    };
    public enum Gender { M,F,T};
    public static final String Gender2String = Stream.of(Gender.values()).map(Gender::name).
            collect(Collectors.joining(",","{","}"));

    public static final String  VALIDATION_FAILURE= "ERR";
    public static final String USER_NOT_FOUND="Staff not found in registry";
    public static final String INVALID_GENDER="gender value invalid";
    public static final String EMPTY_MESSAGE_BODY="Invalid message body";
    public static final String INVALID_EMAIL="Invalid email format";
    public static final String INVALID_AGE="Invalid age";
    public static final String INVALID_PHONE="Invalid phoneNumber format";
    public static final String MANDATORY_MISSING="Mandatory fields missing ";

}