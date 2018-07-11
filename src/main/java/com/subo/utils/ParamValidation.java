package com.subo.utils;

import com.subo.exception.ParametersMissException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParamValidation {

    public static final Logger logger = LoggerFactory.getLogger(ParamValidation.class);

    public static void validateRequiredData(Map<String, String> parameterInfos) throws ValidationException {
        String emptyParameterStr;
        StringBuffer emptyParameters = new StringBuffer();
        Set<String> parameters = parameterInfos.keySet();
        Iterator<String> iter = parameters.iterator();
        String parameter;
        String value;
        logger.info("iterator start");
        logger.info("param value start append");
        while (iter.hasNext()) {
            parameter = iter.next();
            value = parameterInfos.get(parameter);
            if (!(hasValidData(value))) {
                emptyParameters.append(parameter).append(",");
            }
        }

        if (emptyParameters != null) {
            emptyParameterStr = emptyParameters.toString();
            if (emptyParameterStr != null && emptyParameterStr.trim().length() > 0) {
                emptyParameterStr = emptyParameterStr.substring(0, emptyParameterStr.length() - 1);
                logger.info("Mandatory parameters missing");
                throw new ParametersMissException("Mandatory parameters missing:" + emptyParameterStr);
            }
        }
    }

    public static String validateRequiredDataMsg(Map<String, String> parameterInfos) {
        String emptyParameterStr;
        StringBuffer emptyParameters = new StringBuffer();
        Set<String> parameters = parameterInfos.keySet();
        Iterator<String> iter = parameters.iterator();
        String parameter;
        String value;
        logger.info("iterator start");
        logger.info("param value start append");
        while (iter.hasNext()) {
            parameter = iter.next();
            value = parameterInfos.get(parameter);
            if (!(hasValidData(value))) {
                emptyParameters.append(parameter).append(",");
            }
        }

        if (emptyParameters != null) {
            emptyParameterStr = emptyParameters.toString();
            if (emptyParameterStr != null && emptyParameterStr.trim().length() > 0) {
                emptyParameterStr = emptyParameterStr.substring(0, emptyParameterStr.length() - 1);
                logger.info("Mandatory parameters missing");
                return "Mandatory parameters missing:" + emptyParameterStr;
            }
        }

        return null;
    }


    public static void atLeastOneOfParams(Map<String, String> parameterValues)
            throws ValidationException {
        boolean validSearchForProvisioning = false;
        StringBuffer emptyValue = new StringBuffer();
        String emptyValueStr;
        Set<String> parameters = parameterValues.keySet();
        Iterator<String> iter = parameters.iterator();
        String key;
        String value;

        logger.info("param value start append");
        while (iter.hasNext()) {
            key = iter.next();
            value = parameterValues.get(key);
            if (value != null && value.trim().length() >= 0) {
                validSearchForProvisioning = true;
            }
            emptyValue.append(key).append(",");
        }
        if (!(validSearchForProvisioning)) {
            if (emptyValue != null) {
                emptyValueStr = emptyValue.toString();
                if (emptyValueStr != null && emptyValueStr.trim().length() > 0) {
                    emptyValueStr = emptyValueStr.substring(0, emptyValueStr.length() - 1);
                    logger.info("parameters are all empty");
                    throw new ParametersMissException(
                            " At least one of the following parameters must be contained:" + emptyValueStr);
                }
            }
        }
    }

    public static String atLeastOneOfParamsMsg(Map<String, String> parameterValues) {
        boolean validSearchForProvisioning = false;
        StringBuffer emptyValue = new StringBuffer();
        String emptyValueStr;
        Set<String> parameters = parameterValues.keySet();
        Iterator<String> iter = parameters.iterator();
        String key;
        String value;

        logger.info("param value start append");
        while (iter.hasNext()) {
            key = iter.next();
            value = parameterValues.get(key);
            if (value != null && value.trim().length() >= 0) {
                validSearchForProvisioning = true;
            }
            emptyValue.append(key).append(",");
        }
        if (!(validSearchForProvisioning)) {
            if (emptyValue != null) {
                emptyValueStr = emptyValue.toString();
                if (emptyValueStr != null && emptyValueStr.trim().length() > 0) {
                    emptyValueStr = emptyValueStr.substring(0, emptyValueStr.length() - 1);
                    logger.info("parameters are all empty");
                    return " At least one of the following parameters must be contained:" + emptyValueStr;
                }
            }
        }
        return null;
    }

    public static boolean hasValidData(String value) {
        return value != null && value.trim().length() != 0 && !"null".equalsIgnoreCase(value);
    }

}
