package com.google.android.material.oneui.floatingactioncontainer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.oneui.common.BlurSupportable;
import androidx.appcompat.oneui.common.internal.policy.BlurInfoState;
import androidx.appcompat.oneui.common.internal.resource.OpenThemeResourceDrawableRes;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceDrawableRes;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.SeslScrollable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.oneui.common.internal.MaterialLogTag;
import com.google.android.material.oneui.common.internal.animation.ResizeAnimation;
import com.google.android.material.oneui.common.internal.util.ViewHelperKt;
import com.google.android.material.oneui.floatingactioncontainer.FloatingAware;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import com.google.android.material.oneui.floatingactioncontainer.behavior.AppBarScrollBehavior;
import com.google.android.material.oneui.floatingactioncontainer.manager.FloatingScrollableManager;
import com.google.android.material.oneui.floatingactioncontainer.manager.SeslScrollableListener;
import com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p004A2.ViewTreeObserverOnPreDrawListenerC0014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u0000±\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b%*\u0003\r.U\b\u0017\u0018\u0000 ó\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\nó\u0001ô\u0001õ\u0001ö\u0001÷\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020j2\u0006\u0010l\u001a\u00020\u0011H\u0002J\u0014\u0010m\u001a\u00020j2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00160oJ\u000e\u0010p\u001a\u00020j2\u0006\u0010q\u001a\u00020rJ\u000e\u0010s\u001a\u00020j2\u0006\u0010q\u001a\u00020&J\u0010\u0010t\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010u\u001a\u00020jH\u0002J$\u0010v\u001a\u00020j2\b\u0010w\u001a\u0004\u0018\u00010\u00162\u0006\u0010x\u001a\u00020\n2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010{\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010|\u001a\u00020jH\u0015J\u0015\u0010}\u001a\u00020j2\u0006\u0010~\u001a\u00020\nH\u0000¢\u0006\u0002\b\u007fJ\t\u0010\u0080\u0001\u001a\u00020jH\u0004J\u0011\u0010\u0081\u0001\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0007\u0010\u0082\u0001\u001a\u00020jJ\t\u0010\u0083\u0001\u001a\u00020jH\u0002J\u000f\u0010\u0084\u0001\u001a\u00020j2\u0006\u0010q\u001a\u00020&J\t\u0010\u0085\u0001\u001a\u00020jH\u0002J\t\u0010\u0086\u0001\u001a\u00020jH\u0002J\t\u0010\u0087\u0001\u001a\u00020jH\u0002J\t\u0010\u0088\u0001\u001a\u00020jH\u0002J\u0007\u0010\u0089\u0001\u001a\u00020jJ\u0010\u0010\u008a\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020\nJ\u0010\u0010\u008c\u0001\u001a\u00020j2\u0007\u0010\u008d\u0001\u001a\u00020\u0011J\u0007\u0010\u008e\u0001\u001a\u00020jJ\u001a\u0010\u001b\u001a\u00020j2\u0007\u0010\u008d\u0001\u001a\u00020\u00112\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0011J\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0000¢\u0006\u0003\b\u0092\u0001J\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\u000e\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160oH\u0000¢\u0006\u0003\b\u0092\u0001J\u000e\u0010\u0093\u0001\u001a\u0007\u0012\u0002\b\u00030\u0094\u0001H\u0016J\u000f\u0010\u0095\u0001\u001a\u00020\u001dH\u0000¢\u0006\u0003\b\u0096\u0001J\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0000¢\u0006\u0003\b\u0099\u0001J\u0012\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010=J\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0010¢\u0006\u0003\b\u009f\u0001J\t\u0010 \u0001\u001a\u0004\u0018\u00010KJ\u000b\u0010¡\u0001\u001a\u0004\u0018\u00010SH\u0002J\u000b\u0010¢\u0001\u001a\u0004\u0018\u00010SH\u0002J\b\u0010£\u0001\u001a\u00030¤\u0001J\u0007\u0010¥\u0001\u001a\u00020jJ\t\u0010¦\u0001\u001a\u00020jH\u0002J\t\u0010§\u0001\u001a\u00020\u0011H\u0016J\u0007\u0010¨\u0001\u001a\u00020\u0011J\u0007\u0010©\u0001\u001a\u00020\u0011J\u0007\u0010ª\u0001\u001a\u00020\u0011J\u0012\u0010«\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u00ad\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010®\u0001\u001a\u00020j2\u0007\u0010¯\u0001\u001a\u00020`H\u0002J\u001c\u0010°\u0001\u001a\u00020j2\b\u0010±\u0001\u001a\u00030\u0091\u00012\u0007\u0010²\u0001\u001a\u00020\nH\u0016J\t\u0010³\u0001\u001a\u00020jH\u0014J\u0015\u0010´\u0001\u001a\u00020\u00112\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J6\u0010·\u0001\u001a\u00020j2\u0007\u0010¸\u0001\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010º\u0001\u001a\u00020\n2\u0007\u0010»\u0001\u001a\u00020\n2\u0007\u0010¼\u0001\u001a\u00020\nH\u0014J\u001b\u0010½\u0001\u001a\u00020j2\u0007\u0010¾\u0001\u001a\u00020\n2\u0007\u0010¿\u0001\u001a\u00020\nH\u0014J\u0012\u0010À\u0001\u001a\u00020j2\u0007\u0010Á\u0001\u001a\u00020\nH\u0014J\t\u0010Â\u0001\u001a\u00020jH\u0002J\u0015\u0010Ã\u0001\u001a\u00020j2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00160oJ\u000f\u0010Ä\u0001\u001a\u00020j2\u0006\u0010q\u001a\u00020&J\u000f\u0010Å\u0001\u001a\u00020jH\u0000¢\u0006\u0003\bÆ\u0001J\u0012\u0010Ç\u0001\u001a\u00020j2\u0007\u0010È\u0001\u001a\u00020\nH\u0016J\u0012\u0010É\u0001\u001a\u00020j2\t\b\u0001\u0010Ê\u0001\u001a\u00020\nJ\u0012\u0010Ë\u0001\u001a\u00020j2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0017J\u001a\u0010Í\u0001\u001a\u00020j2\t\u0010Î\u0001\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0003\u0010Ï\u0001J\u0013\u0010Ð\u0001\u001a\u00020j2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0013\u0010Ñ\u0001\u001a\u00020j2\b\u0010Ò\u0001\u001a\u00030Ó\u0001H\u0007J\u0019\u0010Ô\u0001\u001a\u00020j2\b\u0010q\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0003\bÕ\u0001J&\u0010Ö\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020\u00112\t\b\u0002\u0010×\u0001\u001a\u00020\u00112\t\b\u0002\u0010Ø\u0001\u001a\u00020\u0011J\u0012\u0010Ù\u0001\u001a\u00020j2\u0007\u0010Ú\u0001\u001a\u00020=H\u0016J\t\u0010Û\u0001\u001a\u00020jH\u0016J\u0012\u0010Ü\u0001\u001a\u00020j2\u0007\u0010Ý\u0001\u001a\u00020KH\u0016J\u0012\u0010Þ\u0001\u001a\u00020j2\t\b\u0001\u0010ß\u0001\u001a\u00020\nJ\u0010\u0010à\u0001\u001a\u00020j2\u0007\u0010á\u0001\u001a\u00020\nJ\u001b\u0010â\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020\u00112\t\b\u0002\u0010ã\u0001\u001a\u00020\u0011J\u0012\u0010ä\u0001\u001a\u00020j2\t\b\u0002\u0010ã\u0001\u001a\u00020\u0011J\u000f\u0010å\u0001\u001a\u00020jH\u0000¢\u0006\u0003\bæ\u0001J!\u0010ç\u0001\u001a\u00020j2\u0007\u0010è\u0001\u001a\u00020`2\u0007\u0010é\u0001\u001a\u00020`H\u0010¢\u0006\u0003\bê\u0001J,\u0010ë\u0001\u001a\u00020j2\u0007\u0010è\u0001\u001a\u00020`2\u0007\u0010é\u0001\u001a\u00020`2\t\b\u0002\u0010ì\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\bí\u0001J(\u0010î\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020\u00112\t\b\u0002\u0010ï\u0001\u001a\u00020\u00112\t\b\u0002\u0010Ø\u0001\u001a\u00020\u0011H\u0002J\u000f\u0010ð\u0001\u001a\u00020jH\u0000¢\u0006\u0003\bñ\u0001J\t\u0010ò\u0001\u001a\u00020jH\u0002R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u001e\u00100\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00106\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0010\u0010I\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u001a\u0010W\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010Y\"\u0004\bh\u0010[¨\u0006ø\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "Landroidx/appcompat/oneui/common/BlurSupportable;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alphaAnimListener", "com/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$alphaAnimListener$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$alphaAnimListener$1;", "appBarVerticalOffset", "applyFloatingItemBackgroundBlur", "", "getAttrs", "()Landroid/util/AttributeSet;", "blurInvalidateTargetViews", "", "Landroid/view/View;", "Landroid/graphics/Rect;", "customPadding", "delayShowRunnable", "Ljava/lang/Runnable;", "enableScrollTransition", "floatingAware", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware;", "hideStartScrollRange", "isFirstLayout", "layoutAlphaAnimationListener", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$OnAlphaAnimationListener;", "layoutAlphaAnimator", "Landroid/animation/ObjectAnimator;", "layoutStateListener", "", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingLayoutStateChangeListener;", "lifeCycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "mAlphaAnimProperty", "com/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$mAlphaAnimProperty$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$mAlphaAnimProperty$1;", "manageFadingEdgeBottomOffset", "getManageFadingEdgeBottomOffset", "()Ljava/lang/Boolean;", "setManageFadingEdgeBottomOffset", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "manageGoToTopOffset", "getManageGoToTopOffset", "setManageGoToTopOffset", "nestedScrollAttachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "nestedScrollViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/core/widget/NestedScrollView;", "onPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "postInvalidateHandler", "Landroid/os/Handler;", "postShowHandler", "projectionView", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView;", "getProjectionView$material_release", "()Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView;", "recyclerAttachStateChangeListener", "recyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "requestUpdatePosted", "resetHideTransitionRunnable", "scaleSpringAnimation", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scrollIdleCheckHandler", "scrollabelViewRef", "Landroidx/core/widget/SeslScrollable;", "scrollableListener", "com/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$scrollableListener$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$scrollableListener$1;", "showBackgroundAtFirst", "getShowBackgroundAtFirst$material_release", "()Z", "setShowBackgroundAtFirst$material_release", "(Z)V", "startBackgroundItemAnimationOnAnimEnd", "totalScrollY", "touchSlop", "viewTargetAlpha", "", "windowInsetBottom", "getWindowInsetBottom", "()I", "setWindowInsetBottom", "(I)V", "withAppBarLayout", "getWithAppBarLayout$material_release", "setWithAppBarLayout$material_release", "OnAlphaAnimationEnded", "", "OnAlphaAnimationStarted", "toShow", "addBlurInvalidateTargetViews", "views", "", "addFloatingBackgroundAnimatorListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/Animator$AnimatorListener;", "addLayoutStateListener", "addOrReplaceLifeCycleObserverForScrollable", "addProjectionBgView", "addView", "child", "index", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "applyBlurInfo", "applyScrollableViewOptions", "checkAndRunHideTransition", "dy", "checkAndRunHideTransition$material_release", "checkDependenceToAppBar", "clearBlurInfo", "clearBlurInvalidateTargetView", "clearFloatingScrollableView", "clearLayoutStateListener", "clearNestedScroll", "clearPostInvalidateHandler", "clearRecyclerView", "clearScrollable", "disableAutoGoToTopOffsetMove", "dpToPx", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "enableAutoFadingEdgeBottomOffset", "enable", "enableAutoGoToTopOffsetMove", Constants.IntentExtraValue.SHOW, "getAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayout$material_release", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getFloatingAware", "getFloatingAware$material_release", "getFloatingScrollableManager", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager;", "getFloatingScrollableManager$material_release", "getLifeCycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "getNestedScrollView", "getOnGoToTopClickListener", "Landroidx/core/widget/SeslScrollable$SeslOnGoToTopClickListener;", "getOnGoToTopClickListener$material_release", "getRecyclerView", "getScrollable", "getScrollableView", "getVisibleState", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingLayoutState;", "invalidateBlurTargetView", "invalidateBlurViewsIfNeed", "isBlurApplied", "isEnabledScrollTransition", "isShowingFloatingItemBackground", "isVisible", "needInvalidate", "view", "needInvalidateBlurViews", "onAlphaAnimationProgress", "value", "onAppBarOffsetChanged", "appBarLayout", "verticalOffset", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onWindowVisibilityChanged", "visibility", "registerScrollInvalidate", "removeBlurInvalidateTargetViews", "removeLayoutStateListener", "resetHideTransitionCondition", "resetHideTransitionCondition$material_release", "setBlurMode", "semBlurInfoMode", "setColorForFloatingBackground", "color", "setCustomPadding", "paddingRect", "setElevationForFloatingBackground", "elevation", "(Ljava/lang/Float;)V", "setFloatingAware", "setFloatingScrollableAdapter", "floatingScrollableAdapter", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "setLayoutAlphaAnimationListener", "setLayoutAlphaAnimationListener$material_release", "setLayoutVisibility", "animation", NotesSyncRpcProvider.FORCE_SYNC, "setNestedScrollView", "nestedScrollView", "setPaddingForElevation", "setRecyclerView", "recyclerView", "setTintForFloatingBackground", "tintColor", "setWindowBottomInset", TypedValues.Cycle.S_WAVE_OFFSET, "showFloatingItemBackground", "animate", "startFloatingItemBackgroundRectAnimation", "startPostShowRunnable", "startPostShowRunnable$material_release", "startSpringScaleAnimation", "oldValue", "newValue", "startSpringScaleAnimation$material_release", "startSpringScaleAnimationInternal", "targetView", "startSpringScaleAnimationInternal$material_release", "startViewAlphaAnimation", "immediately", "stopPostShowRunnable", "stopPostShowRunnable$material_release", "updateVisibleLayoutState", "Companion", "FloatingActionBehavior", "FloatingGroupAware", "OnAlphaAnimationListener", "SeslProjectionView", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingGroupLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Handler.kt\nandroidx/core/os/HandlerKt\n*L\n1#1,1625:1\n1855#2,2:1626\n1855#2,2:1628\n1855#2,2:1630\n1855#2,2:1633\n800#2,11:1635\n1855#2,2:1646\n800#2,11:1648\n1855#2,2:1659\n800#2,11:1661\n1855#2,2:1672\n800#2,11:1674\n1747#2,3:1685\n1#3:1632\n33#4,12:1688\n*S KotlinDebug\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout\n*L\n943#1:1626,2\n1274#1:1628,2\n1280#1:1630,2\n1517#1:1633,2\n1528#1:1635,11\n1529#1:1646,2\n1539#1:1648,11\n1540#1:1659,2\n1550#1:1661,11\n1551#1:1672,2\n1555#1:1674,11\n1556#1:1685,3\n178#1:1688,12\n*E\n"})
public class FloatingGroupLayout extends FrameLayout implements CoordinatorLayout.AttachedBehavior, BlurSupportable, MaterialLogTag {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_ANIMATION = true;
    private static final boolean DEBUG_PRE_DRAW = false;

    @NotNull
    private static final String TAG = "FloatingGroupLayout";
    private static final long UPDATE_POST_DELAY = 10;
    public static final int VIEW_INDEX_CONTENT = 1;
    public static final int VIEW_INDEX_PROJECTION_VIEW = 0;

    @NotNull
    private final FloatingGroupLayout$alphaAnimListener$1 alphaAnimListener;
    private int appBarVerticalOffset;
    private boolean applyFloatingItemBackgroundBlur;

    @Nullable
    private final AttributeSet attrs;

    @NotNull
    private final Map<View, Rect> blurInvalidateTargetViews;

    @Nullable
    private Rect customPadding;

    @NotNull
    private Runnable delayShowRunnable;
    private boolean enableScrollTransition;

    @Nullable
    private FloatingAware floatingAware;
    private final int hideStartScrollRange;
    private boolean isFirstLayout;

    @Nullable
    private OnAlphaAnimationListener layoutAlphaAnimationListener;

    @NotNull
    private ObjectAnimator layoutAlphaAnimator;

    @NotNull
    private List<FloatingLayoutStateChangeListener> layoutStateListener;

    @Nullable
    private LifecycleObserver lifeCycleObserver;

    @NotNull
    private final FloatingGroupLayout$mAlphaAnimProperty$1 mAlphaAnimProperty;

    @Nullable
    private Boolean manageFadingEdgeBottomOffset;

    @Nullable
    private Boolean manageGoToTopOffset;

    @Nullable
    private View.OnAttachStateChangeListener nestedScrollAttachStateChangeListener;

    @Nullable
    private WeakReference<NestedScrollView> nestedScrollViewRef;

    @NotNull
    private final ViewTreeObserver.OnPreDrawListener onPreDrawListener;

    @NotNull
    private final Handler postInvalidateHandler;

    @NotNull
    private final Handler postShowHandler;

    @NotNull
    private final SeslProjectionView projectionView;

    @Nullable
    private View.OnAttachStateChangeListener recyclerAttachStateChangeListener;

    @Nullable
    private WeakReference<RecyclerView> recyclerViewRef;
    private boolean requestUpdatePosted;

    @NotNull
    private Runnable resetHideTransitionRunnable;

    @Nullable
    private DynamicAnimation<SpringAnimation> scaleSpringAnimation;

    @NotNull
    private final Handler scrollIdleCheckHandler;

    @Nullable
    private WeakReference<SeslScrollable> scrollabelViewRef;

    @NotNull
    private final FloatingGroupLayout$scrollableListener$1 scrollableListener;
    private boolean showBackgroundAtFirst;
    private boolean startBackgroundItemAnimationOnAnimEnd;
    private int totalScrollY;
    private int touchSlop;
    private float viewTargetAlpha;
    private int windowInsetBottom;
    private boolean withAppBarLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ%\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$FloatingActionBehavior;", "T", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/behavior/AppBarScrollBehavior;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "prevProgress", "", "reserveLayoutHide", "", "tmpRect", "Landroid/graphics/Rect;", "onLayoutChild", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "layoutDirection", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;I)Z", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class FloatingActionBehavior<T extends FloatingGroupLayout> extends AppBarScrollBehavior<T> implements MaterialLogTag {
        private float prevProgress;
        private boolean reserveLayoutHide;

        @NotNull
        private Rect tmpRect;

        public /* synthetic */ FloatingActionBehavior(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        @Override // androidx.core.oneui.common.internal.log.LogTag
        @NotNull
        public String getLogTag() {
            return "FloatingActionBehavior";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatingActionBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            this.tmpRect = new Rect();
            this.prevProgress = -1.0f;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull T child, int layoutDirection) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            if (child.getShowBackgroundAtFirst() && child.getProjectionView().getParent() != null) {
                child.getProjectionView().startProjectionViewItemAnimation(true);
                child.getProjectionView().startProjectionViewAlphaAnimation(1.0f, true);
            }
            return super.onLayoutChild(parent, child, layoutDirection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$FloatingGroupAware;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware;", "floatingGroupLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;)V", "getReferenceView", "Landroid/view/View;", "type", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class FloatingGroupAware implements FloatingAware {

        @Nullable
        private final FloatingGroupLayout floatingGroupLayout;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FloatingAware.PositionType.values().length];
                try {
                    iArr[FloatingAware.PositionType.START_FIRST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FloatingGroupAware() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
        @Nullable
        public View getReferenceView(@NotNull FloatingAware.PositionType type) {
            FloatingGroupLayout floatingGroupLayout;
            Intrinsics.checkNotNullParameter(type, "type");
            if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] != 1 || (floatingGroupLayout = this.floatingGroupLayout) == null) {
                return null;
            }
            return floatingGroupLayout.getChildAt(1);
        }

        public FloatingGroupAware(@Nullable FloatingGroupLayout floatingGroupLayout) {
            this.floatingGroupLayout = floatingGroupLayout;
        }

        public /* synthetic */ FloatingGroupAware(FloatingGroupLayout floatingGroupLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : floatingGroupLayout);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$OnAlphaAnimationListener;", "", "onEnd", "", "onProgress", "alpha", "", "onStart", "toShow", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnAlphaAnimationListener {
        void onEnd();

        void onProgress(float alpha);

        void onStart(boolean toShow);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingGroupLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void OnAlphaAnimationEnded() {
        OnAlphaAnimationListener onAlphaAnimationListener = this.layoutAlphaAnimationListener;
        if (onAlphaAnimationListener != null) {
            onAlphaAnimationListener.onEnd();
        }
    }

    private final void OnAlphaAnimationStarted(boolean toShow) {
        OnAlphaAnimationListener onAlphaAnimationListener = this.layoutAlphaAnimationListener;
        if (onAlphaAnimationListener != null) {
            onAlphaAnimationListener.onStart(toShow);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addOrReplaceLifeCycleObserverForScrollable(Context context) {
        if (context instanceof LifecycleOwner) {
            LifecycleObserver lifecycleObserver = this.lifeCycleObserver;
            if (lifecycleObserver != null) {
                ((LifecycleOwner) context).getLifecycle().removeObserver(lifecycleObserver);
            }
            DefaultLifecycleObserver lifeCycleObserver = getLifeCycleObserver(context);
            this.lifeCycleObserver = lifeCycleObserver;
            if (lifeCycleObserver != null) {
                ((LifecycleOwner) context).getLifecycle().addObserver(lifeCycleObserver);
            }
        }
    }

    private final void addProjectionBgView() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        if (indexOfChild(this.projectionView) != 0) {
            removeView(this.projectionView);
            super.addView(this.projectionView, 0, layoutParams);
        }
        registerScrollInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearFloatingScrollableView() {
        getFloatingScrollableManager$material_release().removeSeslScrollableListener(this.scrollableListener);
        clearRecyclerView();
        clearNestedScroll();
        clearScrollable();
    }

    private final void clearNestedScroll() {
        WeakReference<NestedScrollView> weakReference = this.nestedScrollViewRef;
        NestedScrollView nestedScrollView = weakReference != null ? weakReference.get() : null;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.nestedScrollAttachStateChangeListener;
        if (onAttachStateChangeListener != null && nestedScrollView != null) {
            nestedScrollView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.nestedScrollAttachStateChangeListener = null;
        FloatingScrollableManager.INSTANCE.clearInstance(this, nestedScrollView);
        WeakReference<NestedScrollView> weakReference2 = this.nestedScrollViewRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.nestedScrollViewRef = null;
    }

    private final void clearPostInvalidateHandler() {
        this.postInvalidateHandler.removeCallbacksAndMessages(null);
        this.requestUpdatePosted = false;
    }

    private final void clearRecyclerView() {
        WeakReference<RecyclerView> weakReference = this.recyclerViewRef;
        RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.recyclerAttachStateChangeListener;
        if (onAttachStateChangeListener != null && recyclerView != null) {
            recyclerView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.recyclerAttachStateChangeListener = null;
        FloatingScrollableManager.INSTANCE.clearInstance(this, recyclerView);
        WeakReference<RecyclerView> weakReference2 = this.recyclerViewRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.recyclerViewRef = null;
    }

    private final void clearScrollable() {
        FloatingScrollableManager.INSTANCE.clearInstance(this, getScrollable());
        WeakReference<SeslScrollable> weakReference = this.scrollabelViewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.scrollabelViewRef = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayShowRunnable$lambda$1(FloatingGroupLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resetHideTransitionCondition$material_release();
        startViewAlphaAnimation$default(this$0, true, false, false, 6, null);
    }

    public static /* synthetic */ void enableScrollTransition$default(FloatingGroupLayout floatingGroupLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableScrollTransition");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        floatingGroupLayout.enableScrollTransition(z, z2);
    }

    private final DefaultLifecycleObserver getLifeCycleObserver(Context context) {
        return new DefaultLifecycleObserver() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.getLifeCycleObserver.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                FloatingGroupLayout.this.clearFloatingScrollableView();
                owner.getLifecycle().removeObserver(this);
            }
        };
    }

    private final SeslScrollable getScrollable() {
        WeakReference<SeslScrollable> weakReference = this.scrollabelViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final SeslScrollable getScrollableView() {
        SeslScrollable recyclerView = getRecyclerView();
        if (recyclerView == null) {
            recyclerView = getNestedScrollView();
        }
        return recyclerView == null ? getScrollable() : recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateBlurViewsIfNeed() {
        if (needInvalidateBlurViews()) {
            for (View view : this.blurInvalidateTargetViews.keySet()) {
                if (needInvalidate(view)) {
                    view.invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean needInvalidate(View view) {
        if (view.getVisibility() == 0 && (view instanceof BlurSupportable)) {
            return ((BlurSupportable) view).isBlurApplied();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAlphaAnimationProgress(float value) {
        OnAlphaAnimationListener onAlphaAnimationListener = this.layoutAlphaAnimationListener;
        if (onAlphaAnimationListener != null) {
            onAlphaAnimationListener.onProgress(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayout$lambda$14(FloatingGroupLayout this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 0 || this$0.appBarVerticalOffset != i) {
            this$0.appBarVerticalOffset = i;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
            this$0.onAppBarOffsetChanged(appBarLayout, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onPreDrawListener$lambda$6(final FloatingGroupLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ArrayList arrayList = new ArrayList();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<View, Rect> map = this$0.blurInvalidateTargetViews;
        final Function2<View, Rect, Unit> function2 = new Function2<View, Rect, Unit>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$onPreDrawListener$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Rect rect) {
                invoke2(view, rect);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, Rect prePos) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(prePos, "prePos");
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect) || Intrinsics.areEqual(prePos, rect)) {
                    return;
                }
                arrayList.add(view);
                linkedHashMap.put(view, rect);
            }
        };
        final int i = 0;
        map.forEach(new BiConsumer() { // from class: com.google.android.material.oneui.floatingactioncontainer.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        FloatingGroupLayout.onPreDrawListener$lambda$6$lambda$2(function2, obj, obj2);
                        break;
                    default:
                        FloatingGroupLayout.onPreDrawListener$lambda$6$lambda$5(function2, obj, obj2);
                        break;
                }
            }
        });
        if (!arrayList.isEmpty() && !this$0.requestUpdatePosted) {
            this$0.requestUpdatePosted = true;
            this$0.postInvalidateHandler.postDelayed(new Runnable() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$onPreDrawListener$lambda$6$$inlined$postDelayed$default$1
                @Override // java.lang.Runnable
                public final void run() {
                    LogTagHelperKt.debug(this.this$0, "onPreDraw position Change invalidateBlurTargetView " + arrayList);
                    for (View view : arrayList) {
                        if (this.this$0.needInvalidate(view)) {
                            view.invalidate();
                        }
                    }
                    this.this$0.requestUpdatePosted = false;
                }
            }, 10L);
            LogTagHelperKt.debug(this$0, "OnPreDrawListener invalidateRect=" + linkedHashMap);
            final Function2<View, Rect, Unit> function22 = new Function2<View, Rect, Unit>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$onPreDrawListener$1$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, Rect rect) {
                    invoke2(view, rect);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view, Rect rect) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(rect, "rect");
                    if (this.this$0.blurInvalidateTargetViews.containsKey(view)) {
                        this.this$0.blurInvalidateTargetViews.put(view, rect);
                    }
                }
            };
            final int i2 = 1;
            linkedHashMap.forEach(new BiConsumer() { // from class: com.google.android.material.oneui.floatingactioncontainer.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    switch (i2) {
                        case 0:
                            FloatingGroupLayout.onPreDrawListener$lambda$6$lambda$2(function22, obj, obj2);
                            break;
                        default:
                            FloatingGroupLayout.onPreDrawListener$lambda$6$lambda$5(function22, obj, obj2);
                            break;
                    }
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreDrawListener$lambda$6$lambda$2(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreDrawListener$lambda$6$lambda$5(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj, obj2);
    }

    private final void registerScrollInvalidate() {
        if (Build.VERSION.SDK_INT >= 35) {
            addBlurInvalidateTargetViews(CollectionsKt.listOf((Object[]) new SeslProjectionView.SeslProjectionBackgroundView[]{this.projectionView.getPrjBgEndFirstView(), this.projectionView.getPrjBgStartFirstView(), this.projectionView.getPrjBgStartSecondView()}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetHideTransitionRunnable$lambda$0(FloatingGroupLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resetHideTransitionCondition$material_release();
    }

    public static /* synthetic */ void setLayoutVisibility$default(FloatingGroupLayout floatingGroupLayout, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLayoutVisibility");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        floatingGroupLayout.setLayoutVisibility(z, z2, z3);
    }

    public static /* synthetic */ void showFloatingItemBackground$default(FloatingGroupLayout floatingGroupLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFloatingItemBackground");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        floatingGroupLayout.showFloatingItemBackground(z, z2);
    }

    public static /* synthetic */ void startFloatingItemBackgroundRectAnimation$default(FloatingGroupLayout floatingGroupLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startFloatingItemBackgroundRectAnimation");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        floatingGroupLayout.startFloatingItemBackgroundRectAnimation(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSpringScaleAnimationInternal$lambda$13$lambda$12(View targetView, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        float f5 = f / 10000.0f;
        targetView.setScaleX(f5);
        targetView.setScaleY(f5);
    }

    public static /* synthetic */ void startSpringScaleAnimationInternal$material_release$default(FloatingGroupLayout floatingGroupLayout, float f, float f4, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSpringScaleAnimationInternal");
        }
        View view2 = view;
        if ((i & 4) != 0) {
            view2 = floatingGroupLayout;
        }
        floatingGroupLayout.startSpringScaleAnimationInternal$material_release(f, f4, view2);
    }

    private final void startViewAlphaAnimation(boolean show, boolean immediately, boolean force) {
        if (this.enableScrollTransition || force) {
            if (!show || getAlpha() == 0.0f) {
                if (show) {
                    stopPostShowRunnable$material_release();
                }
                LogTagHelperKt.info(this, "StartViewAlphaAnimation show:" + show + " immediately:" + immediately);
                float f = show ? 1.0f : 0.0f;
                if (f == 1.0f) {
                    startSpringScaleAnimation$material_release(0.94f, 1.0f);
                } else {
                    startSpringScaleAnimation$material_release(1.0f, 0.94f);
                }
                this.layoutAlphaAnimator.setDuration(immediately ? 0L : 150L);
                if (!this.layoutAlphaAnimator.isRunning()) {
                    this.layoutAlphaAnimator.setFloatValues(getAlpha(), f);
                    this.viewTargetAlpha = f;
                    this.layoutAlphaAnimator.start();
                    OnAlphaAnimationStarted(f == 1.0f);
                    return;
                }
                if (this.viewTargetAlpha == f) {
                    return;
                }
                this.viewTargetAlpha = f;
                this.layoutAlphaAnimator.end();
                this.layoutAlphaAnimator.setFloatValues(getAlpha(), f);
                this.layoutAlphaAnimator.start();
                OnAlphaAnimationStarted(f == 1.0f);
            }
        }
    }

    public static /* synthetic */ void startViewAlphaAnimation$default(FloatingGroupLayout floatingGroupLayout, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startViewAlphaAnimation");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        floatingGroupLayout.startViewAlphaAnimation(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVisibleLayoutState() {
        FloatingLayoutState floatingLayoutState = FloatingLayoutState.STATE_NONE;
        for (FloatingLayoutStateChangeListener floatingLayoutStateChangeListener : this.layoutStateListener) {
            float alpha = getAlpha();
            FloatingLayoutState floatingLayoutState2 = alpha == 0.0f ? FloatingLayoutState.STATE_HIDE : alpha == 1.0f ? FloatingLayoutState.STATE_SHOW : FloatingLayoutState.STATE_SHOW;
            if (floatingLayoutState2 != floatingLayoutState) {
                floatingLayoutStateChangeListener.onStateChange(this, floatingLayoutState2);
                floatingLayoutState = floatingLayoutState2;
            }
        }
    }

    public final void addBlurInvalidateTargetViews(@NotNull List<? extends View> views) {
        Intrinsics.checkNotNullParameter(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            this.blurInvalidateTargetViews.put((View) it.next(), new Rect());
        }
    }

    public final void addFloatingBackgroundAnimatorListener(@NotNull Animator.AnimatorListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.projectionView.addAnimatorListener(listener);
    }

    public final void addLayoutStateListener(@NotNull FloatingLayoutStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.layoutStateListener.add(listener);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        addProjectionBgView();
        super.addView(child, index, params);
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean applyBlurInfo(@NotNull Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Set<View> setKeySet = this.blurInvalidateTargetViews.keySet();
        ArrayList<BlurSupportable> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof BlurSupportable) {
                arrayList.add(obj);
            }
        }
        while (true) {
            for (BlurSupportable blurSupportable : arrayList) {
                z = z && blurSupportable.applyBlurInfo(context);
            }
            return z;
        }
    }

    @CallSuper
    public void applyScrollableViewOptions() {
        if (this.windowInsetBottom != -1) {
            getFloatingScrollableManager$material_release().setWindowInsetBottom(this.windowInsetBottom);
        }
        Boolean bool = this.manageGoToTopOffset;
        if (bool != null) {
            getFloatingScrollableManager$material_release().setManageGoToTopOffset(bool.booleanValue());
        }
        Boolean bool2 = this.manageFadingEdgeBottomOffset;
        if (bool2 != null) {
            getFloatingScrollableManager$material_release().setManageFadingEdgeBottomOffset(bool2.booleanValue());
        }
    }

    public final void checkAndRunHideTransition$material_release(int dy) {
        if (dy <= 0) {
            resetHideTransitionCondition$material_release();
            if (isVisible()) {
                return;
            }
            startViewAlphaAnimation$default(this, true, false, false, 6, null);
            return;
        }
        if (isVisible()) {
            this.totalScrollY += dy;
        }
        if (this.totalScrollY > this.hideStartScrollRange) {
            startViewAlphaAnimation$default(this, false, false, false, 6, null);
            resetHideTransitionCondition$material_release();
        }
    }

    public final void checkDependenceToAppBar() {
        this.withAppBarLayout = getAppBarLayout$material_release() != null;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void clearBlurInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set<View> setKeySet = this.blurInvalidateTargetViews.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof BlurSupportable) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BlurSupportable) it.next()).clearBlurInfo(context);
        }
    }

    public final void clearBlurInvalidateTargetView() {
        this.blurInvalidateTargetViews.clear();
    }

    public final void clearLayoutStateListener(@NotNull FloatingLayoutStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.layoutStateListener.clear();
    }

    public final void disableAutoGoToTopOffsetMove() {
        this.manageGoToTopOffset = Boolean.FALSE;
        getFloatingScrollableManager$material_release().setManageGoToTopOffset(false);
    }

    public final int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public final void enableAutoFadingEdgeBottomOffset(boolean enable) {
        this.manageFadingEdgeBottomOffset = Boolean.valueOf(enable);
        getFloatingScrollableManager$material_release().setManageFadingEdgeBottomOffset(enable);
    }

    public final void enableAutoGoToTopOffsetMove() {
        this.manageGoToTopOffset = Boolean.TRUE;
        getFloatingScrollableManager$material_release().setManageGoToTopOffset(true);
    }

    public final void enableScrollTransition(boolean enable, boolean show) {
        LogTagHelperKt.info(this, "FloatingLayout Transition enabled:" + enable + " show:" + show);
        this.enableScrollTransition = enable;
        if (enable) {
            return;
        }
        setLayoutVisibility$default(this, show, false, false, 4, null);
    }

    @Nullable
    public final AppBarLayout getAppBarLayout$material_release() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        List<View> dependencies = ((CoordinatorLayout) parent).getDependencies(this);
        Intrinsics.checkNotNullExpressionValue(dependencies, "coordinatorLayout.getDependencies(this)");
        return getAppBarLayout$material_release(dependencies);
    }

    @Nullable
    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FloatingActionBehavior(context, this.attrs);
    }

    @NotNull
    public final FloatingAware getFloatingAware$material_release() {
        FloatingAware floatingAware = this.floatingAware;
        return floatingAware == null ? new FloatingGroupAware(this) : floatingAware;
    }

    @NotNull
    public final FloatingScrollableManager getFloatingScrollableManager$material_release() {
        return FloatingScrollableManager.Companion.getInstance$default(FloatingScrollableManager.INSTANCE, this, getScrollableView(), null, 4, null);
    }

    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @Nullable
    public final Boolean getManageFadingEdgeBottomOffset() {
        return this.manageFadingEdgeBottomOffset;
    }

    @Nullable
    public final Boolean getManageGoToTopOffset() {
        return this.manageGoToTopOffset;
    }

    @Nullable
    public final NestedScrollView getNestedScrollView() {
        WeakReference<NestedScrollView> weakReference = this.nestedScrollViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public SeslScrollable.SeslOnGoToTopClickListener getOnGoToTopClickListener$material_release() {
        return null;
    }

    @NotNull
    public final ViewTreeObserver.OnPreDrawListener getOnPreDrawListener() {
        return this.onPreDrawListener;
    }

    @NotNull
    /* JADX INFO: renamed from: getProjectionView$material_release, reason: from getter */
    public final SeslProjectionView getProjectionView() {
        return this.projectionView;
    }

    @Nullable
    public final RecyclerView getRecyclerView() {
        WeakReference<RecyclerView> weakReference = this.recyclerViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: getShowBackgroundAtFirst$material_release, reason: from getter */
    public final boolean getShowBackgroundAtFirst() {
        return this.showBackgroundAtFirst;
    }

    @NotNull
    public final FloatingLayoutState getVisibleState() {
        if (this.layoutAlphaAnimator.isRunning()) {
            float f = this.viewTargetAlpha;
            if (f == 1.0f) {
                return FloatingLayoutState.STATE_ANIMATING_TO_SHOW;
            }
            if (f == 0.0f) {
                return FloatingLayoutState.STATE_ANIMATING_TO_HIDE;
            }
        } else {
            if (getAlpha() == 1.0f) {
                return FloatingLayoutState.STATE_SHOW;
            }
            if (getAlpha() == 0.0f) {
                return FloatingLayoutState.STATE_HIDE;
            }
        }
        LogTagHelperKt.error(this, "Invalid State on getVisibleState from:" + getAlpha() + " to:" + this.viewTargetAlpha + " now:" + getAlpha());
        return FloatingLayoutState.STATE_SHOW;
    }

    public final int getWindowInsetBottom() {
        return this.windowInsetBottom;
    }

    /* JADX INFO: renamed from: getWithAppBarLayout$material_release, reason: from getter */
    public final boolean getWithAppBarLayout() {
        return this.withAppBarLayout;
    }

    public final void invalidateBlurTargetView() {
        Iterator<T> it = this.blurInvalidateTargetViews.keySet().iterator();
        while (it.hasNext()) {
            ((View) it.next()).invalidate();
        }
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean isBlurApplied() {
        Set<View> setKeySet = this.blurInvalidateTargetViews.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof BlurSupportable) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((BlurSupportable) it.next()).isBlurApplied()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isEnabledScrollTransition, reason: from getter */
    public final boolean getEnableScrollTransition() {
        return this.enableScrollTransition;
    }

    public final boolean isShowingFloatingItemBackground() {
        return this.projectionView.getAlpha() == 1.0f;
    }

    public final boolean isVisible() {
        return getAlpha() == 1.0f;
    }

    public boolean needInvalidateBlurViews() {
        return true;
    }

    public void onAppBarOffsetChanged(@NotNull AppBarLayout appBarLayout, int verticalOffset) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        if (verticalOffset != 0) {
            invalidateBlurViewsIfNeed();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LifecycleObserver lifecycleObserver;
        LogTagHelperKt.debug(this, "onDetachedFromWindow " + this);
        if ((getContext() instanceof LifecycleOwner) && (lifecycleObserver = this.lifeCycleObserver) != null) {
            Object context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            ((LifecycleOwner) context).getLifecycle().removeObserver(lifecycleObserver);
        }
        this.lifeCycleObserver = null;
        super.onDetachedFromWindow();
        clearFloatingScrollableView();
        this.postShowHandler.removeCallbacks(this.delayShowRunnable);
        this.projectionView.resetOldRect();
        clearPostInvalidateHandler();
        getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev) {
        if (getVisibleState() != FloatingLayoutState.STATE_SHOW) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.isFirstLayout) {
            AppBarLayout appBarLayout$material_release = getAppBarLayout$material_release();
            if (appBarLayout$material_release != null) {
                appBarLayout$material_release.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.d
                    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        FloatingGroupLayout.onLayout$lambda$14(this.f2320a, appBarLayout, i);
                    }
                });
            }
            this.isFirstLayout = false;
        }
        if (this.showBackgroundAtFirst && !(getParent() instanceof CoordinatorLayout)) {
            showFloatingItemBackground(true, false);
        } else if (this.projectionView.getParent() != null && (this.projectionView.getParent() instanceof FloatingToolbarLayout)) {
            startFloatingItemBackgroundRectAnimation$default(this, false, 1, null);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() <= 1) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (this.showBackgroundAtFirst) {
            setPaddingForElevation();
        }
        View childAt = getChildAt(1);
        measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
        childAt.getMeasuredWidth();
        getPaddingStart();
        getPaddingEnd();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight();
        View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824);
        setMeasuredDimension(widthMeasureSpec, paddingBottom);
        this.projectionView.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        LogTagHelperKt.debug(this, "onWindowVisibilityChanged visibility=" + visibility + ' ' + this);
        if (visibility == 0) {
            getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
        } else {
            clearPostInvalidateHandler();
            getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
        }
    }

    public final void removeBlurInvalidateTargetViews(@NotNull List<? extends View> views) {
        Intrinsics.checkNotNullParameter(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            this.blurInvalidateTargetViews.remove((View) it.next());
        }
    }

    public final void removeLayoutStateListener(@NotNull FloatingLayoutStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.layoutStateListener.remove(listener);
    }

    public final void resetHideTransitionCondition$material_release() {
        this.scrollIdleCheckHandler.removeCallbacks(this.resetHideTransitionRunnable);
        this.totalScrollY = 0;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void setBlurMode(int semBlurInfoMode) {
        Set<View> setKeySet = this.blurInvalidateTargetViews.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof BlurSupportable) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BlurSupportable) it.next()).setBlurMode(semBlurInfoMode);
        }
    }

    public final void setColorForFloatingBackground(@ColorInt int color) {
        Drawable background = this.projectionView.getPrjBgEndFirstView().getBackground();
        Drawable drawableMutate = background != null ? background.mutate() : null;
        GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(ColorStateList.valueOf(color));
        }
        Drawable background2 = this.projectionView.getPrjBgStartFirstView().getBackground();
        Drawable drawableMutate2 = background2 != null ? background2.mutate() : null;
        GradientDrawable gradientDrawable2 = drawableMutate2 instanceof GradientDrawable ? (GradientDrawable) drawableMutate2 : null;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setColor(ColorStateList.valueOf(color));
        }
        Drawable background3 = this.projectionView.getPrjBgStartSecondView().getBackground();
        Drawable drawableMutate3 = background3 != null ? background3.mutate() : null;
        GradientDrawable gradientDrawable3 = drawableMutate3 instanceof GradientDrawable ? (GradientDrawable) drawableMutate3 : null;
        if (gradientDrawable3 == null) {
            return;
        }
        gradientDrawable3.setColor(ColorStateList.valueOf(color));
    }

    public final void setCustomPadding(@Nullable Rect paddingRect) {
        this.customPadding = paddingRect;
    }

    public void setElevationForFloatingBackground(@Nullable Float elevation) {
        this.projectionView.setElevation(elevation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFloatingAware(@Nullable FloatingAware floatingAware) {
        if (floatingAware == null) {
            floatingAware = new FloatingGroupAware(null, 1, 0 == true ? 1 : 0);
        }
        this.floatingAware = floatingAware;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setFloatingScrollableAdapter(@NotNull FloatingScrollableAdapter floatingScrollableAdapter) {
        Intrinsics.checkNotNullParameter(floatingScrollableAdapter, "floatingScrollableAdapter");
        clearFloatingScrollableView();
        if (floatingScrollableAdapter.getView() == null) {
            LogTagHelperKt.warn(this, "setFloatingScrollableAdapter fail(getFloatingScrollable return null), scrollableAdapter=" + floatingScrollableAdapter);
        } else {
            FloatingScrollableManager.INSTANCE.getInstance(this, floatingScrollableAdapter);
            this.scrollabelViewRef = new WeakReference<>(floatingScrollableAdapter.getView());
            getFloatingScrollableManager$material_release().addSeslScrollableListener(this.scrollableListener);
            applyScrollableViewOptions();
        }
    }

    public final void setLayoutAlphaAnimationListener$material_release(@Nullable OnAlphaAnimationListener listener) {
        this.layoutAlphaAnimationListener = listener;
    }

    public final void setLayoutVisibility(boolean show, boolean animation, boolean force) {
        startViewAlphaAnimation(show, !animation, force);
    }

    public final void setManageFadingEdgeBottomOffset(@Nullable Boolean bool) {
        this.manageFadingEdgeBottomOffset = bool;
    }

    public final void setManageGoToTopOffset(@Nullable Boolean bool) {
        this.manageGoToTopOffset = bool;
    }

    public void setNestedScrollView(@NotNull NestedScrollView nestedScrollView) throws Exception {
        Intrinsics.checkNotNullParameter(nestedScrollView, "nestedScrollView");
        LogTagHelperKt.info(this, "setNestedScrollView isSame=" + Intrinsics.areEqual(nestedScrollView, getNestedScrollView()) + ", nestedScrollView=" + nestedScrollView + PropertyUtils.MAPPED_DELIM + nestedScrollView.hashCode() + PropertyUtils.MAPPED_DELIM2);
        if (Intrinsics.areEqual(nestedScrollView, getNestedScrollView())) {
            return;
        }
        clearFloatingScrollableView();
        this.nestedScrollViewRef = new WeakReference<>(nestedScrollView);
        getFloatingScrollableManager$material_release().setFloatingScrollableView(nestedScrollView);
        getFloatingScrollableManager$material_release().addSeslScrollableListener(this.scrollableListener);
        applyScrollableViewOptions();
        if (this.nestedScrollAttachStateChangeListener == null) {
            this.nestedScrollAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.setNestedScrollView.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (Intrinsics.areEqual(FloatingGroupLayout.this.getNestedScrollView(), view)) {
                        FloatingGroupLayout.this.clearFloatingScrollableView();
                    }
                }
            };
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.nestedScrollAttachStateChangeListener;
        if (onAttachStateChangeListener != null) {
            nestedScrollView.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        Context context = nestedScrollView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "nestedScrollView.context");
        addOrReplaceLifeCycleObserverForScrollable(context);
    }

    public void setPaddingForElevation() {
        float fMax = Math.max(this.projectionView.getPrjBgEndFirstView().getElevation(), Math.max(this.projectionView.getPrjBgStartFirstView().getElevation(), this.projectionView.getPrjBgStartSecondView().getElevation()));
        Rect rect = this.customPadding;
        if (rect != null) {
            if (rect != null) {
                setPadding(rect.left, rect.top, rect.right, rect.bottom);
            }
        } else if (fMax > 0.0f) {
            int i = (int) fMax;
            setPadding(getPaddingLeft(), getPaddingTop() == 0 ? i : getPaddingTop(), getPaddingRight(), getPaddingBottom() == 0 ? i * 2 : getPaddingBottom());
        }
    }

    public void setRecyclerView(@NotNull RecyclerView recyclerView) throws Exception {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LogTagHelperKt.info(this, "setRecyclerView isSame=" + Intrinsics.areEqual(recyclerView, getRecyclerView()) + ", recyclerView=" + recyclerView + PropertyUtils.MAPPED_DELIM + recyclerView.hashCode() + PropertyUtils.MAPPED_DELIM2);
        if (Intrinsics.areEqual(recyclerView, getRecyclerView())) {
            return;
        }
        clearFloatingScrollableView();
        this.recyclerViewRef = new WeakReference<>(recyclerView);
        getFloatingScrollableManager$material_release().setFloatingScrollableView(recyclerView);
        getFloatingScrollableManager$material_release().addSeslScrollableListener(this.scrollableListener);
        applyScrollableViewOptions();
        if (this.recyclerAttachStateChangeListener == null) {
            this.recyclerAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.setRecyclerView.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (Intrinsics.areEqual(FloatingGroupLayout.this.getRecyclerView(), view)) {
                        FloatingGroupLayout.this.clearFloatingScrollableView();
                    }
                }
            };
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.recyclerAttachStateChangeListener;
        if (onAttachStateChangeListener != null) {
            recyclerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        addOrReplaceLifeCycleObserverForScrollable(context);
    }

    public final void setShowBackgroundAtFirst$material_release(boolean z) {
        this.showBackgroundAtFirst = z;
    }

    public final void setTintForFloatingBackground(@ColorInt int tintColor) {
        Drawable drawableMutate;
        Drawable drawableMutate2;
        Drawable drawableMutate3;
        Drawable background = this.projectionView.getPrjBgEndFirstView().getBackground();
        if (background != null && (drawableMutate3 = background.mutate()) != null) {
            drawableMutate3.setTint(tintColor);
        }
        Drawable background2 = this.projectionView.getPrjBgStartFirstView().getBackground();
        if (background2 != null && (drawableMutate2 = background2.mutate()) != null) {
            drawableMutate2.setTint(tintColor);
        }
        Drawable background3 = this.projectionView.getPrjBgStartSecondView().getBackground();
        if (background3 == null || (drawableMutate = background3.mutate()) == null) {
            return;
        }
        drawableMutate.setTint(tintColor);
    }

    public final void setWindowBottomInset(int offset) {
        this.windowInsetBottom = offset;
        getFloatingScrollableManager$material_release().setWindowInsetBottom(offset);
    }

    public final void setWindowInsetBottom(int i) {
        this.windowInsetBottom = i;
    }

    public final void setWithAppBarLayout$material_release(boolean z) {
        this.withAppBarLayout = z;
    }

    public final void showFloatingItemBackground(boolean show, boolean animate) {
        this.projectionView.startProjectionViewItemAnimation(animate);
        this.projectionView.startProjectionViewAlphaAnimation(show ? 1.0f : 0.0f, !animate);
        if (show) {
            invalidateBlurTargetView();
        }
    }

    public final void startFloatingItemBackgroundRectAnimation(boolean animate) {
        this.projectionView.startProjectionViewItemAnimation(animate);
    }

    public final void startPostShowRunnable$material_release() {
        this.postShowHandler.removeCallbacks(this.delayShowRunnable);
        this.postShowHandler.postDelayed(this.delayShowRunnable, 300L);
    }

    public void startSpringScaleAnimation$material_release(float oldValue, float newValue) {
        for (FloatingAware.PositionType positionType : FloatingAware.PositionType.values()) {
            startSpringScaleAnimationInternal$material_release(oldValue, newValue, this.projectionView.getBackgroundView(positionType));
        }
    }

    public final void startSpringScaleAnimationInternal$material_release(float oldValue, float newValue, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(361.0f);
        float f = 10000;
        springForce.setFinalPosition(newValue * f);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(oldValue * f);
        springAnimation.addUpdateListener(new C4778c(targetView, 0));
        springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$startSpringScaleAnimationInternal$1$3
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                if (this.this$0.startBackgroundItemAnimationOnAnimEnd) {
                    this.this$0.getProjectionView().startProjectionViewItemAnimation(true);
                    this.this$0.startBackgroundItemAnimationOnAnimEnd = false;
                }
            }
        });
        springAnimation.start();
        this.scaleSpringAnimation = springAnimation;
    }

    public final void stopPostShowRunnable$material_release() {
        this.postShowHandler.removeCallbacks(this.delayShowRunnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingGroupLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FloatingGroupLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$scrollableListener$1] */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.util.Property, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$mAlphaAnimProperty$1] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.animation.Animator$AnimatorListener, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$alphaAnimListener$1] */
    @JvmOverloads
    public FloatingGroupLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        this.viewTargetAlpha = 1.0f;
        this.layoutStateListener = new ArrayList();
        final int i2 = 1;
        this.withAppBarLayout = true;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        SeslProjectionView seslProjectionView = new SeslProjectionView(context2);
        this.projectionView = seslProjectionView;
        this.isFirstLayout = true;
        this.blurInvalidateTargetViews = new LinkedHashMap();
        this.enableScrollTransition = true;
        this.applyFloatingItemBackgroundBlur = true;
        this.showBackgroundAtFirst = true;
        this.hideStartScrollRange = context.getResources().getDimensionPixelOffset(C4548R.dimen.sesl_floating_layout_hide_start_scroll_range);
        this.scrollIdleCheckHandler = new Handler(Looper.getMainLooper());
        final int i4 = 0;
        this.resetHideTransitionRunnable = new Runnable(this) { // from class: com.google.android.material.oneui.floatingactioncontainer.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingGroupLayout f2317b;

            {
                this.f2317b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        FloatingGroupLayout.resetHideTransitionRunnable$lambda$0(this.f2317b);
                        break;
                    default:
                        FloatingGroupLayout.delayShowRunnable$lambda$1(this.f2317b);
                        break;
                }
            }
        };
        this.postShowHandler = new Handler(Looper.getMainLooper());
        this.delayShowRunnable = new Runnable(this) { // from class: com.google.android.material.oneui.floatingactioncontainer.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingGroupLayout f2317b;

            {
                this.f2317b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        FloatingGroupLayout.resetHideTransitionRunnable$lambda$0(this.f2317b);
                        break;
                    default:
                        FloatingGroupLayout.delayShowRunnable$lambda$1(this.f2317b);
                        break;
                }
            }
        };
        this.postInvalidateHandler = new Handler(Looper.getMainLooper());
        this.windowInsetBottom = -1;
        this.onPreDrawListener = new ViewTreeObserverOnPreDrawListenerC0014a(this, i2);
        ?? r2 = new FloatProperty<View>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$mAlphaAnimProperty$1
            {
                super("AlphaAnim");
            }

            @Override // android.util.Property
            public Float get(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                return Float.valueOf(view.getAlpha());
            }

            @Override // android.util.FloatProperty
            public void setValue(View view, float value) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(value);
                this.this$0.onAlphaAnimationProgress(value);
            }
        };
        this.mAlphaAnimProperty = r2;
        ?? r4 = new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$alphaAnimListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.updateVisibleLayoutState();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        this.alphaAnimListener = r4;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C4548R.styleable.FloatingGroupLayout, i, 0, new int[0]);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(\n…tyleAttr, 0\n            )");
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.FloatingGroupLayout_showFloatingItemBackground)) {
            this.showBackgroundAtFirst = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.FloatingGroupLayout_showFloatingItemBackground, true);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.FloatingGroupLayout_enableScrollTransition)) {
            this.enableScrollTransition = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.FloatingToolbarLayout_seslShowToolbarItemBackground, true);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.FloatingGroupLayout_applyFloatingItemBackgroundBlur)) {
            this.applyFloatingItemBackgroundBlur = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.FloatingGroupLayout_applyFloatingItemBackgroundBlur, true);
        }
        if (this.applyFloatingItemBackgroundBlur) {
            seslProjectionView.getPrjBgEndFirstView().applyBlurInfo(context);
            seslProjectionView.getPrjBgStartFirstView().applyBlurInfo(context);
            seslProjectionView.getPrjBgStartSecondView().applyBlurInfo(context);
        }
        typedArrayObtainStyledAttributes.recycle();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<FloatingGroupLayout, Float>) r2, getAlpha());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(this, mAlphaAnimProperty, alpha)");
        this.layoutAlphaAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(150L);
        this.layoutAlphaAnimator.addListener(r4);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.scrollableListener = new SeslScrollableListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$scrollableListener$1
            @Override // com.google.android.material.oneui.floatingactioncontainer.manager.SeslScrollableListener
            public void onScrolled(View view, int dx, int dy) {
                this.this$0.scrollIdleCheckHandler.removeCallbacks(this.this$0.resetHideTransitionRunnable);
                this.this$0.scrollIdleCheckHandler.postDelayed(this.this$0.resetHideTransitionRunnable, 50L);
                this.this$0.invalidateBlurViewsIfNeed();
                AppBarLayout appBarLayout$material_release = this.this$0.getAppBarLayout$material_release();
                if (appBarLayout$material_release != null) {
                    FloatingGroupLayout floatingGroupLayout = this.this$0;
                    if (appBarLayout$material_release.seslIsHided()) {
                        floatingGroupLayout.checkAndRunHideTransition$material_release(dy);
                    }
                } else {
                    this.this$0.checkAndRunHideTransition$material_release(dy);
                }
                if (this.this$0.getVisibleState() == FloatingLayoutState.STATE_HIDE || this.this$0.getVisibleState() == FloatingLayoutState.STATE_ANIMATING_TO_HIDE) {
                    this.this$0.startPostShowRunnable$material_release();
                }
            }
        };
    }

    @Nullable
    public final AppBarLayout getAppBarLayout$material_release(@NotNull List<? extends View> views) {
        Intrinsics.checkNotNullParameter(views, "views");
        int size = views.size();
        for (int i = 0; i < size; i++) {
            View view = views.get(i);
            if (view instanceof AppBarLayout) {
                return (AppBarLayout) view;
            }
        }
        LogTagHelperKt.warn(this, "Can't find AppBarLayout " + views.size());
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0014\b\u0000\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0003Z[\\B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u000eJ\b\u00103\u001a\u00020.H\u0002J\u000e\u00104\u001a\u0002052\u0006\u00102\u001a\u00020\u000eJ\b\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020&2\u0006\u00102\u001a\u00020\u000eH\u0002J\u0016\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002050<H\u0002J\n\u0010=\u001a\u0004\u0018\u000107H\u0002J.\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002050<2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0017H\u0002J.\u0010B\u001a\u00020.2\u0006\u0010?\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002050<2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0017H\u0002J\u0018\u0010C\u001a\u00020.2\u0006\u00102\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u0007H\u0002J\u0012\u0010E\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J0\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0014J\u000e\u0010N\u001a\u00020.2\u0006\u00102\u001a\u00020\u000eJ\u0006\u0010O\u001a\u00020.J\u0010\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u001fH\u0016J\u0015\u0010R\u001a\u00020.2\b\u0010S\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010TJ\u0012\u0010U\u001a\u00020.2\b\b\u0002\u0010V\u001a\u00020\u0007H\u0002J\u0018\u0010W\u001a\u00020.2\u0006\u0010X\u001a\u00020\u001f2\b\b\u0002\u0010V\u001a\u00020\u0007J\u0010\u0010Y\u001a\u00020.2\b\b\u0002\u0010D\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(¨\u0006]"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView;", "Landroid/widget/FrameLayout;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configChanged", "", "defaultBgId", "", "getDefaultBgId", "()I", "forceHideTypes", "", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "mPrjAlphaAnimProperty", "com/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$mPrjAlphaAnimProperty$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$mPrjAlphaAnimProperty$1;", "oldRectEndFirst", "Landroid/graphics/Rect;", "oldRectStartFirst", "oldRectStartSecond", "oldRects", "", "prjBGAlphaAnimator", "Landroid/animation/ObjectAnimator;", "prjBGAlphaFrom", "", "getPrjBGAlphaFrom$material_release", "()F", "setPrjBGAlphaFrom$material_release", "(F)V", "prjBGAlphaTo", "prjBgEndFirstView", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView;", "getPrjBgEndFirstView", "()Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView;", "prjBgStartFirstView", "getPrjBgStartFirstView", "prjBgStartSecondView", "getPrjBgStartSecondView", "addAnimatorListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/Animator$AnimatorListener;", "addHideBackgroundType", "type", "ensureItemBgVisible", "getBackgroundView", "Landroid/view/View;", "getParentFloatingLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "getProjectionBackgroundView", "getReferGroupViewsLocationOnScreen", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$ReferViewInformation;", "referGroupViews", "", "getSafeParentFloatingLayout", "getTargetRect", "bgView", "animation", "paddingRect", "matchingLayoutPosition", "matchingOrHideBackgroundView", "animate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLayout", "changed", "left", "top", "right", "bottom", "removeHideBackgroundType", "resetOldRect", "setAlpha", "alpha", "setElevation", "elevation", "(Ljava/lang/Float;)V", "startBackgroundMatchingAnimationImpl", "immediately", "startProjectionViewAlphaAnimation", "toValue", "startProjectionViewItemAnimation", "Companion", "ReferViewInformation", "SeslProjectionBackgroundView", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nFloatingGroupLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView\n+ 2 ViewHelper.kt\nandroidx/appcompat/oneui/common/internal/util/ViewHelperKt\n*L\n1#1,1625:1\n10#2:1626\n10#2:1627\n*S KotlinDebug\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView\n*L\n660#1:1626\n666#1:1627\n*E\n"})
    public static final class SeslProjectionView extends FrameLayout implements MaterialLogTag {

        @NotNull
        private static final String PROJECTION_BG_TAG_END_FIRST = "end_first";

        @NotNull
        private static final String PROJECTION_BG_TAG_START_FIRST = "start_first";

        @NotNull
        private static final String PROJECTION_BG_TAG_START_SECOND = "start_second";
        private static final long PROJECTION_VIEW_ALPHA_ANIM_DURATION = 150;

        @NotNull
        private static final String TAG = "ProjectionView";
        private boolean configChanged;
        private final int defaultBgId;

        @NotNull
        private final List<FloatingAware.PositionType> forceHideTypes;

        @NotNull
        private final FloatingGroupLayout$SeslProjectionView$mPrjAlphaAnimProperty$1 mPrjAlphaAnimProperty;

        @NotNull
        private final Rect oldRectEndFirst;

        @NotNull
        private final Rect oldRectStartFirst;

        @NotNull
        private final Rect oldRectStartSecond;

        @NotNull
        private final Map<String, Rect> oldRects;

        @NotNull
        private ObjectAnimator prjBGAlphaAnimator;
        private float prjBGAlphaFrom;
        private float prjBGAlphaTo;

        @NotNull
        private final SeslProjectionBackgroundView prjBgEndFirstView;

        @NotNull
        private final SeslProjectionBackgroundView prjBgStartFirstView;

        @NotNull
        private final SeslProjectionBackgroundView prjBgStartSecondView;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u001c\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0003J\b\u0010)\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\bH\u0016J\u000e\u0010.\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0014J\u0014\u0010/\u001a\u00020 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0016\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082D¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView;", "Landroid/view/View;", "Landroidx/appcompat/oneui/common/BlurSupportable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anim", "Lcom/google/android/material/oneui/common/internal/animation/ResizeAnimation;", "getAnim", "()Lcom/google/android/material/oneui/common/internal/animation/ResizeAnimation;", "bgViewAlphaAnimator", "Landroid/animation/ObjectAnimator;", "blurInfo", "Landroidx/core/oneui/common/internal/semblurinfo/SemBlurInfoState;", "blurMode", "lastFinalRect", "Landroid/graphics/Rect;", "getLastFinalRect", "()Landroid/graphics/Rect;", "setLastFinalRect", "(Landroid/graphics/Rect;)V", "mBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "mBgViewAlphaAnimProperty", "com/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$mBgViewAlphaAnimProperty$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$mBgViewAlphaAnimProperty$1;", "onResizeUpdate", "Lkotlin/Function0;", "", "ratio", "", "animateToFinalPosition", "rect", "applyBlurInfo", "", "clearBlurInfo", "generateBlurInfo", "isBlurApplied", "setBackground", "background", "setBlurMode", "semBlurInfoMode", "setFinalPosition", "setOnResizeUpdate", "startBackgroundViewAlphaAnimation", Constants.IntentExtraValue.SHOW, "animate", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nFloatingGroupLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1625:1\n271#2:1626\n271#2:1627\n1#3:1628\n*S KotlinDebug\n*F\n+ 1 FloatingGroupLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView\n*L\n815#1:1626\n820#1:1627\n*E\n"})
        public static final class SeslProjectionBackgroundView extends View implements BlurSupportable {

            @NotNull
            private final ResizeAnimation anim;

            @NotNull
            private ObjectAnimator bgViewAlphaAnimator;

            @Nullable
            private SemBlurInfoState blurInfo;
            private int blurMode;

            @NotNull
            private Rect lastFinalRect;

            @Nullable
            private Drawable mBackgroundDrawable;

            @NotNull
            private final C4768x4e451a8d mBgViewAlphaAnimProperty;

            @NotNull
            private Function0<Unit> onResizeUpdate;
            private final float ratio;

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            @JvmOverloads
            public SeslProjectionBackgroundView(@NotNull Context context) {
                this(context, null, 0, 6, null);
                Intrinsics.checkNotNullParameter(context, "context");
            }

            @RequiresApi(35)
            private final SemBlurInfoState generateBlurInfo(Context context) {
                float dimension = context.getResources().getDimension(C4548R.dimen.sesl_projection_bg_radius);
                SemBlurInfoStateBuilder semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder = BlurInfoState.INSTANCE.generateFloatingComponentBlurInfoStateBuilder(context, this.blurMode);
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable != null) {
                    semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.nonBlurBackground(drawable);
                }
                semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.cornerRadius(dimension);
                return semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.build();
            }

            public final void animateToFinalPosition(@NotNull Rect rect) {
                Intrinsics.checkNotNullParameter(rect, "rect");
                this.lastFinalRect = rect;
                this.anim.animateToFinalPosition(new RectF(rect));
            }

            @Override // androidx.appcompat.oneui.common.BlurSupportable
            public boolean applyBlurInfo(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (Build.VERSION.SDK_INT < 35) {
                    return false;
                }
                clearBlurInfo(context);
                SemBlurInfoState semBlurInfoStateGenerateBlurInfo = generateBlurInfo(context);
                boolean zApplyBlurInfo = semBlurInfoStateGenerateBlurInfo.applyBlurInfo(this);
                if (!zApplyBlurInfo) {
                    semBlurInfoStateGenerateBlurInfo = null;
                }
                this.blurInfo = semBlurInfoStateGenerateBlurInfo;
                return zApplyBlurInfo;
            }

            @Override // androidx.appcompat.oneui.common.BlurSupportable
            public void clearBlurInfo(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                SemBlurInfoState semBlurInfoState = this.blurInfo;
                if (semBlurInfoState != null) {
                    semBlurInfoState.clearBlurInfo(this);
                }
                this.blurInfo = null;
            }

            @NotNull
            public final ResizeAnimation getAnim() {
                return this.anim;
            }

            @NotNull
            public final Rect getLastFinalRect() {
                return this.lastFinalRect;
            }

            @Override // androidx.appcompat.oneui.common.BlurSupportable
            public boolean isBlurApplied() {
                return this.blurInfo != null;
            }

            @Override // android.view.View
            public void setBackground(@Nullable Drawable background) {
                super.setBackground(background);
                this.mBackgroundDrawable = background;
            }

            @Override // androidx.appcompat.oneui.common.BlurSupportable
            public void setBlurMode(int semBlurInfoMode) {
                this.blurMode = semBlurInfoMode;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                applyBlurInfo(context);
            }

            public final void setFinalPosition(@NotNull Rect rect) {
                Intrinsics.checkNotNullParameter(rect, "rect");
                this.lastFinalRect = rect;
                this.anim.init(new RectF(rect));
            }

            public final void setLastFinalRect(@NotNull Rect rect) {
                Intrinsics.checkNotNullParameter(rect, "<set-?>");
                this.lastFinalRect = rect;
            }

            public final void setOnResizeUpdate(@NotNull Function0<Unit> onResizeUpdate) {
                Intrinsics.checkNotNullParameter(onResizeUpdate, "onResizeUpdate");
                this.onResizeUpdate = onResizeUpdate;
            }

            public final void startBackgroundViewAlphaAnimation(boolean show, boolean animate) {
                this.bgViewAlphaAnimator.setFloatValues(getAlpha(), show ? 1.0f : 0.0f);
                this.bgViewAlphaAnimator.setDuration(animate ? 150L : 0L);
                this.bgViewAlphaAnimator.start();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            @JvmOverloads
            public SeslProjectionBackgroundView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
                this(context, attributeSet, 0, 4, null);
                Intrinsics.checkNotNullParameter(context, "context");
            }

            public /* synthetic */ SeslProjectionBackgroundView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Type inference failed for: r2v8, types: [android.util.Property, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$mBgViewAlphaAnimProperty$1] */
            @JvmOverloads
            public SeslProjectionBackgroundView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
                super(context, attributeSet, i);
                Intrinsics.checkNotNullParameter(context, "context");
                this.blurMode = 2;
                this.onResizeUpdate = new Function0<Unit>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$onResizeUpdate$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                };
                this.lastFinalRect = new Rect();
                this.ratio = 100.0f;
                ResizeAnimation resizeAnimation = new ResizeAnimation(100.0f);
                resizeAnimation.setSpringForce(Float.valueOf(1.0f), Float.valueOf(361.0f));
                resizeAnimation.setUpdater(new Function1<RectF, Unit>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$anim$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RectF rectF) {
                        invoke2(rectF);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(RectF rectF) {
                        Intrinsics.checkNotNullParameter(rectF, "rectF");
                        this.this$0.onResizeUpdate.invoke();
                        FloatingGroupLayout.SeslProjectionView.SeslProjectionBackgroundView seslProjectionBackgroundView = this.this$0;
                        Rect rect = new Rect();
                        rectF.roundOut(rect);
                        ViewHelperKt.setViewRect(seslProjectionBackgroundView, rect);
                    }
                });
                this.anim = resizeAnimation;
                ?? r2 = new FloatProperty<View>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$SeslProjectionBackgroundView$mBgViewAlphaAnimProperty$1
                    @Override // android.util.Property
                    public Float get(View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        return Float.valueOf(view.getAlpha());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float value) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        view.setAlpha(value);
                    }
                };
                this.mBgViewAlphaAnimProperty = r2;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SeslProjectionBackgroundView, Float>) r2, getAlpha());
                Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(this, mBgViewAlphaAnimProperty, alpha)");
                this.bgViewAlphaAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(150L);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FloatingAware.PositionType.values().length];
                try {
                    iArr[FloatingAware.PositionType.START_FIRST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FloatingAware.PositionType.START_SECOND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FloatingAware.PositionType.END_FIRST.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Type inference failed for: r2v7, types: [android.util.Property, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$mPrjAlphaAnimProperty$1] */
        public SeslProjectionView(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.forceHideTypes = new ArrayList();
            SeslProjectionBackgroundView seslProjectionBackgroundView = new SeslProjectionBackgroundView(context, null, 0, 6, null);
            this.prjBgEndFirstView = seslProjectionBackgroundView;
            int i = 6;
            DefaultConstructorMarker defaultConstructorMarker = null;
            AttributeSet attributeSet = null;
            int i2 = 0;
            SeslProjectionBackgroundView seslProjectionBackgroundView2 = new SeslProjectionBackgroundView(context, attributeSet, i2, i, defaultConstructorMarker);
            this.prjBgStartFirstView = seslProjectionBackgroundView2;
            SeslProjectionBackgroundView seslProjectionBackgroundView3 = new SeslProjectionBackgroundView(context, attributeSet, i2, i, defaultConstructorMarker);
            this.prjBgStartSecondView = seslProjectionBackgroundView3;
            int iIntValue = new OpenThemeResourceDrawableRes(new ThemeResourceDrawableRes(C4548R.drawable.sesl_floating_appbar_round_background_light, C4548R.drawable.sesl_floating_appbar_round_background_dark), new ThemeResourceDrawableRes(C4548R.drawable.sesl_floating_appbar_round_background_for_theme, C4548R.drawable.sesl_floating_appbar_round_background_dark_for_theme)).getResource(context).intValue();
            this.defaultBgId = iIntValue;
            Rect rect = new Rect();
            this.oldRectStartFirst = rect;
            Rect rect2 = new Rect();
            this.oldRectStartSecond = rect2;
            Rect rect3 = new Rect();
            this.oldRectEndFirst = rect3;
            this.oldRects = MapsKt.mapOf(new Pair(PROJECTION_BG_TAG_START_FIRST, rect), new Pair(PROJECTION_BG_TAG_START_SECOND, rect2), new Pair(PROJECTION_BG_TAG_END_FIRST, rect3));
            this.prjBGAlphaAnimator = new ObjectAnimator();
            ?? r2 = new FloatProperty<View>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$mPrjAlphaAnimProperty$1
                @Override // android.util.Property
                public Float get(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return Float.valueOf(view.getAlpha());
                }

                @Override // android.util.FloatProperty
                public void setValue(View view, float value) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setAlpha(value);
                }
            };
            this.mPrjAlphaAnimProperty = r2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SeslProjectionView, Float>) r2, getAlpha());
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(this, mPrjAlphaAnimProperty, alpha)");
            this.prjBGAlphaAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(150L);
            this.prjBGAlphaAnimator.setInterpolator(Companion.AnimatingConfig.INSTANCE.getALPHA_ANIM_INTERPOLATOR());
            setAlpha(0.0f);
            this.prjBGAlphaAnimator.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.SeslProjectionView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    FloatingAware floatingAware$material_release = SeslProjectionView.this.getParentFloatingLayout().getFloatingAware$material_release();
                    if (SeslProjectionView.this.getAlpha() == 0.0f) {
                        floatingAware$material_release.onStartShowFloatingBackground();
                    } else {
                        floatingAware$material_release.onStartHideFloatingBackground();
                    }
                }
            });
            seslProjectionBackgroundView.setTag(PROJECTION_BG_TAG_END_FIRST);
            seslProjectionBackgroundView2.setTag(PROJECTION_BG_TAG_START_FIRST);
            seslProjectionBackgroundView3.setTag(PROJECTION_BG_TAG_START_SECOND);
            seslProjectionBackgroundView2.setId(C4548R.id.floating_toolbar_item_background_start_first);
            seslProjectionBackgroundView3.setId(C4548R.id.floating_toolbar_item_background_start_second);
            seslProjectionBackgroundView.setId(C4548R.id.floating_toolbar_item_background_end_first);
            seslProjectionBackgroundView2.setBackground(getResources().getDrawable(iIntValue));
            seslProjectionBackgroundView3.setBackground(getResources().getDrawable(iIntValue));
            seslProjectionBackgroundView.setBackground(getResources().getDrawable(iIntValue));
            addView(seslProjectionBackgroundView, 0, -1);
            addView(seslProjectionBackgroundView2, 0, -1);
            addView(seslProjectionBackgroundView3, 0, -1);
            float dimension = getResources().getDimension(C4548R.dimen.sesl_floating_toolbar_projection_background_elevation);
            seslProjectionBackgroundView.setElevation(dimension);
            seslProjectionBackgroundView2.setElevation(dimension);
            seslProjectionBackgroundView3.setElevation(dimension);
        }

        private final void ensureItemBgVisible() {
            this.prjBgStartFirstView.setVisibility(this.forceHideTypes.contains(FloatingAware.PositionType.START_FIRST) ? 8 : 0);
            this.prjBgStartSecondView.setVisibility(this.forceHideTypes.contains(FloatingAware.PositionType.START_SECOND) ? 8 : 0);
            this.prjBgEndFirstView.setVisibility(this.forceHideTypes.contains(FloatingAware.PositionType.END_FIRST) ? 8 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FloatingGroupLayout getParentFloatingLayout() {
            ViewParent parent = getParent();
            FloatingGroupLayout floatingGroupLayout = parent instanceof FloatingGroupLayout ? (FloatingGroupLayout) parent : null;
            if (floatingGroupLayout != null) {
                return floatingGroupLayout;
            }
            StringBuilder sb = new StringBuilder("SeslProjectionView must have a FloatingGroupLayout as its parent, but found: ");
            ViewParent parent2 = getParent();
            sb.append(parent2 != null ? parent2.getClass().getSimpleName() : null);
            throw new IllegalStateException(sb.toString());
        }

        private final SeslProjectionBackgroundView getProjectionBackgroundView(FloatingAware.PositionType type) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return this.prjBgStartFirstView;
            }
            if (i == 2) {
                return this.prjBgStartSecondView;
            }
            if (i == 3) {
                return this.prjBgEndFirstView;
            }
            throw new NoWhenBranchMatchedException();
        }

        private final ReferViewInformation getReferGroupViewsLocationOnScreen(List<? extends View> referGroupViews) {
            int[] iArr = new int[2];
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int iMin3 = Integer.MAX_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            for (View view : referGroupViews) {
                view.getLocationOnScreen(iArr);
                iMin = Math.min(iMin, iArr[0]);
                iMax2 = Math.max(iMax2, view.getWidth() + iArr[0]);
                iMax = Math.max(iMax, view.getHeight() + iArr[1]);
                iMin2 = Math.min(iMin2, iArr[0]);
                iMin3 = Math.min(iMin3, iArr[1]);
            }
            return new ReferViewInformation(iMin, iMax2, iMax - iMin3, iMin2, iMin3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FloatingGroupLayout getSafeParentFloatingLayout() {
            if (getParent() instanceof FloatingGroupLayout) {
                ViewParent parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout");
                return (FloatingGroupLayout) parent;
            }
            StringBuilder sb = new StringBuilder("SeslProjectionView must have a FloatingGroupLayout as its parent, but found: ");
            ViewParent parent2 = getParent();
            sb.append(parent2 != null ? parent2.getClass().getSimpleName() : null);
            LogTagHelperKt.warn(this, sb.toString());
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Rect getTargetRect(SeslProjectionBackgroundView bgView, List<? extends View> referGroupViews, boolean animation, Rect paddingRect) {
            ReferViewInformation referGroupViewsLocationOnScreen = getReferGroupViewsLocationOnScreen(referGroupViews);
            int[] iArr = {referGroupViewsLocationOnScreen.getLocationScreenX(), referGroupViewsLocationOnScreen.getLocationScreenY()};
            int[] iArr2 = new int[2];
            FloatingGroupLayout parentFloatingLayout = getParentFloatingLayout();
            parentFloatingLayout.getLocationOnScreen(iArr2);
            Rect rect = this.oldRects.get(bgView.getTag());
            if (rect == null) {
                rect = new Rect();
            }
            ViewHelperKt.getViewRect(bgView, rect);
            int top = (iArr[1] - iArr2[1]) - getTop();
            int height = referGroupViewsLocationOnScreen.getHeight() + top;
            return new Rect(((referGroupViewsLocationOnScreen.getLeft() - iArr2[0]) - parentFloatingLayout.getPaddingLeft()) + (getLayoutDirection() == 1 ? paddingRect.right : paddingRect.left), top + paddingRect.top, ((referGroupViewsLocationOnScreen.getRight() - iArr2[0]) - parentFloatingLayout.getPaddingLeft()) + (-(getLayoutDirection() == 1 ? paddingRect.left : paddingRect.right)), height - paddingRect.bottom);
        }

        private final void matchingLayoutPosition(final SeslProjectionBackgroundView bgView, final List<? extends View> referGroupViews, final boolean animation, final Rect paddingRect) {
            if (getParentFloatingLayout().getScaleX() != 1.0f) {
                getParentFloatingLayout().startBackgroundItemAnimationOnAnimEnd = true;
                return;
            }
            Rect rect = this.oldRects.get(bgView.getTag());
            if (rect == null) {
                rect = new Rect();
            }
            boolean z = rect.isEmpty() ? false : animation;
            if (rect.left < 0 || rect.top < 0 || rect.right < 0 || rect.bottom < 0) {
                z = false;
            }
            boolean z2 = bgView.getAlpha() != 0.0f ? z : false;
            Rect targetRect = getTargetRect(bgView, referGroupViews, animation, paddingRect);
            StringBuilder sbM2230u = AbstractC2821a.m2230u("[FloatingItemBG Animation: anim:", " should:", " tag[", animation, z2);
            sbM2230u.append(bgView.getTag());
            sbM2230u.append("] hashCode{");
            sbM2230u.append(bgView.hashCode());
            sbM2230u.append("} visible:");
            sbM2230u.append(bgView.getVisibility());
            sbM2230u.append(" alpha:");
            sbM2230u.append(bgView.getAlpha());
            sbM2230u.append(' ');
            sbM2230u.append(rect);
            sbM2230u.append(" -> ");
            sbM2230u.append(targetRect);
            sbM2230u.append(", paddingRect:");
            sbM2230u.append(paddingRect.toShortString());
            sbM2230u.append(' ');
            sbM2230u.append(bgView.getParent().getParent());
            LogTagHelperKt.info(this, sbM2230u.toString());
            if (z2) {
                bgView.animateToFinalPosition(targetRect);
                bgView.setOnResizeUpdate(new Function0<Unit>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$matchingLayoutPosition$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (this.this$0.getSafeParentFloatingLayout() != null) {
                            Rect targetRect2 = this.this$0.getTargetRect(bgView, referGroupViews, animation, paddingRect);
                            if (Intrinsics.areEqual(bgView.getLastFinalRect(), targetRect2)) {
                                return;
                            }
                            bgView.animateToFinalPosition(targetRect2);
                        }
                    }
                });
            } else {
                bgView.setFinalPosition(targetRect);
                ViewHelperKt.setViewRect(bgView, targetRect);
            }
        }

        private final void matchingOrHideBackgroundView(FloatingAware.PositionType type, boolean animate) {
            boolean z;
            FloatingAware floatingAware$material_release = getParentFloatingLayout().getFloatingAware$material_release();
            View referenceView = floatingAware$material_release.getReferenceView(type);
            SeslProjectionBackgroundView projectionBackgroundView = getProjectionBackgroundView(type);
            List<View> referenceViews = floatingAware$material_release.getReferenceViews(type);
            if (referenceViews != null) {
                z = false;
            } else if (referenceView != null) {
                referenceViews = CollectionsKt.listOf(referenceView);
                z = false;
            } else {
                referenceViews = null;
                z = true;
            }
            if (!this.forceHideTypes.contains(type) && !z && referenceViews != null) {
                matchingLayoutPosition(projectionBackgroundView, referenceViews, animate, floatingAware$material_release.getReferenceViewInset(type));
            }
            if (z) {
                projectionBackgroundView.startBackgroundViewAlphaAnimation(false, animate);
            } else {
                projectionBackgroundView.startBackgroundViewAlphaAnimation(true, animate);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void startBackgroundMatchingAnimationImpl(boolean immediately) {
            boolean z = (immediately || this.configChanged) ? false : true;
            this.configChanged = false;
            matchingOrHideBackgroundView(FloatingAware.PositionType.START_FIRST, z);
            matchingOrHideBackgroundView(FloatingAware.PositionType.START_SECOND, z);
            matchingOrHideBackgroundView(FloatingAware.PositionType.END_FIRST, z);
        }

        public static /* synthetic */ void startBackgroundMatchingAnimationImpl$default(SeslProjectionView seslProjectionView, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            seslProjectionView.startBackgroundMatchingAnimationImpl(z);
        }

        public static /* synthetic */ void startProjectionViewAlphaAnimation$default(SeslProjectionView seslProjectionView, float f, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            seslProjectionView.startProjectionViewAlphaAnimation(f, z);
        }

        public static /* synthetic */ void startProjectionViewItemAnimation$default(SeslProjectionView seslProjectionView, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            seslProjectionView.startProjectionViewItemAnimation(z);
        }

        public final void addAnimatorListener(@NotNull Animator.AnimatorListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.prjBGAlphaAnimator.addListener(listener);
        }

        public final void addHideBackgroundType(@NotNull FloatingAware.PositionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.forceHideTypes.add(type);
            ensureItemBgVisible();
        }

        @NotNull
        public final View getBackgroundView(@NotNull FloatingAware.PositionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return this.prjBgStartFirstView;
            }
            if (i == 2) {
                return this.prjBgStartSecondView;
            }
            if (i == 3) {
                return this.prjBgEndFirstView;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final int getDefaultBgId() {
            return this.defaultBgId;
        }

        @Override // androidx.core.oneui.common.internal.log.LogTag
        @NotNull
        public String getLogTag() {
            return "SeslProjectionView";
        }

        /* JADX INFO: renamed from: getPrjBGAlphaFrom$material_release, reason: from getter */
        public final float getPrjBGAlphaFrom() {
            return this.prjBGAlphaFrom;
        }

        @NotNull
        public final SeslProjectionBackgroundView getPrjBgEndFirstView() {
            return this.prjBgEndFirstView;
        }

        @NotNull
        public final SeslProjectionBackgroundView getPrjBgStartFirstView() {
            return this.prjBgStartFirstView;
        }

        @NotNull
        public final SeslProjectionBackgroundView getPrjBgStartSecondView() {
            return this.prjBgStartSecondView;
        }

        @Override // android.view.View
        public void onConfigurationChanged(@Nullable Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            this.configChanged = true;
            LogTagHelperKt.debug(this, "onConfigurationChanged " + this);
            getParentFloatingLayout().getFloatingAware$material_release().onFloatingViewConfigurationChanged(getAlpha() == 1.0f, newConfig);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            if (changed && getAlpha() == 1.0f && getSafeParentFloatingLayout() != null) {
                startProjectionViewItemAnimation$default(this, false, 1, null);
            }
        }

        public final void removeHideBackgroundType(@NotNull FloatingAware.PositionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.forceHideTypes.remove(type);
        }

        public final void resetOldRect() {
            Iterator<Rect> it = this.oldRects.values().iterator();
            while (it.hasNext()) {
                it.next().setEmpty();
            }
        }

        @Override // android.view.View
        public void setAlpha(float alpha) {
            this.prjBGAlphaTo = alpha;
            super.setAlpha(alpha);
        }

        public final void setElevation(@Nullable Float elevation) {
            float fFloatValue = elevation != null ? elevation.floatValue() : getResources().getDimension(C4548R.dimen.sesl_floating_toolbar_projection_background_elevation);
            this.prjBgEndFirstView.setElevation(fFloatValue);
            this.prjBgStartFirstView.setElevation(fFloatValue);
            this.prjBgStartSecondView.setElevation(fFloatValue);
        }

        public final void setPrjBGAlphaFrom$material_release(float f) {
            this.prjBGAlphaFrom = f;
        }

        public final void startProjectionViewAlphaAnimation(float toValue, boolean immediately) {
            Object target = this.prjBGAlphaAnimator.getTarget();
            Intrinsics.checkNotNull(target, "null cannot be cast to non-null type android.view.View");
            if (((View) target).getAlpha() == toValue || toValue == this.prjBGAlphaTo) {
                return;
            }
            ensureItemBgVisible();
            this.prjBGAlphaAnimator.setDuration(immediately ? 0L : 150L);
            Log.d(TAG, "ProjectionBackgroundAnimation: to=" + toValue + ", duration=" + this.prjBGAlphaAnimator.getDuration() + ", isRunning=" + this.prjBGAlphaAnimator.isRunning());
            if (!this.prjBGAlphaAnimator.isRunning()) {
                this.prjBGAlphaTo = toValue;
                this.prjBGAlphaAnimator.setFloatValues(getAlpha(), toValue);
                this.prjBGAlphaAnimator.start();
            } else {
                if (this.prjBGAlphaTo == toValue) {
                    return;
                }
                this.prjBGAlphaTo = toValue;
                this.prjBGAlphaAnimator.end();
                this.prjBGAlphaAnimator.setFloatValues(getAlpha(), toValue);
                this.prjBGAlphaAnimator.start();
            }
        }

        public final void startProjectionViewItemAnimation(final boolean animate) {
            final FloatingGroupLayout parentFloatingLayout = getParentFloatingLayout();
            parentFloatingLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout$SeslProjectionView$startProjectionViewItemAnimation$1$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.this$0.startBackgroundMatchingAnimationImpl(!animate);
                    parentFloatingLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$SeslProjectionView$ReferViewInformation;", "", "left", "", "right", "height", "locationScreenX", "locationScreenY", "(IIIII)V", "getHeight", "()I", "getLeft", "getLocationScreenX", "getLocationScreenY", "getRight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final /* data */ class ReferViewInformation {
            private final int height;
            private final int left;
            private final int locationScreenX;
            private final int locationScreenY;
            private final int right;

            public ReferViewInformation(int i, int i2, int i4, int i5, int i6) {
                this.left = i;
                this.right = i2;
                this.height = i4;
                this.locationScreenX = i5;
                this.locationScreenY = i6;
            }

            public static /* synthetic */ ReferViewInformation copy$default(ReferViewInformation referViewInformation, int i, int i2, int i4, int i5, int i6, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    i = referViewInformation.left;
                }
                if ((i7 & 2) != 0) {
                    i2 = referViewInformation.right;
                }
                if ((i7 & 4) != 0) {
                    i4 = referViewInformation.height;
                }
                if ((i7 & 8) != 0) {
                    i5 = referViewInformation.locationScreenX;
                }
                if ((i7 & 16) != 0) {
                    i6 = referViewInformation.locationScreenY;
                }
                int i8 = i6;
                int i9 = i4;
                return referViewInformation.copy(i, i2, i9, i5, i8);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getLeft() {
                return this.left;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getRight() {
                return this.right;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getHeight() {
                return this.height;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getLocationScreenX() {
                return this.locationScreenX;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getLocationScreenY() {
                return this.locationScreenY;
            }

            @NotNull
            public final ReferViewInformation copy(int left, int right, int height, int locationScreenX, int locationScreenY) {
                return new ReferViewInformation(left, right, height, locationScreenX, locationScreenY);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReferViewInformation)) {
                    return false;
                }
                ReferViewInformation referViewInformation = (ReferViewInformation) other;
                return this.left == referViewInformation.left && this.right == referViewInformation.right && this.height == referViewInformation.height && this.locationScreenX == referViewInformation.locationScreenX && this.locationScreenY == referViewInformation.locationScreenY;
            }

            public final int getHeight() {
                return this.height;
            }

            public final int getLeft() {
                return this.left;
            }

            public final int getLocationScreenX() {
                return this.locationScreenX;
            }

            public final int getLocationScreenY() {
                return this.locationScreenY;
            }

            public final int getRight() {
                return this.right;
            }

            public int hashCode() {
                return Integer.hashCode(this.locationScreenY) + AbstractC0622a.m1157c(this.locationScreenX, AbstractC0622a.m1157c(this.height, AbstractC0622a.m1157c(this.right, Integer.hashCode(this.left) * 31, 31), 31), 31);
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder("ReferViewInformation(left=");
                sb.append(this.left);
                sb.append(", right=");
                sb.append(this.right);
                sb.append(", height=");
                sb.append(this.height);
                sb.append(", locationScreenX=");
                sb.append(this.locationScreenX);
                sb.append(", locationScreenY=");
                return AbstractC0000a.m13j(sb, this.locationScreenY, PropertyUtils.MAPPED_DELIM2);
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ ReferViewInformation(int i, int i2, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
                int i8;
                int i9;
                int i10;
                i = (i7 & 1) != 0 ? 0 : i;
                i2 = (i7 & 2) != 0 ? 0 : i2;
                if ((i7 & 4) != 0) {
                    i8 = i6;
                    i9 = i5;
                    i10 = 0;
                } else {
                    i8 = i6;
                    i9 = i5;
                    i10 = i4;
                }
                this(i, i2, i10, i9, i8);
            }
        }
    }
}
