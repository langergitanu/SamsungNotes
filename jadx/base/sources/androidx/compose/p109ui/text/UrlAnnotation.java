package androidx.compose.p109ui.text;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@ExperimentalTextApi
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m13886d2 = {"Landroidx/compose/ui/text/UrlAnnotation;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Deprecated(message = "Use LinkAnnotatation.Url(url) instead", replaceWith = @ReplaceWith(expression = "LinkAnnotation.Url(url)", imports = {}))
public final class UrlAnnotation {
    public static final int $stable = 0;

    @NotNull
    private final String url;

    public UrlAnnotation(@NotNull String str) {
        this.url = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UrlAnnotation) && Intrinsics.areEqual(this.url, ((UrlAnnotation) other).url);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.url, new StringBuilder("UrlAnnotation(url="));
    }
}
