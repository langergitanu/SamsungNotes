package com.samsung.android.support.senl.p148nt.base.common.util;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.util.Pair;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6955h;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p148nt.base.common.C8878a;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.TaskSpan;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u0001:\u00042345B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0010¢\u0006\u0004\b\u0004\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020&H\u0002J \u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002J \u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002J(\u0010.\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable;", "", "mSpanObjectFactory", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;)V", "()V", "convertSpenTextToSpannableSBuilderIn", "", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "addTaskSpan", "", "maxLength", "", "objectSpanConverter", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$IObjectSpanConverter;", "isCoeditMode", "convertSpenSpansToSpans", "", "spannableTextData", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpannableTextData;", "isInvalidSpanRange", "text", "len", "start", "end", "convertSpenSpanToSpan", "spanTextSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "makeTaskSpan", "isInvalidParagraphRange", "paragraphBase", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "convertBulletParagraphToTaskSpan", "Landroidx/core/util/Pair;", "indentParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenIndentLevelParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;", "isInvalidRange", "ssb", "Landroid/text/SpannableStringBuilder;", "startPos", "endPos", "adjustPositionInEmptyTaskSpanCase", "paragraphStart", "setTaskSpan", "taskSpan", "convertObjectSpan", "converter", "IObjectSpanConverter", "SpannableTextData", "SpanObjectFactory", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConvertSpenTextToSpannable {
    public static final int COMPOSER_DEFAULT_TEXT_COLOR = -14342875;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG = false;

    @NotNull
    private static final String TAG = "ConvertSpenTextToSpannable";

    @NotNull
    private final SpanObjectFactory mSpanObjectFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\tH\u0007J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J:\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEBUG", "", "COMPOSER_DEFAULT_TEXT_COLOR", "", "subSequence", "", "string", "maxLength", "convertSpenTextToSpannableSBuilder", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "objectSpanConverter", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$IObjectSpanConverter;", "addTaskSpan", "objectFactory", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;", "isCoeditDoc", "convertExpansion", "spenExpansion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int convertExpansion(int spenExpansion) {
            if (spenExpansion != 0) {
                return spenExpansion != 1 ? 34 : 18;
            }
            return 17;
        }

        @JvmStatic
        @NotNull
        public final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape objectShape, @Nullable IObjectSpanConverter objectSpanConverter) {
            Intrinsics.checkNotNullParameter(objectShape, "objectShape");
            return convertSpenTextToSpannableSBuilder(objectShape, false, -1, objectSpanConverter);
        }

        @JvmStatic
        @NotNull
        public final CharSequence subSequence(@Nullable CharSequence string, int maxLength) {
            return string == null ? "" : string.length() >= maxLength ? string.subSequence(0, maxLength) : string;
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape objectShape, boolean addTaskSpan, int maxLength, @Nullable IObjectSpanConverter objectSpanConverter) {
            Intrinsics.checkNotNullParameter(objectShape, "objectShape");
            return new ConvertSpenTextToSpannable().convertSpenTextToSpannableSBuilderIn(objectShape, addTaskSpan, maxLength, objectSpanConverter, false);
        }

        @JvmStatic
        @NotNull
        public final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape objectShape, boolean addTaskSpan, int maxLength, @Nullable IObjectSpanConverter objectSpanConverter, @NotNull SpanObjectFactory objectFactory, boolean isCoeditDoc) {
            Intrinsics.checkNotNullParameter(objectShape, "objectShape");
            Intrinsics.checkNotNullParameter(objectFactory, "objectFactory");
            return new ConvertSpenTextToSpannable(objectFactory).convertSpenTextToSpannableSBuilderIn(objectShape, addTaskSpan, maxLength, objectSpanConverter, isCoeditDoc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$IObjectSpanConverter;", "", MarkdownConverter.PREFIX_NAME, "", "objectSpanList", "", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "result", "Landroid/text/SpannableStringBuilder;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IObjectSpanConverter {
        void convert(@NotNull List<SpenObjectSpan> objectSpanList, @NotNull SpannableStringBuilder result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;", "", "<init>", "()V", "getSpanText", "", "text", "maxLength", "", "createSpannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "", "createStyleSpan", "Landroid/text/style/StyleSpan;", "type", "createStrikethroughSpan", "Landroid/text/style/StrikethroughSpan;", "createUnderlineSpan", "Landroid/text/style/UnderlineSpan;", "createForegroundColorSpan", "Landroid/text/style/ForegroundColorSpan;", "color", "createBackgroundColorSpan", "Landroid/text/style/BackgroundColorSpan;", "createAbsoluteSizeSpan", "Landroid/text/style/AbsoluteSizeSpan;", "size", "createTaskSpan", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/TaskSpan;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class SpanObjectFactory {
        @Nullable
        public AbsoluteSizeSpan createAbsoluteSizeSpan(int size) {
            return new AbsoluteSizeSpan(size, true);
        }

        @Nullable
        public BackgroundColorSpan createBackgroundColorSpan(int color) {
            return new BackgroundColorSpan(color);
        }

        @Nullable
        public ForegroundColorSpan createForegroundColorSpan(int color) {
            return new ForegroundColorSpan(color);
        }

        @NotNull
        public SpannableStringBuilder createSpannableStringBuilder(@NotNull CharSequence text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new SpannableStringBuilder(text);
        }

        @Nullable
        public StrikethroughSpan createStrikethroughSpan() {
            return new StrikethroughSpan();
        }

        @Nullable
        public StyleSpan createStyleSpan(int type) {
            return new StyleSpan(type);
        }

        @NotNull
        public TaskSpan createTaskSpan(int type) {
            return new TaskSpan(type);
        }

        @Nullable
        public UnderlineSpan createUnderlineSpan() {
            return new UnderlineSpan();
        }

        @NotNull
        public String getSpanText(@NotNull String text, int maxLength) {
            Intrinsics.checkNotNullParameter(text, "text");
            if (maxLength <= 0) {
                return text;
            }
            CharSequence charSequenceSubSequence = ConvertSpenTextToSpannable.INSTANCE.subSequence(text, maxLength);
            Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type kotlin.String");
            return (String) charSequenceSubSequence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0018¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpannableTextData;", "", "mSpenObjectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "maxLength", "", "objectFactory", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;", "<init>", "(Lcom/samsung/android/sdk/pen/document/SpenObjectShape;ILcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpanObjectFactory;)V", "carriageReturnCount", "getCarriageReturnCount", "()I", "text", "", "getText", "()Ljava/lang/String;", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "getSpannableStringBuilder", "()Landroid/text/SpannableStringBuilder;", "splitStringIndex", "", "getSplitStringIndex", "()Ljava/util/List;", "mSpenTextParagraphList", "", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "mSpenTextSpanList", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "mObjectSpanList", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "spenTextSpanList", "getSpenTextSpanList", "textParagraph", "getTextParagraph", "objectSpanList", "getObjectSpanList", "adjustObjectSpanPosition", "", "base", "adjustValue", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nConvertSpenTextToSpannable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertSpenTextToSpannable.kt\ncom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpannableTextData\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,476:1\n37#2:477\n36#2,3:478\n*S KotlinDebug\n*F\n+ 1 ConvertSpenTextToSpannable.kt\ncom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$SpannableTextData\n*L\n319#1:477\n319#1:478,3\n*E\n"})
    public static final class SpannableTextData {
        private final int carriageReturnCount;

        @Nullable
        private List<SpenObjectSpan> mObjectSpanList;

        @NotNull
        private final SpenObjectShape mSpenObjectShape;

        @Nullable
        private List<? extends SpenTextParagraphBase> mSpenTextParagraphList;

        @Nullable
        private List<? extends SpenTextSpanBase> mSpenTextSpanList;

        @NotNull
        private final SpannableStringBuilder spannableStringBuilder;

        @NotNull
        private final List<Integer> splitStringIndex;

        @NotNull
        private final String text;

        public SpannableTextData(@NotNull SpenObjectShape mSpenObjectShape, int i, @NotNull SpanObjectFactory objectFactory) {
            Intrinsics.checkNotNullParameter(mSpenObjectShape, "mSpenObjectShape");
            Intrinsics.checkNotNullParameter(objectFactory, "objectFactory");
            this.mSpenObjectShape = mSpenObjectShape;
            ArrayList arrayList = new ArrayList();
            this.splitStringIndex = arrayList;
            String text = mSpenObjectShape.getText();
            Intrinsics.checkNotNull(text);
            String spanText = objectFactory.getSpanText(text, i);
            this.text = spanText;
            this.spannableStringBuilder = objectFactory.createSpannableStringBuilder(spanText);
            String[] strArr = (String[]) AbstractC12991c.m13999t(0, "[\n]", spanText).toArray(new String[0]);
            this.carriageReturnCount = strArr.length;
            arrayList.add(0);
            int iM2212c = 0;
            for (String str : strArr) {
                iM2212c = AbstractC2821a.m2212c(1, iM2212c, str);
                this.splitStringIndex.add(Integer.valueOf(iM2212c));
            }
        }

        public final void adjustObjectSpanPosition(int base, int adjustValue) {
            for (SpenObjectSpan spenObjectSpan : getObjectSpanList()) {
                if (base < spenObjectSpan.getTextIndex()) {
                    spenObjectSpan.set(spenObjectSpan.getObject(), spenObjectSpan.getTextIndex() + adjustValue);
                }
            }
        }

        public final int getCarriageReturnCount() {
            return this.carriageReturnCount;
        }

        @NotNull
        public final List<SpenObjectSpan> getObjectSpanList() {
            if (this.mObjectSpanList == null) {
                ArrayList<SpenObjectSpan> arrayListFindObjectSpan = this.mSpenObjectShape.findObjectSpan(0, this.text.length());
                this.mObjectSpanList = arrayListFindObjectSpan;
                if (arrayListFindObjectSpan == null) {
                    this.mObjectSpanList = new ArrayList(1);
                }
            }
            List<SpenObjectSpan> list = this.mObjectSpanList;
            Intrinsics.checkNotNull(list);
            return list;
        }

        @NotNull
        public final SpannableStringBuilder getSpannableStringBuilder() {
            return this.spannableStringBuilder;
        }

        @Nullable
        public final List<SpenTextSpanBase> getSpenTextSpanList() {
            if (this.mSpenTextSpanList == null) {
                this.mSpenTextSpanList = this.mSpenObjectShape.findTextSpan(0, this.text.length());
            }
            return this.mSpenTextSpanList;
        }

        @NotNull
        public final List<Integer> getSplitStringIndex() {
            return this.splitStringIndex;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final List<SpenTextParagraphBase> getTextParagraph() {
            if (this.mSpenTextParagraphList == null) {
                this.mSpenTextParagraphList = this.mSpenObjectShape.findTextParagraph(0, this.carriageReturnCount);
            }
            List list = this.mSpenTextParagraphList;
            if (list == null) {
                return new ArrayList();
            }
            Intrinsics.checkNotNull(list);
            return list;
        }
    }

    public ConvertSpenTextToSpannable(@NotNull SpanObjectFactory mSpanObjectFactory) {
        Intrinsics.checkNotNullParameter(mSpanObjectFactory, "mSpanObjectFactory");
        this.mSpanObjectFactory = mSpanObjectFactory;
    }

    private final int adjustPositionInEmptyTaskSpanCase(SpannableTextData spannableTextData, int paragraphStart, int endPos) {
        List<Integer> splitStringIndex = spannableTextData.getSplitStringIndex();
        int size = splitStringIndex.size();
        for (int i = 0; i < size; i++) {
            int iIntValue = splitStringIndex.get(i).intValue();
            if (iIntValue >= splitStringIndex.get(paragraphStart).intValue()) {
                splitStringIndex.set(i, Integer.valueOf(iIntValue + 1));
            }
        }
        spannableTextData.adjustObjectSpanPosition(endPos, 1);
        return endPos + 1;
    }

    private final Pair<Object, Object> convertBulletParagraphToTaskSpan(SpenIndentLevelParagraph indentParagraph, SpenBulletParagraph paragraphBase) {
        TaskSpan taskSpanCreateTaskSpan;
        int bulletType = paragraphBase.getBulletType();
        int bulletNumber = paragraphBase.getBulletNumber();
        int indentLevel = (indentParagraph != null && paragraphBase.getStart() == indentParagraph.getStart() && paragraphBase.getEnd() == indentParagraph.getEnd()) ? indentParagraph.getIndentLevel() : 0;
        StrikethroughSpan strikethroughSpanCreateStrikethroughSpan = null;
        if (bulletType != 2) {
            if (bulletType != 4) {
                switch (bulletType) {
                    case 6:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(12);
                        break;
                    case 7:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(13);
                        break;
                    case 8:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(20);
                        break;
                    case 9:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(21);
                        break;
                    case 10:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(11);
                        break;
                    case 11:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(22);
                        break;
                    case 12:
                        taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(23);
                        break;
                    default:
                        taskSpanCreateTaskSpan = new TaskSpan(40);
                        break;
                }
            } else {
                taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(10);
            }
        } else if (paragraphBase.getIsChecked()) {
            taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(2);
            strikethroughSpanCreateStrikethroughSpan = this.mSpanObjectFactory.createStrikethroughSpan();
        } else {
            taskSpanCreateTaskSpan = this.mSpanObjectFactory.createTaskSpan(1);
        }
        taskSpanCreateTaskSpan.setNumber(bulletNumber);
        taskSpanCreateTaskSpan.setIndent(indentLevel);
        return new Pair<>(taskSpanCreateTaskSpan, strikethroughSpanCreateStrikethroughSpan);
    }

    private final void convertObjectSpan(SpannableTextData spannableTextData, IObjectSpanConverter converter) {
        List<SpenObjectSpan> objectSpanList = spannableTextData.getObjectSpanList();
        Collections.sort(objectSpanList, new C8878a(new C6955h(2), 1));
        converter.convert(objectSpanList, spannableTextData.getSpannableStringBuilder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int convertObjectSpan$lambda$0(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
        return spenObjectSpan.getTextIndex() - spenObjectSpan2.getTextIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int convertObjectSpan$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final Object convertSpenSpanToSpan(SpenTextSpanBase spanTextSpan) {
        int type = spanTextSpan.getType();
        if (type == 1) {
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan");
            SpenForegroundColorSpan spenForegroundColorSpan = (SpenForegroundColorSpan) spanTextSpan;
            if (spenForegroundColorSpan.getColor() != -14342875) {
                return this.mSpanObjectFactory.createForegroundColorSpan(spenForegroundColorSpan.getColor());
            }
            return null;
        }
        if (type == 3) {
            SpanObjectFactory spanObjectFactory = this.mSpanObjectFactory;
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan");
            return spanObjectFactory.createAbsoluteSizeSpan((int) ((SpenFontSizeSpan) spanTextSpan).getSize());
        }
        if (type == 17) {
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan");
            SpenBackgroundColorSpan spenBackgroundColorSpan = (SpenBackgroundColorSpan) spanTextSpan;
            if (spenBackgroundColorSpan.getColor() != 0) {
                return this.mSpanObjectFactory.createBackgroundColorSpan(spenBackgroundColorSpan.getColor());
            }
            return null;
        }
        if (type == 20) {
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan");
            if (((SpenStrikethroughSpan) spanTextSpan).getIsStrikethroughStyleEnabled()) {
                return this.mSpanObjectFactory.createStrikethroughSpan();
            }
            return null;
        }
        if (type == 5) {
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan");
            if (((SpenBoldSpan) spanTextSpan).getIsBoldStyleEnabled()) {
                return this.mSpanObjectFactory.createStyleSpan(1);
            }
            return null;
        }
        if (type == 6) {
            Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan");
            if (((SpenItalicSpan) spanTextSpan).getIsItalicStyleEnabled()) {
                return this.mSpanObjectFactory.createStyleSpan(2);
            }
            return null;
        }
        if (type != 7) {
            return null;
        }
        Intrinsics.checkNotNull(spanTextSpan, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan");
        if (((SpenUnderlineSpan) spanTextSpan).getIsUnderlineStyleEnabled()) {
            return this.mSpanObjectFactory.createUnderlineSpan();
        }
        return null;
    }

    private final void convertSpenSpansToSpans(SpannableTextData spannableTextData) {
        Object objConvertSpenSpanToSpan;
        List<SpenTextSpanBase> spenTextSpanList = spannableTextData.getSpenTextSpanList();
        SpannableStringBuilder spannableStringBuilder = spannableTextData.getSpannableStringBuilder();
        Integer numValueOf = spenTextSpanList != null ? Integer.valueOf(spenTextSpanList.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        for (int i = 0; i < iIntValue; i++) {
            SpenTextSpanBase spenTextSpanBase = spenTextSpanList.get(i);
            int length = spannableStringBuilder.length();
            int start = spenTextSpanBase.getStart();
            int end = spenTextSpanBase.getEnd();
            if (!isInvalidSpanRange(spannableTextData.getText(), length, start, end) && (objConvertSpenSpanToSpan = convertSpenSpanToSpan(spenTextSpanBase)) != null) {
                spannableStringBuilder.setSpan(objConvertSpenSpanToSpan, start, (int) Math.min(length, end), INSTANCE.convertExpansion(spenTextSpanBase.getExpansion()));
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape spenObjectShape, @Nullable IObjectSpanConverter iObjectSpanConverter) {
        return INSTANCE.convertSpenTextToSpannableSBuilder(spenObjectShape, iObjectSpanConverter);
    }

    private final boolean isInvalidParagraphRange(SpannableTextData spannableTextData, SpenTextParagraphBase paragraphBase, int start, int end) {
        return end < start || start > spannableTextData.getCarriageReturnCount() || end > spannableTextData.getCarriageReturnCount() || start < 0 || start >= spannableTextData.getText().length() || paragraphBase.getType() != 5;
    }

    private final boolean isInvalidRange(SpannableStringBuilder ssb, int startPos, int endPos) {
        return endPos < startPos || startPos > ssb.length() || endPos > ssb.length() || startPos < 0;
    }

    private final boolean isInvalidSpanRange(CharSequence text, int len, int start, int end) {
        return end < start || start > len || start < 0 || start >= text.length();
    }

    private final void makeTaskSpan(SpannableTextData spannableTextData) {
        Object obj;
        List<SpenTextParagraphBase> textParagraph = spannableTextData.getTextParagraph();
        SpannableStringBuilder spannableStringBuilder = spannableTextData.getSpannableStringBuilder();
        List<Integer> splitStringIndex = spannableTextData.getSplitStringIndex();
        int size = textParagraph.size();
        SpenIndentLevelParagraph spenIndentLevelParagraph = null;
        for (int i = 0; i < size; i++) {
            SpenTextParagraphBase spenTextParagraphBase = textParagraph.get(i);
            int start = spenTextParagraphBase.getStart();
            int end = spenTextParagraphBase.getEnd();
            if (!isInvalidParagraphRange(spannableTextData, spenTextParagraphBase, start, end)) {
                Intrinsics.checkNotNull(spenTextParagraphBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph");
                Pair<Object, Object> pairConvertBulletParagraphToTaskSpan = convertBulletParagraphToTaskSpan(spenIndentLevelParagraph, (SpenBulletParagraph) spenTextParagraphBase);
                Object obj2 = pairConvertBulletParagraphToTaskSpan.first;
                int iIntValue = splitStringIndex.get(start).intValue();
                int iIntValue2 = splitStringIndex.get(end).intValue() - 1;
                if (spannableStringBuilder.length() >= iIntValue2) {
                    if (iIntValue == iIntValue2) {
                        spannableStringBuilder.insert(iIntValue, "\u200b");
                        iIntValue2 = adjustPositionInEmptyTaskSpanCase(spannableTextData, start, iIntValue2);
                    }
                    Intrinsics.checkNotNull(obj2);
                    if (setTaskSpan(spannableStringBuilder, obj2, iIntValue, iIntValue2) && (obj = pairConvertBulletParagraphToTaskSpan.second) != null) {
                        spannableStringBuilder.setSpan(obj, iIntValue, iIntValue2, 33);
                    }
                }
            } else if (spenTextParagraphBase instanceof SpenIndentLevelParagraph) {
                spenIndentLevelParagraph = (SpenIndentLevelParagraph) spenTextParagraphBase;
            }
        }
    }

    private final boolean setTaskSpan(SpannableStringBuilder ssb, Object taskSpan, int startPos, int endPos) {
        if (isInvalidRange(ssb, startPos, endPos)) {
            return false;
        }
        ssb.setSpan(taskSpan, startPos, endPos, 33);
        return true;
    }

    @JvmStatic
    @NotNull
    public static final CharSequence subSequence(@Nullable CharSequence charSequence, int i) {
        return INSTANCE.subSequence(charSequence, i);
    }

    @NotNull
    public final CharSequence convertSpenTextToSpannableSBuilderIn(@NotNull SpenObjectShape objectShape, boolean addTaskSpan, int maxLength, @Nullable IObjectSpanConverter objectSpanConverter, boolean isCoeditMode) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        SpannableTextData spannableTextData = new SpannableTextData(objectShape, maxLength, this.mSpanObjectFactory);
        List<SpenTextSpanBase> spenTextSpanList = spannableTextData.getSpenTextSpanList();
        if (spenTextSpanList == null && !isCoeditMode) {
            return this.mSpanObjectFactory.createSpannableStringBuilder(spannableTextData.getSpannableStringBuilder());
        }
        if (spenTextSpanList != null) {
            convertSpenSpansToSpans(spannableTextData);
        }
        if (addTaskSpan) {
            makeTaskSpan(spannableTextData);
        }
        if (objectSpanConverter != null) {
            convertObjectSpan(spannableTextData, objectSpanConverter);
        }
        return spannableTextData.getSpannableStringBuilder();
    }

    public ConvertSpenTextToSpannable() {
        this(new SpanObjectFactory());
    }

    @JvmStatic
    @NotNull
    public static final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape spenObjectShape, boolean z, int i, @Nullable IObjectSpanConverter iObjectSpanConverter) {
        return INSTANCE.convertSpenTextToSpannableSBuilder(spenObjectShape, z, i, iObjectSpanConverter);
    }

    @JvmStatic
    @NotNull
    public static final CharSequence convertSpenTextToSpannableSBuilder(@NotNull SpenObjectShape spenObjectShape, boolean z, int i, @Nullable IObjectSpanConverter iObjectSpanConverter, @NotNull SpanObjectFactory spanObjectFactory, boolean z2) {
        return INSTANCE.convertSpenTextToSpannableSBuilder(spenObjectShape, z, i, iObjectSpanConverter, spanObjectFactory, z2);
    }
}
