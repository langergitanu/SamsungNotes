package com.samsung.android.app.sdk.deepsky.feedback;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.common.Injector;
import com.samsung.android.app.sdk.deepsky.contract.feedback.FeedbackContract;
import com.samsung.android.app.sdk.deepsky.contract.feedback.FeedbackType;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027F3.RunnableC0101a;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/feedback/FeedbackRequest;", "Lcom/samsung/android/app/sdk/deepsky/feedback/Feedback;", "contentProviderCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "(Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;)V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "send", "", "widgetComponentName", "Landroid/content/ComponentName;", "feedbackType", "Lcom/samsung/android/app/sdk/deepsky/contract/feedback/FeedbackType;", "sendFeedback", "sendRawData", "stackId", "", "sendRawFeedback", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FeedbackRequest implements Feedback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "FeedbackRequest";

    @Nullable
    private static volatile FeedbackRequest sInstance;

    @NotNull
    private final ContentProviderCaller contentProviderCaller;

    @NotNull
    private final ExecutorService mExecutorService;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/feedback/FeedbackRequest$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/app/sdk/deepsky/feedback/FeedbackRequest;", "getInstance", "context", "Landroid/content/Context;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FeedbackRequest getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (FeedbackRequest.sInstance == null) {
                synchronized (Reflection.getOrCreateKotlinClass(FeedbackRequest.class)) {
                    FeedbackRequest.sInstance = new FeedbackRequest(Injector.INSTANCE.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context), null);
                    Unit unit = Unit.INSTANCE;
                }
            }
            return FeedbackRequest.sInstance;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FeedbackRequest(ContentProviderCaller contentProviderCaller, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentProviderCaller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$0(FeedbackRequest this$0, ComponentName widgetComponentName, FeedbackType feedbackType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(widgetComponentName, "$widgetComponentName");
        Intrinsics.checkNotNullParameter(feedbackType, "$feedbackType");
        this$0.sendFeedback(widgetComponentName, feedbackType);
    }

    private final void sendFeedback(ComponentName widgetComponentName, FeedbackType feedbackType) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(FeedbackContract.KEY_WIDGET_COMPONENT_NAME, widgetComponentName);
        bundle.putInt(FeedbackContract.KEY_FEEDBACK_TYPE, feedbackType.getId());
        this.contentProviderCaller.sendCommand(FeedbackContract.INSTANCE.getCONTENT_URI(), FeedbackContract.METHOD_SUBMIT_FEEDBACK_WIDGET, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendRawData$lambda$1(FeedbackRequest this$0, int i, ComponentName widgetComponentName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(widgetComponentName, "$widgetComponentName");
        this$0.sendRawFeedback(i, widgetComponentName);
    }

    private final void sendRawFeedback(int stackId, ComponentName widgetComponentName) {
        Bundle bundle = new Bundle();
        bundle.putInt(FeedbackContract.KEY_STACK_ID, stackId);
        bundle.putParcelable(FeedbackContract.KEY_WIDGET_COMPONENT_NAME, widgetComponentName);
        this.contentProviderCaller.sendCommand(FeedbackContract.METHOD_SUBMIT_RAW_FEEDBACK_WIDGET, bundle);
    }

    @Override // com.samsung.android.app.sdk.deepsky.feedback.Feedback
    public void send(@NotNull ComponentName widgetComponentName, @NotNull FeedbackType feedbackType) {
        Intrinsics.checkNotNullParameter(widgetComponentName, "widgetComponentName");
        Intrinsics.checkNotNullParameter(feedbackType, "feedbackType");
        this.mExecutorService.execute(new RunnableC0201c(this, 6, widgetComponentName, feedbackType));
    }

    @Override // com.samsung.android.app.sdk.deepsky.feedback.Feedback
    public void sendRawData(int stackId, @NotNull ComponentName widgetComponentName) {
        Intrinsics.checkNotNullParameter(widgetComponentName, "widgetComponentName");
        this.mExecutorService.execute(new RunnableC0101a(this, stackId, widgetComponentName, 1));
    }

    private FeedbackRequest(ContentProviderCaller contentProviderCaller) {
        this.contentProviderCaller = contentProviderCaller;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
    }
}
