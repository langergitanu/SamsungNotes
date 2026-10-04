package androidx.compose.p109ui.text;

import androidx.compose.p109ui.text.intl.Locale;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.platform.AndroidStringDelegate_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"stringDelegate", "Landroidx/compose/ui/text/PlatformStringDelegate;", "capitalize", "", "locale", "Landroidx/compose/ui/text/intl/Locale;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StringKt {

    @NotNull
    private static final PlatformStringDelegate stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();

    @NotNull
    public static final String capitalize(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.capitalize(str, locale.getPlatformLocale());
    }

    @NotNull
    public static final String decapitalize(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.decapitalize(str, locale.getPlatformLocale());
    }

    @NotNull
    public static final String toLowerCase(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.toLowerCase(str, locale.getPlatformLocale());
    }

    @NotNull
    public static final String toUpperCase(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.toUpperCase(str, locale.getPlatformLocale());
    }

    @NotNull
    public static final String capitalize(@NotNull String str, @NotNull LocaleList localeList) {
        return capitalize(str, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    @NotNull
    public static final String decapitalize(@NotNull String str, @NotNull LocaleList localeList) {
        return decapitalize(str, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    @NotNull
    public static final String toLowerCase(@NotNull String str, @NotNull LocaleList localeList) {
        return toLowerCase(str, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    @NotNull
    public static final String toUpperCase(@NotNull String str, @NotNull LocaleList localeList) {
        return toUpperCase(str, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }
}
