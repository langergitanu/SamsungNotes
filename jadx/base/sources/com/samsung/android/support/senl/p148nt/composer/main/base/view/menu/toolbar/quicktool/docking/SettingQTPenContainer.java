package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.core.view.ViewGroupKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\rJ \u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0015J(\u0010,\u001a\u00020)2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0015J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\rJ\u0018\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u000108J\u001a\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020;2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u000e\u0010<\u001a\u00020)2\u0006\u00107\u001a\u00020'J,\u0010=\u001a\u00020)2\u0006\u00104\u001a\u00020\u001c2\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u0005J\u0006\u0010A\u001a\u00020)J\u0016\u0010B\u001a\u00020)2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010DJ\u0016\u0010E\u001a\u00020)2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fJ\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u0005J\u001c\u0010I\u001a\u00020\u00052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0D2\u0006\u0010L\u001a\u00020\rJ\u000e\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020KJ\u0010\u0010O\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010PJ\u001c\u0010Q\u001a\u00020\u00052\f\u0010R\u001a\b\u0012\u0004\u0012\u00020K0D2\u0006\u0010S\u001a\u00020\rJ\u0010\u0010T\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010PJ\u000e\u0010U\u001a\u00020)2\u0006\u0010 \u001a\u00020!J\u0018\u0010U\u001a\u00020)2\u0006\u00100\u001a\u00020\u00152\u0006\u0010V\u001a\u00020WH\u0002J\u0016\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020W2\u0006\u0010Z\u001a\u00020WJ\u0018\u0010[\u001a\u00020)2\u0006\u00104\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\u0005J\u0018\u0010]\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\"\u0010^\u001a\u00020)2\u0006\u00104\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\\\u001a\u00020\u0005H\u0002J\u0006\u0010_\u001a\u00020)J\u0012\u0010`\u001a\u0004\u0018\u00010K2\u0006\u00104\u001a\u00020\rH\u0002J\u0010\u0010a\u001a\u00020\r2\u0006\u00104\u001a\u00020\rH\u0002J\u001e\u0010b\u001a\u00020)2\u0006\u00104\u001a\u00020\r2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020K0\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "supportEyedropper", "", "supportCustomMode", "<init>", "(Landroid/content/Context;ZZ)V", "mPenLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout;", "mPaletteList", "", "", "mRecentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "mPenListManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListManager;", "mFavoriteListManager", "mSupportCustomMode", "mCustomModeView", "Landroid/view/View;", "mMode", "getMMode", "()I", "setMMode", "(I)V", "value", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "viewMode", "getViewMode", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "rotationType", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "getRotationType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "setRotationType", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;)V", "mPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PaletteActionButtonListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setCustomMode", "resourceId", "description", "", "view", "unselectedResourceId", "selectedResourceId", "changeMode", "mode", "setVisibilityWithAnimation", "visibility", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$VisibilityChangedListener;", "setModeVisibility", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationType;", "setPaletteActionButtonListener", "setViewMode", "animation", "notify", "forceUpdate", "updateColor", "setPalette", "paletteList", "", "setRecentColor", "recentList", "setEyedropperEnabled", "enabled", "setPenInfoList", "uiInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "currentPenIndex", "setPenInfo", "info", "setPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PenInfoChangedListener;", "setFavoriteList", XmlErrorCodes.LIST, "selectedIndex", "setFavoriteInfoChangedListener", "setRotation", "degrees", "", "isScrollAt", "x", "y", "onModeChanged", "openPenList", "initView", "changeView", "collapse", "getCurrentPenInfo", "getCurrentPenIndex", "getCurrentPenList", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSettingQTPenContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTPenContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,392:1\n1740#2,3:393\n*S KotlinDebug\n*F\n+ 1 SettingQTPenContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenContainer\n*L\n164#1:393,3\n*E\n"})
public final class SettingQTPenContainer extends FrameLayout {
    public static final int MODE_CUSTOM = 2;
    public static final int MODE_FAVORITE = 1;
    public static final int MODE_PEN = 0;

    @NotNull
    private static final String TAG = "SettingQTPenContainer";

    @Nullable
    private View mCustomModeView;

