package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import androidx.collection.AbstractC0622a;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IDock;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0014\n\u0002\b\u0019\b&\u0018\u0000 è\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002è\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000fJ\u0010\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010@J\u0010\u0010D\u001a\u00020B2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u00020BH\u0014J\b\u0010F\u001a\u00020BH$J\b\u0010G\u001a\u00020BH$J\u000e\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020\u0011J\u0010\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020\u0011H\u0004J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\fH\u0004J\u0012\u0010S\u001a\u00020B2\b\u0010T\u001a\u0004\u0018\u00010UH\u0004J\u000e\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020*J\u000e\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020*J\u0010\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010a\u001a\u00020B2\u0006\u0010^\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u0011H\u0016J0\u0010c\u001a\u00020B2\u0006\u0010d\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020\f2\u0006\u0010h\u001a\u00020\fH\u0014J\u000e\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020*J\u0018\u0010k\u001a\u00020\u00112\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*H\u0004J(\u0010u\u001a\u00020B2\u0006\u0010v\u001a\u00020*2\u0006\u0010w\u001a\u00020*2\u0006\u0010x\u001a\u00020\u00112\u0006\u0010y\u001a\u00020\fH\u0004J\u0010\u0010{\u001a\u00020B2\u0006\u0010|\u001a\u000208H\u0002J\b\u0010}\u001a\u00020BH\u0016J\u0012\u0010~\u001a\u00020B2\b\u0010\u007f\u001a\u0004\u0018\u000106H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020B2\u0006\u0010\u007f\u001a\u000206H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020B2\u0007\u0010\u0082\u0001\u001a\u00020*H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020B2\u0006\u0010|\u001a\u000208H\u0016J\u001d\u0010\u0084\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u0002082\t\u0010\u0086\u0001\u001a\u0004\u0018\u000104H\u0004J$\u0010\u0087\u0001\u001a\u00020B2\u0007\u0010\u0088\u0001\u001a\u00020*2\u0007\u0010\u0089\u0001\u001a\u00020*2\u0007\u0010\u008a\u0001\u001a\u00020*H\u0004J\t\u0010\u008b\u0001\u001a\u00020BH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u008e\u0001\u001a\u00020BH\u0016J\u0011\u0010\u008f\u0001\u001a\u00020B2\u0006\u0010x\u001a\u00020\u0011H\u0002J\u0011\u0010\u0090\u0001\u001a\u00020B2\u0006\u0010N\u001a\u00020\u0011H\u0004J\u0011\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010x\u001a\u00020\u0011H\u0014J\u001a\u0010\u0098\u0001\u001a\u00020B2\u0006\u0010x\u001a\u00020\u00112\u0007\u0010\u0096\u0001\u001a\u00020\fH\u0004J\u0011\u0010¦\u0001\u001a\u00020\u00112\u0006\u0010x\u001a\u00020\u0011H\u0014J%\u0010§\u0001\u001a\u00020\u00112\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u00012\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*H\u0016J\u001b\u0010ª\u0001\u001a\u00020B2\u0007\u0010«\u0001\u001a\u00020*2\u0007\u0010¬\u0001\u001a\u00020*H\u0002J&\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\t\u0010°\u0001\u001a\u0004\u0018\u000104H\u0016J\t\u0010±\u0001\u001a\u00020BH\u0016J\u0010\u0010²\u0001\u001a\u00020B2\u0007\u0010³\u0001\u001a\u00020\u0011J&\u0010´\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\t\u0010°\u0001\u001a\u0004\u0018\u000104H\u0002J&\u0010µ\u0001\u001a\u00020B2\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\t\u0010°\u0001\u001a\u0004\u0018\u000104H\u0014J\u0013\u0010¶\u0001\u001a\u00020\u00112\b\u0010·\u0001\u001a\u00030¸\u0001H\u0002J\u001b\u0010¼\u0001\u001a\u00020\f2\u0007\u0010½\u0001\u001a\u00020*2\u0007\u0010¾\u0001\u001a\u00020*H\u0002J\u0013\u0010¿\u0001\u001a\u00020\u00112\b\u0010À\u0001\u001a\u00030©\u0001H\u0016J\u0013\u0010Á\u0001\u001a\u00020\u00112\b\u0010À\u0001\u001a\u00030©\u0001H\u0002J\t\u0010Â\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010Ã\u0001\u001a\u00020B2\u0007\u0010Ä\u0001\u001a\u00020\u001aH\u0014J\t\u0010Å\u0001\u001a\u00020BH\u0002J\u0013\u0010Æ\u0001\u001a\u00020B2\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\t\u0010Ç\u0001\u001a\u00020BH\u0002J\u0007\u0010È\u0001\u001a\u00020BJ\u0012\u0010É\u0001\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010Ë\u0001\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u00020\u001aH\u0002J\u001c\u0010Ì\u0001\u001a\u00020\u00112\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010Ä\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010Í\u0001\u001a\u00020B2\b\u0010¨\u0001\u001a\u00030©\u0001H\u0014J\u001d\u0010Î\u0001\u001a\u00020B2\b\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0014J\u0012\u0010Ì\u0001\u001a\u00020\u00112\u0007\u0010Ä\u0001\u001a\u00020\u001aH\u0014J\u0012\u0010Ñ\u0001\u001a\u00020B2\u0007\u0010Ä\u0001\u001a\u00020\u001aH\u0002J\t\u0010Ò\u0001\u001a\u00020BH\u0002J\u0019\u0010Ó\u0001\u001a\u00020B2\u0006\u0010y\u001a\u00020\f2\u0006\u0010x\u001a\u00020\u0011H\u0014J\u0012\u0010Ô\u0001\u001a\u00020B2\u0007\u0010¡\u0001\u001a\u00020*H\u0004J\u001b\u0010Õ\u0001\u001a\u00020B2\u0007\u0010Ö\u0001\u001a\u00020*2\u0007\u0010×\u0001\u001a\u00020*H\u0014J\t\u0010Ø\u0001\u001a\u00020BH\u0004J\u0011\u0010Ù\u0001\u001a\u00020\u00112\u0006\u0010y\u001a\u00020\fH\u0014J\u0010\u0010Ú\u0001\u001a\u00020B2\u0007\u0010Û\u0001\u001a\u00020\u0011J\t\u0010Ü\u0001\u001a\u00020BH\u0002J\t\u0010Ý\u0001\u001a\u00020BH\u0016J\t\u0010Þ\u0001\u001a\u00020BH\u0016J\t\u0010à\u0001\u001a\u00020BH\u0014J\u0011\u0010á\u0001\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u001aH\u0016J\t\u0010æ\u0001\u001a\u00020BH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001a8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020*8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010KR\u0014\u0010Q\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010KR\u0014\u0010n\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0011\u0010q\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\br\u0010pR\u0011\u0010s\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bt\u0010pR\u0014\u0010z\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010KR\u0016\u0010\u0091\u0001\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010pR\u0013\u0010\u0094\u0001\u001a\u00020\f8F¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010pR\u0016\u0010\u0096\u0001\u001a\u00020\f8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010pR\u0016\u0010\u0099\u0001\u001a\u00020*8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010.R\u0016\u0010\u009b\u0001\u001a\u00020*8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010.R\u0016\u0010\u009d\u0001\u001a\u00020*8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010.R\u0016\u0010\u009f\u0001\u001a\u00020*8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010.R\u0016\u0010¡\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010pR\u0016\u0010£\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010pR\u0015\u0010W\u001a\u00020*8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010.R\u0015\u0010¹\u0001\u001a\u00030¸\u00018F¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u0013\u0010ß\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bß\u0001\u0010KR)\u0010ã\u0001\u001a\u00020\u00112\u0007\u0010â\u0001\u001a\u00020\u00118V@TX\u0096\u000e¢\u0006\u000f\u001a\u0005\bã\u0001\u0010K\"\u0006\bä\u0001\u0010å\u0001R\u0016\u0010ç\u0001\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bç\u0001\u0010K¨\u0006é\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloatLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater;", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IViewContract;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mEnableFly", "", "mDelegate", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;", "mOperatingActionCount", "mEnableDocking", "mIsFreeze", "mParentWidth", "mParentHeight", "mInit", "Landroid/graphics/PointF;", "mStart", "mCurrentTouch", "getMCurrentTouch", "()Landroid/graphics/PointF;", "setMCurrentTouch", "(Landroid/graphics/PointF;)V", "mHasScrollable", "mHasViewFlipper", "mHasSeekBar", "mIsInterceptedTouch", "mIsMoving", "mTouchSlope", "mLongTouchSlope", "mIsFlying", "mEndEdgeSize", "", "mStartMargin", "bottomMargin", "getBottomMargin", "()F", "setBottomMargin", "(F)V", "mStartPress", "mIsReleased", "mDropAction", "Ljava/lang/Runnable;", "mOriginRect", "Landroid/graphics/Rect;", "mOriginPoint", "Landroid/graphics/Point;", "mLongPressHandler", "Landroid/os/Handler;", "mLongPressRunnable", "mHideAnimator", "Landroid/animation/ValueAnimator;", "mShowAnimator", "mContract", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IContract;", "setContract", "", "contract", "initialize", "onAttachedToWindow", "onActionStart", "onActionEnd", "setFreezeState", "isFreeze", "isFreezeState", "()Z", "isVisible", "enableDocking", "enable", "setDockSide", "dockSide", "enabledDocking", "getEnabledDocking", "setDockParams", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock$AlignmentParam;", "setEndEdgeSize", "endEdgeSize", "setStartMargin", "startMargin", "addModeChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$ModeChangeListener;", "addDock", "id", "dock", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock;", "blockadeDock", "blockade", "onLayout", "changed", "l", "t", "r", "b", "setDefaultCornerRadius", "radius", "canStartToMove", "distanceX", "distanceY", "state", "getState", "()I", "dockingType", "getDockingType", "dockingGravity", "getDockingGravity", "reboundOnDropZone", "x", "y", "withAnimation", "type", "isAcceptableOverlap", "getOriginPoint", "point", "captureOriginPosition", "getOriginRect", "rect", "getHitRect", "setAlpha", "alpha", "animateToFinalPosition", "runTranslationAnimation", "dstPoint", "endAction", "runScaleAnimation", "targetScale", "stiffness", "dampingRatio", "cancelTranslationAnimation", "startMoveWithAnimation", "isStart", "dropAction", "drop", "enableMargin", "dockingBoundary", "getDockingBoundary", "dropY", "dockingSize", "getDockingSize", "dockingSide", "getDockingSide", "dropHorizontalDocking", "topDockingPosition", "getTopDockingPosition", "bottomDockingPosition", "getBottomDockingPosition", "topDockingArea", "getTopDockingArea", "bottomDockingArea", "getBottomDockingArea", "parentWidth", "getParentWidth", "parentHeight", "getParentHeight", "getEndEdgeSize", "dropX", "onScroll", "event", "Landroid/view/MotionEvent;", SecureFolderConstants.TEMP_FOLDER_NAME, "rawX", "rawY", "onFling", "velocityX", "velocityY", "withEndAction", "onFieldSizeChanged", "setEnableFly", "isEnable", "fly", "actionFly", "getDestination", "dstRect", "Landroid/graphics/RectF;", OutlinedTextFieldKt.BorderId, "getBorder", "()Landroid/graphics/RectF;", "getHorizonSnappingDelta", "dstX", "originX", "dispatchTouchEvent", "ev", "onTouch", "isPressed", "onTouchDown", "currentTouch", "initInterceptEvent", "detectLongPressGesture", "cancelLongPressGesture", "interceptTouchOnce", "isTouchedOutsideForUnDocking", "touch", "isTouchedOnChildView", "onTouchMove", "dispatchLongPress", "getUndockDestination", "dest", "", "moveIntoTouchPoint", "onTouchUp", "onDocking", "onUndocking", "updateXY", "toX", "toY", "updateDockerSizeWithMargin", "openDocker", "setDocker", "isOpen", "makeAnimation", "startHideAnimation", "startShowAnimation", "isHideRunning", "updateState", "contains", "moving", "isMoving", "setMoving", "(Z)V", "release", "isStateDocking", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatLayout.kt\ncom/samsung/android/support/senl/nt/base/winset/view/floater/FloatLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,963:1\n1#2:964\n*E\n"})
public abstract class FloatLayout extends ConstraintLayout implements IFloater, IFloater.IViewContract {
    protected static final float DIST_FACTOR = 0.05f;
    public static final int FADE_ANIMATION_DURATION = 200;
    private static final float FLY_VELOCITY_MIN_LIMIT = 2000.0f;
    private static final float SHADOW_ALPHA = 0.5f;

