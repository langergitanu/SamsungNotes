package org.apache.commons.logging.impl;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.spi.AbstractLoggerAdapter;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerAdapter;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.util.StackLocatorUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Log4jApiLogFactory extends LogFactory {
    private static final String[] EMPTY_ARRAY = new String[0];
    private static final Marker MARKER = MarkerManager.getMarker("COMMONS-LOGGING");
    private final LoggerAdapter<Log> adapter = new LogAdapter();
    private final ConcurrentMap<String, Object> attributes = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Log4j2Log implements Log {
        private static final String FQCN = "org.apache.commons.logging.impl.Log4jApiLogFactory$Log4j2Log";
        private final ExtendedLogger logger;

        public Log4j2Log(ExtendedLogger extendedLogger) {
            this.logger = extendedLogger;
        }

        private boolean isEnabled(Level level) {
            return this.logger.isEnabled(level, Log4jApiLogFactory.MARKER, (String) null);
        }

        private void logIfEnabled(Level level, Object obj, Throwable th) {
            if (obj instanceof CharSequence) {
                this.logger.logIfEnabled(FQCN, level, Log4jApiLogFactory.MARKER, (CharSequence) obj, th);
            } else {
                this.logger.logIfEnabled(FQCN, level, Log4jApiLogFactory.MARKER, obj, th);
            }
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj) {
            logIfEnabled(Level.DEBUG, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj) {
            logIfEnabled(Level.ERROR, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj) {
            logIfEnabled(Level.FATAL, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj) {
            logIfEnabled(Level.INFO, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isDebugEnabled() {
            return isEnabled(Level.DEBUG);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isErrorEnabled() {
            return isEnabled(Level.ERROR);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isFatalEnabled() {
            return isEnabled(Level.FATAL);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isInfoEnabled() {
            return isEnabled(Level.INFO);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isTraceEnabled() {
            return isEnabled(Level.TRACE);
        }

        @Override // org.apache.commons.logging.Log
        public boolean isWarnEnabled() {
            return isEnabled(Level.WARN);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj) {
            logIfEnabled(Level.TRACE, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj) {
            logIfEnabled(Level.WARN, obj, null);
        }

        @Override // org.apache.commons.logging.Log
        public void debug(Object obj, Throwable th) {
            logIfEnabled(Level.DEBUG, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void error(Object obj, Throwable th) {
            logIfEnabled(Level.ERROR, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void fatal(Object obj, Throwable th) {
            logIfEnabled(Level.FATAL, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void info(Object obj, Throwable th) {
            logIfEnabled(Level.INFO, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void trace(Object obj, Throwable th) {
            logIfEnabled(Level.TRACE, obj, th);
        }

        @Override // org.apache.commons.logging.Log
        public void warn(Object obj, Throwable th) {
            logIfEnabled(Level.WARN, obj, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LogAdapter extends AbstractLoggerAdapter<Log> {
        private LogAdapter() {
        }

        public LoggerContext getContext() {
            return getContext(LogManager.getFactory().isClassLoaderDependent() ? StackLocatorUtil.getCallerClass(LogFactory.class) : null);
        }

        public Log newLogger(String str, LoggerContext loggerContext) {
            return new Log4j2Log(loggerContext.getLogger(str));
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        return (String[]) this.attributes.keySet().toArray(EMPTY_ARRAY);
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        try {
            this.adapter.close();
        } catch (IOException unused) {
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
        return (Log) this.adapter.getLogger(str);
    }
}
