package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class UserUpdater extends AbstractUpdater {
    private final Logger logger = Logger.get("UserUpdater");
    private final UserUpdateApiImpl updateApi;

    public UserUpdater(UserUpdateApiImpl userUpdateApiImpl) {
        this.updateApi = userUpdateApiImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNewPushInfoList$1(PushInfo pushInfo, PushInfo pushInfo2) {
        return pushInfo2.getType().equals(pushInfo.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNewPushInfoList$2(PushInfo pushInfo, PushInfo pushInfo2) {
        return pushInfo2.getType().equals(pushInfo.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(PushInfoList pushInfoList, DeviceInfo deviceInfo) {
        this.updateApi.update(pushInfoList, deviceInfo);
    }

    public PushInfoList getNewPushInfoList() {
        PushInfoSupplier pushInfoSupplier = SContext.getInstance().getPushInfoSupplier();
        AccountInfoSupplier accountInfoSupplier = SContext.getInstance().getAccountInfoSupplier();
        if (pushInfoSupplier == null || !pushInfoSupplier.has() || accountInfoSupplier == null || !accountInfoSupplier.has()) {
            this.logger.m12934i("no push info or account info. skip to update push info.");
            return null;
        }
        String str = ScspCorePreferences.get().pushInfos.get();
        PushInfoList pushInfoList = new PushInfoList(pushInfoSupplier.getPushInfo());
        if (StringUtil.isEmpty(str)) {
            return pushInfoList;
        }
        List<PushInfo> pushInfoList2 = pushInfoList.getPushInfoList();
        List<PushInfo> pushInfoList3 = new PushInfoList(str).getPushInfoList();
        ArrayList arrayList = new ArrayList(pushInfoList3);
        for (final PushInfo pushInfo : pushInfoList2) {
            final int i = 0;
            Optional<PushInfo> optionalFindAny = pushInfoList3.stream().filter(new Predicate() { // from class: com.samsung.scsp.framework.core.identity.l
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    switch (i) {
                        case 0:
                            return UserUpdater.lambda$getNewPushInfoList$1(pushInfo, (PushInfo) obj);
                        default:
                            return UserUpdater.lambda$getNewPushInfoList$2(pushInfo, (PushInfo) obj);
                    }
                }
            }).findAny();
            if (optionalFindAny.isPresent()) {
                final PushInfo pushInfo2 = optionalFindAny.get();
                if (!pushInfo2.equalsValue(pushInfo)) {
                    final int i2 = 1;
                    arrayList.removeIf(new Predicate() { // from class: com.samsung.scsp.framework.core.identity.l
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            switch (i2) {
                                case 0:
                                    return UserUpdater.lambda$getNewPushInfoList$1(pushInfo2, (PushInfo) obj);
                                default:
                                    return UserUpdater.lambda$getNewPushInfoList$2(pushInfo2, (PushInfo) obj);
                            }
                        }
                    });
                    arrayList.add(pushInfo);
                }
            } else {
                arrayList.add(pushInfo);
            }
        }
        if (arrayList.equals(pushInfoList3)) {
            return null;
        }
        return new PushInfoList(arrayList);
    }

    @Override // com.samsung.scsp.framework.core.identity.AbstractUpdater
    public void update() {
        PushInfoList newPushInfoList = getNewPushInfoList();
        DeviceInfo newDeviceInfo = getNewDeviceInfo();
        if (newPushInfoList == null && newDeviceInfo.isAllFieldsNull()) {
            return;
        }
        FaultBarrier.run(new C11659d(this, 2, newPushInfoList, newDeviceInfo));
    }
}
