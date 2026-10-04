package com.vladsch.flexmark.html.renderer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AttributablePart {
    private final String myName;
    public static final AttributablePart NODE = new AttributablePart("NODE");
    public static final AttributablePart NODE_POSITION = new AttributablePart("NODE_POSITION");
    public static final AttributablePart LINK = new AttributablePart("LINK");

    /* JADX INFO: renamed from: ID */
    public static final AttributablePart f8349ID = new AttributablePart("ID");

    public AttributablePart(@NotNull String str) {
        this.myName = str;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @NotNull
    public String getName() {
        return this.myName;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
