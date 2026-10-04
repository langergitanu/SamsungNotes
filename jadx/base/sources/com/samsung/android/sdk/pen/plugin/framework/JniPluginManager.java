package com.samsung.android.sdk.pen.plugin.framework;

import android.content.Context;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086 J1\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0086 J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0086 J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH\u0086 J1\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0086 ¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/framework/JniPluginManager;", "", "<init>", "()V", "onLoad", "", "handle", "", "context", "Landroid/content/Context;", "onUnload", "onCommand", "Ljava/util/ArrayList;", Contract.COMMAND, "objectList", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class JniPluginManager {
    @Nullable
    public final native ArrayList<Object> onCommand(int handle, int command, @Nullable ArrayList<Object> objectList);

    @Nullable
    public final native ArrayList<Object> onCommand(long handle, int command, @Nullable ArrayList<Object> objectList);

    public final native void onLoad(int handle, @NotNull Context context);

    public final native void onLoad(long handle, @NotNull Context context);

    public final native void onUnload(int handle);

    public final native void onUnload(long handle);
}
