package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.Size;
import android.view.animation.PathInterpolator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u000234B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0019X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010,\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R(\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u00102¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/Constants;", "", "<init>", "()V", "COLOR_WHITE", "", "getCOLOR_WHITE", "()I", "COLOR_PURPLE", "getCOLOR_PURPLE", "COLOR_BLUE", "getCOLOR_BLUE", "COLOR_LIGHT_BLUE", "getCOLOR_LIGHT_BLUE", "COLOR_GREEN", "getCOLOR_GREEN", "COLOR_YELLOW", "getCOLOR_YELLOW", "COLOR_LAVENDER_PURPLE", "getCOLOR_LAVENDER_PURPLE", "COLOR_SKY_BLUE", "getCOLOR_SKY_BLUE", "COLOR_SOFT_YELLOW", "getCOLOR_SOFT_YELLOW", "RESULT_ALPHA_RATIO", "", "getRESULT_ALPHA_RATIO", "()F", "WGL_INTERVAL", "", "WGL_SCALE", "WGL_POS", "STATE_CHANGE_DURATION", "STATE_CHANGE_DURATION_PROCESSING", "BUFFER_SIZE", "Landroid/util/Size;", "getBUFFER_SIZE", "()Landroid/util/Size;", "STATE_CHANGE_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "getSTATE_CHANGE_INTERPOLATOR", "()Landroid/view/animation/PathInterpolator;", "STATE_CHANGE_INTERPOLATOR_PROCESSING", "getSTATE_CHANGE_INTERPOLATOR_PROCESSING", "CUBIC_BEZIER_INTERPOLATOR", "getCUBIC_BEZIER_INTERPOLATOR", "COLOR_TO_SPOT_IDX", "", "getCOLOR_TO_SPOT_IDX$annotations", "getCOLOR_TO_SPOT_IDX", "()Ljava/util/Map;", "SpotScales", "SpotPositions", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConstants.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Constants.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/Constants\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,78:1\n470#2:79\n470#2:80\n470#2:81\n470#2:82\n470#2:83\n470#2:84\n470#2:85\n470#2:86\n470#2:87\n*S KotlinDebug\n*F\n+ 1 Constants.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/Constants\n*L\n10#1:79\n11#1:80\n12#1:81\n13#1:82\n14#1:83\n15#1:84\n17#1:85\n18#1:86\n19#1:87\n*E\n"})
public final class Constants {
    public static final long STATE_CHANGE_DURATION = 1200;
    public static final long STATE_CHANGE_DURATION_PROCESSING = 800;
    public static final long WGL_INTERVAL = 1100;
    public static final float WGL_POS = 0.35f;
    public static final float WGL_SCALE = 0.5f;

    @NotNull
    public static final Constants INSTANCE = new Constants();
    private static final int COLOR_WHITE = Color.parseColor("#FFFFFF");
    private static final int COLOR_PURPLE = Color.parseColor("#8F74FF");
    private static final int COLOR_BLUE = Color.parseColor("#3E85FB");
    private static final int COLOR_LIGHT_BLUE = Color.parseColor("#88E6E3");
    private static final int COLOR_GREEN = Color.parseColor("#BDFAA5");
    private static final int COLOR_YELLOW = Color.parseColor("#FFE653");
    private static final int COLOR_LAVENDER_PURPLE = Color.parseColor("#C2B2FF");
    private static final int COLOR_SKY_BLUE = Color.parseColor("#8BBDFF");
    private static final int COLOR_SOFT_YELLOW = Color.parseColor("#FFFFAC");
    private static final float RESULT_ALPHA_RATIO = 0.8f;

    @NotNull
    private static final Size BUFFER_SIZE = new Size(200, 200);

    @NotNull
    private static final PathInterpolator STATE_CHANGE_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    @NotNull
    private static final PathInterpolator STATE_CHANGE_INTERPOLATOR_PROCESSING = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    @NotNull
    private static final PathInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    @NotNull
    private static final Map<Integer, Integer> COLOR_TO_SPOT_IDX = MapsKt.mapOf(TuplesKt.m13893to(0, 0), TuplesKt.m13893to(1, 3), TuplesKt.m13893to(2, 1), TuplesKt.m13893to(3, 2));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/Constants$SpotPositions;", "", "<init>", "()V", "POS_SPOT1", "Landroid/graphics/PointF;", "getPOS_SPOT1", "()Landroid/graphics/PointF;", "POS_SPOT2", "getPOS_SPOT2", "POS_SPOT3", "getPOS_SPOT3", "POS_SPOT4", "getPOS_SPOT4", "PROCESSING_POS_SPOT1", "getPROCESSING_POS_SPOT1", "PROCESSING_POS_SPOT2", "getPROCESSING_POS_SPOT2", "PROCESSING_POS_SPOT3", "getPROCESSING_POS_SPOT3", "PROCESSING_POS_SPOT4", "getPROCESSING_POS_SPOT4", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SpotPositions {

        @NotNull
        public static final SpotPositions INSTANCE = new SpotPositions();

        @NotNull
        private static final PointF POS_SPOT1 = new PointF(0.22f, 0.15f);

        @NotNull
        private static final PointF POS_SPOT2 = new PointF(1.2f, 0.38f);

        @NotNull
        private static final PointF POS_SPOT3 = new PointF(-0.1f, 0.75f);

        @NotNull
        private static final PointF POS_SPOT4 = new PointF(0.72f, 1.32f);

        @NotNull
        private static final PointF PROCESSING_POS_SPOT1 = new PointF(0.28f, 0.77f);

        @NotNull
        private static final PointF PROCESSING_POS_SPOT2 = new PointF(1.39f, -0.27f);

        @NotNull
        private static final PointF PROCESSING_POS_SPOT3 = new PointF(0.1f, -0.09f);

        @NotNull
        private static final PointF PROCESSING_POS_SPOT4 = new PointF(0.9f, 0.62f);

        private SpotPositions() {
        }

        @NotNull
        public final PointF getPOS_SPOT1() {
            return POS_SPOT1;
        }

        @NotNull
        public final PointF getPOS_SPOT2() {
            return POS_SPOT2;
        }

        @NotNull
        public final PointF getPOS_SPOT3() {
            return POS_SPOT3;
        }

        @NotNull
        public final PointF getPOS_SPOT4() {
            return POS_SPOT4;
        }

        @NotNull
        public final PointF getPROCESSING_POS_SPOT1() {
            return PROCESSING_POS_SPOT1;
        }

        @NotNull
        public final PointF getPROCESSING_POS_SPOT2() {
            return PROCESSING_POS_SPOT2;
        }

        @NotNull
        public final PointF getPROCESSING_POS_SPOT3() {
            return PROCESSING_POS_SPOT3;
        }

        @NotNull
        public final PointF getPROCESSING_POS_SPOT4() {
            return PROCESSING_POS_SPOT4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/Constants$SpotScales;", "", "<init>", "()V", "BASE_SCALE_1", "", "BASE_SCALE_SPOT_1", "BASE_SCALE_2", "SCALE_SPOT1", "SCALE_SPOT2", "SCALE_SPOT3", "SCALE_SPOT4", "PROCESSING_SCALE_SPOT1", "PROCESSING_SCALE_SPOT2", "PROCESSING_SCALE_SPOT3", "PROCESSING_SCALE_SPOT4", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SpotScales {
        public static final float BASE_SCALE_1 = 2.25f;
        public static final float BASE_SCALE_2 = 0.95f;
        public static final float BASE_SCALE_SPOT_1 = 2.5f;

        @NotNull
        public static final SpotScales INSTANCE = new SpotScales();
        public static final float PROCESSING_SCALE_SPOT1 = 3.0f;
        public static final float PROCESSING_SCALE_SPOT2 = 3.31f;
        public static final float PROCESSING_SCALE_SPOT3 = 2.2f;
        public static final float PROCESSING_SCALE_SPOT4 = 1.7f;
        public static final float SCALE_SPOT1 = 2.5f;
        public static final float SCALE_SPOT2 = 2.25f;
        public static final float SCALE_SPOT3 = 0.95f;
        public static final float SCALE_SPOT4 = 2.25f;

        private SpotScales() {
        }
    }

    private Constants() {
    }

    @Deprecated(message = "Use SpotIndexManager instead for better encapsulation", replaceWith = @ReplaceWith(expression = "SpotIndexManager.userToRenderIndex()", imports = {}))
    public static /* synthetic */ void getCOLOR_TO_SPOT_IDX$annotations() {
    }

    @NotNull
    public final Size getBUFFER_SIZE() {
        return BUFFER_SIZE;
    }

    public final int getCOLOR_BLUE() {
        return COLOR_BLUE;
    }

    public final int getCOLOR_GREEN() {
        return COLOR_GREEN;
    }

    public final int getCOLOR_LAVENDER_PURPLE() {
        return COLOR_LAVENDER_PURPLE;
    }

    public final int getCOLOR_LIGHT_BLUE() {
        return COLOR_LIGHT_BLUE;
    }

    public final int getCOLOR_PURPLE() {
        return COLOR_PURPLE;
    }

    public final int getCOLOR_SKY_BLUE() {
        return COLOR_SKY_BLUE;
    }

    public final int getCOLOR_SOFT_YELLOW() {
        return COLOR_SOFT_YELLOW;
    }

    @NotNull
    public final Map<Integer, Integer> getCOLOR_TO_SPOT_IDX() {
        return COLOR_TO_SPOT_IDX;
    }

    public final int getCOLOR_WHITE() {
        return COLOR_WHITE;
    }

    public final int getCOLOR_YELLOW() {
        return COLOR_YELLOW;
    }

    @NotNull
    public final PathInterpolator getCUBIC_BEZIER_INTERPOLATOR() {
        return CUBIC_BEZIER_INTERPOLATOR;
    }

    public final float getRESULT_ALPHA_RATIO() {
        return RESULT_ALPHA_RATIO;
    }

    @NotNull
    public final PathInterpolator getSTATE_CHANGE_INTERPOLATOR() {
        return STATE_CHANGE_INTERPOLATOR;
    }

    @NotNull
    public final PathInterpolator getSTATE_CHANGE_INTERPOLATOR_PROCESSING() {
        return STATE_CHANGE_INTERPOLATOR_PROCESSING;
    }
}
