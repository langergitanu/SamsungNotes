package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/MathObject;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TaskObject;", HtmlConstants.LATEX, "", "isInline", "", "<init>", "(Ljava/lang/String;Z)V", "getLatex", "()Ljava/lang/String;", "()Z", "convertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
final /* data */ class MathObject extends TaskObject {
    private final boolean isInline;

    @NotNull
    private final String latex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MathObject(@NotNull String latex, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(latex, "latex");
        this.latex = latex;
        this.isInline = z;
    }

    public static /* synthetic */ MathObject copy$default(MathObject mathObject, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mathObject.latex;
        }
        if ((i & 2) != 0) {
            z = mathObject.isInline;
        }
        return mathObject.copy(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLatex() {
        return this.latex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsInline() {
        return this.isInline;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.DocumentElement
    @NotNull
    public SpenObjectBase convertObject() {
        return new SpenMathObjectTemp(this.latex, this.isInline);
    }

    @NotNull
    public final MathObject copy(@NotNull String latex, boolean isInline) {
        Intrinsics.checkNotNullParameter(latex, "latex");
        return new MathObject(latex, isInline);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MathObject)) {
            return false;
        }
        MathObject mathObject = (MathObject) other;
        return Intrinsics.areEqual(this.latex, mathObject.latex) && this.isInline == mathObject.isInline;
    }

    @NotNull
    public final String getLatex() {
        return this.latex;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isInline) + (this.latex.hashCode() * 31);
    }

    public final boolean isInline() {
        return this.isInline;
    }

    @NotNull
    public String toString() {
        return "MathObject(latex=" + this.latex + ", isInline=" + this.isInline + ")";
    }

    public /* synthetic */ MathObject(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }
}
