package com.google.android.material.oneui.floatingdock;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Size;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.util.Consumer;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewGroupKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.C4565b;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.oneui.common.internal.animation.ScaleSpringAnimation;
import com.google.android.material.oneui.common.internal.util.RectHelperKt;
import com.google.android.material.oneui.common.internal.util.ViewHelperKt;
import com.google.android.material.oneui.floatingactioncontainer.C4778c;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.android.material.oneui.floatingdock.behavior.BottomBehavior;
import com.google.android.material.oneui.floatingdock.behavior.CommonBehavior;
import com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior;
import com.google.android.material.oneui.floatingdock.behavior.SideBehavior;
import com.google.android.material.oneui.floatingdock.controller.DragHandlerController;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import com.google.android.material.oneui.floatingdock.util.HapticFeedbackHelper;
import com.google.android.material.oneui.floatingdock.util.PolicyHelperKt;
import com.google.android.material.oneui.floatingdock.widget.FloatingMenuItemView;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0015\n\u0002\b5\n\u0002\u0010\t\n\u0002\b\u0013\b\u0007\u0018\u0000 ÷\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002÷\u0001B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kJ\b\u0010l\u001a\u00020iH\u0002J@\u0010m\u001a\u00020i2\u0006\u0010n\u001a\u00020\u000e2\b\b\u0002\u0010o\u001a\u0002012\b\b\u0002\u0010p\u001a\u0002012\b\b\u0002\u0010q\u001a\u0002012\b\b\u0002\u0010r\u001a\u000201ø\u0001\u0000¢\u0006\u0004\bs\u0010tJ\u001d\u0010u\u001a\u00020\u000e2\u0006\u0010v\u001a\u00020wH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ\u000e\u0010z\u001a\u00020i2\u0006\u0010{\u001a\u000201J\u0018\u0010z\u001a\u00020i2\u0006\u0010{\u001a\u0002012\u0006\u0010|\u001a\u00020)H\u0002J\u0018\u0010}\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ\t\u0010\u0080\u0001\u001a\u00020)H\u0002J!\u0010\u0081\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020WH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020)H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u000bH\u0003J\u0011\u0010\u0087\u0001\u001a\u0002012\u0006\u0010v\u001a\u00020wH\u0002J\u001c\u0010\u0088\u0001\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00172\t\b\u0002\u0010\u0089\u0001\u001a\u000201H\u0002J\u0015\u0010\u008a\u0001\u001a\u0004\u0018\u00010F2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u0010\u0010\u008d\u0001\u001a\u00020i2\u0007\u0010\u008e\u0001\u001a\u000201J\t\u0010\u008f\u0001\u001a\u00020iH\u0002J\t\u0010\u0090\u0001\u001a\u00020iH\u0002J\u001d\u0010\u0091\u0001\u001a\u0002012\u0006\u0010I\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u000201J\t\u0010\u0095\u0001\u001a\u000201H\u0002J3\u0010\u0096\u0001\u001a\u00020i2\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0003\b\u009b\u0001J\u0012\u0010\u009c\u0001\u001a\u00020i2\u0007\u0010\u009d\u0001\u001a\u00020WH\u0014J\t\u0010\u009e\u0001\u001a\u00020iH\u0002J\t\u0010\u009f\u0001\u001a\u00020iH\u0002J\t\u0010 \u0001\u001a\u00020iH\u0002J\u0011\u0010¡\u0001\u001a\u0002012\u0006\u0010v\u001a\u00020wH\u0016J6\u0010¢\u0001\u001a\u00020i2\u0007\u0010£\u0001\u001a\u0002012\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000bH\u0014J\u001a\u0010¤\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020w2\u0007\u0010¥\u0001\u001a\u00020)H\u0002J-\u0010¦\u0001\u001a\u0002012\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010¨\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020\"2\u0007\u0010ª\u0001\u001a\u000201H\u0016J$\u0010«\u0001\u001a\u0002012\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010¨\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020\"H\u0016J7\u0010¬\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010\u00ad\u0001\u001a\u00020\u000b2\u0007\u0010®\u0001\u001a\u00020\u000b2\b\u0010ª\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016J?\u0010±\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010²\u0001\u001a\u00020\u000b2\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010µ\u0001\u001a\u00020\u000b2\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016JI\u0010±\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010²\u0001\u001a\u00020\u000b2\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010µ\u0001\u001a\u00020\u000b2\u0007\u0010°\u0001\u001a\u00020\u000b2\b\u0010ª\u0001\u001a\u00030¯\u0001H\u0016J-\u0010¶\u0001\u001a\u00020i2\u0007\u0010·\u0001\u001a\u00020\u001f2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016J\u0011\u0010¹\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020wH\u0002J\u001a\u0010º\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020w2\u0007\u0010¥\u0001\u001a\u00020)H\u0002J\t\u0010»\u0001\u001a\u00020iH\u0002J\t\u0010¼\u0001\u001a\u00020iH\u0002J\t\u0010½\u0001\u001a\u00020iH\u0002J-\u0010¾\u0001\u001a\u0002012\u0007\u0010·\u0001\u001a\u00020\u001f2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016J\u001b\u0010¿\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010°\u0001\u001a\u00020\u000bH\u0016J\u0011\u0010À\u0001\u001a\u0002012\u0006\u0010v\u001a\u00020wH\u0016J\u001b\u0010Á\u0001\u001a\u00020i2\u0007\u0010Â\u0001\u001a\u00020\u001f2\u0007\u0010Ã\u0001\u001a\u00020\u000bH\u0014J\u0007\u0010Ä\u0001\u001a\u00020iJ\u000f\u0010Å\u0001\u001a\u00020i2\u0006\u0010j\u001a\u00020kJ5\u0010Æ\u0001\u001a\u00020i2\u0007\u0010Ç\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b2\u0007\u0010É\u0001\u001a\u00020)2\u0007\u0010Ê\u0001\u001a\u00020)2\u0006\u0010]\u001a\u00020\u000bH\u0002J\u0007\u0010Ë\u0001\u001a\u000201J\u0010\u0010Ì\u0001\u001a\u00020i2\u0007\u0010Í\u0001\u001a\u00020\u001fJ\u0011\u0010Î\u0001\u001a\u00020i2\u0006\u0010{\u001a\u000201H\u0002J\u0010\u0010Ï\u0001\u001a\u00020i2\u0007\u0010Í\u0001\u001a\u00020\u001fJ&\u0010Ð\u0001\u001a\u00020i2\u0006\u0010I\u001a\u00020\u000e2\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J(\u0010Ô\u0001\u001a\u00020i2\u0006\u0010I\u001a\u00020\u000e2\u000b\b\u0001\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0006\bÖ\u0001\u0010Ó\u0001J&\u0010×\u0001\u001a\u00020i2\u0006\u0010I\u001a\u00020\u000e2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u000bø\u0001\u0000¢\u0006\u0006\bÙ\u0001\u0010Ó\u0001J\u0012\u0010Ú\u0001\u001a\u00020i2\u0007\u0010Û\u0001\u001a\u00020\"H\u0016J\u0012\u0010Ü\u0001\u001a\u00020i2\u0007\u0010Ý\u0001\u001a\u00020\"H\u0016J\u0011\u0010Þ\u0001\u001a\u0002012\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010ß\u0001\u001a\u00020i2\u0007\u0010\u008e\u0001\u001a\u000201J\t\u0010à\u0001\u001a\u00020iH\u0002J%\u0010á\u0001\u001a\u00020i2\u0007\u0010â\u0001\u001a\u00020)2\u0007\u0010ã\u0001\u001a\u00020)2\b\u0010ä\u0001\u001a\u00030å\u0001H\u0002J)\u0010æ\u0001\u001a\u00020i2\u0007\u0010ã\u0001\u001a\u00020)2\n\b\u0002\u0010ç\u0001\u001a\u00030å\u00012\t\b\u0002\u0010\u0089\u0001\u001a\u000201H\u0002J\t\u0010è\u0001\u001a\u00020iH\u0002J\t\u0010é\u0001\u001a\u00020iH\u0002J\u001b\u0010ê\u0001\u001a\u00020i2\u0007\u0010â\u0001\u001a\u00020)2\u0007\u0010ã\u0001\u001a\u00020)H\u0002J\t\u0010ë\u0001\u001a\u00020iH\u0002J\t\u0010ì\u0001\u001a\u00020iH\u0002J\u001b\u0010í\u0001\u001a\u00020i2\u0007\u0010â\u0001\u001a\u00020)2\u0007\u0010ã\u0001\u001a\u00020)H\u0002J\t\u0010î\u0001\u001a\u00020iH\u0002J\u0010\u0010ï\u0001\u001a\u00020i2\u0007\u0010ð\u0001\u001a\u00020\u000bJ\u0011\u0010ñ\u0001\u001a\u00020i2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010ò\u0001\u001a\u00020iH\u0002J\t\u0010ó\u0001\u001a\u00020iH\u0002J\u0011\u0010ô\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020wH\u0002J\u0011\u0010õ\u0001\u001a\u00020i2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010ö\u0001\u001a\u00020i2\u0007\u0010¥\u0001\u001a\u00020)H\u0002R\"\u0010\r\u001a\u00020\u000eX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n  *\u0004\u0018\u00010'0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020@X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010I\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\bJ\u0010\u0010R\u000e\u0010K\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\n  *\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00107\"\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u000bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ø\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPaneView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "context", "Landroid/content/Context;", "parentView", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneLayout;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lcom/google/android/material/oneui/floatingdock/FloatingPaneLayout;Landroid/util/AttributeSet;I)V", "allowedMode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "getAllowedMode-91QzYFA$material_release", "()I", "setAllowedMode-J5JjPLc$material_release", "(I)V", "I", "animator", "Landroid/animation/ValueAnimator;", "behavior", "Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "behaviors", "", "bottomToFloatingBottomMargin", "callbackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "contentContainer", "dividerView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "downRawX", "", "downRawY", "dragHandlerController", "Lcom/google/android/material/oneui/floatingdock/controller/DragHandlerController;", "dragHandlerView", "Landroid/widget/ImageView;", "endBounds", "Landroid/graphics/Rect;", "enterMinimizeAlphaAnimation", "Landroid/animation/AnimatorSet;", "exitMinimizeAlphaAnimation", "floatLayoutElevation", "handler", "Landroid/os/Handler;", "haveAnotherMinimizeView", "", "hideRunnable", "Ljava/lang/Runnable;", "isDragging", "isInMinimizeArea", "isShowing", "()Z", "isUserModeChanged", "lastTouchRawX", "lastTouchRawY", "lastTouchX", "lastTouchY", "layoutInflater", "Landroid/view/LayoutInflater;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "minimizeGestureDetector", "Landroid/view/GestureDetector;", "minimizeToolbarView", "Landroidx/appcompat/widget/Toolbar;", "minimizeViewContainer", "<set-?>", "mode", "getMode-91QzYFA", "modeChangeBottomThreshold", "modeChangeSideThreshold", "moveScaleAnimation", "Lcom/google/android/material/oneui/common/internal/animation/ScaleSpringAnimation;", "onMenuItemClickListener", "Landroid/view/View$OnClickListener;", "originBounds", "originRect", "popupWindow", "Landroid/widget/PopupWindow;", "pressScaleAnimation", "prevConfiguration", "Landroid/content/res/Configuration;", "prevParentRect", "resizeByContentScrollEnabled", "getResizeByContentScrollEnabled", "setResizeByContentScrollEnabled", "(Z)V", "resizePinPoint", "getResizePinPoint$annotations", "()V", "resizeTouchSize", "rootView", "startNestedScroll", "sumDy", "touchSlop", "trackingScroll", "viewModel", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;", "addCallbacks", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback;", "changeFocusOrderForHandlerFirst", "changePaneLayoutMode", "requestMode", "invalidate", "isLongPress", "skipAnimate", "fromUser", "changePaneLayoutMode-WX4EXPg", "(IZZZZ)V", "checkLayoutModeChangeOnMove", "event", "Landroid/view/MotionEvent;", "checkLayoutModeChangeOnMove-WJaa9_w", "(Landroid/view/MotionEvent;)I", "enterMinimizeView", "minimize", "current", "getBehavior", "getBehavior-J5JjPLc", "(I)Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "getCurrentRect", "getDefaultLayoutMode", "configuration", "getDefaultLayoutMode-WJaa9_w", "(Landroid/content/res/Configuration;)I", "getIntersectRect", "getMenuLayoutResId", "getResizePinDirection", "getTargetModeBounds", "moveValidArea", "getToolbar", "parent", "Landroid/view/ViewGroup;", "hide", "animate", "initEffect", "initViewState", "isAllowedMode", "isAllowedMode-J5JjPLc", "(I)Z", "isMinimizeView", "isNestedScrollSupport", "onChangedParentBounds", "left", "top", "right", "bottom", "onChangedParentBounds$material_release", "onConfigurationChanged", "newConfig", "onHideAnimationEnd", "onHideAnimationStart", "onHideAnimationUpdate", "onInterceptTouchEvent", "onLayout", "changed", "onMove", "nextResultViewRect", "onNestedFling", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onPreMove", "onResize", "onShowAnimationEnd", "onShowAnimationStart", "onShowAnimationUpdate", "onStartNestedScroll", "onStopNestedScroll", "onTouchEvent", "onVisibilityChanged", "changedView", "visibility", "removeAllCallback", "removeCallback", "resize", "diffX", "diffY", "newRect", "minRect", "runNestedScrollAnimation", "setContentView", "view", "setMinimizeStateAndAlphaAnimation", "setMinimizeView", "setResultHeight", "height", "setResultHeight-oaV7IQU", "(ILjava/lang/Integer;)V", "setResultViewBackgroundResource", "resId", "setResultViewBackgroundResource-oaV7IQU", "setResultWidth", "width", "setResultWidth-oaV7IQU", "setTranslationX", "translationX", "setTranslationY", "translationY", "shouldInterceptTouch", Constants.IntentExtraValue.SHOW, "showPopup", "startAnimation", Constants.MessagePayloadKeys.FROM, "to", "animatorDuration", "", "startBoundAnimation", XmlErrorCodes.DURATION, "startLongPressOrDragStartAnimation", "startMinimizeAlphaAnimation", "startMinimizeAnimation", "startReleaseAnimation", "startUnMinimizeAlphaAnimation", "startUnMinimizeAnimation", "tryChangeFloatingModeByLongPress", "updateDelta", "delta", "updateDivider", "updateFloatingPosition", "updateMinimize", "updateState", "updateView", "updateViewBoundsInSideMoveableArea", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingPaneView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingPaneView.kt\ncom/google/android/material/oneui/floatingdock/FloatingPaneView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n+ 6 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 7 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 8 ViewHelper.kt\nandroidx/appcompat/oneui/common/internal/util/ViewHelperKt\n*L\n1#1,1708:1\n1855#2,2:1709\n1855#2,2:1796\n473#3:1711\n1295#3,2:1712\n1#4:1714\n192#5,3:1715\n339#5:1799\n357#5,10:1800\n39#6:1718\n85#6,18:1719\n29#6:1737\n85#6,18:1738\n39#6:1756\n85#6,18:1757\n29#6:1775\n85#6,18:1776\n51#7:1794\n51#7:1795\n10#8:1798\n*S KotlinDebug\n*F\n+ 1 FloatingPaneView.kt\ncom/google/android/material/oneui/floatingdock/FloatingPaneView\n*L\n214#1:1709,2\n1084#1:1796,2\n325#1:1711\n325#1:1712,2\n371#1:1715,3\n1488#1:1799\n1488#1:1800,10\n459#1:1718\n459#1:1719,18\n460#1:1737\n460#1:1738,18\n514#1:1756\n514#1:1757,18\n515#1:1775\n515#1:1776,18\n551#1:1794\n562#1:1795\n1430#1:1798\n*E\n"})
public final class FloatingPaneView extends FrameLayout implements NestedScrollingParent3, FloatingDockLogTag {
    private static final long ACCESSIBILITY_DELAY = 500;
    private static final long ANIM_DURATION = 400;
    private static final boolean DEBUG_NO_LIMIT = false;
    private static final boolean DEBUG_TOUCH = false;
    private static final boolean DEBUG_VISUAL = false;
    private static final long HANDLER_MENU_POPUP_DISMISS_DELAY_TIME = 2000;
    private static final float LONG_PRESS_AND_DRAG_SCALE_ANIM_FINAL_VALUE = 1.02f;
    private static final float LONG_PRESS_AND_DRAG_SCALE_ANIM_START_VALUE = 1.0f;
    private static final long LONG_PRESS_ANIM_DURATION = 300;
    private static final float PRESS_SCALE_ANIM_FINAL_VALUE = 0.98f;
    private static final float PRESS_SCALE_ANIM_START_VALUE = 1.0f;
    public static final int RESIZE_PIN_ALL = 15;
    public static final int RESIZE_PIN_BOTTOM = 8;
    public static final int RESIZE_PIN_LEFT = 1;
    public static final int RESIZE_PIN_NONE = 0;
    public static final int RESIZE_PIN_RIGHT = 4;
    public static final int RESIZE_PIN_TOP = 2;
    private int allowedMode;

