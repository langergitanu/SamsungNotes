package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import com.samsung.android.app.notes.sync.infos.ModelType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotificationModelFactory {

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.sync.ui.notification.NotificationModelFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C88451 {
        static final /* synthetic */ int[] $SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType;

        static {
            int[] iArr = new int[ModelType.values().length];
            $SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType = iArr;
            try {
                iArr[ModelType.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static IModelNotification create(ModelType modelType) {
        if (C88451.$SwitchMap$com$samsung$android$app$notes$sync$infos$ModelType[modelType.ordinal()] != 1) {
            return null;
        }
        return new ShareNotification();
    }
}
