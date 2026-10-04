package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sesl.visualeffect.C7843R;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p097Y0.C0344a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 22\u00020\u0001:\u0003234B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0019J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\b\b\u0001\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000fJ\u0018\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\tj\b\u0012\u0004\u0012\u00020\u000f`\u000bH\u0002J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0003J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(H\u0002J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120*H\u0002J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100*H\u0002J\u0016\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0019R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor;", "", "initialState", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;", "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;)V", "control", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradControl;", "colorAnims", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "state", "currentSpotScales", "", "", "", "currentSpotPositions", "Landroid/graphics/PointF;", "currentSpotColors", "value", "", "isRunning", "()Z", "setSpotScale", "", "spotIndex", WiggleAnimationConfig.KEY_SCALE, "setSpotPosition", "position", "resetSpotConfigs", "setSpotColor", "color", "getSpotColor", "getSpotScale", "getSpotPosition", "getCurrentColors", "startAnimationByState", "newState", "getColorsInRenderOrder", "", "getPositionsInRenderOrder", "", "getScalesInRenderOrder", "build", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "lightConfig", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "destroy", "Companion", "SpotState", "State", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPresetEffectColor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PresetEffectColor.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,470:1\n1#2:471\n1872#3,3:472\n1863#3,2:475\n1863#3,2:477\n1557#3:479\n1628#3,3:480\n1279#3,2:483\n1293#3,4:485\n1279#3,2:489\n1293#3,4:491\n1863#3,2:495\n*S KotlinDebug\n*F\n+ 1 PresetEffectColor.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor\n*L\n328#1:472,3\n380#1:475,2\n408#1:477,2\n416#1:479\n416#1:480,3\n424#1:483,2\n424#1:485,4\n434#1:489,2\n434#1:491,4\n465#1:495,2\n*E\n"})
public final class PresetEffectColor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Bitmap radialMap;

    @NotNull
    private ArrayList<ValueAnimator> colorAnims;

    @Nullable
    private RadialGradControl control;

    @NotNull
    private Map<Integer, Integer> currentSpotColors;

    @NotNull
    private Map<Integer, PointF> currentSpotPositions;

    @NotNull
    private Map<Integer, Float> currentSpotScales;
    private boolean isRunning;

    @NotNull
    private State state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$Companion;", "", "<init>", "()V", "radialMap", "Landroid/graphics/Bitmap;", "getRadialMap$sesl_visualeffect_INTERNAL_2_1_10_release", "()Landroid/graphics/Bitmap;", "setRadialMap$sesl_visualeffect_INTERNAL_2_1_10_release", "(Landroid/graphics/Bitmap;)V", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Bitmap getRadialMap$sesl_visualeffect_INTERNAL_2_1_10_release() {
            return PresetEffectColor.radialMap;
        }

        public final void setRadialMap$sesl_visualeffect_INTERNAL_2_1_10_release(@Nullable Bitmap bitmap) {
            PresetEffectColor.radialMap = bitmap;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$SpotState;", "", "color", "", WiggleAnimationConfig.KEY_SCALE, "", "position", "Landroid/graphics/PointF;", "<init>", "(IFLandroid/graphics/PointF;)V", "getColor", "()I", "getScale", "()F", "getPosition", "()Landroid/graphics/PointF;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class SpotState {
        private final int color;

        @NotNull
        private final PointF position;
        private final float scale;

        public SpotState(@ColorInt int i, float f, @NotNull PointF position) {
            Intrinsics.checkNotNullParameter(position, "position");
            this.color = i;
            this.scale = f;
            this.position = position;
        }

        public static /* synthetic */ SpotState copy$default(SpotState spotState, int i, float f, PointF pointF, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = spotState.color;
            }
            if ((i2 & 2) != 0) {
                f = spotState.scale;
            }
            if ((i2 & 4) != 0) {
                pointF = spotState.position;
            }
            return spotState.copy(i, f, pointF);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getScale() {
            return this.scale;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PointF getPosition() {
            return this.position;
        }

        @NotNull
        public final SpotState copy(@ColorInt int color, float scale, @NotNull PointF position) {
            Intrinsics.checkNotNullParameter(position, "position");
            return new SpotState(color, scale, position);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpotState)) {
                return false;
            }
            SpotState spotState = (SpotState) other;
            return this.color == spotState.color && Float.compare(this.scale, spotState.scale) == 0 && Intrinsics.areEqual(this.position, spotState.position);
        }

        public final int getColor() {
            return this.color;
        }

        @NotNull
        public final PointF getPosition() {
            return this.position;
        }

        public final float getScale() {
            return this.scale;
        }

        public int hashCode() {
            return this.position.hashCode() + AbstractC0622a.m1156b(this.scale, Integer.hashCode(this.color) * 31, 31);
        }

        @NotNull
        public String toString() {
            int i = this.color;
            float f = this.scale;
            PointF pointF = this.position;
            StringBuilder sbM1628r = AbstractC2322a.m1628r("SpotState(color=", i, ", scale=", f, ", position=");
            sbM1628r.append(pointF);
            sbM1628r.append(")");
            return sbM1628r.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;", "", "spots", "", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$SpotState;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getSpots", "()Ljava/util/List;", CommonConstants.SERVICE_NAME_COMMON, "Input", "Processing", "Mono", "Button", "Action", "Result", "Processing85", "Nudge", "NudgeAutomation", "colors", "", "getColors", "scales", "", "getScales", "positions", "Landroid/graphics/PointF;", "getPositions", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPresetEffectColor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PresetEffectColor.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,470:1\n1557#2:471\n1628#2,3:472\n1557#2:475\n1628#2,3:476\n1557#2:479\n1628#2,3:480\n1567#2:483\n1598#2,4:484\n470#3:488\n470#3:489\n470#3:490\n470#3:491\n470#3:492\n470#3:493\n470#3:494\n470#3:495\n470#3:496\n470#3:497\n470#3:498\n470#3:499\n470#3:500\n470#3:501\n470#3:502\n470#3:503\n470#3:504\n470#3:505\n470#3:506\n470#3:507\n*S KotlinDebug\n*F\n+ 1 PresetEffectColor.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State\n*L\n279#1:471\n279#1:472,3\n282#1:475\n282#1:476,3\n285#1:479\n285#1:480,3\n288#1:483\n288#1:484,4\n136#1:488\n141#1:489\n146#1:490\n151#1:491\n160#1:492\n165#1:493\n170#1:494\n175#1:495\n184#1:496\n189#1:497\n194#1:498\n199#1:499\n232#1:500\n237#1:501\n242#1:502\n247#1:503\n256#1:504\n261#1:505\n266#1:506\n271#1:507\n*E\n"})
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State Action;
        public static final State Button;
        public static final State Common;
        public static final State Input;
        public static final State Mono;
        public static final State Nudge;
        public static final State NudgeAutomation;
        public static final State Processing;
        public static final State Processing85;
        public static final State Result;

        @NotNull
        private final List<SpotState> spots;

        private static final /* synthetic */ State[] $values() {
            return new State[]{Common, Input, Processing, Mono, Button, Action, Result, Processing85, Nudge, NudgeAutomation};
        }

        static {
            Constants constants = Constants.INSTANCE;
            int color_blue = constants.getCOLOR_BLUE();
            Constants.SpotPositions spotPositions = Constants.SpotPositions.INSTANCE;
            Common = new State(CommonConstants.SERVICE_NAME_COMMON, 0, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(color_blue, 2.5f, spotPositions.getPOS_SPOT1()), new SpotState(constants.getCOLOR_LIGHT_BLUE(), 2.25f, spotPositions.getPOS_SPOT2()), new SpotState(constants.getCOLOR_BLUE(), 0.95f, spotPositions.getPOS_SPOT3()), new SpotState(constants.getCOLOR_GREEN(), 2.25f, spotPositions.getPOS_SPOT4())}));
            Input = new State("Input", 1, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(constants.getCOLOR_BLUE(), 2.5f, spotPositions.getPOS_SPOT1()), new SpotState(constants.getCOLOR_LIGHT_BLUE(), 2.25f, spotPositions.getPOS_SPOT2()), new SpotState(constants.getCOLOR_PURPLE(), 0.95f, spotPositions.getPOS_SPOT3()), new SpotState(constants.getCOLOR_GREEN(), 2.25f, spotPositions.getPOS_SPOT4())}));
            Processing = new State("Processing", 2, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(constants.getCOLOR_BLUE(), 2.5f, spotPositions.getPOS_SPOT1()), new SpotState(constants.getCOLOR_LIGHT_BLUE(), 2.25f, spotPositions.getPOS_SPOT2()), new SpotState(constants.getCOLOR_LIGHT_BLUE(), 0.95f, spotPositions.getPOS_SPOT3()), new SpotState(constants.getCOLOR_YELLOW(), 2.25f, spotPositions.getPOS_SPOT4())}));
            Mono = new State("Mono", 3, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(constants.getCOLOR_WHITE(), 2.5f, spotPositions.getPOS_SPOT1()), new SpotState(constants.getCOLOR_WHITE(), 2.25f, spotPositions.getPOS_SPOT2()), new SpotState(constants.getCOLOR_WHITE(), 0.95f, spotPositions.getPOS_SPOT3()), new SpotState(constants.getCOLOR_WHITE(), 2.25f, spotPositions.getPOS_SPOT4())}));
            Button = new State("Button", 4, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(Color.parseColor("#C2B2FF"), 2.71f, new PointF(0.08f, 0.6f)), new SpotState(Color.parseColor("#8BE6CA"), 2.3f, new PointF(1.29f, -0.02f)), new SpotState(Color.parseColor("#8BBDFF"), 1.75f, new PointF(0.49f, 0.01f)), new SpotState(Color.parseColor("#F0F488"), 1.86f, new PointF(1.26f, 1.2f))}));
            Action = new State("Action", 5, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(Color.parseColor("#C2B2FF"), 3.7f, new PointF(0.5f, 0.8f)), new SpotState(Color.parseColor("#88E6E3"), 3.31f, new PointF(1.34f, -0.22f)), new SpotState(Color.parseColor("#8BBDFF"), 2.29f, new PointF(0.1f, -0.14f)), new SpotState(Color.parseColor("#F0F488"), 2.4f, new PointF(1.44f, 0.62f))}));
            Result = new State("Result", 6, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(Color.parseColor("#C2B2FF"), 3.7f, new PointF(0.5f, 0.45f)), new SpotState(Color.parseColor("#BF88E6E3"), 3.15f, new PointF(1.34f, -0.52f)), new SpotState(Color.parseColor("#BF8BBDFF"), 2.24f, new PointF(0.1f, -0.34f)), new SpotState(Color.parseColor("#F0F488"), 2.7f, new PointF(1.54f, 0.72f))}));
            Processing85 = new State("Processing85", 7, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(constants.getCOLOR_LAVENDER_PURPLE(), 3.0f, spotPositions.getPROCESSING_POS_SPOT1()), new SpotState(constants.getCOLOR_LIGHT_BLUE(), 3.31f, spotPositions.getPROCESSING_POS_SPOT2()), new SpotState(constants.getCOLOR_SKY_BLUE(), 2.2f, spotPositions.getPROCESSING_POS_SPOT3()), new SpotState(constants.getCOLOR_SOFT_YELLOW(), 1.7f, spotPositions.getPROCESSING_POS_SPOT4())}));
            Nudge = new State("Nudge", 8, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(Color.parseColor("#C2B2FF"), 1.87f, new PointF(0.08f, 0.62f)), new SpotState(Color.parseColor("#F0F488"), 2.15f, new PointF(1.7f, 1.0f)), new SpotState(Color.parseColor("#8BBDFF"), 1.48f, new PointF(0.55f, 0.65f)), new SpotState(Color.parseColor("#88E6E3"), 1.32f, new PointF(1.17f, 0.49f))}));
            NudgeAutomation = new State("NudgeAutomation", 9, CollectionsKt.listOf((Object[]) new SpotState[]{new SpotState(Color.parseColor("#C2B2FF"), 3.0f, new PointF(0.93f, 0.62f)), new SpotState(Color.parseColor("#FF8D7A"), 2.64f, new PointF(-0.25f, -0.16f)), new SpotState(Color.parseColor("#8BBDFF"), 3.28f, new PointF(0.55f, 0.3f)), new SpotState(Color.parseColor("#88E6E3"), 1.32f, new PointF(1.07f, 0.97f))}));
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }

        private State(String str, int i, List list) {
            this.spots = list;
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        @NotNull
        public final List<Integer> getColors() {
            List<SpotState> list = this.spots;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((SpotState) it.next()).getColor()));
            }
            return arrayList;
        }

        @NotNull
        public final List<PointF> getPositions() {
            List<SpotState> list = this.spots;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((SpotState) it.next()).getPosition());
            }
            return arrayList;
        }

        @NotNull
        public final List<Float> getScales() {
            List<SpotState> list = this.spots;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(((SpotState) it.next()).getScale()));
            }
            return arrayList;
        }

        @NotNull
        public final List<SpotState> getSpots() {
            return this.spots;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() throws IOException {
            List<SpotState> list = this.spots;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SpotState spotState = (SpotState) obj;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strM1624n = AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(spotState.getColor())}, 1, "format(...)");
                float scale = spotState.getScale();
                float f = spotState.getPosition().x;
                float f4 = spotState.getPosition().y;
                StringBuilder sbM1629s = AbstractC2322a.m1629s("Spot", i, "[Color=", strM1624n, ", Scale=");
                AbstractC11014a.m12337v(sbM1629s, scale, ", Position=(", f, SQLKeyword.COMMA);
                sbM1629s.append(f4);
                sbM1629s.append(")]");
                arrayList.add(sbM1629s.toString());
                i = i2;
            }
            return AbstractC2821a.m2221l(name(), "(", CollectionsKt.m13955n(arrayList, SQLKeyword.COMMA, null, null, null, 62), ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PresetEffectColor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final List<Integer> getColorsInRenderOrder() {
        IntRange intRange = new IntRange(0, 3);
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRange));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getSpotColor(((IntIterator) it).nextInt())));
        }
        return SpotIndexManager.INSTANCE.convertToRenderOrder(arrayList);
    }

    private final ArrayList<Integer> getCurrentColors() {
        RadialGradRenderEffect renderEffect;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int iUserToRenderIndex = SpotIndexManager.INSTANCE.userToRenderIndex(i);
            RadialGradControl radialGradControl = this.control;
            Integer numValueOf = (radialGradControl == null || (renderEffect = radialGradControl.getRenderEffect()) == null) ? null : Integer.valueOf(renderEffect.getSpotColor(iUserToRenderIndex));
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    private final Map<Integer, PointF> getPositionsInRenderOrder() {
        IntRange intRange = new IntRange(0, 3);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(intRange)), 16));
        for (Integer num : intRange) {
            int iIntValue = num.intValue();
            PointF pointFCopy = this.currentSpotPositions.get(Integer.valueOf(iIntValue));
            if (pointFCopy == null) {
                pointFCopy = PresetEffectColorKt.copy(this.state.getSpots().get(iIntValue).getPosition());
            }
            linkedHashMap.put(num, pointFCopy);
        }
        return SpotIndexManager.INSTANCE.convertToRenderOrderMap(linkedHashMap);
    }

    private final Map<Integer, Float> getScalesInRenderOrder() {
        IntRange intRange = new IntRange(0, 3);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(intRange)), 16));
        for (Integer num : intRange) {
            int iIntValue = num.intValue();
            Float f = this.currentSpotScales.get(Integer.valueOf(iIntValue));
            linkedHashMap.put(num, Float.valueOf(f != null ? f.floatValue() : this.state.getSpots().get(iIntValue).getScale()));
        }
        return SpotIndexManager.INSTANCE.convertToRenderOrderMap(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAnimationByState$lambda$10$lambda$8(PresetEffectColor presetEffectColor, State state) {
        presetEffectColor.state = state;
        presetEffectColor.resetSpotConfigs();
        return Unit.INSTANCE;
    }

    @NotNull
    public final RadialGradControl build(@NotNull Context appContext, @NotNull GuidingLightConfig lightConfig) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(lightConfig, "lightConfig");
        if (radialMap == null) {
            radialMap = BitmapFactory.decodeResource(appContext.getResources(), C7843R.drawable.lightmap);
        }
        RadialGradControl radialGradControl = new RadialGradControl(new RadialGradConfig(lightConfig.getLightBaseColor().toArgb(), radialMap, Constants.INSTANCE.getBUFFER_SIZE(), 0, 0.0f, AnimationHelper.INSTANCE.buildSpotConfigs(getColorsInRenderOrder(), lightConfig.getFrameRate(), lightConfig.getLightMovementInterval(), getPositionsInRenderOrder(), getScalesInRenderOrder()), 24, null));
        this.control = radialGradControl;
        radialGradControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().addAll(this.colorAnims);
        return radialGradControl;
    }

    public final void destroy() {
        Iterator<T> it = this.colorAnims.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
        this.colorAnims.clear();
        Bitmap bitmap = radialMap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        radialMap = null;
    }

    public final int getSpotColor(int spotIndex) {
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        Integer num = this.currentSpotColors.get(Integer.valueOf(spotIndex));
        return num != null ? num.intValue() : this.state.getSpots().get(spotIndex).getColor();
    }

    @NotNull
    public final PointF getSpotPosition(int spotIndex) {
        PointF pointFCopy;
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        PointF pointF = this.currentSpotPositions.get(Integer.valueOf(spotIndex));
        return (pointF == null || (pointFCopy = PresetEffectColorKt.copy(pointF)) == null) ? PresetEffectColorKt.copy(this.state.getSpots().get(spotIndex).getPosition()) : pointFCopy;
    }

    public final float getSpotScale(int spotIndex) {
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        Float f = this.currentSpotScales.get(Integer.valueOf(spotIndex));
        return f != null ? f.floatValue() : this.state.getSpots().get(spotIndex).getScale();
    }

    public final boolean isRunning() {
        if (this.colorAnims.size() > 0) {
            return this.colorAnims.get(0).isRunning();
        }
        return false;
    }

    public final void resetSpotConfigs() {
        int i = 0;
        for (Object obj : this.state.getSpots()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpotState spotState = (SpotState) obj;
            this.currentSpotScales.put(Integer.valueOf(i), Float.valueOf(spotState.getScale()));
            this.currentSpotPositions.put(Integer.valueOf(i), PresetEffectColorKt.copy(spotState.getPosition()));
            this.currentSpotColors.put(Integer.valueOf(i), Integer.valueOf(spotState.getColor()));
            i = i2;
        }
    }

    public final void setSpotColor(int spotIndex, @ColorInt int color) {
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        this.currentSpotColors.put(Integer.valueOf(spotIndex), Integer.valueOf(color));
    }

    public final void setSpotPosition(int spotIndex, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        this.currentSpotPositions.put(Integer.valueOf(spotIndex), PresetEffectColorKt.copy(position));
    }

    public final void setSpotScale(int spotIndex, float scale) {
        if (spotIndex < 0 || spotIndex >= 4) {
            throw new IllegalArgumentException("Spot index must be between 0 and 3");
        }
        this.currentSpotScales.put(Integer.valueOf(spotIndex), Float.valueOf(scale));
    }

    public final void startAnimationByState(@NotNull State newState) {
        RadialGradRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(newState, "newState");
        RadialGradControl radialGradControl = this.control;
        if (radialGradControl == null || (renderEffect = radialGradControl.getRenderEffect()) == null) {
            return;
        }
        Iterator<T> it = this.colorAnims.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
        this.colorAnims.clear();
        ArrayList<Integer> currentColors = getCurrentColors();
        State state = State.Processing;
        this.colorAnims.addAll(AnimationHelper.INSTANCE.buildColorAnimation(currentColors, SpotIndexManager.INSTANCE.convertToRenderOrder(newState.getColors()), renderEffect, newState == state ? 800L : 1200L, newState == state ? Constants.INSTANCE.getSTATE_CHANGE_INTERPOLATOR_PROCESSING() : Constants.INSTANCE.getSTATE_CHANGE_INTERPOLATOR(), new C0344a(this, newState, 1)));
        Iterator<T> it2 = this.colorAnims.iterator();
        while (it2.hasNext()) {
            ((ValueAnimator) it2.next()).start();
        }
    }

    public PresetEffectColor(@NotNull State initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.colorAnims = new ArrayList<>();
        this.state = initialState;
        this.currentSpotScales = new LinkedHashMap();
        this.currentSpotPositions = new LinkedHashMap();
        this.currentSpotColors = new LinkedHashMap();
        resetSpotConfigs();
    }

    public /* synthetic */ PresetEffectColor(State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? State.Common : state);
    }
}
