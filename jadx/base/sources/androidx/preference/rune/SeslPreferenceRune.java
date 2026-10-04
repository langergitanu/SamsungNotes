package androidx.preference.rune;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Landroidx/preference/rune/SeslPreferenceRune;", "", "()V", "WIDGET_BASIC_INTERACTION", "", "RunePreferenceType", "preference_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SeslPreferenceRune {

    @NotNull
    public static final SeslPreferenceRune INSTANCE = new SeslPreferenceRune();
    public static final boolean WIDGET_BASIC_INTERACTION = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @BooleanDef({true})
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m13886d2 = {"Landroidx/preference/rune/SeslPreferenceRune$RunePreferenceType;", "", "preference_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RunePreferenceType {
    }

    private SeslPreferenceRune() {
    }
}
