package com.samsung.android.support.senl.p148nt.base.common.displaydata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Annotation;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.EasyEditSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TtsSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000bJ \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData;", "Landroid/os/Parcelable;", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "cs", "p", "parcelableFlags", "writeWhere", "sp", "Landroid/text/Spanned;", "o", "", "CharSequenceCreator", "CharSequenceCreatorVersion0", "CharSequenceCreatorVersion1", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayData implements Parcelable {
    public static final int ABSOLUTE_SIZE_SPAN = 16;
    public static final int ACCESSIBILITY_CLICKABLE_SPAN = 25;
    public static final int ACCESSIBILITY_URL_SPAN = 26;
    public static final int ALIGNMENT_SPAN = 1;
    public static final int ANNOTATION = 18;
    public static final int BACKGROUND_COLOR_SPAN = 12;
    public static final int BULLET_SPAN = 8;
    public static final int EASY_EDIT_SPAN = 22;
    public static final int FIRST_SPAN = 1;
    public static final int FOREGROUND_COLOR_SPAN = 2;
    public static final int LAST_SPAN = 26;
    public static final int LEADING_MARGIN_SPAN = 10;
    public static final int LOCALE_SPAN = 23;
    public static final int QUOTE_SPAN = 9;
    public static final int RELATIVE_SIZE_SPAN = 3;
    public static final int SCALE_X_SPAN = 4;
    public static final int SPELL_CHECK_SPAN = 20;
    public static final int STRIKETHROUGH_SPAN = 5;
    public static final int STYLE_SPAN = 7;
    public static final int SUBSCRIPT_SPAN = 15;
    public static final int SUGGESTION_RANGE_SPAN = 21;
    public static final int SUGGESTION_SPAN = 19;
    public static final int SUPERSCRIPT_SPAN = 14;
    public static final int TASK = 1001;
    public static final int TEXT_APPEARANCE_SPAN = 17;
    public static final int TTS_SPAN = 24;
    public static final int TYPEFACE_SPAN = 13;
    public static final int UNDERLINE_SPAN = 6;
    public static final int URL_SPAN = 11;

    @Nullable
    private CharSequence content;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR = new CharSequenceCreatorVersion0();

    @NotNull
    private static final Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR_VERSION_1 = new CharSequenceCreatorVersion1();

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DisplayData> CREATOR = new Parcelable.Creator<DisplayData>() { // from class: com.samsung.android.support.senl.nt.base.common.displaydata.DisplayData$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayData createFromParcel(Parcel src) {
            Intrinsics.checkNotNullParameter(src, "src");
            DisplayData displayData = new DisplayData();
            displayData.setContent(DisplayData.INSTANCE.getCHAR_SEQUENCE_CREATOR().createFromParcel(src));
            return displayData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayData[] newArray(int size) {
            return new DisplayData[0];
        }
    };

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DisplayData> CREATOR_VERSION_1 = new Parcelable.Creator<DisplayData>() { // from class: com.samsung.android.support.senl.nt.base.common.displaydata.DisplayData$Companion$CREATOR_VERSION_1$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayData createFromParcel(Parcel src) {
            Intrinsics.checkNotNullParameter(src, "src");
            DisplayData displayData = new DisplayData();
            displayData.setContent(DisplayData.INSTANCE.getCHAR_SEQUENCE_CREATOR_VERSION_1().createFromParcel(src));
            return displayData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisplayData[] newArray(int size) {
            return new DisplayData[0];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$CharSequenceCreator;", "Landroid/os/Parcelable$Creator;", "", "<init>", "()V", "createFromParcel", "p", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ljava/lang/CharSequence;", "readSpanFromParcel", "", "kind", "sp", "Landroid/text/SpannableStringBuilder;", "readSpan", "", "Landroid/text/Spannable;", "o", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class CharSequenceCreator implements Parcelable.Creator<CharSequence> {
        public final void readSpan(@NotNull Parcel p, @NotNull Spannable sp, @Nullable Object o) {
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(sp, "sp");
            sp.setSpan(o, p.readInt(), p.readInt(), p.readInt());
        }

        public boolean readSpanFromParcel(int kind, @NotNull SpannableStringBuilder sp, @NotNull Parcel p) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(p, "p");
            switch (kind) {
                case 1:
                    readSpan(p, sp, new AlignmentSpan.Standard(p));
                    return true;
                case 2:
                    readSpan(p, sp, new ForegroundColorSpan(p));
                    return true;
                case 3:
                    readSpan(p, sp, new RelativeSizeSpan(p));
                    return true;
                case 4:
                    readSpan(p, sp, new ScaleXSpan(p));
                    return true;
                case 5:
                    readSpan(p, sp, new StrikethroughSpan(p));
                    return true;
                case 6:
                    readSpan(p, sp, new UnderlineSpan(p));
                    return true;
                case 7:
                    readSpan(p, sp, new StyleSpan(p));
                    return true;
                case 8:
                    readSpan(p, sp, new BulletSpan(p));
                    return true;
                case 9:
                    readSpan(p, sp, new QuoteSpan(p));
                    return true;
                case 10:
                    readSpan(p, sp, new LeadingMarginSpan.Standard(p));
                    return true;
                case 11:
                    readSpan(p, sp, new URLSpan(p));
                    return true;
                case 12:
                    readSpan(p, sp, new BackgroundColorSpan(p));
                    return true;
                case 13:
                    readSpan(p, sp, new TypefaceSpan(p));
                    return true;
                case 14:
                    readSpan(p, sp, new SuperscriptSpan(p));
                    return true;
                case 15:
                    readSpan(p, sp, new SubscriptSpan(p));
                    return true;
                case 16:
                    readSpan(p, sp, new AbsoluteSizeSpan(p));
                    return true;
                case 17:
                    readSpan(p, sp, new TextAppearanceSpan(p));
                    return true;
                case 18:
                    readSpan(p, sp, new Annotation(p));
                    return true;
                case 19:
                    readSpan(p, sp, new SuggestionSpan(p));
                    return true;
                case 20:
                case 21:
                default:
                    return false;
                case 22:
                    readSpan(p, sp, new EasyEditSpan(p));
                    return true;
                case 23:
                    readSpan(p, sp, new LocaleSpan(p));
                    return true;
                case 24:
                    readSpan(p, sp, new TtsSpan(p));
                    return true;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @Nullable
        public CharSequence createFromParcel(@NotNull Parcel p) {
            int i;
            Intrinsics.checkNotNullParameter(p, "p");
            int i2 = p.readInt();
            String string = p.readString();
            if (string == null) {
                return null;
            }
            if (i2 == 1) {
                return string;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            do {
                i = p.readInt();
                if (i == 0) {
                    return spannableStringBuilder;
                }
            } while (readSpanFromParcel(i, spannableStringBuilder, p));
            throw new RuntimeException(AbstractC0000a.m11h(i, "bogus span encoding "));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CharSequence[] newArray(int size) {
            return new CharSequence[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$CharSequenceCreatorVersion0;", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$CharSequenceCreator;", "<init>", "()V", "readSpanFromParcel", "", "kind", "", "sp", "Landroid/text/SpannableStringBuilder;", "p", "Landroid/os/Parcel;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CharSequenceCreatorVersion0 extends CharSequenceCreator {
        @Override // com.samsung.android.support.senl.nt.base.common.displaydata.DisplayData.CharSequenceCreator
        public boolean readSpanFromParcel(int kind, @NotNull SpannableStringBuilder sp, @NotNull Parcel p) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(p, "p");
            if (super.readSpanFromParcel(kind, sp, p) || kind == 25 || kind == 26) {
                return true;
            }
            if (kind != 1001) {
                return false;
            }
            readSpan(p, sp, new TaskSpan(p));
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$CharSequenceCreatorVersion1;", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$CharSequenceCreator;", "<init>", "()V", "readSpanFromParcel", "", "kind", "", "sp", "Landroid/text/SpannableStringBuilder;", "p", "Landroid/os/Parcel;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CharSequenceCreatorVersion1 extends CharSequenceCreator {
        private static final int TASK_SPAN_ID_VERSION_1 = 25;

        @Override // com.samsung.android.support.senl.nt.base.common.displaydata.DisplayData.CharSequenceCreator
        public boolean readSpanFromParcel(int kind, @NotNull SpannableStringBuilder sp, @NotNull Parcel p) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(p, "p");
            if (super.readSpanFromParcel(kind, sp, p)) {
                return true;
            }
            if (kind != 25) {
                return false;
            }
            readSpan(p, sp, new TaskSpan(p));
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\"8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\"8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData$Companion;", "", "<init>", "()V", "ALIGNMENT_SPAN", "", "FIRST_SPAN", "FOREGROUND_COLOR_SPAN", "RELATIVE_SIZE_SPAN", "SCALE_X_SPAN", "STRIKETHROUGH_SPAN", "UNDERLINE_SPAN", "STYLE_SPAN", "BULLET_SPAN", "QUOTE_SPAN", "LEADING_MARGIN_SPAN", "URL_SPAN", "BACKGROUND_COLOR_SPAN", "TYPEFACE_SPAN", "SUPERSCRIPT_SPAN", "SUBSCRIPT_SPAN", "ABSOLUTE_SIZE_SPAN", "TEXT_APPEARANCE_SPAN", "ANNOTATION", "SUGGESTION_SPAN", "SPELL_CHECK_SPAN", "SUGGESTION_RANGE_SPAN", "EASY_EDIT_SPAN", "LOCALE_SPAN", "TTS_SPAN", "ACCESSIBILITY_CLICKABLE_SPAN", "ACCESSIBILITY_URL_SPAN", "LAST_SPAN", "CHAR_SEQUENCE_CREATOR", "Landroid/os/Parcelable$Creator;", "", "getCHAR_SEQUENCE_CREATOR", "()Landroid/os/Parcelable$Creator;", "CHAR_SEQUENCE_CREATOR_VERSION_1", "getCHAR_SEQUENCE_CREATOR_VERSION_1", "CREATOR", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayData;", "CREATOR_VERSION_1", "TASK", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Parcelable.Creator<CharSequence> getCHAR_SEQUENCE_CREATOR() {
            return DisplayData.CHAR_SEQUENCE_CREATOR;
        }

        @NotNull
        public final Parcelable.Creator<CharSequence> getCHAR_SEQUENCE_CREATOR_VERSION_1() {
            return DisplayData.CHAR_SEQUENCE_CREATOR_VERSION_1;
        }

        private Companion() {
        }
    }

    private final void writeWhere(Parcel p, Spanned sp, Object o) {
        p.writeInt(sp.getSpanStart(o));
        p.writeInt(sp.getSpanEnd(o));
        p.writeInt(sp.getSpanFlags(o));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final CharSequence getContent() {
        return this.content;
    }

    public final void setContent(@Nullable CharSequence charSequence) {
        this.content = charSequence;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        writeToParcel(this.content, dest, flags);
    }

    public final void writeToParcel(@Nullable CharSequence cs, @NotNull Parcel p, int parcelableFlags) {
        Intrinsics.checkNotNullParameter(p, "p");
        if (!(cs instanceof Spanned)) {
            p.writeInt(1);
            if (cs != null) {
                p.writeString(cs.toString());
                return;
            } else {
                p.writeString(null);
                return;
            }
        }
        p.writeInt(0);
        p.writeString(cs.toString());
        Spanned spanned = (Spanned) cs;
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            Object underlying = obj instanceof CharacterStyle ? ((CharacterStyle) obj).getUnderlying() : obj;
            if (underlying instanceof ParcelableSpan) {
                ParcelableSpan parcelableSpan = (ParcelableSpan) underlying;
                p.writeInt(parcelableSpan.getSpanTypeId());
                parcelableSpan.writeToParcel(p, parcelableFlags);
                Intrinsics.checkNotNull(obj);
                writeWhere(p, spanned, obj);
            }
        }
        p.writeInt(0);
    }
}
