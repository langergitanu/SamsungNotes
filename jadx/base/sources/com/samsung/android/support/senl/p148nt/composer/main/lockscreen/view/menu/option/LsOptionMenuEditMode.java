package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/menu/option/LsOptionMenuEditMode;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/OptionMenuEditMode;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuPresenter;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuPresenter;)V", "mKeyguardPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;", "onCreateOptionsMenu", "", "param", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/OptionMenuParam;", "updateSaveMenu", "onOptionsItemSelected", "", "itemId", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsOptionMenuEditMode extends OptionMenuEditMode {

    @NotNull
    private KeyguardPresenter mKeyguardPresenter;

    public LsOptionMenuEditMode(@Nullable Activity activity, @Nullable OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        KeyguardPresenter keyguardPresenter = this.mPresenter.getKeyguardPresenter();
        Intrinsics.checkNotNull(keyguardPresenter);
        this.mKeyguardPresenter = keyguardPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onCreateOptionsMenu(@NotNull OptionMenuParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        super.onCreateOptionsMenu(param);
        if (this.mKeyguardPresenter.isInitialLockDismissed()) {
            return;
        }
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_search));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_full_screen_mode));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_add_to));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_start_in_app_collaboration));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_share_note));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_export));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_add_favorite));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_lock));
        this.mOptionMenuBehavior.removeMenu(param.setChildResId(C9086R.id.action_delete));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NotNull OptionMenuParam param, int itemId) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (itemId == C9086R.id.action_save) {
            this.mPresenter.onClickDone();
            return true;
        }
        if (itemId == C9086R.id.action_add || itemId == C9086R.id.action_share || itemId == C9086R.id.action_export || itemId == C9086R.id.action_sort_pages || itemId == C9086R.id.action_tablet_sort_pages || itemId == C9086R.id.action_change_note_style || itemId == C9086R.id.action_add_edit_hash_tag || itemId == C9086R.id.action_print) {
            this.mKeyguardPresenter.dismissKeyguard(this.mActivity, new RunnableC0101a(this, param, itemId, 0));
            return true;
        }
        super.onOptionsItemSelected(param, itemId);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode
    public void updateSaveMenu(@NotNull OptionMenuParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        super.updateSaveMenu(param);
        if (this.mKeyguardPresenter.isInitialLockDismissed()) {
            return;
        }
        this.mOptionMenuBehavior.setTitle(param.setChildResId(C9086R.id.action_save), C9086R.string.ai_done);
    }
}
