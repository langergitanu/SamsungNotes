package com.samsung.android.app.sdk.deepsky.textextraction.selectionui;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.barcode.result.Barcode;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.TranslateCapsuleListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ActionModeListener;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextExtractionActionModeHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.BarcodeHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableLine;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop.DragAndDropCallBack;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop.DragAndDropHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleController;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.KeyEventHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.MagnifierHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.VibrationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer.BackgroundRenderer;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer.EntityRenderer;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer.SelectionRenderer;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.textselection.TextSelectionHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.TextExtractionMode;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.LanguageChangeListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.LayoutState;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslationTokenInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010Q\u001a\u00020R2\u0006\u0010#\u001a\u00020$2\u0006\u0010S\u001a\u00020TH\u0017J \u0010U\u001a\u00020R2\u0006\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020YH\u0017J \u0010Z\u001a\u00020R2\u0006\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020[H\u0017J(\u0010Z\u001a\u00020R2\u0006\u0010V\u001a\u00020$2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u001bH\u0017J\b\u0010]\u001a\u00020RH\u0016J\b\u0010^\u001a\u00020RH\u0016J\b\u0010_\u001a\u00020RH\u0002J\u0010\u0010`\u001a\u00020R2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020R2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010d\u001a\u00020RH\u0016J\b\u0010e\u001a\u00020RH\u0017J\n\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010h\u001a\u000200H\u0016J\u0016\u0010i\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P\u0018\u00010jH\u0016J\n\u0010k\u001a\u0004\u0018\u00010KH\u0016J\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020P0mH\u0002J\u0010\u0010n\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020pH\u0002J\u0010\u0010q\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020pH\u0016J\b\u0010r\u001a\u00020RH\u0016J\u0010\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020AH\u0016J\u0010\u0010u\u001a\u00020R2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020R2\u0006\u0010v\u001a\u00020wH\u0017J\b\u0010y\u001a\u00020RH\u0002J\b\u0010z\u001a\u00020RH\u0002J\u0012\u0010{\u001a\u00020R2\b\b\u0002\u0010|\u001a\u00020\u001bH\u0002J\b\u0010}\u001a\u00020RH\u0017J\b\u0010~\u001a\u00020\u001bH\u0016J\b\u0010\u007f\u001a\u00020\u001bH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u001bH\u0016J\t\u0010\u0081\u0001\u001a\u00020RH\u0016J\u001b\u0010\u0082\u0001\u001a\u00020\u001b2\u0007\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010o\u001a\u00030\u0084\u0001H\u0016J\t\u0010\u0085\u0001\u001a\u00020RH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020R2\u0007\u0010\u0087\u0001\u001a\u00020PH\u0016J\u0018\u0010\u0088\u0001\u001a\u00020R2\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130mH\u0016J\u0012\u0010\u008a\u0001\u001a\u00020R2\u0007\u0010\u008b\u0001\u001a\u000206H\u0016J\u0019\u0010\u008c\u0001\u001a\u00020R2\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010mH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020R2\u0007\u0010\u008b\u0001\u001a\u000206H\u0016J\u001b\u0010\u008f\u0001\u001a\u00020R2\u0007\u0010\u008b\u0001\u001a\u0002062\u0007\u0010\u0090\u0001\u001a\u00020\u001bH\u0016J\u001b\u0010\u0091\u0001\u001a\u00020R2\u0007\u0010\u0092\u0001\u001a\u00020\u000e2\u0007\u0010\u0093\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020R2\u0007\u0010\u0087\u0001\u001a\u00020 H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020R2\u0007\u0010\u0096\u0001\u001a\u00020\u001bH\u0017J\u0012\u0010\u0097\u0001\u001a\u00020R2\u0007\u0010X\u001a\u00030\u0098\u0001H\u0017J\u0012\u0010\u0099\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u009b\u0001\u001a\u00020R2\u0007\u0010\u009c\u0001\u001a\u000200H\u0002J\u0012\u0010\u009d\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u009e\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u009f\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010 \u0001\u001a\u00020R2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010¡\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010¢\u0001\u001a\u00020R2\u0006\u00103\u001a\u000204H\u0016J!\u0010£\u0001\u001a\u00020R2\u0006\u00103\u001a\u0002042\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010mH\u0016J\u0011\u0010¤\u0001\u001a\u00020R2\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0012\u0010¥\u0001\u001a\u00020R2\u0007\u0010X\u001a\u00030¦\u0001H\u0016J\u0012\u0010§\u0001\u001a\u00020R2\u0007\u0010X\u001a\u00030¨\u0001H\u0016J\u0011\u0010©\u0001\u001a\u00020R2\u0006\u0010L\u001a\u00020\u000eH\u0016J\u0013\u0010ª\u0001\u001a\u00020R2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020R2\u0007\u0010®\u0001\u001a\u000208H\u0016J\u0012\u0010¯\u0001\u001a\u00020R2\u0007\u0010°\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010±\u0001\u001a\u00020R2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010³\u0001\u001a\u00020R2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0016J\u0011\u0010´\u0001\u001a\u00020R2\u0006\u0010X\u001a\u00020<H\u0016J\u0012\u0010µ\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010¶\u0001\u001a\u00020R2\u0007\u0010\u009a\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010·\u0001\u001a\u00020R2\u0006\u0010X\u001a\u00020IH\u0017J\u0012\u0010¸\u0001\u001a\u00020R2\u0007\u0010¹\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010º\u0001\u001a\u00020\u001b2\u0007\u0010»\u0001\u001a\u00020\u000eH\u0016J\t\u0010¼\u0001\u001a\u00020RH\u0016J\u001b\u0010½\u0001\u001a\u00020\u001b2\u0007\u0010¾\u0001\u001a\u00020\u001e2\u0007\u0010¿\u0001\u001a\u00020\u001eH\u0016J\t\u0010À\u0001\u001a\u00020RH\u0016J\u001d\u0010À\u0001\u001a\u00020R2\b\u0010Á\u0001\u001a\u00030Â\u00012\b\u0010®\u0001\u001a\u00030Ã\u0001H\u0017J\t\u0010Ä\u0001\u001a\u00020\u001bH\u0016J#\u0010Å\u0001\u001a\u00020\u001b2\u0007\u0010¾\u0001\u001a\u00020\u001e2\u0007\u0010¿\u0001\u001a\u00020\u001e2\u0006\u0010|\u001a\u00020\u001bH\u0016JB\u0010Æ\u0001\u001a\u00020R2\u0007\u0010Ç\u0001\u001a\u00020\u000e2\u0007\u0010È\u0001\u001a\u00020\u000e2\t\u0010É\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0003\u0010Ì\u0001J\u001d\u0010Í\u0001\u001a\u00020R2\t\u0010Î\u0001\u001a\u0004\u0018\u0001042\u0007\u0010Ï\u0001\u001a\u00020\u001eH\u0002J\u001d\u0010Ð\u0001\u001a\u00020R2\t\u0010Î\u0001\u001a\u0004\u0018\u0001042\u0007\u0010Ï\u0001\u001a\u00020\u001eH\u0002J\t\u0010Ñ\u0001\u001a\u00020RH\u0002J\t\u0010Ò\u0001\u001a\u00020RH\u0002J\u0012\u0010Ó\u0001\u001a\u00020R2\u0007\u0010\u0087\u0001\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Õ\u0001"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelperImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionModeHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextExtractionActionModeHelper;", "backgroundRenderer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/BackgroundRenderer;", "barcodeHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeHelper;", "barcodeImageHeight", "", "barcodeImageWidth", "capsuleHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelperImpl;", "centerOffset", "Landroid/graphics/Point;", "dragAndDropHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/dragndrop/DragAndDropHelper;", "entityRenderer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/EntityRenderer;", "handleController", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/HandleController;", "hitFromLongClick", "", ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT, "imageRatio", "", "imageRect", "Landroid/graphics/RectF;", "imageTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH, "isImageScale", "isImageTranslationOn", "isShowPopupEnabled", "isTalkBackEnabled", "()Z", "keyEventHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/KeyEventHelper;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "languageTags", "", "magnifierHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/MagnifierHelper;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "originalBitmap", "Landroid/graphics/Bitmap;", "progressBarCallback", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ProgressBarCallback;", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "scaleState", "selectionHandleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$SelectionHandleListener;", "selectionRenderer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/SelectionRenderer;", "selectionStarted", "teView", "Landroid/view/View;", "textClassificationHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper;", "textExtractionMode", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/util/TextExtractionMode;", "textSelectionHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper;", "translateButtonListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$TranslateCapsuleClickListener;", "translateLangHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelper;", "translationState", "vibrationHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/VibrationHelper;", "viewRect", "Landroid/graphics/Rect;", "addActionCapsule", "", "data", "Lcom/google/gson/JsonObject;", "addCapsule", "icon", "text", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnCapsuleClickListener;", "addToggleCapsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToggleCapsuleListener;", "defaultValue", "clearAllSelection", "dismissPopupMenu", "doImageTranslate", "drawSelection", "canvas", "Landroid/graphics/Canvas;", "drawTranslation", "finishTextSelection", "finishTranslate", "getCapsuleHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "getSelectedText", "getSelectionHandlePositions", "Lkotlin/Pair;", "getTranslateLanguageHelper", "getVisibleCharactersRectList", "", "handleMagnifierVisibility", "event", "Landroid/view/MotionEvent;", "handleTouchEvent", "hapticFeedback", "init", "view", "initCapsuleHelper", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "initCapsuleLayout", "initImageInfo", "initInternal", "initTextSelection", "isLongPress", "invalidateCapsuleLayout", "isBarcodeSelected", "isSelectionHandlePressed", "isTextSelected", "onConfigurationChanged", "onKey", "keyCode", "Landroid/view/KeyEvent;", "selectAll", "selectCharactersByRect", "rect", "selectWordsByPoints", "points", "setBarcodeBitmap", "bitmap", "setBarcodeList", "barcodeList", "Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;", "setBitmap", "isScale", "setBitmapInfo", "width", "height", "setBitmapRect", "setCapsuleLayoutVisibility", "isVisible", "setCapsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$CapsuleListener;", "setCheckImageMinimumSizeOnTranslation", "enabled", "setContentDescription", "contentDescription", "setDimEnabled", "setDragAndDropEnabled", "setEnableCopyPastePopup", "setImageUri", "setMagnifierEnabled", "setOcrResult", "setOcrResultAndBarcodeList", "setOnScaleState", "setOnSelectedTextChangeListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;", "setOnToolbarMenuClickListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToolbarMenuClickListener;", "setOnTranslationState", "setPendingShareIntent", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "setProgressBarCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "setScaleFactor", WiggleAnimationConfig.KEY_SCALE, "setSelectionAreaColor", "color", "setSelectionHandleColor", "setSelectionHandleListener", "setSelectionHandleMovingEnabled", "setSelectionHandleShadowEnabled", "setTranslateClickListener", "setUnderlineVisible", "visible", "showBarcodeDialog", "index", "showPopupMenu", "startBarcodeSelection", "x", "y", "startImageTranslation", "tokenInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ImageTranslationResultCallback;", "startTextSelectionByButton", "startTextSelectionWithCoordinate", "updateCapsuleColor", "backgroundColor", "textColor", "pressedBackgroundColor", "pressedTextColor", "rippleColor", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateTextExtraction", "result", "ratio", "updateTextExtractionData", "updateTextExtractionDrawInfo", "updateTextExtractionWithNewRect", "updateTextSelection", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextExtractionDrawHelperImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextExtractionDrawHelperImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelperImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,958:1\n1747#2,3:959\n11335#3:962\n11670#3,3:963\n37#4,2:966\n*S KotlinDebug\n*F\n+ 1 TextExtractionDrawHelperImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelperImpl\n*L\n651#1:959,3\n680#1:962\n680#1:963,3\n685#1:966,2\n*E\n"})
public final class TextExtractionDrawHelperImpl implements TextExtractionDrawHelper {
    public static final int SCALE_STATE_NONE = 0;
    public static final int SCALE_STATE_PROGRESS = 1;

