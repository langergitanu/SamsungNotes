package androidx.core.rune;

import androidx.core.rune.SeslCoreRune;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0081\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/core/rune/SeslCoreRuneSupport;", "", "value", "", "()Z", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SeslCoreRuneSupport {
    @SeslCoreRune.RuneType
    boolean value() default false;
}
