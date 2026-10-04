package com.samsung.android.sdk.pen.setting.quicktool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.widget.RunnableC2503c;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b#*\u0001u\b\u0007\u0018\u0000 \u008d\u00012\u00020\u0001:\u0014\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fJ\b\u00105\u001a\u000206H\u0016J\u000e\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\bJ \u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0019J*\u00109\u001a\u0002062\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0019H\u0007J7\u00109\u001a\u0002062\u0006\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010@\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020\u001bH\u0016J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\bH\u0016J\u0016\u0010F\u001a\u0002062\u0006\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u000200J\u0006\u0010G\u001a\u000206J\u001a\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010JH\u0016J\u000e\u0010K\u001a\u0002062\u0006\u0010C\u001a\u00020(J\u0016\u0010L\u001a\u0002062\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010NJ\u0016\u0010O\u001a\u0002062\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J\u000e\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\u0005J\u001c\u0010S\u001a\u00020\u00052\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0N2\u0006\u0010V\u001a\u00020\bJ\u000e\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020UJ\u0010\u0010Y\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010ZJ\u001c\u0010[\u001a\u00020\u00052\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020U0N2\u0006\u0010]\u001a\u00020\bJ\u0010\u0010^\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010ZJ\u0010\u0010_\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u000102J\u0016\u0010`\u001a\u0002062\u0006\u0010a\u001a\u00020\"2\u0006\u0010b\u001a\u00020\u0005J\u0018\u0010c\u001a\u0002062\u0006\u0010d\u001a\u00020e2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u0018\u0010f\u001a\u0002062\u0006\u0010d\u001a\u00020e2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u0018\u0010g\u001a\u0002062\u0006\u0010a\u001a\u00020\"2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u0012\u0010h\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010*H\u0007J\u0010\u0010i\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010,J\u0010\u0010j\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010.J\u000e\u0010k\u001a\u0002062\u0006\u0010C\u001a\u000204J\u0018\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020nH\u0007J\u0012\u0010s\u001a\u00020\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010rJ\u0018\u0010w\u001a\u0002062\u0006\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u0005H\u0002J \u0010z\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010{\u001a\u0002062\u0006\u0010|\u001a\u00020UH\u0002J\b\u0010}\u001a\u000206H\u0002J\b\u0010~\u001a\u000206H\u0002J\u0010\u0010\u007f\u001a\u0002062\u0006\u0010E\u001a\u00020\bH\u0002J\u0019\u0010\u0080\u0001\u001a\u0002062\u0006\u0010E\u001a\u00020\b2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u001a\u0010\u0081\u0001\u001a\u0002062\u0007\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u001a\u0010\u0083\u0001\u001a\u0002062\u0007\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u0013\u0010\u0084\u0001\u001a\u0004\u0018\u00010U2\u0006\u0010E\u001a\u00020\bH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bH\u0002J\u001f\u0010\u0086\u0001\u001a\u0002062\u0006\u0010E\u001a\u00020\b2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020U0\u0010H\u0002J\u0011\u0010\u0087\u0001\u001a\u0002062\u0006\u0010I\u001a\u00020\bH\u0002J\u0014\u0010\u0089\u0001\u001a\u0002062\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010UH\u0002J\u0014\u0010\u008b\u0001\u001a\u00020\u00052\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010UH\u0002J\t\u0010\u008c\u0001\u001a\u000206H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u00020uX\u0082\u0004¢\u0006\u0004\n\u0002\u0010vR\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer;", "context", "Landroid/content/Context;", "supportEyedropper", "", "supportCustomMode", "maxFavoriteCount", "", "<init>", "(Landroid/content/Context;ZZI)V", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;ZZ)V", "mPenLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout;", "mPaletteList", "", "mRecentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "mPenListManager", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListManager;", "mFavoriteListManager", "mIsSupportEyedropper", "mSupportCustomMode", "mCustomModeView", "Landroid/view/View;", "mModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeChangedListener;", "mMode", "value", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "viewMode", "getViewMode", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "rotationType", "getRotationType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "mForceModeChange", "mPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PaletteActionButtonListener;", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnButtonClickListener;", "mAddButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnAddButtonClickListener;", "mMainViewActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnMainViewActionListener;", "mModeAccessEventListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnModeAccessEventListener;", "mFavoriteListActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnFavoriteListActionListener;", "mViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$OnViewModeChangedListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setCustomMode", "resourceId", "description", "", "view", "unselectedResourceId", "selectedResourceId", "switchColor", "(Landroid/view/View;IILjava/lang/CharSequence;Ljava/lang/Integer;)V", "setOnModeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "changeMode", "mode", "restrictModeAccess", "clearModeAccess", "setVisibilityWithAnimation", "visibility", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnVisibilityAnimationListener;", "setPaletteActionButtonListener", "setPalette", "paletteList", "", "setRecentColor", "recentList", "setEyedropperEnabled", "enabled", "setPenInfoList", "uiInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "currentPenIndex", "setPenInfo", "info", "setPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PenInfoChangedListener;", "setFavoriteList", XmlErrorCodes.LIST, "selectedIndex", "setFavoriteInfoChangedListener", "setFavoriteListActionListener", "setRotation", "type", "animation", "setDockingMode", "state", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingState;", "setCustomViewDockingMode", "setSwitchDockingMode", "setOnButtonClickListener", "setOnAddButtonClickListener", "setOnMainViewActionListener", "setViewModeChangedListener", "isScrollAt", "rawX", "", "rawY", "mIsAnimatingChangeViewModeToMain", "mChangeViewModeToMainAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnAnimationListener;", "changeViewModeToMainWithAnimation", "mChangeViewModeToMainListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$mChangeViewModeToMainListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$mChangeViewModeToMainListener$1;", "callAnimationListener", "isCalledStartListener", "isCalledEndListener", "initView", "sendFavoriteToPenInfo", "favoriteInfo", "performModeChangeIfNeeded", "performModeChangeToMain", "changeSwitch", "changeView", "togglePenView", "nextVisibility", "toggleCustomView", "getCurrentPenInfo", "getCurrentPenIndex", "getCurrentPenList", "startModeViewAnimation", "mInnerChangedPenInfo", "setInnerChangedFavoriteInfo", "penInfo", "isChangedFavoritePenInfo", "changeFavoriteToCurrent", "Companion", "RotationType", "PenInfoChangedListener", "PaletteActionButtonListener", "VisibilityChangedListener", "OnButtonClickListener", "OnAddButtonClickListener", "OnMainViewActionListener", "OnModeAccessEventListener", "OnFavoriteListActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSpenSettingQTPenContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingQTPenContainer.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,719:1\n1726#2,3:720\n*S KotlinDebug\n*F\n+ 1 SpenSettingQTPenContainer.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer\n*L\n220#1:720,3\n*E\n"})
public final class SpenSettingQTPenContainer extends SpenSettingQTContainer {
    public static final int MODE_CUSTOM = 2;
    public static final int MODE_FAVORITE = 1;
    public static final int MODE_PEN = 0;

