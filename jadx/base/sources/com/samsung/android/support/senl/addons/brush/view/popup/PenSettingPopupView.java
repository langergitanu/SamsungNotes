package com.samsung.android.support.senl.addons.brush.view.popup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuLayoutInjector;
import com.samsung.android.support.senl.addons.brush.view.popup.SettingPopupViewUtils;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\u0010H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/PenSettingPopupView;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenSettingLayout;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "context", "Landroid/content/Context;", "needSeekBarStroke", "", "<init>", "(Landroid/content/Context;Z)V", "mMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mPenPopupAlign", "", "mRotateDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", Constants.IntentExtraValue.SHOW, "", "hide", "result", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView$IPopupResult;", "updatePosition", "info", "subAlign", "setRotationDelegate", "delegate", "isVisible", "isStart", "align", "position", "getPenPopupMarginForCenterAlign", "canShowPenPopupForEndAlign", "rotate", "event", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "pivotByPenMenuAlign", "getPivotByPenMenuAlign", "()I", "getHorizontalMargin", "getVerticalMargin", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class PenSettingPopupView extends SpenBrushPenSettingLayout implements IBrushSettingPopupView {

    @NotNull
    private static final String TAG = Logger.createTag("PenSettingPopupView");

    @Nullable
    private IBrushMenuInfo mMenuInfo;
    private int mPenPopupAlign;

    @Nullable
    private RotationDelegate mRotateDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PenSettingPopupView(@NotNull Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        MenuLayoutInjector menuLayoutInjector = new MenuLayoutInjector(context);
        setRoundedBackground(menuLayoutInjector.getRadius(), menuLayoutInjector.getBackgroundColor(), menuLayoutInjector.getStrokeSize(), menuLayoutInjector.getStrokeColor());
    }

    private final boolean canShowPenPopupForEndAlign() {
        int iWidth;
        int measuredWidth;
        if (this.mMenuInfo == null) {
            return false;
        }
        measure(0, 0);
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        Rect mPenRect = iBrushMenuInfo.getMPenRect();
        IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo2);
        int mPenAlign = iBrushMenuInfo2.getMPenAlign();
        if (mPenAlign == 0 || mPenAlign == 3) {
            iWidth = mPenRect.width();
            measuredWidth = getMeasuredWidth();
        } else {
            iWidth = mPenRect.height();
            measuredWidth = getMeasuredHeight();
        }
        Logger.m7100d(TAG, "canShowPenPopupForEndAlign. vR=" + iWidth + " >= pR" + measuredWidth);
        return iWidth >= measuredWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getPenPopupMarginForCenterAlign() {
        int iWidth;
        int measuredWidth;
        int i = 0;
        if (this.mMenuInfo == null) {
            return 0;
        }
        measure(0, 0);
        String str = TAG;
        Logger.m7100d(str, "penSetting. width=" + getMeasuredWidth() + SQLKeyword.COMMA + getMeasuredHeight());
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo);
        Rect mPenRect = iBrushMenuInfo.getMPenRect();
        IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo2);
        int mPenAlign = iBrushMenuInfo2.getMPenAlign();
        if (mPenAlign == 0 || mPenAlign == 3) {
            iWidth = mPenRect.width() / 2;
            measuredWidth = getMeasuredWidth() / 2;
        } else {
            iWidth = mPenRect.height() / 2;
            measuredWidth = getMeasuredHeight() / 2;
        }
        int i2 = iWidth - measuredWidth;
        if (i2 < 0) {
            boolean z = getResources().getConfiguration().getLayoutDirection() == 1;
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            View view = (View) parent;
            if (z) {
                if (mPenRect.centerX() + measuredWidth > view.getWidth()) {
                    int iCenterX = mPenRect.centerX();
                    int width = view.getWidth();
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(iCenterX, measuredWidth, "[LTR] Not enough space. so make margin= 0 center=", " popupRadius=", "width=");
                    sbM1173s.append(width);
                    Logger.m7100d(str, sbM1173s.toString());
                }
            } else if (mPenRect.centerX() - measuredWidth < 0) {
                Logger.m7100d(str, "[LTR] Not enough space. so make margin= 0 center=" + mPenRect.centerX() + " popupRadius=" + measuredWidth);
            } else {
                i = i2;
            }
        }
        AbstractC6670b.m4761v(i, "result margin=", str);
        return i;
    }

    private final int getPivotByPenMenuAlign() {
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        if (iBrushMenuInfo == null) {
            return 0;
        }
        Intrinsics.checkNotNull(iBrushMenuInfo);
        int mPenAlign = iBrushMenuInfo.getMPenAlign();
        if (mPenAlign == 0) {
            String str = TAG;
            Logger.m7100d(str, "Pen menu align : BOTTOM");
            int i = this.mPenPopupAlign;
            if (i == -1) {
                Logger.m7100d(str, "Pen align : LEFT");
                return 6;
            }
            if (i != 1) {
                return 2;
            }
            Logger.m7100d(str, "Pen align : RIGHT");
            return 10;
        }
        if (mPenAlign == 1) {
            String str2 = TAG;
            Logger.m7100d(str2, "Pen menu align : RIGHT");
            int i2 = this.mPenPopupAlign;
            if (i2 == -1) {
                Logger.m7100d(str2, "Pen align : BOTTOM");
                return 10;
            }
            if (i2 != 1) {
                return 8;
            }
            Logger.m7100d(str2, "Pen align : TOP");
            return 9;
        }
        if (mPenAlign != 2) {
            if (mPenAlign != 3) {
                return 0;
            }
            String str3 = TAG;
            Logger.m7100d(str3, "Pen menu align : TOP");
            int i4 = this.mPenPopupAlign;
            if (i4 == -1) {
                Logger.m7100d(str3, "Pen align : LEFT");
                return 5;
            }
            if (i4 != 1) {
                return 1;
            }
            Logger.m7100d(str3, "Pen align : RIGHT");
            return 9;
        }
        String str4 = TAG;
        Logger.m7100d(str4, "Pen menu align : LEFT");
        int i5 = this.mPenPopupAlign;
        if (i5 == -1) {
            if (TabletUtil.isTabletUi()) {
                Logger.m7100d(str4, "Pen align : TOP");
                return 5;
            }
            Logger.m7100d(str4, "Pen align : BOTTOM");
            return 6;
        }
        if (i5 != 1) {
            return 4;
        }
        if (TabletUtil.isTabletUi()) {
            Logger.m7100d(str4, "Pen align : BOTTOM");
            return 6;
        }
        Logger.m7100d(str4, "Pen align : TOP");
        return 5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        if (r5 != 3) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isStart(int align, int position) {
        boolean z = true;
        boolean z2 = false;
        if (align == 0) {
            if (position == 1) {
                z = false;
            }
            z2 = z;
        } else if (align == 1 || align == 2) {
            if (position != -1) {
            }
            z2 = z;
        }
        if (!TabletUtil.isTabletUi() && align == 2) {
            z2 = !z2;
        }
        Logger.m7100d(TAG, "isStart ? " + z2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + align + " / " + position);
        return z2;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenSettingLayout, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void close() {
        this.mMenuInfo = null;
        this.mRotateDelegate = null;
        super.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
    
        if (r0.getMPenAlign() == 1) goto L8;
     */
    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getHorizontalMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        if (iBrushMenuInfo != null) {
            Intrinsics.checkNotNull(iBrushMenuInfo);
            if (iBrushMenuInfo.getMPenAlign() != 2) {
                IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo2);
            }
            IBrushMenuInfo iBrushMenuInfo3 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo3);
            return iBrushMenuInfo3.getMPenRect().height() + i;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
    
        if (r0.getMPenAlign() == 0) goto L8;
     */
    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getVerticalMargin() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
        if (iBrushMenuInfo != null) {
            Intrinsics.checkNotNull(iBrushMenuInfo);
            if (iBrushMenuInfo.getMPenAlign() != 3) {
                IBrushMenuInfo iBrushMenuInfo2 = this.mMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo2);
            }
            IBrushMenuInfo iBrushMenuInfo3 = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo3);
            return iBrushMenuInfo3.getMPenRect().height() + i;
        }
        return i;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void hide(@Nullable ISettingPopupView.IPopupResult result) {
        setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public void rotate(@Nullable IRotationEvent event) {
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            rotationDelegate.rotate(this, getPivotByPenMenuAlign());
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void setRotationDelegate(@NotNull RotationDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mRotateDelegate = delegate;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void show() {
        setVisibility(0);
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            rotationDelegate.onShow(this, getPivotByPenMenuAlign());
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition(@Nullable IBrushMenuInfo info, int subAlign) {
        AbstractC6670b.m4761v(subAlign, "updatePenSetting. ", TAG);
        this.mMenuInfo = info;
        this.mPenPopupAlign = subAlign;
        updatePosition();
        RotationDelegate rotationDelegate = this.mRotateDelegate;
        if (rotationDelegate != null) {
            rotationDelegate.rotate((IBrushSettingPopupView) this, getPivotByPenMenuAlign(), true);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition() {
        boolean z;
        int penPopupMarginForCenterAlign;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (this.mMenuInfo != null) {
            SettingPopupViewUtils.Companion companion = SettingPopupViewUtils.INSTANCE;
            companion.resetPopupParams(layoutParams2);
            IBrushMenuInfo iBrushMenuInfo = this.mMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo);
            int mPenAlign = iBrushMenuInfo.getMPenAlign();
            boolean zIsStart = isStart(mPenAlign, this.mPenPopupAlign);
            int i = this.mPenPopupAlign;
            if (i == 0) {
                z = zIsStart;
                penPopupMarginForCenterAlign = getPenPopupMarginForCenterAlign();
            } else {
                if (i == 1 && !canShowPenPopupForEndAlign()) {
                    this.mPenPopupAlign = -1;
                    zIsStart = isStart(mPenAlign, -1);
                }
                z = zIsStart;
                penPopupMarginForCenterAlign = 0;
            }
            companion.setPopupParams(layoutParams2, C7944R.id.popup_pen_view, mPenAlign, getResources().getDimensionPixelSize(C7944R.dimen.brush_setting_popup_layout_between_space), z, penPopupMarginForCenterAlign);
        }
        setLayoutParams(layoutParams2);
        requestLayout();
    }
}
