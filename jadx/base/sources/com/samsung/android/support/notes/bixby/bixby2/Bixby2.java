package com.samsung.android.support.notes.bixby.bixby2;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.Gson;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.bixby2.action.BixbyActionNoteListController;
import com.samsung.android.support.notes.bixby.bixby2.action.BixbyAppContext;
import com.samsung.android.support.notes.bixby.bixby2.action.BixbyExecutor;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbyAiParam;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound;
import com.samsung.android.support.notes.bixby.bixby2.contract.IDrawerFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\u0012J\u0010\u0010\u001c\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u001c\u00104\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00105\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u00106\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u001c\u00107\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00108\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u00109\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010:\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010;\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010<\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010=\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/Bixby2;", "", "<init>", "()V", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mBixbyExecutor", "Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyExecutor;", "mBixbyAppContext", "Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyAppContext;", "mNoteListActivity", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteListActivityBixby2;", "mNoteFragment", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteFragmentBixby2;", "mDrawerFragment", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IDrawerFragmentBixby2;", "registerBixbyExecutor", "", "updateAppState", "", "registerNoteListActivity", "bixby2", "releaseNoteListActivity", "registerNoteFragment", "releaseNoteFragment", "registerDrawerFragment", "releaseDrawerFragment", "bixbyAction", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IBixby2ActionBackgound;", "getBixbyAction", "()Ljava/lang/String;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "handleAppLink", "", "id", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "setLaunchOverTargetTask", "isNotBixbyAppLink", "", "handleAppLinkNoteListActivity", "handleAppLinkNoteFragment", "isValidNoteId", "noteId", "ConvertAddAction", "action", "handleActionOnComposer", "actionName", "appLinkData", "Landroid/net/Uri;", "handleActionForSmartSelect", "handleAddAction", "handleAiAction", "handleEtcAction", "isActionOnComposer", "isActionOnMainList", "isEtcActionOnComposer", "isActionForSmartSelect", "isAiAction", "isAddAction", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBixby2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Bixby2.kt\ncom/samsung/android/support/notes/bixby/bixby2/Bixby2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,487:1\n739#2,9:488\n739#2,9:501\n37#3:497\n36#3,3:498\n37#3:510\n36#3,3:511\n*S KotlinDebug\n*F\n+ 1 Bixby2.kt\ncom/samsung/android/support/notes/bixby/bixby2/Bixby2\n*L\n208#1:488,9\n287#1:501,9\n208#1:497\n208#1:498,3\n287#1:510\n287#1:511,3\n*E\n"})
public final class Bixby2 {

    @NotNull
    private static final String TAG = "Bixby2";

    @Nullable
    private BixbyAppContext mBixbyAppContext;

    @Nullable
    private BixbyExecutor mBixbyExecutor;

    @Nullable
    private IDrawerFragmentBixby2 mDrawerFragment;

    @Nullable
    private INoteFragmentBixby2 mNoteFragment;

    @Nullable
    private INoteListActivityBixby2 mNoteListActivity;

