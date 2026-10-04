package com.samsung.android.sdk.pen.pen;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001b\u001a\u00020\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPenManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mPenList", "", "Lcom/samsung/android/sdk/pen/pen/SpenPen;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/pen/SpenPenManager$InstallListener;", "createPen", "info", "Lcom/samsung/android/sdk/pen/pen/SpenPenInfo;", "penInfoList", "", "getPenInfoList", "()Ljava/util/List;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "", "createPreviewPen", "destroyPen", "pen", "destroyPreviewPen", "close", "InstallListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPenManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPenManager.kt\ncom/samsung/android/sdk/pen/pen/SpenPenManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,695:1\n1#2:696\n*E\n"})
public final class SpenPenManager {
    private static final int CLASS_NAME_INDEX = 3;
    private static final int ICON_IMAGE_URI_INDEX = 1;
    private static final int PACKAGE_NAME_INDEX = 2;

    @NotNull
    public static final String SPEN_AIR_BRUSH_PEN = "com.samsung.android.sdk.pen.pen.preload.AirBrushPen";

    @NotNull
    public static final String SPEN_BEAUTIFY = "com.samsung.android.sdk.pen.pen.preload.Beautify";

    @NotNull
    public static final String SPEN_BLUR_PEN = "com.samsung.android.sdk.pen.pen.preload.BlurPen";

    @NotNull
    public static final String SPEN_BRUSH = "com.samsung.android.sdk.pen.pen.preload.Brush";

    @NotNull
    public static final String SPEN_BRUSH_PEN = "com.samsung.android.sdk.pen.pen.preload.BrushPen";

    @NotNull
    public static final String SPEN_CHINESE_BRUSH = "com.samsung.android.sdk.pen.pen.preload.ChineseBrush";

    @NotNull
    public static final String SPEN_COLORED_PENCIL = "com.samsung.android.sdk.pen.pen.preload.ColoredPencil";

    @NotNull
    public static final String SPEN_CRAYON = "com.samsung.android.sdk.pen.pen.preload.Crayon";

    @NotNull
    public static final String SPEN_CRAYON2 = "com.samsung.android.sdk.pen.pen.preload.Crayon2";

    @NotNull
    public static final String SPEN_DOODLE_PEN = "com.samsung.android.sdk.pen.pen.preload.DoodlePen";

    @NotNull
    public static final String SPEN_ERASER = "com.samsung.android.sdk.pen.pen.preload.Eraser";

    @NotNull
    public static final String SPEN_FADED_PEN = "com.samsung.android.sdk.pen.pen.preload.FadedPen";

    @NotNull
    public static final String SPEN_FOUNTAIN_PEN = "com.samsung.android.sdk.pen.pen.preload.FountainPen";

    @NotNull
    public static final String SPEN_GLOW_PEN = "com.samsung.android.sdk.pen.pen.preload.GlowPen";

    @NotNull
    public static final String SPEN_INK_PEN = "com.samsung.android.sdk.pen.pen.preload.InkPen";

    @NotNull
    public static final String SPEN_INK_PEN2 = "com.samsung.android.sdk.pen.pen.preload.InkPen2";

    @NotNull
    public static final String SPEN_LASER_PEN = "com.samsung.android.sdk.pen.pen.preload.LaserPen";

    @NotNull
    public static final String SPEN_MAGIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MagicPen";

    @NotNull
    public static final String SPEN_MARKER = "com.samsung.android.sdk.pen.pen.preload.Marker";

    @NotNull
    public static final String SPEN_MARKER2 = "com.samsung.android.sdk.pen.pen.preload.Marker2";

    @NotNull
    public static final String SPEN_MARKER3 = "com.samsung.android.sdk.pen.pen.preload.Marker3";

    @NotNull
    public static final String SPEN_MARKER4 = "com.samsung.android.sdk.pen.pen.preload.Marker4";

    @NotNull
    public static final String SPEN_MONTBLANC_FOUNTAIN_PEN = "com.samsung.android.sdk.pen.pen.preload.MontblancFountainPen";

    @NotNull
    public static final String SPEN_MONTBLANC_OBLIQUE_PEN = "com.samsung.android.sdk.pen.pen.preload.MontblancCalligraphyPen";

    @NotNull
    public static final String SPEN_MOSAIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MosaicPen";

    @NotNull
    public static final String SPEN_MOSAIC_PEN2 = "com.samsung.android.sdk.pen.pen.preload.MosaicPen2";

    @NotNull
    public static final String SPEN_OBLIQUE_PEN = "com.samsung.android.sdk.pen.pen.preload.ObliquePen";

    @NotNull
    public static final String SPEN_OIL_BRUSH2 = "com.samsung.android.sdk.pen.pen.preload.OilBrush2";

    @NotNull
    public static final String SPEN_OIL_BRUSH3 = "com.samsung.android.sdk.pen.pen.preload.OilBrush3";