    @NotNull
    private static final String TAG = "TextExtractionDrawHelperImpl";
    public static final int TRANSLATION_STATE_NONE = 0;
    public static final int TRANSLATION_STATE_PROGRESS = 1;

    @NotNull
    private final AccessibilityManager accessibilityManager;
    private TextExtractionActionModeHelper actionModeHelper;

    @NotNull
    private final BackgroundRenderer backgroundRenderer;
    private BarcodeHelper barcodeHelper;
    private int barcodeImageHeight;
    private int barcodeImageWidth;

    @Nullable
    private CapsuleHelperImpl capsuleHelper;

    @NotNull
    private final Point centerOffset;

    @NotNull
    private final Context context;
    private DragAndDropHelper dragAndDropHelper;

    @NotNull
    private final EntityRenderer entityRenderer;

    @NotNull
    private final HandleController handleController;
    private boolean hitFromLongClick;
    private int imageHeight;
    private float imageRatio;

    @NotNull
    private RectF imageRect;

    @Nullable
    private ImageTranslator imageTranslator;

    @Nullable
    private Uri imageUri;
    private int imageWidth;
    private boolean isImageScale;
    private boolean isImageTranslationOn;
    private boolean isShowPopupEnabled;
    private KeyEventHelper keyEventHelper;

