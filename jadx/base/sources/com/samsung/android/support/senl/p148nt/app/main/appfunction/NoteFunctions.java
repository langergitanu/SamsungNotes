package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Display;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.AppFunctionException;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateNote;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.DeleteNotes;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotes;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.GetNotes;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.google.android.appfunctions.schema.common.p129v1.notes.ShowNote;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNote;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.google.android.appfunctions.schema.common.p129v1.types.Date;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.SetAttachmentListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDay;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.DocumentTextData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.document.SDocXBodyTextGetter;
import com.samsung.android.support.senl.p148nt.model.domain.common.DomainUtils;
import com.samsung.android.support.senl.p148nt.model.domain.note.MoveNoteToTrashUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.note.UpdateNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentServiceIntent;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u00014B\u0007¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J*\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\nH\u0096@¢\u0006\u0002\u0010&J*\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\nH\u0096@¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\"H\u0002J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/appfunction/NoteFunctions;", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotes;", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNote;", "Lcom/google/android/appfunctions/schema/common/v1/notes/DeleteNotes;", "Lcom/google/android/appfunctions/schema/common/v1/notes/ShowNote;", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNote;", "Lcom/google/android/appfunctions/schema/common/v1/notes/GetNotes;", "<init>", "()V", "findNotes", "", "Lcom/google/android/appfunctions/schema/common/v1/notes/Note;", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "findNotesParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotesParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStartTime", "", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "endDate", "createNote", "createNoteParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNote", "Landroid/app/PendingIntent;", "noteId", "", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "updateNoteParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNotes", "noteIds", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotes", "printNote", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "printFindNotesParams", ActionHandler.PARAMS, "printCreateNoteParams", "printUpdateNoteParams", "printDateTime", "dateTime", "checkInvalidStatus", "", "context", "Landroid/content/Context;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNoteFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/NoteFunctions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n+ 4 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,369:1\n1869#2,2:370\n1869#2,2:373\n1869#2,2:375\n29#3:372\n31#4:377\n*S KotlinDebug\n*F\n+ 1 NoteFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/NoteFunctions\n*L\n158#1:370,2\n235#1:373,2\n303#1:375,2\n198#1:372\n356#1:377\n*E\n"})
public final class NoteFunctions implements FindNotes, CreateNote, DeleteNotes, ShowNote, UpdateNote, GetNotes {

    @NotNull
    private static final String NAME_SPACE = "SamsungNotes";

    @NotNull
    private static final String TAG = "NoteFunctions";
    private static final long UPDATE_NOTE_TIME_OUT = 3000;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions$findNotes$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions", m14021f = "NoteFunctions.kt", m14022i = {}, m14023l = {78}, m14024m = "findNotes", m14025n = {}, m14026s = {})
    public static final class C81551 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C81551(Continuation<? super C81551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NoteFunctions.this.findNotes(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions$updateNote$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions", m14021f = "NoteFunctions.kt", m14022i = {0, 0, 0}, m14023l = {250}, m14024m = "updateNote", m14025n = {"appFunctionContext", "updateNoteParams", "factory"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C81561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C81561(Continuation<? super C81561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NoteFunctions.this.updateNote(null, null, this);
        }
    }

