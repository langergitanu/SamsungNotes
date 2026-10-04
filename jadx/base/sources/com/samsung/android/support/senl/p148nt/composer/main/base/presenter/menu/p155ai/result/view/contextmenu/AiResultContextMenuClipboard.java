package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import android.view.Menu;
import com.samsung.android.sdk.composer.SpenTextView;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuClipboard;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuItem;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextView;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextView;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "clipboardController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ClipboardController;", "kotlin.jvm.PlatformType", "canShow", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "executeMenu", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuClipboard extends AiResultContextMenuItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmContextMenuClipboard");
    private final ClipboardController clipboardController;

    @NotNull
    private final SpenTextView spenView;

    @NotNull
    private final SimpleEditView textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuClipboard$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultContextMenuClipboard.TAG;
        }

        private Companion() {
        }
    }

    public AiResultContextMenuClipboard(@NotNull SpenTextView spenView, @NotNull SimpleEditView textManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.spenView = spenView;
        this.textManager = textManager;
        this.clipboardController = textManager.getClipboardController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void addMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        AiResultContextMenuCode aiResultContextMenuCode = AiResultContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD;
        menu.add(0, aiResultContextMenuCode.getId(), aiResultContextMenuCode.getId(), C8875R.string.ctx_menu_clipboard).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public boolean canShow() {
        if (this.textManager.isEditMode() && DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.spenView.getContext())) {
            return ClipboardManagerCompat.INSTANCE.getInstance().canShowClipboard(this.spenView.getContext(), this.spenView.getRootView().findFocus());
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeMenu");
        this.textManager.clearSelection();
    }

    @NotNull
    public final SimpleEditView getTextManager() {
        return this.textManager;
    }
}
