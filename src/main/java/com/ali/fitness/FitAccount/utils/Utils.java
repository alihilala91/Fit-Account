package com.ali.fitness.FitAccount.utils;

import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public class Utils {


    /**
     * Check the Request Locale if null return the Default Locale (English)
     *
     * @param request HttpServletRequest
     * @return Locale
     */
    public static Locale getLocale(final HttpServletRequest request) {

        // Validate The Request null
        if (request != null && request.getLocale() != null) {
            return request.getLocale();
        }

        // Return the Default Locale as English
        return Locale.ENGLISH;

    }

    /**
     * Format Mobile number in Stander Format
     *
     * @param mobile Mobile
     * @param locale Locale
     * @return String
     */
    public static String formatMobileNumber(final String mobile, final Locale locale) {

        try {

            // ToDo Format Mobile Number
            return mobile;
        } catch (final Exception e) {
            throw new ResourceException(ExceptionKey.FAILED_FORMAT_MOBILE_NUMBER, HttpStatus.NOT_FOUND, locale);
        }
    }

    /**
     * Convert String Value to UpperCase
     *
     * @param value  Value
     * @param locale Locale
     * @return String
     */
    public static String convertToUpper(final String value, final Locale locale) {

        try {
            if (value == null || value.isEmpty()) {
                return value;
            }
            return value.toUpperCase(locale).trim();
        } catch (final Exception e) {
            return value;
        }

    }
}
