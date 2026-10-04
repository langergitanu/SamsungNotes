package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import android.content.Context;
import android.view.Menu;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmCopyTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmCutTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCut;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCopy;", "context", "Landroid/content/Context;", "controlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "getModeControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuCut extends SmContextMenuCopy {

    @NotNull
    private final SmModeControl modeControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmContextMenuCut(@NotNull Context context, @NotNull SmControlManager controlManager) {
        super(context, controlManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(controlManager, "controlManager");
        this.modeControl = controlManager.getModeControl();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy, com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        SmContextMenuCode smContextMenuCode = SmContextMenuCode.CONTEXT_MENU_ID_CUT;
        menu.add(0, smContextMenuCode.getId(), smContextMenuCode.getId(), C8875R.string.ctx_menu_cut).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy, com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public boolean canShow() {
        return super.canShow() && this.modeControl.isEditMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy, com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuItem
    public void executeMenu() {
        getTaskController().execute(new SmCutTask(), new SmCopyTask.Inputs(getContext(), getObjectManager(), getTextManager()), new SmTask.Callback<SmCopyTask.Results>() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCut$executeMenu$callback$1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onSuccess(SmCopyTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onFail(SmCopyTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.showErrorToast();
            }
        });
    }

    @NotNull
    public final SmModeControl getModeControl() {
        return this.modeControl;
    }
}
