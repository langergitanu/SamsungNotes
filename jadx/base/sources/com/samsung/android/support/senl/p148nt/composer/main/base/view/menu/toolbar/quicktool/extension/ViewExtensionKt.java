package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.extension;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"isLtr", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "ntComposer_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewExtensionKt {
    public static final boolean isLtr(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getLayoutDirection() == 0;
    }
}
