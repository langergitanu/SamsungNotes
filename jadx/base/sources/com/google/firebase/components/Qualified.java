package com.google.firebase.components;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class Qualified<T> {
    private final Class<? extends Annotation> qualifier;
    private final Class<T> type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Unqualified {
    }

    public Qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        this.qualifier = cls;
        this.type = cls2;
    }

    public static <T> Qualified<T> qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        return new Qualified<>(cls, cls2);
    }

    public static <T> Qualified<T> unqualified(Class<T> cls) {
        return new Qualified<>(Unqualified.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (this.type.equals(qualified.type)) {
            return this.qualifier.equals(qualified.qualifier);
        }
        return false;
    }

    public int hashCode() {
        return this.qualifier.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        if (this.qualifier == Unqualified.class) {
            return this.type.getName();
        }
        StringBuilder sb = new StringBuilder(Log.TAG_SEPARATOR);
        AbstractC2322a.m1635y(this.qualifier, sb, " ");
        sb.append(this.type.getName());
        return sb.toString();
    }
}
