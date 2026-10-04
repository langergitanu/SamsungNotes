package com.vladsch.flexmark.html.renderer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkType {

    @NotNull
    private final String myName;
    public static final LinkType LINK = new LinkType("LINK");
    public static final LinkType IMAGE = new LinkType("IMAGE");
    public static final LinkType LINK_REF = new LinkType("LINK_REF");
    public static final LinkType IMAGE_REF = new LinkType("IMAGE_REF");

    public LinkType(@NotNull String str) {
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
