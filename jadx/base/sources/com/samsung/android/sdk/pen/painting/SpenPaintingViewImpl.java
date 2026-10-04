package com.samsung.android.sdk.pen.painting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.SpenSettingFillColorInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenEraserChangeListener;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.sdk.pen.engine.SpenPenChangeListener;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffectManager;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.util.SpenLogInjector;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sdk.pen.view.context.SpenContext;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenu;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sdk.pen.view.gesture.SpenGesture;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.spen.C7932R;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0000\u0018\u0000 ÿ\u00012\u00020\u0001:\u0002ÿ\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001J\u0013\u0010\u0088\u0001\u001a\u00030\u0087\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010!J\u0013\u0010\u008a\u0001\u001a\u00030\u0087\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010!J\u0013\u0010\u008c\u0001\u001a\u00030\u0087\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010$J\u0013\u0010\u008e\u0001\u001a\u00030\u0087\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010&J\u0013\u0010\u008f\u0001\u001a\u00030\u0087\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010(J\u001a\u0010\u0090\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u001e2\u0007\u0010\u0092\u0001\u001a\u00020\u001eJ\u0010\u0010\u0093\u0001\u001a\u00020\u001e2\u0007\u0010\u0091\u0001\u001a\u00020\u001eJ\u001c\u0010\u0094\u0001\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u0001092\u0007\u0010\u0095\u0001\u001a\u00020*H\u0007J\u0011\u0010\u0096\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0097\u0001\u001a\u00020*J\u0013\u0010\u0098\u0001\u001a\u00020*2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0007J\u0011\u0010\u009b\u0001\u001a\u00020*2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\u0011\u0010\u009c\u0001\u001a\u00020*2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\b\u0010\u009d\u0001\u001a\u00030\u0087\u0001J\b\u0010\u009e\u0001\u001a\u00030\u0087\u0001J5\u0010\u009f\u0001\u001a\u00030\u0087\u00012\u0007\u0010 \u0001\u001a\u00020*2\u0007\u0010¡\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020\u001e2\u0007\u0010£\u0001\u001a\u00020\u001e2\u0007\u0010¤\u0001\u001a\u00020\u001eJ\b\u0010¥\u0001\u001a\u00030\u0087\u0001J\b\u0010¦\u0001\u001a\u00030\u0087\u0001J#\u0010§\u0001\u001a\u00030\u0087\u00012\u0013\u0010¨\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010ª\u0001\u0018\u00010©\u0001¢\u0006\u0003\u0010«\u0001J#\u0010¬\u0001\u001a\u00030\u0087\u00012\u0013\u0010¨\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010ª\u0001\u0018\u00010©\u0001¢\u0006\u0003\u0010«\u0001J\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010®\u0001\u001a\u00020t2\u0007\u0010¯\u0001\u001a\u00020\u001eJ\u0012\u0010°\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010±\u0001\u001a\u00020*J\u001b\u0010²\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010®\u0001\u001a\u00020t2\u0007\u0010³\u0001\u001a\u00020\u001eJ\u0015\u0010´\u0001\u001a\u0004\u0018\u00010G2\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001J,\u0010·\u0001\u001a\u00030\u0087\u00012\u0007\u0010¸\u0001\u001a\u00020\u001e2\u0007\u0010¹\u0001\u001a\u00020\u001e2\u0007\u0010º\u0001\u001a\u00020\u001e2\u0007\u0010»\u0001\u001a\u00020\u001eJ!\u0010¼\u0001\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0007\u0010½\u0001\u001a\u00020\u001e2\u0007\u0010¾\u0001\u001a\u00020\u001eJ9\u0010¿\u0001\u001a\u00020*2\t\u0010À\u0001\u001a\u0004\u0018\u00010G2\n\u0010Á\u0001\u001a\u0005\u0018\u00010¶\u00012\u0007\u0010Â\u0001\u001a\u00020\u001e2\u0007\u0010Ã\u0001\u001a\u00020\u001e2\u0007\u0010Ä\u0001\u001a\u00020*J,\u0010Å\u0001\u001a\u00030¶\u00012\u0007\u0010Æ\u0001\u001a\u00020\u001e2\u0007\u0010Ç\u0001\u001a\u00020\u001e2\u0007\u0010È\u0001\u001a\u00020\u001e2\u0007\u0010É\u0001\u001a\u00020\u001eJ$\u0010Ê\u0001\u001a\u00020*2\t\u0010À\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010Ë\u0001\u001a\u00020\u001e2\u0007\u0010Ì\u0001\u001a\u00020\u001eJ\u0010\u0010Í\u0001\u001a\u00030\u0087\u00012\u0006\u0010n\u001a\u00020*J$\u0010¿\u0001\u001a\u00020*2\t\u0010À\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010Î\u0001\u001a\u00020\u001e2\u0007\u0010Ä\u0001\u001a\u00020*J\u0011\u0010Ï\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ð\u0001\u001a\u00020\u001eJ\u0014\u0010Ñ\u0001\u001a\u00030\u0087\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010Ò\u0001J#\u0010Ó\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ô\u0001\u001a\u00020t2\u0007\u0010Õ\u0001\u001a\u00020t2\u0007\u0010Ö\u0001\u001a\u00020tJ\u0010\u0010×\u0001\u001a\u00020*2\u0007\u0010Ô\u0001\u001a\u00020tJ\u0010\u0010Ø\u0001\u001a\u00020*2\u0007\u0010Ô\u0001\u001a\u00020tJ,\u0010Ù\u0001\u001a\u00030\u0087\u00012\u0007\u0010¡\u0001\u001a\u00020t2\u0007\u0010¢\u0001\u001a\u00020t2\u0007\u0010£\u0001\u001a\u00020t2\u0007\u0010¤\u0001\u001a\u00020tJ\u001a\u0010Ú\u0001\u001a\u00030\u0087\u00012\u0007\u0010Û\u0001\u001a\u00020t2\u0007\u0010Ü\u0001\u001a\u00020tJ\u0011\u0010Ý\u0001\u001a\u00030\u0087\u00012\u0007\u0010Þ\u0001\u001a\u00020*J\u0010\u0010ß\u0001\u001a\u00020*2\u0007\u0010à\u0001\u001a\u00020*J\u0011\u0010á\u0001\u001a\u00030\u0087\u00012\u0007\u0010à\u0001\u001a\u00020*J#\u0010â\u0001\u001a\u00030\u0087\u00012\u0007\u0010ã\u0001\u001a\u00020\f2\u0007\u0010ä\u0001\u001a\u00020t2\u0007\u0010å\u0001\u001a\u00020\u001eJ\u0011\u0010æ\u0001\u001a\u00030\u0087\u00012\u0007\u0010à\u0001\u001a\u00020*J\u0011\u0010ç\u0001\u001a\u00030\u0087\u00012\u0007\u0010è\u0001\u001a\u00020*J\b\u0010é\u0001\u001a\u00030\u0087\u0001J\b\u0010ê\u0001\u001a\u00030\u0087\u0001J\u0013\u0010ë\u0001\u001a\u00030\u0087\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010QJ\n\u0010ì\u0001\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010í\u0001\u001a\u00030\u0087\u00012\u0006\u0010V\u001a\u00020JH\u0002J\u0016\u0010î\u0001\u001a\u00030\u0087\u00012\n\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0002J\u0012\u0010ñ\u0001\u001a\u00030\u0087\u00012\u0006\u0010V\u001a\u00020JH\u0002J\u0012\u0010ò\u0001\u001a\u00030\u0087\u00012\u0006\u0010V\u001a\u00020JH\u0002J\u0014\u0010ó\u0001\u001a\u00030\u0087\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u0087\u0001H\u0002J\u0013\u0010õ\u0001\u001a\u00020*2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010ö\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010÷\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u0087\u0001H\u0002J$\u0010ù\u0001\u001a\u00030\u0087\u00012\u0007\u0010ú\u0001\u001a\u00020\u001e2\u0007\u0010û\u0001\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\u001eH\u0002J@\u0010ü\u0001\u001a\u00030\u0087\u00012\u0007\u0010¡\u0001\u001a\u00020*2\u0007\u0010¢\u0001\u001a\u00020*2\u0007\u0010£\u0001\u001a\u00020*2\u0007\u0010¤\u0001\u001a\u00020*2\u0007\u0010ý\u0001\u001a\u00020t2\u0007\u0010þ\u0001\u001a\u00020tH\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010:\u001a\u0004\u0018\u0001092\b\u00108\u001a\u0004\u0018\u000109@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bT\u0010UR(\u0010W\u001a\u0004\u0018\u00010J2\b\u0010V\u001a\u0004\u0018\u00010J8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R(\u0010\\\u001a\u0004\u0018\u00010J2\b\u0010V\u001a\u0004\u0018\u00010J8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R(\u0010_\u001a\u0004\u0018\u00010M2\b\u0010V\u001a\u0004\u0018\u00010M8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0011\u0010d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010g\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bh\u0010fR$\u0010j\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010f\"\u0004\bl\u0010mR$\u0010o\u001a\u00020*2\u0006\u0010n\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010>\"\u0004\bp\u0010@R$\u0010q\u001a\u00020*2\u0006\u0010n\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010>\"\u0004\br\u0010@R\u0011\u0010s\u001a\u00020t8F¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0011\u0010w\u001a\u00020t8F¢\u0006\u0006\u001a\u0004\bx\u0010vR\u0011\u0010y\u001a\u00020t8F¢\u0006\u0006\u001a\u0004\bz\u0010vR)\u0010|\u001a\u0004\u0018\u00010B2\b\u0010{\u001a\u0004\u0018\u00010B8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010B8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010~R\u0013\u0010\u0083\u0001\u001a\u00020*8F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010>R'\u0010\u0084\u0001\u001a\u00020*2\u0006\u0010n\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010>\"\u0005\b\u0085\u0001\u0010@¨\u0006\u0080\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewImpl;", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;)V", "mContext", "nativePainting", "", "mViewCore", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewCore;", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "mNativeContext", "Lcom/samsung/android/sdk/pen/view/context/SpenContext;", "mView", "mDrawLoop", "mEdgeEffectManager", "Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;", "mHoverPointer", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "mPenSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "mScreenWidth", "", "mScreenHeight", "mTouchListener", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "mPreTouchListener", "mColorPickerListener", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "mPenChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenPenChangeListener;", "mEraserChangeListener", "Lcom/samsung/android/sdk/pen/engine/SpenEraserChangeListener;", "mIsDisAllowTouch", "", "mAllowTouchRect", "Landroid/graphics/Rect;", "mTouchMargin", "mIsPenButtonEnabledAtActionDown", "mGestureController", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingGestureController;", "mMouseWheelZoomEnabled", "mSpenLatencyConfiguration", "Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "mFbrDrawPad", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad;", "mIsFbrSupportedFeature", "mIsPredictionEnabled", "value", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "paintingDoc", "getPaintingDoc", "()Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "isPaperEnabled", "()Z", "setPaperEnabled", "(Z)V", "mStretchRatio", "Landroid/graphics/PointF;", "mPaperDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "mDepthDrawable", "mPaperBitmap", "Landroid/graphics/Bitmap;", "mDepthBitmap", "mCurEraserInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "mCurPenInfo", "mCurFillColorInfo", "Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "mContextMenu", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenu;", "mContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "gestureController", "Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "info", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "eraserSettingInfo", "getEraserSettingInfo", "setEraserSettingInfo", "fillColorInfo", "getFillColorInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "setFillColorInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;)V", "canvasWidth", "getCanvasWidth", "()I", "canvasHeight", "getCanvasHeight", "color", "blankColor", "getBlankColor", "setBlankColor", "(I)V", "enable", "isToolTipEnabled", "setToolTipEnabled", "isZoomable", "setZoomable", "zoomScale", "", "getZoomScale", "()F", "maxZoomScale", "getMaxZoomScale", "minZoomScale", "getMinZoomScale", "position", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "isFbrDrawPadEnabled", "isPredictionEnabled", "setPredictionEnabled", "close", "", "setTouchListener", "touchListener", "setPreTouchListener", "preTouchListener", "setColorPickerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPenChangeListener", "setEraserChangeListener", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setPaintingDoc", "isUpdate", "onWindowFocusChanged", "hasWindowFocus", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onGenericMotionEvent", "onHoverEvent", "commitStroke", "cancelStroke", "onLayout", "changed", "left", "top", "right", "bottom", "onAttachedToWindow", Constants.ARG_UPDATE, "updateUndo", "userDataList", "", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "([Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;)V", "updateRedo", "capturePage", "ratio", "option", "captureCurrentView", "includeBlank", "captureLayer", "layer_id", "captureRect", "rect", "Landroid/graphics/RectF;", "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setForceStretchView", "width", "height", "setLayerBitmap", "bitmap", "dstRect", "fullBitmapWidth", "fullBitmapHeight", "isClear", "getValidRect", "lMargin", "tMargin", "rMargin", "bMargin", "setSketchImage", "stretchMode", "opacity", "setColoringForegroundEnabled", "wrappingmode", "setScreenOrientation", "orientation", "setZoomListener", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "setZoomScale", WiggleAnimationConfig.KEY_SCALE, "centerX", "centerY", "setMaxZoomScale", "setMinZoomScale", "setMargin", "setDelta", "deltaX", "deltaY", "setIsFbrSupportedFeature", "isFbrSupportedFeature", "setFrontBufferRenderingEnabled", "enabled", "setHoverScrollEnabled", "setHoverScrollOption", "responseTime", "velocity", "margin", "setDoubleTapZoomEnabled", "setMouseWheelZoomEnabled", "wheelZoomEnabled", "startActionMode", "stopActionMode", "setContextMenuListener", "constructNativePainting", "applyPenSettingInfo", "initPenSoundInfo", "penName", "", "applyEraserSettingInfo", "printSettingPenInfoLog", "convertMotionEventPenButtonAction", "updateAllowTouchRect", "isTouchableArea", "createFbrDrawPad", "finalizeFbrDrawPad", "addFBRView", "onColorPickerChanged", "x", "y", "onShowEdgeEffect", "velocityX", "velocityY", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaintingViewImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaintingViewImpl.kt\ncom/samsung/android/sdk/pen/painting/SpenPaintingViewImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1009:1\n1#2:1010\n*E\n"})
public final class SpenPaintingViewImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float PAN_SCROLL_STEP = 5.0f;

    @NotNull
    private static final String TAG = "SpenPaintingViewImpl";
    private static final int U_OS = 34;
    private static final float ZOOM_RATIO_STEP = 0.05f;
    private boolean isPaperEnabled;

    @NotNull
    private final Rect mAllowTouchRect;

    @Nullable
    private SpenColorPickerListener mColorPickerListener;

    @Nullable
    private SpenConfiguration mConfiguration;

    @NotNull
    private Context mContext;

    @Nullable
    private SpenContextMenu mContextMenu;

    @Nullable
    private SpenContextMenuListener mContextMenuListener;

    @NotNull
    private SpenSettingPenInfo mCurEraserInfo;

    @NotNull
    private SpenSettingFillColorInfo mCurFillColorInfo;

    @NotNull
    private SpenSettingPenInfo mCurPenInfo;

    @Nullable
    private Bitmap mDepthBitmap;

    @Nullable
    private BitmapDrawable mDepthDrawable;

    @Nullable
    private SpenDisplay mDisplay;

    @NotNull
    private final SpenDrawLoopInterface mDrawLoop;

    @Nullable
    private SpenEdgeEffectManager mEdgeEffectManager;

    @Nullable
    private SpenEraserChangeListener mEraserChangeListener;

    @Nullable
    private SpenFbrDrawPad mFbrDrawPad;

    @NotNull
    private final SpenPaintingGestureController mGestureController;

    @Nullable
    private SpenHoverPointerIcon mHoverPointer;
    private boolean mIsDisAllowTouch;
    private boolean mIsFbrSupportedFeature;
    private boolean mIsPenButtonEnabledAtActionDown;
    private boolean mIsPredictionEnabled;
    private boolean mMouseWheelZoomEnabled;

    @Nullable
    private SpenContext mNativeContext;

    @Nullable
    private Bitmap mPaperBitmap;

    @Nullable
    private BitmapDrawable mPaperDrawable;

    @Nullable
    private SpenPenChangeListener mPenChangeListener;

    @Nullable
    private SpenPenSound mPenSound;

    @Nullable
    private SpenTouchListener mPreTouchListener;
    private int mScreenHeight;
    private int mScreenWidth;

    @Nullable
    private SpenLatencyConfiguration mSpenLatencyConfiguration;

    @NotNull
    private final PointF mStretchRatio;

    @Nullable
    private SpenTouchListener mTouchListener;

    @NotNull
    private final Rect mTouchMargin;

    @NotNull
    private View mView;

    @Nullable
    private SpenPaintingViewCore mViewCore;
    private long nativePainting;

    @Nullable
    private SpenPaintingDoc paintingDoc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0083 J9\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0011\u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0083 J\u0011\u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0083 J#\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u001bH\u0083 J\u0019\u0010&\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0083 J\u0019\u0010)\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0083 J\u0011\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0083 J\u0011\u0010+\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0083 J\u0011\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0083 J+\u0010-\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\u0006\u00101\u001a\u00020\u0007H\u0083 J+\u00102\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\u0006\u00101\u001a\u00020\u0007H\u0083 J\u0019\u00103\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0007H\u0083 J!\u00105\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0083 J!\u00109\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020\u001bH\u0083 J!\u0010;\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020\u0007H\u0083 J!\u0010=\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0083 J1\u0010@\u001a\u00020?2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0083 J)\u0010E\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0083 J+\u0010I\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0083 J\u0019\u0010L\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u001bH\u0083 J+\u0010M\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001bH\u0083 J;\u0010M\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010>\u001a\u00020?2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001bH\u0083 J\u001b\u0010P\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000107H\u0083 J\u0019\u0010Q\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010R\u001a\u00020\u0007H\u0083 J\u0011\u0010S\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fH\u0083 J\u0019\u0010T\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010U\u001a\u00020\fH\u0083 J\u0019\u0010V\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010W\u001a\u00020\u0007H\u0083 J\u0019\u0010X\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\fH\u0083 J\u0019\u0010Z\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010[\u001a\u00020\\H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "U_OS", "", "ZOOM_RATIO_STEP", "", "PAN_SCROLL_STEP", "Native_init", "", "view", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingViewImpl;", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "contextHandle", "hoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "penSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "Native_finalize", "", "nativePainting", "Native_onLayout", "changed", "", "left", "top", "right", "bottom", "Native_getViewCore", "Native_getGestureController", "Native_setPaintingDoc", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "isUpdate", "Native_onTouch", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_onHover", "Native_commitStroke", "Native_cancelStroke", "Native_update", "Native_updateUndo", "userDataList", "", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "length", "Native_updateRedo", "Native_setScreenOrientation", "orientation", "Native_capturePage", "bitmap", "Landroid/graphics/Bitmap;", "flag", "Native_captureCurrentView", "includeBlank", "Native_captureLayer", "layer_id", "Native_captureRect", "rect", "Landroid/graphics/RectF;", "Native_getValidRect", "lMargin", "tMargin", "rMargin", "bMargin", "Native_setForceStretchView", "enable", "width", "height", "Native_setSketchImage", "stretchMode", "opacity", "Native_setColoringForegroundEnabled", "Native_setLayerBitmap", "wrappingmode", "isClear", "Native_setPaperDepthMap", "Native_setBlankColor", "color", "Native_getBlankColor", "Native_setFbrDrawPad", "nativeDrawPad", "Native_setPredictionType", "type", "Native_setContextMenu", "contextMenu", "Native_setFillColorInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_cancelStroke(long nativePainting) {
            SpenPaintingViewImpl.Native_cancelStroke(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureCurrentView(long nativePainting, Bitmap bitmap, boolean includeBlank) {
            return SpenPaintingViewImpl.Native_captureCurrentView(nativePainting, bitmap, includeBlank);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureLayer(long nativePainting, Bitmap bitmap, int layer_id) {
            return SpenPaintingViewImpl.Native_captureLayer(nativePainting, bitmap, layer_id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePage(long nativePainting, Bitmap bitmap, int flag) {
            return SpenPaintingViewImpl.Native_capturePage(nativePainting, bitmap, flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureRect(long nativePainting, Bitmap bitmap, RectF rect) {
            return SpenPaintingViewImpl.Native_captureRect(nativePainting, bitmap, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_commitStroke(long nativePainting) {
            SpenPaintingViewImpl.Native_commitStroke(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativePainting) {
            SpenPaintingViewImpl.Native_finalize(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getBlankColor(long nativePainting) {
            return SpenPaintingViewImpl.Native_getBlankColor(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getGestureController(long nativePainting) {
            return SpenPaintingViewImpl.Native_getGestureController(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getValidRect(long nativePainting, int lMargin, int tMargin, int rMargin, int bMargin) {
            return SpenPaintingViewImpl.Native_getValidRect(nativePainting, lMargin, tMargin, rMargin, bMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getViewCore(long nativePainting) {
            return SpenPaintingViewImpl.Native_getViewCore(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenPaintingViewImpl view, SpenDrawLoopInterface drawLoop, long contextHandle, SpenHoverPointerIcon hoverPointerIcon, SpenPenSound penSound) {
            return SpenPaintingViewImpl.Native_init(view, drawLoop, contextHandle, hoverPointerIcon, penSound);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHover(long nativePainting, SpenMotionEvent event) {
            return SpenPaintingViewImpl.Native_onHover(nativePainting, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onLayout(long nativePainting, boolean changed, int left, int top, int right, int bottom) {
            SpenPaintingViewImpl.Native_onLayout(nativePainting, changed, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onTouch(long nativePainting, SpenMotionEvent event) {
            return SpenPaintingViewImpl.Native_onTouch(nativePainting, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setBlankColor(long nativePainting, int color) {
            SpenPaintingViewImpl.Native_setBlankColor(nativePainting, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setColoringForegroundEnabled(long nativePainting, boolean enable) {
            SpenPaintingViewImpl.Native_setColoringForegroundEnabled(nativePainting, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContextMenu(long nativePainting, long contextMenu) {
            SpenPaintingViewImpl.Native_setContextMenu(nativePainting, contextMenu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFbrDrawPad(long nativePainting, long nativeDrawPad) {
            SpenPaintingViewImpl.Native_setFbrDrawPad(nativePainting, nativeDrawPad);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFillColorInfo(long nativePainting, SpenSettingFillColorInfo info) {
            SpenPaintingViewImpl.Native_setFillColorInfo(nativePainting, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setForceStretchView(long nativePainting, boolean enable, int width, int height) {
            return SpenPaintingViewImpl.Native_setForceStretchView(nativePainting, enable, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setLayerBitmap(long nativePainting, Bitmap bitmap, int wrappingmode, boolean isClear) {
            return SpenPaintingViewImpl.Native_setLayerBitmap(nativePainting, bitmap, wrappingmode, isClear);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPaintingDoc(long nativePainting, SpenPaintingDoc paintingDoc, boolean isUpdate) {
            return SpenPaintingViewImpl.Native_setPaintingDoc(nativePainting, paintingDoc, isUpdate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPaperDepthMap(long nativePainting, Bitmap bitmap) {
            return SpenPaintingViewImpl.Native_setPaperDepthMap(nativePainting, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPredictionType(long nativePainting, int type) {
            SpenPaintingViewImpl.Native_setPredictionType(nativePainting, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenOrientation(long nativePainting, int orientation) {
            SpenPaintingViewImpl.Native_setScreenOrientation(nativePainting, orientation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setSketchImage(long nativePainting, Bitmap bitmap, int stretchMode, int opacity) {
            return SpenPaintingViewImpl.Native_setSketchImage(nativePainting, bitmap, stretchMode, opacity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_update(long nativePainting) {
            SpenPaintingViewImpl.Native_update(nativePainting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_updateRedo(long j, SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArr, int i) {
            return SpenPaintingViewImpl.Native_updateRedo(j, spenHistoryUpdateInfoArr, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_updateUndo(long j, SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArr, int i) {
            return SpenPaintingViewImpl.Native_updateUndo(j, spenHistoryUpdateInfoArr, i);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setLayerBitmap(long nativePainting, Bitmap bitmap, RectF rect, int width, int height, boolean isClear) {
            return SpenPaintingViewImpl.Native_setLayerBitmap(nativePainting, bitmap, rect, width, height, isClear);
        }
    }

    public SpenPaintingViewImpl(@NotNull Context context, @NotNull View view, @NotNull SpenDrawLoopInterface drawLoop) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(drawLoop, "drawLoop");
        this.mContext = context;
        this.mView = view;
        this.mDrawLoop = drawLoop;
        this.mIsDisAllowTouch = true;
        this.mAllowTouchRect = new Rect();
        this.mTouchMargin = new Rect();
        this.mIsFbrSupportedFeature = true;
        this.isPaperEnabled = true;
        this.mStretchRatio = new PointF(1.0f, 1.0f);
        this.mCurEraserInfo = new SpenSettingPenInfo();
        this.mCurPenInfo = new SpenSettingPenInfo();
        this.mCurFillColorInfo = new SpenSettingFillColorInfo();
        SpenResources.INSTANCE.setResources(context.getResources());
        constructNativePainting();
        Context context2 = this.mContext;
        Companion companion = INSTANCE;
        this.mViewCore = new SpenPaintingViewCore(context2, companion.Native_getViewCore(this.nativePainting));
        this.mGestureController = new SpenPaintingGestureController(companion.Native_getGestureController(this.nativePainting));
        this.mEdgeEffectManager = new SpenEdgeEffectManager(this.mContext, this.mView);
        this.mSpenLatencyConfiguration = new SpenLatencyConfiguration(context);
        SpenContextMenu spenContextMenu = new SpenContextMenu(this.mView);
        this.mContextMenu = spenContextMenu;
        companion.Native_setContextMenu(this.nativePainting, spenContextMenu.getNativeContextMenu());
        setFrontBufferRenderingEnabled(true);
        setPredictionEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_cancelStroke(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureCurrentView(long j, Bitmap bitmap, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureLayer(long j, Bitmap bitmap, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePage(long j, Bitmap bitmap, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureRect(long j, Bitmap bitmap, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_commitStroke(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getBlankColor(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getGestureController(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getValidRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getViewCore(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenPaintingViewImpl spenPaintingViewImpl, SpenDrawLoopInterface spenDrawLoopInterface, long j, SpenHoverPointerIcon spenHoverPointerIcon, SpenPenSound spenPenSound);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHover(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onLayout(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onTouch(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setBlankColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setColoringForegroundEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContextMenu(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFbrDrawPad(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFillColorInfo(long j, SpenSettingFillColorInfo spenSettingFillColorInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setForceStretchView(long j, boolean z, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setLayerBitmap(long j, Bitmap bitmap, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setLayerBitmap(long j, Bitmap bitmap, RectF rectF, int i, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPaintingDoc(long j, SpenPaintingDoc spenPaintingDoc, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPaperDepthMap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScreenOrientation(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setSketchImage(long j, Bitmap bitmap, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_update(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_updateRedo(long j, SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_updateUndo(long j, SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArr, int i);

    private final void addFBRView() {
        ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad == null || spenFbrDrawPad.getParent() != null) {
            return;
        }
        spenFbrDrawPad.setVisibility(4);
        spenFbrDrawPad.setZOrderMediaOverlay(true);
        if (viewGroup != null) {
            viewGroup.addView(spenFbrDrawPad, 0);
        }
    }

    private final void applyEraserSettingInfo(SpenSettingPenInfo info) {
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore != null) {
            spenPaintingViewCore.setEraserSettingInfo(info, this.mDisplay);
        }
        printSettingPenInfoLog(info);
        SpenEraserChangeListener spenEraserChangeListener = this.mEraserChangeListener;
        if (spenEraserChangeListener != null) {
            spenEraserChangeListener.onChanged(info);
        }
    }

    private final void applyPenSettingInfo(SpenSettingPenInfo info) {
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore != null) {
            spenPaintingViewCore.setPenSettingInfo(info, this.mDisplay);
        }
        printSettingPenInfoLog(info);
        initPenSoundInfo(info.name);
        SpenPenChangeListener spenPenChangeListener = this.mPenChangeListener;
        if (spenPenChangeListener != null) {
            spenPenChangeListener.onChanged(info);
        }
    }

    private final void constructNativePainting() {
        this.mDisplay = new SpenDisplay(this.mContext);
        this.mConfiguration = new SpenConfiguration(this.mContext);
        Context context = this.mContext;
        long msgQueueHandle = this.mDrawLoop.getMsgQueueHandle();
        SpenDisplay spenDisplay = this.mDisplay;
        Intrinsics.checkNotNull(spenDisplay);
        SpenConfiguration spenConfiguration = this.mConfiguration;
        Intrinsics.checkNotNull(spenConfiguration);
        this.mNativeContext = new SpenContext(context, msgQueueHandle, spenDisplay, spenConfiguration, this.mDrawLoop.getRendererType());
        SpenHoverPointerIcon spenHoverPointerIcon = new SpenHoverPointerIcon(this.mContext, this.mView);
        this.mHoverPointer = spenHoverPointerIcon;
        spenHoverPointerIcon.setPenIconStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_LINE);
        this.mPenSound = new SpenPenSound(this.mContext);
        Companion companion = INSTANCE;
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        SpenContext spenContext = this.mNativeContext;
        Intrinsics.checkNotNull(spenContext);
        long handle = spenContext.getHandle();
        SpenHoverPointerIcon spenHoverPointerIcon2 = this.mHoverPointer;
        Intrinsics.checkNotNull(spenHoverPointerIcon2);
        SpenPenSound spenPenSound = this.mPenSound;
        Intrinsics.checkNotNull(spenPenSound);
        long jNative_init = companion.Native_init(this, spenDrawLoopInterface, handle, spenHoverPointerIcon2, spenPenSound);
        this.nativePainting = jNative_init;
        if (jNative_init == 0) {
            SpenError.ThrowUncheckedException(8, " : nativePainting must not be null");
        }
    }

    private final void convertMotionEventPenButtonAction(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.mIsPenButtonEnabledAtActionDown = event.getButtonState() == 32;
        }
        if (this.mIsPenButtonEnabledAtActionDown) {
            if (action == 0) {
                event.setAction(MotionEventWrapper.ACTION_PEN_DOWN);
                return;
            }
            if (action == 1) {
                event.setAction(MotionEventWrapper.ACTION_PEN_UP);
            } else if (action == 2) {
                event.setAction(MotionEventWrapper.ACTION_PEN_MOVE);
            } else {
                if (action != 3) {
                    return;
                }
                event.setAction(MotionEventWrapper.ACTION_PEN_CANCEL);
            }
        }
    }

    private final void createFbrDrawPad() {
        Log.d(TAG, "createFbrDrawPad");
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        if (spenLatencyConfiguration != null) {
            SpenFbrDrawPad spenFbrDrawPad = new SpenFbrDrawPad(this.mContext, this.mView, spenLatencyConfiguration.getIsChromeOS(), SpenFbrDrawPad.DefaultMode);
            this.mFbrDrawPad = spenFbrDrawPad;
            INSTANCE.Native_setFbrDrawPad(this.nativePainting, spenFbrDrawPad.getHandle());
            ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            if (viewGroup != null) {
                viewGroup.addView(spenFbrDrawPad, 0);
                spenFbrDrawPad.setVisibility(4);
                spenFbrDrawPad.setZOrderMediaOverlay(true);
            }
            spenLatencyConfiguration.updateHWInfo(this.mFbrDrawPad);
        }
    }

    private final void finalizeFbrDrawPad() {
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            long j = this.nativePainting;
            if (j != 0) {
                INSTANCE.Native_setFbrDrawPad(j, 0L);
            }
            ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            if (spenFbrDrawPad.getParent() != null && viewGroup != null) {
                viewGroup.removeView(spenFbrDrawPad);
            }
            spenFbrDrawPad.close();
            this.mFbrDrawPad = null;
        }
    }

    private final void initPenSoundInfo(String penName) {
        SpenPaintingViewCore spenPaintingViewCore;
        if (penName == null || penName.length() == 0 || (spenPaintingViewCore = this.mViewCore) == null) {
            return;
        }
        if (Intrinsics.areEqual(penName, SpenPenManager.SPEN_COLORED_PENCIL)) {
            SpenPenSound spenPenSound = this.mPenSound;
            if (spenPenSound != null) {
                spenPenSound.setPenStyle(penName, spenPaintingViewCore.getPenParticleDensity());
                return;
            }
            return;
        }
        SpenPenSound spenPenSound2 = this.mPenSound;
        if (spenPenSound2 != null) {
            spenPenSound2.setPenStyle(penName, spenPaintingViewCore.getPenSize());
        }
    }

    private final boolean isTouchableArea(MotionEvent event) {
        return this.mAllowTouchRect.contains((int) (event.getX() + 0.5f), (int) (event.getY() + 0.5f));
    }

    private final void onColorPickerChanged(int x, int y2, int color) {
        AbstractC0541b.m755A(color, "onColorPickerChanged color", TAG);
        SpenColorPickerListener spenColorPickerListener = this.mColorPickerListener;
        if (spenColorPickerListener != null) {
            spenColorPickerListener.onColorPicked(color, x, y2);
        }
    }

    private final void onShowEdgeEffect(boolean left, boolean top, boolean right, boolean bottom, float velocityX, float velocityY) {
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.showEdgeEffect(left, top, right, bottom, velocityX, velocityY);
        }
    }

    private final void printSettingPenInfoLog(SpenSettingPenInfo info) {
        Log.d(TAG, "[SpenPaintingViewImpl] =================================================");
        AbstractC2322a.m1609C("[SpenPaintingViewImpl] SettingPenInfo name=", info.name, TAG);
        Log.d(TAG, "[SpenPaintingViewImpl] SettingPenInfo size=" + info.size);
        AbstractC0541b.m755A(info.sizeLevel, "[SpenPaintingViewImpl] SettingPenInfo sizeLevel=", TAG);
        AbstractC2322a.m1609C("[SpenPaintingViewImpl] SettingPenInfo color=", Integer.toHexString(info.color), TAG);
        AbstractC6670b.m4759t("[SpenPaintingViewImpl] SettingPenInfo isCurvable=", TAG, info.isCurvable);
        AbstractC6670b.m4759t("[SpenPaintingViewImpl] SettingPenInfo isEraserEnabled=", TAG, info.isEraserEnabled);
        AbstractC2322a.m1609C("[SpenPaintingViewImpl] SettingPenInfo particleDensity=", Integer.toHexString(info.particleDensity), TAG);
        Log.d(TAG, "[SpenPaintingViewImpl] SettingPenInfo particleSize=" + info.particleSize);
        Log.d(TAG, "[SpenPaintingViewImpl] SettingPenInfo isFixedWidth=" + info.isFixedWidth);
        Log.d(TAG, "[SpenPaintingViewImpl] =================================================");
    }

    private final void updateAllowTouchRect() {
        int i;
        int i2 = this.mScreenWidth;
        if (i2 == 0 || (i = this.mScreenHeight) == 0) {
            this.mAllowTouchRect.setEmpty();
            return;
        }
        Rect rect = this.mAllowTouchRect;
        Rect rect2 = this.mTouchMargin;
        rect.set(rect2.left, rect2.top, i2 - rect2.right, i - rect2.bottom);
    }

    public final void cancelStroke() {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_cancelStroke(j);
    }

    @Nullable
    public final Bitmap captureCurrentView(boolean includeBlank) {
        int i;
        Bitmap bitmapCreateBitmap = null;
        if (this.nativePainting == 0) {
            Log.e(TAG, "Native canvas is null!");
            return null;
        }
        int i2 = this.mScreenWidth;
        if (i2 == 0 || (i = this.mScreenHeight) == 0) {
            Log.e(TAG, "Not yet to create view");
            SpenError.ThrowUncheckedException(4, " : ScreenWidth or ScreenHeight is zero.");
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            INSTANCE.Native_captureCurrentView(this.nativePainting, bitmapCreateBitmap, includeBlank);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
            return bitmapCreateBitmap;
        }
    }

    @Nullable
    public final Bitmap captureLayer(float ratio, int layer_id) {
        if (this.nativePainting == 0) {
            return null;
        }
        try {
            int canvasWidth = getCanvasWidth();
            int canvasHeight = getCanvasHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            if (INSTANCE.Native_captureLayer(this.nativePainting, bitmapCreateBitmap, layer_id)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (canvasWidth * ratio), (int) (canvasHeight * ratio), true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                bitmapCreateBitmap.recycle();
                return bitmapCreateScaledBitmap;
            }
        } catch (Throwable unused) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        return null;
    }

    @Nullable
    public final Bitmap capturePage(float ratio, int option) {
        if (this.nativePainting == 0) {
            return null;
        }
        try {
            int canvasWidth = getCanvasWidth();
            int canvasHeight = getCanvasHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            if (INSTANCE.Native_capturePage(this.nativePainting, bitmapCreateBitmap, option)) {
                return Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (canvasWidth * ratio), (int) (canvasHeight * ratio), true);
            }
        } catch (Throwable unused) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        return null;
    }

    @Nullable
    public final Bitmap captureRect(@Nullable RectF rect) {
        if (this.nativePainting != 0 && rect != null && !rect.isEmpty()) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rect.width(), (int) rect.height(), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                if (INSTANCE.Native_captureRect(this.nativePainting, bitmapCreateBitmap, rect)) {
                    return bitmapCreateBitmap;
                }
            } catch (Throwable unused) {
                Log.e(TAG, "Failed to create bitmap w = " + rect.width() + " h = " + rect.height());
                SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
            }
        }
        return null;
    }

    public final void close() {
        Log.i(TAG, "close");
        this.mPreTouchListener = null;
        this.mTouchListener = null;
        this.mColorPickerListener = null;
        this.mPenChangeListener = null;
        this.mEraserChangeListener = null;
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.close();
        }
        this.mContextMenu = null;
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        if (spenLatencyConfiguration != null) {
            spenLatencyConfiguration.close();
        }
        this.mSpenLatencyConfiguration = null;
        finalizeFbrDrawPad();
        long j = this.nativePainting;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativePainting = 0L;
        }
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointer;
        if (spenHoverPointerIcon != null) {
            spenHoverPointerIcon.removeHoveringIcon();
        }
        SpenHoverPointerIcon spenHoverPointerIcon2 = this.mHoverPointer;
        if (spenHoverPointerIcon2 != null) {
            spenHoverPointerIcon2.close();
        }
        SpenPenSound spenPenSound = this.mPenSound;
        if (spenPenSound != null) {
            spenPenSound.close();
        }
        this.mPaperBitmap = null;
        this.mPaperDrawable = null;
        this.mDepthBitmap = null;
        this.mDepthDrawable = null;
        SpenContext spenContext = this.mNativeContext;
        if (spenContext != null) {
            spenContext.close();
        }
        this.mNativeContext = null;
        SpenConfiguration spenConfiguration = this.mConfiguration;
        if (spenConfiguration != null) {
            spenConfiguration.close();
        }
        SpenDisplay spenDisplay = this.mDisplay;
        if (spenDisplay != null) {
            spenDisplay.close();
        }
        this.mDisplay = null;
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.close();
        }
        this.mEdgeEffectManager = null;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore != null) {
            spenPaintingViewCore.close();
        }
        this.mViewCore = null;
    }

    public final void commitStroke() {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_commitStroke(j);
    }

    public final int getBlankColor() {
        long j = this.nativePainting;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getBlankColor(j);
    }

    public final int getCanvasHeight() {
        SpenPaintingDoc spenPaintingDoc;
        if (this.nativePainting == 0 || (spenPaintingDoc = this.paintingDoc) == null) {
            return 0;
        }
        return spenPaintingDoc.getHeight();
    }

    public final int getCanvasWidth() {
        SpenPaintingDoc spenPaintingDoc;
        if (this.nativePainting == 0 || (spenPaintingDoc = this.paintingDoc) == null) {
            return 0;
        }
        return spenPaintingDoc.getWidth();
    }

    @Nullable
    public final PointF getDelta() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return null;
        }
        return deltaZoom.getDelta();
    }

    @Nullable
    /* JADX INFO: renamed from: getEraserSettingInfo, reason: from getter */
    public final SpenSettingPenInfo getMCurEraserInfo() {
        return this.mCurEraserInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: getFillColorInfo, reason: from getter */
    public final SpenSettingFillColorInfo getMCurFillColorInfo() {
        return this.mCurFillColorInfo;
    }

    @NotNull
    public final SpenIPaintingGestureController getGestureController() {
        return this.mGestureController;
    }

    public final float getMaxZoomScale() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return 0.0f;
        }
        return deltaZoom.getMaxZoomScale();
    }

    public final float getMinZoomScale() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return 0.0f;
        }
        return deltaZoom.getMinZoomScale();
    }

    @Nullable
    public final synchronized SpenPaintingDoc getPaintingDoc() {
        return this.paintingDoc;
    }

    @Nullable
    public final PointF getPan() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return null;
        }
        return deltaZoom.getPan();
    }

    @Nullable
    /* JADX INFO: renamed from: getPenSettingInfo, reason: from getter */
    public final SpenSettingPenInfo getMCurPenInfo() {
        return this.mCurPenInfo;
    }

    public final int getToolTypeAction(int toolType) {
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore != null) {
            return spenPaintingViewCore.getToolTypeAction(toolType);
        }
        return 0;
    }

    @NotNull
    public final RectF getValidRect(int lMargin, int tMargin, int rMargin, int bMargin) {
        return INSTANCE.Native_getValidRect(this.nativePainting, lMargin, tMargin, rMargin, bMargin);
    }

    public final float getZoomScale() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return 0.0f;
        }
        return deltaZoom.getZoomScale();
    }

    public final boolean isFbrDrawPadEnabled() {
        return this.mFbrDrawPad != null;
    }

    /* JADX INFO: renamed from: isPaperEnabled, reason: from getter */
    public final boolean getIsPaperEnabled() {
        return this.isPaperEnabled;
    }

    /* JADX INFO: renamed from: isPredictionEnabled, reason: from getter */
    public final boolean getMIsPredictionEnabled() {
        return this.mIsPredictionEnabled;
    }

    public final boolean isToolTipEnabled() {
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointer;
        if (spenHoverPointerIcon != null) {
            return spenHoverPointerIcon.isToolTipEnabled();
        }
        return false;
    }

    public final boolean isZoomable() {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return false;
        }
        return deltaZoom.isZoomable();
    }

    public final void onAttachedToWindow() {
        ViewParent parent = this.mView.getParent();
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.attachToParentView(parent);
        }
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        ViewGroup viewGroup = (ViewGroup) (spenFbrDrawPad != null ? spenFbrDrawPad.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(this.mFbrDrawPad);
        }
        addFBRView();
    }

    public final boolean onGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event.getSource() & 2) == 0 || event.getAction() != 8) {
            return true;
        }
        if (event.getAxisValue(9) < 0.0f) {
            Log.v(TAG, "ACTION_SCROLL:Zoom Out = " + event.getAxisValue(9));
        } else {
            Log.v(TAG, "ACTION_SCROLL:Zoom In = " + event.getAxisValue(9));
        }
        if (this.mMouseWheelZoomEnabled) {
            setZoomScale((event.getAxisValue(9) * 0.05f) + getZoomScale(), event.getX(), event.getY());
        } else {
            PointF pan = getPan();
            if (pan != null) {
                pan.x -= event.getAxisValue(10) * PAN_SCROLL_STEP;
                pan.y -= event.getAxisValue(9) * PAN_SCROLL_STEP;
                setPan(pan);
            }
        }
        return true;
    }

    public final boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        INSTANCE.Native_onHover(this.nativePainting, new SpenMotionEvent(event));
        return true;
    }

    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.nativePainting == 0) {
            return;
        }
        int i = right - left;
        int i2 = bottom - top;
        if (i == 0 || i2 == 0) {
            return;
        }
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        updateAllowTouchRect();
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.setScreenInfo(this.mScreenWidth, this.mScreenHeight, 0, 0);
        }
        this.mDrawLoop.setScreenSize(i, i2);
        INSTANCE.Native_onLayout(this.nativePainting, changed, left, top, right, bottom);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.nativePainting == 0 || (event.getAction() == 0 && event.getButtonState() == 2)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            convertMotionEventPenButtonAction(event);
        }
        int actionMasked = event.getActionMasked();
        int i = MotionEventWrapper.ACTION_PEN_DOWN;
        int toolType = (actionMasked == i || actionMasked == MotionEventWrapper.ACTION_PEN_MOVE || actionMasked == MotionEventWrapper.ACTION_PEN_UP || actionMasked == MotionEventWrapper.ACTION_PEN_CANCEL) ? 6 : event.getToolType(0);
        if (actionMasked == 0 || actionMasked == i) {
            boolean zIsTouchableArea = isTouchableArea(event);
            this.mIsDisAllowTouch = !zIsTouchableArea;
            if (!zIsTouchableArea) {
                Log.i(TAG, "[JavaGesture] disallow touch down");
            }
        }
        if (this.mIsDisAllowTouch) {
            return false;
        }
        int toolTypeAction = getToolTypeAction(toolType);
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC0000a.m26w(AbstractC0622a.m1173s(actionMasked, toolType, "[JavaGesture] Paint onTouch begin. action=", ", toolType=", ", toolTypeAction="), TAG, toolTypeAction);
        SpenGesture.INSTANCE.onTouchEvent(event, false);
        this.mView.invalidate(0, 0, 0, 0);
        if (actionMasked == i) {
            Context context = this.mContext;
            SpenLogInjector.insertLog(context, SpenLogInjector.ERASE_USING_PEN_BUTTON, context.getPackageName());
        }
        SpenTouchListener spenTouchListener = this.mPreTouchListener;
        if (spenTouchListener != null && spenTouchListener.onTouch(this.mView, event)) {
            Log.v(TAG, "[JavaGesture] Paint Performance onPreTouchViewTimeInMillis has consumed action=" + actionMasked + ", elapsed=" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return true;
        }
        if (actionMasked == 0) {
            int historySize = event.getHistorySize();
            for (int i2 = 0; i2 < historySize; i2++) {
                Log.i(TAG, "[JavaGesture] Paint index : " + i2 + " , down time : " + event.getDownTime() + " , eventTime : " + event.getHistoricalEventTime(i2));
            }
            long downTime = event.getDownTime();
            long eventTime = event.getEventTime();
            StringBuilder sbM1323p = AbstractC1974b.m1323p(downTime, "[JavaGesture] Paint down time : ", ", eventTime : ");
            sbM1323p.append(eventTime);
            Log.i(TAG, sbM1323p.toString());
        }
        INSTANCE.Native_onTouch(this.nativePainting, new SpenMotionEvent(event));
        SpenPenSound spenPenSound = this.mPenSound;
        if (spenPenSound != null) {
            spenPenSound.onTouch(event, toolTypeAction);
        }
        SpenTouchListener spenTouchListener2 = this.mTouchListener;
        if (spenTouchListener2 != null) {
            spenTouchListener2.onTouch(this.mView, event);
        }
        float x = event.getX();
        float y2 = event.getY();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("[JavaGesture] Paint onTouch end. (", x, SQLKeyword.COMMA, y2, "), elapsed=");
        sbM1176v.append(jCurrentTimeMillis2);
        sbM1176v.append("ms");
        Log.i(TAG, sbM1176v.toString());
        return true;
    }

    public final void onWindowFocusChanged(boolean hasWindowFocus) {
        if (this.mPenSound == null) {
            return;
        }
        if (hasWindowFocus) {
            Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : true");
            SpenPenSound spenPenSound = this.mPenSound;
            if (spenPenSound != null) {
                spenPenSound.registerPenSoundSolution();
                return;
            }
            return;
        }
        Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : false");
        SpenPenSound spenPenSound2 = this.mPenSound;
        if (spenPenSound2 != null) {
            spenPenSound2.unregisterPenSoundSolution();
        }
    }

    public final void setBlankColor(int i) {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setBlankColor(j, i);
    }

    public final void setColorPickerListener(@Nullable SpenColorPickerListener listener) {
        this.mColorPickerListener = listener;
    }

    public final void setColoringForegroundEnabled(boolean enable) {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setColoringForegroundEnabled(j, enable);
    }

    public final void setContextMenuListener(@Nullable SpenContextMenuListener listener) {
        this.mContextMenuListener = listener;
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.setContextMenuListener(new SpenContextMenuListener() { // from class: com.samsung.android.sdk.pen.painting.SpenPaintingViewImpl.setContextMenuListener.1
                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    SpenContextMenuListener spenContextMenuListener = SpenPaintingViewImpl.this.mContextMenuListener;
                    return spenContextMenuListener != null && spenContextMenuListener.onActionItemClicked(mode, item);
                }

                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    SpenContextMenuListener spenContextMenuListener = SpenPaintingViewImpl.this.mContextMenuListener;
                    return spenContextMenuListener != null && spenContextMenuListener.onCreateActionMode(mode, menu);
                }

                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public void onCreateContextMenu(ContextMenu menu) {
                    SpenContextMenuListener spenContextMenuListener = SpenPaintingViewImpl.this.mContextMenuListener;
                    if (spenContextMenuListener != null) {
                        spenContextMenuListener.onCreateContextMenu(menu);
                    }
                }
            });
        }
    }

    public final void setDelta(float deltaX, float deltaY) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setDelta(deltaX, deltaY);
    }

    public final void setDoubleTapZoomEnabled(boolean enabled) {
        this.mGestureController.setDoubleTapZoomEnabled(enabled);
    }

    public final void setEraserChangeListener(@Nullable SpenEraserChangeListener listener) {
        this.mEraserChangeListener = listener;
    }

    public final void setEraserSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        if (this.nativePainting == 0 || spenSettingPenInfo == null || this.mCurEraserInfo.equals(spenSettingPenInfo)) {
            return;
        }
        int i = spenSettingPenInfo.sizeLevel;
        if (i != 0) {
            float fConvertSizeLevelToDpSize = SpenPenUtil.convertSizeLevelToDpSize(this.mContext, spenSettingPenInfo.name, i);
            spenSettingPenInfo.size = fConvertSizeLevelToDpSize;
            AbstractC4539a.m3205o("setEraserSettingInfo size2=", TAG, fConvertSizeLevelToDpSize);
        }
        this.mCurEraserInfo = new SpenSettingPenInfo(spenSettingPenInfo);
        applyEraserSettingInfo(spenSettingPenInfo);
    }

    public final void setFillColorInfo(@Nullable SpenSettingFillColorInfo spenSettingFillColorInfo) {
        if (this.nativePainting == 0 || spenSettingFillColorInfo == null || this.mCurFillColorInfo.equals(spenSettingFillColorInfo)) {
            return;
        }
        this.mCurFillColorInfo = new SpenSettingFillColorInfo(spenSettingFillColorInfo);
        INSTANCE.Native_setFillColorInfo(this.nativePainting, spenSettingFillColorInfo);
    }

    public final boolean setForceStretchView(boolean enable, int width, int height) {
        if (this.nativePainting == 0 || !enable) {
            return false;
        }
        float canvasWidth = getCanvasWidth();
        if (canvasWidth > 0.0f) {
            this.mStretchRatio.x = width / canvasWidth;
        }
        float canvasHeight = getCanvasHeight();
        if (canvasHeight > 0.0f) {
            this.mStretchRatio.y = height / canvasHeight;
        }
        return INSTANCE.Native_setForceStretchView(this.nativePainting, enable, width, height);
    }

    public final boolean setFrontBufferRenderingEnabled(boolean enabled) {
        if (!this.mIsFbrSupportedFeature && enabled) {
            Log.d(TAG, "setFrontBufferRenderingEnabled false. not supported feature running");
            return false;
        }
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        if (spenLatencyConfiguration != null && spenLatencyConfiguration.getIsChromeOS()) {
            Log.d(TAG, "setFrontBufferRenderingEnabled false. Temporarily disabled for Chrome OS");
            return false;
        }
        if (this.nativePainting == 0) {
            return false;
        }
        SpenLatencyConfiguration spenLatencyConfiguration2 = this.mSpenLatencyConfiguration;
        boolean zIsFrontBufferRenderingSupported = spenLatencyConfiguration2 != null ? spenLatencyConfiguration2.isFrontBufferRenderingSupported() : false;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("setFrontBufferRenderingEnabled = ", ", (mFbrDrawPad == null) = ", ", isFBRSupported = ", enabled, this.mFbrDrawPad == null);
        sbM2230u.append(zIsFrontBufferRenderingSupported);
        Log.d(TAG, sbM2230u.toString());
        if (!enabled) {
            finalizeFbrDrawPad();
            return true;
        }
        if (this.mFbrDrawPad == null && zIsFrontBufferRenderingSupported) {
            createFbrDrawPad();
        }
        return this.mFbrDrawPad != null;
    }

    public final void setHoverScrollEnabled(boolean enabled) {
        this.mGestureController.setHoverScrollEnabled(enabled);
    }

    public final void setHoverScrollOption(long responseTime, float velocity, int margin) {
        this.mGestureController.setHoverScrollOption(responseTime, velocity, margin);
    }

    public final void setIsFbrSupportedFeature(boolean isFbrSupportedFeature) {
        this.mIsFbrSupportedFeature = isFbrSupportedFeature;
    }

    public final boolean setLayerBitmap(@Nullable Bitmap bitmap, @Nullable RectF dstRect, int fullBitmapWidth, int fullBitmapHeight, boolean isClear) {
        if (this.nativePainting == 0 || dstRect == null || dstRect.isEmpty()) {
            return false;
        }
        return INSTANCE.Native_setLayerBitmap(this.nativePainting, bitmap, dstRect, fullBitmapWidth, fullBitmapHeight, isClear);
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setMargin(left, top, right, bottom);
    }

    public final boolean setMaxZoomScale(float scale) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return false;
        }
        return deltaZoom.setMaxZoomScale(scale);
    }

    public final boolean setMinZoomScale(float scale) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return false;
        }
        return deltaZoom.setMinZoomScale(scale);
    }

    public final void setMouseWheelZoomEnabled(boolean wheelZoomEnabled) {
        this.mMouseWheelZoomEnabled = wheelZoomEnabled;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final synchronized boolean setPaintingDoc(@Nullable SpenPaintingDoc paintingDoc, boolean isUpdate) {
        if (this.nativePainting == 0) {
            Log.e(TAG, "Native canvas is null!");
            return false;
        }
        if (paintingDoc == null) {
            Log.e(TAG, "setPaintingDoc is closed");
            INSTANCE.Native_setPaintingDoc(this.nativePainting, null, isUpdate);
            this.paintingDoc = null;
            return false;
        }
        if (paintingDoc.equals(this.paintingDoc)) {
            Log.e(TAG, "setPaintingDoc is same");
            return true;
        }
        this.paintingDoc = paintingDoc;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.mContext.getResources().getDrawable(C7932R.drawable.paper_kent_depthmap);
        this.mDepthDrawable = bitmapDrawable;
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        this.mDepthBitmap = bitmap;
        Companion companion = INSTANCE;
        companion.Native_setPaperDepthMap(this.nativePainting, bitmap);
        if (!companion.Native_setPaintingDoc(this.nativePainting, paintingDoc, isUpdate)) {
            Log.e(TAG, "setPaintingDoc failed");
            this.paintingDoc = null;
            return false;
        }
        if (this.isPaperEnabled) {
            this.mPaperDrawable = null;
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.mContext.getResources().getDrawable(C7932R.drawable.paper_kent);
            this.mPaperDrawable = bitmapDrawable2;
            this.mPaperBitmap = null;
            this.mPaperBitmap = bitmapDrawable2 != null ? bitmapDrawable2.getBitmap() : null;
            setColoringForegroundEnabled(true);
            setSketchImage(this.mPaperBitmap, 3, 100);
        }
        SpenPenSound spenPenSound = this.mPenSound;
        if (spenPenSound != null) {
            spenPenSound.registerPenSoundSolution();
        }
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        initPenSoundInfo(spenPaintingViewCore != null ? spenPaintingViewCore.getPenStyle() : null);
        return true;
    }

    public final void setPan(@Nullable PointF pointF) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setPan(pointF);
    }

    public final void setPaperEnabled(boolean z) {
        this.isPaperEnabled = z;
    }

    public final void setPenChangeListener(@Nullable SpenPenChangeListener listener) {
        this.mPenChangeListener = listener;
    }

    public final void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        if (this.nativePainting == 0 || spenSettingPenInfo == null || this.mCurPenInfo.equals(spenSettingPenInfo)) {
            return;
        }
        int i = spenSettingPenInfo.sizeLevel;
        if (i != 0) {
            float fConvertSizeLevelToDpSize = SpenPenUtil.convertSizeLevelToDpSize(this.mContext, spenSettingPenInfo.name, i);
            spenSettingPenInfo.size = fConvertSizeLevelToDpSize;
            AbstractC4539a.m3205o("setPenSettingInfo size2=", TAG, fConvertSizeLevelToDpSize);
        }
        this.mCurPenInfo = new SpenSettingPenInfo(spenSettingPenInfo);
        applyPenSettingInfo(spenSettingPenInfo);
    }

    public final void setPreTouchListener(@Nullable SpenTouchListener preTouchListener) {
        this.mPreTouchListener = preTouchListener;
    }

    public final void setPredictionEnabled(boolean z) {
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        Integer numValueOf = spenLatencyConfiguration != null ? Integer.valueOf(spenLatencyConfiguration.getSupportPrediction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return;
        }
        this.mIsPredictionEnabled = z;
        if (this.nativePainting == 0 || numValueOf == null) {
            return;
        }
        INSTANCE.Native_setPredictionType(this.nativePainting, numValueOf.intValue());
    }

    public final void setScreenOrientation(int orientation) {
        synchronized (this) {
            try {
                if (this.nativePainting == 0) {
                    return;
                }
                SpenDisplay spenDisplay = this.mDisplay;
                if (spenDisplay != null) {
                    spenDisplay.updateScreenOrientation(this.mContext);
                }
                Log.i(TAG, "onOrientationChanged, orientation = " + orientation);
                Object systemService = this.mContext.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                INSTANCE.Native_setScreenOrientation(this.nativePainting, ((WindowManager) systemService).getDefaultDisplay().getRotation());
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean setSketchImage(@Nullable Bitmap bitmap, int stretchMode, int opacity) {
        long j = this.nativePainting;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setSketchImage(j, bitmap, stretchMode, opacity);
    }

    public final void setToolTipEnabled(boolean z) {
        AbstractC6670b.m4759t("setToolTipEnabled=", TAG, z);
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointer;
        if (spenHoverPointerIcon != null) {
            spenHoverPointerIcon.setToolTipEnabled(z);
        }
    }

    public final void setToolTypeAction(int toolType, int action) {
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore != null) {
            spenPaintingViewCore.setToolTypeAction(toolType, action);
        }
    }

    public final void setTouchListener(@Nullable SpenTouchListener touchListener) {
        this.mTouchListener = touchListener;
    }

    public final void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.mTouchMargin.set(marginLeft, marginTop, marginRight, marginBottom);
        if (this.mTouchMargin.isEmpty()) {
            return;
        }
        updateAllowTouchRect();
    }

    public final void setZoomListener(@Nullable SpenZoomListener listener) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setZoomListener(listener);
    }

    public final void setZoomScale(float scale, float centerX, float centerY) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setZoomScale(scale, centerX, centerY);
    }

    public final void setZoomable(boolean z) {
        SpenDeltaZoom deltaZoom;
        SpenPaintingViewCore spenPaintingViewCore = this.mViewCore;
        if (spenPaintingViewCore == null || (deltaZoom = spenPaintingViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setZoomable(z);
    }

    public final void startActionMode() {
        Log.d(TAG, "startActionMode");
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.startActionMode();
        }
    }

    public final void stopActionMode() {
        Log.d(TAG, "stopActionMode");
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.hideContextMenu();
        }
    }

    public final void update() {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_update(j);
    }

    public final void updateRedo(@Nullable SpenHistoryUpdateInfo[] userDataList) {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        if (userDataList == null || userDataList.length == 0) {
            Log.e(TAG, "The parameter 'userDataList' cannot be null.");
        } else {
            INSTANCE.Native_updateRedo(j, userDataList, userDataList.length);
        }
    }

    public final void updateUndo(@Nullable SpenHistoryUpdateInfo[] userDataList) {
        long j = this.nativePainting;
        if (j == 0) {
            return;
        }
        if (userDataList == null || userDataList.length == 0) {
            Log.e(TAG, "The parameter 'userDataList' cannot be null.");
        } else {
            INSTANCE.Native_updateUndo(j, userDataList, userDataList.length);
        }
    }

    public final boolean setLayerBitmap(@Nullable Bitmap bitmap, int wrappingmode, boolean isClear) {
        long j = this.nativePainting;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setLayerBitmap(j, bitmap, wrappingmode, isClear);
    }
}