    public Bixby2() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int ConvertAddAction(String action) {
        if (action != null) {
            switch (action.hashCode()) {
                case -1535817068:
                    return !action.equals(Bixby2Constants.BIXBY_ACTION_REPLACE) ? 0 : 2;
                case -36509798:
                    if (action.equals(Bixby2Constants.BIXBY_ACTION_PASTE_IN_NEW_NOTE)) {
                        return 4;
                    }
                    break;
                case 2106261:
                    if (action.equals(Bixby2Constants.BIXBY_ACTION_COPY)) {
                        return 1;
                    }
                    break;
                case 76885619:
                    if (action.equals(Bixby2Constants.BIXBY_ACTION_PASTE)) {
                        return 3;
                    }
                    break;
            }
        } else {
            Logger.m8697d(TAG, "ConvertAddAction# Add action is null");
            return 0;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int handleActionForSmartSelect(String actionName, Uri appLinkData) {
        String str;
        String queryParameter = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_IMAGE_URI) : null;
        String queryParameter2 = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_NOTE_TITLE) : null;
        String queryParameter3 = appLinkData != null ? appLinkData.getQueryParameter("text") : null;
        if (actionName != null) {
            switch (actionName.hashCode()) {
                case -2104394221:
                    if (!actionName.equals(Bixby2Constants.BIXBY_ACTION_SELECT_AND_ADD_CONTENT)) {
                        str = actionName;
                        break;
                    }
                    String str2 = queryParameter;
                    INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
                    return (iNoteListActivityBixby2 == null || !iNoteListActivityBixby2.addContentToComposer(actionName, str2, queryParameter, queryParameter2, queryParameter3)) ? 0 : 1001;
                case -1892512169:
                    if (!actionName.equals(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE)) {
                        str = actionName;
                    }
                    String str22 = queryParameter;
                    INoteListActivityBixby2 iNoteListActivityBixby22 = this.mNoteListActivity;
                    if (iNoteListActivityBixby22 == null) {
                        return 0;
                    }
                    break;
                case -785279598:
                    if (!actionName.equals(Bixby2Constants.BIXBY_ACTION_NEW_NOTE)) {
                        str = actionName;
                    }
                    String str222 = queryParameter;
                    INoteListActivityBixby2 iNoteListActivityBixby222 = this.mNoteListActivity;
                    if (iNoteListActivityBixby222 == null) {
                    }
                    break;
                case 558262456:
                    if (!actionName.equals(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT)) {
                        str = actionName;
                        break;
                    } else {
                        queryParameter = appLinkData != null ? appLinkData.getQueryParameter("noteId") : null;
                        if (!isValidNoteId(queryParameter)) {
                            return -1;
                        }
                        String str2222 = queryParameter;
                        INoteListActivityBixby2 iNoteListActivityBixby2222 = this.mNoteListActivity;
                        if (iNoteListActivityBixby2222 == null) {
                        }
                    }
                    break;
                default:
                    str = actionName;
                    break;
            }
        } else {
            str = actionName;
        }
        AbstractC4539a.m3188B("handleActionForSmartSelect# unexpected actionName: ", str, TAG);
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
    
        if (r18.equals(com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants.BIXBY_ACTION_EDIT) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        if (r18.equals(com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants.BIXBY_ACTION_SELECT) == false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int handleActionOnComposer(String actionName, Uri appLinkData) {
        List listEmptyList;
        String queryParameter = appLinkData != null ? appLinkData.getQueryParameter("noteId") : null;
        if (!isValidNoteId(queryParameter)) {
            return -1;
        }
        Intrinsics.checkNotNull(queryParameter);
        List<String> listSplit = new Regex("\\,").split(queryParameter, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
        if (companion != null && !companion.isValidUUIDs(strArr)) {
            Logger.m8697d(TAG, "handleActionOnComposer# noteIds is not valid");
            return -1;
        }
        String queryParameter2 = appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_SHARE_TYPE);
        String queryParameter3 = appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_KEYWORD);
        String queryParameter4 = appLinkData.getQueryParameter("packageName");
        String queryParameter5 = appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME);
        String encode = Logger.getEncode(queryParameter3);
        String encode2 = Logger.getEncode(queryParameter4);
        String encode3 = Logger.getEncode(queryParameter5);
        StringBuilder sbM16m = AbstractC0000a.m16m("handleActionOnComposer# ", queryParameter, SQLKeyword.COMMA, queryParameter2, SQLKeyword.COMMA);
        AbstractC2821a.m2207B(sbM16m, encode, SQLKeyword.COMMA, encode2, SQLKeyword.COMMA);
        sbM16m.append(encode3);
        Logger.m8697d(TAG, sbM16m.toString());
        if (actionName != null) {
            int iHashCode = actionName.hashCode();
            if (iHashCode != 337336110) {
                if (iHashCode != 421760081) {
                    if (iHashCode == 1666507068) {
                    }
                } else if (actionName.equals(Bixby2Constants.BIXBY_ACTION_SHARE)) {
                    if (strArr.length != 1) {
                        Logger.m8697d(TAG, "handleActionOnComposer# noteId need only 1.");
                        return 0;
                    }
                    INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
                    return (iNoteListActivityBixby2 == null || !iNoteListActivityBixby2.openComposer(actionName, queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5)) ? 0 : 1001;
                }
            }
        }
        AbstractC4539a.m3188B("handleActionOnComposer# unexpected actionName: ", actionName, TAG);
        return -1;
    }

    private final int handleAddAction(String actionName) {
        BixbyAiParam bixbyAiParam = new BixbyAiParam();
        bixbyAiParam.setActionName(Bixby2Constants.BIXBY_ACTION_ADD_ACTION);
        bixbyAiParam.setAddAction(ConvertAddAction(actionName));
        INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
        return (iNoteListActivityBixby2 == null || !iNoteListActivityBixby2.sendActionToComposer(bixbyAiParam)) ? 0 : 1001;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
    
        if (r8.equals(com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants.BIXBY_ACTION_SUMMARIZE_NOTE_PAGE) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
    
        if (r8.equals(com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants.BIXBY_ACTION_CORRECT_SPELLING_NOTE_PAGE) == false) goto L71;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int handleAiAction(String actionName, Uri appLinkData) {
        String queryParameter;
        INoteListActivityBixby2 iNoteListActivityBixby2;
        BixbyAiParam bixbyAiParam = new BixbyAiParam();
        bixbyAiParam.setActionName(actionName);
        if (!Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CREATE_NOTE_COVER, actionName)) {
            bixbyAiParam.setAddAction(ConvertAddAction(appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_ACTION_ADD_ACTION) : null));
            String queryParameter2 = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_RANGE) : null;
            if (queryParameter2 == null || !Intrinsics.areEqual(Bixby2Constants.BIXBY_PARAM_RANGE_CURRENT_PAGE, queryParameter2)) {
                bixbyAiParam.setRange(0);
            } else {
                bixbyAiParam.setRange(1);
            }
        }
        if (actionName != null) {
            switch (actionName.hashCode()) {
                case -1438022424:
                    if (actionName.equals(Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT)) {
                        queryParameter = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_FORMAT_TYPE) : null;
                        if (queryParameter == null || Intrinsics.areEqual(queryParameter, Bixby2Constants.BIXBY_PARAM_FORMAT_MULTI_LEVEL)) {
                            bixbyAiParam.setActionName(Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT_MULTI_LEVEL_LIST);
                        } else {
                            bixbyAiParam.setActionName(Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT_MEETING);
                        }
                        iNoteListActivityBixby2 = this.mNoteListActivity;
                        if (iNoteListActivityBixby2 != null || !iNoteListActivityBixby2.sendActionToComposer(bixbyAiParam)) {
                        }
                    }
                    break;
                case -1228988955:
                    break;
                case -707171031:
                    if (actionName.equals(Bixby2Constants.BIXBY_ACTION_CREATE_NOTE_COVER)) {
                        queryParameter = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_SELECT) : null;
                        if (queryParameter != null && Intrinsics.areEqual(Bixby2Constants.BIXBY_PARAM_CHECK, queryParameter)) {
                        }
                        iNoteListActivityBixby2 = this.mNoteListActivity;
                        if (iNoteListActivityBixby2 != null) {
                        }
                    }
                    break;
                case -683853342:
                    break;
                case 125989306:
                    if (actionName.equals(Bixby2Constants.BIXBY_ACTION_CHANGE_SPEECH_TO_TEXT)) {
                        queryParameter = appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_INDEX) : null;
                        if (queryParameter != null) {
                            try {
                                bixbyAiParam.setIndex(Integer.parseInt(queryParameter));
                            } catch (NumberFormatException e) {
                                AbstractC4539a.m3214x("handleAiAction#, e : ", e.getMessage(), TAG);
                            }
                        } else {
                            Logger.m8697d(TAG, "index is null");
                        }
                        iNoteListActivityBixby2 = this.mNoteListActivity;
                        if (iNoteListActivityBixby2 != null) {
                        }
                    }
                    break;
                case 1693754607:
                    if (actionName.equals(Bixby2Constants.BIXBY_ACTION_TRANSLATE_NOTE_PAGE)) {
                        bixbyAiParam.setTargetLanguage(appLinkData != null ? appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_TARGET_LANGUAGE_CODE) : null);
                        iNoteListActivityBixby2 = this.mNoteListActivity;
                        if (iNoteListActivityBixby2 != null) {
                        }
                    }
                    break;
            }
            return 0;
        }
        AbstractC4539a.m3188B("handleAiAction# unexpected actionName: ", actionName, TAG);
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int handleAppLinkNoteFragment(Intent intent) {
        String[] strArr;
        List listEmptyList;
        Uri data = intent.getData();
        if (isNotBixbyAppLink(intent)) {
            Logger.m8697d(TAG, "handleAppLinkNoteFragment - return None");
            return 0;
        }
        Intrinsics.checkNotNull(data);
        String lastPathSegment = data.getLastPathSegment();
        Logger.m8697d(TAG, "handleAppLinkNoteFragment - actionName : " + lastPathSegment);
        if (TextUtils.isEmpty(lastPathSegment)) {
            return 0;
        }
        if (!isActionOnMainList(lastPathSegment)) {
            Logger.m8697d(TAG, "handleAppLinkNoteFragment# return, Invalid action");
            return 0;
        }
        setLaunchOverTargetTask(intent);
        INoteFragmentBixby2 iNoteFragmentBixby2 = this.mNoteFragment;
        if (iNoteFragmentBixby2 != null) {
            iNoteFragmentBixby2.setAction();
        }
        if (!Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SEARCH, lastPathSegment) && !Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SHOW_ALL_NOTES, lastPathSegment)) {
            String queryParameter = data.getQueryParameter("noteId");
            if (isValidNoteId(queryParameter)) {
                Intrinsics.checkNotNull(queryParameter);
                List<String> listSplit = new Regex("\\,").split(queryParameter, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                            break;
                        }
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                strArr = (String[]) listEmptyList.toArray(new String[0]);
                BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
                if (companion != null && !companion.isValidUUIDs(strArr)) {
                    Logger.m8697d(TAG, "handleAppLinkNoteFragment# noteIds is not valid");
                }
            }
            return -1;
        }
        strArr = null;
        if (lastPathSegment != null) {
            switch (lastPathSegment.hashCode()) {
                case -537085859:
                    if (!lastPathSegment.equals(Bixby2Constants.BIXBY_ACTION_DELETE)) {
                        AbstractC4539a.m3188B("handleAppLinkNoteFragment# unexpected actionName: ", lastPathSegment, TAG);
                        break;
                    } else {
                        INoteFragmentBixby2 iNoteFragmentBixby22 = this.mNoteFragment;
                        if (iNoteFragmentBixby22 == null || !iNoteFragmentBixby22.deleteNotes(strArr)) {
                        }
                    }
                    break;
                case 421760081:
                    if (lastPathSegment.equals(Bixby2Constants.BIXBY_ACTION_SHARE)) {
                        if (strArr != null && strArr.length > 1) {
                            String queryParameter2 = data.getQueryParameter(Bixby2Constants.BIXBY_PARAM_SHARE_TYPE);
                            String string = Arrays.toString(strArr);
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            Logger.m8697d(TAG, "noteIds : " + string + " shareType : " + queryParameter2);
                            INoteFragmentBixby2 iNoteFragmentBixby23 = this.mNoteFragment;
                            if (iNoteFragmentBixby23 == null || !iNoteFragmentBixby23.shareNotes(strArr, queryParameter2)) {
                            }
                        }
                    }
                    break;
                case 1094780893:
                    if (lastPathSegment.equals(Bixby2Constants.BIXBY_ACTION_SHOW_ALL_NOTES)) {
                        INoteFragmentBixby2 iNoteFragmentBixby24 = this.mNoteFragment;
                        if (iNoteFragmentBixby24 != null && iNoteFragmentBixby24.showAllNotes()) {
                            IDrawerFragmentBixby2 iDrawerFragmentBixby2 = this.mDrawerFragment;
                            if (iDrawerFragmentBixby2 != null) {
                                Intrinsics.checkNotNull(iDrawerFragmentBixby2);
                                iDrawerFragmentBixby2.closeDrawer();
                            } else {
                                Logger.m8697d(TAG, "mDrawerFragment is null");
                            }
                        }
                        break;
                    }
                    break;
                case 1282822618:
                    if (lastPathSegment.equals(Bixby2Constants.BIXBY_ACTION_SEARCH)) {
                        INoteFragmentBixby2 iNoteFragmentBixby25 = this.mNoteFragment;
                        if (iNoteFragmentBixby25 == null || !iNoteFragmentBixby25.search()) {
                        }
                    }
                    break;
            }
            return 0;
        }
        return 0;
    }

    private final int handleAppLinkNoteListActivity(Intent intent) {
        Uri data = intent.getData();
        if (isNotBixbyAppLink(intent)) {
            Logger.m8697d(TAG, "handleAppLinkNoteListActivity - return None");
            return 0;
        }
        String lastPathSegment = data != null ? data.getLastPathSegment() : null;
        AbstractC4539a.m3188B("handleAppLinkNoteListActivity - actionName : ", lastPathSegment, TAG);
        if (lastPathSegment != null && lastPathSegment.length() != 0) {
            setLaunchOverTargetTask(intent);
            if (isActionForSmartSelect(lastPathSegment)) {
                return handleActionForSmartSelect(lastPathSegment, data);
            }
            if (isAddAction(lastPathSegment)) {
                return handleAddAction(lastPathSegment);
            }
            if (isAiAction(lastPathSegment)) {
                return handleAiAction(lastPathSegment, data);
            }
            if (isActionOnComposer(lastPathSegment)) {
                return handleActionOnComposer(lastPathSegment, data);
            }
            if (isEtcActionOnComposer(lastPathSegment)) {
                return handleEtcAction(lastPathSegment, data);
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r6.equals(com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants.BIXBY_ACTION_DELETE_IN_NOTE) == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int handleEtcAction(String actionName, Uri appLinkData) {
        if (actionName != null) {
            int iHashCode = actionName.hashCode();
            String queryParameter = null;
            if (iHashCode != -888623006) {
                if (iHashCode != -8266081) {
                    if (iHashCode == 2921576 && actionName.equals(Bixby2Constants.BIXBY_ACTION_CHANGE_TITLE)) {
                        if (appLinkData != null) {
                            queryParameter = appLinkData.getQueryParameter("title");
                        }
                        Logger.m8697d(TAG, "handleEtcAction# " + actionName + SQLKeyword.COMMA + queryParameter);
                        INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
                        return (iNoteListActivityBixby2 == null && iNoteListActivityBixby2.sendActionToComposer(actionName, queryParameter)) ? 1001 : 0;
                    }
                } else if (actionName.equals(Bixby2Constants.BIXBY_ACTION_SEARCH_IN_NOTE)) {
                    if (appLinkData != null) {
                        queryParameter = appLinkData.getQueryParameter(Bixby2Constants.BIXBY_PARAM_KEYWORD);
                    }
                    Logger.m8697d(TAG, "handleEtcAction# " + actionName + SQLKeyword.COMMA + queryParameter);
                    INoteListActivityBixby2 iNoteListActivityBixby22 = this.mNoteListActivity;
                    if (iNoteListActivityBixby22 == null) {
                    }
                }
            }
        }
        AbstractC4539a.m3188B("handleEtcAction# unexpected actionName: ", actionName, TAG);
        return 0;
    }

    private final boolean isActionForSmartSelect(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_NEW_NOTE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SELECT_AND_ADD_CONTENT, actionName);
    }

    private final boolean isActionOnComposer(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SHARE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_EDIT, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SELECT, actionName);
    }

    private final boolean isActionOnMainList(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SHARE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_DELETE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SEARCH, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SHOW_ALL_NOTES, actionName);
    }

    private final boolean isAddAction(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_COPY, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_PASTE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_PASTE_IN_NEW_NOTE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_REPLACE, actionName);
    }

    private final boolean isAiAction(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CORRECT_SPELLING_NOTE_PAGE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SUMMARIZE_NOTE_PAGE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_TRANSLATE_NOTE_PAGE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CREATE_NOTE_COVER, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CHANGE_SPEECH_TO_TEXT, actionName);
    }

    private final boolean isEtcActionOnComposer(String actionName) {
        return Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_CHANGE_TITLE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_SEARCH_IN_NOTE, actionName) || Intrinsics.areEqual(Bixby2Constants.BIXBY_ACTION_DELETE_IN_NOTE, actionName);
    }

    private final boolean isNotBixbyAppLink(Intent intent) {
        Uri data = intent.getData();
        return this.mNoteListActivity == null || data == null || !Intrinsics.areEqual("android.intent.action.VIEW", intent.getAction()) || !StringsKt__StringsJVMKt.equals("applink", data.getScheme(), true);
    }

    private final boolean isValidNoteId(String noteId) {
        if (noteId == null) {
            Logger.m8697d(TAG, "isValidNoteId# noteId is null");
            return false;
        }
        if (!TextUtils.isEmpty(noteId)) {
            return true;
        }
        Logger.m8697d(TAG, "isValidNoteId# noteId is empty.");
        return false;
    }

    private final void registerBixbyExecutor(Application application) {
        BixbyExecutor companion = BixbyExecutor.INSTANCE.getInstance(application);
        this.mBixbyExecutor = companion;
        if (companion != null) {
            companion.addActionHandler();
        }
        BixbyExecutor bixbyExecutor = this.mBixbyExecutor;
        if (bixbyExecutor != null) {
            bixbyExecutor.updateStateChange(new StateHandler.Callback() { // from class: com.samsung.android.support.notes.bixby.bixby2.Bixby2.registerBixbyExecutor.1
                @Override // com.samsung.android.sdk.bixby2.state.StateHandler.Callback
                public String onAppStateRequested() {
                    return Bixby2.this.updateAppState();
                }
            });
        }
    }

    private final void setLaunchOverTargetTask(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Logger.m8697d(TAG, "setLaunchOverTargetTask - bundle is null");
            return;
        }
        if (extras.containsKey("bixbyClient_taskId")) {
            int i = extras.getInt(" bixbyClient_taskId");
            AbstractC4539a.m3203m(i, "setLaunchOverTargetTask - Bixby Client taskId : ", TAG);
            try {
                Intent.class.getDeclaredMethod("semSetLaunchOverTargetTask", Integer.TYPE, Boolean.TYPE).invoke(intent, Integer.valueOf(i), Boolean.FALSE);
            } catch (IllegalAccessException e) {
                AbstractC4539a.m3188B("setLaunchOverTargetTask, exception : ", e.getMessage(), TAG);
            } catch (NoSuchMethodException e2) {
                AbstractC4539a.m3188B("setLaunchOverTargetTask, exception : ", e2.getMessage(), TAG);
            } catch (InvocationTargetException e3) {
                AbstractC4539a.m3188B("setLaunchOverTargetTask, exception : ", e3.getMessage(), TAG);
            }
        }
    }

    public final void bixbyAction(@Nullable IBixby2ActionBackgound bixby2) {
        BixbyActionNoteListController companion;
        if (bixby2 == null || (companion = BixbyActionNoteListController.INSTANCE.getInstance()) == null) {
            return;
        }
        companion.setBixbyCallBack(bixby2);
    }

    @Nullable
    public final String getBixbyAction() {
        INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
        if (iNoteListActivityBixby2 != null) {
            return iNoteListActivityBixby2.getBixbyAction();
        }
        return null;
    }

    @Nullable
    public final String getShareType() {
        INoteListActivityBixby2 iNoteListActivityBixby2 = this.mNoteListActivity;
        if (iNoteListActivityBixby2 != null) {
            return iNoteListActivityBixby2.getShareType();
        }
        return null;
    }

    public final int handleAppLink(int id, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (id == 100) {
            return handleAppLinkNoteListActivity(intent);
        }
        if (id != 101) {
            return 0;
        }
        return handleAppLinkNoteFragment(intent);
    }

    public final void registerDrawerFragment(@Nullable IDrawerFragmentBixby2 bixby2) {
        if (bixby2 != null) {
            Logger.m8697d(TAG, "registerDrawerFragment");
            this.mDrawerFragment = bixby2;
        }
    }

    public final void registerNoteFragment(@Nullable INoteFragmentBixby2 bixby2) {
        if (bixby2 != null) {
            Logger.m8697d(TAG, "registerNoteFragment");
            this.mNoteFragment = bixby2;
        }
    }

    public final void registerNoteListActivity(@Nullable INoteListActivityBixby2 bixby2) {
        if (bixby2 != null) {
            Logger.m8697d(TAG, "registerNoteListActivity");
            this.mNoteListActivity = bixby2;
        }
    }

    public final void releaseDrawerFragment() {
        Logger.m8697d(TAG, "releaseDrawerFragment");
        this.mDrawerFragment = null;
    }

    public final void releaseNoteFragment() {
        Logger.m8697d(TAG, "releaseNoteFragment");
        this.mNoteFragment = null;
    }

    public final void releaseNoteListActivity() {
        Logger.m8697d(TAG, "releaseNoteListActivity");
        this.mNoteListActivity = null;
    }

    @NotNull
    public final String updateAppState() {
        Logger.m8697d(TAG, "updateAppState");
        BixbyAppContext bixbyAppContext = this.mBixbyAppContext;
        String json = new Gson().toJson(bixbyAppContext != null ? bixbyAppContext.makeAppContext(this.mNoteFragment) : null);
        Logger.m8697d(TAG, "updateAppState : " + Logger.getEncode(json));
        Intrinsics.checkNotNull(json);
        return json;
    }

    public Bixby2(@Nullable Application application) {
        this();
        registerBixbyExecutor(application);
        this.mBixbyAppContext = BixbyAppContext.INSTANCE.getInstance();
    }
}
