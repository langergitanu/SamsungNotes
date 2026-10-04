package com.samsung.android.sdk.pen.plugin.framework;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerManager;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0007J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager;", "", "<init>", "()V", "mIs64", "", "getPrivateKeyHint", "", "info", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginInfo;", "getPluginList", "", "type", "getPluginInfo", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "loadPlugin", "context", "Landroid/content/Context;", "key", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "unloadPlugin", "", CoeditServiceConstants.Element.NAME_OBJECT, "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager$PluginListener;", "getNativeHandle", "", "getNativeHandle_64", "", "mJniPluginManager", "Lcom/samsung/android/sdk/pen/plugin/framework/JniPluginManager;", "mBuiltInPluginList", "mLoadedPluginList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginObject;", "PluginListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPluginManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPluginManager.kt\ncom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,819:1\n1#2:820\n*E\n"})
public final class SpenPluginManager {
    private static final int BINARY_TYPE_INDEX = 4;
    private static final int BINARY_TYPE_JAVA = 0;
    private static final int BINARY_TYPE_NATIVE = 1;
    private static final int CLASS_NAME_INDEX = 13;
    private static final int EXTRA_INFO_INDEX = 10;
    private static final int FOCUSED_ICON_IMAGE_URI_INDEX = 9;
    private static final int HAS_PRIVATE_KEY_INDEX = 5;
    private static final int ICON_IMAGE_URI_INDEX = 6;
    private static final int INTERFACE_NAME_INDEX = 2;
    private static final int INTERFACE_VERSION_INDEX = 3;
    private static final int PACKAGE_NAME_INDEX = 12;
    private static final int PLUGIN_NAME_URI_INDEX = 11;
    private static final int PRESET_ICON_IMAGE_URI_INDEX = 8;
    private static final int SELECTED_ICON_IMAGE_URI_INDEX = 7;
    private static final int TYPE_INDEX = 0;
    private static final int VERSION_INDEX = 1;

    @Nullable
    private static SpenPluginManager mInstance;

    @Nullable
    private List<SpenPluginInfo> mBuiltInPluginList;
    private boolean mIs64;

    @Nullable
    private JniPluginManager mJniPluginManager;

