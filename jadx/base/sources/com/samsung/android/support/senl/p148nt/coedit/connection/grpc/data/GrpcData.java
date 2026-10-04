package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.data;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p042J1.AbstractC0146d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GrpcData {
    private static final int MAX_INBOUND_MESSAGE_SIZE = 8388608;
    protected static final int MAX_OUTBOUND_MESSAGE_SIZE = 2097152;
    protected ManagedChannel mChannel;
    private boolean mIsFinished;
    protected Metadata mMetadata;

    private void addMetadata(String str, String str2) {
        if (this.mMetadata == null) {
            this.mMetadata = new Metadata();
        }
        this.mMetadata.put(Metadata.Key.m13734of(str, Metadata.ASCII_STRING_MARSHALLER), str2);
    }

    private void delayedShutdownChannel(String str, String str2) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        CoeditLogger.m8923i(getTag(), "delayedShutdownChannel(), caller: " + str + ", message: " + str2);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            CoeditLogger.m8920e(getTag(), "delayedShutdownChannel(), exception: " + e.getMessage());
        } finally {
            shutdownChannel(str, str2);
        }
    }

    private synchronized void setFinished(boolean z) {
        this.mIsFinished = z;
    }

    private void shutdownChannel(String str, String str2) {
        ManagedChannel managedChannel = this.mChannel;
        if (managedChannel == null) {
            return;
        }
        if (managedChannel.isTerminated()) {
            CoeditLogger.m8924w(getTag(), "shutdownChannel(), ignore, already terminated, caller: " + str + ", message: " + str2);
            return;
        }
        if (this.mChannel.isShutdown()) {
            CoeditLogger.m8924w(getTag(), "shutdownChannel(), ignore, already shutdown, immediately cancel any new call, caller: " + str + ", message: " + str2);
            return;
        }
        CoeditLogger.m8923i(getTag(), "shutdownChannel(), start, caller: " + str + ", message: " + str2);
        try {
            try {
                this.mChannel.shutdown();
            } catch (InterruptedException e) {
                CoeditLogger.m8920e(getTag(), "delayedShutdownChannel(), exception: " + e.getMessage());
            }
            if (!this.mChannel.awaitTermination(1L, TimeUnit.SECONDS)) {
            }
            CoeditLogger.m8923i(getTag(), "shutdownChannel(), end, caller: " + str + ", message: " + str2);
        } finally {
            this.mChannel.shutdownNow();
        }
    }

    public abstract String getTag();

    public void initialize(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            int i = TextUtils.isEmpty(str2) ? 0 : Integer.parseInt(str2);
            CoeditLogger.m8919d(getTag(), "host : " + str + ", port : " + i);
            this.mChannel = NettyChannelBuilder.forAddress(str, i).maxInboundMessageSize(8388608).sslContext(GrpcSslContexts.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build()).build();
            addMetadata("cid", CoeditServiceConstants.MetaData.METADATA_VAL_CONTENT_ID);
            addMetadata(CoeditServiceConstants.Document.KEY_APP_VERSION, str3);
            addMetadata(CoeditServiceConstants.Document.KEY_SDK_VERSION, str4);
            addMetadata(CoeditServiceConstants.Document.KEY_XML_VERSION, str5);
            addMetadata("model", Build.MODEL);
            boolean z = AbstractC0146d.f417a;
            addMetadata(CoeditServiceConstants.MetaData.USER_AGENT, SCloudPamHelper.getUserAgent());
            addMetadata("Authorization", IdentityApiContract.Token.BEARER_ + str6);
            CoeditLogger.m8923i(getTag(), "initialize, metaData: " + CoeditLogger.getEncode(this.mMetadata.toString()));
        } catch (Throwable th) {
            CoeditLogger.m8920e(getTag(), "Failed to build channel. " + th.getMessage());
        }
    }

    public synchronized boolean isFinished() {
        return this.mIsFinished;
    }

    public abstract boolean isInvalidStub();

    public void start(String str) {
        AbstractC8014b.m7219u("start, caller: ", str, getTag());
        setFinished(false);
    }

    public void stop(String str, String str2, boolean z) {
        if (isFinished()) {
            CoeditLogger.m8924w(getTag(), "stop(), already finished, caller: " + str + ", message: " + str2);
            return;
        }
        String tag = getTag();
        StringBuilder sbM16m = AbstractC0000a.m16m("stop, caller: ", str, ", message: ", str2, ", isDelayed: ");
        sbM16m.append(z);
        CoeditLogger.m8923i(tag, sbM16m.toString());
        setFinished(true);
        if (z) {
            delayedShutdownChannel(str, str2);
        } else {
            shutdownChannel(str, str2);
        }
    }
}
