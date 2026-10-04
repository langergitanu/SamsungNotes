package com.samsung.android.sdk.pen.engine.resource;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.VectorDrawable;
import android.icu.text.NumberFormat;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J,\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0002¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/resource/SpenResources;", "", "<init>", "()V", "getBitmap", "Landroid/graphics/Bitmap;", "id", "", "ninePatch", "Landroid/graphics/Rect;", "dstRect", "isVectorDrawable", "", "getString", "", "textAllCaps", "", "getFormattedString", "text1", "text2", ActionHandler.PARAMS, "getParam", "param", "getRtlNumberString", TextConst.KEY_PARAM_NUMBER, "getLocaleTimeString", "hour", VElementFormulasCmd.FMIN, "sec", "getLocaleTimeDescription", "chuckToRect", "", "chuck", "", "out", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenResources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenResources.kt\ncom/samsung/android/sdk/pen/engine/resource/SpenResources\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
public final class SpenResources {
    private static final int CHUCK_BOTTOM = 44;
    private static final int CHUCK_LEFT = 32;
    private static final int CHUCK_RIGHT = 40;
    private static final int CHUCK_TOP = 36;
    private static int dpi;

    @Nullable
    private static Resources resources;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final int[] ResourceID = {C7932R.drawable.memo_bullet, C7932R.drawable.ic_music_note, C7932R.drawable.ic_internet_web_globe, C7932R.drawable.ic_error_notice, C7932R.drawable.ic_delete_card, C7932R.drawable.ic_delete_card_dark, C7932R.drawable.sdk_note_voice_btn_ic_play, C7932R.drawable.sdk_note_voice_btn_ic_play_dark, C7932R.drawable.voice_card_action_button, C7932R.drawable.voice_card_action_button_dark, C7932R.drawable.web_card_action_button, C7932R.drawable.web_card_action_button_dark, C7932R.drawable.native_composer_note_webcard_ic_fail, C7932R.drawable.tw_list_icon_circle_mtrl, C7932R.drawable.tw_list_icon_minus_mtrl, C7932R.drawable.note_handwriting_toolbar_bg, C7932R.drawable.note_handwriting_toolbar_open_bg, C7932R.drawable.note_handwriting_actionlink_ic_bg, C7932R.drawable.note_handwriting_actionlink_ic_calculator, C7932R.drawable.note_handwriting_actionlink_ic_call, C7932R.drawable.note_handwriting_actionlink_ic_msg, C7932R.drawable.note_handwriting_actionlink_ic_web, C7932R.drawable.note_preview_handler, C7932R.drawable.note_preview_handler_focused, C7932R.drawable.note_preview_handler_dark, C7932R.drawable.ic_converttext_top, C7932R.drawable.ic_converttext_down, C7932R.drawable.ic_auto_format_selection_handler_up, C7932R.drawable.ic_auto_format_selection_handler_bottom, C7932R.drawable.selection_handler, C7932R.drawable.shape_point_edit, C7932R.drawable.shape_point_connect, C7932R.drawable.ic_ewp_resize, C7932R.drawable.ic_easywriting_back, C7932R.drawable.ic_easywriting_enter, C7932R.drawable.ic_easywriting_handler, C7932R.drawable.ic_easywriting_guide_handler, C7932R.drawable.ic_converting_math, C7932R.drawable.ic_gesture01, C7932R.drawable.ic_gesture02, C7932R.drawable.ic_gesture03, C7932R.drawable.composer_image_not_found, C7932R.drawable.ic_cursor_select_handle_left, C7932R.drawable.ic_cursor_select_handle_middle, C7932R.drawable.ic_cursor_select_handle_right, C7932R.drawable.spen_ic_textover_que, C7932R.drawable.spen_ic_text_bullet, C7932R.drawable.spen_ic_text_bullet_white_circle, C7932R.drawable.spen_ic_text_bullet_black_square, C7932R.drawable.spen_ic_text_bullet_white_square, C7932R.drawable.spen_ic_text_check_off, C7932R.drawable.spen_ic_text_check_on, C7932R.drawable.drawing, C7932R.drawable.ic_control_delete, C7932R.drawable.ic_control_rotate, C7932R.drawable.ic_page_scroll_btn, C7932R.drawable.ic_send_to_note, C7932R.drawable.ic_sync, C7932R.drawable.intelligence_watermark_logo, C7932R.drawable.template_music_land, C7932R.drawable.template_music_land_dark, C7932R.drawable.icon_rotate, C7932R.drawable.icon_oval, C7932R.drawable.ic_table_handler, C7932R.drawable.ic_table_more, C7932R.drawable.ic_table_more_dark, C7932R.drawable.ic_table_resize, C7932R.drawable.ic_table_resize_dark, C7932R.drawable.ic_table_select_all_cells, C7932R.drawable.sync_error, C7932R.drawable.ic_sticky_memo_min, C7932R.drawable.ic_sticky_memo_min_color, C7932R.drawable.ic_copy};