    @Nullable
    private ValueAnimator animator;

    @NotNull
    private CommonBehavior behavior;

    @NotNull
    private final Map<FloatingPane.FloatingPaneMode, CommonBehavior> behaviors;
    private final int bottomToFloatingBottomMargin;

    @NotNull
    private final FloatingPaneCallbackNotifier callbackNotifier;

    @NotNull
    private final FrameLayout contentContainer;
    private final View dividerView;
    private float downRawX;
    private float downRawY;

    @NotNull
    private final DragHandlerController dragHandlerController;
    private final ImageView dragHandlerView;

    @NotNull
    private final Rect endBounds;

    @NotNull
    private final AnimatorSet enterMinimizeAlphaAnimation;

    @NotNull
    private final AnimatorSet exitMinimizeAlphaAnimation;
    private final float floatLayoutElevation;

    @NotNull
    private final Handler handler;
    private boolean haveAnotherMinimizeView;

    @NotNull
    private final Runnable hideRunnable;
    private boolean isDragging;
    private boolean isInMinimizeArea;
    private boolean isUserModeChanged;
    private float lastTouchRawX;
    private float lastTouchRawY;
    private float lastTouchX;
    private float lastTouchY;

    @NotNull
    private final LayoutInflater layoutInflater;

    @NotNull
    private final String logTag;

    @NotNull
    private final GestureDetector minimizeGestureDetector;

    @Nullable
    private Toolbar minimizeToolbarView;

    @NotNull
    private final FrameLayout minimizeViewContainer;
    private int mode;
    private final float modeChangeBottomThreshold;
    private final float modeChangeSideThreshold;

    @NotNull
    private final ScaleSpringAnimation moveScaleAnimation;

    @NotNull
    private final View.OnClickListener onMenuItemClickListener;

    @NotNull
    private final Rect originBounds;

    @NotNull
    private Rect originRect;

    @NotNull
    private final FloatingPaneLayout parentView;

    @Nullable
    private PopupWindow popupWindow;
    private final ValueAnimator pressScaleAnimation;
    private Configuration prevConfiguration;

    @NotNull
    private final Rect prevParentRect;
    private boolean resizeByContentScrollEnabled;
    private int resizePinPoint;
    private final int resizeTouchSize;

    @NotNull
    private final View rootView;
    private boolean startNestedScroll;
    private int sumDy;
    private final int touchSlop;
    private boolean trackingScroll;

    @NotNull
    private final FloatingPaneViewModel viewModel;

    @NotNull
    private static final RectEvaluator RECT_EVALUATOR = new RectEvaluator(new Rect());

    @NotNull
    private static final PathInterpolator INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneView(@NotNull Context context, @NotNull FloatingPaneLayout parentView) {
        this(context, parentView, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }

    private final void changeFocusOrderForHandlerFirst() {
        ViewGroup viewGroup = (ViewGroup) this.rootView.findViewById(C4548R.id.float_top_handle_area);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            Intrinsics.checkNotNullExpressionValue(viewGroup, "changeFocusOrderForHandl…First$lambda$55$lambda$54");
            ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            int i = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
            ViewGroup.LayoutParams layoutParams4 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
            int i2 = marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0;
            ViewGroup.LayoutParams layoutParams5 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            layoutParams2.setMargins(i, -1, i2, marginLayoutParams3 != null ? marginLayoutParams3.bottomMargin : 0);
            viewGroup.setPadding(viewGroup.getPaddingLeft(), 1, viewGroup.getPaddingTop(), viewGroup.getPaddingBottom());
        }
    }

