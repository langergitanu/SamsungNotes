package com.samsung.android.sdk.pen.engine.writingview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.Pair;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.base.SpenObjectFindType;
import com.samsung.android.sdk.pen.control.SpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.engine.ListenerManager;
import com.samsung.android.sdk.pen.engine.SpenGestureController;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.sdk.pen.engine.SpenViewCore;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenDeltaZoom;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenu;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sdk.pen.view.gesture.SpenGesture;
import com.samsung.android.sdk.pen.widget.SpenTextManager;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
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
@Metadata(m13885d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0088\u00022\u00020\u0001:\u0002\u0088\u0002B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010s\u001a\u00020tJ\u0010\u0010u\u001a\u00020t2\b\u0010v\u001a\u0004\u0018\u00010.J\u000e\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020yJ\u000e\u0010z\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020yJ\u000e\u0010{\u001a\u00020t2\u0006\u0010|\u001a\u00020\u000bJ\u000e\u0010}\u001a\u00020t2\u0006\u0010A\u001a\u00020\u000bJ\u001f\u0010~\u001a\u00020t2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\tJ4\u0010\u0081\u0001\u001a\u00020t2\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\tJ\u0010\u0010\u0087\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0010\u0010\u0089\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0010\u0010\u008a\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0007\u0010\u008b\u0001\u001a\u00020\u000bJ\u0007\u0010\u008c\u0001\u001a\u00020\u000bJ\u0007\u0010\u008d\u0001\u001a\u00020\u000bJ\u0007\u0010\u008e\u0001\u001a\u00020\u000bJ\u0010\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\tJ\u000f\u0010\u0091\u0001\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\tJ\u0010\u0010\u0092\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0010\u0010\u0093\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\"\u0010\u0094\u0001\u001a\u00020t2\u0007\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0096\u0001\u001a\u00020R2\u0007\u0010\u0097\u0001\u001a\u00020\tJ\u0010\u0010\u0098\u0001\u001a\u00020t2\u0007\u0010\u0099\u0001\u001a\u00020\tJ\u0012\u0010\u009a\u0001\u001a\u00020t2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u009c\u0001\u001a\u00020t2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u009d\u0001\u001a\u00020t2\u0007\u0010\u009e\u0001\u001a\u00020\u000bJ\u0007\u0010\u009f\u0001\u001a\u00020tJ\u0007\u0010 \u0001\u001a\u00020tJ\u0007\u0010¡\u0001\u001a\u00020tJ\u0012\u0010¢\u0001\u001a\u00020\u000b2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010¤\u0001\u001a\u00020t2\u0007\u0010¥\u0001\u001a\u00020\tJ\u0010\u0010¦\u0001\u001a\u00020t2\u0007\u0010§\u0001\u001a\u00020\tJ1\u0010¨\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010®\u0001\u001a\u00020\tJ1\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010®\u0001\u001a\u00020\tJ1\u0010±\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010®\u0001\u001a\u00020\tJ4\u0010²\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\tJ4\u0010´\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\tJ=\u0010µ\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010¶\u0001\u001a\u00020\u000bJ(\u0010·\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010¬\u0001\u001a\u00020\t2\u0007\u0010\u00ad\u0001\u001a\u00020\tJ\u0010\u0010¸\u0001\u001a\u00020t2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010º\u0001\u001a\u00020t2\u0007\u0010»\u0001\u001a\u00020\u000bJ+\u0010¼\u0001\u001a\u00020t2\u0007\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020R2\u0007\u0010\u0085\u0001\u001a\u00020R2\u0007\u0010\u0086\u0001\u001a\u00020RJ+\u0010½\u0001\u001a\u00020t2\u0007\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020R2\u0007\u0010\u0085\u0001\u001a\u00020R2\u0007\u0010\u0086\u0001\u001a\u00020RJ\u0010\u0010¾\u0001\u001a\u00020t2\u0007\u0010¿\u0001\u001a\u00020RJ\"\u0010À\u0001\u001a\u00020t2\u0007\u0010¿\u0001\u001a\u00020R2\u0007\u0010Á\u0001\u001a\u00020R2\u0007\u0010Â\u0001\u001a\u00020RJ\u0010\u0010Ã\u0001\u001a\u00020\u000b2\u0007\u0010Ä\u0001\u001a\u00020RJ\u0010\u0010Å\u0001\u001a\u00020\u000b2\u0007\u0010Ä\u0001\u001a\u00020RJ\u0010\u0010Æ\u0001\u001a\u00020t2\u0007\u0010Ç\u0001\u001a\u00020\tJ.\u0010È\u0001\u001a\u00020t2\n\u0010É\u0001\u001a\u0005\u0018\u00010©\u00012\u0007\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\tJ\u0010\u0010Í\u0001\u001a\u00020t2\u0007\u0010Ç\u0001\u001a\u00020\tJ.\u0010Î\u0001\u001a\u00020t2\n\u0010É\u0001\u001a\u0005\u0018\u00010©\u00012\u0007\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\tJ7\u0010Î\u0001\u001a\u00020t2\n\u0010É\u0001\u001a\u0005\u0018\u00010©\u00012\u0007\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\t2\u0007\u0010Ï\u0001\u001a\u00020\u000bJ%\u0010Ð\u0001\u001a\u00020t2\n\u0010É\u0001\u001a\u0005\u0018\u00010©\u00012\u0007\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010Ñ\u0001\u001a\u00020\tJ\u0019\u0010Ò\u0001\u001a\u00020t2\u0007\u0010Ó\u0001\u001a\u00020\t2\u0007\u0010Ô\u0001\u001a\u00020\tJ\u0010\u0010Õ\u0001\u001a\u00020\t2\u0007\u0010Ó\u0001\u001a\u00020\tJ\u0013\u0010Ö\u0001\u001a\u00020t2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001J\u001e\u0010Ù\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\f\u0010Ú\u0001\u001a\u00030Û\u0001\"\u00020\u000bJ\u0010\u0010Ü\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0013\u0010Ý\u0001\u001a\u00020\u000b2\n\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u0001J\u001d\u0010à\u0001\u001a\u00020t2\u0006\u0010A\u001a\u00020\u000b2\f\u0010Ú\u0001\u001a\u00030Û\u0001\"\u00020\u000bJ\u001d\u0010á\u0001\u001a\u00020t2\u0006\u0010A\u001a\u00020\u000b2\f\u0010Ú\u0001\u001a\u00030Û\u0001\"\u00020\u000bJ\u0013\u0010â\u0001\u001a\u00020t2\n\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u0001J\u0012\u0010å\u0001\u001a\u00020t2\t\u0010ã\u0001\u001a\u0004\u0018\u00010<J\u0013\u0010æ\u0001\u001a\u00020t2\n\u0010ã\u0001\u001a\u0005\u0018\u00010ç\u0001J\u001b\u0010è\u0001\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\t2\t\u0010x\u001a\u0005\u0018\u00010ê\u0001J\u001b\u0010ë\u0001\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\t2\t\u0010x\u001a\u0005\u0018\u00010ê\u0001J\u0019\u0010ì\u0001\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\t2\u0007\u0010x\u001a\u00030ê\u0001J\u0019\u0010í\u0001\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\t2\u0007\u0010x\u001a\u00030ê\u0001J\u0014\u0010î\u0001\u001a\u0005\u0018\u00010ï\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001J.\u0010ò\u0001\u001a\u00020t2\u001b\u0010ó\u0001\u001a\u0016\u0012\u0005\u0012\u00030õ\u00010ô\u0001j\n\u0012\u0005\u0012\u00030õ\u0001`ö\u00012\b\u0010÷\u0001\u001a\u00030ø\u0001J\u0013\u0010ù\u0001\u001a\u00020\u000b2\n\u0010ú\u0001\u001a\u0005\u0018\u00010õ\u0001J\u0011\u0010û\u0001\u001a\u00020t2\u0006\u0010x\u001a\u00020yH\u0002J\u001a\u0010ü\u0001\u001a\u00020t2\u0006\u0010x\u001a\u00020y2\u0007\u0010ý\u0001\u001a\u00020\tH\u0002J\u001a\u0010þ\u0001\u001a\u00020t2\u0006\u0010x\u001a\u00020y2\u0007\u0010ý\u0001\u001a\u00020\tH\u0002J\t\u0010ÿ\u0001\u001a\u00020tH\u0002J$\u0010\u0080\u0002\u001a\u00020t2\u0007\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0002\u001a\u00020R2\u0007\u0010\u0082\u0002\u001a\u00020RH\u0002J\u0012\u0010\u0083\u0002\u001a\u00020t2\u0007\u0010Ç\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0084\u0002\u001a\u00020t2\u0007\u0010Ç\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0085\u0002\u001a\u00020t2\u0007\u0010\u0086\u0002\u001a\u00020\tH\u0002J\t\u0010\u0087\u0002\u001a\u00020tH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010DR(\u0010F\u001a\u0004\u0018\u00010(2\b\u0010E\u001a\u0004\u0018\u00010(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010L\u001a\u0004\u0018\u00010K2\b\u0010E\u001a\u0004\u0018\u00010K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bV\u0010TR$\u0010W\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\u001b\"\u0004\bX\u0010DR$\u0010Y\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010\u001b\"\u0004\bZ\u0010DR\u0011\u0010[\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\b\\\u0010TR\u0011\u0010]\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\b^\u0010TR\u0011\u0010_\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\b`\u0010TR(\u0010c\u001a\u0004\u0018\u00010b2\b\u0010a\u001a\u0004\u0018\u00010b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR(\u0010h\u001a\u0004\u0018\u00010b2\b\u0010h\u001a\u0004\u0018\u00010b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR(\u0010m\u001a\u0004\u0018\u00010l2\b\u0010k\u001a\u0004\u0018\u00010l8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0011\u0010r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\br\u0010\u001b¨\u0006\u0089\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewImpl;", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "drawingType", "", "isAsyncDrawing", "", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;IZ)V", "nativeView", "", "mView", "mParentLayout", "Landroid/view/ViewGroup;", "mNativeContext", "Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewContext;", "mViewCore", "Lcom/samsung/android/sdk/pen/engine/SpenViewCore;", "mFbrDrawPad", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad;", "value", "isPredictionEnabled", "()Z", "mDocument", "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "mGestureController", "Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "mIsPenButtonEnabledAtActionDown", "mContext", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "mDrawLoop", "mPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "mHoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "mRemoverToastMessage", "Landroid/widget/Toast;", "mListenerManager", "Lcom/samsung/android/sdk/pen/engine/ListenerManager;", "mPenSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "mViewWidth", "mViewHeight", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "setControlObjectManager", "(Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;)V", "mContextMenu", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenu;", "mContextMenuListener", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "mSpenLatencyConfiguration", "Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "mTextManager", "Lcom/samsung/android/sdk/pen/widget/SpenTextManager;", "enable", "isToolTipEnabled", "setToolTipEnabled", "(Z)V", "info", "penSettingInfo", "getPenSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "removerSettingInfo", "getRemoverSettingInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverSettingInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "scaleX", "", "getScaleX", "()F", "scaleY", "getScaleY", "isZoomable", "setZoomable", "isScrollable", "setScrollable", "zoomScale", "getZoomScale", "maxZoomScale", "getMaxZoomScale", "minZoomScale", "getMinZoomScale", "position", "Landroid/graphics/PointF;", "pan", "getPan", "()Landroid/graphics/PointF;", "setPan", "(Landroid/graphics/PointF;)V", "delta", "getDelta", "setDelta", "pMatrix", "Landroid/graphics/Matrix;", "contentMatrix", "getContentMatrix", "()Landroid/graphics/Matrix;", "setContentMatrix", "(Landroid/graphics/Matrix;)V", "isNativeViewValid", "close", "", "setListenerManager", "listenerManager", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onHoverEvent", "setDarkMode", "isDartMode", "setHapticSoundEnabled", "setStretchContentSize", "width", "height", "onLayout", "changed", "left", "top", "right", "bottom", "setLongPressEnabled", "enabled", "setHoldLongPressEnabled", "setStrokeToShapeEnabled", "startReplay", "stopReplay", "resumeReplay", "pauseReplay", "setReplaySpeed", "speed", "setReplayPosition", "setEdgeEffectEnabled", "setHoverScrollEnabled", "setHoverScrollOption", "responseTime", "velocity", "margin", "setScreenOrientation", "orientation", "onAttachedToWindow", "parent", "onDetachedFromWindow", "onWindowFocusChanged", "hasWindowFocus", "onPause", "onResume", "onTrimMemory", "setDocument", ExternalDataConstants.DOCUMENT_TABLE_NAME, "setObjectTypeFilter", "typeFilter", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "captureView", "Landroid/graphics/Bitmap;", "src", "Landroid/graphics/Rect;", "dstWidth", "dstHeight", "option", "captureViewWithRawData", "", "captureContent", "captureContentWithStrokeMask", "backgroundBitmap", "captureOriginalContentWithStrokeMask", "captureObject", "isHighlighter", "captureMosaicMask", "setSelectionType", "type", "setIntersectSelection", "intersect", "setMargin", "setContentRect", "setContentScale", WiggleAnimationConfig.KEY_SCALE, "setZoomScale", "pivotX", "pivotY", "setMaxZoomScale", "ratio", "setMinZoomScale", "setBackgroundColor", "color", "setBackgroundBitmap", "bitmap", "gravity", "tileModeX", "tileModeY", "setContentBackgroundColor", "setContentBackgroundBitmap", "includeAsMosaicBackground", "setContentTransparentBackgroundImage", "tileMode", "setToolTypeAction", "toolType", "action", "getToolTypeAction", "setTouchUpMode", "mode", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad$TouchUpMode;", "setFrontBufferRenderingEnabled", NotesSyncRpcProvider.FORCE_SYNC, "", "setInputMethodServiceInkWindowMode", "setFrontBufferRenderingCaptureWindow", "window", "Landroid/view/Window;", "setPredictionEnabled", "setUnbufferedDispatchEnabled", "setZoomListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "setContextMenuListener", "setSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "appendDoodleObject", "strokes", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "Lkotlin/collections/ArrayList;", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "convertStrokeToShape", "stroke", "convertMotionEventPenButtonAction", "onPreTouch", "toolTypeAction", "onPostTouch", "finalizeFbrDrawPad", "onColorPicked", "x", "y", "onStrokeAdded", "onStrokeStyleChanged", "onMaxStrokeCountIsOverflowed", "maxStrokeCount", "onHighlighterRemoverTouchesNormalStroke", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWritingViewImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWritingViewImpl.kt\ncom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1088:1\n1#2:1089\n*E\n"})
public final class SpenWritingViewImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float MIN_STROKE_LENGTH = 15.0f;

    @NotNull
    private static final String TAG = "SpenWritingViewImpl";
    private static final int U_OS = 34;

    @NotNull
    private SpenControlObjectManager controlObjectManager;
    private boolean isPredictionEnabled;

    @NotNull
    private SpenConfiguration mConfiguration;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenContextMenu mContextMenu;

    @Nullable
    private SpenContextMenuListener mContextMenuListener;

    @NotNull
    private SpenDisplay mDisplay;

    @Nullable
    private SpenWritingDocument mDocument;

    @Nullable
    private final SpenDrawLoopInterface mDrawLoop;

    @Nullable
    private SpenFbrDrawPad mFbrDrawPad;

    @NotNull
    private SpenGestureController mGestureController;

    @NotNull
    private SpenHoverPointerIcon mHoverPointerIcon;
    private boolean mIsPenButtonEnabledAtActionDown;

    @Nullable
    private ListenerManager mListenerManager;

    @Nullable
    private SpenWritingViewContext mNativeContext;

    @Nullable
    private ViewGroup mParentLayout;

    @NotNull
    private final SpenSettingPenInfo mPenInfo;

    @NotNull
    private SpenPenSound mPenSound;

    @NotNull
    private Toast mRemoverToastMessage;

    @NotNull
    private final SpenLatencyConfiguration mSpenLatencyConfiguration;

    @NotNull
    private final SpenTextManager mTextManager;

    @NotNull
    private final View mView;

    @NotNull
    private SpenViewCore mViewCore;
    private int mViewHeight;
    private int mViewWidth;
    private long nativeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0019\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0083 J\u0019\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\tH\u0083 J+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0083 J+\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0083 J9\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0083 J\u0011\u0010,\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010-\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010.\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u001b\u0010/\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0083 J\u001b\u00102\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0083 J\u0019\u00103\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0017H\u0083 J)\u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\tH\u0083 J\u0011\u00109\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010:\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010;\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0019\u0010<\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\tH\u0083 J;\u0010>\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0083 J\u0019\u0010B\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\tH\u0083 JC\u0010C\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0017H\u0083 J3\u0010E\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010?\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0083 J\u0019\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0083 J\u0011\u0010K\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010L\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0019\u0010M\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\tH\u0083 J\u0019\u0010O\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u0017H\u0083 J\u0019\u0010Q\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bH\u0083 J\u0019\u0010S\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\tH\u0083 J\u0019\u0010T\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0017H\u0083 J\u0019\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0083 J\u0019\u0010Y\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bH\u0083 J\u0011\u0010[\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000bH\u0083 J\u0019\u0010\\\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0017H\u0083 J\u0011\u0010]\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010^\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010_\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0011\u0010`\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bH\u0083 J\u0019\u0010a\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\tH\u0083 J\u0019\u0010c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\tH\u0083 J1\u0010e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0083 J1\u0010f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MIN_STROKE_LENGTH", "", "U_OS", "", "Native_init", "", "viewImpl", "Lcom/samsung/android/sdk/pen/engine/writingview/SpenWritingViewImpl;", "spenDrawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "hoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "penSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "contextHandle", "drawingType", "isAsyncDrawing", "", "Native_finalize", "", "nativeView", "Native_setDocument", "nativeDocument", "Native_setObjectTypeFilter", "typeFilter", "Native_captureView", "bitmap", "Landroid/graphics/Bitmap;", "src", "Landroid/graphics/Rect;", "option", "Native_captureContent", "Native_onLayout", "changed", "left", "top", "right", "bottom", "Native_getViewCore", "Native_getGestureController", "Native_isHapticSoundNeeded", "Native_onTouch", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_onHover", "Native_setHoverScrollEnabled", "enabled", "Native_setHoverScrollOption", "responseTime", "velocity", "margin", "Native_onResume", "Native_onPause", "Native_onTrimMemory", "Native_setBackgroundColor", "color", "Native_setBackgroundBitmap", "gravity", "tileModeX", "tileModeY", "Native_setContentBackgroundColor", "Native_setContentBackgroundBitmap", "includeAsMosaicBackground", "Native_setContentTransparentBackgroundImage", "tileMode", "Native_setRemoverSettingInfo", "nativeVIew", "info", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "Native_getRemoverType", "Native_getRemoverSize", "Native_setSelectionType", "type", "Native_setIntersectSelection", "intersect", "Native_setFbrDrawPad", "nativeDrawPad", "Native_setPredictionType", "Native_setPredictionEnabled", "enable", "Native_setControlObjectManager", "nativeHandle", "controlObjectManager", "Native_setContextMenu", "contextMenu", "Native_getTextManager", "Native_setStrokeToShapeEnabled", "Native_startReplay", "Native_stopReplay", "Native_resumeReplay", "Native_pauseReplay", "Native_setReplaySpeed", "speed", "Native_setReplayPosition", "position", "Native_setVisibleViewRect", "Native_setVisibleScreenRect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureContent(long nativeView, Bitmap bitmap, Rect src, int option) {
            return SpenWritingViewImpl.Native_captureContent(nativeView, bitmap, src, option);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureView(long nativeView, Bitmap bitmap, Rect src, int option) {
            return SpenWritingViewImpl.Native_captureView(nativeView, bitmap, src, option);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeView) {
            SpenWritingViewImpl.Native_finalize(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getGestureController(long nativeView) {
            return SpenWritingViewImpl.Native_getGestureController(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getRemoverSize(long nativeView) {
            return SpenWritingViewImpl.Native_getRemoverSize(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getRemoverType(long nativeView) {
            return SpenWritingViewImpl.Native_getRemoverType(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getTextManager(long nativeHandle) {
            return SpenWritingViewImpl.Native_getTextManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getViewCore(long nativeView) {
            return SpenWritingViewImpl.Native_getViewCore(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenWritingViewImpl viewImpl, SpenDrawLoopInterface spenDrawLoop, SpenHoverPointerIcon hoverPointerIcon, SpenPenSound penSound, long contextHandle, int drawingType, boolean isAsyncDrawing) {
            return SpenWritingViewImpl.Native_init(viewImpl, spenDrawLoop, hoverPointerIcon, penSound, contextHandle, drawingType, isAsyncDrawing);
        }

        @JvmStatic
        private final boolean Native_isHapticSoundNeeded(long nativeView) {
            return SpenWritingViewImpl.Native_isHapticSoundNeeded(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHover(long nativeView, SpenMotionEvent event) {
            return SpenWritingViewImpl.Native_onHover(nativeView, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onLayout(long nativeView, boolean changed, int left, int top, int right, int bottom) {
            SpenWritingViewImpl.Native_onLayout(nativeView, changed, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeView) {
            SpenWritingViewImpl.Native_onPause(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeView) {
            SpenWritingViewImpl.Native_onResume(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onTouch(long nativeView, SpenMotionEvent event) {
            return SpenWritingViewImpl.Native_onTouch(nativeView, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onTrimMemory(long nativeView) {
            SpenWritingViewImpl.Native_onTrimMemory(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_pauseReplay(long nativeView) {
            return SpenWritingViewImpl.Native_pauseReplay(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_resumeReplay(long nativeView) {
            return SpenWritingViewImpl.Native_resumeReplay(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setBackgroundBitmap(long nativeView, long contextHandle, Bitmap bitmap, int gravity, int tileModeX, int tileModeY) {
            SpenWritingViewImpl.Native_setBackgroundBitmap(nativeView, contextHandle, bitmap, gravity, tileModeX, tileModeY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setBackgroundColor(long nativeView, int color) {
            SpenWritingViewImpl.Native_setBackgroundColor(nativeView, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentBackgroundBitmap(long nativeView, long contextHandle, Bitmap bitmap, int gravity, int tileModeX, int tileModeY, boolean includeAsMosaicBackground) {
            SpenWritingViewImpl.Native_setContentBackgroundBitmap(nativeView, contextHandle, bitmap, gravity, tileModeX, tileModeY, includeAsMosaicBackground);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentBackgroundColor(long nativeView, int color) {
            SpenWritingViewImpl.Native_setContentBackgroundColor(nativeView, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContentTransparentBackgroundImage(long nativeView, long contextHandle, Bitmap bitmap, int gravity, int tileMode) {
            SpenWritingViewImpl.Native_setContentTransparentBackgroundImage(nativeView, contextHandle, bitmap, gravity, tileMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContextMenu(long nativeHandle, long contextMenu) {
            SpenWritingViewImpl.Native_setContextMenu(nativeHandle, contextMenu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setControlObjectManager(long nativeHandle, long controlObjectManager) {
            SpenWritingViewImpl.Native_setControlObjectManager(nativeHandle, controlObjectManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeView, long nativeDocument) {
            return SpenWritingViewImpl.Native_setDocument(nativeView, nativeDocument);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFbrDrawPad(long nativeView, long nativeDrawPad) {
            SpenWritingViewImpl.Native_setFbrDrawPad(nativeView, nativeDrawPad);
        }

        @JvmStatic
        private final void Native_setHoverScrollEnabled(long nativeView, boolean enabled) {
            SpenWritingViewImpl.Native_setHoverScrollEnabled(nativeView, enabled);
        }

        @JvmStatic
        private final void Native_setHoverScrollOption(long nativeView, long responseTime, float velocity, int margin) {
            SpenWritingViewImpl.Native_setHoverScrollOption(nativeView, responseTime, velocity, margin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setIntersectSelection(long nativeView, boolean intersect) {
            SpenWritingViewImpl.Native_setIntersectSelection(nativeView, intersect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setObjectTypeFilter(long nativeView, int typeFilter) {
            SpenWritingViewImpl.Native_setObjectTypeFilter(nativeView, typeFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPredictionEnabled(long nativeView, boolean enable) {
            SpenWritingViewImpl.Native_setPredictionEnabled(nativeView, enable);
        }

        @JvmStatic
        private final void Native_setPredictionType(long nativeView, int type) {
            SpenWritingViewImpl.Native_setPredictionType(nativeView, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRemoverSettingInfo(long nativeVIew, SpenSettingRemoverInfo info) {
            SpenWritingViewImpl.Native_setRemoverSettingInfo(nativeVIew, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setReplayPosition(long nativeView, int position) {
            return SpenWritingViewImpl.Native_setReplayPosition(nativeView, position);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setReplaySpeed(long nativeView, int speed) {
            return SpenWritingViewImpl.Native_setReplaySpeed(nativeView, speed);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionType(long nativeView, int type) {
            SpenWritingViewImpl.Native_setSelectionType(nativeView, type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setStrokeToShapeEnabled(long nativeHandle, boolean enabled) {
            SpenWritingViewImpl.Native_setStrokeToShapeEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVisibleScreenRect(long nativeView, int left, int top, int right, int bottom) {
            SpenWritingViewImpl.Native_setVisibleScreenRect(nativeView, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVisibleViewRect(long nativeView, int left, int top, int right, int bottom) {
            SpenWritingViewImpl.Native_setVisibleViewRect(nativeView, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_startReplay(long nativeView) {
            return SpenWritingViewImpl.Native_startReplay(nativeView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_stopReplay(long nativeView) {
            return SpenWritingViewImpl.Native_stopReplay(nativeView);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SpenWritingViewImpl(@Nullable Context context, @NotNull View view, @Nullable SpenDrawLoopInterface spenDrawLoopInterface, int i, boolean z) {
        long jLongValue;
        Intrinsics.checkNotNullParameter(view, "view");
        Log.d(TAG, "construct");
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        SpenResources.INSTANCE.setResources(context.getResources());
        this.mContext = context;
        this.mView = view;
        this.mDrawLoop = spenDrawLoopInterface;
        this.mPenInfo = new SpenSettingPenInfo();
        this.mDisplay = new SpenDisplay(context);
        this.mConfiguration = new SpenConfiguration(context);
        this.mNativeContext = spenDrawLoopInterface != null ? new SpenWritingViewContext(context, spenDrawLoopInterface.getMsgQueueHandle(), this.mDisplay, this.mConfiguration, spenDrawLoopInterface.getRendererType()) : null;
        SpenHoverPointerIcon spenHoverPointerIcon = new SpenHoverPointerIcon(context, view);
        this.mHoverPointerIcon = spenHoverPointerIcon;
        spenHoverPointerIcon.setPenIconStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_LINE);
        SpenPenSound spenPenSound = new SpenPenSound(context);
        this.mPenSound = spenPenSound;
        if (spenDrawLoopInterface == null) {
            jLongValue = 0;
        } else {
            SpenWritingViewContext spenWritingViewContext = this.mNativeContext;
            Long lValueOf = spenWritingViewContext != null ? Long.valueOf(INSTANCE.Native_init(this, spenDrawLoopInterface, this.mHoverPointerIcon, spenPenSound, spenWritingViewContext.getHandle(), i, z)) : null;
            if (lValueOf != null) {
                jLongValue = lValueOf.longValue();
            }
        }
        this.nativeView = jLongValue;
        Log.d(TAG, "nativeView = " + jLongValue);
        if (this.nativeView == 0) {
            SpenError.ThrowUncheckedException(8, " : nativeView must not be null");
        }
        Companion companion = INSTANCE;
        this.mViewCore = new SpenViewCore(context, companion.Native_getViewCore(this.nativeView));
        this.mGestureController = new SpenGestureController(companion.Native_getGestureController(this.nativeView));
        this.mRemoverToastMessage = new Toast(context);
        SpenControlObjectManager spenControlObjectManager = new SpenControlObjectManager();
        this.controlObjectManager = spenControlObjectManager;
        companion.Native_setControlObjectManager(this.nativeView, spenControlObjectManager.getNativeHandle());
        SpenContextMenu spenContextMenu = new SpenContextMenu(view);
        this.mContextMenu = spenContextMenu;
        companion.Native_setContextMenu(this.nativeView, spenContextMenu.getNativeContextMenu());
        this.mSpenLatencyConfiguration = new SpenLatencyConfiguration(context);
        setFrontBufferRenderingEnabled(true, false);
        setPredictionEnabled(true, false);
        setObjectTypeFilter(SpenObjectFindType.ALL);
        SpenTextManager spenTextManager = new SpenTextManager(view);
        this.mTextManager = spenTextManager;
        spenTextManager.setNativeHandle(companion.Native_getTextManager(this.nativeView));
        spenTextManager.setEditable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureContent(long j, Bitmap bitmap, Rect rect, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureView(long j, Bitmap bitmap, Rect rect, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getGestureController(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getRemoverSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getRemoverType(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getTextManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getViewCore(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenWritingViewImpl spenWritingViewImpl, SpenDrawLoopInterface spenDrawLoopInterface, SpenHoverPointerIcon spenHoverPointerIcon, SpenPenSound spenPenSound, long j, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHapticSoundNeeded(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHover(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onLayout(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onResume(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onTouch(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onTrimMemory(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_pauseReplay(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_resumeReplay(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setBackgroundBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setBackgroundColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentBackgroundBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i4, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentBackgroundColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContentTransparentBackgroundImage(long j, long j2, Bitmap bitmap, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContextMenu(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setControlObjectManager(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFbrDrawPad(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoverScrollEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoverScrollOption(long j, long j2, float f, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setIntersectSelection(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setObjectTypeFilter(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRemoverSettingInfo(long j, SpenSettingRemoverInfo spenSettingRemoverInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setReplayPosition(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setReplaySpeed(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setStrokeToShapeEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVisibleScreenRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVisibleViewRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_startReplay(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_stopReplay(long j);

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

    private final void finalizeFbrDrawPad() {
        ViewGroup viewGroup;
        Log.d(TAG, "finalizeFbrDrawPad() start");
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            long j = this.nativeView;
            if (j != 0) {
                INSTANCE.Native_setFbrDrawPad(j, 0L);
            }
            if (spenFbrDrawPad.getParent() != null && (viewGroup = this.mParentLayout) != null) {
                viewGroup.removeView(spenFbrDrawPad);
            }
            spenFbrDrawPad.close();
            this.mFbrDrawPad = null;
        }
    }

    private final void onColorPicked(int color, float x, float y2) {
        StringBuilder sbM1628r = AbstractC2322a.m1628r("onColorPicked color = %d", color, ", x = ", x, ", y = ");
        sbM1628r.append(y2);
        Log.d(TAG, sbM1628r.toString());
        int i = (color >> 24) & 255;
        int i2 = (color >> 16) & 255;
        int i4 = (color >> 8) & 255;
        int i5 = color & 255;
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onColorPicked(Color.argb(i, i5, i4, i2), x, y2);
        }
    }

    private final void onHighlighterRemoverTouchesNormalStroke() {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onHighlighterRemoverTouchesNormalStroke();
        }
    }

    private final void onMaxStrokeCountIsOverflowed(int maxStrokeCount) {
        AbstractC0541b.m755A(maxStrokeCount, "onMaxStrokeCountIsOverflowed maxStrokeCount = %d", TAG);
    }

    private final void onPostTouch(MotionEvent event, int toolTypeAction) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onTouchView(this.mView, event);
        }
    }

    private final void onPreTouch(MotionEvent event, int toolTypeAction) {
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onPreTouchView(this.mView, event);
        }
    }

    private final void onStrokeAdded(int color) {
        AbstractC0541b.m755A(color, "onStrokeAdded color = %d", TAG);
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onAddStroke(color);
        }
    }

    private final void onStrokeStyleChanged(int color) {
        AbstractC0541b.m755A(color, "onStrokeStyleChanged color = %d", TAG);
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onChangeStyle(color);
        }
    }

    public final void appendDoodleObject(@NotNull ArrayList<SpenObjectStroke> strokes, @NotNull SpenObjectShape objectShape) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
    }

    @Nullable
    public final Bitmap captureContent(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        Bitmap bitmapCreateBitmap;
        if (this.nativeView == 0 || src == null) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(dstWidth, dstHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        } catch (Throwable unused) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        if (INSTANCE.Native_captureContent(this.nativeView, bitmapCreateBitmap, src, option)) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    @Nullable
    public final Bitmap captureContentWithStrokeMask(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight) {
        return null;
    }

    @Nullable
    public final Bitmap captureMosaicMask(@Nullable Rect src, int dstWidth, int dstHeight) {
        return null;
    }

    @Nullable
    public final Bitmap captureObject(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight, boolean isHighlighter) {
        return null;
    }

    @Nullable
    public final Bitmap captureOriginalContentWithStrokeMask(@Nullable Bitmap backgroundBitmap, @Nullable Rect src, int dstWidth, int dstHeight) {
        return null;
    }

    @Nullable
    public final Bitmap captureView(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        Bitmap bitmapCreateBitmap;
        if (this.nativeView == 0 || src == null) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(dstWidth, dstHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        } catch (Throwable unused) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        if (INSTANCE.Native_captureView(this.nativeView, bitmapCreateBitmap, src, option)) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    @Nullable
    public final byte[] captureViewWithRawData(@Nullable Rect src, int dstWidth, int dstHeight, int option) {
        Log.e(TAG, "Not support captureViewWithRawData");
        return null;
    }

    public final void close() {
        Log.d(SearchConstants.TargetContents.TAG, "WritingViewImpl.close()");
        this.mTextManager.close();
        this.mSpenLatencyConfiguration.close();
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.close();
        }
        this.mContextMenu = null;
        this.controlObjectManager.close();
        this.mHoverPointerIcon.removeHoveringIcon();
        this.mHoverPointerIcon.close();
        this.mRemoverToastMessage.cancel();
        this.mPenSound.close();
        this.mViewCore.close();
        this.mConfiguration.close();
        this.mDisplay.close();
        long j = this.nativeView;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativeView = 0L;
        }
        SpenWritingViewContext spenWritingViewContext = this.mNativeContext;
        if (spenWritingViewContext != null) {
            spenWritingViewContext.close();
        }
        finalizeFbrDrawPad();
    }

    public final boolean convertStrokeToShape(@Nullable SpenObjectStroke stroke) {
        return false;
    }

    @Nullable
    public final Matrix getContentMatrix() {
        return null;
    }

    @NotNull
    public final SpenControlObjectManager getControlObjectManager() {
        return this.controlObjectManager;
    }

    @Nullable
    public final PointF getDelta() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getDelta();
        }
        return null;
    }

    public final float getMaxZoomScale() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getMaxZoomScale();
        }
        return 0.0f;
    }

    public final float getMinZoomScale() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getMinZoomScale();
        }
        return 0.0f;
    }

    @Nullable
    public final PointF getPan() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getPan();
        }
        return null;
    }

    @Nullable
    public final SpenSettingPenInfo getPenSettingInfo() {
        SpenSettingPenInfo spenSettingPenInfo = this.mPenInfo;
        String penStyle = this.mViewCore.getPenStyle();
        if (penStyle == null) {
            penStyle = "";
        }
        spenSettingPenInfo.name = penStyle;
        this.mPenInfo.size = this.mViewCore.getPenSize();
        this.mPenInfo.color = this.mViewCore.getPenColor();
        this.mPenInfo.isCurvable = this.mViewCore.isPenCurveEnabled();
        SpenSettingPenInfo spenSettingPenInfo2 = this.mPenInfo;
        String advancedPenSetting = this.mViewCore.getAdvancedPenSetting();
        spenSettingPenInfo2.advancedSetting = advancedPenSetting != null ? advancedPenSetting : "";
        return new SpenSettingPenInfo(this.mPenInfo);
    }

    @Nullable
    public final SpenSettingRemoverInfo getRemoverSettingInfo() {
        if (this.nativeView == 0) {
            return null;
        }
        SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
        Companion companion = INSTANCE;
        spenSettingRemoverInfo.type = companion.Native_getRemoverType(this.nativeView);
        spenSettingRemoverInfo.size = companion.Native_getRemoverSize(this.nativeView);
        return spenSettingRemoverInfo;
    }

    public final float getScaleX() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getScaleX();
        }
        return 0.0f;
    }

    public final float getScaleY() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getScaleY();
        }
        return 0.0f;
    }

    public final int getToolTypeAction(int toolType) {
        return this.mViewCore.getToolTypeAction(toolType);
    }

    public final float getZoomScale() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.getZoomScale();
        }
        return 0.0f;
    }

    public final boolean isNativeViewValid() {
        return this.nativeView != 0;
    }

    /* JADX INFO: renamed from: isPredictionEnabled, reason: from getter */
    public final boolean getIsPredictionEnabled() {
        return this.isPredictionEnabled;
    }

    public final boolean isScrollable() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.isScrollable();
        }
        return false;
    }

    public final boolean isToolTipEnabled() {
        return this.mHoverPointerIcon.isToolTipEnabled();
    }

    public final boolean isZoomable() {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.isZoomable();
        }
        return false;
    }

    public final void onAttachedToWindow(@Nullable ViewGroup parent) {
        if (this.nativeView == 0) {
            return;
        }
        this.mParentLayout = parent;
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null && spenFbrDrawPad.getParent() == null && parent != null) {
            parent.addView(spenFbrDrawPad);
            spenFbrDrawPad.setVisibility(4);
            spenFbrDrawPad.setZOrderOnTop(true);
        }
        Log.d(TAG, " onAttachedToWindow() nativeView=" + this.nativeView);
    }

    @Nullable
    public final InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        return this.mTextManager.onCreateInputConnection(outAttrs);
    }

    public final void onDetachedFromWindow(@Nullable ViewGroup parent) {
        if (this.nativeView == 0) {
            return;
        }
        this.mParentLayout = parent;
    }

    public final boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.nativeView == 0) {
            return false;
        }
        INSTANCE.Native_onHover(this.nativeView, new SpenMotionEvent(event));
        return true;
    }

    public final boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        SpenTextManager spenTextManager = this.mTextManager;
        Intrinsics.checkNotNull(event);
        return spenTextManager.onKeyDown(keyCode, event);
    }

    public final boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.mTextManager.onKeyPreIme(keyCode, event);
    }

    public final boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.mTextManager.onKeyShortcut(keyCode, event);
    }

    public final boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        SpenTextManager spenTextManager = this.mTextManager;
        Intrinsics.checkNotNull(event);
        return spenTextManager.onKeyUp(keyCode, event);
    }

    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.nativeView == 0) {
            return;
        }
        int i = right - left;
        int i2 = bottom - top;
        if (i == 0 || i2 == 0) {
            return;
        }
        if (i == this.mViewWidth && i2 == this.mViewHeight) {
            return;
        }
        StringBuilder sb = new StringBuilder("onLayout(");
        sb.append(changed);
        sb.append(SQLKeyword.COMMA);
        sb.append(left);
        sb.append(SQLKeyword.COMMA);
        AbstractC2821a.m2235z(sb, top, right, SQLKeyword.COMMA, SQLKeyword.COMMA);
        sb.append(bottom);
        sb.append(")");
        Log.d(TAG, sb.toString());
        this.mViewWidth = i;
        this.mViewHeight = i2;
        SpenDrawLoopInterface spenDrawLoopInterface = this.mDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.setScreenSize(i, i2);
        }
        Pair<Rect, Rect> visibleRects = this.mSpenLatencyConfiguration.getVisibleRects(this.mView, this.mDisplay);
        Companion companion = INSTANCE;
        long j = this.nativeView;
        Object obj = visibleRects.first;
        Intrinsics.checkNotNull(obj);
        int i4 = ((Rect) obj).left;
        Object obj2 = visibleRects.first;
        Intrinsics.checkNotNull(obj2);
        int i5 = ((Rect) obj2).top;
        Object obj3 = visibleRects.first;
        Intrinsics.checkNotNull(obj3);
        int i6 = ((Rect) obj3).right;
        Object obj4 = visibleRects.first;
        Intrinsics.checkNotNull(obj4);
        companion.Native_setVisibleViewRect(j, i4, i5, i6, ((Rect) obj4).bottom);
        long j2 = this.nativeView;
        Object obj5 = visibleRects.second;
        Intrinsics.checkNotNull(obj5);
        int i7 = ((Rect) obj5).left;
        Object obj6 = visibleRects.second;
        Intrinsics.checkNotNull(obj6);
        int i8 = ((Rect) obj6).top;
        Object obj7 = visibleRects.second;
        Intrinsics.checkNotNull(obj7);
        int i9 = ((Rect) obj7).right;
        Object obj8 = visibleRects.second;
        Intrinsics.checkNotNull(obj8);
        companion.Native_setVisibleScreenRect(j2, i7, i8, i9, ((Rect) obj8).bottom);
        companion.Native_onLayout(this.nativeView, changed, left, top, right, bottom);
    }

    public final void onPause() {
        long j = this.nativeView;
        if (j != 0) {
            INSTANCE.Native_onPause(j);
        }
    }

    public final void onResume() {
        long j = this.nativeView;
        if (j != 0) {
            INSTANCE.Native_onResume(j);
        }
    }

    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.nativeView == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            convertMotionEventPenButtonAction(event);
        }
        Trace.beginSection("SPenSDK::WritingView onTouchEvent");
        int actionMasked = event.getActionMasked();
        int toolTypeAction = getToolTypeAction((actionMasked == MotionEventWrapper.ACTION_PEN_DOWN || actionMasked == MotionEventWrapper.ACTION_PEN_MOVE || actionMasked == MotionEventWrapper.ACTION_PEN_UP || actionMasked == MotionEventWrapper.ACTION_PEN_CANCEL) ? 6 : event.getToolType(0));
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC0000a.m26w(AbstractC0622a.m1173s(actionMasked, event.getToolType(0), "[JavaGesture] Write onTouch begin. action=", ", toolType=", ", toolTypeAction="), TAG, toolTypeAction);
        onPreTouch(event, toolTypeAction);
        SpenGesture.INSTANCE.onTouchEvent(event, toolTypeAction != 1);
        if (actionMasked == 0) {
            if (this.mSpenLatencyConfiguration.checkAndUpdateUnbufferedDispatch()) {
                this.mView.requestUnbufferedDispatch(event);
            }
            int historySize = event.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                Log.i(TAG, "[JavaGesture] Write index : " + i + " , down time : " + event.getDownTime() + " , eventTime : " + event.getHistoricalEventTime(i));
            }
            long downTime = event.getDownTime();
            long eventTime = event.getEventTime();
            StringBuilder sbM1323p = AbstractC1974b.m1323p(downTime, "[JavaGesture] Write down time : ", ", eventTime : ");
            sbM1323p.append(eventTime);
            Log.i(TAG, sbM1323p.toString());
        }
        INSTANCE.Native_onTouch(this.nativeView, new SpenMotionEvent(event));
        this.mPenSound.onTouch(event, toolTypeAction);
        onPostTouch(event, toolTypeAction);
        Trace.endSection();
        float x = event.getX();
        float y2 = event.getY();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("[JavaGesture] Write onTouch end. (", x, SQLKeyword.COMMA, y2, "), elapsed=");
        sbM1176v.append(jCurrentTimeMillis2);
        sbM1176v.append("ms");
        Log.i(TAG, sbM1176v.toString());
        return true;
    }

    public final void onTrimMemory() {
        long j = this.nativeView;
        if (j != 0) {
            INSTANCE.Native_onTrimMemory(j);
        }
    }

    public final void onWindowFocusChanged(boolean hasWindowFocus) {
        Log.d(TAG, "onWindowFocusChanged() - Start");
        if (hasWindowFocus) {
            Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : true");
            this.mPenSound.registerPenSoundSolution();
        } else {
            Log.d(TAG, "onWindowFocusChanged() - hasWindowFocus : false");
            this.mPenSound.unregisterPenSoundSolution();
        }
        Log.d(TAG, "onWindowFocusChanged() - End");
    }

    public final boolean pauseReplay() {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_pauseReplay(j);
    }

    public final boolean resumeReplay() {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_resumeReplay(j);
    }

    public final void setBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY) {
        SpenWritingViewContext spenWritingViewContext;
        long j = this.nativeView;
        if (j == 0 || (spenWritingViewContext = this.mNativeContext) == null) {
            return;
        }
        INSTANCE.Native_setBackgroundBitmap(j, spenWritingViewContext.getHandle(), bitmap, gravity, tileModeX, tileModeY);
    }

    public final void setBackgroundColor(int color) {
        long j = this.nativeView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setBackgroundColor(j, color);
    }

    public final void setColorTheme(int theme) {
        SpenWritingViewContext spenWritingViewContext = this.mNativeContext;
        if (spenWritingViewContext != null) {
            spenWritingViewContext.setColorTheme(theme);
        }
    }

    public final void setContentBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY) {
        setContentBackgroundBitmap(bitmap, gravity, tileModeX, tileModeY, false);
    }

    public final void setContentBackgroundColor(int color) {
        long j = this.nativeView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setContentBackgroundColor(j, color);
    }

    public final void setContentMatrix(@Nullable Matrix matrix) {
    }

    public final void setContentRect(float left, float top, float right, float bottom) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setContentRect(left, top, right, bottom);
        }
    }

    public final void setContentScale(float scale) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setContentScale(scale);
        }
    }

    public final void setContentTransparentBackgroundImage(@Nullable Bitmap bitmap, int gravity, int tileMode) {
        SpenWritingViewContext spenWritingViewContext;
        long j = this.nativeView;
        if (j == 0 || (spenWritingViewContext = this.mNativeContext) == null) {
            return;
        }
        INSTANCE.Native_setContentTransparentBackgroundImage(j, spenWritingViewContext.getHandle(), bitmap, gravity, tileMode);
    }

    public final void setContextMenuListener(@Nullable SpenContextMenuListener listener) {
        this.mContextMenuListener = listener;
        SpenContextMenu spenContextMenu = this.mContextMenu;
        if (spenContextMenu != null) {
            spenContextMenu.setContextMenuListener(new SpenContextMenuListener() { // from class: com.samsung.android.sdk.pen.engine.writingview.SpenWritingViewImpl.setContextMenuListener.1
                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    SpenContextMenuListener spenContextMenuListener = SpenWritingViewImpl.this.mContextMenuListener;
                    return spenContextMenuListener != null && spenContextMenuListener.onActionItemClicked(mode, item);
                }

                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    SpenContextMenuListener spenContextMenuListener = SpenWritingViewImpl.this.mContextMenuListener;
                    return spenContextMenuListener != null && spenContextMenuListener.onCreateActionMode(mode, menu);
                }

                @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
                public void onCreateContextMenu(ContextMenu menu) {
                    SpenContextMenuListener spenContextMenuListener = SpenWritingViewImpl.this.mContextMenuListener;
                    if (spenContextMenuListener != null) {
                        spenContextMenuListener.onCreateContextMenu(menu);
                    }
                }
            });
        }
    }

    public final void setControlObjectManager(@NotNull SpenControlObjectManager spenControlObjectManager) {
        Intrinsics.checkNotNullParameter(spenControlObjectManager, "<set-?>");
        this.controlObjectManager = spenControlObjectManager;
    }

    public final void setDarkMode(boolean isDartMode) {
        SpenWritingViewContext spenWritingViewContext = this.mNativeContext;
        if (spenWritingViewContext != null) {
            spenWritingViewContext.setSystemDarkMode(isDartMode);
        }
    }

    public final void setDelta(@Nullable PointF pointF) {
        SpenDeltaZoom deltaZoom;
        if (pointF == null || (deltaZoom = this.mViewCore.getDeltaZoom()) == null) {
            return;
        }
        deltaZoom.setDelta(pointF.x, pointF.y);
    }

    public final boolean setDocument(@Nullable SpenWritingDocument document) {
        if (this.nativeView == 0) {
            return false;
        }
        if (document == this.mDocument) {
            Log.e(TAG, "setDocument is same");
            return true;
        }
        if (document != null && !document.isValid()) {
            Log.e(TAG, "setDocument is closed");
            return false;
        }
        if (document != null) {
            this.mPenSound.registerPenSoundSolution();
        }
        if (INSTANCE.Native_setDocument(this.nativeView, document != null ? document.getMHandle() : 0L)) {
            this.mDocument = document;
            return true;
        }
        Log.e(TAG, "setDocument failed");
        return false;
    }

    public final void setEdgeEffectEnabled(boolean enabled) {
    }

    public final boolean setFrontBufferRenderingCaptureWindow(@Nullable Window window) {
        Unit unit;
        if (window == null) {
            return false;
        }
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            spenFbrDrawPad.setFrontBufferRenderingCaptureWindow(window);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit != null;
    }

    public final boolean setFrontBufferRenderingEnabled(boolean enabled, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        boolean z = !(force.length == 0) ? force[0] : false;
        if (!z && !this.mSpenLatencyConfiguration.isFrontBufferRenderingSupported()) {
            return false;
        }
        this.mSpenLatencyConfiguration.setForcedWithoutStylusSupport(z);
        Log.d(TAG, "setFrontBufferRenderingEnabled() called");
        if (this.nativeView == 0) {
            return false;
        }
        if (!enabled) {
            finalizeFbrDrawPad();
            return true;
        }
        if (this.mFbrDrawPad == null) {
            SpenFbrDrawPad spenFbrDrawPad = new SpenFbrDrawPad(this.mContext, this.mSpenLatencyConfiguration.getIsChromeOS(), SpenFbrDrawPad.DefaultMode);
            this.mFbrDrawPad = spenFbrDrawPad;
            Companion companion = INSTANCE;
            long j = this.nativeView;
            Intrinsics.checkNotNull(spenFbrDrawPad);
            companion.Native_setFbrDrawPad(j, spenFbrDrawPad.getHandle());
            ViewGroup viewGroup = this.mParentLayout;
            if (viewGroup != null) {
                viewGroup.addView(this.mFbrDrawPad);
                SpenFbrDrawPad spenFbrDrawPad2 = this.mFbrDrawPad;
                if (spenFbrDrawPad2 != null) {
                    spenFbrDrawPad2.setVisibility(4);
                }
                SpenFbrDrawPad spenFbrDrawPad3 = this.mFbrDrawPad;
                if (spenFbrDrawPad3 != null) {
                    spenFbrDrawPad3.setZOrderOnTop(true);
                }
            }
            this.mSpenLatencyConfiguration.updateHWInfo(this.mFbrDrawPad);
        }
        return this.mFbrDrawPad != null;
    }

    public final void setHapticSoundEnabled(boolean enable) {
        this.mPenSound.setEnabled(enable);
    }

    public final void setHoldLongPressEnabled(boolean enabled) {
        this.mGestureController.setHoldLongPressEnabled(enabled);
    }

    public final void setHoverScrollEnabled(boolean enabled) {
        this.mGestureController.setHoverScrollEnabled(enabled);
    }

    public final void setHoverScrollOption(long responseTime, float velocity, int margin) {
        this.mGestureController.setHoverScrollOption(responseTime, velocity, margin);
    }

    public final boolean setInputMethodServiceInkWindowMode(boolean enabled) {
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad == null) {
            return false;
        }
        spenFbrDrawPad.setInputMethodServiceInkWindowMode(enabled);
        return true;
    }

    public final void setIntersectSelection(boolean intersect) {
        long j = this.nativeView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setIntersectSelection(j, intersect);
    }

    public final void setListenerManager(@Nullable ListenerManager listenerManager) {
        this.mListenerManager = listenerManager;
    }

    public final void setLongPressEnabled(boolean enabled) {
        this.mGestureController.setLongPressEnabled(enabled);
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setMargin(left, top, right, bottom);
        }
    }

    public final boolean setMaxZoomScale(float ratio) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.setMaxZoomScale(ratio);
        }
        return false;
    }

    public final boolean setMinZoomScale(float ratio) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            return deltaZoom.setMinZoomScale(ratio);
        }
        return false;
    }

    public final void setObjectTypeFilter(int typeFilter) {
        long j = this.nativeView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setObjectTypeFilter(j, typeFilter);
    }

    public final void setPan(@Nullable PointF pointF) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setPan(pointF);
        }
    }

    public final void setPenSettingInfo(@Nullable SpenSettingPenInfo spenSettingPenInfo) {
        int i;
        if (spenSettingPenInfo == null) {
            return;
        }
        Log.i(TAG, "<<=== setPenSettingInfo =====");
        AbstractC6670b.m4756q("setPenSettingInfo name=", spenSettingPenInfo.name, TAG);
        AbstractC4539a.m3205o("setPenSettingInfo size=", TAG, spenSettingPenInfo.size);
        AbstractC2322a.m1631u(spenSettingPenInfo.sizeLevel, "setPenSettingInfo sizeLevel=", TAG);
        AbstractC2322a.m1631u(spenSettingPenInfo.color, "setPenSettingInfo color=", TAG);
        SpenWritingDocument spenWritingDocument = this.mDocument;
        if (spenWritingDocument != null && (i = spenSettingPenInfo.sizeLevel) != 0) {
            float fConvertSizeLevelToPxSize = SpenPenUtil.convertSizeLevelToPxSize(spenSettingPenInfo.name, i, spenWritingDocument.getWidth(), spenWritingDocument.getHeight());
            spenSettingPenInfo.size = fConvertSizeLevelToPxSize;
            AbstractC4539a.m3205o("setPenSettingInfo size2=", TAG, fConvertSizeLevelToPxSize);
        }
        Log.i(TAG, "===== setPenSettingInfo ===>>");
        SpenSettingPenInfo spenSettingPenInfo2 = this.mPenInfo;
        spenSettingPenInfo2.name = spenSettingPenInfo.name;
        spenSettingPenInfo2.size = spenSettingPenInfo.size;
        spenSettingPenInfo2.sizeLevel = spenSettingPenInfo.sizeLevel;
        spenSettingPenInfo2.color = spenSettingPenInfo.color;
        spenSettingPenInfo2.isCurvable = spenSettingPenInfo.isCurvable;
        spenSettingPenInfo2.isEraserEnabled = spenSettingPenInfo.isEraserEnabled;
        spenSettingPenInfo2.advancedSetting = spenSettingPenInfo.advancedSetting;
        spenSettingPenInfo2.particleDensity = spenSettingPenInfo.particleDensity;
        spenSettingPenInfo2.particleSize = spenSettingPenInfo.particleSize;
        spenSettingPenInfo2.isFixedWidth = spenSettingPenInfo.isFixedWidth;
        spenSettingPenInfo2.fromLightColor = spenSettingPenInfo.fromLightColor;
        spenSettingPenInfo2.toLightColor = spenSettingPenInfo.toLightColor;
        spenSettingPenInfo2.fromDarkColor = spenSettingPenInfo.fromDarkColor;
        spenSettingPenInfo2.toDarkColor = spenSettingPenInfo.toDarkColor;
        spenSettingPenInfo2.dashType = spenSettingPenInfo.dashType;
        spenSettingPenInfo2.dashOffset = spenSettingPenInfo.dashOffset;
        this.mViewCore.setPenSettingInfo(spenSettingPenInfo, this.mDisplay);
        this.mPenSound.setPenStyle(spenSettingPenInfo.name, this.mViewCore.getPenSize());
        ListenerManager listenerManager = this.mListenerManager;
        if (listenerManager != null) {
            listenerManager.onPenChanged(spenSettingPenInfo);
        }
    }

    public final void setPredictionEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        this.isPredictionEnabled = enable;
        if (this.nativeView != 0) {
            this.mSpenLatencyConfiguration.setForcedWithoutStylusSupport(force.length == 0 ? false : force[0]);
            INSTANCE.Native_setPredictionEnabled(this.nativeView, this.isPredictionEnabled);
        }
    }

    public final void setRemoverSettingInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
        if (spenSettingRemoverInfo != null) {
            long j = this.nativeView;
            if (j == 0) {
                return;
            }
            INSTANCE.Native_setRemoverSettingInfo(j, spenSettingRemoverInfo);
            this.mPenSound.setRemoverSize(spenSettingRemoverInfo.size);
            ListenerManager listenerManager = this.mListenerManager;
            if (listenerManager != null) {
                listenerManager.onRemoverChanged(spenSettingRemoverInfo);
            }
        }
    }

    public final boolean setReplayPosition(int position) {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setReplayPosition(j, position);
    }

    public final boolean setReplaySpeed(int speed) {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setReplaySpeed(j, speed);
    }

    public final void setScreenOrientation(int orientation) {
        synchronized (this) {
            this.mDisplay.updateScreenOrientation(this.mContext);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setScrollable(boolean z) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setScrollable(z);
        }
    }

    public final void setSelectionType(int type) {
        long j = this.nativeView;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionType(j, type);
    }

    public final void setSoftInputListener(@Nullable SpenSoftInputListener listener) {
        this.mTextManager.setSoftInputListener(listener);
    }

    public final void setStretchContentSize(boolean enable, int width, int height) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setStretchMode(enable, width, height);
        }
    }

    public final void setStrokeToShapeEnabled(boolean enabled) {
        INSTANCE.Native_setStrokeToShapeEnabled(this.nativeView, enabled);
    }

    public final void setToolTipEnabled(boolean z) {
        this.mHoverPointerIcon.setToolTipEnabled(z);
    }

    public final void setToolTypeAction(int toolType, int action) {
        if (this.nativeView == 0) {
            return;
        }
        this.mViewCore.setToolTypeAction(toolType, action);
    }

    public final void setTouchUpMode(@Nullable SpenFbrDrawPad.TouchUpMode mode) {
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            spenFbrDrawPad.setTouchUpMode(mode);
        }
    }

    public final void setUnbufferedDispatchEnabled(boolean enable, @NotNull boolean... force) {
        Intrinsics.checkNotNullParameter(force, "force");
        this.mSpenLatencyConfiguration.setForcedWithoutStylusSupport(force.length == 0 ? false : force[0]);
        this.mSpenLatencyConfiguration.setUnbufferedDispatchEnabled(enable);
    }

    public final void setZoomListener(@Nullable SpenZoomListener listener) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setZoomListener(listener);
        }
    }

    public final void setZoomScale(float scale, float pivotX, float pivotY) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setZoomScale(scale, pivotX, pivotY);
        }
    }

    public final void setZoomable(boolean z) {
        SpenDeltaZoom deltaZoom = this.mViewCore.getDeltaZoom();
        if (deltaZoom != null) {
            deltaZoom.setZoomable(z);
        }
    }

    public final boolean startReplay() {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_startReplay(j);
    }

    public final boolean stopReplay() {
        long j = this.nativeView;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_stopReplay(j);
    }

    public final void setContentBackgroundBitmap(@Nullable Bitmap bitmap, int gravity, int tileModeX, int tileModeY, boolean includeAsMosaicBackground) {
        SpenWritingViewContext spenWritingViewContext;
        long j = this.nativeView;
        if (j == 0 || (spenWritingViewContext = this.mNativeContext) == null) {
            return;
        }
        INSTANCE.Native_setContentBackgroundBitmap(j, spenWritingViewContext.getHandle(), bitmap, gravity, tileModeX, tileModeY, includeAsMosaicBackground);
    }
}
