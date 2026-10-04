package com.samsung.android.sdk.pen.recoguifeature;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0004J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0004J.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0004J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0004J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0004J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0004J\b\u0010\u001d\u001a\u00020\u001bH\u0004J\b\u0010\u001e\u001a\u00020\u001bH\u0004R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/SpenRecognitionManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPluginList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginInfo;", "Lkotlin/collections/ArrayList;", "mPluginManager", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager;", "getInfoList", "", "Lcom/samsung/android/sdk/pen/recoguifeature/SpenRecognitionInfo;", "type", "", "inputType", "", "outputType", "interfaceName", "getPrivateKeyHint", "info", "createPluginObject", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognitionInterface;", "key", "destroyPluginObject", "", "pluginObject", "close", "finalize", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognitionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognitionManager.kt\ncom/samsung/android/sdk/pen/recoguifeature/SpenRecognitionManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,325:1\n1#2:326\n731#3,9:327\n731#3,9:338\n731#3,9:349\n731#3,9:360\n37#4,2:336\n37#4,2:347\n37#4,2:358\n37#4,2:369\n*S KotlinDebug\n*F\n+ 1 SpenRecognitionManager.kt\ncom/samsung/android/sdk/pen/recoguifeature/SpenRecognitionManager\n*L\n46#1:327,9\n91#1:338,9\n144#1:349,9\n190#1:360,9\n46#1:336,2\n91#1:347,2\n144#1:358,2\n190#1:369,2\n*E\n"})
public abstract class SpenRecognitionManager {
    private static final int INPUT_TYPE_INDEX = 0;
    private static final int OUTPUT_TYPE_INDEX = 1;

    @Nullable
    private ArrayList<SpenPluginInfo> mPluginList;

    @Nullable
    private SpenPluginManager mPluginManager;

    public SpenRecognitionManager(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mPluginManager = SpenPluginManager.INSTANCE.getInstance(context);
    }

