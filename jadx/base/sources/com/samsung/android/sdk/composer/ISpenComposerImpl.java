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
import com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrgen.SpenHwrGenerator;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 é\u00012\u00020\u0001:\u0002é\u0001J\u0012\u0010V\u001a\u00020O2\b\u0010W\u001a\u0004\u0018\u00010XH&J\b\u0010Y\u001a\u00020ZH&J\b\u0010[\u001a\u00020ZH&J\u0012\u0010\\\u001a\u00020Z2\b\u0010]\u001a\u0004\u0018\u00010^H&J\u0012\u0010_\u001a\u00020Z2\b\u0010`\u001a\u0004\u0018\u00010aH&J0\u0010b\u001a\u00020Z2\u0006\u0010c\u001a\u00020O2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020e2\u0006\u0010g\u001a\u00020e2\u0006\u0010h\u001a\u00020eH&J\"\u0010i\u001a\u00020Z2\u0006\u0010j\u001a\u00020O2\u0006\u0010k\u001a\u00020e2\b\u0010l\u001a\u0004\u0018\u00010mH&J\u0010\u0010n\u001a\u00020Z2\u0006\u0010o\u001a\u00020OH&J\u0012\u0010p\u001a\u00020O2\b\u0010W\u001a\u0004\u0018\u00010XH&J\u0012\u0010q\u001a\u00020O2\b\u0010W\u001a\u0004\u0018\u00010XH&J\u001a\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020e2\b\u0010W\u001a\u0004\u0018\u00010tH&J\u001a\u0010u\u001a\u00020O2\u0006\u0010s\u001a\u00020e2\b\u0010W\u001a\u0004\u0018\u00010tH&J\u001a\u0010v\u001a\u00020O2\u0006\u0010s\u001a\u00020e2\b\u0010W\u001a\u0004\u0018\u00010tH&J\u001a\u0010w\u001a\u00020O2\u0006\u0010s\u001a\u00020e2\b\u0010W\u001a\u0004\u0018\u00010tH&J\b\u0010x\u001a\u00020ZH&J0\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020O2\u0006\u0010{\u001a\u00020e2\u0006\u0010|\u001a\u00020e2\u0006\u0010}\u001a\u00020e2\u0006\u0010~\u001a\u00020eH&J\u0012\u0010\u007f\u001a\u00020Z2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H&J\u0013\u0010\u0082\u0001\u001a\u00020O2\b\u0010W\u001a\u0004\u0018\u00010XH&J\u0011\u0010\u0083\u0001\u001a\u00020O2\u0006\u0010W\u001a\u00020tH&J\u0014\u0010\u0084\u0001\u001a\u00020Z2\t\u0010W\u001a\u0005\u0018\u00010\u0085\u0001H&J\t\u0010\u0086\u0001\u001a\u00020ZH&J\t\u0010\u0087\u0001\u001a\u00020ZH&J\u0012\u0010\u0088\u0001\u001a\u00020Z2\u0007\u0010\u0089\u0001\u001a\u00020eH&J\t\u0010\u008a\u0001\u001a\u00020ZH&J\u0015\u0010\u008b\u0001\u001a\u00020O2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H&J\u0012\u0010\u008e\u0001\u001a\u00020Z2\u0007\u0010\u008f\u0001\u001a\u00020eH&J\u0012\u0010\u0090\u0001\u001a\u00020Z2\u0007\u0010\u008f\u0001\u001a\u00020eH&J\u0011\u0010\u0091\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010\u0092\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010\u0093\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010\u0094\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0012\u0010\u0095\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020eH&J\u0012\u0010\u0097\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020eH&J\t\u0010\u0098\u0001\u001a\u00020ZH&J\t\u0010\u0099\u0001\u001a\u00020ZH&J\u0011\u0010\u009a\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u001d\u0010\u009b\u0001\u001a\u00020Z2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H&J\u001e\u0010\u009f\u0001\u001a\u00020e2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\u0007\u0010¡\u0001\u001a\u00020OH&J\t\u0010¢\u0001\u001a\u00020OH&J\u001e\u0010£\u0001\u001a\u00020O2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\u0007\u0010¡\u0001\u001a\u00020OH&J\t\u0010¤\u0001\u001a\u00020eH&J\t\u0010¥\u0001\u001a\u00020eH&J\u0012\u0010¦\u0001\u001a\u00020O2\u0007\u0010§\u0001\u001a\u00020eH&J\t\u0010¨\u0001\u001a\u00020ZH&J\t\u0010©\u0001\u001a\u00020ZH&J\t\u0010ª\u0001\u001a\u00020ZH&J\t\u0010«\u0001\u001a\u00020ZH&J\u0012\u0010¬\u0001\u001a\u00020Z2\u0007\u0010\u00ad\u0001\u001a\u00020OH&J\u0012\u0010®\u0001\u001a\u00020Z2\u0007\u0010¯\u0001\u001a\u00020eH&J-\u0010°\u0001\u001a\u00020Z2\u0007\u0010±\u0001\u001a\u00020e2\u0007\u0010²\u0001\u001a\u00020e2\u0007\u0010³\u0001\u001a\u00020e2\u0007\u0010´\u0001\u001a\u00020eH&J-\u0010µ\u0001\u001a\u00020Z2\u0007\u0010±\u0001\u001a\u00020e2\u0007\u0010²\u0001\u001a\u00020e2\u0007\u0010³\u0001\u001a\u00020e2\u0007\u0010´\u0001\u001a\u00020eH&J\f\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H&J\u0011\u0010¸\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010¹\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0012\u0010º\u0001\u001a\u00020Z2\u0007\u0010»\u0001\u001a\u00020OH&J\u0011\u0010¼\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010½\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010¾\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0011\u0010¿\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH'J\t\u0010À\u0001\u001a\u00020ZH&J\t\u0010Á\u0001\u001a\u00020ZH&J\u0012\u0010Â\u0001\u001a\u00020O2\u0007\u0010\u0096\u0001\u001a\u00020eH&J\u0012\u0010Ã\u0001\u001a\u00020O2\u0007\u0010Ä\u0001\u001a\u00020OH&J\u001b\u0010Å\u0001\u001a\u00020O2\u0007\u0010\u0096\u0001\u001a\u00020e2\u0007\u0010Ä\u0001\u001a\u00020OH&J\u0012\u0010Æ\u0001\u001a\u00020O2\u0007\u0010Ä\u0001\u001a\u00020OH&J\u001b\u0010Ç\u0001\u001a\u00020O2\u0007\u0010\u0096\u0001\u001a\u00020e2\u0007\u0010Ä\u0001\u001a\u00020OH&J\u0012\u0010È\u0001\u001a\u00020O2\u0007\u0010\u0096\u0001\u001a\u00020eH&J\u0015\u0010É\u0001\u001a\u00020O2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H&J\u001f\u0010Ì\u0001\u001a\u00020O2\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u00012\b\u0010Ï\u0001\u001a\u00030\u009d\u0001H&J\t\u0010Ð\u0001\u001a\u00020ZH&J\t\u0010Ñ\u0001\u001a\u00020ZH&J\t\u0010Ò\u0001\u001a\u00020ZH&J\u0012\u0010Ó\u0001\u001a\u00020Z2\u0007\u0010Ô\u0001\u001a\u00020eH&J\u0015\u0010Õ\u0001\u001a\u00020Z2\n\u0010Ö\u0001\u001a\u0005\u0018\u00010·\u0001H&J\u0012\u0010×\u0001\u001a\u00020Z2\u0007\u0010Ø\u0001\u001a\u00020OH&J\u0012\u0010Ù\u0001\u001a\u00020O2\u0007\u0010\u00ad\u0001\u001a\u00020OH&J\u0011\u0010Ú\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020OH&J\u0015\u0010Û\u0001\u001a\u00020Z2\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H&J\u0012\u0010Þ\u0001\u001a\u00020Z2\u0007\u0010\u00ad\u0001\u001a\u00020OH&J\t\u0010ß\u0001\u001a\u00020ZH&J\t\u0010à\u0001\u001a\u00020ZH&J\u0012\u0010á\u0001\u001a\u00020Z2\u0007\u0010\u00ad\u0001\u001a\u00020OH&J\u001c\u0010â\u0001\u001a\u00020Z2\b\u0010ã\u0001\u001a\u00030ä\u00012\u0007\u0010å\u0001\u001a\u00020OH&J\u001a\u0010æ\u0001\u001a\u00020Z2\t\u0010ç\u0001\u001a\u0004\u0018\u00010eH&¢\u0006\u0003\u0010è\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u0004\u0018\u00010+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u0004\u0018\u00010/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0004\u0018\u000103X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u0004\u0018\u000107X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u0004\u0018\u00010;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u0004\u0018\u00010?X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u0004\u0018\u00010CX¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u0004\u0018\u00010GX¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u0004\u0018\u00010KX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0012\u0010N\u001a\u00020OX¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010PR\u0012\u0010Q\u001a\u00020OX¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010PR\u0012\u0010R\u001a\u00020OX¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0018\u0010S\u001a\u00020OX¦\u000e¢\u0006\f\u001a\u0004\bS\u0010P\"\u0004\bT\u0010U¨\u0006ê\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/ISpenComposerImpl;", "", "accessibilityClassName", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "listenerManager", "Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "getListenerManager", "()Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "getNoteWritingViewManager", "()Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "convertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "getConvertToTextManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "mathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "getMathManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "hwrGenerator", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "getHwrGenerator", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "sTTManager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "getSTTManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "alignmentManager", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "getAlignmentManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "hwrBeautifierManager", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "getHwrBeautifierManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "notePdfManager", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "getNotePdfManager", "()Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "noteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "getNoteZoomScroller", "()Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "noteObjectInserter", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "getNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "notePageLayouter", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "getNotePageLayouter", "()Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "textManager", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "getTextManager", "()Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "noteLaserManager", "Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "getNoteLaserManager", "()Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "wNoteHelper", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "getWNoteHelper", "()Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "gestureController", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "smartScriptDocument", "Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "getSmartScriptDocument", "()Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "isEasyWritingPadEnabled", "", "()Z", "isMathEnabled", "isFbrDrawPadEnabledInEWP", "isContextMenuEnabled", "setContextMenuEnabled", "(Z)V", "onGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", "onLayout", "changed", "left", "", "top", "right", "bottom", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onWindowFocusChanged", "hasWindowFocus", "onTouchEvent", "onHoverEvent", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onConfigurationChanged", "onScaleByScreenSize", "enable", "startWidth", "startHeight", "endWidth", "endHeight", "updateScreenOrientation", "context", "Landroid/content/Context;", "dispatchHoverEvent", "dispatchKeyEvent", "onPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "onResume", "onPause", "onTrimMemory", "level", "close", "setDocument", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setMode", "mode", "setEditMode", "setTextOnlyEnabled", "setWritingGuideLineEnabled", "setAutoCleanUpEnabled", "setLaserPenEnabled", "goToPage", "pageIndex", "requestAlignmentContent", "requestResetZoomScaleToDefault", "requestKeepPageFitToScreenWhenPageFit", "setAllwaysFitPageToScreen", "setPan", "panX", "", "panY", "searchText", "", "includeSearchData", "pauseSearchText", "resumeSearchText", "searchFocusNext", "searchFocusPrev", "setSearchFocus", "focusId", "clearSearch", "cancelSearch", "startActionMode", "stopActionMode", "setDarkModeEnabled", "enabled", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setStrokeRemoverTouchMargin", "captureCurrentView", "Landroid/graphics/Bitmap;", "setEasyWritingPadEnable", "setActionLinkEnabled", "setActionLinkVisible", "visible", "setVoiceSyncPlayEnabled", "setVoiceSyncPlayAutoScroll", "setAutoScrollEnabled", "setLongPressEnabled", "requestCancelTouch", "smoothScrollToFitPage", "smoothScrollToPage", "smoothScrollFitPageToScreen", "isFitToWidth", "smoothScrollToPageAndFitPageToScreen", "isFitToScreen", "isPageFitToScreen", "smoothScrollAndScaleToFitPage", "smoothScrollAndScaleToFitRect", "targetContentRect", "Landroid/graphics/RectF;", "smoothScrollAndScaleTo", "targetContentPoint", "Landroid/graphics/PointF;", "targetZoomScale", "stopGestureAnimation", "startLazyViewUpdate", "endLazyViewUpdate", "setImageCacheQuality", "imageCacheQuality", "setCaptureCurrentViewBmp", "bitmap", "setIsFbrSupportedFeature", "mIsFbrSupportedFeature", "setFrontBufferRenderingEnabledInEWP", "setUnbufferedDispatchEnabled", "setDvfsFling", "dvfsInterface", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "setVSTEnabled", "startContextMenuDelegate", "stopContextMenuDelegate", "setInputFormEnabled", "startStickyMemoIconAnimation", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "isShow", "setInitBackgroundColor", "color", "(Ljava/lang/Integer;)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenComposerImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DRAW_LOOP_TYPE_AGLL = 2;
    public static final int DRAW_LOOP_TYPE_HWUI = 0;
    public static final int DRAW_LOOP_TYPE_HW_BUFFER = 3;
    public static final int DRAW_LOOP_TYPE_TEXTURE_VIEW = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/ISpenComposerImpl$Companion;", "", "<init>", "()V", "DRAW_LOOP_TYPE_HWUI", "", "DRAW_LOOP_TYPE_TEXTURE_VIEW", "DRAW_LOOP_TYPE_AGLL", "DRAW_LOOP_TYPE_HW_BUFFER", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DRAW_LOOP_TYPE_AGLL = 2;
        public static final int DRAW_LOOP_TYPE_HWUI = 0;
        public static final int DRAW_LOOP_TYPE_HW_BUFFER = 3;
        public static final int DRAW_LOOP_TYPE_TEXTURE_VIEW = 1;

        private Companion() {
        }
    }

    void cancelSearch();

    @Nullable
    Bitmap captureCurrentView();

    void clearSearch();

    void close();

    boolean dispatchHoverEvent(@Nullable MotionEvent event);

    boolean dispatchKeyEvent(@NotNull KeyEvent event);

    void endLazyViewUpdate();

    @Nullable
    CharSequence getAccessibilityClassName();

    @Nullable
    ISPenAlignmentManager getAlignmentManager();

    @Nullable
    ISpenControlObjectManager getControlObjectManager();

    @Nullable
    ISpenConvertToTextManager getConvertToTextManager();

    @Nullable
    SpenIGestureController getGestureController();

    @Nullable
    SPenHwrBeautifierManager getHwrBeautifierManager();

    @Nullable
    SpenHwrGenerator getHwrGenerator();

    @Nullable
    SpenComposerListenerManager getListenerManager();

    @Nullable
    SpenIMathManager getMathManager();

    @Nullable
    SpenNoteLaserManager getNoteLaserManager();

    @Nullable
    SpenNoteObjectInserter getNoteObjectInserter();

    @Nullable
    ISpenNotePageLayouter getNotePageLayouter();

    @Nullable
    ISpenNotePdfManager getNotePdfManager();

    @Nullable
    ISpenNoteWritingViewManager getNoteWritingViewManager();

    @Nullable
    ISpenNoteZoomScroller getNoteZoomScroller();

    @Nullable
    ISPenSTTManager getSTTManager();

    @Nullable
    SpenSmartScriptDocument getSmartScriptDocument();

    @Nullable
    ISpenNoteTextManager getTextManager();

    @Nullable
    SpenWNoteHelper getWNoteHelper();

    void goToPage(int pageIndex);

    boolean isContextMenuEnabled();

    boolean isEasyWritingPadEnabled();

    boolean isFbrDrawPadEnabledInEWP();

    boolean isFitToScreen(boolean isFitToWidth);

    boolean isMathEnabled();

    boolean isPageFitToScreen(int pageIndex, boolean isFitToWidth);

    void onAttachedToWindow();

    void onConfigurationChanged();

    void onCreateContextMenu(@Nullable ContextMenu menu);

    void onDetachedFromWindow();

    void onDraw(@Nullable Canvas canvas);

    void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect);

    boolean onGenericMotionEvent(@Nullable MotionEvent event);

    boolean onHoverEvent(@Nullable MotionEvent event);

    boolean onKeyDown(int keyCode, @Nullable KeyEvent event);

    boolean onKeyPreIme(int keyCode, @Nullable KeyEvent event);

    boolean onKeyShortcut(int keyCode, @Nullable KeyEvent event);

    boolean onKeyUp(int keyCode, @Nullable KeyEvent event);

    void onLayout(boolean changed, int left, int top, int right, int bottom);

    void onPause();

    void onPopulateAccessibilityEvent(@Nullable AccessibilityEvent event);

    void onResume();

    void onScaleByScreenSize(boolean enable, int startWidth, int startHeight, int endWidth, int endHeight);

    boolean onTouchEvent(@Nullable MotionEvent event);

    void onTrimMemory(int level);

    void onWindowFocusChanged(boolean hasWindowFocus);

    boolean pauseSearchText();

    void requestAlignmentContent(int pageIndex);

    void requestCancelTouch();

    void requestKeepPageFitToScreenWhenPageFit();

    void requestResetZoomScaleToDefault();

    boolean resumeSearchText(@Nullable String searchText, boolean includeSearchData);

    int searchFocusNext();

    int searchFocusPrev();

    int searchText(@Nullable String searchText, boolean includeSearchData);

    void setActionLinkEnabled(boolean enable);

    void setActionLinkVisible(boolean visible);

    void setAllwaysFitPageToScreen(boolean enable);

    void setAutoCleanUpEnabled(boolean enable);

    void setAutoScrollEnabled(boolean enable);

    void setCaptureCurrentViewBmp(@Nullable Bitmap bitmap);

    void setColorTheme(int theme);

    void setContextMenuEnabled(boolean z);

    void setDarkModeEnabled(boolean enabled);

    boolean setDocument(@Nullable SpenWNote doc);

    void setDvfsFling(@Nullable SpenDvfsInterface dvfsInterface);

    void setEasyWritingPadEnable(boolean enable);

    void setEditMode(int mode);

    boolean setFrontBufferRenderingEnabledInEWP(boolean enabled);

    void setImageCacheQuality(int imageCacheQuality);

    void setInitBackgroundColor(@Nullable Integer color);

    void setInputFormEnabled(boolean enabled);

    void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature);

    void setLaserPenEnabled(boolean enable);

    @Deprecated(message = "")
    void setLongPressEnabled(boolean enable);

    void setMode(int mode);

    void setPan(float panX, float panY);

    boolean setSearchFocus(int focusId);

    void setStrokeRemoverTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom);

    void setTextOnlyEnabled(boolean enable);

    void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom);

    void setUnbufferedDispatchEnabled(boolean enable);

    void setVSTEnabled(boolean enabled);

    void setVoiceSyncPlayAutoScroll(boolean enable);

    void setVoiceSyncPlayEnabled(boolean enable);

    void setWritingGuideLineEnabled(boolean enable);

    boolean smoothScrollAndScaleTo(@Nullable PointF targetContentPoint, float targetZoomScale);

    boolean smoothScrollAndScaleToFitPage(int pageIndex);

    boolean smoothScrollAndScaleToFitRect(@Nullable RectF targetContentRect);

    boolean smoothScrollFitPageToScreen(boolean isFitToWidth);

    void smoothScrollToFitPage();

    boolean smoothScrollToPage(int pageIndex);

    boolean smoothScrollToPageAndFitPageToScreen(int pageIndex, boolean isFitToWidth);

    void startActionMode();

    void startContextMenuDelegate();

    void startLazyViewUpdate();

    void startStickyMemoIconAnimation(@NotNull SpenCustomObject customObject, boolean isShow);

    void stopActionMode();

    void stopContextMenuDelegate();

    void stopGestureAnimation();

    void updateScreenOrientation(@NotNull Context context);
}
