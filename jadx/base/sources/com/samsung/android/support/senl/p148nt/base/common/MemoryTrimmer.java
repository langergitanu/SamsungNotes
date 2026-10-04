package com.samsung.android.support.senl.p148nt.base.common;

import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H$J\b\u0010\u000b\u001a\u00020\u0007H$J\b\u0010\f\u001a\u00020\u0007H$J\b\u0010\r\u001a\u00020\u0007H$J\b\u0010\u000e\u001a\u00020\u0007H$R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer;", "", "<init>", "()V", "mTrimLevelCompat", "Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer$TrimLevelCompat;", "trimMemory", "", "level", "", "trimUIMemory", "trimTaskMemory", "trimCriticalMemory", "trimRunningMemory", "trimBackgroundMemory", "TrimLevelCompat", "VOsTrimLevelCompat", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class MemoryTrimmer {

    @NotNull
    private final TrimLevelCompat mTrimLevelCompat;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0090\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer$TrimLevelCompat;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer;)V", "trimMemory", "", "level", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public class TrimLevelCompat {
        public TrimLevelCompat() {
        }

        public void trimMemory(int level) {
            if (level == 10 || level == 15) {
                MemoryTrimmer.this.trimRunningMemory();
                return;
            }
            if (level == 20) {
                MemoryTrimmer.this.trimUIMemory();
            } else if (level == 60) {
                MemoryTrimmer.this.trimTaskMemory();
            } else {
                if (level != 80) {
                    return;
                }
                MemoryTrimmer.this.trimCriticalMemory();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0080\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer$VOsTrimLevelCompat;", "Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer$TrimLevelCompat;", "Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/common/MemoryTrimmer;)V", "trimMemory", "", "level", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class VOsTrimLevelCompat extends TrimLevelCompat {
        public VOsTrimLevelCompat() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MemoryTrimmer.TrimLevelCompat
        public void trimMemory(int level) {
            if (level == 20) {
                MemoryTrimmer.this.trimUIMemory();
            } else {
                if (level != 40) {
                    return;
                }
                MemoryTrimmer.this.trimBackgroundMemory();
            }
        }
    }

    public MemoryTrimmer() {
        this.mTrimLevelCompat = Build.VERSION.SDK_INT <= 34 ? new TrimLevelCompat() : new VOsTrimLevelCompat();
    }

    public abstract void trimBackgroundMemory();

    public abstract void trimCriticalMemory();

    public final void trimMemory(int level) {
        this.mTrimLevelCompat.trimMemory(level);
    }

    public abstract void trimRunningMemory();

    public abstract void trimTaskMemory();

    public abstract void trimUIMemory();
}
