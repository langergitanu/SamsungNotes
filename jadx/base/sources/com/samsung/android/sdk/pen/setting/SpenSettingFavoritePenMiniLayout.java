package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenFavoritePenMiniLayoutControl;
import com.samsung.android.sdk.pen.setting.SpenFavoritePenMiniOutsideReorder;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenMiniFavoriteControl;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001\\B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\f\u0010\u000fJ\b\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\nJ\u0016\u0010,\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\n2\u0006\u0010-\u001a\u00020 J\u0018\u00105\u001a\u00020%2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107H\u0016J\u0012\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010;\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010=\u001a\u00020 2\u0006\u00102\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010>\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010?\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010B\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020 J\u0010\u0010E\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020 J\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020 J\u0010\u0010J\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020\nH\u0016J\u001a\u0010L\u001a\u00020 2\u0010\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u00010MH\u0004J(\u0010N\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u001a\u0010O\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020 H\u0002J \u0010,\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020 2\u0006\u0010S\u001a\u00020 H\u0002J\b\u0010T\u001a\u00020%H\u0002J\b\u0010U\u001a\u00020%H\u0002J\u0010\u0010V\u001a\u00020%2\u0006\u0010W\u001a\u00020\nH\u0002J\u0010\u0010X\u001a\u00020%2\u0006\u0010R\u001a\u00020 H\u0002J\u0018\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020 H\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b,\u00100R$\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020\n8F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010/\"\u0004\b1\u00100¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenMiniLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSetting;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSettingUI;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSettingUIMode;", "Lcom/samsung/android/sdk/pen/setting/SpenPenFavoriteSettingUI;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfig;", "context", "Landroid/content/Context;", "mode", "", "maxCount", "<init>", "(Landroid/content/Context;II)V", "orientation", "(Landroid/content/Context;III)V", "mLayoutControl", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl;", "mFavoriteControl", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenMiniFavoriteControl;", "mOutsideReorder", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniOutsideReorder;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "mModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteModeChangedListener;", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteButtonClickListener;", "mChangeViewModeButtonListener", "Landroid/view/View$OnClickListener;", "mMoreButtonClickListener", "mDisallowMorePopup", "", "mOnDataChangedListener", "mButtonListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonClickListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "favoriteContainer", "Landroid/view/View;", "getFavoriteContainer", "()Landroid/view/View;", "setMode", "needAnimation", "getMode", "()I", "(I)V", "setSelectedItem", "index", "selectedItem", "getSelectedItem", "setFavoriteList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setFavoriteDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addFavorite", "info", "updateFavorite", "setOnButtonClickListener", "setOnViewItemClickListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewItemClickListener;", "setModeChangedListener", "setChangeViewModeButtonListener", "setDisallowMorePopup", "disallowMorePopup", "setMoreButtonClickListener", "playButtonAnimation", "isClose", "setAllowReorderOutside", "allowReorderOutside", "setLayoutOrientation", "getLayoutOrientation", "isSameFavoriteList", "", "construct", "setClipChildren", "view", "Landroid/view/ViewGroup;", "clipChildren", "notify", "setEditDone", "setSizeChangeTransition", "notifyButtonClick", "type", "updateClipChildren", "checkMenu", "favoriteCount", "applyLayout", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public class SpenSettingFavoritePenMiniLayout extends SpenPopupMiniLayout implements SpenFavoritePenSetting, SpenFavoritePenSettingUI, SpenFavoritePenSettingUIMode, SpenPenFavoriteSettingUI, SpenLayoutConfig {
    private static final int SIZE_CHANGE_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenSettingFavoritePenMiniLayout";

    @Nullable
    private SpenFavoriteButtonClickListener mButtonClickListener;

    @NotNull
    private final SpenFavoritePenMiniLayoutControl.ButtonClickListener mButtonListener;

    @Nullable
    private View.OnClickListener mChangeViewModeButtonListener;

    @Nullable
    private SpenFavoriteDataChangedListener mDataChangedListener;
    private boolean mDisallowMorePopup;
    private SpenMiniFavoriteControl mFavoriteControl;
    private SpenFavoritePenMiniLayoutControl mLayoutControl;

    @Nullable
    private SpenFavoriteModeChangedListener mModeChangedListener;

    @Nullable
    private View.OnClickListener mMoreButtonClickListener;

    @NotNull
    private final SpenFavoriteDataChangedListener mOnDataChangedListener;

    @Nullable
    private SpenFavoritePenMiniOutsideReorder mOutsideReorder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSettingFavoritePenMiniLayout(@NotNull Context context, int i, int i2) {
        this(context, i, i2, 1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void checkMenu(int favoriteCount, boolean applyLayout) {
        boolean z = false;
        boolean z2 = favoriteCount > 0;
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = null;
        if (favoriteCount > 0) {
            SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
            if (spenMiniFavoriteControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
                spenMiniFavoriteControl = null;
            }
            if (favoriteCount < spenMiniFavoriteControl.getMMaxCount()) {
                z = true;
            }
        }
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenMiniLayoutControl = spenFavoritePenMiniLayoutControl2;
        }
        spenFavoritePenMiniLayoutControl.setMenuEnable(z2, z, applyLayout);
    }

    private final void construct(Context context, int mode, int maxCount, int orientation) {
        SpenMiniFavoriteControl spenMiniFavoriteControl = new SpenMiniFavoriteControl(context, maxCount);
        this.mFavoriteControl = spenMiniFavoriteControl;
        spenMiniFavoriteControl.setMode(mode, false);
        SpenMiniFavoriteControl spenMiniFavoriteControl2 = this.mFavoriteControl;
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = null;
        if (spenMiniFavoriteControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl2 = null;
        }
        spenMiniFavoriteControl2.setFavoriteDataChangedListener(this.mOnDataChangedListener);
        SpenMiniFavoriteControl spenMiniFavoriteControl3 = this.mFavoriteControl;
        if (spenMiniFavoriteControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl3 = null;
        }
        spenMiniFavoriteControl3.setAddButtonClickListener(new ViewOnClickListenerC0157a(this, 21));
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = new SpenFavoritePenMiniLayoutControl(context, this, orientation);
        this.mLayoutControl = spenFavoritePenMiniLayoutControl2;
        spenFavoritePenMiniLayoutControl2.setButtonClickListener(this.mButtonListener);
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl3 = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl3 = null;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl4 = this.mFavoriteControl;
        if (spenMiniFavoriteControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl4 = null;
        }
        spenFavoritePenMiniLayoutControl3.setContent(spenMiniFavoriteControl4);
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl4 = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenMiniLayoutControl = spenFavoritePenMiniLayoutControl4;
        }
        spenFavoritePenMiniLayoutControl.setViewMode(mode, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonClick(int type) {
        SpenFavoriteButtonClickListener spenFavoriteButtonClickListener = this.mButtonClickListener;
        if (spenFavoriteButtonClickListener != null) {
            spenFavoriteButtonClickListener.onButtonClick(type);
        }
    }

    private final void setClipChildren(ViewGroup view, boolean clipChildren) {
        if (view != null) {
            view.setClipChildren(clipChildren);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEditDone() {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        SpenMiniFavoriteControl spenMiniFavoriteControl2 = null;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        if (!spenMiniFavoriteControl.applyFavoriteFromView()) {
            Log.i(TAG, "setEditDone() but same favorite list.");
            setMode(1, true, true);
            return;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl3 = this.mFavoriteControl;
        if (spenMiniFavoriteControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl3 = null;
        }
        checkMenu(spenMiniFavoriteControl3.getFavoriteCount(), false);
        setMode(1, true, true);
        SpenFavoriteDataChangedListener spenFavoriteDataChangedListener = this.mDataChangedListener;
        if (spenFavoriteDataChangedListener != null) {
            SpenMiniFavoriteControl spenMiniFavoriteControl4 = this.mFavoriteControl;
            if (spenMiniFavoriteControl4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            } else {
                spenMiniFavoriteControl2 = spenMiniFavoriteControl4;
            }
            spenFavoriteDataChangedListener.onFavoriteDataChanged(spenMiniFavoriteControl2.getFavoriteList());
        }
    }

    private final void setSizeChangeTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(400L);
        changeBounds.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        TransitionManager.beginDelayedTransition(this, changeBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateClipChildren(boolean clipChildren) {
        setClipChildren(this, clipChildren);
        View viewFindViewById = findViewById(C7932R.id.root_layout);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        setClipChildren((ViewGroup) viewFindViewById, clipChildren);
        View viewFindViewById2 = findViewById(C7932R.id.total_layout);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        setClipChildren((ViewGroup) viewFindViewById2, clipChildren);
        View viewFindViewById3 = findViewById(C7932R.id.content_area);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        setClipChildren((ViewGroup) viewFindViewById3, clipChildren);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        Log.i(TAG, "addFavorite()");
        if (getMode() != 1) {
            Log.i(TAG, "addFavorite is possible in ViewMode.");
            return false;
        }
        setSizeChangeTransition();
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        SpenMiniFavoriteControl spenMiniFavoriteControl2 = null;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        if (!spenMiniFavoriteControl.addFavorite(info)) {
            return false;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl3 = this.mFavoriteControl;
        if (spenMiniFavoriteControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
        } else {
            spenMiniFavoriteControl2 = spenMiniFavoriteControl3;
        }
        checkMenu(spenMiniFavoriteControl2.getFavoriteCount(), true);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupMiniLayout
    public void close() {
        this.mMoreButtonClickListener = null;
        this.mChangeViewModeButtonListener = null;
        this.mButtonClickListener = null;
        this.mModeChangedListener = null;
        this.mDataChangedListener = null;
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.close();
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl = null;
        }
        spenFavoritePenMiniLayoutControl.close();
        SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder = this.mOutsideReorder;
        if (spenFavoritePenMiniOutsideReorder != null) {
            spenFavoritePenMiniOutsideReorder.close(false);
        }
        this.mOutsideReorder = null;
        super.close();
    }

    @Nullable
    public final View getFavoriteContainer() {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        return spenMiniFavoriteControl.getContainerView();
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig
    public int getLayoutOrientation() {
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl = null;
        }
        return spenFavoritePenMiniLayoutControl.getMOrientation();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public int getMode() {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        return spenMiniFavoriteControl.getMode();
    }

    public final int getSelectedItem() {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        return spenMiniFavoriteControl.getSelectedItem();
    }

    public final boolean isSameFavoriteList(@Nullable List<? extends SpenSettingUIPenInfo> list) {
        if (getMode() != 1) {
            Log.i(TAG, "setFavoriteList is possible in ViewMode.");
            return false;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        return spenMiniFavoriteControl.isSameFavoriteList(list);
    }

    public final void playButtonAnimation(boolean isClose) {
        AbstractC4539a.m3208r("playCloseButtonAnimation() isClose=", TAG, isClose);
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl = null;
        }
        spenFavoritePenMiniLayoutControl.playCloseAnimation(isClose);
    }

    public final void setAllowReorderOutside(boolean allowReorderOutside) {
        if ((allowReorderOutside && this.mOutsideReorder != null) || (!allowReorderOutside && this.mOutsideReorder == null)) {
            Log.i(TAG, "setAllowReorderOutside(" + allowReorderOutside + ") -> same state. so return");
            return;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl = null;
        if (!allowReorderOutside) {
            SpenMiniFavoriteControl spenMiniFavoriteControl2 = this.mFavoriteControl;
            if (spenMiniFavoriteControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
                spenMiniFavoriteControl2 = null;
            }
            spenMiniFavoriteControl2.setOnPenMiniDragListener(null);
            SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder = this.mOutsideReorder;
            if (spenFavoritePenMiniOutsideReorder != null) {
                spenFavoritePenMiniOutsideReorder.close(true);
            }
            this.mOutsideReorder = null;
            return;
        }
        final SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder2 = new SpenFavoritePenMiniOutsideReorder();
        this.mOutsideReorder = spenFavoritePenMiniOutsideReorder2;
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl = null;
        }
        spenFavoritePenMiniOutsideReorder2.setOrientation(spenFavoritePenMiniLayoutControl.getMOrientation());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        spenFavoritePenMiniOutsideReorder2.initFloatingView(context);
        spenFavoritePenMiniOutsideReorder2.setDragDropListener(new SpenFavoritePenMiniOutsideReorder.DragDropListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout$setAllowReorderOutside$1$1
            @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenMiniOutsideReorder.DragDropListener
            public void onDropped() {
                if (this.this$0.mOutsideReorder == null) {
                    return;
                }
                this.this$0.removeContentView(spenFavoritePenMiniOutsideReorder2.getFloatingView());
                this.this$0.updateClipChildren(true);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenMiniOutsideReorder.DragDropListener
            public void onStartDrag() {
                if (this.this$0.mOutsideReorder == null) {
                    return;
                }
                int mOrientation = spenFavoritePenMiniOutsideReorder2.getMOrientation();
                SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = this.this$0.mLayoutControl;
                SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl3 = null;
                if (spenFavoritePenMiniLayoutControl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                    spenFavoritePenMiniLayoutControl2 = null;
                }
                if (mOrientation != spenFavoritePenMiniLayoutControl2.getMOrientation()) {
                    SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder3 = spenFavoritePenMiniOutsideReorder2;
                    SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl4 = this.this$0.mLayoutControl;
                    if (spenFavoritePenMiniLayoutControl4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                    } else {
                        spenFavoritePenMiniLayoutControl3 = spenFavoritePenMiniLayoutControl4;
                    }
                    spenFavoritePenMiniOutsideReorder3.setOrientation(spenFavoritePenMiniLayoutControl3.getMOrientation());
                }
                this.this$0.setContentView(spenFavoritePenMiniOutsideReorder2.getFloatingView(), new FrameLayout.LayoutParams(this.this$0.getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_width), this.this$0.getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_height)));
                this.this$0.updateClipChildren(false);
            }
        });
        SpenMiniFavoriteControl spenMiniFavoriteControl3 = this.mFavoriteControl;
        if (spenMiniFavoriteControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
        } else {
            spenMiniFavoriteControl = spenMiniFavoriteControl3;
        }
        spenMiniFavoriteControl.setOnPenMiniDragListener(this.mOutsideReorder);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenFavoriteSettingUI
    public void setChangeViewModeButtonListener(@Nullable View.OnClickListener listener) {
        this.mChangeViewModeButtonListener = listener;
    }

    public final void setColorTheme(int theme) {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.setColorTheme(theme);
    }

    public final void setDisallowMorePopup(boolean disallowMorePopup) {
        AbstractC4539a.m3208r("setDisallowMorePopup() ", TAG, disallowMorePopup);
        this.mDisallowMorePopup = disallowMorePopup;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        Log.i(TAG, "setFavoriteList()");
        if (getMode() != 1) {
            Log.i(TAG, "setFavoriteList is possible in ViewMode.");
            return;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        SpenMiniFavoriteControl spenMiniFavoriteControl2 = null;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        if (spenMiniFavoriteControl.isSameFavoriteList(list)) {
            Log.i(TAG, "Same Favorite List.");
            return;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl3 = this.mFavoriteControl;
        if (spenMiniFavoriteControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl3 = null;
        }
        spenMiniFavoriteControl3.setFavoriteList(list);
        SpenMiniFavoriteControl spenMiniFavoriteControl4 = this.mFavoriteControl;
        if (spenMiniFavoriteControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
        } else {
            spenMiniFavoriteControl2 = spenMiniFavoriteControl4;
        }
        checkMenu(spenMiniFavoriteControl2.getFavoriteCount(), true);
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig
    public void setLayoutOrientation(int orientation) {
        AbstractC2322a.m1631u(orientation, "setLayoutOrientation() orientation=", TAG);
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = this.mLayoutControl;
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = null;
        if (spenFavoritePenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenMiniLayoutControl = null;
        }
        if (spenFavoritePenMiniLayoutControl.getMOrientation() == orientation) {
            return;
        }
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl3 = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenMiniLayoutControl2 = spenFavoritePenMiniLayoutControl3;
        }
        spenFavoritePenMiniLayoutControl2.setOrientation(orientation);
    }

    public final void setMode(int mode, boolean needAnimation) {
        boolean zIsShown = isShown();
        StringBuilder sbM2226q = AbstractC2821a.m2226q("setMode() mode=", mode, " animation=", needAnimation, " shown=");
        sbM2226q.append(zIsShown);
        Log.i(TAG, sbM2226q.toString());
        setMode(mode, isShown() && needAnimation, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUIMode
    public void setModeChangedListener(@Nullable SpenFavoriteModeChangedListener listener) {
        this.mModeChangedListener = listener;
    }

    public final void setMoreButtonClickListener(@Nullable View.OnClickListener listener) {
        this.mMoreButtonClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUI
    public void setOnButtonClickListener(@Nullable SpenFavoriteButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUI
    public void setOnViewItemClickListener(@Nullable SpenFavoriteViewItemClickListener listener) {
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.setViewItemClickListener(listener);
    }

    public final void setSelectedItem(int index, boolean needAnimation) {
        AbstractC6670b.m4754o("setSelectedItem() index=", index, "needAnimation=", needAnimation, TAG);
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.setSelectedItem(index, true, needAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info) {
        Log.i(TAG, "updateFavorite() index=" + index);
        if (getMode() != 1) {
            Log.i(TAG, "updateFavorite is possible in ViewMode.");
            return false;
        }
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        return spenMiniFavoriteControl.updateFavorite(index, info);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingFavoritePenMiniLayout(@NotNull Context context, int i, int i2, int i4) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnDataChangedListener = new SpenFavoriteDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout$mOnDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                Log.i("SpenSettingFavoritePenMiniLayout", "onFavoriteDataChanged() size=" + (list != null ? Integer.valueOf(list.size()) : null));
                SpenFavoriteDataChangedListener spenFavoriteDataChangedListener = this.this$0.mDataChangedListener;
                if (spenFavoriteDataChangedListener != null) {
                    spenFavoriteDataChangedListener.onFavoriteDataChanged(list);
                }
            }
        };
        this.mButtonListener = new SpenFavoritePenMiniLayoutControl.ButtonClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout$mButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenFavoriteButtonClickListener
            public void onButtonClick(int type) {
                SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = null;
                if (type == 1) {
                    Log.i("SpenSettingFavoritePenMiniLayout", "onButtonClick() - BUTTON_TYPE_CLOSE");
                    View.OnClickListener onClickListener = this.this$0.mChangeViewModeButtonListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(null);
                        return;
                    }
                    return;
                }
                if (type != 10) {
                    if (type == 3) {
                        Log.i("SpenSettingFavoritePenMiniLayout", "onButtonClick() - BUTTON_TYPE_DELETE");
                        this.this$0.setMode(2, true, true);
                    } else if (type == 4) {
                        Log.i("SpenSettingFavoritePenMiniLayout", "onButtonClick() - BUTTON_TYPE_EDIT_DONE");
                        this.this$0.setEditDone();
                    } else if (type == 5) {
                        Log.i("SpenSettingFavoritePenMiniLayout", "onButtonClick() - BUTTON_TYPE_EDIT_CANCEL");
                        this.this$0.setMode(1, true, true);
                    }
                    this.this$0.notifyButtonClick(type);
                    return;
                }
                Log.i("SpenSettingFavoritePenMiniLayout", "onButtonClick() - BUTTON_TYPE_MORE");
                if (!this.this$0.mDisallowMorePopup) {
                    SpenMiniFavoriteControl spenMiniFavoriteControl = this.this$0.mFavoriteControl;
                    if (spenMiniFavoriteControl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
                        spenMiniFavoriteControl = null;
                    }
                    int favoriteCount = spenMiniFavoriteControl.getFavoriteCount();
                    SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = this.this$0.mLayoutControl;
                    if (spenFavoritePenMiniLayoutControl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                        spenFavoritePenMiniLayoutControl2 = null;
                    }
                    boolean z = favoriteCount != 0;
                    SpenMiniFavoriteControl spenMiniFavoriteControl2 = this.this$0.mFavoriteControl;
                    if (spenMiniFavoriteControl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
                        spenMiniFavoriteControl2 = null;
                    }
                    spenFavoritePenMiniLayoutControl2.showPopupMenu(z, favoriteCount < spenMiniFavoriteControl2.getMMaxCount());
                }
                View.OnClickListener onClickListener2 = this.this$0.mMoreButtonClickListener;
                if (onClickListener2 != null) {
                    SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl3 = this.this$0.mLayoutControl;
                    if (spenFavoritePenMiniLayoutControl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                    } else {
                        spenFavoritePenMiniLayoutControl = spenFavoritePenMiniLayoutControl3;
                    }
                    onClickListener2.onClick(spenFavoritePenMiniLayoutControl.getMoreButton());
                }
            }
        };
        AbstractC0000a.m26w(AbstractC0622a.m1173s(i, i2, "mode=", " maxCount=", " orientation="), TAG, i4);
        this.mDisallowMorePopup = false;
        construct(context, i, i2, i4);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        AbstractC2322a.m1631u(i, "setMode() mode=", TAG);
        setMode(i, false, false);
    }

    @Deprecated(message = "use setSelectedItem(index: Int, needAnimation: Boolean) instead")
    public final void setSelectedItem(int i) {
        AbstractC2322a.m1631u(i, "setSelectedItem() index=", TAG);
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.setSelectedItem(i, isShown(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMode(int mode, boolean needAnimation, boolean notify) {
        SpenFavoriteModeChangedListener spenFavoriteModeChangedListener;
        SpenMiniFavoriteControl spenMiniFavoriteControl = this.mFavoriteControl;
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl = null;
        if (spenMiniFavoriteControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteControl");
            spenMiniFavoriteControl = null;
        }
        spenMiniFavoriteControl.setMode(mode, needAnimation);
        SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl2 = this.mLayoutControl;
        if (spenFavoritePenMiniLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenMiniLayoutControl = spenFavoritePenMiniLayoutControl2;
        }
        spenFavoritePenMiniLayoutControl.setViewMode(mode, needAnimation);
        if (!notify || (spenFavoriteModeChangedListener = this.mModeChangedListener) == null) {
            return;
        }
        spenFavoriteModeChangedListener.onModeChanged(mode);
    }
}
