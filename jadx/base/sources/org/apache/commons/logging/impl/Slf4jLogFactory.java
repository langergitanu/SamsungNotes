package org.apache.commons.logging.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.C13833a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Slf4jLogFactory extends LogFactory {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final Marker MARKER = MarkerFactory.getMarker("COMMONS-LOGGING");
    private final ConcurrentMap<String, Log> loggers = new ConcurrentHashMap();
    private final ConcurrentMap<String, Object> attributes = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Slf4jLocationAwareLog implements Log {
        private static final String FQCN = "org.apache.commons.logging.impl.Slf4jLogFactory$Slf4jLocationAwareLog";
        private final LocationAwareLogger logger;

        public Slf4jLocationAwareLog(LocationAwareLogger locationAwareLogger) {
            this.logger = locationAwareLogger;
        }

        private void log(int i, Object obj, Throwable th) {
            this.logger.log(Slf4jLogFactory.MARKER, FQCN, i, String.valueOf(obj), Slf4jLogFactory.EMPTY_OBJECT_ARRAY, th);
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj) {
            log(10, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj) {
            log(40, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj) {
            error(obj);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj) {
            log(20, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isDebugEnabled() {
            return this.logger.isDebugEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isErrorEnabled() {
            return this.logger.isErrorEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isFatalEnabled() {
            return isErrorEnabled();
        }

        @Override // org.apache.commons.logging.Log
        public boolean isInfoEnabled() {
            return this.logger.isInfoEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isTraceEnabled() {
            return this.logger.isTraceEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isWarnEnabled() {
            return this.logger.isWarnEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj) {
            log(0, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj) {
            log(30, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj, Throwable th) {
            log(10, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj, Throwable th) {
            log(40, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj, Throwable th) {
            error(obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj, Throwable th) {
            log(20, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj, Throwable th) {
            log(0, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj, Throwable th) {
            log(30, obj, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Slf4jLog implements Log {
        private final Logger logger;

        public Slf4jLog(Logger logger) {
            this.logger = logger;
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj) {
            this.logger.debug(Slf4jLogFactory.MARKER, String.valueOf(obj));
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj) {
            this.logger.error(Slf4jLogFactory.MARKER, String.valueOf(obj));
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj) {
            error(obj);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj) {
            this.logger.info(Slf4jLogFactory.MARKER, String.valueOf(obj));
        }

        @Override // org.apache.commons.logging.Log
        public boolean isDebugEnabled() {
            return this.logger.isDebugEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isErrorEnabled() {
            return this.logger.isErrorEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isFatalEnabled() {
            return isErrorEnabled();
        }

        @Override // org.apache.commons.logging.Log
        public boolean isInfoEnabled() {
            return this.logger.isInfoEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isTraceEnabled() {
            return this.logger.isTraceEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isWarnEnabled() {
            return this.logger.isWarnEnabled(Slf4jLogFactory.MARKER);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj) {
            this.logger.trace(Slf4jLogFactory.MARKER, String.valueOf(obj));
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj) {
            this.logger.warn(Slf4jLogFactory.MARKER, String.valueOf(obj));
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj, Throwable th) {
            this.logger.debug(Slf4jLogFactory.MARKER, String.valueOf(obj), th);
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj, Throwable th) {
            this.logger.debug(Slf4jLogFactory.MARKER, String.valueOf(obj), th);
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj, Throwable th) {
            error(obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj, Throwable th) {
            this.logger.info(Slf4jLogFactory.MARKER, String.valueOf(obj), th);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj, Throwable th) {
            this.logger.trace(Slf4jLogFactory.MARKER, String.valueOf(obj), th);
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj, Throwable th) {
            this.logger.warn(Slf4jLogFactory.MARKER, String.valueOf(obj), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Log lambda$getInstance$0(String str) {
        Logger logger = LoggerFactory.getLogger(str);
        return logger instanceof LocationAwareLogger ? new Slf4jLocationAwareLog((LocationAwareLogger) logger) : new Slf4jLog(logger);
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        return (String[]) this.attributes.keySet().toArray(EMPTY_STRING_ARRAY);
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
        try {
            iLoggerFactory.getClass().getMethod("stop", null).invoke(iLoggerFactory, null);
        } catch (ReflectiveOperationException unused) {
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String str, Object obj) {
        if (obj != null) {
            this.attributes.put(str, obj);
        } else {
            removeAttribute(str);
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) {
        return this.loggers.computeIfAbsent(str, new C13833a(11));
    }
}
