package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenResource;", "", "<init>", "()V", "getPenSettingResource", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "context", "Landroid/content/Context;", "penName", "", "getPenResourceID", "", "getPenDescriptionID", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenResource {

    @NotNull
    public static final SpenPenResource INSTANCE = new SpenPenResource();

    private SpenPenResource() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0109, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x010e, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_marker_pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL3) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_pencil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_STRAIGHT_MOSAICPEN2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a2, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a8, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_STRAIGHT_MOSAICPEN) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b4, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_straight_line_mosaic_pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MOSAIC_PEN) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c4, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MOSAIC_PEN2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c9, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_mosaic_pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00f4, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER4) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00f9, code lost:
    
        return com.samsung.android.spen.C7932R.string.pen_string_highlighter_pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0100, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER3) == false) goto L101;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getPenDescriptionID(@Nullable String penName) {
        if (penName == null) {
            return 0;
        }
        int i = C7932R.string.pen_string_pen;
        switch (penName.hashCode()) {
            case -1720765579:
                break;
            case -1720765578:
                break;
            case -1720765577:
                break;
            case -1499175198:
                if (penName.equals(SpenPenManager.SPEN_BRUSH_PEN)) {
                    return C7932R.string.pen_string_chinese_brush;
                }
                return i;
            case -1245360606:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_INKPEN2)) {
                    return C7932R.string.pen_string_straight_line_pen;
                }
                return i;
            case -938388931:
                if (penName.equals(SpenPenManager.SPEN_DOODLE_PEN)) {
                    return C7932R.string.pen_string_doodle_pen;
                }
                return i;
            case -867878778:
                break;
            case -859280084:
                break;
            case -687518126:
                break;
            case -610903172:
                break;
            case 161774624:
                break;
            case 202751947:
                if (penName.equals(SpenPenManager.SPEN_OBLIQUE_PEN)) {
                    return C7932R.string.pen_string_calligraphy_pen;
                }
                return i;
            case 383993284:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER)) {
                    return C7932R.string.pen_string_straight_line_highlighter;
                }
                return i;
            case 478214391:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_MARKER)) {
                    return C7932R.string.pen_string_straight_line_marker;
                }
                return i;
            case 1052333314:
                break;
            case 1052333315:
                break;
            case 1222176559:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_GLOWPEN)) {
                    return C7932R.string.pen_string_straight_line_glow_pen;
                }
                return i;
            case 1559752130:
                if (penName.equals(SpenPenManager.SPEN_FOUNTAIN_PEN)) {
                    return C7932R.string.pen_string_fountain_pen;
                }
                return i;
            case 1642861430:
                break;
            case 1745606749:
                break;
            case 1835061552:
                break;
            case 1856633993:
                if (penName.equals(SpenPenManager.SPEN_GLOW_PEN)) {
                    return C7932R.string.pen_string_glow_pen;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL3) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL2) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
    
        return com.samsung.android.spen.C7932R.drawable.pencil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007a, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN2) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007f, code lost:
    
        return com.samsung.android.spen.C7932R.drawable.pen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00aa, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER4) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00af, code lost:
    
        return com.samsung.android.spen.C7932R.drawable.highlighter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b6, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER3) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bf, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER2) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c4, code lost:
    
        return com.samsung.android.spen.C7932R.drawable.markerpen_round;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r2.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL) == false) goto L75;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getPenResourceID(@Nullable String penName) {
        if (penName == null) {
            return 0;
        }
        switch (penName.hashCode()) {
            case -1720765579:
                break;
            case -1720765578:
                break;
            case -1720765577:
                break;
            case -1499175198:
                if (penName.equals(SpenPenManager.SPEN_BRUSH_PEN)) {
                    return C7932R.drawable.caligraphy_brush;
                }
                return 0;
            case -867878778:
                if (penName.equals(SpenPenManager.SPEN_MOSAIC_PEN2)) {
                    return C7932R.drawable.mosaic_pen;
                }
                return 0;
            case -859280084:
                if (penName.equals(SpenPenManager.SPEN_MOSAIC_PEN)) {
                    return C7932R.drawable.mosaic_pen;
                }
                return 0;
            case -610903172:
                break;
            case 202751947:
                if (penName.equals(SpenPenManager.SPEN_OBLIQUE_PEN)) {
                    return C7932R.drawable.caligraphy_pen;
                }
                return 0;
            case 383993284:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER)) {
                    return C7932R.drawable.highlighter_straight;
                }
                return 0;
            case 478214391:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_MARKER)) {
                    return C7932R.drawable.markerpen_round_straight;
                }
                return 0;
            case 1052333314:
                break;
            case 1052333315:
                break;
            case 1559752130:
                if (penName.equals(SpenPenManager.SPEN_FOUNTAIN_PEN)) {
                    return C7932R.drawable.fountain_pen;
                }
                return 0;
            case 1642861430:
                break;
            case 1745606749:
                break;
            case 1835061552:
                break;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ad, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.marker_body;
        r3 = com.samsung.android.spen.C7932R.drawable.marker_effect;
        r2 = com.samsung.android.spen.C7932R.drawable.marker_av_unselected;
        r4 = com.samsung.android.spen.C7932R.drawable.marker_av_selected;
        r5 = com.samsung.android.spen.C7932R.drawable.marker_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_BLUR_PEN) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_STRAIGHT_BLURPEN) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL3) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_PENCIL2) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.pencil_body;
        r3 = com.samsung.android.spen.C7932R.drawable.pencil_effect;
        r2 = com.samsung.android.spen.C7932R.drawable.pencil_av_unselected;
        r4 = com.samsung.android.spen.C7932R.drawable.pencil_av_selected;
        r5 = com.samsung.android.spen.C7932R.drawable.pencil_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f5, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_STRAIGHT_MOSAICPEN2) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0112, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_INK_PEN2) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0116, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.pen_body;
        r3 = com.samsung.android.spen.C7932R.drawable.pen_effect;
        r2 = com.samsung.android.spen.C7932R.drawable.pen_av_unselected;
        r4 = com.samsung.android.spen.C7932R.drawable.pen_av_selected;
        r5 = com.samsung.android.spen.C7932R.drawable.pen_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0128, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_STRAIGHT_MOSAICPEN) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012c, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.straight_mosaic_pen_body;
        r2 = com.samsung.android.spen.C7932R.drawable.straight_mosaic_pen_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0130, code lost:
    
        r8 = r1;
        r12 = r2;
        r9 = 0;
        r10 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x013d, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MOSAIC_PEN) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0147, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MOSAIC_PEN2) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014a, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.mosaic_pen_body;
        r2 = com.samsung.android.spen.C7932R.drawable.mosaic_pen_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x018b, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER4) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x018e, code lost:
    
        r1 = com.samsung.android.spen.C7932R.drawable.highlighter_body;
        r3 = com.samsung.android.spen.C7932R.drawable.highlighter_effect;
        r2 = com.samsung.android.spen.C7932R.drawable.highlighter_av_unselected;
        r4 = com.samsung.android.spen.C7932R.drawable.highlighter_av_selected;
        r5 = com.samsung.android.spen.C7932R.drawable.highlighter_body_hover;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a0, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER3) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a9, code lost:
    
        if (r14.equals(com.samsung.android.sdk.pen.pen.SpenPenManager.SPEN_MARKER2) == false) goto L62;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpenSettingPenResource getPenSettingResource(@Nullable Context context, @Nullable String penName) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (penName == null) {
            return null;
        }
        int penDescriptionID = getPenDescriptionID(penName);
        int penResourceID = getPenResourceID(penName);
        switch (penName.hashCode()) {
            case -1720765579:
                break;
            case -1720765578:
                break;
            case -1720765577:
                break;
            case -1499175198:
                if (penName.equals(SpenPenManager.SPEN_BRUSH_PEN)) {
                    i7 = C7932R.drawable.brush_body;
                    i8 = C7932R.drawable.brush_effect;
                    i9 = C7932R.drawable.brush_av_unselected;
                    i10 = C7932R.drawable.brush_av_selected;
                    i11 = C7932R.drawable.brush_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case -1245360606:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_INKPEN2)) {
                    i7 = C7932R.drawable.pen_body;
                    i8 = C7932R.drawable.pen_effect_ruler;
                    i9 = C7932R.drawable.pen_av_unselected;
                    i10 = C7932R.drawable.pen_av_selected;
                    i11 = C7932R.drawable.pen_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case -938388931:
                if (penName.equals(SpenPenManager.SPEN_DOODLE_PEN)) {
                    penResourceID = C7932R.drawable.ai_pen;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case -867878778:
                break;
            case -859280084:
                break;
            case -687518126:
                break;
            case -610903172:
                break;
            case -531513173:
                if (penName.equals(SpenPenManager.SPEN_PATTERN_IMAGE_PEN)) {
                    penResourceID = C7932R.drawable.pattern_pen;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 161774624:
                break;
            case 202751947:
                if (penName.equals(SpenPenManager.SPEN_OBLIQUE_PEN)) {
                    i7 = C7932R.drawable.calligraphy_body;
                    i8 = C7932R.drawable.calligraphy_effect;
                    i9 = C7932R.drawable.calligraphy_av_unselected;
                    i10 = C7932R.drawable.calligraphy_av_selected;
                    i11 = C7932R.drawable.calligraphy_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 383993284:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER)) {
                    i7 = C7932R.drawable.highlighter_body;
                    i8 = C7932R.drawable.highlighter_effect_ruler;
                    i9 = C7932R.drawable.highlighter_av_unselected;
                    i10 = C7932R.drawable.highlighter_av_selected;
                    i11 = C7932R.drawable.highlighter_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 478214391:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_MARKER)) {
                    i7 = C7932R.drawable.marker_body;
                    i8 = C7932R.drawable.marker_effect_ruler;
                    i9 = C7932R.drawable.marker_av_unselected;
                    i10 = C7932R.drawable.marker_av_selected;
                    i11 = C7932R.drawable.marker_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 1052333314:
                break;
            case 1052333315:
                break;
            case 1085017621:
                break;
            case 1222176559:
                if (penName.equals(SpenPenManager.SPEN_STRAIGHT_GLOWPEN)) {
                    i7 = C7932R.drawable.marker_body;
                    i8 = C7932R.drawable.marker_effect_ruler;
                    i9 = C7932R.drawable.marker_av_unselected;
                    i10 = C7932R.drawable.marker_av_selected;
                    i11 = C7932R.drawable.marker_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 1559752130:
                if (penName.equals(SpenPenManager.SPEN_FOUNTAIN_PEN)) {
                    i7 = C7932R.drawable.fountain_body;
                    i8 = C7932R.drawable.fountain_effect;
                    i9 = C7932R.drawable.fountain_av_unselected;
                    i10 = C7932R.drawable.fountain_av_selected;
                    i11 = C7932R.drawable.fountain_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            case 1642861430:
                break;
            case 1719475055:
                break;
            case 1745606749:
                break;
            case 1835061552:
                break;
            case 1856633993:
                if (penName.equals(SpenPenManager.SPEN_GLOW_PEN)) {
                    i7 = C7932R.drawable.marker_body;
                    i8 = C7932R.drawable.marker_effect;
                    i9 = C7932R.drawable.marker_av_unselected;
                    i10 = C7932R.drawable.marker_av_selected;
                    i11 = C7932R.drawable.marker_body_hover;
                    i = i7;
                    i2 = i9;
                    i5 = i8;
                    i4 = i10;
                    i6 = i11;
                }
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            default:
                i = penResourceID;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
        }
        SpenSettingPenResource spenSettingPenResource = new SpenSettingPenResource(penName, penDescriptionID);
        spenSettingPenResource.setResourceId(context, i, i2, i4, i5, i6);
        return spenSettingPenResource;
    }
}
