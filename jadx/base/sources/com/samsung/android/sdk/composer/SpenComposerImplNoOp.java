package com.samsung.android.sdk.composer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.input.ISpenNotePageLayouter;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.input.SpenNotePageLayouterNoOp;
import com.samsung.android.sdk.composer.listener.SpenComposerListenerManager;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfManagerNoOp;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenNoteTextManagerNoOp;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerNoOp;
import com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager;
import com.samsung.android.sdk.composer.writing.SpenNoteWritingViewManagerNoOp;
import com.samsung.android.sdk.composer.writing.laserview.SpenNoteLaserManager;
import com.samsung.android.sdk.composer.writing.smartscript.SpenSmartScriptDocument;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.control.SpenControlObjectManagerNoOp;
import com.samsung.android.sdk.pen.engine.SpenGestureControllerNoOp;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface;
import com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.alignment.SpenAlignmentManagerNoOp;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextManagerNoOp;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrgen.SpenHwrGenerator;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathManagerNoOP;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SpenSTTManagerNoOp;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\u0012\u0010_\u001a\u00020]2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010b\u001a\u00020]2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J0\u0010e\u001a\u00020]2\u0006\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020h2\u0006\u0010k\u001a\u00020hH\u0016J\"\u0010l\u001a\u00020]2\u0006\u0010m\u001a\u00020Q2\u0006\u0010n\u001a\u00020h2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0010\u0010q\u001a\u00020]2\u0006\u0010r\u001a\u00020QH\u0016J\u0012\u0010s\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010t\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010u\u001a\u00020Q2\u0006\u0010v\u001a\u00020h2\b\u0010Z\u001a\u0004\u0018\u00010wH\u0016J\u001a\u0010x\u001a\u00020Q2\u0006\u0010v\u001a\u00020h2\b\u0010Z\u001a\u0004\u0018\u00010wH\u0016J\u001a\u0010y\u001a\u00020Q2\u0006\u0010v\u001a\u00020h2\b\u0010Z\u001a\u0004\u0018\u00010wH\u0016J\u001a\u0010z\u001a\u00020Q2\u0006\u0010v\u001a\u00020h2\b\u0010Z\u001a\u0004\u0018\u00010wH\u0016J\b\u0010{\u001a\u00020]H\u0016J2\u0010|\u001a\u00020]2\u0006\u0010}\u001a\u00020Q2\u0006\u0010~\u001a\u00020h2\u0006\u0010\u007f\u001a\u00020h2\u0007\u0010\u0080\u0001\u001a\u00020h2\u0007\u0010\u0081\u0001\u001a\u00020hH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020]2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020Q2\u0006\u0010Z\u001a\u00020wH\u0016J\u0014\u0010\u0087\u0001\u001a\u00020]2\t\u0010Z\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020]H\u0016J\t\u0010\u008a\u0001\u001a\u00020]H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020]2\u0007\u0010\u008c\u0001\u001a\u00020hH\u0016J\t\u0010\u008d\u0001\u001a\u00020]H\u0016J\u0015\u0010\u008e\u0001\u001a\u00020Q2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020]2\u0007\u0010\u0092\u0001\u001a\u00020hH\u0016J\u0012\u0010\u0093\u0001\u001a\u00020]2\u0007\u0010\u0092\u0001\u001a\u00020hH\u0016J\u0011\u0010\u0094\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010\u0095\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010\u0096\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010\u0097\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0012\u0010\u0098\u0001\u001a\u00020]2\u0007\u0010\u0099\u0001\u001a\u00020hH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020]2\u0007\u0010\u0099\u0001\u001a\u00020hH\u0016J\t\u0010\u009b\u0001\u001a\u00020]H\u0016J\t\u0010\u009c\u0001\u001a\u00020]H\u0016J\u0011\u0010\u009d\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u001d\u0010\u009e\u0001\u001a\u00020]2\b\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030 \u0001H\u0016J\u001e\u0010¢\u0001\u001a\u00020h2\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\u0007\u0010¤\u0001\u001a\u00020QH\u0016J\t\u0010¥\u0001\u001a\u00020QH\u0016J\u001e\u0010¦\u0001\u001a\u00020Q2\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\u0007\u0010¤\u0001\u001a\u00020QH\u0016J\t\u0010§\u0001\u001a\u00020hH\u0016J\t\u0010¨\u0001\u001a\u00020hH\u0016J\u0012\u0010©\u0001\u001a\u00020Q2\u0007\u0010ª\u0001\u001a\u00020hH\u0016J\t\u0010«\u0001\u001a\u00020]H\u0016J\t\u0010¬\u0001\u001a\u00020]H\u0016J\t\u0010\u00ad\u0001\u001a\u00020]H\u0016J\t\u0010®\u0001\u001a\u00020]H\u0016J\u0012\u0010¯\u0001\u001a\u00020]2\u0007\u0010°\u0001\u001a\u00020QH\u0016J\u0012\u0010±\u0001\u001a\u00020]2\u0007\u0010²\u0001\u001a\u00020hH\u0016J-\u0010³\u0001\u001a\u00020]2\u0007\u0010´\u0001\u001a\u00020h2\u0007\u0010µ\u0001\u001a\u00020h2\u0007\u0010¶\u0001\u001a\u00020h2\u0007\u0010·\u0001\u001a\u00020hH\u0016J-\u0010¸\u0001\u001a\u00020]2\u0007\u0010´\u0001\u001a\u00020h2\u0007\u0010µ\u0001\u001a\u00020h2\u0007\u0010¶\u0001\u001a\u00020h2\u0007\u0010·\u0001\u001a\u00020hH\u0016J\f\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\u0011\u0010»\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010¼\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0012\u0010½\u0001\u001a\u00020]2\u0007\u0010¾\u0001\u001a\u00020QH\u0016J\u0011\u0010¿\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010À\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010Á\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0011\u0010Â\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0017J\t\u0010Ã\u0001\u001a\u00020]H\u0016J\t\u0010Ä\u0001\u001a\u00020]H\u0016J\u0012\u0010Å\u0001\u001a\u00020Q2\u0007\u0010\u0099\u0001\u001a\u00020hH\u0016J\u0012\u0010Æ\u0001\u001a\u00020Q2\u0007\u0010Ç\u0001\u001a\u00020QH\u0016J\u001b\u0010È\u0001\u001a\u00020Q2\u0007\u0010\u0099\u0001\u001a\u00020h2\u0007\u0010Ç\u0001\u001a\u00020QH\u0016J\u0012\u0010É\u0001\u001a\u00020Q2\u0007\u0010Ç\u0001\u001a\u00020QH\u0016J\u001b\u0010Ê\u0001\u001a\u00020Q2\u0007\u0010\u0099\u0001\u001a\u00020h2\u0007\u0010Ç\u0001\u001a\u00020QH\u0016J\u0012\u0010Ë\u0001\u001a\u00020Q2\u0007\u0010\u0099\u0001\u001a\u00020hH\u0016J\u0015\u0010Ì\u0001\u001a\u00020Q2\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001H\u0016J\u001f\u0010Ï\u0001\u001a\u00020Q2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\b\u0010Ò\u0001\u001a\u00030 \u0001H\u0016J\t\u0010Ó\u0001\u001a\u00020]H\u0016J\t\u0010Ô\u0001\u001a\u00020]H\u0016J\t\u0010Õ\u0001\u001a\u00020]H\u0016J\u0012\u0010Ö\u0001\u001a\u00020]2\u0007\u0010×\u0001\u001a\u00020hH\u0016J\u0015\u0010Ø\u0001\u001a\u00020]2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\u0012\u0010Ú\u0001\u001a\u00020]2\u0007\u0010Û\u0001\u001a\u00020QH\u0016J\u0012\u0010Ü\u0001\u001a\u00020Q2\u0007\u0010°\u0001\u001a\u00020QH\u0016J\u0011\u0010Ý\u0001\u001a\u00020]2\u0006\u0010}\u001a\u00020QH\u0016J\u0015\u0010Þ\u0001\u001a\u00020]2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0016J\u0012\u0010á\u0001\u001a\u00020]2\u0007\u0010°\u0001\u001a\u00020QH\u0016J\t\u0010â\u0001\u001a\u00020]H\u0016J\t\u0010ã\u0001\u001a\u00020]H\u0016J\u0012\u0010ä\u0001\u001a\u00020]2\u0007\u0010°\u0001\u001a\u00020QH\u0016J\u001c\u0010å\u0001\u001a\u00020]2\b\u0010æ\u0001\u001a\u00030ç\u00012\u0007\u0010è\u0001\u001a\u00020QH\u0016J\u001a\u0010é\u0001\u001a\u00020]2\t\u0010ê\u0001\u001a\u0004\u0018\u00010hH\u0016¢\u0006\u0003\u0010ë\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u00010=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010D\u001a\u0004\u0018\u00010E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u0004\u0018\u00010I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010L\u001a\u0004\u0018\u00010M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010RR\u0014\u0010S\u001a\u00020Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010RR\u0014\u0010T\u001a\u00020Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010RR$\u0010V\u001a\u00020Q2\u0006\u0010U\u001a\u00020Q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bV\u0010R\"\u0004\bW\u0010X¨\u0006ì\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposerImplNoOp;", "Lcom/samsung/android/sdk/composer/ISpenComposerImpl;", "<init>", "()V", "accessibilityClassName", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "listenerManager", "Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "getListenerManager", "()Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "getNoteWritingViewManager", "()Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "convertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "getConvertToTextManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "mathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "getMathManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "hwrGenerator", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "getHwrGenerator", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "sTTManager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "getSTTManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "alignmentManager", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "getAlignmentManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "hwrBeautifierManager", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "getHwrBeautifierManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "notePdfManager", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "getNotePdfManager", "()Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "noteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "getNoteZoomScroller", "()Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "noteObjectInserter", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "getNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "notePageLayouter", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "getNotePageLayouter", "()Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "textManager", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "getTextManager", "()Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "noteLaserManager", "Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "getNoteLaserManager", "()Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "wNoteHelper", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "getWNoteHelper", "()Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "gestureController", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "smartScriptDocument", "Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "getSmartScriptDocument", "()Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "isEasyWritingPadEnabled", "", "()Z", "isMathEnabled", "isFbrDrawPadEnabledInEWP", "_enable", "isContextMenuEnabled", "setContextMenuEnabled", "(Z)V", "onGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", "onLayout", "changed", "left", "", "top", "right", "bottom", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onWindowFocusChanged", "hasWindowFocus", "onTouchEvent", "onHoverEvent", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onConfigurationChanged", "onScaleByScreenSize", "enable", "startWidth", "startHeight", "endWidth", "endHeight", "updateScreenOrientation", "context", "Landroid/content/Context;", "dispatchHoverEvent", "dispatchKeyEvent", "onPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "onResume", "onPause", "onTrimMemory", "level", "close", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setMode", "mode", "setEditMode", "setTextOnlyEnabled", "setWritingGuideLineEnabled", "setAutoCleanUpEnabled", "setLaserPenEnabled", "goToPage", "pageIndex", "requestAlignmentContent", "requestResetZoomScaleToDefault", "requestKeepPageFitToScreenWhenPageFit", "setAllwaysFitPageToScreen", "setPan", "panX", "", "panY", "searchText", "", "includeSearchData", "pauseSearchText", "resumeSearchText", "searchFocusNext", "searchFocusPrev", "setSearchFocus", "focusId", "clearSearch", "cancelSearch", "startActionMode", "stopActionMode", "setDarkModeEnabled", "enabled", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setStrokeRemoverTouchMargin", "captureCurrentView", "Landroid/graphics/Bitmap;", "setEasyWritingPadEnable", "setActionLinkEnabled", "setActionLinkVisible", "visible", "setVoiceSyncPlayEnabled", "setVoiceSyncPlayAutoScroll", "setAutoScrollEnabled", "setLongPressEnabled", "requestCancelTouch", "smoothScrollToFitPage", "smoothScrollToPage", "smoothScrollFitPageToScreen", "isFitToWidth", "smoothScrollToPageAndFitPageToScreen", "isFitToScreen", "isPageFitToScreen", "smoothScrollAndScaleToFitPage", "smoothScrollAndScaleToFitRect", "targetContentRect", "Landroid/graphics/RectF;", "smoothScrollAndScaleTo", "targetContentPoint", "Landroid/graphics/PointF;", "targetZoomScale", "stopGestureAnimation", "startLazyViewUpdate", "endLazyViewUpdate", "setImageCacheQuality", "imageCacheQuality", "setCaptureCurrentViewBmp", "bitmap", "setIsFbrSupportedFeature", "mIsFbrSupportedFeature", "setFrontBufferRenderingEnabledInEWP", "setUnbufferedDispatchEnabled", "setDvfsFling", "dvfsInterface", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "setVSTEnabled", "startContextMenuDelegate", "stopContextMenuDelegate", "setInputFormEnabled", "startStickyMemoIconAnimation", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "isShow", "setInitBackgroundColor", "color", "(Ljava/lang/Integer;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerImplNoOp implements ISpenComposerImpl {
    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void cancelSearch() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public Bitmap captureCurrentView() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void clearSearch() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void close() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean dispatchHoverEvent(@Nullable MotionEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void endLazyViewUpdate() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public CharSequence getAccessibilityClassName() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISPenAlignmentManager getAlignmentManager() {
        return new SpenAlignmentManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenControlObjectManager getControlObjectManager() {
        return new SpenControlObjectManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenConvertToTextManager getConvertToTextManager() {
        return new SpenConvertToTextManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenIGestureController getGestureController() {
        return new SpenGestureControllerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SPenHwrBeautifierManager getHwrBeautifierManager() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenHwrGenerator getHwrGenerator() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenComposerListenerManager getListenerManager() {
        return new SpenComposerListenerManager();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenIMathManager getMathManager() {
        return new SpenMathManagerNoOP();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenNoteLaserManager getNoteLaserManager() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenNoteObjectInserter getNoteObjectInserter() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNotePageLayouter getNotePageLayouter() {
        return new SpenNotePageLayouterNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNotePdfManager getNotePdfManager() {
        return new SpenNotePdfManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteWritingViewManager getNoteWritingViewManager() {
        return new SpenNoteWritingViewManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteZoomScroller getNoteZoomScroller() {
        return new SpenNoteZoomScrollerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISPenSTTManager getSTTManager() {
        return new SpenSTTManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenSmartScriptDocument getSmartScriptDocument() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteTextManager getTextManager() {
        return new SpenNoteTextManagerNoOp();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenWNoteHelper getWNoteHelper() {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void goToPage(int pageIndex) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isContextMenuEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isEasyWritingPadEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isFbrDrawPadEnabledInEWP() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isFitToScreen(boolean isFitToWidth) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isMathEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isPageFitToScreen(int pageIndex, boolean isFitToWidth) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onAttachedToWindow() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onConfigurationChanged() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onCreateContextMenu(@Nullable ContextMenu menu) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onDraw(@Nullable Canvas canvas) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onGenericMotionEvent(@Nullable MotionEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onHoverEvent(@Nullable MotionEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyPreIme(int keyCode, @Nullable KeyEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyShortcut(int keyCode, @Nullable KeyEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onPause() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onPopulateAccessibilityEvent(@Nullable AccessibilityEvent event) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onResume() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onScaleByScreenSize(boolean enable, int startWidth, int startHeight, int endWidth, int endHeight) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onTrimMemory(int level) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onWindowFocusChanged(boolean hasWindowFocus) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean pauseSearchText() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestAlignmentContent(int pageIndex) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestCancelTouch() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestKeepPageFitToScreenWhenPageFit() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestResetZoomScaleToDefault() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean resumeSearchText(@Nullable String searchText, boolean includeSearchData) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchFocusNext() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchFocusPrev() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchText(@Nullable String searchText, boolean includeSearchData) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setActionLinkEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setActionLinkVisible(boolean visible) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAllwaysFitPageToScreen(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAutoCleanUpEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAutoScrollEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setCaptureCurrentViewBmp(@Nullable Bitmap bitmap) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setColorTheme(int theme) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setContextMenuEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setDarkModeEnabled(boolean enabled) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setDocument(@Nullable SpenWNote doc) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setDvfsFling(@Nullable SpenDvfsInterface dvfsInterface) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setEasyWritingPadEnable(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setEditMode(int mode) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setFrontBufferRenderingEnabledInEWP(boolean enabled) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setImageCacheQuality(int imageCacheQuality) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setInitBackgroundColor(@Nullable Integer color) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setInputFormEnabled(boolean enabled) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setLaserPenEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Deprecated(message = "")
    public void setLongPressEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setMode(int mode) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setPan(float panX, float panY) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setSearchFocus(int focusId) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setStrokeRemoverTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setTextOnlyEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setUnbufferedDispatchEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVSTEnabled(boolean enabled) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVoiceSyncPlayAutoScroll(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVoiceSyncPlayEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setWritingGuideLineEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleTo(@Nullable PointF targetContentPoint, float targetZoomScale) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleToFitPage(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleToFitRect(@Nullable RectF targetContentRect) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollFitPageToScreen(boolean isFitToWidth) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void smoothScrollToFitPage() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollToPage(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollToPageAndFitPageToScreen(int pageIndex, boolean isFitToWidth) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startActionMode() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startContextMenuDelegate() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startLazyViewUpdate() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startStickyMemoIconAnimation(@NotNull SpenCustomObject customObject, boolean isShow) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopActionMode() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopContextMenuDelegate() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopGestureAnimation() {
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void updateScreenOrientation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
