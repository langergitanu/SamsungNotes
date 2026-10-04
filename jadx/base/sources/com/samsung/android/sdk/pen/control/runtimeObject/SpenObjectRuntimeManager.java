package com.samsung.android.sdk.pen.control.runtimeObject;

import android.app.Activity;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001a\u001a\u00020\nR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntimeManager;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mActivity", "mListener", "Lcom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntimeManager$InstallListener;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPrivateKeyHint", "", "info", "Lcom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntimeInfo;", "objectRuntimeInfoList", "", "getObjectRuntimeInfoList", "()Ljava/util/List;", "createObjectRuntime", "Lcom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntime;", "privateKey", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "unload", "objectRuntime", "close", "InstallListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectRuntimeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectRuntimeManager.kt\ncom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntimeManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
public final class SpenObjectRuntimeManager {

    @NotNull
    private static final String PLUGIN_TYPE = "ObjectRuntime";

    @Nullable
    private Activity mActivity;

    @Nullable
    private InstallListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/runtimeObject/SpenObjectRuntimeManager$InstallListener;", "", "onInstalled", "", "packageName", "", "onUninstalled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface InstallListener {
        void onInstalled(@NotNull String packageName);

        void onUninstalled(@NotNull String packageName);
    }

    public SpenObjectRuntimeManager(@Nullable Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mActivity = activity;
    }

    public final void close() {
        this.mActivity = null;
        this.mListener = null;
    }

    @NotNull
    public final SpenObjectRuntime createObjectRuntime(@Nullable SpenObjectRuntimeInfo info) throws ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        for (SpenPluginInfo spenPluginInfo : SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE)) {
            if (Intrinsics.areEqual(info.className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName) && Intrinsics.areEqual(info.name, spenPluginInfo.pluginNameUri) && info.version == spenPluginInfo.version) {
                Object objLoadPlugin = SpenPluginManager.INSTANCE.getInstance(this.mActivity).loadPlugin(this.mActivity, spenPluginInfo, "");
                Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface");
                return new SpenObjectRuntime((SpenObjectRuntimeInterface) objLoadPlugin);
            }
        }
        throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " ObjectRuntime"));
    }

    @Nullable
    public final List<SpenObjectRuntimeInfo> getObjectRuntimeInfoList() {
        List<SpenPluginInfo> pluginList = SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        ArrayList arrayList = new ArrayList();
        for (SpenPluginInfo spenPluginInfo : pluginList) {
            SpenObjectRuntimeInfo spenObjectRuntimeInfo = new SpenObjectRuntimeInfo();
            spenObjectRuntimeInfo.name = spenPluginInfo.pluginNameUri;
            spenObjectRuntimeInfo.className = AbstractC0541b.m757C(spenPluginInfo.packageName, Extension.DOT, spenPluginInfo.canonicalClassName);
            spenObjectRuntimeInfo.version = spenPluginInfo.version;
            arrayList.add(spenObjectRuntimeInfo);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @NotNull
    public final String getPrivateKeyHint(@Nullable SpenObjectRuntimeInfo info) throws InstantiationException, ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        for (SpenPluginInfo spenPluginInfo : SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE)) {
            if (Intrinsics.areEqual(info.className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName) && Intrinsics.areEqual(info.name, spenPluginInfo.pluginNameUri) && info.version == spenPluginInfo.version) {
                try {
                    return String.valueOf(SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPrivateKeyHint(spenPluginInfo));
                } catch (InstantiationException unused) {
                    throw new InstantiationException("SpenPluginManager.getInstance Error");
                }
            }
        }
        throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " ObjectRuntime"));
    }

    public final void setListener(@Nullable final InstallListener listener) {
        this.mListener = listener;
        if (listener != null) {
            SpenPluginManager.INSTANCE.getInstance(this.mActivity).setListener(new SpenPluginManager.PluginListener() { // from class: com.samsung.android.sdk.pen.control.runtimeObject.SpenObjectRuntimeManager$setListener$1$1
                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onInstalled(String pluginType, String packageName) {
                    Intrinsics.checkNotNullParameter(pluginType, "pluginType");
                    Intrinsics.checkNotNullParameter(packageName, "packageName");
                    if (Intrinsics.areEqual(pluginType, "ObjectRuntime")) {
                        listener.onInstalled(packageName);
                    }
                }

                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onUninstalled(String pluginType, String packageName) {
                    Intrinsics.checkNotNullParameter(pluginType, "pluginType");
                    Intrinsics.checkNotNullParameter(packageName, "packageName");
                    if (Intrinsics.areEqual(pluginType, "ObjectRuntime")) {
                        listener.onUninstalled(packageName);
                    }
                }
            });
        }
    }

    public final void unload(@Nullable SpenObjectRuntime objectRuntime) {
        if (objectRuntime == null) {
            throw new IllegalStateException("E_INVALID_STATE : ObjectRuntime is not loaded");
        }
        SpenPluginManager.INSTANCE.getInstance(this.mActivity).unloadPlugin(objectRuntime.getObjectRuntimeObject());
    }

    @NotNull
    public final SpenObjectRuntime createObjectRuntime(@Nullable SpenObjectRuntimeInfo info, @NotNull String privateKey) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        if (info != null) {
            for (SpenPluginInfo spenPluginInfo : SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE)) {
                if (Intrinsics.areEqual(info.className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName) && Intrinsics.areEqual(info.name, spenPluginInfo.pluginNameUri) && info.version == spenPluginInfo.version) {
                    Object objLoadPlugin = SpenPluginManager.INSTANCE.getInstance(this.mActivity).loadPlugin(this.mActivity, spenPluginInfo, privateKey);
                    Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface");
                    return new SpenObjectRuntime((SpenObjectRuntimeInterface) objLoadPlugin);
                }
            }
            throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", info.name, " ObjectRuntime"));
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
    }

    @NotNull
    public final SpenObjectRuntime createObjectRuntime(@Nullable String className) throws ClassNotFoundException {
        if (className != null) {
            for (SpenPluginInfo spenPluginInfo : SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE)) {
                if (Intrinsics.areEqual(className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName)) {
                    Object objLoadPlugin = SpenPluginManager.INSTANCE.getInstance(this.mActivity).loadPlugin(this.mActivity, spenPluginInfo, "");
                    Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface");
                    return new SpenObjectRuntime((SpenObjectRuntimeInterface) objLoadPlugin);
                }
            }
            throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", className, " ObjectRuntime"));
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
    }

    @NotNull
    public final SpenObjectRuntime createObjectRuntime(@Nullable String className, @NotNull String privateKey) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        if (className != null) {
            for (SpenPluginInfo spenPluginInfo : SpenPluginManager.INSTANCE.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE)) {
                if (Intrinsics.areEqual(className, spenPluginInfo.packageName + Extension.DOT + spenPluginInfo.canonicalClassName)) {
                    Object objLoadPlugin = SpenPluginManager.INSTANCE.getInstance(this.mActivity).loadPlugin(this.mActivity, spenPluginInfo, privateKey);
                    Intrinsics.checkNotNull(objLoadPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface");
                    return new SpenObjectRuntime((SpenObjectRuntimeInterface) objLoadPlugin);
                }
            }
            throw new ClassNotFoundException(AbstractC0541b.m773o("Can not find ", className, " ObjectRuntime"));
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
    }
}
