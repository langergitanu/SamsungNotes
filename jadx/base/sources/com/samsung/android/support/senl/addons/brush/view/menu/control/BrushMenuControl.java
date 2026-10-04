package com.samsung.android.support.senl.addons.brush.view.menu.control;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenBrushLayoutInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.util.CommonUtil;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMenuHideViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorGradationViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorMenuViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorRecentViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.MenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.SubMenuLayoutViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModelFactory;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penviews.PenViewModelList;
import com.samsung.android.support.senl.addons.brush.viewmodel.setting.BrushSettingsViewModel;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p145cm.base.framework.widget.TipPopupWidgetWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Hashtable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b*\u0005+.147\b&\u0018\u0000 i2\u00020\u0001:\u0001iB\u0013\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020$H\u0016J\u0010\u00109\u001a\u00020$2\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020$J\u000e\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>J\u000e\u0010<\u001a\u00020$2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CJ\u0018\u0010A\u001a\u00020$2\u0006\u0010=\u001a\u00020E2\u0006\u0010B\u001a\u00020CH\u0002J\u0016\u0010K\u001a\u00020$2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010MJ\u0010\u0010N\u001a\u00020$2\b\u0010O\u001a\u0004\u0018\u00010PJ\u000e\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020CJ\u0010\u0010Y\u001a\u00020$2\b\u0010Z\u001a\u0004\u0018\u00010\bJ\u0010\u0010[\u001a\u00020$2\b\u0010\\\u001a\u0004\u0018\u00010\u0006J\u0010\u0010]\u001a\u00020$2\b\u0010^\u001a\u0004\u0018\u00010\fJ\u0018\u0010_\u001a\u00020$2\b\u0010`\u001a\u0004\u0018\u00010\u001c2\u0006\u0010a\u001a\u00020bJ\u0010\u0010c\u001a\u00020$2\b\u0010O\u001a\u0004\u0018\u00010PJ\b\u0010d\u001a\u00020$H\u0016J\u0012\u0010e\u001a\u00020C2\b\u0010`\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010h\u001a\u00020$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u0016\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u0004\u0018\u00010@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR4\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010M2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010M8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0011\u0010f\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006j"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;", "", "prev", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;)V", "mBrushLayoutViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushLayoutViewModel;", "mBrushMenuHideViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMenuHideViewModel;", "mSubMenuLayoutViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/SubMenuLayoutViewModel;", "mBrushSettingsViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/BrushSettingsViewModel;", "mPenView", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "getMPenView", "()Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "setMPenView", "(Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;)V", "mColorView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorLayout;", "mTipPopup", "Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper;", "getMTipPopup", "()Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper;", "setMTipPopup", "(Lcom/samsung/android/support/senl/cm/base/framework/widget/TipPopupWidgetWrapper;)V", "mBrushMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "getMBrushMenuInfo", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "setMBrushMenuInfo", "(Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;)V", "getBrushLayoutInfo", "Lcom/samsung/android/sdk/pen/setting/SpenBrushLayoutInfo;", "setBrushLayout", "", "brushLayout", "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$OnModeChangeListener;", "setSmartTipPopup", "mPenActionListener", "com/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mPenActionListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mPenActionListener$1;", "mColorActionListener", "com/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorActionListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorActionListener$1;", "mColorChangeListener", "com/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorChangeListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorChangeListener$1;", "mColorSwipeListener", "com/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorSwipeListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorSwipeListener$1;", "mColorButtonListener", "com/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorButtonListener$1", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl$mColorButtonListener$1;", "setPenInfo", "viewModelList", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModelList;", "updateCurrentPenView", "color", "", "penViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel;", "updateCurrentColorView", "needAnim", "", "selectedColorModel", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "getSelectedColorModel", "()Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "selectedPenViewModel", "getSelectedPenViewModel", "()Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel;", "updatePaletteList", XmlErrorCodes.LIST, "", "addRecentColor", "hsvColor", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "recentPalette", "getRecentPalette", "()Ljava/util/List;", "setRecentPalette", "(Ljava/util/List;)V", "setColorViewVisibility", "isOpened", "setMenuHideViewModel", "menuHideViewModel", "setBrushLayoutViewModel", "brushLayoutViewModel", "setSettingsViewModel", "settingsViewModel", "updateMenuInfo", "info", "view", "Landroid/view/View;", "selectNextRecentColor", "close", "setMenuInfo", "isPenMenuOpen", "()Z", "disableSmartTipPopup", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBrushMenuControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrushMenuControl.kt\ncom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,294:1\n1#2:295\n*E\n"})
public abstract class BrushMenuControl {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushMenuControl");

