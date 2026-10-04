package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenViewInfo;", "", "name", "", "color", "", "sizeLevel", "particleSize", "", "isFixedWidth", "", "<init>", "(Ljava/lang/String;IIFZ)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getColor", "()I", "setColor", "(I)V", "getSizeLevel", "setSizeLevel", "getParticleSize", "()F", "setParticleSize", "(F)V", "()Z", "setFixedWidth", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class QTPenViewInfo {
    private int color;
    private boolean isFixedWidth;

    @NotNull
    private String name;
    private float particleSize;
    private int sizeLevel;

    public QTPenViewInfo(@NotNull String name, int i, int i2, float f, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.color = i;
        this.sizeLevel = i2;
        this.particleSize = f;
        this.isFixedWidth = z;
    }

    public static /* synthetic */ QTPenViewInfo copy$default(QTPenViewInfo qTPenViewInfo, String str, int i, int i2, float f, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = qTPenViewInfo.name;
        }
        if ((i4 & 2) != 0) {
            i = qTPenViewInfo.color;
        }
        if ((i4 & 4) != 0) {
            i2 = qTPenViewInfo.sizeLevel;
        }
        if ((i4 & 8) != 0) {
            f = qTPenViewInfo.particleSize;
        }
        if ((i4 & 16) != 0) {
            z = qTPenViewInfo.isFixedWidth;
        }
        boolean z2 = z;
        int i5 = i2;
        return qTPenViewInfo.copy(str, i, i5, f, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSizeLevel() {
        return this.sizeLevel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getParticleSize() {
        return this.particleSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFixedWidth() {
        return this.isFixedWidth;
    }

    @NotNull
    public final QTPenViewInfo copy(@NotNull String name, int color, int sizeLevel, float particleSize, boolean isFixedWidth) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new QTPenViewInfo(name, color, sizeLevel, particleSize, isFixedWidth);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QTPenViewInfo)) {
            return false;
        }
        QTPenViewInfo qTPenViewInfo = (QTPenViewInfo) other;
        return Intrinsics.areEqual(this.name, qTPenViewInfo.name) && this.color == qTPenViewInfo.color && this.sizeLevel == qTPenViewInfo.sizeLevel && Float.compare(this.particleSize, qTPenViewInfo.particleSize) == 0 && this.isFixedWidth == qTPenViewInfo.isFixedWidth;
    }

    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final float getParticleSize() {
        return this.particleSize;
    }

    public final int getSizeLevel() {
        return this.sizeLevel;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isFixedWidth) + AbstractC0622a.m1156b(this.particleSize, AbstractC0622a.m1157c(this.sizeLevel, AbstractC0622a.m1157c(this.color, this.name.hashCode() * 31, 31), 31), 31);
    }

    public final boolean isFixedWidth() {
        return this.isFixedWidth;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setFixedWidth(boolean z) {
        this.isFixedWidth = z;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setParticleSize(float f) {
        this.particleSize = f;
    }

    public final void setSizeLevel(int i) {
        this.sizeLevel = i;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        int i = this.color;
        int i2 = this.sizeLevel;
        float f = this.particleSize;
        boolean z = this.isFixedWidth;
        StringBuilder sbM780v = AbstractC0541b.m780v("QTPenViewInfo(name=", i, str, ", color=", ", sizeLevel=");
        sbM780v.append(i2);
        sbM780v.append(", particleSize=");
        sbM780v.append(f);
        sbM780v.append(", isFixedWidth=");
        return AbstractC0000a.m14k(sbM780v, z, ")");
    }

    public /* synthetic */ QTPenViewInfo(String str, int i, int i2, float f, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, f, (i4 & 16) != 0 ? false : z);
    }
}
