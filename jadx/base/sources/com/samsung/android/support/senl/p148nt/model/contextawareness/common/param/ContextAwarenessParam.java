package com.samsung.android.support.senl.p148nt.model.contextawareness.common.param;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.IContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContextAwarenessParam {
    private static final int SUBSCRIBE_ID = 11312251;
    private Activity mActivity;
    private int mCaller;
    private Intent mIntent;
    private SuggestionInfo mSuggestionInfo;
    private IContextAwarenessParam.Type mType;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.contextawareness.common.param.ContextAwarenessParam$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114361 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$model$contextawareness$common$param$IContextAwarenessParam$Type */
        static final /* synthetic */ int[] f7698x6cb89fd2;

        static {
            int[] iArr = new int[IContextAwarenessParam.Type.values().length];
            f7698x6cb89fd2 = iArr;
            try {
                iArr[IContextAwarenessParam.Type.SUBSCRIBE_SUGGESTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7698x6cb89fd2[IContextAwarenessParam.Type.DRAW_SUGGESTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7698x6cb89fd2[IContextAwarenessParam.Type.EXECUTE_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7698x6cb89fd2[IContextAwarenessParam.Type.ATTACH_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7698x6cb89fd2[IContextAwarenessParam.Type.UNSUBSCRIBE_SUGGESTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContextAwarenessParamBuilder {
        private final ContextAwarenessParam mContextAwarenessParam = new ContextAwarenessParam(0);

        public ContextAwarenessParam build() {
            return this.mContextAwarenessParam;
        }

        public ContextAwarenessParamBuilder setActivity(Activity activity) {
            this.mContextAwarenessParam.setActivity(activity);
            return this;
        }

        public ContextAwarenessParamBuilder setCaller(int i) {
            this.mContextAwarenessParam.setCaller(i);
            return this;
        }

        public ContextAwarenessParamBuilder setIntent(Intent intent) {
            this.mContextAwarenessParam.setIntent(intent);
            return this;
        }

        public ContextAwarenessParamBuilder setSuggestionInfo(SuggestionInfo suggestionInfo) {
            this.mContextAwarenessParam.setSuggestionInfo(suggestionInfo);
            return this;
        }

        public ContextAwarenessParamBuilder setType(IContextAwarenessParam.Type type) {
            this.mContextAwarenessParam.setType(type);
            return this;
        }
    }

    public /* synthetic */ ContextAwarenessParam(int i) {
        this();
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public int getCaller() {
        return this.mCaller;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getSubscribeId() {
        return SUBSCRIBE_ID;
    }

    public SuggestionInfo getSuggestionInfo() {
        return this.mSuggestionInfo;
    }

    public IContextAwarenessParam.Type getType() {
        return this.mType;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setCaller(int i) {
        this.mCaller = i;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setSuggestionInfo(SuggestionInfo suggestionInfo) {
        this.mSuggestionInfo = suggestionInfo;
    }

    public void setType(IContextAwarenessParam.Type type) {
        this.mType = type;
    }

    @NonNull
    public String toString() {
        int i = C114361.f7698x6cb89fd2[this.mType.ordinal()];
        return "ContextAwarenessParam{subScribeId='11312251', caller='" + this.mCaller + "', type='" + (i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? CoverStickerConstants.Category.NONE.NAME : "UNSUBSCRIBE_SUGGESTION" : "ATTACH_CONTENT" : "EXECUTE_ACTION" : "DRAW_SUGGESTION" : "SUBSCRIBE_SUGGESTION") + "'}";
    }

    private ContextAwarenessParam() {
    }
}
