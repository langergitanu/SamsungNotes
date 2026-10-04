package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpenMathObjectTemp;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", HtmlConstants.LATEX, "", "isInline", "", "<init>", "(Ljava/lang/String;Z)V", "getLatex", "()Ljava/lang/String;", "()Z", "downloadContentRef", "", "getDownloadContentRef", "()Ljava/lang/Object;", "setDownloadContentRef", "(Ljava/lang/Object;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenMathObjectTemp extends SpenObjectBase {
    public Object downloadContentRef;
    private final boolean isInline;

    @NotNull
    private final String latex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMathObjectTemp(@NotNull String latex, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(latex, "latex");
        this.latex = latex;
        this.isInline = z;
    }

    @NotNull
    public final Object getDownloadContentRef() {
        Object obj = this.downloadContentRef;
        if (obj != null) {
            return obj;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadContentRef");
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getLatex() {
        return this.latex;
    }

    /* JADX INFO: renamed from: isInline, reason: from getter */
    public final boolean getIsInline() {
        return this.isInline;
    }

    public final void setDownloadContentRef(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.downloadContentRef = obj;
    }
}
