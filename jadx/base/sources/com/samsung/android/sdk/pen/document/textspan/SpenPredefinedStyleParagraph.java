package com.samsung.android.sdk.pen.document.textspan;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\tR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenPredefinedStyleParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "<init>", "()V", "startPosition", "", "endPosition", "styleType", "followingType", "(IIII)V", "getStyleType", "()I", "setStyleType", "(I)V", "followingStyleType", "getFollowingStyleType", "setFollowingStyleType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPredefinedStyleParagraph extends SpenTextParagraphBase {
    private int followingStyleType;
    private int styleType;

    public SpenPredefinedStyleParagraph() {
        super(10);
        this.followingStyleType = 3;
    }

    public final int getFollowingStyleType() {
        return this.followingStyleType;
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public final void setFollowingStyleType(int i) {
        this.followingStyleType = i;
    }

    public final void setStyleType(int i) {
        this.styleType = i;
    }

    public SpenPredefinedStyleParagraph(int i, int i2, int i4, int i5) {
        super(10, i, i2);
        this.styleType = i4;
        this.followingStyleType = i5;
    }
}
