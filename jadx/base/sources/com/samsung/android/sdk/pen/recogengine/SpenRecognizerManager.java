package com.samsung.android.sdk.pen.recogengine;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0016H\u0007J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0016H\u0007J\u0010\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\rH\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizerManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mPluginManager", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager;", "mPluginList", "", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginInfo;", "checkPluginManager", "", "checkPluginInfo", "info", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizerInfo;", "infoList", "", "getInfoList", "()Ljava/util/List;", "getPrivateKeyHint", "", "createRecognizer", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer;", "key", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "destroyRecognizer", "recognizer", "close", "finalize", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizerManager.kt\ncom/samsung/android/sdk/pen/recogengine/SpenRecognizerManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n1#2:248\n1855#3,2:249\n1855#3,2:251\n1855#3,2:253\n1855#3,2:255\n*S KotlinDebug\n*F\n+ 1 SpenRecognizerManager.kt\ncom/samsung/android/sdk/pen/recogengine/SpenRecognizerManager\n*L\n58#1:249,2\n107#1:251,2\n144#1:253,2\n186#1:255,2\n*E\n"})
public final class SpenRecognizerManager {

    @NotNull
    public static final String TAG = "SpenRecognizerPlugin";

    @Nullable
    private Context mContext;

    @Nullable
    private List<SpenPluginInfo> mPluginList;

    @Nullable
    private SpenPluginManager mPluginManager;

    public SpenRecognizerManager(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mPluginManager = SpenPluginManager.INSTANCE.getInstance(context);
        this.mContext = context;
    }

    private final void checkPluginInfo(SpenRecognizerInfo info) {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
    }

    private final void checkPluginManager() {
        if (this.mPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
        }
    }

    public static /* synthetic */ SpenRecognizer createRecognizer$default(SpenRecognizerManager spenRecognizerManager, SpenRecognizerInfo spenRecognizerInfo, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return spenRecognizerManager.createRecognizer(spenRecognizerInfo, str);
    }

    public final void close() {
        this.mContext = null;
        this.mPluginManager = null;
        List<SpenPluginInfo> list = this.mPluginList;
        if (list != null && !list.isEmpty()) {
            list.clear();
        }
        this.mPluginList = null;
    }

    @JvmOverloads
    @NotNull
    public final SpenRecognizer createRecognizer(@Nullable SpenRecognizerInfo spenRecognizerInfo) {
        return createRecognizer$default(this, spenRecognizerInfo, (String) null, 2, (Object) null);
    }

