package org.apache.commons.logging;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LogConfigurationException extends RuntimeException {
    private static final long serialVersionUID = 8486587136871052495L;

    @Deprecated
    protected Throwable cause;

    public LogConfigurationException() {
    }

    public LogConfigurationException(String str) {
        super(str);
    }

    public LogConfigurationException(String str, Throwable th) {
        super(str, th);
        this.cause = th;
    }

    public LogConfigurationException(Throwable th) {
        this(Objects.toString(th, null), th);
    }
}
