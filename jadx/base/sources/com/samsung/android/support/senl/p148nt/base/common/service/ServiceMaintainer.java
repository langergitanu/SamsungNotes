package com.samsung.android.support.senl.p148nt.base.common.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceMaintainer;", "Landroid/os/Handler;", "serviceName", "", "<init>", "(Ljava/lang/String;)V", "mTag", "mConnection", "Landroid/content/ServiceConnection;", "mServiceMaintainerListener", "Lcom/samsung/android/support/senl/nt/base/common/service/ServiceMaintainer$ServiceMaintainerListener;", "setServiceMaintainerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bind", "context", "Landroid/content/Context;", "bindService", "Ljava/lang/Class;", "handleMessage", "msg", "Landroid/os/Message;", "unbind", "unbindInternal", "isConnected", "", "()Z", "ServiceMaintainerListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nServiceMaintainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServiceMaintainer.kt\ncom/samsung/android/support/senl/nt/base/common/service/ServiceMaintainer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
public final class ServiceMaintainer extends Handler {
    private static final long CONNECTION_MAINTAINING_TIME = 3000;
    private static final int MESSAGE_UNBIND = 0;

    @Nullable
    private ServiceConnection mConnection;

    @Nullable
    private ServiceMaintainerListener mServiceMaintainerListener;

    @NotNull
    private final String mTag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceMaintainer$ServiceMaintainerListener;", "", "onBind", "", "onUnbind", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ServiceMaintainerListener {
        void onBind();

        void onUnbind();
    }

    public ServiceMaintainer(@NotNull String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        this.mTag = AbstractC0541b.m756B(serviceName, "$ServiceMaintainer");
    }

    private final void unbindInternal(Context context) {
        String str = this.mTag;
        Object obj = this.mConnection;
        if (obj == null) {
            obj = "null";
        }
        Logger.m8702i(str, "unbindInternal, mConnection : " + obj);
        ServiceConnection serviceConnection = this.mConnection;
        if (serviceConnection != null) {
            Intrinsics.checkNotNull(serviceConnection);
            context.unbindService(serviceConnection);
            this.mConnection = null;
            ServiceMaintainerListener serviceMaintainerListener = this.mServiceMaintainerListener;
            if (serviceMaintainerListener != null) {
                serviceMaintainerListener.onUnbind();
            }
            this.mServiceMaintainerListener = null;
        }
    }

    public final void bind(@NotNull Context context, @NotNull Class<?> bindService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bindService, "bindService");
        String str = this.mTag;
        Object obj = this.mConnection;
        if (obj == null) {
            obj = "null";
        }
        Logger.m8702i(str, "bind, bindService : " + bindService + ", mConnection : " + obj);
        removeMessages(0);
        if (this.mConnection != null) {
            return;
        }
        Intent intent = new Intent(context, bindService);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.base.common.service.ServiceMaintainer.bind.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Logger.m8702i(ServiceMaintainer.this.mTag, "onServiceConnected, name : " + name);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Logger.m8702i(ServiceMaintainer.this.mTag, "onServiceDisconnected, name : " + name);
            }
        };
        this.mConnection = serviceConnection;
        Unit unit = Unit.INSTANCE;
        context.bindService(intent, serviceConnection, 1);
        ServiceMaintainerListener serviceMaintainerListener = this.mServiceMaintainerListener;
        if (serviceMaintainerListener != null) {
            serviceMaintainerListener.onBind();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8697d(this.mTag, "handleMessage, msg : " + msg);
        if (msg.what == 0) {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Context");
            unbindInternal((Context) obj);
        }
    }

    public final boolean isConnected() {
        return this.mConnection != null;
    }

    public final void setServiceMaintainerListener(@Nullable ServiceMaintainerListener listener) {
        this.mServiceMaintainerListener = listener;
    }

    public final void unbind(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.m8702i(this.mTag, "unbind, mConnection : " + this.mConnection + ", delay : 3000");
        sendMessageDelayed(Message.obtain(this, 0, context.getApplicationContext()), 3000L);
    }
}
