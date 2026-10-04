package com.samsung.android.support.senl.p148nt.stt.base.model;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/TextDataCreator;", "", "<init>", "()V", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextDataCreator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "TextDataCreator";

    @Nullable
    private static TextDataCreator mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/TextDataCreator$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextDataCreator;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/base/model/TextDataCreator;", "createTextData", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "text", "speakerId", "", "start", "end", "cloneTextData", "data", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TextData cloneTextData(@NotNull TextData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                Object objClone = data.clone();
                Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.stt.base.model.TextData");
                return (TextData) objClone;
            } catch (CloneNotSupportedException unused) {
                Logger.m12711e(TextDataCreator.TAG, "makeCloneOfSttData() : clone fail");
                return null;
            }
        }

        @NotNull
        public final TextData createTextData(@NotNull String text, int speakerId, int start, int end) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new TextData(text, speakerId, start, end);
        }

        @Nullable
        public final synchronized TextDataCreator getInstance() {
            try {
                if (TextDataCreator.mInstance == null) {
                    TextDataCreator.mInstance = new TextDataCreator();
                }
            } catch (Throwable th) {
                throw th;
            }
            return TextDataCreator.mInstance;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    @Nullable
    public static final synchronized TextDataCreator getInstance() {
        return INSTANCE.getInstance();
    }
}
