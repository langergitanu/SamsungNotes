package com.samsung.android.app.sdk.deepsky.contract.feedback;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NO_ACTION", "POSITIVE_IMPLICIT", "POSITIVE_EXPLICIT", "NEGATIVE_IMPLICIT", "NEGATIVE_EXPLICIT", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public enum FeedbackType {
    NO_ACTION(1),
    POSITIVE_IMPLICIT(2),
    POSITIVE_EXPLICIT(3),
    NEGATIVE_IMPLICIT(4),
    NEGATIVE_EXPLICIT(5);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int id;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType;", "id", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nFeedbackType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackType.kt\ncom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n1282#2,2:38\n*S KotlinDebug\n*F\n+ 1 FeedbackType.kt\ncom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType$Companion\n*L\n34#1:38,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedbackType from(int id) {
            FeedbackType feedbackType;
            FeedbackType[] feedbackTypeArrValues = FeedbackType.values();
            int length = feedbackTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    feedbackType = null;
                    break;
                }
                feedbackType = feedbackTypeArrValues[i];
                if (feedbackType.getId() == id) {
                    break;
                }
                i++;
            }
            return feedbackType == null ? FeedbackType.NO_ACTION : feedbackType;
        }

        private Companion() {
        }
    }

    FeedbackType(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}
