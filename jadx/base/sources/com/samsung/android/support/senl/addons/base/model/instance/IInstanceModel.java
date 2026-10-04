package com.samsung.android.support.senl.addons.base.model.instance;

import android.content.res.Configuration;
import android.os.Bundle;
import com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.model.IEventListener;
import com.samsung.android.support.senl.addons.base.model.ILifeCycleController;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.common.ISavableModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0010H&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0010H&J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\b\u0010\u001f\u001a\u00020\u0010H&J\b\u0010 \u001a\u00020\u0007H&¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/ISavableModel;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "Lcom/samsung/android/support/senl/addons/base/model/IEventListener;", "Lcom/samsung/android/support/senl/addons/base/model/IBaseOptionItemControl;", "onCreate", "", "setArgument", "argument", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateDisallowTouchDownArea", "enable", "", "navigationBarHeight", "", "onPause", "onResume", "onDestroyView", "isMultiwindow", "setMultiwindow", "setLifeCycleController", "controller", "Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;", "setDataHandler", "handler", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "getDataHandler", "isClosed", "pendingSaveForRecreatedView", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IInstanceModel extends IBaseModel, ISavableModel, IScreenModel, IEventListener, IBaseOptionItemControl {
    @Nullable
    /* JADX INFO: renamed from: getDataHandler */
    IDataHandler getMDataHandler();

    /* JADX INFO: renamed from: isClosed */
    boolean getMIsClosed();

    /* JADX INFO: renamed from: isMultiwindow */
    boolean getMIsMultiwindow();

    void onConfigurationChanged(@NotNull Configuration newConfig);

    void onCreate();

    void onDestroyView();

    void onPause();

    void onResume();

    void pendingSaveForRecreatedView();

    void setArgument(@Nullable Bundle argument);

    void setDataHandler(@Nullable IDataHandler handler);

    void setLifeCycleController(@Nullable ILifeCycleController controller);

    void setMultiwindow(boolean isMultiwindow);

    void updateDisallowTouchDownArea(boolean enable, int navigationBarHeight);
}
