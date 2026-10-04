package com.samsung.android.support.senl.p148nt.app.main.noteslist.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.exception.DisplayDataException;
import com.samsung.android.support.senl.p148nt.app.main.common.view.CustomImageMarginSpan;
import com.samsung.android.support.senl.p148nt.app.main.common.view.CustomImageSpan;
import com.samsung.android.support.senl.p148nt.app.main.common.view.CustomNumberingSpan;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.TaskSpan;
import com.samsung.android.support.senl.p148nt.base.common.util.HighlightTextUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.document.save.converter.DisplayBulletDataConverter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesHolderUtil {
    private static final String TAG = "NotesHolderUtil";
    private static final int[] mSubFolderListItemIds = {C8003R.id.sub_folder_list_item1, C8003R.id.sub_folder_list_item2, C8003R.id.sub_folder_list_item3, C8003R.id.sub_folder_list_item4, C8003R.id.sub_folder_list_item5, C8003R.id.sub_folder_list_item6, C8003R.id.sub_folder_list_item7, C8003R.id.sub_folder_list_item8, C8003R.id.sub_folder_list_item9, C8003R.id.sub_folder_list_item10, C8003R.id.sub_folder_list_item11, C8003R.id.sub_folder_list_item12, C8003R.id.sub_folder_list_item13, C8003R.id.sub_folder_list_item14};

    private static void addTextAlignSpan(boolean z, Editable editable, int i, int i2) {
        if (!z) {
            editable.insert(i, "\u200e");
            return;
        }
        String string = editable.toString();
        while (true) {
            i2 = string.lastIndexOf(10, i2 - 1);
            if (i2 < i) {
                editable.insert(i, UnicodeUtils.RLM);
                return;
            }
            editable.insert(i2 + 1, UnicodeUtils.RLM);
        }
    }

    private static SpannableString addTrimTextContent(CharSequence charSequence) {
        while (charSequence != null && charSequence.length() >= 2 && (charSequence.charAt(0) == '\n' || charSequence.charAt(0) == '\t' || charSequence.charAt(0) == ' ')) {
            charSequence = charSequence.subSequence(1, charSequence.length());
        }
        return new SpannableString(charSequence);
    }

    private static Drawable applyBulletStyle(Context context, Editable editable, int i, int i2, boolean z, int i4, int i5, boolean z2, int i6, boolean z3) {
        if (i5 == 0) {
            i5 = getColorBulletPoint(context, editable, i, i2, z2, i6, z3);
        }
        applyRTL(z, editable, i);
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i4, null);
        if (drawable != null) {
            drawable.setTint(i5);
        }
        return drawable;
    }

    private static void applyDimAlphaMaskColor(Context context, final Editable editable, int i, int i2, boolean z, int i4, boolean z2, int i5) {
        int alphaComponent = ColorUtils.setAlphaComponent(i5 != 0 ? i5 : (z2 || z) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color, null) : i4 == context.getResources().getColor(C8003R.color.composer_main_background_dark, null) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_black_bg_note, null) : context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_has_bg_note, null), 102);
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(i, i2, ForegroundColorSpan.class);
        if (foregroundColorSpanArr.length > 512) {
            return;
        }
        Arrays.sort(foregroundColorSpanArr, new Comparator<ForegroundColorSpan>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.NotesHolderUtil.1
            @Override // java.util.Comparator
            public int compare(ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
                int spanStart = editable.getSpanStart(foregroundColorSpan);
                int spanStart2 = editable.getSpanStart(foregroundColorSpan2);
                if (spanStart > spanStart2) {
                    return 1;
                }
                return spanStart < spanStart2 ? -1 : 0;
            }
        });
        try {
            int i6 = i;
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                int spanStart = editable.getSpanStart(foregroundColorSpan);
                int spanEnd = editable.getSpanEnd(foregroundColorSpan);
                if (spanStart != spanEnd || spanStart > i) {
                    if (spanStart < i) {
                        spanStart = i;
                    }
                    if (spanEnd > i2) {
                        spanEnd = i2;
                    }
                    int foregroundColor = i5 == 0 ? foregroundColorSpan.getForegroundColor() : i5;
                    editable.setSpan(new ForegroundColorSpan(Color.argb(102, Color.red(foregroundColor), Color.green(foregroundColor), Color.blue(foregroundColor))), spanStart, spanEnd, 33);
                    if (i6 < spanStart) {
                        editable.setSpan(new ForegroundColorSpan(alphaComponent), i6, spanStart, 33);
                    }
                    i6 = spanEnd;
                }
            }
            if (i6 < i2) {
                editable.setSpan(new ForegroundColorSpan(alphaComponent), i6, i2, 33);
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("applyDimAlphaMaskColor Exception "), TAG);
        }
    }

    private static void applyInverseColorSpan(Context context, Editable editable) {
        MainLogger.m7258i(TAG, "applyInverseColorSpan# inverse applied");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
        BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) editable.getSpans(0, editable.length(), BackgroundColorSpan.class);
        if (foregroundColorSpanArr.length > 0 || backgroundColorSpanArr.length > 0) {
            SpenColorThemeUtil spenColorThemeUtil = new SpenColorThemeUtil(context);
            spenColorThemeUtil.setColorTheme(1);
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                editable.setSpan(new ForegroundColorSpan(spenColorThemeUtil.getColor(foregroundColorSpan.getForegroundColor())), editable.getSpanStart(foregroundColorSpan), editable.getSpanEnd(foregroundColorSpan), 33);
            }
            for (BackgroundColorSpan backgroundColorSpan : backgroundColorSpanArr) {
                editable.setSpan(new BackgroundColorSpan(spenColorThemeUtil.getColor(backgroundColorSpan.getBackgroundColor())), editable.getSpanStart(backgroundColorSpan), editable.getSpanEnd(backgroundColorSpan), 33);
            }
            spenColorThemeUtil.close();
        }
    }

    private static void applyNumberingStyle(Context context, Editable editable, int i, int i2, boolean z, TaskSpan taskSpan, int i4, boolean z2, int i5, boolean z3, int i6, boolean z4) {
        int colorBulletPoint = i4 == 0 ? getColorBulletPoint(context, editable, i, i2, z2, i5, z3) : i4;
        int dimensionPixelSize = z4 ? context.getResources().getDimensionPixelSize(C8003R.dimen.notes_small_grid_item_text_content_size) : context.getResources().getDimensionPixelSize(C8003R.dimen.notes_grid_item_text_content_size);
        applyRTL(z, editable, i);
        editable.setSpan(new CustomNumberingSpan(context.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_display_content_numbering_gap_size), context.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_display_content_numbering_lead_size), DisplayBulletDataConverter.convertNumberToBulletString(taskSpan), colorBulletPoint, i6, dimensionPixelSize), i, i2, 33);
    }

    private static void applyRTL(boolean z, Editable editable, int i) {
        if (z) {
            editable.insert(i, UnicodeUtils.RLM);
        } else {
            editable.insert(i, "\u200e");
        }
    }

    private static void applyTaskEmpty(Context context, Editable editable, TaskSpan taskSpan) {
        int spanStart = editable.getSpanStart(taskSpan);
        int spanEnd = editable.getSpanEnd(taskSpan);
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.note_ic_image, null);
        for (TaskSpan taskSpan2 : (TaskSpan[]) editable.getSpans(spanStart, spanEnd, TaskSpan.class)) {
            if (taskSpan2.getTaskStatus() == 2 || taskSpan2.getTaskStatus() == 6) {
                drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_display_content_task_done_empty_color, null));
                break;
            }
        }
        drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_display_content_empty_color, null));
        editable.setSpan(new CustomImageSpan(drawable, (int) context.getResources().getDimension(C8003R.dimen.noteslist_display_content_checkbox_size)), spanStart, spanEnd, 33);
    }

    public static void applyTextOnlyThumbnailFgDim(View view, boolean z, @ColorInt int i) {
        if (!z) {
            i = 0;
        }
        applyTextOnlyThumbnailFgDim(view, i);
    }

    private static int getColorBulletPoint(Context context, Editable editable, int i, int i2, boolean z, int i4, boolean z2) {
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(i, i2, ForegroundColorSpan.class);
        if (foregroundColorSpanArr.length > 512) {
            return 0;
        }
        int foregroundColor = 0;
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            int spanStart = editable.getSpanStart(foregroundColorSpan);
            int spanEnd = editable.getSpanEnd(foregroundColorSpan);
            if (spanStart <= i) {
                if (spanStart == spanEnd) {
                    break;
                }
                foregroundColor = foregroundColorSpan.getForegroundColor();
            }
        }
        return foregroundColor == 0 ? (z2 || z) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color, null) : i4 == context.getResources().getColor(C8003R.color.composer_main_background_dark, null) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_black_bg_note, null) : context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_has_bg_note, null) : foregroundColor;
    }

    public static CharSequence getDisplayContent(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            CharSequence content = ((DisplayData) DisplayDataHelper.unmarshall(bArr, DisplayData.CREATOR)).getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            if (content.length() > 300) {
                MainLogger.m7258i(TAG, "getDisplayContent# displayContent subSequence");
                content = content.subSequence(0, 300);
            }
            return addTrimTextContent(content);
        } catch (Exception e) {
            throw new DisplayDataException(e.getMessage() == null ? "" : e.getMessage());
        }
    }

    public static CharSequence getDisplayContentAndExtra(Context context, MainListDocumentData mainListDocumentData) {
        String content = mainListDocumentData.getContent();
        int length = content.length();
        String strSubSequence = content;
        if (length > 300) {
            MainLogger.m7258i(TAG, "getDisplayContentAndExtra# Content subSequence");
            strSubSequence = content.subSequence(0, 300);
        }
        return mainListDocumentData.getIsFavorite() == 1 ? TextUtils.concat(strSubSequence, ",", context.getString(C8003R.string.notes_icon_favorite)) : strSubSequence;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x006b. Please report as an issue. */
    public static Spannable getDisplaySpan(Context context, CharSequence charSequence, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2) {
        int i4;
        int i5;
        TaskSpan taskSpan;
        boolean z5;
        int i6;
        int i7;
        Editable editable;
        Drawable drawable;
        int i8;
        float dimension;
        int i9;
        TaskSpan taskSpan2;
        Context context2 = context;
        if (charSequence == null) {
            return null;
        }
        final Editable editableNewEditable = Editable.Factory.getInstance().newEditable(charSequence);
        if (TextUtils.isEmpty(editableNewEditable)) {
            return editableNewEditable;
        }
        TaskSpan[] taskSpanArr = (TaskSpan[]) editableNewEditable.getSpans(0, editableNewEditable.length(), TaskSpan.class);
        Arrays.sort(taskSpanArr, new Comparator<TaskSpan>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.NotesHolderUtil.2
            @Override // java.util.Comparator
            public int compare(TaskSpan taskSpan3, TaskSpan taskSpan4) {
                int spanStart = editableNewEditable.getSpanStart(taskSpan3);
                int spanStart2 = editableNewEditable.getSpanStart(taskSpan4);
                if (spanStart > spanStart2) {
                    return 1;
                }
                return spanStart < spanStart2 ? -1 : 0;
            }
        });
        if (z3 && z2) {
            applyInverseColorSpan(context2, editableNewEditable);
        }
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        int length = taskSpanArr.length;
        int i10 = 0;
        while (i10 < length) {
            TaskSpan taskSpan3 = taskSpanArr[i10];
            int spanStart = editableNewEditable.getSpanStart(taskSpan3);
            int spanEnd = editableNewEditable.getSpanEnd(taskSpan3);
            int indent = taskSpan3.getIndent();
            int taskStatus = taskSpan3.getTaskStatus();
            if (taskStatus != 1) {
                if (taskStatus != 2) {
                    if (taskStatus != 4) {
                        if (taskStatus == 6) {
                            i4 = i10;
                            i5 = 33;
                            taskSpan = taskSpan3;
                            z5 = zIsRTLMode;
                            i9 = spanStart;
                            applyDimAlphaMaskColor(context2, editableNewEditable, i9, spanEnd, z, i, z3, i2);
                        } else if (taskStatus == 8) {
                            i4 = i10;
                            i5 = 33;
                            taskSpan = taskSpan3;
                            z5 = zIsRTLMode;
                            i9 = spanStart;
                            applyTaskEmpty(context2, editableNewEditable, taskSpan);
                        } else if (taskStatus != 40) {
                            switch (taskStatus) {
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    i4 = i10;
                                    i5 = 33;
                                    i9 = spanStart;
                                    applyNumberingStyle(context2, editableNewEditable, i9, spanEnd, zIsRTLMode, taskSpan3, i2, z, i, z3, indent, z4);
                                    taskSpan = taskSpan3;
                                    z5 = zIsRTLMode;
                                    break;
                                default:
                                    switch (taskStatus) {
                                        case 20:
                                            taskSpan2 = taskSpan3;
                                            i9 = spanStart;
                                            drawable = applyBulletStyle(context, editableNewEditable, i9, spanEnd, zIsRTLMode, C8003R.drawable.ic_text_bullet, i2, z, i, z3);
                                            i4 = i10;
                                            i5 = 33;
                                            i8 = 255;
                                            taskSpan = taskSpan2;
                                            z5 = zIsRTLMode;
                                            i6 = spanEnd;
                                            break;
                                        case 21:
                                            taskSpan2 = taskSpan3;
                                            i9 = spanStart;
                                            drawable = applyBulletStyle(context, editableNewEditable, i9, spanEnd, zIsRTLMode, C8003R.drawable.ic_text_bullet_white_circle, i2, z, i, z3);
                                            i4 = i10;
                                            i5 = 33;
                                            i8 = 255;
                                            taskSpan = taskSpan2;
                                            z5 = zIsRTLMode;
                                            i6 = spanEnd;
                                            break;
                                        case 22:
                                            taskSpan2 = taskSpan3;
                                            i9 = spanStart;
                                            drawable = applyBulletStyle(context, editableNewEditable, i9, spanEnd, zIsRTLMode, C8003R.drawable.ic_text_bullet_black_square, i2, z, i, z3);
                                            i4 = i10;
                                            i5 = 33;
                                            i8 = 255;
                                            taskSpan = taskSpan2;
                                            z5 = zIsRTLMode;
                                            i6 = spanEnd;
                                            break;
                                        case 23:
                                            taskSpan2 = taskSpan3;
                                            i9 = spanStart;
                                            drawable = applyBulletStyle(context2, editableNewEditable, i9, spanEnd, zIsRTLMode, C8003R.drawable.ic_text_bullet_white_square, i2, z, i, z3);
                                            i4 = i10;
                                            i5 = 33;
                                            i8 = 255;
                                            taskSpan = taskSpan2;
                                            z5 = zIsRTLMode;
                                            i6 = spanEnd;
                                            break;
                                        default:
                                            i4 = i10;
                                            i5 = 33;
                                            taskSpan = taskSpan3;
                                            z5 = zIsRTLMode;
                                            i9 = spanStart;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            i4 = i10;
                            i5 = 33;
                            taskSpan = taskSpan3;
                            z5 = zIsRTLMode;
                            i9 = spanStart;
                            addTextAlignSpan(z5, editableNewEditable, i9, spanEnd);
                        }
                        i6 = spanEnd;
                        drawable = null;
                    } else {
                        i4 = i10;
                        i5 = 33;
                        taskSpan = taskSpan3;
                        z5 = zIsRTLMode;
                        i9 = spanStart;
                        drawable = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.ic_text_bullet, context.getTheme());
                        i6 = spanEnd;
                        i8 = 0;
                    }
                    i7 = i9;
                    editable = editableNewEditable;
                } else {
                    i4 = i10;
                    i5 = 33;
                    taskSpan = taskSpan3;
                    z5 = zIsRTLMode;
                    Drawable drawable2 = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.ic_text_check_on, null);
                    Editable editable2 = editableNewEditable;
                    setTintCheckBox(context, drawable2, editable2, spanStart, spanEnd, taskSpan.getTaskStatus(), z, i, z3, i2);
                    editableNewEditable = editable2;
                    i9 = spanStart;
                    applyDimAlphaMaskColor(context, editableNewEditable, i9, spanEnd, z, i, z3, i2);
                    i6 = spanEnd;
                    drawable = drawable2;
                }
                i8 = 255;
                i7 = i9;
                editable = editableNewEditable;
            } else {
                i4 = i10;
                i5 = 33;
                taskSpan = taskSpan3;
                z5 = zIsRTLMode;
                Drawable drawable3 = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.ic_text_check_off, null);
                i6 = spanEnd;
                i7 = spanStart;
                editable = editableNewEditable;
                setTintCheckBox(context, drawable3, editable, i7, i6, taskSpan.getTaskStatus(), z, i, z3, i2);
                drawable = drawable3;
                i8 = 255;
            }
            if (drawable != null) {
                switch (taskSpan.getTaskStatus()) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        dimension = context.getResources().getDimension(z4 ? C8003R.dimen.noteslist_display_content_bullet_small_size : C8003R.dimen.noteslist_display_content_bullet_size);
                        break;
                    default:
                        dimension = context.getResources().getDimension(z4 ? C8003R.dimen.noteslist_display_content_checkbox_small_size : C8003R.dimen.noteslist_display_content_checkbox_size);
                        break;
                }
                int i11 = (int) dimension;
                applyRTL(z5, editable, i7);
                drawable.setAlpha(i8);
                editable.setSpan(new CustomImageMarginSpan(i7, drawable, (int) context.getResources().getDimension(C8003R.dimen.noteslist_display_content_task_todo_padding_right), i11, true, indent), i7, i6 + 1, i5);
            }
            editableNewEditable = editable;
            zIsRTLMode = z5;
            i10 = i4 + 1;
            context2 = context;
        }
        Editable editable3 = editableNewEditable;
        if (i2 != 0) {
            for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) editable3.getSpans(0, editable3.length(), BackgroundColorSpan.class)) {
                editable3.removeSpan(backgroundColorSpan);
            }
            editable3.setSpan(new ForegroundColorSpan(i2), 0, editable3.length(), 33);
        }
        editable3.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(z4 ? C8003R.dimen.notes_small_grid_item_text_content_size : C8003R.dimen.notes_grid_item_text_content_size)), 0, editable3.length(), 33);
        return new SpannableString(editable3);
    }

    @ColorInt
    public static int getNoteBackgroundColor(Resources resources, boolean z, boolean z2, boolean z3, @ColorInt int i) {
        return z3 ? resources.getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.basic_list_item_bg_color), null) : z2 ? resources.getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_list_item_bg_color), null) : i == resources.getColor(C8003R.color.composer_main_background_dark, null) ? resources.getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_card_view_bg_color_black), null) : !z ? ResourcesUtils.getDefaultBackgroundColor(resources) : i;
    }

    public static int getSubFolderViewById(int i) {
        try {
            return mSubFolderListItemIds[i];
        } catch (IndexOutOfBoundsException unused) {
            MainLogger.m7255e(TAG, "unexpected index: " + i);
            return -1;
        }
    }

    @ColorInt
    public static int getTextContentsColor(Context context, boolean z, boolean z2, boolean z3, @ColorInt int i) {
        return (z || z2 || z3) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color, null) : i == context.getResources().getColor(C8003R.color.composer_main_background_dark, null) ? context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_black_bg_note, null) : context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_has_bg_note, null);
    }

    public static boolean isBlackNoteListCardViewColor(Resources resources, @ColorInt int i) {
        return i == resources.getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_card_view_bg_color_black), null);
    }

    public static CharSequence removeStrikethroughSpan(CharSequence charSequence) {
        SpannableString spannableString = new SpannableString(charSequence);
        for (StrikethroughSpan strikethroughSpan : (StrikethroughSpan[]) spannableString.getSpans(0, spannableString.length(), StrikethroughSpan.class)) {
            spannableString.removeSpan(strikethroughSpan);
        }
        return spannableString;
    }

    public static CharSequence removeZeroWidthSpace(CharSequence charSequence) {
        Pattern patternCompile = Pattern.compile("\u200b", 64);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Matcher matcher = patternCompile.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            spannableStringBuilder.delete(matcher.start() - i, matcher.end() - i);
            i++;
        }
        return spannableStringBuilder;
    }

    public static SpannableString setHighlightText(TextView textView, SpannableString spannableString, String str) {
        if (textView == null) {
            return spannableString;
        }
        return HighlightTextUtils.setHighlightText(spannableString, str, textView.getPaint(), textView.getContext().getResources().getColor(C8003R.color.search_highlight_color, null));
    }

    private static void setTintCheckBox(Context context, Drawable drawable, Editable editable, int i, int i2, int i4, boolean z, int i5, boolean z2, int i6) {
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(i, i2, ForegroundColorSpan.class);
        if (foregroundColorSpanArr.length > 512) {
            return;
        }
        if (i6 != 0) {
            drawable.setTint(i6);
            return;
        }
        int foregroundColor = 0;
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            int spanStart = editable.getSpanStart(foregroundColorSpan);
            int spanEnd = editable.getSpanEnd(foregroundColorSpan);
            if (spanStart <= i) {
                if (spanStart == spanEnd) {
                    break;
                } else {
                    foregroundColor = foregroundColorSpan.getForegroundColor();
                }
            }
        }
        if (!z && foregroundColor != 0) {
            drawable.setTint(foregroundColor);
            return;
        }
        if (z2 || z) {
            if (i4 == 2) {
                drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_display_content_task_done_color, null));
                return;
            } else {
                drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_display_content_task_todo_color, null));
                return;
            }
        }
        if (i5 == context.getResources().getColor(C8003R.color.composer_main_background_dark, null)) {
            drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_item_text_content_color_black_bg_note, null));
        } else {
            drawable.setTint(context.getResources().getColor(C8003R.color.noteslist_display_content_task_done_color_has_bg, null));
        }
    }

    public static void applyTextOnlyThumbnailFgDim(View view, @ColorInt int i) {
        LayerDrawable layerDrawable;
        if (view == null || (layerDrawable = (LayerDrawable) view.getForeground()) == null) {
            return;
        }
        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(C8003R.id.notes_grid_ratio_view_text_only_fg_dim);
        if (drawableFindDrawableByLayerId == null) {
            MainLogger.m7255e(TAG, "can not find foregroundDim Drawable");
        } else {
            drawableFindDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
    }

    public static SpannableString setHighlightText(TextView textView, SpannableString spannableString, List<String> list) {
        if (textView == null) {
            return spannableString;
        }
        return HighlightTextUtils.setHighlightText(spannableString, list, textView.getPaint(), textView.getContext().getResources().getColor(C8003R.color.search_highlight_color, null));
    }
}
