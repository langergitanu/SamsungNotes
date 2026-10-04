package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command;

import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.ControlService;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.DeleteNoteByRemovePinOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenAttach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenDetach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PreInitialize;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.StartNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/StartCommandFactory;", "", "<init>", "()V", "mStartCommand", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/IStartCommand;", "mPrimitiveStartCommand", "makeStartCommand", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "startCommand", "getStartCommand", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/IStartCommand;", "primitiveStartCommand", "getPrimitiveStartCommand", "setPrimitiveStartCommand", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/IStartCommand;)V", "uri", "", "primitiveStartCommandUri", "getPrimitiveStartCommandUri", "()Ljava/lang/String;", "setPrimitiveStartCommandUri", "(Ljava/lang/String;)V", "release", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStartCommandFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartCommandFactory.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/StartCommandFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class StartCommandFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("StartCommandFactory");

    @Nullable
    private static volatile StartCommandFactory mInstance;

    @Nullable
    private IStartCommand mPrimitiveStartCommand;

    @Nullable
    private IStartCommand mStartCommand;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/StartCommandFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/StartCommandFactory;", "getInstance", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nStartCommandFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartCommandFactory.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/StartCommandFactory$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final StartCommandFactory getInstance() {
            StartCommandFactory startCommandFactory;
            StartCommandFactory startCommandFactory2 = StartCommandFactory.mInstance;
            if (startCommandFactory2 != null) {
                return startCommandFactory2;
            }
            synchronized (this) {
                startCommandFactory = StartCommandFactory.mInstance;
                if (startCommandFactory == null) {
                    startCommandFactory = new StartCommandFactory(null);
                    StartCommandFactory.mInstance = startCommandFactory;
                }
            }
            return startCommandFactory;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StartCommandFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final StartCommandFactory getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPrimitiveStartCommandUri(String str) {
        AbstractC8014b.m7208j("setPrimitiveStartCommandUri# uri ", Logger.getEncode(str), SOLogger.INSTANCE, TAG);
        IStartCommand iStartCommand = this.mPrimitiveStartCommand;
        if (iStartCommand != null) {
            iStartCommand.setUri(str);
        }
    }

    @NotNull
    public final IStartCommand getPrimitiveStartCommand() {
        IStartCommand iStartCommand = this.mPrimitiveStartCommand;
        return iStartCommand == null ? new StartNone() : iStartCommand;
    }

    @NotNull
    public final String getPrimitiveStartCommandUri() {
        String mUri;
        IStartCommand iStartCommand = this.mPrimitiveStartCommand;
        if (iStartCommand == null || (mUri = iStartCommand.getMUri()) == null) {
            mUri = "";
        }
        AbstractC8014b.m7208j("getPrimitiveStartCommandUri# uri ", Logger.getEncode(mUri), SOLogger.INSTANCE, TAG);
        return mUri;
    }

    @Nullable
    /* JADX INFO: renamed from: getStartCommand, reason: from getter */
    public final IStartCommand getMStartCommand() {
        return this.mStartCommand;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IStartCommand makeStartCommand(@Nullable Intent intent) {
        IStartCommand penButtonHoverTap;
        this.mStartCommand = null;
        Boolean boolValueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra(Constants.BooleanExtraKey.CONTROL_SERVICE, false)) : null;
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolValueOf, bool)) {
            this.mStartCommand = new ControlService();
        }
        if (Intrinsics.areEqual(intent != null ? Boolean.valueOf(intent.getBooleanExtra(Constants.BooleanExtraKey.PRE_INITIALIZED_COM, false)) : null, bool)) {
            this.mStartCommand = new PreInitialize();
        }
        String stringExtra = intent != null ? intent.getStringExtra(Constants.StringExtraKey.PEN_INTENT_COM) : null;
        if (stringExtra != null) {
            int iHashCode = stringExtra.hashCode();
            if (iHashCode == -740145538) {
                if (stringExtra.equals(Constants.StringExtra.PEN_BUTTON_HOVER_TAP)) {
                    penButtonHoverTap = new PenButtonHoverTap();
                }
                this.mStartCommand = penButtonHoverTap;
            } else if (iHashCode != 1332837419) {
                penButtonHoverTap = (iHashCode == 1404872057 && stringExtra.equals(Constants.StringExtra.PEN_DETACH)) ? new PenDetach() : new StartNone();
                this.mStartCommand = penButtonHoverTap;
            } else {
                if (stringExtra.equals(Constants.StringExtra.PEN_ATTACH)) {
                    penButtonHoverTap = new PenAttach();
                }
                this.mStartCommand = penButtonHoverTap;
            }
        }
        String stringExtra2 = intent != null ? intent.getStringExtra("pin_com_load") : null;
        if (stringExtra2 != null) {
            LoadNoteByDoubleTapOnAOD loadNoteByDoubleTapOnAOD = new LoadNoteByDoubleTapOnAOD();
            this.mStartCommand = loadNoteByDoubleTapOnAOD;
            loadNoteByDoubleTapOnAOD.setUri(stringExtra2);
            IStartCommand iStartCommand = this.mStartCommand;
            Intrinsics.checkNotNull(iStartCommand, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD");
            ((LoadNoteByDoubleTapOnAOD) iStartCommand).setCommandFactory(new LoadNoteByDoubleTapOnAOD.ICommandFactory() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.model.command.StartCommandFactory.makeStartCommand.1
                @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD.ICommandFactory
                public void setPrimitiveStartCommandUri(String uri) {
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    StartCommandFactory.this.setPrimitiveStartCommandUri(uri);
                }
            });
        }
        String stringExtra3 = intent != null ? intent.getStringExtra(Constants.StringExtraKey.AOD_INTENT_PIN_COM_DELETE) : null;
        if (stringExtra3 != null) {
            DeleteNoteByRemovePinOnAOD deleteNoteByRemovePinOnAOD = new DeleteNoteByRemovePinOnAOD();
            this.mStartCommand = deleteNoteByRemovePinOnAOD;
            deleteNoteByRemovePinOnAOD.setUri(stringExtra3);
        }
        IStartCommand startNone = this.mStartCommand;
        if (startNone == null) {
            startNone = new StartNone();
            this.mStartCommand = startNone;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "makeStartCommand# startCommand ".concat(startNone.getClass().getSimpleName()));
        if (this.mPrimitiveStartCommand == null && !(startNone instanceof PreInitialize) && !(startNone instanceof PenAttach) && !(startNone instanceof ControlService)) {
            this.mPrimitiveStartCommand = startNone;
            sOLogger.SOLoggerD(str, "makeStartCommand# primitiveStartCommand ".concat(startNone.getClass().getSimpleName()));
        }
        return startNone;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        this.mStartCommand = null;
        this.mPrimitiveStartCommand = null;
    }

    public final void setPrimitiveStartCommand(@NotNull IStartCommand startCommand) {
        Intrinsics.checkNotNullParameter(startCommand, "startCommand");
        this.mPrimitiveStartCommand = startCommand;
    }

    private StartCommandFactory() {
    }
}
