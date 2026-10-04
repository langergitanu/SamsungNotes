package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpenImageObjectTemp;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "src", "", "<init>", "(Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "downloadContentRef", "", "getDownloadContentRef", "()Ljava/lang/Object;", "setDownloadContentRef", "(Ljava/lang/Object;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenImageObjectTemp extends SpenObjectBase {
    public Object downloadContentRef;

    @Nullable
    private final String src;

    public SpenImageObjectTemp(@Nullable String str) {
        super(0);
        this.src = str;
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

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    public final void setDownloadContentRef(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.downloadContentRef = obj;
    }
}
