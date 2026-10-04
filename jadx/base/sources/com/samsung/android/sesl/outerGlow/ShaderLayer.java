package com.samsung.android.sesl.outerGlow;

import androidx.annotation.Keep;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003Jm\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\nHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0017\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u001e\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00067"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "", "id", "", "uniforms", "", "Lcom/samsung/android/sesl/outerGlow/Uniform;", "enabled", "", "agslShaderCode", "", "isCanvasDraw", "isBlur", "radiusX", "", "radiusY", "name", "(ILjava/util/List;ZLjava/lang/String;ZZFFLjava/lang/String;)V", "getAgslShaderCode", "()Ljava/lang/String;", "setAgslShaderCode", "(Ljava/lang/String;)V", "getEnabled", "()Z", "getId", "()I", "setId", "(I)V", "setBlur", "(Z)V", "setCanvasDraw", "getName", "setName", "getRadiusX", "()F", "setRadiusX", "(F)V", "getRadiusY", "setRadiusY", "getUniforms", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ShaderLayer {

    @Nullable
    private String agslShaderCode;
    private final boolean enabled;
    private int id;
    private boolean isBlur;
    private boolean isCanvasDraw;

    @Nullable
    private String name;
    private float radiusX;
    private float radiusY;

    @NotNull
    private final List<Uniform> uniforms;

    public ShaderLayer(int i, @NotNull List<Uniform> uniforms, boolean z, @Nullable String str, boolean z2, boolean z3, float f, float f4, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uniforms, "uniforms");
        this.id = i;
        this.uniforms = uniforms;
        this.enabled = z;
        this.agslShaderCode = str;
        this.isCanvasDraw = z2;
        this.isBlur = z3;
        this.radiusX = f;
        this.radiusY = f4;
        this.name = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShaderLayer copy$default(ShaderLayer shaderLayer, int i, List list, boolean z, String str, boolean z2, boolean z3, float f, float f4, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shaderLayer.id;
        }
        if ((i2 & 2) != 0) {
            list = shaderLayer.uniforms;
        }
        if ((i2 & 4) != 0) {
            z = shaderLayer.enabled;
        }
        if ((i2 & 8) != 0) {
            str = shaderLayer.agslShaderCode;
        }
        if ((i2 & 16) != 0) {
            z2 = shaderLayer.isCanvasDraw;
        }
        if ((i2 & 32) != 0) {
            z3 = shaderLayer.isBlur;
        }
        if ((i2 & 64) != 0) {
            f = shaderLayer.radiusX;
        }
        if ((i2 & 128) != 0) {
            f4 = shaderLayer.radiusY;
        }
        if ((i2 & 256) != 0) {
            str2 = shaderLayer.name;
        }
        float f5 = f4;
        String str3 = str2;
        boolean z4 = z3;
        float f6 = f;
        boolean z5 = z2;
        boolean z6 = z;
        return shaderLayer.copy(i, list, z6, str, z5, z4, f6, f5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    public final List<Uniform> component2() {
        return this.uniforms;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAgslShaderCode() {
        return this.agslShaderCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsCanvasDraw() {
        return this.isCanvasDraw;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBlur() {
        return this.isBlur;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getRadiusX() {
        return this.radiusX;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getRadiusY() {
        return this.radiusY;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ShaderLayer copy(int id, @NotNull List<Uniform> uniforms, boolean enabled, @Nullable String agslShaderCode, boolean isCanvasDraw, boolean isBlur, float radiusX, float radiusY, @Nullable String name) {
        Intrinsics.checkNotNullParameter(uniforms, "uniforms");
        return new ShaderLayer(id, uniforms, enabled, agslShaderCode, isCanvasDraw, isBlur, radiusX, radiusY, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShaderLayer)) {
            return false;
        }
        ShaderLayer shaderLayer = (ShaderLayer) other;
        return this.id == shaderLayer.id && Intrinsics.areEqual(this.uniforms, shaderLayer.uniforms) && this.enabled == shaderLayer.enabled && Intrinsics.areEqual(this.agslShaderCode, shaderLayer.agslShaderCode) && this.isCanvasDraw == shaderLayer.isCanvasDraw && this.isBlur == shaderLayer.isBlur && Float.compare(this.radiusX, shaderLayer.radiusX) == 0 && Float.compare(this.radiusY, shaderLayer.radiusY) == 0 && Intrinsics.areEqual(this.name, shaderLayer.name);
    }

    @Nullable
    public final String getAgslShaderCode() {
        return this.agslShaderCode;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final float getRadiusX() {
        return this.radiusX;
    }

    public final float getRadiusY() {
        return this.radiusY;
    }

    @NotNull
    public final List<Uniform> getUniforms() {
        return this.uniforms;
    }

    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.enabled, AbstractC0622a.m1159e(this.uniforms, Integer.hashCode(this.id) * 31, 31), 31);
        String str = this.agslShaderCode;
        int iM1156b = AbstractC0622a.m1156b(this.radiusY, AbstractC0622a.m1156b(this.radiusX, AbstractC0622a.m1160f(this.isBlur, AbstractC0622a.m1160f(this.isCanvasDraw, (iM1160f + (str == null ? 0 : str.hashCode())) * 31, 31), 31), 31), 31);
        String str2 = this.name;
        return iM1156b + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isBlur() {
        return this.isBlur;
    }

    public final boolean isCanvasDraw() {
        return this.isCanvasDraw;
    }

    public final void setAgslShaderCode(@Nullable String str) {
        this.agslShaderCode = str;
    }

    public final void setBlur(boolean z) {
        this.isBlur = z;
    }

    public final void setCanvasDraw(boolean z) {
        this.isCanvasDraw = z;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setRadiusX(float f) {
        this.radiusX = f;
    }

    public final void setRadiusY(float f) {
        this.radiusY = f;
    }

    @NotNull
    public String toString() {
        int i = this.id;
        List<Uniform> list = this.uniforms;
        boolean z = this.enabled;
        String str = this.agslShaderCode;
        boolean z2 = this.isCanvasDraw;
        boolean z3 = this.isBlur;
        float f = this.radiusX;
        float f4 = this.radiusY;
        String str2 = this.name;
        StringBuilder sb = new StringBuilder("ShaderLayer(id=");
        sb.append(i);
        sb.append(", uniforms=");
        sb.append(list);
        sb.append(", enabled=");
        sb.append(z);
        sb.append(", agslShaderCode=");
        sb.append(str);
        sb.append(", isCanvasDraw=");
        AbstractC2821a.m2208C(sb, z2, ", isBlur=", z3, ", radiusX=");
        AbstractC11014a.m12337v(sb, f, ", radiusY=", f4, ", name=");
        return AbstractC0622a.m1170p(str2, ")", sb);
    }

    public /* synthetic */ ShaderLayer(int i, List list, boolean z, String str, boolean z2, boolean z3, float f, float f4, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3, (i2 & 64) != 0 ? 0.0f : f, (i2 & 128) != 0 ? 0.0f : f4, (i2 & 256) != 0 ? null : str2);
    }
}
