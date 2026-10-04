package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverSrcExtractor;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\tJ \u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J4\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/util/CoverStyleUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getCoverType", "templateUuid", "getStickerSpanCount", "", "context", "Landroid/content/Context;", "measuredWidth", "getTemplateSpanCount", "isTextType", "", "getRandomTemplate", "getRandomColor", "extractTextWithReceiver", "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "filePath", "noteUuid", "needToClose", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStyleUtils {

    @NotNull
    public static final CoverStyleUtils INSTANCE = new CoverStyleUtils();

    @NotNull
    public static final String TAG = "CoverStyleUtils";

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils$extractTextWithReceiver$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils$extractTextWithReceiver$1", m14021f = "CoverStyleUtils.kt", m14022i = {}, m14023l = {131, 139}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C103571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ SpenWNote $document;
        final /* synthetic */ String $filePath;
        final /* synthetic */ boolean $needToClose;
        final /* synthetic */ String $noteUuid;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils$extractTextWithReceiver$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils$extractTextWithReceiver$1$1", m14021f = "CoverStyleUtils.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ SpenWNote $document;
            final /* synthetic */ String $filePath;
            final /* synthetic */ boolean $needToClose;
            final /* synthetic */ String $noteUuid;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, SpenWNote spenWNote, String str, String str2, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$document = spenWNote;
                this.$filePath = str;
                this.$noteUuid = str2;
                this.$needToClose = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$context, this.$document, this.$filePath, this.$noteUuid, this.$needToClose, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Logger.m10999d(CoverStyleUtils.TAG, "extractTextWithReceiver# run");
                String strExtractText = new AiCoverSrcExtractor().extractText(this.$context, this.$document, this.$filePath);
                Intrinsics.checkNotNullExpressionValue(strExtractText, "extractText(...)");
                if (!TextUtils.isEmpty(strExtractText)) {
                    Intent intent = new Intent(NoteStyleActivity.ACTION_EXTRACT_TEXT);
                    intent.putExtra(NoteStyleActivity.KEY_EXTRACT_UUID, this.$noteUuid);
                    intent.putExtra(CoverData.KEY_EXTRACT_TEXT, strExtractText);
                    LocalBroadcastManager.getInstance(this.$context).sendBroadcast(intent);
                }
                if (this.$needToClose) {
                    try {
                        DocumentFileManager.getInstance().close(this.$filePath, this.$document, true);
                    } catch (IOException e) {
                        AbstractC8014b.m7198D("extractTextWithReceiver# fail to close doc, e: ", e.getMessage(), CoverStyleUtils.TAG);
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103571(SpenWNote spenWNote, Context context, String str, String str2, boolean z, Continuation<? super C103571> continuation) {
            super(2, continuation);
            this.$document = spenWNote;
            this.$context = context;
            this.$filePath = str;
            this.$noteUuid = str2;
            this.$needToClose = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C103571(this.$document, this.$context, this.$filePath, this.$noteUuid, this.$needToClose, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r12, r4, r11) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                AbstractC8014b.m7198D("extractTextWithReceiver# unexpected exception: ", e.getMessage(), CoverStyleUtils.TAG);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(500L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (this.$document.isClosed()) {
                Logger.m11004w(CoverStyleUtils.TAG, "extractTextWithReceiver# skipped, document is closed after delay");
                return Unit.INSTANCE;
            }
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$document, this.$filePath, this.$noteUuid, this.$needToClose, null);
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C103571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private CoverStyleUtils() {
    }

    public final void extractTextWithReceiver(@Nullable Context context, @Nullable SpenWNote document, @NotNull String filePath, @Nullable String noteUuid, boolean needToClose) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (context == null || document == null || document.isClosed() || TextUtils.isEmpty(filePath) || TextUtils.isEmpty(noteUuid)) {
            Logger.m11004w(TAG, "extractTextWithReceiver# skipped, initial check failed");
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C103571(document, context, filePath, noteUuid, needToClose, null), 3, null);
        }
    }

    @NotNull
    public final String getCoverType(@NotNull String templateUuid) {
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        int iM14129C = StringsKt.m14129C(CoverConstants.VERSION_SEPARATOR, 0, 6, templateUuid);
        if (iM14129C > 0) {
            templateUuid = templateUuid.substring(iM14129C + 5);
            Intrinsics.checkNotNullExpressionValue(templateUuid, "substring(...)");
        }
        if (!StringsKt.m14162r(templateUuid, "_")) {
            return templateUuid;
        }
        String strSubstring = templateUuid.substring(0, StringsKt.m14131E("_", 0, 6, templateUuid));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @NotNull
    public final String getRandomColor() {
        String[] strArr = {CoverConstants.Color.SET_1, CoverConstants.Color.SET_2, CoverConstants.Color.SET_3, CoverConstants.Color.SET_4, CoverConstants.Color.SET_5, CoverConstants.Color.SET_6, CoverConstants.Color.SKY_BLUE, CoverConstants.Color.LAVENDER, CoverConstants.Color.CORAL, CoverConstants.Color.ORANGE, CoverConstants.Color.YELLOW, CoverConstants.Color.BEIGE, CoverConstants.Color.GREEN, CoverConstants.Color.VIVID_BLUE, CoverConstants.Color.VIVID_PURPLE, CoverConstants.Color.VIVID_CORAL, CoverConstants.Color.VIVID_ORANGE, CoverConstants.Color.VIVID_YELLOW, CoverConstants.Color.VIVID_GREEN, CoverConstants.Color.NAVY};
        int iNextInt = JavaInstanceConstructor.getSecureRandom().nextInt(20);
        AbstractC0000a.m3D(iNextInt, "getRandomColor# index : ", TAG);
        return strArr[iNextInt];
    }

    @NotNull
    public final String getRandomTemplate() {
        int iNextInt = JavaInstanceConstructor.getSecureRandom().nextInt(8);
        AbstractC0000a.m3D(iNextInt, "getRandomTemplate# index : ", TAG);
        return new String[]{"BASIC_STYLE_1:///", "BASIC_STYLE_2:///", "cover_v2:////BASIC_STYLE_6:///", "BASIC_STYLE_3:///", "BASIC_STYLE_4:///", "cover_v2:////BASIC_STYLE_7:///", "BASIC_STYLE_5:///", "cover_v2:////BASIC_STYLE_8:///"}[iNextInt];
    }

    public final int getStickerSpanCount(@Nullable Context context, int measuredWidth) {
        if (measuredWidth <= 0) {
            return 6;
        }
        float f = measuredWidth;
        if (f <= ResourceUtils.convertDpToPixel(context, 84.0f)) {
            return 1;
        }
        if (f <= ResourceUtils.convertDpToPixel(context, 132.0f)) {
            return 2;
        }
        if (f <= ResourceUtils.convertDpToPixel(context, 180.0f)) {
            return 3;
        }
        if (f <= ResourceUtils.convertDpToPixel(context, 228.0f)) {
            return 4;
        }
        return f <= ResourceUtils.convertDpToPixel(context, 276.0f) ? 5 : 6;
    }

    public final int getTemplateSpanCount(@Nullable Context context, int measuredWidth, boolean isTextType) {
        if (measuredWidth <= 0) {
            return isTextType ? 4 : 3;
        }
        float f = measuredWidth;
        if (f <= ResourceUtils.convertDpToPixel(context, 118.0f)) {
            return 1;
        }
        return f <= ResourceUtils.convertDpToPixel(context, 180.0f) ? isTextType ? 2 : 1 : f <= ResourceUtils.convertDpToPixel(context, 242.0f) ? isTextType ? 3 : 2 : isTextType ? 4 : 3;
    }
}
