package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.collection.AbstractC0622a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener;
import com.samsung.android.sdk.pen.setting.quicktool.OnVisibilityAnimationListener;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.animation.QTTouchScaleAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolCustomBackground;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCurvedSwitchLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenViewInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.interaction.QTVisibilityHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p047K3.ViewOnLayoutChangeListenerC0162a;
import p097Y0.C0344a;
import p123b3.C4201a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0005*\u0002¹\u0001\b\u0007\u0018\u0000 ¼\u00012\u00020\u0001:\u0004»\u0001¼\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020%J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0014J\u0010\u0010Y\u001a\u00020I2\u0006\u0010Z\u001a\u00020\u0007H\u0016J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u00020\u0007H\u0002J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u0002032\u0006\u0010a\u001a\u000203H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0016J\u000e\u0010c\u001a\u00020I2\u0006\u0010d\u001a\u00020\u0007J\b\u0010e\u001a\u00020IH\u0002J\u001a\u0010f\u001a\u00020\u00072\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020I0HJ\u0006\u0010h\u001a\u00020IJ\u0018\u0010i\u001a\u00020I2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u000203H\u0002J\b\u0010l\u001a\u00020IH\u0002J\b\u0010m\u001a\u00020IH\u0002J\b\u0010n\u001a\u00020IH\u0002J\u000e\u0010o\u001a\u00020I2\u0006\u0010p\u001a\u00020*J\b\u0010q\u001a\u00020\u0007H\u0002J\u0006\u0010r\u001a\u00020IJ\u0006\u0010P\u001a\u00020sJ\b\u0010t\u001a\u00020\u0007H\u0016J\u0006\u0010u\u001a\u00020IJ,\u0010v\u001a\u00020I2\b\b\u0001\u0010w\u001a\u00020\u00142\b\b\u0001\u0010x\u001a\u00020\u00142\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020%J,\u0010|\u001a\u00020I2\b\b\u0001\u0010w\u001a\u00020\u00142\b\b\u0001\u0010x\u001a\u00020\u00142\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020%J\u0018\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00142\b\u0010g\u001a\u0004\u0018\u00010\u007fJ\u0019\u0010\u0080\u0001\u001a\u00020I2\u0010\u0010\u0081\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u00020I2\u0011\u0010\u0084\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0085\u0001J\u0010\u0010\u0087\u0001\u001a\u00020I2\u0007\u0010\u0088\u0001\u001a\u00020\u0014J!\u0010\u0089\u0001\u001a\u00020\u00072\u000f\u0010\u008a\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u0082\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0014J\u0010\u0010\u008d\u0001\u001a\u00020I2\u0007\u0010g\u001a\u00030\u008e\u0001J!\u0010\u008f\u0001\u001a\u00020\u00072\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u0082\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0014J\u0010\u0010\u0092\u0001\u001a\u00020I2\u0007\u0010g\u001a\u00030\u008e\u0001J\u0012\u0010\u0093\u0001\u001a\u00020I2\t\u0010g\u001a\u0005\u0018\u00010\u0094\u0001J\u001a\u0010\u0095\u0001\u001a\u00020\u00072\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0085\u0001H\u0002J\u001a\u0010\u0097\u0001\u001a\u00020\u00072\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0085\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020IH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020I2\u0007\u0010\u009a\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020I2\u0007\u0010\u009a\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u009c\u0001\u001a\u00020IH\u0002J\t\u0010\u009d\u0001\u001a\u00020IH\u0002J\u0007\u0010\u009e\u0001\u001a\u00020IJ\t\u0010\u009f\u0001\u001a\u00020IH\u0002J\t\u0010 \u0001\u001a\u00020IH\u0002J\u001b\u0010¡\u0001\u001a\u00020I2\u0007\u0010\u009a\u0001\u001a\u00020\u00142\t\b\u0002\u0010¢\u0001\u001a\u00020\u0007J\u0019\u0010£\u0001\u001a\u00020I2\u0007\u0010¤\u0001\u001a\u00020\u00142\u0007\u0010¥\u0001\u001a\u00020\u0007J\u001d\u0010¦\u0001\u001a\u00020I2\u0007\u0010§\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010g\u001a\u0005\u0018\u00010¨\u0001J\u001f\u0010©\u0001\u001a\u00020I2\u0014\u0010ª\u0001\u001a\u000f\u0012\u0005\u0012\u00030«\u0001\u0012\u0004\u0012\u00020I0HH\u0002J\r\u0010¬\u0001\u001a\u00020I*\u00020%H\u0002J\u0010\u0010\u00ad\u0001\u001a\u00020I2\u0007\u0010g\u001a\u00030®\u0001J\u0010\u0010¯\u0001\u001a\u00020I2\u0007\u0010g\u001a\u00030°\u0001J\u0019\u0010±\u0001\u001a\u00020I2\u0007\u0010²\u0001\u001a\u0002032\u0007\u0010³\u0001\u001a\u000203J\u0010\u0010´\u0001\u001a\u00020I2\u0007\u0010µ\u0001\u001a\u000203J\u0010\u0010¶\u0001\u001a\u00020I2\u0007\u0010·\u0001\u001a\u00020\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020I\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0013\u0010¸\u0001\u001a\u00030¹\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010º\u0001¨\u0006½\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;", "isEyedropperSupported", "", "isCustomModeSupported", "visibilityHandler", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/interaction/QTVisibilityHandler;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;ZZLcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/interaction/QTVisibilityHandler;)V", "getPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;", "floatingQT", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer;", "dockingQT", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenContainer;", "touchSlop", "", "mGestureDetector", "Landroid/view/GestureDetector;", "penListType", "getPenListType", "()I", "setPenListType", "(I)V", "mPenListLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mBgView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolCustomBackground;", "switchLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout;", "mCoverQT", "Landroid/view/View;", "isDockingAnimationRunning", "moving", "flying", "dockingType", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "getDockingType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "setDockingType", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;)V", "scrolling", "previousMode", "draggingStartMode", "lastRawX", "", "lastRawY", "currentY", "halfDockingWidth", "size", "getSize", "()F", "mDelta", "getMDelta", "touchScaleAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/animation/QTTouchScaleAnimation;", "expandAnimation", "Ljava/lang/Runnable;", "scaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scaleYAnimator", "mDelegate", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolDelegate;", "mContainerLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onModeChangedListener", "Lkotlin/Function1;", "", "getOnModeChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnModeChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "viewMode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "getViewMode", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "setCoverAndContainer", "container", "Landroid/view/ViewGroup;", "coverQt", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "onWindowFocusChanged", "hasWindowFocus", "dispatchTouchEvent", "onInterceptTouchEvent", "toggleCenterView", Constants.IntentExtraValue.SHOW, "inCircle", "x", "y", "onTouchEvent", "setRestrictionAiMode", "block", "startReLocateAnimation", "moveOutDocking", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "resetCoverQT", SecureFolderConstants.TEMP_FOLDER_NAME, "rawX", "rawY", "checkDocking", "dockingToLeft", "dockingToRight", "restoreDocking", "type", "supportedModeFloatingMove", "hide3rdLayer", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "performClick", "close", "setFloatingCustomMode", "unselectedResourceId", "selectedResourceId", "description", "", "view", "setDockingCustomMode", "setVisibilityWithAnimation", "visibility", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnVisibilityAnimationListener;", "setPalette", "paletteList", "", "setRecentColor", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setColorTheme", "colorTheme", "setPenInfoList", "uiInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "currentPenIndex", "setPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PenInfoChangedListener;", "setFavoriteList", XmlErrorCodes.LIST, "selectedIndex", "setFavoriteInfoChangedListener", "setOnAddButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnAddButtonClickListener;", "getPenViewList", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenViewInfo;", "getFavoritePenViewList", "setupBGView", "onModeChange", "mode", "logOnModeChange", "setupCurvedSwitchLayout", "closeCurvedSwitchLayout", "removeBgView", "setMainViewActionListener", "clearMainViewActionListener", "changeToMode", "openPenList", "openPenListView", "indexSelect", "isFavorite", "hideDockingPenList", "toggleMode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$VisibilityChangedListener;", "hide", "onAnimationEnd", "Landroid/view/animation/Animation;", "setDockingPenList", "setPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$PaletteActionButtonListener;", "setFavoriteListActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$OnFavoriteListActionListener;", "startMoveOutDockingAnimation", "targetX", "targetY", "reAttachQuickTool", "oldY", "setEyedropperEnabled", "enable", "favoriteInfoChangeListener", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer$favoriteInfoChangeListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer$favoriteInfoChangeListener$1;", "FloaterGestureListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nQuickToolContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickToolContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1087:1\n255#2:1088\n1#3:1089\n*S KotlinDebug\n*F\n+ 1 QuickToolContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer\n*L\n236#1:1088\n*E\n"})
public final class QuickToolContainer extends FrameLayout {
    private static final long ANIMATION_DURATION = 250;
    public static final float DIST_FACTOR = 0.3f;
    private static final float FLY_VELOCITY_MIN_LIMIT = 1000.0f;
    private static final int MAX_PEN_COUNT = 45;
    public static final int PEN_LIST_FAVORITE = 2;
    public static final int PEN_LIST_HIDE = 0;
    public static final int PEN_LIST_SHOW = 1;
    private static final long SHOW_HIDE_ANIMATION_DURATION = 250;

