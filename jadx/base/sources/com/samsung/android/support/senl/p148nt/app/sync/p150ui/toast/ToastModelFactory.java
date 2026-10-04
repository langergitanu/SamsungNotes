package com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast;

import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ToastModelFactory {
    private static final String TAG = "ToastModelFactory";

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.sync.ui.toast.ToastModelFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C88531 {
        static final /* synthetic */ int[] $SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType;

        static {
            int[] iArr = new int[ModelType.values().length];
            $SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType = iArr;
            try {
                iArr[ModelType.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType[ModelType.SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static IModelToast create(ModelType modelType) {
        int i = C88531.$SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType[modelType.ordinal()];
        if (i == 1) {
            return new ShareToast();
        }
        if (i == 2) {
            return new SyncToast();
        }
        Debugger.m8609e(TAG, "invalid model type!");
        return null;
    }
}
