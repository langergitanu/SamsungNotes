package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.content.Context;
import android.view.Menu;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCopyTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCopy;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuItem;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getContext", "()Landroid/content/Context;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AiResultContextMenuCopy extends AiResultContextMenuItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmContextMenuCopy");

    @NotNull
    private final Context context;

    @NotNull
    private final SimpleEditView textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCopy$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultContextMenuCopy.TAG;
        }

        private Companion() {
        }
    }

    public AiResultContextMenuCopy(@NotNull Context context, @NotNull SimpleEditView textManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.context = context;
        this.textManager = textManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        AiResultContextMenuCode aiResultContextMenuCode = AiResultContextMenuCode.CONTEXT_MENU_ID_COPY;
        menu.add(0, aiResultContextMenuCode.getId(), aiResultContextMenuCode.getId(), C8875R.string.ctx_menu_copy).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public boolean canShow() {
        return this.textManager.isSelected();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        this.textManager.getTaskController().execute(new AiResultCopyTask(), new AiResultCopyTask.Inputs(this.context, this.textManager), new AiResultTask.Callback<AiResultCopyTask.Results>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.contextmenu.AiResultContextMenuCopy$executeMenu$callback$1
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

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final SimpleEditView getTextManager() {
        return this.textManager;
    }
}
