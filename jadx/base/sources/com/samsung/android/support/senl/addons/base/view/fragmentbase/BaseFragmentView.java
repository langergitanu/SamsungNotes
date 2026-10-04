package com.samsung.android.support.senl.addons.base.view.fragmentbase;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.MainThread;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.model.IEventListener;
import com.samsung.android.support.senl.addons.base.model.ILifeCycleController;
import com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel;
import com.samsung.android.support.senl.addons.base.utils.FeatureInfo;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.utils.ScreenUtils;
import com.samsung.android.support.senl.addons.base.view.common.IBindHelper;
import com.samsung.android.support.senl.addons.base.view.common.ScreenData;
import com.samsung.android.support.senl.addons.base.view.inputblockcontainers.IInputIntercepter;
import com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 k2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001kB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H$J(\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H$J\u0012\u0010.\u001a\u00020/2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u00100\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J&\u00102\u001a\u0004\u0018\u0001032\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00104\u001a\u00020/H\u0016J\b\u00105\u001a\u00020/H\u0016J\b\u00106\u001a\u00020/H\u0016J\b\u00107\u001a\u00020/H\u0016J\b\u00108\u001a\u00020/H\u0016J\b\u00109\u001a\u00020/H\u0016J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\rH\u0014J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u0019H\u0014J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020,H\u0014J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010E\u001a\u00020,2\u0006\u0010C\u001a\u00020,H\u0014J\b\u0010F\u001a\u00020/H\u0002J\u0018\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020,H\u0014J\b\u0010J\u001a\u00020/H\u0014J\u0010\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020 H\u0016J\u0010\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\u0019H\u0016J\b\u0010R\u001a\u00020/H\u0002J \u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u0019H\u0016J \u0010W\u001a\u00020/2\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u0019H\u0016J\u0010\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020,H\u0016J\b\u0010Z\u001a\u00020\u0019H\u0016J\u0010\u0010[\u001a\u00020/2\u0006\u0010\\\u001a\u00020\u0019H\u0016J\u001a\u0010]\u001a\u00020/2\u0006\u0010^\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020\u0019H\u0016J\u0010\u0010c\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0019H\u0016J\b\u0010d\u001a\u00020/H\u0016J\u000e\u0010e\u001a\u00020/2\u0006\u0010\u001f\u001a\u00020 J\b\u0010f\u001a\u00020\u0019H\u0016J\u0010\u0010g\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0019H\u0014J\u0010\u0010h\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0019H\u0003J\b\u0010i\u001a\u00020/H\u0002J\u0010\u0010j\u001a\u00020/2\u0006\u0010Y\u001a\u00020,H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView;", "Landroidx/fragment/app/Fragment;", "Lcom/samsung/android/support/senl/addons/base/model/IEventListener;", "Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;", "<init>", "()V", "mModel", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "getMModel", "()Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "setMModel", "(Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;)V", "mLifeCycleObserver", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;", "getMLifeCycleObserver", "()Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;", "setMLifeCycleObserver", "(Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;)V", "mSDataHandler", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "getMSDataHandler", "()Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "setMSDataHandler", "(Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;)V", "mIsOnFinish", "", "mBindHelper", "Lcom/samsung/android/support/senl/addons/base/view/common/IBindHelper;", "mRotationListener", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/ScreenLockRotationListener;", "createModel", "savedInstanceState", "Landroid/os/Bundle;", "bindingViewModel", "model", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "mLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "mOrientationEventListener", "Landroid/view/OrientationEventListener;", "mCurrentOrientation", "", "mPreviousOrientation", "onCreate", "", "getDataHandle", "makeModel", "onCreateView", "Landroid/view/View;", "onDestroyView", "onDestroy", "onStart", "onResume", "onPause", "onStop", "checkHideNavigationBar", "enable", "setLifeCycleObserver", "observer", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "isEnabledMenuItem", "getOptionMenuId", "resId", "onContextItemSelected", "getContextMenuId", "setOptionMenuCallback", "onOptionMenuPropertyChanged", "id", "type", "updateWindowSize", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "setWindowPaddingCutout", "onKeyDown", "keycode", "withCtrl", "withShift", "onKeyUp", "onBLEEvent", "eventId", "onBack", "onFinishDocumentByUser", "save", "requestSetResult", "resultCode", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "requestFinish", "isSaved", "requestBlockUserInput", "bringToFront", "onRestoreInstanceState", "requestChangeView", "enableRotation", "enableRotationInner", "createRotationListener", "onDispatchEvent", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseFragmentView extends Fragment implements IEventListener, ILifeCycleController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("BaseFragmentView");

    @Nullable
    private static IInstanceModel sInstanceModel;

    @Nullable
    private IBindHelper mBindHelper;
    private boolean mIsOnFinish;

    @Nullable
    private View.OnLayoutChangeListener mLayoutChangeListener;

    @Nullable
    private IActivityLifeCycleObserver mLifeCycleObserver;

    @Nullable
    private IInstanceModel mModel;

    @Nullable
    private OrientationEventListener mOrientationEventListener;

    @Nullable
    private ScreenLockRotationListener mRotationListener;

    @Nullable
    private IDataHandler mSDataHandler;
    private int mCurrentOrientation = -1;
    private int mPreviousOrientation = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstanceModel", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "storeInstanceModel", "", "fragmentView", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void storeInstanceModel(@NotNull BaseFragmentView fragmentView) {
            Intrinsics.checkNotNullParameter(fragmentView, "fragmentView");
            Logger.m7100d(BaseFragmentView.TAG, "storeInstanceModel - " + fragmentView.getMModel());
            BaseFragmentView.sInstanceModel = fragmentView.getMModel();
        }

        private Companion() {
        }
    }

    private final void checkHideNavigationBar(boolean enable) {
        FragmentActivity activity = getActivity();
        if (activity == null || this.mModel == null || !FeatureInfo.hideNavigationBar(activity)) {
            return;
        }
        int navigationBarHeight = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeight(activity);
        IInstanceModel iInstanceModel = this.mModel;
        if (iInstanceModel != null) {
            iInstanceModel.updateDisallowTouchDownArea(enable, navigationBarHeight);
        }
    }

    private final void createRotationListener() {
        Context context = getContext();
        if (context != null) {
            this.mRotationListener = new ScreenLockRotationListener(context, this.mModel);
        } else {
            Logger.m7101e(TAG, "getContext is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableRotation$lambda$1(BaseFragmentView baseFragmentView, boolean z) {
        if (baseFragmentView.getActivity() == null || baseFragmentView.requireActivity().isFinishing()) {
            return;
        }
        baseFragmentView.enableRotationInner(z);
    }

    @MainThread
    private final void enableRotationInner(boolean enable) {
        String str = TAG;
        AbstractC6670b.m4764y("enable rotation : ", str, enable);
        if (enable) {
            if (this.mRotationListener == null) {
                createRotationListener();
            }
            ScreenLockRotationListener screenLockRotationListener = this.mRotationListener;
            Intrinsics.checkNotNull(screenLockRotationListener);
            screenLockRotationListener.start(getContext());
            Logger.m7104i(str, "enable rotation");
            return;
        }
        ScreenLockRotationListener screenLockRotationListener2 = this.mRotationListener;
        if (screenLockRotationListener2 != null) {
            Intrinsics.checkNotNull(screenLockRotationListener2);
            screenLockRotationListener2.stop();
            Logger.m7104i(str, "disable rotation");
            this.mRotationListener = null;
            return;
        }
        Logger.m7101e(str, "enable rotation : " + enable + " -> null listener");
    }

    private final IDataHandler getDataHandle() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Intent intent;
        FragmentActivity activity = getActivity();
        Class cls = (Class) ((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("data_handler_class"));
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.base.model.IDataHandler");
        return (IDataHandler) objNewInstance;
    }

    private final boolean makeModel(Bundle savedInstanceState) {
        String str = TAG;
        Logger.m7100d(str, "makeModel");
        try {
            IInstanceModel iInstanceModel = sInstanceModel;
            if (iInstanceModel != null) {
                Intrinsics.checkNotNull(iInstanceModel);
                this.mSDataHandler = iInstanceModel.getMDataHandler();
                this.mModel = sInstanceModel;
                sInstanceModel = null;
            } else {
                IDataHandler dataHandle = getDataHandle();
                this.mSDataHandler = dataHandle;
                if (dataHandle != null) {
                    dataHandle.onCreate(getActivity(), savedInstanceState);
                }
                Logger.m7100d(str, "create model");
                this.mModel = createModel(savedInstanceState);
            }
            if (this.mModel == null) {
                return false;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                IInstanceModel iInstanceModel2 = this.mModel;
                Intrinsics.checkNotNull(iInstanceModel2);
                iInstanceModel2.setArgument(arguments);
                setArguments(null);
            }
            if (savedInstanceState == null) {
                return true;
            }
            Logger.m7100d(str, "onCreateView : load data from savedInstanceState");
            IInstanceModel iInstanceModel3 = this.mModel;
            Intrinsics.checkNotNull(iInstanceModel3);
            iInstanceModel3.onLoadFromInstanceState(savedInstanceState);
            return true;
        } catch (Exception e) {
            Logger.m7101e(TAG, "makeModel : failed create SDocHandler : " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BaseFragmentView baseFragmentView, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i2;
        int i11 = i9 - i7;
        if (i4 - i == i8 - i6 && i10 == i11) {
            return;
        }
        baseFragmentView.updateWindowSize();
    }

    private final void setOptionMenuCallback() {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.setOptionChangeCallback(new IBaseOptionItemControl.IOptionChangeCallback() { // from class: com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView.setOptionMenuCallback.1
                @Override // com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl.IOptionChangeCallback
                public void onChanged(int id, int type) {
                    BaseFragmentView.this.onOptionMenuPropertyChanged(id, type);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setWindowPaddingCutout() {
        if (Build.VERSION.SDK_INT >= 29) {
            Logger.m7100d(TAG, "setWindowPaddingCutout");
            FragmentActivity activity = getActivity();
            WindowManager windowManager = activity != null ? activity.getWindowManager() : null;
            Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
            DisplayCutout cutout = defaultDisplay != null ? defaultDisplay.getCutout() : null;
            if (cutout != null) {
                int safeInsetTop = cutout.getSafeInsetTop();
                int safeInsetBottom = cutout.getSafeInsetBottom();
                int safeInsetLeft = cutout.getSafeInsetLeft();
                int safeInsetRight = cutout.getSafeInsetRight();
                View view = getView();
                if (view != null) {
                    view.setPadding(safeInsetLeft, safeInsetTop, safeInsetRight, safeInsetBottom);
                }
            }
        }
    }

    @JvmStatic
    public static final void storeInstanceModel(@NotNull BaseFragmentView baseFragmentView) {
        INSTANCE.storeInstanceModel(baseFragmentView);
    }

    @Nullable
    public abstract IBindHelper bindingViewModel(@Nullable IInstanceModel model, @Nullable LayoutInflater inflater, @Nullable ViewGroup container);

    @Override // com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public void bringToFront() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof IBaseActivity) {
            ((IBaseActivity) activity).bringToFront();
        }
    }

    @Nullable
    public abstract IInstanceModel createModel(@Nullable Bundle savedInstanceState);

    public void enableRotation(boolean enable) {
        if (PlatformUtil.isOnMainUIThread()) {
            enableRotationInner(enable);
            return;
        }
        if (getActivity() == null) {
            Logger.m7101e(TAG, "enableRotation : couldn't run on main thread");
        }
        requireActivity().runOnUiThread(new RunnableC0116a(8, this, enable));
    }

    public int getContextMenuId(int resId) {
        return 1000;
    }

    @Nullable
    public final IActivityLifeCycleObserver getMLifeCycleObserver() {
        return this.mLifeCycleObserver;
    }

    @Nullable
    public final IInstanceModel getMModel() {
        return this.mModel;
    }

    @Nullable
    public final IDataHandler getMSDataHandler() {
        return this.mSDataHandler;
    }

    public int getOptionMenuId(int resId) {
        return resId == 16908332 ? 1001 : 1000;
    }

    public boolean isEnabledMenuItem() {
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.bleremote.IBLEListener
    public void onBLEEvent(int eventId) {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onBLEEvent(eventId);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public boolean onBack() {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            return iActivityLifeCycleObserver.onBack();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.m7100d(TAG, "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        updateWindowSize();
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onConfigurationChanged(newConfig);
        }
        IActivityLifeCycleObserver iActivityLifeCycleObserver2 = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver2 != null) {
            iActivityLifeCycleObserver2.setWindowType(ScreenUtils.getWindowType(getActivity()));
        }
        ScreenLockRotationListener screenLockRotationListener = this.mRotationListener;
        if (screenLockRotationListener != null) {
            screenLockRotationListener.onConfigurationChanged(getContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.m7100d(TAG, "onContextItemSelected()");
        if (!isEnabledMenuItem()) {
            return false;
        }
        int contextMenuId = getContextMenuId(item.getItemId());
        if (contextMenuId == 1000) {
            return super.onContextItemSelected(item);
        }
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver == null) {
            return true;
        }
        iActivityLifeCycleObserver.onOptionItemSelected(contextMenuId);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.mModel == null) {
            String str = TAG;
            Logger.m7100d(str, "onCreateView - has null model");
            if (!makeModel(savedInstanceState)) {
                Logger.m7101e(str, "onCreateView : failed create model");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return new View(getContext());
            }
        }
        IBindHelper iBindHelperBindingViewModel = bindingViewModel(this.mModel, inflater, container);
        this.mBindHelper = iBindHelperBindingViewModel;
        final View root = iBindHelperBindingViewModel != null ? iBindHelperBindingViewModel.getRoot() : null;
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            FragmentActivity activity2 = getActivity();
            iActivityLifeCycleObserver.onCreate(activity2 != null ? activity2.getIntent() : null, savedInstanceState);
        }
        updateWindowSize();
        ViewOnLayoutChangeListenerC0162a viewOnLayoutChangeListenerC0162a = new ViewOnLayoutChangeListenerC0162a(this, 3);
        this.mLayoutChangeListener = viewOnLayoutChangeListenerC0162a;
        if (root != null) {
            root.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0162a);
        }
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        if (!companion.getInstance().isMultiWindowMode(getActivity())) {
            checkHideNavigationBar(true);
        }
        companion.getInstance().disableSystemBarInsets(root);
        companion.getInstance().disableSystemBarInsetsNoDisplayCutout(root);
        OrientationEventListener orientationEventListener = new OrientationEventListener(getContext()) { // from class: com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView.onCreateView.2
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                Context context = BaseFragmentView.this.getContext();
                Object systemService = context != null ? context.getSystemService("window") : null;
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                BaseFragmentView.this.mCurrentOrientation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
                if (BaseFragmentView.this.mCurrentOrientation == BaseFragmentView.this.mPreviousOrientation) {
                    return;
                }
                if (BaseFragmentView.this.mCurrentOrientation == 1) {
                    BaseFragmentView.this.setWindowPaddingCutout();
                    BaseFragmentView baseFragmentView = BaseFragmentView.this;
                    baseFragmentView.mPreviousOrientation = baseFragmentView.mCurrentOrientation;
                } else {
                    View view = root;
                    if (view != null) {
                        view.setPadding(0, 0, 0, 0);
                    }
                    BaseFragmentView baseFragmentView2 = BaseFragmentView.this;
                    baseFragmentView2.mPreviousOrientation = baseFragmentView2.mCurrentOrientation;
                }
                AbstractC6670b.m4761v(BaseFragmentView.this.mCurrentOrientation, "onOrientationChanged, orientation = ", BaseFragmentView.TAG);
            }
        };
        this.mOrientationEventListener = orientationEventListener;
        orientationEventListener.enable();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mIsOnFinish = true;
        super.onDestroy();
        Logger.m7100d(TAG, "onDestroy");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = getView();
        if (view != null) {
            view.removeOnLayoutChangeListener(this.mLayoutChangeListener);
            this.mLayoutChangeListener = null;
        }
        IBindHelper iBindHelper = this.mBindHelper;
        if (iBindHelper != null) {
            Intrinsics.checkNotNull(iBindHelper);
            iBindHelper.close();
            this.mBindHelper = null;
        }
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            Intrinsics.checkNotNull(iActivityLifeCycleObserver);
            iActivityLifeCycleObserver.onDestroyView();
            this.mLifeCycleObserver = null;
        }
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.mOrientationEventListener = null;
        super.onDestroyView();
        Logger.m7100d(TAG, "onDestroyView");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onDispatchEvent(int eventId) {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            Intrinsics.checkNotNull(iActivityLifeCycleObserver);
            iActivityLifeCycleObserver.onDispatchEvent(eventId);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onFinishDocumentByUser(boolean save) {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onFinishDocumentByUser(save);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyDown(int keycode, boolean withCtrl, boolean withShift) {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onKeyDown(keycode, withCtrl, withShift);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyUp(int keycode, boolean withCtrl, boolean withShift) {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onKeyUp(keycode, withCtrl, withShift);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Logger.m7100d(TAG, "onMultiWindowModeChanged");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onMultiWindowModeChanged(isInMultiWindowMode);
        }
        checkHideNavigationBar(!isInMultiWindowMode);
    }

    public void onOptionMenuPropertyChanged(int id, int type) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.m7100d(TAG, "onOptionsItemSelected");
        if (!isEnabledMenuItem()) {
            return false;
        }
        int optionMenuId = getOptionMenuId(item.getItemId());
        if (optionMenuId == 1000) {
            return super.onOptionsItemSelected(item);
        }
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver == null) {
            return true;
        }
        iActivityLifeCycleObserver.onOptionItemSelected(optionMenuId);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onPause();
        }
        ScreenLockRotationListener screenLockRotationListener = this.mRotationListener;
        if (screenLockRotationListener != null) {
            screenLockRotationListener.onPause();
        }
        super.onPause();
        Logger.m7100d(TAG, "onPause()");
    }

    public final void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        Logger.m7100d(TAG, "onRestoreInstanceState() - " + savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Logger.m7100d(TAG, "onResume");
        super.onResume();
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onResume();
        }
        ScreenLockRotationListener screenLockRotationListener = this.mRotationListener;
        if (screenLockRotationListener != null) {
            screenLockRotationListener.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Logger.m7100d(TAG, "onSaveInstanceState : " + outState);
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onSaveInstanceState(outState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Logger.m7100d(TAG, "onStart");
        super.onStart();
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        if (iActivityLifeCycleObserver != null) {
            iActivityLifeCycleObserver.onStop();
        }
        super.onStop();
        Logger.m7100d(TAG, "onStop");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public void requestBlockUserInput(boolean enable) {
        if (getActivity() != null) {
            KeyEvent.Callback view = getView();
            if (view instanceof IInputIntercepter) {
                Logger.m7100d(TAG, "Block User Input ? " + enable + " / by TouchIntercept");
                ((IInputIntercepter) view).ignoreInputEvent(enable);
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public boolean requestChangeView() {
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public void requestFinish(boolean isSaved) {
        if (this.mIsOnFinish) {
            return;
        }
        Logger.m7100d(TAG, "requestFinish");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            requireActivity().finish();
        }
        this.mIsOnFinish = true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public void requestSetResult(int resultCode, @Nullable Intent intent) {
        Logger.m7100d(TAG, "requestSetResult resultCode : " + resultCode);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(resultCode, intent);
        }
    }

    public void setLifeCycleObserver(@NotNull IActivityLifeCycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mLifeCycleObserver = observer;
        Intrinsics.checkNotNull(observer);
        observer.setLifeCycleController(this);
        int windowType = ScreenUtils.getWindowType(getActivity());
        IActivityLifeCycleObserver iActivityLifeCycleObserver = this.mLifeCycleObserver;
        Intrinsics.checkNotNull(iActivityLifeCycleObserver);
        iActivityLifeCycleObserver.setWindowType(windowType);
        setOptionMenuCallback();
    }

    public final void setMLifeCycleObserver(@Nullable IActivityLifeCycleObserver iActivityLifeCycleObserver) {
        this.mLifeCycleObserver = iActivityLifeCycleObserver;
    }

    public final void setMModel(@Nullable IInstanceModel iInstanceModel) {
        this.mModel = iInstanceModel;
    }

    public final void setMSDataHandler(@Nullable IDataHandler iDataHandler) {
        this.mSDataHandler = iDataHandler;
    }

    public void updateWindowSize() {
        Logger.m7100d(TAG, "updateWindowSize");
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
            int navigationBarHeight = (!companion.getInstance().configShowNavigationBar(context) || companion.getInstance().isNavigationBarHidden(context)) ? 0 : companion.getInstance().getNavigationBarHeight(context);
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getDefaultDisplay(...)");
            ScreenData screenData = new ScreenData(defaultDisplay, navigationBarHeight);
            IInstanceModel iInstanceModel = this.mModel;
            if (iInstanceModel != null) {
                iInstanceModel.updateScreenData(screenData);
            }
        }
    }
}