    @NotNull
    private static final String TAG = "FloatLayout";
    private static final long TIME_FOR_LONG_PRESS = 400;
    private static final long TIME_FOR_LONG_PRESS_BY_SINGLE_DOWN = 500;
    private static final int VELOCITY_UNIT = 1000;
    private float bottomMargin;

    @Nullable
    private IFloater.IContract mContract;

    @NotNull
    private PointF mCurrentTouch;

    @JvmField
    @Nullable
    protected FloaterDelegate mDelegate;

    @Nullable
    private Runnable mDropAction;

    @JvmField
    protected boolean mEnableDocking;
    private boolean mEnableFly;
    private float mEndEdgeSize;

    @JvmField
    protected boolean mHasScrollable;

    @JvmField
    protected boolean mHasSeekBar;

    @JvmField
    protected boolean mHasViewFlipper;

    @Nullable
    private ValueAnimator mHideAnimator;

    @JvmField
    @NotNull
    protected PointF mInit;
    private boolean mIsFlying;
    private boolean mIsFreeze;
    private boolean mIsInterceptedTouch;
    private boolean mIsMoving;

    @JvmField
    protected boolean mIsReleased;

    @Nullable
    private Handler mLongPressHandler;

    @Nullable
    private Runnable mLongPressRunnable;
    private int mLongTouchSlope;
    private int mOperatingActionCount;

