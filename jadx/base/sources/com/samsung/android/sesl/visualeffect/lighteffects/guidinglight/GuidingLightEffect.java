package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.math.MathUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.RadialGradControl;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.RadialGradRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.SpotIndexManager;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import opennlp.tools.parser.AbstractBottomUpParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010 \n\u0002\b\u000f\b\u0007\u0018\u0000 x2\u00020\u0001:\u0005xyz{|B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fB%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$J!\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020)J\b\u0010*\u001a\u00020\"H\u0002J\u000e\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200J\u000e\u0010.\u001a\u00020\"2\u0006\u00101\u001a\u000202J\u0018\u00103\u001a\u00020\"2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000207J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205J\u0010\u00108\u001a\u0002052\u0006\u00109\u001a\u000205H\u0002J\u000e\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u000205J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>H\u0007J\u000e\u0010?\u001a\u00020\"2\u0006\u0010=\u001a\u00020>J\u000e\u0010@\u001a\u00020\"2\u0006\u0010=\u001a\u00020>J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020>H\u0002J\u0018\u0010C\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010B\u001a\u00020>H\u0002J\u000e\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u000205J\u0010\u0010F\u001a\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010I\u001a\u00020\"J\u000e\u0010J\u001a\u00020\"2\u0006\u0010;\u001a\u000205J\u000e\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u000205J\u000e\u0010M\u001a\u00020\"2\u0006\u0010E\u001a\u000205J\u000e\u0010N\u001a\u00020\"2\u0006\u0010;\u001a\u000205J\u000e\u0010O\u001a\u00020\"2\u0006\u0010P\u001a\u000205J\u000e\u0010Q\u001a\u00020\"2\u0006\u0010E\u001a\u000205J\u000e\u0010R\u001a\u00020\"2\u0006\u0010;\u001a\u000205J\u000e\u0010S\u001a\u00020\"2\u0006\u0010T\u001a\u000205J\u0010\u0010U\u001a\u00020\"2\u0006\u0010V\u001a\u00020\u000bH\u0007J\u0010\u0010W\u001a\u00020\"2\u0006\u0010X\u001a\u00020\u001bH\u0007J\u000e\u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\u000bJ\u000e\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u000205J\u000e\u0010]\u001a\u00020\"2\u0006\u0010^\u001a\u000205J\u000e\u0010_\u001a\u00020\"2\u0006\u0010`\u001a\u000205J\u000e\u0010a\u001a\u00020\"2\u0006\u0010b\u001a\u000205J\u000e\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u000205J\u000e\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u000205J\u000e\u0010g\u001a\u00020\"2\u0006\u0010h\u001a\u000205J\u0016\u0010i\u001a\u00020\"2\u0006\u0010j\u001a\u0002002\u0006\u0010k\u001a\u000200J\u0016\u0010l\u001a\u00020\"2\f\u0010m\u001a\b\u0012\u0004\u0012\u0002000nH\u0007J\u0016\u0010o\u001a\u00020\"2\u0006\u0010p\u001a\u0002002\u0006\u0010q\u001a\u000205J\u0016\u0010r\u001a\u00020\"2\u0006\u0010p\u001a\u0002002\u0006\u0010=\u001a\u00020>J\b\u0010s\u001a\u00020\"H\u0002J\u000e\u0010t\u001a\u00020\"2\u0006\u0010u\u001a\u00020\u0007J\u000e\u0010v\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010w\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006}"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;)V", "roundRect", "", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;Z)V", "(Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;Z)V", "weakView", "Ljava/lang/ref/WeakReference;", "getView", "()Landroid/view/View;", "lightControl", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl;", "animationManager", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationManager;", "colorControl", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradControl;", "colorConfig", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor;", "colorState", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;", "touchHandler", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/TouchInteractionHandler;", "isRunning", "isAnimationOff", "()Z", Constants.IntentExtraValue.SHOW, "", "animationType", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$ShowAnimationType;", "customDuration", "", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$ShowAnimationType;Ljava/lang/Long;)V", "hide", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$HideAnimationType;", "stopControls", "setLightMovement", "movement", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;", "setInsetPixel", "inset", "", "point", "Landroid/graphics/Point;", "setCornerRadiusPixel", "cornerRadius", "", "applyPattern", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$CornerRadiusSide;", "getMaxCornerRadius", "default", "setCircleRadius", "radius", "setPosition", "position", "Landroid/graphics/PointF;", "setLightPositionInView", "setLightPositionInScreen", "setScreenPosition", "screenPos", "screenToViewNormal", "setLightIntensity", "intensity", "setLightMap", "lightMap", "Landroid/graphics/Bitmap;", "clearLightMap", "setLightRadius", "setGlobalLuminance", "globalLuminance", "setRefLightIntensity", "setRefLightRadius", "setRefLightAlbedo", "albedo", "setGlowIntensity", "setGlowRadius", "setGlowSharpness", "sharpness", "setDefaultTouchInteraction", "isEnable", "setColorState", "state", "setLightXYFlip", "isFlipped", "setDitherVariation", "ditherVariation", "setSaturation", "saturation", "setOuterSaturation", "outerSaturation", "setStretch", "stretch", "setStretchDirLit", "stretchDirLit", "setOutlineThickness", "outlineThickness", "setBoundarySmoothWidth", "boundarySmoothWidth", "setLightColor", "index", "color", "setLightColors", "colors", "", "setSpotScale", "spotIndex", WiggleAnimationConfig.KEY_SCALE, "setSpotPosition", "rebuildColorControl", "setConfig", "newConfig", "remove", "release", "Companion", "Movement", "ShowAnimationType", "HideAnimationType", "CornerRadiusSide", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGuidingLightEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuidingLightEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,698:1\n254#2:699\n1872#3,3:700\n*S KotlinDebug\n*F\n+ 1 GuidingLightEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect\n*L\n144#1:699\n592#1:700,3\n*E\n"})
public final class GuidingLightEffect {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float MAX_OUTER_LINE_THICKNESS = 80.0f;
    private static final float MIN_CORNER_RADIUS = 2.0f;
    private static final float MIN_OUTER_LINE_THICKNESS = 2.0f;

