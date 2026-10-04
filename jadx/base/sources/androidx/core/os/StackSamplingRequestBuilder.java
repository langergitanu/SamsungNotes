package androidx.core.os;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(api = 35)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0015J\b\u0010\u0006\u001a\u00020\u0007H\u0015J\b\u0010\b\u001a\u00020\u0000H\u0015J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Landroidx/core/os/StackSamplingRequestBuilder;", "Landroidx/core/os/ProfilingRequestBuilder;", "()V", "mParams", "Landroid/os/Bundle;", "getParams", "getProfilingType", "", "getThis", "setBufferSizeKb", "bufferSizeKb", "setDurationMs", "durationMs", "setSamplingFrequencyHz", "samplingFrequencyHz", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StackSamplingRequestBuilder extends ProfilingRequestBuilder<StackSamplingRequestBuilder> {

    @NotNull
    private final Bundle mParams = new Bundle();

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    @NotNull
    /* JADX INFO: renamed from: getParams, reason: from getter */
    public Bundle getMParams() {
        return this.mParams;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public int getProfilingType() {
        return 3;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    @NotNull
    public StackSamplingRequestBuilder getThis() {
        return this;
    }

    @NotNull
    public final StackSamplingRequestBuilder setBufferSizeKb(int bufferSizeKb) {
        this.mParams.putInt("KEY_SIZE_KB", bufferSizeKb);
        return this;
    }

    @NotNull
    public final StackSamplingRequestBuilder setDurationMs(int durationMs) {
        this.mParams.putInt("KEY_DURATION_MS", durationMs);
        return this;
    }

    @NotNull
    public final StackSamplingRequestBuilder setSamplingFrequencyHz(int samplingFrequencyHz) {
        this.mParams.putInt("KEY_FREQUENCY_HZ", samplingFrequencyHz);
        return this;
    }
}
