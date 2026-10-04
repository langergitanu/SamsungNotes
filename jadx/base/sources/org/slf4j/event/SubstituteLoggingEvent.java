package org.slf4j.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SubstituteLoggingEvent implements LoggingEvent {
    Object[] argArray;
    List<KeyValuePair> keyValuePairList;
    Level level;
    SubstituteLogger logger;
    String loggerName;
    List<Marker> markers;
    String message;
    String threadName;
    Throwable throwable;
    long timeStamp;

    public void addMarker(Marker marker) {
        if (marker == null) {
            return;
        }
        if (this.markers == null) {
            this.markers = new ArrayList(2);
        }
        this.markers.add(marker);
    }

    @Override // org.slf4j.event.LoggingEvent
    public Object[] getArgumentArray() {
        return this.argArray;
    }

    @Override // org.slf4j.event.LoggingEvent
    public List<Object> getArguments() {
        Object[] objArr = this.argArray;
        if (objArr == null) {
            return null;
        }
        return Arrays.asList(objArr);
    }

    @Override // org.slf4j.event.LoggingEvent
    public List<KeyValuePair> getKeyValuePairs() {
        return this.keyValuePairList;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Level getLevel() {
        return this.level;
    }

    public SubstituteLogger getLogger() {
        return this.logger;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override // org.slf4j.event.LoggingEvent
    public List<Marker> getMarkers() {
        return this.markers;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getMessage() {
        return this.message;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getThreadName() {
        return this.threadName;
    }

    @Override // org.slf4j.event.LoggingEvent
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // org.slf4j.event.LoggingEvent
    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setArgumentArray(Object[] objArr) {
        this.argArray = objArr;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setLogger(SubstituteLogger substituteLogger) {
        this.logger = substituteLogger;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }
}