    @NotNull
    private static final int[] StringID = {C7932R.string.voice_play, C7932R.string.voice_stop, C7932R.string.voice_delete, C7932R.string.voice_title_prefix, C7932R.string.string_loading_dot_dot_dot, C7932R.string.pen_string_pen_settings, C7932R.string.pen_string_pen_mode, C7932R.string.pen_string_transform_into_auto_shape, C7932R.string.drawing_menu_erase, C7932R.string.pen_string_selection_mode, C7932R.string.drawing_menu_redo, C7932R.string.drawing_menu_undo, C7932R.string.composer_ctx_menu_resize_image, C7932R.string.drawing_string_selected, C7932R.string.drawing_string_not_selected, C7932R.string.handwriting_string_zoompad, C7932R.string.handwriting_string_web_address, C7932R.string.handwriting_string_phone, C7932R.string.handwriting_string_email, C7932R.string.handwriting_string_calculator, C7932R.string.handwriting_string_extract_text, C7932R.string.handwriting_string_zoompad_status_on, C7932R.string.handwriting_string_zoompad_status_off, C7932R.string.pen_string_color_double_tap_and_hold_to_move, C7932R.string.voice_assistant_editbox_double_tab_to_edit, C7932R.string.voice_assistant_editbox_editing, C7932R.string.voice_assistant_editbox, C7932R.string.voice_assistant_textbox, C7932R.string.voice_assistant_disabled, C7932R.string.voice_assistant_slider, C7932R.string.voice_assistant_moved, C7932R.string.voice_assistant_double_tap, C7932R.string.voice_assistant_write, C7932R.string.voice_assistant_text_to_text, C7932R.string.handwriting, C7932R.string.easy_writing_pad_guide_text, C7932R.string.easy_writing_pad_btn_next, C7932R.string.easy_writing_pad_btn_previous, C7932R.string.easy_writing_pad_btn_enter, C7932R.string.pen_string_move_handler, C7932R.string.math_guide_text_1, C7932R.string.math_guide_text_2, C7932R.string.composer_pdf_pages, C7932R.string.composer_pdf_1_page, C7932R.string.composer_voice_assistant_button, C7932R.string.composer_voice_assistant_handle, C7932R.string.composer_voice_assistant_category, C7932R.string.pen_string_page_indicator, C7932R.string.spen_string_bullet_todo, C7932R.string.spen_string_bullet_numbering, C7932R.string.spen_string_bullet_points, C7932R.string.voice_assistant_easy_writing_pad_focus_area, C7932R.string.voice_assistant_object_shape_focus_area, C7932R.string.image, C7932R.string.drawing_object, C7932R.string.audio_file, C7932R.string.link, C7932R.string.sticky_note};