    @NotNull
    private static final String TAG = "SpenSettingQTPenContainer";

    @Nullable
    private OnAddButtonClickListener mAddButtonClickListener;

    @Nullable
    private OnButtonClickListener mButtonClickListener;

    @Nullable
    private OnAnimationListener mChangeViewModeToMainAnimationListener;

    @NotNull
    private final SpenSettingQTPenContainer$mChangeViewModeToMainListener$1 mChangeViewModeToMainListener;

    @Nullable
    private View mCustomModeView;

    @Nullable
    private OnFavoriteListActionListener mFavoriteListActionListener;

    @NotNull
    private final SpenQTPenListManager mFavoriteListManager;
    private boolean mForceModeChange;

    @Nullable
    private SpenSettingUIPenInfo mInnerChangedPenInfo;
    private boolean mIsAnimatingChangeViewModeToMain;
    private boolean mIsSupportEyedropper;

    @Nullable
    private OnMainViewActionListener mMainViewActionListener;
    private int mMode;

    @Nullable
    private OnModeAccessEventListener mModeAccessEventListener;

    @Nullable
    private SpenSettingQTContainer.OnModeChangedListener mModeChangedListener;

    @Nullable
    private PaletteActionButtonListener mPaletteActionButtonListener;

    @NotNull
    private final List<Integer> mPaletteList;
    private SpenSettingQTPenLayout mPenLayout;

    @NotNull
    private final SpenQTPenListManager mPenListManager;

    @NotNull
    private final List<SpenHSVColor> mRecentColors;
    private boolean mSupportCustomMode;

    @Nullable
    private SpenSettingQTPenLayout.OnViewModeChangedListener mViewModeChangedListener;

    @NotNull
    private RotationType rotationType;

