package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.guide;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/guide/GuideModel;", "", "<init>", "()V", "value", "", "layoutVisibility", "getLayoutVisibility", "()I", "saveData", "", "", "initLayoutVisibility", "saveFirstExecuted", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GuideModel {

    @NotNull
    private static final String TAG = SOLogger.createTag("GuideModel");
    private int layoutVisibility = 8;

    public GuideModel() {
        initLayoutVisibility();
    }

    private final void initLayoutVisibility() {
        int i = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).getBoolean(Constants.Preference.PREF_KEY_FIRST_EXECUTED, true) ? 0 : 8;
        this.layoutVisibility = i;
        AbstractC8014b.m7206h("initLayoutVisibility# ", i, SOLogger.INSTANCE, TAG);
    }

    private final void saveFirstExecuted(boolean value) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).putBoolean(Constants.Preference.PREF_KEY_FIRST_EXECUTED, value);
    }

    public final int getLayoutVisibility() {
        return this.layoutVisibility;
    }

    public final void saveData(boolean value) {
        AbstractC8014b.m7211m("saveData# ", value, SOLogger.INSTANCE, TAG);
        saveFirstExecuted(value);
    }
}
