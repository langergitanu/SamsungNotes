package com.samsung.android.sdk.composer;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.samsung.android.sdk.composer.input.ISpenNotePageLayouter;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.listener.SpenComposerListenerManager;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager;
import com.samsung.android.sdk.composer.writing.laserview.SpenNoteLaserManager;
import com.samsung.android.sdk.composer.writing.smartscript.SpenSmartScriptDocument;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ý\u00012\u00020\u0001:\u0004ü\u0001ý\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\rJ\u0018\u0010j\u001a\u00020k2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020\u0007H\u0014J\u0010\u0010n\u001a\u00020k2\u0006\u0010o\u001a\u00020\u0007H\u0016J\u0010\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020kH\u0014J\b\u0010t\u001a\u00020kH\u0014J\u0010\u0010u\u001a\u00020k2\u0006\u0010v\u001a\u00020wH\u0014J\u0010\u0010x\u001a\u00020k2\u0006\u0010y\u001a\u00020zH\u0014J1\u0010{\u001a\u00020k2\u0006\u0010|\u001a\u00020\u00192\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0014J'\u0010\u0081\u0001\u001a\u00020k2\u0007\u0010\u0082\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020\u00072\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0014J\u0012\u0010\u0086\u0001\u001a\u00020k2\u0007\u0010\u0087\u0001\u001a\u00020\u0019H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020\u00192\u0006\u0010q\u001a\u00020rH\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u00192\u0006\u0010q\u001a\u00020rH\u0016J\u001b\u0010\u008a\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010q\u001a\u00030\u008c\u0001H\u0016J\u001b\u0010\u008d\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010q\u001a\u00030\u008c\u0001H\u0016J\u001b\u0010\u008e\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010q\u001a\u00030\u008c\u0001H\u0016J\u001b\u0010\u008f\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010q\u001a\u00030\u008c\u0001H\u0016J\u0014\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0019H\u0016J\u0013\u0010\u0095\u0001\u001a\u00020k2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0014J\u0011\u0010\u0098\u0001\u001a\u00020\u00192\u0006\u0010q\u001a\u00020rH\u0014J\u0012\u0010\u0099\u0001\u001a\u00020\u00192\u0007\u0010q\u001a\u00030\u008c\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020k2\u0007\u0010q\u001a\u00030\u009b\u0001H\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\u0007\u0010\u009e\u0001\u001a\u00020kJ\u0013\u0010\u009f\u0001\u001a\u00020\u00192\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001J\u0010\u0010¢\u0001\u001a\u00020k2\u0007\u0010£\u0001\u001a\u00020\u0007J\u0010\u0010¤\u0001\u001a\u00020k2\u0007\u0010£\u0001\u001a\u00020\u0007J\u000f\u0010¥\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010¦\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010§\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010¨\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u0010\u0010©\u0001\u001a\u00020k2\u0007\u0010ª\u0001\u001a\u00020\u0007J3\u0010«\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u00192\u0007\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u00072\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0010\u0010°\u0001\u001a\u00020k2\u0007\u0010ª\u0001\u001a\u00020\u0007J\u0007\u0010±\u0001\u001a\u00020kJ\u0007\u0010²\u0001\u001a\u00020kJ\u000f\u0010³\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u0018\u0010´\u0001\u001a\u00020k2\u0007\u0010µ\u0001\u001a\u00020^2\u0006\u0010]\u001a\u00020^J\u001c\u0010¶\u0001\u001a\u00020\u00072\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\u0007\u0010¸\u0001\u001a\u00020\u0019J\u0007\u0010¹\u0001\u001a\u00020\u0019J\u001c\u0010º\u0001\u001a\u00020\u00192\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\u0007\u0010¸\u0001\u001a\u00020\u0019J\u0007\u0010»\u0001\u001a\u00020\u0007J\u0007\u0010¼\u0001\u001a\u00020\u0007J\u0010\u0010½\u0001\u001a\u00020\u00192\u0007\u0010¾\u0001\u001a\u00020\u0007J\u0007\u0010¿\u0001\u001a\u00020kJ\u0007\u0010À\u0001\u001a\u00020kJ\u0007\u0010Á\u0001\u001a\u00020kJ\u0007\u0010Â\u0001\u001a\u00020kJ\u0010\u0010Ã\u0001\u001a\u00020k2\u0007\u0010Ä\u0001\u001a\u00020\u0019J\u0010\u0010Å\u0001\u001a\u00020k2\u0007\u0010Æ\u0001\u001a\u00020\u0007J+\u0010Ç\u0001\u001a\u00020k2\u0007\u0010È\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u00072\u0007\u0010Ë\u0001\u001a\u00020\u0007J+\u0010Ì\u0001\u001a\u00020k2\u0007\u0010È\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u00072\u0007\u0010Ë\u0001\u001a\u00020\u0007J\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001J\u000f\u0010Ï\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010Ð\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u0010\u0010Ñ\u0001\u001a\u00020k2\u0007\u0010Ò\u0001\u001a\u00020\u0019J\u000f\u0010Ó\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010Ô\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u000f\u0010Õ\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u0011\u0010Ö\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019H\u0007J\u0007\u0010×\u0001\u001a\u00020kJ\u0007\u0010Ø\u0001\u001a\u00020kJ\u0010\u0010Ù\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u0007J\u0010\u0010Ú\u0001\u001a\u00020\u00192\u0007\u0010Û\u0001\u001a\u00020\u0019J\u0019\u0010Ü\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010Û\u0001\u001a\u00020\u0019J\u0010\u0010Ý\u0001\u001a\u00020\u00192\u0007\u0010Û\u0001\u001a\u00020\u0019J\u0019\u0010Þ\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010Û\u0001\u001a\u00020\u0019J\u0010\u0010ß\u0001\u001a\u00020\u00192\u0007\u0010ª\u0001\u001a\u00020\u0007J\u0013\u0010à\u0001\u001a\u00020\u00192\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001J\u001c\u0010ã\u0001\u001a\u00020\u00192\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\u0007\u0010æ\u0001\u001a\u00020^J\u0007\u0010ç\u0001\u001a\u00020kJ\u0007\u0010è\u0001\u001a\u00020kJ\u0007\u0010é\u0001\u001a\u00020kJ\u0010\u0010ê\u0001\u001a\u00020k2\u0007\u0010ë\u0001\u001a\u00020\u0007J\u0010\u0010ì\u0001\u001a\u00020\u00192\u0007\u0010Ä\u0001\u001a\u00020\u0019J\u000f\u0010í\u0001\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0019J\u0013\u0010î\u0001\u001a\u00020k2\n\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001J\u0010\u0010ñ\u0001\u001a\u00020k2\u0007\u0010Ä\u0001\u001a\u00020\u0019J\u0007\u0010ò\u0001\u001a\u00020kJ\u0007\u0010ó\u0001\u001a\u00020kJ\u0010\u0010ô\u0001\u001a\u00020k2\u0007\u0010Ä\u0001\u001a\u00020\u0019J\u001a\u0010õ\u0001\u001a\u00020k2\b\u0010ö\u0001\u001a\u00030÷\u00012\u0007\u0010ø\u0001\u001a\u00020\u0019J\u0018\u0010ù\u0001\u001a\u00020k2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010û\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u0004\u0018\u00010J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010R8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0013\u0010U\u001a\u0004\u0018\u00010V8F¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0013\u0010Y\u001a\u0004\u0018\u00010Z8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010]\u001a\u00020^8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010a\u001a\u00020^8F¢\u0006\u0006\u001a\u0004\bb\u0010`R\u0011\u0010c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\be\u0010dR$\u0010g\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010d\"\u0004\bh\u0010i¨\u0006þ\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createType", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mComposerImpl", "Lcom/samsung/android/sdk/composer/ISpenComposerImpl;", "mOrientationListener", "Landroid/view/OrientationEventListener;", "mActivity", "Landroid/app/Activity;", "mLifecycleCallback", "Lcom/samsung/android/sdk/composer/SpenComposer$LifecycleCallback;", "mDocumentLoadingTime", "", "mIsDocumentLoaded", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "getActivity", "()Landroid/app/Activity;", "listenerManager", "Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "getListenerManager", "()Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "getNoteWritingViewManager", "()Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "convertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "getConvertToTextManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "mathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "getMathManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "sTTManager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "getSTTManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "alignmentManager", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "getAlignmentManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "hwrBeautifierManager", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "getHwrBeautifierManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "notePdfManager", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "getNotePdfManager", "()Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "noteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "getNoteZoomScroller", "()Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "noteObjectInserter", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "getNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "notePageLayouter", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "getNotePageLayouter", "()Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "textManager", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "getTextManager", "()Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "noteLaserManager", "Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "getNoteLaserManager", "()Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "gestureController", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "smartScriptDocument", "Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "getSmartScriptDocument", "()Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "panY", "", "getPanY", "()F", "deltaY", "getDeltaY", "isEasyWritingPadEnabled", "()Z", "isMathEnabled", "enable", "isContextMenuEnabled", "setContextMenuEnabled", "(Z)V", "init", "", "onWindowVisibilityChanged", "visibility", "onScreenStateChanged", "screenState", "onGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", "onLayout", "changed", "left", "top", "right", "bottom", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onWindowFocusChanged", "hasWindowFocus", "onTouchEvent", "onHoverEvent", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchHoverEvent", "dispatchKeyEvent", "onPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "getAccessibilityClassName", "", "close", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setMode", "mode", "setEditMode", "setTextOnlyEnabled", "setWritingGuideLineEnabled", "setAutoCleanUpEnabled", "setLaserViewEnabled", "goToPage", "pageIndex", "onScaleByScreenSize", "startWidth", "startHeight", "endWidth", "endHeight", "requestAlignmentContent", "requestResetZoomScaleToDefault", "requestKeepPageFitToScreenWhenPageFit", "setAllwaysFitPageToScreen", "setPan", "panX", "searchText", "", "includeSearchData", "pauseSearchText", "resumeSearchText", "searchFocusNext", "searchFocusPrev", "setSearchFocus", "focusId", "clearSearch", "cancelSearch", "startActionMode", "stopActionMode", "setDarkModeEnabled", "enabled", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setStrokeRemoverTouchMargin", "captureCurrentView", "Landroid/graphics/Bitmap;", "setEasyWritingPadEnable", "setActionLinkEnabled", "setActionLinkVisible", "visible", "setVoiceSyncPlayEnabled", "setVoiceSyncPlayAutoScroll", "setAutoScrollEnabled", "setLongPressEnabled", "requestCancelTouch", "smoothScrollToFitPage", "smoothScrollToPage", "smoothScrollFitPageToScreen", "isFitToWidth", "smoothScrollToPageAndFitPageToScreen", "isFitToScreen", "isPageFitToScreen", "smoothScrollAndScaleToFitPage", "smoothScrollAndScaleToFitRect", "targetContentRect", "Landroid/graphics/RectF;", "smoothScrollAndScaleTo", "targetContentPoint", "Landroid/graphics/PointF;", "targetZoomScale", "stopGestureAnimation", "startLazyViewUpdate", "endLazyViewUpdate", "setImageCacheQuality", "imageCacheQuality", "setFrontBufferRenderingEnabledInEWP", "setUnbufferedDispatchEnabled", "setDvfsFling", "dvfsInterface", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "setVSTEnabled", "startContextMenuDelegate", "stopContextMenuDelegate", "setInputFormEnabled", "startStickyMemoIconAnimation", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "isShow", "setInitBackgroundColor", "color", "(Ljava/lang/Integer;)V", "LifecycleCallback", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenComposer extends FrameLayout {
    public static final int COMPOSER_CREATE_TYPE_ALL = 1;
    public static final int COMPOSER_CREATE_TYPE_WRITING_ONLY = 2;

    @NotNull
    private static final String TAG = "SpenComposer";

    @Nullable
    private Activity mActivity;

    @Nullable
    private ISpenComposerImpl mComposerImpl;
    private long mDocumentLoadingTime;
    private boolean mIsDocumentLoaded;

    @Nullable
    private LifecycleCallback mLifecycleCallback;

    @Nullable
    private OrientationEventListener mOrientationListener;
    private static final int mDrawLoopType = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposer$LifecycleCallback;", "Landroid/content/ComponentCallbacks2;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenComposer;)V", "onActivityCreated", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onTrimMemory", "level", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class LifecycleCallback implements ComponentCallbacks2, Application.ActivityLifecycleCallbacks {
        public LifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenComposer.this.mActivity) {
                Log.i(SpenComposer.TAG, "onActivityPaused");
                ISpenComposerImpl iSpenComposerImpl = SpenComposer.this.mComposerImpl;
                if (iSpenComposerImpl != null) {
                    iSpenComposerImpl.onPause();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity == SpenComposer.this.mActivity) {
                Log.i(SpenComposer.TAG, "onActivityResumed");
                ISpenComposerImpl iSpenComposerImpl = SpenComposer.this.mComposerImpl;
                if (iSpenComposerImpl != null) {
                    iSpenComposerImpl.onResume();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            ISpenComposerImpl iSpenComposerImpl = SpenComposer.this.mComposerImpl;
            if (iSpenComposerImpl != null) {
                iSpenComposerImpl.onConfigurationChanged();
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            ISpenComposerImpl iSpenComposerImpl = SpenComposer.this.mComposerImpl;
            if (iSpenComposerImpl != null) {
                iSpenComposerImpl.onTrimMemory(level);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
        init(context, 1);
    }

    private final Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Log.i(TAG, "getActivity - Activity found");
                return (Activity) context;
            }
        }
        Log.i(TAG, "getActivity - Activity NOT found");
        return null;
    }

    private final void init(Context context, int createType) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Log.i(TAG, "[EntryPerformance] init Start");
        SPenRecognitionWorker.initializeSelf(context);
        this.mComposerImpl = new SpenComposerImpl(context, this, createType, mDrawLoopType);
        Activity activity = getActivity();
        this.mActivity = activity;
        if (activity != null) {
            activity.registerComponentCallbacks(this.mLifecycleCallback);
            activity.getApplication().registerActivityLifecycleCallbacks(this.mLifecycleCallback);
        }
        this.mOrientationListener = new OrientationEventListener(context, this) { // from class: com.samsung.android.sdk.composer.SpenComposer.init.2
            final /* synthetic */ Context $context;
            final /* synthetic */ SpenComposer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.$context = context;
                this.this$0 = this;
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                SpenComposer spenComposer = this.this$0;
                Context context2 = this.$context;
                synchronized (this) {
                    ISpenComposerImpl iSpenComposerImpl = spenComposer.mComposerImpl;
                    if (iSpenComposerImpl != null) {
                        iSpenComposerImpl.updateScreenOrientation(context2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        };
        setWillNotDraw(false);
        Log.i(TAG, "[EntryPerformance] init end " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    public final void cancelSearch() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.cancelSearch();
        }
    }

    @Nullable
    public final Bitmap captureCurrentView() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.captureCurrentView();
        }
        return null;
    }

    public final void clearSearch() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.clearSearch();
        }
    }

    public final void close() {
        Log.i(TAG, "close");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.close();
        }
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.mOrientationListener = null;
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.unregisterComponentCallbacks(this.mLifecycleCallback);
            Application application = activity.getApplication();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this.mLifecycleCallback);
            }
        }
        this.mActivity = null;
        this.mLifecycleCallback = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.dispatchHoverEvent(event)) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.dispatchKeyEvent(event)) || super.dispatchKeyEvent(event);
    }

    public final void endLazyViewUpdate() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.endLazyViewUpdate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @Nullable
    public CharSequence getAccessibilityClassName() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getAccessibilityClassName();
        }
        return null;
    }

    @Nullable
    public final ISPenAlignmentManager getAlignmentManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getAlignmentManager();
        }
        return null;
    }

    @Nullable
    public final ISpenControlObjectManager getControlObjectManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getControlObjectManager();
        }
        return null;
    }

    @Nullable
    public final ISpenConvertToTextManager getConvertToTextManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getConvertToTextManager();
        }
        return null;
    }

    public final float getDeltaY() {
        PointF delta;
        ISpenNoteZoomScroller noteZoomScroller = getNoteZoomScroller();
        if (noteZoomScroller == null || (delta = noteZoomScroller.getDelta()) == null) {
            return 0.0f;
        }
        return delta.y;
    }

    @Nullable
    public final SpenIGestureController getGestureController() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getGestureController();
        }
        return null;
    }

    @Nullable
    public final SPenHwrBeautifierManager getHwrBeautifierManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getHwrBeautifierManager();
        }
        return null;
    }

    @Nullable
    public final SpenComposerListenerManager getListenerManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getListenerManager();
        }
        return null;
    }

    @Nullable
    public final SpenIMathManager getMathManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getMathManager();
        }
        return null;
    }

    @Nullable
    public final SpenNoteLaserManager getNoteLaserManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNoteLaserManager();
        }
        return null;
    }

    @Nullable
    public final SpenNoteObjectInserter getNoteObjectInserter() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNoteObjectInserter();
        }
        return null;
    }

    @Nullable
    public final ISpenNotePageLayouter getNotePageLayouter() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNotePageLayouter();
        }
        return null;
    }

    @Nullable
    public final ISpenNotePdfManager getNotePdfManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNotePdfManager();
        }
        return null;
    }

    @Nullable
    public final ISpenNoteWritingViewManager getNoteWritingViewManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNoteWritingViewManager();
        }
        return null;
    }

    @Nullable
    public final ISpenNoteZoomScroller getNoteZoomScroller() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getNoteZoomScroller();
        }
        return null;
    }

    public final float getPanY() {
        PointF pan;
        ISpenNoteZoomScroller noteZoomScroller = getNoteZoomScroller();
        if (noteZoomScroller == null || (pan = noteZoomScroller.getPan()) == null) {
            return 0.0f;
        }
        return pan.y;
    }

    @Nullable
    public final ISPenSTTManager getSTTManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getSTTManager();
        }
        return null;
    }

    @Nullable
    public final SpenSmartScriptDocument getSmartScriptDocument() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getSmartScriptDocument();
        }
        return null;
    }

    @Nullable
    public final ISpenNoteTextManager getTextManager() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.getTextManager();
        }
        return null;
    }

    public final void goToPage(int pageIndex) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.goToPage(pageIndex);
        }
    }

    public final boolean isContextMenuEnabled() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.isContextMenuEnabled();
        }
        return false;
    }

    public final boolean isEasyWritingPadEnabled() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.isEasyWritingPadEnabled();
        }
        return false;
    }

    public final boolean isFitToScreen(boolean isFitToWidth) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.isFitToScreen(isFitToWidth);
        }
        return false;
    }

    public final boolean isMathEnabled() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.isMathEnabled();
        }
        return false;
    }

    public final boolean isPageFitToScreen(int pageIndex, boolean isFitToWidth) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.isPageFitToScreen(pageIndex, isFitToWidth);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        ISpenNoteTextManager textManager;
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl == null || (textManager = iSpenComposerImpl.getTextManager()) == null) {
            return false;
        }
        return textManager.onCheckIsTextEditor();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onConfigurationChanged();
        }
    }

    @Override // android.view.View
    public void onCreateContextMenu(@NotNull ContextMenu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onCreateContextMenu(menu);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onCreateContextMenu(menu);
        }
    }

    @Override // android.view.View
    @NotNull
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        ISpenNoteTextManager textManager;
        InputConnection inputConnectionOnCreateInputConnection;
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        if (!isEnabled()) {
            InputConnection inputConnectionOnCreateInputConnection2 = super.onCreateInputConnection(outAttrs);
            Intrinsics.checkNotNullExpressionValue(inputConnectionOnCreateInputConnection2, "onCreateInputConnection(...)");
            return inputConnectionOnCreateInputConnection2;
        }
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null && (textManager = iSpenComposerImpl.getTextManager()) != null && (inputConnectionOnCreateInputConnection = textManager.onCreateInputConnection(outAttrs)) != null) {
            return inputConnectionOnCreateInputConnection;
        }
        InputConnection inputConnectionOnCreateInputConnection3 = super.onCreateInputConnection(outAttrs);
        Intrinsics.checkNotNullExpressionValue(inputConnectionOnCreateInputConnection3, "onCreateInputConnection(...)");
        return inputConnectionOnCreateInputConnection3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onDraw(canvas);
        }
        super.onDraw(canvas);
        if (this.mIsDocumentLoaded) {
            Log.i(TAG, "[EntryPerformance] first onDraw called after setDocument " + (SystemClock.uptimeMillis() - this.mDocumentLoadingTime) + "ms");
            this.mIsDocumentLoaded = false;
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.onGenericMotionEvent(event)) || super.onGenericMotionEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.onHoverEvent(event)) || super.onHoverEvent(event);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.onKeyDown(keyCode, event)) || super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.onKeyPreIme(keyCode, event);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.onKeyShortcut(keyCode, event);
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.onKeyUp(keyCode, event)) || super.onKeyUp(keyCode, event);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = bottom - top;
        if (right - left <= 0 || i <= 0) {
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onLayout(changed, left, top, right, bottom);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onPopulateAccessibilityEvent(event);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onPopulateAccessibilityEvent(event);
        }
    }

    public final void onScaleByScreenSize(boolean enable, int startWidth, int startHeight, int endWidth, int endHeight) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onScaleByScreenSize(enable, startWidth, startHeight, endWidth, endHeight);
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (getWindowVisibility() == 0) {
            if (screenState == 0) {
                OrientationEventListener orientationEventListener = this.mOrientationListener;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                    return;
                }
                return;
            }
            OrientationEventListener orientationEventListener2 = this.mOrientationListener;
            if (orientationEventListener2 != null) {
                orientationEventListener2.enable();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        return (iSpenComposerImpl != null && iSpenComposerImpl.onTouchEvent(event)) || super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            if (visibility == 0) {
                orientationEventListener.enable();
            } else {
                orientationEventListener.disable();
            }
        }
    }

    public final boolean pauseSearchText() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.pauseSearchText();
        }
        return false;
    }

    public final void requestAlignmentContent(int pageIndex) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.requestAlignmentContent(pageIndex);
        }
    }

    public final void requestCancelTouch() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.requestCancelTouch();
        }
    }

    public final void requestKeepPageFitToScreenWhenPageFit() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.requestKeepPageFitToScreenWhenPageFit();
        }
    }

    public final void requestResetZoomScaleToDefault() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.requestResetZoomScaleToDefault();
        }
    }

    public final boolean resumeSearchText(@Nullable String searchText, boolean includeSearchData) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.resumeSearchText(searchText, includeSearchData);
        }
        return false;
    }

    public final int searchFocusNext() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.searchFocusNext();
        }
        return -1;
    }

    public final int searchFocusPrev() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.searchFocusPrev();
        }
        return -1;
    }

    public final int searchText(@Nullable String searchText, boolean includeSearchData) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.searchText(searchText, includeSearchData);
        }
        return 0;
    }

    public final void setActionLinkEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setActionLinkEnabled(enable);
        }
    }

    public final void setActionLinkVisible(boolean visible) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setActionLinkVisible(visible);
        }
    }

    public final void setAllwaysFitPageToScreen(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setAllwaysFitPageToScreen(enable);
        }
    }

    public final void setAutoCleanUpEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setAutoCleanUpEnabled(enable);
        }
    }

    public final void setAutoScrollEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setAutoScrollEnabled(enable);
        }
    }

    public final void setColorTheme(int theme) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setColorTheme(theme);
        }
    }

    public final void setContextMenuEnabled(boolean z) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setContextMenuEnabled(z);
        }
    }

    public final void setDarkModeEnabled(boolean enabled) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setDarkModeEnabled(enabled);
        }
    }

    public final boolean setDocument(@Nullable SpenWNote doc) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Log.i(TAG, "[EntryPerformance] setDocument java : " + doc + " Start");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        boolean document = iSpenComposerImpl != null ? iSpenComposerImpl.setDocument(doc) : false;
        this.mIsDocumentLoaded = true;
        this.mDocumentLoadingTime = SystemClock.uptimeMillis();
        Log.i(TAG, "[EntryPerformance] setDocument java end " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
        return document;
    }

    public final void setDvfsFling(@Nullable SpenDvfsInterface dvfsInterface) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setDvfsFling(dvfsInterface);
        }
    }

    public final void setEasyWritingPadEnable(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setEasyWritingPadEnable(enable);
        }
    }

    public final void setEditMode(int mode) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setEditMode(mode);
        }
    }

    public final boolean setFrontBufferRenderingEnabledInEWP(boolean enabled) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.setFrontBufferRenderingEnabledInEWP(enabled);
        }
        return false;
    }

    public final void setImageCacheQuality(int imageCacheQuality) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setImageCacheQuality(imageCacheQuality);
        }
    }

    public final void setInitBackgroundColor(@Nullable Integer color) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setInitBackgroundColor(color);
        }
    }

    public final void setInputFormEnabled(boolean enabled) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setInputFormEnabled(enabled);
        }
    }

    public final void setLaserViewEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setLaserPenEnabled(enable);
        }
    }

    @Deprecated(message = "")
    public final void setLongPressEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setLongPressEnabled(enable);
        }
    }

    public final void setMode(int mode) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setMode(mode);
        }
    }

    public final void setPan(float panX, float panY) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setPan(panX, panY);
        }
    }

    public final boolean setSearchFocus(int focusId) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.setSearchFocus(focusId);
        }
        return false;
    }

    public final void setStrokeRemoverTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setStrokeRemoverTouchMargin(marginLeft, marginTop, marginRight, marginBottom);
        }
    }

    public final void setTextOnlyEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setTextOnlyEnabled(enable);
        }
    }

    public final void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setTouchMargin(marginLeft, marginTop, marginRight, marginBottom);
        }
    }

    public final void setUnbufferedDispatchEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setUnbufferedDispatchEnabled(enable);
        }
    }

    public final void setVSTEnabled(boolean enabled) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setVSTEnabled(enabled);
        }
    }

    public final void setVoiceSyncPlayAutoScroll(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setVoiceSyncPlayAutoScroll(enable);
        }
    }

    public final void setVoiceSyncPlayEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setVoiceSyncPlayEnabled(enable);
        }
    }

    public final void setWritingGuideLineEnabled(boolean enable) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.setWritingGuideLineEnabled(enable);
        }
    }

    public final boolean smoothScrollAndScaleTo(@Nullable PointF targetContentPoint, float targetZoomScale) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollAndScaleTo(targetContentPoint, targetZoomScale);
        }
        return false;
    }

    public final boolean smoothScrollAndScaleToFitPage(int pageIndex) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollAndScaleToFitPage(pageIndex);
        }
        return false;
    }

    public final boolean smoothScrollAndScaleToFitRect(@Nullable RectF targetContentRect) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollAndScaleToFitRect(targetContentRect);
        }
        return false;
    }

    public final boolean smoothScrollFitPageToScreen(boolean isFitToWidth) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollFitPageToScreen(isFitToWidth);
        }
        return false;
    }

    public final void smoothScrollToFitPage() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.smoothScrollToFitPage();
        }
    }

    public final boolean smoothScrollToPage(int pageIndex) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollToPage(pageIndex);
        }
        return false;
    }

    public final boolean smoothScrollToPageAndFitPageToScreen(int pageIndex, boolean isFitToWidth) {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            return iSpenComposerImpl.smoothScrollToPageAndFitPageToScreen(pageIndex, isFitToWidth);
        }
        return false;
    }

    public final void startActionMode() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.startActionMode();
        }
    }

    public final void startContextMenuDelegate() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.startContextMenuDelegate();
        }
    }

    public final void startLazyViewUpdate() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.startLazyViewUpdate();
        }
    }

    public final void startStickyMemoIconAnimation(@NotNull SpenCustomObject customObject, boolean isShow) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.startStickyMemoIconAnimation(customObject, isShow);
        }
    }

    public final void stopActionMode() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.stopActionMode();
        }
    }

    public final void stopContextMenuDelegate() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.stopContextMenuDelegate();
        }
    }

    public final void stopGestureAnimation() {
        ISpenComposerImpl iSpenComposerImpl = this.mComposerImpl;
        if (iSpenComposerImpl != null) {
            iSpenComposerImpl.stopGestureAnimation();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposer(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
        init(context, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
        init(context, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleCallback = new LifecycleCallback();
        init(context, 1);
    }
}
