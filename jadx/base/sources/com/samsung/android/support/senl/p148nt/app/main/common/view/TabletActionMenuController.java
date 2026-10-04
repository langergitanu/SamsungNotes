package com.samsung.android.support.senl.p148nt.app.main.common.view;

import androidx.appcompat.widget.Toolbar;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/view/TabletActionMenuController;", "Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController;", "absFragment", "Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;", "recyclerView", "Lcom/samsung/android/support/senl/nt/app/common/penrecyclerview/PenRecyclerView;", "clickNavigateListener", "Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController$OnClickNavigateListener;", "contract", "Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;Lcom/samsung/android/support/senl/nt/app/common/penrecyclerview/PenRecyclerView;Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController$OnClickNavigateListener;Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController$Contract;)V", "setDisplayHomeAsUpEnabled", "", Constants.IntentExtraValue.SHOW, "", "isArrowIcon", "updateDrawerIconWithBadge", "setToolbarContentInsetsAbsolute", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getTag", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TabletActionMenuController extends ActionMenuController {

    @NotNull
    public static final String TAG = "TabletActionMenuController";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabletActionMenuController(@NotNull AbsFragment absFragment, @NotNull PenRecyclerView recyclerView, @Nullable ActionMenuController.OnClickNavigateListener onClickNavigateListener, @NotNull ActionMenuController.Contract contract) {
        super(absFragment, recyclerView, onClickNavigateListener, contract);
        Intrinsics.checkNotNullParameter(absFragment, "absFragment");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(contract, "contract");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController
    public void setDisplayHomeAsUpEnabled(boolean show) {
        if (DeviceInfo.isVSTModel()) {
            super.setDisplayHomeAsUpEnabled(true);
        } else {
            super.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController
    public void setToolbarContentInsetsAbsolute(@Nullable Toolbar toolbar) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController
    public void updateDrawerIconWithBadge() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController
    public void setDisplayHomeAsUpEnabled(boolean show, boolean isArrowIcon) {
        if (DeviceInfo.isVSTModel()) {
            super.setDisplayHomeAsUpEnabled(true, isArrowIcon);
        } else if (isPickEditSearchWidgetMode()) {
            super.setDisplayHomeAsUpEnabled(show, isArrowIcon);
        } else {
            super.setDisplayHomeAsUpEnabled(false);
        }
    }
}