    @NotNull
    private final ArrayList<SpenPluginObject> mLoadedPluginList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[][] BUILTIN_PLUGIN_LIST = {new String[]{"ObjectRuntime", "1", "SpenObjectRuntimeInterface", "1", StringLookupFactory.KEY_JAVA, "defaultIconImageURI", "0", "selectedIconImageURI", "defaultIconImageURI", "defaultIconImageURI", "extraInfo", "Video", "com.samsung.android.sdk.pen.objectruntime.preload", "Video"}, new String[]{"Recognizer", "1", "SpenRecognizerInterface", "1", StringLookupFactory.KEY_JAVA, "0", "iconImageUri", "selectedIconImageUri", "presetIconImageUri", "focusedIconImageUri", "extraInfo", "SpenRecognizer", "com.samsung.android.sdk.pen.recogengine.preload", SpenRecognizerManager.TAG}};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager$Companion;", "", "<init>", "()V", "TYPE_INDEX", "", "VERSION_INDEX", "INTERFACE_NAME_INDEX", "INTERFACE_VERSION_INDEX", "BINARY_TYPE_INDEX", "HAS_PRIVATE_KEY_INDEX", "ICON_IMAGE_URI_INDEX", "SELECTED_ICON_IMAGE_URI_INDEX", "PRESET_ICON_IMAGE_URI_INDEX", "FOCUSED_ICON_IMAGE_URI_INDEX", "EXTRA_INFO_INDEX", "PLUGIN_NAME_URI_INDEX", "PACKAGE_NAME_INDEX", "CLASS_NAME_INDEX", "BINARY_TYPE_JAVA", "BINARY_TYPE_NATIVE", "getInstance", "Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager;", "context", "Landroid/content/Context;", "BUILTIN_PLUGIN_LIST", "", "", "[[Ljava/lang/String;", "mInstance", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenPluginManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPluginManager.kt\ncom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,819:1\n1#2:820\n731#3,9:821\n37#4,2:830\n*S KotlinDebug\n*F\n+ 1 SpenPluginManager.kt\ncom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager$Companion\n*L\n690#1:821,9\n691#1:830,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized SpenPluginManager getInstance(@Nullable Context context) {
            SpenPluginManager spenPluginManager;
            char c;
            int i;
            boolean z;
            InputStream inputStreamOpen;
            List listEmptyList;
            try {
                if (context == null) {
                    throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
                }
                if (SpenPluginManager.mInstance == null) {
                    SpenPluginManager.mInstance = new SpenPluginManager(null);
                    SpenPluginManager spenPluginManager2 = SpenPluginManager.mInstance;
                    if (spenPluginManager2 != null) {
                        spenPluginManager2.mJniPluginManager = new JniPluginManager();
                        if (spenPluginManager2.mJniPluginManager == null) {
                            throw new IllegalStateException("E_INVALID_STATE : Fail to create JniPluginManager");
                        }
                        spenPluginManager2.mBuiltInPluginList = new ArrayList();
                        if (spenPluginManager2.mBuiltInPluginList == null) {
                            throw new IllegalStateException("E_INVALID_STATE : Fail to create ArrayList for BuiltInPluginList");
                        }
                        String[][] strArr = SpenPluginManager.BUILTIN_PLUGIN_LIST;
                        int length = strArr.length;
                        int i2 = 0;
                        int i4 = 0;
                        while (true) {
                            c = '\n';
                            i = 14;
                            if (i4 >= length) {
                                break;
                            }
                            String[] strArr2 = strArr[i4];
                            if (strArr2.length == 14) {
                                SpenPluginInfo spenPluginInfo = new SpenPluginInfo();
                                spenPluginInfo.type = strArr2[0];
                                spenPluginInfo.version = Integer.parseInt(strArr2[1]);
                                spenPluginInfo.interfaceName = strArr2[2];
                                spenPluginInfo.interfaceVersion = Integer.parseInt(strArr2[3]);
                                String str = strArr2[4];
                                spenPluginInfo.hasPrivateKey = Boolean.parseBoolean(strArr2[5]);
                                spenPluginInfo.iconImageUri = strArr2[6];
                                spenPluginInfo.selectedIconImageUri = strArr2[7];
                                spenPluginInfo.presetIconImageUri = strArr2[8];
                                spenPluginInfo.focusedIconImageUri = strArr2[9];
                                spenPluginInfo.extraInfo = strArr2[10];
                                spenPluginInfo.pluginNameUri = strArr2[11];
                                spenPluginInfo.packageName = strArr2[12];
                                spenPluginInfo.canonicalClassName = strArr2[13];
                                if (Intrinsics.areEqual(str, "native")) {
                                    spenPluginInfo.binaryType = 1;
                                } else {
                                    spenPluginInfo.binaryType = 0;
                                }
                                List list = spenPluginManager2.mBuiltInPluginList;
                                if (list != null) {
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        Intrinsics.areEqual(spenPluginInfo.canonicalClassName, ((SpenPluginInfo) it.next()).canonicalClassName);
                                    }
                                }
                                List list2 = spenPluginManager2.mBuiltInPluginList;
                                if (list2 != null) {
                                    list2.add(spenPluginInfo);
                                }
                            }
                            i4++;
                        }
                        try {
                            inputStreamOpen = context.getAssets().open("plugin.ini");
                            z = true;
                        } catch (IOException unused) {
                            Log.i("PluginManager", "Fail to read Plugin List of App");
                            z = false;
                            inputStreamOpen = null;
                        }
                        if (z) {
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charset.forName("UTF-8")));
                                String line = bufferedReader.readLine();
                                while (line != null) {
                                    SpenPluginInfo spenPluginInfo2 = new SpenPluginInfo();
                                    char c2 = c;
                                    List<String> listSplit = new Regex(";").split(line, i2);
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
                                    String[] strArr3 = (String[]) listEmptyList.toArray(new String[i2]);
                                    if (strArr3.length != i) {
                                        c = c2;
                                    } else {
                                        spenPluginInfo2.type = strArr3[i2];
                                        spenPluginInfo2.version = Integer.parseInt(strArr3[1]);
                                        spenPluginInfo2.interfaceName = strArr3[2];
                                        spenPluginInfo2.interfaceVersion = Integer.parseInt(strArr3[3]);
                                        String str2 = strArr3[4];
                                        spenPluginInfo2.hasPrivateKey = Boolean.parseBoolean(strArr3[5]);
                                        spenPluginInfo2.iconImageUri = strArr3[6];
                                        spenPluginInfo2.selectedIconImageUri = strArr3[7];
                                        spenPluginInfo2.presetIconImageUri = strArr3[8];
                                        spenPluginInfo2.focusedIconImageUri = strArr3[9];
                                        spenPluginInfo2.extraInfo = strArr3[c2];
                                        spenPluginInfo2.pluginNameUri = strArr3[11];
                                        spenPluginInfo2.packageName = strArr3[12];
                                        spenPluginInfo2.canonicalClassName = strArr3[13];
                                        if (Intrinsics.areEqual(str2, "native")) {
                                            spenPluginInfo2.binaryType = 1;
                                        } else {
                                            spenPluginInfo2.binaryType = i2;
                                        }
                                        List list3 = spenPluginManager2.mBuiltInPluginList;
                                        if (list3 != null) {
                                            Iterator it2 = list3.iterator();
                                            while (it2.hasNext()) {
                                                Intrinsics.areEqual(spenPluginInfo2.canonicalClassName, ((SpenPluginInfo) it2.next()).canonicalClassName);
                                            }
                                            list3.add(spenPluginInfo2);
                                            c = c2;
                                            i = 14;
                                            i2 = 0;
                                        } else {
                                            c = c2;
                                            i = 14;
                                        }
                                    }
                                }
                                bufferedReader.close();
                            } catch (IOException e) {
                                Log.i("PluginManager", "I/O error occurs");
                                e.printStackTrace();
                                throw new IllegalStateException("E_INVALID_STATE : Fail to update ArrayList for BuiltInPluginList of App");
                            } catch (NumberFormatException e2) {
                                Log.i("PluginManager", "I/O error occurs");
                                e2.printStackTrace();
                                throw new IllegalStateException("E_INVALID_STATE : Fail to update ArrayList for BuiltInPluginList of App");
                            }
                        }
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException e3) {
                                Log.i("PluginManager", "I/O error occurs");
                                e3.printStackTrace();
                            }
                        }
                        Log.i("PluginManager", "Constructor is completed.");
                    }
                }
                spenPluginManager = SpenPluginManager.mInstance;
                Intrinsics.checkNotNull(spenPluginManager);
            } catch (Throwable th) {
                throw th;
            }
            return spenPluginManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 ¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/framework/SpenPluginManager$PluginListener;", "", "<init>", "()V", "onInstalled", "", "pluginType", "", "packageName", "onUninstalled", "native_Installed", "native_Uninstalled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static class PluginListener {
        private final native void native_Installed(String pluginType, String packageName);

        private final native void native_Uninstalled(String pluginType, String packageName);

        public void onInstalled(@NotNull String pluginType, @NotNull String packageName) {
            Intrinsics.checkNotNullParameter(pluginType, "pluginType");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            native_Installed(pluginType, packageName);
        }

        public void onUninstalled(@NotNull String pluginType, @NotNull String packageName) {
            Intrinsics.checkNotNullParameter(pluginType, "pluginType");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            native_Uninstalled(pluginType, packageName);
        }
    }

    public /* synthetic */ SpenPluginManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final synchronized SpenPluginManager getInstance(@Nullable Context context) {
        return INSTANCE.getInstance(context);
    }

    public final int getNativeHandle(@NotNull Object object) {
        long j;
        Intrinsics.checkNotNullParameter(object, "object");
        Log.i("PluginManager", "getNativeHandle()");
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(object);
        Intrinsics.checkNotNull(invocationHandler, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler");
        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler doubleClassLoaderInvocationHandler = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler;
        String name = doubleClassLoaderInvocationHandler.instance.getClass().getName();
        synchronized (this.mLoadedPluginList) {
            try {
                Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        j = 0;
                        break;
                    }
                    SpenPluginObject next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.SpenPluginObject");
                    SpenPluginObject spenPluginObject = next;
                    if (Intrinsics.areEqual(name, spenPluginObject.packageName + Extension.DOT + spenPluginObject.className)) {
                        InvocationHandler invocationHandler2 = Proxy.getInvocationHandler(spenPluginObject.obj);
                        Intrinsics.checkNotNull(invocationHandler2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler");
                        if (Intrinsics.areEqual(doubleClassLoaderInvocationHandler.instance, ((DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler2).instance)) {
                            j = spenPluginObject.nativeHandle;
                            break;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i("PluginManager", "getNativeHandle() is completed. returns " + j);
        return (int) j;
    }

    public final long getNativeHandle_64(@NotNull Object object) {
        long j;
        Intrinsics.checkNotNullParameter(object, "object");
        Log.i("PluginManager", "getNativeHandle()");
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(object);
        Intrinsics.checkNotNull(invocationHandler, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler");
        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler doubleClassLoaderInvocationHandler = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler;
        String name = doubleClassLoaderInvocationHandler.instance.getClass().getName();
        synchronized (this.mLoadedPluginList) {
            try {
                Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        j = 0;
                        break;
                    }
                    SpenPluginObject next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.SpenPluginObject");
                    SpenPluginObject spenPluginObject = next;
                    if (Intrinsics.areEqual(name, spenPluginObject.packageName + Extension.DOT + spenPluginObject.className)) {
                        InvocationHandler invocationHandler2 = Proxy.getInvocationHandler(spenPluginObject.obj);
                        Intrinsics.checkNotNull(invocationHandler2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler");
                        if (Intrinsics.areEqual(doubleClassLoaderInvocationHandler.instance, ((DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler2).instance)) {
                            j = spenPluginObject.nativeHandle;
                            break;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i("PluginManager", "getNativeHandle() is completed. returns " + j);
        return j;
    }

    @Nullable
    public final SpenPluginInfo getPluginInfo(@NotNull String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        Log.i("PluginManager", "getPluginInfo()");
        List<SpenPluginInfo> list = this.mBuiltInPluginList;
        Iterator<SpenPluginInfo> it = list != null ? list.iterator() : null;
        if (it != null) {
            while (it.hasNext()) {
                SpenPluginInfo next = it.next();
                if (Intrinsics.areEqual(className, next.packageName + Extension.DOT + next.canonicalClassName)) {
                    return next;
                }
            }
        }
        Log.i("PluginManager", "getPluginInfo() returns false");
        return null;
    }

    @NotNull
    public final List<SpenPluginInfo> getPluginList(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Log.i("PluginManager", "getPluginList()");
        ArrayList arrayList = new ArrayList();
        List<SpenPluginInfo> list = this.mBuiltInPluginList;
        Iterator<SpenPluginInfo> it = list != null ? list.iterator() : null;
        if (it != null) {
            while (it.hasNext()) {
                SpenPluginInfo next = it.next();
                if (Intrinsics.areEqual(type, next.type) || Intrinsics.areEqual(type, "all")) {
                    arrayList.add(next);
                }
            }
        }
        Log.i("PluginManager", "getPluginList() is completed.");
        return arrayList;
    }

    @Nullable
    public final String getPrivateKeyHint(@NotNull SpenPluginInfo info) {
        String privateKeyHint;
        Intrinsics.checkNotNullParameter(info, "info");
        synchronized (this.mLoadedPluginList) {
            try {
                Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        privateKeyHint = null;
                        break;
                    }
                    SpenPluginObject next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.SpenPluginObject");
                    SpenPluginObject spenPluginObject = next;
                    if (Intrinsics.areEqual(info.packageName, spenPluginObject.packageName) && Intrinsics.areEqual(info.canonicalClassName, spenPluginObject.className)) {
                        Object obj = spenPluginObject.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface");
                        privateKeyHint = ((SpenPluginInterface) obj).getPrivateKeyHint();
                        break;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return privateKeyHint;
    }

    @Nullable
    public final Object loadPlugin(@Nullable Context context, @NotNull SpenPluginInfo info, @NotNull String key) {
        ClassLoader classLoader;
        Object objBuild;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(key, "key");
        Log.i("PluginManager", "loadPlugin()");
        if (context == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null Context");
        }
        if (this.mJniPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null JniPluginManager");
        }
        synchronized (this.mLoadedPluginList) {
            try {
                Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        classLoader = null;
                        break;
                    }
                    SpenPluginObject next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.SpenPluginObject");
                    SpenPluginObject spenPluginObject = next;
                    if (Intrinsics.areEqual(info.packageName, spenPluginObject.packageName) && Intrinsics.areEqual(info.canonicalClassName, spenPluginObject.className)) {
                        classLoader = spenPluginObject.classLoader;
                        break;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        List<SpenPluginInfo> list = this.mBuiltInPluginList;
        if (list != null) {
            for (SpenPluginInfo spenPluginInfo : list) {
                if (Intrinsics.areEqual(info.packageName, spenPluginInfo.packageName) && Intrinsics.areEqual(info.canonicalClassName, spenPluginInfo.canonicalClassName)) {
                    String strM757C = AbstractC0541b.m757C(SpenPluginInterface.class.getPackage().getName(), Extension.DOT, info.interfaceName);
                    String strM757C2 = AbstractC0541b.m757C(info.packageName, Extension.DOT, info.canonicalClassName);
                    ClassLoader classLoader2 = context.getClassLoader();
                    Intrinsics.checkNotNull(classLoader2, "null cannot be cast to non-null type java.lang.ClassLoader");
                    objBuild = DoubleClassLoaderProxyBuilder.build(Class.forName(strM757C, true, context.getClassLoader()), strM757C2, classLoader2);
                    break;
                }
            }
            objBuild = null;
        } else {
            objBuild = null;
        }
        if (objBuild != null) {
            SpenPluginObject spenPluginObject2 = new SpenPluginObject();
            spenPluginObject2.type = info.type;
            int i = info.binaryType;
            spenPluginObject2.binaryType = i;
            spenPluginObject2.packageName = info.packageName;
            spenPluginObject2.className = info.canonicalClassName;
            spenPluginObject2.obj = objBuild;
            spenPluginObject2.dummyObject = null;
            if (i == 1) {
                spenPluginObject2.nativeHandle = ((SpenNativeHandleInterface) objBuild).getMEngine();
            } else {
                spenPluginObject2.nativeHandle = 0L;
            }
            spenPluginObject2.classLoader = classLoader;
            SpenPluginInterface spenPluginInterface = (SpenPluginInterface) objBuild;
            if (!spenPluginInterface.unlock(key)) {
                throw new IllegalArgumentException("E_INVALID_ARG : parameter 'key' is wrong");
            }
            long j = spenPluginObject2.nativeHandle;
            if (j == 0) {
                spenPluginInterface.onLoad(context);
                spenPluginObject2.nativeHandle = spenPluginInterface.getMEngine();
            } else if (this.mIs64) {
                JniPluginManager jniPluginManager = this.mJniPluginManager;
                if (jniPluginManager != null) {
                    jniPluginManager.onLoad(j, context);
                }
            } else {
                JniPluginManager jniPluginManager2 = this.mJniPluginManager;
                if (jniPluginManager2 != null) {
                    jniPluginManager2.onLoad((int) j, context);
                }
            }
            synchronized (this.mLoadedPluginList) {
                this.mLoadedPluginList.add(spenPluginObject2);
            }
        }
        Log.i("PluginManager", "loadPlugin() is completed");
        return objBuild;
    }

    public final void setListener(@NotNull PluginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Log.i("PluginManager", "setListener()");
        Log.i("PluginManager", "setPluginListener() is completed");
    }

    public final void unloadPlugin(@Nullable Object object) {
        boolean z;
        Log.i("PluginManager", "unloadPlugin()");
        if (this.mJniPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use unloadPlugin by null JniPluginManager");
        }
        if (object == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'object' is null");
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(object);
        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler doubleClassLoaderInvocationHandler = invocationHandler instanceof DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler ? (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler : null;
        if (doubleClassLoaderInvocationHandler == null) {
            throw new NullPointerException("E_INVALID_ARG : proxy handler of object is null");
        }
        String name = doubleClassLoaderInvocationHandler.instance.getClass().getName();
        synchronized (this.mLoadedPluginList) {
            try {
                Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SpenPluginObject next = it.next();
                    SpenPluginObject spenPluginObject = next instanceof SpenPluginObject ? next : null;
                    if (spenPluginObject != null) {
                        if (Intrinsics.areEqual(name, spenPluginObject.packageName + Extension.DOT + spenPluginObject.className)) {
                            String str = spenPluginObject.className;
                            Intrinsics.checkNotNull(str);
                            Log.i("PluginManager", str);
                            InvocationHandler invocationHandler2 = Proxy.getInvocationHandler(spenPluginObject.obj);
                            Intrinsics.checkNotNull(invocationHandler2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler");
                            if (Intrinsics.areEqual(doubleClassLoaderInvocationHandler.instance, ((DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) invocationHandler2).instance)) {
                                if (spenPluginObject.binaryType != 1) {
                                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface");
                                    ((SpenPluginInterface) object).onUnload();
                                } else if (this.mIs64) {
                                    JniPluginManager jniPluginManager = this.mJniPluginManager;
                                    Intrinsics.checkNotNull(jniPluginManager);
                                    jniPluginManager.onUnload(spenPluginObject.nativeHandle);
                                } else {
                                    JniPluginManager jniPluginManager2 = this.mJniPluginManager;
                                    Intrinsics.checkNotNull(jniPluginManager2);
                                    jniPluginManager2.onUnload((int) spenPluginObject.nativeHandle);
                                }
                                this.mLoadedPluginList.remove(spenPluginObject);
                                spenPluginObject.obj = null;
                                z = true;
                            } else {
                                z = true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            Log.i("PluginManager", "unloadPlugin() is completed");
        } else {
            Log.i("PluginManager", "unloadPlugin() returns false");
            throw new IllegalArgumentException("E_INVALID_ARG : Data to unload does not found");
        }
    }

    private SpenPluginManager() {
        this.mLoadedPluginList = new ArrayList<>();
        this.mIs64 = Spen.INSTANCE.osType() != 32;
    }

    @Nullable
    public final Object loadPlugin(@Nullable Activity activity, @NotNull SpenPluginInfo info, @NotNull String key) {
        ClassLoader classLoader;
        Object objBuild;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(key, "key");
        Log.i("PluginManager", "loadPlugin()");
        if (activity != null) {
            if (this.mJniPluginManager != null) {
                synchronized (this.mLoadedPluginList) {
                    try {
                        Iterator<SpenPluginObject> it = this.mLoadedPluginList.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (true) {
                            if (!it.hasNext()) {
                                classLoader = null;
                                break;
                            }
                            SpenPluginObject next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.framework.SpenPluginObject");
                            SpenPluginObject spenPluginObject = next;
                            if (Intrinsics.areEqual(info.packageName, spenPluginObject.packageName) && Intrinsics.areEqual(info.canonicalClassName, spenPluginObject.className)) {
                                classLoader = spenPluginObject.classLoader;
                                break;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                List<SpenPluginInfo> list = this.mBuiltInPluginList;
                if (list != null) {
                    for (SpenPluginInfo spenPluginInfo : list) {
                        if (Intrinsics.areEqual(info.packageName, spenPluginInfo.packageName) && Intrinsics.areEqual(info.canonicalClassName, spenPluginInfo.canonicalClassName)) {
                            objBuild = DoubleClassLoaderProxyBuilder.build(Class.forName(AbstractC0541b.m757C(SpenPluginInterface.class.getPackage().getName(), Extension.DOT, info.interfaceName), true, activity.getClassLoader()), AbstractC0541b.m757C(info.packageName, Extension.DOT, info.canonicalClassName), activity.getClassLoader());
                            break;
                        }
                    }
                    objBuild = null;
                } else {
                    objBuild = null;
                }
                if (objBuild != null) {
                    SpenPluginObject spenPluginObject2 = new SpenPluginObject();
                    spenPluginObject2.type = info.type;
                    int i = info.binaryType;
                    spenPluginObject2.binaryType = i;
                    spenPluginObject2.packageName = info.packageName;
                    spenPluginObject2.className = info.canonicalClassName;
                    spenPluginObject2.obj = objBuild;
                    spenPluginObject2.dummyObject = null;
                    if (i == 1) {
                        spenPluginObject2.nativeHandle = ((SpenNativeHandleInterface) objBuild).getMEngine();
                    } else {
                        spenPluginObject2.nativeHandle = 0L;
                    }
                    spenPluginObject2.classLoader = classLoader;
                    SpenPluginInterface spenPluginInterface = (SpenPluginInterface) objBuild;
                    if (spenPluginInterface.unlock(key)) {
                        long j = spenPluginObject2.nativeHandle;
                        if (j != 0) {
                            if (this.mIs64) {
                                JniPluginManager jniPluginManager = this.mJniPluginManager;
                                if (jniPluginManager != null) {
                                    jniPluginManager.onLoad(j, activity);
                                }
                            } else {
                                JniPluginManager jniPluginManager2 = this.mJniPluginManager;
                                if (jniPluginManager2 != null) {
                                    jniPluginManager2.onLoad((int) j, (Context) activity);
                                }
                            }
                        } else {
                            spenPluginInterface.onLoad(activity);
                            spenPluginObject2.nativeHandle = spenPluginInterface.getMEngine();
                        }
                        synchronized (this.mLoadedPluginList) {
                            this.mLoadedPluginList.add(spenPluginObject2);
                        }
                    } else {
                        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'key' is wrong");
                    }
                }
                Log.i("PluginManager", "loadPlugin() is completed");
                return objBuild;
            }
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null JniPluginManager");
        }
        throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null Activity");
    }
}