    @NotNull
    private final QTPenListManager mFavoriteListManager;
    private int mMode;

    @Nullable
    private SpenSettingQTPenContainer.PaletteActionButtonListener mPaletteActionButtonListener;

    @NotNull
    private final List<Integer> mPaletteList;
    private SettingQTPenLayout mPenLayout;

    @NotNull
    private final QTPenListManager mPenListManager;

    @NotNull
    private final List<SpenHSVColor> mRecentColors;
    private boolean mSupportCustomMode;

    @NotNull
    private SpenSettingQTPenContainer.RotationType rotationType;
    private boolean supportEyedropper;

    @NotNull
    private SettingQTPenLayout.ViewMode viewMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTPenContainer(@NotNull Context context, boolean z, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.supportEyedropper = z;
        this.mPaletteList = new ArrayList();
        this.mRecentColors = new ArrayList();
        this.mPenListManager = new QTPenListManager();
        this.mFavoriteListManager = new QTPenListManager();
        this.mSupportCustomMode = z2;
        this.viewMode = SettingQTPenLayout.ViewMode.MAIN;
        this.rotationType = SpenSettingQTPenContainer.RotationType.NONE;
        initView(context, this.supportEyedropper);
    }

    private final void changeView(int mode, boolean animation, boolean openPenList) {
        Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mMode, mode, "changeView() mode[", " -> ", "]"));
        SettingQTPenLayout settingQTPenLayout = null;
        if (mode == 2) {
            View view = this.mCustomModeView;
            SettingQTLayout settingQTLayout = view instanceof SettingQTLayout ? (SettingQTLayout) view : null;
            if (settingQTLayout != null) {
                settingQTLayout.toggle(0, animation);
            }
            SettingQTPenLayout settingQTPenLayout2 = this.mPenLayout;
            if (settingQTPenLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                settingQTPenLayout = settingQTPenLayout2;
            }
            settingQTPenLayout.toggle(8, animation);
            return;
        }
        View view2 = this.mCustomModeView;
        SettingQTLayout settingQTLayout2 = view2 instanceof SettingQTLayout ? (SettingQTLayout) view2 : null;
        if (settingQTLayout2 != null) {
            settingQTLayout2.toggle(8, animation);
        }
        if (mode != 0 || openPenList) {
            SettingQTPenLayout settingQTPenLayout3 = this.mPenLayout;
            if (settingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                settingQTPenLayout3 = null;
            }
            settingQTPenLayout3.toggle(8, animation);
        } else {
            SettingQTPenLayout settingQTPenLayout4 = this.mPenLayout;
            if (settingQTPenLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                settingQTPenLayout4 = null;
            }
            settingQTPenLayout4.toggle(0, animation);
        }
        SettingQTPenLayout settingQTPenLayout5 = this.mPenLayout;
        if (settingQTPenLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout5 = null;
        }
        settingQTPenLayout5.setPaletteList(this.mPaletteList);
        SettingQTPenLayout settingQTPenLayout6 = this.mPenLayout;
        if (settingQTPenLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout6 = null;
        }
        settingQTPenLayout6.setRecentColor(this.mRecentColors);
        ArrayList arrayList = new ArrayList();
        getCurrentPenList(mode, arrayList);
        SettingQTPenLayout settingQTPenLayout7 = this.mPenLayout;
        if (settingQTPenLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            settingQTPenLayout = settingQTPenLayout7;
        }
        settingQTPenLayout.setPenInfoList(arrayList, getCurrentPenIndex(mode));
    }

    public static /* synthetic */ void changeView$default(SettingQTPenContainer settingQTPenContainer, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        settingQTPenContainer.changeView(i, z, z2);
    }

    private final int getCurrentPenIndex(int mode) {
        if (mode == 0) {
            return this.mPenListManager.getMCurrentIndex();
        }
        int currentPenIndex = this.mFavoriteListManager.getMCurrentIndex();
        return currentPenIndex > -1 ? currentPenIndex : this.mFavoriteListManager.getPenInfoCount() > 0 ? 0 : -1;
    }

    private final SpenSettingUIPenInfo getCurrentPenInfo(int mode) {
        if (mode == 0) {
            return this.mPenListManager.getCurrentPenInfo();
        }
        if (this.mFavoriteListManager.getMCurrentIndex() > -1) {
            return this.mFavoriteListManager.getCurrentPenInfo();
        }
        AbstractC8014b.m7217s(this.mFavoriteListManager.getPenInfoCount(), "favorite count=", TAG);
        if (this.mFavoriteListManager.getPenInfoCount() > 0) {
            return this.mFavoriteListManager.getPenInfo(0);
        }
        return null;
    }

    private final void getCurrentPenList(int mode, List<SpenSettingUIPenInfo> list) {
        if (mode == 0) {
            this.mPenListManager.getPenInfoList(list);
        } else {
            this.mFavoriteListManager.getPenInfoList(list);
        }
    }

    private final void initView(Context context, boolean supportEyedropper) {
        addView(new View(context), new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_pen_list_width), context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_default_size)));
        SettingQTPenLayout settingQTPenLayout = new SettingQTPenLayout(context, supportEyedropper);
        this.mPenLayout = settingQTPenLayout;
        addView(settingQTPenLayout);
        SettingQTPenLayout settingQTPenLayout2 = this.mPenLayout;
        SettingQTPenLayout settingQTPenLayout3 = null;
        if (settingQTPenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout2 = null;
        }
        settingQTPenLayout2.setViewModeChangedListener(new SettingQTPenLayout.OnViewModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer.initView.1

            /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer$initView$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SettingQTPenLayout.ViewMode.values().length];
                    try {
                        iArr[SettingQTPenLayout.ViewMode.COLOR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SettingQTPenLayout.ViewMode.ATTRIBUTES.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SettingQTPenLayout.ViewMode.COLOR_PICKER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.OnViewModeChangedListener
            public void onViewModeChanged(SettingQTPenLayout.ViewMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Logger.m11003i(SettingQTPenContainer.TAG, "onViewModeChanged() mode=" + SettingQTPenContainer.this.getMMode() + ", viewMode=" + mode);
                SettingQTPenContainer.this.viewMode = mode;
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                if (i == 1) {
                    QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
                    quickToolSA.logFirstBehavior("3");
                    quickToolSA.log(QuickToolSA.EVENT_QT_COLOR_LIST, SettingQTPenContainer.this.getRotationType());
                } else if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_COLOR_PICKER, SettingQTPenContainer.this.getRotationType());
                } else {
                    QuickToolSA quickToolSA2 = QuickToolSA.INSTANCE;
                    quickToolSA2.logFirstBehavior("2");
                    quickToolSA2.log(QuickToolSA.EVENT_QT_THICKNESS_AND_TRANSPARENCY, SettingQTPenContainer.this.getRotationType());
                }
            }
        });
        SettingQTPenLayout settingQTPenLayout4 = this.mPenLayout;
        if (settingQTPenLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout4 = null;
        }
        settingQTPenLayout4.setPenInfoChangedListener(new SpenSettingQTPenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer.initView.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener
            public void onPenInfoChanged(int index, SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                StringBuilder sbM1173s = AbstractC0622a.m1173s(SettingQTPenContainer.this.getMMode(), index, "onPenInfoChanged() mode=", " index=", " info=");
                sbM1173s.append(info);
                Logger.m11003i(SettingQTPenContainer.TAG, sbM1173s.toString());
                if (SettingQTPenContainer.this.getMMode() == 0) {
                    SettingQTPenContainer.this.mPenListManager.setCurrentPenInfo(index, info, true);
                } else if (SettingQTPenContainer.this.getMMode() == 1) {
                    SettingQTPenContainer.this.mFavoriteListManager.setCurrentPenInfo(index, info, true);
                } else {
                    Logger.m11003i(SettingQTPenContainer.TAG, "Not Supported.");
                }
            }
        });
        SettingQTPenLayout settingQTPenLayout5 = this.mPenLayout;
        if (settingQTPenLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            settingQTPenLayout3 = settingQTPenLayout5;
        }
        settingQTPenLayout3.setPaletteActionButtonListener(new OnActionButtonListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer.initView.3
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
            public void onButtonClick(int type) {
                SpenSettingQTPenContainer.PaletteActionButtonListener paletteActionButtonListener = SettingQTPenContainer.this.mPaletteActionButtonListener;
                if (paletteActionButtonListener != null) {
                    paletteActionButtonListener.onButtonClick(SettingQTPenContainer.this.getMMode(), type);
                }
            }
        });
    }

    public static /* synthetic */ void onModeChanged$default(SettingQTPenContainer settingQTPenContainer, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        settingQTPenContainer.onModeChanged(i, z);
    }

    private final void setModeVisibility(SettingQTLayout.AnimationType type, final SpenSettingQTPenContainer.VisibilityChangedListener listener) {
        SettingQTLayout.AnimationEndListener animationEndListener = new SettingQTLayout.AnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer$setModeVisibility$callback$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout.AnimationEndListener
            public void onAnimationEnd(SettingQTLayout.AnimationType type2) {
                Intrinsics.checkNotNullParameter(type2, "type");
                if (type2 == SettingQTLayout.AnimationType.CLOSE) {
                    this.this$0.setVisibility(8);
                }
                SpenSettingQTPenContainer.VisibilityChangedListener visibilityChangedListener = listener;
                if (visibilityChangedListener != null) {
                    visibilityChangedListener.onCompleted();
                }
            }
        };
        int i = this.mMode;
        if (i == 0 || i == 1) {
            SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
            if (settingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                settingQTLayout = settingQTPenLayout;
            }
            settingQTLayout.startAnimation(type, animationEndListener);
            return;
        }
        if (i != 2) {
            return;
        }
        View view = this.mCustomModeView;
        settingQTLayout = view instanceof SettingQTLayout ? (SettingQTLayout) view : null;
        if (settingQTLayout != null) {
            settingQTLayout.startAnimation(type, animationEndListener);
        }
    }

    public static /* synthetic */ void setViewMode$default(SettingQTPenContainer settingQTPenContainer, SettingQTPenLayout.ViewMode viewMode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        settingQTPenContainer.setViewMode(viewMode, z, z2, z3);
    }

    public final void changeMode(int mode) {
        Logger.m11003i(TAG, "changeMode() mode=" + mode + " supportCustomMode=" + this.mSupportCustomMode);
        if (mode == 2 && (!this.mSupportCustomMode || this.mCustomModeView == null)) {
            Logger.m11003i(TAG, "not support mode.");
        } else if (this.mMode == mode) {
            Logger.m11003i(TAG, "same mode.");
        } else {
            changeView$default(this, mode, false, false, 4, null);
            this.mMode = mode;
        }
    }

    public final void close() {
        this.mPaletteList.clear();
        this.mRecentColors.clear();
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.close();
        this.mCustomModeView = null;
        this.mPaletteActionButtonListener = null;
        this.mPenListManager.close();
        this.mFavoriteListManager.close();
    }

    public final void collapse() {
        View view = this.mCustomModeView;
        SettingQTPenLayout settingQTPenLayout = null;
        SettingQTLayout settingQTLayout = view instanceof SettingQTLayout ? (SettingQTLayout) view : null;
        if (settingQTLayout != null) {
            settingQTLayout.toggle(8, true);
        }
        SettingQTPenLayout settingQTPenLayout2 = this.mPenLayout;
        if (settingQTPenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            settingQTPenLayout = settingQTPenLayout2;
        }
        settingQTPenLayout.toggle(8, true);
    }

    public final int getMMode() {
        return this.mMode;
    }

    @NotNull
    public final SpenSettingQTPenContainer.RotationType getRotationType() {
        return this.rotationType;
    }

    @NotNull
    public final SettingQTPenLayout.ViewMode getViewMode() {
        return this.viewMode;
    }

    public final boolean isScrollAt(float x, float y2) {
        float dimension = getResources().getDimension(C9086R.dimen.qt_docking_pen_list_width) * 0.5f;
        float f = x - dimension;
        float f4 = y2 - dimension;
        return ((float) Math.sqrt((double) ((f4 * f4) + (f * f)))) > getResources().getDimension(C9086R.dimen.qt_circle_layout_height) / ((float) 2);
    }

    public final void onModeChanged(int mode, boolean openPenList) {
        changeView(mode, true, openPenList);
        this.mMode = mode;
    }

    public final void setColorTheme(int theme) {
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.setColorTheme(theme);
    }

    public final void setCustomMode(int resourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setCustomMode(resourceId, resourceId, description, view);
    }

    public final void setEyedropperEnabled(boolean enabled) {
        if (this.supportEyedropper == enabled) {
            return;
        }
        this.supportEyedropper = enabled;
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.setEyedropperEnabled(enabled);
    }

    public final void setFavoriteInfoChangedListener(@Nullable SpenSettingQTPenContainer.PenInfoChangedListener listener) {
        this.mFavoriteListManager.setPenInfoChangedListener(listener);
    }

    public final boolean setFavoriteList(@NotNull List<? extends SpenSettingUIPenInfo> list, int selectedIndex) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (selectedIndex >= list.size()) {
            AbstractC14516b.m15114b(selectedIndex, list.size(), "invalid index ", " size=", TAG);
            return false;
        }
        int penInfoList = this.mFavoriteListManager.setPenInfoList(list, selectedIndex);
        int size = list.size();
        AbstractC8014b.m7195A(AbstractC0622a.m1173s(size, selectedIndex, "setFavoriteList() size=", " index=", ", mode="), TAG, this.mMode);
        if (penInfoList != 0 && this.mMode == 1) {
            SettingQTPenLayout settingQTPenLayout = null;
            if (penInfoList == 2) {
                SettingQTPenLayout settingQTPenLayout2 = this.mPenLayout;
                if (settingQTPenLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                } else {
                    settingQTPenLayout = settingQTPenLayout2;
                }
                settingQTPenLayout.setInfo(getCurrentPenInfo(1), getCurrentPenIndex(1));
                return true;
            }
            SettingQTPenLayout settingQTPenLayout3 = this.mPenLayout;
            if (settingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                settingQTPenLayout = settingQTPenLayout3;
            }
            settingQTPenLayout.setPenInfoList(list, getCurrentPenIndex(1));
        }
        return true;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setPalette(@Nullable List<Integer> paletteList) {
        if (Intrinsics.areEqual(paletteList, this.mPaletteList)) {
            Logger.m11003i(TAG, "same palette. skip update.");
            return;
        }
        this.mPaletteList.clear();
        List<Integer> list = this.mPaletteList;
        if (paletteList == null) {
            paletteList = CollectionsKt.emptyList();
        }
        list.addAll(paletteList);
        if (this.mMode != 2) {
            SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
            if (settingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                settingQTPenLayout = null;
            }
            settingQTPenLayout.setPaletteList(this.mPaletteList);
        }
    }

    public final void setPaletteActionButtonListener(@NotNull SpenSettingQTPenContainer.PaletteActionButtonListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPaletteActionButtonListener = listener;
    }

    public final boolean setPenInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        int iFindPenIndex = this.mPenListManager.findPenIndex(info.name);
        if (iFindPenIndex == -1) {
            AbstractC8014b.m7197C("not exist pen name=", info.name, TAG);
            return false;
        }
        if (!this.mPenListManager.setCurrentPenInfo(iFindPenIndex, info, false)) {
            Logger.m11003i(TAG, "Need Check. setPenInfo() fail.");
            return false;
        }
        if (this.mMode != 0) {
            return true;
        }
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.setInfo(info, iFindPenIndex);
        return true;
    }

    public final void setPenInfoChangedListener(@Nullable SpenSettingQTPenContainer.PenInfoChangedListener listener) {
        this.mPenListManager.setPenInfoChangedListener(listener);
    }

    public final boolean setPenInfoList(@NotNull List<? extends SpenSettingUIPenInfo> uiInfoList, int currentPenIndex) {
        Intrinsics.checkNotNullParameter(uiInfoList, "uiInfoList");
        AbstractC14516b.m15114b(uiInfoList.size(), this.mMode, "setPenInfoList() size=", " mode=", TAG);
        if (!this.mPenListManager.isValidIndex(uiInfoList, currentPenIndex)) {
            AbstractC14516b.m15114b(currentPenIndex, uiInfoList.size(), "invalid index ", " size=", TAG);
            return false;
        }
        int penInfoList = this.mPenListManager.setPenInfoList(uiInfoList, currentPenIndex);
        if (penInfoList != 0 && this.mMode == 0) {
            SettingQTPenLayout settingQTPenLayout = null;
            if (penInfoList == 2) {
                SettingQTPenLayout settingQTPenLayout2 = this.mPenLayout;
                if (settingQTPenLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                } else {
                    settingQTPenLayout = settingQTPenLayout2;
                }
                settingQTPenLayout.setInfo(this.mPenListManager.getCurrentPenInfo(), currentPenIndex);
                return true;
            }
            SettingQTPenLayout settingQTPenLayout3 = this.mPenLayout;
            if (settingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                settingQTPenLayout = settingQTPenLayout3;
            }
            settingQTPenLayout.setPenInfoList(uiInfoList, currentPenIndex);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        List<SpenHSVColor> list;
        Iterator<T> it;
        if (recentList != null && recentList.size() == this.mRecentColors.size()) {
            List<SpenHSVColor> list2 = this.mRecentColors;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                list = recentList;
                if (list instanceof Collection) {
                }
                it = list.iterator();
                while (it.hasNext()) {
                }
                Logger.m11003i(TAG, "same recent color list. skip update.");
                return;
            }
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!recentList.contains((SpenHSVColor) it2.next())) {
                    break;
                }
            }
            list = recentList;
            if ((list instanceof Collection) || !list.isEmpty()) {
                it = list.iterator();
                while (it.hasNext()) {
                    if (!this.mRecentColors.contains((SpenHSVColor) it.next())) {
                    }
                }
            }
            Logger.m11003i(TAG, "same recent color list. skip update.");
            return;
        }
        this.mRecentColors.clear();
        if (recentList != null) {
            this.mRecentColors.addAll(recentList);
        }
        if (this.mMode != 2) {
            SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
            if (settingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                settingQTPenLayout = null;
            }
            settingQTPenLayout.setRecentColor(this.mRecentColors);
        }
    }

    public final void setRotation(@NotNull SpenSettingQTPenContainer.RotationType rotationType) {
        Intrinsics.checkNotNullParameter(rotationType, "rotationType");
        if (this.rotationType == rotationType) {
            return;
        }
        this.rotationType = rotationType;
        setRotationY(rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING ? 0.0f : 180.0f);
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.setRotation(rotationType);
        setRotation(this, getRotationY());
    }

    public final void setRotationType(@NotNull SpenSettingQTPenContainer.RotationType rotationType) {
        Intrinsics.checkNotNullParameter(rotationType, "<set-?>");
        this.rotationType = rotationType;
    }

    public final void setViewMode(@NotNull SettingQTPenLayout.ViewMode mode, boolean animation, boolean notify, boolean forceUpdate) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        settingQTPenLayout.setViewMode(mode, animation, notify, forceUpdate);
    }

    public final boolean setVisibilityWithAnimation(int visibility, @Nullable SpenSettingQTPenContainer.VisibilityChangedListener listener) {
        if (visibility == 0) {
            setVisibility(0);
            setModeVisibility(SettingQTLayout.AnimationType.OPEN, listener);
            return true;
        }
        if (visibility != 8) {
            setVisibility(visibility);
            return true;
        }
        setModeVisibility(SettingQTLayout.AnimationType.CLOSE, listener);
        return true;
    }

    public final void updateColor() {
        SettingQTPenLayout settingQTPenLayout = this.mPenLayout;
        if (settingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            settingQTPenLayout = null;
        }
        SettingQTPenLayout.updateColor$default(settingQTPenLayout, false, 1, null);
    }

    public final void setCustomMode(int unselectedResourceId, int selectedResourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        addView(view);
        this.mCustomModeView = view;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void setRotation(View view, float degrees) {
        if (!(view instanceof ImageView) && !(view instanceof TextView)) {
            if (view instanceof ViewGroup) {
                Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                while (it.hasNext()) {
                    setRotation(it.next(), degrees);
                }
                return;
            }
            return;
        }
        view.setRotationY(degrees);
    }
}
