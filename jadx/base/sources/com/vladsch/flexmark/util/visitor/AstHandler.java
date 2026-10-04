package com.vladsch.flexmark.util.visitor;

import com.vladsch.flexmark.util.visitor.AstAction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AstHandler<N, A extends AstAction<? super N>> {

    @NotNull
    private final Class<? extends N> aClass;

    @NotNull
    private final A adapter;

    public AstHandler(@NotNull Class<? extends N> cls, @NotNull A a) {
        this.aClass = cls;
        this.adapter = a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AstHandler astHandler = (AstHandler) obj;
            if (this.aClass == astHandler.aClass && this.adapter == astHandler.adapter) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public A getAdapter() {
        return this.adapter;
    }

    @NotNull
    public Class<? extends N> getNodeType() {
        return this.aClass;
    }

    public int hashCode() {
        return this.adapter.hashCode() + (this.aClass.hashCode() * 31);
    }
}
