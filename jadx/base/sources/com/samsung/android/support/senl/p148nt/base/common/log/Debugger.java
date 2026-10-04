package com.samsung.android.support.senl.p148nt.base.common.log;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/log/Debugger;", "", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class Debugger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final boolean DEBUG = false;
    public static final boolean FILE_LOG = false;

    @NotNull
    private static final String IMPORTANTSYNCTAG = "SC/@";

    @NotNull
    private static final String ONLYSYNCTAG = "SC/";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0007J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0007J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\"\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/log/Debugger$Companion;", "", "<init>", "()V", "DEBUG", "", "ONLYSYNCTAG", "", "IMPORTANTSYNCTAG", "FILE_LOG", "d", "", "tag", "msg", "longLog", "str", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "t", "", "i", "s", "context", "Landroid/content/Context;", "w", "f", "ef", "getEncode", "content", "getShortStackTrace", "pii", "printMemory", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nDebugger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Debugger.kt\ncom/samsung/android/support/senl/nt/base/common/log/Debugger$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,177:1\n739#2,9:178\n37#3:187\n36#3,3:188\n*S KotlinDebug\n*F\n+ 1 Debugger.kt\ncom/samsung/android/support/senl/nt/base/common/log/Debugger$Companion\n*L\n133#1:178,9\n133#1:187\n133#1:188,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getShortStackTrace(Throwable e) {
            List listEmptyList;
            try {
                String stackTraceString = Log.getStackTraceString(e);
                Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(...)");
                List<String> listSplit = new Regex("\\r?\\n").split(stackTraceString, 0);
                if (listSplit.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                }
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                int i = 0;
                boolean z = false;
                for (int i2 = 0; i2 < length; i2++) {
                    if (StringsKt.m14162r(strArr[i2], "Caused by")) {
                        sb.append("\nCaused by");
                        i = 0;
                        z = true;
                    }
                    if (!z) {
                        int i4 = i + 1;
                        if (i < 4) {
                            if (i2 != 0) {
                                sb.append('\n');
                            }
                            sb.append(strArr[i2]);
                        }
                        i = i4;
                    }
                    if (z) {
                        int i5 = i + 1;
                        if (i < 3) {
                            sb.append('\n');
                            sb.append(strArr[i2]);
                        }
                        i = i5;
                    }
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            } catch (Exception e2) {
                m8621e("Debugger", "getShortStackTrace, e : " + e2.getMessage());
                return "getShortStackTrace() : invalid throwable!";
            }
        }

        private final void longLog(String tag, String str) {
            if (str.length() <= 3500) {
                Logger.m8697d(AbstractC0541b.m772n(Debugger.ONLYSYNCTAG, tag), "longLog".concat(str));
                return;
            }
            String strM772n = AbstractC0541b.m772n(Debugger.ONLYSYNCTAG, tag);
            String strSubstring = str.substring(0, 3500);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Logger.m8697d(strM772n, "longLog#" + strSubstring);
            String strSubstring2 = str.substring(3500);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            longLog(tag, strSubstring2);
        }

        @JvmStatic
        /* JADX INFO: renamed from: d */
        public final void m8619d(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Logger.m8697d(Debugger.ONLYSYNCTAG + tag, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m8621e(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8698e(Debugger.IMPORTANTSYNCTAG + tag, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: ef */
        public final void m8625ef(@NotNull String tag, @NotNull String msg, @Nullable Throwable e) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            m8626f(tag, msg + ", error = " + getShortStackTrace(e));
        }

        @JvmStatic
        /* JADX INFO: renamed from: f */
        public final void m8626f(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8700f(Debugger.IMPORTANTSYNCTAG + tag, String.valueOf(msg));
        }

        @JvmStatic
        @Nullable
        public final String getEncode(@Nullable String content) {
            return Logger.getEncode(content);
        }

        @JvmStatic
        /* JADX INFO: renamed from: i */
        public final void m8627i(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Logger.m8702i(Debugger.IMPORTANTSYNCTAG + tag, msg);
        }

        @JvmStatic
        @NotNull
        public final String pii(@Nullable String content) {
            return Logger.pii(content);
        }

        @JvmStatic
        public final void printMemory(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            LoggerBase.INSTANCE.printMemory(tag, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: s */
        public final void m8628s(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
        }

        /* JADX INFO: renamed from: t */
        public final void m8630t(@NotNull String tag, @Nullable String msg, @Nullable Context context) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8697d(Debugger.ONLYSYNCTAG + tag, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: w */
        public final void m8631w(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8703w(Debugger.ONLYSYNCTAG + tag, msg);
        }

        private Companion() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m8620e(@NotNull Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Logger.m8699e(Debugger.IMPORTANTSYNCTAG, e.getMessage(), e);
        }

        @JvmStatic
        /* JADX INFO: renamed from: ef */
        public final void m8624ef(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            m8626f(tag, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: s */
        public final void m8629s(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m8623e(@NotNull String tag, @Nullable Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Logger.m8698e(Debugger.IMPORTANTSYNCTAG + tag, getShortStackTrace(t));
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m8622e(@NotNull String tag, @NotNull String msg, @Nullable Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Logger.m8698e(Debugger.IMPORTANTSYNCTAG + tag, msg + getShortStackTrace(t));
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m8607d(@NotNull String str, @NotNull String str2) {
        INSTANCE.m8619d(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8608e(@NotNull Exception exc) {
        INSTANCE.m8620e(exc);
    }

    @JvmStatic
    /* JADX INFO: renamed from: ef */
    public static final void m8612ef(@NotNull String str, @Nullable String str2) {
        INSTANCE.m8624ef(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m8614f(@NotNull String str, @Nullable String str2) {
        INSTANCE.m8626f(str, str2);
    }

    @JvmStatic
    @Nullable
    public static final String getEncode(@Nullable String str) {
        return INSTANCE.getEncode(str);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m8615i(@NotNull String str, @NotNull String str2) {
        INSTANCE.m8627i(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String pii(@Nullable String str) {
        return INSTANCE.pii(str);
    }

    @JvmStatic
    public static final void printMemory(@NotNull String str, @NotNull String str2) {
        INSTANCE.printMemory(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: s */
    public static final void m8616s(@NotNull String str, @NotNull String str2) {
        INSTANCE.m8628s(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m8618w(@NotNull String str, @Nullable String str2) {
        INSTANCE.m8631w(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8609e(@NotNull String str, @Nullable String str2) {
        INSTANCE.m8621e(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: ef */
    public static final void m8613ef(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        INSTANCE.m8625ef(str, str2, th);
    }

    @JvmStatic
    /* JADX INFO: renamed from: s */
    public static final void m8617s(@NotNull String str, @Nullable String str2, @Nullable Throwable th) {
        INSTANCE.m8629s(str, str2, th);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8610e(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        INSTANCE.m8622e(str, str2, th);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m8611e(@NotNull String str, @Nullable Throwable th) {
        INSTANCE.m8623e(str, th);
    }
}
