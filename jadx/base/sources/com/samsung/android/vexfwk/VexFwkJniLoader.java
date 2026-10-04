package com.samsung.android.vexfwk;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/VexFwkJniLoader;", "", "()V", SearchConstants.TargetContents.TAG, "", "loadedLibraries", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "loadLibrary", "libName", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkJniLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkJniLoader.kt\ncom/samsung/android/vexfwk/VexFwkJniLoader\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n372#2,3:19\n375#2,4:23\n1#3:22\n*S KotlinDebug\n*F\n+ 1 VexFwkJniLoader.kt\ncom/samsung/android/vexfwk/VexFwkJniLoader\n*L\n12#1:19,3\n12#1:23,4\n*E\n"})
public final class VexFwkJniLoader {

    @NotNull
    private static final String TAG = "VexFwkJniLoader";

    @NotNull
    public static final VexFwkJniLoader INSTANCE = new VexFwkJniLoader();

    @NotNull
    private static HashMap<String, Boolean> loadedLibraries = new HashMap<>();

    private VexFwkJniLoader() {
    }

    @JvmStatic
    public static final synchronized boolean loadLibrary(@NotNull String libName) {
        Boolean boolValueOf;
        Object objM22215constructorimpl;
        try {
            Intrinsics.checkNotNullParameter(libName, "libName");
            HashMap<String, Boolean> map = loadedLibraries;
            boolValueOf = map.get(libName);
            if (boolValueOf == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    System.loadLibrary(libName);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.d(TAG, "Unable to load library " + libName, thM22218exceptionOrNullimpl);
                }
                boolValueOf = Boolean.valueOf(Result.m22222isSuccessimpl(objM22215constructorimpl));
                map.put(libName, boolValueOf);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return boolValueOf.booleanValue();
    }
}
