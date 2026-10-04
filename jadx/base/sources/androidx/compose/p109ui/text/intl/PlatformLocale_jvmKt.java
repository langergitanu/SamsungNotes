package androidx.compose.p109ui.text.intl;

import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import java.util.Locale;
import kotlin.Metadata;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\n\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u001c\u0010\b\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005*\n\u0010\u000b\"\u00020\u00022\u00020\u0002¨\u0006\f"}, m13886d2 = {"language", "", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getLanguage", "(Ljava/util/Locale;)Ljava/lang/String;", BuddyContract.Address.REGION, "getRegion", StringLookupFactory.KEY_SCRIPT, "getScript", "getLanguageTag", "PlatformLocale", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PlatformLocale_jvmKt {
    @NotNull
    public static final String getLanguage(@NotNull Locale locale) {
        return locale.getLanguage();
    }

    @NotNull
    public static final String getLanguageTag(@NotNull Locale locale) {
        return locale.toLanguageTag();
    }

    @NotNull
    public static final String getRegion(@NotNull Locale locale) {
        return locale.getCountry();
    }

    @NotNull
    public static final String getScript(@NotNull Locale locale) {
        return locale.getScript();
    }
}
