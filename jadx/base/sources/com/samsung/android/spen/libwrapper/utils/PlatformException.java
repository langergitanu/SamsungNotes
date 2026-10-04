package com.samsung.android.spen.libwrapper.utils;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PlatformException extends Exception {
    public static final String SDL = "SDL";

    /* JADX INFO: renamed from: SE */
    public static final String f5434SE = "SE";
    private Throwable cause;

    public PlatformException() {
        super("Samsung platform API is not supported on the current platform.");
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public PlatformException(Throwable th) {
        super("Samsung platform API is not supported on the current platform.");
        this.cause = th.getCause();
    }

    public PlatformException(String str) {
        super(AbstractC0541b.m756B(str, " API is not supported on the current platform."));
    }

    public PlatformException(String str, Throwable th) {
        super(AbstractC0541b.m756B(str, " API is not supported on the current platform."));
        this.cause = th.getCause();
    }
}
