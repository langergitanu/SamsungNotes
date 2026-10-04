package androidx.compose.p109ui.text.input;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.runtime.Immutable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+BE\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB9\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eBM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"JX\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, m13886d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ImeOptions {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, null, null, 127, null);
    private final boolean autoCorrect;
    private final int capitalization;

    @NotNull
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;

    @Nullable
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i4, platformImeOptions, localeList);
    }

    /* JADX INFO: renamed from: copy-YTHSh70$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m20642copyYTHSh70$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i5 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i5 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i5 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i5 & 16) != 0) {
            i4 = imeOptions.imeAction;
        }
        if ((i5 & 32) != 0) {
            platformImeOptions = imeOptions.platformImeOptions;
        }
        int i6 = i4;
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        return imeOptions.m20645copyYTHSh70(z, i, z2, i2, i6, platformImeOptions2);
    }

    /* JADX INFO: renamed from: copy-uxg59PA$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m20643copyuxg59PA$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i5 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i5 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i5 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i5 & 16) != 0) {
            i4 = imeOptions.imeAction;
        }
        int i6 = i4;
        boolean z3 = z2;
        return imeOptions.m20646copyuxg59PA(z, i, z3, i2, i6);
    }

    /* JADX INFO: renamed from: copy-wBHncE4$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m20644copywBHncE4$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, LocaleList localeList, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i5 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i5 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i5 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i5 & 16) != 0) {
            i4 = imeOptions.imeAction;
        }
        if ((i5 & 32) != 0) {
            platformImeOptions = imeOptions.platformImeOptions;
        }
        if ((i5 & 64) != 0) {
            localeList = imeOptions.hintLocales;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        LocaleList localeList2 = localeList;
        int i6 = i4;
        boolean z3 = z2;
        return imeOptions.m20647copywBHncE4(z, i, z3, i2, i6, platformImeOptions2, localeList2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional hintLocales parameter.")
    /* JADX INFO: renamed from: copy-YTHSh70, reason: not valid java name */
    public final /* synthetic */ ImeOptions m20645copyYTHSh70(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, this.hintLocales, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-uxg59PA, reason: not valid java name */
    public final /* synthetic */ ImeOptions m20646copyuxg59PA(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, this.platformImeOptions, this.hintLocales, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-wBHncE4, reason: not valid java name */
    public final ImeOptions m20647copywBHncE4(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, @Nullable PlatformImeOptions platformImeOptions, @NotNull LocaleList hintLocales) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) other;
        return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m20656equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m20673equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m20620equalsimpl0(this.imeAction, imeOptions.imeAction) && Intrinsics.areEqual(this.platformImeOptions, imeOptions.platformImeOptions) && Intrinsics.areEqual(this.hintLocales, imeOptions.hintLocales);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    @NotNull
    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    @Nullable
    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        int iM20621hashCodeimpl = (ImeAction.m20621hashCodeimpl(this.imeAction) + ((KeyboardType.m20674hashCodeimpl(this.keyboardType) + AbstractC0622a.m1160f(this.autoCorrect, (KeyboardCapitalization.m20657hashCodeimpl(this.capitalization) + (Boolean.hashCode(this.singleLine) * 31)) * 31, 31)) * 31)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        return this.hintLocales.hashCode() + ((iM20621hashCodeimpl + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) KeyboardCapitalization.m20658toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m20675toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m20622toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + ", hintLocales=" + this.hintLocales + PropertyUtils.MAPPED_DELIM2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional hintLocales parameter.")
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i4, platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i4);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, LocaleList localeList) {
        this.singleLine = z;
        this.capitalization = i;
        this.autoCorrect = z2;
        this.keyboardType = i2;
        this.imeAction = i4;
        this.platformImeOptions = platformImeOptions;
        this.hintLocales = localeList;
    }

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, LocaleList localeList, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m20666getNoneIUNYP9k() : i, (i5 & 4) != 0 ? true : z2, (i5 & 8) != 0 ? KeyboardType.INSTANCE.m20694getTextPjHm6EE() : i2, (i5 & 16) != 0 ? ImeAction.INSTANCE.m20633getDefaulteUduSuo() : i4, (i5 & 32) != 0 ? null : platformImeOptions, (i5 & 64) != 0 ? LocaleList.INSTANCE.getEmpty() : localeList, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m20666getNoneIUNYP9k() : i, (i5 & 4) != 0 ? true : z2, (i5 & 8) != 0 ? KeyboardType.INSTANCE.m20694getTextPjHm6EE() : i2, (i5 & 16) != 0 ? ImeAction.INSTANCE.m20633getDefaulteUduSuo() : i4, (i5 & 32) != 0 ? null : platformImeOptions, (DefaultConstructorMarker) null);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i4, PlatformImeOptions platformImeOptions) {
        this(z, i, z2, i2, i4, platformImeOptions, LocaleList.INSTANCE.getEmpty(), (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m20666getNoneIUNYP9k() : i, (i5 & 4) != 0 ? true : z2, (i5 & 8) != 0 ? KeyboardType.INSTANCE.m20694getTextPjHm6EE() : i2, (i5 & 16) != 0 ? ImeAction.INSTANCE.m20633getDefaulteUduSuo() : i4, (DefaultConstructorMarker) null);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i4) {
        this(z, i, z2, i2, i4, null, null, 64, null);
    }
}
