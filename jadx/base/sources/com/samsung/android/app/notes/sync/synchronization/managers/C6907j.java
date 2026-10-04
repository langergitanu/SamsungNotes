package com.samsung.android.app.notes.sync.synchronization.managers;

import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import com.google.protobuf.InvalidProtocolBufferException;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6727e;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.RunnableC6726d;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import os_migration_data_types.p233v1.AttachmentMeta;
import p063P.InterfaceC0192a;
import p063P.InterfaceC0193b;
import p199l1.InterfaceC13517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6907j implements Serializer, InterfaceC0193b, InterfaceC13517a {

    /* JADX INFO: renamed from: a */
    public static C6907j f4485a;

    /* JADX INFO: renamed from: b */
    public static int m5141b(int i) {
        switch (i) {
            case 100:
                return 900;
            case 101:
            default:
                return 901;
            case 102:
                return 902;
            case 103:
                return TypedValues.Custom.TYPE_BOOLEAN;
            case 104:
                return TypedValues.Custom.TYPE_DIMENSION;
            case 105:
                return TypedValues.Custom.TYPE_REFERENCE;
            case 106:
                return 908;
            case 107:
                return SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK;
            case 108:
                return 909;
            case 109:
                return SdlMediaRecorder.MEDIA_RECORDER_INFO_POOR_NETWORK;
            case 110:
                return 912;
            case 111:
                return 913;
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C6907j m5142c() {
        try {
            if (f4485a == null) {
                f4485a = new C6907j();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4485a;
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: a */
    public void mo452a(String str) {
        Debugger.m8607d("MdeDeleteLogic", "onEnded()");
        Debugger.m8607d("MdeDeleteLogic", "onEnded : " + (System.currentTimeMillis() - C6727e.f4081h) + "ms");
        Iterator it = C6727e.f4080g.iterator();
        while (it.hasNext()) {
            ((InterfaceC0192a) it.next()).onEnded(str, -1);
        }
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: d */
    public void mo453d(String str, ArrayList arrayList) {
        Debugger.m8607d("MdeDeleteLogic", "onError()");
        new Handler(Looper.getMainLooper()).post(new RunnableC6726d(this, str, arrayList, 0));
    }

    @Override // androidx.datastore.core.Serializer
    public Object getDefaultValue() {
        AttachmentMeta defaultInstance = AttachmentMeta.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        return defaultInstance;
    }

    @Override // p063P.InterfaceC0193b
    public void onStart() {
        Debugger.m8607d("MdeDeleteLogic", "onStart()");
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, Continuation continuation) throws CorruptionException {
        try {
            AttachmentMeta from = AttachmentMeta.parseFrom(inputStream);
            Intrinsics.checkNotNullExpressionValue(from, "parseFrom(...)");
            return from;
        } catch (InvalidProtocolBufferException e) {
            throw new CorruptionException("Cannot read proto", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public Object writeTo(Object obj, OutputStream outputStream, Continuation continuation) {
        ((AttachmentMeta) obj).writeTo(outputStream);
        return Unit.INSTANCE;
    }
}
