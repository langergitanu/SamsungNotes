package com.samsung.android.sdk.pen.setting;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenMiniCloseButton;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilInOutAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 T2\u00020\u0001:\u0003TUVB#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fJ\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020(J\u001e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020(J\u000e\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020(J\u0012\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010>\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010?\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020\"H\u0002J\b\u0010C\u001a\u00020\"H\u0002J\b\u0010D\u001a\u00020\"H\u0002J\b\u0010E\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\u0010\u0010J\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0018\u0010M\u001a\u00020\"2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000eH\u0002J\u0018\u0010Q\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00192\u0006\u0010R\u001a\u00020OH\u0002J\u0010\u0010S\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b3\u00104R$\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010G\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "mContext", "Landroid/content/Context;", "mParent", "Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;", "orientation", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;I)V", "mViewMode", "mFavoriteViewInterface", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteMiniViewInterface;", "mHeaderButton", "Landroid/widget/ImageView;", "mCloseButton", "Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton;", "mMoreButton", "mDoneButton", "Landroid/widget/RelativeLayout;", "mChangeModeAnimator", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilInOutAnimation;", "mLayoutTransition", "Landroid/transition/AutoTransition;", "mExcludeTransitionView", "Landroid/view/View;", "mButtonEnableColor", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonClickListener;", "mHeaderButtonClickListener", "Landroid/view/View$OnClickListener;", "mViewModeAniListener", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilInOutAnimation$AnimationEndListener;", "close", "", "setContent", "favoriteViewInterface", "setViewMode", "viewMode", "needAnimation", "", "setButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showPopupMenu", "isSupportDelete", "isSupportAdd", "setMenuEnable", "deleteEnabled", "addEnabled", "applyNow", "moreButton", "getMoreButton", "()Landroid/view/View;", "playCloseAnimation", "isClose", "value", "getOrientation", "()I", "setOrientation", "(I)V", "setExcludeTransitionChildView", "view", "changeOrientation", "detachView", "setHeaderVisible", "visible", "init", "initParent", "initTransition", "addFooter", "addHeader", "mViewModeOverlapMargin", "mEditModeOverlapMargin", "mEditModeOverlapMarginLand", "setViewModeWithoutAnimation", "setViewModeWithAnimation", "updateFooterOverlapMargin", "setButton", "type", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonType;", MarketingConstants.BUTTON, "isSameButton", "buttonType", "notifyButtonClicked", "Companion", "ButtonType", "ButtonClickListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoritePenMiniLayoutControl extends SpenLayoutConfigHelper {
    private static final int BUTTON_ANIMATION_DURATION = 150;

    @NotNull
    private static final String BUTTON_TAG_DELETE = "Delete";

    @NotNull
    private static final String BUTTON_TAG_MORE = "More";
    private static final int LAYOUT_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenFavoritePenMiniLayoutControl";

    @Nullable
    private ButtonClickListener mButtonClickListener;
    private int mButtonEnableColor;
    private SpenSettingUtilInOutAnimation mChangeModeAnimator;
    private SpenMiniCloseButton mCloseButton;

    @NotNull
    private Context mContext;
    private RelativeLayout mDoneButton;
    private int mEditModeOverlapMargin;
    private int mEditModeOverlapMarginLand;

    @Nullable
    private View mExcludeTransitionView;

    @Nullable
    private SpenFavoriteMiniViewInterface mFavoriteViewInterface;
    private ImageView mHeaderButton;

    @NotNull
    private final View.OnClickListener mHeaderButtonClickListener;
    private AutoTransition mLayoutTransition;
    private ImageView mMoreButton;

    @NotNull
    private SpenPopupMiniLayout mParent;
    private int mViewMode;

    @NotNull
    private final SpenSettingUtilInOutAnimation.AnimationEndListener mViewModeAniListener;
    private int mViewModeOverlapMargin;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonClickListener;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteButtonClickListener;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ButtonClickListener extends SpenFavoriteButtonClickListener {
        public static final int BUTTON_TYPE_MORE = 10;
        public static final int BUTTON_TYPE_PEN_SETTING = 11;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonClickListener$Companion;", "", "<init>", "()V", "BUTTON_TYPE_MORE", "", "BUTTON_TYPE_PEN_SETTING", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BUTTON_TYPE_MORE = 10;
            public static final int BUTTON_TYPE_PEN_SETTING = 11;

            private Companion() {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniLayoutControl$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "MORE", "DELETE", CoeditGrpcMethod.Caller.CLOSE, "EDIT_CANCEL", "EDIT_DONE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType MORE = new ButtonType("MORE", 0);
        public static final ButtonType DELETE = new ButtonType("DELETE", 1);
        public static final ButtonType CLOSE = new ButtonType(CoeditGrpcMethod.Caller.CLOSE, 2);
        public static final ButtonType EDIT_CANCEL = new ButtonType("EDIT_CANCEL", 3);
        public static final ButtonType EDIT_DONE = new ButtonType("EDIT_DONE", 4);

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{MORE, DELETE, CLOSE, EDIT_CANCEL, EDIT_DONE};
        }

        static {
            ButtonType[] buttonTypeArr$values = $values();
            $VALUES = buttonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonTypeArr$values);
        }

        private ButtonType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ButtonType> getEntries() {
            return $ENTRIES;
        }

        public static ButtonType valueOf(String str) {
            return (ButtonType) Enum.valueOf(ButtonType.class, str);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonType.values().length];
            try {
                iArr[ButtonType.EDIT_CANCEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonType.MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonType.CLOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenFavoritePenMiniLayoutControl(@NotNull Context mContext, @NotNull SpenPopupMiniLayout mParent) {
        this(mContext, mParent, 0, 4, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mParent, "mParent");
    }

    private final void addFooter() {
        FrameLayout frameLayoutCreateFooterGroup = SpenMiniFavoriteSettingLayoutFactory.createFooterGroup(this.mContext, getMOrientation());
        this.mParent.addFooterView(frameLayoutCreateFooterGroup, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = (ImageView) frameLayoutCreateFooterGroup.findViewById(C7932R.id.mini_favorite_button_more);
        this.mMoreButton = imageView;
        ButtonType buttonType = ButtonType.MORE;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
            imageView = null;
        }
        setButton(buttonType, imageView);
        ImageView imageView2 = this.mMoreButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new ViewOnClickListenerC7521b(this, 0));
        SpenMiniCloseButton spenMiniCloseButton = (SpenMiniCloseButton) frameLayoutCreateFooterGroup.findViewById(C7932R.id.mini_favorite_button_close);
        this.mCloseButton = spenMiniCloseButton;
        if (spenMiniCloseButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            spenMiniCloseButton = null;
        }
        spenMiniCloseButton.setButtonType(SpenMiniCloseButton.Type.BACK, false);
        ButtonType buttonType2 = ButtonType.CLOSE;
        SpenMiniCloseButton spenMiniCloseButton2 = this.mCloseButton;
        if (spenMiniCloseButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            spenMiniCloseButton2 = null;
        }
        setButton(buttonType2, spenMiniCloseButton2);
        SpenMiniCloseButton spenMiniCloseButton3 = this.mCloseButton;
        if (spenMiniCloseButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            spenMiniCloseButton3 = null;
        }
        spenMiniCloseButton3.setOnClickListener(new ViewOnClickListenerC7521b(this, 1));
        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayoutCreateFooterGroup.findViewById(C7932R.id.mini_favorite_button_done);
        this.mDoneButton = relativeLayout2;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            relativeLayout2 = null;
        }
        SpenShowButtonShapeText spenShowButtonShapeText = (SpenShowButtonShapeText) relativeLayout2.findViewById(C7932R.id.mini_favorite_button_done_text);
        SpenSettingUtilText.setTypeFace(this.mContext, SpenSettingUtilText.FontName.MEDIUM, spenShowButtonShapeText);
        SpenSettingUtilText.applyUpToLargeLevel(this.mContext, 14.0f, spenShowButtonShapeText);
        spenShowButtonShapeText.setButtonShapeEnabled(true);
        RelativeLayout relativeLayout3 = this.mDoneButton;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
        } else {
            relativeLayout = relativeLayout3;
        }
        relativeLayout.setOnClickListener(new ViewOnClickListenerC7521b(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addFooter$lambda$3(SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl, View view) {
        Intrinsics.checkNotNull(view);
        if (spenFavoritePenMiniLayoutControl.isSameButton(view, ButtonType.MORE)) {
            spenFavoritePenMiniLayoutControl.notifyButtonClicked(10);
        } else {
            spenFavoritePenMiniLayoutControl.notifyButtonClicked(3);
        }
    }

    private final void addHeader() {
        ImageView imageView = new ImageView(this.mContext);
        this.mHeaderButton = imageView;
        imageView.setOnClickListener(this.mHeaderButtonClickListener);
        SpenPopupMiniLayout spenPopupMiniLayout = this.mParent;
        ImageView imageView2 = this.mHeaderButton;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
            imageView2 = null;
        }
        spenPopupMiniLayout.addDefaultHeaderView(imageView2);
        ButtonType buttonType = ButtonType.EDIT_CANCEL;
        ImageView imageView4 = this.mHeaderButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
        } else {
            imageView3 = imageView4;
        }
        setButton(buttonType, imageView3);
        setHeaderVisible(false);
    }

    private final void changeOrientation(int orientation) {
        AbstractC11014a.m12328m(orientation, "changeOrientation(", ")", TAG);
        SpenFavoriteMiniViewInterface spenFavoriteMiniViewInterface = this.mFavoriteViewInterface;
        if (spenFavoriteMiniViewInterface != null) {
            spenFavoriteMiniViewInterface.saveViewState();
            detachView(spenFavoriteMiniViewInterface.getView(this.mContext));
            spenFavoriteMiniViewInterface.clearView();
            spenFavoriteMiniViewInterface.setViewOrientation(orientation);
            initParent();
            setContent(spenFavoriteMiniViewInterface);
            spenFavoriteMiniViewInterface.restoreViewState();
            setViewModeWithoutAnimation(this.mViewMode);
        }
    }

    private final void detachView(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    private final void init() {
        Resources resources = this.mContext.getResources();
        this.mViewModeOverlapMargin = resources.getDimensionPixelOffset(C7932R.dimen.mini_favorite_setting_view_mode_overlap_margin);
        this.mEditModeOverlapMargin = resources.getDimensionPixelOffset(C7932R.dimen.mini_favorite_setting_edit_mode_overlap_margin);
        this.mEditModeOverlapMarginLand = resources.getDimensionPixelOffset(C7932R.dimen.mini_favorite_setting_edit_mode_overlap_margin_land);
        this.mButtonEnableColor = SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_handwriting_icon_enable_color);
        initParent();
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation = new SpenSettingUtilInOutAnimation();
        this.mChangeModeAnimator = spenSettingUtilInOutAnimation;
        spenSettingUtilInOutAnimation.setAlphaValue(150L, 15);
        setViewModeWithoutAnimation(this.mViewMode);
    }

    private final void initParent() {
        this.mParent.setLayoutInterface(SpenMiniFavoriteSettingLayoutFactory.createPopupLayoutHelper(getMOrientation()));
        addHeader();
        addFooter();
        initTransition();
    }

    private final void initTransition() {
        AutoTransition autoTransition = new AutoTransition();
        this.mLayoutTransition = autoTransition;
        autoTransition.setDuration(400L);
        AutoTransition autoTransition2 = this.mLayoutTransition;
        if (autoTransition2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutTransition");
            autoTransition2 = null;
        }
        autoTransition2.setInterpolator((TimeInterpolator) SpenSettingUtilAnimation.getInterpolator(11));
    }

    private final boolean isSameButton(View button, ButtonType buttonType) {
        if (button.getTag() == null) {
            return false;
        }
        String string = button.getTag().toString();
        if (buttonType == ButtonType.MORE && string.compareTo(BUTTON_TAG_MORE) == 0) {
            return true;
        }
        return buttonType == ButtonType.DELETE && string.compareTo(BUTTON_TAG_DELETE) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonClicked(int type) {
        AbstractC2322a.m1631u(type, "notifyButtonClicked() type=", TAG);
        ButtonClickListener buttonClickListener = this.mButtonClickListener;
        if (buttonClickListener != null) {
            buttonClickListener.onButtonClick(type);
        }
    }

    private final void setButton(ButtonType type, ImageView button) {
        int i;
        String string;
        String string2;
        String str;
        Resources resources = this.mContext.getResources();
        int i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        String str2 = null;
        if (i2 != 1) {
            if (i2 == 2) {
                i = C7932R.drawable.ic_mini_more;
                string2 = resources.getString(C7932R.string.pen_string_favorite_more_options);
                str = BUTTON_TAG_MORE;
            } else if (i2 == 3) {
                i = C7932R.drawable.note_setting_ic_delete;
                string2 = resources.getString(C7932R.string.pen_string_delete_preset);
                str = BUTTON_TAG_DELETE;
            } else if (i2 != 4) {
                i = -1;
                string = null;
            } else {
                string = resources.getString(C7932R.string.pen_string_collapse);
                i = -1;
            }
            String str3 = string2;
            str2 = str;
            string = str3;
        } else {
            i = C7932R.drawable.setting_favorite_cancel_button;
            string = resources.getString(C7932R.string.pen_string_cancel);
        }
        if (i != -1) {
            button.setImageResource(i);
        }
        if (str2 != null) {
            button.setTag(str2);
        }
        button.setBackgroundResource(C7932R.drawable.spen_ripple_effect_drawable);
        button.setColorFilter(this.mButtonEnableColor);
        button.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(button, string);
    }

    private final void setExcludeTransitionChildView(View view) {
        this.mExcludeTransitionView = view;
    }

    private final void setHeaderVisible(boolean visible) {
        this.mParent.setHeaderGroupVisibility(visible ? 0 : 8);
    }

    private final void setViewModeWithAnimation(int viewMode) {
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation = this.mChangeModeAnimator;
        AutoTransition autoTransition = null;
        if (spenSettingUtilInOutAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
            spenSettingUtilInOutAnimation = null;
        }
        spenSettingUtilInOutAnimation.close();
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation2 = this.mChangeModeAnimator;
        if (spenSettingUtilInOutAnimation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
            spenSettingUtilInOutAnimation2 = null;
        }
        spenSettingUtilInOutAnimation2.setAnimationEndListener(this.mViewModeAniListener);
        if (viewMode == 1) {
            setHeaderVisible(false);
            ImageView imageView = this.mMoreButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                imageView = null;
            }
            imageView.setVisibility(4);
            SpenMiniCloseButton spenMiniCloseButton = this.mCloseButton;
            if (spenMiniCloseButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                spenMiniCloseButton = null;
            }
            spenMiniCloseButton.setVisibility(4);
            View headerDivider = this.mParent.getMHeaderDivider();
            if (headerDivider != null) {
                headerDivider.setVisibility(0);
            }
            ImageView imageView2 = this.mHeaderButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation3 = this.mChangeModeAnimator;
            if (spenSettingUtilInOutAnimation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                spenSettingUtilInOutAnimation3 = null;
            }
            RelativeLayout relativeLayout = this.mDoneButton;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
                relativeLayout = null;
            }
            spenSettingUtilInOutAnimation3.registerViewForAni(relativeLayout);
        } else {
            setHeaderVisible(true);
            ImageView imageView3 = this.mHeaderButton;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
                imageView3 = null;
            }
            imageView3.setVisibility(4);
            RelativeLayout relativeLayout2 = this.mDoneButton;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(4);
            View headerDivider2 = this.mParent.getMHeaderDivider();
            if (headerDivider2 != null) {
                headerDivider2.setVisibility(4);
            }
            ImageView imageView4 = this.mMoreButton;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
            SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation4 = this.mChangeModeAnimator;
            if (spenSettingUtilInOutAnimation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                spenSettingUtilInOutAnimation4 = null;
            }
            SpenMiniCloseButton spenMiniCloseButton2 = this.mCloseButton;
            if (spenMiniCloseButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                spenMiniCloseButton2 = null;
            }
            spenSettingUtilInOutAnimation4.registerViewForAni(spenMiniCloseButton2);
        }
        updateFooterOverlapMargin(viewMode);
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation5 = this.mChangeModeAnimator;
        if (spenSettingUtilInOutAnimation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
            spenSettingUtilInOutAnimation5 = null;
        }
        spenSettingUtilInOutAnimation5.setObjectVisibility(0);
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation6 = this.mChangeModeAnimator;
        if (spenSettingUtilInOutAnimation6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
            spenSettingUtilInOutAnimation6 = null;
        }
        spenSettingUtilInOutAnimation6.hideAnimation();
        AutoTransition autoTransition2 = this.mLayoutTransition;
        if (autoTransition2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutTransition");
            autoTransition2 = null;
        }
        autoTransition2.excludeChildren(this.mExcludeTransitionView, true);
        SpenPopupMiniLayout spenPopupMiniLayout = this.mParent;
        AutoTransition autoTransition3 = this.mLayoutTransition;
        if (autoTransition3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutTransition");
        } else {
            autoTransition = autoTransition3;
        }
        TransitionManager.beginDelayedTransition(spenPopupMiniLayout, autoTransition);
    }

    private final void setViewModeWithoutAnimation(int viewMode) {
        RelativeLayout relativeLayout = null;
        if (viewMode == 1) {
            setHeaderVisible(false);
            ImageView imageView = this.mMoreButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                imageView = null;
            }
            imageView.setVisibility(0);
            SpenMiniCloseButton spenMiniCloseButton = this.mCloseButton;
            if (spenMiniCloseButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                spenMiniCloseButton = null;
            }
            spenMiniCloseButton.setVisibility(0);
            RelativeLayout relativeLayout2 = this.mDoneButton;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(8);
        } else {
            setHeaderVisible(true);
            ImageView imageView2 = this.mMoreButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            SpenMiniCloseButton spenMiniCloseButton2 = this.mCloseButton;
            if (spenMiniCloseButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                spenMiniCloseButton2 = null;
            }
            spenMiniCloseButton2.setVisibility(8);
            RelativeLayout relativeLayout3 = this.mDoneButton;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setVisibility(0);
        }
        updateFooterOverlapMargin(viewMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopupMenu$lambda$1(SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl, MenuItem menuItem) {
        if (menuItem.getItemId() == C7932R.id.menu_favorite_add) {
            Log.i(TAG, "MenuItemClick ADD_FAVORITE");
            spenFavoritePenMiniLayoutControl.notifyButtonClicked(2);
            return true;
        }
        if (menuItem.getItemId() != C7932R.id.menu_favorite_remove) {
            return false;
        }
        Log.i(TAG, "MenuItemClick EDIT_FAVORITE");
        spenFavoritePenMiniLayoutControl.notifyButtonClicked(3);
        return true;
    }

    private final void updateFooterOverlapMargin(int viewMode) {
        int i = this.mViewModeOverlapMargin;
        if (viewMode == 2) {
            i = isVertical() ? this.mEditModeOverlapMargin : this.mEditModeOverlapMarginLand;
        }
        this.mParent.setFooterOverlapMargin(i);
    }

    public final void close() {
        SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation = this.mChangeModeAnimator;
        if (spenSettingUtilInOutAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
            spenSettingUtilInOutAnimation = null;
        }
        spenSettingUtilInOutAnimation.close();
        this.mFavoriteViewInterface = null;
        this.mButtonClickListener = null;
    }

    @NotNull
    public final View getMoreButton() {
        ImageView imageView = this.mMoreButton;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    /* JADX INFO: renamed from: getOrientation */
    public int getMOrientation() {
        return super.getMOrientation();
    }

    public final void playCloseAnimation(boolean isClose) {
        SpenMiniCloseButton.Type type = isClose ? SpenMiniCloseButton.Type.BACK : SpenMiniCloseButton.Type.CLOSE;
        SpenMiniCloseButton.Type type2 = isClose ? SpenMiniCloseButton.Type.CLOSE : SpenMiniCloseButton.Type.BACK;
        SpenMiniCloseButton spenMiniCloseButton = this.mCloseButton;
        SpenMiniCloseButton spenMiniCloseButton2 = null;
        if (spenMiniCloseButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
            spenMiniCloseButton = null;
        }
        if (spenMiniCloseButton.getMButtonType() != type) {
            SpenMiniCloseButton spenMiniCloseButton3 = this.mCloseButton;
            if (spenMiniCloseButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                spenMiniCloseButton3 = null;
            }
            spenMiniCloseButton3.setButtonType(type, false);
        }
        SpenMiniCloseButton spenMiniCloseButton4 = this.mCloseButton;
        if (spenMiniCloseButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
        } else {
            spenMiniCloseButton2 = spenMiniCloseButton4;
        }
        spenMiniCloseButton2.setButtonType(type2, true);
    }

    public final void setButtonClickListener(@Nullable ButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    public final void setContent(@NotNull SpenFavoriteMiniViewInterface favoriteViewInterface) {
        Intrinsics.checkNotNullParameter(favoriteViewInterface, "favoriteViewInterface");
        this.mFavoriteViewInterface = favoriteViewInterface;
        if (favoriteViewInterface != null) {
            favoriteViewInterface.setViewOrientation(getMOrientation());
        }
        this.mParent.setContentView(favoriteViewInterface.getView(this.mContext), SpenMiniFavoriteSettingLayoutFactory.createContentLayoutParams(getMOrientation()));
        setExcludeTransitionChildView(favoriteViewInterface.getContainerView());
    }

    public final void setMenuEnable(boolean deleteEnabled, boolean addEnabled, boolean applyNow) {
        AbstractC6670b.m4758s("setMenuEnable() delete=", " add=", TAG, deleteEnabled, addEnabled);
        ButtonType buttonType = ButtonType.MORE;
        ImageView imageView = this.mMoreButton;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
            imageView = null;
        }
        if (!isSameButton(imageView, buttonType)) {
            ImageView imageView3 = this.mMoreButton;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                imageView3 = null;
            }
            setButton(buttonType, imageView3);
        }
        ImageView imageView4 = this.mMoreButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
        if (applyNow) {
            updateFooterOverlapMargin(1);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    public void setOrientation(int i) {
        if (getMOrientation() == i) {
            return;
        }
        super.setOrientation(i);
        changeOrientation(i);
    }

    public final void setViewMode(int viewMode, boolean needAnimation) {
        if (this.mViewMode == viewMode) {
            return;
        }
        this.mViewMode = viewMode;
        if (needAnimation) {
            setViewModeWithAnimation(viewMode);
        } else {
            setViewModeWithoutAnimation(viewMode);
        }
    }

    public final void showPopupMenu(boolean isSupportDelete, boolean isSupportAdd) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.mContext, C7932R.style.SettingPopupMenuStyle);
        ImageView imageView = this.mMoreButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
            imageView = null;
        }
        PopupMenu popupMenu = new PopupMenu(contextThemeWrapper, imageView);
        new MenuInflater(this.mContext).inflate(C7932R.menu.favorite_menu, popupMenu.getMenu());
        popupMenu.getMenu().getItem(0).setVisible(isSupportAdd);
        popupMenu.getMenu().getItem(1).setVisible(isSupportDelete);
        popupMenu.setOnMenuItemClickListener(new C7522c(this, 0));
        popupMenu.show();
    }

    public /* synthetic */ SpenFavoritePenMiniLayoutControl(Context context, SpenPopupMiniLayout spenPopupMiniLayout, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, spenPopupMiniLayout, (i2 & 4) != 0 ? 1 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenFavoritePenMiniLayoutControl(@NotNull Context mContext, @NotNull SpenPopupMiniLayout mParent, int i) {
        super(mContext, i);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mParent, "mParent");
        this.mContext = mContext;
        this.mParent = mParent;
        this.mViewMode = 1;
        this.mHeaderButtonClickListener = new ViewOnClickListenerC7521b(this, 3);
        this.mViewModeAniListener = new SpenSettingUtilInOutAnimation.AnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.SpenFavoritePenMiniLayoutControl$mViewModeAniListener$1
            @Override // com.samsung.android.sdk.pen.setting.util.SpenSettingUtilInOutAnimation.AnimationEndListener
            public void onHideAnimationEnd() {
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation = this.this$0.mChangeModeAnimator;
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation2 = null;
                if (spenSettingUtilInOutAnimation == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                    spenSettingUtilInOutAnimation = null;
                }
                spenSettingUtilInOutAnimation.setObjectVisibility(8);
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation3 = this.this$0.mChangeModeAnimator;
                if (spenSettingUtilInOutAnimation3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                    spenSettingUtilInOutAnimation3 = null;
                }
                spenSettingUtilInOutAnimation3.close();
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation4 = this.this$0.mChangeModeAnimator;
                if (spenSettingUtilInOutAnimation4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                    spenSettingUtilInOutAnimation4 = null;
                }
                spenSettingUtilInOutAnimation4.setAnimationEndListener(null);
                if (this.this$0.mViewMode == 1) {
                    RelativeLayout relativeLayout = this.this$0.mDoneButton;
                    if (relativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
                        relativeLayout = null;
                    }
                    relativeLayout.setAlpha(1.0f);
                    SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation5 = this.this$0.mChangeModeAnimator;
                    if (spenSettingUtilInOutAnimation5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                        spenSettingUtilInOutAnimation5 = null;
                    }
                    ImageView imageView = this.this$0.mMoreButton;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMoreButton");
                        imageView = null;
                    }
                    SpenMiniCloseButton spenMiniCloseButton = this.this$0.mCloseButton;
                    if (spenMiniCloseButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                        spenMiniCloseButton = null;
                    }
                    spenSettingUtilInOutAnimation5.registerViewForAni(imageView, spenMiniCloseButton);
                } else {
                    SpenMiniCloseButton spenMiniCloseButton2 = this.this$0.mCloseButton;
                    if (spenMiniCloseButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCloseButton");
                        spenMiniCloseButton2 = null;
                    }
                    spenMiniCloseButton2.setAlpha(1.0f);
                    SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation6 = this.this$0.mChangeModeAnimator;
                    if (spenSettingUtilInOutAnimation6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                        spenSettingUtilInOutAnimation6 = null;
                    }
                    View mHeaderDivider = this.this$0.mParent.getMHeaderDivider();
                    ImageView imageView2 = this.this$0.mHeaderButton;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
                        imageView2 = null;
                    }
                    RelativeLayout relativeLayout2 = this.this$0.mDoneButton;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDoneButton");
                        relativeLayout2 = null;
                    }
                    spenSettingUtilInOutAnimation6.registerViewForAni(mHeaderDivider, imageView2, relativeLayout2);
                }
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation7 = this.this$0.mChangeModeAnimator;
                if (spenSettingUtilInOutAnimation7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                    spenSettingUtilInOutAnimation7 = null;
                }
                spenSettingUtilInOutAnimation7.setObjectVisibility(0);
                SpenSettingUtilInOutAnimation spenSettingUtilInOutAnimation8 = this.this$0.mChangeModeAnimator;
                if (spenSettingUtilInOutAnimation8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeModeAnimator");
                } else {
                    spenSettingUtilInOutAnimation2 = spenSettingUtilInOutAnimation8;
                }
                spenSettingUtilInOutAnimation2.showAnimation();
            }

            @Override // com.samsung.android.sdk.pen.setting.util.SpenSettingUtilInOutAnimation.AnimationEndListener
            public void onShowAnimationEnd() {
            }
        };
        init();
    }
}
