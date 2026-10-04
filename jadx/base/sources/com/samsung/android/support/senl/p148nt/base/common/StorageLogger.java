package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/StorageLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "print", "", "context", "Landroid/content/Context;", "extraLogs", "", "removeDetailPath", "content", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStorageLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageLogger.kt\ncom/samsung/android/support/senl/nt/base/common/StorageLogger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1869#2,2:63\n13472#3,2:65\n1#4:67\n*S KotlinDebug\n*F\n+ 1 StorageLogger.kt\ncom/samsung/android/support/senl/nt/base/common/StorageLogger\n*L\n19#1:63,2\n36#1:65,2\n*E\n"})
public final class StorageLogger {

    @NotNull
    public static final StorageLogger INSTANCE = new StorageLogger();

    @NotNull
    private static final String TAG = "[Storage]";

    private StorageLogger() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit print$lambda$2$lambda$1(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        List<String> listSplit = new Regex("\t").split(line, 0);
        if (listSplit.size() >= 2) {
            String str = listSplit.get(0);
            Logger.m8697d(TAG, Logger.getEncode(((Object) str) + INSTANCE.removeDetailPath(listSplit.get(1))));
        }
        return Unit.INSTANCE;
    }

    private final String removeDetailPath(String content) {
        int iM14131E = StringsKt.m14131E("com.samsung.android.app.notes", 0, 6, content);
        if (iM14131E < 0) {
            return content;
        }
        String strSubstring = content.substring(iM14131E + 29);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return AbstractC0541b.m772n(" .", strSubstring);
    }

    @WorkerThread
    public final void print(@NotNull Context context, @NotNull Collection<String> extraLogs) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraLogs, "extraLogs");
        print(context);
        Iterator<T> it = extraLogs.iterator();
        while (it.hasNext()) {
            Logger.m8697d(TAG, (String) it.next());
        }
    }

    @WorkerThread
    public final void print(@NotNull Context context) throws Throwable {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(context, "context");
        String noteFilePath = WDocUtils.getNoteFilePath(context);
        String[] strArr = {AbstractC0541b.m772n("du -sh ", noteFilePath), AbstractC0541b.m773o("du -sh ", noteFilePath, "/SDocBnR"), AbstractC0541b.m773o("du -sh ", WDocUtils.getNoteDirPath(context), "/app_attach"), AbstractC0541b.m772n("du -h -d 1 ", context.getFilesDir().getAbsolutePath())};
        Runtime runtime = Runtime.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "getRuntime(...)");
        int i = 0;
        BufferedReader bufferedReader2 = null;
        InputStream element = null;
        while (i < 4) {
            try {
                try {
                    element = runtime.exec(strArr[i]).getInputStream();
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    bufferedReader = new BufferedReader(new InputStreamReader(element, Charsets.UTF_8), 8192);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                TextStreamsKt.forEachLine(bufferedReader, new C0348a(5));
                bufferedReader.close();
                element.close();
                i++;
                bufferedReader2 = bufferedReader;
            } catch (Exception e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                Logger.m8698e(TAG, "e: " + e.getMessage());
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
                CloseableKt.closeFinally(bufferedReader2, null);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                CloseableKt.closeFinally(bufferedReader2, null);
                return;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        Unit unit3 = Unit.INSTANCE;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                CloseableKt.closeFinally(bufferedReader2, null);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        Unit unit4 = Unit.INSTANCE;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                CloseableKt.closeFinally(bufferedReader2, null);
                throw th;
            }
        }
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
                Unit unit5 = Unit.INSTANCE;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
        CloseableKt.closeFinally(bufferedReader2, null);
        if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
                Unit unit6 = Unit.INSTANCE;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
        CloseableKt.closeFinally(bufferedReader2, null);
    }
}
