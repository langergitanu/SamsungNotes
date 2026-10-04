package com.samsung.android.support.senl.p145cm.base.common.util;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.text.Normalizer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/UnicodeUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "UNIT_SEPARATOR", "NBSP", "ZWS", "RLM", "OBJECT_REPLACEMENT", "REPLACEMENT", "EMPTY_STRING", "normalizeNFC", "text", "removeObjectReplacementChar", "removeUnicode", "unicode", "replaceUnicode", "to", "Builder", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UnicodeUtils {

    @NotNull
    private static final String EMPTY_STRING = "";

    @NotNull
    public static final UnicodeUtils INSTANCE = new UnicodeUtils();

    @NotNull
    public static final String NBSP = " ";

    @NotNull
    public static final String OBJECT_REPLACEMENT = "￼";

    @NotNull
    public static final String REPLACEMENT = "�";

    @NotNull
    public static final String RLM = "\u200f";

    @NotNull
    private static final String TAG = "UnicodeUtils";

    @NotNull
    public static final String UNIT_SEPARATOR = "\u001f";

    @NotNull
    public static final String ZWS = "\u200b";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/UnicodeUtils$Builder;", "", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "remove", "unicode", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "to", "trim", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Builder {

        @NotNull
        private String text;

        public Builder(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final Builder remove(@NotNull String unicode) {
            Intrinsics.checkNotNullParameter(unicode, "unicode");
            this.text = UnicodeUtils.removeUnicode(this.text, unicode);
            return this;
        }

        @NotNull
        public final Builder replace(@NotNull String unicode, @NotNull String to) {
            Intrinsics.checkNotNullParameter(unicode, "unicode");
            Intrinsics.checkNotNullParameter(to, "to");
            this.text = UnicodeUtils.replaceUnicode(this.text, unicode, to);
            return this;
        }

        public final void setText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        @NotNull
        public final Builder trim() {
            this.text = StringsKt.trim((CharSequence) this.text).toString();
            return this;
        }
    }

    private UnicodeUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String normalizeNFC(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Normalizer.Form form = Normalizer.Form.NFC;
        if (Normalizer.isNormalized(text, form)) {
            return text;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "normalizeNFC: " + companion.getEncode(text));
        String strNormalize = Normalizer.normalize(text, form);
        Intrinsics.checkNotNullExpressionValue(strNormalize, "normalize(...)");
        return strNormalize;
    }

    @JvmStatic
    @NotNull
    public static final String removeObjectReplacementChar(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return removeUnicode(text, OBJECT_REPLACEMENT);
    }

    @JvmStatic
    @NotNull
    public static final String removeUnicode(@NotNull String text, @NotNull String unicode) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(unicode, "unicode");
        return replaceUnicode(text, unicode, "");
    }

    @JvmStatic
    @NotNull
    public static final String replaceUnicode(@NotNull String text, @NotNull String unicode, @NotNull String to) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(unicode, "unicode");
        Intrinsics.checkNotNullParameter(to, "to");
        return new Regex(unicode).replace(text, to);
    }
}
