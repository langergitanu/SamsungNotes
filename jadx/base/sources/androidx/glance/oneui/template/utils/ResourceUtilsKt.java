package androidx.glance.oneui.template.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DimenRes;
import com.microsoft.identity.common.java.WarningType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0001¨\u0006\u0005"}, m13886d2 = {"getFloat", "", "Landroid/content/Context;", "sizeResId", "", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ResourceUtilsKt {
    @SuppressLint({WarningType.NewApi})
    public static final float getFloat(@NotNull Context context, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getFloat(i);
    }
}
