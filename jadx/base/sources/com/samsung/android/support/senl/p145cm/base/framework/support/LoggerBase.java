package com.samsung.android.support.senl.p145cm.base.framework.support;

import android.content.Context;
import android.os.Binder;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UnknownFormatConversionException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/LoggerBase;", "", "<init>", "()V", "LogParam", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class LoggerBase {
    private static final int LOG_FILE_MAX_COUNT = 2;

    @NotNull
    private static final String LOG_FILE_NAME = "NotesFileLog%g.log";
    private static final int LOG_FILE_SIZE_LIMIT = 1048576;
    protected static final float MB_UNIT = 1048576.0f;

    @NotNull
    private static final String PKG_NAME = "com.samsung.android.app.notes";

    @NotNull
    protected static final String TIME_TAG = "[Performance]";
    private static final boolean mEnableFileLogger = true;
    private static final boolean mIsEngBuildType = true;

    @Nullable
    private static Logger mLogger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String APP_TAG = "SENL$";

    @NotNull
    private static final String TAG = AbstractC0541b.m756B("SENL$", "LoggerBase");

    @NotNull
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(".##");

    @NotNull
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    @NotNull
    private static final Date mDate = new Date();

    @NotNull
    private static final ArrayList<LogParam> mCumulativeLogs = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0007J\u001a\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010'\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010'\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u001c\u0010*\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010+\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010,\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0007J\"\u0010,\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\"\u0010-\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0012H\u0002J\u0012\u00101\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010;J\u0012\u0010<\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\u0010:\u001a\u0004\u0018\u00010;J\u001a\u0010@\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005H\u0007J\u0018\u0010A\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005J\u001a\u0010B\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/LoggerBase$Companion;", "", "<init>", "()V", "APP_TAG", "", "getAPP_TAG", "()Ljava/lang/String;", "setAPP_TAG", "(Ljava/lang/String;)V", SearchConstants.TargetContents.TAG, "mIsEngBuildType", "", "mEnableFileLogger", "TIME_TAG", "MB_UNIT", "", "LOG_FILE_SIZE_LIMIT", "", "LOG_FILE_MAX_COUNT", "LOG_FILE_NAME", "DECIMAL_FORMAT", "Ljava/text/DecimalFormat;", "formatter", "Ljava/text/SimpleDateFormat;", "mDate", "Ljava/util/Date;", "mLogger", "Ljava/util/logging/Logger;", "mCumulativeLogs", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/cm/base/framework/support/LoggerBase$LogParam;", "Lkotlin/collections/ArrayList;", "PKG_NAME", "createTag", "tag", "d", "", "msg", "e", "t", "", "i", "w", "f", "printFileLog", "getStarString", "str", "remainCount", "pii", "getEncode", "content", "wrapEncodedLog", "encodedLog", "getTimeString", "ms", "", "setupFileLogger", "context", "Landroid/content/Context;", "getLogFilePath", "getLogFiles", "", "Ljava/io/File;", "printMemory", "printNativeHeapMemory", "printRuntimeMemory", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLoggerBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoggerBase.kt\ncom/samsung/android/support/senl/cm/base/framework/support/LoggerBase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,315:1\n1#2:316\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getStarString(String str, int remainCount) {
            int length = str.length();
            int i = length - (remainCount * 2);
            StringBuilder sb = new StringBuilder();
            String strSubstring = str.substring(0, remainCount);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append('*');
            }
            String strSubstring2 = str.substring(length - remainCount, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            sb.append(strSubstring2);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean printFileLog(String tag, String msg, Throwable t) {
            Logger logger;
            if (LoggerBase.mLogger == null) {
                return false;
            }
            try {
                Logger logger2 = LoggerBase.mLogger;
                if (logger2 != null) {
                    Level level = Level.INFO;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format(" %s(%d): %s%n", Arrays.copyOf(new Object[]{tag, Integer.valueOf(Binder.getCallingPid()), msg}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    logger2.log(level, str);
                }
                if (t == null || (logger = LoggerBase.mLogger) == null) {
                    return true;
                }
                Level level2 = Level.INFO;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format(" %s(%d): %s%n", Arrays.copyOf(new Object[]{tag, Integer.valueOf(Binder.getCallingPid()), t.getMessage()}, 3));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                logger.log(level2, str2);
                return true;
            } catch (NoSuchFieldError e) {
                AbstractC2322a.m1636z("printFileLog# ", e.getMessage(), LoggerBase.TAG);
                return false;
            } catch (UnknownFormatConversionException e2) {
                AbstractC2322a.m1636z("printFileLog# ", e2.getMessage(), LoggerBase.TAG);
                return false;
            }
        }

        private final void printRuntimeMemory(String tag, String msg) {
            long j = Runtime.getRuntime().totalMemory();
            long jFreeMemory = Runtime.getRuntime().freeMemory();
            String str = LoggerBase.DECIMAL_FORMAT.format(j / 1048576.0f);
            String str2 = LoggerBase.DECIMAL_FORMAT.format((j - jFreeMemory) / 1048576.0f);
            String str3 = LoggerBase.DECIMAL_FORMAT.format(jFreeMemory / 1048576.0f);
            StringBuilder sbM16m = AbstractC0000a.m16m("[Performance]", msg, "# Dalvik Heap (MB) || Size: ", str, " \t| Alloc: ");
            sbM16m.append(str2);
            sbM16m.append(" \t| Free: ");
            sbM16m.append(str3);
            Log.i(tag, sbM16m.toString());
        }

        private final String wrapEncodedLog(String encodedLog) {
            return AbstractC0541b.m773o("@[/", encodedLog, "/]@");
        }

        @JvmStatic
        @NotNull
        public final String createTag(@NotNull String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            return AbstractC0541b.m756B(getAPP_TAG(), tag);
        }

        @JvmStatic
        /* JADX INFO: renamed from: d */
        public final void m7132d(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Log.i(AbstractC0541b.m756B(getAPP_TAG(), tag), String.valueOf(msg));
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m7133e(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            String strM756B = AbstractC0541b.m756B(getAPP_TAG(), tag);
            if (msg == null) {
                msg = "";
            }
            Log.e(strM756B, msg);
        }

        @JvmStatic
        /* JADX INFO: renamed from: f */
        public final void m7135f(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            synchronized (LoggerBase.mCumulativeLogs) {
                try {
                    if (!LoggerBase.INSTANCE.printFileLog(tag, msg, null)) {
                        LoggerBase.mCumulativeLogs.add(new LogParam(tag, msg));
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.i(getAPP_TAG() + ((Object) tag), msg);
        }

        @NotNull
        public final String getAPP_TAG() {
            return LoggerBase.APP_TAG;
        }

        @JvmStatic
        @NotNull
        public final String getEncode(@Nullable String content) {
            int iM14129C;
            if (!TextUtils.isEmpty(content) && content != null && StringsKt.m14162r(content, "com.samsung.android.app.notes") && (iM14129C = StringsKt.m14129C("com.samsung.android.app.notes", 0, 6, content)) >= 0) {
                String strSubstring = content.substring(iM14129C + 29);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                content = AbstractC0541b.m772n(Extension.DOT, strSubstring);
            }
            if (TextUtils.isEmpty(content)) {
                return String.valueOf(content);
            }
            byte[] bytes = null;
            if (!DeviceInfo.isUserMode()) {
                return String.valueOf(content != null ? LoggerBase.INSTANCE.wrapEncodedLog(content) : null);
            }
            if (content != null) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                bytes = content.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            }
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return wrapEncodedLog(strEncodeToString);
        }

        @JvmStatic
        @NotNull
        public final String getLogFilePath(@Nullable Context context) {
            File filesDir;
            if (context != null && (filesDir = context.getFilesDir()) != null) {
                File parentFile = filesDir.getParentFile();
                File file = parentFile != null ? parentFile : null;
                if (parentFile != null) {
                    String strM756B = AbstractC0541b.m756B(file != null ? file.getAbsolutePath() : null, "/log/");
                    File file2 = new File(strM756B);
                    if (!file2.exists() && !file2.mkdir()) {
                        AbstractC2322a.m1636z("getLogFilePath, Failed to make directory ", strM756B, LoggerBase.TAG);
                    }
                    AbstractC2322a.m1609C("getLogFilePath, path = ", strM756B, LoggerBase.TAG);
                    return strM756B;
                }
            }
            Log.e(LoggerBase.TAG, "getLogFilePath, Failed to get context or filesDir ");
            return "";
        }

        @NotNull
        public final List<File> getLogFiles(@Nullable Context context) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                File file = new File(AbstractC2322a.m1624n(AbstractC0541b.m757C(getLogFilePath(context), File.separator, StringsKt.m14139M(LoggerBase.LOG_FILE_NAME, "%g", TimeModel.NUMBER_FORMAT)), new Object[]{Integer.valueOf(i)}, 1, "format(...)"));
                if (file.exists()) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        }

        @JvmStatic
        @NotNull
        public final String getTimeString(long ms) {
            String str;
            synchronized (LoggerBase.formatter) {
                str = LoggerBase.formatter.format(Long.valueOf(ms));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                Unit unit = Unit.INSTANCE;
            }
            return str;
        }

        @JvmStatic
        /* JADX INFO: renamed from: i */
        public final void m7137i(@Nullable String tag, @Nullable String msg) {
            String strM756B = AbstractC0541b.m756B(getAPP_TAG(), tag);
            if (msg != null) {
                Log.i(strM756B, msg);
            }
        }

        @JvmStatic
        @NotNull
        public final String pii(@Nullable String str) {
            if (str == null || Intrinsics.areEqual(str, "")) {
                return "<Empty>";
            }
            if (DeviceInfo.isUserMode()) {
                return getStarString(str, str.length() >= 11 ? 3 : (str.length() + 1) / 4);
            }
            return str;
        }

        @JvmStatic
        public final void printMemory(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            printNativeHeapMemory(tag, msg);
            printRuntimeMemory(tag, msg);
        }

        public final void printNativeHeapMemory(@Nullable String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            String str = LoggerBase.DECIMAL_FORMAT.format(Debug.getNativeHeapSize() / 1048576.0f);
            String str2 = LoggerBase.DECIMAL_FORMAT.format(Debug.getNativeHeapAllocatedSize() / 1048576.0f);
            String str3 = LoggerBase.DECIMAL_FORMAT.format(Debug.getNativeHeapFreeSize() / 1048576.0f);
            StringBuilder sbM16m = AbstractC0000a.m16m("[Performance]", msg, "# Native Heap (MB) || Size: ", str, " \t| Alloc: ");
            sbM16m.append(str2);
            sbM16m.append(" \t| Free: ");
            sbM16m.append(str3);
            Log.i(tag, sbM16m.toString());
        }

        public final void setAPP_TAG(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LoggerBase.APP_TAG = str;
        }

        public final void setupFileLogger(@Nullable Context context) {
            String logFilePath = getLogFilePath(context);
            Log.d(LoggerBase.TAG, "init Log Path : " + logFilePath);
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
            FileHandler fileHandler = new FileHandler(AbstractC0541b.m757C(logFilePath, File.separator, LoggerBase.LOG_FILE_NAME), 1048576, 2, true);
            fileHandler.setFormatter(new Formatter() { // from class: com.samsung.android.support.senl.cm.base.framework.support.LoggerBase$Companion$setupFileLogger$1$1
                @Override // java.util.logging.Formatter
                public String format(LogRecord r) {
                    Intrinsics.checkNotNullParameter(r, "r");
                    LoggerBase.mDate.setTime(System.currentTimeMillis());
                    StringBuilder sb = new StringBuilder(80);
                    sb.append(simpleDateFormat.format(LoggerBase.mDate));
                    sb.append(r.getMessage());
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            });
            Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);
            synchronized (LoggerBase.mCumulativeLogs) {
                try {
                    LoggerBase.mLogger = logger;
                    if (!LoggerBase.mCumulativeLogs.isEmpty()) {
                        Iterator it = LoggerBase.mCumulativeLogs.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            ((LogParam) next).printFileLog();
                        }
                        LoggerBase.mCumulativeLogs.clear();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.d(LoggerBase.TAG, "initFileLogger success");
        }

        @JvmStatic
        /* JADX INFO: renamed from: w */
        public final void m7138w(@NotNull String tag, @Nullable String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Log.w(AbstractC0541b.m756B(getAPP_TAG(), tag), String.valueOf(msg));
        }

        private Companion() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: e */
        public final void m7134e(@NotNull String tag, @Nullable String msg, @Nullable Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Log.e(getAPP_TAG() + tag, msg, t);
        }

        @JvmStatic
        /* JADX INFO: renamed from: f */
        public final void m7136f(@NotNull String tag, @NotNull String msg, @Nullable Throwable t) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            synchronized (LoggerBase.mCumulativeLogs) {
                try {
                    if (!LoggerBase.INSTANCE.printFileLog(tag, msg, t)) {
                        LoggerBase.mCumulativeLogs.add(new LogParam(tag, msg, t));
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.e(getAPP_TAG() + ((Object) tag), msg, t);
        }
    }

    @JvmStatic
    @NotNull
    public static final String createTag(@NotNull String str) {
        return INSTANCE.createTag(str);
    }

    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m7125d(@NotNull String str, @Nullable String str2) {
        INSTANCE.m7132d(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7126e(@NotNull String str, @Nullable String str2) {
        INSTANCE.m7133e(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m7128f(@NotNull String str, @NotNull String str2) {
        INSTANCE.m7135f(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String getEncode(@Nullable String str) {
        return INSTANCE.getEncode(str);
    }

    @JvmStatic
    @NotNull
    public static final String getLogFilePath(@Nullable Context context) {
        return INSTANCE.getLogFilePath(context);
    }

    @JvmStatic
    @NotNull
    public static final String getTimeString(long j) {
        return INSTANCE.getTimeString(j);
    }

    @JvmStatic
    /* JADX INFO: renamed from: i */
    public static final void m7130i(@Nullable String str, @Nullable String str2) {
        INSTANCE.m7137i(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final String pii(@Nullable String str) {
        return INSTANCE.pii(str);
    }

    @JvmStatic
    public static final void printMemory(@Nullable String str, @NotNull String str2) {
        INSTANCE.printMemory(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: w */
    public static final void m7131w(@NotNull String str, @Nullable String str2) {
        INSTANCE.m7138w(str, str2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m7127e(@NotNull String str, @Nullable String str2, @Nullable Throwable th) {
        INSTANCE.m7134e(str, str2, th);
    }

    @JvmStatic
    /* JADX INFO: renamed from: f */
    public static final void m7129f(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        INSTANCE.m7136f(str, str2, th);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/LoggerBase$LogParam;", "", "tag", "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "t", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "mTag", "mMsg", "mT", "printFileLog", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LogParam {

        @NotNull
        private final String mMsg;

        @Nullable
        private Throwable mT;

        @NotNull
        private final String mTag;

        public LogParam(@NotNull String tag, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.mTag = tag;
            this.mMsg = msg;
        }

        public final void printFileLog() {
            LoggerBase.INSTANCE.printFileLog(this.mTag, this.mMsg, this.mT);
        }

        public LogParam(@NotNull String tag, @NotNull String msg, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.mTag = tag;
            this.mMsg = msg;
            this.mT = th;
        }
    }
}