    @NotNull
    private final LangPackManager langPackManager;

    @NotNull
    private String languageTags;
    private MagnifierHelper magnifierHelper;

    @Nullable
    private OcrResult ocrResult;

    @Nullable
    private Bitmap originalBitmap;

    @Nullable
    private TextExtractionDrawHelper.ProgressBarCallback progressBarCallback;
    private float scaleFactor;
    private int scaleState;

    @Nullable
    private TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener;

    @NotNull
    private final SelectionRenderer selectionRenderer;
    private boolean selectionStarted;
    private View teView;

    @NotNull
    private final TextClassificationHelper textClassificationHelper;

    @NotNull
    private TextExtractionMode textExtractionMode;

    @NotNull
    private final TextSelectionHelper textSelectionHelper;

    @Nullable
    private TextExtractionDrawHelper.TranslateCapsuleClickListener translateButtonListener;

    @Nullable
    private TranslateLanguageHelper translateLangHelper;
    private int translationState;

    @NotNull
    private final VibrationHelper vibrationHelper;

    @NotNull
    private final Rect viewRect;

    public TextExtractionDrawHelperImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.languageTags = "";
        this.isImageScale = true;
        this.isShowPopupEnabled = true;
        this.textClassificationHelper = new TextClassificationHelper(context);
        this.selectionRenderer = new SelectionRenderer(context);
        this.entityRenderer = new EntityRenderer(context);
        this.backgroundRenderer = new BackgroundRenderer(context);
        this.vibrationHelper = new VibrationHelper(context);
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager) systemService;
        TextSelectionHelper textSelectionHelper = new TextSelectionHelper(context);
        this.textSelectionHelper = textSelectionHelper;
        this.handleController = new HandleController(context, textSelectionHelper);
        this.langPackManager = new LangPackManager(context);
        this.textExtractionMode = TextExtractionMode.T_BUTTON_PRESS;
        this.viewRect = new Rect();
        this.imageRatio = 1.0f;
        this.imageRect = new RectF();
        this.centerOffset = new Point(0, 0);
        this.scaleFactor = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doImageTranslate() {
        final ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator != null) {
            imageTranslator.doImageTranslate(new ImageTranslateListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$doImageTranslate$1$1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener
                public void onImageTranslateFail(@NotNull ImageTranslationResult.Error error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LibLogger.m5432i("TextExtractionDrawHelperImpl", "doImageTranslate failed: " + error);
                    this.this$0.isImageTranslationOn = false;
                    TextExtractionDrawHelper.ProgressBarCallback progressBarCallback = this.this$0.progressBarCallback;
                    if (progressBarCallback != null) {
                        progressBarCallback.finishProgressBar();
                    }
                    CapsuleHelperImpl capsuleHelperImpl = this.this$0.capsuleHelper;
                    if (capsuleHelperImpl != null) {
                        capsuleHelperImpl.turnOffTranslate();
                    }
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener
                public void onImageTranslateSuccess() {
                    LibLogger.m5432i("TextExtractionDrawHelperImpl", "doImageTranslate success");
                    this.this$0.isImageTranslationOn = true;
                    TextExtractionDrawHelper.ProgressBarCallback progressBarCallback = this.this$0.progressBarCallback;
                    if (progressBarCallback != null) {
                        progressBarCallback.finishProgressBar();
                    }
                    TranslateLanguageHelper translateLanguageHelper = this.this$0.translateLangHelper;
                    if (translateLanguageHelper != null) {
                        translateLanguageHelper.invalidateLayout(LayoutState.LANGUAGE_CODE_BUTTON);
                    }
                    this.this$0.setContentDescription(imageTranslator.getLastTranslatedText());
                    View view = this.this$0.teView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("teView");
                        view = null;
                    }
                    view.invalidate();
                }
            });
        }
    }

    private final List<Rect> getVisibleCharactersRectList() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[2];
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        for (SelectableCharacter selectableCharacter : this.textSelectionHelper.getSelectedCharacters()) {
            Point[] poly = selectableCharacter.getPoly();
            int length = poly.length;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    float f = poly[i4].x;
                    float f4 = this.scaleFactor;
                    float f5 = i;
                    int i5 = (int) ((f * f4) + f5);
                    float f6 = r9.y * f4;
                    float f7 = i2;
                    if (this.viewRect.contains(i5, (int) (f6 + f7))) {
                        Point[] poly2 = selectableCharacter.getPoly();
                        ArrayList arrayList2 = new ArrayList(poly2.length);
                        for (Point point : poly2) {
                            float f8 = point.x;
                            float f9 = this.scaleFactor;
                            arrayList2.add(new Point((int) ((f8 * f9) + f5), (int) ((r9.y * f9) + f7)));
                        }
                        arrayList.add(PointUtil.INSTANCE.polyToRect((Point[]) arrayList2.toArray(new Point[0])));
                    } else {
                        i4++;
                    }
                }
            }
        }
        return arrayList;
    }

    private final boolean handleMagnifierVisibility(MotionEvent event) {
        MagnifierHelper magnifierHelper = this.magnifierHelper;
        MagnifierHelper magnifierHelper2 = null;
        if (magnifierHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            magnifierHelper = null;
        }
        if (!magnifierHelper.getIsEnabled() || !this.textSelectionHelper.isTextSelected()) {
            return false;
        }
        SelectableLine lastSelectedLine = this.textSelectionHelper.getLastSelectedLine();
        MagnifierHelper magnifierHelper3 = this.magnifierHelper;
        if (magnifierHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
        } else {
            magnifierHelper2 = magnifierHelper3;
        }
        return magnifierHelper2.handleTouchEvent(event, lastSelectedLine.getPoly(), this.scaleFactor);
    }

    private final void initCapsuleHelper(ViewGroup layout) {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.setTranslateCapsuleListener(new TranslateCapsuleListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$initCapsuleHelper$1$1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.TranslateCapsuleListener
                public void onTranslateOff() {
                    TextExtractionDrawHelper.TranslateCapsuleClickListener translateCapsuleClickListener = this.this$0.translateButtonListener;
                    if (translateCapsuleClickListener != null) {
                        translateCapsuleClickListener.onClick(false);
                    }
                    TextExtractionDrawHelper.ProgressBarCallback progressBarCallback = this.this$0.progressBarCallback;
                    if (progressBarCallback != null) {
                        progressBarCallback.finishProgressBar();
                    }
                    this.this$0.isImageTranslationOn = false;
                    TranslateLanguageHelper translateLanguageHelper = this.this$0.translateLangHelper;
                    if (translateLanguageHelper != null) {
                        translateLanguageHelper.invalidateLayout(LayoutState.HIDDEN);
                    }
                    View view = this.this$0.teView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("teView");
                        view = null;
                    }
                    view.invalidate();
                    TextExtractionDrawHelperImpl textExtractionDrawHelperImpl = this.this$0;
                    textExtractionDrawHelperImpl.setContentDescription(textExtractionDrawHelperImpl.textSelectionHelper.getContentDescription());
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.TranslateCapsuleListener
                public void onTranslateOn() {
                    this.this$0.clearAllSelection();
                    TextExtractionDrawHelper.ProgressBarCallback progressBarCallback = this.this$0.progressBarCallback;
                    if (progressBarCallback != null) {
                        progressBarCallback.startProgressBar();
                    }
                    TextExtractionDrawHelper.TranslateCapsuleClickListener translateCapsuleClickListener = this.this$0.translateButtonListener;
                    if (translateCapsuleClickListener != null) {
                        translateCapsuleClickListener.onClick(true);
                    }
                }
            });
            capsuleHelperImpl.initTranslateCapsule();
            capsuleHelperImpl.initLayout(layout);
        }
    }

    private final void initImageInfo() {
        View view = this.teView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        int width = view.getWidth();
        View view3 = this.teView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view3 = null;
        }
        int height = view3.getHeight();
        View view4 = this.teView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view4 = null;
        }
        view4.getGlobalVisibleRect(this.viewRect);
        this.imageRatio = this.isImageScale ? RangesKt.coerceAtMost(width / this.imageWidth, height / this.imageHeight) : 1.0f;
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        barcodeHelper.setImageRatio(RangesKt.coerceAtMost(width / this.barcodeImageWidth, height / this.barcodeImageHeight));
        Point point = this.centerOffset;
        RectF rectF = this.imageRect;
        point.x = (int) rectF.left;
        point.y = (int) rectF.top;
        HandleController handleController = this.handleController;
        View view5 = this.teView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
        } else {
            view2 = view5;
        }
        handleController.setImageInfo(view2);
    }

    private final void initInternal() {
        View view = this.teView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.setWillNotDraw(false);
        View view3 = this.teView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view3 = null;
        }
        view3.setLayerType(2, null);
        DragAndDropHelper dragAndDropHelper = this.dragAndDropHelper;
        if (dragAndDropHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragAndDropHelper");
            dragAndDropHelper = null;
        }
        View view4 = this.teView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
        } else {
            view2 = view4;
        }
        ViewParent parent = view2.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        dragAndDropHelper.setTEViewChildCount(((ViewGroup) parent).getChildCount());
    }

    private final void initTextSelection(boolean isLongPress) {
        Bitmap bitmap;
        initImageInfo();
        if (isLongPress) {
            this.textExtractionMode = TextExtractionMode.TEXT_LONG_PRESS;
        } else {
            this.textExtractionMode = TextExtractionMode.T_BUTTON_PRESS;
            clearAllSelection();
        }
        if (this.selectionStarted) {
            return;
        }
        this.selectionStarted = true;
        updateTextExtraction(this.ocrResult, this.imageRatio);
        OcrResult ocrResult = this.ocrResult;
        if (ocrResult != null) {
            if (Rune.INSTANCE.isSupportCapsule() && (bitmap = this.originalBitmap) != null) {
                ImageTranslator imageTranslator = this.imageTranslator;
                if (imageTranslator != null) {
                    imageTranslator.init(bitmap, ocrResult);
                }
                CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
                if (capsuleHelperImpl != null) {
                    capsuleHelperImpl.onStartTextSelectionWithDrawCapsuleLayout(ocrResult, this.isImageTranslationOn);
                }
            }
            this.handleController.updatePosition();
        }
    }

    public static /* synthetic */ void initTextSelection$default(TextExtractionDrawHelperImpl textExtractionDrawHelperImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        textExtractionDrawHelperImpl.initTextSelection(z);
    }

    private final boolean isTalkBackEnabled() {
        return this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentDescription(String contentDescription) {
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.setContentDescription(contentDescription);
    }

    private final void updateTextExtraction(OcrResult result, float ratio) {
        updateTextExtractionData(result, ratio);
        updateTextExtractionDrawInfo();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.invalidate();
    }

    private final void updateTextExtractionData(OcrResult result, float ratio) {
        if (result != null) {
            this.entityRenderer.updateEntityDrawInfo(result, ratio, this.centerOffset);
            this.textSelectionHelper.updateSelectableData(result, ratio, this.centerOffset);
        }
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        barcodeHelper.updateSelectableBarcodes(this.centerOffset);
    }

    private final void updateTextExtractionDrawInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.textSelectionHelper.makeHighlightPolyPerBlock());
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        arrayList.addAll(barcodeHelper.makeHighlightPolyPerBarcode());
        setContentDescription(this.textSelectionHelper.getContentDescription());
        this.backgroundRenderer.updateHighlightPath(arrayList);
    }

    private final void updateTextExtractionWithNewRect() {
        if (this.ocrResult == null) {
            LibLogger.m5430e(TAG, "updateTextExtractionWithNewRect skipped by null ocrResult");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SelectableCharacter> it = this.textSelectionHelper.getSelectableOcrResult().getSelectableCharacters().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (it.next().getIsSelected()) {
                arrayList.add(Integer.valueOf(i));
            }
            i = i2;
        }
        updateTextExtraction(this.ocrResult, this.imageRatio);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.textSelectionHelper.getSelectableOcrResult().getSelectableCharacters().get(((Number) it2.next()).intValue()).setSelected(true);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void addActionCapsule(@NotNull Uri imageUri, @NotNull JsonObject data) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(data, "data");
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.addActionCapsule(imageUri, data);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void addCapsule(@NotNull Uri icon, @NotNull String text, @NotNull final TextExtractionDrawHelper.OnCapsuleClickListener listener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.addCapsule(icon, text, new SimpleCapsuleClickListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.addCapsule.1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener
                public void onClick() {
                    listener.onClick();
                }
            });
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull final TextExtractionDrawHelper.OnToggleCapsuleListener listener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.addToggleCapsule(icon, text, new ToggleCapsuleListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.addToggleCapsule.1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
                public void onToggleOff() {
                    listener.onToggleOff();
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
                public void onToggleOn() {
                    listener.onToggleOn();
                }
            }, false);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void clearAllSelection() {
        LibLogger.m5432i(TAG, "clearAllSelection called");
        this.textSelectionHelper.clearAllSelection();
        this.textSelectionHelper.updateSelectedTextData();
        this.handleController.setEmpty();
        dismissPopupMenu();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.invalidate();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void dismissPopupMenu() {
        if (this.isShowPopupEnabled) {
            TextExtractionActionModeHelper textExtractionActionModeHelper = this.actionModeHelper;
            if (textExtractionActionModeHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionModeHelper");
                textExtractionActionModeHelper = null;
            }
            textExtractionActionModeHelper.stopActionMode();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void drawSelection(@NotNull Canvas canvas) {
        ImageTranslator imageTranslator;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isImageTranslationOn && (imageTranslator = this.imageTranslator) != null && !imageTranslator.getIsLongPress()) {
            this.backgroundRenderer.drawTranslationBackground(canvas);
            drawTranslation(canvas);
            return;
        }
        this.backgroundRenderer.drawSelectionBackground(canvas);
        this.entityRenderer.drawEntities(canvas, this.textExtractionMode);
        SelectionRenderer selectionRenderer = this.selectionRenderer;
        List<SelectableCharacter> selectedCharacters = this.textSelectionHelper.getSelectedCharacters();
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        selectionRenderer.drawSelection(canvas, selectedCharacters, barcodeHelper.getSelectedBarcodes());
        this.handleController.drawHandles(canvas);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void drawTranslation(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator != null) {
            imageTranslator.drawBackgroundBitmap(canvas, this.imageRect);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void finishTextSelection() {
        LibLogger.m5432i(TAG, "finishTextSelection called");
        clearAllSelection();
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.clearCapsuleLayout();
        }
        CapsuleHelperImpl capsuleHelperImpl2 = this.capsuleHelper;
        if (capsuleHelperImpl2 != null) {
            capsuleHelperImpl2.turnOffTranslate();
        }
        this.selectionStarted = false;
        MagnifierHelper magnifierHelper = this.magnifierHelper;
        MagnifierHelper magnifierHelper2 = null;
        if (magnifierHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            magnifierHelper = null;
        }
        if (magnifierHelper.getIsEnabled()) {
            MagnifierHelper magnifierHelper3 = this.magnifierHelper;
            if (magnifierHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            } else {
                magnifierHelper2 = magnifierHelper3;
            }
            magnifierHelper2.dismiss();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper.turnOffTranslate")
    public void finishTranslate() {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.turnOffTranslate();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Nullable
    public CapsuleHelper getCapsuleHelper() {
        return this.capsuleHelper;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @NotNull
    public String getSelectedText() {
        return this.textSelectionHelper.getSelectedText();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Nullable
    public Pair<Rect, Rect> getSelectionHandlePositions() {
        if (isTextSelected()) {
            return new Pair<>(this.handleController.getStartHandlePosition(), this.handleController.getEndHandlePosition());
        }
        return null;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Nullable
    /* JADX INFO: renamed from: getTranslateLanguageHelper, reason: from getter */
    public TranslateLanguageHelper getTranslateLangHelper() {
        return this.translateLangHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c3  */
    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleTouchEvent(@NotNull MotionEvent event) {
        boolean z;
        boolean z2;
        DragAndDropHelper dragAndDropHelper;
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        View view = null;
        boolean z3 = true;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.hitFromLongClick = false;
                this.textSelectionHelper.setTextSelectedForFirstTime(true);
                MagnifierHelper magnifierHelper = this.magnifierHelper;
                if (magnifierHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                    magnifierHelper = null;
                }
                if (magnifierHelper.getIsEnabled()) {
                    MagnifierHelper magnifierHelper2 = this.magnifierHelper;
                    if (magnifierHelper2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                        magnifierHelper2 = null;
                    }
                    magnifierHelper2.dismiss();
                    z = true;
                } else {
                    z = false;
                }
                if (isTextSelected()) {
                    this.textSelectionHelper.setTextSelectedForFirstTime(false);
                    showPopupMenu();
                    z = true;
                }
            }
            if (this.hitFromLongClick && !this.textSelectionHelper.getIsTextSelectedForFirstTime()) {
                dragAndDropHelper = this.dragAndDropHelper;
                if (dragAndDropHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dragAndDropHelper");
                    dragAndDropHelper = null;
                }
                if (dragAndDropHelper.handleTouchEvent(event, getSelectedText(), this.scaleFactor, new DragAndDropCallBack() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$handleTouchEvent$touchConsumedByDragAndDrop$1
                    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop.DragAndDropCallBack
                    public void onDragStarted() {
                        this.this$0.clearAllSelection();
                    }
                })) {
                    LibLogger.m5432i(TAG, "touch consumed for drag and drop");
                    return true;
                }
            }
            if (this.isImageTranslationOn) {
                ImageTranslator imageTranslator = this.imageTranslator;
                if (imageTranslator != null ? imageTranslator.onTouchEvent(event) : false) {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            boolean zHandleMagnifierVisibility = handleMagnifierVisibility(event);
            boolean zHandleTouchEvent = this.handleController.handleTouchEvent(event, this.hitFromLongClick, new HandleTouchEventListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$handleTouchEvent$touchConsumedByHandle$1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
                public void onHandleMove() {
                    this.this$0.textSelectionHelper.updateSelectedTextData();
                    MagnifierHelper magnifierHelper3 = this.this$0.magnifierHelper;
                    if (magnifierHelper3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                        magnifierHelper3 = null;
                    }
                    magnifierHelper3.setShowing(true);
                    TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                    if (selectionHandleListener != null) {
                        selectionHandleListener.onHandleMove();
                    }
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
                public void onHandleStop() {
                    this.this$0.showPopupMenu();
                    TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                    if (selectionHandleListener != null) {
                        selectionHandleListener.onHandleStop();
                    }
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
                public void onHandleTouchDown(boolean isStartHandleTouched) {
                    this.this$0.textSelectionHelper.updateLastSelectedChar(isStartHandleTouched);
                    this.this$0.dismissPopupMenu();
                    TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                    if (selectionHandleListener != null) {
                        selectionHandleListener.onHandleTouchDown();
                    }
                }
            });
            if (!z && !z2 && !zHandleMagnifierVisibility && !zHandleTouchEvent) {
                z3 = false;
            }
            if (z3) {
                View view2 = this.teView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("teView");
                } else {
                    view = view2;
                }
                view.invalidate();
            }
            return z3;
        }
        dismissPopupMenu();
        MagnifierHelper magnifierHelper3 = this.magnifierHelper;
        if (magnifierHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            magnifierHelper3 = null;
        }
        if (magnifierHelper3.getIsEnabled()) {
            MagnifierHelper magnifierHelper4 = this.magnifierHelper;
            if (magnifierHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                magnifierHelper4 = null;
            }
            magnifierHelper4.dismiss();
        }
        z = false;
        if (this.hitFromLongClick) {
            dragAndDropHelper = this.dragAndDropHelper;
            if (dragAndDropHelper == null) {
            }
            if (dragAndDropHelper.handleTouchEvent(event, getSelectedText(), this.scaleFactor, new DragAndDropCallBack() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$handleTouchEvent$touchConsumedByDragAndDrop$1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.dragndrop.DragAndDropCallBack
                public void onDragStarted() {
                    this.this$0.clearAllSelection();
                }
            })) {
            }
        }
        if (this.isImageTranslationOn) {
        }
        boolean zHandleMagnifierVisibility2 = handleMagnifierVisibility(event);
        boolean zHandleTouchEvent2 = this.handleController.handleTouchEvent(event, this.hitFromLongClick, new HandleTouchEventListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl$handleTouchEvent$touchConsumedByHandle$1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
            public void onHandleMove() {
                this.this$0.textSelectionHelper.updateSelectedTextData();
                MagnifierHelper magnifierHelper32 = this.this$0.magnifierHelper;
                if (magnifierHelper32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                    magnifierHelper32 = null;
                }
                magnifierHelper32.setShowing(true);
                TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                if (selectionHandleListener != null) {
                    selectionHandleListener.onHandleMove();
                }
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
            public void onHandleStop() {
                this.this$0.showPopupMenu();
                TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                if (selectionHandleListener != null) {
                    selectionHandleListener.onHandleStop();
                }
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.HandleTouchEventListener
            public void onHandleTouchDown(boolean isStartHandleTouched) {
                this.this$0.textSelectionHelper.updateLastSelectedChar(isStartHandleTouched);
                this.this$0.dismissPopupMenu();
                TextExtractionDrawHelper.SelectionHandleListener selectionHandleListener = this.this$0.selectionHandleListener;
                if (selectionHandleListener != null) {
                    selectionHandleListener.onHandleTouchDown();
                }
            }
        });
        if (!z) {
            z3 = false;
        }
        if (z3) {
        }
        return z3;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void hapticFeedback() {
        if (this.vibrationHelper.isVibrationOff()) {
            LibLogger.m5433w(TAG, "Vibration is off");
        } else {
            this.vibrationHelper.doVibrate(this.hitFromLongClick);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void init(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LibLogger.m5432i(TAG, "initialize TextExtractionDrawHelper");
        view.setFocusableInTouchMode(true);
        view.setFocusable(true);
        view.setImportantForAccessibility(1);
        this.teView = view;
        Context context = this.context;
        View view2 = this.teView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view2 = null;
        }
        this.actionModeHelper = new TextExtractionActionModeHelper(context, view2, this.textClassificationHelper, new ActionModeListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.init.2
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ActionModeListener
            public void onCopyClicked() {
                TextExtractionDrawHelperImpl.this.clearAllSelection();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ActionModeListener
            public void onSelectAllClicked() {
                TextExtractionDrawHelperImpl.this.selectAll();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ActionModeListener
            public void onShareClicked() {
                TextExtractionDrawHelperImpl.this.clearAllSelection();
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.ActionModeListener
            public void onTranslateClicked() {
                TextExtractionDrawHelperImpl.this.clearAllSelection();
            }
        });
        View view4 = this.teView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view4 = null;
        }
        this.magnifierHelper = new MagnifierHelper(view4, this.context);
        Context context2 = this.context;
        View view5 = this.teView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view5 = null;
        }
        this.barcodeHelper = new BarcodeHelper(context2, view5);
        this.keyEventHelper = new KeyEventHelper(this.context);
        Context context3 = this.context;
        View view6 = this.teView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
        } else {
            view3 = view6;
        }
        this.dragAndDropHelper = new DragAndDropHelper(context3, view3);
        initInternal();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void initCapsuleLayout(@NotNull ViewGroup layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (Rune.INSTANCE.isSupportCapsule()) {
            this.imageTranslator = new ImageTranslator(this.context, this.langPackManager);
            Context context = this.context;
            ImageTranslator imageTranslator = this.imageTranslator;
            Intrinsics.checkNotNull(imageTranslator);
            this.capsuleHelper = new CapsuleHelperImpl(context, imageTranslator);
            this.translateLangHelper = new TranslateLanguageHelperImpl(this.context, this.imageTranslator, this.langPackManager, new LanguageChangeListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.initCapsuleLayout.1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.LanguageChangeListener
                public void onLanguageChanged(boolean doTranslate) {
                    if (doTranslate) {
                        TextExtractionDrawHelper.ProgressBarCallback progressBarCallback = TextExtractionDrawHelperImpl.this.progressBarCallback;
                        if (progressBarCallback != null) {
                            progressBarCallback.startProgressBar();
                        }
                        TextExtractionDrawHelperImpl.this.doImageTranslate();
                    }
                }
            });
            initCapsuleHelper(layout);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void invalidateCapsuleLayout() {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.invalidateCapsuleLayout();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean isBarcodeSelected() {
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        return barcodeHelper.isBarcodeSelected();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean isSelectionHandlePressed() {
        return this.handleController.isHandleMoving();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean isTextSelected() {
        return this.textSelectionHelper.isTextSelected();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void onConfigurationChanged() {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.onConfigurationChanged(this.selectionStarted);
        }
        TranslateLanguageHelper translateLanguageHelper = this.translateLangHelper;
        if (translateLanguageHelper != null) {
            translateLanguageHelper.onConfigurationChanged();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean onKey(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        KeyEventHelper keyEventHelper = this.keyEventHelper;
        if (keyEventHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyEventHelper");
            keyEventHelper = null;
        }
        return keyEventHelper.onKey(keyCode, event, this);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void selectAll() {
        clearAllSelection();
        this.textSelectionHelper.selectAll();
        this.handleController.updatePosition();
        this.textSelectionHelper.updateSelectedTextData();
        showPopupMenu();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.postInvalidate();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void selectCharactersByRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        clearAllSelection();
        this.textSelectionHelper.selectCharactersByRect(rect);
        this.handleController.updatePosition();
        this.textSelectionHelper.updateSelectedTextData();
        showPopupMenu();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.postInvalidate();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void selectWordsByPoints(@NotNull List<? extends Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        clearAllSelection();
        this.textSelectionHelper.selectWordsByPoints(points);
        this.handleController.updatePosition();
        this.textSelectionHelper.updateSelectedTextData();
        showPopupMenu();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.postInvalidate();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBarcodeBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "setBarcodeBitmap with " + LogUtil.INSTANCE.logString(bitmap));
        this.barcodeImageWidth = bitmap.getWidth();
        this.barcodeImageHeight = bitmap.getHeight();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBarcodeList(@NotNull List<Barcode> barcodeList) {
        Intrinsics.checkNotNullParameter(barcodeList, "barcodeList");
        LibLogger.m5432i(TAG, "setBarcodeList with " + barcodeList.size() + " items");
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        barcodeHelper.setBarcodeList(barcodeList);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "setBitmap with " + LogUtil.INSTANCE.logString(bitmap));
        setBarcodeBitmap(bitmap);
        this.imageWidth = bitmap.getWidth();
        this.imageHeight = bitmap.getHeight();
        this.originalBitmap = bitmap;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBitmapInfo(int width, int height) {
        LibLogger.m5432i(TAG, "setBitmapInfo with width=" + width + ", height=" + height);
        this.imageWidth = width;
        this.imageHeight = height;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBitmapRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        LibLogger.m5432i(TAG, "setBitmapRect with " + rect);
        this.imageRect = rect;
        this.backgroundRenderer.setViewRect(rect);
        MagnifierHelper magnifierHelper = this.magnifierHelper;
        if (magnifierHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            magnifierHelper = null;
        }
        magnifierHelper.setViewRect(rect);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void setCapsuleLayoutVisibility(boolean isVisible) {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.setCapsuleLayoutVisibility(isVisible);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper.setCapsuleListener")
    public void setCapsuleListener(@NotNull final TextExtractionDrawHelper.CapsuleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.setCapsuleListener(new CapsuleHelper.CapsuleListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.setCapsuleListener.1
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper.CapsuleListener
                public void onAdd(@NotNull CapsuleActionType capsuleActionType) {
                    Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
                    listener.onAdd(capsuleActionType);
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper.CapsuleListener
                public void onClick(@NotNull CapsuleActionType capsuleActionType) {
                    Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
                    listener.onClick(capsuleActionType);
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper.CapsuleListener
                public void onMoreButtonAppear() {
                    listener.onMoreButtonAppear();
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper.CapsuleListener
                public void onMoreButtonClick() {
                    listener.onMoreButtonClick();
                }
            });
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setCheckImageMinimumSizeOnTranslation(boolean enabled) {
        LibLogger.m5432i(TAG, "setCheckImageMinimumSizeOnTranslation " + enabled);
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator != null) {
            imageTranslator.setCheckImageMinimumSize(enabled);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setDimEnabled(boolean enabled) {
        this.backgroundRenderer.setDimEnabled(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setDragAndDropEnabled(boolean enabled) {
        DragAndDropHelper dragAndDropHelper = this.dragAndDropHelper;
        if (dragAndDropHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragAndDropHelper");
            dragAndDropHelper = null;
        }
        dragAndDropHelper.setDragAndDropEnabled(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setEnableCopyPastePopup(boolean enabled) {
        LibLogger.m5432i(TAG, "setEnableCopyPastePopup " + enabled);
        this.isShowPopupEnabled = enabled;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setImageUri(@NotNull Uri imageUri) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        this.imageUri = imageUri;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setMagnifierEnabled(boolean enabled) {
        MagnifierHelper magnifierHelper = this.magnifierHelper;
        if (magnifierHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
            magnifierHelper = null;
        }
        magnifierHelper.setEnabled(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOcrResult(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        LibLogger.m5432i(TAG, "setOcrResult with " + ocrResult.getBlockInfoList().size() + " blocks");
        this.ocrResult = ocrResult;
        this.languageTags = ocrResult.getLanguageTags();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOcrResultAndBarcodeList(@NotNull OcrResult ocrResult, @NotNull List<Barcode> barcodeList) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(barcodeList, "barcodeList");
        setOcrResult(ocrResult);
        setBarcodeList(barcodeList);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOnScaleState(int scaleState) {
        this.scaleState = scaleState;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOnSelectedTextChangeListener(@NotNull TextExtractionDrawHelper.OnSelectedTextChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.textSelectionHelper.setOnSelectedTextChangeListener(listener);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOnToolbarMenuClickListener(@NotNull TextExtractionDrawHelper.OnToolbarMenuClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextExtractionActionModeHelper textExtractionActionModeHelper = this.actionModeHelper;
        if (textExtractionActionModeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionModeHelper");
            textExtractionActionModeHelper = null;
        }
        textExtractionActionModeHelper.setOnToolbarMenuClickListener(listener);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setOnTranslationState(int translationState) {
        this.translationState = translationState;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setPendingShareIntent(@NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        TextExtractionActionModeHelper textExtractionActionModeHelper = this.actionModeHelper;
        if (textExtractionActionModeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionModeHelper");
            textExtractionActionModeHelper = null;
        }
        textExtractionActionModeHelper.setPendingIntent(pendingIntent);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setProgressBarCallback(@NotNull TextExtractionDrawHelper.ProgressBarCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.progressBarCallback = callback;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setScaleFactor(float scale) {
        this.scaleFactor = scale;
        this.handleController.setScaleFactor(scale);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setSelectionAreaColor(int color) {
        this.selectionRenderer.setColor(color);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setSelectionHandleColor(int color) {
        this.handleController.setHandleColor(color);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setSelectionHandleListener(@NotNull TextExtractionDrawHelper.SelectionHandleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.selectionHandleListener = listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setSelectionHandleMovingEnabled(boolean enabled) {
        LibLogger.m5432i(TAG, "setSelectionHandleMovingEnabled " + enabled);
        this.handleController.setMovingHandleEnabled(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setSelectionHandleShadowEnabled(boolean enabled) {
        LibLogger.m5432i(TAG, "setSelectionHandleShadowEnabled " + enabled);
        this.handleController.setHandleShadowEnabled(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void setTranslateClickListener(@NotNull TextExtractionDrawHelper.TranslateCapsuleClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.translateButtonListener = listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setUnderlineVisible(boolean visible) {
        if (this.entityRenderer.getIsUnderlineVisible() != visible) {
            this.entityRenderer.setUnderlineVisible(visible);
            View view = this.teView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("teView");
                view = null;
            }
            view.invalidate();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean showBarcodeDialog(int index) {
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        return barcodeHelper.showBarcodeDialog(index);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void showPopupMenu() {
        boolean z;
        if (this.isShowPopupEnabled && this.scaleState != 1 && isTextSelected()) {
            List<SelectableCharacter> selectedCharacters = this.textSelectionHelper.getSelectedCharacters();
            if ((selectedCharacters instanceof Collection) && selectedCharacters.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it = selectedCharacters.iterator();
                while (it.hasNext()) {
                    if (((SelectableCharacter) it.next()).getIsVertical()) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            List<Rect> visibleCharactersRectList = getVisibleCharactersRectList();
            if (visibleCharactersRectList.isEmpty()) {
                dismissPopupMenu();
                return;
            }
            TextExtractionActionModeHelper textExtractionActionModeHelper = this.actionModeHelper;
            if (textExtractionActionModeHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionModeHelper");
                textExtractionActionModeHelper = null;
            }
            textExtractionActionModeHelper.startActionMode(this.textSelectionHelper.getSelectedTextForActionMode(), this.textSelectionHelper.getSelectedTextForTextClassification(), this.textSelectionHelper.getLeftAdjacentStringFromSelection(), this.textSelectionHelper.getRightAdjacentStringFromSelection(), this.languageTags, visibleCharactersRectList, z, this.textSelectionHelper.isAllTextSelected());
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean startBarcodeSelection(float x, float y2) {
        LibLogger.m5432i(TAG, "startBarcodeSelection called with " + x + SQLKeyword.COMMA + y2);
        if (isTalkBackEnabled()) {
            LibLogger.m5430e(TAG, "startBarcodeSelection is not supported on talkback mode!");
            return false;
        }
        if (this.scaleState == 1 || this.translationState == 1) {
            LibLogger.m5430e(TAG, "scaleState or translation state in progress!");
            return false;
        }
        int i = (int) (x + 0.5f);
        int i2 = (int) (y2 + 0.5f);
        BarcodeHelper barcodeHelper = this.barcodeHelper;
        BarcodeHelper barcodeHelper2 = null;
        if (barcodeHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
            barcodeHelper = null;
        }
        barcodeHelper.clearAllSelection();
        BarcodeHelper barcodeHelper3 = this.barcodeHelper;
        if (barcodeHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeHelper");
        } else {
            barcodeHelper2 = barcodeHelper3;
        }
        return barcodeHelper2.handleShowBarcodeDialog(i, i2);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "TranslationTokenInfo is no longer needed in image translation", replaceWith = @ReplaceWith(expression = "startImageTranslation()", imports = {}))
    public void startImageTranslation(@NotNull TranslationTokenInfo tokenInfo, @NotNull TextExtractionDrawHelper.ImageTranslationResultCallback callback) {
        Intrinsics.checkNotNullParameter(tokenInfo, "tokenInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        startImageTranslation();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean startTextSelectionByButton() {
        LibLogger.m5432i(TAG, "startTextSelectionByButton called");
        View view = null;
        initTextSelection$default(this, false, 1, null);
        View view2 = this.teView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
        } else {
            view = view2;
        }
        view.invalidate();
        return !this.textSelectionHelper.getSelectedCharacters().isEmpty();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public boolean startTextSelectionWithCoordinate(float x, float y2, boolean isLongPress) {
        StringBuilder sbM1176v = AbstractC0622a.m1176v("startTextSelectionWithCoordinate called with ", x, SQLKeyword.COMMA, y2, ", isLongPress=");
        sbM1176v.append(isLongPress);
        LibLogger.m5432i(TAG, sbM1176v.toString());
        if (isTalkBackEnabled()) {
            LibLogger.m5430e(TAG, "startTextSelectionWithCoordinate is not supported on talkback mode!");
            return false;
        }
        if (this.scaleState == 1) {
            LibLogger.m5430e(TAG, "scale in progress!");
            return false;
        }
        if (this.handleController.isHandleMoving()) {
            return false;
        }
        int i = (int) (x + 0.5f);
        int i2 = (int) (y2 + 0.5f);
        initTextSelection(isLongPress);
        if (this.isImageTranslationOn) {
            ImageTranslator imageTranslator = this.imageTranslator;
            if (imageTranslator != null) {
                return imageTranslator.handleTouchEvent(i, i2, this.imageRatio, this.centerOffset, isLongPress);
            }
            return false;
        }
        if (!this.textSelectionHelper.setNewSelectedEntity(i, i2) && !this.textSelectionHelper.setNewSelectedWord(i, i2)) {
            this.hitFromLongClick = false;
            this.handleController.setLongPress(false);
            clearAllSelection();
            return false;
        }
        if (isLongPress) {
            hapticFeedback();
            this.hitFromLongClick = true;
            MagnifierHelper magnifierHelper = this.magnifierHelper;
            MagnifierHelper magnifierHelper2 = null;
            if (magnifierHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                magnifierHelper = null;
            }
            if (magnifierHelper.getIsEnabled()) {
                MagnifierHelper magnifierHelper3 = this.magnifierHelper;
                if (magnifierHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magnifierHelper");
                } else {
                    magnifierHelper2 = magnifierHelper3;
                }
                magnifierHelper2.setShowing(true);
            }
        } else {
            this.hitFromLongClick = false;
            showPopupMenu();
            this.handleController.updatePosition();
        }
        this.handleController.setLongPress(this.hitFromLongClick);
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void updateCapsuleColor(int backgroundColor, int textColor, @Nullable Integer pressedBackgroundColor, @Nullable Integer pressedTextColor, @Nullable Integer rippleColor) {
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.updateCapsuleColor(backgroundColor, textColor, pressedBackgroundColor, pressedTextColor, rippleColor);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void updateTextSelection(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        LibLogger.m5432i(TAG, "updateTextSelection called with " + rect);
        dismissPopupMenu();
        setBitmapRect(rect);
        initImageInfo();
        updateTextExtractionWithNewRect();
        this.handleController.updatePosition();
        showPopupMenu();
        View view = this.teView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teView");
            view = null;
        }
        view.invalidate();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void startImageTranslation() {
        if (Rune.INSTANCE.isSupportCapsule()) {
            doImageTranslate();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    @Deprecated(message = "Replace with CapsuleHelper usage")
    public void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull final TextExtractionDrawHelper.OnToggleCapsuleListener listener, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CapsuleHelperImpl capsuleHelperImpl = this.capsuleHelper;
        if (capsuleHelperImpl != null) {
            capsuleHelperImpl.addToggleCapsule(icon, text, new ToggleCapsuleListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl.addToggleCapsule.2
                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
                public void onToggleOff() {
                    listener.onToggleOff();
                }

                @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
                public void onToggleOn() {
                    listener.onToggleOn();
                }
            }, defaultValue);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper
    public void setBitmap(@NotNull Bitmap bitmap, boolean isScale) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "setBitmap with " + LogUtil.INSTANCE.logString(bitmap) + ", isScale=" + isScale);
        setBarcodeBitmap(bitmap);
        this.imageWidth = bitmap.getWidth();
        this.imageHeight = bitmap.getHeight();
        this.originalBitmap = bitmap;
        this.isImageScale = isScale;
    }
}
