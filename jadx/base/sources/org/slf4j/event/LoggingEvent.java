package org.slf4j.event;

import java.util.List;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface LoggingEvent {
    Object[] getArgumentArray();

    List<Object> getArguments();

    default String getCallerBoundary() {
        return null;
    }

    List<KeyValuePair> getKeyValuePairs();

    Level getLevel();

    String getLoggerName();

    List<Marker> getMarkers();

    String getMessage();

    String getThreadName();

    Throwable getThrowable();

    long getTimeStamp();
}