    private final void checkInvalidStatus(Context context) throws AppFunctionException {
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500) {
            KeyguardManager keyguardManager = context != null ? (KeyguardManager) ContextCompat.getSystemService(context, KeyguardManager.class) : null;
            if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
                return;
            }
            MainLogger.m7254d(TAG, "ERROR_APP_UNKNOWN_ERROR by KeyguardLocked");
            throw new AppFunctionException(3000, "This function is unavailable while the device is locked.", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getEndTime(DateTime endDate) {
        if (endDate == null) {
            return 0L;
        }
        Date date = endDate.getDate();
        TimeOfDay timeOfDay = endDate.getTimeOfDay();
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of(endDate.getTimeZone()));
        Calendar calendar = Calendar.getInstance(timeZone);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        calendar.set(date.getYear(), date.getMonth() - 1, date.getDay(), timeOfDay.getHours(), timeOfDay.getMinutes(), timeOfDay.getSeconds());
        StringBuilder sbM2225p = AbstractC2821a.m2225p(calendar.getTimeInMillis(), "getEndTime - timeInMillis: ", " (applied timeZone: ", timeZone.getDisplayName());
        sbM2225p.append(")");
        MainLogger.m7254d(TAG, sbM2225p.toString());
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getStartTime(DateTime startDate) {
        if (startDate == null) {
            return 0L;
        }
        Date date = startDate.getDate();
        TimeOfDay timeOfDay = startDate.getTimeOfDay();
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of(startDate.getTimeZone()));
        Calendar calendar = Calendar.getInstance(timeZone);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        calendar.set(date.getYear(), date.getMonth() - 1, date.getDay(), timeOfDay.getHours(), timeOfDay.getMinutes(), timeOfDay.getSeconds());
        StringBuilder sbM2225p = AbstractC2821a.m2225p(calendar.getTimeInMillis(), "getStartTime - timeInMillis: ", " (applied timeZone: ", timeZone.getDisplayName());
        sbM2225p.append(")");
        MainLogger.m7254d(TAG, sbM2225p.toString());
        return calendar.getTimeInMillis();
    }

    private final String printCreateNoteParams(CreateNoteParams params) {
        String id = params.getId();
        String encode = MainLogger.getEncode(params.getTitle());
        String externalId = params.getExternalId();
        String encode2 = MainLogger.getEncode(params.getContent());
        String folderId = params.getFolderId();
        int size = params.getAttachments().size();
        StringBuilder sbM16m = AbstractC0000a.m16m("[id: ", id, ", title: ", encode, ", externalId: ");
        AbstractC2821a.m2207B(sbM16m, externalId, ", content: ", encode2, ", folderId: ");
        sbM16m.append(folderId);
        sbM16m.append(", attachments: ");
        sbM16m.append(size);
        sbM16m.append("]");
        return sbM16m.toString();
    }

    private final String printDateTime(DateTime dateTime) {
        TimeOfDay timeOfDay;
        TimeOfDay timeOfDay2;
        TimeOfDay timeOfDay3;
        Date date;
        Date date2;
        Date date3;
        Integer numValueOf = (dateTime == null || (date3 = dateTime.getDate()) == null) ? null : Integer.valueOf(date3.getYear());
        Integer numValueOf2 = (dateTime == null || (date2 = dateTime.getDate()) == null) ? null : Integer.valueOf(date2.getMonth());
        Integer numValueOf3 = (dateTime == null || (date = dateTime.getDate()) == null) ? null : Integer.valueOf(date.getDay());
        Integer numValueOf4 = (dateTime == null || (timeOfDay3 = dateTime.getTimeOfDay()) == null) ? null : Integer.valueOf(timeOfDay3.getHours());
        Integer numValueOf5 = (dateTime == null || (timeOfDay2 = dateTime.getTimeOfDay()) == null) ? null : Integer.valueOf(timeOfDay2.getMinutes());
        Integer numValueOf6 = (dateTime == null || (timeOfDay = dateTime.getTimeOfDay()) == null) ? null : Integer.valueOf(timeOfDay.getSeconds());
        String timeZone = dateTime != null ? dateTime.getTimeZone() : null;
        StringBuilder sb = new StringBuilder("date( y:");
        sb.append(numValueOf);
        sb.append(" m:");
        sb.append(numValueOf2);
        sb.append(" d:");
        sb.append(numValueOf3);
        sb.append(" ) timeOfDay( h:");
        sb.append(numValueOf4);
        sb.append(" m:");
        sb.append(numValueOf5);
        sb.append(" s:");
        sb.append(numValueOf6);
        sb.append(" ) timeZone( ");
        return AbstractC0622a.m1170p(timeZone, " )", sb);
    }

