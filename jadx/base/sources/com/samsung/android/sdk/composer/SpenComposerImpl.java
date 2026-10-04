package com.samsung.android.sdk.composer;

import android.R;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.document.capture.SpenNoteCapturePage;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.composer.input.ISpenNotePageLayouter;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.input.SpenNotePageLayouter;
import com.samsung.android.sdk.composer.listener.SpenComposerListenerManager;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfManager;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.composer.util.SpenComposerFeatures;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.composer.view.accessibility.AccessibilityDelegateImpl;
import com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener;
import com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityNodeInfo;
import com.samsung.android.sdk.composer.view.context.SpenComposerContext;
import com.samsung.android.sdk.composer.view.contextmenu.SpenComposerContextMenu;
import com.samsung.android.sdk.composer.view.contextmenu.SpenContextMenuDelegate;
import com.samsung.android.sdk.composer.view.deltaZoom.SpenNoteDeltaZoom;
import com.samsung.android.sdk.composer.view.floatingview.SpenFloatingViewManager;
import com.samsung.android.sdk.composer.view.floatingview.SpenImageFloatingViewListener;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;
import com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager;
import com.samsung.android.sdk.composer.writing.SpenEasyWritingPadManager;
import com.samsung.android.sdk.composer.writing.SpenNoteWritingViewManager;
import com.samsung.android.sdk.composer.writing.laserview.SpenNoteLaserManager;
import com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathListener;
import com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathManager;
import com.samsung.android.sdk.composer.writing.smartscript.SpenSmartScriptDocument;
import com.samsung.android.sdk.pdf.SpenPdfAIModelLoader;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.control.SpenControlObjectManager;
import com.samsung.android.sdk.pen.debug.ISpenGraphicMemoryLogger;
import com.samsung.android.sdk.pen.debug.SpenMemoryLoggerReceiver;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.engine.SpenGestureController;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.sdk.pen.engine.SpenWritingOptionPatternDetector;
import com.samsung.android.sdk.pen.engine.SpenWritingOptionView;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopAGLL;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopHWUI;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopHwBuffer;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture;
import com.samsung.android.sdk.pen.engine.drawLoop.SpenRenderer;
import com.samsung.android.sdk.pen.engine.edgeEffect.SpenEdgeEffectManager;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.pointericon.SpenHoverPointerIcon;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsInterface;
import com.samsung.android.sdk.pen.engine.power.SpenDvfsManager;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.recoguifeature.hwrgen.SpenHwrGenerator;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTTextListener;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sdk.pen.view.gesture.SpenGesture;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.spen.libwrapper.MotionEventWrapper;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000À\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  \u00032\u00020\u0001:\u0002 \u0003B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010Ï\u0001\u001a\u00020\u000f2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010Ó\u0001\u001a\u00030Ò\u0001H\u0016J\u0016\u0010Ô\u0001\u001a\u00030Ò\u00012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0016J\u0016\u0010×\u0001\u001a\u00030Ò\u00012\n\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001H\u0016J7\u0010Ú\u0001\u001a\u00030Ò\u00012\u0007\u0010Û\u0001\u001a\u00020\u000f2\u0007\u0010Ü\u0001\u001a\u00020\u00072\u0007\u0010Ý\u0001\u001a\u00020\u00072\u0007\u0010Þ\u0001\u001a\u00020\u00072\u0007\u0010ß\u0001\u001a\u00020\u0007H\u0017J'\u0010à\u0001\u001a\u00030Ò\u00012\u0007\u0010á\u0001\u001a\u00020\u000f2\u0007\u0010â\u0001\u001a\u00020\u00072\t\u0010ã\u0001\u001a\u0004\u0018\u00010\u0017H\u0016J\u0013\u0010ä\u0001\u001a\u00030Ò\u00012\u0007\u0010å\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010æ\u0001\u001a\u00030Ò\u00012\u0007\u0010Ð\u0001\u001a\u00020\u001dH\u0002J\u0014\u0010ç\u0001\u001a\u00020\u000f2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J\u0014\u0010è\u0001\u001a\u00020\u000f2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010é\u0001\u001a\u00020\u000f2\u0007\u0010ê\u0001\u001a\u00020\u00072\n\u0010Ð\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0016J\u001e\u0010ì\u0001\u001a\u00020\u000f2\u0007\u0010ê\u0001\u001a\u00020\u00072\n\u0010Ð\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0016J\u001e\u0010í\u0001\u001a\u00020\u000f2\u0007\u0010ê\u0001\u001a\u00020\u00072\n\u0010Ð\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0016J\u001e\u0010î\u0001\u001a\u00020\u000f2\u0007\u0010ê\u0001\u001a\u00020\u00072\n\u0010Ð\u0001\u001a\u0005\u0018\u00010ë\u0001H\u0016J\n\u0010ï\u0001\u001a\u00030Ò\u0001H\u0016J7\u0010ð\u0001\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000f2\u0007\u0010ñ\u0001\u001a\u00020\u00072\u0007\u0010ò\u0001\u001a\u00020\u00072\u0007\u0010ó\u0001\u001a\u00020\u00072\u0007\u0010ô\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010õ\u0001\u001a\u00030Ò\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010ö\u0001\u001a\u00020\u000f2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J\u0013\u0010÷\u0001\u001a\u00020\u000f2\b\u0010Ð\u0001\u001a\u00030ë\u0001H\u0016J\u0016\u0010ø\u0001\u001a\u00030Ò\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010ù\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010û\u0001\u001a\u00030Ò\u0001H\u0016J\u0013\u0010ü\u0001\u001a\u00030Ò\u00012\u0007\u0010ý\u0001\u001a\u00020\u0007H\u0016J\n\u0010þ\u0001\u001a\u00030Ò\u0001H\u0016J\u0014\u0010ÿ\u0001\u001a\u00020\u000f2\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\"H\u0016J\u0013\u0010\u0081\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0082\u0002\u001a\u00020\u0007H\u0016J\u0013\u0010\u0083\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0082\u0002\u001a\u00020\u0007H\u0016J\u0013\u0010\u0084\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0085\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0086\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0087\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0088\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0089\u0002\u001a\u00020\u0007H\u0016J\u0013\u0010\u008a\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0089\u0002\u001a\u00020\u0007H\u0016J\n\u0010\u008b\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010\u008c\u0002\u001a\u00030Ò\u0001H\u0016J\u0013\u0010\u008d\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u001e\u0010\u008e\u0002\u001a\u00030Ò\u00012\b\u0010\u008f\u0002\u001a\u00030\u0090\u00022\b\u0010\u0091\u0002\u001a\u00030\u0090\u0002H\u0016J\u001e\u0010\u0092\u0002\u001a\u00020\u00072\n\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u00022\u0007\u0010\u0094\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u0095\u0002\u001a\u00020\u000fH\u0016J\u001e\u0010\u0096\u0002\u001a\u00020\u000f2\n\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u00022\u0007\u0010\u0094\u0002\u001a\u00020\u000fH\u0016J\t\u0010\u0097\u0002\u001a\u00020\u0007H\u0016J\t\u0010\u0098\u0002\u001a\u00020\u0007H\u0016J\u0012\u0010\u0099\u0002\u001a\u00020\u000f2\u0007\u0010\u009a\u0002\u001a\u00020\u0007H\u0016J\n\u0010\u009b\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010\u009c\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010\u009d\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010\u009e\u0002\u001a\u00030Ò\u0001H\u0016J\u0013\u0010\u009f\u0002\u001a\u00030Ò\u00012\u0007\u0010 \u0002\u001a\u00020\u000fH\u0016J\u0013\u0010¡\u0002\u001a\u00030Ò\u00012\u0007\u0010¢\u0002\u001a\u00020\u0007H\u0016J.\u0010£\u0002\u001a\u00030Ò\u00012\u0007\u0010¤\u0002\u001a\u00020\u00072\u0007\u0010¥\u0002\u001a\u00020\u00072\u0007\u0010¦\u0002\u001a\u00020\u00072\u0007\u0010§\u0002\u001a\u00020\u0007H\u0016J.\u0010¨\u0002\u001a\u00030Ò\u00012\u0007\u0010¤\u0002\u001a\u00020\u00072\u0007\u0010¥\u0002\u001a\u00020\u00072\u0007\u0010¦\u0002\u001a\u00020\u00072\u0007\u0010§\u0002\u001a\u00020\u0007H\u0016J\f\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002H\u0016J\u0013\u0010«\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010¬\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u00ad\u0002\u001a\u00030Ò\u00012\u0007\u0010®\u0002\u001a\u00020\u000fH\u0016J\u0013\u0010¯\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010°\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010±\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010²\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0017J\n\u0010³\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010´\u0002\u001a\u00030Ò\u0001H\u0016J\u0012\u0010µ\u0002\u001a\u00020\u000f2\u0007\u0010\u0089\u0002\u001a\u00020\u0007H\u0016J\u0012\u0010¶\u0002\u001a\u00020\u000f2\u0007\u0010·\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010¸\u0002\u001a\u00020\u000f2\u0007\u0010\u0089\u0002\u001a\u00020\u00072\u0007\u0010·\u0002\u001a\u00020\u000fH\u0016J\u0012\u0010¹\u0002\u001a\u00020\u000f2\u0007\u0010·\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010º\u0002\u001a\u00020\u000f2\u0007\u0010\u0089\u0002\u001a\u00020\u00072\u0007\u0010·\u0002\u001a\u00020\u000fH\u0016J\u0012\u0010»\u0002\u001a\u00020\u000f2\u0007\u0010\u0089\u0002\u001a\u00020\u0007H\u0016J\u0014\u0010¼\u0002\u001a\u00020\u000f2\t\u0010½\u0002\u001a\u0004\u0018\u00010\u0015H\u0016J\u001f\u0010¾\u0002\u001a\u00020\u000f2\n\u0010¿\u0002\u001a\u0005\u0018\u00010À\u00022\b\u0010Á\u0002\u001a\u00030\u0090\u0002H\u0016J\n\u0010Â\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010Ã\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010Ä\u0002\u001a\u00030Ò\u0001H\u0016J\u0013\u0010Å\u0002\u001a\u00030Ò\u00012\u0007\u0010Æ\u0002\u001a\u00020\u0007H\u0016J\u001d\u0010Ç\u0002\u001a\u00030Ò\u00012\b\u0010È\u0002\u001a\u00030É\u00022\u0007\u0010Ê\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010Ë\u0002\u001a\u00030Ò\u00012\t\u0010Ì\u0002\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0003\u0010Í\u0002J\u0016\u0010Î\u0002\u001a\u00030Ò\u00012\n\u0010Ï\u0002\u001a\u0005\u0018\u00010ª\u0002H\u0017J*\u0010Ð\u0002\u001a\u00030Ò\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010Ñ\u0002\u001a\u0005\u0018\u00010Ò\u00022\n\u0010Ó\u0002\u001a\u0005\u0018\u00010Ô\u0002H\u0002J\n\u0010Õ\u0002\u001a\u00030Ò\u0001H\u0002J\n\u0010Ö\u0002\u001a\u00030Ò\u0001H\u0002J\u0013\u0010×\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0089\u0002\u001a\u00020\u0007H\u0002J\u0013\u0010Ø\u0002\u001a\u00030Ò\u00012\u0007\u0010Ù\u0002\u001a\u00020\u0007H\u0002J.\u0010Ú\u0002\u001a\u00030Ò\u00012\u0007\u0010Û\u0002\u001a\u00020\u00072\u0007\u0010Ü\u0002\u001a\u00020\u00072\u0007\u0010Ý\u0002\u001a\u00020\u000f2\u0007\u0010Þ\u0002\u001a\u00020\u000fH\u0002J\u0013\u0010ß\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0082\u0002\u001a\u00020\u0007H\u0002JU\u0010à\u0002\u001a\u00030Ò\u00012\u001f\u0010á\u0002\u001a\u001a\u0012\u0007\u0012\u0005\u0018\u00010Ò\u00020â\u0002j\f\u0012\u0007\u0012\u0005\u0018\u00010Ò\u0002`ã\u00022\u001f\u0010ä\u0002\u001a\u001a\u0012\u0007\u0012\u0005\u0018\u00010Ô\u00020â\u0002j\f\u0012\u0007\u0012\u0005\u0018\u00010Ô\u0002`ã\u00022\u0007\u0010å\u0002\u001a\u00020\u000fH\u0002J\u001d\u0010æ\u0002\u001a\u00030Ò\u00012\u0007\u0010ç\u0002\u001a\u00020\u00072\b\u0010è\u0002\u001a\u00030Ô\u0002H\u0002J%\u0010é\u0002\u001a\u00030Ò\u00012\u0007\u0010ê\u0002\u001a\u00020\u00072\u0007\u0010®\u0002\u001a\u00020\u000f2\u0007\u0010ë\u0002\u001a\u00020\u0007H\u0002J\u0013\u0010ì\u0002\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0002J0\u0010í\u0002\u001a\u00030Ò\u00012\u0007\u0010î\u0002\u001a\u00020\u00152\b\u0010ï\u0002\u001a\u00030\u0093\u00022\b\u0010ð\u0002\u001a\u00030\u0090\u00022\u0007\u0010ñ\u0002\u001a\u00020\u0007H\u0002J&\u0010ò\u0002\u001a\u00030Ò\u00012\u0007\u0010î\u0002\u001a\u00020\u00152\b\u0010ï\u0002\u001a\u00030\u0093\u00022\u0007\u0010ñ\u0002\u001a\u00020\u0007H\u0002J)\u0010ó\u0002\u001a\u00030Ò\u00012\u0007\u0010î\u0002\u001a\u00020\u00152\n\u0010ô\u0002\u001a\u0005\u0018\u00010\u0093\u00022\b\u0010ð\u0002\u001a\u00030\u0090\u0002H\u0002J\u0013\u0010õ\u0002\u001a\u00030Ò\u00012\u0007\u0010ê\u0002\u001a\u00020\u0007H\u0002J\u0013\u0010ö\u0002\u001a\u00030Ò\u00012\u0007\u0010÷\u0002\u001a\u00020\u000fH\u0002J\u001f\u0010ø\u0002\u001a\u00030Ò\u00012\n\u0010ù\u0002\u001a\u0005\u0018\u00010\u0093\u00022\u0007\u0010ú\u0002\u001a\u00020\u0007H\u0002JB\u0010û\u0002\u001a\u00030Ò\u00012\u0007\u0010Ü\u0001\u001a\u00020\u000f2\u0007\u0010Ý\u0001\u001a\u00020\u000f2\u0007\u0010Þ\u0001\u001a\u00020\u000f2\u0007\u0010ß\u0001\u001a\u00020\u000f2\b\u0010ü\u0002\u001a\u00030\u0090\u00022\b\u0010ý\u0002\u001a\u00030\u0090\u0002H\u0002J\n\u0010þ\u0002\u001a\u00030Ò\u0001H\u0002J\n\u0010ÿ\u0002\u001a\u00030Ò\u0001H\u0002J\u001f\u0010\u0080\u0003\u001a\u00030Ò\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u00072\n\u0010\u0082\u0003\u001a\u0005\u0018\u00010\u0083\u0003H\u0002J\u0013\u0010\u0084\u0003\u001a\u00030Ò\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0007H\u0002J1\u0010\u0085\u0003\u001a\u00030Ò\u00012\b\u0010\u0086\u0003\u001a\u00030\u0090\u00022\b\u0010\u0087\u0003\u001a\u00030\u0090\u00022\b\u0010\u0088\u0003\u001a\u00030\u0090\u00022\u0007\u0010\u0089\u0003\u001a\u00020\u000fH\u0002J\u0013\u0010\u008a\u0003\u001a\u00030Ò\u00012\u0007\u0010\u008b\u0003\u001a\u00020\u0007H\u0002J\n\u0010\u008c\u0003\u001a\u00030Ò\u0001H\u0002J\n\u0010\u008d\u0003\u001a\u00030Ò\u0001H\u0002J\u0014\u0010\u008e\u0003\u001a\u00030Ò\u00012\b\u0010È\u0002\u001a\u00030É\u0002H\u0002J!\u0010\u008f\u0003\u001a\u00030Ò\u00012\n\u0010È\u0002\u001a\u0005\u0018\u00010É\u00022\t\u0010î\u0002\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010\u0090\u0003\u001a\u00030Ò\u00012\b\u0010È\u0002\u001a\u00030É\u0002H\u0002J\u001a\u0010\u0091\u0003\u001a\u00030Ò\u00012\u000e\u0010\u0092\u0003\u001a\t\u0012\u0004\u0012\u00020\u00170\u0093\u0003H\u0002J\n\u0010\u0094\u0003\u001a\u00030Ò\u0001H\u0002J\u0012\u0010\u0095\u0003\u001a\u00030Ò\u00012\u0006\u0010|\u001a\u00020\u000fH\u0016J\u0012\u0010\u0096\u0003\u001a\u00020\u000f2\u0007\u0010 \u0002\u001a\u00020\u000fH\u0016J\u0013\u0010\u0097\u0003\u001a\u00030Ò\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000fH\u0016J\u0016\u0010\u0098\u0003\u001a\u00030Ò\u00012\n\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u009a\u0003H\u0016J\u0013\u0010\u009b\u0003\u001a\u00030Ò\u00012\u0007\u0010 \u0002\u001a\u00020\u000fH\u0016J\n\u0010\u009c\u0003\u001a\u00030Ò\u0001H\u0016J\n\u0010\u009d\u0003\u001a\u00030Ò\u0001H\u0016J\u0013\u0010\u009e\u0003\u001a\u00030Ò\u00012\u0007\u0010 \u0002\u001a\u00020\u000fH\u0016J\t\u0010\u009f\u0003\u001a\u00020\u0005H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010/\u001a\u0004\u0018\u000100@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010/\u001a\u0004\u0018\u00010@@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010G\u001a\u0004\u0018\u00010F2\b\u0010/\u001a\u0004\u0018\u00010F@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010W\u001a\u0004\u0018\u00010V2\b\u0010/\u001a\u0004\u0018\u00010V@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010e\u001a\u0004\u0018\u00010d2\b\u0010/\u001a\u0004\u0018\u00010d@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010k\u001a\u0004\u0018\u00010j2\b\u0010/\u001a\u0004\u0018\u00010j@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\"\u0010o\u001a\u0004\u0018\u00010n2\b\u0010/\u001a\u0004\u0018\u00010n@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0091\u0001\u001a\u00030\u0092\u00018\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0093\u0001\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\u00078BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u001a\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010¨\u0001\u001a\u0005\u0018\u00010©\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u001a\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010°\u0001\u001a\u0005\u0018\u00010±\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u001a\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u001a\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u001a\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0017\u0010È\u0001\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÈ\u0001\u0010\u0094\u0001R\u0017\u0010É\u0001\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010\u0094\u0001R\u0017\u0010Ê\u0001\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010\u0094\u0001R*\u0010Ì\u0001\u001a\u00020\u000f2\u0007\u0010Ë\u0001\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÌ\u0001\u0010\u0094\u0001\"\u0006\bÍ\u0001\u0010Î\u0001¨\u0006¡\u0003"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposerImpl;", "Lcom/samsung/android/sdk/composer/ISpenComposerImpl;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "createType", "", "drawLoopType", "<init>", "(Landroid/content/Context;Landroid/view/View;II)V", "mNativeHandle", "", "mView", "mIsOnLayout", "", "mIsRequestTouchCancel", "mIsShiftPressed", "mScreenWidth", "mScreenHeight", "mAllowTouchRect", "Landroid/graphics/RectF;", "mTouchMargin", "Landroid/graphics/Rect;", "mAllowStrokeRemoverTouchRect", "mStrokeRemoverTouchMargin", "mIsDisAllowTouch", "mIsTouchDown", "mCurrentMotionEvent", "Landroid/view/MotionEvent;", "mIsPenButtonEnabledAtActionDown", "mRenderer", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenRenderer;", "mDocument", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mSpenDrawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "mSpenDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mSpenConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "mSpenDeltaZoom", "Lcom/samsung/android/sdk/composer/view/deltaZoom/SpenNoteDeltaZoom;", "mSpenNoteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/SpenNoteZoomScroller;", "mSpenComposerContext", "Lcom/samsung/android/sdk/composer/view/context/SpenComposerContext;", "value", "Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "listenerManager", "getListenerManager", "()Lcom/samsung/android/sdk/composer/listener/SpenComposerListenerManager;", "mContextMenu", "Lcom/samsung/android/sdk/composer/view/contextmenu/SpenComposerContextMenu;", "mContextMenuDelegate", "Lcom/samsung/android/sdk/composer/view/contextmenu/SpenContextMenuDelegate;", "mNoteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/SpenNoteWritingViewManager;", "mConvertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextManager;", "mMathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathManager;", "mTextMathManager", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "hwrGenerator", "getHwrGenerator", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrgen/SpenHwrGenerator;", "mSTTManager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTManager;", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "hwrBeautifierManager", "getHwrBeautifierManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "mAlignmentManager", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SPenAlignmentManager;", "mEasyWritingPadManager", "Lcom/samsung/android/sdk/composer/writing/SpenEasyWritingPadManager;", "mNotePdfManager", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfManager;", "mNoteTextManager", "Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;", "mControlObjectManager", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectManager;", "mFloatingViewManager", "Lcom/samsung/android/sdk/composer/view/floatingview/SpenFloatingViewManager;", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "noteObjectInserter", "getNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "mNotePageLayouter", "Lcom/samsung/android/sdk/composer/input/SpenNotePageLayouter;", "mHoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "mDvfsManager", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsManager;", "mEdgeEffectManager", "Lcom/samsung/android/sdk/pen/engine/edgeEffect/SpenEdgeEffectManager;", "mGestureController", "Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "wNoteHelper", "getWNoteHelper", "()Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "mSpenPenSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "noteLaserManager", "getNoteLaserManager", "()Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "smartScriptDocument", "getSmartScriptDocument", "()Lcom/samsung/android/sdk/composer/writing/smartscript/SpenSmartScriptDocument;", "mPdfAIModelLoader", "Lcom/samsung/android/sdk/pdf/SpenPdfAIModelLoader;", "mWritingOptionPatternDetector", "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionPatternDetector;", "mWritingOptionView", "Lcom/samsung/android/sdk/pen/engine/SpenWritingOptionView;", "mAccDelegateImpl", "Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityDelegateImpl;", "mFbrDrawPad", "Lcom/samsung/android/sdk/pen/engine/fbrDrawPad/SpenFbrDrawPad;", "mIsFbrSupportedFeature", "mContext", "mPrevEdgeAnimationState", "mDrawLoopType", "mTextureView", "Landroid/view/TextureView;", "mSurfaceView", "Landroid/view/SurfaceView;", "mSurfaceViewBG", "mTwinViewAgll", "mDocInited", "mHighTextContrastEnabled", "mIsUnbufferedDispatch", "mCapturePaint", "Landroid/graphics/Paint;", "mMemoryLoggerReceiver", "Lcom/samsung/android/sdk/pen/debug/SpenMemoryLoggerReceiver;", "mUseInitBackgroundColor", "mInitBackgroundColor", "mHandlerTwin", "Landroid/os/Handler;", "mRemoveTwinViewRunnable", "Ljava/lang/Runnable;", "isInputMethodShown", "()Z", "clearColor", "getClearColor", "()I", "accessibilityClassName", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "noteWritingViewManager", "Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "getNoteWritingViewManager", "()Lcom/samsung/android/sdk/composer/writing/ISpenNoteWritingViewManager;", "convertToTextManager", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "getConvertToTextManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/ISpenConvertToTextManager;", "mathManager", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "getMathManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenIMathManager;", "sTTManager", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "getSTTManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "alignmentManager", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "getAlignmentManager", "()Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "notePdfManager", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "getNotePdfManager", "()Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager;", "noteZoomScroller", "Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "getNoteZoomScroller", "()Lcom/samsung/android/sdk/composer/view/zoomScroller/ISpenNoteZoomScroller;", "notePageLayouter", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "getNotePageLayouter", "()Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "textManager", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "getTextManager", "()Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "controlObjectManager", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "getControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "gestureController", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "getGestureController", "()Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "isEasyWritingPadEnabled", "isMathEnabled", "isFbrDrawPadEnabledInEWP", "enable", "isContextMenuEnabled", "setContextMenuEnabled", "(Z)V", "onGenericMotionEvent", "event", "onAttachedToWindow", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", "onLayout", "changed", "left", "top", "right", "bottom", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "onWindowFocusChanged", "hasWindowFocus", "convertMotionEventPenButtonAction", "onTouchEvent", "onHoverEvent", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onConfigurationChanged", "onScaleByScreenSize", "startWidth", "startHeight", "endWidth", "endHeight", "updateScreenOrientation", "dispatchHoverEvent", "dispatchKeyEvent", "onPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "onResume", "onPause", "onTrimMemory", "level", "close", "setDocument", "doc", "setMode", "mode", "setEditMode", "setTextOnlyEnabled", "setWritingGuideLineEnabled", "setAutoCleanUpEnabled", "setLaserPenEnabled", "goToPage", "pageIndex", "requestAlignmentContent", "requestResetZoomScaleToDefault", "requestKeepPageFitToScreenWhenPageFit", "setAllwaysFitPageToScreen", "setPan", "panX", "", "panY", "searchText", "", "includeSearchData", "pauseSearchText", "resumeSearchText", "searchFocusNext", "searchFocusPrev", "setSearchFocus", "focusId", "clearSearch", "cancelSearch", "startActionMode", "stopActionMode", "setDarkModeEnabled", "enabled", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setStrokeRemoverTouchMargin", "captureCurrentView", "Landroid/graphics/Bitmap;", "setEasyWritingPadEnable", "setActionLinkEnabled", "setActionLinkVisible", "visible", "setVoiceSyncPlayEnabled", "setVoiceSyncPlayAutoScroll", "setAutoScrollEnabled", "setLongPressEnabled", "requestCancelTouch", "smoothScrollToFitPage", "smoothScrollToPage", "smoothScrollFitPageToScreen", "isFitToWidth", "smoothScrollToPageAndFitPageToScreen", "isFitToScreen", "isPageFitToScreen", "smoothScrollAndScaleToFitPage", "smoothScrollAndScaleToFitRect", "targetContentRect", "smoothScrollAndScaleTo", "targetContentPoint", "Landroid/graphics/PointF;", "targetZoomScale", "stopGestureAnimation", "startLazyViewUpdate", "endLazyViewUpdate", "setImageCacheQuality", "imageCacheQuality", "startStickyMemoIconAnimation", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "isShow", "setInitBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setCaptureCurrentViewBmp", "bitmap", "init", "getOwnerPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "updateAllowTouchRect", "updateAllowStrokeRemoverTouchRect", "onThumbnailChanged", "onLastPageChanged", "totalHeight", "onPageLayoutChanged", "pageLayoutColumn", "pageLayoutRow", "pageLayoutFitScreen", "pageLayoutVertical", "onEditModeChanged", "onObjectSelected", "pageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectList", "selected", "onShowAlertDialog", "id", "content", "onChangeGuideVisible", "type", "count", "onSetFrontBufferRenderingEnable", "onAddFloatingTextView", "rect", "description", "fontSize", "nativeViewId", "onAddFloatingImageButton", "onHoverHyperText", "url", "onSetHoverIcon", "onFlingGesture", "isStarted", "onActionLinkClicked", "text", "linkType", "onShowEdgeEffect", "velocityX", "velocityY", "onInitLayoutFinished", "onComposerClicked", "onSearchingText", "totalCount", "searchData", "Lcom/samsung/android/sdk/composer/document/search/SearchData;", "onSearchTextFinished", "onPullGestureAnimationUpdated", "animatedValue", "viewX", "viewY", "isReleased", "onVibrate", "vibrationPattern", "onStrokeShapeConverted", "onSmoothScrollEnd", "onStickyMemoClicked", "onHoverStickyNote", "onStickyMemoMovedByUser", "onGestureExclusionRectUpdated", "rectList", "", "finalizeFbrDrawPad", "setIsFbrSupportedFeature", "setFrontBufferRenderingEnabledInEWP", "setUnbufferedDispatchEnabled", "setDvfsFling", "dvfsInterface", "Lcom/samsung/android/sdk/pen/engine/power/SpenDvfsInterface;", "setVSTEnabled", "startContextMenuDelegate", "stopContextMenuDelegate", "setInputFormEnabled", "createTwinView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerImpl implements ISpenComposerImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int EDGE_ANIMATION_STATE_IDLE = 0;
    private static final int EDGE_ANIMATION_STATE_PLAYING = 1;

    @NotNull
    private static final String TAG = "SpenComposerImpl";
    private static final int U_OS = 34;

    @Nullable
    private SPenHwrBeautifierManager hwrBeautifierManager;

    @Nullable
    private SpenHwrGenerator hwrGenerator;

    @Nullable
    private SpenComposerListenerManager listenerManager;

    @Nullable
    private AccessibilityDelegateImpl mAccDelegateImpl;

    @Nullable
    private SPenAlignmentManager mAlignmentManager;

    @NotNull
    private final RectF mAllowStrokeRemoverTouchRect;

    @NotNull
    private final RectF mAllowTouchRect;

    @NotNull
    private final Paint mCapturePaint;
    private Context mContext;

    @Nullable
    private SpenComposerContextMenu mContextMenu;

    @Nullable
    private SpenContextMenuDelegate mContextMenuDelegate;

    @Nullable
    private SpenControlObjectManager mControlObjectManager;

    @Nullable
    private SpenConvertToTextManager mConvertToTextManager;

    @Nullable
    private MotionEvent mCurrentMotionEvent;
    private boolean mDocInited;

    @Nullable
    private SpenWNote mDocument;
    private int mDrawLoopType;

    @Nullable
    private SpenDvfsManager mDvfsManager;

    @Nullable
    private SpenEasyWritingPadManager mEasyWritingPadManager;

    @Nullable
    private SpenEdgeEffectManager mEdgeEffectManager;

    @Nullable
    private SpenFbrDrawPad mFbrDrawPad;

    @Nullable
    private SpenFloatingViewManager mFloatingViewManager;

    @Nullable
    private SpenGestureController mGestureController;

    @NotNull
    private final Handler mHandlerTwin;
    private int mHighTextContrastEnabled;

    @Nullable
    private SpenHoverPointerIcon mHoverPointerIcon;
    private int mInitBackgroundColor;
    private boolean mIsDisAllowTouch;
    private boolean mIsFbrSupportedFeature;
    private boolean mIsOnLayout;
    private boolean mIsPenButtonEnabledAtActionDown;
    private boolean mIsRequestTouchCancel;
    private boolean mIsShiftPressed;
    private boolean mIsTouchDown;
    private boolean mIsUnbufferedDispatch;

    @Nullable
    private SpenMathManager mMathManager;

    @Nullable
    private SpenMemoryLoggerReceiver mMemoryLoggerReceiver;
    private long mNativeHandle;

    @Nullable
    private SpenNotePageLayouter mNotePageLayouter;

    @Nullable
    private SpenNotePdfManager mNotePdfManager;

    @Nullable
    private SpenNoteTextManager mNoteTextManager;

    @Nullable
    private SpenNoteWritingViewManager mNoteWritingViewManager;

    @Nullable
    private SpenPdfAIModelLoader mPdfAIModelLoader;
    private int mPrevEdgeAnimationState;

    @RequiresApi(26)
    @NotNull
    private final Runnable mRemoveTwinViewRunnable;

    @Nullable
    private SpenRenderer mRenderer;

    @Nullable
    private SPenSTTManager mSTTManager;
    private int mScreenHeight;
    private int mScreenWidth;

    @Nullable
    private SpenComposerContext mSpenComposerContext;

    @Nullable
    private SpenConfiguration mSpenConfiguration;

    @Nullable
    private SpenNoteDeltaZoom mSpenDeltaZoom;

    @Nullable
    private SpenDisplay mSpenDisplay;

    @Nullable
    private SpenDrawLoopInterface mSpenDrawLoop;

    @Nullable
    private SpenNoteZoomScroller mSpenNoteZoomScroller;

    @Nullable
    private SpenPenSound mSpenPenSound;

    @NotNull
    private final Rect mStrokeRemoverTouchMargin;

    @Nullable
    private SurfaceView mSurfaceView;

    @Nullable
    private SurfaceView mSurfaceViewBG;

    @Nullable
    private SpenTextMathManager mTextMathManager;

    @Nullable
    private TextureView mTextureView;

    @NotNull
    private final Rect mTouchMargin;

    @Nullable
    private View mTwinViewAgll;
    private boolean mUseInitBackgroundColor;
    private View mView;

    @Nullable
    private SpenWritingOptionPatternDetector mWritingOptionPatternDetector;

    @Nullable
    private SpenWritingOptionView mWritingOptionView;

    @Nullable
    private SpenNoteLaserManager noteLaserManager;

    @Nullable
    private SpenNoteObjectInserter noteObjectInserter;

    @Nullable
    private SpenSmartScriptDocument smartScriptDocument;

    @Nullable
    private SpenWNoteHelper wNoteHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J9\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0083 J\u0011\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J9\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0083 J\u0019\u0010'\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0083 J1\u0010*\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,H\u0083 J\u0019\u00100\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0083 J\u0011\u00101\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u00103\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 JI\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0083 J\u001b\u0010=\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0083 J\u0011\u0010@\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010A\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010B\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010C\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010D\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010E\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010F\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010G\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010H\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010I\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010J\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010K\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010L\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0019\u0010M\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0083 J\u0011\u0010O\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0019\u0010P\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000bH\u0083 J\u0011\u0010R\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010S\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J!\u0010T\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001bH\u0083 J\u0011\u0010V\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J!\u0010W\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u001bH\u0083 J\u0011\u0010Z\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J#\u0010[\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u00052\u0006\u0010Y\u001a\u00020\u001bH\u0083 J\u0011\u0010\\\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010]\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0019\u0010^\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0007H\u0083 J\u0011\u0010`\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0011\u0010a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J!\u0010e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0083 J\u0019\u0010g\u001a\u00020h2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u0007H\u0083 J1\u0010i\u001a\u00020j2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020\u0007H\u0083 J\u0019\u0010n\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u0007H\u0083 J\u0019\u0010o\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020qH\u0083 J\u0019\u0010r\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010t\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010u\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010v\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010w\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0011\u0010x\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0019\u0010y\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010z\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010{\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0019\u0010|\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0007H\u0083 J\u0019\u0010~\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0007H\u0083 J\u0011\u0010\u007f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0012\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u001a\u0010\u0081\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0012\u0010\u0082\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u001a\u0010\u0083\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0007H\u0083 J\u001b\u0010\u0084\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0007\u0010\u0085\u0001\u001a\u00020\u001bH\u0083 J#\u0010\u0086\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u001bH\u0083 J\u001b\u0010\u0087\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0007\u0010\u0085\u0001\u001a\u00020\u001bH\u0083 J#\u0010\u0088\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u001bH\u0083 J\u001a\u0010\u0089\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0007H\u0083 J\u001e\u0010\u008a\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0083 J'\u0010\u008d\u0001\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000b2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020,H\u0083 J\u0012\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0012\u0010\u0092\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u0012\u0010\u0093\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J%\u0010\u0094\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u001bH\u0083 J\u001b\u0010\u0098\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\u000bH\u0083 J\u001b\u0010\u009a\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u000bH\u0083 J\u001c\u0010\u009c\u0001\u001a\u00020\u00172\u0007\u0010\u009d\u0001\u001a\u00020\u000b2\u0007\u0010\u009e\u0001\u001a\u00020\u0007H\u0083 J\u001a\u0010\u009f\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0083 J\u0012\u0010 \u0001\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0083 J\u001b\u0010¡\u0001\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\u001bH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposerImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "U_OS", "", "EDGE_ANIMATION_STATE_IDLE", "EDGE_ANIMATION_STATE_PLAYING", "Native_init", "", "composer", "Lcom/samsung/android/sdk/composer/SpenComposerImpl;", "contextHandle", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "hoverPointerIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "penSound", "Lcom/samsung/android/sdk/pen/engine/SpenPenSound;", "createType", "Native_finalize", "", "nativeHandle", "Native_onLayout", "changed", "", "left", "top", "right", "bottom", "Native_onConfigurationChanged", "Native_onScaleByScreenSize", "enable", "startWidth", "startHeight", "endWidth", "endHeight", "Native_onTouch", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_onMouseWheel", "x", "", "y", "verticalAxisValue", "horizontalAxisValue", "Native_onHover", "Native_onPause", "Native_onResume", "Native_onTrimMemory", "Native_onKeyEvent", "nativeCanvas", "action", "keyCode", "downTime", "eventTime", "repeatCount", "metaState", "flags", "Native_setDocument", "noteDoc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Native_getDeltaZoom", "Native_getNoteZoomScroller", "Native_getNoteWritingView", "Native_getConvertToTextView", "Native_getMathManager", "Native_getTextMathManager", "Native_getHwrGenerator", "Native_getAlignmentView", "Native_getSTTView", "Native_getHwrBeautifier", "Native_getNoteObjectInserter", "Native_getNotePageLayouter", "Native_getGestureController", "Native_setContextMenu", "contextMenu", "Native_getTextManager", "Native_setControlObjectManager", "controlObjectManager", "Native_getPdfManager", "Native_getSmartScriptDocument", "Native_setEasyWritingPadEnable", "guideTextEnable", "Native_isEasyWritingPadEnabled", "Native_searchText", "searchText", "includeSearchData", "Native_pauseSearchText", "Native_resumeSearchText", "Native_searchFocusNext", "Native_searchFocusPrev", "Native_setSearchFocus", "focusId", "Native_clearSearch", "Native_cancelSearch", "Native_getNodeList", "", "Lcom/samsung/android/sdk/composer/view/accessibility/SpenAccessibilityNodeInfo;", "Native_onNodeInfoClick", "nativeId", "Native_getObjectByNativeID", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Native_getCursorIndexInObjectText", "", "cursorIndex", "isNext", "selectBy", "Native_isNodeInfoFocused", "Native_captureCurrentView", "bitmap", "Landroid/graphics/Bitmap;", "Native_setActionLinkEnabled", "enabled", "Native_setActionLinkVisible", "Native_setVoiceSyncPlayEnabled", "Native_setVoiceSyncPlayAutoScroll", "Native_setAutoScrollEnabled", "Native_isMathEnabled", "Native_setTextOnlyEnabled", "Native_setWritingGuideLineEnabled", "Native_setLaserPenEnabled", "Native_goToPage", "pageIndex", "Native_requestAlignmentContent", "Native_requestResetZoomScaleToDefault", "Native_requestKeepPageFitToScreenWhenPageFit", "Native_setAllwaysFitPageToScreen", "Native_smoothScrollToFitPage", "Native_smoothScrollToPage", "Native_smoothScrollFitPageToScreen", "isFitToWidth", "Native_smoothScrollToPageAndFitPageToScreen", "Native_isFitToScreen", "Native_isPageFitToScreen", "Native_smoothScrollAndScaleToFitPage", "Native_smoothScrollAndScaleToFitRect", "targetContentRect", "Landroid/graphics/RectF;", "Native_smoothScrollAndScaleTo", "targetContentPoint", "Landroid/graphics/PointF;", "targetZoomScale", "Native_stopGestureAnimation", "Native_startLazyViewUpdate", "Native_endLazyViewUpdate", "Native_startStickyMemoIconAnimation", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "isShow", "Native_setFbrDrawPad", "nativeDrawPad", "Native_setWNoteHelper", "wnoteHelper", "Native_setEdgeAnimationState", "nativeView", "state", "Native_setInputFormEnabled", "Native_getPdfAIModelLoader", "Native_setViewFocus", "viewFocus", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_cancelSearch(long nativeHandle) {
            SpenComposerImpl.Native_cancelSearch(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureCurrentView(long nativeHandle, Bitmap bitmap) {
            return SpenComposerImpl.Native_captureCurrentView(nativeHandle, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_clearSearch(long nativeHandle) {
            SpenComposerImpl.Native_clearSearch(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_endLazyViewUpdate(long nativeHandle) {
            SpenComposerImpl.Native_endLazyViewUpdate(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenComposerImpl.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getAlignmentView(long nativeHandle) {
            return SpenComposerImpl.Native_getAlignmentView(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getConvertToTextView(long nativeHandle) {
            return SpenComposerImpl.Native_getConvertToTextView(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int[] Native_getCursorIndexInObjectText(long nativeHandle, int nativeId, int cursorIndex, boolean isNext, int selectBy) {
            return SpenComposerImpl.Native_getCursorIndexInObjectText(nativeHandle, nativeId, cursorIndex, isNext, selectBy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getDeltaZoom(long nativeHandle) {
            return SpenComposerImpl.Native_getDeltaZoom(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getGestureController(long nativeHandle) {
            return SpenComposerImpl.Native_getGestureController(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getHwrBeautifier(long nativeHandle) {
            return SpenComposerImpl.Native_getHwrBeautifier(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getHwrGenerator(long nativeHandle) {
            return SpenComposerImpl.Native_getHwrGenerator(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getMathManager(long nativeHandle) {
            return SpenComposerImpl.Native_getMathManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<SpenAccessibilityNodeInfo> Native_getNodeList(long nativeHandle) {
            return SpenComposerImpl.Native_getNodeList(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getNoteObjectInserter(long nativeHandle) {
            return SpenComposerImpl.Native_getNoteObjectInserter(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getNotePageLayouter(long nativeHandle) {
            return SpenComposerImpl.Native_getNotePageLayouter(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getNoteWritingView(long nativeHandle) {
            return SpenComposerImpl.Native_getNoteWritingView(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getNoteZoomScroller(long nativeHandle) {
            return SpenComposerImpl.Native_getNoteZoomScroller(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectBase Native_getObjectByNativeID(long nativeHandle, int nativeId) {
            return SpenComposerImpl.Native_getObjectByNativeID(nativeHandle, nativeId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getPdfAIModelLoader(long nativeHandle) {
            return SpenComposerImpl.Native_getPdfAIModelLoader(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getPdfManager(long nativeHandle) {
            return SpenComposerImpl.Native_getPdfManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getSTTView(long nativeHandle) {
            return SpenComposerImpl.Native_getSTTView(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getSmartScriptDocument(long nativeHandle) {
            return SpenComposerImpl.Native_getSmartScriptDocument(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getTextManager(long nativeHandle) {
            return SpenComposerImpl.Native_getTextManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getTextMathManager(long nativeHandle) {
            return SpenComposerImpl.Native_getTextMathManager(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_goToPage(long nativeHandle, int pageIndex) {
            SpenComposerImpl.Native_goToPage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenComposerImpl composer, long contextHandle, SpenDrawLoopInterface drawLoop, SpenHoverPointerIcon hoverPointerIcon, SpenPenSound penSound, int createType) {
            return SpenComposerImpl.Native_init(composer, contextHandle, drawLoop, hoverPointerIcon, penSound, createType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isEasyWritingPadEnabled(long nativeHandle) {
            return SpenComposerImpl.Native_isEasyWritingPadEnabled(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFitToScreen(long nativeHandle, boolean isFitToWidth) {
            return SpenComposerImpl.Native_isFitToScreen(nativeHandle, isFitToWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isMathEnabled(long nativeHandle) {
            return SpenComposerImpl.Native_isMathEnabled(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isNodeInfoFocused(long nativeHandle, int nativeId) {
            return SpenComposerImpl.Native_isNodeInfoFocused(nativeHandle, nativeId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isPageFitToScreen(long nativeHandle, int pageIndex, boolean isFitToWidth) {
            return SpenComposerImpl.Native_isPageFitToScreen(nativeHandle, pageIndex, isFitToWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onConfigurationChanged(long nativeHandle) {
            SpenComposerImpl.Native_onConfigurationChanged(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHover(long nativeHandle, SpenMotionEvent event) {
            return SpenComposerImpl.Native_onHover(nativeHandle, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onKeyEvent(long nativeCanvas, int action, int keyCode, long downTime, long eventTime, int repeatCount, int metaState, int flags) {
            return SpenComposerImpl.Native_onKeyEvent(nativeCanvas, action, keyCode, downTime, eventTime, repeatCount, metaState, flags);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onLayout(long nativeHandle, boolean changed, int left, int top, int right, int bottom) {
            SpenComposerImpl.Native_onLayout(nativeHandle, changed, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onMouseWheel(long nativeHandle, float x, float y2, float verticalAxisValue, float horizontalAxisValue) {
            return SpenComposerImpl.Native_onMouseWheel(nativeHandle, x, y2, verticalAxisValue, horizontalAxisValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onNodeInfoClick(long nativeHandle, int nativeId, int action) {
            SpenComposerImpl.Native_onNodeInfoClick(nativeHandle, nativeId, action);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeHandle) {
            SpenComposerImpl.Native_onPause(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeHandle) {
            SpenComposerImpl.Native_onResume(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onScaleByScreenSize(long nativeHandle, boolean enable, int startWidth, int startHeight, int endWidth, int endHeight) {
            SpenComposerImpl.Native_onScaleByScreenSize(nativeHandle, enable, startWidth, startHeight, endWidth, endHeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onTouch(long nativeHandle, SpenMotionEvent event) {
            return SpenComposerImpl.Native_onTouch(nativeHandle, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onTrimMemory(long nativeHandle) {
            SpenComposerImpl.Native_onTrimMemory(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_pauseSearchText(long nativeHandle) {
            return SpenComposerImpl.Native_pauseSearchText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestAlignmentContent(long nativeHandle, int pageIndex) {
            SpenComposerImpl.Native_requestAlignmentContent(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestKeepPageFitToScreenWhenPageFit(long nativeHandle) {
            SpenComposerImpl.Native_requestKeepPageFitToScreenWhenPageFit(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestResetZoomScaleToDefault(long nativeHandle) {
            SpenComposerImpl.Native_requestResetZoomScaleToDefault(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_resumeSearchText(long nativeHandle, String searchText, boolean includeSearchData) {
            return SpenComposerImpl.Native_resumeSearchText(nativeHandle, searchText, includeSearchData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_searchFocusNext(long nativeHandle) {
            return SpenComposerImpl.Native_searchFocusNext(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_searchFocusPrev(long nativeHandle) {
            return SpenComposerImpl.Native_searchFocusPrev(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_searchText(long nativeHandle, String searchText, boolean includeSearchData) {
            return SpenComposerImpl.Native_searchText(nativeHandle, searchText, includeSearchData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setActionLinkEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setActionLinkEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setActionLinkVisible(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setActionLinkVisible(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAllwaysFitPageToScreen(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setAllwaysFitPageToScreen(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAutoScrollEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setAutoScrollEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setContextMenu(long nativeHandle, long contextMenu) {
            SpenComposerImpl.Native_setContextMenu(nativeHandle, contextMenu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setControlObjectManager(long nativeHandle, long controlObjectManager) {
            SpenComposerImpl.Native_setControlObjectManager(nativeHandle, controlObjectManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeCanvas, SpenWNote noteDoc) {
            return SpenComposerImpl.Native_setDocument(nativeCanvas, noteDoc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setEasyWritingPadEnable(long nativeHandle, boolean enable, boolean guideTextEnable) {
            SpenComposerImpl.Native_setEasyWritingPadEnable(nativeHandle, enable, guideTextEnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setEdgeAnimationState(long nativeView, int state) {
            SpenComposerImpl.Native_setEdgeAnimationState(nativeView, state);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFbrDrawPad(long nativeHandle, long nativeDrawPad) {
            SpenComposerImpl.Native_setFbrDrawPad(nativeHandle, nativeDrawPad);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setInputFormEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setInputFormEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_setLaserPenEnabled(long nativeHandle, boolean enabled) {
            return SpenComposerImpl.Native_setLaserPenEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setSearchFocus(long nativeHandle, int focusId) {
            return SpenComposerImpl.Native_setSearchFocus(nativeHandle, focusId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextOnlyEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setTextOnlyEnabled(nativeHandle, enabled);
        }

        @JvmStatic
        private final void Native_setViewFocus(long nativeHandle, boolean viewFocus) {
            SpenComposerImpl.Native_setViewFocus(nativeHandle, viewFocus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVoiceSyncPlayAutoScroll(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setVoiceSyncPlayAutoScroll(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setVoiceSyncPlayEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setVoiceSyncPlayEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setWNoteHelper(long nativeHandle, long wnoteHelper) {
            SpenComposerImpl.Native_setWNoteHelper(nativeHandle, wnoteHelper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setWritingGuideLineEnabled(long nativeHandle, boolean enabled) {
            SpenComposerImpl.Native_setWritingGuideLineEnabled(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollAndScaleTo(long nativeHandle, PointF targetContentPoint, float targetZoomScale) {
            return SpenComposerImpl.Native_smoothScrollAndScaleTo(nativeHandle, targetContentPoint, targetZoomScale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollAndScaleToFitPage(long nativeHandle, int pageIndex) {
            return SpenComposerImpl.Native_smoothScrollAndScaleToFitPage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollAndScaleToFitRect(long nativeHandle, RectF targetContentRect) {
            return SpenComposerImpl.Native_smoothScrollAndScaleToFitRect(nativeHandle, targetContentRect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollFitPageToScreen(long nativeHandle, boolean isFitToWidth) {
            return SpenComposerImpl.Native_smoothScrollFitPageToScreen(nativeHandle, isFitToWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_smoothScrollToFitPage(long nativeHandle) {
            SpenComposerImpl.Native_smoothScrollToFitPage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollToPage(long nativeHandle, int pageIndex) {
            return SpenComposerImpl.Native_smoothScrollToPage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_smoothScrollToPageAndFitPageToScreen(long nativeHandle, int pageIndex, boolean isFitToWidth) {
            return SpenComposerImpl.Native_smoothScrollToPageAndFitPageToScreen(nativeHandle, pageIndex, isFitToWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_startLazyViewUpdate(long nativeHandle) {
            SpenComposerImpl.Native_startLazyViewUpdate(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_startStickyMemoIconAnimation(long nativeHandle, SpenCustomObject customObject, boolean isShow) {
            SpenComposerImpl.Native_startStickyMemoIconAnimation(nativeHandle, customObject, isShow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_stopGestureAnimation(long nativeHandle) {
            SpenComposerImpl.Native_stopGestureAnimation(nativeHandle);
        }

        private Companion() {
        }
    }

    public SpenComposerImpl(@NotNull Context context, @NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        this.mAllowTouchRect = new RectF();
        this.mTouchMargin = new Rect();
        this.mAllowStrokeRemoverTouchRect = new RectF();
        this.mStrokeRemoverTouchMargin = new Rect();
        this.mIsDisAllowTouch = true;
        this.mIsFbrSupportedFeature = true;
        this.mHighTextContrastEnabled = -1;
        this.mCapturePaint = new Paint(1);
        this.mHandlerTwin = new Handler();
        this.mRemoveTwinViewRunnable = new RunnableC4617a(this, 11);
        init(context, view, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_cancelSearch(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureCurrentView(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_clearSearch(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_endLazyViewUpdate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getAlignmentView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getConvertToTextView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int[] Native_getCursorIndexInObjectText(long j, int i, int i2, boolean z, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getDeltaZoom(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getGestureController(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getHwrBeautifier(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getHwrGenerator(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getMathManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<SpenAccessibilityNodeInfo> Native_getNodeList(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getNoteObjectInserter(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getNotePageLayouter(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getNoteWritingView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getNoteZoomScroller(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectBase Native_getObjectByNativeID(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getPdfAIModelLoader(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getPdfManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getSTTView(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getSmartScriptDocument(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getTextManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getTextMathManager(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_goToPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenComposerImpl spenComposerImpl, long j, SpenDrawLoopInterface spenDrawLoopInterface, SpenHoverPointerIcon spenHoverPointerIcon, SpenPenSound spenPenSound, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isEasyWritingPadEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFitToScreen(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isMathEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isNodeInfoFocused(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isPageFitToScreen(long j, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onConfigurationChanged(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHover(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onKeyEvent(long j, int i, int i2, long j2, long j3, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onLayout(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onMouseWheel(long j, float f, float f4, float f5, float f6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onNodeInfoClick(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onResume(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onScaleByScreenSize(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onTouch(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onTrimMemory(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_pauseSearchText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestAlignmentContent(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestKeepPageFitToScreenWhenPageFit(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestResetZoomScaleToDefault(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_resumeSearchText(long j, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_searchFocusNext(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_searchFocusPrev(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_searchText(long j, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setActionLinkEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setActionLinkVisible(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAllwaysFitPageToScreen(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAutoScrollEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setContextMenu(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setControlObjectManager(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, SpenWNote spenWNote);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setEasyWritingPadEnable(long j, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setEdgeAnimationState(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFbrDrawPad(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setInputFormEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_setLaserPenEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setSearchFocus(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextOnlyEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setViewFocus(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVoiceSyncPlayAutoScroll(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setVoiceSyncPlayEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setWNoteHelper(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setWritingGuideLineEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollAndScaleTo(long j, PointF pointF, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollAndScaleToFitPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollAndScaleToFitRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollFitPageToScreen(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_smoothScrollToFitPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollToPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_smoothScrollToPageAndFitPageToScreen(long j, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_startLazyViewUpdate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_startStickyMemoIconAnimation(long j, SpenCustomObject spenCustomObject, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_stopGestureAnimation(long j);

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

    private final View createTwinView() {
        Context context = this.mContext;
        View view = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View view2 = new View(context);
        View view3 = this.mView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
        } else {
            view = view3;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int iIndexOfChild = viewGroup.indexOfChild(this.mTextureView);
        if (iIndexOfChild != -1) {
            viewGroup.addView(view2, iIndexOfChild);
            return view2;
        }
        viewGroup.addView(view2);
        return view2;
    }

    private final void finalizeFbrDrawPad() {
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            long j = this.mNativeHandle;
            if (j != 0) {
                INSTANCE.Native_setFbrDrawPad(j, 0L);
            }
            View view = this.mView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(spenFbrDrawPad);
            }
            spenFbrDrawPad.close();
        }
        this.mFbrDrawPad = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getClearColor() {
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        return (spenComposerContext == null || spenComposerContext.getMColorTheme() != 1) ? -1 : -16777216;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpenWPage getOwnerPage(SpenObjectBase objectBase) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote == null) {
            return null;
        }
        int pageCount = spenWNote.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            if (spenWNote.getPage(i).isObjectContained(objectBase)) {
                return spenWNote.getPage(i);
            }
        }
        return null;
    }

    private final void init(Context context, View view, int createType, int drawLoopType) {
        View view2;
        int i;
        int i2;
        SpenDrawLoopInterface spenDrawLoopInterface;
        SpenDrawLoopInterface spenDrawLoopInterface2;
        Context context2;
        final SpenComposerImpl spenComposerImpl;
        View view3;
        SpenComposerContextMenu spenComposerContextMenu;
        int i4;
        this.mView = view;
        SpenResources.Companion companion = SpenResources.INSTANCE;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view2 = null;
        } else {
            view2 = view;
        }
        companion.setResources(view2.getResources());
        View view4 = this.mView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view4 = null;
        }
        companion.registerResourceView(view4);
        this.listenerManager = new SpenComposerListenerManager();
        this.mSpenDisplay = new SpenDisplay(context);
        if (drawLoopType == 2 && (i4 = Build.VERSION.SDK_INT) < 29) {
            AbstractC11014a.m12328m(i4, "DrawloopAGLL is not supported on the OS = ", ", switch to DrawloopTexture", TAG);
            i = 1;
        } else if (drawLoopType != 3 || (i2 = Build.VERSION.SDK_INT) > 31) {
            i = drawLoopType;
        } else {
            AbstractC11014a.m12328m(i2, "DrawloopHwBuffer is not supported on the OS = ", ", switch to DrawloopHWUI", TAG);
            i = 0;
        }
        this.mDrawLoopType = i;
        if (i == 0) {
            View view5 = this.mView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view5 = null;
            }
            this.mSpenDrawLoop = new SpenDrawLoopHWUI(view5);
        } else if (i == 1) {
            this.mSpenDrawLoop = new SpenDrawLoopTexture(false);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setLayerType(2, null);
            TextureView textureView = new TextureView(context);
            this.mTextureView = textureView;
            viewGroup.addView(textureView);
            textureView.setOpaque(false);
            textureView.setSurfaceTextureListener((SpenDrawLoopTexture) this.mSpenDrawLoop);
            if (textureView.isAvailable() && textureView.getSurfaceTexture() != null) {
                SpenDrawLoopInterface spenDrawLoopInterface3 = this.mSpenDrawLoop;
                Intrinsics.checkNotNull(spenDrawLoopInterface3, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
                SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
                Intrinsics.checkNotNull(surfaceTexture);
                ((SpenDrawLoopTexture) spenDrawLoopInterface3).onSurfaceTextureAvailable(surfaceTexture, viewGroup.getWidth(), viewGroup.getHeight());
            }
            Unit unit = Unit.INSTANCE;
            if (SpenDisplay.INSTANCE.getDebugLevel() > 0 && (spenDrawLoopInterface2 = this.mSpenDrawLoop) != null) {
                SpenMemoryLoggerReceiver spenMemoryLoggerReceiver = new SpenMemoryLoggerReceiver((SpenDrawLoopTexture) spenDrawLoopInterface2);
                this.mMemoryLoggerReceiver = spenMemoryLoggerReceiver;
                context.registerReceiver(spenMemoryLoggerReceiver, new IntentFilter("com.samsung.android.sdk.composer.TRIGGER_MEMORY_LOGGING"), 4);
                Log.i(TAG, "SpenMemoryLoggerReceiver registered");
            }
            this.mHighTextContrastEnabled = Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0);
        } else if (i == 2 && Build.VERSION.SDK_INT >= 29) {
            this.mSurfaceView = new SurfaceView(context);
            this.mSurfaceViewBG = new SurfaceView(context);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) view;
            viewGroup2.addView(this.mSurfaceViewBG, 0);
            viewGroup2.addView(this.mSurfaceView, 1);
            SurfaceView surfaceView = this.mSurfaceView;
            SurfaceHolder holder = surfaceView != null ? surfaceView.getHolder() : null;
            if (holder != null) {
                holder.addCallback(new SurfaceHolder.Callback() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.3
                    @Override // android.view.SurfaceHolder.Callback
                    @RequiresApi(api = 29)
                    public void surfaceChanged(SurfaceHolder holder2, int format, int width, int height) {
                        Intrinsics.checkNotNullParameter(holder2, "holder");
                        int i5 = SpenComposerImpl.this.mScreenWidth;
                        int i6 = SpenComposerImpl.this.mScreenHeight;
                        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "surfaceChanged  Surface w:", ",h: ", " Canvas w:");
                        sbM1173s.append(i5);
                        sbM1173s.append(",h: ");
                        sbM1173s.append(i6);
                        Log.i(SpenComposerImpl.TAG, sbM1173s.toString());
                        Canvas canvasLockHardwareCanvas = holder2.lockHardwareCanvas();
                        Bitmap bitmapCaptureCurrentView = SpenComposerImpl.this.captureCurrentView();
                        if (bitmapCaptureCurrentView != null) {
                            SpenComposerImpl spenComposerImpl2 = SpenComposerImpl.this;
                            canvasLockHardwareCanvas.drawColor(spenComposerImpl2.getClearColor());
                            canvasLockHardwareCanvas.drawBitmap(bitmapCaptureCurrentView, 0.0f, 0.0f, spenComposerImpl2.mCapturePaint);
                            holder2.unlockCanvasAndPost(canvasLockHardwareCanvas);
                            Canvas canvasLockHardwareCanvas2 = holder2.lockHardwareCanvas();
                            canvasLockHardwareCanvas2.drawColor(spenComposerImpl2.getClearColor());
                            canvasLockHardwareCanvas2.drawBitmap(bitmapCaptureCurrentView, 0.0f, 0.0f, spenComposerImpl2.mCapturePaint);
                            holder2.unlockCanvasAndPost(canvasLockHardwareCanvas2);
                        }
                        SurfaceView surfaceView2 = SpenComposerImpl.this.mSurfaceViewBG;
                        SurfaceHolder holder3 = surfaceView2 != null ? surfaceView2.getHolder() : null;
                        if (holder3 != null) {
                            SpenComposerImpl spenComposerImpl3 = SpenComposerImpl.this;
                            Canvas canvasLockHardwareCanvas3 = holder3.lockHardwareCanvas();
                            canvasLockHardwareCanvas3.drawColor(spenComposerImpl3.getClearColor());
                            holder3.unlockCanvasAndPost(canvasLockHardwareCanvas3);
                        }
                        SpenDrawLoopAGLL spenDrawLoopAGLL = (SpenDrawLoopAGLL) SpenComposerImpl.this.mSpenDrawLoop;
                        if (spenDrawLoopAGLL != null) {
                            spenDrawLoopAGLL.surfaceChanged(holder2, format, width, height);
                        }
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    @RequiresApi(api = 29)
                    public void surfaceCreated(SurfaceHolder holder2) {
                        Intrinsics.checkNotNullParameter(holder2, "holder");
                        SpenDrawLoopAGLL spenDrawLoopAGLL = (SpenDrawLoopAGLL) SpenComposerImpl.this.mSpenDrawLoop;
                        if (spenDrawLoopAGLL != null) {
                            spenDrawLoopAGLL.surfaceCreated(holder2);
                        }
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    @RequiresApi(api = 29)
                    public void surfaceDestroyed(SurfaceHolder holder2) {
                        Intrinsics.checkNotNullParameter(holder2, "holder");
                        SpenDrawLoopAGLL spenDrawLoopAGLL = (SpenDrawLoopAGLL) SpenComposerImpl.this.mSpenDrawLoop;
                        if (spenDrawLoopAGLL != null) {
                            spenDrawLoopAGLL.surfaceDestroyed(holder2);
                        }
                    }
                });
                Unit unit2 = Unit.INSTANCE;
            }
            if (holder != null) {
                holder.setFormat(1);
                Unit unit3 = Unit.INSTANCE;
            }
            SurfaceView surfaceView2 = this.mSurfaceViewBG;
            SurfaceHolder holder2 = surfaceView2 != null ? surfaceView2.getHolder() : null;
            if (holder2 != null) {
                holder2.addCallback(new SurfaceHolder.Callback() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.4
                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceChanged(SurfaceHolder holder3, int format, int width, int height) {
                        Intrinsics.checkNotNullParameter(holder3, "holder");
                        Log.i(SpenComposerImpl.TAG, "SurfaceViewBG  surfaceChanged w:" + width + ",h: " + height);
                        Canvas canvasLockHardwareCanvas = holder3.lockHardwareCanvas();
                        canvasLockHardwareCanvas.drawColor(SpenComposerImpl.this.getClearColor());
                        holder3.unlockCanvasAndPost(canvasLockHardwareCanvas);
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceCreated(SurfaceHolder holder3) {
                        Intrinsics.checkNotNullParameter(holder3, "holder");
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceDestroyed(SurfaceHolder holder3) {
                        Intrinsics.checkNotNullParameter(holder3, "holder");
                    }
                });
                Unit unit4 = Unit.INSTANCE;
            }
            SpenDisplay spenDisplay = this.mSpenDisplay;
            if (spenDisplay != null) {
                if (holder2 != null) {
                    holder2.setFixedSize(spenDisplay.widthPixels, spenDisplay.heightPixels);
                    Unit unit5 = Unit.INSTANCE;
                }
                AbstractC6670b.m4744e(spenDisplay.widthPixels, spenDisplay.heightPixels, "Display size w:", ",h: ", TAG);
            }
            this.mSpenDrawLoop = new SpenDrawLoopAGLL(view, this.mSurfaceView);
            SurfaceView surfaceView3 = this.mSurfaceView;
            if (surfaceView3 != null) {
                surfaceView3.setWillNotDraw(false);
                Unit unit6 = Unit.INSTANCE;
            }
            this.mIsFbrSupportedFeature = false;
        } else if (i == 3) {
            this.mRenderer = new SpenRenderer();
            View view6 = this.mView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view6 = null;
            }
            this.mSpenDrawLoop = new SpenDrawLoopHwBuffer(view6, this.mRenderer);
            if (SpenDisplay.INSTANCE.getDebugLevel() > 0 && (spenDrawLoopInterface = this.mSpenDrawLoop) != null) {
                if (spenDrawLoopInterface instanceof ISpenGraphicMemoryLogger) {
                    SpenMemoryLoggerReceiver spenMemoryLoggerReceiver2 = new SpenMemoryLoggerReceiver((ISpenGraphicMemoryLogger) spenDrawLoopInterface);
                    this.mMemoryLoggerReceiver = spenMemoryLoggerReceiver2;
                    context.registerReceiver(spenMemoryLoggerReceiver2, new IntentFilter("com.samsung.android.sdk.composer.TRIGGER_MEMORY_LOGGING"), 4);
                    Log.i(TAG, "SpenMemoryLoggerReceiver registered");
                }
                Unit unit7 = Unit.INSTANCE;
            }
            this.mHighTextContrastEnabled = Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0);
        }
        this.mSpenConfiguration = new SpenConfiguration(context);
        if (this.mSpenDrawLoop == null || this.mSpenDisplay == null) {
            context2 = context;
        } else {
            SpenDrawLoopInterface spenDrawLoopInterface4 = this.mSpenDrawLoop;
            Intrinsics.checkNotNull(spenDrawLoopInterface4);
            long msgQueueHandle = spenDrawLoopInterface4.getMsgQueueHandle();
            SpenDisplay spenDisplay2 = this.mSpenDisplay;
            Intrinsics.checkNotNull(spenDisplay2);
            SpenConfiguration spenConfiguration = this.mSpenConfiguration;
            Intrinsics.checkNotNull(spenConfiguration);
            SpenDrawLoopInterface spenDrawLoopInterface5 = this.mSpenDrawLoop;
            Intrinsics.checkNotNull(spenDrawLoopInterface5);
            context2 = context;
            this.mSpenComposerContext = new SpenComposerContext(context, msgQueueHandle, spenDisplay2, spenConfiguration, spenDrawLoopInterface5.getRendererType());
        }
        View view7 = this.mView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view7 = null;
        }
        SpenHoverPointerIcon spenHoverPointerIcon = new SpenHoverPointerIcon(context2, view7);
        this.mHoverPointerIcon = spenHoverPointerIcon;
        spenHoverPointerIcon.setPenIconStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_CURVER);
        Unit unit8 = Unit.INSTANCE;
        this.mSpenPenSound = new SpenPenSound(context2);
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext == null || this.mHoverPointerIcon == null) {
            spenComposerImpl = this;
        } else {
            Companion companion2 = INSTANCE;
            Intrinsics.checkNotNull(spenComposerContext);
            long handle = spenComposerContext.getHandle();
            SpenDrawLoopInterface spenDrawLoopInterface6 = this.mSpenDrawLoop;
            SpenHoverPointerIcon spenHoverPointerIcon2 = this.mHoverPointerIcon;
            Intrinsics.checkNotNull(spenHoverPointerIcon2);
            SpenPenSound spenPenSound = this.mSpenPenSound;
            Intrinsics.checkNotNull(spenPenSound);
            spenComposerImpl = this;
            spenComposerImpl.mNativeHandle = companion2.Native_init(this, handle, spenDrawLoopInterface6, spenHoverPointerIcon2, spenPenSound, createType);
        }
        Companion companion3 = INSTANCE;
        long jNative_getDeltaZoom = companion3.Native_getDeltaZoom(spenComposerImpl.mNativeHandle);
        View view8 = spenComposerImpl.mView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view8 = null;
        }
        spenComposerImpl.mSpenDeltaZoom = new SpenNoteDeltaZoom(jNative_getDeltaZoom, view8);
        spenComposerImpl.mSpenNoteZoomScroller = new SpenNoteZoomScroller(companion3.Native_getNoteZoomScroller(spenComposerImpl.mNativeHandle));
        View view9 = spenComposerImpl.mView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view3 = null;
        } else {
            view3 = view9;
        }
        final Context context3 = context2;
        SpenNoteWritingViewManager spenNoteWritingViewManager = new SpenNoteWritingViewManager(context3, view3, companion3.Native_getNoteWritingView(spenComposerImpl.mNativeHandle), spenComposerImpl.mSpenDisplay, spenComposerImpl.mSpenPenSound);
        spenComposerImpl.mNoteWritingViewManager = spenNoteWritingViewManager;
        if (i == 2) {
            spenNoteWritingViewManager.setIsFbrSupportedFeature(false);
        }
        spenComposerImpl.mConvertToTextManager = new SpenConvertToTextManager(context3);
        spenComposerImpl.mAlignmentManager = new SPenAlignmentManager(context3);
        SPenSTTManager sPenSTTManager = new SPenSTTManager();
        spenComposerImpl.mSTTManager = sPenSTTManager;
        sPenSTTManager.setTextListener(new SPenSTTTextListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.7
            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTTextListener
            public void onKeyEvent(KeyEvent event) {
                View view10 = SpenComposerImpl.this.mView;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mView");
                    view10 = null;
                }
                view10.dispatchKeyEvent(event);
            }

            @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTTextListener
            public void onSoftInputAffected(boolean disable) {
                SpenNoteTextManager spenNoteTextManager = SpenComposerImpl.this.mNoteTextManager;
                if (spenNoteTextManager != null) {
                    spenNoteTextManager.setShowSoftInputDisabled(disable);
                }
            }
        });
        spenComposerImpl.hwrBeautifierManager = new SPenHwrBeautifierManager();
        spenComposerImpl.mEasyWritingPadManager = new SpenEasyWritingPadManager(context3);
        SpenConvertToTextManager spenConvertToTextManager = spenComposerImpl.mConvertToTextManager;
        if (spenConvertToTextManager != null) {
            spenConvertToTextManager.setNativeHandle(companion3.Native_getConvertToTextView(spenComposerImpl.mNativeHandle));
        }
        SPenAlignmentManager sPenAlignmentManager = spenComposerImpl.mAlignmentManager;
        if (sPenAlignmentManager != null) {
            sPenAlignmentManager.setNativeHandle(companion3.Native_getAlignmentView(spenComposerImpl.mNativeHandle));
        }
        SPenSTTManager sPenSTTManager2 = spenComposerImpl.mSTTManager;
        if (sPenSTTManager2 != null) {
            View view10 = spenComposerImpl.mView;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view10 = null;
            }
            sPenSTTManager2.setNativeHandle(view10.getContext(), companion3.Native_getSTTView(spenComposerImpl.mNativeHandle));
        }
        SPenHwrBeautifierManager hwrBeautifierManager = spenComposerImpl.getHwrBeautifierManager();
        if (hwrBeautifierManager != null) {
            View view11 = spenComposerImpl.mView;
            if (view11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view11 = null;
            }
            hwrBeautifierManager.setNativeHandle(view11.getContext(), companion3.Native_getHwrBeautifier(spenComposerImpl.mNativeHandle));
        }
        if (spenComposerImpl.isMathEnabled()) {
            View view12 = spenComposerImpl.mView;
            if (view12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view12 = null;
            }
            SpenMathManager spenMathManager = new SpenMathManager((ViewGroup) view12);
            spenComposerImpl.mMathManager = spenMathManager;
            View view13 = spenComposerImpl.mView;
            if (view13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view13 = null;
            }
            spenMathManager.setNativeHandle(view13.getContext(), companion3.Native_getMathManager(spenComposerImpl.mNativeHandle));
            SpenMathManager spenMathManager2 = spenComposerImpl.mMathManager;
            if (spenMathManager2 != null) {
                spenMathManager2.setNoteZoomScroller(spenComposerImpl.mSpenNoteZoomScroller);
            }
            spenComposerImpl.hwrGenerator = new SpenHwrGenerator();
            SpenHwrGenerator hwrGenerator = spenComposerImpl.getHwrGenerator();
            if (hwrGenerator != null) {
                View view14 = spenComposerImpl.mView;
                if (view14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mView");
                    view14 = null;
                }
                hwrGenerator.setNativeHandle(view14.getContext(), companion3.Native_getHwrGenerator(spenComposerImpl.mNativeHandle));
            }
        }
        SpenTextMathManager spenTextMathManager = new SpenTextMathManager();
        spenComposerImpl.mTextMathManager = spenTextMathManager;
        spenTextMathManager.setNoteZoomScroller(spenComposerImpl.mSpenNoteZoomScroller);
        SpenTextMathManager spenTextMathManager2 = spenComposerImpl.mTextMathManager;
        if (spenTextMathManager2 != null) {
            View view15 = spenComposerImpl.mView;
            if (view15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view15 = null;
            }
            Context context4 = view15.getContext();
            long jNative_getTextMathManager = companion3.Native_getTextMathManager(spenComposerImpl.mNativeHandle);
            View view16 = spenComposerImpl.mView;
            if (view16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view16 = null;
            }
            spenTextMathManager2.setNativeHandle(context4, jNative_getTextMathManager, (ViewGroup) view16);
        }
        SpenTextMathManager spenTextMathManager3 = spenComposerImpl.mTextMathManager;
        if (spenTextMathManager3 != null) {
            spenTextMathManager3.setTextMathListener(new SpenTextMathListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.8
                @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathListener
                public void onDialerVisibleChanged(boolean isVisible) {
                }

                @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathListener
                public void requestInsertPlot(SpenObjectBase objectBase) {
                    if (SpenComposerImpl.this.getNoteObjectInserter() == null || objectBase == null) {
                        return;
                    }
                    Log.d(SpenComposerImpl.TAG, "SpenTextMathListener - requestInsertPlot");
                    PointF pointF = new PointF(objectBase.getRect().left, objectBase.getRect().top);
                    SpenNoteObjectInserter noteObjectInserter = SpenComposerImpl.this.getNoteObjectInserter();
                    if (noteObjectInserter != null) {
                        noteObjectInserter.insertObject(objectBase, pointF);
                    }
                }
            });
        }
        SpenNotePdfManager spenNotePdfManager = new SpenNotePdfManager(context3);
        spenComposerImpl.mNotePdfManager = spenNotePdfManager;
        spenNotePdfManager.setNativeHandle(companion3.Native_getPdfManager(spenComposerImpl.mNativeHandle));
        spenComposerImpl.noteObjectInserter = new SpenNoteObjectInserter();
        SpenNoteObjectInserter noteObjectInserter = spenComposerImpl.getNoteObjectInserter();
        if (noteObjectInserter != null) {
            noteObjectInserter.setNativeHandle(companion3.Native_getNoteObjectInserter(spenComposerImpl.mNativeHandle));
        }
        SpenNotePageLayouter spenNotePageLayouter = new SpenNotePageLayouter();
        spenComposerImpl.mNotePageLayouter = spenNotePageLayouter;
        spenNotePageLayouter.setNativeHandle(companion3.Native_getNotePageLayouter(spenComposerImpl.mNativeHandle));
        View view17 = spenComposerImpl.mView;
        if (view17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view17 = null;
        }
        SpenComposerContextMenu spenComposerContextMenu2 = new SpenComposerContextMenu(view17);
        spenComposerImpl.mContextMenu = spenComposerContextMenu2;
        companion3.Native_setContextMenu(spenComposerImpl.mNativeHandle, spenComposerContextMenu2.getNativeContextMenu());
        spenComposerContextMenu2.setListerManager(spenComposerImpl.getListenerManager());
        View view18 = spenComposerImpl.mView;
        if (view18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view18 = null;
        }
        SpenNoteTextManager spenNoteTextManager = new SpenNoteTextManager(view18);
        spenComposerImpl.mNoteTextManager = spenNoteTextManager;
        spenNoteTextManager.setNativeHandle(companion3.Native_getTextManager(spenComposerImpl.mNativeHandle));
        SpenNoteTextManager spenNoteTextManager2 = spenComposerImpl.mNoteTextManager;
        if (spenNoteTextManager2 != null) {
            spenNoteTextManager2.setPerformContextMenuActionListener$SDK_fullRelease(new SpenInputManager.PerformContextMenuActionListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.10
                @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PerformContextMenuActionListener
                public boolean onPerformContextMenuAction(int id) {
                    switch (id) {
                        case R.id.cut:
                        case R.id.copy:
                        case R.id.paste:
                            SpenComposerImpl.this.mIsShiftPressed = false;
                            break;
                    }
                    return true;
                }
            });
        }
        SpenContextMenuDelegate spenContextMenuDelegate = new SpenContextMenuDelegate();
        spenComposerImpl.mContextMenuDelegate = spenContextMenuDelegate;
        spenContextMenuDelegate.setTextManager(spenComposerImpl.mNoteTextManager);
        SpenContextMenuDelegate spenContextMenuDelegate2 = spenComposerImpl.mContextMenuDelegate;
        if (spenContextMenuDelegate2 != null && (spenComposerContextMenu = spenComposerImpl.mContextMenu) != null) {
            spenComposerContextMenu.setContextMenuDelegate(spenContextMenuDelegate2);
        }
        View view19 = spenComposerImpl.mView;
        if (view19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view19 = null;
        }
        Context context5 = view19.getContext();
        View view20 = spenComposerImpl.mView;
        if (view20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view20 = null;
        }
        SpenControlObjectManager spenControlObjectManager = new SpenControlObjectManager(context5, view20);
        spenComposerImpl.mControlObjectManager = spenControlObjectManager;
        companion3.Native_setControlObjectManager(spenComposerImpl.mNativeHandle, spenControlObjectManager.getNativeHandle());
        spenControlObjectManager.setControlActionListener(new ISpenControlObjectManager.ControlActionListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl$init$12$1
            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public boolean isFloatingViewShown() {
                SpenConvertToTextManager spenConvertToTextManager2 = this.this$0.mConvertToTextManager;
                return spenConvertToTextManager2 != null && spenConvertToTextManager2.isFloatingViewShown();
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestCoordinateInfo(ISpenControlObjectManager.CoordinateInfo coordinateInfo, SpenObjectBase objectBase) {
                PointF pointF;
                PointF pointF2 = new PointF();
                if (this.this$0.getOwnerPage(objectBase) != null) {
                    pointF2.set(r5.getOffset().x, r5.getOffset().y);
                }
                SpenNoteZoomScroller spenNoteZoomScroller = this.this$0.mSpenNoteZoomScroller;
                if (spenNoteZoomScroller != null) {
                    if (coordinateInfo != null) {
                        coordinateInfo.zoomRatio = spenNoteZoomScroller.getContentScale() * spenNoteZoomScroller.getZoomScale();
                    }
                    if (coordinateInfo != null) {
                        PointF pan = spenNoteZoomScroller.getPan();
                        if (pan == null) {
                            pan = new PointF();
                        }
                        coordinateInfo.pan = pan;
                    }
                    if (coordinateInfo == null || (pointF = coordinateInfo.startPos) == null) {
                        return;
                    }
                    float f = pointF2.x;
                    float f4 = coordinateInfo.zoomRatio;
                    pointF.set(f * f4, pointF2.y * f4);
                }
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestMoveIntoScreen(SpenObjectBase objectBase) {
                PointF pointF = new PointF();
                if (this.this$0.getOwnerPage(objectBase) != null) {
                    pointF.set(r1.getOffset().x, r1.getOffset().y);
                }
                RectF rect = objectBase != null ? objectBase.getRect() : null;
                if (rect != null) {
                    rect.offset(pointF.x, pointF.y);
                }
                SpenNoteZoomScroller spenNoteZoomScroller = this.this$0.mSpenNoteZoomScroller;
                if (spenNoteZoomScroller != null) {
                    spenNoteZoomScroller.scrollToContentRect(rect);
                }
            }

            @Override // com.samsung.android.sdk.pen.control.ISpenControlObjectManager.ControlActionListener
            public void onRequestSelectObject(SpenObjectBase objectBase) {
                SpenWNote spenWNote;
                SpenWNote spenWNote2 = this.this$0.mDocument;
                ArrayList<SpenObjectBase> selectedObject = spenWNote2 != null ? spenWNote2.getSelectedObject() : null;
                if (selectedObject != null && selectedObject.size() > 0 && (spenWNote = this.this$0.mDocument) != null) {
                    spenWNote.selectObject((ArrayList<SpenObjectBase>) null);
                }
                SpenWNote spenWNote3 = this.this$0.mDocument;
                if (spenWNote3 != null) {
                    spenWNote3.selectObject(objectBase);
                }
            }
        });
        View view21 = spenComposerImpl.mView;
        if (view21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view21 = null;
        }
        spenComposerImpl.mFloatingViewManager = new SpenFloatingViewManager(view21);
        View view22 = spenComposerImpl.mView;
        if (view22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view22 = null;
        }
        spenComposerImpl.mAccDelegateImpl = new AccessibilityDelegateImpl(view22, new SpenAccessibilityDelegateListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.13
            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public int[] getCursorPos(int nativeID, int cursorIndex, boolean isNext, int selectBy) {
                return SpenComposerImpl.INSTANCE.Native_getCursorIndexInObjectText(SpenComposerImpl.this.mNativeHandle, nativeID, cursorIndex, isNext, selectBy);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public Triple<Editable, Integer, Integer> getEditable(int nativeID, int pageIndex) {
                SpenNoteTextManager spenNoteTextManager3 = SpenComposerImpl.this.mNoteTextManager;
                if (spenNoteTextManager3 != null) {
                    return spenNoteTextManager3.getObjectEditable(nativeID, pageIndex);
                }
                return null;
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public List<SpenAccessibilityNodeInfo> getNodeList() {
                return SpenComposerImpl.INSTANCE.Native_getNodeList(SpenComposerImpl.this.mNativeHandle);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public SpenObjectBase getObjectByNativeId(int nativeId) {
                return SpenComposerImpl.INSTANCE.Native_getObjectByNativeID(SpenComposerImpl.this.mNativeHandle, nativeId);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public boolean isNodeInfoFocused(int nativeID) {
                return SpenComposerImpl.INSTANCE.Native_isNodeInfoFocused(SpenComposerImpl.this.mNativeHandle, nativeID);
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onAccessibilityStateChanged(boolean enabled) {
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onClick(int nativeId) {
                if (SpenComposerImpl.this.mNativeHandle != 0) {
                    SpenComposerImpl.INSTANCE.Native_onNodeInfoClick(SpenComposerImpl.this.mNativeHandle, nativeId, 1);
                }
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onMove(float y2) {
                SpenNoteDeltaZoom spenNoteDeltaZoom = SpenComposerImpl.this.mSpenDeltaZoom;
                PointF pan = spenNoteDeltaZoom != null ? spenNoteDeltaZoom.getPan() : null;
                if (pan != null) {
                    SpenComposerImpl.this.setPan(pan.x, y2);
                }
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public boolean onPerformContextMenuAction(int id) {
                SpenComposerListenerManager listenerManager = SpenComposerImpl.this.getListenerManager();
                if (listenerManager != null) {
                    return listenerManager.onPerformContextMenuAction(id);
                }
                return false;
            }

            @Override // com.samsung.android.sdk.composer.view.accessibility.SpenAccessibilityDelegateListener
            public void onScroll(float dx, float dy) {
                SpenNoteDeltaZoom spenNoteDeltaZoom = SpenComposerImpl.this.mSpenDeltaZoom;
                if (spenNoteDeltaZoom != null) {
                    spenNoteDeltaZoom.scroll(dx, dy);
                }
            }
        });
        spenComposerImpl.mDvfsManager = new SpenDvfsManager(context3);
        spenComposerImpl.mGestureController = new SpenGestureController(companion3.Native_getGestureController(spenComposerImpl.mNativeHandle));
        View view23 = spenComposerImpl.mView;
        if (view23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view23 = null;
        }
        spenComposerImpl.mEdgeEffectManager = new SpenEdgeEffectManager(context3, view23);
        spenComposerImpl.mWritingOptionPatternDetector = new SpenWritingOptionPatternDetector(context3, new SpenWritingOptionPatternDetector.Listener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl.init.14
            @Override // com.samsung.android.sdk.pen.engine.SpenWritingOptionPatternDetector.Listener
            public void onPatternMatched() {
                SpenWritingOptionView spenWritingOptionView;
                if (SpenComposerImpl.this.mWritingOptionView == null) {
                    SpenWritingOptionView.WritingOptionState writingOptionState = SpenWritingOptionView.WritingOptionState.Unsupported;
                    SpenNoteWritingViewManager spenNoteWritingViewManager2 = SpenComposerImpl.this.mNoteWritingViewManager;
                    if (spenNoteWritingViewManager2 != null && spenNoteWritingViewManager2.isFbrDrawPadSupported()) {
                        SpenNoteWritingViewManager spenNoteWritingViewManager3 = SpenComposerImpl.this.mNoteWritingViewManager;
                        writingOptionState = (spenNoteWritingViewManager3 == null || !spenNoteWritingViewManager3.isFbrDrawPadEnabled()) ? SpenWritingOptionView.WritingOptionState.Off : SpenWritingOptionView.WritingOptionState.f4951On;
                    }
                    SpenWritingOptionView.WritingOptionState writingOptionState2 = writingOptionState;
                    SpenNoteWritingViewManager spenNoteWritingViewManager4 = SpenComposerImpl.this.mNoteWritingViewManager;
                    SpenWritingOptionView.WritingOptionState writingOptionState3 = (spenNoteWritingViewManager4 == null || !spenNoteWritingViewManager4.getIsPredictionEnabled()) ? SpenWritingOptionView.WritingOptionState.Off : SpenWritingOptionView.WritingOptionState.f4951On;
                    SpenDvfsManager spenDvfsManager = SpenComposerImpl.this.mDvfsManager;
                    SpenWritingOptionView.WritingOptionState writingOptionState4 = (spenDvfsManager == null || !spenDvfsManager.getIsEnabled()) ? SpenWritingOptionView.WritingOptionState.Off : SpenWritingOptionView.WritingOptionState.f4951On;
                    SpenComposerImpl spenComposerImpl2 = SpenComposerImpl.this;
                    Context context6 = context3;
                    final SpenComposerImpl spenComposerImpl3 = SpenComposerImpl.this;
                    spenComposerImpl2.mWritingOptionView = new SpenWritingOptionView(context6, writingOptionState2, writingOptionState3, writingOptionState4, new SpenWritingOptionView.Listener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl$init$14$onPatternMatched$1
                        @Override // com.samsung.android.sdk.pen.engine.SpenWritingOptionView.Listener
                        public void onDVFSEnabled(boolean enabled) {
                            SpenDvfsManager spenDvfsManager2 = spenComposerImpl3.mDvfsManager;
                            if (spenDvfsManager2 != null) {
                                spenDvfsManager2.setEnabled(enabled);
                            }
                            SpenDvfsManager spenDvfsManager3 = spenComposerImpl3.mDvfsManager;
                            Log.i("SpenComposerImpl", "SpenWritingOptionView DVFS = " + (spenDvfsManager3 != null ? Boolean.valueOf(spenDvfsManager3.getIsEnabled()) : null));
                        }

                        @Override // com.samsung.android.sdk.pen.engine.SpenWritingOptionView.Listener
                        public void onFrontBufferRenderingEnabled(boolean enabled) {
                            SpenNoteWritingViewManager spenNoteWritingViewManager5 = spenComposerImpl3.mNoteWritingViewManager;
                            if (spenNoteWritingViewManager5 != null) {
                                spenNoteWritingViewManager5.setFrontBufferRenderingEnabled(enabled, new boolean[0]);
                            }
                            spenComposerImpl3.setFrontBufferRenderingEnabledInEWP(enabled);
                            SpenNoteWritingViewManager spenNoteWritingViewManager6 = spenComposerImpl3.mNoteWritingViewManager;
                            Log.i("SpenComposerImpl", "SpenWritingOptionView FbrDrawPad = " + (spenNoteWritingViewManager6 != null ? Boolean.valueOf(spenNoteWritingViewManager6.isFbrDrawPadEnabled()) : null));
                        }

                        @Override // com.samsung.android.sdk.pen.engine.SpenWritingOptionView.Listener
                        public void onMeasureMode(boolean enabled) {
                            SpenNoteZoomScroller spenNoteZoomScroller = spenComposerImpl3.mSpenNoteZoomScroller;
                            if (spenNoteZoomScroller != null) {
                                spenNoteZoomScroller.setPan(new PointF(0.0f, 0.0f));
                            }
                            SpenNoteZoomScroller spenNoteZoomScroller2 = spenComposerImpl3.mSpenNoteZoomScroller;
                            if (spenNoteZoomScroller2 != null) {
                                spenNoteZoomScroller2.setZoomScale(1.0f);
                            }
                        }

                        @Override // com.samsung.android.sdk.pen.engine.SpenWritingOptionView.Listener
                        public void onPredictionEnabled(boolean enabled) {
                            SpenNoteWritingViewManager spenNoteWritingViewManager5 = spenComposerImpl3.mNoteWritingViewManager;
                            if (spenNoteWritingViewManager5 != null) {
                                spenNoteWritingViewManager5.setPredictionEnabled(enabled, new boolean[0]);
                            }
                            SpenNoteWritingViewManager spenNoteWritingViewManager6 = spenComposerImpl3.mNoteWritingViewManager;
                            Log.i("SpenComposerImpl", "SpenWritingOptionView Prediction = " + (spenNoteWritingViewManager6 != null ? Boolean.valueOf(spenNoteWritingViewManager6.getIsPredictionEnabled()) : null));
                        }
                    });
                }
                SpenWritingOptionView spenWritingOptionView2 = SpenComposerImpl.this.mWritingOptionView;
                View view24 = null;
                if ((spenWritingOptionView2 != null ? spenWritingOptionView2.getParent() : null) != null || (spenWritingOptionView = SpenComposerImpl.this.mWritingOptionView) == null) {
                    return;
                }
                View view25 = SpenComposerImpl.this.mView;
                if (view25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mView");
                } else {
                    view24 = view25;
                }
                spenWritingOptionView.setParent(view24);
            }
        });
        SpenNoteWritingViewManager spenNoteWritingViewManager2 = spenComposerImpl.mNoteWritingViewManager;
        if (spenNoteWritingViewManager2 != null) {
            spenNoteWritingViewManager2.setFrontBufferRenderingEnabled(true, new boolean[0]);
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager3 = spenComposerImpl.mNoteWritingViewManager;
        if (spenNoteWritingViewManager3 != null) {
            spenNoteWritingViewManager3.setPredictionEnabled(true, new boolean[0]);
        }
        SpenPdfAIModelLoader spenPdfAIModelLoader = new SpenPdfAIModelLoader(context3);
        spenComposerImpl.mPdfAIModelLoader = spenPdfAIModelLoader;
        spenPdfAIModelLoader.setNativeHandle(companion3.Native_getPdfAIModelLoader(spenComposerImpl.mNativeHandle));
        spenComposerImpl.mContext = context3;
        spenComposerImpl.setFrontBufferRenderingEnabledInEWP(true);
        spenComposerImpl.wNoteHelper = new SpenWNoteHelper(false);
        SpenWNoteHelper wNoteHelper = spenComposerImpl.getWNoteHelper();
        if (wNoteHelper != null) {
            companion3.Native_setWNoteHelper(spenComposerImpl.mNativeHandle, wNoteHelper.getNativeHandle());
        }
    }

    private final boolean isInputMethodShown() {
        SpenInputManager.Companion companion = SpenInputManager.INSTANCE;
        View view = this.mView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view = null;
        }
        return companion.isInputMethodShown(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRemoveTwinViewRunnable$lambda$3(SpenComposerImpl spenComposerImpl) {
        View view = spenComposerImpl.mTwinViewAgll;
        if (view != null) {
            view.setTranslationX(view.getWidth());
            view.setTranslationY(view.getHeight());
            view.setVisibility(8);
            view.invalidate();
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
            spenComposerImpl.mTwinViewAgll = null;
            SurfaceView surfaceView = spenComposerImpl.mSurfaceView;
            if (surfaceView != null) {
                SurfaceHolder holder = surfaceView.getHolder();
                Canvas canvasLockHardwareCanvas = holder.lockHardwareCanvas();
                canvasLockHardwareCanvas.drawColor(0);
                holder.unlockCanvasAndPost(canvasLockHardwareCanvas);
            }
            SurfaceView surfaceView2 = spenComposerImpl.mSurfaceViewBG;
            if (surfaceView2 != null) {
                SurfaceHolder holder2 = surfaceView2.getHolder();
                Canvas canvasLockHardwareCanvas2 = holder2.lockHardwareCanvas();
                canvasLockHardwareCanvas2.drawColor(0);
                holder2.unlockCanvasAndPost(canvasLockHardwareCanvas2);
            }
            Log.d(TAG, "hiding mTwinViewAgll completed");
        }
    }

    private final void onActionLinkClicked(String text, int linkType) {
        Log.i(TAG, "onActionLinkClicked text=" + text + ", linkType=" + linkType);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onActionLinkClicked(text, linkType);
        }
    }

    private final void onAddFloatingImageButton(RectF rect, String description, int nativeViewId) {
        onSetHoverIcon(0);
        SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
        if (spenFloatingViewManager != null) {
            spenFloatingViewManager.onAddFloatingImageButton(rect, description, nativeViewId);
        }
    }

    private final void onAddFloatingTextView(RectF rect, String description, float fontSize, int nativeViewId) {
        onSetHoverIcon(0);
        SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
        if (spenFloatingViewManager != null) {
            spenFloatingViewManager.onAddFloatingTextView(rect, description, fontSize, false, nativeViewId);
        }
    }

    private final void onChangeGuideVisible(int type, boolean visible, int count) {
        SpenEasyWritingPadManager spenEasyWritingPadManager = this.mEasyWritingPadManager;
        if (spenEasyWritingPadManager != null) {
            spenEasyWritingPadManager.onChangeGuideVisible(type, visible, count);
        }
    }

    private final void onComposerClicked() {
        Log.i(TAG, "onComposerClicked");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onComposerClicked(this.mCurrentMotionEvent);
        }
    }

    private final void onEditModeChanged(int mode) {
        Log.i(TAG, "onEditModeChanged mode=" + mode);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onEditModeChanged(mode);
        }
    }

    private final void onFlingGesture(boolean isStarted) {
        AbstractC4539a.m3208r("onFlingGesture isStarted=", TAG, isStarted);
        if (isStarted) {
            SpenDvfsManager spenDvfsManager = this.mDvfsManager;
            if (spenDvfsManager != null) {
                spenDvfsManager.acquire();
                return;
            }
            return;
        }
        SpenDvfsManager spenDvfsManager2 = this.mDvfsManager;
        if (spenDvfsManager2 != null) {
            spenDvfsManager2.release();
        }
    }

    private final void onGestureExclusionRectUpdated(List<Rect> rectList) {
        Log.i(TAG, "onGestureExclusionRectUpdated " + rectList.size() + " - " + rectList);
        if (Build.VERSION.SDK_INT >= 29) {
            View view = this.mView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            view.setSystemGestureExclusionRects(rectList);
        }
    }

    private final void onHoverHyperText(RectF rect, String url, float fontSize) {
        int iHashCode = url != null ? url.hashCode() : 0;
        SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
        if (spenFloatingViewManager != null) {
            spenFloatingViewManager.onAddFloatingTextView(rect, url, fontSize, true, iHashCode);
        }
    }

    private final void onHoverStickyNote(SpenCustomObject customObject, RectF rect) {
        if (customObject == null || rect == null) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        SpenNoteCapturePage spenNoteCapturePage = new SpenNoteCapturePage(context);
        Bitmap bitmapCaptureStickyNoteObject = spenNoteCapturePage.captureStickyNoteObject(customObject);
        spenNoteCapturePage.close();
        SpenImageFloatingViewListener spenImageFloatingViewListener = new SpenImageFloatingViewListener() { // from class: com.samsung.android.sdk.composer.SpenComposerImpl$onHoverStickyNote$listener$1
            @Override // com.samsung.android.sdk.composer.view.floatingview.SpenImageFloatingViewListener
            public boolean isInScreen(long nativeHolder, int top) {
                return true;
            }
        };
        SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
        if (spenFloatingViewManager != null) {
            spenFloatingViewManager.onAddFloatingImageView(rect, bitmapCaptureStickyNoteObject, spenImageFloatingViewListener, customObject.getMHandle());
        }
    }

    private final void onInitLayoutFinished() {
        Log.i(TAG, "onInitLayoutFinished");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onInitLayoutFinished();
        }
    }

    private final void onLastPageChanged(int totalHeight) {
        Log.i(TAG, "onLastPageChanged totalHeight=" + totalHeight);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onLastPageChanged(totalHeight);
        }
    }

    private final void onObjectSelected(ArrayList<SpenWPage> pageList, ArrayList<SpenObjectBase> objectList, boolean selected) {
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onObjectSelected(pageList, objectList, selected);
        }
    }

    private final void onPageLayoutChanged(int pageLayoutColumn, int pageLayoutRow, boolean pageLayoutFitScreen, boolean pageLayoutVertical) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageLayoutColumn, pageLayoutRow, "onPageLayoutChanged pageLayoutColumn=", ", pageLayoutRow=", ", pageLayoutFitScreen=");
        sbM1173s.append(pageLayoutFitScreen);
        sbM1173s.append(", pageLayoutVertical=");
        sbM1173s.append(pageLayoutVertical);
        Log.i(TAG, sbM1173s.toString());
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onPageLayoutChanged(pageLayoutColumn, pageLayoutRow, pageLayoutFitScreen, pageLayoutVertical);
        }
    }

    private final void onPullGestureAnimationUpdated(float animatedValue, float viewX, float viewY, boolean isReleased) {
        StringBuilder sbM1176v = AbstractC0622a.m1176v("onPullGestureAnimationUpdated, animatedValue=", animatedValue, ", pan(", viewX, SQLKeyword.COMMA);
        sbM1176v.append(viewY);
        sbM1176v.append("), isReleased=");
        sbM1176v.append(isReleased);
        Log.i(TAG, sbM1176v.toString());
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onPullGestureAnimationUpdated(animatedValue, viewX, viewY, isReleased);
        }
    }

    private final void onSearchTextFinished(int totalCount) {
        Log.i(TAG, "onSearchTextFinished totalCount= " + totalCount);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onSearchTextFinished(totalCount);
        }
    }

    private final void onSearchingText(int totalCount, SearchData searchData) {
        AbstractC6670b.m4744e(totalCount, searchData != null ? searchData.getPageIndex() : -1, "onSearchingText totalCount= ", " pageIndex=", TAG);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onSearchingText(totalCount, searchData);
        }
    }

    private final void onSetFrontBufferRenderingEnable(boolean enable) {
        if (this.mIsOnLayout) {
            Log.i(TAG, "onSetFrontBufferRenderingEnable post enable:" + enable);
            ISpenNoteWritingViewManager noteWritingViewManager = getNoteWritingViewManager();
            if (noteWritingViewManager != null) {
                noteWritingViewManager.setFrontBufferRenderingEnabled(enable, new boolean[0]);
            }
            setFrontBufferRenderingEnabledInEWP(enable);
            return;
        }
        Log.i(TAG, "onSetFrontBufferRenderingEnable enable:" + enable);
        ISpenNoteWritingViewManager noteWritingViewManager2 = getNoteWritingViewManager();
        if (noteWritingViewManager2 != null) {
            noteWritingViewManager2.setFrontBufferRenderingEnabled(enable, new boolean[0]);
        }
        setFrontBufferRenderingEnabledInEWP(enable);
    }

    private final void onSetHoverIcon(int type) {
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointerIcon;
        if (spenHoverPointerIcon != null) {
            spenHoverPointerIcon.setHoveringSpenIcon(type);
        }
    }

    private final void onShowAlertDialog(int id, SpenObjectBase content) {
        Log.i(TAG, "onShowAlertDialog id=" + id);
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onShowAlertDialog(id, content);
        }
    }

    private final void onShowEdgeEffect(boolean left, boolean top, boolean right, boolean bottom, float velocityX, float velocityY) {
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.showEdgeEffect(left, top, right, bottom, velocityX, velocityY);
        }
    }

    private final void onSmoothScrollEnd() {
        Log.i(TAG, "onSmoothScrollEnd");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onSmoothScrollEnd();
        }
    }

    private final void onStickyMemoClicked(SpenCustomObject customObject) {
        Log.i(TAG, "onStickyMemoClicked");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onStickyMemoClicked(customObject);
        }
    }

    private final void onStickyMemoMovedByUser(SpenCustomObject customObject) {
        Log.i(TAG, "onStickyMemoMovedByUser");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onStickyMemoMovedByUser(customObject);
        }
    }

    private final void onStrokeShapeConverted() {
        Log.i(TAG, "onStrokeShapeConverted");
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onStrokeShapeConverted();
        }
    }

    private final void onThumbnailChanged(int pageIndex) {
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onThumbnailChanged(pageIndex);
        }
    }

    private final void onVibrate(int vibrationPattern) {
        AbstractC2322a.m1631u(vibrationPattern, "onVibrate ", TAG);
        View view = this.mView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view = null;
        }
        SpenComposerUtil.performHapticFeedback(view, vibrationPattern);
    }

    private final void updateAllowStrokeRemoverTouchRect() {
        int i;
        if (this.mScreenWidth == 0 || (i = this.mScreenHeight) == 0) {
            this.mAllowStrokeRemoverTouchRect.setEmpty();
            return;
        }
        RectF rectF = this.mAllowStrokeRemoverTouchRect;
        Rect rect = this.mStrokeRemoverTouchMargin;
        rectF.set(rect.left, rect.top, r0 - rect.right, i - rect.bottom);
    }

    private final void updateAllowTouchRect() {
        int i;
        if (this.mScreenWidth == 0 || (i = this.mScreenHeight) == 0) {
            this.mAllowTouchRect.setEmpty();
            return;
        }
        RectF rectF = this.mAllowTouchRect;
        Rect rect = this.mTouchMargin;
        rectF.set(rect.left, rect.top, r0 - rect.right, i - rect.bottom);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void cancelSearch() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_cancelSearch(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public Bitmap captureCurrentView() {
        int i;
        Bitmap bitmap = null;
        if (this.mNativeHandle == 0) {
            return null;
        }
        int i2 = this.mScreenWidth;
        if (i2 == 0 || (i = this.mScreenHeight) == 0) {
            Log.e(TAG, "Not yet to create view");
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            try {
                if (INSTANCE.Native_captureCurrentView(this.mNativeHandle, bitmapCreateBitmap)) {
                    return bitmapCreateBitmap;
                }
                bitmapCreateBitmap.recycle();
                return null;
            } catch (Throwable unused) {
                bitmap = bitmapCreateBitmap;
                Log.e(TAG, "Failed to create bitmap");
                return bitmap;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void clearSearch() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_clearSearch(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void close() {
        Log.i(TAG, "close");
        if (this.mDrawLoopType == 1) {
            View view = this.mView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            ((ViewGroup) view).removeView(this.mTextureView);
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
            }
            this.mTextureView = null;
        }
        finalizeFbrDrawPad();
        Companion companion = INSTANCE;
        companion.Native_setWNoteHelper(this.mNativeHandle, 0L);
        SpenWNoteHelper wNoteHelper = getWNoteHelper();
        if (wNoteHelper != null) {
            wNoteHelper.close();
        }
        SpenNotePdfManager spenNotePdfManager = this.mNotePdfManager;
        if (spenNotePdfManager != null) {
            spenNotePdfManager.close();
        }
        SpenNotePageLayouter spenNotePageLayouter = this.mNotePageLayouter;
        if (spenNotePageLayouter != null) {
            spenNotePageLayouter.setNativeHandle(0L);
        }
        SpenSmartScriptDocument smartScriptDocument = getSmartScriptDocument();
        if (smartScriptDocument != null) {
            smartScriptDocument.close();
        }
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.close();
        }
        this.mEdgeEffectManager = null;
        companion.Native_setControlObjectManager(this.mNativeHandle, 0L);
        SpenControlObjectManager spenControlObjectManager = this.mControlObjectManager;
        if (spenControlObjectManager != null) {
            spenControlObjectManager.close();
        }
        SpenControlObjectManager spenControlObjectManager2 = this.mControlObjectManager;
        if (spenControlObjectManager2 != null) {
            spenControlObjectManager2.setControlActionListener(null);
        }
        SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
        if (spenFloatingViewManager != null) {
            spenFloatingViewManager.close();
        }
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.close();
        }
        this.mContextMenu = null;
        SpenContextMenuDelegate spenContextMenuDelegate = this.mContextMenuDelegate;
        if (spenContextMenuDelegate != null) {
            spenContextMenuDelegate.close();
        }
        this.mContextMenuDelegate = null;
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.close();
        }
        SpenConvertToTextManager spenConvertToTextManager = this.mConvertToTextManager;
        if (spenConvertToTextManager != null) {
            spenConvertToTextManager.close();
        }
        SPenAlignmentManager sPenAlignmentManager = this.mAlignmentManager;
        if (sPenAlignmentManager != null) {
            sPenAlignmentManager.close();
        }
        SPenSTTManager sPenSTTManager = this.mSTTManager;
        if (sPenSTTManager != null) {
            sPenSTTManager.close();
        }
        SPenHwrBeautifierManager hwrBeautifierManager = getHwrBeautifierManager();
        if (hwrBeautifierManager != null) {
            hwrBeautifierManager.close();
        }
        SpenMathManager spenMathManager = this.mMathManager;
        if (spenMathManager != null) {
            spenMathManager.close();
        }
        SpenTextMathManager spenTextMathManager = this.mTextMathManager;
        if (spenTextMathManager != null) {
            spenTextMathManager.close();
        }
        SpenHwrGenerator hwrGenerator = getHwrGenerator();
        if (hwrGenerator != null) {
            hwrGenerator.close();
        }
        SpenPdfAIModelLoader spenPdfAIModelLoader = this.mPdfAIModelLoader;
        if (spenPdfAIModelLoader != null) {
            spenPdfAIModelLoader.close();
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager != null) {
            spenNoteWritingViewManager.close();
        }
        SpenHoverPointerIcon spenHoverPointerIcon = this.mHoverPointerIcon;
        if (spenHoverPointerIcon != null) {
            spenHoverPointerIcon.close();
        }
        companion.Native_finalize(this.mNativeHandle);
        this.mNativeHandle = 0L;
        SpenNoteDeltaZoom spenNoteDeltaZoom = this.mSpenDeltaZoom;
        if (spenNoteDeltaZoom != null) {
            spenNoteDeltaZoom.close();
        }
        SpenNoteZoomScroller spenNoteZoomScroller = this.mSpenNoteZoomScroller;
        if (spenNoteZoomScroller != null) {
            spenNoteZoomScroller.close();
        }
        SpenPenSound spenPenSound = this.mSpenPenSound;
        if (spenPenSound != null) {
            spenPenSound.close();
        }
        SpenNoteLaserManager noteLaserManager = getNoteLaserManager();
        if (noteLaserManager != null) {
            noteLaserManager.close();
        }
        this.noteLaserManager = null;
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            spenComposerContext.close();
        }
        SpenConfiguration spenConfiguration = this.mSpenConfiguration;
        if (spenConfiguration != null) {
            spenConfiguration.close();
        }
        SpenDisplay spenDisplay = this.mSpenDisplay;
        if (spenDisplay != null) {
            spenDisplay.close();
        }
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            accessibilityDelegateImpl.close();
        }
        SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.close();
            View view2 = this.mView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view2 = null;
            }
            if (!view2.isAttachedToWindow()) {
                this.mSpenDrawLoop = null;
            }
        }
        SpenRenderer spenRenderer = this.mRenderer;
        if (spenRenderer != null) {
            spenRenderer.close();
        }
        this.mRenderer = null;
        SpenWritingOptionPatternDetector spenWritingOptionPatternDetector = this.mWritingOptionPatternDetector;
        if (spenWritingOptionPatternDetector != null) {
            spenWritingOptionPatternDetector.close();
        }
        SpenResources.Companion companion2 = SpenResources.INSTANCE;
        View view3 = this.mView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view3 = null;
        }
        companion2.unregisterResourceView(view3);
        SpenDvfsManager spenDvfsManager = this.mDvfsManager;
        if (spenDvfsManager != null) {
            spenDvfsManager.close();
        }
        SpenMemoryLoggerReceiver spenMemoryLoggerReceiver = this.mMemoryLoggerReceiver;
        if (spenMemoryLoggerReceiver == null || SpenDisplay.INSTANCE.getDebugLevel() <= 0) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.unregisterReceiver(spenMemoryLoggerReceiver);
        this.mMemoryLoggerReceiver = null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean dispatchHoverEvent(@Nullable MotionEvent event) {
        AccessibilityDelegateImpl accessibilityDelegateImpl;
        if (event == null || (accessibilityDelegateImpl = this.mAccDelegateImpl) == null || !accessibilityDelegateImpl.dispatchHoverEvent(event)) {
            return false;
        }
        onHoverEvent(event);
        return true;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            return accessibilityDelegateImpl.dispatchKeyEvent(event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void endLazyViewUpdate() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_endLazyViewUpdate(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public CharSequence getAccessibilityClassName() {
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            return accessibilityDelegateImpl.getAccessibilityClassName();
        }
        return null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISPenAlignmentManager getAlignmentManager() {
        return this.mAlignmentManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenControlObjectManager getControlObjectManager() {
        return this.mControlObjectManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenConvertToTextManager getConvertToTextManager() {
        return this.mConvertToTextManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenIGestureController getGestureController() {
        return this.mGestureController;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SPenHwrBeautifierManager getHwrBeautifierManager() {
        return this.hwrBeautifierManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenHwrGenerator getHwrGenerator() {
        return this.hwrGenerator;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenComposerListenerManager getListenerManager() {
        return this.listenerManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenIMathManager getMathManager() {
        return this.mMathManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenNoteLaserManager getNoteLaserManager() {
        return this.noteLaserManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenNoteObjectInserter getNoteObjectInserter() {
        return this.noteObjectInserter;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNotePageLayouter getNotePageLayouter() {
        return this.mNotePageLayouter;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNotePdfManager getNotePdfManager() {
        return this.mNotePdfManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteWritingViewManager getNoteWritingViewManager() {
        return this.mNoteWritingViewManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteZoomScroller getNoteZoomScroller() {
        return this.mSpenNoteZoomScroller;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISPenSTTManager getSTTManager() {
        return this.mSTTManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenSmartScriptDocument getSmartScriptDocument() {
        return this.smartScriptDocument;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public ISpenNoteTextManager getTextManager() {
        return this.mNoteTextManager;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Nullable
    public SpenWNoteHelper getWNoteHelper() {
        return this.wNoteHelper;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void goToPage(int pageIndex) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_goToPage(j, pageIndex);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isContextMenuEnabled() {
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        return spenComposerContextMenu != null && spenComposerContextMenu.isEnabled();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isEasyWritingPadEnabled() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_isEasyWritingPadEnabled(j);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isFbrDrawPadEnabledInEWP() {
        return this.mFbrDrawPad != null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isFitToScreen(boolean isFitToWidth) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_isFitToScreen(j, isFitToWidth);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isMathEnabled() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_isMathEnabled(j);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean isPageFitToScreen(int pageIndex, boolean isFitToWidth) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_isPageFitToScreen(j, pageIndex, isFitToWidth);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onAttachedToWindow() {
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.onAttachedToWindow();
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager != null) {
            spenNoteWritingViewManager.onAttachedToWindow();
        }
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        View view = null;
        if (spenEdgeEffectManager != null) {
            View view2 = this.mView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view2 = null;
            }
            spenEdgeEffectManager.attachToParentView(view2.getParent());
        }
        View view3 = this.mView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
        } else {
            view = view3;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        SpenFbrDrawPad spenFbrDrawPad = this.mFbrDrawPad;
        if (spenFbrDrawPad != null) {
            if (spenFbrDrawPad.getParent() != null) {
                ViewParent parent2 = spenFbrDrawPad.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).removeView(spenFbrDrawPad);
            }
            if (spenFbrDrawPad.getParent() == null) {
                spenFbrDrawPad.setVisibility(4);
                spenFbrDrawPad.setZOrderOnTop(true);
                viewGroup.addView(spenFbrDrawPad);
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onConfigurationChanged() {
        if (this.mDocument != null) {
            SpenResources.Companion companion = SpenResources.INSTANCE;
            View view = this.mView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            companion.setResources(view.getResources());
            View view3 = this.mView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            } else {
                view2 = view3;
            }
            SpenDisplay spenDisplay = new SpenDisplay(view2.getContext().getApplicationContext());
            SpenDisplay spenDisplay2 = this.mSpenDisplay;
            if (spenDisplay2 != null) {
                spenDisplay2.copy(spenDisplay);
            }
            SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
            if (spenNoteTextManager != null) {
                spenNoteTextManager.onConfigurationChanged();
            }
            long j = this.mNativeHandle;
            if (j != 0) {
                INSTANCE.Native_onConfigurationChanged(j);
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onCreateContextMenu(@Nullable ContextMenu menu) {
        Log.i(TAG, "onCreateContextMenu()");
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.onCreateContextMenu(menu);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onDetachedFromWindow() {
        Log.i(TAG, "onDetachedFromWindow :" + this.mNativeHandle);
        if (this.mNativeHandle == 0) {
            SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
            if (spenDrawLoopInterface != null) {
                spenDrawLoopInterface.onViewDetachedFromWindow();
            }
            this.mSpenDrawLoop = null;
        }
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            spenComposerContext.onViewDetachedFromWindow();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onDraw(@Nullable Canvas canvas) {
        Bitmap bitmapCaptureCurrentView;
        if (this.mNativeHandle == 0) {
            return;
        }
        if (this.mSpenDrawLoop != null) {
            if (this.mDrawLoopType == 1 && this.mDocInited) {
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                }
                Configuration configuration = context.getResources().getConfiguration();
                Integer numValueOf = configuration != null ? Integer.valueOf(configuration.uiMode & 48) : null;
                int i = this.mUseInitBackgroundColor ? this.mInitBackgroundColor : (numValueOf != null && numValueOf.intValue() == 32) ? -16777216 : -1;
                SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
                Intrinsics.checkNotNull(spenDrawLoopInterface, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
                ((SpenDrawLoopTexture) spenDrawLoopInterface).setCurrentViewColor(i);
                this.mDocInited = false;
            }
            int i2 = this.mDrawLoopType;
            if (i2 == 2) {
                if (this.mDocInited) {
                    if (this.mSurfaceView != null && (bitmapCaptureCurrentView = captureCurrentView()) != null) {
                        SurfaceView surfaceView = this.mSurfaceView;
                        Intrinsics.checkNotNull(surfaceView);
                        SurfaceHolder holder = surfaceView.getHolder();
                        Canvas canvasLockHardwareCanvas = holder.lockHardwareCanvas();
                        canvasLockHardwareCanvas.drawColor(getClearColor());
                        canvasLockHardwareCanvas.drawBitmap(bitmapCaptureCurrentView, 0.0f, 0.0f, this.mCapturePaint);
                        holder.unlockCanvasAndPost(canvasLockHardwareCanvas);
                    }
                    this.mDocInited = false;
                } else {
                    SpenDrawLoopInterface spenDrawLoopInterface2 = this.mSpenDrawLoop;
                    if (spenDrawLoopInterface2 != null) {
                        spenDrawLoopInterface2.onDraw(canvas);
                    }
                }
            } else if (i2 == 3) {
                SpenDrawLoopInterface spenDrawLoopInterface3 = this.mSpenDrawLoop;
                if (spenDrawLoopInterface3 != null) {
                    spenDrawLoopInterface3.onDraw(canvas);
                }
                if (this.mDocInited) {
                    SpenDrawLoopInterface spenDrawLoopInterface4 = this.mSpenDrawLoop;
                    if (spenDrawLoopInterface4 != null) {
                        spenDrawLoopInterface4.onResume();
                    }
                    this.mDocInited = false;
                }
            } else {
                SpenDrawLoopInterface spenDrawLoopInterface5 = this.mSpenDrawLoop;
                if (spenDrawLoopInterface5 != null) {
                    spenDrawLoopInterface5.onDraw(canvas);
                }
            }
        }
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.draw(canvas);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        if (this.mNativeHandle == 0) {
            return;
        }
        AbstractC4539a.m3208r("onFocusChanged gainFocus=", TAG, gainFocus);
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.onFocusChanged(gainFocus);
        }
        AccessibilityDelegateImpl accessibilityDelegateImpl = this.mAccDelegateImpl;
        if (accessibilityDelegateImpl != null) {
            accessibilityDelegateImpl.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onGenericMotionEvent(@Nullable MotionEvent event) {
        if (this.mNativeHandle == 0) {
            return false;
        }
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf == null || numValueOf.intValue() != 8) {
            return false;
        }
        AbstractC2322a.m1631u(event.getAction(), "[JavaGesture] onGenericMotionEvent event=", TAG);
        return INSTANCE.Native_onMouseWheel(this.mNativeHandle, event.getX(), event.getY(), event.getAxisValue(9), event.getAxisValue(10));
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onHoverEvent(@Nullable MotionEvent event) {
        if (this.mNativeHandle != 0 && event != null) {
            SpenFloatingViewManager spenFloatingViewManager = this.mFloatingViewManager;
            if (spenFloatingViewManager != null) {
                spenFloatingViewManager.onHoverEvent(event);
            }
            SpenComposerListenerManager listenerManager = getListenerManager();
            if (listenerManager != null) {
                View view = this.mView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mView");
                    view = null;
                }
                listenerManager.onHover(view, event);
            }
            if (event.getToolType(0) == 2 || event.getToolType(0) == 3) {
                INSTANCE.Native_onHover(this.mNativeHandle, new SpenMotionEvent(event));
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (this.mNativeHandle != 0 && event != null) {
            if (keyCode == 59 || keyCode == 60) {
                this.mIsShiftPressed = true;
            }
            SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
            if (spenNoteTextManager != null && spenNoteTextManager.onKeyDown(keyCode, event)) {
                return true;
            }
            int metaState = event.getMetaState();
            if (this.mIsShiftPressed) {
                metaState |= 1;
            }
            if (INSTANCE.Native_onKeyEvent(this.mNativeHandle, event.getAction(), keyCode, event.getDownTime(), event.getEventTime(), event.getRepeatCount(), metaState, event.getFlags())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyPreIme(int keyCode, @Nullable KeyEvent event) {
        SpenObjectTextBox bodyText;
        SpenObjectTextBox bodyText2;
        if (Build.VERSION.SDK_INT < 35 && this.mNativeHandle != 0 && event != null && keyCode == 4 && event.getAction() == 0) {
            SpenComposerContext spenComposerContext = this.mSpenComposerContext;
            if (spenComposerContext == null || spenComposerContext.getMMode() != 2) {
                SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
                if (spenNoteTextManager != null) {
                    return spenNoteTextManager.onKeyPreIme(keyCode, event);
                }
            } else {
                SpenWNote spenWNote = this.mDocument;
                Integer numValueOf = null;
                Integer numValueOf2 = (spenWNote == null || (bodyText2 = spenWNote.getBodyText()) == null) ? null : Integer.valueOf(bodyText2.getSelectedStart());
                SpenWNote spenWNote2 = this.mDocument;
                if (spenWNote2 != null && (bodyText = spenWNote2.getBodyText()) != null) {
                    numValueOf = Integer.valueOf(bodyText.getSelectedEnd());
                }
                if (!Intrinsics.areEqual(numValueOf2, numValueOf)) {
                    SpenWNote spenWNote3 = this.mDocument;
                    Intrinsics.checkNotNull(spenWNote3);
                    spenWNote3.getBodyText().setSelection(-1, -1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyShortcut(int keyCode, @Nullable KeyEvent event) {
        SpenNoteTextManager spenNoteTextManager;
        if (this.mNativeHandle == 0 || event == null || (spenNoteTextManager = this.mNoteTextManager) == null) {
            return false;
        }
        return spenNoteTextManager.onKeyShortcut(keyCode, event);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        if (this.mNativeHandle != 0 && event != null) {
            if (keyCode == 59 || keyCode == 60) {
                this.mIsShiftPressed = false;
            }
            SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
            if (spenNoteTextManager != null && spenNoteTextManager.onKeyUp(keyCode, event)) {
                return true;
            }
            int metaState = event.getMetaState();
            if (this.mIsShiftPressed) {
                metaState |= 1;
            }
            if (INSTANCE.Native_onKeyEvent(this.mNativeHandle, event.getAction(), keyCode, event.getDownTime(), event.getEventTime(), event.getRepeatCount(), metaState, event.getFlags())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @RequiresApi(26)
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        SpenNoteTextManager spenNoteTextManager;
        SpenDrawLoopInterface spenDrawLoopInterface;
        Log.i(TAG, "onLayout begin");
        if (this.mNativeHandle == 0) {
            return;
        }
        int i = right - left;
        int i2 = bottom - top;
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            listenerManager.onLayout(changed, this.mScreenWidth, this.mScreenHeight, i, i2);
        }
        if (this.mScreenWidth == i && this.mScreenHeight == i2) {
            int i4 = this.mDrawLoopType;
            if (i4 != 1) {
                if (i4 != 3 || (spenDrawLoopInterface = this.mSpenDrawLoop) == null) {
                    return;
                }
                spenDrawLoopInterface.onResume();
                return;
            }
            SpenDrawLoopTexture spenDrawLoopTexture = (SpenDrawLoopTexture) this.mSpenDrawLoop;
            Context context = this.mContext;
            View view = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            int i5 = Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0);
            if (this.mHighTextContrastEnabled != i5) {
                this.mHighTextContrastEnabled = i5;
                if (spenDrawLoopTexture != null && !spenDrawLoopTexture.IsTwinViewVisible()) {
                    AbstractC2322a.m1631u(this.mHighTextContrastEnabled, "onLayout; high_text_contrast_enabled changed, mHighTextContrastEnabled = ", TAG);
                    spenDrawLoopTexture.setOwnedTwinView(createTwinView());
                    View view2 = this.mView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mView");
                    } else {
                        view = view2;
                    }
                    spenDrawLoopTexture.setCaptureCurrentViewBmp(((SpenComposer) view).captureCurrentView());
                }
            }
            if (spenDrawLoopTexture != null) {
                spenDrawLoopTexture.onResume();
            }
            Log.i(TAG, "onLayout same end");
            return;
        }
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        SpenDrawLoopInterface spenDrawLoopInterface2 = this.mSpenDrawLoop;
        if (spenDrawLoopInterface2 != null) {
            spenDrawLoopInterface2.setScreenSize(i, i2);
        }
        updateAllowTouchRect();
        updateAllowStrokeRemoverTouchRect();
        SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
        if (spenEdgeEffectManager != null) {
            spenEdgeEffectManager.setScreenInfo(i, i2, 0, 0);
        }
        this.mIsOnLayout = true;
        INSTANCE.Native_onLayout(this.mNativeHandle, changed, left, top, right, bottom);
        this.mIsOnLayout = false;
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager != null) {
            spenNoteWritingViewManager.onLayout(changed, left, top, right, bottom);
        }
        SpenWritingOptionPatternDetector spenWritingOptionPatternDetector = this.mWritingOptionPatternDetector;
        if (spenWritingOptionPatternDetector != null) {
            spenWritingOptionPatternDetector.setViewSize(i, i2);
        }
        SpenControlObjectManager spenControlObjectManager = this.mControlObjectManager;
        if (spenControlObjectManager != null) {
            spenControlObjectManager.setScreenSize(i, i2);
        }
        if (this.mDocument != null && (spenNoteTextManager = this.mNoteTextManager) != null) {
            spenNoteTextManager.onLayout(changed);
        }
        SpenDrawLoopInterface spenDrawLoopInterface3 = this.mSpenDrawLoop;
        if (spenDrawLoopInterface3 != null) {
            spenDrawLoopInterface3.onLayout(changed);
        }
        if (this.mDrawLoopType == 2) {
            Bitmap bitmapCaptureCurrentView = captureCurrentView();
            this.mTwinViewAgll = createTwinView();
            setCaptureCurrentViewBmp(bitmapCaptureCurrentView);
        }
        Log.i(TAG, "onLayout end");
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onPause() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_onPause(j);
        }
        SpenPenSound spenPenSound = this.mSpenPenSound;
        if (spenPenSound != null) {
            spenPenSound.unregisterPenSoundSolution();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onPopulateAccessibilityEvent(@Nullable AccessibilityEvent event) {
        SpenNoteTextManager spenNoteTextManager;
        if (event == null || (spenNoteTextManager = this.mNoteTextManager) == null) {
            return;
        }
        spenNoteTextManager.onPopulateAccessibilityEvent(event);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onResume() {
        if (this.mNativeHandle != 0) {
            Log.i(TAG, "onResume. Restore GL resources");
            SpenDisplay spenDisplay = this.mSpenDisplay;
            if (spenDisplay != null) {
                spenDisplay.updateDebugLevel();
            }
            SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
            if (spenDrawLoopInterface != null) {
                spenDrawLoopInterface.onResume();
            }
            INSTANCE.Native_onResume(this.mNativeHandle);
        }
        SpenPenSound spenPenSound = this.mSpenPenSound;
        if (spenPenSound != null) {
            spenPenSound.registerPenSoundSolution();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onScaleByScreenSize(boolean enable, int startWidth, int startHeight, int endWidth, int endHeight) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_onScaleByScreenSize(j, enable, startWidth, startHeight, endWidth, endHeight);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        boolean z;
        int i;
        long j;
        String str;
        String str2;
        MotionEvent motionEvent;
        SpenDrawLoopAGLL spenDrawLoopAGLL;
        SpenDrawLoopAGLL spenDrawLoopAGLL2;
        SpenLatencyConfiguration spenLatencyConfiguration;
        if (this.mNativeHandle == 0 || event == null) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            convertMotionEventPenButtonAction(event);
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        int toolTypeAction = spenNoteWritingViewManager != null ? spenNoteWritingViewManager.getToolTypeAction(event.getToolType(0)) : 0;
        int actionMasked = event.getActionMasked();
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC0000a.m26w(AbstractC0622a.m1173s(actionMasked, event.getToolType(0), "[JavaGesture] Note onTouch begin. action=", ", toolType=", ", toolTypeAction="), TAG, toolTypeAction);
        SpenWritingOptionView spenWritingOptionView = this.mWritingOptionView;
        if (spenWritingOptionView != null) {
            spenWritingOptionView.onTouchEvent(event);
        }
        SpenComposerListenerManager listenerManager = getListenerManager();
        if (listenerManager != null) {
            View view = this.mView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            if (listenerManager.onTouch(view, event)) {
                Log.i(TAG, "[JavaGesture] Note onTouchEvent is consumed by PreTouchListener. elapsed=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                return true;
            }
        }
        if (actionMasked == 0 || actionMasked == MotionEventWrapper.ACTION_PEN_DOWN) {
            boolean zContains = this.mAllowTouchRect.contains(event.getX(), event.getY());
            this.mIsDisAllowTouch = !zContains;
            z = false;
            if (zContains) {
                i = toolTypeAction;
                j = jCurrentTimeMillis;
                str = "mView";
                str2 = "ms";
            } else {
                float x = event.getX();
                j = jCurrentTimeMillis;
                float y2 = event.getY();
                RectF rectF = this.mAllowTouchRect;
                str = "mView";
                float f = rectF.left;
                i = toolTypeAction;
                float f4 = rectF.top;
                str2 = "ms";
                float f5 = rectF.right;
                float f6 = rectF.bottom;
                StringBuilder sbM1176v = AbstractC0622a.m1176v("event.getX() : ", x, ", event.getY() : ", y2, " mAllowTouchRect left : ");
                AbstractC11014a.m12337v(sbM1176v, f, ", top : ", f4, ", right : ");
                sbM1176v.append(f5);
                sbM1176v.append(", bottom : ");
                sbM1176v.append(f6);
                Log.i(TAG, sbM1176v.toString());
                Log.i(TAG, "[JavaGesture] disallow touch down by touch margin");
            }
            if (!this.mIsDisAllowTouch && actionMasked == MotionEventWrapper.ACTION_PEN_DOWN) {
                boolean zContains2 = this.mAllowStrokeRemoverTouchRect.contains(event.getX(), event.getY());
                this.mIsDisAllowTouch = !zContains2;
                if (!zContains2) {
                    float x2 = event.getX();
                    float y3 = event.getY();
                    RectF rectF2 = this.mAllowStrokeRemoverTouchRect;
                    float f7 = rectF2.left;
                    float f8 = rectF2.top;
                    float f9 = rectF2.right;
                    float f10 = rectF2.bottom;
                    StringBuilder sbM1176v2 = AbstractC0622a.m1176v("event.getX() : ", x2, ", event.getY() : ", y3, " mAllowStrokeRemoverTouchRect left : ");
                    AbstractC11014a.m12337v(sbM1176v2, f7, ", top : ", f8, ", right : ");
                    sbM1176v2.append(f9);
                    sbM1176v2.append(", bottom : ");
                    sbM1176v2.append(f10);
                    Log.i(TAG, sbM1176v2.toString());
                    Log.i(TAG, "[JavaGesture] disallow touch down by StrokeRemover touch margin " + this.mAllowStrokeRemoverTouchRect);
                }
            }
        } else {
            z = false;
            i = toolTypeAction;
            j = jCurrentTimeMillis;
            str = "mView";
            str2 = "ms";
        }
        if (this.mIsDisAllowTouch) {
            return z;
        }
        if (actionMasked == 0) {
            SpenNoteWritingViewManager spenNoteWritingViewManager2 = this.mNoteWritingViewManager;
            boolean zCheckAndUpdateUnbufferedDispatch = (spenNoteWritingViewManager2 == null || (spenLatencyConfiguration = spenNoteWritingViewManager2.getSpenLatencyConfiguration()) == null) ? z : spenLatencyConfiguration.checkAndUpdateUnbufferedDispatch();
            this.mIsUnbufferedDispatch = zCheckAndUpdateUnbufferedDispatch;
            if (this.mDrawLoopType == 2 && i2 >= 29 && (spenDrawLoopAGLL2 = (SpenDrawLoopAGLL) this.mSpenDrawLoop) != null) {
                spenDrawLoopAGLL2.setUnbuffereDispatch(zCheckAndUpdateUnbufferedDispatch);
            }
            if (this.mIsUnbufferedDispatch) {
                View view2 = this.mView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    view2 = null;
                }
                motionEvent = event;
                view2.requestUnbufferedDispatch(motionEvent);
            } else {
                motionEvent = event;
            }
            this.mIsRequestTouchCancel = z;
            this.mIsTouchDown = true;
            int historySize = motionEvent.getHistorySize();
            for (int i4 = 0; i4 < historySize; i4++) {
                Log.i(TAG, "[JavaGesture] composer index : " + i4 + " , down time : " + motionEvent.getDownTime() + " , eventTime : " + motionEvent.getHistoricalEventTime(i4));
            }
            long downTime = motionEvent.getDownTime();
            long eventTime = motionEvent.getEventTime();
            StringBuilder sbM1323p = AbstractC1974b.m1323p(downTime, "[JavaGesture] composer down time : ", ", eventTime : ");
            sbM1323p.append(eventTime);
            Log.i(TAG, sbM1323p.toString());
        } else {
            motionEvent = event;
        }
        if (actionMasked == 3 && !this.mIsTouchDown) {
            Log.i(TAG, "[JavaGesture] Note ignore touch cancel because we didn't receive touch down first. elapsed=" + (System.currentTimeMillis() - j) + str2);
            return false;
        }
        String str3 = str2;
        if (this.mIsRequestTouchCancel) {
            motionEvent.setAction(3);
            Log.i(TAG, "[JavaGesture] touch canceled by request");
            this.mIsRequestTouchCancel = false;
        }
        int i5 = i;
        SpenGesture.INSTANCE.onTouchEvent(motionEvent, i5 != 1);
        SpenWritingOptionPatternDetector spenWritingOptionPatternDetector = this.mWritingOptionPatternDetector;
        if (spenWritingOptionPatternDetector != null) {
            spenWritingOptionPatternDetector.onTouchEvent(motionEvent);
        }
        if (actionMasked == 7) {
            setEasyWritingPadEnable(true);
        }
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.onParentTouchEvent(motionEvent);
        }
        SpenMotionEvent spenMotionEvent = new SpenMotionEvent(motionEvent);
        this.mCurrentMotionEvent = motionEvent;
        if (this.mDrawLoopType == 1) {
            SpenEdgeEffectManager spenEdgeEffectManager = this.mEdgeEffectManager;
            int i6 = ((spenEdgeEffectManager == null || !spenEdgeEffectManager.isAnimationsFinished()) ? 0 : 1) ^ 1;
            if (i6 != this.mPrevEdgeAnimationState) {
                INSTANCE.Native_setEdgeAnimationState(this.mNativeHandle, i6);
                this.mPrevEdgeAnimationState = i6;
            }
        }
        INSTANCE.Native_onTouch(this.mNativeHandle, spenMotionEvent);
        SpenPenSound spenPenSound = this.mSpenPenSound;
        if (spenPenSound != null) {
            spenPenSound.onTouch(motionEvent, i5);
        }
        SpenControlObjectManager spenControlObjectManager = this.mControlObjectManager;
        if (spenControlObjectManager != null) {
            spenControlObjectManager.onTouch(motionEvent);
        }
        SpenEdgeEffectManager spenEdgeEffectManager2 = this.mEdgeEffectManager;
        if (spenEdgeEffectManager2 != null) {
            spenEdgeEffectManager2.onTouch(motionEvent);
        }
        SpenMathManager spenMathManager = this.mMathManager;
        if (spenMathManager != null) {
            spenMathManager.onTouch(motionEvent);
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mCurrentMotionEvent = null;
            this.mIsTouchDown = false;
        }
        if (this.mDrawLoopType == 2 && Build.VERSION.SDK_INT >= 29 && this.mIsUnbufferedDispatch && (spenDrawLoopAGLL = (SpenDrawLoopAGLL) this.mSpenDrawLoop) != null) {
            spenDrawLoopAGLL.onDrawFbr();
        }
        float x5 = motionEvent.getX();
        float y4 = motionEvent.getY();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j;
        StringBuilder sbM1176v3 = AbstractC0622a.m1176v("[JavaGesture] Note onTouch end. (", x5, SQLKeyword.COMMA, y4, "), elapsed=");
        sbM1176v3.append(jCurrentTimeMillis2);
        sbM1176v3.append(str3);
        Log.i(TAG, sbM1176v3.toString());
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onTrimMemory(int level) {
        if (this.mNativeHandle == 0) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if ((i > 34 || level != 80) && (i <= 34 || level != 40)) {
            return;
        }
        SpenResources.INSTANCE.forceClearResources();
        INSTANCE.Native_onTrimMemory(this.mNativeHandle);
        SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
        if (spenDrawLoopInterface != null) {
            spenDrawLoopInterface.onPause();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean pauseSearchText() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_pauseSearchText(j);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestAlignmentContent(int pageIndex) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_requestAlignmentContent(j, pageIndex);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestCancelTouch() {
        this.mIsRequestTouchCancel = true;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestKeepPageFitToScreenWhenPageFit() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_requestKeepPageFitToScreenWhenPageFit(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void requestResetZoomScaleToDefault() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_requestResetZoomScaleToDefault(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean resumeSearchText(@Nullable String searchText, boolean includeSearchData) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_resumeSearchText(j, searchText, includeSearchData);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchFocusNext() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_searchFocusNext(j);
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchFocusPrev() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_searchFocusPrev(j);
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public int searchText(@Nullable String searchText, boolean includeSearchData) {
        if (this.mNativeHandle != 0) {
            if (searchText != null && searchText.length() != 0) {
                return INSTANCE.Native_searchText(this.mNativeHandle, searchText, includeSearchData);
            }
            clearSearch();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setActionLinkEnabled(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setActionLinkEnabled(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setActionLinkVisible(boolean visible) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setActionLinkVisible(j, visible);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAllwaysFitPageToScreen(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setAllwaysFitPageToScreen(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAutoCleanUpEnabled(boolean enable) {
        SPenHwrBeautifierManager hwrBeautifierManager = getHwrBeautifierManager();
        if (hwrBeautifierManager != null) {
            hwrBeautifierManager.setAutoCleanUpEnabled(enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setAutoScrollEnabled(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setAutoScrollEnabled(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @RequiresApi(26)
    public void setCaptureCurrentViewBmp(@Nullable Bitmap bitmap) {
        View view = this.mTwinViewAgll;
        if (view != null) {
            Log.d(TAG, "Show mTwinViewAgll and start delayed hide of mTwinViewAgll ");
            this.mHandlerTwin.removeCallbacks(this.mRemoveTwinViewRunnable);
            view.setBackground(new BitmapDrawable(bitmap));
            view.setVisibility(0);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.invalidate();
            this.mHandlerTwin.post(this.mRemoveTwinViewRunnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setColorTheme(int theme) {
        boolean z;
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            Log.i(TAG, "[ComposerView] setColorTheme = " + theme);
            spenComposerContext.setColorTheme(theme);
            SpenConfiguration.Companion companion = SpenConfiguration.INSTANCE;
            View view = this.mView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view = null;
            }
            boolean zIsSystemDarkMode = companion.isSystemDarkMode(view.getContext());
            SpenConvertToTextManager spenConvertToTextManager = this.mConvertToTextManager;
            if (spenConvertToTextManager != null) {
                if (zIsSystemDarkMode) {
                    z = spenComposerContext.getMColorTheme() == 1;
                }
                spenConvertToTextManager.setDarkModeEnabled(zIsSystemDarkMode, z);
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setContextMenuEnabled(boolean z) {
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.setEnabled(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDarkModeEnabled(boolean enabled) {
        boolean z;
        SpenComposerContext spenComposerContext;
        SpenComposerContext spenComposerContext2 = this.mSpenComposerContext;
        if (spenComposerContext2 != null) {
            spenComposerContext2.setSystemDarkMode(enabled);
        }
        SpenConvertToTextManager spenConvertToTextManager = this.mConvertToTextManager;
        if (spenConvertToTextManager != null) {
            if (!enabled || (spenComposerContext = this.mSpenComposerContext) == null) {
                z = false;
            } else {
                z = true;
                if (spenComposerContext.getMColorTheme() != 1) {
                }
            }
            spenConvertToTextManager.setDarkModeEnabled(enabled, z);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setDocument(@Nullable SpenWNote doc) {
        if (this.mNativeHandle == 0) {
            return false;
        }
        if (Intrinsics.areEqual(doc, this.mDocument)) {
            Log.i(TAG, "setDocument : same document");
            return false;
        }
        this.mDocument = doc;
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.setDocument(doc);
        }
        SpenConvertToTextManager spenConvertToTextManager = this.mConvertToTextManager;
        if (spenConvertToTextManager != null) {
            spenConvertToTextManager.setDocument(this.mDocument);
        }
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            SpenNoteLaserManager noteLaserManager = getNoteLaserManager();
            if (noteLaserManager != null) {
                noteLaserManager.setDocumentSize(spenWNote.getWidth(), spenWNote.getHeight());
            }
            SpenPenSound spenPenSound = this.mSpenPenSound;
            if (spenPenSound != null) {
                spenPenSound.registerPenSoundSolution();
            }
        }
        if (SpenComposerFeatures.isSupportSmartScript()) {
            long jNative_getSmartScriptDocument = INSTANCE.Native_getSmartScriptDocument(this.mNativeHandle);
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            this.smartScriptDocument = new SpenSmartScriptDocument(jNative_getSmartScriptDocument, context);
        }
        boolean zNative_setDocument = INSTANCE.Native_setDocument(this.mNativeHandle, doc);
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager != null) {
            spenNoteWritingViewManager.setMinZoomScale(0.75f);
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager2 = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager2 != null) {
            spenNoteWritingViewManager2.setDocument(this.mDocument);
        }
        if (this.mDrawLoopType == 1) {
            if (doc != null) {
                View viewCreateTwinView = createTwinView();
                SpenDrawLoopInterface spenDrawLoopInterface = this.mSpenDrawLoop;
                Intrinsics.checkNotNull(spenDrawLoopInterface, "null cannot be cast to non-null type com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopTexture");
                ((SpenDrawLoopTexture) spenDrawLoopInterface).setOwnedTwinView(viewCreateTwinView);
            }
            this.mDocInited = true;
        }
        int i = this.mDrawLoopType;
        if (i != 2 && i != 3) {
            return zNative_setDocument;
        }
        this.mDocInited = true;
        return zNative_setDocument;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setDvfsFling(@Nullable SpenDvfsInterface dvfsInterface) {
        SpenDvfsManager spenDvfsManager = this.mDvfsManager;
        if (spenDvfsManager != null) {
            spenDvfsManager.setDvfsFling(dvfsInterface);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setEasyWritingPadEnable(boolean enable) {
        SpenDrawLoopAGLL spenDrawLoopAGLL;
        long j = this.mNativeHandle;
        if (j != 0) {
            Companion companion = INSTANCE;
            SpenEasyWritingPadManager spenEasyWritingPadManager = this.mEasyWritingPadManager;
            companion.Native_setEasyWritingPadEnable(j, enable, spenEasyWritingPadManager != null ? spenEasyWritingPadManager.isGuideTextEnabled() : false);
        }
        if (this.mDrawLoopType != 2 || Build.VERSION.SDK_INT < 29 || (spenDrawLoopAGLL = (SpenDrawLoopAGLL) this.mSpenDrawLoop) == null) {
            return;
        }
        spenDrawLoopAGLL.allowFrontBufferRendering(!enable);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setEditMode(int mode) {
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            spenComposerContext.setEditMode(mode);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setFrontBufferRenderingEnabledInEWP(boolean enabled) {
        SpenNoteWritingViewManager spenNoteWritingViewManager;
        SpenLatencyConfiguration spenLatencyConfiguration;
        SpenLatencyConfiguration spenLatencyConfiguration2;
        SpenLatencyConfiguration spenLatencyConfiguration3;
        if (!this.mIsFbrSupportedFeature && enabled) {
            Log.d(TAG, "setFrontBufferRenderingEnabledInEWP false. not supported feature running");
            return false;
        }
        if (this.mNativeHandle == 0) {
            return false;
        }
        AbstractC6670b.m4759t("setFrontBufferRenderingEnabledInEWP enabled = ", TAG, enabled);
        if (!enabled) {
            finalizeFbrDrawPad();
            return true;
        }
        if (this.mFbrDrawPad == null && (spenNoteWritingViewManager = this.mNoteWritingViewManager) != null && (spenLatencyConfiguration = spenNoteWritingViewManager.getSpenLatencyConfiguration()) != null && spenLatencyConfiguration.isFrontBufferRenderingSupported()) {
            Context context = this.mContext;
            View view = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            SpenNoteWritingViewManager spenNoteWritingViewManager2 = this.mNoteWritingViewManager;
            SpenFbrDrawPad spenFbrDrawPad = new SpenFbrDrawPad(context, (spenNoteWritingViewManager2 == null || (spenLatencyConfiguration3 = spenNoteWritingViewManager2.getSpenLatencyConfiguration()) == null || !spenLatencyConfiguration3.getIsChromeOS()) ? false : true, SpenFbrDrawPad.INSTANCE.getEwpMode());
            this.mFbrDrawPad = spenFbrDrawPad;
            INSTANCE.Native_setFbrDrawPad(this.mNativeHandle, spenFbrDrawPad.getHandle());
            View view2 = this.mView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            } else {
                view = view2;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.addView(spenFbrDrawPad);
                spenFbrDrawPad.setVisibility(4);
                spenFbrDrawPad.setZOrderOnTop(true);
            }
            SpenNoteWritingViewManager spenNoteWritingViewManager3 = this.mNoteWritingViewManager;
            if (spenNoteWritingViewManager3 != null && (spenLatencyConfiguration2 = spenNoteWritingViewManager3.getSpenLatencyConfiguration()) != null) {
                spenLatencyConfiguration2.updateHWInfo(spenFbrDrawPad);
            }
        }
        AbstractC6670b.m4759t("setFrontBufferRenderingEnabledInEWP return ", TAG, this.mFbrDrawPad != null);
        return this.mFbrDrawPad != null;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setImageCacheQuality(int imageCacheQuality) {
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            spenComposerContext.setImageCacheQuality(imageCacheQuality);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setInitBackgroundColor(@Nullable Integer color) {
        if (color == null) {
            this.mUseInitBackgroundColor = false;
        } else {
            this.mUseInitBackgroundColor = true;
            this.mInitBackgroundColor = color.intValue();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setInputFormEnabled(boolean enabled) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setInputFormEnabled(j, enabled);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setIsFbrSupportedFeature(boolean mIsFbrSupportedFeature) {
        this.mIsFbrSupportedFeature = mIsFbrSupportedFeature;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setLaserPenEnabled(boolean enable) {
        if (this.mNativeHandle == 0) {
            return;
        }
        Context context = null;
        if (!enable) {
            SpenNoteLaserManager noteLaserManager = getNoteLaserManager();
            if (noteLaserManager != null) {
                noteLaserManager.close();
                this.noteLaserManager = null;
                INSTANCE.Native_setLaserPenEnabled(this.mNativeHandle, false);
                return;
            }
            return;
        }
        if (this.mDocument == null || getNoteLaserManager() != null) {
            return;
        }
        long jNative_setLaserPenEnabled = INSTANCE.Native_setLaserPenEnabled(this.mNativeHandle, true);
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        this.noteLaserManager = new SpenNoteLaserManager(context, jNative_setLaserPenEnabled);
        SpenNoteLaserManager noteLaserManager2 = getNoteLaserManager();
        if (noteLaserManager2 != null) {
            SpenWNote spenWNote = this.mDocument;
            Intrinsics.checkNotNull(spenWNote);
            int width = spenWNote.getWidth();
            SpenWNote spenWNote2 = this.mDocument;
            Intrinsics.checkNotNull(spenWNote2);
            noteLaserManager2.setDocumentSize(width, spenWNote2.getHeight());
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    @Deprecated(message = "")
    public void setLongPressEnabled(boolean enable) {
        SpenGestureController spenGestureController = this.mGestureController;
        if (spenGestureController != null) {
            spenGestureController.setLongPressEnabled(enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setMode(int mode) {
        AbstractC2322a.m1631u(mode, "setMode : ", TAG);
        SpenComposerContext spenComposerContext = this.mSpenComposerContext;
        if (spenComposerContext != null) {
            spenComposerContext.setMode(mode);
        }
        SpenNoteTextManager spenNoteTextManager = this.mNoteTextManager;
        if (spenNoteTextManager != null) {
            spenNoteTextManager.setEditable(mode == 1);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setPan(float panX, float panY) {
        SpenNoteZoomScroller spenNoteZoomScroller;
        if (this.mDocument == null || (spenNoteZoomScroller = this.mSpenNoteZoomScroller) == null) {
            return;
        }
        spenNoteZoomScroller.setPan(new PointF(panX, panY));
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean setSearchFocus(int focusId) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_setSearchFocus(j, focusId);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setStrokeRemoverTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.mStrokeRemoverTouchMargin.set(marginLeft, marginTop, marginRight, marginBottom);
        Rect rect = this.mStrokeRemoverTouchMargin;
        if (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) {
            return;
        }
        updateAllowStrokeRemoverTouchRect();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setTextOnlyEnabled(boolean enable) {
        if (this.mNativeHandle != 0) {
            SpenNotePageLayouter spenNotePageLayouter = this.mNotePageLayouter;
            if (spenNotePageLayouter != null) {
                spenNotePageLayouter.setNativeHandle(0L);
            }
            Companion companion = INSTANCE;
            companion.Native_setTextOnlyEnabled(this.mNativeHandle, enable);
            SpenNotePageLayouter spenNotePageLayouter2 = this.mNotePageLayouter;
            if (spenNotePageLayouter2 != null) {
                spenNotePageLayouter2.setNativeHandle(companion.Native_getNotePageLayouter(this.mNativeHandle));
            }
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.mTouchMargin.set(marginLeft, marginTop, marginRight, marginBottom);
        Rect rect = this.mTouchMargin;
        if (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) {
            return;
        }
        updateAllowTouchRect();
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setUnbufferedDispatchEnabled(boolean enable) {
        SpenLatencyConfiguration spenLatencyConfiguration;
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager == null || (spenLatencyConfiguration = spenNoteWritingViewManager.getSpenLatencyConfiguration()) == null) {
            return;
        }
        spenLatencyConfiguration.setUnbufferedDispatchEnabled(enable);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVSTEnabled(boolean enabled) {
        SpenLatencyConfiguration spenLatencyConfiguration;
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.setVSTEnabled(enabled);
        }
        SpenNoteWritingViewManager spenNoteWritingViewManager = this.mNoteWritingViewManager;
        if (spenNoteWritingViewManager == null || (spenLatencyConfiguration = spenNoteWritingViewManager.getSpenLatencyConfiguration()) == null) {
            return;
        }
        spenLatencyConfiguration.setVSTEnabled(enabled);
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVoiceSyncPlayAutoScroll(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setVoiceSyncPlayAutoScroll(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setVoiceSyncPlayEnabled(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setVoiceSyncPlayEnabled(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void setWritingGuideLineEnabled(boolean enable) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setWritingGuideLineEnabled(j, enable);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleTo(@Nullable PointF targetContentPoint, float targetZoomScale) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollAndScaleTo(j, targetContentPoint, targetZoomScale);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleToFitPage(int pageIndex) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollAndScaleToFitPage(j, pageIndex);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollAndScaleToFitRect(@Nullable RectF targetContentRect) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollAndScaleToFitRect(j, targetContentRect);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollFitPageToScreen(boolean isFitToWidth) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollFitPageToScreen(j, isFitToWidth);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void smoothScrollToFitPage() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_smoothScrollToFitPage(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollToPage(int pageIndex) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollToPage(j, pageIndex);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public boolean smoothScrollToPageAndFitPageToScreen(int pageIndex, boolean isFitToWidth) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_smoothScrollToPageAndFitPageToScreen(j, pageIndex, isFitToWidth);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startActionMode() {
        Log.i(TAG, "startActionMode");
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.startActionMode();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startContextMenuDelegate() {
        Log.i(TAG, "startContextMenuDelegate");
        SpenContextMenuDelegate spenContextMenuDelegate = this.mContextMenuDelegate;
        if (spenContextMenuDelegate != null) {
            spenContextMenuDelegate.startAction();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startLazyViewUpdate() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_startLazyViewUpdate(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void startStickyMemoIconAnimation(@NotNull SpenCustomObject customObject, boolean isShow) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_startStickyMemoIconAnimation(j, customObject, isShow);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopActionMode() {
        Log.i(TAG, "stopActionMode");
        SpenComposerContextMenu spenComposerContextMenu = this.mContextMenu;
        if (spenComposerContextMenu != null) {
            spenComposerContextMenu.hideContextMenu();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopContextMenuDelegate() {
        Log.i(TAG, "stopContextMenuDelegate");
        SpenContextMenuDelegate spenContextMenuDelegate = this.mContextMenuDelegate;
        if (spenContextMenuDelegate != null) {
            spenContextMenuDelegate.stopAction();
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void stopGestureAnimation() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_stopGestureAnimation(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.ISpenComposerImpl
    public void updateScreenOrientation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenDisplay spenDisplay = this.mSpenDisplay;
        if (spenDisplay != null) {
            spenDisplay.updateScreenOrientation(context);
        }
    }
}
