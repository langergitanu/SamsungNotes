package com.samsung.android.sesl.outerGlow;

import androidx.annotation.Keep;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/CanvasLayer;", "", "codeId", "", "frameRate", "", "stopAfterDelay", "needStopAfterInitAnimation", "", "needStopAfterDelay", "needInitAnimation", "initAnimationDuration", "stopAnimationDuration", "shaders", "", "Lcom/samsung/android/sesl/outerGlow/ShaderLayer;", "uniforms", "Lcom/samsung/android/sesl/outerGlow/Uniform;", "agslShaderCode", "(Ljava/lang/String;IIZZZIILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAgslShaderCode", "()Ljava/lang/String;", "setAgslShaderCode", "(Ljava/lang/String;)V", "getCodeId", "setCodeId", "getFrameRate", "()I", "getInitAnimationDuration", "getNeedInitAnimation", "()Z", "getNeedStopAfterDelay", "getNeedStopAfterInitAnimation", "getShaders", "()Ljava/util/List;", "getStopAfterDelay", "getStopAnimationDuration", "getUniforms", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class CanvasLayer {

    @Nullable
    private String agslShaderCode;

    @Nullable
    private String codeId;
    private final int frameRate;
    private final int initAnimationDuration;
    private final boolean needInitAnimation;
    private final boolean needStopAfterDelay;
    private final boolean needStopAfterInitAnimation;

    @Nullable
    private final List<ShaderLayer> shaders;
    private final int stopAfterDelay;
    private final int stopAnimationDuration;

    @Nullable
    private final List<Uniform> uniforms;

    public CanvasLayer(@Nullable String str, int i, int i2, boolean z, boolean z2, boolean z3, int i4, int i5, @Nullable List<ShaderLayer> list, @Nullable List<Uniform> list2, @Nullable String str2) {
        this.codeId = str;
        this.frameRate = i;
        this.stopAfterDelay = i2;
        this.needStopAfterInitAnimation = z;
        this.needStopAfterDelay = z2;
        this.needInitAnimation = z3;
        this.initAnimationDuration = i4;
        this.stopAnimationDuration = i5;
        this.shaders = list;
        this.uniforms = list2;
        this.agslShaderCode = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasLayer copy$default(CanvasLayer canvasLayer, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i4, int i5, List list, List list2, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = canvasLayer.codeId;
        }
        if ((i6 & 2) != 0) {
            i = canvasLayer.frameRate;
        }
        if ((i6 & 4) != 0) {
            i2 = canvasLayer.stopAfterDelay;
        }
        if ((i6 & 8) != 0) {
            z = canvasLayer.needStopAfterInitAnimation;
        }
        if ((i6 & 16) != 0) {
            z2 = canvasLayer.needStopAfterDelay;
        }
        if ((i6 & 32) != 0) {
            z3 = canvasLayer.needInitAnimation;
        }
        if ((i6 & 64) != 0) {
            i4 = canvasLayer.initAnimationDuration;
        }
        if ((i6 & 128) != 0) {
            i5 = canvasLayer.stopAnimationDuration;
        }
        if ((i6 & 256) != 0) {
            list = canvasLayer.shaders;
        }
        if ((i6 & 512) != 0) {
            list2 = canvasLayer.uniforms;
        }
        if ((i6 & 1024) != 0) {
            str2 = canvasLayer.agslShaderCode;
        }
        List list3 = list2;
        String str3 = str2;
        int i7 = i5;
        List list4 = list;
        boolean z4 = z3;
        int i8 = i4;
        boolean z5 = z2;
        int i9 = i2;
        return canvasLayer.copy(str, i, i9, z, z5, z4, i8, i7, list4, list3, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCodeId() {
        return this.codeId;
    }

    @Nullable
    public final List<Uniform> component10() {
        return this.uniforms;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAgslShaderCode() {
        return this.agslShaderCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFrameRate() {
        return this.frameRate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStopAfterDelay() {
        return this.stopAfterDelay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getNeedStopAfterInitAnimation() {
        return this.needStopAfterInitAnimation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getNeedStopAfterDelay() {
        return this.needStopAfterDelay;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getNeedInitAnimation() {
        return this.needInitAnimation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getInitAnimationDuration() {
        return this.initAnimationDuration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getStopAnimationDuration() {
        return this.stopAnimationDuration;
    }

    @Nullable
    public final List<ShaderLayer> component9() {
        return this.shaders;
    }

    @NotNull
    public final CanvasLayer copy(@Nullable String codeId, int frameRate, int stopAfterDelay, boolean needStopAfterInitAnimation, boolean needStopAfterDelay, boolean needInitAnimation, int initAnimationDuration, int stopAnimationDuration, @Nullable List<ShaderLayer> shaders, @Nullable List<Uniform> uniforms, @Nullable String agslShaderCode) {
        return new CanvasLayer(codeId, frameRate, stopAfterDelay, needStopAfterInitAnimation, needStopAfterDelay, needInitAnimation, initAnimationDuration, stopAnimationDuration, shaders, uniforms, agslShaderCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CanvasLayer)) {
            return false;
        }
        CanvasLayer canvasLayer = (CanvasLayer) other;
        return Intrinsics.areEqual(this.codeId, canvasLayer.codeId) && this.frameRate == canvasLayer.frameRate && this.stopAfterDelay == canvasLayer.stopAfterDelay && this.needStopAfterInitAnimation == canvasLayer.needStopAfterInitAnimation && this.needStopAfterDelay == canvasLayer.needStopAfterDelay && this.needInitAnimation == canvasLayer.needInitAnimation && this.initAnimationDuration == canvasLayer.initAnimationDuration && this.stopAnimationDuration == canvasLayer.stopAnimationDuration && Intrinsics.areEqual(this.shaders, canvasLayer.shaders) && Intrinsics.areEqual(this.uniforms, canvasLayer.uniforms) && Intrinsics.areEqual(this.agslShaderCode, canvasLayer.agslShaderCode);
    }

    @Nullable
    public final String getAgslShaderCode() {
        return this.agslShaderCode;
    }

    @Nullable
    public final String getCodeId() {
        return this.codeId;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getInitAnimationDuration() {
        return this.initAnimationDuration;
    }

    public final boolean getNeedInitAnimation() {
        return this.needInitAnimation;
    }

    public final boolean getNeedStopAfterDelay() {
        return this.needStopAfterDelay;
    }

    public final boolean getNeedStopAfterInitAnimation() {
        return this.needStopAfterInitAnimation;
    }

    @Nullable
    public final List<ShaderLayer> getShaders() {
        return this.shaders;
    }

    public final int getStopAfterDelay() {
        return this.stopAfterDelay;
    }

    public final int getStopAnimationDuration() {
        return this.stopAnimationDuration;
    }

    @Nullable
    public final List<Uniform> getUniforms() {
        return this.uniforms;
    }

    public int hashCode() {
        String str = this.codeId;
        int iM1157c = AbstractC0622a.m1157c(this.stopAnimationDuration, AbstractC0622a.m1157c(this.initAnimationDuration, AbstractC0622a.m1160f(this.needInitAnimation, AbstractC0622a.m1160f(this.needStopAfterDelay, AbstractC0622a.m1160f(this.needStopAfterInitAnimation, AbstractC0622a.m1157c(this.stopAfterDelay, AbstractC0622a.m1157c(this.frameRate, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31), 31), 31), 31), 31);
        List<ShaderLayer> list = this.shaders;
        int iHashCode = (iM1157c + (list == null ? 0 : list.hashCode())) * 31;
        List<Uniform> list2 = this.uniforms;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.agslShaderCode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAgslShaderCode(@Nullable String str) {
        this.agslShaderCode = str;
    }

    public final void setCodeId(@Nullable String str) {
        this.codeId = str;
    }

    @NotNull
    public String toString() {
        String str = this.codeId;
        int i = this.frameRate;
        int i2 = this.stopAfterDelay;
        boolean z = this.needStopAfterInitAnimation;
        boolean z2 = this.needStopAfterDelay;
        boolean z3 = this.needInitAnimation;
        int i4 = this.initAnimationDuration;
        int i5 = this.stopAnimationDuration;
        List<ShaderLayer> list = this.shaders;
        List<Uniform> list2 = this.uniforms;
        String str2 = this.agslShaderCode;
        StringBuilder sbM780v = AbstractC0541b.m780v("CanvasLayer(codeId=", i, str, ", frameRate=", ", stopAfterDelay=");
        sbM780v.append(i2);
        sbM780v.append(", needStopAfterInitAnimation=");
        sbM780v.append(z);
        sbM780v.append(", needStopAfterDelay=");
        AbstractC2821a.m2208C(sbM780v, z2, ", needInitAnimation=", z3, ", initAnimationDuration=");
        AbstractC2821a.m2235z(sbM780v, i4, i5, ", stopAnimationDuration=", ", shaders=");
        sbM780v.append(list);
        sbM780v.append(", uniforms=");
        sbM780v.append(list2);
        sbM780v.append(", agslShaderCode=");
        return AbstractC0622a.m1170p(str2, ")", sbM780v);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ CanvasLayer(java.lang.String r15, int r16, int r17, boolean r18, boolean r19, boolean r20, int r21, int r22, java.util.List r23, java.util.List r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 32
            if (r1 == 0) goto L9
            r1 = 0
            r8 = r1
            goto Lb
        L9:
            r8 = r20
        Lb:
            r1 = r0 & 64
            r2 = 3000(0xbb8, float:4.204E-42)
            if (r1 == 0) goto L13
            r9 = r2
            goto L15
        L13:
            r9 = r21
        L15:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L1b
            r10 = r2
            goto L1d
        L1b:
            r10 = r22
        L1d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L24
            r11 = r2
            goto L26
        L24:
            r11 = r23
        L26:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L2c
            r12 = r2
            goto L2e
        L2c:
            r12 = r24
        L2e:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L3e
            r13 = r2
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r2 = r14
            goto L4a
        L3e:
            r13 = r25
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
        L4a:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sesl.outerGlow.CanvasLayer.<init>(java.lang.String, int, int, boolean, boolean, boolean, int, int, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