    @NotNull
    private static final String TAG = "GuidingLightEffect";

    @NotNull
    private AnimationManager animationManager;

    @NotNull
    private PresetEffectColor colorConfig;

    @NotNull
    private RadialGradControl colorControl;

    @NotNull
    private PresetEffectColor.State colorState;

    @NotNull
    private final GuidingLightConfig config;

    @NotNull
    private final Context context;
    private boolean isRunning;

    @NotNull
    private GuidingLightControl lightControl;

    @NotNull
    private TouchInteractionHandler touchHandler;

    @NotNull
    private final WeakReference<View> weakView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MIN_CORNER_RADIUS", "", "MIN_OUTER_LINE_THICKNESS", "MAX_OUTER_LINE_THICKNESS", "create", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "view", "Landroid/view/View;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "roundRect", "", "create$sesl_visualeffect_INTERNAL_2_1_10_release", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GuidingLightEffect create$sesl_visualeffect_INTERNAL_2_1_10_release$default(Companion companion, View view, GuidingLightConfig guidingLightConfig, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                guidingLightConfig = GuidingLightConfig.BUTTON_LIGHT;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.create$sesl_visualeffect_INTERNAL_2_1_10_release(view, guidingLightConfig, z);
        }

        @Deprecated(message = "Use the primary constructor instead", replaceWith = @ReplaceWith(expression = "GuidingLightEffect(view.context, view, config)", imports = {}))
        @JvmStatic
        @NotNull
        public final GuidingLightEffect create$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull View view, @NotNull GuidingLightConfig config, boolean roundRect) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(config, "config");
            GuidingLightConfig guidingLightConfigCopy$default = GuidingLightConfig.copy$default(config, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
            guidingLightConfigCopy$default.setShape(roundRect ? GuidingLightConfig.Shape.RoundRect : GuidingLightConfig.Shape.Circle);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return new GuidingLightEffect(context, view, guidingLightConfigCopy$default);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$CornerRadiusSide;", "", "<init>", "(Ljava/lang/String;I)V", AbstractBottomUpParser.TOP_NODE, "BOTTOM", "LEFT", "RIGHT", "ALL", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CornerRadiusSide {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CornerRadiusSide[] $VALUES;
        public static final CornerRadiusSide TOP = new CornerRadiusSide(AbstractBottomUpParser.TOP_NODE, 0);
        public static final CornerRadiusSide BOTTOM = new CornerRadiusSide("BOTTOM", 1);
        public static final CornerRadiusSide LEFT = new CornerRadiusSide("LEFT", 2);
        public static final CornerRadiusSide RIGHT = new CornerRadiusSide("RIGHT", 3);
        public static final CornerRadiusSide ALL = new CornerRadiusSide("ALL", 4);

        private static final /* synthetic */ CornerRadiusSide[] $values() {
            return new CornerRadiusSide[]{TOP, BOTTOM, LEFT, RIGHT, ALL};
        }

        static {
            CornerRadiusSide[] cornerRadiusSideArr$values = $values();
            $VALUES = cornerRadiusSideArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(cornerRadiusSideArr$values);
        }

        private CornerRadiusSide(String str, int i) {
        }

        @NotNull
        public static EnumEntries<CornerRadiusSide> getEntries() {
            return $ENTRIES;
        }

        public static CornerRadiusSide valueOf(String str) {
            return (CornerRadiusSide) Enum.valueOf(CornerRadiusSide.class, str);
        }

        public static CornerRadiusSide[] values() {
            return (CornerRadiusSide[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$HideAnimationType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "LUMINANCE", "LUMINANCE_LONG", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class HideAnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HideAnimationType[] $VALUES;
        public static final HideAnimationType NONE = new HideAnimationType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final HideAnimationType LUMINANCE = new HideAnimationType("LUMINANCE", 1);
        public static final HideAnimationType LUMINANCE_LONG = new HideAnimationType("LUMINANCE_LONG", 2);

        private static final /* synthetic */ HideAnimationType[] $values() {
            return new HideAnimationType[]{NONE, LUMINANCE, LUMINANCE_LONG};
        }

        static {
            HideAnimationType[] hideAnimationTypeArr$values = $values();
            $VALUES = hideAnimationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hideAnimationTypeArr$values);
        }

        private HideAnimationType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<HideAnimationType> getEntries() {
            return $ENTRIES;
        }

        public static HideAnimationType valueOf(String str) {
            return (HideAnimationType) Enum.valueOf(HideAnimationType.class, str);
        }

        public static HideAnimationType[] values() {
            return (HideAnimationType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "DEFAULT", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Movement {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Movement[] $VALUES;
        public static final Movement NONE = new Movement(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final Movement DEFAULT = new Movement("DEFAULT", 1);

        private static final /* synthetic */ Movement[] $values() {
            return new Movement[]{NONE, DEFAULT};
        }

        static {
            Movement[] movementArr$values = $values();
            $VALUES = movementArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(movementArr$values);
        }

        private Movement(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Movement> getEntries() {
            return $ENTRIES;
        }

        public static Movement valueOf(String str) {
            return (Movement) Enum.valueOf(Movement.class, str);
        }

        public static Movement[] values() {
            return (Movement[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$ShowAnimationType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "SIZE", "LUMINANCE", "LUMINANCE_LONG", "NOW_BAR", "NOW_BAR_SHORTCUT", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ShowAnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ShowAnimationType[] $VALUES;
        public static final ShowAnimationType NONE = new ShowAnimationType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final ShowAnimationType SIZE = new ShowAnimationType("SIZE", 1);
        public static final ShowAnimationType LUMINANCE = new ShowAnimationType("LUMINANCE", 2);
        public static final ShowAnimationType LUMINANCE_LONG = new ShowAnimationType("LUMINANCE_LONG", 3);
        public static final ShowAnimationType NOW_BAR = new ShowAnimationType("NOW_BAR", 4);
        public static final ShowAnimationType NOW_BAR_SHORTCUT = new ShowAnimationType("NOW_BAR_SHORTCUT", 5);

        private static final /* synthetic */ ShowAnimationType[] $values() {
            return new ShowAnimationType[]{NONE, SIZE, LUMINANCE, LUMINANCE_LONG, NOW_BAR, NOW_BAR_SHORTCUT};
        }

        static {
            ShowAnimationType[] showAnimationTypeArr$values = $values();
            $VALUES = showAnimationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(showAnimationTypeArr$values);
        }

        private ShowAnimationType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ShowAnimationType> getEntries() {
            return $ENTRIES;
        }

        public static ShowAnimationType valueOf(String str) {
            return (ShowAnimationType) Enum.valueOf(ShowAnimationType.class, str);
        }

        public static ShowAnimationType[] values() {
            return (ShowAnimationType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CornerRadiusSide.values().length];
            try {
                iArr[CornerRadiusSide.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CornerRadiusSide.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CornerRadiusSide.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CornerRadiusSide.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CornerRadiusSide.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GuidingLightEffect(@NotNull Context context, @NotNull View view, @NotNull GuidingLightConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.weakView = new WeakReference<>(view);
        this.colorState = config.getColorState();
        if (Build.VERSION.SDK_INT >= 35) {
            view.setRequestedFrameRate(-3.0f);
        }
        Log.i(TAG, "Create effect, version: 2.1.10 config:" + config);
        int width = view.getWidth();
        int height = view.getHeight();
        boolean zIsClickable = view.isClickable();
        boolean z = view.getVisibility() == 0;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "View size: ", "x", " clickable: ");
        sbM1173s.append(zIsClickable);
        sbM1173s.append(" visible: ");
        sbM1173s.append(z);
        Log.i(TAG, sbM1173s.toString());
        GuidingLightControl guidingLightControl = new GuidingLightControl(config);
        this.lightControl = guidingLightControl;
        guidingLightControl.add(view);
        PresetEffectColor presetEffectColor = new PresetEffectColor(this.colorState);
        this.colorConfig = presetEffectColor;
        RadialGradControl radialGradControlBuild = presetEffectColor.build(context, config);
        this.colorControl = radialGradControlBuild;
        this.lightControl.setColorEffect(radialGradControlBuild);
        this.animationManager = new AnimationManager(config, this.lightControl);
        this.touchHandler = new TouchInteractionHandler(view, this.lightControl.getRenderEffect(), config);
        stopControls();
    }

    private final float getMaxCornerRadius(float f) {
        View view = getView();
        if (view == null) {
            return 0.0f;
        }
        return (view.getWidth() == 0 || view.getHeight() == 0) ? f : RangesKt.coerceAtMost(view.getWidth() / 2.0f, view.getHeight() / 2.0f);
    }

    private final View getView() {
        return this.weakView.get();
    }

    public static /* synthetic */ void hide$default(GuidingLightEffect guidingLightEffect, HideAnimationType hideAnimationType, int i, Object obj) {
        if ((i & 1) != 0) {
            hideAnimationType = HideAnimationType.NONE;
        }
        guidingLightEffect.hide(hideAnimationType);
    }

    private final boolean isAnimationOff() {
        DeviceSettingsUtil.Companion companion = DeviceSettingsUtil.INSTANCE;
        return companion.isBlockedByReduceAnimations(this.context) || companion.isBlockedByAnimatorDurationScale(this.context);
    }

    private final void rebuildColorControl() {
        Log.i(TAG, "rebuildColorControl");
        boolean zIsRunning = this.colorConfig.isRunning();
        this.colorControl.pause(false);
        RadialGradControl radialGradControlBuild = this.colorConfig.build(this.context, this.config);
        this.colorControl = radialGradControlBuild;
        this.lightControl.setColorEffect(radialGradControlBuild);
        if (zIsRunning && this.config.getLightMovement() == Movement.DEFAULT && !isAnimationOff()) {
            this.colorControl.start();
        }
    }

    private final PointF screenToViewNormal(View view, PointF screenPos) {
        view.getLocationOnScreen(new int[2]);
        Point point = new Point((int) (screenPos.x - r0[0]), (int) (screenPos.y - r0[1]));
        return new PointF(point.x / view.getWidth(), point.y / view.getHeight());
    }

    public static /* synthetic */ void setCornerRadiusPixel$default(GuidingLightEffect guidingLightEffect, float f, CornerRadiusSide cornerRadiusSide, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRadiusSide = CornerRadiusSide.ALL;
        }
        guidingLightEffect.setCornerRadiusPixel(f, cornerRadiusSide);
    }

    private final void setScreenPosition(PointF screenPos) {
        View view = getView();
        if (view != null) {
            setLightPositionInView(screenToViewNormal(view, screenPos));
        }
    }

    public static /* synthetic */ void show$default(GuidingLightEffect guidingLightEffect, ShowAnimationType showAnimationType, int i, Object obj) {
        if ((i & 1) != 0) {
            showAnimationType = ShowAnimationType.NONE;
        }
        guidingLightEffect.show(showAnimationType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(final ShowAnimationType showAnimationType, final GuidingLightEffect guidingLightEffect, Long l) {
        Log.i(TAG, "Show Guiding Light Effect: " + showAnimationType);
        guidingLightEffect.lightControl.start();
        if (guidingLightEffect.config.getLightMovement() == Movement.DEFAULT && !guidingLightEffect.isAnimationOff()) {
            guidingLightEffect.colorControl.start();
        }
        guidingLightEffect.animationManager.showWithAnimation(showAnimationType, l, new AnimationManager.AnimationCallback() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect$show$1$1
            @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
            public void onAnimationCancel() {
            }

            @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
            public void onAnimationEnd() {
                if (showAnimationType == GuidingLightEffect.ShowAnimationType.NOW_BAR_SHORTCUT) {
                    guidingLightEffect.stopControls();
                }
            }

            @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
            public void onAnimationStart() {
            }
        });
        guidingLightEffect.isRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopControls() {
        this.lightControl.stop();
        this.colorControl.pause(false);
    }

    public final void clearLightMap() {
        setLightMap(null);
    }

    public final void hide(@NotNull HideAnimationType animationType) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        Log.i(TAG, "Hide Guiding Light Effect: " + animationType);
        if (this.isRunning) {
            this.animationManager.hideWithAnimation(animationType, new AnimationManager.AnimationCallback() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect.hide.1
                @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
                public void onAnimationCancel() {
                }

                @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
                public void onAnimationEnd() {
                    GuidingLightEffect.this.stopControls();
                }

                @Override // com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager.AnimationCallback
                public void onAnimationStart() {
                }
            });
            if (animationType == HideAnimationType.NONE) {
                stopControls();
            }
            this.isRunning = false;
        }
    }

    public final void release() {
        Log.i(TAG, "release");
        stopControls();
        this.animationManager.release();
        this.touchHandler.destroy();
        this.colorConfig.destroy();
        this.lightControl.destroy();
        this.colorControl.destroy();
    }

    public final void remove(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "remove view: " + view);
        this.lightControl.remove(view);
        this.colorControl.remove(view);
    }

    public final void setBoundarySmoothWidth(float boundarySmoothWidth) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setBoundarySmoothWidth(boundarySmoothWidth);
        }
        this.config.setBoundarySmoothWidth(boundarySmoothWidth);
    }

    public final void setCircleRadius(float radius) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setCircleRadius(radius);
        }
    }

    @Deprecated(message = "Use GuidingLightConfig.colorState at creation time instead of changing color state at runtime", replaceWith = @ReplaceWith(expression = "GuidingLightConfig(colorState = state)", imports = {}))
    public final void setColorState(@NotNull PresetEffectColor.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Log.w(TAG, "setColorState is deprecated: " + state);
        if (this.colorState == state) {
            return;
        }
        this.colorState = state;
        this.config.setColorState(state);
        this.colorConfig.startAnimationByState(this.colorState);
    }

    public final void setConfig(@NotNull GuidingLightConfig newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Log.i(TAG, "setConfig: " + newConfig);
        this.config.setShape(newConfig.getShape());
        this.config.setColorState(newConfig.getColorState());
        this.config.setLightBaseColor(newConfig.getLightBaseColor());
        this.config.setLightPos(newConfig.getLightPos());
        this.config.setLightRadius(newConfig.getLightRadius());
        this.config.setLightIntensity(newConfig.getLightIntensity());
        this.config.setGlowIntensity(newConfig.getGlowIntensity());
        this.config.setGlowRadius(newConfig.getGlowRadius());
        this.config.setGlowSharpness(newConfig.getGlowSharpness());
        this.config.setReflLightIntensity(newConfig.getReflLightIntensity());
        this.config.setReflLightRadius(newConfig.getReflLightRadius());
        this.config.setReflAlbedo(newConfig.getReflAlbedo());
        this.config.setGlobalLuminance(newConfig.getGlobalLuminance());
        this.config.setDitherVariation(newConfig.getDitherVariation());
        this.config.setSaturation(newConfig.getSaturation());
        this.config.setOuterSaturation(newConfig.getOuterSaturation());
        this.config.setStretch(newConfig.getStretch());
        this.config.setStretchDirLit(newConfig.getStretchDirLit());
        this.config.setInitialViewAlpha(newConfig.getInitialViewAlpha());
        this.config.setLightMovement(newConfig.getLightMovement());
        this.config.setFrameRate(newConfig.getFrameRate());
        this.config.setOutlineThickness(newConfig.getOutlineThickness());
        this.config.setBoundarySmoothWidth(newConfig.getBoundarySmoothWidth());
        this.config.setShaderPrecision(newConfig.getShaderPrecision());
        this.config.setLightMovementInterval(newConfig.getLightMovementInterval());
        if (this.colorState != newConfig.getColorState()) {
            setColorState(newConfig.getColorState());
        }
        this.lightControl.applyConfig(this.config);
    }

    public final void setCornerRadiusPixel(float cornerRadius, @NotNull CornerRadiusSide applyPattern) {
        Intrinsics.checkNotNullParameter(applyPattern, "applyPattern");
        int i = WhenMappings.$EnumSwitchMapping$0[applyPattern.ordinal()];
        if (i == 1) {
            GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
            if (renderEffect != null) {
                renderEffect.setRoundRectDirection(GuidingLightConfig.RoundRectDirection.f5272UP.getVector());
            }
        } else if (i == 2) {
            GuidingLightRenderEffect renderEffect2 = this.lightControl.getRenderEffect();
            if (renderEffect2 != null) {
                renderEffect2.setRoundRectDirection(GuidingLightConfig.RoundRectDirection.DOWN.getVector());
            }
        } else if (i == 3) {
            GuidingLightRenderEffect renderEffect3 = this.lightControl.getRenderEffect();
            if (renderEffect3 != null) {
                renderEffect3.setRoundRectDirection(GuidingLightConfig.RoundRectDirection.LEFT.getVector());
            }
        } else if (i == 4) {
            GuidingLightRenderEffect renderEffect4 = this.lightControl.getRenderEffect();
            if (renderEffect4 != null) {
                renderEffect4.setRoundRectDirection(GuidingLightConfig.RoundRectDirection.RIGHT.getVector());
            }
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            GuidingLightRenderEffect renderEffect5 = this.lightControl.getRenderEffect();
            if (renderEffect5 != null) {
                renderEffect5.setRoundRectDirection(GuidingLightConfig.RoundRectDirection.ALL.getVector());
            }
        }
        if (applyPattern != CornerRadiusSide.ALL) {
            setBoundarySmoothWidth(0.0f);
        }
        setCornerRadiusPixel(cornerRadius);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setDefaultTouchInteraction(boolean isEnable) {
        this.touchHandler.setDefaultTouchInteraction(isEnable);
    }

    public final void setDitherVariation(float ditherVariation) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setDitherVariation(ditherVariation);
        }
    }

    public final void setGlobalLuminance(float globalLuminance) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlobalLuminance(globalLuminance);
        }
        this.config.setGlobalLuminance(globalLuminance);
    }

    public final void setGlowIntensity(float intensity) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlowIntensity(intensity);
        }
        this.config.setGlowIntensity(intensity);
    }

    public final void setGlowRadius(float radius) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlowRadius(radius);
        }
        this.config.setGlowRadius(radius);
    }

    public final void setGlowSharpness(float sharpness) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setGlowSharpness(sharpness);
        }
    }

    public final void setInsetPixel(int inset) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setBorderWidth(new Point(inset, inset));
        }
    }

    public final void setLightColor(int index, int color) {
        Log.i(TAG, AbstractC0622a.m1164j(index, color, "setLightColor(", SQLKeyword.COMMA, ")"));
        if (index < 0 || index >= 4) {
            throw new IllegalArgumentException("Color index must be between 0 and 3");
        }
        this.colorConfig.setSpotColor(index, color);
        int iUserToRenderIndex = SpotIndexManager.INSTANCE.userToRenderIndex(index);
        RadialGradRenderEffect renderEffect = this.colorControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setSpotColor(iUserToRenderIndex, color);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC4539a.m3209s(AbstractC0622a.m1173s(index, iUserToRenderIndex, "setLightColor (user:", " -> render:", SQLKeyword.COMMA), AbstractC2322a.m1624n("%08X", new Object[]{Integer.valueOf(color)}, 1, "format(...)"), ")", TAG);
    }

    @Deprecated(message = "Use Builder pattern to set initial spot colors. Runtime color changes are not recommended for performance.")
    public final void setLightColors(@NotNull List<Integer> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (colors.isEmpty()) {
            throw new IllegalArgumentException("At least one color should be provided");
        }
        if (colors.size() > 4) {
            throw new IllegalArgumentException("Maximum four colors can be provided");
        }
        int i = 0;
        for (Object obj : colors) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            setLightColor(i, ((Number) obj).intValue());
            i = i2;
        }
    }

    public final void setLightIntensity(float intensity) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightIntensity(intensity);
        }
        this.config.setLightIntensity(intensity);
        this.touchHandler.updateBaseIntensity(intensity);
    }

    public final void setLightMap(@Nullable Bitmap lightMap) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        GuidingLightRenderEffect guidingLightRenderEffect = renderEffect instanceof GuidingLightRenderEffect ? renderEffect : null;
        if (guidingLightRenderEffect != null) {
            guidingLightRenderEffect.setLightmap(lightMap);
            guidingLightRenderEffect.setLightmapGlow(lightMap);
        }
    }

    public final void setLightMovement(@NotNull Movement movement) {
        Intrinsics.checkNotNullParameter(movement, "movement");
        Log.i(TAG, "setLightMovement: " + movement + ", isRunning: " + this.isRunning);
        this.config.setLightMovement(movement);
        if (movement == Movement.NONE) {
            this.colorControl.pause(false);
            Log.i(TAG, "Light movement disabled - colorControl paused");
        } else {
            if (!this.isRunning || isAnimationOff()) {
                return;
            }
            this.colorControl.start();
            Log.i(TAG, "Light movement enabled - colorControl started");
        }
    }

    public final void setLightPositionInScreen(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        Log.i(TAG, "setScreenPosition: " + position);
        setScreenPosition(position);
    }

    public final void setLightPositionInView(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        Log.i(TAG, "setLightPositionInView: " + position);
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightPos(position);
        }
    }

    public final void setLightRadius(float radius) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightRadius(radius);
        }
    }

    public final void setLightXYFlip(boolean isFlipped) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintFlipX(isFlipped);
        }
    }

    public final void setOuterSaturation(float outerSaturation) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setOuterSaturation(outerSaturation);
        }
    }

    public final void setOutlineThickness(float outlineThickness) {
        Log.w(TAG, "setOutlineThickness: " + outlineThickness);
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setOutlineThickness(MathUtils.clamp(outlineThickness, 2.0f, MAX_OUTER_LINE_THICKNESS));
        }
    }

    @Deprecated(message = "Use setLightPositionInView instead")
    public final void setPosition(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightPos(position);
        }
    }

    public final void setRefLightAlbedo(float albedo) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setReflAlbedo(albedo);
        }
    }

    public final void setRefLightIntensity(float intensity) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setReflLightIntensity(intensity);
        }
    }

    public final void setRefLightRadius(float radius) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setReflLightRadius(radius);
        }
    }

    public final void setSaturation(float saturation) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setSaturation(saturation);
        }
    }

    public final void setSpotPosition(int spotIndex, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.colorConfig.setSpotPosition(spotIndex, position);
        rebuildColorControl();
        Log.i(TAG, "setSpotPosition (" + spotIndex + SQLKeyword.COMMA + position + ")");
    }

    public final void setSpotScale(int spotIndex, float scale) {
        this.colorConfig.setSpotScale(spotIndex, scale);
        rebuildColorControl();
        Log.i(TAG, "setSpotScale (" + spotIndex + SQLKeyword.COMMA + scale + ")");
    }

    public final void setStretch(float stretch) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setStretch(stretch);
        }
    }

    public final void setStretchDirLit(float stretchDirLit) {
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setStretchDirLit(stretchDirLit);
        }
    }

    public final void show(@NotNull ShowAnimationType animationType) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        show(animationType, null);
    }

    public static /* synthetic */ void show$default(GuidingLightEffect guidingLightEffect, ShowAnimationType showAnimationType, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            showAnimationType = ShowAnimationType.NONE;
        }
        if ((i & 2) != 0) {
            l = null;
        }
        guidingLightEffect.show(showAnimationType, l);
    }

    public final void setInsetPixel(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setBorderWidth(point);
        }
    }

    public final void show(@NotNull ShowAnimationType animationType, @Nullable Long customDuration) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        View view = getView();
        if (view != null) {
            view.post(new RunnableC0201c(animationType, 19, this, customDuration));
        }
    }

    public final void setCornerRadiusPixel(float cornerRadius) {
        float fClamp = MathUtils.clamp(cornerRadius, 2.0f, getMaxCornerRadius(cornerRadius));
        AbstractC4539a.m3205o("setCornerRadiusPixel: ", TAG, fClamp);
        GuidingLightRenderEffect renderEffect = this.lightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setViewCornerRadius(fClamp);
        }
    }

    public /* synthetic */ GuidingLightEffect(Context context, View view, GuidingLightConfig guidingLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, view, (i & 4) != 0 ? GuidingLightConfig.BUTTON_LIGHT : guidingLightConfig);
    }

    public /* synthetic */ GuidingLightEffect(Context context, View view, GuidingLightConfig guidingLightConfig, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, view, (i & 4) != 0 ? GuidingLightConfig.BUTTON_LIGHT : guidingLightConfig, (i & 8) != 0 ? true : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "Use the primary constructor instead.", replaceWith = @ReplaceWith(expression = "GuidingLightEffect(context, view, config)", imports = {}))
    public GuidingLightEffect(@NotNull Context context, @NotNull View view, @NotNull GuidingLightConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        GuidingLightConfig guidingLightConfigCopy$default = GuidingLightConfig.copy$default(config, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default.setShape(z ? GuidingLightConfig.Shape.RoundRect : GuidingLightConfig.Shape.Circle);
        Unit unit = Unit.INSTANCE;
        this(context, view, guidingLightConfigCopy$default);
    }

    public /* synthetic */ GuidingLightEffect(View view, GuidingLightConfig guidingLightConfig, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? GuidingLightConfig.BUTTON_LIGHT : guidingLightConfig, (i & 4) != 0 ? true : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "Use the primary constructor instead.", replaceWith = @ReplaceWith(expression = "GuidingLightEffect(view.context, view, config)", imports = {}))
    public GuidingLightEffect(@NotNull View view, @NotNull GuidingLightConfig config, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GuidingLightConfig guidingLightConfigCopy$default = GuidingLightConfig.copy$default(config, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default.setShape(z ? GuidingLightConfig.Shape.RoundRect : GuidingLightConfig.Shape.Circle);
        Unit unit = Unit.INSTANCE;
        this(context, view, guidingLightConfigCopy$default);
    }
}
