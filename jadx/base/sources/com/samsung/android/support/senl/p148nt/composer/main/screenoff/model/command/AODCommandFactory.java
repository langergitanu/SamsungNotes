package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command;

import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.AODNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.IAODCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.PreResult;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultApply;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultBack;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultHome;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultLcdOff;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultPause;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultReject;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/AODCommandFactory;", "", "<init>", "()V", "makeAODCommand", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/aod/IAODCommand;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AODCommandFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static volatile AODCommandFactory mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/AODCommandFactory$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/AODCommandFactory;", "getInstance", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAODCommandFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AODCommandFactory.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/AODCommandFactory$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n1#2:79\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AODCommandFactory getInstance() {
            AODCommandFactory aODCommandFactory;
            AODCommandFactory aODCommandFactory2 = AODCommandFactory.mInstance;
            if (aODCommandFactory2 != null) {
                return aODCommandFactory2;
            }
            synchronized (this) {
                aODCommandFactory = AODCommandFactory.mInstance;
                if (aODCommandFactory == null) {
                    aODCommandFactory = new AODCommandFactory(null);
                    AODCommandFactory.mInstance = aODCommandFactory;
                }
            }
            return aODCommandFactory;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AODCommandFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final IAODCommand makeAODCommand(@Nullable Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_PRE_RESULT) : null;
        if (stringExtra != null) {
            PreResult preResult = new PreResult();
            preResult.setUri(stringExtra);
            return preResult;
        }
        String stringExtra2 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_APPLY) : null;
        if (stringExtra2 != null) {
            ResultApply resultApply = new ResultApply();
            resultApply.setUri(stringExtra2);
            return resultApply;
        }
        String stringExtra3 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_HOME) : null;
        if (stringExtra3 != null) {
            ResultHome resultHome = new ResultHome();
            resultHome.setUri(stringExtra3);
            return resultHome;
        }
        String stringExtra4 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_BACK) : null;
        if (stringExtra4 != null) {
            ResultBack resultBack = new ResultBack();
            resultBack.setUri(stringExtra4);
            return resultBack;
        }
        String stringExtra5 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_PAUSE) : null;
        if (stringExtra5 != null) {
            ResultPause resultPause = new ResultPause();
            resultPause.setUri(stringExtra5);
            return resultPause;
        }
        String stringExtra6 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_LCD_OFF) : null;
        if (stringExtra6 != null) {
            ResultLcdOff resultLcdOff = new ResultLcdOff();
            resultLcdOff.setUri(stringExtra6);
            return resultLcdOff;
        }
        String stringExtra7 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_RESULT_REJECT) : null;
        if (stringExtra7 == null) {
            return new AODNone();
        }
        ResultReject resultReject = new ResultReject();
        resultReject.setUri(stringExtra7);
        return resultReject;
    }

    private AODCommandFactory() {
    }
}
