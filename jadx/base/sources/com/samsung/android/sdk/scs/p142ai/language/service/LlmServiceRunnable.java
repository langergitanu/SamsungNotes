package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskCompletionSource;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.tasks.TaskStreamingCompletionSource;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.ResultErrorException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LlmServiceRunnable<T> extends TaskRunnable<T> {
    private static final String TAG = "LlmServiceRunnable";
    private final String featureName;
    private final LlmServiceObserver2 observer;
    private final Function<List<Bundle>, T> resultMapper;
    private final Consumer<LlmServiceObserver2> serviceRequest;

    public LlmServiceRunnable(@NonNull String str, boolean z, Consumer<LlmServiceObserver2> consumer, Function<List<Bundle>, T> function) {
        super(z ? new TaskStreamingCompletionSource() : new TaskCompletionSource());
        this.observer = new LlmServiceObserver2() { // from class: com.samsung.android.sdk.scs.ai.language.service.LlmServiceRunnable.1
            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
            public void onError(Bundle bundle) {
                if (bundle == null) {
                    Log.m6487e(LlmServiceRunnable.TAG, "onError= error is null");
                    AbstractC6670b.m4749j(5, "error is null", ((TaskRunnable) LlmServiceRunnable.this).mSource);
                    return;
                }
                Log.m6487e(LlmServiceRunnable.TAG, "onError= " + bundle.getInt("error_code") + bundle.getString("error_message"));
                ((TaskRunnable) LlmServiceRunnable.this).mSource.setException(new ResultErrorException(500, bundle.getInt("error_code"), bundle.getString("error_message")));
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
            public void onNext(List<Bundle> list) {
                ((TaskRunnable) LlmServiceRunnable.this).mSource.setResult(LlmServiceRunnable.this.resultMapper.apply(list));
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2
            public void onComplete() {
            }
        };
        this.featureName = str;
        this.serviceRequest = consumer;
        this.resultMapper = function;
    }

    public static List<Result> listResultMapper(@NonNull List<Bundle> list) {
        return (List) list.stream().map(new C4662f(17)).collect(Collectors.toList());
    }

    public static Result singleResultMapper(@NonNull List<Bundle> list) {
        return list.isEmpty() ? new Result(new Bundle()) : new Result(list.get(0));
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        this.serviceRequest.accept(this.observer);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return this.featureName;
    }
}