    public final void close() {
        this.mPluginManager = null;
        ArrayList<SpenPluginInfo> arrayList = this.mPluginList;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                arrayList.clear();
            }
            this.mPluginList = null;
        }
    }

    @NotNull
    public final SpenRecognitionInterface createPluginObject(@NotNull Context context, @Nullable SpenRecognitionInfo info, @NotNull String key) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        ArrayList<SpenPluginInfo> arrayList = this.mPluginList;
        if (arrayList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        Iterator<SpenPluginInfo> it = arrayList != null ? arrayList.iterator() : null;
        while (true) {
            if (it != null && !it.hasNext()) {
                throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " Recognition"));
            }
            SpenPluginInfo next = it != null ? it.next() : null;
            if (Intrinsics.areEqual(info.className, (next != null ? next.packageName : null) + Extension.DOT + (next != null ? next.canonicalClassName : null))) {
                if (Intrinsics.areEqual(info.name, next != null ? next.pluginNameUri : null) && next != null && info.version == next.version) {
                    SpenPluginManager spenPluginManager = this.mPluginManager;
                    Object objLoadPlugin = spenPluginManager != null ? spenPluginManager.loadPlugin(context, next, key) : null;
                    Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface");
                    return (SpenRecognitionInterface) objLoadPlugin;
                }
            }
        }
    }

    public final void destroyPluginObject(@Nullable SpenRecognitionInterface pluginObject) {
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
        }
        if (spenPluginManager != null) {
            spenPluginManager.unloadPlugin(pluginObject);
        }
    }

    public final void finalize() {
        ArrayList<SpenPluginInfo> arrayList = this.mPluginList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        arrayList.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0024 A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<SpenRecognitionInfo> getInfoList(@NotNull String type) {
        List<SpenPluginInfo> listEmptyList;
        ArrayList<SpenPluginInfo> arrayList;
        List listEmptyList2;
        String[] strArr;
        Intrinsics.checkNotNullParameter(type, "type");
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
        }
        if (spenPluginManager == null || (listEmptyList = spenPluginManager.getPluginList(type)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList<SpenPluginInfo> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        for (SpenPluginInfo spenPluginInfo : listEmptyList) {
            if (Intrinsics.areEqual(spenPluginInfo.interfaceName, "SpenRecognitionInterface")) {
                List listM13999t = AbstractC12991c.m13999t(0, "/", spenPluginInfo.extraInfo);
                if (listM13999t.isEmpty()) {
                    listEmptyList2 = CollectionsKt.emptyList();
                    strArr = (String[]) listEmptyList2.toArray(new String[0]);
                    if (strArr.length < 2) {
                    }
                } else {
                    ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                    strArr = (String[]) listEmptyList2.toArray(new String[0]);
                    if (strArr.length < 2) {
                        arrayList2.add(spenPluginInfo);
                        SpenRecognitionInfo spenRecognitionInfo = new SpenRecognitionInfo();
                        spenRecognitionInfo.name = spenPluginInfo.pluginNameUri;
                        spenRecognitionInfo.version = spenPluginInfo.version;
                        spenRecognitionInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
                        spenRecognitionInfo.hasPrivateKey = spenPluginInfo.hasPrivateKey;
                        spenRecognitionInfo.iconImageUri = spenPluginInfo.iconImageUri;
                        spenRecognitionInfo.inputType = Integer.parseInt(strArr[0]);
                        spenRecognitionInfo.outputType = Integer.parseInt(strArr[1]);
                        arrayList3.add(spenRecognitionInfo);
                    }
                }
            }
        }
        ArrayList<SpenPluginInfo> arrayList4 = this.mPluginList;
        if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = this.mPluginList) != null) {
            arrayList.clear();
        }
        this.mPluginList = arrayList2;
        return arrayList3;
    }

    @Nullable
    public final String getPrivateKeyHint(@Nullable SpenRecognitionInfo info) throws ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        ArrayList<SpenPluginInfo> arrayList = this.mPluginList;
        if (arrayList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        Iterator<SpenPluginInfo> it = arrayList != null ? arrayList.iterator() : null;
        while (true) {
            if (it != null && !it.hasNext()) {
                throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " Recognition"));
            }
            SpenPluginInfo next = it != null ? it.next() : null;
            if (Intrinsics.areEqual(info.className, (next != null ? next.packageName : null) + Extension.DOT + (next != null ? next.canonicalClassName : null))) {
                if (Intrinsics.areEqual(info.name, next != null ? next.pluginNameUri : null) && next != null && info.version == next.version) {
                    SpenPluginManager spenPluginManager = this.mPluginManager;
                    if (spenPluginManager != null) {
                        return spenPluginManager.getPrivateKeyHint(next);
                    }
                    return null;
                }
            }
        }
    }

    @NotNull
    public final List<SpenRecognitionInfo> getInfoList(@NotNull String type, int inputType, int outputType) {
        List<SpenPluginInfo> listEmptyList;
        ArrayList<SpenPluginInfo> arrayList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(type, "type");
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager != null) {
            if (spenPluginManager == null || (listEmptyList = spenPluginManager.getPluginList(type)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList<SpenPluginInfo> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            for (SpenPluginInfo spenPluginInfo : listEmptyList) {
                List listM13999t = AbstractC12991c.m13999t(0, "/", spenPluginInfo.extraInfo);
                if (!listM13999t.isEmpty()) {
                    ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
                if (strArr.length >= 2) {
                    int i = Integer.parseInt(strArr[0]);
                    int i2 = Integer.parseInt(strArr[1]);
                    if (inputType == i && outputType == i2 && Intrinsics.areEqual(spenPluginInfo.interfaceName, "SpenRecognitionInterface")) {
                        arrayList2.add(spenPluginInfo);
                        SpenRecognitionInfo spenRecognitionInfo = new SpenRecognitionInfo();
                        spenRecognitionInfo.name = spenPluginInfo.pluginNameUri;
                        spenRecognitionInfo.version = spenPluginInfo.version;
                        spenRecognitionInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
                        spenRecognitionInfo.inputType = i;
                        spenRecognitionInfo.outputType = i2;
                        spenRecognitionInfo.hasPrivateKey = spenPluginInfo.hasPrivateKey;
                        spenRecognitionInfo.iconImageUri = spenPluginInfo.iconImageUri;
                        arrayList3.add(spenRecognitionInfo);
                    }
                }
            }
            ArrayList<SpenPluginInfo> arrayList4 = this.mPluginList;
            if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = this.mPluginList) != null) {
                arrayList.clear();
            }
            this.mPluginList = arrayList2;
            return arrayList3;
        }
        throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0029 A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<SpenRecognitionInfo> getInfoList(@NotNull String type, @NotNull String interfaceName) {
        List<SpenPluginInfo> listEmptyList;
        ArrayList<SpenPluginInfo> arrayList;
        List listEmptyList2;
        String[] strArr;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(interfaceName, "interfaceName");
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager != null) {
            if (spenPluginManager == null || (listEmptyList = spenPluginManager.getPluginList(type)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList<SpenPluginInfo> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            for (SpenPluginInfo spenPluginInfo : listEmptyList) {
                if (Intrinsics.areEqual(spenPluginInfo.interfaceName, interfaceName)) {
                    List listM13999t = AbstractC12991c.m13999t(0, "/", spenPluginInfo.extraInfo);
                    if (!listM13999t.isEmpty()) {
                        ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                        while (listIterator.hasPrevious()) {
                            if (((String) listIterator.previous()).length() != 0) {
                                listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                                break;
                            }
                        }
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        if (strArr.length < 2) {
                            arrayList2.add(spenPluginInfo);
                            SpenRecognitionInfo spenRecognitionInfo = new SpenRecognitionInfo();
                            spenRecognitionInfo.name = spenPluginInfo.pluginNameUri;
                            spenRecognitionInfo.version = spenPluginInfo.version;
                            spenRecognitionInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
                            spenRecognitionInfo.hasPrivateKey = spenPluginInfo.hasPrivateKey;
                            spenRecognitionInfo.iconImageUri = spenPluginInfo.iconImageUri;
                            spenRecognitionInfo.inputType = Integer.parseInt(strArr[0]);
                            spenRecognitionInfo.outputType = Integer.parseInt(strArr[1]);
                            arrayList3.add(spenRecognitionInfo);
                        }
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                        strArr = (String[]) listEmptyList2.toArray(new String[0]);
                        if (strArr.length < 2) {
                        }
                    }
                }
            }
            ArrayList<SpenPluginInfo> arrayList4 = this.mPluginList;
            if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = this.mPluginList) != null) {
                arrayList.clear();
            }
            this.mPluginList = arrayList2;
            return arrayList3;
        }
        throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
    }

    @NotNull
    public final List<SpenRecognitionInfo> getInfoList(@NotNull String type, int inputType, int outputType, @NotNull String interfaceName) {
        List<SpenPluginInfo> listEmptyList;
        ArrayList<SpenPluginInfo> arrayList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(interfaceName, "interfaceName");
        SpenPluginManager spenPluginManager = this.mPluginManager;
        if (spenPluginManager != null) {
            if (spenPluginManager == null || (listEmptyList = spenPluginManager.getPluginList(type)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList<SpenPluginInfo> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            for (SpenPluginInfo spenPluginInfo : listEmptyList) {
                List listM13999t = AbstractC12991c.m13999t(0, "/", spenPluginInfo.extraInfo);
                if (!listM13999t.isEmpty()) {
                    ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
                if (strArr.length >= 2) {
                    int i = Integer.parseInt(strArr[0]);
                    int i2 = Integer.parseInt(strArr[1]);
                    if (inputType == i && outputType == i2 && Intrinsics.areEqual(spenPluginInfo.interfaceName, interfaceName)) {
                        arrayList2.add(spenPluginInfo);
                        SpenRecognitionInfo spenRecognitionInfo = new SpenRecognitionInfo();
                        spenRecognitionInfo.name = spenPluginInfo.pluginNameUri;
                        spenRecognitionInfo.version = spenPluginInfo.version;
                        spenRecognitionInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
                        spenRecognitionInfo.inputType = i;
                        spenRecognitionInfo.outputType = i2;
                        spenRecognitionInfo.hasPrivateKey = spenPluginInfo.hasPrivateKey;
                        spenRecognitionInfo.iconImageUri = spenPluginInfo.iconImageUri;
                        arrayList3.add(spenRecognitionInfo);
                    }
                }
            }
            ArrayList<SpenPluginInfo> arrayList4 = this.mPluginList;
            if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = this.mPluginList) != null) {
                arrayList.clear();
            }
            this.mPluginList = arrayList2;
            return arrayList3;
        }
        throw new IllegalStateException("E_INVALID_STATE: Recognition Manager is null");
    }
}