    /* JADX INFO: renamed from: changePaneLayoutMode-WX4EXPg$default, reason: not valid java name */
    public static /* synthetic */ void m22095changePaneLayoutModeWX4EXPg$default(FloatingPaneView floatingPaneView, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            z3 = false;
        }
        if ((i2 & 16) != 0) {
            z4 = false;
        }
        floatingPaneView.m22099changePaneLayoutModeWX4EXPg(i, z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: checkLayoutModeChangeOnMove-WJaa9_w, reason: not valid java name */
    private final int m22096checkLayoutModeChangeOnMoveWJaa9_w(MotionEvent event) {
        float x = event.getX() + getLeft();
        float y2 = event.getY() + getTop();
        int width = this.parentView.getWidth();
        int height = this.parentView.getHeight();
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        int iMODE_FLOATING = companion.MODE_FLOATING();
        float width2 = getWidth() * this.modeChangeSideThreshold;
        float height2 = getHeight() * this.modeChangeBottomThreshold;
        if (getLayoutDirection() != 1 ? x > width - width2 : x < width2) {
            iMODE_FLOATING = companion.MODE_SIDE();
        } else if (y2 > height - height2) {
            iMODE_FLOATING = companion.MODE_BOTTOM();
        }
        this.parentView.seslShowProDockingEffect$material_release(!FloatingPane.FloatingPaneMode.m22083equalsimpl0(iMODE_FLOATING, companion.MODE_FLOATING()), getTargetModeBounds$default(this, m22101getBehaviorJ5JjPLc(iMODE_FLOATING), false, 2, null));
        return iMODE_FLOATING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dragHandlerController$lambda$6(FloatingPaneView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonBehavior commonBehavior = this$0.behavior;
        if (!(commonBehavior instanceof FloatingBehavior) || commonBehavior.getIsMinimized()) {
            return true;
        }
        this$0.pressScaleAnimation.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dragHandlerController$lambda$7(FloatingPaneView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initEffect();
        CommonBehavior commonBehavior = this$0.behavior;
        if ((commonBehavior instanceof FloatingBehavior) && commonBehavior.getIsMinimized()) {
            this$0.enterMinimizeView(false);
        } else {
            this$0.showPopup();
        }
        this$0.startReleaseAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dragHandlerController$lambda$8(FloatingPaneView this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        CommonBehavior commonBehavior = this$0.behavior;
        if (!(commonBehavior instanceof FloatingBehavior) || commonBehavior.getIsMinimized()) {
            this$0.tryChangeFloatingModeByLongPress();
        } else {
            HapticFeedbackHelper.INSTANCE.onLongPress(this$0);
            this$0.startLongPressOrDragStartAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        FrameLayout frameLayout = this$0.contentContainer;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        FrameLayout frameLayout = this$0.minimizeViewContainer;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    private final void enterMinimizeView(boolean minimize, Rect current) {
        if (this.behavior.isSupportMinimize() && this.behavior.getIsMinimized() != minimize) {
            Toolbar toolbar = this.minimizeToolbarView;
            if (toolbar != null) {
                toolbar.seslSetEatingTouch(!minimize);
            }
            Rect minimizeRect = this.behavior.getMinimizeRect(minimize, current);
            this.behavior.setMinimize(minimize, this);
            if (minimize) {
                startMinimizeAnimation(current, minimizeRect);
            } else {
                startUnMinimizeAnimation(current, minimizeRect);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        FrameLayout frameLayout = this$0.contentContainer;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        FrameLayout frameLayout = this$0.minimizeViewContainer;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        frameLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    private final Rect getCurrentRect() {
        return new Rect(getLeft(), getTop(), getWidth() + getLeft(), getHeight() + getTop());
    }

    /* JADX INFO: renamed from: getDefaultLayoutMode-WJaa9_w, reason: not valid java name */
    private final int m22097getDefaultLayoutModeWJaa9_w(Configuration configuration) {
        int i = configuration.orientation;
        return i != 1 ? i != 2 ? FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM() : FloatingPane.FloatingPaneMode.INSTANCE.MODE_SIDE() : FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM();
    }

    private final Rect getIntersectRect() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        ViewHelperKt.getCurrentLayoutBounds(this, rect);
        ViewHelperKt.getCurrentLayoutBounds(this.parentView, rect2);
        return rect.intersect(rect2) ? rect : new Rect();
    }

    @LayoutRes
    private final int getMenuLayoutResId() {
        return this.behavior.getMenuLayoutResId();
    }

    private final boolean getResizePinDirection(MotionEvent event) {
        int x = (int) event.getX();
        int y2 = (int) event.getY();
        this.resizePinPoint = 15;
        if (x < this.resizeTouchSize) {
            this.resizePinPoint = 15 ^ 1;
        }
        if (x > getWidth() - this.resizeTouchSize) {
            this.resizePinPoint ^= 4;
        }
        int height = getHeight();
        int i = this.resizeTouchSize;
        if (y2 > height - i) {
            this.resizePinPoint ^= 8;
        }
        if (y2 < i) {
            this.resizePinPoint ^= 2;
        }
        int resizePinDirectionFlags = this.resizePinPoint | this.behavior.getResizePinDirectionFlags();
        this.resizePinPoint = resizePinDirectionFlags;
        return resizePinDirectionFlags != 15;
    }

    private final Rect getTargetModeBounds(CommonBehavior behavior, boolean moveValidArea) {
        return behavior.getTargetModeBounds(this.parentView, moveValidArea);
    }

    public static /* synthetic */ Rect getTargetModeBounds$default(FloatingPaneView floatingPaneView, CommonBehavior commonBehavior, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return floatingPaneView.getTargetModeBounds(commonBehavior, z);
    }

    private final Toolbar getToolbar(ViewGroup parent) {
        Toolbar toolbar;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt instanceof Toolbar) {
                return (Toolbar) childAt;
            }
            if ((childAt instanceof ViewGroup) && (toolbar = getToolbar((ViewGroup) childAt)) != null) {
                return toolbar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$24$lambda$22(FloatingPaneView this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onHideAnimationUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$24$lambda$23(FloatingPaneView this$0, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onHideAnimationEnd();
    }

    private final void initEffect() {
        this.parentView.seslStopDrawAllRequested$material_release();
    }

    private final void initViewState() {
        setAlpha(1.0f);
        setScaleX(1.0f);
        setScaleY(1.0f);
        setTranslationY(0.0f);
        setTranslationX(0.0f);
    }

    /* JADX INFO: renamed from: isAllowedMode-J5JjPLc, reason: not valid java name */
    private final boolean m22098isAllowedModeJ5JjPLc(int mode) {
        if (!FloatingPane.FloatingPaneMode.m22081containsJ5JjPLc(this.allowedMode, mode)) {
            return false;
        }
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = m22101getBehaviorJ5JjPLc(mode);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return commonBehaviorM22101getBehaviorJ5JjPLc.isSupported(context);
    }

    private final boolean isNestedScrollSupport() {
        CommonBehavior commonBehavior = this.behavior;
        return (commonBehavior instanceof BottomBehavior) && !commonBehavior.getIsMinimized();
    }

    private static final boolean onConfigurationChanged$needUpdate(FloatingPaneView floatingPaneView, Configuration configuration) {
        Configuration configuration2 = floatingPaneView.prevConfiguration;
        Configuration configuration3 = null;
        if (configuration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prevConfiguration");
            configuration2 = null;
        }
        if (configuration2.orientation != configuration.orientation) {
            return true;
        }
        Configuration configuration4 = floatingPaneView.prevConfiguration;
        if (configuration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prevConfiguration");
            configuration4 = null;
        }
        if (configuration4.screenWidthDp != configuration.screenWidthDp) {
            return true;
        }
        Configuration configuration5 = floatingPaneView.prevConfiguration;
        if (configuration5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prevConfiguration");
        } else {
            configuration3 = configuration5;
        }
        return configuration3.screenHeightDp != configuration.screenHeightDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHideAnimationEnd() {
        setVisibility(8);
        Rect intersectRect = getIntersectRect();
        this.callbackNotifier.onInsert(intersectRect);
        if (this.behavior.isSupportMinimize() && this.behavior.getIsMinimized()) {
            setMinimizeStateAndAlphaAnimation(false);
        }
        IFloatingPaneCallback.AnimationListener hideAnimationListener = this.behavior.getHideAnimationListener();
        if (hideAnimationListener != null) {
            hideAnimationListener.onAnimationEnd(intersectRect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHideAnimationStart() {
        Rect intersectRect = getIntersectRect();
        IFloatingPaneCallback.AnimationListener hideAnimationListener = this.behavior.getHideAnimationListener();
        if (hideAnimationListener != null) {
            hideAnimationListener.onAnimationStart(intersectRect);
        }
        this.callbackNotifier.onPreInsert(intersectRect);
    }

    private final void onHideAnimationUpdate() {
        IFloatingPaneCallback.AnimationListener hideAnimationListener = this.behavior.getHideAnimationListener();
        if (hideAnimationListener != null) {
            hideAnimationListener.onAnimationUpdate(getIntersectRect());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMenuItemClickListener$lambda$0(FloatingPaneView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id = view.getId();
        m22095changePaneLayoutModeWX4EXPg$default(this$0, id == C4548R.id.bottom_view ? FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM() : id == C4548R.id.side_view ? FloatingPane.FloatingPaneMode.INSTANCE.MODE_SIDE() : FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING(), false, false, false, true, 14, null);
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private final void onMove(MotionEvent event, Rect nextResultViewRect) {
        int action = event.getAction();
        int iRoundToInt = MathKt.roundToInt(event.getRawX() - this.lastTouchRawX);
        int iRoundToInt2 = MathKt.roundToInt(event.getRawY() - this.lastTouchRawY);
        this.lastTouchRawX = event.getRawX();
        this.lastTouchRawY = event.getRawY();
        this.lastTouchX = event.getX();
        this.lastTouchY = event.getY();
        CommonBehavior commonBehavior = this.behavior;
        if (commonBehavior instanceof FloatingBehavior) {
            Intrinsics.checkNotNull(commonBehavior, "null cannot be cast to non-null type com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior");
            ((FloatingBehavior) commonBehavior).setLastPosX(getLeft());
            CommonBehavior commonBehavior2 = this.behavior;
            Intrinsics.checkNotNull(commonBehavior2, "null cannot be cast to non-null type com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior");
            ((FloatingBehavior) commonBehavior2).setLastPosY(getTop());
        }
        int iM22096checkLayoutModeChangeOnMoveWJaa9_w = m22096checkLayoutModeChangeOnMoveWJaa9_w(event);
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        if (!FloatingPane.FloatingPaneMode.m22083equalsimpl0(iM22096checkLayoutModeChangeOnMoveWJaa9_w, companion.MODE_FLOATING()) && (action == 1 || action == 3)) {
            m22095changePaneLayoutModeWX4EXPg$default(this, iM22096checkLayoutModeChangeOnMoveWJaa9_w, false, false, false, true, 14, null);
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
            this.parentView.seslStopDrawAllRequested$material_release();
            return;
        }
        nextResultViewRect.top += iRoundToInt2;
        nextResultViewRect.bottom += iRoundToInt2;
        nextResultViewRect.left += iRoundToInt;
        nextResultViewRect.right += iRoundToInt;
        if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, companion.MODE_FLOATING()) && (action == 1 || action == 3)) {
            updateViewBoundsInSideMoveableArea(nextResultViewRect);
        } else {
            ViewHelperKt.updateViewBounds(this, nextResultViewRect);
        }
        this.callbackNotifier.onFloatingMoved(nextResultViewRect.left, nextResultViewRect.top);
    }

    private final void onPreMove(MotionEvent event) {
        CommonBehavior commonBehavior = this.behavior;
        if ((commonBehavior instanceof FloatingBehavior) && !commonBehavior.getIsMinimized() && event.getAction() == 2) {
            startLongPressOrDragStartAnimation();
        }
    }

    private final void onResize(MotionEvent event, Rect nextResultViewRect) {
        int i = this.mode;
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        if (!FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, companion.MODE_FLOATING())) {
            nextResultViewRect = new Rect(this.originRect);
        }
        Rect rect = nextResultViewRect;
        Rect rect2 = new Rect();
        int action = event.getAction();
        resize((int) (event.getRawX() - this.downRawX), (int) (event.getRawY() - this.downRawY), rect, rect2, this.resizePinPoint);
        if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, companion.MODE_FLOATING())) {
            CommonBehavior commonBehavior = this.behavior;
            Intrinsics.checkNotNull(commonBehavior, "null cannot be cast to non-null type com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior");
            FloatingBehavior floatingBehavior = (FloatingBehavior) commonBehavior;
            rect.intersect(floatingBehavior.getMoveableArea(this.parentView));
            floatingBehavior.setLastPosX(rect.left);
            floatingBehavior.setLastPosY(rect.top);
            FloatingPaneLayout.showMinimizedIcon$default(this.parentView, this.behavior.isMinimizableRect(rect), false, 2, null);
            DragHandlerController dragHandlerController = this.dragHandlerController;
            ImageView dragHandlerView = this.dragHandlerView;
            Intrinsics.checkNotNullExpressionValue(dragHandlerView, "dragHandlerView");
            if (!dragHandlerController.isInArea(dragHandlerView, event)) {
                this.parentView.seslRequestDrawResizeRect$material_release(rect);
            }
        } else {
            CommonBehavior commonBehavior2 = this.behavior;
            BottomBehavior bottomBehavior = commonBehavior2 instanceof BottomBehavior ? (BottomBehavior) commonBehavior2 : null;
            if (bottomBehavior != null) {
                if (bottomBehavior.getIsMinimized()) {
                    Object upper = bottomBehavior.getMinVIThreshold().getUpper();
                    Intrinsics.checkNotNullExpressionValue(upper, "minVIThreshold.upper");
                    if (((Number) upper).intValue() > rect.top) {
                        setMinimizeStateAndAlphaAnimation(false);
                    }
                }
                Object lower = bottomBehavior.getMinVIThreshold().getLower();
                Intrinsics.checkNotNullExpressionValue(lower, "minVIThreshold.lower");
                boolean z = ((Number) lower).intValue() <= rect.top;
                if (z != this.isInMinimizeArea) {
                    this.isInMinimizeArea = z;
                    if (z) {
                        HapticFeedbackHelper.INSTANCE.onTouchMinimizeThreshold(this);
                    }
                }
            }
            ViewHelperKt.updateViewBounds(this, rect);
        }
        if (action == 1 || action == 3) {
            this.parentView.seslRequestDrawResizeRect$material_release(null);
            if (this.behavior.isSupportMinimize()) {
                CommonBehavior commonBehavior3 = this.behavior;
                if (commonBehavior3 instanceof BottomBehavior) {
                    Intrinsics.checkNotNull(commonBehavior3, "null cannot be cast to non-null type com.google.android.material.oneui.floatingdock.behavior.BottomBehavior");
                    BottomBehavior bottomBehavior2 = (BottomBehavior) commonBehavior3;
                    if (bottomBehavior2.getCloseVIThreshold().contains(Integer.valueOf(rect.top))) {
                        hide(true);
                    } else if (bottomBehavior2.getMinVIThreshold().contains(Integer.valueOf(rect.top))) {
                        enterMinimizeView(true, rect);
                        return;
                    } else if (bottomBehavior2.getMaxVIThreshold().contains(Integer.valueOf(rect.top))) {
                        rect.top = this.parentView.getHeight() - bottomBehavior2.getMaxHeight();
                        rect.bottom = this.parentView.getHeight();
                        startBoundAnimation$default(this, rect, 0L, false, 6, null);
                    }
                } else if (commonBehavior3.isMinimizableRect(rect)) {
                    this.parentView.showMinimizedIcon(false, true);
                    enterMinimizeView(true);
                    return;
                }
            }
            if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, companion.MODE_FLOATING())) {
                startBoundAnimation$default(this, rect, 0L, false, 6, null);
                return;
            }
            if (isShowing()) {
                if ((this.behavior instanceof SideBehavior) && rect2.contains(rect)) {
                    startBoundAnimation$default(this, rect2, 0L, false, 6, null);
                } else {
                    this.callbackNotifier.onInsert(rect);
                    this.behavior.updateLayoutParams(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShowAnimationEnd() {
        Rect intersectRect = getIntersectRect();
        this.callbackNotifier.onInsert(intersectRect);
        IFloatingPaneCallback.AnimationListener showAnimationListener = this.behavior.getShowAnimationListener();
        if (showAnimationListener != null) {
            showAnimationListener.onAnimationEnd(intersectRect);
        }
        this.behavior.updateLayoutParams(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShowAnimationStart() {
        Rect intersectRect = getIntersectRect();
        this.callbackNotifier.onPreInsert(intersectRect);
        IFloatingPaneCallback.AnimationListener showAnimationListener = this.behavior.getShowAnimationListener();
        if (showAnimationListener != null) {
            showAnimationListener.onAnimationStart(intersectRect);
        }
    }

    private final void onShowAnimationUpdate() {
        IFloatingPaneCallback.AnimationListener showAnimationListener = this.behavior.getShowAnimationListener();
        if (showAnimationListener != null) {
            showAnimationListener.onAnimationUpdate(getIntersectRect());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pressScaleAnimation$lambda$4$lambda$3(FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setScaleX(((Float) animatedValue).floatValue());
        Object animatedValue2 = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        this$0.setScaleY(((Float) animatedValue2).floatValue());
    }

    private final void resize(int diffX, int diffY, Rect newRect, Rect minRect, int resizePinPoint) {
        if ((resizePinPoint & 1) == 0) {
            int iWidth = newRect.width() - diffX;
            int i = this.mode;
            FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
            if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, companion.MODE_FLOATING()) ? true : FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, companion.MODE_SIDE())) {
                if (iWidth > this.behavior.getMaxWidth()) {
                    newRect.left = newRect.right - this.behavior.getMaxWidth();
                } else if (iWidth <= this.behavior.getMinWidth()) {
                    minRect.set(newRect);
                    minRect.left = newRect.right - this.behavior.getMinWidth();
                    newRect.left = (newRect.right - this.behavior.getMinWidth()) + ((int) ((diffX - (newRect.width() - this.behavior.getMinWidth())) * 0.1f));
                } else {
                    newRect.left += diffX;
                }
            }
        }
        if ((resizePinPoint & 2) == 0) {
            int iHeight = newRect.height() - diffY;
            int i2 = this.mode;
            FloatingPane.FloatingPaneMode.Companion companion2 = FloatingPane.FloatingPaneMode.INSTANCE;
            if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(i2, companion2.MODE_FLOATING()) ? true : FloatingPane.FloatingPaneMode.m22083equalsimpl0(i2, companion2.MODE_BOTTOM())) {
                if (iHeight > this.behavior.getMaxHeight()) {
                    newRect.top = newRect.bottom - this.behavior.getMaxHeight();
                } else if (iHeight < this.behavior.getMinHeight()) {
                    minRect.set(newRect);
                    minRect.top = newRect.bottom - this.behavior.getMinHeight();
                    newRect.top = newRect.bottom - this.behavior.getMinHeight();
                } else {
                    newRect.top += diffY;
                }
            }
        }
        if ((resizePinPoint & 4) == 0) {
            int iWidth2 = newRect.width() + diffX;
            int i4 = this.mode;
            FloatingPane.FloatingPaneMode.Companion companion3 = FloatingPane.FloatingPaneMode.INSTANCE;
            if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(i4, companion3.MODE_FLOATING()) ? true : FloatingPane.FloatingPaneMode.m22083equalsimpl0(i4, companion3.MODE_SIDE())) {
                if (iWidth2 > this.behavior.getMaxWidth()) {
                    newRect.right = this.behavior.getMaxWidth() + newRect.left;
                } else if (iWidth2 <= this.behavior.getMinWidth()) {
                    minRect.set(newRect);
                    minRect.right = newRect.left - this.behavior.getMinWidth();
                    newRect.right = this.behavior.getMinWidth() + newRect.left + ((int) ((diffX - (this.behavior.getMinWidth() - newRect.width())) * 0.1f));
                } else {
                    newRect.right += diffX;
                }
            }
        }
        if ((resizePinPoint & 8) == 0) {
            int iHeight2 = newRect.height() + diffY;
            int i5 = newRect.bottom + diffY;
            if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING())) {
                if (i5 > this.parentView.getHeight()) {
                    newRect.bottom = this.parentView.getHeight();
                    return;
                }
                if (iHeight2 > this.behavior.getMinHeight()) {
                    newRect.bottom += diffY;
                    return;
                }
                minRect.set(newRect);
                minRect.bottom = newRect.top - this.behavior.getMinHeight();
                newRect.bottom = this.behavior.getMinHeight() + newRect.top + ((int) ((diffY - (this.behavior.getMinHeight() - newRect.height())) * 0.1f));
            }
        }
    }

    private final void setMinimizeStateAndAlphaAnimation(boolean minimize) {
        Toolbar toolbar = this.minimizeToolbarView;
        if (toolbar != null) {
            toolbar.seslSetEatingTouch(!minimize);
        }
        this.behavior.setMinimize(minimize, this);
        if (this.haveAnotherMinimizeView) {
            if (minimize) {
                startMinimizeAlphaAnimation();
            } else {
                startUnMinimizeAlphaAnimation();
            }
        }
    }

    private final boolean shouldInterceptTouch(MotionEvent event) {
        DragHandlerController dragHandlerController = this.dragHandlerController;
        ImageView dragHandlerView = this.dragHandlerView;
        Intrinsics.checkNotNullExpressionValue(dragHandlerView, "dragHandlerView");
        return dragHandlerController.isInArea(dragHandlerView, event) || this.behavior.shouldInterceptTouch(this, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$18$lambda$16(Ref.BooleanRef isStart, FloatingPaneView this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(isStart, "$isStart");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!isStart.element) {
            this$0.onShowAnimationStart();
            isStart.element = true;
        }
        this$0.onShowAnimationUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$18$lambda$17(FloatingPaneView this$0, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onShowAnimationEnd();
    }

    private final void showPopup() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (PolicyHelperKt.isPhoneSize(context)) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        View viewInflate = LayoutInflater.from(getContext()).inflate(getMenuLayoutResId(), (ViewGroup) null);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(C4548R.id.floating_pane_menu_container);
        if (viewGroup != null) {
            Intrinsics.checkNotNullExpressionValue(viewGroup, "findViewById<ViewGroup>(…ting_pane_menu_container)");
            Sequence<FloatingMenuItemView> sequenceFilter = SequencesKt.filter(ViewGroupKt.getChildren(viewGroup), new Function1<Object, Boolean>() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$showPopup$lambda$11$lambda$10$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable Object obj) {
                    return Boolean.valueOf(obj instanceof FloatingMenuItemView);
                }
            });
            Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            for (FloatingMenuItemView floatingMenuItemView : sequenceFilter) {
                int id = floatingMenuItemView.getId();
                Pair pair = id == C4548R.id.bottom_view ? new Pair(FloatingPane.FloatingPaneMode.m22079boximpl(FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM()), viewGroup.getResources().getString(C4548R.string.sesl_floating_pane_menu_item_bottom_view)) : id == C4548R.id.side_view ? new Pair(FloatingPane.FloatingPaneMode.m22079boximpl(FloatingPane.FloatingPaneMode.INSTANCE.MODE_SIDE()), viewGroup.getResources().getString(C4548R.string.sesl_floating_pane_menu_item_side_view)) : id == C4548R.id.floating_view ? new Pair(FloatingPane.FloatingPaneMode.m22079boximpl(FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING()), viewGroup.getResources().getString(C4548R.string.sesl_floating_pane_menu_item_floating_view)) : new Pair(FloatingPane.FloatingPaneMode.m22079boximpl(FloatingPane.FloatingPaneMode.INSTANCE.MODE_NONE()), "");
                int type = ((FloatingPane.FloatingPaneMode) pair.component1()).getType();
                String str = (String) pair.component2();
                floatingMenuItemView.setEnabled(m22098isAllowedModeJ5JjPLc(type));
                floatingMenuItemView.setOnClickListener(this.onMenuItemClickListener);
                TooltipCompat.setTooltipText(floatingMenuItemView, str);
                floatingMenuItemView.setContentDescription(str);
                arrayList.add(floatingMenuItemView);
            }
        }
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setElevation(getContext().getResources().getDimension(C4548R.dimen.sesl_floating_pane_menu_container_elevation));
        popupWindow.setAnimationStyle(C4548R.style.sesl_floating_popup_menu_window_animation);
        popupWindow.setOnDismissListener(new C4797h(this, 0));
        int[] iArr = new int[2];
        this.dragHandlerView.getLocationInWindow(iArr);
        popupWindow.showAtLocation(this.dragHandlerView, 8388659, iArr[0] - ((new Size(popupWindow.getContentView().getMeasuredWidth(), popupWindow.getContentView().getMeasuredHeight()).getWidth() - this.dragHandlerView.getWidth()) / 2), this.dragHandlerView.getPaddingTop() + iArr[1]);
        if (!arrayList.isEmpty()) {
            postDelayed(new Runnable() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$showPopup$lambda$15$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    ((FloatingMenuItemView) arrayList.get(0)).sendAccessibilityEvent(8);
                }
            }, 500L);
        }
        this.popupWindow = popupWindow;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        if (ContextHelperKt.isTalkbackOn(context2)) {
            return;
        }
        this.handler.postDelayed(this.hideRunnable, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopup$lambda$15$lambda$12(FloatingPaneView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.popupWindow = null;
        this$0.handler.removeCallbacks(this$0.hideRunnable);
    }

    private final void startAnimation(final Rect from, final Rect to, long animatorDuration) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.animator = null;
        this.endBounds.set(to);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C4565b(from, this, 2));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$startAnimation$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.animator = null;
                if (this.this$0.isShowing()) {
                    this.this$0.callbackNotifier.onInsert(to);
                    this.this$0.behavior.updateLayoutParams(this.this$0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0.isShowing()) {
                    this.this$0.callbackNotifier.onPreInsert(from);
                }
            }
        });
        valueAnimatorOfFloat.setInterpolator(INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(animatorDuration);
        valueAnimatorOfFloat.start();
        this.callbackNotifier.onResizeAnimate(from, to, valueAnimatorOfFloat.getDuration());
        this.animator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$53$lambda$52(Rect from, FloatingPaneView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        Rect r = RECT_EVALUATOR.evaluate(((Float) animatedValue).floatValue(), from, this$0.endBounds);
        Intrinsics.checkNotNullExpressionValue(r, "r");
        ViewHelperKt.updateViewBounds(this$0, r);
    }

    private final void startBoundAnimation(Rect to, long duration, boolean moveValidArea) {
        if (moveValidArea) {
            ViewHelperKt.getCurrentLayoutBounds(this, this.originBounds);
        } else {
            this.originBounds.set(getIntersectRect());
        }
        Rect rect = new Rect(this.originBounds);
        if (Intrinsics.areEqual(rect, to)) {
            return;
        }
        startAnimation(rect, to, duration);
    }

    public static /* synthetic */ void startBoundAnimation$default(FloatingPaneView floatingPaneView, Rect rect, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 400;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        floatingPaneView.startBoundAnimation(rect, j, z);
    }

    private final void startLongPressOrDragStartAnimation() {
        if (this.pressScaleAnimation.isRunning()) {
            this.pressScaleAnimation.cancel();
        }
        this.moveScaleAnimation.animateToFinalPosition(LONG_PRESS_AND_DRAG_SCALE_ANIM_FINAL_VALUE, LONG_PRESS_AND_DRAG_SCALE_ANIM_FINAL_VALUE);
    }

    private final void startMinimizeAlphaAnimation() {
        if (this.exitMinimizeAlphaAnimation.isRunning()) {
            this.exitMinimizeAlphaAnimation.cancel();
        }
        if (this.enterMinimizeAlphaAnimation.isRunning()) {
            this.enterMinimizeAlphaAnimation.cancel();
        }
        this.minimizeViewContainer.setAlpha(0.0f);
        this.minimizeViewContainer.setVisibility(0);
        this.enterMinimizeAlphaAnimation.start();
    }

    private final void startMinimizeAnimation(Rect from, Rect to) {
        this.endBounds.set(to);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        springAnimation.setSpring(new SpringForce());
        springAnimation.getSpring().setDampingRatio(1.0f);
        springAnimation.getSpring().setStiffness(361.0f);
        springAnimation.getSpring().setFinalPosition(1000.0f);
        springAnimation.setStartValue(0.0f);
        springAnimation.setMinValue(0.0f);
        springAnimation.setMaxValue(1000.0f);
        springAnimation.addUpdateListener(new C4788b(1, from, this));
        springAnimation.addEndListener(new C4795f(0, to, this));
        this.callbackNotifier.onPreInsert(from);
        this.callbackNotifier.onResizeAnimate(from, to, 0L);
        springAnimation.start();
        if (this.haveAnotherMinimizeView) {
            startMinimizeAlphaAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMinimizeAnimation$lambda$38$lambda$36(Rect from, FloatingPaneView this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect r = RECT_EVALUATOR.evaluate(f * 0.001f, from, this$0.endBounds);
        Intrinsics.checkNotNullExpressionValue(r, "r");
        ViewHelperKt.updateViewBounds(this$0, r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMinimizeAnimation$lambda$38$lambda$37(FloatingPaneView this$0, Rect to, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(to, "$to");
        this$0.callbackNotifier.onInsert(to);
    }

    private final void startReleaseAnimation() {
        if (this.pressScaleAnimation.isRunning()) {
            this.pressScaleAnimation.cancel();
        }
        this.moveScaleAnimation.animateToFinalPosition(1.0f, 1.0f);
    }

    private final void startUnMinimizeAlphaAnimation() {
        if (this.enterMinimizeAlphaAnimation.isRunning()) {
            this.enterMinimizeAlphaAnimation.cancel();
        }
        if (this.exitMinimizeAlphaAnimation.isRunning()) {
            this.exitMinimizeAlphaAnimation.cancel();
        }
        this.contentContainer.setVisibility(0);
        this.contentContainer.setAlpha(0.0f);
        this.exitMinimizeAlphaAnimation.start();
    }

    private final void startUnMinimizeAnimation(Rect from, Rect to) {
        this.endBounds.set(to);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        springAnimation.setSpring(new SpringForce());
        springAnimation.getSpring().setDampingRatio(1.0f);
        springAnimation.getSpring().setStiffness(361.0f);
        springAnimation.getSpring().setFinalPosition(1000.0f);
        springAnimation.setStartValue(0.0f);
        springAnimation.setMinValue(0.0f);
        springAnimation.setMaxValue(1000.0f);
        springAnimation.addUpdateListener(new C4788b(0, from, this));
        springAnimation.addEndListener(new C4795f(1, to, this));
        this.callbackNotifier.onPreInsert(from);
        this.callbackNotifier.onResizeAnimate(from, to, 0L);
        springAnimation.start();
        if (this.haveAnotherMinimizeView) {
            startUnMinimizeAlphaAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUnMinimizeAnimation$lambda$46$lambda$44(Rect from, FloatingPaneView this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect r = RECT_EVALUATOR.evaluate(f * 0.001f, from, this$0.endBounds);
        Intrinsics.checkNotNullExpressionValue(r, "r");
        ViewHelperKt.updateViewBounds(this$0, r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUnMinimizeAnimation$lambda$46$lambda$45(FloatingPaneView this$0, Rect to, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(to, "$to");
        this$0.callbackNotifier.onInsert(to);
    }

    private final void tryChangeFloatingModeByLongPress() {
        int iMODE_FLOATING = FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING();
        if (!m22098isAllowedModeJ5JjPLc(iMODE_FLOATING)) {
            LogTagHelperKt.error(this, "Can't change to floatingMode. It is not allowed");
            return;
        }
        if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, iMODE_FLOATING)) {
            return;
        }
        CommonBehavior commonBehavior = this.behaviors.get(FloatingPane.FloatingPaneMode.m22079boximpl(iMODE_FLOATING));
        if (commonBehavior != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (!commonBehavior.isSupported(context)) {
                return;
            }
        }
        this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_MOVE());
        updateFloatingPosition();
        m22095changePaneLayoutModeWX4EXPg$default(this, iMODE_FLOATING, false, true, false, true, 10, null);
    }

    private final void updateDivider(CommonBehavior behavior) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_background_divider_size);
        View dividerView = this.dividerView;
        Intrinsics.checkNotNullExpressionValue(dividerView, "dividerView");
        behavior.updateDivider(dividerView, dimensionPixelSize);
    }

    private final void updateFloatingPosition() {
        Map<FloatingPane.FloatingPaneMode, CommonBehavior> map = this.behaviors;
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        CommonBehavior commonBehavior = map.get(FloatingPane.FloatingPaneMode.m22079boximpl(companion.MODE_FLOATING()));
        FloatingBehavior floatingBehavior = commonBehavior instanceof FloatingBehavior ? (FloatingBehavior) commonBehavior : null;
        if (floatingBehavior == null) {
            return;
        }
        float requestedWidth = floatingBehavior.getRequestedWidth() / 2;
        floatingBehavior.setLastPosY(getTop());
        if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, companion.MODE_BOTTOM()) || FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, companion.MODE_SIDE())) {
            floatingBehavior.setLastPosX((int) ((getLeft() + this.lastTouchX) - requestedWidth));
        }
    }

    private final void updateMinimize() {
        if (this.behavior.updateMinimize(this)) {
            setMinimizeStateAndAlphaAnimation(this.behavior.getIsMinimized());
        }
    }

    private final void updateState(MotionEvent event) {
        this.behavior.updateState(this, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(CommonBehavior behavior) {
        setElevation(behavior instanceof BottomBehavior ? true : behavior instanceof SideBehavior ? 0.0f : this.floatLayoutElevation);
        setBackgroundResource(behavior.getBackgroundResId());
        ImageView imageView = this.dragHandlerView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setVisibility((PolicyHelperKt.isPhoneSize(context) && (behavior instanceof SideBehavior)) ? 8 : 0);
        updateDivider(behavior);
    }

    private final void updateViewBoundsInSideMoveableArea(Rect nextResultViewRect) {
        CommonBehavior commonBehavior = this.behavior;
        FloatingBehavior floatingBehavior = commonBehavior instanceof FloatingBehavior ? (FloatingBehavior) commonBehavior : null;
        if (floatingBehavior != null) {
            if (RectHelperKt.moveInsideAndIntersect(nextResultViewRect, floatingBehavior.getMoveableArea(this.parentView))) {
                startBoundAnimation$default(this, nextResultViewRect, 0L, true, 2, null);
            } else {
                ViewHelperKt.updateViewBounds(this, nextResultViewRect);
            }
        }
    }

    public final void addCallbacks(@NotNull IFloatingPaneCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.callbackNotifier.contains((Object) callback)) {
            return;
        }
        this.callbackNotifier.add(callback);
    }

    /* JADX INFO: renamed from: changePaneLayoutMode-WX4EXPg, reason: not valid java name */
    public final void m22099changePaneLayoutModeWX4EXPg(int requestMode, boolean invalidate, boolean isLongPress, boolean skipAnimate, boolean fromUser) {
        int iM22097getDefaultLayoutModeWJaa9_w;
        LogTagHelperKt.info(this, "Change Pane Mode to " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(requestMode)));
        int i = this.mode;
        if (m22098isAllowedModeJ5JjPLc(requestMode)) {
            iM22097getDefaultLayoutModeWJaa9_w = requestMode;
        } else {
            LogTagHelperKt.error(this, "Change mode canceled, Because of the mode " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(requestMode)) + " is not allowed");
            Configuration configuration = getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "resources.configuration");
            iM22097getDefaultLayoutModeWJaa9_w = m22097getDefaultLayoutModeWJaa9_w(configuration);
        }
        if (invalidate || !FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, iM22097getDefaultLayoutModeWJaa9_w)) {
            initEffect();
            if (fromUser || !this.isUserModeChanged) {
                if (fromUser) {
                    LogTagHelperKt.debug(this, "user has changed the mode(" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(requestMode)) + SQLKeyword.COMMA + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(iM22097getDefaultLayoutModeWJaa9_w)) + PropertyUtils.MAPPED_DELIM2);
                    this.isUserModeChanged = true;
                }
                if (!FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, iM22097getDefaultLayoutModeWJaa9_w)) {
                    this.behavior.initBehavior(this.parentView);
                    if (this.behavior.getIsMinimized()) {
                        StringBuilder sbM3200j = AbstractC4539a.m3200j("Change Mode ClearMinimizeState invalidate=", " (", invalidate);
                        sbM3200j.append((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode));
                        sbM3200j.append(" -> ");
                        sbM3200j.append((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(iM22097getDefaultLayoutModeWJaa9_w));
                        sbM3200j.append(PropertyUtils.MAPPED_DELIM2);
                        LogTagHelperKt.debug(this, sbM3200j.toString());
                        setMinimizeStateAndAlphaAnimation(false);
                    }
                }
                this.mode = iM22097getDefaultLayoutModeWJaa9_w;
            } else {
                LogTagHelperKt.debug(this, "user has changed the mode(" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode)) + ") already. Automatic mode change is ignored");
            }
            this.behavior = m22101getBehaviorJ5JjPLc(this.mode);
            if (isShowing() && !FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, this.mode)) {
                if (isLongPress) {
                    CommonBehavior commonBehavior = this.behavior;
                    if ((commonBehavior instanceof FloatingBehavior ? (FloatingBehavior) commonBehavior : null) != null) {
                        HapticFeedbackHelper.INSTANCE.onLongPress(this);
                    }
                } else {
                    CommonBehavior commonBehavior2 = this.behavior;
                    FloatingBehavior floatingBehavior = commonBehavior2 instanceof FloatingBehavior ? (FloatingBehavior) commonBehavior2 : null;
                    if (floatingBehavior != null) {
                        floatingBehavior.setLastPosX(getLeft() + (((getRight() - getLeft()) - floatingBehavior.getRequestedWidth()) / 2));
                        floatingBehavior.setLastPosY(getTop());
                        int bottom = (getBottom() - floatingBehavior.getRequestedHeight()) - this.bottomToFloatingBottomMargin;
                        if (FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM()) && getTop() > bottom) {
                            floatingBehavior.setLastPosY(bottom);
                        }
                    }
                }
            }
            updateView(this.behavior);
            if (isShowing()) {
                updateMinimize();
                ViewHelperKt.getCurrentLayoutBounds(this, new Rect());
                if (!FloatingPane.FloatingPaneMode.m22083equalsimpl0(i, this.mode)) {
                    this.callbackNotifier.onModeChanged(this.mode);
                }
            }
            long j = skipAnimate ? 0L : isLongPress ? 300L : 400L;
            Rect targetModeBounds = getTargetModeBounds(this.behavior, !isLongPress);
            this.behavior.updateLayoutParams(this);
            startBoundAnimation$default(this, targetModeBounds, j, false, 4, null);
        }
    }

