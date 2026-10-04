package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.AbstractC0622a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.listener.SpenComposerListenerManager;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.engine.SpenHoverListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.interaction.QTVisibilityHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p047K3.ViewOnLayoutChangeListenerC0162a;
import p072Q3.C0221a;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b \n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001%\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020(H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0019H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J \u00107\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019J\u0006\u0010:\u001a\u00020\u0019J&\u0010;\u001a\u00020(*\u00020\u00132\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020,2\b\b\u0002\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020\u0013H\u0002J\f\u0010@\u001a\u00020(*\u00020\u0013H\u0002J\f\u0010A\u001a\u00020(*\u00020\u0013H\u0002J\f\u0010B\u001a\u00020(*\u00020\u0013H\u0002J\u0014\u0010C\u001a\u00020(*\u00020\u00132\u0006\u0010D\u001a\u00020\u001cH\u0002J\f\u0010E\u001a\u00020(*\u00020\u0013H\u0002J\f\u0010F\u001a\u00020(*\u00020\u0013H\u0002J\f\u0010G\u001a\u00020(*\u00020\u0013H\u0002J\f\u0010H\u001a\u00020(*\u00020\u0013H\u0002J\u0006\u0010I\u001a\u00020\u0019J\b\u0010J\u001a\u00020\u0019H\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020\u001cH\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\u001cH\u0016J\u0016\u0010O\u001a\u00020(2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001c0QH\u0016J\u0016\u0010R\u001a\u00020(2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0QH\u0016J\u0010\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020\u001cH\u0016J\b\u0010W\u001a\u00020(H\u0016J\b\u0010X\u001a\u00020(H\u0016J\u0010\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\u0019H\u0016J\u0006\u0010[\u001a\u00020(J\u0006\u0010\\\u001a\u00020(J\u001e\u0010]\u001a\u00020(2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\nJ \u0010a\u001a\u00020(2\u0006\u0010-\u001a\u00020,2\u0006\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020!H\u0002J\u0006\u0010d\u001a\u00020(J\u0006\u0010e\u001a\u00020\u0019J\u0006\u0010f\u001a\u00020\u0019J\u0006\u0010g\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter$IQTView;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/setting/HwSettingContract$IQuickToolView;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;", "container", "Landroid/view/ViewGroup;", "composerView", "Lcom/samsung/android/sdk/composer/SpenComposer;", "coverView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;Landroid/view/ViewGroup;Lcom/samsung/android/sdk/composer/SpenComposer;Landroid/view/View;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "visibilityHandler", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/interaction/QTVisibilityHandler;", "child", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;", "getChild", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;", "setChild", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;)V", "isFavoriteShow", "", "isHideAnimationRunning", "currentMode", "", "wasSettingPenMiniShownBefore", "preTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "rotationType", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "getRotationType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "favoriteInfoChangeListener", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool$favoriteInfoChangeListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool$favoriteInfoChangeListener$1;", "initQuickTool", "", "initCoverView", "setEyedropperPosition", "x", "", "y", "toggle", "getDockingQTState", "", "updateEyedropper", "updateQTContainer", "width", "setClipToOutlineForQTContainer", "clipToOutline", "getDeltaCoordinateOrigin", Constants.IntentExtraValue.SHOW, "shouldLogFirstBehavior", "isShowing", "isFloating", "centerAt", "rawX", "rawY", "animation", "setupQuickTool", "setupMode", "setupAiMenu", "setupPens", "updatePenInfoList", "penType", "setupFavorites", "initEyedropperPosition", "setupPalettes", "setupRecentColors", "hide", "hideQt", "setVisibility", "visibility", "onColorThemeChanged", "colorTheme", "onColorPalettesChanged", "colorPalettes", "", "onRecentColorsChanged", "recentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "requestHideFromToolbar", "viewId", "updateInfo", "onConfigurationChanged", "blockAiMenu", RPCSyncSettingContract.Parameter.SUPPORTED, "close", "noticeChangeLayout", "reloadQuickTool", "parent", "composer", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MAIN_THUMBNAIL_FILE_NAME_COVER, "updateQuickTool", "modePen", "dockingType", "requestCancelTouch", "isFavoritePenListShow", "isRightDocking", "isColorPickerViewMode", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
@SourceDebugExtension({"SMAP\nQuickTool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickTool.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool\n+ 2 ViewExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/ViewExtensionKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,554:1\n6#2:555\n6#2:557\n1#3:556\n*S KotlinDebug\n*F\n+ 1 QuickTool.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool\n*L\n111#1:555\n381#1:557\n*E\n"})
public final class QuickTool implements QuickToolPresenter.IQTView, HwSettingContract.IQuickToolView {
    public static final int QT_DOCKING_TYPE = 2;
    public static final int QT_DOCKING_Y = 1;
    public static final int QT_MODE = 3;

    @Nullable
    private QuickToolContainer child;

    @NotNull
    private SpenComposer composerView;

    @NotNull
    private ViewGroup container;
    private final Context context;

    @NotNull
    private View coverView;
    private int currentMode;

    @NotNull
    private final QuickTool$favoriteInfoChangeListener$1 favoriteInfoChangeListener;
    private boolean isFavoriteShow;
    private boolean isHideAnimationRunning;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener preTouchListener;

    @NotNull
    private final QuickToolPresenter presenter;

    @NotNull
    private final QTVisibilityHandler visibilityHandler;
    private boolean wasSettingPenMiniShownBefore;
    private static final String TAG = Logger.createTag("QuickTool");

    /* JADX WARN: Type inference failed for: r4v3, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool$favoriteInfoChangeListener$1] */
    public QuickTool(@NotNull QuickToolPresenter presenter, @NotNull ViewGroup container, @NotNull SpenComposer composerView, @NotNull View coverView) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(composerView, "composerView");
        Intrinsics.checkNotNullParameter(coverView, "coverView");
        this.presenter = presenter;
        this.container = container;
        this.composerView = composerView;
        this.coverView = coverView;
        this.context = container.getContext();
        this.visibilityHandler = new QTVisibilityHandler(this);
        this.favoriteInfoChangeListener = new SettingFavoritePenData.FavoritePenInfoChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool$favoriteInfoChangeListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoriteIndexChanged(int index) {
                QuickToolContainer child = this.this$0.getChild();
                if (child != null) {
                    child.setFavoriteList(this.this$0.presenter.getFavoriteInfoList(), index);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> favorites) {
                Intrinsics.checkNotNullParameter(favorites, "favorites");
                QuickToolContainer child = this.this$0.getChild();
                if (child != null) {
                    child.setFavoriteList(favorites, this.this$0.presenter.getFavoriteSelectedIndex());
                }
            }
        };
        initQuickTool();
        initCoverView();
        if (presenter.getMDockingState() != null) {
            float[] mDockingState = presenter.getMDockingState();
            Intrinsics.checkNotNull(mDockingState);
            presenter.setView(this);
            updateQuickTool(mDockingState[1], (int) mDockingState[3], SpenSettingQTPenContainer.RotationType.getEntries().get((int) mDockingState[2]));
            presenter.setMDockingState(null);
        }
    }

    private final void centerAt(QuickToolContainer quickToolContainer, float f, float f4, boolean z) {
        this.container.getLocationOnScreen(new int[2]);
        float fCoerceIn = RangesKt.coerceIn((f - r0[0]) - (quickToolContainer.getWidth() * 0.5f), -quickToolContainer.getMDelta(), quickToolContainer.getMDelta() + (this.container.getWidth() - quickToolContainer.getWidth()));
        float fCoerceIn2 = RangesKt.coerceIn((f4 - r0[1]) - (quickToolContainer.getHeight() * 0.5f), -quickToolContainer.getMDelta(), quickToolContainer.getMDelta() + (this.container.getHeight() - quickToolContainer.getHeight()));
        if (z) {
            quickToolContainer.startMoveOutDockingAnimation(fCoerceIn, fCoerceIn2);
            return;
        }
        quickToolContainer.setX(fCoerceIn);
        quickToolContainer.setY(fCoerceIn2);
        QuickToolContainer quickToolContainer2 = this.child;
        if (quickToolContainer2 != null) {
            quickToolContainer2.resetCoverQT();
        }
    }

    public static /* synthetic */ void centerAt$default(QuickTool quickTool, QuickToolContainer quickToolContainer, float f, float f4, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        quickTool.centerAt(quickToolContainer, f, f4, z);
    }

    private final void initCoverView() {
        if (ResourceUtils.isTabletLayout(this.context)) {
            this.coverView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCoverView$lambda$2(QuickTool quickTool, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (quickTool.coverView.getLayoutDirection() == 1) {
            QuickToolContainer quickToolContainer = quickTool.child;
            if ((quickToolContainer != null ? quickToolContainer.getDockingType() : null) == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
                quickTool.updateQTContainer(quickTool.coverView.getWidth());
                quickTool.setClipToOutlineForQTContainer(true);
                return;
            }
            return;
        }
        QuickToolContainer quickToolContainer2 = quickTool.child;
        if ((quickToolContainer2 != null ? quickToolContainer2.getDockingType() : null) == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
            quickTool.updateQTContainer(quickTool.coverView.getWidth());
            quickTool.setClipToOutlineForQTContainer(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initEyedropperPosition(QuickToolContainer quickToolContainer) {
        float dimension;
        float dimension2 = quickToolContainer.getResources().getDimension(C9086R.dimen.color_spoid_width);
        float dimension3 = quickToolContainer.getResources().getDimension(C9086R.dimen.color_spoid_height);
        int[] iArr = new int[2];
        this.container.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.composerView.getLocationOnScreen(iArr2);
        int i = iArr2[0] - iArr[0];
        int i2 = iArr2[1] - iArr[1];
        if (quickToolContainer.getDockingType() == SpenSettingQTPenContainer.RotationType.NONE) {
            dimension = AbstractC0000a.m29z(quickToolContainer.getWidth(), dimension2, 0.5f, quickToolContainer.getX());
        } else {
            dimension = quickToolContainer.getResources().getDimension(C9086R.dimen.composer_qt_color_picker_radius);
            if (quickToolContainer.getDockingType() != SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
                dimension = (this.container.getWidth() - dimension) - dimension2;
            }
        }
        setEyedropperPosition(this.container.getLayoutDirection() == 0 ? dimension - i : (dimension - i) + dimension2, (((quickToolContainer.getHeight() + dimension3) * 0.5f) + quickToolContainer.getY()) - i2);
    }

    private final void initQuickTool() {
        this.presenter.getHwToolbarPresenter().getMRemoteHwSettingPresenter().setQuickToolView(this);
        SpenComposerListenerManager listenerManager = this.composerView.getListenerManager();
        if (listenerManager != null) {
            listenerManager.setHoverListener(new SpenHoverListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.initQuickTool.1
                @Override // com.samsung.android.sdk.pen.engine.SpenHoverListener
                public boolean onHover(View view, MotionEvent event) {
                    if (event != null) {
                        return QuickTool.this.visibilityHandler.onHover(event);
                    }
                    return false;
                }
            });
        }
        C0221a c0221a = new C0221a(this, 2);
        this.preTouchListener = c0221a;
        this.presenter.setPreTouchListener(c0221a);
        this.presenter.addOnSipListener();
        this.container.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initQuickTool$lambda$0(QuickTool quickTool, View view, MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) == 2) {
            quickTool.setEyedropperPosition(motionEvent.getX(), motionEvent.getY());
        }
        QTVisibilityHandler qTVisibilityHandler = quickTool.visibilityHandler;
        Intrinsics.checkNotNull(motionEvent);
        return qTVisibilityHandler.onTouchComposer(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initQuickTool$lambda$1(QuickTool quickTool, View view, MotionEvent motionEvent) {
        QTVisibilityHandler qTVisibilityHandler = quickTool.visibilityHandler;
        Intrinsics.checkNotNull(motionEvent);
        return qTVisibilityHandler.onTouch(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConfigurationChanged$lambda$8(QuickToolContainer quickToolContainer, QuickTool quickTool) {
        QuickToolContainer.changeToMode$default(quickToolContainer, quickTool.currentMode, false, 2, null);
        quickToolContainer.restoreDocking(quickToolContainer.getDockingType());
    }

    private final void setEyedropperPosition(float x, float y2) {
        if (this.container.getLayoutDirection() != 0) {
            x = this.composerView.getWidth() - x;
        }
        this.presenter.setEyedropperPosition(x, y2);
    }

    private final void setupAiMenu(QuickToolContainer quickToolContainer) {
        if (quickToolContainer.getPresenter().isFocusStickyNote()) {
            quickToolContainer.setRestrictionAiMode(true);
        }
        Context context = quickToolContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        QuickToolAiMenu quickToolAiMenu = new QuickToolAiMenu(context, this, quickToolContainer.getPresenter());
        CharSequence text = quickToolContainer.getContext().getText(C9086R.string.ai_notes_assist);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        quickToolContainer.getPresenter().clearSelectionNoteAssist();
        quickToolContainer.setDockingCustomMode(C9086R.drawable.qt_ic_ai_menu_toolbar_btn_unselected, C9086R.drawable.ic_ai_menu_toolbar_btn, text, quickToolAiMenu.makeAiMenuForDocking());
        quickToolContainer.setFloatingCustomMode(C9086R.drawable.qt_ic_ai_menu_toolbar_btn_unselected, C9086R.drawable.ic_ai_menu_toolbar_btn, text, quickToolAiMenu.makeAiMenuForFloating());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    private final void setupFavorites(final QuickToolContainer quickToolContainer) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? favoriteInfoList = quickToolContainer.getPresenter().getFavoriteInfoList();
        objectRef.element = favoriteInfoList;
        if (this.currentMode == 1 && !((Collection) favoriteInfoList).isEmpty() && quickToolContainer.getPresenter().getFavoriteSelectedIndex() == -1) {
            quickToolContainer.getPresenter().onPenInfoChange((SpenSettingUIPenInfo) ((List) objectRef.element).get(0));
        }
        quickToolContainer.setFavoriteList((List) objectRef.element, quickToolContainer.getPresenter().getFavoriteSelectedIndex());
        quickToolContainer.setFavoriteInfoChangedListener(new SpenSettingQTPenContainer.PenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.setupFavorites.1
            /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.List] */
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener
            public void onPenInfoChanged(int index, SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
                quickToolSA.log(QuickToolSA.EVENT_QT_CHANGE_FAVORITE_PEN);
                objectRef.element = quickToolContainer.getPresenter().getFavoriteInfoList();
                quickToolContainer.getPresenter().onFavoriteInfoChange(objectRef.element.get(index), info);
                quickToolSA.log(QuickToolSA.EVENT_QT_SELECT_PEN_STYLE, quickToolSA.getSADetailPenType(info.name));
            }
        });
        quickToolContainer.setOnAddButtonClickListener(new SpenSettingQTPenContainer.OnAddButtonClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.setupFavorites.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnAddButtonClickListener
            public void onAddButtonClicked() {
                QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_ADD_FAVORITE_PEN, quickToolContainer.getDockingType(), quickToolContainer.getViewMode());
                quickToolContainer.getPresenter().showAddFavoritePen(this.container, (((float) quickToolContainer.getWidth()) * 0.5f) + quickToolContainer.getX() >= ((float) this.container.getWidth()) * 0.5f);
                this.isFavoriteShow = true;
            }
        });
        quickToolContainer.setPaletteActionButtonListener(new SpenSettingQTPenContainer.PaletteActionButtonListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.setupFavorites.3
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.PaletteActionButtonListener
            public void onButtonClick(int mode, int type) {
                if (type == 2) {
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_EYEDROPPER, quickToolContainer.getDockingType());
                    quickToolContainer.getPresenter().showEyedropper(this.container);
                    this.initEyedropperPosition(quickToolContainer);
                    this.hide();
                }
            }
        });
        quickToolContainer.setFavoriteListActionListener(new SpenSettingQTPenContainer.OnFavoriteListActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.setupFavorites.4
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnFavoriteListActionListener
            public void onItemSelected(int position) {
                quickToolContainer.getPresenter().setCurrentFavoriteIndex(position);
                this.hide();
            }
        });
        quickToolContainer.getPresenter().registerFavoriteInfoChangeListener(this.favoriteInfoChangeListener);
    }

    private final void setupMode(QuickToolContainer quickToolContainer) {
        if (this.currentMode != 0 && quickToolContainer.getPresenter().isFocusStickyNote()) {
            this.currentMode = 0;
        }
        QuickToolContainer.changeToMode$default(quickToolContainer, this.currentMode, false, 2, null);
        quickToolContainer.setOnModeChangedListener(new C4202b(this, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupMode$lambda$7(QuickTool quickTool, int i) {
        quickTool.currentMode = i;
        return Unit.INSTANCE;
    }

    private final void setupPalettes(QuickToolContainer quickToolContainer) {
        quickToolContainer.setPalette(quickToolContainer.getPresenter().getPaletteList());
    }

    private final void setupPens(final QuickToolContainer quickToolContainer) {
        int selectedPenType = quickToolContainer.getPresenter().getSelectedPenType();
        updatePenInfoList(quickToolContainer, selectedPenType);
        quickToolContainer.getPresenter().onItemSelected(selectedPenType);
        quickToolContainer.setPenInfoChangedListener(new SpenSettingQTPenContainer.PenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.setupPens.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener
            public void onPenInfoChanged(int index, SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                SpenSettingUIPenInfo selectedPenInfo = quickToolContainer.getPresenter().getSelectedPenInfo();
                quickToolContainer.getPresenter().onPenInfoChange(info);
                if (!Intrinsics.areEqual(info.name, selectedPenInfo.name)) {
                    QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
                    quickToolSA.log(QuickToolSA.EVENT_QT_SELECT_PEN_STYLE, quickToolSA.getSADetailPenType(info.name));
                    return;
                }
                int i = info.color;
                if (((i >> 24) & 255) != ((selectedPenInfo.color >> 24) & 255)) {
                    QuickToolSA quickToolSA2 = QuickToolSA.INSTANCE;
                    quickToolSA2.log(QuickToolSA.EVENT_QT_MODIFY_PEN_TRANSPARENCY, String.valueOf((int) Math.ceil(((double) quickToolSA2.getAlphaPercent((i >> 24) & 255)) / ((double) 10))));
                    return;
                }
                int i2 = info.sizeLevel;
                if (i2 != selectedPenInfo.sizeLevel) {
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_MODIFY_PEN_THICKNESS, String.valueOf((int) Math.ceil(((double) i2) / ((double) 10))));
                }
            }
        });
    }

    private final QuickToolContainer setupQuickTool() {
        boolean zCanShowAiMenu = this.presenter.canShowAiMenu();
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuickToolPresenter quickToolPresenter = this.presenter;
        QuickToolContainer quickToolContainer = new QuickToolContainer(context, quickToolPresenter, quickToolPresenter.isEyeDropperEnabled(), zCanShowAiMenu, this.visibilityHandler);
        if (zCanShowAiMenu) {
            setupAiMenu(quickToolContainer);
        }
        setupMode(quickToolContainer);
        setupPens(quickToolContainer);
        setupFavorites(quickToolContainer);
        setupPalettes(quickToolContainer);
        setupRecentColors(quickToolContainer);
        return quickToolContainer;
    }

    private final void setupRecentColors(QuickToolContainer quickToolContainer) {
        quickToolContainer.setRecentColor(CollectionsKt.toMutableList((Collection) quickToolContainer.getPresenter().getRecentColors()));
    }

    public static /* synthetic */ boolean show$default(QuickTool quickTool, float f, float f4, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return quickTool.show(f, f4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toggle$lambda$3(QuickTool quickTool, float f, float f4, boolean z) {
        if (z) {
            quickTool.presenter.clearSelectionNoteAssist();
            QuickToolContainer quickToolContainer = quickTool.child;
            if (quickToolContainer != null) {
                quickTool.centerAt(quickToolContainer, f, f4, true);
            }
        } else {
            quickTool.container.removeView(quickTool.child);
            QuickToolContainer quickToolContainer2 = quickTool.child;
            if (quickToolContainer2 != null) {
                quickToolContainer2.close();
            }
            quickTool.child = null;
            quickTool.show(f, f4, false);
        }
        return Unit.INSTANCE;
    }

    private final void updatePenInfoList(QuickToolContainer quickToolContainer, int i) {
        if (quickToolContainer.getPresenter().isFocusStickyNote()) {
            quickToolContainer.setPenInfoList(quickToolContainer.getPresenter().getPenInfoList(), quickToolContainer.getPresenter().getPenSelectedIndex());
        } else {
            List<SpenSettingUIPenInfo> penInfoList = quickToolContainer.getPresenter().getPenInfoList();
            quickToolContainer.setPenInfoList(CollectionsKt.plus((Collection) penInfoList, (Iterable) quickToolContainer.getPresenter().getHighlighterInfoList()), i == 2 ? quickToolContainer.getPresenter().getPenSelectedIndex() : penInfoList.size() + quickToolContainer.getPresenter().getHighlighterSelectedIndex());
        }
    }

    private final void updateQuickTool(final float y2, int modePen, SpenSettingQTPenContainer.RotationType dockingType) {
        this.currentMode = modePen;
        final QuickToolContainer quickToolContainer = setupQuickTool();
        this.child = quickToolContainer;
        this.container.addView(quickToolContainer);
        quickToolContainer.setDockingType(dockingType);
        quickToolContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.updateQuickTool.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (quickToolContainer.getWidth() <= 0 || quickToolContainer.getHeight() <= 0) {
                    return;
                }
                quickToolContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                quickToolContainer.reAttachQuickTool(y2);
            }
        });
        quickToolContainer.setCoverAndContainer(this.container, this.coverView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void blockAiMenu(boolean supported) {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setRestrictionAiMode(supported);
        }
    }

    public final void close() {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            this.presenter.setView(null);
            this.presenter.unregisterFavoriteInfoChangeListener(this.favoriteInfoChangeListener);
            this.presenter.removePreTouchListener(this.preTouchListener);
            this.presenter.removeOnSipListener();
            this.container.removeView(quickToolContainer);
            this.container.addOnLayoutChangeListener(null);
            quickToolContainer.close();
            this.child = null;
        }
    }

    @Nullable
    public final QuickToolContainer getChild() {
        return this.child;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public int getDeltaCoordinateOrigin() {
        return Math.abs(this.container.getLeft() - this.coverView.getLeft());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    @Nullable
    public float[] getDockingQTState() {
        SpenSettingQTPenContainer.RotationType dockingType;
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer == null || (dockingType = quickToolContainer.getDockingType()) == SpenSettingQTPenContainer.RotationType.NONE) {
            return null;
        }
        return new float[]{0.0f, quickToolContainer.getY(), dockingType.ordinal(), 0.0f};
    }

    @Nullable
    public final SpenSettingQTPenContainer.RotationType getRotationType() {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            return quickToolContainer.getDockingType();
        }
        return null;
    }

    public final boolean hide() {
        QuickToolContainer quickToolContainer;
        String str = TAG;
        AbstractC0000a.m3D(this.container.getChildCount(), "hide() childCount: ", str);
        if (!this.presenter.isSupportQuickTool() || this.container.getChildCount() > 1 || (quickToolContainer = this.child) == null) {
            return false;
        }
        if (quickToolContainer.getPenListType() == 1) {
            QuickToolContainer.hideDockingPenList$default(quickToolContainer, this.currentMode, null, 2, null);
        }
        if (quickToolContainer.getDockingType() == SpenSettingQTPenContainer.RotationType.NONE) {
            return hideQt();
        }
        Logger.m10999d(str, "disable hide");
        quickToolContainer.hide3rdLayer();
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public boolean hideQt() {
        final QuickToolContainer quickToolContainer;
        if (this.isHideAnimationRunning || this.presenter.getIsRequestShowNoteAssist() || (quickToolContainer = this.child) == null) {
            return false;
        }
        this.isHideAnimationRunning = true;
        this.isFavoriteShow = false;
        this.presenter.unregisterFavoriteInfoChangeListener(this.favoriteInfoChangeListener);
        return quickToolContainer.setVisibilityWithAnimation(8, new OnVisibilityAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.hideQt.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener
            public void onAnimationEnd(int visibility, boolean canceled) {
                if (canceled) {
                    return;
                }
                QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_LAST_MODE, QuickTool.this.currentMode);
                QuickTool.this.isHideAnimationRunning = false;
                QuickTool.this.presenter.setView(null);
                QuickTool.this.container.removeView(quickToolContainer);
                quickToolContainer.close();
                QuickTool.this.setChild(null);
                if (QuickTool.this.wasSettingPenMiniShownBefore) {
                    QuickTool.this.presenter.showSettingPenMini();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener
            public void onAnimationStart(int visibility) {
            }
        });
    }

    public final boolean isColorPickerViewMode() {
        QuickToolContainer quickToolContainer = this.child;
        return (quickToolContainer != null ? quickToolContainer.m22191getViewMode() : null) == SettingQTPenLayout.ViewMode.COLOR_PICKER;
    }

    public final boolean isFavoritePenListShow() {
        QuickToolContainer quickToolContainer = this.child;
        return quickToolContainer != null && quickToolContainer.getPenListType() == 2;
    }

    public final boolean isFloating() {
        QuickToolContainer quickToolContainer = this.child;
        return (quickToolContainer != null ? quickToolContainer.getDockingType() : null) == SpenSettingQTPenContainer.RotationType.NONE;
    }

    public final boolean isRightDocking() {
        QuickToolContainer quickToolContainer = this.child;
        return (quickToolContainer != null ? quickToolContainer.getDockingType() : null) == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING;
    }

    public final boolean isShowing() {
        return this.child != null;
    }

    public final void noticeChangeLayout() {
        if (ResourceUtils.isTabletLayout(this.context) || !isShowing()) {
            return;
        }
        ToastHandler.show(this.context, C9086R.string.not_support_window_quick_tool_notice, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IQuickToolView
    public void onColorPalettesChanged(@NotNull List<Integer> colorPalettes) {
        Intrinsics.checkNotNullParameter(colorPalettes, "colorPalettes");
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setPalette(colorPalettes);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IQuickToolView
    public void onColorThemeChanged(int colorTheme) {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setColorTheme(colorTheme);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void onConfigurationChanged() {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer == null) {
            return;
        }
        if (quickToolContainer.getDockingType() == SpenSettingQTPenContainer.RotationType.NONE) {
            hideQt();
        } else if (ResourceUtils.isTabletLayout(this.context)) {
            this.container.post(new RunnableC9844c(quickToolContainer, this, 24));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IQuickToolView
    public void onRecentColorsChanged(@NotNull List<SpenHSVColor> recentColors) {
        Intrinsics.checkNotNullParameter(recentColors, "recentColors");
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setRecentColor(CollectionsKt.toMutableList((Collection) recentColors));
        }
    }

    public final void reloadQuickTool(@NotNull ViewGroup parent, @NotNull SpenComposer composer, @NotNull View cover) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(cover, "cover");
        this.container = parent;
        this.composerView = composer;
        this.coverView = cover;
        initQuickTool();
        initCoverView();
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer == null) {
            return;
        }
        this.container.removeView(quickToolContainer);
        quickToolContainer.close();
        this.child = null;
        updateQuickTool(quickToolContainer.getY(), 0, quickToolContainer.getDockingType());
    }

    public final void requestCancelTouch() {
        this.presenter.requestCancelTouch();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void requestHideFromToolbar(int viewId) {
        if (this.isFavoriteShow) {
            hideQt();
        }
    }

    public final void setChild(@Nullable QuickToolContainer quickToolContainer) {
        this.child = quickToolContainer;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void setClipToOutlineForQTContainer(boolean clipToOutline) {
        AbstractC8014b.m7220v("setClipToOutlineForQTContainer ", TAG, this.container.getClipToOutline());
        if (this.container.getClipToOutline() != clipToOutline) {
            this.container.setClipToOutline(clipToOutline);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void setVisibility(int visibility) {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setVisibility(visibility);
        }
    }

    public final boolean show(final float x, final float y2, boolean shouldLogFirstBehavior) {
        String str = TAG;
        AbstractC8014b.m7215q(AbstractC0622a.m1176v("show x:", x, ", y:", y2, ", hasFocus:"), this.composerView.hasWindowFocus(), str);
        if (!this.presenter.isSupportQuickTool() || !this.composerView.hasWindowFocus()) {
            return false;
        }
        if (!ResourceUtils.isTabletLayout(this.context)) {
            ToastHandler.show(this.context, C9086R.string.not_support_window_quick_tool_notice, 0);
            return false;
        }
        if (this.child != null) {
            return false;
        }
        this.presenter.setView(this);
        this.wasSettingPenMiniShownBefore = this.presenter.hideSettingPenMini();
        final QuickToolContainer quickToolContainer = setupQuickTool();
        this.child = quickToolContainer;
        quickToolContainer.setVisibilityWithAnimation(0, null);
        quickToolContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool.show.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (quickToolContainer.getWidth() <= 0 || quickToolContainer.getHeight() <= 0) {
                    return;
                }
                quickToolContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                QuickTool.centerAt$default(this, quickToolContainer, x, y2, false, 4, null);
            }
        });
        this.container.addView(quickToolContainer);
        quickToolContainer.setCoverAndContainer(this.container, this.coverView);
        QuickToolContainer quickToolContainer2 = this.child;
        if (quickToolContainer2 != null) {
            quickToolContainer2.resetCoverQT();
        }
        QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
        quickToolSA.setShouldLogFirstBehavior(shouldLogFirstBehavior);
        quickToolSA.log(QuickToolSA.EVENT_QT_CALL_QUICK_TOOLS);
        return true;
    }

    public final boolean toggle(final float x, final float y2) {
        if (!this.composerView.hasWindowFocus() || !this.presenter.isSupportQuickTool()) {
            return false;
        }
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer == null) {
            return show$default(this, x, y2, false, 4, null);
        }
        if (quickToolContainer.moveOutDocking(new Function1() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickTool.toggle$lambda$3(this.f7227a, x, y2, ((Boolean) obj).booleanValue());
            }
        })) {
            return false;
        }
        boolean zHide = hide();
        if (zHide) {
            QuickToolSA.INSTANCE.logFirstBehavior(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON);
        }
        return zHide;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void updateEyedropper() {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer != null) {
            quickToolContainer.setEyedropperEnabled(this.presenter.isEyeDropperEnabled());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void updateInfo() {
        QuickToolContainer quickToolContainer = this.child;
        if (quickToolContainer == null) {
            return;
        }
        updatePenInfoList(quickToolContainer, this.presenter.getSelectedPenType());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter.IQTView
    public void updateQTContainer(int width) {
        this.container.getLayoutParams().width = width;
        this.container.requestLayout();
    }
}