    @NotNull
    private SpenSettingQTPenLayout.ViewMode viewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnAddButtonClickListener;", "", "onAddButtonClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAddButtonClickListener {
        void onAddButtonClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "")
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnButtonClickListener;", "", "onAddButtonClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnButtonClickListener {
        void onAddButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnFavoriteListActionListener;", "", "onItemSelected", "", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnFavoriteListActionListener {
        void onItemSelected(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnMainViewActionListener;", "", "onPenClicked", "", "mode", "", "penName", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnMainViewActionListener {
        void onPenClicked(int mode, @NotNull String penName);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnModeAccessEventListener;", "", "onModeBlocked", "", "onModeChangeStart", "mode", "", "onModeChangedEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeAccessEventListener {
        void onModeBlocked();

        void onModeChangeStart(int mode);

        void onModeChangedEnd(int mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PaletteActionButtonListener;", "", "onButtonClick", "", "mode", "", "type", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PaletteActionButtonListener {
        public static final int BUTTON_TYPE_EYEDROPPER = 2;
        public static final int BUTTON_TYPE_PICKER = 1;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PaletteActionButtonListener$Companion;", "", "<init>", "()V", "BUTTON_TYPE_PICKER", "", "BUTTON_TYPE_EYEDROPPER", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BUTTON_TYPE_EYEDROPPER = 2;
            public static final int BUTTON_TYPE_PICKER = 1;

            private Companion() {
            }
        }

        void onButtonClick(int mode, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PenInfoChangedListener;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenInfoChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PenInfoChangedListener extends SpenSettingQTPenInfoChangedListener {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "LEFT_DOCKING", "RIGHT_DOCKING", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RotationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RotationType[] $VALUES;
        public static final RotationType NONE = new RotationType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final RotationType LEFT_DOCKING = new RotationType("LEFT_DOCKING", 1);
        public static final RotationType RIGHT_DOCKING = new RotationType("RIGHT_DOCKING", 2);

        private static final /* synthetic */ RotationType[] $values() {
            return new RotationType[]{NONE, LEFT_DOCKING, RIGHT_DOCKING};
        }

        static {
            RotationType[] rotationTypeArr$values = $values();
            $VALUES = rotationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(rotationTypeArr$values);
        }

        private RotationType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RotationType> getEntries() {
            return $ENTRIES;
        }

        public static RotationType valueOf(String str) {
            return (RotationType) Enum.valueOf(RotationType.class, str);
        }

        public static RotationType[] values() {
            return (RotationType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$VisibilityChangedListener;", "", "onCompleted", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface VisibilityChangedListener {
        void onCompleted();
    }

    public /* synthetic */ SpenSettingQTPenContainer(Context context, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 45 : i);
    }

    private final void callAnimationListener(boolean isCalledStartListener, boolean isCalledEndListener) {
        if (this.mChangeViewModeToMainAnimationListener == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new RunnableC2503c(isCalledStartListener, this, isCalledEndListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callAnimationListener$lambda$3(boolean z, SpenSettingQTPenContainer spenSettingQTPenContainer, boolean z2) {
        if (z) {
            spenSettingQTPenContainer.mChangeViewModeToMainListener.onAnimationStart();
        }
        if (z2) {
            spenSettingQTPenContainer.mChangeViewModeToMainListener.onAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeFavoriteToCurrent() {
        AbstractC2322a.m1631u(this.mFavoriteListManager.getMCurrentIndex(), "changeFavoriteToCurrent() current=", TAG);
        if (this.mFavoriteListManager.getMCurrentIndex() == -1) {
            this.mFavoriteListManager.setCurrentPen(0, true);
        }
    }

    private final void changeSwitch(int mode) {
        AbstractC2322a.m1631u(mode, "changeSwitch() mode=", TAG);
        if (mode == 2 && !this.mSupportCustomMode) {
            Log.i(TAG, "not support mode.");
        } else if (this.mMode == mode) {
            Log.i(TAG, "same mode.");
        } else {
            super.changeMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeView(int mode, boolean animation) {
        AbstractC0000a.m27x(AbstractC0622a.m1173s(this.mMode, mode, "changeView() mode[", " -> ", "] animation="), animation, TAG);
        boolean z = false;
        if (mode == 2) {
            toggleCustomView(0, animation);
            togglePenView(8, animation);
            return;
        }
        boolean z2 = animation && this.mMode != 2;
        toggleCustomView(8, animation);
        togglePenView(0, false);
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        SpenSettingQTPenLayout spenSettingQTPenLayout2 = null;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.setPaletteList(this.mPaletteList);
        SpenSettingQTPenLayout spenSettingQTPenLayout3 = this.mPenLayout;
        if (spenSettingQTPenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout3 = null;
        }
        spenSettingQTPenLayout3.setRecentColor(this.mRecentColors);
        ArrayList arrayList = new ArrayList();
        getCurrentPenList(mode, arrayList);
        SpenSettingQTPenLayout spenSettingQTPenLayout4 = this.mPenLayout;
        if (spenSettingQTPenLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout4 = null;
        }
        spenSettingQTPenLayout4.setAddButtonInPenList$SDK_fullRelease(mode == 1);
        SpenSettingQTPenLayout spenSettingQTPenLayout5 = this.mPenLayout;
        if (spenSettingQTPenLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout5 = null;
        }
        spenSettingQTPenLayout5.setPenInfoList$SDK_fullRelease(arrayList, getCurrentPenIndex(mode), z2);
        SpenSettingQTPenLayout spenSettingQTPenLayout6 = this.mPenLayout;
        if (spenSettingQTPenLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            spenSettingQTPenLayout2 = spenSettingQTPenLayout6;
        }
        if (mode == 1 && this.mFavoriteListActionListener != null) {
            z = true;
        }
        spenSettingQTPenLayout2.requestDisallowModeChangeInPenList$SDK_fullRelease(z);
    }

    public static /* synthetic */ boolean changeViewModeToMainWithAnimation$default(SpenSettingQTPenContainer spenSettingQTPenContainer, OnAnimationListener onAnimationListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onAnimationListener = null;
        }
        return spenSettingQTPenContainer.changeViewModeToMainWithAnimation(onAnimationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentPenIndex(int mode) {
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
        AbstractC2322a.m1631u(this.mFavoriteListManager.getPenInfoCount(), "favorite count=", TAG);
        if (this.mFavoriteListManager.getPenInfoCount() > 0) {
            return this.mFavoriteListManager.getPenInfo(0);
        }
        return null;
    }

    private final void getCurrentPenList(int mode, List<SpenSettingUIPenInfo> list) {
        (mode == 0 ? this.mPenListManager : this.mFavoriteListManager).getPenInfoList(list);
    }

    private final void initView(Context context, boolean supportEyedropper, int maxFavoriteCount) {
        addViewBehindSwitch$SDK_fullRelease(new View(context), new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_width), context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_size)));
        super.setMode(0, C7932R.drawable.qt_ic_pen, C7932R.drawable.qt_ic_pen_selected, context.getResources().getString(C7932R.string.pen_string_qtool_pen_settings), null);
        super.setMode(1, C7932R.drawable.qt_ic_favorite_pen, C7932R.drawable.qt_ic_favorite_pen_selected, context.getResources().getString(C7932R.string.pen_string_favorite_pens), null);
        SpenSettingQTPenLayout spenSettingQTPenLayout = new SpenSettingQTPenLayout(context, supportEyedropper, maxFavoriteCount);
        this.mPenLayout = spenSettingQTPenLayout;
        spenSettingQTPenLayout.setCurvedSwitchLayout$SDK_fullRelease(getSwitchView$SDK_fullRelease());
        SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
        SpenSettingQTPenLayout spenSettingQTPenLayout3 = null;
        if (spenSettingQTPenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout2 = null;
        }
        addViewBehindSwitch(spenSettingQTPenLayout2);
        super.setOnModeChangedListener(new SpenSettingQTContainer.OnModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer.OnModeChangedListener
            public void onModeChanged(int mode) {
                SpenSettingQTPenContainer.this.changeView(mode, true);
                SpenSettingQTPenContainer.this.mMode = mode;
                SpenSettingQTPenContainer.this.setInnerChangedFavoriteInfo(null);
                if (SpenSettingQTPenContainer.this.mMode == 1) {
                    SpenSettingQTPenContainer.this.changeFavoriteToCurrent();
                }
                SpenSettingQTContainer.OnModeChangedListener onModeChangedListener = SpenSettingQTPenContainer.this.mModeChangedListener;
                if (onModeChangedListener != null) {
                    onModeChangedListener.onModeChanged(mode);
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout4 = this.mPenLayout;
        if (spenSettingQTPenLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout4 = null;
        }
        spenSettingQTPenLayout4.setViewModeChangedListener(new SpenSettingQTPenLayout.OnViewModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnViewModeChangedListener
            public void onViewModeChanged(SpenSettingQTPenLayout.ViewMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Log.i(SpenSettingQTPenContainer.TAG, "onViewModeChanged() mode=" + SpenSettingQTPenContainer.this.mMode + ", viewMode=" + mode);
                SpenSettingQTPenContainer.this.viewMode = mode;
                SpenSettingQTPenContainer.this.performModeChangeToMain();
                SpenSettingQTPenLayout.OnViewModeChangedListener onViewModeChangedListener = SpenSettingQTPenContainer.this.mViewModeChangedListener;
                if (onViewModeChangedListener != null) {
                    onViewModeChangedListener.onViewModeChanged(mode);
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout5 = this.mPenLayout;
        if (spenSettingQTPenLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout5 = null;
        }
        spenSettingQTPenLayout5.setPenInfoChangedListener(new SpenSettingQTPenInfoChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.3
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener
            public void onPenInfoChanged(int index, SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                int i = SpenSettingQTPenContainer.this.mMode;
                SpenSettingQTPenLayout.ViewMode viewMode = SpenSettingQTPenContainer.this.getViewMode();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, index, "onPenInfoChanged() mode=", " index=", " info=");
                sbM1173s.append(info);
                sbM1173s.append(" viewMode=");
                sbM1173s.append(viewMode);
                Log.i(SpenSettingQTPenContainer.TAG, sbM1173s.toString());
                if (SpenSettingQTPenContainer.this.mMode == 0) {
                    SpenSettingQTPenContainer.this.mPenListManager.setCurrentPenInfo(index, info, true);
                    return;
                }
                if (SpenSettingQTPenContainer.this.mMode != 1) {
                    Log.i(SpenSettingQTPenContainer.TAG, "Not Supported.");
                    return;
                }
                if (SpenSettingQTPenContainer.this.getCurrentPenIndex(1) != index) {
                    Log.i(SpenSettingQTPenContainer.TAG, "Change selected favorite index");
                    SpenSettingQTPenContainer.this.mFavoriteListManager.setCurrentPen(index, true);
                } else {
                    Log.i(SpenSettingQTPenContainer.TAG, "Not change favorite index. change attribute only");
                    SpenSettingQTPenContainer.this.setInnerChangedFavoriteInfo(info);
                    SpenSettingQTPenContainer.this.sendFavoriteToPenInfo(info);
                    SpenSettingQTPenContainer.this.performModeChangeIfNeeded();
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout6 = this.mPenLayout;
        if (spenSettingQTPenLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout6 = null;
        }
        spenSettingQTPenLayout6.setPaletteActionButtonListener(new OnActionButtonListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.4
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
            public void onButtonClick(int type) {
                PaletteActionButtonListener paletteActionButtonListener = SpenSettingQTPenContainer.this.mPaletteActionButtonListener;
                if (paletteActionButtonListener != null) {
                    paletteActionButtonListener.onButtonClick(SpenSettingQTPenContainer.this.mMode, type);
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout7 = this.mPenLayout;
        if (spenSettingQTPenLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout7 = null;
        }
        spenSettingQTPenLayout7.setOnAddButtonClickListener(new SpenSettingQTPenLayout.OnAddButtonClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.5
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnAddButtonClickListener
            public void onAddButtonClicked() {
                OnAddButtonClickListener onAddButtonClickListener = SpenSettingQTPenContainer.this.mAddButtonClickListener;
                if (onAddButtonClickListener != null) {
                    onAddButtonClickListener.onAddButtonClicked();
                }
                OnButtonClickListener onButtonClickListener = SpenSettingQTPenContainer.this.mButtonClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onAddButtonClick();
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout8 = this.mPenLayout;
        if (spenSettingQTPenLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout8 = null;
        }
        spenSettingQTPenLayout8.setOnMainViewActionListener$SDK_fullRelease(new SpenSettingQTPenLayout.OnMainViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.6
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnMainViewActionListener
            public void onPenClicked(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                Log.i(SpenSettingQTPenContainer.TAG, "onPenClicked() mode=" + SpenSettingQTPenContainer.this.mMode + " viewMode=" + SpenSettingQTPenContainer.this.getViewMode());
                OnMainViewActionListener onMainViewActionListener = SpenSettingQTPenContainer.this.mMainViewActionListener;
                if (onMainViewActionListener != null) {
                    onMainViewActionListener.onPenClicked(SpenSettingQTPenContainer.this.mMode, name);
                }
            }
        });
        SpenSettingQTPenLayout spenSettingQTPenLayout9 = this.mPenLayout;
        if (spenSettingQTPenLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            spenSettingQTPenLayout3 = spenSettingQTPenLayout9;
        }
        spenSettingQTPenLayout3.setOnViewActionListener$SDK_fullRelease(new SpenSettingQTPenLayout.OnViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.initView.7
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnViewActionListener
            public void onColorPickerTapped() {
                AbstractC2322a.m1631u(SpenSettingQTPenContainer.this.mMode, "onPaletteColorClicked() mode=", SpenSettingQTPenContainer.TAG);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnViewActionListener
            public void onPaletteColorClicked() {
                AbstractC2322a.m1631u(SpenSettingQTPenContainer.this.mMode, "onPaletteColorClicked() mode=", SpenSettingQTPenContainer.TAG);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnViewActionListener
            public void onPenListItemClicked(int position, boolean selected) {
                if (SpenSettingQTPenContainer.this.mMode == 1) {
                    if (SpenSettingQTPenContainer.this.mFavoriteListManager.getMCurrentIndex() == -1) {
                        AbstractC11014a.m12328m(position, "Changed Selected Favorite item. [-1 -> ", "]", SpenSettingQTPenContainer.TAG);
                        SpenSettingQTPenContainer.this.mFavoriteListManager.setCurrentPen(position, true);
                        SpenSettingQTPenContainer.this.setInnerChangedFavoriteInfo(null);
                    }
                    OnFavoriteListActionListener onFavoriteListActionListener = SpenSettingQTPenContainer.this.mFavoriteListActionListener;
                    if (onFavoriteListActionListener != null) {
                        onFavoriteListActionListener.onItemSelected(position);
                    }
                }
            }
        });
    }

    private final boolean isChangedFavoritePenInfo(SpenSettingUIPenInfo penInfo) {
        if (this.mInnerChangedPenInfo == null) {
            return false;
        }
        if (penInfo == null) {
            return true;
        }
        return !Intrinsics.areEqual(penInfo, r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performModeChangeIfNeeded() {
        AbstractC2322a.m1631u(this.mMode, "performModeChangeIfNeeded() mMode=", TAG);
        if (this.mMode != 1) {
            return;
        }
        SpenSettingUIPenInfo currentPenInfo = getCurrentPenInfo(1);
        if (isChangedFavoritePenInfo(currentPenInfo)) {
            Log.i(TAG, "### Change switch to Pen by UX scenario - case2.");
            changeSwitch(0);
            this.mForceModeChange = true;
            performModeChangeToMain();
        } else if (this.mFavoriteListManager.getMCurrentIndex() == -1 && currentPenInfo != null) {
            sendFavoriteToPenInfo(currentPenInfo);
            Log.i(TAG, "### Change switch to Pen by UX scenario - case1.");
            changeSwitch(0);
            this.mForceModeChange = true;
            performModeChangeToMain();
        }
        AbstractC4539a.m3208r("### End performModeChangeIfNeeded() mForceModeChange=", TAG, this.mForceModeChange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performModeChangeToMain() {
        AbstractC4539a.m3208r("performModeChange() = ", TAG, this.mForceModeChange);
        if (this.mForceModeChange) {
            this.mForceModeChange = false;
            ArrayList arrayList = new ArrayList();
            getCurrentPenList(0, arrayList);
            SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
            if (spenSettingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout = null;
            }
            spenSettingQTPenLayout.setAddButtonInPenList$SDK_fullRelease(false);
            SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
            if (spenSettingQTPenLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout2 = null;
            }
            spenSettingQTPenLayout2.setPenInfoList(arrayList, getCurrentPenIndex(0));
            SpenSettingQTPenLayout spenSettingQTPenLayout3 = this.mPenLayout;
            if (spenSettingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout3 = null;
            }
            spenSettingQTPenLayout3.requestDisallowModeChangeInPenList$SDK_fullRelease(false);
            this.mMode = 0;
            setInnerChangedFavoriteInfo(null);
            SpenSettingQTContainer.OnModeChangedListener onModeChangedListener = this.mModeChangedListener;
            if (onModeChangedListener != null) {
                onModeChangedListener.onModeChanged(this.mMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendFavoriteToPenInfo(SpenSettingUIPenInfo favoriteInfo) {
        int iFindPenIndex = this.mPenListManager.findPenIndex(favoriteInfo.name);
        if (iFindPenIndex == -1) {
            AbstractC6670b.m4756q("not exist pen name=", favoriteInfo.name, TAG);
        } else {
            this.mPenListManager.setCurrentPenInfo(iFindPenIndex, favoriteInfo, true);
        }
    }

    private final void setCustomViewDockingMode(SpenSettingQTLayout.DockingState state, boolean animation) {
        if (this.mSupportCustomMode) {
            View view = this.mCustomModeView;
            SpenSettingQTLayout spenSettingQTLayout = view instanceof SpenSettingQTLayout ? (SpenSettingQTLayout) view : null;
            if (spenSettingQTLayout != null) {
                spenSettingQTLayout.setDockingState$SDK_fullRelease(state, animation);
            }
        }
    }

    private final void setDockingMode(SpenSettingQTLayout.DockingState state, boolean animation) {
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.setDockingState$SDK_fullRelease(state, animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInnerChangedFavoriteInfo(SpenSettingUIPenInfo penInfo) {
        this.mInnerChangedPenInfo = penInfo == null ? null : new SpenSettingUIPenInfo(penInfo);
    }

    private final void setSwitchDockingMode(RotationType type, boolean animation) {
        getSwitchView$SDK_fullRelease().setRotation(type == RotationType.LEFT_DOCKING ? -90.0f : type == RotationType.RIGHT_DOCKING ? 90.0f : 0.0f, animation);
    }

    private final void startModeViewAnimation(int visibility) {
        boolean z = visibility == 0;
        int i = this.mMode;
        SpenSettingQTPenLayout spenSettingQTPenLayout = null;
        if (i == 0 || i == 1) {
            SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
            if (spenSettingQTPenLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                spenSettingQTPenLayout = spenSettingQTPenLayout2;
            }
            spenSettingQTPenLayout.startAnimation$SDK_fullRelease(z);
            return;
        }
        if (i != 2) {
            return;
        }
        View view = this.mCustomModeView;
        SpenSettingQTLayout spenSettingQTLayout = view instanceof SpenSettingQTLayout ? (SpenSettingQTLayout) view : null;
        if (spenSettingQTLayout == null) {
            return;
        }
        SpenSettingQTLayout.startAnimation$SDK_fullRelease$default(spenSettingQTLayout, z ? SpenSettingQTLayout.AnimationType.OPEN : SpenSettingQTLayout.AnimationType.CLOSE, null, 2, null);
    }

    private final void toggleCustomView(int nextVisibility, boolean animation) {
        View view = this.mCustomModeView;
        if (view == null) {
            return;
        }
        if (!(view instanceof SpenSettingQTLayout)) {
            AbstractC2322a.m1631u(nextVisibility, "toggleCustomView() directly visibility=", TAG);
            View view2 = this.mCustomModeView;
            if (view2 != null) {
                view2.setVisibility(nextVisibility);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout");
        SpenSettingQTLayout spenSettingQTLayout = (SpenSettingQTLayout) view;
        if (animation) {
            spenSettingQTLayout.startAnimation$SDK_fullRelease(nextVisibility == 0 ? SpenSettingQTLayout.AnimationType.TOGGLE_TO_SHOW : SpenSettingQTLayout.AnimationType.TOGGLE_TO_HIDE, new SpenSettingQTLayout.QTLayoutAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.toggleCustomView.1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationEnd(SpenSettingQTLayout.AnimationType type, boolean canceled) {
                    View view3;
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type != SpenSettingQTLayout.AnimationType.TOGGLE_TO_HIDE || (view3 = SpenSettingQTPenContainer.this.mCustomModeView) == null) {
                        return;
                    }
                    view3.setVisibility(8);
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationStart(SpenSettingQTLayout.AnimationType type) {
                    View view3;
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type != SpenSettingQTLayout.AnimationType.TOGGLE_TO_SHOW || (view3 = SpenSettingQTPenContainer.this.mCustomModeView) == null) {
                        return;
                    }
                    view3.setVisibility(0);
                }
            });
        } else {
            spenSettingQTLayout.setVisibility(nextVisibility);
            spenSettingQTLayout.setBackgroundVisibility$SDK_fullRelease(nextVisibility == 0, false);
        }
    }

    private final void togglePenView(int nextVisibility, boolean animation) {
        SpenSettingQTPenLayout spenSettingQTPenLayout = null;
        if (!animation) {
            SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
            if (spenSettingQTPenLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout2 = null;
            }
            spenSettingQTPenLayout2.setVisibility(nextVisibility);
            SpenSettingQTPenLayout spenSettingQTPenLayout3 = this.mPenLayout;
            if (spenSettingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                spenSettingQTPenLayout = spenSettingQTPenLayout3;
            }
            spenSettingQTPenLayout.setAlpha(1.0f);
            return;
        }
        SpenSettingQTLayout.AnimationType animationType = nextVisibility == 0 ? SpenSettingQTLayout.AnimationType.TOGGLE_TO_SHOW : SpenSettingQTLayout.AnimationType.TOGGLE_TO_HIDE;
        SpenSettingQTPenLayout spenSettingQTPenLayout4 = this.mPenLayout;
        if (spenSettingQTPenLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout4 = null;
        }
        if (spenSettingQTPenLayout4.getVisibility() != 0) {
            SpenSettingQTPenLayout spenSettingQTPenLayout5 = this.mPenLayout;
            if (spenSettingQTPenLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout5 = null;
            }
            spenSettingQTPenLayout5.setVisibility(0);
        }
        SpenSettingQTPenLayout spenSettingQTPenLayout6 = this.mPenLayout;
        if (spenSettingQTPenLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
        } else {
            spenSettingQTPenLayout = spenSettingQTPenLayout6;
        }
        spenSettingQTPenLayout.startAnimation$SDK_fullRelease(animationType, new SpenSettingQTLayout.QTLayoutAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.togglePenView.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
            public void onAnimationEnd(SpenSettingQTLayout.AnimationType type, boolean canceled) {
                Intrinsics.checkNotNullParameter(type, "type");
                if (type == SpenSettingQTLayout.AnimationType.TOGGLE_TO_HIDE) {
                    SpenSettingQTPenLayout spenSettingQTPenLayout7 = SpenSettingQTPenContainer.this.mPenLayout;
                    if (spenSettingQTPenLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                        spenSettingQTPenLayout7 = null;
                    }
                    spenSettingQTPenLayout7.setVisibility(8);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
            public void onAnimationStart(SpenSettingQTLayout.AnimationType type) {
                Intrinsics.checkNotNullParameter(type, "type");
            }
        });
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer
    public void changeMode(int mode) {
        boolean z = this.mSupportCustomMode;
        AbstractC0000a.m27x(AbstractC2821a.m2226q("changeMode() mode=", mode, " supportCustomMode=", z, " isRunning="), getMIsAnimationRunning(), TAG);
        if (mode == 2 && (!this.mSupportCustomMode || this.mCustomModeView == null)) {
            Log.i(TAG, "not support mode.");
            return;
        }
        if (this.mMode == mode) {
            Log.i(TAG, "same mode.");
            return;
        }
        super.changeMode(mode);
        changeView(mode, false);
        this.mMode = mode;
        setInnerChangedFavoriteInfo(null);
    }

    public final boolean changeViewModeToMainWithAnimation(@Nullable OnAnimationListener listener) {
        int i = this.mMode;
        SpenSettingQTPenLayout.ViewMode viewMode = this.viewMode;
        boolean z = this.mIsAnimatingChangeViewModeToMain;
        StringBuilder sb = new StringBuilder("changeViewModeToMain() mMode=");
        sb.append(i);
        sb.append(" viewMode=");
        sb.append(viewMode);
        sb.append(" isAnimating=");
        AbstractC0000a.m27x(sb, z, TAG);
        if (this.mIsAnimatingChangeViewModeToMain) {
            return false;
        }
        this.mChangeViewModeToMainAnimationListener = listener;
        if (this.mMode != 2) {
            SpenSettingQTPenLayout.ViewMode viewMode2 = this.viewMode;
            SpenSettingQTPenLayout.ViewMode viewMode3 = SpenSettingQTPenLayout.ViewMode.MAIN;
            if (viewMode2 != viewMode3) {
                SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
                if (spenSettingQTPenLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                    spenSettingQTPenLayout = null;
                }
                spenSettingQTPenLayout.resetViewModeWithAnimation$SDK_fullRelease(this.mChangeViewModeToMainListener);
                this.viewMode = viewMode3;
                callAnimationListener(true, false);
                return true;
            }
        }
        callAnimationListener(true, true);
        return true;
    }

    public final void clearModeAccess() {
        Log.i(TAG, "clearModeAccess()");
        this.mModeAccessEventListener = null;
        blockSwitchModeAccessOnClick$SDK_fullRelease(null, null);
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer
    public void close() {
        this.mPaletteList.clear();
        this.mRecentColors.clear();
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.close();
        this.mCustomModeView = null;
        this.mModeChangedListener = null;
        this.mViewModeChangedListener = null;
        this.mPaletteActionButtonListener = null;
        this.mPenListManager.close();
        this.mFavoriteListManager.close();
        super.close();
    }

    @NotNull
    public final RotationType getRotationType() {
        return this.rotationType;
    }

    @NotNull
    public final SpenSettingQTPenLayout.ViewMode getViewMode() {
        return this.viewMode;
    }

    @SuppressLint({"UseKtx"})
    public final boolean isScrollAt(float rawX, float rawY) {
        boolean zIsScrollAt;
        if (this.mMode != 2) {
            SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
            if (spenSettingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout = null;
            }
            zIsScrollAt = spenSettingQTPenLayout.isScrollAt(rawX, rawY);
        } else {
            zIsScrollAt = false;
        }
        if (zIsScrollAt) {
            return true;
        }
        if (getSwitchView$SDK_fullRelease().getVisibility() == 0) {
            return getSwitchView$SDK_fullRelease().isScrollAt(rawX, rawY);
        }
        return false;
    }

    public final void restrictModeAccess(int mode, @NotNull OnModeAccessEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Log.i(TAG, "restrictModeAccess() mode=" + mode);
        this.mModeAccessEventListener = listener;
        blockSwitchModeAccessOnClick$SDK_fullRelease(Integer.valueOf(mode), new SpenSettingQTContainer.OnModeBlockedEventListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.restrictModeAccess.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer.OnModeBlockedEventListener
            public void onModeBlocked(int mode2) {
                AbstractC6670b.m4744e(mode2, SpenSettingQTPenContainer.this.mMode, "restrictModeAccess() onModeBlocked mode=", " current=", SpenSettingQTPenContainer.TAG);
                OnModeAccessEventListener onModeAccessEventListener = SpenSettingQTPenContainer.this.mModeAccessEventListener;
                if (onModeAccessEventListener != null) {
                    onModeAccessEventListener.onModeBlocked();
                }
            }
        });
        setOnSwitchDragListener$SDK_fullRelease(new SpenCurvedSwitchLayout.OnSwitchDragListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.restrictModeAccess.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout.OnSwitchDragListener
            public void onDragEnd() {
                AbstractC2322a.m1631u(SpenSettingQTPenContainer.this.mMode, "========== onDragEnd() mode=", SpenSettingQTPenContainer.TAG);
                OnModeAccessEventListener onModeAccessEventListener = SpenSettingQTPenContainer.this.mModeAccessEventListener;
                if (onModeAccessEventListener != null) {
                    onModeAccessEventListener.onModeChangedEnd(SpenSettingQTPenContainer.this.mMode);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout.OnSwitchDragListener
            public void onDragStart() {
                AbstractC2322a.m1631u(SpenSettingQTPenContainer.this.mMode, "========== onDragStart() mode=", SpenSettingQTPenContainer.TAG);
                OnModeAccessEventListener onModeAccessEventListener = SpenSettingQTPenContainer.this.mModeAccessEventListener;
                if (onModeAccessEventListener != null) {
                    onModeAccessEventListener.onModeChangeStart(SpenSettingQTPenContainer.this.mMode);
                }
            }
        });
    }

    public final void setColorTheme(int theme) {
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.setColorTheme(theme);
    }

    public final void setCustomMode(int resourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setCustomMode(view, resourceId, resourceId, description, null);
    }

    public final void setEyedropperEnabled(boolean enabled) {
        Log.i(TAG, "setEyedropperEnabled() [" + this.mIsSupportEyedropper + " -> " + enabled + "]");
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.setEyedropperEnabled(this.mIsSupportEyedropper);
    }

    public final void setFavoriteInfoChangedListener(@Nullable PenInfoChangedListener listener) {
        this.mFavoriteListManager.setPenInfoChangedListener(listener);
    }

    public final boolean setFavoriteList(@NotNull List<? extends SpenSettingUIPenInfo> list, int selectedIndex) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (selectedIndex >= list.size()) {
            AbstractC0000a.m26w(AbstractC0622a.m1173s(selectedIndex, list.size(), "invalid index ", " size=", " selectedIndex="), TAG, selectedIndex);
            return false;
        }
        int penInfoList = this.mFavoriteListManager.setPenInfoList(list, selectedIndex);
        int size = list.size();
        AbstractC0000a.m26w(AbstractC0622a.m1173s(size, selectedIndex, "setFavoriteList() size=", " index=", ", mode="), TAG, this.mMode);
        if (penInfoList != 0 && this.mMode == 1) {
            SpenSettingQTPenLayout spenSettingQTPenLayout = null;
            if (penInfoList == 2) {
                SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
                if (spenSettingQTPenLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                } else {
                    spenSettingQTPenLayout = spenSettingQTPenLayout2;
                }
                spenSettingQTPenLayout.setInfo(getCurrentPenInfo(1), getCurrentPenIndex(1));
                return true;
            }
            SpenSettingQTPenLayout spenSettingQTPenLayout3 = this.mPenLayout;
            if (spenSettingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                spenSettingQTPenLayout = spenSettingQTPenLayout3;
            }
            spenSettingQTPenLayout.setPenInfoList(list, getCurrentPenIndex(1));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setFavoriteListActionListener(@Nullable OnFavoriteListActionListener listener) {
        boolean z;
        Log.i(TAG, "setFavoriteListActionListener=".concat(listener == null ? "null" : "not null"));
        this.mFavoriteListActionListener = listener;
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        if (listener != null) {
            z = this.mMode == 1;
        }
        spenSettingQTPenLayout.requestDisallowModeChangeInPenList$SDK_fullRelease(z);
    }

    public final void setOnAddButtonClickListener(@Nullable OnAddButtonClickListener listener) {
        this.mAddButtonClickListener = listener;
    }

    @Deprecated(message = "Please use setOnAddButtonClickListener instead.")
    public final void setOnButtonClickListener(@Nullable OnButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    public final void setOnMainViewActionListener(@Nullable OnMainViewActionListener listener) {
        this.mMainViewActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer
    public void setOnModeChangedListener(@NotNull SpenSettingQTContainer.OnModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mModeChangedListener = listener;
    }

    public final void setPalette(@Nullable List<Integer> paletteList) {
        if (Intrinsics.areEqual(paletteList, this.mPaletteList)) {
            Log.i(TAG, "same palette. skip update.");
            return;
        }
        this.mPaletteList.clear();
        List<Integer> list = this.mPaletteList;
        if (paletteList == null) {
            paletteList = CollectionsKt.emptyList();
        }
        list.addAll(paletteList);
        if (this.mMode != 2) {
            SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
            if (spenSettingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout = null;
            }
            spenSettingQTPenLayout.setPaletteList(this.mPaletteList);
        }
    }

    public final void setPaletteActionButtonListener(@NotNull PaletteActionButtonListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPaletteActionButtonListener = listener;
    }

    public final boolean setPenInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        int iFindPenIndex = this.mPenListManager.findPenIndex(info.name);
        if (iFindPenIndex == -1) {
            AbstractC6670b.m4756q("not exist pen name=", info.name, TAG);
            return false;
        }
        String str = info.name;
        AbstractC0000a.m26w(AbstractC2322a.m1629s("setPenInfo() index=", iFindPenIndex, " name=", str, " mode="), TAG, this.mMode);
        if (!this.mPenListManager.setCurrentPenInfo(iFindPenIndex, info, false)) {
            Log.i(TAG, "Need Check. setPenInfo() fail.");
            return false;
        }
        if (this.mMode != 0) {
            return true;
        }
        SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
        if (spenSettingQTPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenSettingQTPenLayout = null;
        }
        spenSettingQTPenLayout.setInfo(info, iFindPenIndex);
        return true;
    }

    public final void setPenInfoChangedListener(@Nullable PenInfoChangedListener listener) {
        this.mPenListManager.setPenInfoChangedListener(listener);
    }

    public final boolean setPenInfoList(@NotNull List<? extends SpenSettingUIPenInfo> uiInfoList, int currentPenIndex) {
        Intrinsics.checkNotNullParameter(uiInfoList, "uiInfoList");
        AbstractC0000a.m26w(AbstractC0622a.m1173s(uiInfoList.size(), this.mMode, "setPenInfoList() size=", " mode=", " currentPenIndex="), TAG, currentPenIndex);
        if (!this.mPenListManager.isValidIndex(uiInfoList, currentPenIndex)) {
            AbstractC6670b.m4744e(currentPenIndex, uiInfoList.size(), "invalid index ", " size=", TAG);
            return false;
        }
        int penInfoList = this.mPenListManager.setPenInfoList(uiInfoList, currentPenIndex);
        if (penInfoList != 0 && this.mMode == 0) {
            SpenSettingQTPenLayout spenSettingQTPenLayout = null;
            if (penInfoList == 2) {
                SpenSettingQTPenLayout spenSettingQTPenLayout2 = this.mPenLayout;
                if (spenSettingQTPenLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                } else {
                    spenSettingQTPenLayout = spenSettingQTPenLayout2;
                }
                spenSettingQTPenLayout.setInfo(this.mPenListManager.getCurrentPenInfo(), currentPenIndex);
                return true;
            }
            SpenSettingQTPenLayout spenSettingQTPenLayout3 = this.mPenLayout;
            if (spenSettingQTPenLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            } else {
                spenSettingQTPenLayout = spenSettingQTPenLayout3;
            }
            spenSettingQTPenLayout.setPenInfoList(uiInfoList, currentPenIndex);
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
                Log.i(TAG, "same recent color list. skip update.");
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
            Log.i(TAG, "same recent color list. skip update.");
            return;
        }
        this.mRecentColors.clear();
        if (recentList != null) {
            this.mRecentColors.addAll(recentList);
        }
        if (this.mMode != 2) {
            SpenSettingQTPenLayout spenSettingQTPenLayout = this.mPenLayout;
            if (spenSettingQTPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenSettingQTPenLayout = null;
            }
            spenSettingQTPenLayout.setRecentColor(this.mRecentColors);
        }
    }

    public final void setRotation(@NotNull RotationType type, boolean animation) {
        Intrinsics.checkNotNullParameter(type, "type");
        Log.i(TAG, "setRotation() type=" + type + "  rotationType=" + this.rotationType + " viewMode=" + this.viewMode);
        if (this.rotationType == type || this.viewMode != SpenSettingQTPenLayout.ViewMode.MAIN) {
            return;
        }
        SpenSettingQTLayout.DockingState dockingState = type == RotationType.NONE ? SpenSettingQTLayout.DockingState.EXIT : type == RotationType.LEFT_DOCKING ? SpenSettingQTLayout.DockingState.ENTER_LEFT : SpenSettingQTLayout.DockingState.ENTER_RIGHT;
        boolean z = false;
        setDockingMode(dockingState, animation && this.mMode != 2);
        if (animation && this.mMode == 2) {
            z = true;
        }
        setCustomViewDockingMode(dockingState, z);
        setSwitchDockingMode(type, animation);
        this.rotationType = type;
    }

    public final void setViewModeChangedListener(@NotNull SpenSettingQTPenLayout.OnViewModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mViewModeChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer
    public boolean setVisibilityWithAnimation(int visibility, @Nullable OnVisibilityAnimationListener listener) {
        AbstractC2322a.m1631u(visibility, "setVisibilityWithAnimation visibility=", TAG);
        super.setVisibilityWithAnimation(visibility, listener);
        startModeViewAnimation(visibility);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTPenContainer(@NotNull Context context, boolean z, boolean z2, int i) {
        super(context, z2 ? 3 : 2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteList = new ArrayList();
        this.mRecentColors = new ArrayList();
        this.mPenListManager = new SpenQTPenListManager();
        this.mFavoriteListManager = new SpenQTPenListManager();
        this.viewMode = SpenSettingQTPenLayout.ViewMode.MAIN;
        this.rotationType = RotationType.NONE;
        this.mChangeViewModeToMainListener = new SpenSettingQTPenContainer$mChangeViewModeToMainListener$1(this);
        this.mIsSupportEyedropper = z;
        this.mSupportCustomMode = z2;
        initView(context, z, i);
    }

    @Deprecated(message = "Use setCustomMode(view, unselectedResourceId, selectedResourceId, description, switchColor)")
    public final void setCustomMode(int unselectedResourceId, int selectedResourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setMode(2, unselectedResourceId, selectedResourceId, description, 218103808);
        addViewBehindSwitch(view);
        this.mCustomModeView = view;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void setCustomMode(@NotNull View view, int unselectedResourceId, int selectedResourceId, @Nullable CharSequence description, @Nullable Integer switchColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setMode(2, unselectedResourceId, selectedResourceId, description, switchColor);
        addViewBehindSwitch(view);
        this.mCustomModeView = view;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTPenContainer(@NotNull Context context, boolean z) {
        this(context, z, false, 45);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTPenContainer(@NotNull Context context, boolean z, boolean z2) {
        this(context, z, z2, 45);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
