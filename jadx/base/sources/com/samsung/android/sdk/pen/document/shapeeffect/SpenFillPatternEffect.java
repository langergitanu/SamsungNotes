package com.samsung.android.sdk.pen.document.shapeeffect;

import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillPatternEffect;", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "<init>", "()V", "pattern", "", "getPattern", "()[C", "setPattern", "([C)V", "foregroundColor", "", "getForegroundColor", "()I", "setForegroundColor", "(I)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFillPatternEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFillPatternEffect.kt\ncom/samsung/android/sdk/pen/document/shapeeffect/SpenFillPatternEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class SpenFillPatternEffect extends SpenFillEffectBase {

    @ColorInt
    private int backgroundColor;

    @ColorInt
    private int foregroundColor;

    @NotNull
    private char[] pattern;

    public SpenFillPatternEffect() {
        super(3);
        char[] cArr = new char[8];
        for (int i = 0; i < 8; i++) {
            cArr[i] = 0;
        }
        this.pattern = cArr;
        this.foregroundColor = -16777216;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    @NotNull
    public final char[] getPattern() {
        return this.pattern;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setForegroundColor(int i) {
        this.foregroundColor = i;
    }

    public final void setPattern(@NotNull char[] pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (pattern.length != 8) {
            throw new IllegalArgumentException("Pattern length is not valid");
        }
        System.arraycopy(pattern, 0, this.pattern, 0, 8);
    }
}
