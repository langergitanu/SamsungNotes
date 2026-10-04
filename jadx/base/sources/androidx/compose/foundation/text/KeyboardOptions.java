package androidx.compose.foundation.text;

import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.ImeOptions;
import androidx.compose.p109ui.text.input.KeyboardCapitalization;
import androidx.compose.p109ui.text.input.KeyboardType;
import androidx.compose.p109ui.text.input.PlatformImeOptions;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JBQ\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J:\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107JF\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0004\b:\u0010<J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0017\u0010?\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\b@J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000J\u0017\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\bGJ\b\u0010H\u001a\u00020IH\u0016R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u00038BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020\t8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u00078BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, m13886d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrectEnabled", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "getCapitalization-IUNYP9k", "()I", "I", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "hintLocalesOrDefault", "getHintLocalesOrDefault", "getImeAction-eUduSuo", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "isCompletelyUnspecified", "getKeyboardType-PjHm6EE", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "getShowKeyboardOnFocus", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-INvB4aQ", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "hashCode", "", "merge", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nKeyboardOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeyboardOptions.kt\nandroidx/compose/foundation/text/KeyboardOptions\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1#2:417\n*E\n"})
public final class KeyboardOptions {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);

    @NotNull
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.INSTANCE.m20692getPasswordPjHm6EE(), 0, (PlatformImeOptions) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), (LocaleList) null, 121, (DefaultConstructorMarker) null);

    @Nullable
    private final Boolean autoCorrectEnabled;
    private final int capitalization;

    @Nullable
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;

    @Nullable
    private final PlatformImeOptions platformImeOptions;

    @Nullable
    private final Boolean showKeyboardOnFocus;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        @NotNull
        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.SecureTextField;
        }

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }
    }

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i4, platformImeOptions, bool2, localeList);
    }

    /* JADX INFO: renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m16172copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i5 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i5 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i5 & 8) != 0) {
            i4 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m16178copy3m2b7yw(i, z, i2, i4);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m16173copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, Boolean bool, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i5, Object obj) {
        LocaleList localeList2;
        Boolean bool3;
        int i6;
        PlatformImeOptions platformImeOptions2;
        Boolean bool4;
        int i7;
        KeyboardOptions keyboardOptions2;
        int i8;
        if ((i5 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i5 & 2) != 0) {
            bool = keyboardOptions.autoCorrectEnabled;
        }
        if ((i5 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i5 & 8) != 0) {
            i4 = keyboardOptions.imeAction;
        }
        if ((i5 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        if ((i5 & 32) != 0) {
            bool2 = null;
        }
        if ((i5 & 64) != 0) {
            localeList2 = null;
            platformImeOptions2 = platformImeOptions;
            bool3 = bool2;
            i7 = i2;
            i6 = i4;
            i8 = i;
            bool4 = bool;
            keyboardOptions2 = keyboardOptions;
        } else {
            localeList2 = localeList;
            bool3 = bool2;
            i6 = i4;
            platformImeOptions2 = platformImeOptions;
            bool4 = bool;
            i7 = i2;
            keyboardOptions2 = keyboardOptions;
            i8 = i;
        }
        return keyboardOptions2.m16179copyINvB4aQ(i8, bool4, i7, i6, platformImeOptions2, bool3, localeList2);
    }

    /* JADX INFO: renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m16175copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i5 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i5 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i5 & 8) != 0) {
            i4 = keyboardOptions.imeAction;
        }
        if ((i5 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        int i6 = i2;
        return keyboardOptions.m16181copyij11fho(i, z, i6, i4, platformImeOptions2);
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m16176getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM20653boximpl = KeyboardCapitalization.m20653boximpl(this.capitalization);
        int value = keyboardCapitalizationM20653boximpl.getValue();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.INSTANCE;
        if (KeyboardCapitalization.m20656equalsimpl0(value, companion.m20668getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM20653boximpl = null;
        }
        return keyboardCapitalizationM20653boximpl != null ? keyboardCapitalizationM20653boximpl.getValue() : companion.m20666getNoneIUNYP9k();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.INSTANCE.getEmpty() : localeList;
    }

    /* JADX INFO: renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m16177getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM20670boximpl = KeyboardType.m20670boximpl(this.keyboardType);
        int value = keyboardTypeM20670boximpl.getValue();
        KeyboardType.Companion companion = KeyboardType.INSTANCE;
        if (KeyboardType.m20673equalsimpl0(value, companion.m20695getUnspecifiedPjHm6EE())) {
            keyboardTypeM20670boximpl = null;
        }
        return keyboardTypeM20670boximpl != null ? keyboardTypeM20670boximpl.getValue() : companion.m20694getTextPjHm6EE();
    }

    private final boolean isCompletelyUnspecified() {
        return KeyboardCapitalization.m20656equalsimpl0(this.capitalization, KeyboardCapitalization.INSTANCE.m20668getUnspecifiedIUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.m20673equalsimpl0(this.keyboardType, KeyboardType.INSTANCE.m20695getUnspecifiedPjHm6EE()) && ImeAction.m20620equalsimpl0(this.imeAction, ImeAction.INSTANCE.m20641getUnspecifiedeUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null;
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.INSTANCE.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m16178copy3m2b7yw(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m16179copyINvB4aQ(int capitalization, @Nullable Boolean autoCorrectEnabled, int keyboardType, int imeAction, @Nullable PlatformImeOptions platformImeOptions, @Nullable Boolean showKeyboardOnFocus, @Nullable LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, autoCorrectEnabled, keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m16181copyij11fho(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        return KeyboardCapitalization.m20656equalsimpl0(this.capitalization, keyboardOptions.capitalization) && Intrinsics.areEqual(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) && KeyboardType.m20673equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m20620equalsimpl0(this.imeAction, keyboardOptions.imeAction) && Intrinsics.areEqual(this.platformImeOptions, keyboardOptions.platformImeOptions) && Intrinsics.areEqual(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, keyboardOptions.hintLocales);
    }

    @Stable
    @NotNull
    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(@Nullable KeyboardOptions other) {
        if (other == null || other.isCompletelyUnspecified() || Intrinsics.areEqual(other, this)) {
            return this;
        }
        if (isCompletelyUnspecified()) {
            return other;
        }
        KeyboardCapitalization keyboardCapitalizationM20653boximpl = KeyboardCapitalization.m20653boximpl(this.capitalization);
        if (KeyboardCapitalization.m20656equalsimpl0(keyboardCapitalizationM20653boximpl.getValue(), KeyboardCapitalization.INSTANCE.m20668getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM20653boximpl = null;
        }
        int value = keyboardCapitalizationM20653boximpl != null ? keyboardCapitalizationM20653boximpl.getValue() : other.capitalization;
        Boolean bool = this.autoCorrectEnabled;
        if (bool == null) {
            bool = other.autoCorrectEnabled;
        }
        Boolean bool2 = bool;
        KeyboardType keyboardTypeM20670boximpl = KeyboardType.m20670boximpl(this.keyboardType);
        if (KeyboardType.m20673equalsimpl0(keyboardTypeM20670boximpl.getValue(), KeyboardType.INSTANCE.m20695getUnspecifiedPjHm6EE())) {
            keyboardTypeM20670boximpl = null;
        }
        int value2 = keyboardTypeM20670boximpl != null ? keyboardTypeM20670boximpl.getValue() : other.keyboardType;
        ImeAction imeActionM20617boximpl = ImeAction.m20617boximpl(this.imeAction);
        ImeAction imeAction = ImeAction.m20620equalsimpl0(imeActionM20617boximpl.getValue(), ImeAction.INSTANCE.m20641getUnspecifiedeUduSuo()) ? null : imeActionM20617boximpl;
        int value3 = imeAction != null ? imeAction.getValue() : other.imeAction;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        if (platformImeOptions == null) {
            platformImeOptions = other.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        Boolean bool3 = this.showKeyboardOnFocus;
        if (bool3 == null) {
            bool3 = other.showKeyboardOnFocus;
        }
        Boolean bool4 = bool3;
        LocaleList localeList = this.hintLocales;
        if (localeList == null) {
            localeList = other.hintLocales;
        }
        return new KeyboardOptions(value, bool2, value2, value3, platformImeOptions2, bool4, localeList, (DefaultConstructorMarker) null);
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    @Nullable
    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    @Nullable
    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m16184getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM20617boximpl = ImeAction.m20617boximpl(this.imeAction);
        int value = imeActionM20617boximpl.getValue();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        if (ImeAction.m20620equalsimpl0(value, companion.m20641getUnspecifiedeUduSuo())) {
            imeActionM20617boximpl = null;
        }
        return imeActionM20617boximpl != null ? imeActionM20617boximpl.getValue() : companion.m20633getDefaulteUduSuo();
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    @Nullable
    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Nullable
    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public int hashCode() {
        int iM20657hashCodeimpl = KeyboardCapitalization.m20657hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iM20621hashCodeimpl = (ImeAction.m20621hashCodeimpl(this.imeAction) + ((KeyboardType.m20674hashCodeimpl(this.keyboardType) + ((iM20657hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31)) * 31)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        int iHashCode = (iM20621hashCodeimpl + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31;
        Boolean bool2 = this.showKeyboardOnFocus;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return iHashCode2 + (localeList != null ? localeList.hashCode() : 0);
    }

    @NotNull
    public final KeyboardOptions merge(@Nullable KeyboardOptions other) {
        KeyboardOptions keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
        return (other == null || (keyboardOptionsFillUnspecifiedValuesWith$foundation_release = other.fillUnspecifiedValuesWith$foundation_release(this)) == null) ? this : keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
    }

    @NotNull
    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m16176getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m16177getKeyboardTypeOrDefaultPjHm6EE(), m16184getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m20658toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m20675toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m20622toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + PropertyUtils.MAPPED_DELIM2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i4, platformImeOptions, bool, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m16180copyINvB4aQ(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i4, platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i4);
    }

    private KeyboardOptions(int i, Boolean bool, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i2;
        this.imeAction = i4;
        this.platformImeOptions = platformImeOptions;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m16174copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i5 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i5 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i5 & 8) != 0) {
            i4 = keyboardOptions.imeAction;
        }
        if ((i5 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        if ((i5 & 32) != 0) {
            bool = Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release());
        }
        if ((i5 & 64) != 0) {
            localeList = keyboardOptions.hintLocales;
        }
        Boolean bool2 = bool;
        LocaleList localeList2 = localeList;
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        int i6 = i2;
        return keyboardOptions.m16180copyINvB4aQ(i, z, i6, i4, platformImeOptions2, bool2, localeList2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int iM20668getUnspecifiedIUNYP9k = (i5 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m20668getUnspecifiedIUNYP9k() : i;
        Boolean bool3 = (i5 & 2) != 0 ? null : bool;
        int iM20695getUnspecifiedPjHm6EE = (i5 & 4) != 0 ? KeyboardType.INSTANCE.m20695getUnspecifiedPjHm6EE() : i2;
        int iM20641getUnspecifiedeUduSuo = (i5 & 8) != 0 ? ImeAction.INSTANCE.m20641getUnspecifiedeUduSuo() : i4;
        PlatformImeOptions platformImeOptions2 = (i5 & 16) != 0 ? null : platformImeOptions;
        Boolean bool4 = (i5 & 32) != 0 ? null : bool2;
        this(iM20668getUnspecifiedIUNYP9k, bool3, iM20695getUnspecifiedPjHm6EE, iM20641getUnspecifiedeUduSuo, platformImeOptions2, bool4, (i5 & 64) == 0 ? localeList : null, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m20668getUnspecifiedIUNYP9k() : i, z, (i5 & 4) != 0 ? KeyboardType.INSTANCE.m20695getUnspecifiedPjHm6EE() : i2, (i5 & 8) != 0 ? ImeAction.INSTANCE.m20641getUnspecifiedeUduSuo() : i4, (i5 & 16) != 0 ? null : platformImeOptions, (i5 & 32) != 0 ? null : bool, (i5 & 64) != 0 ? null : localeList, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList) {
        this(i, Boolean.valueOf(z), i2, i4, platformImeOptions, bool, localeList, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m20668getUnspecifiedIUNYP9k() : i, (i5 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i5 & 4) != 0 ? KeyboardType.INSTANCE.m20695getUnspecifiedPjHm6EE() : i2, (i5 & 8) != 0 ? ImeAction.INSTANCE.m20633getDefaulteUduSuo() : i4, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i4) {
        this(i, Boolean.valueOf(z), i2, i4, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 96, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m20666getNoneIUNYP9k() : i, (i5 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i5 & 4) != 0 ? KeyboardType.INSTANCE.m20694getTextPjHm6EE() : i2, (i5 & 8) != 0 ? ImeAction.INSTANCE.m20633getDefaulteUduSuo() : i4, (i5 & 16) != 0 ? null : platformImeOptions, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i4, PlatformImeOptions platformImeOptions) {
        this(i, Boolean.valueOf(z), i2, i4, platformImeOptions, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), (LocaleList) null, 64, (DefaultConstructorMarker) null);
    }
}
