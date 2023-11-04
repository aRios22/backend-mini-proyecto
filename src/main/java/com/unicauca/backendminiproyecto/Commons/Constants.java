package com.unicauca.backendminiproyecto.Commons;

public final class Constants {

    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    //EXCEPCIONES
    public static final Integer STATUS_BAD_REQUEST = 400;
    public static final String APPLICATION_EXCEPTION = "Application Exception";
    public static final String DATA_EXCEPTION = "Data Exception";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "Constraint Violation Exception";
    public static final String ARGUMENT_VIOLATION_EXCEPTION = "Argument Violation Exception";

    //SIMBOLOS
    public static final String ESPACIO_EN_BLANCO = " ";

    //GENERAL
    public static final String UTILITY_CLASS = "Utility class";

    //storage
    public static final String FILES_DIRECTION="/opt/data/";

}