    public final void destroyRecognizer(@Nullable SpenRecognizer recognizer) {
        if (recognizer == null) {
            throw new IllegalArgumentException("E_INVALID_STATE : parameter 'verification' is null");
        }
        if (recognizer.getPluginObject() == null) {
            throw new IllegalArgumentException("E_INVALID_STATE : parameter 'verification' is null");
        }
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager != null) {
            spenPluginManager.unloadPlugin(recognizer.getPluginObject());
        }
        recognizer.setPluginObject(null);
        recognizer.close();
    }

    public final void finalize() {
        List<SpenPluginInfo> list = this.mPluginList;
        if (list != null && !list.isEmpty()) {
            list.clear();
        }
        this.mPluginList = null;
    }

    @NotNull
    public final List<SpenRecognizerInfo> getInfoList() {
        checkPluginManager();
        SpenPluginManager spenPluginManager = this.mPluginManager;
        Intrinsics.checkNotNull(spenPluginManager);
        List<SpenPluginInfo> pluginList = spenPluginManager.getPluginList("Recognizer");
        ArrayList arrayList = new ArrayList();
        for (SpenPluginInfo spenPluginInfo : pluginList) {
            SpenRecognizerInfo spenRecognizerInfo = new SpenRecognizerInfo();
            spenRecognizerInfo.name = spenPluginInfo.pluginNameUri;
            spenRecognizerInfo.version = spenPluginInfo.version;
            spenRecognizerInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
            spenRecognizerInfo.iconImageUri = spenPluginInfo.iconImageUri;
            spenRecognizerInfo.hasPrivateKey = spenPluginInfo.hasPrivateKey;
            arrayList.add(spenRecognizerInfo);
        }
        this.mPluginList = pluginList;
        return arrayList;
    }

    @Nullable
    public final String getPrivateKeyHint(@Nullable SpenRecognizerInfo info) throws ClassNotFoundException {
        checkPluginInfo(info);
        checkPluginManager();
        List<SpenPluginInfo> list = this.mPluginList;
        if (list != null) {
            for (SpenPluginInfo spenPluginInfo : list) {
                Intrinsics.checkNotNull(info);
                if (Intrinsics.areEqual(info.className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName) && Intrinsics.areEqual(info.name, spenPluginInfo.pluginNameUri) && info.version == spenPluginInfo.version) {
                    SpenPluginManager spenPluginManager = this.mPluginManager;
                    if (spenPluginManager != null) {
                        return spenPluginManager.getPrivateKeyHint(spenPluginInfo);
                    }
                    return null;
                }
            }
        }
        Intrinsics.checkNotNull(info);
        throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " handwriting recognizer"));
    }

    @JvmOverloads
    @NotNull
    public final SpenRecognizer createRecognizer(@Nullable String str) {
        return createRecognizer$default(this, str, (String) null, 2, (Object) null);
    }

    public static /* synthetic */ SpenRecognizer createRecognizer$default(SpenRecognizerManager spenRecognizerManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return spenRecognizerManager.createRecognizer(str, str2);
    }

    @JvmOverloads
    @NotNull
    public final SpenRecognizer createRecognizer(@Nullable SpenRecognizerInfo info, @NotNull String key) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(key, "key");
        checkPluginInfo(info);
        checkPluginManager();
        List<SpenPluginInfo> list = this.mPluginList;
        if (list != null) {
            for (SpenPluginInfo spenPluginInfo : list) {
                Intrinsics.checkNotNull(info);
                if (Intrinsics.areEqual(info.className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName) && Intrinsics.areEqual(info.name, spenPluginInfo.pluginNameUri) && info.version == spenPluginInfo.version) {
                    Context context = this.mContext;
                    SpenPluginManager spenPluginManager = this.mPluginManager;
                    Intrinsics.checkNotNull(spenPluginManager);
                    Object objLoadPlugin = spenPluginManager.loadPlugin(this.mContext, spenPluginInfo, key);
                    Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface");
                    return new SpenRecognizer(context, (SpenRecognizerInterface) objLoadPlugin);
                }
            }
        }
        Intrinsics.checkNotNull(info);
        throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " handwriting recognizer"));
    }

    @JvmOverloads
    @NotNull
    public final SpenRecognizer createRecognizer(@Nullable String className, @NotNull String key) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(key, "key");
        if (className != null) {
            SpenPluginManager spenPluginManager = this.mPluginManager;
            List<SpenPluginInfo> pluginList = spenPluginManager != null ? spenPluginManager.getPluginList("Recognizer") : null;
            List<SpenPluginInfo> list = this.mPluginList;
            if (list != null && !list.isEmpty()) {
                List<SpenPluginInfo> list2 = this.mPluginList;
                Intrinsics.checkNotNull(list2);
                list2.clear();
            }
            this.mPluginList = pluginList;
            if (pluginList != null) {
                for (SpenPluginInfo spenPluginInfo : pluginList) {
                    if (Intrinsics.areEqual(className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName)) {
                        Context context = this.mContext;
                        SpenPluginManager spenPluginManager2 = this.mPluginManager;
                        Object objLoadPlugin = spenPluginManager2 != null ? spenPluginManager2.loadPlugin(context, spenPluginInfo, key) : null;
                        Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface");
                        return new SpenRecognizer(context, (SpenRecognizerInterface) objLoadPlugin);
                    }
                }
            }
            throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", className, " handwriting recognizer"));
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'packageName' or 'className' is null");
    }
}