    @NotNull
    private static final String TAG = "QuickToolContainer";
    private static final int VELOCITY_UNIT = 500;
    private float currentY;

    @NotNull
    private final SettingQTPenContainer dockingQT;

    @NotNull
    private SpenSettingQTPenContainer.RotationType dockingType;
    private int draggingStartMode;

    @NotNull
    private final Runnable expandAnimation;

    @NotNull
    private final QuickToolContainer$favoriteInfoChangeListener$1 favoriteInfoChangeListener;

    @NotNull
    private final SpenSettingQTPenContainer floatingQT;
    private boolean flying;
    private final float halfDockingWidth;
    private boolean isDockingAnimationRunning;
    private float lastRawX;
    private float lastRawY;

    @Nullable
    private QuickToolCustomBackground mBgView;

    @NotNull
    private final SpenColorThemeUtil mColorThemeUtil;

    @Nullable
    private View.OnLayoutChangeListener mContainerLayoutChangeListener;
    private View mCoverQT;

    @NotNull
    private final QuickToolDelegate mDelegate;
    private final float mDelta;

    @NotNull
    private GestureDetector mGestureDetector;

    @Nullable
    private SettingQTPenListDockingLayout mPenListLayout;
    private boolean moving;

    @Nullable
    private Function1<? super Integer, Unit> onModeChangedListener;
    private int penListType;

    @NotNull
    private final QuickToolPresenter presenter;
    private int previousMode;

    @NotNull
    private final SpringAnimation scaleXAnimator;

    @NotNull
    private final SpringAnimation scaleYAnimator;
    private boolean scrolling;
    private final float size;

    @Nullable
    private QTCurvedSwitchLayout switchLayout;

    @NotNull
    private final QTTouchScaleAnimation touchScaleAnimation;
    private final int touchSlop;

