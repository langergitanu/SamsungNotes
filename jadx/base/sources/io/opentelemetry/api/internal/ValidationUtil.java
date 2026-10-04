package io.opentelemetry.api.internal;

import androidx.appcompat.widget.AbstractC0541b;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ValidationUtil {
    public static final String API_USAGE_LOGGER_NAME = "io.opentelemetry.ApiUsageLogging";
    private static final Logger API_USAGE_LOGGER = Logger.getLogger(API_USAGE_LOGGER_NAME);
    private static final Pattern VALID_INSTRUMENT_NAME_PATTERN = Pattern.compile("([A-Za-z]){1}([A-Za-z0-9\\_\\-\\.]){0,62}");

    private ValidationUtil() {
    }

    public static boolean checkValidInstrumentName(String str) {
        return checkValidInstrumentName(str, "");
    }

    public static boolean checkValidInstrumentUnit(String str) {
        return checkValidInstrumentUnit(str, "");
    }

    public static void log(String str) {
        log(str, Level.FINEST);
    }

    public static boolean checkValidInstrumentName(String str, String str2) {
        if (str != null && VALID_INSTRUMENT_NAME_PATTERN.matcher(str).matches()) {
            return true;
        }
        log(AbstractC0541b.m774p("Instrument name \"", str, "\" is invalid, returning noop instrument. Instrument names must consist of 63 or fewer characters including alphanumeric, _, ., -, and start with a letter.", str2), Level.WARNING);
        return false;
    }

    public static boolean checkValidInstrumentUnit(String str, String str2) {
        if (str != null && !str.equals("") && str.length() < 64 && StandardCharsets.US_ASCII.newEncoder().canEncode(str)) {
            return true;
        }
        log(AbstractC0541b.m774p("Unit \"", str, "\" is invalid. Instrument unit must be 63 or fewer ASCII characters.", str2), Level.WARNING);
        return false;
    }

    public static void log(String str, Level level) {
        Logger logger = API_USAGE_LOGGER;
        if (logger.isLoggable(level)) {
            logger.log(level, str, (Throwable) new AssertionError());
        }
    }
}