    private final String printFindNotesParams(FindNotesParams params) {
        String id = params.getId();
        String encode = MainLogger.getEncode(params.getQuery());
        int maxCount = params.getMaxCount();
        String strPrintDateTime = printDateTime(params.getStartDate());
        String strPrintDateTime2 = printDateTime(params.getEndDate());
        StringBuilder sbM16m = AbstractC0000a.m16m("[id: ", id, ", query: ", encode, ", maxCount: ");
        AbstractC1974b.m1331x(sbM16m, maxCount, ", startDate: ", strPrintDateTime, ", endDate: ");
        return AbstractC0622a.m1170p(strPrintDateTime2, "]", sbM16m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String printNote(Note note) {
        String id = note.getId();
        String encode = MainLogger.getEncode(note.getTitle());
        String encode2 = MainLogger.getEncode(note.getContent());
        String folderId = note.getFolderId();
        if (folderId == null) {
            folderId = "";
        }
        return AbstractC0541b.m776r(AbstractC0000a.m16m("[noteId: ", id, ", title: ", encode, ", content: "), encode2, ", folderId: ", folderId, "]");
    }

    private final String printUpdateNoteParams(UpdateNoteParams params) {
        List<? extends Attachment> value;
        String id = params.getId();
        String noteId = params.getNoteId();
        SetStringField title = params.getTitle();
        Integer numValueOf = null;
        String encode = MainLogger.getEncode(title != null ? title.getValue() : null);
        SetStringNullableField content = params.getContent();
        String encode2 = MainLogger.getEncode(content != null ? content.getValue() : null);
        SetStringNullableField folderId = params.getFolderId();
        String value2 = folderId != null ? folderId.getValue() : null;
        SetAttachmentListField attachments = params.getAttachments();
        if (attachments != null && (value = attachments.getValue()) != null) {
            numValueOf = Integer.valueOf(value.size());
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("[id: ", id, ", noteId: ", noteId, ", title: ");
        AbstractC2821a.m2207B(sbM16m, encode, ", content: ", encode2, ", folderId: ");
        sbM16m.append(value2);
        sbM16m.append(", attachments: ");
        sbM16m.append(numValueOf);
        sbM16m.append("]");
        return sbM16m.toString();
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.CreateNote
    @Nullable
    public Object createNote(@NotNull AppFunctionContext appFunctionContext, @NotNull CreateNoteParams createNoteParams, @NotNull Continuation<? super Note> continuation) throws AppFunctionException {
        String strNewUUID;
        MainLogger.m7254d(TAG, "createNote - createNoteParams: " + printCreateNoteParams(createNoteParams));
        String title = createNoteParams.getTitle();
        String content = createNoteParams.getContent();
        List<Attachment> attachments = createNoteParams.getAttachments();
        if (createNoteParams.getExternalId() == null || (strNewUUID = createNoteParams.getExternalId()) == null) {
            strNewUUID = UUIDUtils.newUUID(appFunctionContext.getContext());
        }
        String str = strNewUUID;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Attachment attachment : createNoteParams.getAttachments()) {
            arrayList.add(attachment.getMimeType());
            arrayList2.add(attachment.getUri().getAndroidUri());
        }
        String strSaveMemo = NotesWordDocumentServiceIntent.saveMemo(appFunctionContext.getContext(), str, createNoteParams.getFolderId(), DomainUtils.applyTitleMaxLimit(title), content == null ? "" : content, arrayList, arrayList2, null);
        if (TextUtils.isEmpty(strSaveMemo)) {
            throw new AppFunctionException(1502, null, null, 6, null);
        }
        String string = strSaveMemo.toString();
        String folderId = createNoteParams.getFolderId();
        Note note = new Note(NAME_SPACE, string, title, content, attachments, folderId == null ? "" : folderId);
        AbstractC0000a.m25v("createNote - result: ", printNote(note), TAG);
        CommonSamsungAnalytics.INSTANCE.insertLog("401", "COMP0001");
        return note;
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.DeleteNotes
    @Nullable
    public Object deleteNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<String>> continuation) throws AppFunctionException {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AbstractC0000a.m25v("deleteNote - noteId: ", (String) it.next(), TAG);
        }
        checkInvalidStatus(appFunctionContext.getContext());
        MoveNoteToTrashUseCase.Result resultExecute = new MoveNoteToTrashUseCase(NotesDataRepositoryFactory.newInstance(appFunctionContext.getContext()).createDocumentDataRepository()).execute(appFunctionContext.getContext(), list);
        Intrinsics.checkNotNullExpressionValue(resultExecute, "execute(...)");
        return new ArrayList(resultExecute.getDeletedNotes());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.FindNotes
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull FindNotesParams findNotesParams, @NotNull Continuation<? super List<Note>> continuation) throws AppFunctionException {
        C81551 c81551;
        if (continuation instanceof C81551) {
            c81551 = (C81551) continuation;
            int i = c81551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c81551.label = i - Integer.MIN_VALUE;
            } else {
                c81551 = new C81551(continuation);
            }
        }
        Object objWithContext = c81551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c81551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainLogger.m7254d(TAG, "findNotes - findNotesParams: " + printFindNotesParams(findNotesParams));
            checkInvalidStatus(appFunctionContext.getContext());
            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
            NoteFunctions$findNotes$result$1 noteFunctions$findNotes$result$1 = new NoteFunctions$findNotes$result$1(findNotesParams, this, appFunctionContext, null);
            c81551.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, noteFunctions$findNotes$result$1, c81551);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return (ArrayList) objWithContext;
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.GetNotes
    @Nullable
    public Object getNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<Note>> continuation) throws AppFunctionException {
        checkInvalidStatus(appFunctionContext.getContext());
        ArrayList arrayList = new ArrayList();
        for (DocumentTextData documentTextData : NotesDataRepositoryFactory.newInstance(appFunctionContext.getContext()).createSearchRepository().getDocumentTextData(list)) {
            String uuid = documentTextData.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            String title = documentTextData.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            arrayList.add(new Note(NAME_SPACE, uuid, title, documentTextData.getStrippedContent(), new ArrayList(), null, 32, null));
        }
        return arrayList;
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.ShowNote
    @Nullable
    public Object showNote(@NotNull AppFunctionContext appFunctionContext, @NotNull String str, @NotNull Continuation<? super PendingIntent> continuation) throws AppFunctionException {
        Intent intent;
        MainLogger.m7254d(TAG, "showNote - noteId: " + str);
        checkInvalidStatus(appFunctionContext.getContext());
        NotesDocumentEntity notesDocumentEntity = NotesDataRepositoryFactory.newInstance(appFunctionContext.getContext()).createDocumentDataRepository().get(str);
        if (notesDocumentEntity == null || notesDocumentEntity.getIsDeleted() != 0) {
            throw new AppFunctionException(1500, null, null, 6, null);
        }
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        Intrinsics.checkNotNullExpressionValue(activityOptionsMakeBasic, "makeBasic(...)");
        if (LockUtils.isLockedType(notesDocumentEntity.getIsLock())) {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("applink://com.samsung.android.app.notes/SelectNote?noteId=" + str));
        } else {
            intent = new Intent();
            if (Features.isSupportSimpleComposerForCoverDisplay()) {
                MainLogger.m7254d(TAG, "showNote - ACTION_SIMPLE_MODE");
                intent.setAction(ComposerConstants.ACTION_SIMPLE_MODE);
                Display extraBuiltInDisplay = DisplayUtils.INSTANCE.getExtraBuiltInDisplay(appFunctionContext.getContext());
                if (extraBuiltInDisplay != null) {
                    MainLogger.m7254d(TAG, "showNote - displayId : " + extraBuiltInDisplay.getDisplayId());
                    activityOptionsMakeBasic.setLaunchDisplayId(extraBuiltInDisplay.getDisplayId());
                }
            } else {
                intent.setAction("android.intent.action.VIEW");
            }
            intent.setFlags(intent.getFlags() & (-16777217));
            intent.addFlags(470286337);
            intent.setClass(appFunctionContext.getContext(), ComposerActivity.class);
            intent.putExtra("sdoc_uuid", str);
        }
        PendingIntent activity = PendingIntent.getActivity(appFunctionContext.getContext(), 0, intent, 201326592, activityOptionsMakeBasic.toBundle());
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNote
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateNote(@NotNull AppFunctionContext appFunctionContext, @NotNull UpdateNoteParams updateNoteParams, @NotNull Continuation<? super Note> continuation) throws AppFunctionException {
        C81561 c81561;
        String value;
        NotesDataRepositoryFactory notesDataRepositoryFactory;
        AppFunctionContext appFunctionContext2;
        List<? extends Attachment> arrayList;
        String value2;
        if (continuation instanceof C81561) {
            c81561 = (C81561) continuation;
            int i = c81561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c81561.label = i - Integer.MIN_VALUE;
            } else {
                c81561 = new C81561(continuation);
            }
        }
        Object objWithContext = c81561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c81561.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainLogger.m7254d(TAG, "updateNote - updateNoteParams: " + printUpdateNoteParams(updateNoteParams));
            checkInvalidStatus(appFunctionContext.getContext());
            ArrayList<Uri> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            SetAttachmentListField attachments = updateNoteParams.getAttachments();
            if (attachments != null) {
                for (Attachment attachment : attachments.getValue()) {
                    arrayList3.add(attachment.getMimeType());
                    arrayList2.add(attachment.getUri().getAndroidUri());
                }
            }
            UpdateNoteUseCase.UpdateNoteParam updateNoteParam = new UpdateNoteUseCase.UpdateNoteParam(updateNoteParams.getNoteId());
            SetStringNullableField folderId = updateNoteParams.getFolderId();
            if (folderId == null || (value = folderId.getValue()) == null) {
                value = "";
            }
            UpdateNoteUseCase.UpdateNoteParam folderUuid = updateNoteParam.setFolderUuid(value);
            SetStringField title = updateNoteParams.getTitle();
            UpdateNoteUseCase.UpdateNoteParam title2 = folderUuid.setTitle(title != null ? title.getValue() : null);
            SetStringNullableField content = updateNoteParams.getContent();
            UpdateNoteUseCase.UpdateNoteParam timeout = title2.setBodyText(content != null ? content.getValue() : null).setMimeTypes(arrayList3).setUris(arrayList2).setTimeout(3000L);
            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(appFunctionContext.getContext());
            CoroutineDispatcher io2 = Dispatchers.getIO();
            NoteFunctions$updateNote$result$1 noteFunctions$updateNote$result$1 = new NoteFunctions$updateNote$result$1(notesDataRepositoryFactoryNewInstance, appFunctionContext, timeout, arrayList2, null);
            c81561.L$0 = appFunctionContext;
            c81561.L$1 = updateNoteParams;
            c81561.L$2 = notesDataRepositoryFactoryNewInstance;
            c81561.label = 1;
            objWithContext = BuildersKt.withContext(io2, noteFunctions$updateNote$result$1, c81561);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            notesDataRepositoryFactory = notesDataRepositoryFactoryNewInstance;
            appFunctionContext2 = appFunctionContext;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            notesDataRepositoryFactory = (NotesDataRepositoryFactory) c81561.L$2;
            updateNoteParams = (UpdateNoteParams) c81561.L$1;
            appFunctionContext2 = (AppFunctionContext) c81561.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        if (((UpdateNoteUseCase.Result) objWithContext).getUpdatedNotes().isEmpty()) {
            throw new AppFunctionException(1500, null, null, 6, null);
        }
        NotesDocumentEntity notesDocumentEntity = notesDataRepositoryFactory.createDocumentDataRepository().get(updateNoteParams.getNoteId());
        if (notesDocumentEntity == null) {
            throw new AppFunctionException(1500, null, null, 6, null);
        }
        SDocXBodyTextGetter sDocXBodyTextGetter = new SDocXBodyTextGetter(appFunctionContext2.getContext());
        String filePath = notesDocumentEntity.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        String strReplaceUnicode = UnicodeUtils.replaceUnicode(sDocXBodyTextGetter.getMaxLengthBodyText(filePath), UnicodeUtils.OBJECT_REPLACEMENT, " ");
        String noteId = updateNoteParams.getNoteId();
        String title3 = notesDocumentEntity.getTitle();
        Intrinsics.checkNotNullExpressionValue(title3, "getTitle(...)");
        SetAttachmentListField attachments2 = updateNoteParams.getAttachments();
        if (attachments2 == null || (arrayList = attachments2.getValue()) == null) {
            arrayList = new ArrayList<>();
        }
        List<? extends Attachment> list = arrayList;
        SetStringNullableField folderId2 = updateNoteParams.getFolderId();
        Note note = new Note(NAME_SPACE, noteId, title3, strReplaceUnicode, list, (folderId2 == null || (value2 = folderId2.getValue()) == null) ? "" : value2);
        AbstractC0000a.m25v("updateNote - result: ", printNote(note), TAG);
        return note;
    }
}