    @NotNull
    private final QTVisibilityHandler visibilityHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer$FloaterGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class FloaterGestureListener extends GestureDetector.SimpleOnGestureListener {
        public FloaterGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            Logger.m10999d(QuickToolContainer.TAG, "velocityX:" + velocityX + ", velocityY:" + velocityY);
            if (QuickToolContainer.this.getDockingType() != SpenSettingQTPenContainer.RotationType.NONE) {
                return false;
            }
            if (((float) Math.abs(velocityX)) > QuickToolContainer.FLY_VELOCITY_MIN_LIMIT || ((float) Math.abs(velocityY)) > QuickToolContainer.FLY_VELOCITY_MIN_LIMIT) {
                QuickToolContainer.this.flying = true;
                QuickToolDelegate quickToolDelegate = QuickToolContainer.this.mDelegate;
                SpenSettingQTPenContainer.RotationType dockingType = QuickToolContainer.this.getDockingType();
                final QuickToolContainer quickToolContainer = QuickToolContainer.this;
                quickToolDelegate.fly(velocityX, velocityY, dockingType, new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$FloaterGestureListener$onFling$1
                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                        if (canceled) {
                            return;
                        }
                        quickToolContainer.flying = false;
                        quickToolContainer.checkDocking();
                    }
                });
            }
            return super.onFling(e12, e2, velocityX, velocityY);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingQTPenLayout.ViewMode.values().length];
            try {
                iArr[SettingQTPenLayout.ViewMode.COLOR_DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingQTPenLayout.ViewMode.COLOR_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SpenSettingQTPenContainer.RotationType.values().length];
            try {
                iArr2[SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SpenSettingQTPenContainer.RotationType.LEFT_DOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SpenSettingQTPenContainer.RotationType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QuickToolContainer(@NotNull Context context, @NotNull QuickToolPresenter presenter, @NotNull QTVisibilityHandler visibilityHandler) {
        this(context, presenter, false, false, visibilityHandler, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(visibilityHandler, "visibilityHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(QuickToolContainer quickToolContainer) {
        quickToolContainer.isDockingAnimationRunning = false;
        quickToolContainer.toggleCenterView(false);
        if (quickToolContainer.dockingQT.getMMode() == 1) {
            quickToolContainer.openPenListView(quickToolContainer.presenter.getCurrentFavoriteIndex(), true);
        } else if (quickToolContainer.dockingQT.getMMode() == 0) {
            QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
            quickToolSA.logFirstBehavior("3");
            quickToolSA.log(QuickToolSA.EVENT_QT_COLOR_LIST, quickToolContainer.floatingQT.getRotationType());
        }
        quickToolContainer.dockingQT.setVisibilityWithAnimation(0, null);
    }

    public static /* synthetic */ void changeToMode$default(QuickToolContainer quickToolContainer, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        quickToolContainer.changeToMode(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDocking() {
        SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
        SpenSettingQTPenContainer.RotationType rotationType2 = SpenSettingQTPenContainer.RotationType.NONE;
        View view = null;
        if (rotationType == rotationType2) {
            float x = (getX() + getWidth()) - this.mDelta;
            View view2 = this.mCoverQT;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            } else {
                view = view2;
            }
            if (x > view.getRight()) {
                dockingToRight();
                return;
            }
            if (getX() + this.mDelta < this.presenter.getDeltaCoordinateOrigin()) {
                dockingToLeft();
                return;
            }
            QuickToolSA.INSTANCE.logFirstBehavior("8");
            this.dockingType = rotationType2;
            this.floatingQT.setRotation(rotationType2, true);
            clearMainViewActionListener();
            this.presenter.updateQTContainer(getRootView().getWidth());
            return;
        }
        float x2 = (getX() + getWidth()) - this.mDelta;
        View view3 = this.mCoverQT;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
        } else {
            view = view3;
        }
        if (x2 > view.getRight()) {
            dockingToRight();
            return;
        }
        if (getX() + this.mDelta < this.presenter.getDeltaCoordinateOrigin()) {
            dockingToLeft();
            return;
        }
        QuickToolSA.INSTANCE.logFirstBehavior("8");
        Logger.m10999d(TAG, "Stop Docking");
        this.floatingQT.setRotation(rotationType2, true);
        this.dockingType = rotationType2;
        this.dockingQT.setVisibility(8);
        clearMainViewActionListener();
        this.presenter.updateQTContainer(getRootView().getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearMainViewActionListener() {
        SettingQTPenContainer.setViewMode$default(this.dockingQT, SettingQTPenLayout.ViewMode.MAIN, false, false, false, 14, null);
    }

    private final void closeCurvedSwitchLayout() {
        QTCurvedSwitchLayout qTCurvedSwitchLayout = this.switchLayout;
        if (qTCurvedSwitchLayout == null) {
            return;
        }
        final C0344a c0344a = new C0344a(qTCurvedSwitchLayout, this, 3);
        SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
        if (rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
            final int i = 0;
            qTCurvedSwitchLayout.animate().alpha(0.0f).rotation(180.0f).y(0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.c
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            c0344a.invoke();
                            break;
                        default:
                            c0344a.invoke();
                            break;
                    }
                }
            }).start();
        } else if (rotationType == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
            final int i2 = 1;
            qTCurvedSwitchLayout.animate().alpha(0.0f).rotation(0.0f).y(0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.c
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            c0344a.invoke();
                            break;
                        default:
                            c0344a.invoke();
                            break;
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit closeCurvedSwitchLayout$lambda$9(QTCurvedSwitchLayout qTCurvedSwitchLayout, QuickToolContainer quickToolContainer) {
        qTCurvedSwitchLayout.setVisibility(8);
        quickToolContainer.removeView(qTCurvedSwitchLayout);
        qTCurvedSwitchLayout.close();
        quickToolContainer.switchLayout = null;
        return Unit.INSTANCE;
    }

    private final void dockingToLeft() {
        QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
        quickToolSA.logFirstBehavior("9");
        quickToolSA.log(QuickToolSA.EVENT_QT_DOCKING);
        Logger.m10999d(TAG, "Start Docking to Left");
        View view = this.mCoverQT;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            view = null;
        }
        if (view.getLayoutDirection() == 1) {
            QuickToolPresenter quickToolPresenter = this.presenter;
            View view3 = this.mCoverQT;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            } else {
                view2 = view3;
            }
            quickToolPresenter.updateQTContainer(view2.getWidth());
            this.presenter.setClipToOutlineForQTContainer(true);
        }
        this.isDockingAnimationRunning = true;
        this.floatingQT.changeViewModeToMainWithAnimation(new OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.dockingToLeft.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
            public void onAnimationEnd() {
                QuickToolContainer quickToolContainer = QuickToolContainer.this;
                SpenSettingQTPenContainer.RotationType rotationType = SpenSettingQTPenContainer.RotationType.LEFT_DOCKING;
                quickToolContainer.setDockingType(rotationType);
                QuickToolContainer.this.dockingQT.setRotation(rotationType);
                QuickToolContainer.this.floatingQT.setRotation(rotationType, true);
                QuickToolDelegate quickToolDelegate = QuickToolContainer.this.mDelegate;
                float width = 0 - (QuickToolContainer.this.getWidth() / 2);
                float y2 = QuickToolContainer.this.getY();
                float appBarHeight = QuickToolContainer.this.halfDockingWidth + QuickToolContainer.this.getPresenter().getAppBarHeight() + (0.0f - (QuickToolContainer.this.getHeight() / 2));
                float height = (QuickToolContainer.this.getRootView().getHeight() - (QuickToolContainer.this.getHeight() / 2)) - QuickToolContainer.this.halfDockingWidth;
                QuickToolPresenter presenter = QuickToolContainer.this.getPresenter();
                Intrinsics.checkNotNullExpressionValue(QuickToolContainer.this.getContext(), "getContext(...)");
                quickToolDelegate.checkDockingAnimation(width, RangesKt.coerceIn(y2, appBarHeight, height - presenter.getNavigationBarHeight(r6)), null);
                QuickToolContainer quickToolContainer2 = QuickToolContainer.this;
                quickToolContainer2.postDelayed(quickToolContainer2.expandAnimation, 200L);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
            public void onAnimationStart() {
            }
        });
    }

    private final void dockingToRight() {
        QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
        quickToolSA.logFirstBehavior("9");
        quickToolSA.log(QuickToolSA.EVENT_QT_DOCKING);
        Logger.m10999d(TAG, "Start Docking to Right");
        this.isDockingAnimationRunning = true;
        this.floatingQT.changeViewModeToMainWithAnimation(new OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.dockingToRight.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
            public void onAnimationEnd() {
                QuickToolContainer quickToolContainer = QuickToolContainer.this;
                SpenSettingQTPenContainer.RotationType rotationType = SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING;
                quickToolContainer.setDockingType(rotationType);
                QuickToolContainer.this.dockingQT.setRotation(rotationType);
                QuickToolContainer.this.floatingQT.setRotation(rotationType, true);
                QuickToolDelegate quickToolDelegate = QuickToolContainer.this.mDelegate;
                View view = QuickToolContainer.this.mCoverQT;
                View view2 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                    view = null;
                }
                float right = view.getRight() - (QuickToolContainer.this.getWidth() / 2);
                float y2 = QuickToolContainer.this.getY();
                float appBarHeight = QuickToolContainer.this.halfDockingWidth + QuickToolContainer.this.getPresenter().getAppBarHeight() + (0.0f - (QuickToolContainer.this.getHeight() / 2));
                float height = (QuickToolContainer.this.getRootView().getHeight() - (QuickToolContainer.this.getHeight() / 2)) - QuickToolContainer.this.halfDockingWidth;
                QuickToolPresenter presenter = QuickToolContainer.this.getPresenter();
                Intrinsics.checkNotNullExpressionValue(QuickToolContainer.this.getContext(), "getContext(...)");
                quickToolDelegate.checkDockingAnimation(right, RangesKt.coerceIn(y2, appBarHeight, height - presenter.getNavigationBarHeight(r9)), null);
                QuickToolContainer quickToolContainer2 = QuickToolContainer.this;
                quickToolContainer2.postDelayed(quickToolContainer2.expandAnimation, 200L);
                View view3 = QuickToolContainer.this.mCoverQT;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                    view3 = null;
                }
                if (view3.getLayoutDirection() == 0) {
                    QuickToolPresenter presenter2 = QuickToolContainer.this.getPresenter();
                    View view4 = QuickToolContainer.this.mCoverQT;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                    } else {
                        view2 = view4;
                    }
                    presenter2.updateQTContainer(view2.getWidth());
                    QuickToolContainer.this.getPresenter().setClipToOutlineForQTContainer(true);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
            public void onAnimationStart() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFavoritePenViewList(List<QTPenViewInfo> list) {
        List<SpenSettingUIPenInfo> favoriteInfoList = this.presenter.getFavoriteInfoList();
        list.clear();
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : favoriteInfoList) {
            list.add(new QTPenViewInfo(spenSettingUIPenInfo.name, this.mColorThemeUtil.getColor(spenSettingUIPenInfo.color), spenSettingUIPenInfo.sizeLevel, spenSettingUIPenInfo.particleSize, spenSettingUIPenInfo.isFixedWidth));
        }
        if (list.size() >= 45) {
            return true;
        }
        list.add(new QTPenViewInfo("AddFavorite", 0, 0, 0.0f, false));
        return true;
    }

    private final boolean getPenViewList(List<QTPenViewInfo> list) {
        ArrayList<SpenSettingUIPenInfo> arrayList = new ArrayList();
        arrayList.addAll(this.presenter.getPenInfoList());
        if (!this.presenter.isFocusStickyNote()) {
            arrayList.addAll(this.presenter.getHighlighterInfoList());
        }
        list.clear();
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : arrayList) {
            list.add(new QTPenViewInfo(spenSettingUIPenInfo.name, this.mColorThemeUtil.getColor(spenSettingUIPenInfo.color), spenSettingUIPenInfo.sizeLevel, spenSettingUIPenInfo.particleSize, spenSettingUIPenInfo.isFixedWidth));
        }
        return true;
    }

    private final void hide(final Function1<? super Animation, Unit> onAnimationEnd) {
        this.scaleXAnimator.animateToFinalPosition(0.8f);
        this.scaleYAnimator.animateToFinalPosition(0.8f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$hide$alphaAnimation$1$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                onAnimationEnd.invoke(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        startAnimation(alphaAnimation);
    }

    public static /* synthetic */ void hideDockingPenList$default(QuickToolContainer quickToolContainer, int i, SpenSettingQTPenContainer.VisibilityChangedListener visibilityChangedListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            visibilityChangedListener = null;
        }
        quickToolContainer.hideDockingPenList(i, visibilityChangedListener);
    }

    private final boolean inCircle(float x, float y2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.dockingQT.getViewMode().ordinal()];
        float dimension = getResources().getDimension((i == 1 || i == 2) ? C9086R.dimen.composer_qt_color_picker_radius : C9086R.dimen.qt_ai_menu_radius);
        float width = x - (getWidth() * 0.5f);
        float height = y2 - (getHeight() * 0.5f);
        return (height * height) + (width * width) <= dimension * dimension;
    }

    private final void logOnModeChange(int mode) {
        if (mode == 0) {
            QuickToolSA.INSTANCE.logFirstBehavior("5");
        } else if (mode != 1) {
            QuickToolSA.INSTANCE.logFirstBehavior("6");
        } else {
            QuickToolSA.INSTANCE.logFirstBehavior("4");
        }
        QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_CHANGE_MODE, mode);
    }

    private final void move(float rawX, float rawY) {
        if (this.flying) {
            return;
        }
        setX((rawX - this.lastRawX) + getX());
        setY((rawY - this.lastRawY) + getY());
        this.lastRawX = rawX;
        this.lastRawY = rawY;
        if (getX() + this.mDelta < this.presenter.getDeltaCoordinateOrigin()) {
            this.floatingQT.setRotation(SpenSettingQTPenContainer.RotationType.LEFT_DOCKING, true);
        } else {
            float x = getX() - this.mDelta;
            View view = this.mCoverQT;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                view = null;
            }
            if (x > view.getRight() - getWidth()) {
                this.floatingQT.setRotation(SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING, true);
            } else {
                this.floatingQT.setRotation(SpenSettingQTPenContainer.RotationType.NONE, true);
            }
        }
        this.presenter.setClipToOutlineForQTContainer(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit moveOutDocking$lambda$2(QuickToolContainer quickToolContainer, Function1 function1, Animation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        quickToolContainer.presenter.unregisterFavoriteInfoChangeListener(quickToolContainer.favoriteInfoChangeListener);
        function1.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onModeChange(int mode) {
        logOnModeChange(mode);
        this.presenter.clearSelectionNoteAssist();
        QuickToolPresenter.hideSettingViews$default(this.presenter, false, 1, null);
        this.previousMode = this.dockingQT.getMMode();
        Function1<? super Integer, Unit> function1 = this.onModeChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(mode));
        }
        if (this.dockingType == SpenSettingQTPenContainer.RotationType.NONE) {
            SettingQTPenContainer.onModeChanged$default(this.dockingQT, mode, false, 2, null);
        } else if (mode == 1) {
            openPenListView(this.presenter.getCurrentFavoriteIndex(), true);
        } else {
            hideDockingPenList$default(this, mode, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreDocking$lambda$4(QuickToolContainer quickToolContainer) {
        QuickToolDelegate quickToolDelegate = quickToolContainer.mDelegate;
        View view = quickToolContainer.mCoverQT;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            view = null;
        }
        float right = view.getRight() - (quickToolContainer.getWidth() / 2);
        float y2 = quickToolContainer.getY();
        float appBarHeight = quickToolContainer.presenter.getAppBarHeight() + (0.0f - (quickToolContainer.getHeight() / 2)) + quickToolContainer.halfDockingWidth;
        float height = (quickToolContainer.getRootView().getHeight() - (quickToolContainer.getHeight() / 2)) - quickToolContainer.halfDockingWidth;
        QuickToolPresenter quickToolPresenter = quickToolContainer.presenter;
        Intrinsics.checkNotNullExpressionValue(quickToolContainer.getContext(), "getContext(...)");
        quickToolDelegate.checkDockingAnimation(right, RangesKt.coerceIn(y2, appBarHeight, height - quickToolPresenter.getNavigationBarHeight(r6)), new C10744d(quickToolContainer, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreDocking$lambda$4$lambda$3(QuickToolContainer quickToolContainer, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        View view = quickToolContainer.mCoverQT;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            view = null;
        }
        quickToolContainer.setX(view.getRight() - (quickToolContainer.getWidth() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreDocking$lambda$5(QuickToolContainer quickToolContainer) {
        QuickToolDelegate quickToolDelegate = quickToolContainer.mDelegate;
        float width = 0 - (quickToolContainer.getWidth() / 2);
        float y2 = quickToolContainer.getY();
        float appBarHeight = quickToolContainer.presenter.getAppBarHeight() + (0.0f - (quickToolContainer.getHeight() / 2)) + quickToolContainer.halfDockingWidth;
        float height = (quickToolContainer.getRootView().getHeight() - (quickToolContainer.getHeight() / 2)) - quickToolContainer.halfDockingWidth;
        QuickToolPresenter quickToolPresenter = quickToolContainer.presenter;
        Intrinsics.checkNotNullExpressionValue(quickToolContainer.getContext(), "getContext(...)");
        quickToolDelegate.checkDockingAnimation(width, RangesKt.coerceIn(y2, appBarHeight, height - quickToolPresenter.getNavigationBarHeight(r7)), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCoverAndContainer$lambda$1(QuickToolContainer quickToolContainer, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        View view2 = quickToolContainer.mCoverQT;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            view2 = null;
        }
        if (view2.getLayoutDirection() == 1) {
            if (quickToolContainer.dockingType != SpenSettingQTPenContainer.RotationType.LEFT_DOCKING || i - i6 == 0) {
                return;
            }
            quickToolContainer.setX((-quickToolContainer.getWidth()) / 2);
            return;
        }
        if (quickToolContainer.dockingType != SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING || i4 - i8 == 0) {
            return;
        }
        quickToolContainer.setX(i4 - (quickToolContainer.getWidth() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDockingPenList(View view) {
        view.setRotation(90.0f);
        SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
        if (rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
            view.setScaleY(1.0f);
            view.setX(view.getX() + (view.getHeight() / 3));
        } else if (rotationType == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
            view.setScaleY(-1.0f);
            view.setX(view.getX() - (view.getHeight() / 3));
        }
    }

    private final void setMainViewActionListener() {
        this.floatingQT.setOnMainViewActionListener(new SpenSettingQTPenContainer.OnMainViewActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.setMainViewActionListener.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnMainViewActionListener
            public void onPenClicked(int mode, String penName) {
                Intrinsics.checkNotNullParameter(penName, "penName");
                if (QuickToolContainer.this.getDockingType() == SpenSettingQTPenContainer.RotationType.NONE) {
                    return;
                }
                View viewFindViewById = QuickToolContainer.this.floatingQT.findViewById(C9086R.id.center_pen_item);
                int[] iArr = new int[2];
                viewFindViewById.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                viewFindViewById.getGlobalVisibleRect(rect);
                int i = iArr[0];
                int i2 = iArr[1];
                float x = viewFindViewById.getX();
                float y2 = viewFindViewById.getY();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "currentPenView currentPenViewLocation [", " ", "], [x,y] ");
                AbstractC11014a.m12337v(sbM1173s, x, SQLKeyword.COMMA, y2, ", rect ");
                sbM1173s.append(rect);
                Logger.m10999d(QuickToolContainer.TAG, sbM1173s.toString());
                QuickToolContainer quickToolContainer = QuickToolContainer.this;
                quickToolContainer.openPenListView(quickToolContainer.getPresenter().getPenSelected(), false);
            }
        });
    }

    private final void setupBGView() {
        if (this.mBgView != null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        QuickToolCustomBackground quickToolCustomBackground = new QuickToolCustomBackground(context, 0.0f, false, 6, null);
        this.mBgView = quickToolCustomBackground;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(quickToolCustomBackground, layoutParams);
        quickToolCustomBackground.setRotation(90.0f);
        SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
        if (rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
            quickToolCustomBackground.setScaleY(1.0f);
            quickToolCustomBackground.setX(getResources().getDimension(C9086R.dimen.qt_bg_stroke_margin));
        } else if (rotationType == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
            quickToolCustomBackground.setScaleY(-1.0f);
            quickToolCustomBackground.setX(0.0f - getResources().getDimension(C9086R.dimen.qt_bg_stroke_margin));
        }
    }

    private final void setupCurvedSwitchLayout() {
        QTCurvedSwitchLayout qTCurvedSwitchLayout = this.switchLayout;
        if (qTCurvedSwitchLayout == null) {
            int i = this.presenter.canShowAiMenu() ? 3 : 2;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            QTCurvedSwitchLayout qTCurvedSwitchLayout2 = new QTCurvedSwitchLayout(context, i);
            this.switchLayout = qTCurvedSwitchLayout2;
            if (this.presenter.isFocusStickyNote()) {
                qTCurvedSwitchLayout2.restrictModeAccessDocking(2);
            }
            qTCurvedSwitchLayout2.setOnModeChangedListener(new SpenSettingQTContainer.OnModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$setupCurvedSwitchLayout$switch$1$1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer.OnModeChangedListener
                public void onModeChanged(int mode) {
                    this.$this_run.onModeChange(mode);
                }
            });
            SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
            if (rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
                qTCurvedSwitchLayout2.setRotation(180.0f);
                qTCurvedSwitchLayout2.setX(qTCurvedSwitchLayout2.getX() - getResources().getDimension(C9086R.dimen.qt_circle_margin_docking));
            } else if (rotationType == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
                qTCurvedSwitchLayout2.setRotation(0.0f);
                qTCurvedSwitchLayout2.setX(getResources().getDimension(C9086R.dimen.qt_circle_margin_docking) + qTCurvedSwitchLayout2.getX());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(qTCurvedSwitchLayout2, layoutParams);
            qTCurvedSwitchLayout = qTCurvedSwitchLayout2;
        }
        SpenSettingQTPenContainer.RotationType rotationType2 = this.dockingType;
        if (rotationType2 == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING) {
            qTCurvedSwitchLayout.setRotationIcon(180.0f);
            qTCurvedSwitchLayout.animate().alpha(1.0f).rotation(196.0f).y(this.floatingQT.getHeight() - getResources().getDimension(C9086R.dimen.qt_circle_am_margin_bottom)).setDuration(250L).withEndAction(null).start();
        } else if (rotationType2 == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING) {
            qTCurvedSwitchLayout.setRotationIcon(0.0f);
            qTCurvedSwitchLayout.animate().alpha(1.0f).rotation(-16.0f).y(this.floatingQT.getHeight() - getResources().getDimension(C9086R.dimen.qt_circle_am_margin_bottom)).setDuration(250L).withEndAction(null).start();
        }
    }

    private final void startReLocateAnimation() {
        Logger.m10999d(TAG, "startReLocateAnimation");
        if (this.flying) {
            return;
        }
        this.mDelegate.relocateAnimation(this.dockingType);
        checkDocking();
    }

    private final boolean supportedModeFloatingMove() {
        return this.floatingQT.getViewMode() == SpenSettingQTPenLayout.ViewMode.MAIN || this.floatingQT.getViewMode() == SpenSettingQTPenLayout.ViewMode.ATTRIBUTES || this.floatingQT.getViewMode() == SpenSettingQTPenLayout.ViewMode.COLOR;
    }

    private final void toggleCenterView(boolean show) {
        View viewFindViewById = findViewById(C9086R.id.qt_ai_menu_center_text);
        if (viewFindViewById == null) {
            return;
        }
        if (!show) {
            viewFindViewById.setVisibility(8);
            return;
        }
        viewFindViewById.setScaleX(0.0f);
        viewFindViewById.setScaleY(0.0f);
        viewFindViewById.setVisibility(0);
    }

    public final void changeToMode(int mode, boolean openPenList) {
        this.previousMode = this.dockingQT.getMMode();
        Function1<? super Integer, Unit> function1 = this.onModeChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(mode));
        }
        this.floatingQT.changeMode(mode);
        this.dockingQT.onModeChanged(mode, openPenList);
    }

    public final void close() {
        removeAllViews();
        this.floatingQT.close();
        this.dockingQT.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dockingType == SpenSettingQTPenContainer.RotationType.NONE) {
            this.visibilityHandler.onHover(event);
        }
        return super.dispatchHoverEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.floatingQT.isScrollAt(event.getRawX(), event.getRawY())) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            if (((ViewGroup) parent).getChildCount() > 1) {
                return true;
            }
        } else if (this.dockingType == SpenSettingQTPenContainer.RotationType.NONE && supportedModeFloatingMove()) {
            this.touchScaleAnimation.scale(event);
        }
        requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(event);
    }

    @NotNull
    public final SpenSettingQTPenContainer.RotationType getDockingType() {
        return this.dockingType;
    }

    public final float getMDelta() {
        return this.mDelta;
    }

    @Nullable
    public final Function1<Integer, Unit> getOnModeChangedListener() {
        return this.onModeChangedListener;
    }

    public final int getPenListType() {
        return this.penListType;
    }

    @NotNull
    public final QuickToolPresenter getPresenter() {
        return this.presenter;
    }

    public final float getSize() {
        return this.size;
    }

    @NotNull
    public final SpenSettingQTPenLayout.ViewMode getViewMode() {
        return this.floatingQT.getViewMode();
    }

    public final void hide3rdLayer() {
        if (this.dockingQT.getViewMode() == SettingQTPenLayout.ViewMode.COLOR_DETAIL) {
            SettingQTPenContainer.setViewMode$default(this.dockingQT, SettingQTPenLayout.ViewMode.MAIN, false, false, false, 14, null);
        }
    }

    public final void hideDockingPenList(int toggleMode, @Nullable final SpenSettingQTPenContainer.VisibilityChangedListener listener) {
        if (toggleMode == 1) {
            toggleMode = this.previousMode;
        }
        changeToMode$default(this, toggleMode, false, 2, null);
        final SettingQTPenListDockingLayout settingQTPenListDockingLayout = this.mPenListLayout;
        if (settingQTPenListDockingLayout != null) {
            settingQTPenListDockingLayout.setVisibility(8, true);
        }
        final QTCurvedSwitchLayout qTCurvedSwitchLayout = this.switchLayout;
        QuickToolCustomBackground quickToolCustomBackground = this.mBgView;
        if (quickToolCustomBackground != null) {
            quickToolCustomBackground.animate().translationX(0.0f).setDuration(300L).start();
            quickToolCustomBackground.setBGMode(false, true, new OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$hideDockingPenList$1$1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
                public void onAnimationEnd() {
                    this.this$0.floatingQT.setVisibility(0);
                    SpenSettingQTPenContainer.VisibilityChangedListener visibilityChangedListener = listener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onCompleted();
                    }
                    SettingQTPenListDockingLayout settingQTPenListDockingLayout2 = settingQTPenListDockingLayout;
                    ViewParent parent = settingQTPenListDockingLayout2 != null ? settingQTPenListDockingLayout2.getParent() : null;
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(settingQTPenListDockingLayout);
                    }
                    SettingQTPenListDockingLayout settingQTPenListDockingLayout3 = settingQTPenListDockingLayout;
                    if (settingQTPenListDockingLayout3 != null) {
                        settingQTPenListDockingLayout3.close();
                    }
                    this.this$0.mPenListLayout = null;
                    this.this$0.setPenListType(0);
                    QTCurvedSwitchLayout qTCurvedSwitchLayout2 = qTCurvedSwitchLayout;
                    if (qTCurvedSwitchLayout2 != null) {
                        qTCurvedSwitchLayout2.clearModeAccessDocking();
                    }
                    this.this$0.removeBgView();
                    this.this$0.getPresenter().unregisterFavoriteInfoChangeListener(this.this$0.favoriteInfoChangeListener);
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener
                public void onAnimationStart() {
                }
            });
        }
        closeCurvedSwitchLayout();
        if (this.currentY != -1.0f) {
            animate().translationY(this.currentY).setDuration(250L).start();
            this.currentY = -1.0f;
        }
        this.dockingQT.setVisibility(0);
    }

    public final boolean moveOutDocking(@NotNull final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.flying || this.isDockingAnimationRunning || this.dockingType == SpenSettingQTPenContainer.RotationType.NONE) {
            return false;
        }
        QuickToolPresenter.hideSettingViews$default(this.presenter, false, 1, null);
        setVisibility(0);
        if (this.penListType != 0) {
            hide(new C4201a(this, listener, 3));
            return true;
        }
        this.dockingQT.setVisibilityWithAnimation(8, new SpenSettingQTPenContainer.VisibilityChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.moveOutDocking.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.VisibilityChangedListener
            public void onCompleted() {
                listener.invoke(Boolean.TRUE);
            }
        });
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isDockingAnimationRunning) {
            return true;
        }
        if (!supportedModeFloatingMove()) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            if (this.dockingType != SpenSettingQTPenContainer.RotationType.NONE && inCircle(event.getX(), event.getY())) {
                QuickToolPresenter.hideSettingViews$default(this.presenter, false, 1, null);
            }
            this.scrolling = false;
            if (this.floatingQT.isScrollAt(event.getRawX(), event.getRawY()) || this.dockingQT.isScrollAt(event.getX(), event.getY()) || this.penListType != 0) {
                this.scrolling = true;
                return false;
            }
            this.moving = false;
            this.flying = false;
            this.lastRawX = event.getRawX();
            this.lastRawY = event.getRawY();
        } else if (action == 1) {
            this.scrolling = false;
        } else if (action == 2) {
            float fAbs = Math.abs(event.getRawX() - this.lastRawX);
            float fAbs2 = Math.abs(event.getRawY() - this.lastRawY);
            if (!this.scrolling) {
                int i = this.touchSlop;
                if (fAbs > i || fAbs2 > i) {
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_MOVE_QUICK_TOOLS);
                    this.moving = true;
                    if (this.dockingQT.getVisibility() == 0) {
                        this.dockingQT.setVisibilityWithAnimation(8, null);
                        toggleCenterView(true);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isDockingAnimationRunning) {
            return true;
        }
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        if (((ViewGroup) parent).getChildCount() > 1) {
            Logger.m10999d(TAG, "Not support floating move mode.");
            return false;
        }
        this.mGestureDetector.onTouchEvent(event);
        int action = event.getAction();
        if (action != 1) {
            if (action != 2) {
                if (action == 3 && this.moving) {
                    move(event.getRawX(), event.getRawY());
                    this.moving = false;
                    startReLocateAnimation();
                }
            } else if (this.moving) {
                move(event.getRawX(), event.getRawY());
            }
        } else if (this.moving) {
            move(event.getRawX(), event.getRawY());
            this.moving = false;
            startReLocateAnimation();
        } else {
            performClick();
        }
        return false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus || this.dockingType != SpenSettingQTPenContainer.RotationType.NONE) {
            return;
        }
        this.presenter.hideQT();
    }

    public final void openPenListView(int indexSelect, final boolean isFavorite) {
        if (isFavorite) {
            changeToMode(1, true);
        } else {
            changeToMode(0, true);
            this.dockingQT.collapse();
        }
        SettingQTPenListDockingLayout settingQTPenListDockingLayout = this.mPenListLayout;
        if (settingQTPenListDockingLayout == null) {
            setupBGView();
            List<QTPenViewInfo> arrayList = new ArrayList<>();
            if (isFavorite) {
                getFavoritePenViewList(arrayList);
                this.dockingQT.updateColor();
                List<SpenSettingUIPenInfo> favoriteInfoList = this.presenter.getFavoriteInfoList();
                if (!favoriteInfoList.isEmpty()) {
                    if (this.presenter.getCurrentFavoriteIndex() >= favoriteInfoList.size()) {
                        this.presenter.setCurrentFavoriteIndex(0);
                    }
                    QuickToolPresenter quickToolPresenter = this.presenter;
                    quickToolPresenter.onPenInfoChange(favoriteInfoList.get(quickToolPresenter.getCurrentFavoriteIndex()));
                }
            } else {
                getPenViewList(arrayList);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            final SettingQTPenListDockingLayout settingQTPenListDockingLayout2 = new SettingQTPenListDockingLayout(context, arrayList, isFavorite, this.dockingType == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING ? -1.0f : 1.0f);
            this.mPenListLayout = settingQTPenListDockingLayout2;
            settingQTPenListDockingLayout2.setOnItemClickListener(new SettingQTPenListDockingLayout.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$openPenListView$penListLayout$1$1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout.OnItemClickListener
                public void onAddFavoriteClicked() {
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_ADD_FAVORITE_PEN, this.$this_run.floatingQT.getRotationType(), this.$this_run.floatingQT.getViewMode());
                    boolean z = this.$this_run.getDockingType() == SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING;
                    QuickToolPresenter presenter = this.$this_run.getPresenter();
                    ViewParent parent = this.$this_run.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    presenter.showAddFavoritePen((ViewGroup) parent, z);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout.OnItemClickListener
                public void onItemClicked(int position, boolean selected) {
                    List<SpenSettingUIPenInfo> penViewList;
                    AbstractC0000a.m3D(position, "onItemClicked() position=", "QuickToolContainer");
                    QuickToolPresenter.hideSettingViews$default(this.$this_run.getPresenter(), false, 1, null);
                    settingQTPenListDockingLayout2.selectPen(position, true);
                    if (isFavorite) {
                        this.$this_run.getPresenter().setCurrentFavoriteIndex(position);
                        penViewList = this.$this_run.getPresenter().getFavoriteInfoList();
                    } else {
                        this.$this_run.getPresenter().setCurrentFavoriteIndex(0);
                        settingQTPenListDockingLayout2.enableScroll(false);
                        penViewList = this.$this_run.getPresenter().getPenViewList();
                    }
                    this.$this_run.floatingQT.setPenInfoList(penViewList, position);
                    this.$this_run.dockingQT.setPenInfoList(penViewList, position);
                    this.$this_run.dockingQT.updateColor();
                    this.$this_run.getPresenter().onPenInfoChange(penViewList.get(position));
                    if (!isFavorite) {
                        QuickToolContainer.hideDockingPenList$default(this.$this_run, 0, null, 2, null);
                    }
                    if (selected) {
                        return;
                    }
                    QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
                    quickToolSA.log(QuickToolSA.EVENT_QT_SELECT_PEN_STYLE, quickToolSA.getSADetailPenType(penViewList.get(position).name));
                    if (isFavorite) {
                        quickToolSA.log(QuickToolSA.EVENT_QT_CHANGE_FAVORITE_PEN);
                    }
                }
            });
            settingQTPenListDockingLayout2.setPenInfoList(arrayList);
            settingQTPenListDockingLayout2.selectPen(indexSelect, false);
            settingQTPenListDockingLayout2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$openPenListView$penListLayout$1$2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = settingQTPenListDockingLayout2.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    this.setDockingPenList(settingQTPenListDockingLayout2);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(settingQTPenListDockingLayout2, layoutParams);
            settingQTPenListDockingLayout2.setY(settingQTPenListDockingLayout2.getY() - ResourceUtils.convertDpToPixel(getContext(), 3.5f));
            if (isFavorite) {
                settingQTPenListDockingLayout2.setY(settingQTPenListDockingLayout2.getY() - getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_favorite_margin));
                this.presenter.registerFavoriteInfoChangeListener(this.favoriteInfoChangeListener);
            }
            this.floatingQT.setVisibility(4);
            settingQTPenListDockingLayout = settingQTPenListDockingLayout2;
        }
        QuickToolCustomBackground quickToolCustomBackground = this.mBgView;
        if (quickToolCustomBackground != null) {
            QuickToolCustomBackground.setBGMode$default(quickToolCustomBackground, true, true, null, 4, null);
        }
        if (isFavorite) {
            setupCurvedSwitchLayout();
        }
        int height = getRootView().getHeight();
        int dimensionPixelSize = (getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_margin) * 2) + getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_pen_list_width);
        QuickToolPresenter quickToolPresenter2 = this.presenter;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int dimensionPixelSize2 = height > quickToolPresenter2.getNavigationBarHeight(context2) + dimensionPixelSize ? getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_margin) : 0;
        float y2 = getY() + getHeight();
        int height2 = getRootView().getHeight();
        QuickToolPresenter quickToolPresenter3 = this.presenter;
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        if (y2 > height2 - quickToolPresenter3.getNavigationBarHeight(r8)) {
            this.mDelegate.cancelAllSpringAnimation();
            this.currentY = getY();
            int height3 = getRootView().getHeight();
            QuickToolPresenter quickToolPresenter4 = this.presenter;
            Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
            animate().translationY(((height3 - quickToolPresenter4.getNavigationBarHeight(r9)) - getHeight()) - dimensionPixelSize2).setDuration(250L).start();
        } else if (getY() < this.presenter.getAppBarHeight()) {
            this.mDelegate.cancelAllSpringAnimation();
            this.currentY = getY();
            animate().translationY(this.presenter.getAppBarHeight() + dimensionPixelSize2).setDuration(250L).start();
        }
        settingQTPenListDockingLayout.setVisibility(0, true);
        this.penListType = isFavorite ? 2 : 1;
        QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
        quickToolSA.logFirstBehavior("1");
        quickToolSA.log(QuickToolSA.EVENT_QT_PEN_LIST, this.floatingQT.getRotationType());
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public final void reAttachQuickTool(float oldY) {
        toggleCenterView(this.dockingType == SpenSettingQTPenContainer.RotationType.NONE);
        setY(oldY);
        this.dockingQT.setVisibility(0);
        this.floatingQT.setVisibility(0);
        SpenSettingQTPenContainer.RotationType rotationType = this.dockingType;
        SpenSettingQTPenContainer.RotationType rotationType2 = SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING;
        if (rotationType == rotationType2) {
            View view = this.mCoverQT;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                view = null;
            }
            setX(view.getRight() - (getWidth() * 0.5f));
            this.dockingQT.setRotation(rotationType2);
            this.floatingQT.setRotation(rotationType2, false);
        } else {
            SpenSettingQTPenContainer.RotationType rotationType3 = SpenSettingQTPenContainer.RotationType.LEFT_DOCKING;
            if (rotationType == rotationType3) {
                setX((-getWidth()) * 0.5f);
                this.dockingQT.setRotation(rotationType3);
                this.floatingQT.setRotation(rotationType3, false);
            }
        }
        setMainViewActionListener();
    }

    public final void removeBgView() {
        QuickToolCustomBackground quickToolCustomBackground = this.mBgView;
        if (quickToolCustomBackground != null) {
            removeView(quickToolCustomBackground);
            quickToolCustomBackground.close();
            this.mBgView = null;
        }
    }

    public final void resetCoverQT() {
        this.presenter.updateQTContainer(getRootView().getWidth());
    }

    public final void restoreDocking(@NotNull SpenSettingQTPenContainer.RotationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
        View view = null;
        if (i == 1) {
            SettingQTPenContainer settingQTPenContainer = this.dockingQT;
            SpenSettingQTPenContainer.RotationType rotationType = SpenSettingQTPenContainer.RotationType.RIGHT_DOCKING;
            settingQTPenContainer.setRotation(rotationType);
            this.floatingQT.setRotation(rotationType, true);
            View view2 = this.mCoverQT;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
            } else {
                view = view2;
            }
            view.post(new RunnableC10739b(this, 1));
            return;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        SettingQTPenContainer settingQTPenContainer2 = this.dockingQT;
        SpenSettingQTPenContainer.RotationType rotationType2 = SpenSettingQTPenContainer.RotationType.LEFT_DOCKING;
        settingQTPenContainer2.setRotation(rotationType2);
        this.floatingQT.setRotation(rotationType2, true);
        View view3 = this.mCoverQT;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
        } else {
            view = view3;
        }
        view.post(new RunnableC10739b(this, 2));
    }

    public final void setColorTheme(int colorTheme) {
        this.mColorThemeUtil.setColorTheme(colorTheme);
        this.floatingQT.setColorTheme(colorTheme);
        this.dockingQT.setColorTheme(colorTheme);
    }

    public final void setCoverAndContainer(@NotNull ViewGroup container, @NotNull View coverQt) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(coverQt, "coverQt");
        this.mCoverQT = coverQt;
        if (this.mContainerLayoutChangeListener == null) {
            ViewOnLayoutChangeListenerC0162a viewOnLayoutChangeListenerC0162a = new ViewOnLayoutChangeListenerC0162a(this, 10);
            this.mContainerLayoutChangeListener = viewOnLayoutChangeListenerC0162a;
            container.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0162a);
        }
    }

    public final void setDockingCustomMode(@DrawableRes int unselectedResourceId, @DrawableRes int selectedResourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.dockingQT.setCustomMode(unselectedResourceId, selectedResourceId, description, view);
    }

    public final void setDockingType(@NotNull SpenSettingQTPenContainer.RotationType rotationType) {
        Intrinsics.checkNotNullParameter(rotationType, "<set-?>");
        this.dockingType = rotationType;
    }

    public final void setEyedropperEnabled(boolean enable) {
        this.floatingQT.setEyedropperEnabled(enable);
        this.dockingQT.setEyedropperEnabled(enable);
    }

    public final void setFavoriteInfoChangedListener(@NotNull SpenSettingQTPenContainer.PenInfoChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.floatingQT.setFavoriteInfoChangedListener(listener);
        this.dockingQT.setFavoriteInfoChangedListener(listener);
    }

    public final boolean setFavoriteList(@NotNull List<? extends SpenSettingUIPenInfo> list, int selectedIndex) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this.floatingQT.setFavoriteList(list, selectedIndex) && this.dockingQT.setFavoriteList(list, selectedIndex);
    }

    public final void setFavoriteListActionListener(@NotNull SpenSettingQTPenContainer.OnFavoriteListActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.floatingQT.setFavoriteListActionListener(listener);
    }

    public final void setFloatingCustomMode(@DrawableRes int unselectedResourceId, @DrawableRes int selectedResourceId, @Nullable CharSequence description, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.floatingQT.setCustomMode(view, unselectedResourceId, selectedResourceId, description, Integer.valueOf(getContext().getColor(C9086R.color.qt_note_assist_switch_background)));
    }

    public final void setOnAddButtonClickListener(@Nullable SpenSettingQTPenContainer.OnAddButtonClickListener listener) {
        this.floatingQT.setOnAddButtonClickListener(listener);
    }

    public final void setOnModeChangedListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.onModeChangedListener = function1;
    }

    public final void setPalette(@Nullable List<Integer> paletteList) {
        this.floatingQT.setPalette(paletteList);
        this.dockingQT.setPalette(paletteList);
    }

    public final void setPaletteActionButtonListener(@NotNull SpenSettingQTPenContainer.PaletteActionButtonListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.floatingQT.setPaletteActionButtonListener(listener);
        this.dockingQT.setPaletteActionButtonListener(listener);
    }

    public final void setPenInfoChangedListener(@NotNull SpenSettingQTPenContainer.PenInfoChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.floatingQT.setPenInfoChangedListener(listener);
        this.dockingQT.setPenInfoChangedListener(listener);
    }

    public final boolean setPenInfoList(@NotNull List<? extends SpenSettingUIPenInfo> uiInfoList, int currentPenIndex) {
        Intrinsics.checkNotNullParameter(uiInfoList, "uiInfoList");
        return this.floatingQT.setPenInfoList(uiInfoList, currentPenIndex) && this.dockingQT.setPenInfoList(uiInfoList, currentPenIndex);
    }

    public final void setPenListType(int i) {
        this.penListType = i;
    }

    public final void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        this.floatingQT.setRecentColor(recentList);
        this.dockingQT.setRecentColor(recentList);
    }

    public final void setRestrictionAiMode(boolean block) {
        if (!block) {
            this.floatingQT.clearModeAccess();
            return;
        }
        if (this.dockingQT.getMMode() == 2) {
            changeToMode$default(this, 0, false, 2, null);
        }
        this.floatingQT.restrictModeAccess(2, new SpenSettingQTPenContainer.OnModeAccessEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.setRestrictionAiMode.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnModeAccessEventListener
            public void onModeBlocked() {
                ToastHandler.show(QuickToolContainer.this.getContext(), C9086R.string.block_assist_quick_tool_notice, 0);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnModeAccessEventListener
            public void onModeChangeStart(int mode) {
                QuickToolContainer.this.draggingStartMode = mode;
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer.OnModeAccessEventListener
            public void onModeChangedEnd(int mode) {
                if (mode != 2 || QuickToolContainer.this.draggingStartMode == mode) {
                    return;
                }
                ToastHandler.show(QuickToolContainer.this.getContext(), C9086R.string.block_assist_quick_tool_notice, 0);
                QuickToolContainer quickToolContainer = QuickToolContainer.this;
                QuickToolContainer.changeToMode$default(quickToolContainer, quickToolContainer.draggingStartMode, false, 2, null);
            }
        });
    }

    public final boolean setVisibilityWithAnimation(int visibility, @Nullable OnVisibilityAnimationListener listener) {
        if (visibility == 8) {
            this.dockingQT.setVisibilityWithAnimation(visibility, null);
        }
        return this.floatingQT.setVisibilityWithAnimation(visibility, listener);
    }

    public final void startMoveOutDockingAnimation(float targetX, float targetY) {
        if (this.flying) {
            return;
        }
        this.dockingType = SpenSettingQTPenContainer.RotationType.NONE;
        this.mDelegate.startMoveOutDockingAnimation(targetX, targetY, new C10744d(this, 1), new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.startMoveOutDockingAnimation.2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation<?> animation, float value, float velocity) {
                SpenSettingQTPenContainer.RotationType rotationType = QuickToolContainer.this.floatingQT.getRotationType();
                SpenSettingQTPenContainer.RotationType rotationType2 = SpenSettingQTPenContainer.RotationType.NONE;
                if (rotationType == rotationType2) {
                    return;
                }
                float width = (QuickToolContainer.this.getWidth() + value) - QuickToolContainer.this.getMDelta();
                View view = QuickToolContainer.this.mCoverQT;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverQT");
                    view = null;
                }
                if (width > view.getWidth() || QuickToolContainer.this.getMDelta() + value < 0.0f) {
                    Logger.m10999d(QuickToolContainer.TAG, "startMoveOutDockingAnimation# onAnimationUpdate value = " + value);
                    QuickToolContainer.this.floatingQT.setRotation(rotationType2, true);
                    QuickToolContainer.this.clearMainViewActionListener();
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QuickToolContainer(@NotNull Context context, @NotNull QuickToolPresenter presenter, boolean z, @NotNull QTVisibilityHandler visibilityHandler) {
        this(context, presenter, z, false, visibilityHandler, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(visibilityHandler, "visibilityHandler");
    }

    @NotNull
    /* JADX INFO: renamed from: getViewMode, reason: collision with other method in class */
    public final SettingQTPenLayout.ViewMode m22191getViewMode() {
        return this.dockingQT.getViewMode();
    }

    public /* synthetic */ QuickToolContainer(Context context, QuickToolPresenter quickToolPresenter, boolean z, boolean z2, QTVisibilityHandler qTVisibilityHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, quickToolPresenter, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2, qTVisibilityHandler);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$favoriteInfoChangeListener$1] */
    @JvmOverloads
    public QuickToolContainer(@NotNull Context context, @NotNull QuickToolPresenter presenter, boolean z, boolean z2, @NotNull QTVisibilityHandler visibilityHandler) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(visibilityHandler, "visibilityHandler");
        this.presenter = presenter;
        this.visibilityHandler = visibilityHandler;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mGestureDetector = new GestureDetector(context, new FloaterGestureListener());
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.dockingType = SpenSettingQTPenContainer.RotationType.NONE;
        this.draggingStartMode = -1;
        this.currentY = -1.0f;
        this.halfDockingWidth = getResources().getDimension(C9086R.dimen.qt_docking_half_width);
        float dimension = getResources().getDimension(C9086R.dimen.qt_docking_pen_list_width);
        this.size = dimension;
        float dimension2 = (dimension - getResources().getDimension(C9086R.dimen.composer_qt_circle_default_size)) * 0.5f;
        this.mDelta = dimension2;
        this.touchScaleAnimation = new QTTouchScaleAnimation(this);
        this.mDelegate = new QuickToolDelegate(this, dimension2);
        setLayoutDirection(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        SettingQTPenContainer settingQTPenContainer = new SettingQTPenContainer(context, z, z2);
        this.dockingQT = settingQTPenContainer;
        settingQTPenContainer.setVisibility(8);
        addView(settingQTPenContainer, layoutParams);
        SpenSettingQTPenContainer spenSettingQTPenContainer = new SpenSettingQTPenContainer(context, z, z2);
        this.floatingQT = spenSettingQTPenContainer;
        addView(spenSettingQTPenContainer, layoutParams);
        setColorTheme(presenter.getColorTheme());
        spenSettingQTPenContainer.setOnModeChangedListener(new SpenSettingQTContainer.OnModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer.OnModeChangedListener
            public void onModeChanged(int mode) {
                if (QuickToolContainer.this.mPenListLayout != null) {
                    QuickToolContainer quickToolContainer = QuickToolContainer.this;
                    SettingQTPenListDockingLayout settingQTPenListDockingLayout = quickToolContainer.mPenListLayout;
                    Intrinsics.checkNotNull(settingQTPenListDockingLayout);
                    if (quickToolContainer.indexOfChild(settingQTPenListDockingLayout) != -1) {
                        return;
                    }
                }
                QuickToolContainer.this.onModeChange(mode);
            }
        });
        spenSettingQTPenContainer.setViewModeChangedListener(new SpenSettingQTPenLayout.OnViewModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer.2

            /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$2$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SpenSettingQTPenLayout.ViewMode.values().length];
                    try {
                        iArr[SpenSettingQTPenLayout.ViewMode.PEN_LIST.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SpenSettingQTPenLayout.ViewMode.COLOR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SpenSettingQTPenLayout.ViewMode.ATTRIBUTES.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SpenSettingQTPenLayout.ViewMode.COLOR_PICKER.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout.OnViewModeChangedListener
            public void onViewModeChanged(SpenSettingQTPenLayout.ViewMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                if (i == 1) {
                    QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
                    quickToolSA.logFirstBehavior("1");
                    quickToolSA.log(QuickToolSA.EVENT_QT_PEN_LIST, QuickToolContainer.this.floatingQT.getRotationType());
                } else if (i == 2) {
                    QuickToolSA quickToolSA2 = QuickToolSA.INSTANCE;
                    quickToolSA2.logFirstBehavior("3");
                    quickToolSA2.log(QuickToolSA.EVENT_QT_COLOR_LIST, QuickToolContainer.this.floatingQT.getRotationType());
                } else if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    QuickToolSA.INSTANCE.log(QuickToolSA.EVENT_QT_COLOR_PICKER, QuickToolContainer.this.floatingQT.getRotationType());
                } else {
                    QuickToolSA quickToolSA3 = QuickToolSA.INSTANCE;
                    quickToolSA3.logFirstBehavior("2");
                    quickToolSA3.log(QuickToolSA.EVENT_QT_THICKNESS_AND_TRANSPARENCY, QuickToolContainer.this.floatingQT.getRotationType());
                }
            }
        });
        setMainViewActionListener();
        int i = (int) dimension;
        setLayoutParams(new FrameLayout.LayoutParams(i, i));
        this.expandAnimation = new RunnableC10739b(this, 0);
        SpringForce stiffness = new SpringForce().setDampingRatio(0.75f).setStiffness(300.0f);
        SpringAnimation spring = new SpringAnimation(this, DynamicAnimation.SCALE_X).setSpring(stiffness);
        Intrinsics.checkNotNullExpressionValue(spring, "setSpring(...)");
        this.scaleXAnimator = spring;
        SpringAnimation spring2 = new SpringAnimation(this, DynamicAnimation.SCALE_Y).setSpring(stiffness);
        Intrinsics.checkNotNullExpressionValue(spring2, "setSpring(...)");
        this.scaleYAnimator = spring2;
        this.favoriteInfoChangeListener = new SettingFavoritePenData.FavoritePenInfoChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer$favoriteInfoChangeListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoriteIndexChanged(int index) {
                ArrayList arrayList = new ArrayList();
                this.this$0.getFavoritePenViewList(arrayList);
                SettingQTPenListDockingLayout settingQTPenListDockingLayout = this.this$0.mPenListLayout;
                if (settingQTPenListDockingLayout != null) {
                    settingQTPenListDockingLayout.notifyItemChange(arrayList, false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.FavoritePenInfoChangeListener
            public void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> favorites) {
                Intrinsics.checkNotNullParameter(favorites, "favorites");
                ArrayList arrayList = new ArrayList();
                this.this$0.getFavoritePenViewList(arrayList);
                SettingQTPenListDockingLayout settingQTPenListDockingLayout = this.this$0.mPenListLayout;
                if (settingQTPenListDockingLayout != null) {
                    SettingQTPenListDockingLayout.notifyItemChange$default(settingQTPenListDockingLayout, arrayList, false, 2, null);
                }
            }
        };
    }
}
