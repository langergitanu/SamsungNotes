package com.samsung.android.support.senl.addons.brush.view.menu.control;

import android.content.res.Resources;
import android.view.View;
import com.samsung.android.sdk.pen.setting.SpenBrushLayoutInfo;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p145cm.base.framework.widget.TipPopupWidgetWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0004J\b\u0010\n\u001a\u00020\bH\u0004J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushTabletMenuControl;", "Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;", "prev", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/menu/control/BrushMenuControl;)V", "getBrushLayoutInfo", "Lcom/samsung/android/sdk/pen/setting/SpenBrushLayoutInfo;", "setSmartTipPopup", "", "showSmartTipForPenView", "updateSmartTipForPenView", "disableSmartTipPopup", "setMenuInfo", "", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "loadColorMenuPosition", "", "loadPenMenuPosition", "saveMenuPosition", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushTabletMenuControl extends BrushMenuControl {

    @NotNull
    private static final String BRUSH_V6 = "_brush_v6";

    @NotNull
    private static final String COLOR_MENU_POSITION = "COLOR_MENU_POSITION";

    @NotNull
    private static final String PEN_MENU_POSITION = "PEN_MENU_POSITION";

    public BrushTabletMenuControl(@Nullable BrushMenuControl brushMenuControl) {
        super(brushMenuControl);
    }

    private final int loadColorMenuPosition() {
        return PreferenceUtils.getInt(BRUSH_V6, COLOR_MENU_POSITION, 3);
    }

    private final int loadPenMenuPosition() {
        return PreferenceUtils.getInt(BRUSH_V6, PEN_MENU_POSITION, 3);
    }

    private final void saveMenuPosition() {
        IBrushMenuInfo mBrushMenuInfo = getMBrushMenuInfo();
        Intrinsics.checkNotNull(mBrushMenuInfo);
        PreferenceUtils.putInt(BRUSH_V6, COLOR_MENU_POSITION, mBrushMenuInfo.getColorAlign());
        IBrushMenuInfo mBrushMenuInfo2 = getMBrushMenuInfo();
        Intrinsics.checkNotNull(mBrushMenuInfo2);
        PreferenceUtils.putInt(BRUSH_V6, PEN_MENU_POSITION, mBrushMenuInfo2.getPenAlign());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSmartTipPopup$lambda$0(BrushTabletMenuControl brushTabletMenuControl) {
        if (brushTabletMenuControl.getMPenView() == null) {
            return;
        }
        TipPopupWidgetWrapper mTipPopup = brushTabletMenuControl.getMTipPopup();
        if (mTipPopup == null || !mTipPopup.isShowing()) {
            brushTabletMenuControl.showSmartTipForPenView();
        } else {
            brushTabletMenuControl.updateSmartTipForPenView();
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    public void disableSmartTipPopup() {
        PlatformUtil.setSmartTipsPreference("BrushMenuSmartTip", 1);
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    @NotNull
    public SpenBrushLayoutInfo getBrushLayoutInfo() {
        SpenBrushLayoutInfo spenBrushLayoutInfo = new SpenBrushLayoutInfo();
        spenBrushLayoutInfo.style = 2;
        spenBrushLayoutInfo.penViewType = 2;
        spenBrushLayoutInfo.moveable = true;
        spenBrushLayoutInfo.isOpened = false;
        spenBrushLayoutInfo.penWidthRatio = 0.575f;
        spenBrushLayoutInfo.penHeightRatio = 0.1425f;
        spenBrushLayoutInfo.penAlign = loadPenMenuPosition();
        spenBrushLayoutInfo.colorWidthRatio = 0.395f;
        spenBrushLayoutInfo.colorHeightRatio = 0.1425f;
        spenBrushLayoutInfo.colorAlign = loadColorMenuPosition();
        spenBrushLayoutInfo.spaceRatio = 0.0f;
        return spenBrushLayoutInfo;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    public boolean setMenuInfo(@Nullable IBrushMenuInfo info) {
        if (info == null) {
            return false;
        }
        boolean menuInfo = super.setMenuInfo(info);
        if (menuInfo) {
            saveMenuPosition();
        }
        return menuInfo;
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.menu.control.BrushMenuControl
    public void setSmartTipPopup() {
        Object mPenView = getMPenView();
        Intrinsics.checkNotNull(mPenView, "null cannot be cast to non-null type android.view.View");
        ((View) mPenView).post(new RunnableC7599e(this, 10));
    }

    public final void showSmartTipForPenView() {
        if (PlatformUtil.getSmartTipsPreference("BrushMenuSmartTip", 0) == 0) {
            Object mPenView = getMPenView();
            Intrinsics.checkNotNull(mPenView, "null cannot be cast to non-null type android.view.View");
            Resources resources = ((View) mPenView).getResources();
            try {
                Object mPenView2 = getMPenView();
                Intrinsics.checkNotNull(mPenView2, "null cannot be cast to non-null type android.view.View");
                setMTipPopup(new TipPopupWidgetWrapper((View) mPenView2));
                TipPopupWidgetWrapper mTipPopup = getMTipPopup();
                Intrinsics.checkNotNull(mTipPopup);
                mTipPopup.setMessage(resources.getString(C7944R.string.brush_menu_smart_tip));
                TipPopupWidgetWrapper mTipPopup2 = getMTipPopup();
                Intrinsics.checkNotNull(mTipPopup2);
                mTipPopup2.setMessageTextColor(resources.getColor(C7944R.color.brush_smart_tip_text, null));
                TipPopupWidgetWrapper mTipPopup3 = getMTipPopup();
                Intrinsics.checkNotNull(mTipPopup3);
                mTipPopup3.setBackgroundColor(resources.getColor(C7944R.color.brush_smart_tip_background, null));
                TipPopupWidgetWrapper mTipPopup4 = getMTipPopup();
                Intrinsics.checkNotNull(mTipPopup4);
                mTipPopup4.setExpanded(true);
                updateSmartTipForPenView();
                TipPopupWidgetWrapper mTipPopup5 = getMTipPopup();
                Intrinsics.checkNotNull(mTipPopup5);
                mTipPopup5.show(-1);
                disableSmartTipPopup();
            } catch (NoClassDefFoundError unused) {
            }
        }
    }

    public final void updateSmartTipForPenView() {
        int iWidth;
        Object mPenView = getMPenView();
        Intrinsics.checkNotNull(mPenView, "null cannot be cast to non-null type android.view.View");
        Resources resources = ((View) mPenView).getResources();
        int[] iArr = new int[2];
        Object mPenView2 = getMPenView();
        Intrinsics.checkNotNull(mPenView2, "null cannot be cast to non-null type android.view.View");
        ((View) mPenView2).getLocationInWindow(iArr);
        int iHeight = 0;
        int i = iArr[0];
        if (getMBrushMenuInfo() != null) {
            IBrushMenuInfo mBrushMenuInfo = getMBrushMenuInfo();
            Intrinsics.checkNotNull(mBrushMenuInfo);
            iWidth = mBrushMenuInfo.getPenRect().width() / 2;
        } else {
            iWidth = 0;
        }
        int i2 = i + iWidth;
        int i4 = iArr[1];
        if (getMBrushMenuInfo() != null) {
            IBrushMenuInfo mBrushMenuInfo2 = getMBrushMenuInfo();
            Intrinsics.checkNotNull(mBrushMenuInfo2);
            iHeight = mBrushMenuInfo2.getPenRect().height() + resources.getDimensionPixelSize(C7944R.dimen.brush_smart_tip_top_margin);
        }
        TipPopupWidgetWrapper mTipPopup = getMTipPopup();
        Intrinsics.checkNotNull(mTipPopup);
        mTipPopup.setTargetPosition(i2, i4 + iHeight);
        TipPopupWidgetWrapper mTipPopup2 = getMTipPopup();
        Intrinsics.checkNotNull(mTipPopup2);
        mTipPopup2.update();
    }
}
