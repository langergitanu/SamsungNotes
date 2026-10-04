package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.content.Context;
import android.view.Menu;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCopyTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCutTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCut;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCopy;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuCut extends AiResultContextMenuCopy {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiResultContextMenuCut(@NotNull Context context, @NotNull SimpleEditView textManager) {
        super(context, textManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuCopy, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (getTextManager().isEditMode()) {
            AiResultContextMenuCode aiResultContextMenuCode = AiResultContextMenuCode.CONTEXT_MENU_ID_CUT;
            menu.add(0, aiResultContextMenuCode.getId(), aiResultContextMenuCode.getId(), C8875R.string.ctx_menu_cut).setEnabled(canShow());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuCopy, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        getTextManager().getTaskController().execute(new AiResultCutTask(), new AiResultCopyTask.Inputs(getContext(), getTextManager()), new AiResultTask.Callback<AiResultCopyTask.Results>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.contextmenu.AiResultContextMenuCut$executeMenu$callback$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
            public void onSuccess(AiResultCopyTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultTask.Callback
            public void onFail(AiResultCopyTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.showErrorToast();
            }
        });
    }
}
