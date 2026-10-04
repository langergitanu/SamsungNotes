package org.junit.runner.notification;

import java.io.Serializable;
import org.junit.internal.Throwables;
import org.junit.runner.Description;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class Failure implements Serializable {
    private static final long serialVersionUID = 1;
    private final Description fDescription;
    private final Throwable fThrownException;

    public Failure(Description description, Throwable th) {
        this.fThrownException = th;
        this.fDescription = description;
    }

    public Description getDescription() {
        return this.fDescription;
    }

    public Throwable getException() {
        return this.fThrownException;
    }

    public String getMessage() {
        return getException().getMessage();
    }

    public String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public String getTrace() {
        return Throwables.getStacktrace(getException());
    }

    public String getTrimmedTrace() {
        return Throwables.getTrimmedStackTrace(getException());
    }

    public String toString() {
        return getTestHeader() + ": " + this.fThrownException.getMessage();
    }
}
