package com.samsung.android.support.senl.p148nt.stt.base.model.paint;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\rJ \u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J(\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintHelper;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mForegroundNormalColorSpan", "Landroid/text/style/ForegroundColorSpan;", "mForegroundPlayColorSpan", "mSearchBackgroundColorSpan", "Landroid/text/style/BackgroundColorSpan;", "mSearchSelectedBackgroundColorSpan", "mSearchKeyword", "", "setSTTReplayPaintedString", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "start", "", "end", "getNormalPaintedString", "str", "getRealtimePaintedString", "getPlayPaintedString", "setNormalPaintedString", "setPlayPaintedString", "setRecordPaintedString", "updateSearchHighLight", "clearSearchHighlight", "appendSearchHighlight", "isSelected", "", "setSearchKeyWord", Bixby2Constants.BIXBY_PARAM_KEYWORD, "initSpanColor", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaintHelper {
    private static final int FLAG_EXCLUSIVE = 33;

    @Nullable
    private final Context mContext;

    @Nullable
    private ForegroundColorSpan mForegroundNormalColorSpan;

    @Nullable
    private ForegroundColorSpan mForegroundPlayColorSpan;

    @Nullable
    private BackgroundColorSpan mSearchBackgroundColorSpan;

    @Nullable
    private String mSearchKeyword;

    @Nullable
    private BackgroundColorSpan mSearchSelectedBackgroundColorSpan;

    public PaintHelper(@Nullable Context context) {
        this.mContext = context;
        initSpanColor();
    }

    public final void appendSearchHighlight(@Nullable SpannableStringBuilder spannableStringBuilder, boolean isSelected, int start, int end) {
        int length;
        if (spannableStringBuilder != null && start <= (length = spannableStringBuilder.length()) && end <= length && start >= 0 && end >= 0) {
            if (isSelected) {
                spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mSearchSelectedBackgroundColorSpan), start, end, 33);
            } else {
                spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mSearchBackgroundColorSpan), start, end, 33);
            }
        }
    }

    public final void clearSearchHighlight(@Nullable SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator((CharacterStyle[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.toString().length(), CharacterStyle.class));
        while (it.hasNext()) {
            CharacterStyle characterStyle = (CharacterStyle) it.next();
            if (characterStyle.getUnderlying() instanceof BackgroundColorSpan) {
                spannableStringBuilder.removeSpan(characterStyle);
            }
        }
    }

    @NotNull
    public final SpannableStringBuilder getNormalPaintedString(@Nullable String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundNormalColorSpan), 0, spannableStringBuilder.length(), 33);
        updateSearchHighLight(spannableStringBuilder);
        return spannableStringBuilder;
    }

    @Nullable
    public final SpannableStringBuilder getPlayPaintedString(@Nullable String str, int end) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (end >= 0 && end <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundNormalColorSpan), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), 0, end, 33);
            updateSearchHighLight(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder getRealtimePaintedString(@Nullable String str, int start, int end) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (start >= 0 && end <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), start, end, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), start, end, 33);
            updateSearchHighLight(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public final void initSpanColor() {
        if (this.mContext != null) {
            this.mForegroundNormalColorSpan = new ForegroundColorSpan(this.mContext.getColor(C11493R.color.stt_play_normal_span));
            this.mForegroundPlayColorSpan = new ForegroundColorSpan(this.mContext.getColor(C11493R.color.stt_played_span));
            this.mSearchBackgroundColorSpan = new BackgroundColorSpan(this.mContext.getColor(C11493R.color.stt_search_highlight_color));
            this.mSearchSelectedBackgroundColorSpan = new BackgroundColorSpan(this.mContext.getColor(C11493R.color.stt_search_highlight_selected_color));
        }
    }

    public final void setNormalPaintedString(@Nullable SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder != null) {
            spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundNormalColorSpan), 0, spannableStringBuilder.length(), 33);
            updateSearchHighLight(spannableStringBuilder);
        }
    }

    public final void setPlayPaintedString(@Nullable SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder != null) {
            spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), 0, spannableStringBuilder.length(), 33);
            updateSearchHighLight(spannableStringBuilder);
        }
    }

    public final void setRecordPaintedString(@Nullable SpannableStringBuilder spannableStringBuilder, int start) {
        if (spannableStringBuilder == null || start < 0 || start > spannableStringBuilder.length()) {
            return;
        }
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), start, spannableStringBuilder.length(), 33);
        updateSearchHighLight(spannableStringBuilder);
    }

    public final void setSTTReplayPaintedString(@Nullable SpannableStringBuilder spannableStringBuilder, int start, int end) {
        if (spannableStringBuilder == null || start < 0 || end > spannableStringBuilder.length()) {
            return;
        }
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), start, end, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), start, end, 33);
        updateSearchHighLight(spannableStringBuilder);
    }

    public final void setSearchKeyWord(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = keyword.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.mSearchKeyword = lowerCase;
    }

    public final void updateSearchHighLight(@Nullable SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return;
        }
        int iM14129C = 0;
        Iterator it = ArrayIteratorKt.iterator((CharacterStyle[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.toString().length(), CharacterStyle.class));
        while (it.hasNext()) {
            CharacterStyle characterStyle = (CharacterStyle) it.next();
            if (characterStyle.getUnderlying() instanceof BackgroundColorSpan) {
                spannableStringBuilder.removeSpan(characterStyle);
            }
        }
        if (TextUtils.isEmpty(this.mSearchKeyword)) {
            return;
        }
        while (iM14129C != -1) {
            String string = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str = this.mSearchKeyword;
            Intrinsics.checkNotNull(str);
            iM14129C = StringsKt.m14129C(str, iM14129C, 4, lowerCase);
            if (iM14129C != -1) {
                Object objWrap = CharacterStyle.wrap(this.mSearchBackgroundColorSpan);
                String str2 = this.mSearchKeyword;
                Intrinsics.checkNotNull(str2);
                spannableStringBuilder.setSpan(objWrap, iM14129C, str2.length() + iM14129C, 33);
                String str3 = this.mSearchKeyword;
                Intrinsics.checkNotNull(str3);
                iM14129C += str3.length();
            }
        }
    }

    public final void setPlayPaintedString(@Nullable SpannableStringBuilder spannableStringBuilder, int end) {
        if (spannableStringBuilder == null || end < 0 || end > spannableStringBuilder.length()) {
            return;
        }
        spannableStringBuilder.setSpan(CharacterStyle.wrap(this.mForegroundPlayColorSpan), 0, end, 33);
        updateSearchHighLight(spannableStringBuilder);
    }
}
