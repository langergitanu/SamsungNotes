package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitcompat.C5258c;
import com.google.android.play.core.splitcompat.C5271p;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.InterfaceC5302d;
import com.google.android.play.core.splitinstall.InterfaceC5304f;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.google.android.play.core.internal.as */
/* JADX INFO: loaded from: classes5.dex */
public final class C5170as implements InterfaceC5304f {

    /* JADX INFO: renamed from: a */
    private final Context f2958a;

    /* JADX INFO: renamed from: b */
    private final C5258c f2959b;

    /* JADX INFO: renamed from: c */
    private final C5171at f2960c;

    /* JADX INFO: renamed from: d */
    private final Executor f2961d;

    /* JADX INFO: renamed from: e */
    private final C5271p f2962e;

    public C5170as(Context context, Executor executor, C5171at c5171at, C5258c c5258c, C5271p c5271p) {
        this.f2958a = context;
        this.f2959b = c5258c;
        this.f2960c = c5171at;
        this.f2961d = executor;
        this.f2962e = c5271p;
    }

    @Nullable
    @SplitInstallErrorCode
    /* JADX INFO: renamed from: a */
    private final Integer m3901a(List<Intent> list) {
        FileChannel channel;
        Integer numValueOf;
        FileLock fileLockTryLock;
        int i;
        try {
            channel = new RandomAccessFile(this.f2959b.m4077b(), InternalZipConstants.WRITE_MODE).getChannel();
            numValueOf = null;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error locking files.", e);
            return -13;
        }
        try {
            try {
                fileLockTryLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLockTryLock = null;
            }
            if (fileLockTryLock != null) {
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    Iterator<Intent> it = list.iterator();
                    while (true) {
                        i = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        Intent next = it.next();
                        String stringExtra = next.getStringExtra("split_id");
                        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f2958a.getContentResolver().openAssetFileDescriptor(next.getData(), "r");
                        File fileM4074a = this.f2959b.m4074a(stringExtra);
                        if ((fileM4074a.exists() && fileM4074a.length() != assetFileDescriptorOpenAssetFileDescriptor.getLength()) || !fileM4074a.exists()) {
                            if (this.f2959b.m4078b(stringExtra).exists()) {
                                continue;
                            } else {
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(assetFileDescriptorOpenAssetFileDescriptor.createInputStream());
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(fileM4074a);
                                    try {
                                        byte[] bArr = new byte[4096];
                                        while (true) {
                                            int i2 = bufferedInputStream.read(bArr);
                                            if (i2 <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i2);
                                        }
                                        fileOutputStream.close();
                                        bufferedInputStream.close();
                                    } finally {
                                    }
                                } catch (Throwable th) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Throwable th2) {
                                        C5214ci.m3978a(th, th2);
                                    }
                                    throw th;
                                }
                            }
                        }
                        Log.e("SplitCompat", "Error locking files.", e);
                        return -13;
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                    } catch (Exception e2) {
                        Log.e("SplitCompat", "Error verifying splits.", e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Error copying splits.", e3);
                    i = -13;
                }
                if (this.f2960c.m3906a()) {
                    Log.i("SplitCompat", "Splits verified.");
                    numValueOf = Integer.valueOf(i);
                    fileLockTryLock.release();
                } else {
                    Log.e("SplitCompat", "Split verification failed.");
                    i = -11;
                    numValueOf = Integer.valueOf(i);
                    fileLockTryLock.release();
                }
            }
            if (channel != null) {
                channel.close();
            }
            return numValueOf;
        } finally {
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m3902a(C5170as c5170as, InterfaceC5302d interfaceC5302d) {
        try {
            if (!SplitCompat.m4056a(C5271p.m4096a(c5170as.f2958a))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                interfaceC5302d.mo4132a(-12);
            } else {
                Log.i("SplitCompat", "Splits installed.");
                interfaceC5302d.mo4131a();
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error emulating splits.", e);
            interfaceC5302d.mo4132a(-12);
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m3903a(C5170as c5170as, List list, InterfaceC5302d interfaceC5302d) {
        Integer numM3901a = c5170as.m3901a((List<Intent>) list);
        if (numM3901a == null) {
            return;
        }
        if (numM3901a.intValue() == 0) {
            interfaceC5302d.mo4133b();
        } else {
            interfaceC5302d.mo4132a(numM3901a.intValue());
        }
    }

    @Override // com.google.android.play.core.splitinstall.InterfaceC5304f
    /* JADX INFO: renamed from: a */
    public final void mo3904a(List<Intent> list, InterfaceC5302d interfaceC5302d) {
        if (!SplitCompat.m4055a()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.f2961d.execute(new RunnableC5169ar(this, list, interfaceC5302d));
    }
}
