package com.samsung.android.sesl.outerGlow;

import androidx.annotation.Keep;
import androidx.compose.foundation.layout.AbstractC1038a;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0001HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jh\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0006\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/Uniform;", "", "name", "", "type", "value", "isCustom", "", "minValue", "", "maxValue", "defaultValue", ClientCookie.COMMENT_ATTR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Object;Ljava/lang/String;)V", "getComment", "()Ljava/lang/String;", "getDefaultValue", "()Ljava/lang/Object;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMinValue", "getName", "getType", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Object;Ljava/lang/String;)Lcom/samsung/android/sesl/outerGlow/Uniform;", "equals", "other", "hashCode", "", "toString", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class Uniform {

    @Nullable
    private final String comment;

    @Nullable
    private final Object defaultValue;

    @Nullable
    private final Boolean isCustom;

    @Nullable
    private final Float maxValue;

    @Nullable
    private final Float minValue;

    @NotNull
    private final String name;

    @NotNull
    private final String type;

    @NotNull
    private final Object value;

    public Uniform(@NotNull String name, @NotNull String type, @NotNull Object value, @Nullable Boolean bool, @Nullable Float f, @Nullable Float f4, @Nullable Object obj, @Nullable String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.type = type;
        this.value = value;
        this.isCustom = bool;
        this.minValue = f;
        this.maxValue = f4;
        this.defaultValue = obj;
        this.comment = str;
    }

    public static /* synthetic */ Uniform copy$default(Uniform uniform, String str, String str2, Object obj, Boolean bool, Float f, Float f4, Object obj2, String str3, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = uniform.name;
        }
        if ((i & 2) != 0) {
            str2 = uniform.type;
        }
        if ((i & 4) != 0) {
            obj = uniform.value;
        }
        if ((i & 8) != 0) {
            bool = uniform.isCustom;
        }
        if ((i & 16) != 0) {
            f = uniform.minValue;
        }
        if ((i & 32) != 0) {
            f4 = uniform.maxValue;
        }
        if ((i & 64) != 0) {
            obj2 = uniform.defaultValue;
        }
        if ((i & 128) != 0) {
            str3 = uniform.comment;
        }
        Object obj4 = obj2;
        String str4 = str3;
        Float f5 = f;
        Float f6 = f4;
        return uniform.copy(str, str2, obj, bool, f5, f6, obj4, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsCustom() {
        return this.isCustom;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getMinValue() {
        return this.minValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getMaxValue() {
        return this.maxValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    @NotNull
    public final Uniform copy(@NotNull String name, @NotNull String type, @NotNull Object value, @Nullable Boolean isCustom, @Nullable Float minValue, @Nullable Float maxValue, @Nullable Object defaultValue, @Nullable String comment) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Uniform(name, type, value, isCustom, minValue, maxValue, defaultValue, comment);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Uniform)) {
            return false;
        }
        Uniform uniform = (Uniform) other;
        return Intrinsics.areEqual(this.name, uniform.name) && Intrinsics.areEqual(this.type, uniform.type) && Intrinsics.areEqual(this.value, uniform.value) && Intrinsics.areEqual(this.isCustom, uniform.isCustom) && Intrinsics.areEqual((Object) this.minValue, (Object) uniform.minValue) && Intrinsics.areEqual((Object) this.maxValue, (Object) uniform.maxValue) && Intrinsics.areEqual(this.defaultValue, uniform.defaultValue) && Intrinsics.areEqual(this.comment, uniform.comment);
    }

    @Nullable
    public final String getComment() {
        return this.comment;
    }

    @Nullable
    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    public final Float getMaxValue() {
        return this.maxValue;
    }

    @Nullable
    public final Float getMinValue() {
        return this.minValue;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = (this.value.hashCode() + AbstractC1038a.m1202c(this.name.hashCode() * 31, 31, this.type)) * 31;
        Boolean bool = this.isCustom;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Float f = this.minValue;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Float f4 = this.maxValue;
        int iHashCode4 = (iHashCode3 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Object obj = this.defaultValue;
        int iHashCode5 = (iHashCode4 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str = this.comment;
        return iHashCode5 + (str != null ? str.hashCode() : 0);
    }

    @Nullable
    public final Boolean isCustom() {
        return this.isCustom;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.type;
        Object obj = this.value;
        Boolean bool = this.isCustom;
        Float f = this.minValue;
        Float f4 = this.maxValue;
        Object obj2 = this.defaultValue;
        String str3 = this.comment;
        StringBuilder sbM16m = AbstractC0000a.m16m("Uniform(name=", str, ", type=", str2, ", value=");
        sbM16m.append(obj);
        sbM16m.append(", isCustom=");
        sbM16m.append(bool);
        sbM16m.append(", minValue=");
        sbM16m.append(f);
        sbM16m.append(", maxValue=");
        sbM16m.append(f4);
        sbM16m.append(", defaultValue=");
        sbM16m.append(obj2);
        sbM16m.append(", comment=");
        sbM16m.append(str3);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    public /* synthetic */ Uniform(String str, String str2, Object obj, Boolean bool, Float f, Float f4, Object obj2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, obj, bool, f, f4, obj2, (i & 128) != 0 ? null : str3);
    }
}
