package com.samsung.android.sesl.outerGlow;

import android.graphics.RuntimeShader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/LayerShaderPair;", "", "data", "Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "shader", "Landroid/graphics/RuntimeShader;", "(Lcom/samsung/android/sesl/outerGlow/ShaderLayer;Landroid/graphics/RuntimeShader;)V", "getData", "()Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "getShader", "()Landroid/graphics/RuntimeShader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class LayerShaderPair {

    @NotNull
    private final ShaderLayer data;

    @Nullable
    private final RuntimeShader shader;

    public LayerShaderPair(@NotNull ShaderLayer data, @Nullable RuntimeShader runtimeShader) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.shader = runtimeShader;
    }

    public static /* synthetic */ LayerShaderPair copy$default(LayerShaderPair layerShaderPair, ShaderLayer shaderLayer, RuntimeShader runtimeShader, int i, Object obj) {
        if ((i & 1) != 0) {
            shaderLayer = layerShaderPair.data;
        }
        if ((i & 2) != 0) {
            runtimeShader = layerShaderPair.shader;
        }
        return layerShaderPair.copy(shaderLayer, runtimeShader);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ShaderLayer getData() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RuntimeShader getShader() {
        return this.shader;
    }

    @NotNull
    public final LayerShaderPair copy(@NotNull ShaderLayer data, @Nullable RuntimeShader shader) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new LayerShaderPair(data, shader);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayerShaderPair)) {
            return false;
        }
        LayerShaderPair layerShaderPair = (LayerShaderPair) other;
        return Intrinsics.areEqual(this.data, layerShaderPair.data) && Intrinsics.areEqual(this.shader, layerShaderPair.shader);
    }

    @NotNull
    public final ShaderLayer getData() {
        return this.data;
    }

    @Nullable
    public final RuntimeShader getShader() {
        return this.shader;
    }

    public int hashCode() {
        int iHashCode = this.data.hashCode() * 31;
        RuntimeShader runtimeShader = this.shader;
        return iHashCode + (runtimeShader == null ? 0 : runtimeShader.hashCode());
    }

    @NotNull
    public String toString() {
        return "LayerShaderPair(data=" + this.data + ", shader=" + this.shader + ")";
    }

    public /* synthetic */ LayerShaderPair(ShaderLayer shaderLayer, RuntimeShader runtimeShader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shaderLayer, (i & 2) != 0 ? null : runtimeShader);
    }
}