    @NotNull
    private static final ArrayList<View> mViews = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u0016\u001a\u00020\u0014H\u0007J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0007J\t\u0010\u001a\u001a\u00020\u0014H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/resource/SpenResources$Companion;", "", "<init>", "()V", "CHUCK_LEFT", "", "CHUCK_TOP", "CHUCK_RIGHT", "CHUCK_BOTTOM", "ResourceID", "", "StringID", "resources", "Landroid/content/res/Resources;", "dpi", "mViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "setResources", "", "r", "forceClearResources", "registerResourceView", "view", "unregisterResourceView", "Native_ClearResources", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final void Native_ClearResources() {
            SpenResources.Native_ClearResources();
        }

        @JvmStatic
        public final void forceClearResources() {
            Native_ClearResources();
        }

        @JvmStatic
        public final void registerResourceView(@Nullable View view) {
            if (view == null || SpenResources.mViews.contains(view)) {
                return;
            }
            SpenResources.mViews.add(view);
        }

        @JvmStatic
        public final void setResources(@Nullable Resources r) {
            SpenResources.resources = r;
            Resources resources = SpenResources.resources;
            if (resources == null || SpenResources.dpi == resources.getDisplayMetrics().densityDpi) {
                return;
            }
            SpenResources.dpi = resources.getDisplayMetrics().densityDpi;
            SpenResources.INSTANCE.Native_ClearResources();
        }

