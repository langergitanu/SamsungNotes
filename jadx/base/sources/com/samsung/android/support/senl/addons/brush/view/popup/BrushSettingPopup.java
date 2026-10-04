package com.samsung.android.support.senl.addons.brush.view.popup;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.IPenSettingPopup;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.IRemoverSettingPopup;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushSettingPopupView;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMenuHideViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorGradationViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.MenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenActionListener;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.ColorPickerViewModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u00020\u0006:\u0002\\]B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\rB%\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0010B-\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0012J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010!H\u0016J\b\u00100\u001a\u00020-H\u0016J\u0012\u00101\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020-H\u0002J\b\u00105\u001a\u00020-H\u0002J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010#H\u0016J(\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0014J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u000fH\u0002J\u001a\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020-2\u0006\u0010I\u001a\u00020\u000fH\u0016J\b\u0010M\u001a\u00020-H\u0002J\b\u0010N\u001a\u00020-H\u0002J\b\u0010O\u001a\u00020-H\u0002J\b\u0010P\u001a\u00020-H\u0002J\b\u0010Q\u001a\u00020-H\u0002J\u0012\u0010Y\u001a\u00020-2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0%j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&`'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/BrushSettingPopup;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopup;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushSettingPopupView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IPenSettingPopup;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mScreenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "mSettingsViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel;", "mBrushLayoutViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "mColorPickerViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/ColorPickerViewModel;", "mPenViewID", "mColorViewID", "mPenView", "Landroid/view/View;", "mColorView", "mBrushMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mChangeListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "mPopupViewMap", "Ljava/util/HashMap;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "Lkotlin/collections/HashMap;", "mRotationDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", "mEraserBottomListener", "Landroid/view/View$OnClickListener;", "initialize", "", "updateMenuInfo", "info", "close", "onRotationChanged", "action", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "setPenRect", "setColorRect", "setLayoutViewModel", "layoutViewModel", "setMainViewModel", "mainViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel;", "setSettingsViewModel", "settingsViewModel", "mColorPickerCallback", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "setChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onSizeChanged", "w", "h", "oldw", "oldh", "updateSettingPopupPosition", "penPopupAlign", "showPopup", "mode", "data", "", "hidePopup", "showPenSetting", "showEraserSetting", "showColorGradation", "showColorPaletteSetting", "showColorPicker", "penSettingPopup", "getPenSettingPopup", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IPenSettingPopup;", "removerSettingPopup", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IRemoverSettingPopup;", "getRemoverSettingPopup", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IRemoverSettingPopup;", "setMenuHideViewModel", "menuHideViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMenuHideViewModel;", "Companion", "PopupResult", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushSettingPopup extends RelativeLayout implements IBrushSettingPopup, BMBrushSettingPopupView, ISettingView<IPenSettingPopup>, IRotationMode.OnRotationChangeListener {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSettingPopup");

    @Nullable
    private BrushLayoutViewModel mBrushLayoutViewModel;

    @Nullable
    private IBrushMenuInfo mBrushMenuInfo;

    @Nullable
    private ISettingView.IChangeListener mChangeListener;

    @Nullable
    private IBaseViewModel.Observer mColorPickerCallback;

    @Nullable
    private ColorPickerViewModel mColorPickerViewModel;

    @Nullable
    private View mColorView;
    private int mColorViewID;

    @Nullable
    private View.OnClickListener mEraserBottomListener;

    @Nullable
    private View mPenView;
    private int mPenViewID;

    @NotNull
    private final HashMap<Integer, IBrushSettingPopupView> mPopupViewMap;

    @NotNull
    private final RotationDelegate mRotationDelegate;

    @Nullable
    private IScreenModel mScreenModel;

    @Nullable
    private BrushSettingsViewModel mSettingsViewModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/BrushSettingPopup$PopupResult;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView$IPopupResult;", "<init>", "()V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PopupResult implements ISettingPopupView.IPopupResult {

        @Nullable
        private Object result;

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView.IPopupResult
        @Nullable
        public Object getResult() {
            return this.result;
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView.IPopupResult
        public void setResult(@Nullable Object obj) {
            this.result = obj;
        }
    }

    public BrushSettingPopup(@Nullable Context context) {
        super(context);
        this.mPopupViewMap = new HashMap<>();
        this.mRotationDelegate = new RotationDelegate();
        this.mColorPickerCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.popup.BrushSettingPopup$mColorPickerCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                if (Intrinsics.areEqual(info != null ? info.getId() : null, "color_picker_color_change")) {
                    IBrushSettingPopupView iBrushSettingPopupView = (IBrushSettingPopupView) this.this$0.mPopupViewMap.get(8);
                    if (iBrushSettingPopupView instanceof ColorSpuitPopupView) {
                        ColorSpuitPopupView colorSpuitPopupView = (ColorSpuitPopupView) iBrushSettingPopupView;
                        ColorPickerViewModel colorPickerViewModel = this.this$0.mColorPickerViewModel;
                        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        colorSpuitPopupView.setColorSpoidColor(numValueOf.intValue());
                    }
                }
            }
        };
        initialize();
    }

    private final void initialize() {
        this.mPenViewID = C7944R.id.popup_pen_view;
        this.mColorViewID = C7944R.id.popup_color_view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChangeListener$lambda$0(BrushSettingPopup brushSettingPopup, View view) {
        ISettingView.IChangeListener iChangeListener = brushSettingPopup.mChangeListener;
        if (iChangeListener != null) {
            iChangeListener.onClearAll();
        }
        BrushSettingsViewModel brushSettingsViewModel = brushSettingPopup.mSettingsViewModel;
        if (brushSettingsViewModel != null) {
            brushSettingsViewModel.onEraseAllClick();
        }
    }

    private final void setColorRect() {
        IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
        if (iBrushMenuInfo != null) {
            Intrinsics.checkNotNull(iBrushMenuInfo);
            Rect colorRect = iBrushMenuInfo.getMColorRect();
            IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo2);
            int colorAlign = iBrushMenuInfo2.getMColorAlign();
            boolean z = getResources().getConfiguration().getLayoutDirection() == 1;
            Logger.m7100d(TAG, "setColorRect() rect=" + colorRect + " align=" + colorAlign);
            View view = this.mColorView;
            if (view == null) {
                View view2 = new View(getContext());
                this.mColorView = view2;
                Intrinsics.checkNotNull(view2);
                view2.setId(this.mColorViewID);
                addView(this.mColorView, SettingPopupViewUtils.INSTANCE.getMenuViewParams(getWidth(), z, colorRect, colorAlign));
            } else {
                Intrinsics.checkNotNull(view);
                view.setLayoutParams(SettingPopupViewUtils.INSTANCE.getMenuViewParams(getWidth(), z, colorRect, colorAlign));
            }
            BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
            MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
            Intrinsics.checkNotNull(menuViewModel);
            updateSettingPopupPosition(menuViewModel.getPenPopupAlign());
        }
    }

    private final void setPenRect() {
        IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
        if (iBrushMenuInfo != null) {
            Intrinsics.checkNotNull(iBrushMenuInfo);
            Rect penRect = iBrushMenuInfo.getMPenRect();
            IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo2);
            int penAlign = iBrushMenuInfo2.getMPenAlign();
            boolean z = getResources().getConfiguration().getLayoutDirection() == 1;
            Logger.m7100d(TAG, "setPenRect() rect=" + penRect + " align=" + penAlign);
            View view = this.mPenView;
            if (view == null) {
                View view2 = new View(getContext());
                this.mPenView = view2;
                Intrinsics.checkNotNull(view2);
                view2.setId(this.mPenViewID);
                addView(this.mPenView, SettingPopupViewUtils.INSTANCE.getMenuViewParams(getWidth(), z, penRect, penAlign));
            } else {
                Intrinsics.checkNotNull(view);
                view.setLayoutParams(SettingPopupViewUtils.INSTANCE.getMenuViewParams(getWidth(), z, penRect, penAlign));
            }
            BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
            MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
            Intrinsics.checkNotNull(menuViewModel);
            updateSettingPopupPosition(menuViewModel.getPenPopupAlign());
        }
    }

    private final void showColorGradation() {
        Logger.m7100d(TAG, "showColorGradationSetting.");
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
        Intrinsics.checkNotNull(menuViewModel);
        ColorGradationViewModel colorGradationViewModel = menuViewModel.getMColorGradationViewModel();
        Intrinsics.checkNotNull(colorGradationViewModel);
        ColorGradationPopupView colorGradationPopupView = (ColorGradationPopupView) this.mPopupViewMap.get(4);
        if (colorGradationPopupView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            colorGradationPopupView = new ColorGradationPopupView(context, colorGradationViewModel.getViewMode(), colorGradationViewModel.getCurrentColor());
            addView(colorGradationPopupView);
            colorGradationPopupView.hide(null);
            colorGradationPopupView.setRotationDelegate(this.mRotationDelegate);
            this.mPopupViewMap.put(4, colorGradationPopupView);
        }
        colorGradationPopupView.setViewMode(colorGradationViewModel.getViewMode());
        colorGradationPopupView.setCurrentColor(colorGradationViewModel.getCurrentColor());
        colorGradationPopupView.setRecentColors(colorGradationViewModel.getRecentColors(), colorGradationViewModel.getRecentColorsNum());
        colorGradationPopupView.setColor(colorGradationViewModel.getCurrentColor(), colorGradationViewModel.getCurrentColor());
        colorGradationPopupView.setOnCloseClickListener(colorGradationViewModel.getMCloseGradationListener());
        colorGradationPopupView.setPickerChangedListener(colorGradationViewModel.getMCloseGradationListener());
        colorGradationPopupView.setPickerActionListener(colorGradationViewModel.getMCloseGradationListener());
        colorGradationPopupView.updatePosition(this.mBrushMenuInfo, 0);
        colorGradationPopupView.show();
    }

    private final void showColorPaletteSetting() {
        Logger.m7100d(TAG, "showPaletteSetting.");
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
        Intrinsics.checkNotNull(menuViewModel);
        ColorMenuViewModel colorMenuViewModel = menuViewModel.getMColorMenuViewModel();
        Intrinsics.checkNotNull(colorMenuViewModel);
        ColorPaletteSettingPopupView colorPaletteSettingPopupView = (ColorPaletteSettingPopupView) this.mPopupViewMap.get(32);
        if (colorPaletteSettingPopupView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            List<Integer> maxPaletteIndices = colorMenuViewModel.getMaxPaletteIndices();
            Intrinsics.checkNotNull(maxPaletteIndices);
            colorPaletteSettingPopupView = new ColorPaletteSettingPopupView(context, maxPaletteIndices, colorMenuViewModel.getMaxPaletteSelectable());
            addView(colorPaletteSettingPopupView);
            colorPaletteSettingPopupView.hide(null);
            colorPaletteSettingPopupView.setRotationDelegate(this.mRotationDelegate);
            this.mPopupViewMap.put(32, colorPaletteSettingPopupView);
        }
        colorPaletteSettingPopupView.setEventListener(colorMenuViewModel.getMPaletteSettingActionListener());
        colorPaletteSettingPopupView.setOnCloseClickListener(colorMenuViewModel.getMPaletteSettingActionListener());
        colorPaletteSettingPopupView.setShowToast(false);
        colorPaletteSettingPopupView.setToastTextNotifyListener(colorMenuViewModel.getMPaletteSettingActionListener());
        colorPaletteSettingPopupView.setSelectPaletteList(colorMenuViewModel.getSelectedPalettes());
        colorPaletteSettingPopupView.updatePosition(this.mBrushMenuInfo, 0);
        colorPaletteSettingPopupView.show();
    }

    private final void showColorPicker() {
        Logger.m7100d(TAG, "showColorPicker.");
        BrushSettingsViewModel brushSettingsViewModel = this.mSettingsViewModel;
        ColorPickerViewModel colorPickerViewModel = brushSettingsViewModel != null ? brushSettingsViewModel.getColorPickerViewModel() : null;
        ColorSpuitPopupView colorSpuitPopupView = (ColorSpuitPopupView) this.mPopupViewMap.get(8);
        if (colorSpuitPopupView == null) {
            ColorSpuitPopupView colorSpuitPopupView2 = new ColorSpuitPopupView(getContext(), this, getResources().getDimensionPixelSize(C7944R.dimen.color_spoid_default_margin), getResources().getDimensionPixelSize(C7944R.dimen.color_spoid_default_margin));
            colorSpuitPopupView2.setColorSpoidColor(0);
            SpenColorSpoidLayout.hide$default(colorSpuitPopupView2, false, 1, null);
            colorSpuitPopupView2.setRotationDelegate(this.mRotationDelegate);
            this.mPopupViewMap.put(8, colorSpuitPopupView2);
            colorSpuitPopupView = colorSpuitPopupView2;
        }
        Intrinsics.checkNotNull(colorPickerViewModel);
        colorSpuitPopupView.setSpoidListener(colorPickerViewModel.getMColorPickerActionListener());
        colorSpuitPopupView.setColorSpoidColor(colorPickerViewModel.getPickerColor());
        colorSpuitPopupView.updatePosition(this.mBrushMenuInfo, 0);
        colorSpuitPopupView.show();
    }

    private final void showEraserSetting() {
        Logger.m7100d(TAG, "showEraserSetting.");
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        PenViewModelList penViewModelList = brushLayoutViewModel != null ? brushLayoutViewModel.getPenViewModelList() : null;
        Intrinsics.checkNotNull(penViewModelList);
        PenViewModel eraserViewModel = penViewModelList.getMEraserViewModel();
        Intrinsics.checkNotNull(eraserViewModel);
        BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
        PenViewModelList penViewModelList2 = brushLayoutViewModel2 != null ? brushLayoutViewModel2.getPenViewModelList() : null;
        Intrinsics.checkNotNull(penViewModelList2);
        IPenActionListener eraserActionListener = penViewModelList2.getMEraserActionListener();
        EraserSettingPopupView eraserSettingPopupView = (EraserSettingPopupView) this.mPopupViewMap.get(2);
        if (eraserSettingPopupView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            eraserSettingPopupView = new EraserSettingPopupView(context, false);
            addView(eraserSettingPopupView);
            eraserSettingPopupView.hide(null);
            eraserSettingPopupView.setRotationDelegate(this.mRotationDelegate);
            this.mPopupViewMap.put(2, eraserSettingPopupView);
        }
        eraserSettingPopupView.setActionListener(eraserActionListener);
        eraserSettingPopupView.setPenInfo(eraserViewModel.getInfo());
        eraserSettingPopupView.updatePosition(this.mBrushMenuInfo, 0);
        eraserSettingPopupView.setBottomClickListener(this.mEraserBottomListener);
        eraserSettingPopupView.show();
    }

    private final void showPenSetting() {
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        PenViewModelList penViewModelList = brushLayoutViewModel != null ? brushLayoutViewModel.getPenViewModelList() : null;
        Intrinsics.checkNotNull(penViewModelList);
        PenViewModel selectedViewModel = penViewModelList.getSelectedViewModel();
        if (selectedViewModel == null) {
            Logger.m7101e(TAG, "showPenSetting no pen selected");
            return;
        }
        Logger.m7100d(TAG, "showPenSetting");
        BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel2 != null ? brushLayoutViewModel2.getMenuViewModel() : null;
        Intrinsics.checkNotNull(menuViewModel);
        int penPopupAlign = menuViewModel.getPenPopupAlign();
        BrushLayoutViewModel brushLayoutViewModel3 = this.mBrushLayoutViewModel;
        Intrinsics.checkNotNull(brushLayoutViewModel3);
        PenViewModelList penViewModelList2 = brushLayoutViewModel3.getPenViewModelList();
        Intrinsics.checkNotNull(penViewModelList2);
        IPenActionListener penActionListener = penViewModelList2.getMPenActionListener();
        PenSettingPopupView penSettingPopupView = (PenSettingPopupView) this.mPopupViewMap.get(1);
        if (penSettingPopupView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            penSettingPopupView = new PenSettingPopupView(context, true);
            addView(penSettingPopupView);
            penSettingPopupView.hide(null);
            penSettingPopupView.setRotationDelegate(this.mRotationDelegate);
            this.mPopupViewMap.put(1, penSettingPopupView);
        }
        penSettingPopupView.setActionListener(penActionListener);
        penSettingPopupView.setPenInfo(selectedViewModel.getInfo());
        penSettingPopupView.updatePosition(this.mBrushMenuInfo, penPopupAlign);
        penSettingPopupView.show();
        SystemLogManager.INSTANCE.onBrushSettingOpen(selectedViewModel.getPenName());
    }

    private final void updateSettingPopupPosition(int penPopupAlign) {
        for (Map.Entry<Integer, IBrushSettingPopupView> entry : this.mPopupViewMap.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            entry.getValue().updatePosition(this.mBrushMenuInfo, penPopupAlign);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    public void close() {
        removeAllViews();
        for (Map.Entry<Integer, IBrushSettingPopupView> entry : this.mPopupViewMap.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            entry.getValue().close();
        }
        this.mPopupViewMap.clear();
        this.mPenView = null;
        this.mColorView = null;
        this.mBrushMenuInfo = null;
        this.mColorPickerCallback = null;
        IScreenModel iScreenModel = this.mScreenModel;
        if (iScreenModel != null) {
            Intrinsics.checkNotNull(iScreenModel);
            iScreenModel.removeRotationChangeListener(this);
            this.mScreenModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    @Nullable
    public IPenSettingPopup getPenSettingPopup() {
        return (IPenSettingPopup) this.mPopupViewMap.get(1);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    @Nullable
    public IRemoverSettingPopup getRemoverSettingPopup() {
        return (IRemoverSettingPopup) this.mPopupViewMap.get(2);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    public void hidePopup(int mode) {
        AbstractC6670b.m4761v(mode, "hidePopup. ", TAG);
        IBrushSettingPopupView iBrushSettingPopupView = this.mPopupViewMap.get(Integer.valueOf(mode));
        PopupResult popupResult = new PopupResult();
        if (iBrushSettingPopupView != null) {
            iBrushSettingPopupView.hide(popupResult);
        }
        if (mode == 4) {
            BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
            MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
            Intrinsics.checkNotNull(menuViewModel);
            ColorGradationViewModel colorGradationViewModel = menuViewModel.getMColorGradationViewModel();
            Intrinsics.checkNotNull(colorGradationViewModel);
            colorGradationViewModel.setColorGradationColor((float[]) popupResult.getResult());
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode.OnRotationChangeListener
    public void onRotationChanged(@Nullable IRotationEvent action) {
        this.mRotationDelegate.setRotationEvent(action);
        for (Map.Entry<Integer, IBrushSettingPopupView> entry : this.mPopupViewMap.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            Map.Entry<Integer, IBrushSettingPopupView> entry2 = entry;
            if (entry2.getValue().isVisible()) {
                entry2.getValue().rotate(action);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        if ((brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null) != null) {
            BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
            Intrinsics.checkNotNull(brushLayoutViewModel2);
            MenuLayoutViewModel menuViewModel = brushLayoutViewModel2.getMenuViewModel();
            Intrinsics.checkNotNull(menuViewModel);
            updateSettingPopupPosition(menuViewModel.getPenPopupAlign());
        }
        IBrushSettingPopupView iBrushSettingPopupView = this.mPopupViewMap.get(8);
        if (iBrushSettingPopupView instanceof ColorSpuitPopupView) {
            ((ColorSpuitPopupView) iBrushSettingPopupView).setRotation();
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushSettingPopupView, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    public void setChangeListener(@Nullable ISettingView.IChangeListener listener) {
        this.mChangeListener = listener;
        this.mEraserBottomListener = new ViewOnClickListenerC7538b(this, 20);
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setLayoutViewModel(@Nullable BrushLayoutViewModel layoutViewModel) {
        Logger.m7100d(TAG, "setLayoutViewModel");
        this.mBrushLayoutViewModel = layoutViewModel;
        if ((layoutViewModel != null ? layoutViewModel.getScreenModel() : null) != null) {
            BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
            Intrinsics.checkNotNull(brushLayoutViewModel);
            IScreenModel screenModel = brushLayoutViewModel.getScreenModel();
            this.mScreenModel = screenModel;
            if (screenModel != null) {
                screenModel.addRotationChangeListener(this);
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setMainViewModel(@Nullable BrushMainViewModel mainViewModel) {
        Logger.m7100d(TAG, "setMainViewModel");
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setMenuHideViewModel(@Nullable BrushMenuHideViewModel menuHideViewModel) {
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushMenuView
    public void setSettingsViewModel(@Nullable BrushSettingsViewModel settingsViewModel) {
        Logger.m7100d(TAG, "setSettingsViewModel");
        this.mSettingsViewModel = settingsViewModel;
        ColorPickerViewModel colorPickerViewModel = settingsViewModel != null ? settingsViewModel.getColorPickerViewModel() : null;
        ColorPickerViewModel colorPickerViewModel2 = this.mColorPickerViewModel;
        if (colorPickerViewModel2 != null && !Intrinsics.areEqual(colorPickerViewModel2, colorPickerViewModel)) {
            ColorPickerViewModel colorPickerViewModel3 = this.mColorPickerViewModel;
            Intrinsics.checkNotNull(colorPickerViewModel3);
            IBaseViewModel.Observer observer = this.mColorPickerCallback;
            Intrinsics.checkNotNull(observer);
            colorPickerViewModel3.removeObserver(observer);
        }
        this.mColorPickerViewModel = colorPickerViewModel;
        if (colorPickerViewModel != null) {
            IBaseViewModel.Observer observer2 = this.mColorPickerCallback;
            Intrinsics.checkNotNull(observer2);
            colorPickerViewModel.addObserver(observer2);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    public void showPopup(int mode, @Nullable Object data) {
        String str = TAG;
        AbstractC6670b.m4761v(mode, "showPopup. ", str);
        if (mode == 1) {
            showPenSetting();
            return;
        }
        if (mode == 2) {
            showEraserSetting();
            return;
        }
        if (mode == 4) {
            showColorGradation();
            return;
        }
        if (mode == 8) {
            showColorPicker();
        } else if (mode == 32) {
            showColorPaletteSetting();
        } else {
            if (mode != 65536) {
                return;
            }
            Logger.m7100d(str, "recreate");
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushSettingPopupView
    public void updateMenuInfo(@Nullable IBrushMenuInfo info) {
        if (info != null) {
            this.mBrushMenuInfo = info;
            String str = TAG;
            Intrinsics.checkNotNull(info);
            Rect penRect = info.getMPenRect();
            IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo);
            Rect colorRect = iBrushMenuInfo.getMColorRect();
            IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo2);
            int penAlign = iBrushMenuInfo2.getMPenAlign();
            IBrushMenuInfo iBrushMenuInfo3 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo3);
            Logger.m7100d(str, "updateMenuInfo. " + penRect + SQLKeyword.COMMA + colorRect + " // " + penAlign + SQLKeyword.COMMA + iBrushMenuInfo3.getMColorAlign());
            setPenRect();
            setColorRect();
        }
    }

    public BrushSettingPopup(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPopupViewMap = new HashMap<>();
        this.mRotationDelegate = new RotationDelegate();
        this.mColorPickerCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.popup.BrushSettingPopup$mColorPickerCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                if (Intrinsics.areEqual(info != null ? info.getId() : null, "color_picker_color_change")) {
                    IBrushSettingPopupView iBrushSettingPopupView = (IBrushSettingPopupView) this.this$0.mPopupViewMap.get(8);
                    if (iBrushSettingPopupView instanceof ColorSpuitPopupView) {
                        ColorSpuitPopupView colorSpuitPopupView = (ColorSpuitPopupView) iBrushSettingPopupView;
                        ColorPickerViewModel colorPickerViewModel = this.this$0.mColorPickerViewModel;
                        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        colorSpuitPopupView.setColorSpoidColor(numValueOf.intValue());
                    }
                }
            }
        };
        initialize();
    }

    public BrushSettingPopup(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPopupViewMap = new HashMap<>();
        this.mRotationDelegate = new RotationDelegate();
        this.mColorPickerCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.popup.BrushSettingPopup$mColorPickerCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                if (Intrinsics.areEqual(info != null ? info.getId() : null, "color_picker_color_change")) {
                    IBrushSettingPopupView iBrushSettingPopupView = (IBrushSettingPopupView) this.this$0.mPopupViewMap.get(8);
                    if (iBrushSettingPopupView instanceof ColorSpuitPopupView) {
                        ColorSpuitPopupView colorSpuitPopupView = (ColorSpuitPopupView) iBrushSettingPopupView;
                        ColorPickerViewModel colorPickerViewModel = this.this$0.mColorPickerViewModel;
                        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        colorSpuitPopupView.setColorSpoidColor(numValueOf.intValue());
                    }
                }
            }
        };
        initialize();
    }

    public BrushSettingPopup(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPopupViewMap = new HashMap<>();
        this.mRotationDelegate = new RotationDelegate();
        this.mColorPickerCallback = new IBaseViewModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.popup.BrushSettingPopup$mColorPickerCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseViewModel.Info info) {
                if (Intrinsics.areEqual(info != null ? info.getId() : null, "color_picker_color_change")) {
                    IBrushSettingPopupView iBrushSettingPopupView = (IBrushSettingPopupView) this.this$0.mPopupViewMap.get(8);
                    if (iBrushSettingPopupView instanceof ColorSpuitPopupView) {
                        ColorSpuitPopupView colorSpuitPopupView = (ColorSpuitPopupView) iBrushSettingPopupView;
                        ColorPickerViewModel colorPickerViewModel = this.this$0.mColorPickerViewModel;
                        Integer numValueOf = colorPickerViewModel != null ? Integer.valueOf(colorPickerViewModel.getPickerColor()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        colorSpuitPopupView.setColorSpoidColor(numValueOf.intValue());
                    }
                }
            }
        };
        initialize();
    }
}
