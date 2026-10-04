package io.netty.util.internal.logging;

import org.slf4j.spi.LocationAwareLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class LocationAwareSlf4JLogger extends AbstractInternalLogger {
    static final String FQCN = "io.netty.util.internal.logging.LocationAwareSlf4JLogger";
    private static final long serialVersionUID = -8292030083201538180L;
    private final transient LocationAwareLogger logger;

    public LocationAwareSlf4JLogger(LocationAwareLogger locationAwareLogger) {
        super(locationAwareLogger.getName());
        this.logger = locationAwareLogger;
    }

    private void log(int i, String str) {
        this.logger.log(null, FQCN, i, str, null, null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        if (isDebugEnabled()) {
            log(10, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        if (isErrorEnabled()) {
            log(40, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        if (isInfoEnabled()) {
            log(20, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str) {
        if (isTraceEnabled()) {
            log(0, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        if (isWarnEnabled()) {
            log(30, str);
        }
    }

    private void log(int i, String str, Throwable th) {
        this.logger.log(null, FQCN, i, str, null, th);
    }

    private void log(int i, org.slf4j.helpers.FormattingTuple formattingTuple) {
        this.logger.log(null, FQCN, i, formattingTuple.getMessage(), formattingTuple.getArgArray(), formattingTuple.getThrowable());
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        if (isDebugEnabled()) {
            log(10, org.slf4j.helpers.MessageFormatter.format(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        if (isErrorEnabled()) {
            log(40, org.slf4j.helpers.MessageFormatter.format(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj) {
        if (isInfoEnabled()) {
            log(20, org.slf4j.helpers.MessageFormatter.format(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            log(0, org.slf4j.helpers.MessageFormatter.format(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        if (isWarnEnabled()) {
            log(30, org.slf4j.helpers.MessageFormatter.format(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        if (isDebugEnabled()) {
            log(10, org.slf4j.helpers.MessageFormatter.format(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        if (isErrorEnabled()) {
            log(40, org.slf4j.helpers.MessageFormatter.format(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj, Object obj2) {
        if (isInfoEnabled()) {
            log(20, org.slf4j.helpers.MessageFormatter.format(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            log(0, org.slf4j.helpers.MessageFormatter.format(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        if (isWarnEnabled()) {
            log(30, org.slf4j.helpers.MessageFormatter.arrayFormat(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        if (isDebugEnabled()) {
            log(10, org.slf4j.helpers.MessageFormatter.arrayFormat(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        if (isErrorEnabled()) {
            log(40, org.slf4j.helpers.MessageFormatter.arrayFormat(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object... objArr) {
        if (isInfoEnabled()) {
            log(20, org.slf4j.helpers.MessageFormatter.arrayFormat(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            log(0, org.slf4j.helpers.MessageFormatter.arrayFormat(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        if (isWarnEnabled()) {
            log(30, org.slf4j.helpers.MessageFormatter.format(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        if (isDebugEnabled()) {
            log(10, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        if (isErrorEnabled()) {
            log(40, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Throwable th) {
        if (isInfoEnabled()) {
            log(20, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        if (isTraceEnabled()) {
            log(0, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        if (isWarnEnabled()) {
            log(30, str, th);
        }
    }
}
