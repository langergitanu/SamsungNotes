package com.samsung.android.support.senl.addons.brush.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.binding.binder.Binder;
import com.samsung.android.support.senl.addons.base.binding.binder.BinderBuilder;
import com.samsung.android.support.senl.addons.base.binding.binder.ViewModelBindUtil;
import com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade;
import com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.view.common.AbsBindHelper;
import com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.binding.binder.BrushBindingFactory;
import com.samsung.android.support.senl.addons.brush.model.BrushModel;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModelList;
import com.samsung.android.support.senl.addons.brush.util.CommonUtil;
import com.samsung.android.support.senl.addons.brush.view.injector.BrushModelInjector;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer;
import com.samsung.android.support.senl.addons.brush.view.pen.PenViewModelFactory;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMenuHideViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.canvas.BrushCanvasViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorGradationViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.MenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.submenu.SubMenuViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/BrushBindHelper;", "Lcom/samsung/android/support/senl/addons/base/view/common/AbsBindHelper;", "context", "Landroid/content/Context;", "mainModel", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V", "mLifeCycleObserver", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;", "mLayoutVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "updateLayouts", "", "instanceModel", "menuSizeInjector", "Lcom/samsung/android/support/senl/addons/brush/view/injector/MenuSizeInjector;", "getLifeCycleObserver", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushBindHelper extends AbsBindHelper {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushBindHelper");

    @Nullable
    private BrushLayoutViewModel mLayoutVM;

    @Nullable
    private IActivityLifeCycleObserver mLifeCycleObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrushBindHelper(@NotNull Context context, @NotNull IInstanceModel mainModel, @Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        super(mainModel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainModel, "mainModel");
        MenuSizeInjector menuSizeInjector = new MenuSizeInjector(context);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        BrushModel brushModel = (BrushModel) mainModel;
        brushModel.setInjector(new BrushModelInjector(resources));
        brushModel.setMenuSizeInjector(menuSizeInjector);
        brushModel.setStatusHeight(CommonUtil.getStatusBarHeight(context));
        BrushMainViewModel brushMainViewModel = new BrushMainViewModel(brushModel);
        brushMainViewModel.getSaveViewModel().setSettingsModel(brushModel.getSettingsModel());
        SubMenuViewModel subMenuViewModel = brushMainViewModel.getSubMenuViewModel();
        SettingsModel settingsModel = brushModel.getSettingsModel();
        Intrinsics.checkNotNull(settingsModel);
        subMenuViewModel.setSettingsModel(settingsModel);
        BrushSettingsViewModel brushSettingsViewModel = new BrushSettingsViewModel(brushModel.getMFacade(), brushModel.getSettingsModel(), brushModel.getColorModelsManager());
        IBaseViewModel brushMenuHideViewModel = new BrushMenuHideViewModel(brushModel.getMFacade());
        ViewModelBindUtil viewModelBindUtil = ViewModelBindUtil.INSTANCE;
        Intrinsics.checkNotNull(layoutInflater);
        int i = C7944R.layout.brush_fragment_main;
        Intrinsics.checkNotNull(viewGroup);
        BinderBuilder binderBuilderInflate = viewModelBindUtil.inflate(layoutInflater, i, viewGroup, false);
        binderBuilderInflate.setCustomBindingFactory(new BrushBindingFactory());
        setMMainBinding(binderBuilderInflate.build());
        updateLayouts(brushModel, menuSizeInjector);
        Binder mMainBinding = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding);
        mMainBinding.setViewModel("brushmainvm", brushMainViewModel);
        Binder mMainBinding2 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding2);
        mMainBinding2.setViewModel("submenuvm", brushMainViewModel.getSubMenuViewModel());
        Binder mMainBinding3 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding3);
        mMainBinding3.setViewModel("previewvm", brushMainViewModel.getPreviewImageViewModel());
        Binder mMainBinding4 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding4);
        mMainBinding4.setViewModel("penupvm", brushMainViewModel.getPenupViewModel());
        Binder mMainBinding5 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding5);
        mMainBinding5.setViewModel("brushsavevm", brushMainViewModel.getSaveViewModel());
        Binder mMainBinding6 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding6);
        mMainBinding6.setViewModel("panningvm", brushMainViewModel.getPanningViewModel());
        addViewModel(brushMainViewModel);
        Binder mMainBinding7 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding7);
        mMainBinding7.setViewModel("brushmenuhidevm", brushMenuHideViewModel);
        addViewModel(brushMenuHideViewModel);
        Binder mMainBinding8 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding8);
        mMainBinding8.setViewModel("brushsettingsvm", brushSettingsViewModel);
        Binder mMainBinding9 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding9);
        IBaseViewModel settingPopupHiderViewModel = brushSettingsViewModel.getSettingPopupHiderViewModel();
        Intrinsics.checkNotNull(settingPopupHiderViewModel);
        mMainBinding9.setViewModel("settingpopuphidervm", settingPopupHiderViewModel);
        addViewModel(brushSettingsViewModel);
        this.mLifeCycleObserver = brushMainViewModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.common.AbsBindHelper, com.samsung.android.support.senl.addons.base.view.common.IBindHelper
    public void close() {
        Logger.m7100d(TAG, "close");
        this.mLifeCycleObserver = null;
        Binder mMainBinding = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding);
        View viewFindViewById = mMainBinding.getRoot().findViewById(C7944R.id.brush_palette_menu);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer");
        ((BrushMenuContainer) viewFindViewById).close();
        super.close();
    }

    public final void updateLayouts(@NotNull IInstanceModel instanceModel, @Nullable MenuSizeInjector menuSizeInjector) {
        Intrinsics.checkNotNullParameter(instanceModel, "instanceModel");
        IBaseViewModel iBaseViewModel = this.mLayoutVM;
        if (iBaseViewModel != null) {
            removeViewModel(iBaseViewModel);
            BrushLayoutViewModel brushLayoutViewModel = this.mLayoutVM;
            Intrinsics.checkNotNull(brushLayoutViewModel);
            brushLayoutViewModel.close();
            Binder mMainBinding = getMMainBinding();
            Intrinsics.checkNotNull(mMainBinding);
            View viewFindViewById = mMainBinding.getRoot().findViewById(C7944R.id.brush_palette_menu);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.view.menu.BrushMenuContainer");
            ((BrushMenuContainer) viewFindViewById).init();
        }
        BrushModel brushModel = (BrushModel) instanceModel;
        PenModelList penModelList = brushModel.getPenModelList();
        Intrinsics.checkNotNull(penModelList);
        BrushLayoutViewModel brushLayoutViewModel2 = new BrushLayoutViewModel(menuSizeInjector, instanceModel, new PenViewModelList(new PenViewModelFactory(penModelList), brushModel.getSettingsModel()), brushModel.getColorModelsManager());
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel);
        menuViewModel.setSettingModel(brushModel.getSettingsModel());
        MenuLayoutViewModel menuViewModel2 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel2);
        ColorMenuViewModel mColorMenuViewModel = menuViewModel2.getMColorMenuViewModel();
        Intrinsics.checkNotNull(mColorMenuViewModel);
        mColorMenuViewModel.setSettingModel(brushModel.getSettingsModel());
        MenuLayoutViewModel menuViewModel3 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel3);
        BrushCanvasViewModel mBrushCanvasViewModel = menuViewModel3.getMBrushCanvasViewModel();
        Intrinsics.checkNotNull(mBrushCanvasViewModel);
        mBrushCanvasViewModel.setFacade((AbsFacade) brushModel.getMFacade());
        MenuLayoutViewModel menuViewModel4 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel4);
        ColorGradationViewModel mColorGradationViewModel = menuViewModel4.getMColorGradationViewModel();
        Intrinsics.checkNotNull(mColorGradationViewModel);
        mColorGradationViewModel.setSettingModel(brushModel.getSettingsModel());
        Binder mMainBinding2 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding2);
        mMainBinding2.setViewModel("brushlayoutvm", brushLayoutViewModel2);
        Binder mMainBinding3 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding3);
        MenuLayoutViewModel menuViewModel5 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel5);
        mMainBinding3.setViewModel("submenulayoutvm", menuViewModel5.getMSubMenuLayoutViewModel());
        Binder mMainBinding4 = getMMainBinding();
        Intrinsics.checkNotNull(mMainBinding4);
        MenuLayoutViewModel menuViewModel6 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel6);
        mMainBinding4.setViewModel("brushcanvasvm", menuViewModel6.getMBrushCanvasViewModel());
        addViewModel(brushLayoutViewModel2);
        this.mLayoutVM = brushLayoutViewModel2;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.common.IBindHelper
    @Nullable
    /* JADX INFO: renamed from: getLifeCycleObserver, reason: from getter */
    public IActivityLifeCycleObserver getMLifeCycleObserver() {
        return this.mLifeCycleObserver;
    }
}
