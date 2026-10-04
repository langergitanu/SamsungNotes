package com.samsung.android.support.senl.addons.base.model;

import com.samsung.android.support.senl.addons.base.model.bleremote.IBLEListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/IEventListener;", "Lcom/samsung/android/support/senl/addons/base/model/IKeyListener;", "Lcom/samsung/android/support/senl/addons/base/model/bleremote/IBLEListener;", "onFinishDocumentByUser", "", "save", "", "onDispatchEvent", "eventId", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IEventListener extends IKeyListener, IBLEListener {
    void onDispatchEvent(int eventId);

    void onFinishDocumentByUser(boolean save);
}
