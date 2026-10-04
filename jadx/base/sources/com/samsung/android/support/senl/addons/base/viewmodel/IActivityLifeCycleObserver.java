package com.samsung.android.support.senl.addons.base.viewmodel;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl;
import com.samsung.android.support.senl.addons.base.model.IEventListener;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenMode;
import com.samsung.android.support.senl.addons.base.model.screen.IWindowMode;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\tH&J\b\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\tH&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/ILifeCycleObserver;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IWindowMode;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenMode;", "Lcom/samsung/android/support/senl/addons/base/model/IEventListener;", "Lcom/samsung/android/support/senl/addons/base/model/IBaseOptionItemControl;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IOrientationMode;", "onCreate", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onStop", "onDestroy", "onDestroyView", "onMultiWindowModeChanged", "isInMultiWindowMode", "", "getInflateCallback", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IActivityLifeCycleObserver extends IBaseViewModel, ILifeCycleObserver, IWindowMode, IScreenMode, IEventListener, IBaseOptionItemControl, IOrientationMode {
    @Nullable
    ICanvasContainer.OnInflateCallback getInflateCallback();

    void onConfigurationChanged(@Nullable Configuration newConfig);

    void onCreate(@Nullable Intent intent, @Nullable Bundle savedInstanceState);

    void onDestroy();

    void onDestroyView();

    void onMultiWindowModeChanged(boolean isInMultiWindowMode);

    void onPause();

    void onResume();

    void onSaveInstanceState(@Nullable Bundle outState);

    void onStart();

    void onStop();
}
