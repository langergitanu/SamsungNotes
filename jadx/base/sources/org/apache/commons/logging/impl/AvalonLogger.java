package org.apache.commons.logging.impl;

import java.util.Objects;
import org.apache.avalon.framework.logger.Logger;
import org.apache.commons.logging.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class AvalonLogger implements Log {
    private static volatile Logger defaultLogger;
    private final transient Logger logger;

    public AvalonLogger(Logger logger) {
        this.logger = logger;
    }

    public static void setDefaultLogger(Logger logger) {
        defaultLogger = logger;
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj) {
        if (getLogger().isFatalErrorEnabled()) {
            getLogger().fatalError(String.valueOf(obj));
        }
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        return getLogger().isErrorEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        return getLogger().isFatalErrorEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        return getLogger().isDebugEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
        return getLogger().isWarnEnabled();
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(String.valueOf(obj));
        }
    }

    public AvalonLogger(String str) {
        Objects.requireNonNull(defaultLogger, "defaultLogger");
        this.logger = defaultLogger.getChildLogger(str);
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
        if (getLogger().isFatalErrorEnabled()) {
            getLogger().fatalError(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(String.valueOf(obj), th);
        }
    }
}
