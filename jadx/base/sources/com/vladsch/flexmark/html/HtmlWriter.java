package com.vladsch.flexmark.html;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.html.Attribute;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.HtmlAppendableBase;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.TagRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlWriter extends HtmlAppendableBase<HtmlWriter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private NodeRendererContext context;

    @Nullable
    private AttributablePart useAttributes;

    public HtmlWriter(int i, int i2) {
        super(i, i2);
    }

    @NotNull
    public NodeRendererContext getContext() {
        return this.context;
    }

    public void setContext(@NotNull NodeRendererContext nodeRendererContext) {
        this.context = nodeRendererContext;
    }

    @NotNull
    public HtmlWriter srcPos() {
        NodeRendererContext nodeRendererContext = this.context;
        return nodeRendererContext == null ? this : srcPos(nodeRendererContext.getCurrentNode().getChars());
    }

    @NotNull
    public HtmlWriter srcPosWithEOL() {
        NodeRendererContext nodeRendererContext = this.context;
        return nodeRendererContext == null ? this : srcPosWithEOL(nodeRendererContext.getCurrentNode().getChars());
    }

    @NotNull
    public HtmlWriter srcPosWithTrailingEOL() {
        NodeRendererContext nodeRendererContext = this.context;
        return nodeRendererContext == null ? this : srcPosWithTrailingEOL(nodeRendererContext.getCurrentNode().getChars());
    }

    public HtmlWriter(HtmlWriter htmlWriter, boolean z) {
        super(htmlWriter, z);
        this.context = htmlWriter.context;
    }

    @NotNull
    public HtmlWriter srcPos(@NotNull BasedSequence basedSequence) {
        if (!basedSequence.isNotNull()) {
            return this;
        }
        BasedSequence basedSequenceTrimEOL = basedSequence.trimEOL();
        return srcPos(basedSequenceTrimEOL.getStartOffset(), basedSequenceTrimEOL.getEndOffset());
    }

    @NotNull
    public HtmlWriter srcPosWithEOL(@NotNull BasedSequence basedSequence) {
        return basedSequence.isNotNull() ? srcPos(basedSequence.getStartOffset(), basedSequence.getEndOffset()) : this;
    }

    @NotNull
    public HtmlWriter srcPosWithTrailingEOL(@NotNull BasedSequence basedSequence) {
        char cCharAt;
        if (!basedSequence.isNotNull()) {
            return this;
        }
        int endOffset = basedSequence.getEndOffset();
        BasedSequence baseSequence = basedSequence.getBaseSequence();
        while (endOffset < baseSequence.length() && ((cCharAt = baseSequence.charAt(endOffset)) == ' ' || cCharAt == '\t')) {
            endOffset++;
        }
        if (endOffset < baseSequence.length() && baseSequence.charAt(endOffset) == '\r') {
            endOffset++;
        }
        if (endOffset < baseSequence.length() && baseSequence.charAt(endOffset) == '\n') {
            endOffset++;
        }
        return srcPos(basedSequence.getStartOffset(), endOffset);
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public HtmlWriter tag(@NotNull CharSequence charSequence, boolean z) {
        Attributes attributes;
        String value;
        int i;
        int i2;
        AttributablePart attributablePart = this.useAttributes;
        if (attributablePart != null) {
            NodeRendererContext nodeRendererContext = this.context;
            if (nodeRendererContext != null) {
                attributes = nodeRendererContext.extendRenderingNodeAttributes(attributablePart, getAttributes());
                value = attributes.getValue(this.context.getHtmlOptions().sourcePositionAttribute);
            } else {
                attributes = new Attributes();
                value = "";
            }
            if (!value.isEmpty()) {
                int iIndexOf = value.indexOf(45);
                int i4 = -1;
                if (iIndexOf != -1) {
                    try {
                        i2 = Integer.parseInt(value.substring(0, iIndexOf));
                    } catch (Throwable unused) {
                        i2 = -1;
                    }
                    try {
                        i4 = Integer.parseInt(value.substring(iIndexOf + 1));
                    } catch (Throwable unused2) {
                    }
                    i = i4;
                    i4 = i2;
                } else {
                    i = -1;
                }
                if (i4 >= 0 && i4 < i) {
                    HtmlRenderer.TAG_RANGES.get(this.context.getDocument()).add(new TagRange(charSequence, i4, i));
                }
            }
            setAttributes(attributes);
            this.useAttributes = null;
        }
        super.tag(charSequence, z);
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.HtmlAppendableBase, com.vladsch.flexmark.util.html.HtmlAppendable
    @NotNull
    public HtmlWriter withAttr() {
        return withAttr(AttributablePart.NODE);
    }

    public HtmlWriter(int i, int i2, boolean z, boolean z2) {
        this(null, i, i2, z, z2);
    }

    @NotNull
    public HtmlWriter withAttr(@NotNull AttributablePart attributablePart) {
        super.withAttr();
        this.useAttributes = attributablePart;
        return this;
    }

    public HtmlWriter(@Nullable Appendable appendable, int i, int i2, boolean z, boolean z2) {
        super(appendable, i, i2);
        setSuppressOpenTagLine(z);
        setSuppressCloseTagLine(z2);
    }

    @NotNull
    public HtmlWriter srcPos(int i, int i2) {
        NodeRendererContext nodeRendererContext;
        if (i <= i2 && (nodeRendererContext = this.context) != null && !nodeRendererContext.getHtmlOptions().sourcePositionAttribute.isEmpty()) {
            super.attr((CharSequence) this.context.getHtmlOptions().sourcePositionAttribute, (CharSequence) (i + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + i2));
        }
        return this;
    }

    @NotNull
    public HtmlWriter withAttr(@NotNull LinkStatus linkStatus) {
        attr(Attribute.LINK_STATUS_ATTR, (CharSequence) linkStatus.getName());
        return withAttr(AttributablePart.LINK);
    }

    @NotNull
    public HtmlWriter withAttr(@NotNull ResolvedLink resolvedLink) {
        return withAttr(resolvedLink.getStatus());
    }
}
