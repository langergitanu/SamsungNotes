package com.samsung.android.app.sdk.deepsky.classifier.schedule;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor;", "", "extractSchedule", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/Schedule;", "request", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor$Request;", "isSupported", "", "Request", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ScheduleExtractor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor$Request;", "", "text", "", "language", "(Ljava/lang/String;Ljava/lang/String;)V", "getLanguage$deepsky_sdk_smartsuggestion_6_1_0_release", "()Ljava/lang/String;", "getText$deepsky_sdk_smartsuggestion_6_1_0_release", "Builder", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Request {

        @Nullable
        private final String language;

        @NotNull
        private final String text;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor$Request$Builder;", "", "()V", "language", "", "text", "build", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor$Request;", "setLanguage", "setText", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Builder {

            @Nullable
            private String language;

            @Nullable
            private String text;

            @NotNull
            public final Request build() {
                String str = this.text;
                if (str != null) {
                    return new Request(str, this.language, null);
                }
                throw new IllegalStateException("Required value was null.");
            }

            @NotNull
            public final Builder setLanguage(@Nullable String language) {
                this.language = language;
                return this;
            }

            @NotNull
            public final Builder setText(@NotNull String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
                return this;
            }
        }

        public /* synthetic */ Request(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: getLanguage$deepsky_sdk_smartsuggestion_6_1_0_release, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        /* JADX INFO: renamed from: getText$deepsky_sdk_smartsuggestion_6_1_0_release, reason: from getter */
        public final String getText() {
            return this.text;
        }

        private Request(String str, String str2) {
            this.text = str;
            this.language = str2;
        }
    }

    @WorkerThread
    @Nullable
    Schedule extractSchedule(@NotNull Request request);

    boolean isSupported();
}