        @JvmStatic
        public final void unregisterResourceView(@Nullable View view) {
            TypeIntrinsics.asMutableCollection(SpenResources.mViews).remove(view);
            if (SpenResources.mViews.isEmpty()) {
                Native_ClearResources();
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_ClearResources();

    private final void chuckToRect(byte[] chuck, Rect out) {
        if (chuck == null) {
            return;
        }
        out.set(chuck[32], chuck[36], chuck[40] + 1, chuck[44] + 1);
    }

    @JvmStatic
    public static final void forceClearResources() {
        INSTANCE.forceClearResources();
    }

    private final String getLocaleTimeDescription(int hour, int min, int sec) {
        Resources resources2 = resources;
        if (resources2 == null) {
            throw new IllegalArgumentException("Resource must not be null");
        }
        Intrinsics.checkNotNull(resources2);
        StringBuilder sb = new StringBuilder();
        if (hour > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            sb.append(AbstractC11014a.m12323h(new Object[]{Integer.valueOf(hour)}, 1, Locale.getDefault(), "%d ", "format(locale, format, *args)"));
            Resources resources3 = resources;
            Intrinsics.checkNotNull(resources3);
            sb.append(resources3.getString(C7932R.string.assistant_hour));
        }
        if (min > 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            sb.append(AbstractC11014a.m12323h(new Object[]{Integer.valueOf(min)}, 1, Locale.getDefault(), " %d ", "format(locale, format, *args)"));
            Resources resources4 = resources;
            Intrinsics.checkNotNull(resources4);
            sb.append(resources4.getString(C7932R.string.assistant_minute));
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        sb.append(AbstractC11014a.m12323h(new Object[]{Integer.valueOf(sec)}, 1, Locale.getDefault(), " %d ", "format(locale, format, *args)"));
        sb.append(resources2.getString(C7932R.string.assistant_second));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String getLocaleTimeString(int hour, int min, int sec) {
        if (hour == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(min), Integer.valueOf(sec)}, 2, Locale.getDefault(), "%02d:%02d", "format(locale, format, *args)");
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(hour), Integer.valueOf(min), Integer.valueOf(sec)}, 3, Locale.getDefault(), "%02d:%02d:%02d", "format(locale, format, *args)");
    }

    private final String getRtlNumberString(int number) {
        Resources resources2 = resources;
        if (resources2 == null) {
            throw new IllegalArgumentException("Resource must not be null");
        }
        Intrinsics.checkNotNull(resources2);
        String str = NumberFormat.getInstance(resources2.getConfiguration().getLocales().get(0)).format(number);
        Intrinsics.checkNotNull(str);
        return str;
    }

    @JvmStatic
    public static final void registerResourceView(@Nullable View view) {
        INSTANCE.registerResourceView(view);
    }

    @JvmStatic
    public static final void setResources(@Nullable Resources resources2) {
        INSTANCE.setResources(resources2);
    }

    @JvmStatic
    public static final void unregisterResourceView(@Nullable View view) {
        INSTANCE.unregisterResourceView(view);
    }

    @Nullable
    public final Bitmap getBitmap(int id, @Nullable Rect ninePatch, @NotNull Rect dstRect, @Nullable boolean[] isVectorDrawable) {
        Intrinsics.checkNotNullParameter(dstRect, "dstRect");
        Resources resources2 = resources;
        if (resources2 == null) {
            throw new IllegalArgumentException("Resource must not be null");
        }
        Intrinsics.checkNotNull(resources2);
        int[] iArr = ResourceID;
        if (id >= iArr.length) {
            throw new IndexOutOfBoundsException("native id of bitmap resource is not match with java bitmap resource.");
        }
        Drawable drawable = resources2.getDrawable(iArr[id], null);
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources2, iArr[id]);
            if (ninePatch != null) {
                chuckToRect(bitmapDecodeResource != null ? bitmapDecodeResource.getNinePatchChunk() : null, ninePatch);
                AbstractC2322a.m1609C("getBitmap ninePatch = ", ninePatch.toShortString(), "SComposer");
            }
            return bitmapDecodeResource;
        }
        if (isVectorDrawable != null) {
            if (!(isVectorDrawable.length == 0)) {
                isVectorDrawable[0] = drawable instanceof VectorDrawable;
            }
        }
        int intrinsicWidth = dstRect.isEmpty() ? drawable.getIntrinsicWidth() : dstRect.width();
        int intrinsicHeight = dstRect.isEmpty() ? drawable.getIntrinsicHeight() : dstRect.height();
        AbstractC0541b.m783y(intrinsicWidth, intrinsicHeight, "getBitmap dstWidth=", " dstHeight=", "SComposer");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Nullable
    public final String getFormattedString(int id, @Nullable String text1, @Nullable String text2, boolean textAllCaps) {
        Resources resources2 = resources;
        if (resources2 == null) {
            throw new IllegalArgumentException("Resource must not be null");
        }
        Intrinsics.checkNotNull(resources2);
        int[] iArr = StringID;
        if (id >= iArr.length) {
            throw new IndexOutOfBoundsException("GetFormattedString: native id of string resource is not match with java string resource.");
        }
        try {
            if (!textAllCaps) {
                return resources2.getString(iArr[id], text1, text2);
            }
            String string = resources2.getString(iArr[id], text1, text2);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (MissingFormatArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int getParam(int param) {
        return param;
    }

    @NotNull
    public final String getString(int id, boolean textAllCaps) {
        Resources resources2 = resources;
        if (resources2 == null) {
            throw new IllegalArgumentException("Resource must not be null");
        }
        Intrinsics.checkNotNull(resources2);
        int[] iArr = StringID;
        if (id >= iArr.length) {
            throw new IndexOutOfBoundsException("native id of string resource is not match with java string resource.");
        }
        if (!textAllCaps) {
            String string = resources2.getString(iArr[id]);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = resources2.getString(iArr[id]);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = string2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @NotNull
    public final String getString(int id, int params, boolean textAllCaps) {
        Resources resources2 = resources;
        if (resources2 != null) {
            Intrinsics.checkNotNull(resources2);
            int[] iArr = StringID;
            if (id >= iArr.length) {
                throw new IndexOutOfBoundsException("native id of string resource is not match with java string resource.");
            }
            if (textAllCaps) {
                String string = resources2.getString(iArr[id], Integer.valueOf(params));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
            String string2 = resources2.getString(iArr[id], Integer.valueOf(params));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        throw new IllegalArgumentException("Resource must not be null");
    }
}