    /* JADX INFO: renamed from: getAllowedMode-91QzYFA$material_release, reason: not valid java name and from getter */
    public final int getAllowedMode() {
        return this.allowedMode;
    }

    @NotNull
    /* JADX INFO: renamed from: getBehavior-J5JjPLc, reason: not valid java name */
    public final CommonBehavior m22101getBehaviorJ5JjPLc(int mode) {
        CommonBehavior commonBehavior = this.behaviors.get(FloatingPane.FloatingPaneMode.m22079boximpl(mode));
        if (commonBehavior != null) {
            return commonBehavior;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new BottomBehavior(context, FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM(), this.callbackNotifier, this.viewModel, this.resizeTouchSize, null);
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    /* JADX INFO: renamed from: getMode-91QzYFA, reason: not valid java name and from getter */
    public final int getMode() {
        return this.mode;
    }

    public final boolean getResizeByContentScrollEnabled() {
        return this.resizeByContentScrollEnabled;
    }

    public final void hide(boolean animate) {
        if (isShowing()) {
            this.isUserModeChanged = false;
            this.trackingScroll = false;
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            CommonBehavior commonBehavior = this.behavior;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SpringAnimation hideSpringAnimation = commonBehavior.getHideSpringAnimation(context, this);
            if (hideSpringAnimation != null) {
                hideSpringAnimation.addUpdateListener(new C4778c(this, 2));
                hideSpringAnimation.addEndListener(new C4794e(this, 0));
                onHideAnimationStart();
                hideSpringAnimation.start();
                if (!animate) {
                    hideSpringAnimation.skipToEnd();
                }
            } else {
                hideSpringAnimation = null;
            }
            if (hideSpringAnimation == null) {
                CommonBehavior commonBehavior2 = this.behavior;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                AnimatorSet hideAnimation = commonBehavior2.getHideAnimation(context2, this);
                if (hideAnimation != null) {
                    hideAnimation.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$hide$lambda$27$$inlined$doOnStart$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            this.this$0.onHideAnimationStart();
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    hideAnimation.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$hide$lambda$27$$inlined$doOnEnd$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            this.this$0.onHideAnimationEnd();
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    });
                    if (!animate) {
                        hideAnimation.setDuration(0L);
                    }
                    hideAnimation.start();
                }
            }
        }
    }