    @Nullable
    private BrushLayoutViewModel mBrushLayoutViewModel;

    @Nullable
    private BrushMenuHideViewModel mBrushMenuHideViewModel;

    @Nullable
    private IBrushMenuInfo mBrushMenuInfo;

    @Nullable
    private BrushSettingsViewModel mBrushSettingsViewModel;

    @NotNull
    private final BrushMenuControl$mColorActionListener$1 mColorActionListener;

    @NotNull
    private final BrushMenuControl$mColorButtonListener$1 mColorButtonListener;

    @NotNull
    private final BrushMenuControl$mColorChangeListener$1 mColorChangeListener;

    @NotNull
    private final BrushMenuControl$mColorSwipeListener$1 mColorSwipeListener;

    @Nullable
    private SpenColorLayout mColorView;

    @NotNull
    private final BrushMenuControl$mPenActionListener$1 mPenActionListener;

    @Nullable
    private SpenBrushPenLayoutInterface mPenView;

    @Nullable
    private SubMenuLayoutViewModel mSubMenuLayoutViewModel;

    @Nullable
    private TipPopupWidgetWrapper mTipPopup;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mPenActionListener$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorActionListener$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorChangeListener$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorSwipeListener$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorButtonListener$1] */
    public BrushMenuControl(@Nullable BrushMenuControl brushMenuControl) {
        if (brushMenuControl != null) {
            this.mBrushLayoutViewModel = brushMenuControl.mBrushLayoutViewModel;
            this.mBrushMenuHideViewModel = brushMenuControl.mBrushMenuHideViewModel;
            this.mSubMenuLayoutViewModel = brushMenuControl.mSubMenuLayoutViewModel;
            this.mBrushSettingsViewModel = brushMenuControl.mBrushSettingsViewModel;
        }
        this.mPenActionListener = new SpenBrushPenLayoutInterface.OnActionListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mPenActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface.OnActionListener
            public void onPenClicked(String name, boolean isSelected) {
                Intrinsics.checkNotNullParameter(name, "name");
                Logger.m7100d(BrushMenuControl.TAG, "onPenClicked. " + name + "," + isSelected);
                this.this$0.disableSmartTipPopup();
                BrushLayoutViewModel brushLayoutViewModel = this.this$0.mBrushLayoutViewModel;
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
                Intrinsics.checkNotNull(menuViewModel);
                SpenBrushPenLayoutInterface mPenView = this.this$0.getMPenView();
                Integer numValueOf = mPenView != null ? Integer.valueOf(mPenView.getPenCount()) : null;
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue = numValueOf.intValue();
                SpenBrushPenLayoutInterface mPenView2 = this.this$0.getMPenView();
                Integer numValueOf2 = mPenView2 != null ? Integer.valueOf(mPenView2.getSelectedPenPosition()) : null;
                Intrinsics.checkNotNull(numValueOf2);
                menuViewModel.setPenPopupAlign(iIntValue, numValueOf2.intValue());
                BrushLayoutViewModel brushLayoutViewModel2 = this.this$0.mBrushLayoutViewModel;
                PenViewModelList penViewModelList = brushLayoutViewModel2 != null ? brushLayoutViewModel2.getPenViewModelList() : null;
                Intrinsics.checkNotNull(penViewModelList);
                penViewModelList.onPenClicked(name, isSelected);
            }
        };
        this.mColorActionListener = new OnActionButtonListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
            public void onButtonClick(int type) {
                MenuLayoutViewModel menuViewModel;
                BrushSettingsViewModel brushSettingsViewModel;
                AbstractC6670b.m4761v(type, "onColorButtonClick. ", BrushMenuControl.TAG);
                this.this$0.disableSmartTipPopup();
                if (type == 1) {
                    BrushLayoutViewModel brushLayoutViewModel = this.this$0.mBrushLayoutViewModel;
                    menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
                    Intrinsics.checkNotNull(menuViewModel);
                    ColorGradationViewModel mColorGradationViewModel = menuViewModel.getMColorGradationViewModel();
                    Intrinsics.checkNotNull(mColorGradationViewModel);
                    mColorGradationViewModel.onColorGradationClick();
                    return;
                }
                if (type != 2) {
                    if (type == 3 && (brushSettingsViewModel = this.this$0.mBrushSettingsViewModel) != null) {
                        brushSettingsViewModel.onPaletteSettingClick();
                        return;
                    }
                    return;
                }
                BrushLayoutViewModel brushLayoutViewModel2 = this.this$0.mBrushLayoutViewModel;
                menuViewModel = brushLayoutViewModel2 != null ? brushLayoutViewModel2.getMenuViewModel() : null;
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                ColorRecentViewModel mRecent = mColorMenuViewModel.getMRecent();
                Intrinsics.checkNotNull(mRecent);
                mRecent.onClickColorPicker();
            }
        };
        this.mColorChangeListener = new OnColorChangeListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                Logger.m7100d(BrushMenuControl.TAG, "onColorChanged. " + Integer.toHexString(info) + SQLKeyword.COMMA + Integer.toHexString(ColorCompat.HSVToColor(hsvColor)));
                BrushLayoutViewModel brushLayoutViewModel = this.this$0.mBrushLayoutViewModel;
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                mColorMenuViewModel.setMainColorAndPosition(hsvColor, info);
                this.this$0.updateCurrentPenView();
            }
        };
        this.mColorSwipeListener = new OnPaletteSwipeListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorSwipeListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener
            public void onPaletteSwipe(int direction, int id) {
                Logger.m7100d(BrushMenuControl.TAG, "onPaletteSwipe. " + direction + SQLKeyword.COMMA + id);
                BrushLayoutViewModel brushLayoutViewModel = this.this$0.mBrushLayoutViewModel;
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                mColorMenuViewModel.swipePalettes(direction, id);
            }
        };
        this.mColorButtonListener = new OnColorButtonListener() { // from class: com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl$mColorButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorButtonListener
            public void onColorSelected(int pageIndex, int childIndex, boolean isSelected) {
                String str = BrushMenuControl.TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIndex, childIndex, "onColorSelected. ", SQLKeyword.COMMA, SQLKeyword.COMMA);
                sbM1173s.append(isSelected);
                Logger.m7100d(str, sbM1173s.toString());
                this.this$0.disableSmartTipPopup();
                BrushLayoutViewModel brushLayoutViewModel = this.this$0.mBrushLayoutViewModel;
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                mColorMenuViewModel.selectColorButton(pageIndex, childIndex, isSelected);
                this.this$0.updateCurrentPenView();
            }
        };
    }

    private final IExtendedColor getSelectedColorModel() {
        IPenViewModel selectedPenViewModel = getSelectedPenViewModel();
        if (selectedPenViewModel != null) {
            String penName = selectedPenViewModel.getPenName();
            Intrinsics.checkNotNull(penName);
            if (StringsKt.m14162r(penName, "Smudge")) {
                BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
                Intrinsics.checkNotNull(brushLayoutViewModel);
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel.getMenuViewModel();
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                int currentPage = mColorMenuViewModel.getCurrentPage();
                List<Integer> selectedIndices = mColorMenuViewModel.getSelectedIndices();
                Intrinsics.checkNotNull(selectedIndices);
                if (currentPage < 0 || currentPage >= selectedIndices.size()) {
                    currentPage = 0;
                }
                return new ColorModel(MarketingConstants.PopupConst.DEFAULT_COLOR_LINE, (selectedIndices.get(currentPage).intValue() << 8) | 4194304);
            }
        }
        BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
        Intrinsics.checkNotNull(brushLayoutViewModel2);
        MenuLayoutViewModel menuViewModel2 = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel2);
        ColorMenuViewModel mColorMenuViewModel2 = menuViewModel2.getMColorMenuViewModel();
        Intrinsics.checkNotNull(mColorMenuViewModel2);
        return mColorMenuViewModel2.getSelectedColor();
    }

    private final IPenViewModel getSelectedPenViewModel() {
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        if ((brushLayoutViewModel != null ? brushLayoutViewModel.getPenViewModelList() : null) == null) {
            return null;
        }
        BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
        Intrinsics.checkNotNull(brushLayoutViewModel2);
        PenViewModelList penViewModelList = brushLayoutViewModel2.getPenViewModelList();
        Intrinsics.checkNotNull(penViewModelList);
        return penViewModelList.getSelectedViewModel();
    }

    public final void addRecentColor(@Nullable float[] hsvColor) {
        SpenColorLayout spenColorLayout;
        if (hsvColor == null || (spenColorLayout = this.mColorView) == null) {
            return;
        }
        spenColorLayout.addRecentColor(hsvColor);
    }

    public void close() {
        SpenColorLayout spenColorLayout = this.mColorView;
        if (spenColorLayout != null) {
            Intrinsics.checkNotNull(spenColorLayout);
            spenColorLayout.setOnActionButtonListener(null);
            SpenColorLayout spenColorLayout2 = this.mColorView;
            Intrinsics.checkNotNull(spenColorLayout2);
            spenColorLayout2.setOnColorButtonListener(null);
            SpenColorLayout spenColorLayout3 = this.mColorView;
            Intrinsics.checkNotNull(spenColorLayout3);
            spenColorLayout3.setOnPaletteSwipeListener(null);
            SpenColorLayout spenColorLayout4 = this.mColorView;
            Intrinsics.checkNotNull(spenColorLayout4);
            spenColorLayout4.setOnColorChangeListener(null);
            this.mColorView = null;
        }
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenView;
        if (spenBrushPenLayoutInterface != null) {
            Intrinsics.checkNotNull(spenBrushPenLayoutInterface);
            spenBrushPenLayoutInterface.setActionListener(null);
            this.mPenView = null;
        }
        if (this.mBrushMenuInfo != null) {
            this.mBrushMenuInfo = null;
        }
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mTipPopup;
        if (tipPopupWidgetWrapper != null) {
            Intrinsics.checkNotNull(tipPopupWidgetWrapper);
            if (tipPopupWidgetWrapper.isShowing()) {
                TipPopupWidgetWrapper tipPopupWidgetWrapper2 = this.mTipPopup;
                Intrinsics.checkNotNull(tipPopupWidgetWrapper2);
                tipPopupWidgetWrapper2.dismiss(false);
            }
            this.mTipPopup = null;
        }
    }

    public void disableSmartTipPopup() {
    }

    @Nullable
    public abstract SpenBrushLayoutInfo getBrushLayoutInfo();

    @Nullable
    public final IBrushMenuInfo getMBrushMenuInfo() {
        return this.mBrushMenuInfo;
    }

    @Nullable
    public final SpenBrushPenLayoutInterface getMPenView() {
        return this.mPenView;
    }

    @Nullable
    public final TipPopupWidgetWrapper getMTipPopup() {
        return this.mTipPopup;
    }

    @Nullable
    public final List<SpenHSVColor> getRecentPalette() {
        SpenColorLayout spenColorLayout = this.mColorView;
        if (spenColorLayout != null) {
            return spenColorLayout.getRecentColor();
        }
        return null;
    }

    public final boolean isPenMenuOpen() {
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        if (brushLayoutViewModel == null) {
            return false;
        }
        Intrinsics.checkNotNull(brushLayoutViewModel);
        if (brushLayoutViewModel.getMenuViewModel() == null) {
            return false;
        }
        BrushLayoutViewModel brushLayoutViewModel2 = this.mBrushLayoutViewModel;
        Intrinsics.checkNotNull(brushLayoutViewModel2);
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel2.getMenuViewModel();
        Intrinsics.checkNotNull(menuViewModel);
        return menuViewModel.getMPenModeOpen();
    }

    public final void selectNextRecentColor(@Nullable float[] hsvColor) {
        SpenColorLayout spenColorLayout = this.mColorView;
        Intrinsics.checkNotNull(spenColorLayout);
        if (spenColorLayout.getPalette() > 0) {
            SpenColorLayout spenColorLayout2 = this.mColorView;
            Intrinsics.checkNotNull(spenColorLayout2);
            spenColorLayout2.setPalette(0);
        }
        if (hsvColor != null) {
            updateCurrentColorView(new ColorModel(ColorCompat.HSVToColor(hsvColor), hsvColor, 1048576), false);
            updateCurrentPenView();
        }
    }

    public void setBrushLayout(@NotNull SpenSettingBrushLayout brushLayout, @Nullable SpenBrushPenTypeLayout.OnModeChangeListener listener) {
        Intrinsics.checkNotNullParameter(brushLayout, "brushLayout");
        this.mPenView = brushLayout.getPenView();
        this.mColorView = brushLayout.getColorView();
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenView;
        if (spenBrushPenLayoutInterface != null) {
            spenBrushPenLayoutInterface.setActionListener(this.mPenActionListener);
        }
        SpenColorLayout spenColorLayout = this.mColorView;
        if (spenColorLayout != null) {
            spenColorLayout.setOnActionButtonListener(this.mColorActionListener);
            spenColorLayout.setOnColorButtonListener(this.mColorButtonListener);
            spenColorLayout.setOnPaletteSwipeListener(this.mColorSwipeListener);
            spenColorLayout.setOnColorChangeListener(this.mColorChangeListener);
        }
    }

    public final void setBrushLayoutViewModel(@Nullable BrushLayoutViewModel brushLayoutViewModel) {
        MenuLayoutViewModel menuViewModel;
        this.mBrushLayoutViewModel = brushLayoutViewModel;
        SubMenuLayoutViewModel mSubMenuLayoutViewModel = (brushLayoutViewModel == null || (menuViewModel = brushLayoutViewModel.getMenuViewModel()) == null) ? null : menuViewModel.getMSubMenuLayoutViewModel();
        Intrinsics.checkNotNull(mSubMenuLayoutViewModel);
        this.mSubMenuLayoutViewModel = mSubMenuLayoutViewModel;
    }

    public final void setColorViewVisibility(boolean isOpened) {
        SpenColorLayout spenColorLayout = this.mColorView;
        if (spenColorLayout != null) {
            spenColorLayout.setVisibility(isOpened ? 8 : 0);
        }
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        if (brushLayoutViewModel != null) {
            Intrinsics.checkNotNull(brushLayoutViewModel);
            MenuLayoutViewModel menuViewModel = brushLayoutViewModel.getMenuViewModel();
            Intrinsics.checkNotNull(menuViewModel);
            menuViewModel.setPenViewMode(isOpened);
        }
    }

    public final void setMBrushMenuInfo(@Nullable IBrushMenuInfo iBrushMenuInfo) {
        this.mBrushMenuInfo = iBrushMenuInfo;
    }

    public final void setMPenView(@Nullable SpenBrushPenLayoutInterface spenBrushPenLayoutInterface) {
        this.mPenView = spenBrushPenLayoutInterface;
    }

    public final void setMTipPopup(@Nullable TipPopupWidgetWrapper tipPopupWidgetWrapper) {
        this.mTipPopup = tipPopupWidgetWrapper;
    }

    public final void setMenuHideViewModel(@Nullable BrushMenuHideViewModel menuHideViewModel) {
        this.mBrushMenuHideViewModel = menuHideViewModel;
    }

    public boolean setMenuInfo(@Nullable IBrushMenuInfo info) {
        if (info == null) {
            return false;
        }
        IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
        if (iBrushMenuInfo != null && info.isEquals(iBrushMenuInfo)) {
            return false;
        }
        Logger.m7100d(TAG, "setMenuInfo. ");
        this.mBrushMenuInfo = info;
        SubMenuLayoutViewModel subMenuLayoutViewModel = this.mSubMenuLayoutViewModel;
        if (subMenuLayoutViewModel == null) {
            return true;
        }
        Intrinsics.checkNotNull(subMenuLayoutViewModel);
        subMenuLayoutViewModel.setBrushMenuInfo(this.mBrushMenuInfo);
        return true;
    }

    public final void setPenInfo(@Nullable PenViewModelList viewModelList) {
        Hashtable<String, PenViewModel> penViewModelList = viewModelList != null ? viewModelList.getPenViewModelList() : null;
        if ((penViewModelList != null ? Integer.valueOf(penViewModelList.size()) : null) == null || this.mPenView == null) {
            return;
        }
        int size = penViewModelList.size();
        for (int i = 0; i < size; i++) {
            PenViewModel penViewModel = penViewModelList.get(IPenViewModelFactory.NAME[i]);
            SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenView;
            Intrinsics.checkNotNull(spenBrushPenLayoutInterface);
            Intrinsics.checkNotNull(penViewModel);
            spenBrushPenLayoutInterface.setPenInfo(penViewModel.getPenClass(), penViewModel.getColor());
        }
    }

    public final void setRecentPalette(@Nullable List<SpenHSVColor> list) {
        SpenColorLayout spenColorLayout = this.mColorView;
        if (spenColorLayout != null) {
            spenColorLayout.setRecentColor(list);
        }
    }

    public final void setSettingsViewModel(@Nullable BrushSettingsViewModel settingsViewModel) {
        this.mBrushSettingsViewModel = settingsViewModel;
    }

    public void setSmartTipPopup() {
    }

    public final void updateCurrentColorView(boolean needAnim) {
        IExtendedColor selectedColorModel = getSelectedColorModel();
        if (selectedColorModel != null) {
            updateCurrentColorView(selectedColorModel, needAnim);
        }
    }

    public final void updateCurrentPenView() {
        IPenViewModel selectedPenViewModel = getSelectedPenViewModel();
        if (selectedPenViewModel != null) {
            updateCurrentPenView(selectedPenViewModel);
        }
    }

    public final void updateMenuInfo(@Nullable IBrushMenuInfo info, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (setMenuInfo(info)) {
            Logger.m7100d(TAG, "updateMenuInfo.");
            SubMenuLayoutViewModel subMenuLayoutViewModel = this.mSubMenuLayoutViewModel;
            if (subMenuLayoutViewModel != null) {
                subMenuLayoutViewModel.setLayoutRect(view.findViewById(C7944R.id.brush_sub_menu_container));
            }
            SpenColorLayout spenColorLayout = this.mColorView;
            int statusBarHeight = CommonUtil.getStatusBarHeight(spenColorLayout != null ? spenColorLayout.getContext() : null);
            BrushMenuHideViewModel brushMenuHideViewModel = this.mBrushMenuHideViewModel;
            if (brushMenuHideViewModel != null) {
                View view2 = (View) this.mPenView;
                Intrinsics.checkNotNull(view2);
                int id = view2.getId();
                IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
                Rect penRect = iBrushMenuInfo != null ? iBrushMenuInfo.getPenRect() : null;
                Intrinsics.checkNotNull(penRect);
                brushMenuHideViewModel.setLayoutRect(id, penRect, statusBarHeight);
            }
            BrushMenuHideViewModel brushMenuHideViewModel2 = this.mBrushMenuHideViewModel;
            if (brushMenuHideViewModel2 != null) {
                SpenColorLayout spenColorLayout2 = this.mColorView;
                Integer numValueOf = spenColorLayout2 != null ? Integer.valueOf(spenColorLayout2.getId()) : null;
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue = numValueOf.intValue();
                IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
                Rect colorRect = iBrushMenuInfo2 != null ? iBrushMenuInfo2.getColorRect() : null;
                Intrinsics.checkNotNull(colorRect);
                brushMenuHideViewModel2.setLayoutRect(iIntValue, colorRect, statusBarHeight);
            }
        }
    }

    public final void updatePaletteList(@Nullable List<Integer> list) {
        SpenColorLayout spenColorLayout;
        if (list == null || (spenColorLayout = this.mColorView) == null) {
            return;
        }
        spenColorLayout.setPaletteList(list);
    }

    private final void updateCurrentColorView(IExtendedColor color, boolean needAnim) {
        Integer numValueOf;
        int mPosition = color.getMPosition();
        float[] mhsv = color.getMHSV();
        if (mPosition == 4194304) {
            SpenColorLayout spenColorLayout = this.mColorView;
            if (spenColorLayout != null) {
                BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
                Intrinsics.checkNotNull(brushLayoutViewModel);
                MenuLayoutViewModel menuViewModel = brushLayoutViewModel.getMenuViewModel();
                Intrinsics.checkNotNull(menuViewModel);
                ColorMenuViewModel mColorMenuViewModel = menuViewModel.getMColorMenuViewModel();
                Intrinsics.checkNotNull(mColorMenuViewModel);
                List<Integer> selectedIndices = mColorMenuViewModel.getSelectedIndices();
                Intrinsics.checkNotNull(selectedIndices);
                Integer num = selectedIndices.get(0);
                Intrinsics.checkNotNull(num);
                numValueOf = Integer.valueOf(spenColorLayout.getUiInfo(1, num.intValue()));
            } else {
                numValueOf = null;
            }
            Intrinsics.checkNotNull(numValueOf);
            mPosition = numValueOf.intValue();
        } else if (((-1048576) & mPosition) == 1048576) {
            mPosition = 1048576;
        }
        Logger.m7100d(TAG, "updateCurrentColorView. " + Integer.toHexString(ColorCompat.HSVToColor(mhsv)) + SQLKeyword.COMMA + Integer.toHexString(mPosition));
        SpenColorLayout spenColorLayout2 = this.mColorView;
        if (spenColorLayout2 != null) {
            spenColorLayout2.setColor(mPosition, mhsv, needAnim);
        }
    }

    public final void updateCurrentPenView(int color) {
        IPenViewModel selectedPenViewModel = getSelectedPenViewModel();
        if (selectedPenViewModel != null) {
            selectedPenViewModel.setColor(color);
            updateCurrentPenView(selectedPenViewModel);
        }
    }

    public final void updateCurrentPenView(@NotNull IPenViewModel penViewModel) {
        Intrinsics.checkNotNullParameter(penViewModel, "penViewModel");
        String str = TAG;
        String penName = penViewModel.getPenName();
        String hexString = Integer.toHexString(penViewModel.getColor());
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface = this.mPenView;
        Integer numValueOf = spenBrushPenLayoutInterface != null ? Integer.valueOf(spenBrushPenLayoutInterface.getSelectedPenPosition()) : null;
        StringBuilder sbM16m = AbstractC0000a.m16m("updateCurrentPenView. ", penName, SQLKeyword.COMMA, hexString, " ");
        sbM16m.append(numValueOf);
        Logger.m7100d(str, sbM16m.toString());
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface2 = this.mPenView;
        if (spenBrushPenLayoutInterface2 != null) {
            spenBrushPenLayoutInterface2.setPenInfo(penViewModel.getPenClass(), penViewModel.getColor());
        }
        BrushLayoutViewModel brushLayoutViewModel = this.mBrushLayoutViewModel;
        MenuLayoutViewModel menuViewModel = brushLayoutViewModel != null ? brushLayoutViewModel.getMenuViewModel() : null;
        Intrinsics.checkNotNull(menuViewModel);
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface3 = this.mPenView;
        Integer numValueOf2 = spenBrushPenLayoutInterface3 != null ? Integer.valueOf(spenBrushPenLayoutInterface3.getPenCount()) : null;
        Intrinsics.checkNotNull(numValueOf2);
        int iIntValue = numValueOf2.intValue();
        SpenBrushPenLayoutInterface spenBrushPenLayoutInterface4 = this.mPenView;
        Integer numValueOf3 = spenBrushPenLayoutInterface4 != null ? Integer.valueOf(spenBrushPenLayoutInterface4.getSelectedPenPosition()) : null;
        Intrinsics.checkNotNull(numValueOf3);
        menuViewModel.setPenPopupAlign(iIntValue, numValueOf3.intValue());
    }
}
