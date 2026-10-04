package androidx.glance.appwidget.util;

import android.widget.RemoteViews;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "isValidMethod", "", "Landroid/widget/RemoteViews;", "methodName", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ReflectionsKt {

    @NotNull
    private static final String TAG = "GWT:Reflections";

    public static final boolean isValidMethod(@NotNull RemoteViews remoteViews, @NotNull String methodName) {
        GlanceLog.Companion companion;
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        boolean z = false;
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (Intrinsics.areEqual(declaredMethods[i].getName(), methodName)) {
                    z = true;
                    break;
                }
                i++;
            }
        } catch (Exception unused) {
            companion = GlanceLog.INSTANCE;
            sb = new StringBuilder("isValidMethod: method is null, methodName=");
        } catch (Throwable th) {
            GlanceLog.INSTANCE.m2301i(TAG, "isValidMethod: method is null, methodName=" + methodName);
            throw th;
        }
        if (!z) {
            companion = GlanceLog.INSTANCE;
            sb = new StringBuilder("isValidMethod: method is null, methodName=");
            sb.append(methodName);
            companion.m2301i(TAG, sb.toString());
        }
        return z;
    }
}