    @NotNull
    public static final String SPEN_PATTERN_IMAGE_PEN = "com.samsung.android.sdk.pen.pen.preload.PatternImagePen";

    @NotNull
    public static final String SPEN_PENCIL = "com.samsung.android.sdk.pen.pen.preload.Pencil";

    @NotNull
    public static final String SPEN_PENCIL2 = "com.samsung.android.sdk.pen.pen.preload.Pencil2";

    @NotNull
    public static final String SPEN_PENCIL3 = "com.samsung.android.sdk.pen.pen.preload.Pencil3";

    @NotNull
    public static final String SPEN_SMUDGE = "com.samsung.android.sdk.pen.pen.preload.Smudge";

    @NotNull
    public static final String SPEN_STRAIGHT_BLURPEN = "com.samsung.android.sdk.pen.pen.preload.StraightBlurPen";

    @NotNull
    public static final String SPEN_STRAIGHT_GLOWPEN = "com.samsung.android.sdk.pen.pen.preload.StraightGlowPen";

    @NotNull
    public static final String SPEN_STRAIGHT_HIGHLIGHTER = "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter";

    @NotNull
    public static final String SPEN_STRAIGHT_INKPEN2 = "com.samsung.android.sdk.pen.pen.preload.StraightInkPen2";

    @NotNull
    public static final String SPEN_STRAIGHT_MARKER = "com.samsung.android.sdk.pen.pen.preload.StraightMarker";

    @NotNull
    public static final String SPEN_STRAIGHT_MOSAICPEN = "com.samsung.android.sdk.pen.pen.preload.StraightMosaicPen";

    @NotNull
    public static final String SPEN_STRAIGHT_MOSAICPEN2 = "com.samsung.android.sdk.pen.pen.preload.StraightMosaicPen2";

    @NotNull
    public static final String SPEN_TRIANGLE_MOSAIC_PEN = "com.samsung.android.sdk.pen.pen.preload.TriangleMosaicPen";

    @NotNull
    public static final String SPEN_WATER_BRUSH = "com.samsung.android.sdk.pen.pen.preload.WaterColorBrush";
    private static final int VERSION_INDEX = 0;

    @Nullable
    private Context mContext;

