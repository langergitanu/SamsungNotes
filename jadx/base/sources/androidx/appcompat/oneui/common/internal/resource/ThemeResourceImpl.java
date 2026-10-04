package androidx.appcompat.oneui.common.internal.resource;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.SeslMisc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/resource/ThemeResourceImpl;", "T", "Landroidx/appcompat/oneui/common/internal/resource/ThemeResource;", "resourceLight", "resourceDark", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getResource", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ThemeResourceImpl<T> extends ThemeResource<T> {
    private final T resourceDark;
    private final T resourceLight;

    public ThemeResourceImpl(T t, T t2) {
        this.resourceLight = t;
        this.resourceDark = t2;
    }

    @Override // androidx.appcompat.oneui.common.internal.resource.ThemeResource
    public T getResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SeslMisc.isLightTheme(context) ? this.resourceLight : this.resourceDark;
    }
}
