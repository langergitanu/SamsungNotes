package com.samsung.android.support.senl.p148nt.model.contextawareness.worker.task;

import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.IContextAwarenessParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TaskFactory {

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.contextawareness.worker.task.TaskFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114381 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$contextawareness$common$param$IContextAwarenessParam$Type */
        static final /* synthetic */ int[] f7700x6cb89fd2;

        static {
            int[] iArr = new int[IContextAwarenessParam.Type.values().length];
            f7700x6cb89fd2 = iArr;
            try {
                iArr[IContextAwarenessParam.Type.SUBSCRIBE_SUGGESTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7700x6cb89fd2[IContextAwarenessParam.Type.REQUEST_SUGGESTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7700x6cb89fd2[IContextAwarenessParam.Type.DRAW_SUGGESTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7700x6cb89fd2[IContextAwarenessParam.Type.EXECUTE_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7700x6cb89fd2[IContextAwarenessParam.Type.ATTACH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7700x6cb89fd2[IContextAwarenessParam.Type.UNSUBSCRIBE_SUGGESTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public DeepSkyTask createTask(ContextAwarenessParam contextAwarenessParam) {
        switch (C114381.f7700x6cb89fd2[contextAwarenessParam.getType().ordinal()]) {
            case 1:
                return new SubscribeSuggestion(contextAwarenessParam);
            case 2:
                return new RequestSuggestion(contextAwarenessParam);
            case 3:
                return new DrawSuggestion(contextAwarenessParam);
            case 4:
                return new ExecuteAction(contextAwarenessParam);
            case 5:
                return new AttachContent(contextAwarenessParam);
            case 6:
                return new UnsubscribeSuggestion(contextAwarenessParam);
            default:
                return new InvalidTask(contextAwarenessParam);
        }
    }
}
