package com.samsung.android.app.sdk.deepsky.textextraction.capsule;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.WorkerThread;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.action.ActionManager;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.CapsuleAnimator;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.CapsuleColor;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.ToggleCapsuleLayout;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.AiSuggestionCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.BasicCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.ToggleCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.util.CapsuleUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.LockScreenHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.ClipboardUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PackageHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.RoleDescriptionAccessibilityDelegate;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import p043J2.ViewOnClickListenerC0157a;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 r2\u00020\u0001:\u0001rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0003J \u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0003J \u00103\u001a\u00020%2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u000204H\u0016J(\u00103\u001a\u00020%2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u00020\u0019H\u0003J\u0010\u00108\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0006\u0010?\u001a\u00020%J\b\u0010@\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020%2\u0006\u0010:\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020%2\u0006\u0010:\u001a\u00020 H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010/\u001a\u00020\u001dH\u0002J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020;0GH\u0016J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020,H\u0002J\u0010\u0010J\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010K\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0003J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020\u0012H\u0016J\u0018\u0010N\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u00020\u0019H\u0002J\u0018\u0010O\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u00020\u0019H\u0003J\u000e\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020\u0012J\b\u0010R\u001a\u00020%H\u0016J\b\u0010S\u001a\u00020%H\u0016J\b\u0010T\u001a\u00020\u0019H\u0002J\b\u0010U\u001a\u00020%H\u0016J\u000e\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020\u0019J\u0018\u0010W\u001a\u00020%2\u0006\u0010I\u001a\u00020,2\u0006\u0010X\u001a\u00020\u0019H\u0016J\u0016\u0010Y\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u00107\u001a\u00020\u0019J\u0010\u0010Z\u001a\u00020%2\u0006\u0010[\u001a\u00020\u0019H\u0016J\u0010\u0010\\\u001a\u00020%2\u0006\u00100\u001a\u00020\u000eH\u0016J\b\u0010]\u001a\u00020%H\u0002J\u0010\u0010^\u001a\u00020%2\u0006\u00100\u001a\u00020#H\u0016J\b\u0010_\u001a\u00020%H\u0016J;\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010b2\b\u0010e\u001a\u0004\u0018\u00010b2\b\u0010f\u001a\u0004\u0018\u00010bH\u0016¢\u0006\u0002\u0010gJ,\u0010h\u001a\u00020%2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010mH\u0002J\u0010\u0010n\u001a\u00020%2\u0006\u0010o\u001a\u00020\u001dH\u0002J\f\u0010p\u001a\u00020q*\u00020\u001dH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelperImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "context", "Landroid/content/Context;", "imageTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;)V", "capsuleColor", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleColor;", "capsuleContainer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleContainer;", "capsuleLayout", "Landroid/widget/LinearLayout;", "capsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;", "capsuleScrollView", "Landroid/widget/HorizontalScrollView;", "clientCapsuleLayout", "Landroid/view/ViewGroup;", "drawingJob", "Lkotlinx/coroutines/Job;", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "isCapsuleLayoutVisible", "", "outerLayout", "toggleMap", "", "", "Lkotlin/Pair;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/ToggleCapsuleLayout;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/ToggleCapsule;", "translateCapsule", "translateCapsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/TranslateCapsuleListener;", "addActionCapsule", "", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "data", "Lcom/google/gson/JsonObject;", "addAddToNoteCapsule", "result", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "addCapsule", "icon", "text", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", "addCopyAllCapsule", "addToggleCapsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/ToggleCapsuleListener;", "defaultValue", "addTranslateCapsule", "isImageTranslateOn", "canShowBasicCapsules", "checkCapsuleBeforeDrawing", "capsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/Capsule;", "checkInvalidCondition", "actionManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/ActionManager;", "clearCapsuleLayout", "drawCapsules", "drawSimpleCapsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/SimpleCapsule;", "drawToggleCapsule", "getAddToNoteIntent", "Landroid/content/Intent;", "getCapsuleList", "", "getOcrText", "ocrResult", "inflateCapsule", "initBasicCapsules", "initCapsuleLayout", DBSchema.DocumentThumbnail.LAYOUT, "initCapsules", "initFixedCapsules", "initLayout", "parent", "initTranslateCapsule", "invalidateCapsuleLayout", "isNoteAppEnabled", "onConfigurationChanged", "isTextSelectionStarted", "onStartTextSelection", "isImageTranslationOn", "onStartTextSelectionWithDrawCapsuleLayout", "setCapsuleLayoutVisibility", "isVisible", "setCapsuleListener", "setClientCapsuleLayoutVisible", "setTranslateCapsuleListener", "turnOffTranslate", "updateCapsuleColor", "backgroundColor", "", "textColor", "pressedBackgroundColor", "pressedTextColor", "rippleColor", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateLayoutColor", "backgroundView", "Landroid/view/View;", "image", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "updateToggleCheckedMap", "turnedOnCapsuleTitle", "convertToCapsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCapsuleHelperImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapsuleHelperImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelperImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,565:1\n1855#2,2:566\n215#3,2:568\n215#3,2:570\n*S KotlinDebug\n*F\n+ 1 CapsuleHelperImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelperImpl\n*L\n276#1:566,2\n375#1:568,2\n389#1:570,2\n*E\n"})
public final class CapsuleHelperImpl implements CapsuleHelper {

    @NotNull
    private static final String ADD_TO_NOTES_ACTION = "android.intent.action.SEND";

    @NotNull
    private static final String ADD_TO_NOTES_TYPE = "text/plain";

    @NotNull
    private static final String KEY_TEXT_EXTRA = "ai_text_extra";
    private static final int MAXIMUM_BLOCK_SIZE_FOR_BASIC_CAPSULE = 10;

    @NotNull
    private static final String NOTES_ACTIVITY = "com.samsung.android.app.notes.nativecomposer.NativeComposerActionNewActivity";

    @NotNull
    private static final String NOTES_PACKAGE_NAME = "com.samsung.android.app.notes";

    @NotNull
    private static final String TAG = "CapsuleHelper";

    @NotNull
    private CapsuleColor capsuleColor;

    @NotNull
    private final CapsuleContainer capsuleContainer;

    @Nullable
    private LinearLayout capsuleLayout;

    @Nullable
    private CapsuleHelper.CapsuleListener capsuleListener;

    @Nullable
    private HorizontalScrollView capsuleScrollView;

    @Nullable
    private ViewGroup clientCapsuleLayout;

    @NotNull
    private final Context context;

    @Nullable
    private Job drawingJob;

    @Nullable
    private final ImageTranslator imageTranslator;
    private final LayoutInflater inflater;
    private boolean isCapsuleLayoutVisible;

    @Nullable
    private ViewGroup outerLayout;

    @NotNull
    private final Map<String, Pair<ToggleCapsuleLayout, ToggleCapsule>> toggleMap;

    @Nullable
    private ToggleCapsule translateCapsule;

    @Nullable
    private TranslateCapsuleListener translateCapsuleListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CapsuleActionType.values().length];
            try {
                iArr[CapsuleActionType.ADD_TO_NOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addActionCapsule$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addActionCapsule$1", m14021f = "CapsuleHelperImpl.kt", m14022i = {0}, m14023l = {STBorder.INT_ZANY_TRIANGLES}, m14024m = "invokeSuspend", m14025n = {"target"}, m14026s = {"L$0"})
    public static final class C70401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonObject $data;
        final /* synthetic */ Uri $imageUri;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70401(Uri uri, JsonObject jsonObject, Continuation<? super C70401> continuation) {
            super(2, continuation);
            this.$imageUri = uri;
            this.$data = jsonObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return CapsuleHelperImpl.this.new C70401(this.$imageUri, this.$data, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AiSuggestionCapsule aiSuggestionCapsule;
            CapsuleHelperImpl capsuleHelperImpl;
            CapsuleHelperImpl capsuleHelperImpl2;
            AiSuggestionCapsule aiSuggestionCapsule2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ActionManager actionManager = new ActionManager(CapsuleHelperImpl.this.context, this.$imageUri, this.$data);
                if (CapsuleHelperImpl.this.checkInvalidCondition(actionManager)) {
                    return Unit.INSTANCE;
                }
                final CapsuleActionType capsuleActionTypeConvertToCapsuleActionType = CapsuleHelperImpl.this.convertToCapsuleActionType(actionManager.getClassification());
                String title = actionManager.getTitle();
                Uri iconUri = actionManager.getIconUri();
                final CapsuleHelperImpl capsuleHelperImpl3 = CapsuleHelperImpl.this;
                aiSuggestionCapsule = new AiSuggestionCapsule(title, capsuleActionTypeConvertToCapsuleActionType, iconUri, new SimpleCapsuleClickListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addActionCapsule$1$target$1
                    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener
                    public void onClick() {
                        LockScreenHelper lockScreenHelper = LockScreenHelper.INSTANCE;
                        Context context = capsuleHelperImpl3.context;
                        final CapsuleActionType capsuleActionType = capsuleActionTypeConvertToCapsuleActionType;
                        final CapsuleHelperImpl capsuleHelperImpl4 = capsuleHelperImpl3;
                        final ActionManager actionManager2 = actionManager;
                        LockScreenHelper.requestDismissKeyguard$default(lockScreenHelper, context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addActionCapsule$1$target$1$onClick$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                LibLogger.m5432i("CapsuleHelper", "onClick " + capsuleActionType);
                                CapsuleHelper.CapsuleListener capsuleListener = capsuleHelperImpl4.capsuleListener;
                                if (capsuleListener != null) {
                                    capsuleListener.onClick(capsuleActionType);
                                }
                                actionManager2.runAction();
                            }
                        }, null, 4, null);
                    }
                });
                CapsuleHelperImpl.this.capsuleContainer.appendCapsule(aiSuggestionCapsule);
                Job job = CapsuleHelperImpl.this.drawingJob;
                if (job != null) {
                    capsuleHelperImpl = CapsuleHelperImpl.this;
                    if (job.isActive()) {
                        LibLogger.m5429d(CapsuleHelperImpl.TAG, "AddActionCapsule calls in the middle of drawing, waiting");
                        this.L$0 = aiSuggestionCapsule;
                        this.L$1 = capsuleHelperImpl;
                        this.label = 1;
                        if (job.join(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        capsuleHelperImpl2 = capsuleHelperImpl;
                        aiSuggestionCapsule2 = aiSuggestionCapsule;
                    }
                    LibLogger.m5429d(CapsuleHelperImpl.TAG, "inflating action capsule");
                    capsuleHelperImpl.inflateCapsule(aiSuggestionCapsule);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            capsuleHelperImpl2 = (CapsuleHelperImpl) this.L$1;
            aiSuggestionCapsule2 = (AiSuggestionCapsule) this.L$0;
            ResultKt.throwOnFailure(obj);
            aiSuggestionCapsule = aiSuggestionCapsule2;
            capsuleHelperImpl = capsuleHelperImpl2;
            LibLogger.m5429d(CapsuleHelperImpl.TAG, "inflating action capsule");
            capsuleHelperImpl.inflateCapsule(aiSuggestionCapsule);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C70401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CapsuleHelperImpl(@NotNull Context context, @Nullable ImageTranslator imageTranslator) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.imageTranslator = imageTranslator;
        this.capsuleContainer = new CapsuleContainer();
        this.toggleMap = new LinkedHashMap();
        this.isCapsuleLayoutVisible = true;
        this.capsuleColor = new CapsuleColor(context.getColor(C7039R.color.capsule_background), context.getColor(C7039R.color.capsule_tint_color), context.getColor(C7039R.color.capsule_toggle_on_background), context.getColor(C7039R.color.capsule_toggle_on_tint_color), context.getColor(C7039R.color.capsule_ripple_background_color));
        this.inflater = LayoutInflater.from(context);
    }

    @WorkerThread
    private final void addAddToNoteCapsule(final OcrResult result) {
        CapsuleContainer capsuleContainer = this.capsuleContainer;
        String string = this.context.getString(C7039R.string.add_to_notes);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.add_to_notes)");
        capsuleContainer.appendCapsule(new BasicCapsule(string, CapsuleActionType.ADD_TO_NOTE, CapsuleUtil.INSTANCE.getResourceUri(this.context, C7039R.drawable.capsule_notes), new SimpleCapsuleClickListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.addAddToNoteCapsule.1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener
            public void onClick() {
                LockScreenHelper lockScreenHelper = LockScreenHelper.INSTANCE;
                Context context = CapsuleHelperImpl.this.context;
                final CapsuleHelperImpl capsuleHelperImpl = CapsuleHelperImpl.this;
                final OcrResult ocrResult = result;
                LockScreenHelper.requestDismissKeyguard$default(lockScreenHelper, context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addAddToNoteCapsule$1$onClick$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LibLogger.m5432i("CapsuleHelper", "onClick ADD_TO_NOTE");
                        if (!capsuleHelperImpl.isNoteAppEnabled()) {
                            LibLogger.m5433w("CapsuleHelper", "onClick ADD_TO_NOTE but app not exists");
                            Toast.makeText(capsuleHelperImpl.context, C7039R.string.capsule_unknown_error, 0).show();
                            return;
                        }
                        CapsuleHelper.CapsuleListener capsuleListener = capsuleHelperImpl.capsuleListener;
                        if (capsuleListener != null) {
                            capsuleListener.onClick(CapsuleActionType.ADD_TO_NOTE);
                        }
                        Context context2 = capsuleHelperImpl.context;
                        CapsuleHelperImpl capsuleHelperImpl2 = capsuleHelperImpl;
                        context2.startActivity(capsuleHelperImpl2.getAddToNoteIntent(capsuleHelperImpl2.getOcrText(ocrResult)));
                    }
                }, null, 4, null);
            }
        }));
    }

    @WorkerThread
    private final void addCopyAllCapsule(final OcrResult result) {
        CapsuleContainer capsuleContainer = this.capsuleContainer;
        String string = this.context.getString(C7039R.string.add_to_copy_all);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.add_to_copy_all)");
        capsuleContainer.appendCapsule(new BasicCapsule(string, CapsuleActionType.COPY_ALL, CapsuleUtil.INSTANCE.getResourceUri(this.context, C7039R.drawable.capsule_copyall), new SimpleCapsuleClickListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.addCopyAllCapsule.1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener
            public void onClick() {
                LockScreenHelper lockScreenHelper = LockScreenHelper.INSTANCE;
                Context context = CapsuleHelperImpl.this.context;
                final CapsuleHelperImpl capsuleHelperImpl = CapsuleHelperImpl.this;
                final OcrResult ocrResult = result;
                LockScreenHelper.requestDismissKeyguard$default(lockScreenHelper, context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$addCopyAllCapsule$1$onClick$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LibLogger.m5432i("CapsuleHelper", "onClick COPY_ALL");
                        CapsuleHelper.CapsuleListener capsuleListener = capsuleHelperImpl.capsuleListener;
                        if (capsuleListener != null) {
                            capsuleListener.onClick(CapsuleActionType.COPY_ALL);
                        }
                        ClipboardUtil.INSTANCE.copyClipboard(capsuleHelperImpl.context, capsuleHelperImpl.getOcrText(ocrResult));
                    }
                }, null, 4, null);
            }
        }));
    }

    @WorkerThread
    private final void addTranslateCapsule(OcrResult result, boolean isImageTranslateOn) {
        ToggleCapsule toggleCapsule;
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator == null || !imageTranslator.isTranslationAvailable(result) || (toggleCapsule = this.translateCapsule) == null) {
            return;
        }
        toggleCapsule.setOn(isImageTranslateOn);
        this.capsuleContainer.insertCapsule(toggleCapsule, 0);
    }

    private final boolean canShowBasicCapsules(OcrResult result) {
        return result.getBlockInfoList().size() <= 10;
    }

    private final void checkCapsuleBeforeDrawing(Capsule capsule) {
        if (WhenMappings.$EnumSwitchMapping$0[capsule.getCapsuleActionType().ordinal()] != 1 || isNoteAppEnabled()) {
            return;
        }
        this.capsuleContainer.removeCapsule(capsule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkInvalidCondition(ActionManager actionManager) {
        String classification;
        if (actionManager == null || (classification = actionManager.getClassification()) == null) {
            return true;
        }
        if (!ActionManager.INSTANCE.isValidClassification(classification)) {
            LibLogger.m5432i(TAG, "Fail to add action capsule because of invalid classification : ".concat(classification));
            return true;
        }
        if (actionManager.isSupportAction()) {
            return false;
        }
        LibLogger.m5432i(TAG, "Action is not support in classification ".concat(classification));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CapsuleActionType convertToCapsuleActionType(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != 653222902) {
            if (iHashCode != 691810669) {
                if (iHashCode == 2024260678 && str.equals(ActionConstants.ACTION_CATEGORY_COUPON)) {
                    return CapsuleActionType.WALLET_COUPON;
                }
            } else if (str.equals(ActionConstants.ACTION_CATEGORY_BOARDING_PASS)) {
                return CapsuleActionType.WALLET_BOARDING_PASS;
            }
        } else if (str.equals(ActionConstants.ACTION_CATEGORY_MEMBERSHIP)) {
            return CapsuleActionType.WALLET_MEMBERSHIP;
        }
        return CapsuleActionType.OTHER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawCapsules() {
        if (!this.isCapsuleLayoutVisible) {
            LibLogger.m5429d(TAG, "drawCapsules - capsule layout is not visible");
            return;
        }
        for (Capsule capsule : this.capsuleContainer.getMergedCapsuleList()) {
            checkCapsuleBeforeDrawing(capsule);
            inflateCapsule(capsule);
        }
        setClientCapsuleLayoutVisible();
    }

    private final void drawSimpleCapsule(SimpleCapsule capsule) {
        View viewInflate = this.inflater.inflate(C7039R.layout.capsule_view, (ViewGroup) this.capsuleLayout, false);
        TextView titleView = (TextView) viewInflate.findViewById(C7039R.id.capture_ai_bottom_action_text);
        titleView.setText(capsule.getTitle());
        viewInflate.setTooltipText(capsule.getTitle());
        viewInflate.setContentDescription(capsule.getTitle());
        ImageView imageView = (ImageView) viewInflate.findViewById(C7039R.id.capture_ai_bottom_action_icon);
        imageView.setImageURI(capsule.getIcon());
        Unit unit = Unit.INSTANCE;
        updateLayoutColor(viewInflate, imageView, titleView);
        String string = viewInflate.getContext().getResources().getString(C7039R.string.capsule_role_button);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.capsule_role_button)");
        ViewCompat.setAccessibilityDelegate(viewInflate, new RoleDescriptionAccessibilityDelegate(string));
        viewInflate.setOnClickListener(new ViewOnClickListenerC0157a(capsule, 13));
        LinearLayout linearLayout = this.capsuleLayout;
        if (linearLayout != null) {
            linearLayout.addView(viewInflate);
        }
        CapsuleAnimator capsuleAnimator = CapsuleAnimator.INSTANCE;
        Context context = viewInflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(viewInflate, "this");
        Intrinsics.checkNotNullExpressionValue(titleView, "titleView");
        CapsuleAnimator.startShowingAnimation$default(capsuleAnimator, context, viewInflate, titleView, 0L, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void drawSimpleCapsule$lambda$5$lambda$4(SimpleCapsule capsule, View view) {
        Intrinsics.checkNotNullParameter(capsule, "$capsule");
        capsule.getListener().onClick();
    }

    private final void drawToggleCapsule(ToggleCapsule capsule) {
        ToggleCapsuleLayout toggleCapsuleLayout = new ToggleCapsuleLayout(this.context, capsule.getIcon(), capsule.getTitle(), capsule.isOn(), this.capsuleColor);
        toggleCapsuleLayout.setOnListener(new ViewOnClickListenerC0219a(capsule, this, 6));
        toggleCapsuleLayout.setOffListener(new ViewOnClickListenerC0157a(capsule, 12));
        LinearLayout linearLayout = this.capsuleLayout;
        if (linearLayout != null) {
            linearLayout.addView(toggleCapsuleLayout);
        }
        this.toggleMap.put(capsule.getTitle(), new Pair<>(toggleCapsuleLayout, capsule));
        TextView titleView = (TextView) toggleCapsuleLayout.findViewById(C7039R.id.capture_ai_bottom_action_text);
        CapsuleAnimator capsuleAnimator = CapsuleAnimator.INSTANCE;
        Context context = toggleCapsuleLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(titleView, "titleView");
        CapsuleAnimator.startShowingAnimation$default(capsuleAnimator, context, toggleCapsuleLayout, titleView, 0L, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void drawToggleCapsule$lambda$8$lambda$6(ToggleCapsule capsule, CapsuleHelperImpl this$0, View view) {
        Intrinsics.checkNotNullParameter(capsule, "$capsule");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        capsule.getListener().onToggleOn();
        capsule.setOn(true);
        this$0.updateToggleCheckedMap(capsule.getTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void drawToggleCapsule$lambda$8$lambda$7(ToggleCapsule capsule, View view) {
        Intrinsics.checkNotNullParameter(capsule, "$capsule");
        capsule.getListener().onToggleOff();
        capsule.setOn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent getAddToNoteIntent(String text) {
        Intent intent = new Intent();
        intent.setAction(ADD_TO_NOTES_ACTION);
        intent.setComponent(new ComponentName("com.samsung.android.app.notes", NOTES_ACTIVITY));
        intent.setType("text/plain");
        intent.putExtra(KEY_TEXT_EXTRA, true);
        intent.putExtra("android.intent.extra.TEXT", text);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getOcrText(OcrResult ocrResult) {
        StringBuilder sb = new StringBuilder();
        Iterator<OcrResult.BlockInfo> it = ocrResult.getBlockInfoList().iterator();
        while (it.hasNext()) {
            Iterator<OcrResult.LineInfo> it2 = it.next().getLineInfo().iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().getString());
                sb.append("\n");
            }
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void inflateCapsule(Capsule capsule) {
        if (capsule instanceof SimpleCapsule) {
            drawSimpleCapsule((SimpleCapsule) capsule);
        } else if (capsule instanceof ToggleCapsule) {
            drawToggleCapsule((ToggleCapsule) capsule);
        }
    }

    @WorkerThread
    private final void initBasicCapsules(OcrResult result) {
        if (!canShowBasicCapsules(result)) {
            LibLogger.m5433w(TAG, "initBasicCapsules - not show basic capsules due to large block size");
            return;
        }
        if (isNoteAppEnabled()) {
            addAddToNoteCapsule(result);
        }
        addCopyAllCapsule(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCapsules(OcrResult result, boolean isImageTranslateOn) {
        if (result.getBlockInfoList().isEmpty()) {
            LibLogger.m5433w(TAG, "initCapsules - blockInfoList is empty");
        } else {
            initFixedCapsules(result, isImageTranslateOn);
            initBasicCapsules(result);
        }
    }

    @WorkerThread
    private final void initFixedCapsules(OcrResult result, boolean isImageTranslateOn) {
        addTranslateCapsule(result, isImageTranslateOn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNoteAppEnabled() {
        return PackageHelper.INSTANCE.isPackageExists(this.context, "com.samsung.android.app.notes", NOTES_ACTIVITY);
    }

    private final void setClientCapsuleLayoutVisible() {
        if (this.capsuleContainer.isEmpty()) {
            LibLogger.m5429d(TAG, "CapsuleLayout gone, capsuleContainer empty");
            ViewGroup viewGroup = this.clientCapsuleLayout;
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(8);
            return;
        }
        LibLogger.m5429d(TAG, "CapsuleLayout visible: total " + this.capsuleContainer.getSize() + " capsules");
        ViewGroup viewGroup2 = this.clientCapsuleLayout;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.setVisibility(0);
    }

    private final void updateLayoutColor(View backgroundView, ImageView image, TextView text) {
        if (backgroundView != null) {
            Drawable drawableMutate = backgroundView.getBackground().mutate();
            Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
            RippleDrawable rippleDrawable = (RippleDrawable) drawableMutate;
            rippleDrawable.setTint(this.capsuleColor.getBackgroundColor());
            rippleDrawable.setColor(ColorStateList.valueOf(this.capsuleColor.getRippleColor()));
            backgroundView.setBackground(rippleDrawable);
        }
        if (image != null) {
            image.setImageTintList(ColorStateList.valueOf(this.capsuleColor.getTextColor()));
        }
        if (text != null) {
            text.setTextColor(this.capsuleColor.getTextColor());
        }
    }

    public static /* synthetic */ void updateLayoutColor$default(CapsuleHelperImpl capsuleHelperImpl, View view, ImageView imageView, TextView textView, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        if ((i & 2) != 0) {
            imageView = null;
        }
        if ((i & 4) != 0) {
            textView = null;
        }
        capsuleHelperImpl.updateLayoutColor(view, imageView, textView);
    }

    private final void updateToggleCheckedMap(String turnedOnCapsuleTitle) {
        for (Map.Entry<String, Pair<ToggleCapsuleLayout, ToggleCapsule>> entry : this.toggleMap.entrySet()) {
            ToggleCapsuleLayout first = entry.getValue().getFirst();
            ToggleCapsule second = entry.getValue().getSecond();
            if (!Intrinsics.areEqual(entry.getKey(), turnedOnCapsuleTitle) && first.getIsChecked()) {
                first.setChecked(false);
                second.setOn(false);
                first.updateCapsule(false);
                View.OnClickListener offListener = first.getOffListener();
                if (offListener != null) {
                    offListener.onClick(first);
                }
            }
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void addActionCapsule(@NotNull Uri imageUri, @NotNull JsonObject data) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(data, "data");
        BuildersKt__BuildersKt.runBlocking$default(null, new C70401(imageUri, data, null), 1, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void addCapsule(@NotNull Uri icon, @NotNull String text, @NotNull SimpleCapsuleClickListener listener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.capsuleContainer.addAppCapsule(new BasicCapsule(text, CapsuleActionType.OTHER, icon, listener));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull ToggleCapsuleListener listener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        addToggleCapsule(icon, text, listener, false);
    }

    public final void clearCapsuleLayout() {
        LinearLayout linearLayout = this.capsuleLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    @NotNull
    public List<Capsule> getCapsuleList() {
        return this.capsuleContainer.getMergedCapsuleList();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void initCapsuleLayout(@NotNull ViewGroup layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        LibLogger.m5432i(TAG, "initCapsuleLayout called");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
        this.clientCapsuleLayout = layout;
        ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(C7039R.layout.capsule_layout, layout);
        this.outerLayout = viewGroup;
        this.capsuleScrollView = viewGroup != null ? (HorizontalScrollView) viewGroup.findViewById(C7039R.id.capsule_scroll_view) : null;
        ViewGroup viewGroup2 = this.outerLayout;
        this.capsuleLayout = viewGroup2 != null ? (LinearLayout) viewGroup2.findViewById(C7039R.id.capsule_parent) : null;
    }

    public final void initLayout(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.capsuleContainer.initialize();
        initCapsuleLayout(parent);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void initTranslateCapsule() {
        String string = this.context.getString(C7039R.string.translate);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.translate)");
        this.translateCapsule = new ToggleCapsule(string, CapsuleActionType.TRANSLATE, CapsuleUtil.INSTANCE.getResourceUri(this.context, C7039R.drawable.capsule_translate), new ToggleCapsuleListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.initTranslateCapsule.1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
            public void onToggleOff() {
                LibLogger.m5429d(CapsuleHelperImpl.TAG, "translateCapsule OffClick");
                TranslateCapsuleListener translateCapsuleListener = CapsuleHelperImpl.this.translateCapsuleListener;
                if (translateCapsuleListener != null) {
                    translateCapsuleListener.onTranslateOff();
                }
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener
            public void onToggleOn() {
                LockScreenHelper lockScreenHelper = LockScreenHelper.INSTANCE;
                Context context = CapsuleHelperImpl.this.context;
                final CapsuleHelperImpl capsuleHelperImpl = CapsuleHelperImpl.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$initTranslateCapsule$1$onToggleOn$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LibLogger.m5432i("CapsuleHelper", "onClick TRANSLATE");
                        CapsuleHelper.CapsuleListener capsuleListener = capsuleHelperImpl.capsuleListener;
                        if (capsuleListener != null) {
                            capsuleListener.onClick(CapsuleActionType.TRANSLATE);
                        }
                        TranslateCapsuleListener translateCapsuleListener = capsuleHelperImpl.translateCapsuleListener;
                        if (translateCapsuleListener != null) {
                            translateCapsuleListener.onTranslateOn();
                        }
                    }
                };
                final CapsuleHelperImpl capsuleHelperImpl2 = CapsuleHelperImpl.this;
                lockScreenHelper.requestDismissKeyguard(context, function0, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl$initTranslateCapsule$1$onToggleOn$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        capsuleHelperImpl2.turnOffTranslate();
                    }
                });
            }
        }, false, 16, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void invalidateCapsuleLayout() {
        LibLogger.m5432i(TAG, "invalidateCapsuleLayout called");
        this.drawingJob = SingleThreadCoroutineSwitcher.INSTANCE.newChain().onMain(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.invalidateCapsuleLayout.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LibLogger.m5429d(CapsuleHelperImpl.TAG, "drawing capsules start");
                CapsuleHelperImpl.this.clearCapsuleLayout();
                CapsuleHelperImpl.this.drawCapsules();
            }
        }).start(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.invalidateCapsuleLayout.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Unit unit) {
                LibLogger.m5429d(CapsuleHelperImpl.TAG, "capsule drawing success");
            }
        }, new Function1<Throwable, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.invalidateCapsuleLayout.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LibLogger.m5431e(CapsuleHelperImpl.TAG, "capsule drawing fail", it);
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void onConfigurationChanged() {
        onConfigurationChanged(false);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void onStartTextSelection(@NotNull final OcrResult ocrResult, final boolean isImageTranslationOn) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        SingleThreadCoroutineSwitcher.Chain.start$default(SingleThreadCoroutineSwitcher.INSTANCE.newChain().onBackground(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.onStartTextSelection.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CapsuleHelperImpl.this.initCapsules(ocrResult, isImageTranslationOn);
            }
        }), null, null, 3, null);
    }

    public final void onStartTextSelectionWithDrawCapsuleLayout(@NotNull final OcrResult result, final boolean isImageTranslateOn) {
        Intrinsics.checkNotNullParameter(result, "result");
        SingleThreadCoroutineSwitcher.Chain.start$default(SingleThreadCoroutineSwitcher.INSTANCE.newChain().onBackground(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.onStartTextSelectionWithDrawCapsuleLayout.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CapsuleHelperImpl.this.initCapsules(result, isImageTranslateOn);
            }
        }), new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl.onStartTextSelectionWithDrawCapsuleLayout.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Unit unit) {
                CapsuleHelperImpl.this.invalidateCapsuleLayout();
            }
        }, null, 2, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void setCapsuleLayoutVisibility(boolean isVisible) {
        LibLogger.m5432i(TAG, "setCapsuleLayoutVisibility " + isVisible);
        this.isCapsuleLayoutVisible = isVisible;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void setCapsuleListener(@NotNull CapsuleHelper.CapsuleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.capsuleListener = listener;
        this.capsuleContainer.setCapsuleListener(listener);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void setTranslateCapsuleListener(@NotNull TranslateCapsuleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.translateCapsuleListener = listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void turnOffTranslate() {
        for (Map.Entry<String, Pair<ToggleCapsuleLayout, ToggleCapsule>> entry : this.toggleMap.entrySet()) {
            ToggleCapsuleLayout first = entry.getValue().getFirst();
            ToggleCapsule second = entry.getValue().getSecond();
            if (Intrinsics.areEqual(entry.getKey(), this.context.getString(C7039R.string.translate)) && first.getIsChecked()) {
                first.setChecked(false);
                second.setOn(false);
                first.updateCapsule(false);
                View.OnClickListener offListener = first.getOffListener();
                if (offListener != null) {
                    offListener.onClick(first);
                }
            }
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void updateCapsuleColor(int backgroundColor, int textColor, @Nullable Integer pressedBackgroundColor, @Nullable Integer pressedTextColor, @Nullable Integer rippleColor) {
        this.capsuleColor = new CapsuleColor(backgroundColor, textColor, pressedBackgroundColor != null ? pressedBackgroundColor.intValue() : this.context.getColor(C7039R.color.capsule_toggle_on_background), pressedTextColor != null ? pressedTextColor.intValue() : this.context.getColor(C7039R.color.capsule_toggle_on_tint_color), rippleColor != null ? rippleColor.intValue() : this.context.getColor(C7039R.color.capsule_ripple_background_color));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper
    public void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull ToggleCapsuleListener listener, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.capsuleContainer.addAppCapsule(new ToggleCapsule(text, CapsuleActionType.OTHER, icon, listener, defaultValue));
    }

    public final void onConfigurationChanged(boolean isTextSelectionStarted) {
        LibLogger.m5432i(TAG, "onConfigurationChanged with isTextSelectionStarted(" + isTextSelectionStarted + ")");
        ViewGroup viewGroup = this.clientCapsuleLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            initCapsuleLayout(viewGroup);
        }
        if (isTextSelectionStarted) {
            drawCapsules();
        }
    }

    public /* synthetic */ CapsuleHelperImpl(Context context, ImageTranslator imageTranslator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : imageTranslator);
    }
}
