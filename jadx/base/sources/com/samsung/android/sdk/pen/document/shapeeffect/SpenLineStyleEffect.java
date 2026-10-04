package com.samsung.android.sdk.pen.document.shapeeffect;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenLineStyleEffect;", "", "<init>", "()V", "width", "", "getWidth", "()F", "setWidth", "(F)V", "type", "", "compoundType", "getCompoundType", "()I", "setCompoundType", "(I)V", "value", "beginArrowType", "getBeginArrowType", "beginArrowSize", "getBeginArrowSize", "setBeginArrow", "", "size", "endArrowType", "getEndArrowType", "endArrowSize", "getEndArrowSize", "setEndArrow", "joinType", "getJoinType", "setJoinType", "capType", "getCapType", "setCapType", "dashType", "getDashType", "setDashType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenLineStyleEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenLineStyleEffect.kt\ncom/samsung/android/sdk/pen/document/shapeeffect/SpenLineStyleEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
public final class SpenLineStyleEffect {
    public static final int ARROW_SIZE_BIG = 2;
    public static final int ARROW_SIZE_NORMAL = 0;
    public static final int ARROW_SIZE_SMALL = 1;
    public static final int ARROW_TYPE_ARROW = 1;
    public static final int ARROW_TYPE_DIAMOND_ARROW = 4;
    public static final int ARROW_TYPE_NONE = 0;
    public static final int ARROW_TYPE_OPEN_ARROW = 2;
    public static final int ARROW_TYPE_OVAL_ARROW = 5;
    public static final int ARROW_TYPE_STEALTH_ARROW = 3;
    public static final int CAP_TYPE_BUTT = 0;
    public static final int CAP_TYPE_ROUND = 1;
    public static final int CAP_TYPE_SQUARE = 2;
    public static final int COMPOUND_TYPE_DOUBLE = 1;
    public static final int COMPOUND_TYPE_SIMPLE = 0;
    public static final int COMPOUND_TYPE_THICK_THIN = 2;
    public static final int COMPOUND_TYPE_THIN_THICK = 3;
    public static final int COMPOUND_TYPE_TRIPLE = 4;
    public static final int DASH_TYPE_DASH = 3;
    public static final int DASH_TYPE_DASH_DOT = 4;
    public static final int DASH_TYPE_LONG_DASH = 5;
    public static final int DASH_TYPE_LONG_DASH_DOT = 6;
    public static final int DASH_TYPE_LONG_DASH_DOT_DOT = 7;
    public static final int DASH_TYPE_ROUND_DOT = 1;
    public static final int DASH_TYPE_SOLID = 0;
    public static final int DASH_TYPE_SQUARE_DOT = 2;
    public static final int JOIN_TYPE_BEVEL = 2;
    public static final int JOIN_TYPE_MITER = 0;
    public static final int JOIN_TYPE_ROUND = 1;
    private int beginArrowSize;
    private int beginArrowType;
    private int capType;
    private int compoundType;
    private int dashType;
    private int endArrowSize;
    private int endArrowType;
    private int joinType;
    private float width;

    public final int getBeginArrowSize() {
        return this.beginArrowSize;
    }

    public final int getBeginArrowType() {
        return this.beginArrowType;
    }

    public final int getCapType() {
        return this.capType;
    }

    public final int getCompoundType() {
        return this.compoundType;
    }

    public final int getDashType() {
        return this.dashType;
    }

    public final int getEndArrowSize() {
        return this.endArrowSize;
    }

    public final int getEndArrowType() {
        return this.endArrowType;
    }

    public final int getJoinType() {
        return this.joinType;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setBeginArrow(int type, int size) {
        this.beginArrowType = type;
        this.beginArrowSize = size;
    }

    public final void setCapType(int i) {
        this.capType = i;
    }

    public final void setCompoundType(int i) {
        if (i != 0 && i != 1 && i != 4) {
            throw new IllegalArgumentException("Type is not valid");
        }
        this.compoundType = i;
    }

    public final void setDashType(int i) {
        this.dashType = i;
    }

    public final void setEndArrow(int type, int size) {
        this.endArrowType = type;
        this.endArrowSize = size;
    }

    public final void setJoinType(int i) {
        this.joinType = i;
    }

    public final void setWidth(float f) {
        this.width = f;
    }
}
