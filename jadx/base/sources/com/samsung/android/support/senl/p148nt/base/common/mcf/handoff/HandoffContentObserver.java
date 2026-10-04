package com.samsung.android.support.senl.p148nt.base.common.mcf.handoff;

import android.database.ContentObserver;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffContentObserver;", "Landroid/database/ContentObserver;", "<init>", "()V", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "onAppEventChanged", "onDataSent", "onDataReceived", "onOtherChanged", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class HandoffContentObserver extends ContentObserver {
    public HandoffContentObserver() {
        super(null);
    }

    public void onAppEventChanged() {
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, @Nullable Uri uri) {
        super.onChange(selfChange, uri);
        if (Intrinsics.areEqual(HandoffConstant.URI_HANDOFF_APP_EVENT_CHANGED, String.valueOf(uri))) {
            onAppEventChanged();
            return;
        }
        if (Intrinsics.areEqual(HandoffConstant.URI_HANDOFF_DATA_SENDING_SUCCESS, String.valueOf(uri))) {
            onDataSent();
        } else if (Intrinsics.areEqual(HandoffConstant.URI_HANDOFF_DATA_RECEIVING_SUCCESS, String.valueOf(uri))) {
            onDataReceived();
        } else {
            onOtherChanged(selfChange, uri);
        }
    }

    public void onDataReceived() {
    }

    public void onDataSent() {
    }

    public void onOtherChanged(boolean selfChange, @Nullable Uri uri) {
    }
}
