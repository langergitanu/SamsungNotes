package androidx.glance.oneui.common;

import android.util.Log;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/glance/oneui/common/GlanceLog;", "", "()V", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GlanceLog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String caller = XMPConst.ARRAY_ITEM_NAME;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/oneui/common/GlanceLog$Companion;", "", "()V", NotesConstants.KEY_CALLER, "", "getCaller", "()Ljava/lang/String;", "setCaller", "(Ljava/lang/String;)V", "d", "", "tag", "msg", "tr", "", "e", "i", "init", VPathDataCmd.RCurveTo, "w", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: d */
        public final void m2298d(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
        }

        /* JADX INFO: renamed from: e */
        public final void m2299e(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.e(tag, getCaller() + " " + msg);
        }

        @NotNull
        public final String getCaller() {
            return GlanceLog.caller;
        }

        /* JADX INFO: renamed from: i */
        public final void m2301i(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.i(tag, getCaller() + " " + msg);
        }

        public final void init(@NotNull String caller) {
            Intrinsics.checkNotNullParameter(caller, "caller");
            setCaller("[" + StringsKt__StringsKt.substringAfterLast$default(caller, '.', (String) null, 2, (Object) null) + "]");
        }

        public final void setCaller(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            GlanceLog.caller = str;
        }

        /* JADX INFO: renamed from: v */
        public final void m2303v(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.v(tag, getCaller() + " " + msg);
        }

        /* JADX INFO: renamed from: w */
        public final void m2305w(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.w(tag, getCaller() + " " + msg);
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: d */
        public final void m2297d(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Log.d(tag, getCaller() + " " + msg);
        }

        /* JADX INFO: renamed from: e */
        public final void m2300e(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            Log.e(tag, getCaller() + " " + msg, tr);
        }

        /* JADX INFO: renamed from: i */
        public final void m2302i(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            Log.i(tag, getCaller() + " " + msg, tr);
        }

        /* JADX INFO: renamed from: v */
        public final void m2304v(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            Log.v(tag, getCaller() + " " + msg, tr);
        }

        /* JADX INFO: renamed from: w */
        public final void m2306w(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            Log.w(tag, getCaller() + " " + msg, tr);
        }
    }
}
