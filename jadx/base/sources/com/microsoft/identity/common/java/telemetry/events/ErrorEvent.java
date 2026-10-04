package com.microsoft.identity.common.java.telemetry.events;

import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ErrorEvent extends BaseEvent {
    public static final String ERROR_TAG_PREFIX = "tag_";

    public ErrorEvent() {
        types(TelemetryEventStrings.EventType.ERROR_EVENT);
    }

    private String generateErrorTag(Exception exc, StackTraceElement stackTraceElement) {
        String string = exc.getClass().getSimpleName() + exc.getMessage() + stackTraceElement.getClassName() + stackTraceElement.getMethodName();
        if (exc instanceof BaseException) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(((BaseException) exc).getErrorCode());
            string = sbM1324q.toString();
        }
        return ERROR_TAG_PREFIX + (((long) string.hashCode()) + 2147483647L);
    }

    public ErrorEvent putException(Exception exc) {
        if (exc != null) {
            StackTraceElement[] stackTrace = exc.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StackTraceElement stackTraceElement = stackTrace[0];
                put(TelemetryEventStrings.Key.ERROR_TAG, generateErrorTag(exc, stackTraceElement));
                put(TelemetryEventStrings.Key.ERROR_LOCATION_CLASS_NAME, stackTraceElement.getClassName());
                put(TelemetryEventStrings.Key.ERROR_LOCATION_LINE_NUMBER, String.valueOf(stackTraceElement.getLineNumber()));
                put(TelemetryEventStrings.Key.ERROR_LOCATION_METHOD_NAME, stackTraceElement.getMethodName());
            }
            put(TelemetryEventStrings.Key.ERROR_CLASS_NAME, exc.getClass().getSimpleName());
            put(TelemetryEventStrings.Key.ERROR_DESCRIPTION, exc.getMessage());
            if (exc instanceof BaseException) {
                BaseException baseException = (BaseException) exc;
                if (baseException.getCause() != null) {
                    put(TelemetryEventStrings.Key.ERROR_CLASS_NAME, baseException.getCause().getClass().getSimpleName());
                }
                put("Microsoft.MSAL.error_code", baseException.getErrorCode());
                put(TelemetryEventStrings.Key.SERVER_ERROR_CODE, baseException.getCliTelemErrorCode());
                put(TelemetryEventStrings.Key.SERVER_SUBERROR_CODE, baseException.getCliTelemSubErrorCode());
            }
        }
        return this;
    }
}
