package com.samsung.android.support.senl.p148nt.base.common.tipcard;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u0006\u0010(\u001a\u00020)J\b\u0010.\u001a\u00020\u0003H\u0016J\u0013\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R$\u0010\b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u001cR$\u0010 \u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u001cR\u0011\u0010*\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0010¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/tipcard/TipCardProgress;", "Lcom/samsung/android/support/senl/nt/base/common/tipcard/TipCard;", "type", "", "titleResourceId", "bodyResourceId", "negativeButtonResourceId", "priority", "state", "<init>", "(IIIIII)V", "mTotal", "mFinished", "value", TelemetryEventStrings.Value.FAILED, "getFailed", "()I", "progressValue", "getProgressValue", "", "progressRate", "getProgressRate", "()Ljava/lang/String;", "mState", "progressTypeResId", "getProgressTypeResId", "getState", "setState", "(I)V", "setProgressInfo", "", ImportHandler.KEY_TOTAL, "finished", "getTotal", "setTotal", "getFinished", "setFinished", "updateProgressValue", "updateProgressRate", "updateProgressTypeResId", "isFinished", "", "isNotInitialized", "()Z", "neutralButtonResourceId", "getNeutralButtonResourceId", "hashCode", "equals", "obj", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class TipCardProgress extends TipCard {
    public static final int STATE_CONVERTING = 1;
    public static final int STATE_CONVERTING_SDOC = 2;
    public static final int STATE_DOWNLOADING = 0;
    public static final int STATE_IMPORTING_PDF = 4;
    public static final int STATE_IMPORTING_SDOCX = 3;
    public static final int STATE_NONE = -1;
    private int failed;
    private int mFinished;
    private int mState;
    private int mTotal;

    @Nullable
    private String progressRate;

    @StringRes
    private int progressTypeResId;
    private int progressValue;

    public TipCardProgress(int i, int i2, int i4, int i5, int i6, int i7) {
        super(i, i2, i4, 0, i5, i6);
        this.mState = -1;
        setProgressInfo(0, 0, 0);
        setState(i7);
    }

    private final void updateProgressRate() {
        if (LocaleUtils.isRTLMode()) {
            this.progressRate = AbstractC0541b.m757C(LocaleUtils.convertToArabicNumber(this.mTotal), "/", LocaleUtils.convertToArabicNumber(this.mFinished));
            return;
        }
        this.progressRate = this.mFinished + "/" + this.mTotal;
    }

    private final void updateProgressTypeResId() {
        int i = this.mState;
        if (i == 0) {
            this.progressTypeResId = C8875R.string.base_string_downloading;
            return;
        }
        if (i == 1) {
            this.progressTypeResId = C8875R.string.base_string_converting;
        } else if (i == 4) {
            this.progressTypeResId = C8875R.string.base_string_importing_notes;
        } else {
            this.progressTypeResId = -1;
        }
    }

    private final void updateProgressValue() {
        int i = this.mTotal;
        if (i == 0) {
            this.progressValue = 0;
        } else {
            this.progressValue = (this.mFinished * 100) / i;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public final int getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: getFinished, reason: from getter */
    public final int getMFinished() {
        return this.mFinished;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int getNeutralButtonResourceId() {
        return 0;
    }

    @Nullable
    public final String getProgressRate() {
        return this.progressRate;
    }

    public final int getProgressTypeResId() {
        return this.progressTypeResId;
    }

    public final int getProgressValue() {
        return this.progressValue;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    /* JADX INFO: renamed from: getTotal, reason: from getter */
    public final int getMTotal() {
        return this.mTotal;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int hashCode() {
        return super.hashCode();
    }

    public final boolean isFinished() {
        return this.mFinished == this.mTotal;
    }

    public final boolean isNotInitialized() {
        return this.mFinished == 0 && this.mTotal == 0;
    }

    public final void setFinished(int i) {
        if (this.mFinished != i) {
            this.mFinished = i;
            updateProgressValue();
            updateProgressRate();
        }
    }

    public final void setProgressInfo(int total, int finished, int failed) {
        int i;
        if (this.mTotal == total && (i = this.mFinished) == finished && i == failed) {
            return;
        }
        this.mTotal = total;
        this.mFinished = finished;
        this.failed = failed;
        updateProgressValue();
        updateProgressRate();
    }

    public final void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            updateProgressTypeResId();
        }
    }

    public final void setTotal(int i) {
        if (this.mTotal != i) {
            this.mTotal = i;
            updateProgressValue();
            updateProgressRate();
        }
    }
}
