package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.log.Hierarchy;
import org.apache.log.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class LogKitLogger implements Log, Serializable {
    private static final long serialVersionUID = 3768538055836059519L;
    protected volatile transient Logger logger = getLogger();
    protected String name;

    public LogKitLogger(String str) {
        this.name = str;
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj) {
        if (obj != null) {
            getLogger().debug(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj) {
        if (obj != null) {
            getLogger().error(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj) {
        if (obj != null) {
            getLogger().fatalError(String.valueOf(obj));
        }
    }

    public Logger getLogger() {
        Logger loggerFor;
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            try {
                loggerFor = this.logger;
                if (loggerFor == null) {
                    loggerFor = Hierarchy.getDefaultHierarchy().getLoggerFor(this.name);
                    this.logger = loggerFor;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return loggerFor;
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj) {
        if (obj != null) {
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
        debug(obj);
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj) {
        if (obj != null) {
            getLogger().warn(String.valueOf(obj));
        }
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        if (obj != null) {
            getLogger().debug(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        if (obj != null) {
            getLogger().error(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
        if (obj != null) {
            getLogger().fatalError(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        if (obj != null) {
            getLogger().info(String.valueOf(obj), th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        debug(obj, th);
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        if (obj != null) {
            getLogger().warn(String.valueOf(obj), th);
        }
    }
}
