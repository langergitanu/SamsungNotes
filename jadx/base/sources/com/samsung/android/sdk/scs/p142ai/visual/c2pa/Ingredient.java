package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Ingredient;", "", "url", "", "digitalSourceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDigitalSourceType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class Ingredient {

    @SerializedName("digitalSourceType")
    @Nullable
    private final String digitalSourceType;

    @Nullable
    private final String url;

    public Ingredient(@Nullable String str, @Nullable String str2) {
        this.url = str;
        this.digitalSourceType = str2;
    }

    public static /* synthetic */ Ingredient copy$default(Ingredient ingredient, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ingredient.url;
        }
        if ((i & 2) != 0) {
            str2 = ingredient.digitalSourceType;
        }
        return ingredient.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDigitalSourceType() {
        return this.digitalSourceType;
    }

    @NotNull
    public final Ingredient copy(@Nullable String url, @Nullable String digitalSourceType) {
        return new Ingredient(url, digitalSourceType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ingredient)) {
            return false;
        }
        Ingredient ingredient = (Ingredient) other;
        return Intrinsics.areEqual(this.url, ingredient.url) && Intrinsics.areEqual(this.digitalSourceType, ingredient.digitalSourceType);
    }

    @Nullable
    public final String getDigitalSourceType() {
        return this.digitalSourceType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.digitalSourceType;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("Ingredient(url=", this.url, ", digitalSourceType=", this.digitalSourceType, ")");
    }
}
