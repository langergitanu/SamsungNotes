package com.samsung.android.sesl.outerGlow.data;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/TranslationParams;", "", "translationX", "", "translationY", "(FF)V", "getTranslationX", "()F", "getTranslationY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class TranslationParams {
    private final float translationX;
    private final float translationY;

    /* JADX WARN: Illegal instructions before constructor call */
    public TranslationParams() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ TranslationParams copy$default(TranslationParams translationParams, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = translationParams.translationX;
        }
        if ((i & 2) != 0) {
            f4 = translationParams.translationY;
        }
        return translationParams.copy(f, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    @NotNull
    public final TranslationParams copy(float translationX, float translationY) {
        return new TranslationParams(translationX, translationY);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationParams)) {
            return false;
        }
        TranslationParams translationParams = (TranslationParams) other;
        return Float.compare(this.translationX, translationParams.translationX) == 0 && Float.compare(this.translationY, translationParams.translationY) == 0;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public int hashCode() {
        return Float.hashCode(this.translationY) + (Float.hashCode(this.translationX) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m770l("TranslationParams(translationX=", this.translationX, ", translationY=", this.translationY, ")");
    }

    public TranslationParams(float f, float f4) {
        this.translationX = f;
        this.translationY = f4;
    }

    public /* synthetic */ TranslationParams(float f, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f4);
    }
}
