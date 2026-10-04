package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.view.Menu;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmPasteTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTaskController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.IClipboardPaste;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuPaste;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuItem;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/IClipboardPaste;", "context", "Landroid/content/Context;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "taskController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "paste", "clipData", "Landroid/content/ClipData;", "pastePosition", "Landroid/graphics/PointF;", "doPaste", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuPaste extends SmContextMenuItem implements IClipboardPaste {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmContextMenuPaste");

    @NotNull
    private final Context context;

    @NotNull
    private final SmModeControl modeControl;

    @NotNull
    private final SmObjectManager objectManager;

    @NotNull
    private final SmTaskController taskController;

    @NotNull
    private final SmTextManager textManager;

    @Nullable
    private final ToolShareControl toolShareControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuPaste$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmContextMenuPaste.TAG;
        }

        private Companion() {
        }
    }

    public SmContextMenuPaste(@NotNull Context context, @NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.context = context;
        this.taskController = smControlManager.getTaskController();
        this.objectManager = smControlManager.getObjectManager();
        this.textManager = smControlManager.getTextManager();
        this.modeControl = smControlManager.getModeControl();
        this.toolShareControl = smControlManager.getToolShareControl();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        SmContextMenuCode smContextMenuCode = SmContextMenuCode.CONTEXT_MENU_ID_PASTE;
        menu.add(0, smContextMenuCode.getId(), smContextMenuCode.getId(), C8875R.string.ctx_menu_paste).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public boolean canShow() {
        return this.modeControl.isEditMode() && ClipboardManagerCompat.INSTANCE.getInstance().hasPrimaryClip(this.context, ClipboardController.INSTANCE.getDefaultFilterType());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.IClipboardPaste
    public void doPaste(@NotNull ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "clipData");
        paste(clipData, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void executeMenu() {
        ClipData primaryClip = ClipboardManagerCompat.INSTANCE.getInstance().getPrimaryClip(this.context, ClipboardController.INSTANCE.getDefaultFilterType());
        String str = TAG;
        SmLogger.m8661d(str, "executeMenu#");
        if (primaryClip == null) {
            SmLogger.m8661d(str, "executeMenu# clipData is null");
        } else {
            paste(primaryClip, null);
        }
    }

    public final void paste(@NotNull ClipData clipData, @Nullable PointF pastePosition) {
        Intrinsics.checkNotNullParameter(clipData, "clipData");
        this.taskController.execute(new SmPasteTask(), new SmPasteTask.Inputs(this.context, this.objectManager, this.textManager, clipData, pastePosition), new SmTask.Callback<SmPasteTask.Results>() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuPaste$paste$callback$1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onFail(SmPasteTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onSuccess(SmPasteTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getErrorMsgStringId() != null) {
                    result.showErrorToast();
                }
                if (this.this$0.textManager.isOverHeight(this.this$0.context)) {
                    ToolShareControl toolShareControl = this.this$0.toolShareControl;
                    if (toolShareControl != null) {
                        toolShareControl.undo();
                    }
                    this.this$0.textManager.showExceedToast();
                }
            }
        });
    }
}
