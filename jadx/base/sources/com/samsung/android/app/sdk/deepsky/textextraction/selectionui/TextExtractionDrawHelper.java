package com.samsung.android.app.sdk.deepsky.textextraction.selectionui;

import android.app.PendingIntent;
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
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.barcode.result.Barcode;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectionInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslationTokenInfo;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001:\u0012\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH'J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H'J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001c\u001a\u00020\u000bH&J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH&J\n\u0010 \u001a\u0004\u0018\u00010!H&J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020\u0003H'J\b\u0010-\u001a\u00020\u0011H&J\b\u0010.\u001a\u00020\u0011H&J\b\u0010/\u001a\u00020\u0011H&J\b\u00100\u001a\u00020\u0003H&J\u0018\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010#\u001a\u000204H&J\b\u00105\u001a\u00020\u0003H&J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001fH&J\u0016\u00108\u001a\u00020\u00032\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0016\u0010?\u001a\u00020\u00032\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0:H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0018\u0010B\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010C\u001a\u00020\u0011H&J\u0018\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u0002032\u0006\u0010F\u001a\u000203H&J\u0010\u0010G\u001a\u00020\u00032\u0006\u00107\u001a\u00020HH&J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0011H'J\u0010\u0010K\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020LH'J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010P\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010Q\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020VH&J\u001e\u0010W\u001a\u00020\u00032\u0006\u0010U\u001a\u00020V2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0:H&J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u000203H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020[H&J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020]H&J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u000203H&J\u0010\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020bH&J\u0010\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020eH&J\u0010\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020hH&J\u0010\u0010i\u001a\u00020\u00032\u0006\u0010j\u001a\u000203H&J\u0010\u0010k\u001a\u00020\u00032\u0006\u0010j\u001a\u000203H&J\u0010\u0010l\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020mH&J\u0010\u0010n\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010o\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0011H&J\u0010\u0010p\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020qH&J\u0010\u0010r\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u0011H&J\u0010\u0010t\u001a\u00020\u00112\u0006\u0010u\u001a\u000203H&J\b\u0010v\u001a\u00020\u0003H&J\u0018\u0010w\u001a\u00020\u00112\u0006\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u00020hH&J\b\u0010z\u001a\u00020\u0003H&J\u0018\u0010z\u001a\u00020\u00032\u0006\u0010{\u001a\u00020|2\u0006\u0010d\u001a\u00020}H'J\b\u0010~\u001a\u00020\u0011H&J!\u0010\u007f\u001a\u00020\u00112\u0006\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u00020h2\u0007\u0010\u0080\u0001\u001a\u00020\u0011H&JB\u0010\u0081\u0001\u001a\u00020\u00032\u0007\u0010\u0082\u0001\u001a\u0002032\u0007\u0010\u0083\u0001\u001a\u0002032\t\u0010\u0084\u0001\u001a\u0004\u0018\u0001032\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001032\t\u0010\u0086\u0001\u001a\u0004\u0018\u000103H'¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u00107\u001a\u00020HH&¨\u0006\u0092\u0001"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper;", "", "addActionCapsule", "", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "data", "Lcom/google/gson/JsonObject;", "addCapsule", "icon", "text", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnCapsuleClickListener;", "addToggleCapsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToggleCapsuleListener;", "defaultValue", "", "clearAllSelection", "dismissPopupMenu", "drawSelection", "canvas", "Landroid/graphics/Canvas;", "drawTranslation", "finishTextSelection", "finishTranslate", "getCapsuleHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "getSelectedText", "getSelectionHandlePositions", "Lkotlin/Pair;", "Landroid/graphics/Rect;", "getTranslateLanguageHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelper;", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hapticFeedback", "init", "view", "Landroid/view/View;", "initCapsuleLayout", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "invalidateCapsuleLayout", "isBarcodeSelected", "isSelectionHandlePressed", "isTextSelected", "onConfigurationChanged", "onKey", "keyCode", "", "Landroid/view/KeyEvent;", "selectAll", "selectCharactersByRect", "rect", "selectWordsByPoints", "points", "", "Landroid/graphics/Point;", "setBarcodeBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setBarcodeList", "barcodeList", "Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;", "setBitmap", "isScale", "setBitmapInfo", "width", "height", "setBitmapRect", "Landroid/graphics/RectF;", "setCapsuleLayoutVisibility", "isVisible", "setCapsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$CapsuleListener;", "setCheckImageMinimumSizeOnTranslation", "enabled", "setDimEnabled", "setDragAndDropEnabled", "setEnableCopyPastePopup", "setImageUri", "setMagnifierEnabled", "setOcrResult", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "setOcrResultAndBarcodeList", "setOnScaleState", "scaleState", "setOnSelectedTextChangeListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;", "setOnToolbarMenuClickListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToolbarMenuClickListener;", "setOnTranslationState", "translationState", "setPendingShareIntent", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "setProgressBarCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ProgressBarCallback;", "setScaleFactor", WiggleAnimationConfig.KEY_SCALE, "", "setSelectionAreaColor", "color", "setSelectionHandleColor", "setSelectionHandleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$SelectionHandleListener;", "setSelectionHandleMovingEnabled", "setSelectionHandleShadowEnabled", "setTranslateClickListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$TranslateCapsuleClickListener;", "setUnderlineVisible", "visible", "showBarcodeDialog", "index", "showPopupMenu", "startBarcodeSelection", "x", "y", "startImageTranslation", "tokenInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ImageTranslationResultCallback;", "startTextSelectionByButton", "startTextSelectionWithCoordinate", "isLongPress", "updateCapsuleColor", "backgroundColor", "textColor", "pressedBackgroundColor", "pressedTextColor", "rippleColor", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateTextSelection", "CapsuleListener", "ImageTranslationResultCallback", "OnCapsuleClickListener", "OnSelectedTextChangeListener", "OnToggleCapsuleListener", "OnToolbarMenuClickListener", "ProgressBarCallback", "SelectionHandleListener", "TranslateCapsuleClickListener", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface TextExtractionDrawHelper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "Replace with CapsuleHelper.CapsuleListener")
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$CapsuleListener;", "", "onAdd", "", "capsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "onClick", "onMoreButtonAppear", "onMoreButtonClick", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface CapsuleListener {
        void onAdd(@NotNull CapsuleActionType capsuleActionType);

        void onClick(@NotNull CapsuleActionType capsuleActionType);

        void onMoreButtonAppear();

        void onMoreButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "TranslationTokenInfo is no longer needed in image translation")
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ImageTranslationResultCallback;", "", "onResult", "", "resultCode", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ImageTranslationResultCallback {
        void onResult(int resultCode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "Replace with capsule.SimpleCapsuleClickListener")
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnCapsuleClickListener;", "", "onClick", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnCapsuleClickListener {
        void onClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;", "", "onChanged", "", "selectionInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectionInfo;", "selectedText", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnSelectedTextChangeListener {
        void onChanged(@NotNull SelectionInfo selectionInfo);

        void onChanged(@NotNull String selectedText);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "Replace with capsule.ToggleCapsuleListener")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToggleCapsuleListener;", "", "onToggleOff", "", "onToggleOn", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnToggleCapsuleListener {
        void onToggleOff();

        void onToggleOn();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToolbarMenuClickListener;", "", "onExternalAppCalled", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnToolbarMenuClickListener {
        void onExternalAppCalled();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$ProgressBarCallback;", "", "finishProgressBar", "", "startProgressBar", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ProgressBarCallback {
        void finishProgressBar();

        void startProgressBar();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$SelectionHandleListener;", "", "onHandleMove", "", "onHandleStop", "onHandleTouchDown", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface SelectionHandleListener {
        void onHandleMove();

        void onHandleStop();

        void onHandleTouchDown();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$TranslateCapsuleClickListener;", "", "onClick", "", "isOn", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface TranslateCapsuleClickListener {
        void onClick(boolean isOn);
    }

    @Deprecated(message = "Replace with CapsuleHelper.addActionCapsule")
    void addActionCapsule(@NotNull Uri imageUri, @NotNull JsonObject data);

    @Deprecated(message = "Replace with CapsuleHelper.addCapsule")
    void addCapsule(@NotNull Uri icon, @NotNull String text, @NotNull OnCapsuleClickListener listener);

    @Deprecated(message = "Replace with CapsuleHelper.addToggleCapsule")
    void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull OnToggleCapsuleListener listener);

    @Deprecated(message = "Replace with CapsuleHelper.addToggleCapsule")
    void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull OnToggleCapsuleListener listener, boolean defaultValue);

    void clearAllSelection();

    void dismissPopupMenu();

    void drawSelection(@NotNull Canvas canvas);

    void drawTranslation(@NotNull Canvas canvas);

    void finishTextSelection();

    @Deprecated(message = "Replace with CapsuleHelper.turnOffTranslate")
    void finishTranslate();

    @Nullable
    CapsuleHelper getCapsuleHelper();

    @NotNull
    String getSelectedText();

    @Nullable
    Pair<Rect, Rect> getSelectionHandlePositions();

    @Nullable
    TranslateLanguageHelper getTranslateLanguageHelper();

    boolean handleTouchEvent(@NotNull MotionEvent event);

    void hapticFeedback();

    void init(@NotNull View view);

    void initCapsuleLayout(@NotNull ViewGroup layout);

    @Deprecated(message = "Replace with CapsuleHelper.invalidateCapsuleLayout")
    void invalidateCapsuleLayout();

    boolean isBarcodeSelected();

    boolean isSelectionHandlePressed();

    boolean isTextSelected();

    void onConfigurationChanged();

    boolean onKey(int keyCode, @NotNull KeyEvent event);

    void selectAll();

    void selectCharactersByRect(@NotNull Rect rect);

    void selectWordsByPoints(@NotNull List<? extends Point> points);

    void setBarcodeBitmap(@NotNull Bitmap bitmap);

    void setBarcodeList(@NotNull List<Barcode> barcodeList);

    void setBitmap(@NotNull Bitmap bitmap);

    void setBitmap(@NotNull Bitmap bitmap, boolean isScale);

    void setBitmapInfo(int width, int height);

    void setBitmapRect(@NotNull RectF rect);

    @Deprecated(message = "Replace with CapsuleHelper.setCapsuleLayoutVisibility")
    void setCapsuleLayoutVisibility(boolean isVisible);

    @Deprecated(message = "Replace with CapsuleHelper.CapsuleListener")
    void setCapsuleListener(@NotNull CapsuleListener listener);

    void setCheckImageMinimumSizeOnTranslation(boolean enabled);

    void setDimEnabled(boolean enabled);

    void setDragAndDropEnabled(boolean enabled);

    void setEnableCopyPastePopup(boolean enabled);

    void setImageUri(@NotNull Uri imageUri);

    void setMagnifierEnabled(boolean enabled);

    void setOcrResult(@NotNull OcrResult ocrResult);

    void setOcrResultAndBarcodeList(@NotNull OcrResult ocrResult, @NotNull List<Barcode> barcodeList);

    void setOnScaleState(int scaleState);

    void setOnSelectedTextChangeListener(@NotNull OnSelectedTextChangeListener listener);

    void setOnToolbarMenuClickListener(@NotNull OnToolbarMenuClickListener listener);

    void setOnTranslationState(int translationState);

    void setPendingShareIntent(@NotNull PendingIntent pendingIntent);

    void setProgressBarCallback(@NotNull ProgressBarCallback callback);

    void setScaleFactor(float scale);

    void setSelectionAreaColor(int color);

    void setSelectionHandleColor(int color);

    void setSelectionHandleListener(@NotNull SelectionHandleListener listener);

    void setSelectionHandleMovingEnabled(boolean enabled);

    void setSelectionHandleShadowEnabled(boolean enabled);

    void setTranslateClickListener(@NotNull TranslateCapsuleClickListener listener);

    void setUnderlineVisible(boolean visible);

    boolean showBarcodeDialog(int index);

    void showPopupMenu();

    boolean startBarcodeSelection(float x, float y2);

    void startImageTranslation();

    @Deprecated(message = "TranslationTokenInfo is no longer needed in image translation")
    void startImageTranslation(@NotNull TranslationTokenInfo tokenInfo, @NotNull ImageTranslationResultCallback callback);

    boolean startTextSelectionByButton();

    boolean startTextSelectionWithCoordinate(float x, float y2, boolean isLongPress);

    @Deprecated(message = "Replace with CapsuleHelper.updateCapsuleColor")
    void updateCapsuleColor(int backgroundColor, int textColor, @Nullable Integer pressedBackgroundColor, @Nullable Integer pressedTextColor, @Nullable Integer rippleColor);

    void updateTextSelection(@NotNull RectF rect);
}