    public final boolean isMinimizeView() {
        return this.behavior.isSupportMinimize() && this.behavior.getIsMinimized();
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onChangedParentBounds$material_release(int left, int top, int right, int bottom) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        StringBuilder sb = new StringBuilder("onChangedParentBounds ");
        sb.append(this.prevParentRect);
        sb.append(" -> (");
        sb.append(left);
        sb.append(SQLKeyword.COMMA);
        AbstractC2821a.m2235z(sb, top, right, SQLKeyword.COMMA, SQLKeyword.COMMA);
        sb.append(bottom);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        LogTagHelperKt.debug(this, sb.toString());
        Rect currentRect = getCurrentRect();
        boolean z4 = false;
        boolean z5 = this.behavior.getRequestedWidth() == currentRect.width();
        boolean z6 = this.behavior.getRequestedHeight() == currentRect.height();
        Iterator<T> it = this.behaviors.values().iterator();
        while (it.hasNext()) {
            ((CommonBehavior) it.next()).updateBehavior(this.parentView);
        }
        ValueAnimator valueAnimator = this.animator;
        boolean z7 = valueAnimator != null && valueAnimator.isRunning();
        LogTagHelperKt.debug(this, "onChangedParentBound " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode)) + ", animating=" + z7);
        if (z7) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null) {
                valueAnimator2.end();
            }
            this.animator = null;
            m22095changePaneLayoutModeWX4EXPg$default(this, this.mode, true, false, false, false, 28, null);
        } else {
            Rect rect = this.prevParentRect;
            boolean z8 = (rect.left == left && rect.right == right) ? false : true;
            boolean z9 = (rect.top == top && rect.bottom == bottom) ? false : true;
            CommonBehavior commonBehavior = this.behavior;
            if (commonBehavior instanceof SideBehavior) {
                if (z5 && z8) {
                    z4 = true;
                }
                if (z4) {
                    z2 = z8;
                    z3 = z4;
                    z = z9;
                    str = "onChangedParentBound ";
                    m22095changePaneLayoutModeWX4EXPg$default(this, this.mode, true, false, true, false, 20, null);
                } else {
                    z = z9;
                    z2 = z8;
                    z3 = z4;
                    str = "onChangedParentBound ";
                }
                Rect currentRect2 = getCurrentRect();
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode));
                sb2.append(", update=");
                sb2.append(z3);
                sb2.append(SQLKeyword.COMMA);
                sb2.append(currentRect);
                sb2.append(" -> ");
                sb2.append(currentRect2);
                sb2.append(", w=");
                AbstractC2821a.m2208C(sb2, z2, ", h=", z, ", dw=");
                sb2.append(z5);
                sb2.append(", dh=");
                sb2.append(z6);
                LogTagHelperKt.debug(this, sb2.toString());
            } else if (commonBehavior instanceof BottomBehavior) {
                if (z6 && z9) {
                }
                if (z4) {
                }
                Rect currentRect22 = getCurrentRect();
                StringBuilder sb22 = new StringBuilder(str);
                sb22.append((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode));
                sb22.append(", update=");
                sb22.append(z3);
                sb22.append(SQLKeyword.COMMA);
                sb22.append(currentRect);
                sb22.append(" -> ");
                sb22.append(currentRect22);
                sb22.append(", w=");
                AbstractC2821a.m2208C(sb22, z2, ", h=", z, ", dw=");
                sb22.append(z5);
                sb22.append(", dh=");
                sb22.append(z6);
                LogTagHelperKt.debug(this, sb22.toString());
            } else {
                if (commonBehavior instanceof FloatingBehavior) {
                    Intrinsics.checkNotNull(commonBehavior, "null cannot be cast to non-null type com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior");
                    FloatingBehavior floatingBehavior = (FloatingBehavior) commonBehavior;
                    if (z8 || z9) {
                        if (!z5 || !z6) {
                            Rect rect2 = new Rect(currentRect);
                            updateViewBoundsInSideMoveableArea(rect2);
                            floatingBehavior.setLastPosX(rect2.left);
                            floatingBehavior.setLastPosY(rect2.top);
                        }
                    }
                }
                if (z4) {
                }
                Rect currentRect222 = getCurrentRect();
                StringBuilder sb222 = new StringBuilder(str);
                sb222.append((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode));
                sb222.append(", update=");
                sb222.append(z3);
                sb222.append(SQLKeyword.COMMA);
                sb222.append(currentRect);
                sb222.append(" -> ");
                sb222.append(currentRect222);
                sb222.append(", w=");
                AbstractC2821a.m2208C(sb222, z2, ", h=", z, ", dw=");
                sb222.append(z5);
                sb222.append(", dh=");
                sb222.append(z6);
                LogTagHelperKt.debug(this, sb222.toString());
            }
        }
        this.prevParentRect.set(left, top, right, bottom);
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.prevConfiguration == null || onConfigurationChanged$needUpdate(this, newConfig)) {
            final int iM22097getDefaultLayoutModeWJaa9_w = !FloatingPane.FloatingPaneMode.m22083equalsimpl0(this.mode, FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING()) ? m22097getDefaultLayoutModeWJaa9_w(newConfig) : this.mode;
            Iterator<T> it = this.behaviors.values().iterator();
            while (it.hasNext()) {
                ((CommonBehavior) it.next()).saveState(this.parentView);
            }
            this.parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$onConfigurationChanged$2$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    FloatingPaneLayout floatingPaneLayout = this.this$0.parentView;
                    LogTagHelperKt.debug(floatingPaneLayout, "onConfigurationChanged parentView(" + floatingPaneLayout.getWidth() + SQLKeyword.COMMA + floatingPaneLayout.getHeight() + ") (" + floatingPaneLayout.getLeft() + SQLKeyword.COMMA + floatingPaneLayout.getTop() + SQLKeyword.COMMA + floatingPaneLayout.getRight() + SQLKeyword.COMMA + floatingPaneLayout.getBottom() + ") ");
                    Collection<CommonBehavior> collectionValues = this.this$0.behaviors.values();
                    FloatingPaneView floatingPaneView = this.this$0;
                    for (CommonBehavior commonBehavior : collectionValues) {
                        commonBehavior.updateBehavior(floatingPaneView.parentView);
                        commonBehavior.loadState(floatingPaneView.parentView);
                    }
                    FloatingPaneView.m22095changePaneLayoutModeWX4EXPg$default(this.this$0, iM22097getDefaultLayoutModeWJaa9_w, true, false, true, false, 20, null);
                    this.this$0.parentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
            this.prevConfiguration = newConfig;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (this.dragHandlerController.onInterceptTouchEvent(event)) {
            LogTagHelperKt.debug(this, "dragHandlerController onInterceptTouchEvent=" + event.getAction());
            return true;
        }
        if (action != 0 || !shouldInterceptTouch(event)) {
            return super.onInterceptTouchEvent(event);
        }
        LogTagHelperKt.debug(this, "shouldIntercept onInterceptTouchEvent " + event.getAction());
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed && getVisibility() == 0) {
            this.callbackNotifier.onLayoutChanged(MathKt.roundToInt(getTranslationX()) + left, MathKt.roundToInt(getTranslationY()) + top, MathKt.roundToInt(getTranslationX()) + right, MathKt.roundToInt(getTranslationY()) + bottom);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NotNull View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        LogTagHelperKt.debug(this, "onNestedFling velocityX=" + velocityX + ", velocityY=" + velocityY + ", consumed=" + consumed);
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        LogTagHelperKt.debug(this, "onNestedPreFling velocityX=" + velocityX + ", velocityY=" + velocityY);
        return this.trackingScroll || super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx, int dy, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        StringBuilder sb = new StringBuilder("onNestedPreScroll trackingScroll=");
        sb.append(this.trackingScroll);
        sb.append(" dx=");
        sb.append(dx);
        sb.append(" dy=");
        sb.append(dy);
        sb.append(" consumed=[");
        sb.append(consumed[0]);
        sb.append(SQLKeyword.COMMA);
        AbstractC2821a.m2235z(sb, consumed[1], type, "] type=", " target=");
        sb.append(target);
        LogTagHelperKt.debug(this, sb.toString());
        if (this.startNestedScroll) {
            if (dy <= 0 && androidx.appcompat.oneui.common.internal.util.ViewHelperKt.isAtTop(target)) {
                this.trackingScroll = true;
                this.sumDy = 0;
                this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_RESIZE());
                LogTagHelperKt.debug(this, "onNestedScroll trackingScroll start");
            }
            this.startNestedScroll = false;
        }
        if (this.trackingScroll) {
            consumed[1] = dy;
            int i = this.sumDy + dy;
            this.sumDy = i;
            updateDelta(-i);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.startNestedScroll = this.resizeByContentScrollEnabled && isNestedScrollSupport() && androidx.appcompat.oneui.common.internal.util.ViewHelperKt.isAtTop(target) && axes == 2;
        LogTagHelperKt.debug(this, "onStartNestedScroll startNestedScroll=" + this.startNestedScroll + " resizeByContentScrollEnabled=" + this.resizeByContentScrollEnabled + " mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(this.mode)) + " axes=" + axes + " type=" + type + " target=" + target);
        return this.startNestedScroll;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        LogTagHelperKt.debug(this, "onStopNestedScroll trackingScroll=" + this.trackingScroll);
        if (this.trackingScroll) {
            if (!runNestedScrollAnimation()) {
                this.callbackNotifier.onInsert(getCurrentRect());
            }
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
        this.sumDy = 0;
        this.startNestedScroll = false;
        this.trackingScroll = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.downRawX = event.getRawX();
            this.downRawY = event.getRawY();
            this.originRect = getCurrentRect();
        }
        if (this.dragHandlerController.onTouchEvent(event)) {
            LogTagHelperKt.debug(this, "return by dragHandlerController onTouchEvent=" + event.getAction());
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
            return true;
        }
        if (action == 0) {
            this.lastTouchRawX = this.downRawX;
            this.lastTouchRawY = this.downRawY;
            this.lastTouchX = event.getX();
            this.lastTouchY = event.getY();
            this.isInMinimizeArea = this.behavior.getIsMinimized();
            if (shouldInterceptTouch(event)) {
                updateState(event);
                if (FloatingPane.FloatingPaneState.m22091equalsimpl0(this.viewModel.getState(), FloatingPane.FloatingPaneState.INSTANCE.STATE_RESIZE())) {
                    getResizePinDirection(event);
                }
                LogTagHelperKt.debug(this, "onTouchEvent onInterceptTouchEvent " + event.getAction());
            }
        }
        if (this.behavior.getIsMinimized() && this.minimizeGestureDetector.onTouchEvent(event)) {
            updateState(event);
            return true;
        }
        int iM22107getStateT0mN_rU = this.viewModel.getState();
        FloatingPane.FloatingPaneState.Companion companion = FloatingPane.FloatingPaneState.INSTANCE;
        if (FloatingPane.FloatingPaneState.m22091equalsimpl0(iM22107getStateT0mN_rU, companion.STATE_IDLE())) {
            LogTagHelperKt.debug(this, "onTouchEvent is consumed in ResultView(STATE_IDLE)");
            return true;
        }
        if (action == 2 && !this.isDragging) {
            this.isDragging = Math.abs(event.getRawX() - this.lastTouchRawX) > ((float) this.touchSlop) || Math.abs(event.getRawY() - this.lastTouchRawY) > ((float) this.touchSlop);
            LogTagHelperKt.debug(this, "onTouchEvent Drag Start");
        }
        if (this.isDragging) {
            Rect currentRect = getCurrentRect();
            if (FloatingPane.FloatingPaneState.m22091equalsimpl0(this.viewModel.getState(), companion.STATE_MOVE())) {
                onPreMove(event);
                onMove(event, currentRect);
            } else if (FloatingPane.FloatingPaneState.m22091equalsimpl0(this.viewModel.getState(), companion.STATE_RESIZE())) {
                onResize(event, currentRect);
            }
        }
        updateState(event);
        if (action == 1 || action == 3) {
            this.isDragging = false;
            this.isInMinimizeArea = false;
            startReleaseAnimation();
        }
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        this.callbackNotifier.onVisibilityChanged(visibility);
    }

    public final void removeAllCallback() {
        this.callbackNotifier.clear();
    }

    public final void removeCallback(@NotNull IFloatingPaneCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbackNotifier.remove((Object) callback);
    }

    public final boolean runNestedScrollAnimation() {
        if (!isNestedScrollSupport()) {
            return false;
        }
        CommonBehavior commonBehavior = this.behavior;
        BottomBehavior bottomBehavior = commonBehavior instanceof BottomBehavior ? (BottomBehavior) commonBehavior : null;
        if (bottomBehavior != null) {
            Rect currentRect = getCurrentRect();
            LogTagHelperKt.debug(bottomBehavior, "runNestedScrollAnimation " + currentRect);
            if (bottomBehavior.getMaxVIThreshold().contains(Integer.valueOf(currentRect.top))) {
                currentRect.top = this.parentView.getHeight() - bottomBehavior.getMaxHeight();
                currentRect.bottom = this.parentView.getHeight();
                startBoundAnimation$default(this, currentRect, 0L, false, 6, null);
                this.trackingScroll = false;
                return true;
            }
            Object lower = bottomBehavior.getMinVIThreshold().getLower();
            Intrinsics.checkNotNullExpressionValue(lower, "minVIThreshold.lower");
            if (((Number) lower).intValue() <= currentRect.top) {
                enterMinimizeView(true, currentRect);
                this.trackingScroll = false;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: setAllowedMode-J5JjPLc$material_release, reason: not valid java name */
    public final void m22103setAllowedModeJ5JjPLc$material_release(int i) {
        this.allowedMode = i;
    }

    public final void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.contentContainer.getChildCount() != 0) {
            this.contentContainer.removeAllViews();
        }
        this.contentContainer.addView(view, layoutParams);
    }

    public final void setMinimizeView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.minimizeViewContainer.getChildCount() != 0) {
            this.minimizeViewContainer.removeAllViews();
        }
        this.haveAnotherMinimizeView = true;
        this.minimizeViewContainer.addView(view, layoutParams);
        this.minimizeToolbarView = getToolbar(this.minimizeViewContainer);
    }

    public final void setResizeByContentScrollEnabled(boolean z) {
        this.resizeByContentScrollEnabled = z;
    }

    /* JADX INFO: renamed from: setResultHeight-oaV7IQU, reason: not valid java name */
    public final void m22104setResultHeightoaV7IQU(int mode, @Nullable Integer height) {
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = m22101getBehaviorJ5JjPLc(mode);
        int height2 = getHeight();
        if (height != null && height2 == height.intValue()) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomHeight(height);
        if (isShowing() && Intrinsics.areEqual(commonBehaviorM22101getBehaviorJ5JjPLc, this.behavior)) {
            startBoundAnimation$default(this, getTargetModeBounds$default(this, this.behavior, false, 2, null), 0L, false, 6, null);
        }
    }

    /* JADX INFO: renamed from: setResultViewBackgroundResource-oaV7IQU, reason: not valid java name */
    public final void m22105setResultViewBackgroundResourceoaV7IQU(int mode, @DrawableRes @Nullable Integer resId) {
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = m22101getBehaviorJ5JjPLc(mode);
        if (Intrinsics.areEqual(commonBehaviorM22101getBehaviorJ5JjPLc.getCustomBackground(), resId)) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomBackground(resId);
        if (Intrinsics.areEqual(commonBehaviorM22101getBehaviorJ5JjPLc, this.behavior)) {
            setBackgroundResource(this.behavior.getBackgroundResId());
        }
    }

    /* JADX INFO: renamed from: setResultWidth-oaV7IQU, reason: not valid java name */
    public final void m22106setResultWidthoaV7IQU(int mode, @Nullable Integer width) {
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = m22101getBehaviorJ5JjPLc(mode);
        int width2 = getWidth();
        if (width != null && width2 == width.intValue()) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomWidth(width);
        if (isShowing() && Intrinsics.areEqual(commonBehaviorM22101getBehaviorJ5JjPLc, this.behavior)) {
            startBoundAnimation$default(this, getTargetModeBounds$default(this, this.behavior, false, 2, null), 0L, false, 6, null);
        }
    }

    @Override // android.view.View
    public void setTranslationX(float translationX) {
        boolean z = getTranslationX() == translationX;
        super.setTranslationX(translationX);
        if (z || getVisibility() != 0 || getCurrentRect().isEmpty()) {
            return;
        }
        this.callbackNotifier.onLayoutChanged(MathKt.roundToInt(translationX) + getLeft(), MathKt.roundToInt(getTranslationY()) + getTop(), MathKt.roundToInt(translationX) + getRight(), MathKt.roundToInt(getTranslationY()) + getBottom());
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        boolean z = getTranslationY() == translationY;
        super.setTranslationY(translationY);
        if (z || getVisibility() != 0 || getCurrentRect().isEmpty()) {
            return;
        }
        this.callbackNotifier.onLayoutChanged(MathKt.roundToInt(getTranslationX()) + getLeft(), MathKt.roundToInt(translationY) + getTop(), MathKt.roundToInt(getTranslationX()) + getRight(), MathKt.roundToInt(translationY) + getBottom());
    }

    public final void show(boolean animate) {
        if (isShowing()) {
            return;
        }
        initViewState();
        setVisibility(0);
        this.behavior.initBehavior(this.parentView);
        updateMinimize();
        SpringAnimation springAnimation = null;
        ViewHelperKt.updateViewBounds(this, getTargetModeBounds$default(this, this.behavior, false, 2, null));
        CommonBehavior commonBehavior = this.behavior;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SpringAnimation showSpringAnimation = commonBehavior.getShowSpringAnimation(context, this);
        if (showSpringAnimation != null) {
            showSpringAnimation.addUpdateListener(new C4796g(new Ref.BooleanRef(), this, 0));
            showSpringAnimation.addEndListener(new C4794e(this, 1));
            showSpringAnimation.start();
            if (!animate) {
                showSpringAnimation.skipToEnd();
            }
            springAnimation = showSpringAnimation;
        }
        if (springAnimation == null) {
            CommonBehavior commonBehavior2 = this.behavior;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            AnimatorSet showAnimation = commonBehavior2.getShowAnimation(context2, this);
            if (showAnimation != null) {
                showAnimation.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$show$lambda$21$$inlined$doOnStart$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        this.this$0.onShowAnimationStart();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                showAnimation.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$show$lambda$21$$inlined$doOnEnd$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        this.this$0.onShowAnimationEnd();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                if (!animate) {
                    showAnimation.setDuration(0L);
                }
                showAnimation.start();
            }
        }
    }

    public final void updateDelta(int delta) {
        if (isNestedScrollSupport()) {
            CommonBehavior commonBehavior = this.behavior;
            BottomBehavior bottomBehavior = commonBehavior instanceof BottomBehavior ? (BottomBehavior) commonBehavior : null;
            if (bottomBehavior != null) {
                Rect currentRect = getCurrentRect();
                Rect rect = new Rect();
                bottomBehavior.getMode();
                resize(0, delta, currentRect, rect, 13);
                LogTagHelperKt.debug(bottomBehavior, "UpdateDelta delta=" + delta + Constant.WHITE_SPACE_FOR_LINK_ICON + currentRect);
                ViewHelperKt.updateViewBounds(this, currentRect);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneView(@NotNull Context context, @NotNull FloatingPaneLayout parentView, @Nullable AttributeSet attributeSet) {
        this(context, parentView, attributeSet, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
    }

    public /* synthetic */ FloatingPaneView(Context context, FloatingPaneLayout floatingPaneLayout, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, floatingPaneLayout, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneView(@NotNull Context context, @NotNull FloatingPaneLayout parentView, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.parentView = parentView;
        this.logTag = "FloatingPaneView";
        this.handler = new Handler(Looper.getMainLooper());
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4548R.dimen.sesl_resize_touch_area_size);
        this.resizeTouchSize = dimensionPixelSize;
        this.floatLayoutElevation = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_elevation);
        this.modeChangeBottomThreshold = ContextHelperKt.getFloat(context, C4548R.dimen.sesl_floating_pane_mode_change_bottom_threshold, 0.42f);
        this.modeChangeSideThreshold = ContextHelperKt.getFloat(context, C4548R.dimen.sesl_floating_pane_mode_change_side_threshold, 0.32f);
        this.bottomToFloatingBottomMargin = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_mode_change_bottom_to_floating_bottom_margin);
        this.resizePinPoint = 15;
        this.originBounds = new Rect();
        this.endBounds = new Rect();
        this.originRect = new Rect();
        this.prevParentRect = new Rect();
        FloatingPaneCallbackNotifier floatingPaneCallbackNotifier = new FloatingPaneCallbackNotifier(new ArrayList());
        this.callbackNotifier = floatingPaneCallbackNotifier;
        FloatingPaneViewModel floatingPaneViewModel = new FloatingPaneViewModel(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE(), floatingPaneCallbackNotifier, null);
        this.viewModel = floatingPaneViewModel;
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.behaviors = MapsKt.mutableMapOf(TuplesKt.m13893to(FloatingPane.FloatingPaneMode.m22079boximpl(companion.MODE_BOTTOM()), new BottomBehavior(context, companion.MODE_BOTTOM(), floatingPaneCallbackNotifier, floatingPaneViewModel, dimensionPixelSize, defaultConstructorMarker)), TuplesKt.m13893to(FloatingPane.FloatingPaneMode.m22079boximpl(companion.MODE_SIDE()), new SideBehavior(context, companion.MODE_SIDE(), floatingPaneCallbackNotifier, floatingPaneViewModel, dimensionPixelSize, defaultConstructorMarker)), TuplesKt.m13893to(FloatingPane.FloatingPaneMode.m22079boximpl(companion.MODE_FLOATING()), new FloatingBehavior(context, companion.MODE_FLOATING(), floatingPaneCallbackNotifier, floatingPaneViewModel, dimensionPixelSize, defaultConstructorMarker)));
        Configuration configuration = getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "resources.configuration");
        this.mode = m22097getDefaultLayoutModeWJaa9_w(configuration);
        this.allowedMode = companion.MODE_ALL();
        this.behavior = m22101getBehaviorJ5JjPLc(this.mode);
        this.touchSlop = PolicyHelperKt.getScaledTouchSlop(context);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.layoutInflater = layoutInflater;
        View viewInflate = layoutInflater.inflate(C4548R.layout.sesl_floating_pane_container, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…ing_pane_container, null)");
        this.rootView = viewInflate;
        View viewFindViewById = viewInflate.findViewById(C4548R.id.float_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "rootView.findViewById(R.id.float_content)");
        FrameLayout frameLayout = (FrameLayout) viewFindViewById;
        this.contentContainer = frameLayout;
        View viewFindViewById2 = viewInflate.findViewById(C4548R.id.float_minimize_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "rootView.findViewById(R.id.float_minimize_content)");
        this.minimizeViewContainer = (FrameLayout) viewFindViewById2;
        ImageView dragHandlerView = (ImageView) viewInflate.findViewById(C4548R.id.float_panel_drag_handler);
        this.dragHandlerView = dragHandlerView;
        this.dividerView = viewInflate.findViewById(C4548R.id.floating_pane_divider);
        final int i2 = 0;
        this.onMenuItemClickListener = new View.OnClickListener(this) { // from class: com.google.android.material.oneui.floatingdock.i

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2347b;

            {
                this.f2347b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        FloatingPaneView.onMenuItemClickListener$lambda$0(this.f2347b, view);
                        break;
                    default:
                        FloatingPaneView.dragHandlerController$lambda$7(this.f2347b, view);
                        break;
                }
            }
        };
        this.minimizeGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$minimizeGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return this.this$0.behavior.getIsMinimized();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if ((this.this$0.behavior instanceof FloatingBehavior) && this.this$0.behavior.getIsMinimized()) {
                    this.this$0.enterMinimizeView(false);
                }
                return super.onSingleTapConfirmed(e);
            }
        });
        final int i4 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, PRESS_SCALE_ANIM_FINAL_VALUE);
        final int i5 = 4;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2335b;

            {
                this.f2335b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(this.f2335b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(this.f2335b, valueAnimator);
                        break;
                    case 2:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(this.f2335b, valueAnimator);
                        break;
                    case 3:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(this.f2335b, valueAnimator);
                        break;
                    default:
                        FloatingPaneView.pressScaleAnimation$lambda$4$lambda$3(this.f2335b, valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.83f, 0.0f, 0.83f, 0.83f));
        valueAnimatorOfFloat.setDuration(ViewConfiguration.getLongPressTimeout());
        this.pressScaleAnimation = valueAnimatorOfFloat;
        ScaleSpringAnimation scaleSpringAnimation = new ScaleSpringAnimation(this);
        scaleSpringAnimation.setSpringForce(Float.valueOf(1.0f), Float.valueOf(361.0f));
        this.moveScaleAnimation = scaleSpringAnimation;
        Intrinsics.checkNotNullExpressionValue(dragHandlerView, "dragHandlerView");
        final int i6 = 1;
        this.dragHandlerController = new DragHandlerController(dragHandlerView, new ViewOnTouchListenerC4799j(this, i2), new View.OnClickListener(this) { // from class: com.google.android.material.oneui.floatingdock.i

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2347b;

            {
                this.f2347b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        FloatingPaneView.onMenuItemClickListener$lambda$0(this.f2347b, view);
                        break;
                    default:
                        FloatingPaneView.dragHandlerController$lambda$7(this.f2347b, view);
                        break;
                }
            }
        }, new Consumer() { // from class: com.google.android.material.oneui.floatingdock.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                FloatingPaneView.dragHandlerController$lambda$8(this.f2331a, (Unit) obj);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2335b;

            {
                this.f2335b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(this.f2335b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(this.f2335b, valueAnimator);
                        break;
                    case 2:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(this.f2335b, valueAnimator);
                        break;
                    case 3:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(this.f2335b, valueAnimator);
                        break;
                    default:
                        FloatingPaneView.pressScaleAnimation$lambda$4$lambda$3(this.f2335b, valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$enterMinimizeAlphaAnimation$1$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.contentContainer.setVisibility(8);
            }
        });
        valueAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat2.setDuration(100L);
        Unit unit = Unit.INSTANCE;
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2335b;

            {
                this.f2335b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i6) {
                    case 0:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(this.f2335b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(this.f2335b, valueAnimator);
                        break;
                    case 2:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(this.f2335b, valueAnimator);
                        break;
                    case 3:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(this.f2335b, valueAnimator);
                        break;
                    default:
                        FloatingPaneView.pressScaleAnimation$lambda$4$lambda$3(this.f2335b, valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$enterMinimizeAlphaAnimation$1$2$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        valueAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat3.setStartDelay(100L);
        valueAnimatorOfFloat3.setDuration(200L);
        animatorSet.playTogether(valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        this.enterMinimizeAlphaAnimation = animatorSet;
        AnimatorSet animatorSet2 = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2335b;

            {
                this.f2335b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case 0:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(this.f2335b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(this.f2335b, valueAnimator);
                        break;
                    case 2:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(this.f2335b, valueAnimator);
                        break;
                    case 3:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(this.f2335b, valueAnimator);
                        break;
                    default:
                        FloatingPaneView.pressScaleAnimation$lambda$4$lambda$3(this.f2335b, valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat4.setStartDelay(100L);
        valueAnimatorOfFloat4.setDuration(200L);
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        final int i7 = 3;
        valueAnimatorOfFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.d

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneView f2335b;

            {
                this.f2335b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i7) {
                    case 0:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$40$lambda$39(this.f2335b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneView.enterMinimizeAlphaAnimation$lambda$43$lambda$42$lambda$41(this.f2335b, valueAnimator);
                        break;
                    case 2:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$48$lambda$47(this.f2335b, valueAnimator);
                        break;
                    case 3:
                        FloatingPaneView.exitMinimizeAlphaAnimation$lambda$51$lambda$50$lambda$49(this.f2335b, valueAnimator);
                        break;
                    default:
                        FloatingPaneView.pressScaleAnimation$lambda$4$lambda$3(this.f2335b, valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat5.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$exitMinimizeAlphaAnimation$1$2$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.minimizeViewContainer.setVisibility(8);
            }
        });
        valueAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat5.setDuration(100L);
        animatorSet2.playTogether(valueAnimatorOfFloat4, valueAnimatorOfFloat5);
        this.exitMinimizeAlphaAnimation = animatorSet2;
        setClipToOutline(true);
        setVisibility(8);
        addView(viewInflate);
        this.minimizeToolbarView = getToolbar(frameLayout);
        changeFocusOrderForHandlerFirst();
        parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FloatingPaneLayout floatingPaneLayout = FloatingPaneView.this.parentView;
                LogTagHelperKt.debug(floatingPaneLayout, "init parentView(" + floatingPaneLayout.getWidth() + SQLKeyword.COMMA + floatingPaneLayout.getHeight() + ") (" + floatingPaneLayout.getLeft() + SQLKeyword.COMMA + floatingPaneLayout.getTop() + SQLKeyword.COMMA + floatingPaneLayout.getRight() + SQLKeyword.COMMA + floatingPaneLayout.getBottom() + ") ");
                Collection collectionValues = FloatingPaneView.this.behaviors.values();
                FloatingPaneView floatingPaneView = FloatingPaneView.this;
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    ((CommonBehavior) it.next()).updateBehavior(floatingPaneView.parentView);
                }
                FloatingPaneView floatingPaneView2 = FloatingPaneView.this;
                floatingPaneView2.updateView(floatingPaneView2.behavior);
                FloatingPaneView.this.parentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.hideRunnable = new Runnable() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneView$hideRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                PopupWindow popupWindow = this.this$0.popupWindow;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        };
    }

    public final void enterMinimizeView(boolean minimize) {
        if (!this.behavior.isSupportMinimize()) {
            LogTagHelperKt.debug(this, "that mode is not support Minimize");
        } else {
            enterMinimizeView(minimize, getCurrentRect());
        }
    }

    private static /* synthetic */ void getResizePinPoint$annotations() {
    }
}
