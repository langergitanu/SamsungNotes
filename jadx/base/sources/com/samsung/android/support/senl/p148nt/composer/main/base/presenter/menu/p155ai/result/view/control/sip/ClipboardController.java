package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.samsung.android.content.clipboard.SemClipboardManager;
import com.samsung.android.content.clipboard.data.SemClipData;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/sip/ClipboardController;", "", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getRootView", "()Landroid/view/View;", "setRootView", "pasteListener", "pasteAction", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/sip/IClipboardPaste;", "setPasteAction", "", "setClipboardFilter", "filterType", "", "message", "", "clearFilter", "showClipboard", "setClipboardDefaultFilter", "release", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ClipboardController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    @Nullable
    private IClipboardPaste pasteAction;

    @Nullable
    private Object pasteListener;

    @Nullable
    private View rootView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/sip/ClipboardController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getDefaultFilterType", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDefaultFilterType() {
            ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
            return companion.getInstance().getTypeText() | companion.getInstance().getTypeHtml();
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("ClipboardController");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public ClipboardController(@Nullable View view) {
        this.rootView = view;
    }

    private final void setClipboardFilter(int filterType, String message) {
        View view = this.rootView;
        Context context = view != null ? view.getContext() : null;
        if ((context instanceof Activity) && CommonUtils.isNotAvailableActivity((Activity) context)) {
            return;
        }
        if (this.pasteListener == null) {
            this.pasteListener = new SemClipboardManager.OnPasteListener() { // from class: n3.a
                public final void onPaste(SemClipData semClipData) {
                    ClipboardController.setClipboardFilter$lambda$1(this.f9593a, semClipData);
                }
            };
        }
        ClipboardManagerCompat.INSTANCE.getInstance().filterClip(context, filterType, this.pasteListener, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClipboardFilter$lambda$1(ClipboardController clipboardController, SemClipData semClipData) {
        String str = TAG;
        Logger.m10999d(str, "onPaste#");
        View view = clipboardController.rootView;
        if ((view != null ? view.findFocus() : null) == null) {
            Logger.m10999d(str, "OnPasteListener# failed to find focused view");
            return;
        }
        ClipData clipData = ClipboardManagerCompat.INSTANCE.getInstance().getClipData(semClipData);
        if (clipData != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC10960a(clipboardController, clipData, 27));
        } else {
            Logger.m10999d(str, "OnPasteListener# ClipData is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClipboardFilter$lambda$1$lambda$0(ClipboardController clipboardController, ClipData clipData) {
        IClipboardPaste iClipboardPaste = clipboardController.pasteAction;
        if (iClipboardPaste != null) {
            iClipboardPaste.doPaste(clipData);
        }
    }

    public final void clearFilter(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        View view = this.rootView;
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            AbstractC8014b.m7197C("clearFilter# isNotAvailableActivity from : ", message, TAG);
            return;
        }
        AbstractC8014b.m7197C("clearFilter# isNotAvailableActivity from : ", message, TAG);
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        companion.getInstance().finishBind(context);
        companion.getInstance().filterClip(context, companion.getInstance().getTypeNone(), null, message);
    }

    @Nullable
    public final View getRootView() {
        return this.rootView;
    }

    public final void release() {
        this.pasteListener = null;
        this.pasteAction = null;
        this.rootView = null;
    }

    public final void setClipboardDefaultFilter(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        setClipboardFilter(INSTANCE.getDefaultFilterType(), message);
    }

    public final void setPasteAction(@NotNull IClipboardPaste pasteAction) {
        Intrinsics.checkNotNullParameter(pasteAction, "pasteAction");
        this.pasteAction = pasteAction;
    }

    public final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    public final void showClipboard(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Companion companion = INSTANCE;
        setClipboardFilter(companion.getDefaultFilterType(), message);
        ClipboardManagerCompat companion2 = ClipboardManagerCompat.INSTANCE.getInstance();
        View view = this.rootView;
        Context context = view != null ? view.getContext() : null;
        View view2 = this.rootView;
        companion2.showDialog(context, view2 != null ? view2.findFocus() : null, companion.getDefaultFilterType(), this.pasteListener);
    }
}
