package com.samsung.android.sdk.pen.setting;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0017\u0018\u0000 X2\u00020\u0001:\u0007XYZ[\\]^B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\fJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010+\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0010J\u0010\u0010,\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0010\u0010-\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0014J\u0010\u0010.\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0016J\u0016\u0010/\u001a\u00020&2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101J\u0010\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u000102J\u0018\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u000102J\u0010\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010=J\u000e\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020\u0005J\u0010\u0010G\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010=J\u0010\u0010L\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J \u0010M\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J \u0010N\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010P\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u00109\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002J\u0018\u0010S\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\bH\u0002J\u000e\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020\bJ\u0010\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010@\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R\u0011\u0010C\u001a\u00020D8F¢\u0006\u0006\u001a\u0004\bE\u0010FR$\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:¨\u0006_"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "context", "Landroid/content/Context;", "mCurrentMode", "", "mMaxCount", "supportMoreMenu", "", "<init>", "(Landroid/content/Context;IIZ)V", "mode", "(Landroid/content/Context;IZ)V", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnButtonClickListener;", "mViewItemClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnViewItemClickListener;", "mEditItemClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnEditItemClickListener;", "mModeChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnModeChangeListener;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnFavoriteDataChangedListener;", "mTitleText", "Landroid/widget/TextView;", "mFavoriteLayout", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout;", "mPopupTitle", "Landroid/view/ViewGroup;", "mFavoriteOptionControl", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl;", "mIsLayoutAnimationCompleted", "mLayoutOrientation", "mOptionButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl$OnButtonClickListener;", "mOnFavoritePenAnimationListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnFavoritePenAnimationListener;", "close", "", "setVisibility", "visibility", "setOnButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnViewItemClickListener", "setOnEditItemClickListener", "setOnModeChangeListener", "setOnFavoriteDataChangedListener", "setFavoriteList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "addFavorite", "info", "updateFavorite", "index", "getMode", "()I", "setMode", "(I)V", "setPenSettingButton", "buttonClickListener", "Landroid/view/View$OnClickListener;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "selectedItem", "getSelectedItem", "setSelectedItem", "favoriteContainer", "Landroid/view/View;", "getFavoriteContainer", "()Landroid/view/View;", "setChangeUIModeButtonListener", "orientation", "layoutOrientation", "getLayoutOrientation", "setLayoutOrientation", "setContentHeight", "decideContentHeight", "initView", "maxCount", "initTitle", "updateIfNotChanged", "isNeedAnimation", "updateTitleButtons", "setLayoutAnimation", "hasAnimation", "hideOptionMenu", "needAnimation", "Companion", "OnButtonClickListener", "OnViewItemClickListener", "OnEditItemClickListener", "OnModeChangeListener", "OnFavoriteDataChangedListener", "ViewListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public class SpenSettingFavoritePenLayout extends SpenPopupLayout {
    private static final int ANIMATE_ALPHA_HIDE_TITLE_DURATION = 100;
    private static final int ANIMATE_ALPHA_SHOW_TITLE_DURATION = 200;
    public static final int EDIT_MODE = 2;
    private static final int MAX_PEN_COUNT = 45;

    @NotNull
    private static final String TAG = "SpenSettingFavoritePenLayout";
    public static final int VIEW_MODE = 1;

    @Nullable
    private OnButtonClickListener mButtonClickListener;
    private int mCurrentMode;

    @Nullable
    private OnFavoriteDataChangedListener mDataChangedListener;

    @Nullable
    private OnEditItemClickListener mEditItemClickListener;
    private SpenFavoritePenLayout mFavoriteLayout;
    private SpenFavoriteTitleOptionControl mFavoriteOptionControl;
    private boolean mIsLayoutAnimationCompleted;
    private int mLayoutOrientation;
    private final int mMaxCount;

    @Nullable
    private OnModeChangeListener mModeChangeListener;

    @NotNull
    private final SpenFavoritePenLayout.OnFavoritePenAnimationListener mOnFavoritePenAnimationListener;

    @NotNull
    private final SpenFavoriteTitleOptionControl.OnButtonClickListener mOptionButtonClickListener;
    private ViewGroup mPopupTitle;

    @Nullable
    private TextView mTitleText;

    @Nullable
    private OnViewItemClickListener mViewItemClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnButtonClickListener;", "", "onCloseButtonClick", "", "onAddButtonClick", "onDeleteButtonClick", "onEditDoneButtonClick", "onEditCancelButtonClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnButtonClickListener {
        void onAddButtonClick();

        void onCloseButtonClick();

        void onDeleteButtonClick();

        void onEditCancelButtonClick();

        void onEditDoneButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnEditItemClickListener;", "", "onEditItemClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnEditItemClickListener {
        void onEditItemClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnFavoriteDataChangedListener;", "", "onFavoriteDataChanged", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnFavoriteDataChangedListener {
        void onFavoriteDataChanged(@Nullable List<SpenSettingUIPenInfo> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnModeChangeListener;", "", "onModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeChangeListener {
        void onModeChanged(int mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$OnViewItemClickListener;", "", "onViewItemClick", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnViewItemClickListener {
        void onViewItemClick(@Nullable SpenSettingUIPenInfo info);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenLayout$ViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewListener extends SpenPopupLayout.ViewListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingFavoritePenLayout(@NotNull Context context, int i, int i2, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentMode = i;
        this.mMaxCount = i2;
        this.mIsLayoutAnimationCompleted = true;
        this.mOptionButtonClickListener = new SpenFavoriteTitleOptionControl.OnButtonClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout$mOptionButtonClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl.OnButtonClickListener
            public void onAddButtonClick() {
                SpenSettingFavoritePenLayout.OnButtonClickListener onButtonClickListener = this.this$0.mButtonClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onAddButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl.OnButtonClickListener
            public void onDeleteButtonClick() {
                if (this.this$0.mIsLayoutAnimationCompleted) {
                    this.this$0.setMode(2, true, true);
                    SpenSettingFavoritePenLayout.OnButtonClickListener onButtonClickListener = this.this$0.mButtonClickListener;
                    if (onButtonClickListener != null) {
                        onButtonClickListener.onDeleteButtonClick();
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl.OnButtonClickListener
            public void onMoreButtonClick() {
                SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = this.this$0.mFavoriteOptionControl;
                if (spenFavoriteTitleOptionControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteOptionControl");
                    spenFavoriteTitleOptionControl = null;
                }
                spenFavoriteTitleOptionControl.showOptionMenu();
            }
        };
        this.mOnFavoritePenAnimationListener = new SpenFavoritePenLayout.OnFavoritePenAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout$mOnFavoritePenAnimationListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl.OnFavoritePenLayoutAnimationListener
            public void onAnimationComplete(boolean isDone) {
                if (isDone) {
                    this.this$0.setContentHeight(1);
                    this.this$0.mIsLayoutAnimationCompleted = true;
                }
            }
        };
        this.mLayoutOrientation = 1;
        initView(context, i2, z);
        updateTitleButtons(this.mCurrentMode, false);
        setVisibility(8);
    }

    private final int decideContentHeight(Context context, int layoutOrientation, int mode) {
        if (layoutOrientation == 2) {
            Resources resources = context.getResources();
            return mode == 1 ? resources.getDimensionPixelSize(C7932R.dimen.setting_favorite_content_landscape_height) : resources.getDimensionPixelSize(C7932R.dimen.setting_favorite_content_edit_landscape_height);
        }
        Resources resources2 = context.getResources();
        return mode == 1 ? resources2.getDimensionPixelSize(C7932R.dimen.setting_favorite_content_height) : resources2.getDimensionPixelSize(C7932R.dimen.setting_favorite_content_edit_height);
    }

    private final void hideOptionMenu(boolean needAnimation) {
        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = this.mFavoriteOptionControl;
        if (spenFavoriteTitleOptionControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteOptionControl");
            spenFavoriteTitleOptionControl = null;
        }
        spenFavoriteTitleOptionControl.hideOptionMenu(needAnimation);
    }

    private final void initTitle(Context context, boolean supportMoreMenu) {
        setCloseButtonInfo(new ViewOnClickListenerC0157a(this, 20));
        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = new SpenFavoriteTitleOptionControl(context, this);
        this.mFavoriteOptionControl = spenFavoriteTitleOptionControl;
        spenFavoriteTitleOptionControl.initButton(supportMoreMenu, this.mOptionButtonClickListener);
        this.mTitleText = setTitleText(C7932R.string.pen_string_remove_pen_from_favorite);
        this.mPopupTitle = (ViewGroup) findViewById(C7932R.id.popup_title);
        TextView textView = this.mTitleText;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$0(SpenSettingFavoritePenLayout spenSettingFavoritePenLayout, View view) {
        OnButtonClickListener onButtonClickListener = spenSettingFavoritePenLayout.mButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onCloseButtonClick();
        }
    }

    private final void initView(Context context, int maxCount, boolean supportMoreMenu) {
        initTitle(context, supportMoreMenu);
        int iDecideContentHeight = decideContentHeight(context, this.mLayoutOrientation, this.mCurrentMode);
        SpenFavoritePenLayout spenFavoritePenLayout = null;
        this.mFavoriteLayout = new SpenFavoritePenLayout(context, this.mCurrentMode, maxCount, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iDecideContentHeight);
        SpenFavoritePenLayout spenFavoritePenLayout2 = this.mFavoriteLayout;
        if (spenFavoritePenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout2 = null;
        }
        setContentView(spenFavoritePenLayout2, layoutParams);
        setScrollBarThumbOffset(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_scrollbar_offset_top_normal), context.getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_scrollbar_offset_top_edit_mode));
        SpenFavoritePenLayout spenFavoritePenLayout3 = this.mFavoriteLayout;
        if (spenFavoritePenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout3 = null;
        }
        spenFavoritePenLayout3.setListRadius(context.getResources().getDimensionPixelOffset(C7932R.dimen.common_setting_layout_radius));
        SpenFavoritePenLayout spenFavoritePenLayout4 = this.mFavoriteLayout;
        if (spenFavoritePenLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout4 = null;
        }
        spenFavoritePenLayout4.setOnEventListener(new SpenFavoritePenLayout.OnEventListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.initView.1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout.OnEventListener
            public void onAddItemClick() {
                OnButtonClickListener onButtonClickListener = SpenSettingFavoritePenLayout.this.mButtonClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onAddButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout.OnEventListener
            public void onEditComplete(boolean isDone) {
                AbstractC4539a.m3208r("onEditComplete() isDone=", SpenSettingFavoritePenLayout.TAG, isDone);
                if (isDone) {
                    OnButtonClickListener onButtonClickListener = SpenSettingFavoritePenLayout.this.mButtonClickListener;
                    if (onButtonClickListener != null) {
                        onButtonClickListener.onEditDoneButtonClick();
                    }
                } else {
                    OnButtonClickListener onButtonClickListener2 = SpenSettingFavoritePenLayout.this.mButtonClickListener;
                    if (onButtonClickListener2 != null) {
                        onButtonClickListener2.onEditCancelButtonClick();
                    }
                }
                SpenSettingFavoritePenLayout.this.mIsLayoutAnimationCompleted = false;
                SpenSettingFavoritePenLayout.this.setMode(1, true, true);
            }
        });
        SpenFavoritePenLayout spenFavoritePenLayout5 = this.mFavoriteLayout;
        if (spenFavoritePenLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout5 = null;
        }
        spenFavoritePenLayout5.setOnViewItemClickListener(new SpenFavoriteViewItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.initView.2
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener
            public void onViewItemClick(SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                OnViewItemClickListener onViewItemClickListener = SpenSettingFavoritePenLayout.this.mViewItemClickListener;
                if (onViewItemClickListener != null) {
                    onViewItemClickListener.onViewItemClick(info);
                }
            }
        });
        SpenFavoritePenLayout spenFavoritePenLayout6 = this.mFavoriteLayout;
        if (spenFavoritePenLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout6 = null;
        }
        spenFavoritePenLayout6.setOnEditItemClickListener(new SpenFavoritePenLayout.OnEditItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.initView.3
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout.OnEditItemClickListener
            public void onEditItemClick() {
                OnEditItemClickListener onEditItemClickListener = SpenSettingFavoritePenLayout.this.mEditItemClickListener;
                if (onEditItemClickListener != null) {
                    onEditItemClickListener.onEditItemClick();
                }
            }
        });
        SpenFavoritePenLayout spenFavoritePenLayout7 = this.mFavoriteLayout;
        if (spenFavoritePenLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout7 = null;
        }
        spenFavoritePenLayout7.setFavoriteDataChangedListener(new SpenFavoriteDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.initView.4
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                Log.i(SpenSettingFavoritePenLayout.TAG, "onFavoriteDataChanged() size=" + (list != null ? Integer.valueOf(list.size()) : null));
                OnFavoriteDataChangedListener onFavoriteDataChangedListener = SpenSettingFavoritePenLayout.this.mDataChangedListener;
                if (onFavoriteDataChangedListener != null) {
                    onFavoriteDataChangedListener.onFavoriteDataChanged(list);
                }
                SpenSettingFavoritePenLayout spenSettingFavoritePenLayout = SpenSettingFavoritePenLayout.this;
                spenSettingFavoritePenLayout.setMode(spenSettingFavoritePenLayout.mCurrentMode, false, false);
            }
        });
        SpenFavoritePenLayout spenFavoritePenLayout8 = this.mFavoriteLayout;
        if (spenFavoritePenLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
        } else {
            spenFavoritePenLayout = spenFavoritePenLayout8;
        }
        spenFavoritePenLayout.setOnFavoritePenAnimationListener(this.mOnFavoritePenAnimationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentHeight(int mode) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iDecideContentHeight = decideContentHeight(context, this.mLayoutOrientation, mode);
        changeContentRule(mode == 1);
        setContentVerticalScrollBarEnable(mode == 2);
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        SpenFavoritePenLayout spenFavoritePenLayout2 = null;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = spenFavoritePenLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = iDecideContentHeight;
        SpenFavoritePenLayout spenFavoritePenLayout3 = this.mFavoriteLayout;
        if (spenFavoritePenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
        } else {
            spenFavoritePenLayout2 = spenFavoritePenLayout3;
        }
        spenFavoritePenLayout2.setLayoutParams(layoutParams2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateTitleButtons(int mode, boolean isNeedAnimation) {
        boolean z;
        boolean z2;
        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = null;
        boolean z3 = false;
        boolean z4 = true;
        if (mode == 1) {
            SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
            if (spenFavoritePenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
                spenFavoritePenLayout = null;
            }
            int favoriteCount = spenFavoritePenLayout.getFavoriteCount();
            if (favoriteCount == 0) {
                z2 = false;
                z = true;
            } else {
                if (1 <= favoriteCount && favoriteCount < this.mMaxCount) {
                    z2 = true;
                } else if (favoriteCount >= this.mMaxCount) {
                    z = false;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            }
            if (isNeedAnimation) {
                ViewGroup viewGroup = this.mPopupTitle;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                    viewGroup = null;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
                objectAnimatorOfFloat.setDuration(200L);
                objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.updateTitleButtons.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        ViewGroup viewGroup2 = SpenSettingFavoritePenLayout.this.mPopupTitle;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                            viewGroup2 = null;
                        }
                        viewGroup2.clearAnimation();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        SpenSettingFavoritePenLayout.this.scrollContentToPosition(0, 0);
                        ViewGroup viewGroup2 = SpenSettingFavoritePenLayout.this.mPopupTitle;
                        if (viewGroup2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                            viewGroup2 = null;
                        }
                        viewGroup2.setVisibility(0);
                    }
                });
                objectAnimatorOfFloat.start();
            } else {
                setContentHeight(1);
                ViewGroup viewGroup2 = this.mPopupTitle;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                    viewGroup2 = null;
                }
                viewGroup2.setAlpha(1.0f);
                ViewGroup viewGroup3 = this.mPopupTitle;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(0);
            }
            z3 = z2;
        } else {
            SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl2 = this.mFavoriteOptionControl;
            if (spenFavoriteTitleOptionControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteOptionControl");
                spenFavoriteTitleOptionControl2 = null;
            }
            if (spenFavoriteTitleOptionControl2.isSupportMoreMenuButton()) {
                z4 = false;
                setContentHeight(this.mCurrentMode);
                if (isNeedAnimation) {
                    ViewGroup viewGroup4 = this.mPopupTitle;
                    if (viewGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                        viewGroup4 = null;
                    }
                    viewGroup4.setVisibility(8);
                } else {
                    ViewGroup viewGroup5 = this.mPopupTitle;
                    if (viewGroup5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                        viewGroup5 = null;
                    }
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewGroup5, "alpha", 1.0f, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
                    objectAnimatorOfFloat2.setDuration(100L);
                    objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout.updateTitleButtons.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            ViewGroup viewGroup6 = SpenSettingFavoritePenLayout.this.mPopupTitle;
                            ViewGroup viewGroup7 = null;
                            if (viewGroup6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                                viewGroup6 = null;
                            }
                            viewGroup6.setVisibility(8);
                            ViewGroup viewGroup8 = SpenSettingFavoritePenLayout.this.mPopupTitle;
                            if (viewGroup8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPopupTitle");
                            } else {
                                viewGroup7 = viewGroup8;
                            }
                            viewGroup7.clearAnimation();
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }
                    });
                    objectAnimatorOfFloat2.start();
                }
                z = z4;
            } else {
                SpenFavoritePenLayout spenFavoritePenLayout2 = this.mFavoriteLayout;
                if (spenFavoritePenLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
                    spenFavoritePenLayout2 = null;
                }
                if (spenFavoritePenLayout2.getFavoriteCount() >= this.mMaxCount) {
                }
                setContentHeight(this.mCurrentMode);
                if (isNeedAnimation) {
                }
                z = z4;
            }
        }
        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl3 = this.mFavoriteOptionControl;
        if (spenFavoriteTitleOptionControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteOptionControl");
        } else {
            spenFavoriteTitleOptionControl = spenFavoriteTitleOptionControl3;
        }
        spenFavoriteTitleOptionControl.setMenuEnable(z3, z);
    }

    public final boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        AbstractC2322a.m1631u(this.mCurrentMode, "addFavorite() mode= ", TAG);
        if (this.mCurrentMode == 1) {
            SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
            if (spenFavoritePenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
                spenFavoritePenLayout = null;
            }
            if (spenFavoritePenLayout.addFavorite(info)) {
                setMode(this.mCurrentMode, true, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = this.mFavoriteOptionControl;
        if (spenFavoriteTitleOptionControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteOptionControl");
            spenFavoriteTitleOptionControl = null;
        }
        spenFavoriteTitleOptionControl.close();
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.close();
        this.mButtonClickListener = null;
        this.mViewItemClickListener = null;
        this.mEditItemClickListener = null;
        this.mModeChangeListener = null;
        this.mDataChangedListener = null;
        super.close();
    }

    @NotNull
    public final View getFavoriteContainer() {
        Log.i(TAG, "getFavoriteContainer()");
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        return spenFavoritePenLayout.getFavoriteContainer();
    }

    /* JADX INFO: renamed from: getLayoutOrientation, reason: from getter */
    public final int getMLayoutOrientation() {
        return this.mLayoutOrientation;
    }

    public final int getMode() {
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        return spenFavoritePenLayout.getMMode();
    }

    public final int getSelectedItem() {
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        return spenFavoritePenLayout.getSelectedItem();
    }

    public final void setChangeUIModeButtonListener(@Nullable View.OnClickListener listener) {
        if (listener != null) {
            addButtonNextToCloseInTitle(C7932R.drawable.setting_btn_minimized, C7932R.string.pen_string_shrink_favorite_pens, listener);
        }
    }

    public final void setColorTheme(int theme) {
        AbstractC2322a.m1631u(theme, "setColorTheme() theme=", TAG);
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.setColorTheme(theme);
    }

    public final void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        String strValueOf = list != null ? Integer.valueOf(list.size()) : "NULL";
        Log.i(TAG, "setFavoriteList() list=" + strValueOf + " mode=" + this.mCurrentMode);
        if (this.mCurrentMode == 1) {
            SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
            if (spenFavoritePenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
                spenFavoritePenLayout = null;
            }
            spenFavoritePenLayout.setFavoriteList(list);
            setMode(this.mCurrentMode, true, false);
        }
    }

    public final void setLayoutAnimation(boolean hasAnimation) {
        setAnimation(hasAnimation);
    }

    public final void setLayoutOrientation(int i) {
        AbstractC2322a.m1631u(i, "setLayoutOrientation() orientation=", TAG);
        if (this.mLayoutOrientation != i) {
            this.mLayoutOrientation = i;
            setOrientation(i);
            setContentHeight(this.mCurrentMode);
            SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
            if (spenFavoritePenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
                spenFavoritePenLayout = null;
            }
            spenFavoritePenLayout.setLayoutOrientation(i);
        }
    }

    public final void setMode(int i) {
        OnModeChangeListener onModeChangeListener;
        AbstractC11014a.m12338w(AbstractC0622a.m1173s(i, this.mCurrentMode, "setMode() mode=", " current=", " mModeChangeListener is "), this.mModeChangeListener == null ? "NULL" : "NOT NULL", TAG);
        hideOptionMenu(false);
        if (!setMode(i, false, false) || (onModeChangeListener = this.mModeChangeListener) == null) {
            return;
        }
        onModeChangeListener.onModeChanged(this.mCurrentMode);
    }

    public final void setOnButtonClickListener(@Nullable OnButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    public final void setOnEditItemClickListener(@Nullable OnEditItemClickListener listener) {
        this.mEditItemClickListener = listener;
    }

    public final void setOnFavoriteDataChangedListener(@Nullable OnFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setOnModeChangeListener(@Nullable OnModeChangeListener listener) {
        this.mModeChangeListener = listener;
    }

    public final void setOnViewItemClickListener(@Nullable OnViewItemClickListener listener) {
        this.mViewItemClickListener = listener;
    }

    public final boolean setPenSettingButton(@Nullable View.OnClickListener buttonClickListener) {
        ImageView imageView = (ImageView) addHeaderButtonInTitle(C7932R.drawable.favorite_off_line, buttonClickListener, C7932R.string.pen_string_change_to_mode, getContext().getString(C7932R.string.pen_string_pen));
        if (imageView == null) {
            return false;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int i = !SpenSettingUtilAccessibility.isHighContrast(context) ? C7932R.drawable.favorite_icon_background_drawable : C7932R.drawable.favorite_icon_background_drawable_high_contrast;
        ViewParent parent = imageView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return true;
        }
        viewGroup.setBackgroundResource(i);
        return true;
    }

    public final void setSelectedItem(int i) {
        AbstractC2322a.m1631u(i, "setSelectedItem() index=", TAG);
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.setSelectedItem(i, true);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout, android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 4 || visibility == 8) {
            hideOptionMenu(false);
        }
    }

    public final boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info) {
        AbstractC2322a.m1631u(this.mCurrentMode, "updateFavorite() mode= ", TAG);
        if (this.mCurrentMode != 1) {
            return false;
        }
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        return spenFavoritePenLayout.updateFavorite(index, info);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "")
    public SpenSettingFavoritePenLayout(@NotNull Context context, int i, boolean z) {
        this(context, i, 45, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setMode(int mode, boolean updateIfNotChanged, boolean isNeedAnimation) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(mode, this.mCurrentMode, "setMode() mode=", " current=", " updateIfNotChanged=");
        sbM1173s.append(updateIfNotChanged);
        sbM1173s.append(" isNeedAnimation= ");
        sbM1173s.append(isNeedAnimation);
        Log.i(TAG, sbM1173s.toString());
        boolean z = mode != this.mCurrentMode;
        if (!z && !updateIfNotChanged) {
            return z;
        }
        this.mCurrentMode = mode;
        updateTitleButtons(mode, isNeedAnimation);
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoriteLayout;
        SpenFavoritePenLayout spenFavoritePenLayout2 = null;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.setShowAnimation(isNeedAnimation);
        SpenFavoritePenLayout spenFavoritePenLayout3 = this.mFavoriteLayout;
        if (spenFavoritePenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteLayout");
        } else {
            spenFavoritePenLayout2 = spenFavoritePenLayout3;
        }
        spenFavoritePenLayout2.setMode(this.mCurrentMode);
        return z;
    }
}
