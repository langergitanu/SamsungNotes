package com.samsung.android.support.senl.p148nt.stt.base.model.paint;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfoCreator;", "", "<init>", "()V", "createPaintIndexInfo", "Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfo;", "start", "", "end", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaintIndexInfoCreator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PaintIndexInfoCreator";

    @Nullable
    private static PaintIndexInfoCreator mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfoCreator$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfoCreator;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintIndexInfoCreator;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final synchronized PaintIndexInfoCreator getInstance() {
            try {
                if (PaintIndexInfoCreator.mInstance == null) {
                    PaintIndexInfoCreator.mInstance = new PaintIndexInfoCreator();
                }
            } catch (Throwable th) {
                throw th;
            }
            return PaintIndexInfoCreator.mInstance;
        }

        private Companion() {
        }
    }

    @NotNull
    public final PaintIndexInfo createPaintIndexInfo() {
        return new PaintIndexInfo();
    }

    @NotNull
    public final PaintIndexInfo createPaintIndexInfo(int start, int end) {
        return new PaintIndexInfo(start, end);
    }
}
