package com.microsoft.identity.common.java.logging;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum DiagnosticContext {
    INSTANCE;

    public static final String CORRELATION_ID = "correlation_id";
    public static final String THREAD_ID = "thread_id";
    private static final String UNSET = "UNSET";

    @SuppressFBWarnings({"SE_BAD_FIELD_STORE"})
    private final transient ThreadLocal<IRequestContext> REQUEST_CONTEXT_THREAD_LOCAL = new ThreadLocal<IRequestContext>() { // from class: com.microsoft.identity.common.java.logging.DiagnosticContext.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: initialValue, reason: merged with bridge method [inline-methods] */
        public IRequestContext initialValue2() {
            RequestContext requestContext = new RequestContext();
            requestContext.put(DiagnosticContext.THREAD_ID, String.valueOf(Thread.currentThread().getId()));
            requestContext.put("correlation_id", "UNSET");
            return requestContext;
        }
    };

    DiagnosticContext() {
    }

    public void clear() {
        this.REQUEST_CONTEXT_THREAD_LOCAL.remove();
    }

    public IRequestContext getRequestContext() {
        return this.REQUEST_CONTEXT_THREAD_LOCAL.get();
    }

    public String getThreadCorrelationId() {
        String str = getRequestContext().get("correlation_id");
        return str == null ? "UNSET" : str;
    }

    public void setRequestContext(IRequestContext iRequestContext) {
        if (iRequestContext == null) {
            clear();
        } else {
            iRequestContext.put(THREAD_ID, String.valueOf(Thread.currentThread().getId()));
            this.REQUEST_CONTEXT_THREAD_LOCAL.set(iRequestContext);
        }
    }
}
