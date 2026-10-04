package androidx.glance.appwidget;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0082\b¨\u0006\u0004"}, m13886d2 = {"runAndLogExceptions", "", "block", "Lkotlin/Function0;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GlanceAppWidgetReceiverKt {
    private static final void runAndLogExceptions(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (CancellationException unused) {
        } catch (Throwable th) {
            AppWidgetUtilsKt.logException(th);
        }
    }
}
