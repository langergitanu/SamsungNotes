package com.samsung.android.support.senl.addons.brush.viewmodel.penviews;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "factory", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelFactory;", "model", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelFactory;Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;)V", "mViewModelList", "Ljava/util/Hashtable;", "", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModel;", "mEraserViewModel", "mSettingsModel", "mPenCallback", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "mEraserCallback", "getViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel;", "name", "getSelectedViewModel", "getPenViewModelList", "getEraserViewModel", "closeSubViewModels", "", "clearModels", "closeCallbacks", "mPenActionListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenActionListener;", "mEraserActionListener", "getPenActionListener", "getEraserActionListener", "onPenClicked", "isSelected", "", "findPenName", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPenViewModelList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PenViewModelList.kt\ncom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,221:1\n37#2:222\n36#2,3:223\n*S KotlinDebug\n*F\n+ 1 PenViewModelList.kt\ncom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList\n*L\n218#1:222\n218#1:223,3\n*E\n"})
public class PenViewModelList extends AbsBaseViewModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenViewModelList");

    @Nullable
    private IPenActionListener mEraserActionListener;

    @Nullable
    private IBaseViewModel.Observer mEraserCallback;

    @Nullable
    private PenViewModel mEraserViewModel;

    @Nullable
    private IPenActionListener mPenActionListener;

    @Nullable
    private IBaseViewModel.Observer mPenCallback;

    @Nullable
    private SettingsModel mSettingsModel;

    @Nullable
    private Hashtable<String, PenViewModel> mViewModelList;

    public PenViewModelList(@NotNull IPenViewModelFactory<?> factory, @Nullable SettingsModel settingsModel) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mViewModelList = new Hashtable<>();
        this.mPenCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList$mPenCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                String id = info != null ? info.getId() : null;
                IPenViewModel.Companion companion = IPenViewModel.INSTANCE;
                if (Intrinsics.areEqual(id, companion.getOBSV_VM_PEN_CHANGED())) {
                    if (this.this$0.mSettingsModel != null) {
                        SettingsModel settingsModel2 = this.this$0.mSettingsModel;
                        Intrinsics.checkNotNull(settingsModel2);
                        settingsModel2.clearAllPopupVisibility();
                        SettingsModel settingsModel3 = this.this$0.mSettingsModel;
                        Intrinsics.checkNotNull(settingsModel3);
                        settingsModel3.setMode(2);
                    }
                    this.this$0.notifyChanged(IPenViewModelList.INSTANCE.getOBSV_VIEW_PEN_SELECTED_CHANGE());
                    return;
                }
                if (!Intrinsics.areEqual(id, companion.getOBSV_VM_PEN_RESELECTED()) || this.this$0.mSettingsModel == null) {
                    return;
                }
                SettingsModel settingsModel4 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel4);
                if (settingsModel4.getCurrentMode() == 2) {
                    SettingsModel settingsModel5 = this.this$0.mSettingsModel;
                    Intrinsics.checkNotNull(settingsModel5);
                    Intrinsics.checkNotNull(this.this$0.mSettingsModel);
                    settingsModel5.setPenSettingVisibility(!r0.getPenSettingVisibility());
                    return;
                }
                SettingsModel settingsModel6 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel6);
                settingsModel6.clearAllPopupVisibility();
                SettingsModel settingsModel7 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel7);
                settingsModel7.setMode(2);
                this.this$0.notifyChanged(IPenViewModelList.INSTANCE.getOBSV_VIEW_PEN_SELECTED_CHANGE());
            }
        };
        this.mEraserCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList$mEraserCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                if (Intrinsics.areEqual(info != null ? info.getId() : null, IPenViewModel.INSTANCE.getOBSV_VM_PEN_CHANGED())) {
                    this.this$0.notifyChanged(IPenViewModelList.INSTANCE.getOBSV_VIEW_PEN_SELECTED_CHANGE());
                }
            }
        };
        for (String str : IPenViewModelFactory.NAME) {
            PenViewModel penViewModelCreateViewModel = factory.createViewModel(str);
            Hashtable<String, PenViewModel> hashtable = this.mViewModelList;
            Intrinsics.checkNotNull(hashtable);
            hashtable.put(str, penViewModelCreateViewModel);
            if (penViewModelCreateViewModel != null) {
                IBaseViewModel.Observer observer = this.mPenCallback;
                Intrinsics.checkNotNull(observer);
                penViewModelCreateViewModel.addObserver(observer);
            }
        }
        PenViewModel penViewModelCreateEraserViewModel = factory.createEraserViewModel();
        this.mEraserViewModel = penViewModelCreateEraserViewModel;
        if (penViewModelCreateEraserViewModel != null) {
            IBaseViewModel.Observer observer2 = this.mEraserCallback;
            Intrinsics.checkNotNull(observer2);
            penViewModelCreateEraserViewModel.addObserver(observer2);
        }
        this.mSettingsModel = settingsModel;
        this.mPenActionListener = new IPenActionListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList$mPenActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onDensityChanged(int density) {
                AbstractC6670b.m4761v(density, "onDensityChanged. ", PenViewModelList.TAG);
                PenViewModel selectedViewModel = this.this$0.getSelectedViewModel();
                if (selectedViewModel != null) {
                    selectedViewModel.setSize(density - 1);
                    SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                    String penName = selectedViewModel.getPenName();
                    Intrinsics.checkNotNull(penName);
                    systemLogManager.onSeekBarChanged(0, density, penName);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onOpacityChanged(int color) {
                AbstractC6670b.m4763x("onOpacityChanged. ", Integer.toHexString(color), PenViewModelList.TAG);
                PenViewModel selectedViewModel = this.this$0.getSelectedViewModel();
                if (selectedViewModel == null || !selectedViewModel.hasAlpha()) {
                    return;
                }
                selectedViewModel.setAlpha(color);
                this.this$0.notifyChanged(IPenViewModelList.INSTANCE.getOBSV_VIEW_PEN_CHANGE_OPACITY());
                SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                int alpha = (int) (selectedViewModel.getAlpha() * 100);
                String penName = selectedViewModel.getPenName();
                Intrinsics.checkNotNull(penName);
                systemLogManager.onSeekBarChanged(1, alpha, penName);
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onPenChanged(String penName) {
                Intrinsics.checkNotNullParameter(penName, "penName");
                AbstractC6670b.m4763x("onPenChanged. ", penName, PenViewModelList.TAG);
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onSizeChanged(float size, int sizeLevel) {
                AbstractC6670b.m4761v(sizeLevel, "onSizeChanged. ", PenViewModelList.TAG);
                PenViewModel selectedViewModel = this.this$0.getSelectedViewModel();
                if (selectedViewModel != null) {
                    selectedViewModel.setSize(sizeLevel - 1);
                    SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                    String penName = selectedViewModel.getPenName();
                    Intrinsics.checkNotNull(penName);
                    systemLogManager.onSeekBarChanged(0, sizeLevel, penName);
                }
            }
        };
        this.mEraserActionListener = new IPenActionListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList$mEraserActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onDensityChanged(int density) {
                AbstractC6670b.m4761v(density, "onDensityChanged. ", PenViewModelList.TAG);
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onOpacityChanged(int color) {
                AbstractC6670b.m4763x("onOpacityChanged. ", Integer.toHexString(color), PenViewModelList.TAG);
                if (this.this$0.mEraserViewModel == null || this.this$0.mSettingsModel == null) {
                    return;
                }
                SettingsModel settingsModel2 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel2);
                if (settingsModel2.getCurrentMode() == 4) {
                    PenViewModel penViewModel = this.this$0.mEraserViewModel;
                    Intrinsics.checkNotNull(penViewModel);
                    penViewModel.setAlpha(color);
                    SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                    PenViewModel penViewModel2 = this.this$0.mEraserViewModel;
                    Intrinsics.checkNotNull(penViewModel2);
                    int alpha = (int) (penViewModel2.getAlpha() * 100);
                    PenViewModel penViewModel3 = this.this$0.mEraserViewModel;
                    Intrinsics.checkNotNull(penViewModel3);
                    String penName = penViewModel3.getPenName();
                    Intrinsics.checkNotNull(penName);
                    systemLogManager.onSeekBarChanged(1, alpha, penName);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onPenChanged(String penName) {
                Intrinsics.checkNotNullParameter(penName, "penName");
            }

            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout.ActionListener
            public void onSizeChanged(float size, int sizeLevel) {
                AbstractC6670b.m4761v(sizeLevel, "onSizeChanged. ", PenViewModelList.TAG);
                if (this.this$0.mEraserViewModel != null) {
                    PenViewModel penViewModel = this.this$0.mEraserViewModel;
                    Intrinsics.checkNotNull(penViewModel);
                    penViewModel.setSize(sizeLevel - 1);
                    SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
                    PenViewModel penViewModel2 = this.this$0.mEraserViewModel;
                    Intrinsics.checkNotNull(penViewModel2);
                    String penName = penViewModel2.getPenName();
                    Intrinsics.checkNotNull(penName);
                    systemLogManager.onSeekBarChanged(0, sizeLevel, penName);
                }
            }
        };
    }

    private final String findPenName(String className) {
        return new Regex("[0-9]").replace(((String[]) AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, className).toArray(new String[0]))[r3.length - 1], "");
    }

    private final IPenViewModel getViewModel(String name) {
        Hashtable<String, PenViewModel> hashtable = this.mViewModelList;
        Intrinsics.checkNotNull(hashtable);
        return hashtable.get(name);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mSettingsModel = null;
        this.mPenActionListener = null;
        this.mEraserActionListener = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mPenCallback = null;
        this.mEraserCallback = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        Hashtable<String, PenViewModel> hashtable = this.mViewModelList;
        if (hashtable != null) {
            Intrinsics.checkNotNull(hashtable);
            int size = hashtable.size();
            for (int i = 0; i < size; i++) {
                PenViewModel penViewModel = (PenViewModel) getViewModel(IPenViewModelFactory.NAME[i]);
                Intrinsics.checkNotNull(penViewModel);
                IBaseViewModel.Observer observer = this.mPenCallback;
                Intrinsics.checkNotNull(observer);
                penViewModel.removeObserver(observer);
                penViewModel.close();
            }
            Hashtable<String, PenViewModel> hashtable2 = this.mViewModelList;
            Intrinsics.checkNotNull(hashtable2);
            hashtable2.clear();
            this.mViewModelList = null;
        }
        PenViewModel penViewModel2 = this.mEraserViewModel;
        if (penViewModel2 != null) {
            Intrinsics.checkNotNull(penViewModel2);
            penViewModel2.close();
            PenViewModel penViewModel3 = this.mEraserViewModel;
            Intrinsics.checkNotNull(penViewModel3);
            IBaseViewModel.Observer observer2 = this.mEraserCallback;
            Intrinsics.checkNotNull(observer2);
            penViewModel3.removeObserver(observer2);
            this.mEraserViewModel = null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getEraserActionListener, reason: from getter */
    public final IPenActionListener getMEraserActionListener() {
        return this.mEraserActionListener;
    }

    @Nullable
    /* JADX INFO: renamed from: getEraserViewModel, reason: from getter */
    public final PenViewModel getMEraserViewModel() {
        return this.mEraserViewModel;
    }

    @Nullable
    /* JADX INFO: renamed from: getPenActionListener, reason: from getter */
    public final IPenActionListener getMPenActionListener() {
        return this.mPenActionListener;
    }

    @Nullable
    public final Hashtable<String, PenViewModel> getPenViewModelList() {
        Hashtable<String, PenViewModel> hashtable = this.mViewModelList;
        if (hashtable != null) {
            return hashtable;
        }
        return null;
    }

    @Nullable
    public final PenViewModel getSelectedViewModel() {
        Hashtable<String, PenViewModel> hashtable = this.mViewModelList;
        if (hashtable == null) {
            return null;
        }
        Intrinsics.checkNotNull(hashtable);
        int size = hashtable.size();
        for (int i = 0; i < size; i++) {
            PenViewModel penViewModel = (PenViewModel) getViewModel(IPenViewModelFactory.NAME[i]);
            Intrinsics.checkNotNull(penViewModel);
            if (penViewModel.isSelected()) {
                return penViewModel;
            }
        }
        return null;
    }

    public final void onPenClicked(@NotNull String name, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        PenViewModel selectedViewModel = getSelectedViewModel();
        IPenViewModel viewModel = getViewModel(findPenName(name));
        if (viewModel != null) {
            if (selectedViewModel != null && !Intrinsics.areEqual(selectedViewModel, viewModel)) {
                selectedViewModel.setSelected(false);
            }
            String str = TAG;
            Logger.m7100d(str, "onPenClicked. " + name + SQLKeyword.COMMA + isSelected);
            String penName = viewModel.getPenName();
            if (penName == null) {
                penName = "null";
            }
            Logger.m7100d(str, "onPenClicked. setPenViewModel. ".concat(penName));
            viewModel.setSelected(true);
        }
        SystemLogManager.INSTANCE.onPenClicked();
    }
}
