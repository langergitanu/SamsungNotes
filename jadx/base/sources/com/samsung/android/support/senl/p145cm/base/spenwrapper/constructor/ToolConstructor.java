package com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor;

import android.content.Context;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.document.SDocLocker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/constructor/ToolConstructor;", "", "<init>", "()V", "makeSDocLocker", "Lcom/samsung/android/support/senl/document/SDocLocker;", "context", "Landroid/content/Context;", "makeSpenBodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "makeSpenCapturePage", "Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "makeSpenDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "makeSpenNotePdfImport", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfImport;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToolConstructor {

    @NotNull
    public static final ToolConstructor INSTANCE = new ToolConstructor();

    private ToolConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final SDocLocker makeSDocLocker(@Nullable Context context) {
        return new SDocLocker(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenBodyTextContext makeSpenBodyTextContext(@Nullable Context context) {
        return new SpenBodyTextContext(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenCapturePage makeSpenCapturePage(@Nullable Context context) {
        return new SpenCapturePage(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenDisplay makeSpenDisplay(@Nullable Context context) {
        return new SpenDisplay(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenNotePdfImport makeSpenNotePdfImport(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SpenNotePdfImport(context);
    }
}