    @NotNull
    private final Point mOriginPoint;

    @NotNull
    private final Rect mOriginRect;

    @JvmField
    protected int mParentHeight;

    @JvmField
    protected int mParentWidth;

    @Nullable
    private ValueAnimator mShowAnimator;

    @JvmField
    @NotNull
    protected PointF mStart;

    @JvmField
    protected float mStartMargin;
    private boolean mStartPress;
    private int mTouchSlope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnableFly = true;
        this.mInit = new PointF();
        this.mStart = new PointF();
        this.mCurrentTouch = new PointF();
        this.mOriginRect = new Rect();
        this.mOriginPoint = new Point();
        initialize(context);
    }

    private final void cancelLongPressGesture() {
        Handler handler;
        Runnable runnable = this.mLongPressRunnable;
        if (runnable == null || (handler = this.mLongPressHandler) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    private final void detectLongPressGesture(MotionEvent event) {
        if (event.getToolType(0) == 2) {
            return;
        }
        RunnableC8979b runnableC8979b = new RunnableC8979b(this, event, 1);
        this.mLongPressRunnable = runnableC8979b;
        Handler handler = this.mLongPressHandler;
        if (handler != null) {
            Intrinsics.checkNotNull(runnableC8979b);
            handler.postDelayed(runnableC8979b, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectLongPressGesture$lambda$2(FloatLayout floatLayout, MotionEvent motionEvent) {
        floatLayout.dispatchLongPress(motionEvent);
        floatLayout.moveIntoTouchPoint(new PointF(motionEvent.getRawX(), motionEvent.getRawY()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drop(boolean withAnimation) {
        if (this.mIsFreeze || dropY(withAnimation)) {
            return;
        }
        dropX(withAnimation);
    }

    private final boolean fly(float velocityX, float velocityY, Runnable withEndAction) {
        if (!this.mEnableFly) {
            return false;
        }
        float fAbs = (float) Math.abs(velocityX);
        float fAbs2 = (float) Math.abs(velocityY);
        Logger.m8697d(TAG, "fly : " + velocityX + "/" + velocityY);
        if (fAbs <= FLY_VELOCITY_MIN_LIMIT && fAbs2 <= FLY_VELOCITY_MIN_LIMIT) {
            return false;
        }
        actionFly(velocityX, velocityY, withEndAction);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean getDestination(RectF dstRect) {
        float f;
        float f4;
        RectF border = getBorder();
        boolean z = false;
        if (border.contains(dstRect)) {
            return false;
        }
        float bottomDockingPosition = dstRect.top;
        float f5 = border.top;
        if (bottomDockingPosition >= f5) {
            float f6 = dstRect.bottom;
            float f7 = border.bottom;
            if (f6 > f7) {
                bottomDockingPosition = this.mEnableDocking ? getBottomDockingPosition() : f7 - dstRect.height();
            }
            if (!z && this.mEnableDocking) {
                Float fValueOf = this.mDelegate != null ? Float.valueOf(r0.getDockingPosStartX()) : null;
                if (LocaleUtils.isRTLMode()) {
                    float width = this.mParentWidth - getWidth();
                    Intrinsics.checkNotNull(fValueOf);
                    fValueOf = Float.valueOf(width - fValueOf.floatValue());
                }
                if (fValueOf != null) {
                    dstRect.offsetTo(fValueOf.floatValue(), bottomDockingPosition);
                }
                return true;
            }
            dstRect.offsetTo(dstRect.left, bottomDockingPosition);
            f = dstRect.left;
            f4 = border.left;
            if (f >= f4) {
                dstRect.offsetTo(f4, bottomDockingPosition);
            } else {
                float f8 = dstRect.right;
                float f9 = border.right;
                if (f8 > f9) {
                    dstRect.offsetTo(f9 - dstRect.width(), bottomDockingPosition);
                }
            }
            return true;
        }
        bottomDockingPosition = this.mEnableDocking ? getTopDockingPosition() : f5;
        z = true;
        if (!z) {
        }
        dstRect.offsetTo(dstRect.left, bottomDockingPosition);
        f = dstRect.left;
        f4 = border.left;
        if (f >= f4) {
        }
        return true;
    }

    private final int getHorizonSnappingDelta(float dstX, float originX) {
        int i = this.mParentWidth;
        if (LocaleUtils.isRTLMode()) {
            i = 0;
        }
        IFloater.IContract iContract = this.mContract;
        if (iContract == null) {
            return 0;
        }
        Integer numValueOf = iContract != null ? Integer.valueOf(iContract.getSnappingDelta(i, (int) (dstX - originX))) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    private final void getOriginPoint(Point point) {
        Point point2 = this.mOriginPoint;
        point.set(point2.x, point2.y);
    }

    private final void initInterceptEvent() {
        FloaterDelegate floaterDelegate;
        FloaterDelegate floaterDelegate2;
        FloaterDelegate floaterDelegate3;
        if (this.mHasScrollable && (floaterDelegate3 = this.mDelegate) != null) {
            PointF pointF = this.mInit;
            float f = pointF.x;
            PointF pointF2 = this.mCurrentTouch;
            floaterDelegate3.initInterceptScroll(new PointF(f + pointF2.x, pointF.y + pointF2.y));
        }
        if (this.mHasViewFlipper && (floaterDelegate2 = this.mDelegate) != null) {
            PointF pointF3 = this.mInit;
            float f4 = pointF3.x;
            PointF pointF4 = this.mCurrentTouch;
            floaterDelegate2.initInterceptFlipper(new PointF(f4 + pointF4.x, pointF3.y + pointF4.y));
        }
        if (this.mHasSeekBar && (floaterDelegate = this.mDelegate) != null) {
            PointF pointF5 = this.mInit;
            float f5 = pointF5.x;
            PointF pointF6 = this.mCurrentTouch;
            floaterDelegate.initInterceptSeekBar(new PointF(f5 + pointF6.x, pointF5.y + pointF6.y));
        }
        this.mIsInterceptedTouch = false;
    }

    private final void initialize(Context context) {
        this.mLongPressHandler = new Handler(Looper.getMainLooper());
        this.mParentWidth = 0;
        this.mParentHeight = 0;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTouchSlope = scaledTouchSlop;
        this.mLongTouchSlope = scaledTouchSlop * 2;
        this.mDelegate = new FloaterDelegate(this, new ActionProcessListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.FloatLayout.initialize.1
            @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.ActionProcessListener
            public void onActionEnd(boolean needUpdate) {
                FloatLayout.this.mOperatingActionCount--;
                if (FloatLayout.this.mOperatingActionCount == 0) {
                    FloatLayout.this.onActionEnd();
                }
                if (!needUpdate || FloatLayout.this.isStateDocking()) {
                    return;
                }
                FloatLayout.this.drop(false);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.ActionProcessListener
            public void onActionStart() {
                if (FloatLayout.this.mOperatingActionCount == 0) {
                    FloatLayout.this.onActionStart();
                }
                FloatLayout.this.mOperatingActionCount++;
            }
        }, this);
        this.mOperatingActionCount = 0;
        this.mDropAction = new RunnableC8669a(this, 22);
        setClipChildren(false);
        ViewCompat.INSTANCE.getInstance().setShadowAlpha(this, 0.5f);
        makeAnimation();
    }

    private final boolean isTouchedOnChildView(PointF touch) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (FloaterUtil.INSTANCE.contains(getChildAt(i), touch)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTouchedOutsideForUnDocking(PointF touch) {
        return this.mEnableDocking && isStateDocking() && !isTouchedOnChildView(touch);
    }

    private final void makeAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mHideAnimator = valueAnimatorOfFloat;
        if (valueAnimatorOfFloat != null) {
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(200L);
        }
        ValueAnimator valueAnimator2 = this.mHideAnimator;
        if (valueAnimator2 != null) {
            final int i = 0;
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ FloatLayout f6507b;

                {
                    this.f6507b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    switch (i) {
                        case 0:
                            FloatLayout.makeAnimation$lambda$6(this.f6507b, valueAnimator3);
                            break;
                        default:
                            FloatLayout.makeAnimation$lambda$7(this.f6507b, valueAnimator3);
                            break;
                    }
                }
            });
        }
        ValueAnimator valueAnimator3 = this.mHideAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.FloatLayout.makeAnimation.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    FloatLayout.this.setAlpha(1.0f);
                    FloatLayout.this.setVisibility(8);
                    Logger.m8702i(FloatLayout.TAG, "hide Animation end");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationStart(animation);
                    FloatLayout.this.setVisibility(0);
                    Logger.m8702i(FloatLayout.TAG, "hide Animation start");
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowAnimator = valueAnimatorOfFloat2;
        if (valueAnimatorOfFloat2 != null) {
            valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator4 = this.mShowAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(200L);
        }
        ValueAnimator valueAnimator5 = this.mShowAnimator;
        if (valueAnimator5 != null) {
            final int i2 = 1;
            valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ FloatLayout f6507b;

                {
                    this.f6507b = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator32) {
                    switch (i2) {
                        case 0:
                            FloatLayout.makeAnimation$lambda$6(this.f6507b, valueAnimator32);
                            break;
                        default:
                            FloatLayout.makeAnimation$lambda$7(this.f6507b, valueAnimator32);
                            break;
                    }
                }
            });
        }
        ValueAnimator valueAnimator6 = this.mShowAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.FloatLayout.makeAnimation.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation, boolean isReverse) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    FloatLayout.this.setAlpha(1.0f);
                    FloatLayout.this.setVisibility(0);
                    Logger.m8702i(FloatLayout.TAG, "show Animation end");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationStart(animation);
                    FloatLayout.this.setVisibility(0);
                    Logger.m8702i(FloatLayout.TAG, "show Animation start");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeAnimation$lambda$6(FloatLayout floatLayout, ValueAnimator valueAnimator) {
        floatLayout.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeAnimation$lambda$7(FloatLayout floatLayout, ValueAnimator valueAnimator) {
        floatLayout.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    private final void move(float rawX, float rawY) {
        if (this.mIsMoving) {
            return;
        }
        this.mStart.set(rawX, rawY);
        setMoving(true);
        PointF pointF = this.mStart;
        Logger.m8697d(TAG, "move : " + pointF.x + SQLKeyword.COMMA + pointF.y);
    }

    private final void moveIntoTouchPoint(PointF currentTouch) {
        PointF pointF = this.mInit;
        float f = pointF.x;
        float f4 = currentTouch.x;
        PointF pointF2 = this.mStart;
        updateXY((f4 - pointF2.x) + f, (currentTouch.y - pointF2.y) + pointF.y);
    }

    private final boolean onTouch(MotionEvent ev) {
        PointF pointF = new PointF(ev.getRawX(), ev.getRawY());
        this.mCurrentTouch.set(ev.getX(), ev.getY());
        int action = ev.getAction();
        cancelLongPressGesture();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        switch (action) {
                            case 211:
                                break;
                            case 212:
                            case 214:
                                break;
                            case 213:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                return onTouchMove(ev, pointF);
            }
            onTouchUp();
            return false;
        }
        onTouchDown(pointF);
        boolean zIsTouchedOutsideForUnDocking = isTouchedOutsideForUnDocking(this.mCurrentTouch);
        if (zIsTouchedOutsideForUnDocking) {
            detectLongPressGesture(ev);
        }
        return zIsTouchedOutsideForUnDocking;
    }

    private final boolean onTouchMove(MotionEvent event, PointF currentTouch) {
        float f = currentTouch.x;
        PointF pointF = this.mStart;
        float f4 = f - pointF.x;
        float f5 = currentTouch.y - pointF.y;
        if ((!this.mEnableDocking || !isStateDocking()) && !this.mIsFreeze) {
            return onTouchMove(currentTouch);
        }
        if (this.mStartPress && Math.abs(f4) < this.mLongTouchSlope && Math.abs(f5) < this.mLongTouchSlope) {
            if (event.getEventTime() - event.getDownTime() < 400) {
                return false;
            }
            dispatchLongPress(event);
            return true;
        }
        if (this.mStartPress) {
            Logger.m8697d(TAG, "touch : move - out bound - " + f4 + SQLKeyword.COMMA + f5);
            this.mStartPress = false;
        }
        return false;
    }

    private final void onTouchUp() {
        Logger.m8697d(TAG, "touch : up");
        this.mStartPress = false;
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.deInitInterceptTouchEvent();
        }
        if (this.mIsMoving) {
            setMoving(false);
            if (this.mIsFlying) {
                this.mIsFlying = false;
            } else if (!this.mIsFreeze && this.mEnableDocking) {
                actionFly(0.0f, 0.0f, null);
            }
        }
    }

    private final void startMoveWithAnimation(boolean isStart) {
        if (isStart) {
            FloaterDelegate floaterDelegate = this.mDelegate;
            if (floaterDelegate != null) {
                floaterDelegate.startDrag(this);
                return;
            }
            return;
        }
        FloaterDelegate floaterDelegate2 = this.mDelegate;
        if (floaterDelegate2 != null) {
            floaterDelegate2.endDrag(this);
        }
    }

    public void actionFly(float velocityX, float velocityY, @Nullable Runnable withEndAction) {
        if (isStateDocking()) {
            if (withEndAction != null) {
                withEndAction.run();
                return;
            }
            return;
        }
        float x = getX();
        float y2 = getY();
        PointF pointF = new PointF((velocityX * 0.05f) + x, (0.05f * velocityY) + y2);
        float f = pointF.x;
        RectF rectF = new RectF(f, pointF.y, getWidth() + f, pointF.y + getHeight());
        float f4 = this.mEndEdgeSize;
        if (f4 != 0.0f) {
            rectF.right = rectF.left + f4;
        }
        boolean destination = getDestination(rectF);
        int horizonSnappingDelta = getHorizonSnappingDelta(pointF.x, x);
        StringBuilder sbM1176v = AbstractC0622a.m1176v("fly to drop zone : ", pointF.x, SQLKeyword.COMMA, pointF.y, " : ");
        sbM1176v.append(x);
        sbM1176v.append(SQLKeyword.COMMA);
        sbM1176v.append(y2);
        Logger.m8697d(TAG, sbM1176v.toString());
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.fly(this, rectF.left - horizonSnappingDelta, rectF.top, velocityX, velocityY, destination, withEndAction);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void addDock(int id, @NotNull IDock dock) {
        Intrinsics.checkNotNullParameter(dock, "dock");
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.addDock(id, dock);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void addModeChangeListener(@NotNull IFloater.ModeChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.addModeChangeListener(listener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void animateToFinalPosition(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        Point point2 = new Point();
        getOriginPoint(point2);
        point2.offset(point.x, point.y);
        if (!this.mEnableDocking || isStateDocking()) {
            runTranslationAnimation(point2, null);
        } else {
            runTranslationAnimation(point2, this.mDropAction);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void blockadeDock(int id, boolean blockade) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.blockadeDock(id, blockade);
        }
    }

    public final boolean canStartToMove(float distanceX, float distanceY) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        Boolean boolValueOf = floaterDelegate != null ? Boolean.valueOf(floaterDelegate.canStartToMove(this.mCurrentTouch, distanceX, distanceY)) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void cancelTranslationAnimation() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.cancelTranslationAnimation();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void captureOriginPosition() {
        getHitRect(this.mOriginRect);
        this.mOriginPoint.set((int) getTranslationX(), (int) getTranslationY());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean contains(@NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        return FloaterUtil.INSTANCE.contains(this, point);
    }

    public void dispatchLongPress(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mIsMoving || !this.mEnableDocking || !isStateDocking()) {
            Logger.m8697d(TAG, "dispatchLongPress : ignored not docking");
            return;
        }
        Logger.m8697d(TAG, "dispatchLongPress");
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.onUnDocking();
        }
        setMoving(true);
        float[] fArr = new float[2];
        getUndockDestination(fArr, event);
        updateXY(fArr[0], fArr[1]);
        Logger.m8702i(TAG, "start position delta " + fArr[0] + SQLKeyword.COMMA + fArr[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!onTouch(ev)) {
            return super.dispatchTouchEvent(ev);
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(ev);
        motionEventObtain.setAction(3);
        super.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void dropAction() {
        Runnable runnable = this.mDropAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void dropHorizontalDocking(boolean withAnimation, int dockingSide) {
        float bottomDockingPosition;
        Logger.m8702i(TAG, "dropHorizontalDocking# withAnimation " + withAnimation + " " + dockingSide);
        int width = (this.mParentWidth - getWidth()) >> 1;
        if (dockingSide == 0) {
            bottomDockingPosition = getTopDockingPosition();
            Logger.m8702i(TAG, "dropHorizontalDocking# getTopDockingPosition() " + bottomDockingPosition);
        } else {
            bottomDockingPosition = getBottomDockingPosition();
            Logger.m8702i(TAG, "dropHorizontalDocking# getBottomDockingPosition() " + bottomDockingPosition);
        }
        if (this.mEnableDocking) {
            width = 0;
        }
        reboundOnDropZone(width, bottomDockingPosition, withAnimation, 2);
        onDocking(dockingSide, withAnimation);
    }

    public boolean dropX(boolean withAnimation) {
        int iIntValue;
        Integer numValueOf;
        float x = getX();
        float y2 = getY();
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.closeAllDocker();
        }
        int i = this.mParentWidth;
        float width = this.mStartMargin;
        float width2 = i - this.mEndEdgeSize;
        int iIntValue2 = 0;
        if (LocaleUtils.isRTLMode()) {
            width = this.mEndEdgeSize - getWidth();
            width2 = (this.mParentWidth - getWidth()) - this.mStartMargin;
            i = 0;
        }
        if (x < width) {
            reboundOnDropZone(width, y2, withAnimation, 1);
            return true;
        }
        if (x > width2) {
            IFloater.IContract iContract = this.mContract;
            if (iContract != null) {
                numValueOf = iContract != null ? Integer.valueOf(iContract.getSnappingDelta(i, (int) (width2 - x))) : null;
                Intrinsics.checkNotNull(numValueOf);
                iIntValue2 = numValueOf.intValue();
            }
            reboundOnDropZone(width2 - iIntValue2, y2, withAnimation, 1);
            return true;
        }
        if (getWidth() + x > i) {
            IFloater.IContract iContract2 = this.mContract;
            if (iContract2 != null) {
                numValueOf = iContract2 != null ? Integer.valueOf(iContract2.getSnappingDelta(i, 0)) : null;
                Intrinsics.checkNotNull(numValueOf);
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = 0;
            }
            if (iIntValue != 0) {
                reboundOnDropZone(x - iIntValue, y2, true, 1);
                return true;
            }
        }
        return false;
    }

    public boolean dropY(boolean withAnimation) {
        int dockingSide;
        FloaterDelegate floaterDelegate;
        Logger.m8702i(TAG, "dropY withAnimation " + withAnimation);
        if (!this.mEnableDocking || (dockingSide = getDockingSide()) == -1 || ((floaterDelegate = this.mDelegate) != null && floaterDelegate.isBlockaded(dockingSide))) {
            return false;
        }
        dropHorizontalDocking(withAnimation, dockingSide);
        return true;
    }

    public final void enableDocking(boolean enable) {
        this.mEnableDocking = enable;
    }

    public final void enableMargin(boolean enable) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.enableMargin(enable);
        }
    }

    @NotNull
    public final RectF getBorder() {
        float bottomDockingPosition;
        float topDockingArea;
        if (this.mEnableDocking) {
            topDockingArea = (int) getTopDockingArea();
            bottomDockingPosition = (int) getBottomDockingPosition();
        } else {
            bottomDockingPosition = this.mParentHeight;
            topDockingArea = 0.0f;
        }
        return new RectF(this.mStartMargin, topDockingArea, this.mParentWidth, bottomDockingPosition);
    }

    public float getBottomDockingArea() {
        int i = this.mParentHeight;
        FloaterDelegate floaterDelegate = this.mDelegate;
        Intrinsics.checkNotNull(floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingSize() * 2) : null);
        return (i - r1.intValue()) - this.bottomMargin;
    }

    public final float getBottomDockingPosition() {
        int i = this.mParentHeight;
        FloaterDelegate floaterDelegate = this.mDelegate;
        Intrinsics.checkNotNull(floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingSize()) : null);
        return (i - r1.intValue()) - this.bottomMargin;
    }

    public final float getBottomMargin() {
        return this.bottomMargin;
    }

    public int getDockingBoundary() {
        return -1;
    }

    public final int getDockingGravity() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return 48;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return 80;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return 8388611;
        }
        return (numValueOf != null && numValueOf.intValue() == 3) ? 8388613 : 0;
    }

    public final int getDockingSide() {
        int iIntValue;
        int dockingBoundary;
        if (isStateDocking()) {
            FloaterDelegate floaterDelegate = this.mDelegate;
            Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingType()) : null;
            Intrinsics.checkNotNull(numValueOf);
            iIntValue = numValueOf.intValue();
        } else {
            iIntValue = -1;
        }
        if (iIntValue == -1) {
            dockingBoundary = getDockingBoundary();
            if (dockingBoundary == -1) {
                return -1;
            }
        } else {
            dockingBoundary = iIntValue;
        }
        Logger.m8702i(TAG, "getDockingSide# prev docking side : prevDocking " + iIntValue + " docking " + dockingBoundary);
        return dockingBoundary;
    }

    public final int getDockingSize() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingSize()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final int getDockingType() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate == null) {
            return -1;
        }
        Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingType()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    /* JADX INFO: renamed from: getEnabledDocking, reason: from getter */
    public boolean getMEnableDocking() {
        return this.mEnableDocking;
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.IViewContract
    /* JADX INFO: renamed from: getEndEdgeSize, reason: from getter */
    public float getMEndEdgeSize() {
        return this.mEndEdgeSize;
    }

    @Override // android.view.View, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void getHitRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        super.getHitRect(rect);
    }

    @NotNull
    public final PointF getMCurrentTouch() {
        return this.mCurrentTouch;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void getOriginRect(@Nullable Rect rect) {
        if (rect != null) {
            rect.set(this.mOriginRect);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.IViewContract
    /* JADX INFO: renamed from: getParentHeight, reason: from getter */
    public int getMParentHeight() {
        return this.mParentHeight;
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.IViewContract
    /* JADX INFO: renamed from: getParentWidth, reason: from getter */
    public int getMParentWidth() {
        return this.mParentWidth;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public int getState() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate == null) {
            return 0;
        }
        Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getMState()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public float getTopDockingArea() {
        Float fValueOf = this.mDelegate != null ? Float.valueOf(r0.getDockingSize()) : null;
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    public final float getTopDockingPosition() {
        return 0.0f;
    }

    public void getUndockDestination(@NotNull float[] dest, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(event, "event");
        float rawX = (event.getRawX() - this.mStart.x) + this.mInit.x;
        float rawY = (event.getRawY() - this.mStart.y) + this.mInit.y;
        dest[0] = rawX;
        dest[1] = rawY;
    }

    public final void interceptTouchOnce() {
        this.mIsInterceptedTouch = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean isAcceptableOverlap() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    /* JADX INFO: renamed from: isFreezeState, reason: from getter */
    public boolean getMIsFreeze() {
        return this.mIsFreeze;
    }

    public final boolean isHideRunning() {
        ValueAnimator valueAnimator = this.mHideAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* JADX INFO: renamed from: isMoving, reason: from getter */
    public boolean getMIsMoving() {
        return this.mIsMoving;
    }

    @Override // android.view.View, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean isPressed() {
        return this.mStartPress;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean isStateDocking() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        return floaterDelegate != null && floaterDelegate.getMState() == 2;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public abstract void onActionEnd();

    public abstract void onActionStart();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.initLayout();
        }
    }

    public void onDocking(int type, boolean withAnimation) {
        if (!this.mEnableDocking || isStateDocking()) {
            return;
        }
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.onDocking(type, true, withAnimation);
        }
        invalidate();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onFieldSizeChanged() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        this.mParentWidth = viewGroup.getWidth();
        this.mParentHeight = viewGroup.getHeight();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean onFling(float velocityX, float velocityY, @Nullable Runnable withEndAction) {
        boolean z = this.mIsMoving;
        if (!z) {
            Logger.m8703w(TAG, "onFling : is moving? " + z);
            return false;
        }
        Logger.m8697d(TAG, "onFling : " + velocityX + " / " + velocityY);
        boolean zFly = fly(velocityX, velocityY, withEndAction);
        this.mIsFlying = zFly;
        return zFly;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            onFieldSizeChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean onScroll(@Nullable MotionEvent event, float distanceX, float distanceY) {
        FloaterDelegate floaterDelegate;
        if (this.mIsMoving || isStateDocking() || (floaterDelegate = this.mDelegate) == null || !floaterDelegate.canStartToMove(this.mCurrentTouch, distanceX, distanceY) || event == null) {
            return false;
        }
        move(event.getRawX(), event.getRawY());
        return false;
    }

    public void onTouchDown(@NotNull PointF currentTouch) {
        Intrinsics.checkNotNullParameter(currentTouch, "currentTouch");
        this.mInit.set(getTranslationX(), getTranslationY());
        this.mStart.set(currentTouch);
        this.mStartPress = true;
        initInterceptEvent();
    }

    public final void onUndocking(float parentWidth) {
        if (isStateDocking()) {
            FloaterDelegate floaterDelegate = this.mDelegate;
            if (floaterDelegate != null) {
                floaterDelegate.onUnDocking();
            }
            setTranslationX((parentWidth - getWidth()) / 2.0f);
        }
    }

    public boolean openDocker(int type) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        Boolean boolValueOf = null;
        if (floaterDelegate != null) {
            Integer numValueOf = floaterDelegate != null ? Integer.valueOf(floaterDelegate.getDockingSize()) : null;
            Intrinsics.checkNotNull(numValueOf);
            boolValueOf = Boolean.valueOf(floaterDelegate.openDocker(type, numValueOf.intValue()));
        }
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    public final void reboundOnDropZone(float x, float y2, boolean withAnimation, int type) {
        StringBuilder sbM1176v = AbstractC0622a.m1176v("rebound drop zone : ", x, SQLKeyword.COMMA, y2, SQLKeyword.COMMA);
        sbM1176v.append(withAnimation);
        Logger.m8697d(TAG, sbM1176v.toString());
        if (!withAnimation) {
            setTranslationX(x);
            setTranslationY(y2);
        } else {
            FloaterDelegate floaterDelegate = this.mDelegate;
            if (floaterDelegate != null) {
                floaterDelegate.reboundOnDropZone(this, x, y2, type);
            }
        }
    }

    public void release() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.stopActions();
        }
        FloaterDelegate floaterDelegate2 = this.mDelegate;
        if (floaterDelegate2 != null) {
            floaterDelegate2.release();
        }
        this.mIsReleased = true;
    }

    public final void runScaleAnimation(float targetScale, float stiffness, float dampingRatio) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.runScaleAnimation(this, targetScale, stiffness, dampingRatio);
        }
    }

    public final void runTranslationAnimation(@NotNull Point dstPoint, @Nullable Runnable endAction) {
        Intrinsics.checkNotNullParameter(dstPoint, "dstPoint");
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.runTranslationAnimation(dstPoint, endAction);
        }
    }

    @Override // android.view.View, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void setAlpha(float alpha) {
        super.setAlpha(alpha);
    }

    public final void setBottomMargin(float f) {
        this.bottomMargin = f;
    }

    public final void setContract(@Nullable IFloater.IContract contract) {
        this.mContract = contract;
    }

    public final void setDefaultCornerRadius(float radius) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.setDefaultCornerRadius(radius);
        }
    }

    public final void setDockParams(@Nullable IDock.AlignmentParam params) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.setDockParams(params);
        }
    }

    public final void setDockSide(int dockSide) {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            floaterDelegate.setDockSide(dockSide);
        }
    }

    public final void setDocker(boolean isOpen) {
        FloaterDelegate floaterDelegate;
        if (!isOpen) {
            FloaterDelegate floaterDelegate2 = this.mDelegate;
            if (floaterDelegate2 != null) {
                floaterDelegate2.closeAllDocker();
                return;
            }
            return;
        }
        if (!isStateDocking() || (floaterDelegate = this.mDelegate) == null) {
            return;
        }
        int dockingSize = floaterDelegate.getDockingSize();
        FloaterDelegate floaterDelegate3 = this.mDelegate;
        if (floaterDelegate3 != null) {
            floaterDelegate3.openDocker(dockingSize);
        }
    }

    public final void setEnableFly(boolean isEnable) {
        this.mEnableFly = isEnable;
    }

    public final void setEndEdgeSize(float endEdgeSize) {
        this.mEndEdgeSize = endEdgeSize;
    }

    public final void setFreezeState(boolean isFreeze) {
        this.mIsFreeze = isFreeze;
    }

    public final void setMCurrentTouch(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.mCurrentTouch = pointF;
    }

    public void setMoving(boolean z) {
        if (z && this.mEnableDocking && isStateDocking()) {
            Logger.m8702i(TAG, "moving : onDocking - not move");
            return;
        }
        if (this.mIsMoving != z) {
            this.mInit.y = getTranslationY();
            this.mIsMoving = z;
            startMoveWithAnimation(z);
            Logger.m8697d(TAG, "moving : " + z + "  width " + getWidth());
        }
    }

    public final void setStartMargin(float startMargin) {
        this.mStartMargin = Math.round(startMargin);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void startHideAnimation() {
        ValueAnimator valueAnimator = this.mShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.mHideAnimator;
            if (valueAnimator2 != null) {
                ValueAnimator valueAnimator3 = this.mShowAnimator;
                Float fValueOf = valueAnimator3 != null ? Float.valueOf(valueAnimator3.getAnimatedFraction()) : null;
                Intrinsics.checkNotNull(fValueOf);
                valueAnimator2.setCurrentFraction(1.0f - fValueOf.floatValue());
            }
            ValueAnimator valueAnimator4 = this.mShowAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
        }
        ValueAnimator valueAnimator5 = this.mHideAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void startShowAnimation() {
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.mShowAnimator;
            if (valueAnimator2 != null) {
                ValueAnimator valueAnimator3 = this.mHideAnimator;
                Float fValueOf = valueAnimator3 != null ? Float.valueOf(valueAnimator3.getAnimatedFraction()) : null;
                Intrinsics.checkNotNull(fValueOf);
                valueAnimator2.setCurrentFraction(1.0f - fValueOf.floatValue());
            }
            ValueAnimator valueAnimator4 = this.mHideAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
        }
        ValueAnimator valueAnimator5 = this.mShowAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    public final void updateDockerSizeWithMargin() {
        FloaterDelegate floaterDelegate = this.mDelegate;
        if (floaterDelegate != null) {
            int dockingSize = floaterDelegate.getDockingSize();
            FloaterDelegate floaterDelegate2 = this.mDelegate;
            if (floaterDelegate2 != null) {
                floaterDelegate2.changeDockerSize(dockingSize);
            }
        }
    }

    public void updateState() {
        Logger.m8702i(TAG, "updateState");
        drop(false);
    }

    public void updateXY(float toX, float toY) {
        float height = getHeight() + toY + this.bottomMargin;
        int i = this.mParentHeight;
        if (height > i) {
            toY -= height - i;
        }
        float fMax = (float) Math.max(0.0d, toY);
        float width = getWidth() + toX;
        int i2 = this.mParentWidth;
        if (width > i2) {
            toX -= width - i2;
        }
        float fMax2 = (float) Math.max(0.0d, toX);
        setTranslationY(fMax);
        setTranslationX(fMax2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnableFly = true;
        this.mInit = new PointF();
        this.mStart = new PointF();
        this.mCurrentTouch = new PointF();
        this.mOriginRect = new Rect();
        this.mOriginPoint = new Point();
        initialize(context);
    }

    public boolean onTouchMove(@NotNull PointF currentTouch) {
        FloaterDelegate floaterDelegate;
        Intrinsics.checkNotNullParameter(currentTouch, "currentTouch");
        float fAbs = (float) Math.abs(this.mStart.x - currentTouch.x);
        float fAbs2 = (float) Math.abs(this.mStart.y - currentTouch.y);
        if ((fAbs != 0.0f || fAbs2 != 0.0f) && !this.mIsInterceptedTouch) {
            int i = this.mTouchSlope;
            if ((fAbs > i || fAbs2 > i) && (floaterDelegate = this.mDelegate) != null && floaterDelegate.isInterceptedTouchEvent()) {
                this.mIsInterceptedTouch = true;
                Logger.m8697d(TAG, "touch : move : scrolling : " + fAbs + " vs " + fAbs2);
            } else {
                int i2 = this.mTouchSlope;
                if (fAbs > i2 || fAbs2 > i2) {
                    move(currentTouch.x, currentTouch.y);
                }
            }
        }
        if (!this.mIsMoving) {
            return false;
        }
        moveIntoTouchPoint(currentTouch);
        return this.mIsMoving;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnableFly = true;
        this.mInit = new PointF();
        this.mStart = new PointF();
        this.mCurrentTouch = new PointF();
        this.mOriginRect = new Rect();
        this.mOriginPoint = new Point();
        initialize(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnableFly = true;
        this.mInit = new PointF();
        this.mStart = new PointF();
        this.mCurrentTouch = new PointF();
        this.mOriginRect = new Rect();
        this.mOriginPoint = new Point();
        initialize(context);
    }
}
