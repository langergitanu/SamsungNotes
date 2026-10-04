package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionAi extends BixbyAction {
    private final String TAG;
    AiBixbyParam bixbyParam;
    int mAction;
    int mAddAction;
    int mIndex;
    int mRange;
    String mTargetLanguage;

    public BixbyActionAi(int i, int i2, int i4, int i5) {
        this.TAG = Logger.createTag("BixbyActionAi");
        this.mIndex = 0;
        this.mRange = 0;
        this.mAction = i;
        this.mAddAction = i2;
        this.mTargetLanguage = "";
        if (i4 > 0) {
            this.mIndex = i4 - 1;
        } else {
            this.mIndex = i4;
        }
        this.mRange = i5;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(final BixbyContract bixbyContract) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("execute#");
        sb.append(this.mAction);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.mAddAction);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.mTargetLanguage);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.mIndex);
        sb.append(SQLKeyword.COMMA);
        AbstractC8014b.m7195A(sb, str, this.mRange);
        int i = this.mAction;
        if (i == 6) {
            bixbyContract.getMenuManager().getAiMenuManager().makeCoverDirectly();
            return;
        }
        if (i == 1) {
            AiBixbyParam aiBixbyParam = new AiBixbyParam(this.mAction, this.mAddAction, this.mTargetLanguage);
            this.bixbyParam = aiBixbyParam;
            aiBixbyParam.setMaxSelectionFlag(this.mRange == 0);
            if (this.mTargetLanguage != null) {
                AiLanguageHelper.initTranslateConfig(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.bixby.BixbyActionAi.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Locale locale = AiLanguageHelper.getLocale(BixbyActionAi.this.mTargetLanguage);
                        if (AiLanguageHelper.isDownloadedLanguage(locale) || AiLanguageHelper.isDownloadableLanguage(locale)) {
                            bixbyContract.getMenuManager().getAiMenuManager().showByBixby(BixbyActionAi.this.bixbyParam);
                        } else {
                            ToastHandler.show(bixbyContract.getActivity(), C9086R.string.ai_not_supported_from_language, 1);
                        }
                    }
                });
                return;
            } else {
                bixbyContract.getMenuManager().getAiMenuManager().showByBixby(this.bixbyParam);
                return;
            }
        }
        if (i == 7) {
            bixbyContract.getMenuManager().getAiMenuManager().showByBixby(new AiBixbyParam(this.mAction, this.mAddAction, this.mIndex));
            return;
        }
        AiBixbyParam aiBixbyParam2 = new AiBixbyParam(this.mAction, this.mAddAction);
        this.bixbyParam = aiBixbyParam2;
        aiBixbyParam2.setMaxSelectionFlag(this.mRange == 0);
        bixbyContract.getMenuManager().getAiMenuManager().showByBixby(this.bixbyParam);
    }

    public BixbyActionAi(int i, int i2, String str, int i4) {
        this.TAG = Logger.createTag("BixbyActionAi");
        this.mAction = i;
        this.mAddAction = i2;
        this.mTargetLanguage = str;
        this.mIndex = 0;
        this.mRange = i4;
    }
}
