package com.vladsch.flexmark.html.renderer;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.MutableAttributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ResolvedLink {

    @Nullable
    private MutableAttributes myAttributes;

    @NotNull
    private final LinkType myLinkType;

    @NotNull
    private final LinkStatus myStatus;

    @NotNull
    private final String myUrl;

    public ResolvedLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence) {
        this(linkType, charSequence, null, LinkStatus.UNKNOWN);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolvedLink)) {
            return false;
        }
        ResolvedLink resolvedLink = (ResolvedLink) obj;
        if (this.myLinkType.equals(resolvedLink.myLinkType) && this.myUrl.equals(resolvedLink.myUrl)) {
            return this.myStatus.equals(resolvedLink.myStatus);
        }
        return false;
    }

    @Nullable
    public String getAnchorRef() {
        int iIndexOf = this.myUrl.indexOf(35);
        if (iIndexOf < 0) {
            return null;
        }
        return this.myUrl.substring(iIndexOf + 1);
    }

    @Nullable
    public Attributes getAttributes() {
        MutableAttributes mutableAttributes = this.myAttributes;
        if (mutableAttributes == null) {
            return null;
        }
        return mutableAttributes.toImmutable();
    }

    @NotNull
    public LinkType getLinkType() {
        return this.myLinkType;
    }

    @NotNull
    public MutableAttributes getMutableAttributes() {
        if (this.myAttributes == null) {
            this.myAttributes = new MutableAttributes();
        }
        return this.myAttributes;
    }

    @NotNull
    public Attributes getNonNullAttributes() {
        if (this.myAttributes == null) {
            this.myAttributes = new MutableAttributes();
        }
        return this.myAttributes.toImmutable();
    }

    @NotNull
    public String getPageRef() {
        int iIndexOf = this.myUrl.indexOf(35);
        return iIndexOf < 0 ? this.myUrl : this.myUrl.substring(0, iIndexOf);
    }

    @NotNull
    public LinkStatus getStatus() {
        return this.myStatus;
    }

    public String getTarget() {
        MutableAttributes mutableAttributes = this.myAttributes;
        if (mutableAttributes == null) {
            return null;
        }
        return mutableAttributes.getValue("target");
    }

    @Nullable
    public String getTitle() {
        MutableAttributes mutableAttributes = this.myAttributes;
        if (mutableAttributes == null) {
            return null;
        }
        return mutableAttributes.getValue("title");
    }

    @NotNull
    public String getUrl() {
        return this.myUrl;
    }

    public int hashCode() {
        return this.myStatus.hashCode() + AbstractC1038a.m1202c(this.myLinkType.hashCode() * 31, 31, this.myUrl);
    }

    public ResolvedLink withLinkType(@NotNull LinkType linkType) {
        return linkType == this.myLinkType ? this : new ResolvedLink(linkType, this.myUrl, this.myAttributes, this.myStatus);
    }

    public ResolvedLink withStatus(@NotNull LinkStatus linkStatus) {
        return linkStatus == this.myStatus ? this : new ResolvedLink(this.myLinkType, this.myUrl, this.myAttributes, linkStatus);
    }

    @NotNull
    public ResolvedLink withTarget(@Nullable CharSequence charSequence) {
        MutableAttributes mutableAttributes = this.myAttributes;
        MutableAttributes mutableAttributes2 = null;
        String value = mutableAttributes == null ? null : mutableAttributes.getValue("target");
        if (charSequence == value || !(value == null || charSequence == null || !value.contentEquals(charSequence))) {
            return this;
        }
        MutableAttributes mutableAttributes3 = new MutableAttributes(this.myAttributes);
        if (charSequence == null) {
            mutableAttributes3.remove("target");
            if (!mutableAttributes3.isEmpty()) {
            }
            return new ResolvedLink(this.myLinkType, this.myUrl, mutableAttributes2, this.myStatus);
        }
        mutableAttributes3.replaceValue("target", charSequence);
        mutableAttributes2 = mutableAttributes3;
        return new ResolvedLink(this.myLinkType, this.myUrl, mutableAttributes2, this.myStatus);
    }

    @NotNull
    public ResolvedLink withTitle(@Nullable CharSequence charSequence) {
        MutableAttributes mutableAttributes = this.myAttributes;
        MutableAttributes mutableAttributes2 = null;
        String value = mutableAttributes == null ? null : mutableAttributes.getValue("title");
        if (charSequence == value || !(value == null || charSequence == null || !value.contentEquals(charSequence))) {
            return this;
        }
        MutableAttributes mutableAttributes3 = new MutableAttributes(this.myAttributes);
        if (charSequence == null) {
            mutableAttributes3.remove("title");
            if (!mutableAttributes3.isEmpty()) {
            }
            return new ResolvedLink(this.myLinkType, this.myUrl, mutableAttributes2, this.myStatus);
        }
        mutableAttributes3.replaceValue("title", charSequence);
        mutableAttributes2 = mutableAttributes3;
        return new ResolvedLink(this.myLinkType, this.myUrl, mutableAttributes2, this.myStatus);
    }

    @NotNull
    public ResolvedLink withUrl(@NotNull CharSequence charSequence) {
        String strValueOf = String.valueOf(charSequence);
        return this.myUrl.equals(strValueOf) ? this : new ResolvedLink(this.myLinkType, strValueOf, this.myAttributes, this.myStatus);
    }

    public ResolvedLink(@NotNull LinkType linkType, @NotNull CharSequence charSequence, @Nullable Attributes attributes) {
        this(linkType, charSequence, attributes, LinkStatus.UNKNOWN);
    }

    public ResolvedLink(@NotNull LinkType linkType, CharSequence charSequence, @Nullable Attributes attributes, @NotNull LinkStatus linkStatus) {
        this.myLinkType = linkType;
        this.myUrl = String.valueOf(charSequence);
        this.myStatus = linkStatus;
        if (attributes != null) {
            getMutableAttributes().addValues(attributes);
        }
    }
}