    @NotNull
    private final List<SpenPen> mPenList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[][] BUILTIN_PEN_LIST = {new String[]{"1", "note_brush_water", "com.samsung.android.sdk.pen.pen.preload", "WaterColorBrush"}, new String[]{"1", "note_brush_oil", "com.samsung.android.sdk.pen.pen.preload", "OilBrush3"}, new String[]{"1", "note_handwriting_setting_pen_06_select", "com.samsung.android.sdk.pen.pen.preload", "BrushPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "Pencil3"}, new String[]{"1", "note_brush_color_pencil", "com.samsung.android.sdk.pen.pen.preload", "Crayon2"}, new String[]{"1", "note_handwriting_setting_pen_04_select", "com.samsung.android.sdk.pen.pen.preload", "InkPen"}, new String[]{"1", "note_handwriting_setting_pen_04_select", "com.samsung.android.sdk.pen.pen.preload", "InkPen2"}, new String[]{"1", "note_brush_airbrush", "com.samsung.android.sdk.pen.pen.preload", "AirBrushPen"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "Marker2"}, new String[]{"1", "note_handwriting_setting_pen_01_select", "com.samsung.android.sdk.pen.pen.preload", "FountainPen"}, new String[]{"1", "note_handwriting_setting_pen_02_select", "com.samsung.android.sdk.pen.pen.preload", "ObliquePen"}, new String[]{"1", "note_handwriting_setting_pen_03_select", "com.samsung.android.sdk.pen.pen.preload", "Pencil2"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "Eraser"}, new String[]{"1", "note_handwriting_setting_pen_01_select", "com.samsung.android.sdk.pen.pen.preload", "MontblancFountainPen"}, new String[]{"1", "note_handwriting_setting_pen_02_select", "com.samsung.android.sdk.pen.pen.preload", "MontblancCalligraphyPen"}, new String[]{"1", "note_handwriting_setting_pen_03_select", "com.samsung.android.sdk.pen.pen.preload", "Pencil"}, new String[]{"1", "note_brush_color_pencil", "com.samsung.android.sdk.pen.pen.preload", "Crayon"}, new String[]{"1", "note_brush_cali", "com.samsung.android.sdk.pen.pen.preload", "ChineseBrush"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "MagicPen"}, new String[]{"1", "note_brush_cali", "com.samsung.android.sdk.pen.pen.preload", "Beautify"}, new String[]{"1", "note_brush_cali", "com.samsung.android.sdk.pen.pen.preload", "Brush"}, new String[]{"1", "note_handwriting_setting_pen_05_select", "com.samsung.android.sdk.pen.pen.preload", PerfConstants.CodeMarkerParameters.MARKER}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "Smudge"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "ColoredPencil"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "MosaicPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "MosaicPen2"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "Marker3"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "Marker4"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "TriangleMosaicPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "BlurPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "PatternImagePen"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "StraightHighlighter"}, new String[]{"1", "note_brush_maker", "com.samsung.android.sdk.pen.pen.preload", "StraightMarker"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "FadedPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "LaserPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "GlowPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "DoodlePen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "StraightInkPen2"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "StraightGlowPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "StraightMosaicPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "StraightBlurPen"}, new String[]{"1", "note_brush_pencil", "com.samsung.android.sdk.pen.pen.preload", "StraightMosaicPen2"}};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0007J \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u000208H\u0007J\u001b\u0010<\u001a\u0002082\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050>H\u0002¢\u0006\u0002\u0010?J\u0011\u0010@\u001a\u0002062\u0006\u0010;\u001a\u000208H\u0083 J!\u0010A\u001a\u0002082\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u000208H\u0083 J\u0011\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005H\u0083 J\u0011\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020CH\u0083 J\t\u0010G\u001a\u000201H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000201X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000201X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050>0>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010I¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPenManager$Companion;", "", "<init>", "()V", "SPEN_INK_PEN", "", "SPEN_INK_PEN2", "SPEN_PENCIL", "SPEN_MARKER", "SPEN_MARKER2", "SPEN_MARKER3", "SPEN_MARKER4", "SPEN_STRAIGHT_HIGHLIGHTER", "SPEN_STRAIGHT_MARKER", "SPEN_BRUSH", "SPEN_BRUSH_PEN", "SPEN_BEAUTIFY", "SPEN_CHINESE_BRUSH", "SPEN_MAGIC_PEN", "SPEN_FADED_PEN", "SPEN_FOUNTAIN_PEN", "SPEN_OBLIQUE_PEN", "SPEN_OIL_BRUSH2", "SPEN_OIL_BRUSH3", "SPEN_WATER_BRUSH", "SPEN_PENCIL2", "SPEN_PENCIL3", "SPEN_ERASER", "SPEN_MONTBLANC_OBLIQUE_PEN", "SPEN_MONTBLANC_FOUNTAIN_PEN", "SPEN_SMUDGE", "SPEN_COLORED_PENCIL", "SPEN_CRAYON", "SPEN_CRAYON2", "SPEN_AIR_BRUSH_PEN", "SPEN_MOSAIC_PEN", "SPEN_MOSAIC_PEN2", "SPEN_TRIANGLE_MOSAIC_PEN", "SPEN_BLUR_PEN", "SPEN_PATTERN_IMAGE_PEN", "SPEN_GLOW_PEN", "SPEN_DOODLE_PEN", "SPEN_LASER_PEN", "SPEN_STRAIGHT_INKPEN2", "SPEN_STRAIGHT_GLOWPEN", "SPEN_STRAIGHT_MOSAICPEN", "SPEN_STRAIGHT_BLURPEN", "SPEN_STRAIGHT_MOSAICPEN2", "VERSION_INDEX", "", "ICON_IMAGE_URI_INDEX", "PACKAGE_NAME_INDEX", "CLASS_NAME_INDEX", "setPenAntiAliasEnabled", "", "setPenAttributeEnabled", "", "penName", "attribute", "enable", "isExistedSPen", "plugin", "", "([Ljava/lang/String;)Z", "native_setPenAntiAliasEnabled", "native_setPenAttributeEnabled", "native_createPen", "", "advancedSetting", "native_destroyPen", "nativeHandle", "native_getPenCount", "BUILTIN_PEN_LIST", "[[Ljava/lang/String;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isExistedSPen(String[] plugin) {
            String strM772n = AbstractC0541b.m772n("SPen", plugin[3]);
            if (Intrinsics.areEqual(plugin[3], "Beautify")) {
                strM772n = "SPenChineseBrush";
            }
            return Spen.INSTANCE.isLoadedSpen(strM772n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long native_createPen(String advancedSetting) {
            return SpenPenManager.native_createPen(advancedSetting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_destroyPen(long nativeHandle) {
            return SpenPenManager.native_destroyPen(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getPenCount() {
            return SpenPenManager.native_getPenCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void native_setPenAntiAliasEnabled(boolean enable) {
            SpenPenManager.native_setPenAntiAliasEnabled(enable);
        }

        @JvmStatic
        private final boolean native_setPenAttributeEnabled(String penName, int attribute, boolean enable) {
            return SpenPenManager.native_setPenAttributeEnabled(penName, attribute, enable);
        }

        @JvmStatic
        public final void setPenAntiAliasEnabled() {
            native_setPenAntiAliasEnabled(SpenLatencyConfiguration.INSTANCE.isPenAntiAliasEnabled());
        }

        @JvmStatic
        public final boolean setPenAttributeEnabled(@NotNull String penName, int attribute, boolean enable) {
            Intrinsics.checkNotNullParameter(penName, "penName");
            Log.d("PenManager", "setPenAttributeEnabled penName: " + penName + " attribute: " + attribute + " enable:" + enable);
            return native_setPenAttributeEnabled(penName, attribute, enable);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "")
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPenManager$InstallListener;", "", "onInstalled", "", "packageName", "", "onUninstalled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface InstallListener {
        void onInstalled(@Nullable String packageName);

        void onUninstalled(@Nullable String packageName);
    }

    public SpenPenManager(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mContext = context;
        this.mPenList = new ArrayList();
        INSTANCE.native_setPenAntiAliasEnabled(SpenLatencyConfiguration.INSTANCE.isPenAntiAliasEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long native_createPen(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_destroyPen(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getPenCount();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void native_setPenAntiAliasEnabled(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setPenAttributeEnabled(String str, int i, boolean z);

    @JvmStatic
    public static final void setPenAntiAliasEnabled() {
        INSTANCE.setPenAntiAliasEnabled();
    }

    @JvmStatic
    public static final boolean setPenAttributeEnabled(@NotNull String str, int i, boolean z) {
        return INSTANCE.setPenAttributeEnabled(str, i, z);
    }

    public final void close() {
        AbstractC0541b.m755A(this.mPenList.size(), "PenManager mPenList.size ", "PenManager");
        Iterator<SpenPen> it = this.mPenList.iterator();
        SpenPen next = null;
        while (it.hasNext()) {
            next = it.next();
            INSTANCE.native_destroyPen(next.getPenNativeHandle());
        }
        if (next != null) {
            next.close();
        }
        this.mPenList.clear();
        this.mContext = null;
    }

    @NotNull
    public final SpenPen createPen(@NotNull SpenPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return createPen(info.className);
    }

    @NotNull
    public final SpenPen createPreviewPen(@Nullable SpenPenInfo info) {
        if (info != null) {
            return createPreviewPen(info.className);
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
    }

    public final void destroyPen(@Nullable SpenPen pen) {
        if (pen == null || pen.getPenNativeHandle() == 0) {
            throw new IllegalStateException("E_INVALID_STATE : parameter 'pen' is null");
        }
        Log.d("PenManager", "destroyPen " + pen.getPenNativeHandle());
        Companion companion = INSTANCE;
        if (!companion.native_destroyPen(pen.getPenNativeHandle())) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
        this.mPenList.remove(pen);
        if (companion.native_getPenCount() == 0) {
            pen.close();
        }
    }

    public final void destroyPreviewPen(@Nullable SpenPen pen) {
        destroyPen(pen);
    }

    @Nullable
    public final List<SpenPenInfo> getPenInfoList() {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr : BUILTIN_PEN_LIST) {
            if (strArr.length == 4) {
                SpenPenInfo spenPenInfo = new SpenPenInfo();
                String str = strArr[3];
                spenPenInfo.name = str;
                String strM757C = AbstractC0541b.m757C(strArr[2], Extension.DOT, str);
                spenPenInfo.className = strM757C;
                if (Spen.IS_SPEN_PRELOAD_MODE || (!StringsKt__StringsJVMKt.equals(strM757C, SPEN_BEAUTIFY, true) && !StringsKt__StringsJVMKt.equals(spenPenInfo.className, SPEN_BRUSH, true) && !StringsKt__StringsJVMKt.equals(spenPenInfo.className, SPEN_MONTBLANC_FOUNTAIN_PEN, true) && !StringsKt__StringsJVMKt.equals(spenPenInfo.className, SPEN_MONTBLANC_OBLIQUE_PEN, true))) {
                    arrayList.add(spenPenInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Deprecated(message = "")
    public final void setListener(@Nullable InstallListener listener) {
    }

    @NotNull
    public final SpenPen createPen(@Nullable String className) {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        long jNative_createPen = INSTANCE.native_createPen(className);
        Log.d("PenManager", "createPen " + className + " " + jNative_createPen);
        if (jNative_createPen == 0) {
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
        SpenPen spenPen = new SpenPen(this.mContext, jNative_createPen, 0);
        this.mPenList.add(spenPen);
        return spenPen;
    }

    @NotNull
    public final SpenPen createPreviewPen(@Nullable String className) {
        if (className != null) {
            long jNative_createPen = INSTANCE.native_createPen(className);
            Log.d("PenManager", "createPreviewPen " + className + " " + jNative_createPen);
            if (jNative_createPen == 0) {
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
            }
            SpenPen spenPen = new SpenPen(this.mContext, jNative_createPen, 1);
            this.mPenList.add(spenPen);
            return spenPen;
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
    }
}
