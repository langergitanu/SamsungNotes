package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/helper/BackPressedHelper;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "viewParams", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ViewParams;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ViewParams;Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;)V", "mOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "updateOnBackInvokedCallback", "", "unregisterBackInvokedCallback", "isSupportedPredictiveGesture", "", "needRegisterBackInvokedCallback", "onDestroy", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BackPressedHelper {

    @NotNull
    private static final String TAG = "BackPressedHelper";

    @NotNull
    private final FragmentActivity activity;

    @Nullable
    private OnBackInvokedCallback mOnBackInvokedCallback;

    @NotNull
    private final StateInfo stateInfo;

    @NotNull
    private final ViewParams viewParams;

    public BackPressedHelper(@NotNull FragmentActivity activity, @NotNull ViewParams viewParams, @NotNull StateInfo stateInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        Intrinsics.checkNotNullParameter(stateInfo, "stateInfo");
        this.activity = activity;
        this.viewParams = viewParams;
        this.stateInfo = stateInfo;
    }

    private final boolean needRegisterBackInvokedCallback() {
        int modeIndex = this.stateInfo.getModeIndex();
        String folderUuid = this.stateInfo.getFolderUuid();
        Intrinsics.checkNotNullExpressionValue(folderUuid, "getFolderUuid(...)");
        return ((1 == modeIndex || 7 == modeIndex || 25 == modeIndex || 28 == modeIndex) && (Intrinsics.areEqual(FolderConstants.AllNotes.UUID, folderUuid) || Intrinsics.areEqual(FolderConstants.MyFolders.UUID, folderUuid))) ? false : true;
    }

    @RequiresApi(36)
    private final void unregisterBackInvokedCallback() {
        if (this.mOnBackInvokedCallback != null && isSupportedPredictiveGesture()) {
            MainLogger.m7254d(TAG, "unregisterBackInvokedCallback");
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.activity.getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.mOnBackInvokedCallback;
            Intrinsics.checkNotNull(onBackInvokedCallback);
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
            this.mOnBackInvokedCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateOnBackInvokedCallback$lambda$0(BackPressedHelper backPressedHelper) {
        MainLogger.m7254d(TAG, "updateOnBackInvokedCallback# onBackInvoked");
        backPressedHelper.viewParams.getNotesView().onBackInvoked();
    }

    public final boolean isSupportedPredictiveGesture() {
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT >= 36;
        if (!FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() ? DeviceUtils.isPhoneModel() : DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(this.viewParams.getContext().getResources().getConfiguration())) {
            z = z2;
        }
        AbstractC8014b.m7210l("isSupportedPredictiveGesture# ", TAG, z);
        return z;
    }

    public final void onDestroy() {
        if (Build.VERSION.SDK_INT >= 36) {
            unregisterBackInvokedCallback();
        }
    }

    @RequiresApi(36)
    public final void updateOnBackInvokedCallback() {
        if (isSupportedPredictiveGesture()) {
            if (!needRegisterBackInvokedCallback()) {
                unregisterBackInvokedCallback();
                return;
            }
            if (this.mOnBackInvokedCallback != null) {
                unregisterBackInvokedCallback();
            }
            MainLogger.m7254d(TAG, "updateOnBackInvokedCallback");
            this.mOnBackInvokedCallback = new OnBackInvokedCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.a
                public final void onBackInvoked() {
                    BackPressedHelper.updateOnBackInvokedCallback$lambda$0(this.f6196a);
                }
            };
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.activity.getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.mOnBackInvokedCallback;
            Intrinsics.checkNotNull(onBackInvokedCallback);
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback);
        }
    }
}
