package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.view.Menu;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultPasteTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip.IClipboardPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuPaste;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuItem;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/sip/IClipboardPaste;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "taskController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTaskController;", "kotlin.jvm.PlatformType", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "paste", "clipData", "Landroid/content/ClipData;", "pastePosition", "Landroid/graphics/PointF;", "doPaste", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuPaste extends AiResultContextMenuItem implements IClipboardPaste {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmContextMenuPaste");

    @NotNull
    private final Context context;
    private final AiResultTaskController taskController;

    @NotNull
    private final SimpleEditView textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuPaste$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultContextMenuPaste.TAG;
        }

        private Companion() {
        }
    }

    public AiResultContextMenuPaste(@NotNull Context context, @NotNull SimpleEditView textManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.context = context;
        this.textManager = textManager;
        this.taskController = textManager.getTaskController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        AiResultContextMenuCode aiResultContextMenuCode = AiResultContextMenuCode.CONTEXT_MENU_ID_PASTE;
        menu.add(0, aiResultContextMenuCode.getId(), aiResultContextMenuCode.getId(), C8875R.string.ctx_menu_paste).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public boolean canShow() {
        if (this.textManager.isEditMode()) {
            return ClipboardManagerCompat.INSTANCE.getInstance().hasPrimaryClip(this.context, ClipboardController.INSTANCE.getDefaultFilterType());
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip.IClipboardPaste
    public void doPaste(@NotNull ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "clipData");
        paste(clipData, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        ClipData primaryClip = ClipboardManagerCompat.INSTANCE.getInstance().getPrimaryClip(this.context, ClipboardController.INSTANCE.getDefaultFilterType());
        String str = TAG;
        Logger.m10999d(str, "executeMenu#");
        if (primaryClip == null) {
            Logger.m10999d(str, "executeMenu# clipData is null");
        } else {
            paste(primaryClip, null);
        }
    }

    @NotNull
    public final SimpleEditView getTextManager() {
        return this.textManager;
    }

    public final void paste(@NotNull ClipData clipData, @Nullable PointF pastePosition) {
        Intrinsics.checkNotNullParameter(clipData, "clipData");
        this.taskController.execute(new AiResultPasteTask(), new AiResultPasteTask.Inputs(this.context, this.textManager, clipData), new AiResultTask.Callback<AiResultPasteTask.Results>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.contextmenu.AiResultContextMenuPaste$paste$callback$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
            public void onSuccess(AiResultPasteTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
            public void onFail(AiResultPasteTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.showErrorToast();
            }
        });
    }
}
