package com.samsung.android.support.senl.p148nt.stt.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.credentials.playservices.C2517b;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Feature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.STTLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ConvertUtils;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertResultData;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertService;
import com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseLanguageDialogListener;
import com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseVoiceItemDialogListener;
import com.samsung.android.support.senl.p148nt.stt.base.listener.STTRecognizeListener;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiParagraphInfo;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.STTDataHelper;
import com.samsung.android.support.senl.p148nt.stt.base.model.STTRecognitionData;
import com.samsung.android.support.senl.p148nt.stt.base.model.STTReplayData;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.base.model.paint.PaintHelper;
import com.samsung.android.support.senl.p148nt.stt.base.record.RecordRecognizer;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.common.util.STTDataUtils;
import com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract;
import com.samsung.android.support.senl.p148nt.stt.controller.STTFloatingController;
import com.samsung.android.support.senl.p148nt.stt.controller.STTVoiceDataController;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;
import com.samsung.android.support.senl.p148nt.stt.view.STTVoiceItem;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.RemoveTranscriptConfirmDialog;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTDialogFactory;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSelectTranscribeDialogFragment;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSettingLanguageDialogFragment;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;
import com.samsung.android.support.senl.p148nt.stt.view.language.LanguageInfo;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 È\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Ç\u0002È\u0002B!\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0006JL\u0010n\u001a\u00020l2\u0016\u0010o\u001a\u0012\u0012\u0004\u0012\u00020q0pj\b\u0012\u0004\u0012\u00020q`r2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020xH\u0016J\u0010\u0010z\u001a\u00020l2\u0006\u0010{\u001a\u00020\rH\u0016J\u0006\u0010|\u001a\u00020lJ)\u0010}\u001a\u00020l2\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010vH\u0002¢\u0006\u0003\u0010\u0081\u0001J\u0010\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0080\u0001\u001a\u00020EJ\u0019\u0010\u0083\u0001\u001a\u00020l2\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0080\u0001\u001a\u00020EJ\u0017\u0010\u0085\u0001\u001a\u00020l2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0007\u0010\u0086\u0001\u001a\u00020lJ\u0007\u0010\u0087\u0001\u001a\u00020lJ\u0010\u0010\u0088\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u0010\u0010\u008a\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u0010\u0010\u008b\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u0019\u0010\u008c\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\rJ\u0010\u0010\u008e\u0001\u001a\u00020l2\u0007\u0010\u008d\u0001\u001a\u00020\rJ\u0007\u0010\u008e\u0001\u001a\u00020lJ\u0012\u0010\u008f\u0001\u001a\u00020l2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010%J\u0007\u0010\u0091\u0001\u001a\u00020lJ\u0007\u0010\u0092\u0001\u001a\u00020lJ\u0007\u0010\u0093\u0001\u001a\u00020lJ\u0007\u0010\u0094\u0001\u001a\u00020lJ\u0012\u0010\u0095\u0001\u001a\u00020l2\t\b\u0002\u0010\u0096\u0001\u001a\u00020TJ\u0010\u0010\u0097\u0001\u001a\u00020l2\u0007\u0010\u0098\u0001\u001a\u00020TJ&\u0010\u0099\u0001\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010pj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`r2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010%J\u0007\u0010\u009b\u0001\u001a\u00020lJ\u0007\u0010\u009c\u0001\u001a\u00020lJ\t\u0010\u009d\u0001\u001a\u00020lH\u0002J\t\u0010\u009e\u0001\u001a\u00020lH\u0002J\u0007\u0010\u009f\u0001\u001a\u00020lJ\u0010\u0010 \u0001\u001a\u00020l2\u0007\u0010¡\u0001\u001a\u00020TJ\u0010\u0010¢\u0001\u001a\u00020l2\u0007\u0010£\u0001\u001a\u00020/J\t\u0010¦\u0001\u001a\u00020TH\u0016J\t\u0010§\u0001\u001a\u00020TH\u0016J\u001b\u0010©\u0001\u001a\u00020l2\u0007\u0010\u008d\u0001\u001a\u00020\r2\u0007\u0010ª\u0001\u001a\u00020TH\u0016J\u0007\u0010°\u0001\u001a\u00020lJ\t\u0010±\u0001\u001a\u00020TH\u0016J\u0007\u0010¶\u0001\u001a\u00020lJ\t\u0010·\u0001\u001a\u00020lH\u0002J\u0007\u0010¸\u0001\u001a\u00020lJ\u0010\u0010º\u0001\u001a\u00020l2\u0007\u0010»\u0001\u001a\u00020TJ\u0007\u0010¼\u0001\u001a\u00020TJ\u0010\u0010½\u0001\u001a\u00020l2\u0007\u0010±\u0001\u001a\u00020TJ\u0007\u0010¾\u0001\u001a\u00020lJ\t\u0010¿\u0001\u001a\u00020lH\u0002J\u0012\u0010À\u0001\u001a\u00020l2\u0007\u0010Á\u0001\u001a\u00020TH&J\t\u0010Â\u0001\u001a\u00020lH&J\u001b\u0010Ã\u0001\u001a\u00020l2\u0007\u0010Ä\u0001\u001a\u00020\r2\u0007\u0010Å\u0001\u001a\u00020EH&J\u0012\u0010Æ\u0001\u001a\u00020l2\u0007\u0010Ä\u0001\u001a\u00020\rH&J\u0012\u0010É\u0001\u001a\u00020l2\u0007\u0010Ä\u0001\u001a\u00020\rH&J\t\u0010Ê\u0001\u001a\u00020lH&J\t\u0010Ë\u0001\u001a\u00020lH&J\t\u0010Ì\u0001\u001a\u00020lH&J\u000b\u0010Í\u0001\u001a\u0004\u0018\u00010%H&J\u0012\u0010Î\u0001\u001a\u00020l2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010%J4\u0010Ð\u0001\u001a\u00020l2\u0007\u0010Ñ\u0001\u001a\u00020\r2\u0007\u0010Ò\u0001\u001a\u00020T2\u0007\u0010Ó\u0001\u001a\u00020T2\u0007\u0010Ô\u0001\u001a\u00020\r2\u0007\u0010Õ\u0001\u001a\u00020\rJ\u0010\u0010Ö\u0001\u001a\u00020l2\u0007\u0010×\u0001\u001a\u00020TJ\u0014\u0010Ù\u0001\u001a\u00020\r2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%H\u0002J1\u0010Û\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010Ü\u0001\u001a\u00020\r2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010Þ\u0001\u001a\u00020\rH\u0016J&\u0010ß\u0001\u001a\u00020l2\u0007\u0010à\u0001\u001a\u00020\t2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010Ä\u0001\u001a\u00020\rH\u0002J\u001d\u0010á\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010à\u0001\u001a\u00020\tH\u0002J\u001d\u0010â\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010ã\u0001\u001a\u00020\rH\u0016J \u0010ä\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0016J\u0012\u0010ç\u0001\u001a\u00020l2\u0007\u0010è\u0001\u001a\u00020%H\u0002J \u0010é\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0016J\u0014\u0010ê\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%H\u0016J\t\u0010ë\u0001\u001a\u00020lH\u0016J\t\u0010ì\u0001\u001a\u00020lH\u0002J\t\u0010í\u0001\u001a\u00020lH\u0002J\t\u0010î\u0001\u001a\u00020lH\u0016J\u0010\u0010ï\u0001\u001a\u00020l2\u0007\u0010ð\u0001\u001a\u00020\rJ\u001d\u0010ñ\u0001\u001a\u00020l2\u0007\u0010ò\u0001\u001a\u00020%2\t\u0010ó\u0001\u001a\u0004\u0018\u00010%H\u0002J\t\u0010ô\u0001\u001a\u00020lH\u0016J\t\u0010õ\u0001\u001a\u00020lH\u0016J\u0007\u0010ö\u0001\u001a\u00020lJ\u0012\u0010ö\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%J\u0012\u0010÷\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%J\u0012\u0010ø\u0001\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%J\u0012\u0010ù\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010ú\u0001\u001a\u00020TJ\u0010\u0010\u0086\u0002\u001a\u00020%2\u0007\u0010\u008d\u0001\u001a\u00020\rJ\u0016\u0010\u0087\u0002\u001a\u00020l2\r\u0010\u0088\u0002\u001a\b\u0012\u0004\u0012\u00020%0\bJ\u0012\u0010\u0089\u0002\u001a\u00020l2\u0007\u0010\u008a\u0002\u001a\u00020\rH\u0016J\u001b\u0010\u008b\u0002\u001a\u00020l2\u0007\u0010\u008c\u0002\u001a\u00020%2\u0007\u0010\u008d\u0002\u001a\u00020\rH\u0016J\u0019\u0010\u008e\u0002\u001a\u00020l2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\bH\u0016J\u001d\u0010\u008f\u0002\u001a\u00020l2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%0$H\u0016J\u001a\u0010\u0090\u0002\u001a\u00020l2\u000f\u0010\u0091\u0002\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0017H\u0016J\t\u0010\u0092\u0002\u001a\u00020\u0000H\u0016J\u0010\u0010\u0094\u0002\u001a\u00020l2\u0007\u0010\u0095\u0002\u001a\u00020TJ\u0007\u0010\u0096\u0002\u001a\u00020lJ\u0007\u0010\u0097\u0002\u001a\u00020lJ\u0019\u0010\u0098\u0002\u001a\u00020l2\u0007\u0010ð\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0002\u001a\u00020RJ\u0010\u0010\u009a\u0002\u001a\u00020l2\u0007\u0010ð\u0001\u001a\u00020\rJ\u001c\u0010\u009b\u0002\u001a\u00020l2\n\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009d\u00022\u0007\u0010\u009e\u0002\u001a\u00020TJ\u0010\u0010\u009f\u0002\u001a\u00020l2\u0007\u0010\u008d\u0001\u001a\u00020\rJ\t\u0010 \u0002\u001a\u00020lH\u0016J\u0013\u0010¡\u0002\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0006H\u0002J\u0013\u0010¢\u0002\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010£\u0002\u001a\u00020T2\u0007\u0010ð\u0001\u001a\u00020\rJ\"\u0010§\u0002\u001a\u00020l2\u0007\u0010¨\u0002\u001a\u00020T2\u000e\u0010©\u0002\u001a\t\u0012\u0004\u0012\u00020l0ª\u0002H\u0002J\u0007\u0010«\u0002\u001a\u00020lJ\u001e\u0010¬\u0002\u001a\u00020l2\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010®\u00022\u0007\u0010¯\u0002\u001a\u00020%H\u0002J\u0007\u0010°\u0002\u001a\u00020lJ\u0007\u0010±\u0002\u001a\u00020lJ\u0010\u0010²\u0002\u001a\u00020l2\u0007\u0010³\u0002\u001a\u00020\rJ\u0019\u0010´\u0002\u001a\u00020l2\u0007\u0010µ\u0002\u001a\u00020\t2\u0007\u0010¶\u0002\u001a\u00020\rJ(\u0010·\u0002\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010Þ\u0001\u001a\u00020\r2\t\u0010¸\u0002\u001a\u0004\u0018\u00010%H\u0002J\n\u0010¹\u0002\u001a\u0005\u0018\u00010æ\u0001J\u0014\u0010º\u0002\u001a\u00020l2\t\u0010è\u0001\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010»\u0002\u001a\u00020l2\u0007\u0010¼\u0002\u001a\u00020\tH\u0002J\u0010\u0010½\u0002\u001a\u00020l2\u0007\u0010µ\u0002\u001a\u00020\tJ\u0012\u0010¾\u0002\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%J\t\u0010¿\u0002\u001a\u0004\u0018\u00010aJ\t\u0010À\u0002\u001a\u0004\u0018\u00010%J\u0007\u0010Á\u0002\u001a\u00020TJ\u001e\u0010Â\u0002\u001a\u00020l2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ä\u0002J\u0015\u0010Å\u0002\u001a\u0005\u0018\u00010Æ\u00022\t\u0010Ú\u0001\u001a\u0004\u0018\u00010%R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001e\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0004\u0018\u00010%2\b\u0010.\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001c\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010R0QX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010U\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010%0QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010U\"\u0004\bg\u0010WR\u001a\u0010h\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010U\"\u0004\bj\u0010WR\u0013\u0010¤\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010UR\u0013\u0010¥\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010UR\u0013\u0010¨\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010UR\u0013\u0010«\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b«\u0001\u0010UR\u0013\u0010¬\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010UR\u0013\u0010\u00ad\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010UR\u0015\u0010®\u0001\u001a\u0004\u0018\u00010%8F¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010OR\u0017\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0013\u0010¹\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010UR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX¦\u000e¢\u0006\u000e\u001a\u0005\bÇ\u0001\u0010 \"\u0005\bÈ\u0001\u0010\"R\u0013\u0010Ø\u0001\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010UR\u0015\u0010û\u0001\u001a\u0004\u0018\u00010%8F¢\u0006\u0007\u001a\u0005\bü\u0001\u0010OR\u0015\u0010ý\u0001\u001a\u0004\u0018\u00010%8F¢\u0006\u0007\u001a\u0005\bþ\u0001\u0010OR\u0017\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0080\u00028F¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R(\u0010\u0083\u0002\u001a\u00020\r2\u0007\u0010ð\u0001\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0002\u0010J\"\u0005\b\u0085\u0002\u0010LR\u0013\u0010\u0093\u0002\u001a\u00020T8F¢\u0006\u0007\u001a\u0005\b\u0093\u0002\u0010UR(\u0010¤\u0002\u001a\u0016\u0012\u0004\u0012\u00020q\u0018\u00010pj\n\u0012\u0004\u0012\u00020q\u0018\u0001`r8F¢\u0006\b\u001a\u0006\b¥\u0002\u0010¦\u0002¨\u0006É\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "Lcom/samsung/android/support/senl/nt/stt/contract/STTPresenterContract;", "Lcom/samsung/android/support/senl/nt/stt/base/listener/ChooseLanguageDialogListener;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertViewChangedListener;", "Lcom/samsung/android/support/senl/nt/stt/base/listener/ChooseVoiceItemDialogListener;", "mActivity", "Landroid/app/Activity;", "voiceDataList", "", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "mTranscribeFromType", "", "floatingController", "Lcom/samsung/android/support/senl/nt/stt/controller/STTFloatingController;", "getFloatingController", "()Lcom/samsung/android/support/senl/nt/stt/controller/STTFloatingController;", "voiceDataController", "Lcom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController;", "getVoiceDataController", "()Lcom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController;", "mSTTVoiceItemList", "", "Lcom/samsung/android/support/senl/nt/stt/view/STTVoiceItem;", "mSTTReplayData", "Lcom/samsung/android/support/senl/nt/stt/base/model/STTReplayData;", "mPaintHelper", "Lcom/samsung/android/support/senl/nt/stt/base/model/paint/PaintHelper;", "mCurrentTextDataList", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "getMCurrentTextDataList", "()Ljava/util/List;", "setMCurrentTextDataList", "(Ljava/util/List;)V", "mCurrentSpeakerNameMap", "", "", "getMCurrentSpeakerNameMap", "()Ljava/util/Map;", "setMCurrentSpeakerNameMap", "(Ljava/util/Map;)V", "mCurrentParagraphInfo", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiParagraphInfo;", "getMCurrentParagraphInfo", "setMCurrentParagraphInfo", "value", "Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "currentMode", "getCurrentMode", "()Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "mSelectedVoiceToConvertList", "mSTTSettingLanguageDialogFragment", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment;", "mSTTSelectTranscribeDialogFragment", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSelectTranscribeDialogFragment;", "mRemoveTranscribeConfirmDialog", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog;", "mRemoveTranscribeConfirmPresenter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "getMRemoveTranscribeConfirmPresenter", "()Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "setMRemoveTranscribeConfirmPresenter", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;)V", "mDialogCreator", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDialogCreator;", "mCancelDialog", "Landroidx/appcompat/app/AlertDialog;", "mTotalTimeConvert", "", "mItemIndexToShow", "mCurrentSessionIDAutoTranscribe", "itemIndexPreShowSearch", "getItemIndexPreShowSearch", "()I", "setItemIndexPreShowSearch", "(I)V", "currentConvertSession", "getCurrentConvertSession", "()Ljava/lang/String;", "mAiMenuSTTProcessListenerHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/presenter/AiMenuSTTProcessListener;", "isNeedSummaryAgain", "", "()Z", "setNeedSummaryAgain", "(Z)V", "mTranscriptToOtherLanguage", "mRealtimeVoiceItem", "mLanguagePackSelectedReceiver", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackSelectedReceiver;", "mLanguagePackAddedReceiver", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackAddedReceiver;", "mLanguagePackRemovedReceiver", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackRemovedReceiver;", "mSTTSearchPresenter", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTSearchPresenter;", "mLastLanguageTranscribe", "mLastSelectedLanguage", "mOnSavedInstanceState", "mIsTranslateSTTFirstTime", "getMIsTranslateSTTFirstTime", "setMIsTranslateSTTFirstTime", "mIsTranslateSTTSummarizationFirstTime", "getMIsTranslateSTTSummarizationFirstTime", "setMIsTranslateSTTSummarizationFirstTime", "reloadActivity", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onSTTDataChanged", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "speakerNameMap", "", "speakerIDs", "", "startTimes", "", "endTimes", "onWordTouch", "touchedWordTimestamp", "onSTTDataSaved", "updateReplayData", "replayTexts", "", "timeStamp", "([Ljava/lang/String;[I)V", "getSyncSTTItem", "syncSTT", "voiceItemIndex", "initSTTVoiceList", "resetSTTViewToDefault", "showTabletVoiceList", "updateSTTReplayStart", "voiceData", "updateSTTReplayStop", "updateSTTReplayComplete", "updateSTTReplay", "position", "showHelpView", "showAutoDetectHelpView", "messageTranscriptToOtherLanguage", "hideHelpView", "showInfoView", "hideInfoView", "toggleSTTEditMode", "toggleSTTSelectionMode", "isTranscriptTab", "toggleSTTSelectAllItem", "isSelectedAll", "getVoiceListBySearch", "searchText", "toggleSTTSearchMode", "clearSTTSearchComposerMode", "showCancelDialog", "hideCancelDialog", "checkDataChanged", "saveSTTData", "isUpdated", "setMode", "mode", "isSTTRecordMode", "isSTTReplayMode", "isSTTEditMode", "isSTTSearchMode", "isFocusingSTTEditMode", "onSTTItemCheckedChange", "isChecked", "isComposerSearchMode", "isSelectionMode", "isSelectionSummaryMode", "currentVoiceItemSelectedText", "getCurrentVoiceItemSelectedText", "deleteSelectedTextData", "isShowSpeakerLabel", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "showSettingLanguageDialog", "executeTranscribeAgain", "showLanguageDialog", "isEnableAutoDetect", "setTranscriptToOtherLanguage", "transcriptToOtherLanguage", "getShowSpeakerLabel", "setShowSpeakerLabel", "dismissSelectLanguageDialog", "removeSettingLanguageDialog", "onUpdateListVoiceBtnState", "isEnabled", "onUpdateMoveBtnState", "onSeekToSTTTouchedWord", "voiceIndex", "currentPlayingTime", "updateVoiceSync", "getVoiceDataList", "setVoiceDataList", "onVoiceDataListChange", "onDialogClickedConvertButton", "showRecordingPlayView", "showRealtimeTranscribe", "getDocumentPath", "onSearchDone", Bixby2Constants.BIXBY_PARAM_KEYWORD, "onChangedBackgroundColor", "color", "invert", "hasBackgroundImage", "playingIndex", "playingPosition", "setSavedInstanceState", "onSavedInstanceState", "isSavedInstanceState", "getVoiceIndexFromConvertSession", "sessionID", "notifyFastConvertStatusChanged", "state", "error", "errorCode", "updateItemAfterConvertDone", "updateItem", "putLastDetectLanguage", "notifyFastConvertProgressUpdated", "percent", "onNoLangPackInstalled", "locale", "Ljava/util/Locale;", "requestDownloadLanguagePack", "localeTag", "onLocaleChanged", "onNoMatch", "onDialogClickConvertButton", "proceedDialogClickConvertButton", "releaseSettingDialogFragment", "onDialogClickTranscribeButton", "showOrExecuteSTTVoiceItem", "index", "startFastConvertService", "voiceName", "sessionId", "onDialogClickCancelButton", "onDialogClickAddLanguageButton", "cancelTranscribe", "cancelAutoTranscribe", "releaseAutoTranscribe", "getSTTCurrentVoiceItemAdapterText", "isContainHeader", "currentVoiceItemText", "getCurrentVoiceItemText", "currentSTTVoiceName", "getCurrentSTTVoiceName", "originalSTTListView", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "getOriginalSTTListView", "()Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "indexItemToShow", "getIndexItemToShow", "setIndexItemToShow", "getCurrentVoiceName", "updateConvertVoiceList", "selectedVoiceList", "onSTTItemConvertClick", "voiceItemAdapterIndex", "onEditTextChanged", "string", "pos", "onTextDataListChanged", "onSpeakerNameMapChanged", "onParagraphInfoChanged", "paragraphInfoList", "getSTTPresenter", "isTranscriptToOtherLanguage", "reConvertCurrentItem", "isTranscriptAgain", "updateLastLanguageTranscribe", "cancelCurrentConvertSession", "addAiMenuSTTProcessListener", "aiMenuSTTProcessListener", "removeAiMenuSTTProcessListener", "onSTTConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isOrientationChanged", "notifySTTItemChanged", "onDestroy", "registerReceiver", "unregisterReceiver", "isItemSTTConverting", "currentShowingTextDataList", "getCurrentShowingTextDataList", "()Ljava/util/ArrayList;", "removeDataFromFile", "isTranscribeAgain", "onCompleted", "Lkotlin/Function0;", "showRemoveTranscribeDialog", "showDialogFragment", "dialog", "Landroidx/fragment/app/DialogFragment;", "tag", "executeTranscribeDialog", "dismissTranscribeDialog", "setTranscribeFromType", "transcribeFromType", "onVoiceDataChanged", "spenVoiceData", "changeType", "handleAutoTranscribeOnError", "message", "getRealtimeLanguage", "setRealtimeLanguageSettings", "updateRealtimeView", "recordingItem", "onRecordStop", "saveRealtimeData", "getSTTSearchPresenter", "getSessionIDAutoTranscribe", "isAutoTranscribeItemRunning", "setAutoTranscribeRealtimeData", "realTimeResultData", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "getRecordRecognizer", "Lcom/samsung/android/support/senl/nt/stt/base/record/RecordRecognizer;", "IConvertListener", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({WarningType.NewApi})
@SourceDebugExtension({"SMAP\nSTTPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTPresenter.kt\ncom/samsung/android/support/senl/nt/stt/presenter/STTPresenter\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2099:1\n216#2,2:2100\n216#2,2:2102\n216#2,2:2104\n216#2,2:2106\n216#2,2:2108\n216#2,2:2110\n216#2,2:2112\n216#2,2:2114\n216#2,2:2116\n216#2,2:2118\n216#2,2:2120\n216#2,2:2122\n216#2,2:2124\n216#2,2:2126\n216#2,2:2128\n216#2,2:2130\n216#2,2:2132\n216#2,2:2135\n216#2,2:2137\n216#2,2:2139\n216#2,2:2141\n216#2,2:2143\n216#2,2:2145\n216#2,2:2147\n216#2,2:2149\n1#3:2134\n*S KotlinDebug\n*F\n+ 1 STTPresenter.kt\ncom/samsung/android/support/senl/nt/stt/presenter/STTPresenter\n*L\n199#1:2100,2\n284#1:2102,2\n289#1:2104,2\n380#1:2106,2\n384#1:2108,2\n388#1:2110,2\n396#1:2112,2\n400#1:2114,2\n404#1:2116,2\n431#1:2118,2\n525#1:2120,2\n551#1:2122,2\n859#1:2124,2\n898#1:2126,2\n905#1:2128,2\n996#1:2130,2\n1017#1:2132,2\n1069#1:2135,2\n1321#1:2137,2\n1534#1:2139,2\n1852#1:2141,2\n1951#1:2143,2\n2037#1:2145,2\n978#1:2147,2\n1656#1:2149,2\n*E\n"})
public abstract class STTPresenter implements STTPresenterContract, ChooseLanguageDialogListener, FastConvertController.FastConvertViewChangedListener, ChooseVoiceItemDialogListener {

    @NotNull
    private static final String EMPTY = "";

    @NotNull
    private static final String STT_REMOVE_TRANSCRIPT_TAG = "RemoveTranscriptConfirmDialog";

    @NotNull
    private static final String STT_SELECT_TRANSCRIBE_TAG = "STTSelectTranscribeDialogFragment";

    @NotNull
    private static final String STT_SETTING_LANGUAGE_DIALOG_TAG = "STTSettingLanguageDialogFragment";

    @NotNull
    private static final String TAG = "STTPresenter";

    @Nullable
    private final View container;

    @Nullable
    private String currentConvertSession;

    @NotNull
    private STTMode currentMode;

    @NotNull
    private final STTFloatingController floatingController;
    private boolean isNeedSummaryAgain;
    private int itemIndexPreShowSearch;

    @Nullable
    private Activity mActivity;

    @NotNull
    private final ConcurrentHashMap<Integer, AiMenuSTTProcessListener> mAiMenuSTTProcessListenerHashMap;

    @Nullable
    private AlertDialog mCancelDialog;

    @Nullable
    private List<AiParagraphInfo> mCurrentParagraphInfo;

    @NotNull
    private String mCurrentSessionIDAutoTranscribe;

    @Nullable
    private Map<Integer, String> mCurrentSpeakerNameMap;

    @Nullable
    private List<AiTextData> mCurrentTextDataList;

    @NotNull
    private final DialogContract.IDialogCreator mDialogCreator;
    private boolean mIsTranslateSTTFirstTime;
    private boolean mIsTranslateSTTSummarizationFirstTime;
    private int mItemIndexToShow;

    @NotNull
    private final AiLanguageHelper.STTLanguagePackAddedReceiver mLanguagePackAddedReceiver;

    @NotNull
    private final AiLanguageHelper.STTLanguagePackRemovedReceiver mLanguagePackRemovedReceiver;

    @NotNull
    private final AiLanguageHelper.STTLanguagePackSelectedReceiver mLanguagePackSelectedReceiver;

    @NotNull
    private final ConcurrentHashMap<String, String> mLastLanguageTranscribe;

    @Nullable
    private String mLastSelectedLanguage;
    private boolean mOnSavedInstanceState;

    @NotNull
    private final PaintHelper mPaintHelper;

    @Nullable
    private STTVoiceItem mRealtimeVoiceItem;

    @Nullable
    private RemoveTranscriptConfirmDialog mRemoveTranscribeConfirmDialog;

    @NotNull
    private DialogContract.IRemoveConfirmDialogPresenter mRemoveTranscribeConfirmPresenter;

    @Nullable
    private STTReplayData mSTTReplayData;

    @Nullable
    private final STTSearchPresenter mSTTSearchPresenter;

    @Nullable
    private STTSelectTranscribeDialogFragment mSTTSelectTranscribeDialogFragment;

    @Nullable
    private STTSettingLanguageDialogFragment mSTTSettingLanguageDialogFragment;

    @NotNull
    private final List<STTVoiceItem> mSTTVoiceItemList;

    @NotNull
    private final List<SpenVoiceData> mSelectedVoiceToConvertList;
    private long mTotalTimeConvert;
    private int mTranscribeFromType = 2;
    private boolean mTranscriptToOtherLanguage;

    @NotNull
    private final STTVoiceDataController voiceDataController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter$IConvertListener;", "", "pressCancelTranscribeInNotification", "", "sessionID", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IConvertListener {
        void pressCancelTranscribeInNotification(@Nullable String sessionID);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.STTPresenter$onVoiceDataChanged$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J>\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J>\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, m13886d2 = {"com/samsung/android/support/senl/nt/stt/presenter/STTPresenter$onVoiceDataChanged$1", "Lcom/samsung/android/support/senl/nt/stt/base/listener/STTRecognizeListener;", "onError", "", "sessionID", "", "errorCode", "", "message", "onResultWord", "recognizeText", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isNeedGetRawText", "", "onPartialResultWord", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSTTPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTPresenter.kt\ncom/samsung/android/support/senl/nt/stt/presenter/STTPresenter$onVoiceDataChanged$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,2099:1\n216#2,2:2100\n*S KotlinDebug\n*F\n+ 1 STTPresenter.kt\ncom/samsung/android/support/senl/nt/stt/presenter/STTPresenter$onVoiceDataChanged$1\n*L\n1789#1:2100,2\n*E\n"})
    public static final class C115141 implements STTRecognizeListener {
        final /* synthetic */ RecordRecognizer $recordRecognizer;
        final /* synthetic */ SpenVoiceData $spenVoiceData;

        public C115141(RecordRecognizer recordRecognizer, SpenVoiceData spenVoiceData) {
            this.$recordRecognizer = recordRecognizer;
            this.$spenVoiceData = spenVoiceData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResultWord$lambda$1(STTPresenter sTTPresenter, String str, SpenVoiceData spenVoiceData, FastConvertResultData fastConvertResultData) {
            if (sTTPresenter.mItemIndexToShow >= 0) {
                int i = sTTPresenter.mItemIndexToShow;
                List<SpenVoiceData> voiceDataList = sTTPresenter.getVoiceDataList();
                if (i < (voiceDataList != null ? voiceDataList.size() : -1)) {
                    int i2 = sTTPresenter.mItemIndexToShow;
                    List<SpenVoiceData> voiceDataList2 = sTTPresenter.getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList2);
                    Logger.m12710d(STTPresenter.TAG, "saveRealtimeData#mItemIndexToShow " + i2 + " #" + voiceDataList2.get(sTTPresenter.mItemIndexToShow).getMHandle());
                    if (sTTPresenter.isAutoTranscribeItemRunning()) {
                        List<SpenVoiceData> voiceDataList3 = sTTPresenter.getVoiceDataList();
                        Intrinsics.checkNotNull(voiceDataList3);
                        sTTPresenter.updateRealtimeView(voiceDataList3.get(sTTPresenter.mItemIndexToShow));
                    }
                    String name = spenVoiceData.getName();
                    STTVoiceItem sTTVoiceItem = sTTPresenter.mRealtimeVoiceItem;
                    StringBuilder sbM16m = AbstractC0000a.m16m("saveRealtimeDataFinal# sessionID: ", str, " name = ", name, " mRealtimeVoiceItem = ");
                    sbM16m.append(sTTVoiceItem);
                    sbM16m.append(" realtimeResultData = ");
                    sbM16m.append(fastConvertResultData);
                    Logger.m12710d(STTPresenter.TAG, sbM16m.toString());
                    List<SpenVoiceData> voiceDataList4 = sTTPresenter.getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList4);
                    if (Intrinsics.areEqual(String.valueOf(voiceDataList4.get(sTTPresenter.mItemIndexToShow).getMHandle()), str)) {
                        sTTPresenter.hideHelpView();
                        sTTPresenter.mSTTVoiceItemList.clear();
                        List list = sTTPresenter.mSTTVoiceItemList;
                        STTVoiceItem sTTVoiceItem2 = sTTPresenter.mRealtimeVoiceItem;
                        Intrinsics.checkNotNull(sTTVoiceItem2);
                        list.add(sTTVoiceItem2);
                        sTTPresenter.getFloatingController().onVoiceItemInit(sTTPresenter.mRealtimeVoiceItem);
                        Iterator it = sTTPresenter.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            AiMenuSTTProcessListener aiMenuSTTProcessListener = (AiMenuSTTProcessListener) ((Map.Entry) it.next()).getValue();
                            if (aiMenuSTTProcessListener != null) {
                                aiMenuSTTProcessListener.onVoiceInfoChanged();
                            }
                        }
                    }
                }
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.STTRecognizeListener
        public void onError(String sessionID, int errorCode, String message) {
            Logger.m12710d(STTPresenter.TAG, "Realtime errorCode: " + errorCode + " message: " + message);
            STTPresenter.this.saveRealtimeData(sessionID);
            STTPresenter.this.handleAutoTranscribeOnError(sessionID, errorCode, message);
            STTPresenter.this.releaseAutoTranscribe(sessionID);
        }

        @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.STTRecognizeListener
        public void onPartialResultWord(String sessionID, String recognizeText, int[] timingInfo, List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText) {
            String str;
            int[] iArr;
            List<? extends SpeechInfo> list;
            List<SpenVoiceData> voiceDataList = STTPresenter.this.getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            int size = voiceDataList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                List<SpenVoiceData> voiceDataList2 = STTPresenter.this.getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                if (Intrinsics.areEqual(String.valueOf(voiceDataList2.get(i).getMHandle()), sessionID)) {
                    List<SpenVoiceData> voiceDataList3 = STTPresenter.this.getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList3);
                    StringBuilder sbM16m = AbstractC0000a.m16m("onPartialResultWord# sessionID: ", sessionID, " name = ", voiceDataList3.get(i).getName(), " i = ");
                    sbM16m.append(i);
                    Logger.m12710d(STTPresenter.TAG, sbM16m.toString());
                    break;
                }
                i++;
            }
            if (i >= 0) {
                List<SpenVoiceData> voiceDataList4 = STTPresenter.this.getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList4);
                if (i < voiceDataList4.size()) {
                    List<SpenVoiceData> voiceDataList5 = STTPresenter.this.getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList5);
                    SpenVoiceData spenVoiceData = voiceDataList5.get(i);
                    RecordRecognizer recordRecognizer = STTPresenter.this.getRecordRecognizer(sessionID);
                    FastConvertResultData autoTranscribeResultData = recordRecognizer != null ? recordRecognizer.getAutoTranscribeResultData() : null;
                    if (autoTranscribeResultData == null) {
                        str = recognizeText;
                        iArr = timingInfo;
                        list = speechInfoList;
                        autoTranscribeResultData = new FastConvertResultData(str, iArr, list, false, isNeedGetRawText);
                    } else {
                        str = recognizeText;
                        iArr = timingInfo;
                        list = speechInfoList;
                    }
                    autoTranscribeResultData.setTextResult(str);
                    Intrinsics.checkNotNull(iArr);
                    autoTranscribeResultData.setTimeInfo(iArr);
                    autoTranscribeResultData.setFinal(false);
                    autoTranscribeResultData.setSpeechInfoList(list);
                    STTPresenter.this.setAutoTranscribeRealtimeData(sessionID, autoTranscribeResultData);
                    STTPresenter.this.updateRealtimeView(spenVoiceData);
                    Logger.m12710d(STTPresenter.TAG, "onPartialResultWord# recognizeText: " + str);
                    return;
                }
            }
            Logger.m12711e(STTPresenter.TAG, "onPartialResultWord out of bound");
        }

        @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.STTRecognizeListener
        public void onResultWord(String sessionID, String recognizeText, int[] timingInfo, List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText) {
            Logger.m12710d(STTPresenter.TAG, "onResultWord# recognizeText: " + recognizeText + ", sessionID: " + sessionID);
            FastConvertResultData fastConvertResultData = new FastConvertResultData(recognizeText, timingInfo, speechInfoList, true, isNeedGetRawText);
            Logger.m12710d(STTPresenter.TAG, "saveRealtimeDataFinal#");
            STTPresenter.this.setAutoTranscribeRealtimeData(sessionID, fastConvertResultData);
            STTPresenter.this.saveRealtimeData(sessionID);
            Activity activity = STTPresenter.this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new RunnableC0218a(STTPresenter.this, sessionID, this.$spenVoiceData, fastConvertResultData, 19));
            }
            this.$recordRecognizer.stopVoiceRecognition();
            this.$recordRecognizer.release();
        }
    }

    public STTPresenter(@Nullable Activity activity, @Nullable List<SpenVoiceData> list) {
        this.mActivity = activity;
        STTFloatingController sTTFloatingController = new STTFloatingController(this.mActivity, this);
        this.floatingController = sTTFloatingController;
        this.voiceDataController = new STTVoiceDataController(list);
        this.mSTTVoiceItemList = new ArrayList();
        this.mPaintHelper = new PaintHelper(this.mActivity);
        this.currentMode = STTMode.REPLAY;
        this.mSelectedVoiceToConvertList = new ArrayList();
        this.mRemoveTranscribeConfirmPresenter = new STTPresenter$mRemoveTranscribeConfirmPresenter$1(this);
        this.mDialogCreator = new DialogCreator();
        this.mItemIndexToShow = -1;
        this.mCurrentSessionIDAutoTranscribe = "";
        this.itemIndexPreShowSearch = -1;
        this.mAiMenuSTTProcessListenerHashMap = new ConcurrentHashMap<>();
        this.mLanguagePackSelectedReceiver = new AiLanguageHelper.STTLanguagePackSelectedReceiver();
        this.mLanguagePackAddedReceiver = new AiLanguageHelper.STTLanguagePackAddedReceiver() { // from class: com.samsung.android.support.senl.nt.stt.presenter.STTPresenter$mLanguagePackAddedReceiver$1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.STTLanguagePackAddedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                STTLanguageManager.INSTANCE.getInstance().initLanguageData();
            }
        };
        this.mLanguagePackRemovedReceiver = new AiLanguageHelper.STTLanguagePackRemovedReceiver() { // from class: com.samsung.android.support.senl.nt.stt.presenter.STTPresenter$mLanguagePackRemovedReceiver$1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.STTLanguagePackRemovedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                STTLanguageManager.INSTANCE.getInstance().initLanguageData();
                if (intent == null || !intent.hasExtra("locale")) {
                    return;
                }
                String defaultLocaleTag = STTLanguageHelper.getDefaultLocaleTag();
                String stringExtra = intent.getStringExtra("locale");
                Logger.m12710d("STTPresenter", "STTLanguagePackRemovedReceiver : removed " + stringExtra);
                if (defaultLocaleTag == null || !Intrinsics.areEqual(defaultLocaleTag, stringExtra)) {
                    return;
                }
                STTLanguageHelper.setDefaultLocaleTag(null);
                Logger.m12710d("STTPresenter", "STTLanguagePackRemovedReceiver : setDefaultLocaleTag to null");
            }
        };
        this.mLastLanguageTranscribe = new ConcurrentHashMap<>();
        this.mIsTranslateSTTFirstTime = true;
        this.mIsTranslateSTTSummarizationFirstTime = true;
        initSTTVoiceList(list);
        registerReceiver(this.mActivity);
        this.mSTTSearchPresenter = new STTSearchPresenter(this);
        this.container = sTTFloatingController.sttContainer;
    }

    private final void executeTranscribeAgain() {
        STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = this.mSTTSettingLanguageDialogFragment;
        if (sTTSettingLanguageDialogFragment != null) {
            sTTSettingLanguageDialogFragment.dismiss();
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, "");
        if (!isEnableAutoDetect()) {
            showLanguageDialog();
        } else {
            Logger.m12710d(TAG, "executeTranscribeAgain : use AutoDetectLanguage feature");
            onDialogClickConvertButton();
        }
    }

    private final int getVoiceIndexFromConvertSession(String sessionID) {
        if (sessionID != null && getVoiceDataList() != null) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            int size = voiceDataList.size();
            for (int i = 0; i < size; i++) {
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                if (Intrinsics.areEqual(sessionID, ConvertUtils.getSessionID(voiceDataList2.get(i)))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAutoTranscribeOnError(String sessionID, int errorCode, String message) {
        String defaultLocaleTag;
        if (errorCode == 10 || errorCode == 14) {
            Locale realtimeLanguage = getRealtimeLanguage();
            if (realtimeLanguage == null || (defaultLocaleTag = realtimeLanguage.toLanguageTag()) == null) {
                defaultLocaleTag = STTLanguageHelper.getDefaultLocaleTag();
            }
            if (defaultLocaleTag != null) {
                requestDownloadLanguagePack(defaultLocaleTag);
            }
        }
    }

    private final void hideCancelDialog() {
        AlertDialog alertDialog = this.mCancelDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.mCancelDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDialogClickConvertButton$lambda$31(STTPresenter sTTPresenter) {
        sTTPresenter.proceedDialogClickConvertButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSTTDataChanged$lambda$0(STTPresenter sTTPresenter, boolean z) {
        if (z) {
            sTTPresenter.onVoiceDataListChange(sTTPresenter.mItemIndexToShow);
            sTTPresenter.isNeedSummaryAgain = true;
            sTTPresenter.onSTTDataSaved();
        }
    }

    private final void proceedDialogClickConvertButton() {
        FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        companion.registerListener(this);
        if (companion.isAutoTranscribeConverting(this.mCurrentSessionIDAutoTranscribe)) {
            Logger.m12710d(TAG, "onDialogClickConvertButton, isAutoTranscribeItemRunning = true");
            STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = this.mSTTSettingLanguageDialogFragment;
            String selectedLocale = sTTSettingLanguageDialogFragment != null ? sTTSettingLanguageDialogFragment.getSelectedLocale() : null;
            Locale localeForLanguageTag = selectedLocale != null ? Locale.forLanguageTag(selectedLocale) : null;
            setRealtimeLanguageSettings(localeForLanguageTag != null ? localeForLanguageTag.toLanguageTag() : null);
            releaseAutoTranscribe(this.mCurrentSessionIDAutoTranscribe);
            return;
        }
        this.mTranscriptToOtherLanguage = isTranscriptToOtherLanguage();
        if (!isEnableAutoDetect() || this.mTranscriptToOtherLanguage) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            String sessionID = ConvertUtils.getSessionID(voiceDataList.get(getMItemIndexToShow()));
            String str = sessionID != null ? this.mLastLanguageTranscribe.get(sessionID) : null;
            STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment2 = this.mSTTSettingLanguageDialogFragment;
            String selectedLocale2 = sTTSettingLanguageDialogFragment2 != null ? sTTSettingLanguageDialogFragment2.getSelectedLocale() : null;
            if (selectedLocale2 != null && selectedLocale2.length() != 0) {
                if (sessionID != null) {
                    this.mLastLanguageTranscribe.put(sessionID, selectedLocale2);
                }
                this.mLastSelectedLanguage = selectedLocale2;
                str = selectedLocale2;
            }
            Logger.m12713i(TAG, "proceedDialogClickConvertButton selected language: " + ((Object) str));
            STTLanguageManager companion2 = STTLanguageManager.INSTANCE.getInstance();
            LanguageInfo languageInfo = companion2.getLanguageInfo(str);
            if (languageInfo != null && !companion2.isLangPackInstalled(languageInfo.getLangPackage())) {
                Activity activity = this.mActivity;
                if (activity == null) {
                    Logger.m12711e(TAG, "proceedDialogClickConvertButton# : mActivity = null");
                    return;
                } else {
                    Toast.makeText(activity, activity != null ? activity.getString(C11493R.string.langpack_is_not_available, companion2.getLanguageDisplayName(str)) : null, 0).show();
                    return;
                }
            }
            Locale localeForLanguageTag2 = Locale.forLanguageTag(str);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, localeForLanguageTag2.getDisplayName());
            companion.setConvertLocale(localeForLanguageTag2);
            companion.setEnableAutoDetect(false);
        } else {
            companion.setEnableAutoDetect(true);
        }
        if (this.mSelectedVoiceToConvertList.size() > 0) {
            Logger.m12710d(TAG, "proceedDialogClickConvertButton: action from selected voice list");
            for (SpenVoiceData spenVoiceData : this.mSelectedVoiceToConvertList) {
                companion.addFastConvertItem(spenVoiceData, true);
                String name = spenVoiceData.getName();
                Intrinsics.checkNotNull(name);
                startFastConvertService(name, ConvertUtils.getSessionID(spenVoiceData));
            }
            this.mSelectedVoiceToConvertList.clear();
        } else {
            Logger.m12710d(TAG, "proceedDialogClickConvertButton: action from stt button");
            if (getVoiceDataList() != null) {
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                for (SpenVoiceData spenVoiceData2 : voiceDataList2) {
                    companion.addFastConvertItem(spenVoiceData2, false);
                    String name2 = spenVoiceData2.getName();
                    Intrinsics.checkNotNull(name2);
                    startFastConvertService(name2, ConvertUtils.getSessionID(spenVoiceData2));
                }
            }
        }
        this.mTotalTimeConvert = System.currentTimeMillis();
        onDialogClickedConvertButton();
        releaseSettingDialogFragment();
    }

    private final void putLastDetectLanguage(String sessionID, SpenVoiceData updateItem) {
        String str;
        if (sessionID == null) {
            return;
        }
        this.mLastLanguageTranscribe.remove(sessionID);
        String sessionID2 = ConvertUtils.getSessionID(updateItem);
        if (sessionID2 == null || sessionID2.length() == 0 || (str = this.mLastSelectedLanguage) == null) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.mLastLanguageTranscribe;
        Intrinsics.checkNotNull(str);
        concurrentHashMap.put(sessionID2, str);
    }

    private final void registerReceiver(Activity activity) {
        AiLanguageHelper.registerLanguagePackSelectedReceiver(activity, this.mLanguagePackSelectedReceiver);
        AiLanguageHelper.registerLanguagePackAddedReceiver(activity, this.mLanguagePackAddedReceiver);
        AiLanguageHelper.registerLanguagePackRemovedReceiver(activity, this.mLanguagePackRemovedReceiver);
    }

    private final void releaseSettingDialogFragment() {
        STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = this.mSTTSettingLanguageDialogFragment;
        if (sTTSettingLanguageDialogFragment != null) {
            sTTSettingLanguageDialogFragment.setDialogListener(null);
        }
        this.mSTTSettingLanguageDialogFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDataFromFile(boolean isTranscribeAgain, Function0<Unit> onCompleted) {
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        SpenVoiceData spenVoiceData = voiceDataList != null ? voiceDataList.get(this.mItemIndexToShow) : null;
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        this.voiceDataController.removeSTTVoiceData(getDocumentPath(), spenVoiceData, new C11523b(this, ConvertUtils.getSessionID(voiceDataList2 != null ? voiceDataList2.get(this.mItemIndexToShow) : null), onCompleted, isTranscribeAgain));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDataFromFile$lambda$44(boolean z, STTPresenter sTTPresenter, String str, Function0 function0, boolean z2) {
        if (z2) {
            if (z) {
                List<SpenVoiceData> voiceDataList = sTTPresenter.getVoiceDataList();
                String sessionID = ConvertUtils.getSessionID(voiceDataList != null ? voiceDataList.get(sTTPresenter.mItemIndexToShow) : null);
                String str2 = sTTPresenter.mLastLanguageTranscribe.get(str);
                if (str2 != null) {
                    sTTPresenter.mLastLanguageTranscribe.remove(str);
                    sTTPresenter.mLastLanguageTranscribe.put(sessionID, str2);
                }
            }
            sTTPresenter.onVoiceDataListChange(sTTPresenter.mItemIndexToShow);
            sTTPresenter.isNeedSummaryAgain = true;
            Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = sTTPresenter.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
            while (it.hasNext()) {
                AiMenuSTTProcessListener value = it.next().getValue();
                if (value != null) {
                    value.onSTTDataSaved();
                }
            }
        }
        sTTPresenter.cancelCurrentConvertSession();
        sTTPresenter.setIndexItemToShow(sTTPresenter.mItemIndexToShow);
        function0.invoke();
    }

    private final void removeSettingLanguageDialog() {
        Logger.m12713i(TAG, "removeSettingLanguageDialog");
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = (STTSettingLanguageDialogFragment) supportFragmentManager.findFragmentByTag(STT_SETTING_LANGUAGE_DIALOG_TAG);
            if (sTTSettingLanguageDialogFragment != null) {
                sTTSettingLanguageDialogFragment.setDialogListener(null);
                supportFragmentManager.beginTransaction().remove(sTTSettingLanguageDialogFragment).commitAllowingStateLoss();
            }
        }
    }

    private final void requestDownloadLanguagePack(String localeTag) {
        Logger.m12713i(TAG, "request download language pack : " + localeTag);
        AiLanguageHelper.setManageSTTLanguageActivity(AiLanguageHelper.getRequestDownloadLanguageName(localeTag));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveRealtimeData$lambda$54(SpenVoiceData spenVoiceData, STTPresenter sTTPresenter, Ref.IntRef intRef, Ref.ObjectRef objectRef, boolean z) {
        String name = spenVoiceData.getName();
        String attachedFile = spenVoiceData.getAttachedFile();
        StringBuilder sbM2229t = AbstractC2821a.m2229t("saveRealtimeData#saveDataToSpenVoice ", name, " realtimeSaved: ", z, " file: ");
        sbM2229t.append(attachedFile);
        Logger.m12710d(TAG, sbM2229t.toString());
        sTTPresenter.releaseAutoTranscribe(String.valueOf(spenVoiceData.getMHandle()));
        sTTPresenter.notifySTTItemChanged(intRef.element);
        sTTPresenter.onVoiceDataListChange(intRef.element);
        sTTPresenter.mRealtimeVoiceItem = null;
        objectRef.element = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveRealtimeData$lambda$56$lambda$55(STTPresenter sTTPresenter, AiMenuSTTProcessListener aiMenuSTTProcessListener, Ref.IntRef intRef) {
        sTTPresenter.showTabletVoiceList();
        aiMenuSTTProcessListener.updateRealtimeCompleteView();
        sTTPresenter.onVoiceDataListChange(intRef.element);
    }

    private final void setRealtimeLanguageSettings(String localeTag) {
        Logger.m12710d(TAG, "setRealtimeLanguageSettings# localeTag = " + localeTag);
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, localeTag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [androidx.appcompat.app.AlertDialog$Builder] */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    private final void showCancelDialog() {
        Window window;
        Resources resources;
        Resources resources2;
        Resources resources3;
        Logger.m12713i(TAG, "showCancelDialog#");
        if (this.mActivity == null || this.mCancelDialog != null) {
            return;
        }
        ?? string = 0;
        string = 0;
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivity, 0, 2, string);
        Activity activity = this.mActivity;
        alertDialogBuilderForAppCompat.setMessage(activity != null ? activity.getString(C11493R.string.base_string_popup_ask_save) : null);
        Activity activity2 = this.mActivity;
        final int i = 0;
        AlertDialog.Builder positiveButton = alertDialogBuilderForAppCompat.setPositiveButton((activity2 == null || (resources3 = activity2.getResources()) == null) ? null : resources3.getString(C11493R.string.base_string_save_type1), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.presenter.e

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTPresenter f7895b;

            {
                this.f7895b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        STTPresenter.showCancelDialog$lambda$11(this.f7895b, dialogInterface, i2);
                        break;
                    default:
                        STTPresenter.showCancelDialog$lambda$12(this.f7895b, dialogInterface, i2);
                        break;
                }
            }
        });
        Activity activity3 = this.mActivity;
        final int i2 = 1;
        ?? negativeButton = positiveButton.setNegativeButton((activity3 == null || (resources2 = activity3.getResources()) == null) ? null : resources2.getString(C11493R.string.string_discard), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.presenter.e

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTPresenter f7895b;

            {
                this.f7895b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        STTPresenter.showCancelDialog$lambda$11(this.f7895b, dialogInterface, i22);
                        break;
                    default:
                        STTPresenter.showCancelDialog$lambda$12(this.f7895b, dialogInterface, i22);
                        break;
                }
            }
        });
        Activity activity4 = this.mActivity;
        if (activity4 != null && (resources = activity4.getResources()) != null) {
            string = resources.getString(C11493R.string.base_string_cancel_type3);
        }
        negativeButton.setNeutralButton(string, new DialogInterfaceOnClickListenerC11527f());
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.stt.presenter.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f7896a.mCancelDialog = null;
            }
        });
        alertDialogBuilderForAppCompat.setCancelable(true);
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mCancelDialog = alertDialogCreate;
        if (alertDialogCreate != null && (window = alertDialogCreate.getWindow()) != null) {
            window.setType(ContinuityCommand.CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER);
        }
        AlertDialog alertDialog = this.mCancelDialog;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.stt.presenter.h
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                    return STTPresenter.showCancelDialog$lambda$15(this.f7897a, dialogInterface, i4, keyEvent);
                }
            });
        }
        AlertDialog alertDialog2 = this.mCancelDialog;
        if (alertDialog2 != null) {
            alertDialog2.setCanceledOnTouchOutside(true);
        }
        AlertDialog alertDialog3 = this.mCancelDialog;
        if (alertDialog3 != null) {
            alertDialog3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$11(STTPresenter sTTPresenter, DialogInterface dialogInterface, int i) {
        sTTPresenter.saveSTTData(true);
        sTTPresenter.toggleSTTEditMode();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$12(STTPresenter sTTPresenter, DialogInterface dialogInterface, int i) {
        sTTPresenter.saveSTTData(false);
        sTTPresenter.toggleSTTEditMode();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showCancelDialog$lambda$15(STTPresenter sTTPresenter, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Logger.m12713i(TAG, "onKey# " + keyEvent.getKeyCode());
        if (keyEvent.getKeyCode() != 4 && keyEvent.getKeyCode() != 3) {
            return false;
        }
        AlertDialog alertDialog = sTTPresenter.mCancelDialog;
        Intrinsics.checkNotNull(alertDialog);
        alertDialog.dismiss();
        return true;
    }

    private final void showDialogFragment(DialogFragment dialog, String tag) {
        Activity activity;
        if (dialog == null || (activity = this.mActivity) == null) {
            return;
        }
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentManager childFragmentManager = supportFragmentManager.getFragments().get(0).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        childFragmentManager.beginTransaction().add(dialog, tag).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    private final void startFastConvertService(String voiceName, String sessionId) {
        Logger.m12713i(TAG, "startVoiceService");
        if (sessionId == null) {
            Logger.m12713i(TAG, "startFastConvertService : session id = null");
        } else {
            FastConvertService.INSTANCE.startService(this.mActivity, new IConvertListener() { // from class: com.samsung.android.support.senl.nt.stt.presenter.STTPresenter.startFastConvertService.1
                @Override // com.samsung.android.support.senl.nt.stt.presenter.STTPresenter.IConvertListener
                public void pressCancelTranscribeInNotification(String sessionID) {
                    STTPresenter.this.cancelTranscribe(sessionID);
                }
            }, voiceName, sessionId);
        }
    }

    public static /* synthetic */ void toggleSTTSelectionMode$default(STTPresenter sTTPresenter, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleSTTSelectionMode");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        sTTPresenter.toggleSTTSelectionMode(z);
    }

    private final void unregisterReceiver(Activity activity) {
        AiLanguageHelper.unregisterLanguagePackReceiver(activity, this.mLanguagePackSelectedReceiver);
        AiLanguageHelper.unregisterLanguagePackReceiver(activity, this.mLanguagePackAddedReceiver);
        AiLanguageHelper.unregisterLanguagePackReceiver(activity, this.mLanguagePackRemovedReceiver);
    }

    private final void updateItemAfterConvertDone(final SpenVoiceData updateItem, final String sessionID, final int voiceIndex) {
        final FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        FastConvertResultData fastConvertResultData = companion.getFastConvertResultData(sessionID);
        String textResult = fastConvertResultData != null ? fastConvertResultData.getTextResult() : null;
        int[] timingInfo = fastConvertResultData != null ? fastConvertResultData.getTimingInfo() : null;
        final List<SpeechInfo> speechInfoList = fastConvertResultData != null ? fastConvertResultData.getSpeechInfoList() : null;
        boolean z = fastConvertResultData != null && fastConvertResultData.getMIsNeedGetRawText();
        final STTRecognitionData sTTRecognitionData = new STTRecognitionData();
        if (textResult != null && textResult.length() != 0) {
            sTTRecognitionData.updateRecognitionData(textResult, timingInfo, speechInfoList, true, z);
        }
        final String str = textResult;
        final boolean z2 = z;
        this.voiceDataController.saveDataToSpenVoice(getDocumentPath(), updateItem, sTTRecognitionData.getListText(), sTTRecognitionData.getListTime(), speechInfoList, new HashMap(), new STTUpdateDataTask.Callback() { // from class: com.samsung.android.support.senl.nt.stt.presenter.c
            @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
            public final void onFinished(boolean z3) {
                STTPresenter.updateItemAfterConvertDone$lambda$25(this.f7884a, voiceIndex, str, sessionID, sTTRecognitionData, speechInfoList, z2, updateItem, companion, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateItemAfterConvertDone$lambda$25(STTPresenter sTTPresenter, int i, String str, String str2, STTRecognitionData sTTRecognitionData, List list, boolean z, SpenVoiceData spenVoiceData, FastConvertController fastConvertController, boolean z2) {
        sTTPresenter.onVoiceDataListChange(i);
        String processingString = (str == null || str.length() == 0) ? "" : STTDataHelper.getProcessingString(str);
        if (sTTPresenter.mItemIndexToShow >= 0 && !sTTPresenter.mSTTVoiceItemList.isEmpty() && Intrinsics.areEqual(str2, sTTPresenter.currentConvertSession)) {
            sTTPresenter.mSTTVoiceItemList.get(0).setText(sTTRecognitionData.getListText());
            sTTPresenter.mSTTVoiceItemList.get(0).setTextDataList(STTDataHelper.getTextData(processingString, sTTRecognitionData.getListTime(), list, true, z));
            sTTPresenter.mSTTVoiceItemList.get(0).setRecognizeResult(sTTPresenter.mPaintHelper.getNormalPaintedString(processingString));
            sTTPresenter.mSTTVoiceItemList.get(0).setTimeStamp(sTTRecognitionData.getListTime());
            sTTPresenter.mSTTVoiceItemList.get(0).setParagraphInfo(new ArrayList<>());
            sTTPresenter.floatingController.onItemChanged(0);
        }
        Logger.m12713i(TAG, "FastConvert " + spenVoiceData.getName() + " done");
        if (fastConvertController.isConvertDone()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - sTTPresenter.mTotalTimeConvert;
            sTTPresenter.mTotalTimeConvert = jCurrentTimeMillis;
            Logger.m12713i(TAG, "FastConvert done: total Time: " + jCurrentTimeMillis + "ms");
            NotesSamsungAnalytics.INSTANCE.insertLog("816", STTConstant.EVENT_TRANSCRIBE_TIME, String.valueOf(spenVoiceData.getRecordingTime() / ((long) 1000)));
        }
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = sTTPresenter.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onCompleted(str2);
            }
        }
        sTTPresenter.putLastDetectLanguage(str2, spenVoiceData);
        ConvertUtils.cleanSTTCacheFolder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRealtimeView(SpenVoiceData recordingItem) {
        Activity activity;
        RecordRecognizer recordRecognizer = getRecordRecognizer(String.valueOf(recordingItem.getMHandle()));
        FastConvertResultData autoTranscribeResultData = recordRecognizer != null ? recordRecognizer.getAutoTranscribeResultData() : null;
        if (autoTranscribeResultData == null) {
            Logger.m12710d(TAG, "updateRealtimeView# resultDataBySessionID = null");
            return;
        }
        String textResult = autoTranscribeResultData.getTextResult();
        int[] timingInfo = autoTranscribeResultData.getTimingInfo();
        List<SpeechInfo> speechInfoList = autoTranscribeResultData.getSpeechInfoList();
        boolean zIsmIsNeedGetRawText = autoTranscribeResultData.getMIsNeedGetRawText();
        STTRecognitionData sTTRecognitionData = new STTRecognitionData();
        sTTRecognitionData.updateRecognitionData(textResult, timingInfo, speechInfoList, true, zIsmIsNeedGetRawText);
        StringBuilder sbM780v = AbstractC0541b.m780v("updateRealtimeView#: ", recordingItem.getMHandle(), recordingItem.getName(), " sessionID = ", " realtimeResultData = ");
        sbM780v.append(textResult);
        Logger.m12710d(TAG, sbM780v.toString());
        String processingString = textResult != null ? STTDataHelper.getProcessingString(textResult) : "";
        String name = recordingItem.getName();
        Intrinsics.checkNotNull(name);
        STTVoiceItem sTTVoiceItem = new STTVoiceItem(name, recordingItem.getPlayTime());
        this.mRealtimeVoiceItem = sTTVoiceItem;
        Intrinsics.checkNotNull(sTTVoiceItem);
        sTTVoiceItem.setText(sTTRecognitionData.getListText());
        STTVoiceItem sTTVoiceItem2 = this.mRealtimeVoiceItem;
        Intrinsics.checkNotNull(sTTVoiceItem2);
        sTTVoiceItem2.setTextDataList(STTDataHelper.getTextData(processingString, timingInfo, speechInfoList, true, zIsmIsNeedGetRawText));
        if (sTTRecognitionData.getListText().length != 0) {
            int length = processingString.length() - sTTRecognitionData.getListText()[sTTRecognitionData.getListText().length - 1].length();
            STTVoiceItem sTTVoiceItem3 = this.mRealtimeVoiceItem;
            Intrinsics.checkNotNull(sTTVoiceItem3);
            sTTVoiceItem3.setRecognizeResult(this.mPaintHelper.getRealtimePaintedString(processingString, length, processingString.length()).toString());
        }
        STTVoiceItem sTTVoiceItem4 = this.mRealtimeVoiceItem;
        Intrinsics.checkNotNull(sTTVoiceItem4);
        sTTVoiceItem4.setTimeStamp(timingInfo);
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null && (activity = this.mActivity) != null) {
                Intrinsics.checkNotNull(activity);
                activity.runOnUiThread(new RunnableC8928b(this, 21, recordingItem, value));
                Logger.m12710d(TAG, "updateRealtimeView# partial result: " + recordingItem.getName() + " processedString: " + ((Object) processingString));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRealtimeView$lambda$53$lambda$52(STTPresenter sTTPresenter, SpenVoiceData spenVoiceData, AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        int i = sTTPresenter.mItemIndexToShow;
        if (i >= 0) {
            List<SpenVoiceData> voiceDataList = sTTPresenter.getVoiceDataList();
            if (i < (voiceDataList != null ? voiceDataList.size() : -1)) {
                int i2 = sTTPresenter.mItemIndexToShow;
                List<SpenVoiceData> voiceDataList2 = sTTPresenter.getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                int mHandle = voiceDataList2.get(sTTPresenter.mItemIndexToShow).getMHandle();
                int mHandle2 = spenVoiceData.getMHandle();
                String name = spenVoiceData.getName();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, mHandle, "updateRealtimeView#mItemIndexToShow ", " #", " #");
                sbM1173s.append(mHandle2);
                sbM1173s.append(" name = ");
                sbM1173s.append(name);
                Logger.m12710d(TAG, sbM1173s.toString());
                List<SpenVoiceData> voiceDataList3 = sTTPresenter.getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList3);
                if (voiceDataList3.get(sTTPresenter.mItemIndexToShow).getMHandle() == spenVoiceData.getMHandle()) {
                    sTTPresenter.hideHelpView();
                    sTTPresenter.mSTTVoiceItemList.clear();
                    List<STTVoiceItem> list = sTTPresenter.mSTTVoiceItemList;
                    STTVoiceItem sTTVoiceItem = sTTPresenter.mRealtimeVoiceItem;
                    Intrinsics.checkNotNull(sTTVoiceItem);
                    list.add(sTTVoiceItem);
                    sTTPresenter.floatingController.onVoiceItemInit(sTTPresenter.mRealtimeVoiceItem);
                    aiMenuSTTProcessListener.updateAutoTranscribeView();
                }
            }
        }
    }

    private final void updateReplayData(String[] replayTexts, int[] timeStamp) {
        if (this.mSTTReplayData == null) {
            this.mSTTReplayData = new STTReplayData();
        }
        STTReplayData sTTReplayData = this.mSTTReplayData;
        Intrinsics.checkNotNull(sTTReplayData);
        sTTReplayData.updateReplayData(replayTexts, timeStamp);
    }

    public final void addAiMenuSTTProcessListener(int index, @NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        Intrinsics.checkNotNullParameter(aiMenuSTTProcessListener, "aiMenuSTTProcessListener");
        this.mAiMenuSTTProcessListenerHashMap.put(Integer.valueOf(index), aiMenuSTTProcessListener);
    }

    public final void cancelAutoTranscribe(@Nullable String sessionID) {
        Logger.m12710d(TAG, "cancelAutoTranscribe " + sessionID);
        releaseAutoTranscribe(sessionID);
        showHelpView();
    }

    public final void cancelCurrentConvertSession() {
        if (this.currentConvertSession == null) {
            return;
        }
        FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        companion.removeConvertItem(this.currentConvertSession);
        companion.cancelFastConvert(this.currentConvertSession);
        this.currentConvertSession = null;
    }

    public final void cancelTranscribe() {
        Logger.m12710d(TAG, "cancelTranscribe");
        int mItemIndexToShow = getMItemIndexToShow();
        cancelCurrentConvertSession();
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        String sessionID = ConvertUtils.getSessionID(voiceDataList.get(getMItemIndexToShow()));
        Locale locale = AiLanguageHelper.getLocale(sessionID != null ? this.mLastLanguageTranscribe.get(sessionID) : null);
        String displayName = locale != null ? locale.getDisplayName() : null;
        setIndexItemToShow(mItemIndexToShow);
        Activity activity = this.mActivity;
        String string = activity != null ? activity.getString(C11493R.string.ai_stt_transcribe_into_language_button_text, displayName) : null;
        if (!isEnableAutoDetect() || displayName == null || displayName.length() == 0) {
            showHelpView();
        } else {
            showAutoDetectHelpView(string);
        }
    }

    public final void checkDataChanged() {
        if (this.floatingController.isDataChanged()) {
            showCancelDialog();
        } else {
            saveSTTData(false);
            toggleSTTEditMode();
        }
    }

    public final void clearSTTSearchComposerMode() {
        AiSTTListView sttListView = this.floatingController.getSttListView();
        if (sttListView != null) {
            sttListView.scrollToLastPosition();
        }
        STTSearchPresenter sTTSearchPresenter = this.mSTTSearchPresenter;
        if (sTTSearchPresenter != null) {
            sTTSearchPresenter.clearSearchInfo();
        }
        setMode(STTMode.REPLAY);
    }

    public final void deleteSelectedTextData() {
        AiSTTListView sttListView;
        if (!isSelectionMode() || (sttListView = this.floatingController.getSttListView()) == null) {
            return;
        }
        sttListView.deleteSelectedItem();
    }

    public final void dismissSelectLanguageDialog() {
        STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = this.mSTTSettingLanguageDialogFragment;
        if (sTTSettingLanguageDialogFragment != null) {
            sTTSettingLanguageDialogFragment.dismiss();
        }
    }

    public final void dismissTranscribeDialog() {
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
        if (sTTSelectTranscribeDialogFragment != null) {
            sTTSelectTranscribeDialogFragment.dismiss();
        }
    }

    public final void executeTranscribeDialog() {
        setTranscribeFromType(1);
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        if (voiceDataList != null && voiceDataList.size() == 1) {
            Logger.m12710d(TAG, "executeTranscribeDialog size = 1");
            showRecordingPlayView();
            showOrExecuteSTTVoiceItem(0);
            return;
        }
        if (this.mSTTSelectTranscribeDialogFragment == null) {
            STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = new STTSelectTranscribeDialogFragment(getVoiceDataList());
            this.mSTTSelectTranscribeDialogFragment = sTTSelectTranscribeDialogFragment;
            Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment);
            sTTSelectTranscribeDialogFragment.setDialogListener(this);
        }
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment2 = this.mSTTSelectTranscribeDialogFragment;
        Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment2);
        sTTSelectTranscribeDialogFragment2.clearState();
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment3 = this.mSTTSelectTranscribeDialogFragment;
        Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment3);
        sTTSelectTranscribeDialogFragment3.notifyDatasetChanged();
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentManager childFragmentManager = supportFragmentManager.getFragments().get(0).getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment4 = this.mSTTSelectTranscribeDialogFragment;
            Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment4);
            if (!sTTSelectTranscribeDialogFragment4.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment5 = this.mSTTSelectTranscribeDialogFragment;
                Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment5);
                fragmentTransactionBeginTransaction.add(sTTSelectTranscribeDialogFragment5, STT_SELECT_TRANSCRIBE_TAG).commitAllowingStateLoss();
            }
            childFragmentManager.executePendingTransactions();
        }
    }

    @Nullable
    public final View getContainer() {
        return this.container;
    }

    @Nullable
    public final String getCurrentConvertSession() {
        return this.currentConvertSession;
    }

    @NotNull
    public final STTMode getCurrentMode() {
        return this.currentMode;
    }

    @Nullable
    public final String getCurrentSTTVoiceName() {
        if (this.mItemIndexToShow < 0 || getVoiceDataList() == null) {
            return null;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        if (voiceDataList.isEmpty()) {
            return null;
        }
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList2);
        return voiceDataList2.get(this.mItemIndexToShow).getName();
    }

    @Nullable
    public final ArrayList<TextData> getCurrentShowingTextDataList() {
        int i;
        if (getVoiceDataList() == null || (i = this.mItemIndexToShow) < 0) {
            return null;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        if (i >= voiceDataList.size()) {
            return null;
        }
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList2);
        SpenVoiceData spenVoiceData = voiceDataList2.get(this.mItemIndexToShow);
        return STTDataHelper.getTextData(this.voiceDataController.getVoiceText(spenVoiceData), this.voiceDataController.getVoiceTime(spenVoiceData), this.voiceDataController.getVoiceSpeakerID(spenVoiceData));
    }

    @Nullable
    public final String getCurrentVoiceItemSelectedText() {
        AiSTTListView sttListView;
        if (!isSelectionMode() || (sttListView = this.floatingController.getSttListView()) == null) {
            return null;
        }
        return sttListView.getCurrentVoiceItemSelectedText();
    }

    @Nullable
    public final String getCurrentVoiceItemText() {
        AiSTTListView sttListView = this.floatingController.getSttListView();
        if (sttListView != null) {
            return sttListView.getSTTCurrentVoiceItemText(true);
        }
        return null;
    }

    @NotNull
    public final String getCurrentVoiceName(int position) {
        SpenVoiceData spenVoiceData;
        String name;
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        return (voiceDataList == null || (spenVoiceData = voiceDataList.get(position)) == null || (name = spenVoiceData.getName()) == null) ? "" : name;
    }

    @Nullable
    public abstract String getDocumentPath();

    @NotNull
    public final STTFloatingController getFloatingController() {
        return this.floatingController;
    }

    /* JADX INFO: renamed from: getIndexItemToShow, reason: from getter */
    public final int getMItemIndexToShow() {
        return this.mItemIndexToShow;
    }

    public final int getItemIndexPreShowSearch() {
        return this.itemIndexPreShowSearch;
    }

    @Nullable
    public final List<AiParagraphInfo> getMCurrentParagraphInfo() {
        return this.mCurrentParagraphInfo;
    }

    @Nullable
    public final Map<Integer, String> getMCurrentSpeakerNameMap() {
        return this.mCurrentSpeakerNameMap;
    }

    @Nullable
    public final List<AiTextData> getMCurrentTextDataList() {
        return this.mCurrentTextDataList;
    }

    public final boolean getMIsTranslateSTTFirstTime() {
        return this.mIsTranslateSTTFirstTime;
    }

    public final boolean getMIsTranslateSTTSummarizationFirstTime() {
        return this.mIsTranslateSTTSummarizationFirstTime;
    }

    @NotNull
    public final DialogContract.IRemoveConfirmDialogPresenter getMRemoveTranscribeConfirmPresenter() {
        return this.mRemoveTranscribeConfirmPresenter;
    }

    @Nullable
    public final AiSTTListView getOriginalSTTListView() {
        return this.floatingController.getSttListView();
    }

    @Nullable
    public final Locale getRealtimeLanguage() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
        companion.initLanguageData();
        Logger.m12710d(TAG, "timeToInitLanguageData # " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms ");
        String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, "");
        Logger.m12710d(TAG, "getRealtimeLanguage# languageFromSettings = " + string);
        Locale localeForLanguageTag = string != null ? Locale.forLanguageTag(string) : null;
        LanguageInfo languageInfo = companion.getLanguageInfo(localeForLanguageTag != null ? localeForLanguageTag.toLanguageTag() : null);
        if (languageInfo != null && !companion.isLangPackInstalled(languageInfo.getLangPackage())) {
            return null;
        }
        Logger.m12710d(TAG, "getRealtimeLanguage# languageFromSettings is downloaded");
        if (string != null) {
            return Locale.forLanguageTag(string);
        }
        return null;
    }

    @Nullable
    public final RecordRecognizer getRecordRecognizer(@Nullable String sessionID) {
        Context applicationContext;
        if (sessionID == null || (applicationContext = BaseUtils.getApplicationContext()) == null) {
            return null;
        }
        return RecordRecognizer.INSTANCE.getInstance(applicationContext, sessionID);
    }

    @Nullable
    public final String getSTTCurrentVoiceItemAdapterText(boolean isContainHeader) {
        AiSTTListView sttListView = this.floatingController.getSttListView();
        if (sttListView != null) {
            return sttListView.getSTTCurrentVoiceItemText(isContainHeader);
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getSTTSearchPresenter, reason: from getter */
    public final STTSearchPresenter getMSTTSearchPresenter() {
        return this.mSTTSearchPresenter;
    }

    @Nullable
    public final String getSessionIDAutoTranscribe() {
        int i = this.mItemIndexToShow;
        if (i < 0) {
            return "";
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        if (i > voiceDataList.size()) {
            return "";
        }
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList2);
        return String.valueOf(voiceDataList2.get(this.mItemIndexToShow).getMHandle());
    }

    public final boolean getShowSpeakerLabel() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_STT_SHOW_SPEAKER_LABEL, true);
    }

    public final int getSyncSTTItem(long timeStamp) {
        if (getVoiceDataList() == null) {
            return -1;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        Logger.m12713i(TAG, "getSyncSTTItem " + voiceDataList.size() + " timeStamp " + timeStamp);
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList2);
        int size = voiceDataList2.size();
        for (int i = 0; i < size; i++) {
            List<SpenVoiceData> voiceDataList3 = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList3);
            SpenVoiceData spenVoiceData = voiceDataList3.get(i);
            long recordingTime = spenVoiceData.getRecordingTime();
            String playTime = spenVoiceData.getPlayTime();
            long creationTime = spenVoiceData.getCreationTime();
            StringBuilder sbM2225p = AbstractC2821a.m2225p(recordingTime, "getSyncSTTItem item time ", "// ", playTime);
            sbM2225p.append("// ");
            sbM2225p.append(creationTime);
            Logger.m12710d(TAG, sbM2225p.toString());
            if (timeStamp >= spenVoiceData.getCreationTime()) {
                if (timeStamp < spenVoiceData.getRecordingTime() + spenVoiceData.getCreationTime()) {
                    Logger.m12710d(TAG, "getSyncSTTItem matched " + spenVoiceData.getName() + "// " + i);
                    return i;
                }
            }
        }
        return -1;
    }

    @NotNull
    public final STTVoiceDataController getVoiceDataController() {
        return this.voiceDataController;
    }

    @Nullable
    public abstract List<SpenVoiceData> getVoiceDataList();

    @Nullable
    public final ArrayList<Integer> getVoiceListBySearch(@Nullable String searchText) {
        if (searchText == null || getVoiceDataList() == null) {
            return null;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        return STTDataUtils.getVoiceListBySearch(searchText, voiceDataList);
    }

    public final void hideHelpView() {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.hideHelpView();
            }
        }
    }

    public final void hideInfoView() {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.hideInfoView();
            }
        }
    }

    public final void initSTTVoiceList(@Nullable List<SpenVoiceData> voiceDataList) {
        if (this.mItemIndexToShow < 0) {
            return;
        }
        this.mSTTVoiceItemList.clear();
        if (voiceDataList == null) {
            Logger.m12710d(TAG, "initSTTVoiceList# voiceDataList = null");
            return;
        }
        SpenVoiceData spenVoiceData = voiceDataList.get(this.mItemIndexToShow);
        String name = spenVoiceData.getName();
        Intrinsics.checkNotNull(name);
        if (spenVoiceData.getPlayTime() == null || spenVoiceData.getAttachedFile() == null) {
            return;
        }
        String playTime = spenVoiceData.getPlayTime();
        Intrinsics.checkNotNull(playTime);
        String[] voiceText = this.voiceDataController.getVoiceText(spenVoiceData);
        int[] voiceTime = this.voiceDataController.getVoiceTime(spenVoiceData);
        long[] paragraphStartTimes = this.voiceDataController.getParagraphStartTimes(spenVoiceData);
        long[] paragraphEndTimes = this.voiceDataController.getParagraphEndTimes(spenVoiceData);
        int[] paragraphSpeakerIDs = this.voiceDataController.getParagraphSpeakerIDs(spenVoiceData);
        Logger.m12710d(TAG, "initSTTVoiceList item=" + name + "/" + playTime);
        STTVoiceItem sTTVoiceItem = new STTVoiceItem(name, playTime);
        String processingString = voiceText != null ? STTDataHelper.getProcessingString(voiceText) : "";
        int[] voiceSpeakerID = this.voiceDataController.getVoiceSpeakerID(spenVoiceData);
        sTTVoiceItem.setText(voiceText);
        sTTVoiceItem.setTextDataList(STTDataHelper.getTextData(voiceText, voiceTime, voiceSpeakerID));
        sTTVoiceItem.setSpeakerMap(this.voiceDataController.getSpeakerNameMap(spenVoiceData));
        sTTVoiceItem.setRecognizeResult(this.mPaintHelper.getNormalPaintedString(processingString));
        sTTVoiceItem.setTimeStamp(voiceTime);
        sTTVoiceItem.setParagraphInfo(paragraphSpeakerIDs, paragraphStartTimes, paragraphEndTimes);
        this.mSTTVoiceItemList.add(sTTVoiceItem);
        this.floatingController.onVoiceItemInit(sTTVoiceItem);
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onVoiceInfoChanged();
            }
        }
        AbstractC11014a.m12327l(this.mSTTVoiceItemList.size(), "initSTTVoiceList. ", TAG);
    }

    public final boolean isAutoTranscribeItemRunning() {
        Logger.m12710d(TAG, "isAutoTranscribeItemRunning");
        return FastConvertController.INSTANCE.getInstance().isAutoTranscribeConverting(getSessionIDAutoTranscribe());
    }

    public final boolean isComposerSearchMode() {
        return STTMode.SEARCH_COMPOSER == this.currentMode;
    }

    public final boolean isEnableAutoDetect() {
        return Features.isSupportSTTAutoDetectLanguage() && SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, true);
    }

    public final boolean isFocusingSTTEditMode() {
        Logger.m12713i(TAG, "isFocusingSTTEditMode: " + this.floatingController.isFocusingSTTEditMode());
        if (isSTTEditMode()) {
            return this.floatingController.isFocusingSTTEditMode() || this.floatingController.isShowingSpeakerRenameDialog();
        }
        return false;
    }

    public final boolean isItemSTTConverting(int index) {
        if (getVoiceDataList() == null || index < 0) {
            return false;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        if (index >= voiceDataList.size()) {
            return false;
        }
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList2);
        return FastConvertController.INSTANCE.getInstance().isConverting(ConvertUtils.getSessionID(voiceDataList2.get(index)));
    }

    /* JADX INFO: renamed from: isNeedSummaryAgain, reason: from getter */
    public final boolean getIsNeedSummaryAgain() {
        return this.isNeedSummaryAgain;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public boolean isSTTEditMode() {
        return STTMode.EDIT == this.currentMode;
    }

    public final boolean isSTTRecordMode() {
        return STTMode.RECORD == this.currentMode;
    }

    public final boolean isSTTReplayMode() {
        return STTMode.REPLAY == this.currentMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public boolean isSTTSearchMode() {
        return STTMode.SEARCH == this.currentMode;
    }

    /* JADX INFO: renamed from: isSavedInstanceState, reason: from getter */
    public final boolean getMOnSavedInstanceState() {
        return this.mOnSavedInstanceState;
    }

    public final boolean isSelectionMode() {
        return STTMode.SELECTION == this.currentMode;
    }

    public final boolean isSelectionSummaryMode() {
        return STTMode.SELECTION_SUMMARY == this.currentMode;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public boolean isShowSpeakerLabel() {
        return getShowSpeakerLabel();
    }

    public final boolean isTranscriptToOtherLanguage() {
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        String sessionID = ConvertUtils.getSessionID(voiceDataList.get(getMItemIndexToShow()));
        if (sessionID == null) {
            Logger.m12711e(TAG, "isTranscriptToOtherLanguage# current session id = null");
            return false;
        }
        String str = this.mLastLanguageTranscribe.get(sessionID);
        if (str == null || str.length() == 0) {
            Logger.m12713i(TAG, "isTranscriptToOtherLanguage# sessionID = " + sessionID + " auto-detect language mode");
            return false;
        }
        Logger.m12713i(TAG, "isTranscriptToOtherLanguage# sessionID = " + sessionID + " selected language or last language used to transcribe");
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void notifyFastConvertProgressUpdated(@Nullable String sessionID, int percent) {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onConverting(sessionID, percent);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void notifyFastConvertStatusChanged(@Nullable String sessionID, int state, @Nullable String error, int errorCode) {
        String string;
        FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        if (state == 15 || state == 16) {
            companion.removeConvertItem(sessionID);
        }
        String str = this.currentConvertSession;
        if (str != null && !Intrinsics.areEqual(str, sessionID)) {
            String str2 = this.currentConvertSession;
            int iHashCode = hashCode();
            StringBuilder sbM16m = AbstractC0000a.m16m("notifyFastConvertStatusChanged multiple item convert sessionID ", sessionID, "/", str2, " ");
            sbM16m.append(iHashCode);
            Logger.m12710d(TAG, sbM16m.toString());
        }
        switch (state) {
            case 11:
                ConvertUtils.cleanSTTCacheFolder();
                Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    AiMenuSTTProcessListener value = it.next().getValue();
                    if (value != null) {
                        value.onConverting(sessionID, -1);
                    }
                }
                break;
            case 12:
                Activity activity = this.mActivity;
                if (activity != null) {
                    if (activity == null || (string = activity.getString(C11493R.string.wait_for_your_other_recordings_to_be_transcribed)) == null) {
                        string = "";
                    }
                    ToastHandler.show(activity, string, 0);
                } else {
                    Logger.m12711e(TAG, "notifyFastConvertStatusChanged# CONVERT_DONE: mActivity = null");
                }
                break;
            case 15:
                int voiceIndexFromConvertSession = getVoiceIndexFromConvertSession(sessionID);
                if (voiceIndexFromConvertSession >= 0) {
                    List<SpenVoiceData> voiceDataList = getVoiceDataList();
                    SpenVoiceData spenVoiceData = voiceDataList != null ? voiceDataList.get(voiceIndexFromConvertSession) : null;
                    if (spenVoiceData != null) {
                        updateItemAfterConvertDone(spenVoiceData, sessionID, voiceIndexFromConvertSession);
                    }
                    STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
                    if (sTTSelectTranscribeDialogFragment != null) {
                        sTTSelectTranscribeDialogFragment.notifyDatasetChanged();
                    }
                    companion.release(sessionID);
                } else {
                    AbstractC12991c.m14005z("notifyFastConvertStatusChanged error: not found voice item with session: ", sessionID, TAG);
                }
                break;
            case 16:
                ConvertUtils.cleanSTTCacheFolder();
                Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it2 = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
                while (it2.hasNext()) {
                    AiMenuSTTProcessListener value2 = it2.next().getValue();
                    if (value2 != null) {
                        value2.onFailed(sessionID, error, errorCode);
                    }
                }
                Logger.m12713i(TAG, "FastConvert " + sessionID + " CONVERT_ERROR");
                break;
            case 17:
                ConvertUtils.cleanSTTCacheFolder();
                Logger.m12713i(TAG, "FastConvert " + sessionID + " CONVERT_CANCELED");
                Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it3 = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
                while (it3.hasNext()) {
                    AiMenuSTTProcessListener value3 = it3.next().getValue();
                    if (value3 != null) {
                        value3.onCancelled(sessionID);
                    }
                }
                break;
        }
    }

    public final void notifySTTItemChanged(int position) {
        if (getVoiceDataList() == null || this.mItemIndexToShow != position || this.mSTTVoiceItemList.isEmpty()) {
            return;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        String name = voiceDataList.get(position).getName();
        Intrinsics.checkNotNull(name);
        this.mSTTVoiceItemList.get(0).setName(name);
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onVoiceInfoChanged();
            }
        }
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
        if (sTTSelectTranscribeDialogFragment != null) {
            sTTSelectTranscribeDialogFragment.notifyDatasetChanged();
        }
    }

    public final void onChangedBackgroundColor(int color, boolean invert, boolean hasBackgroundImage, int playingIndex, int playingPosition) {
        this.floatingController.onBackgroundColorChanged();
        if (this.floatingController.getSttListView() != null && this.mCurrentTextDataList != null) {
            AiSTTListView sttListView = this.floatingController.getSttListView();
            Intrinsics.checkNotNull(sttListView);
            AiSTTListViewAdapter mAiSTTListViewAdapter = sttListView.getMAiSTTListViewAdapter();
            Intrinsics.checkNotNull(mAiSTTListViewAdapter);
            List<AiTextData> list = this.mCurrentTextDataList;
            Intrinsics.checkNotNull(list);
            mAiSTTListViewAdapter.setAiTextDataItemsItem(list);
        }
        if (getVoiceDataList() != null) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            if (voiceDataList.size() <= playingIndex || playingIndex < 0) {
                return;
            }
            StringBuilder sbM2226q = AbstractC2821a.m2226q("onChangedBackgroundColor: color: ", color, " isInvert: ", invert, " hasBGImage: ");
            sbM2226q.append(hasBackgroundImage);
            sbM2226q.append(" playingIndex: ");
            sbM2226q.append(playingIndex);
            sbM2226q.append(" position: ");
            sbM2226q.append(playingPosition);
            Logger.m12713i(TAG, sbM2226q.toString());
            this.mPaintHelper.initSpanColor();
            List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList2);
            SpenVoiceData spenVoiceData = voiceDataList2.get(playingIndex);
            int size = this.mSTTVoiceItemList.size();
            for (int i = 0; i < size; i++) {
                STTVoiceItem sTTVoiceItem = this.mSTTVoiceItemList.get(i);
                String[] text = sTTVoiceItem.getText();
                String processingString = text != null ? STTDataHelper.getProcessingString(text) : "";
                if (i < playingIndex) {
                    sTTVoiceItem.setRecognizeResult(this.mPaintHelper.getPlayPaintedString(processingString, processingString.length()));
                } else {
                    sTTVoiceItem.setRecognizeResult(this.mPaintHelper.getNormalPaintedString(processingString));
                }
                if (Intrinsics.areEqual(sTTVoiceItem.getName(), spenVoiceData.getName())) {
                    updateReplayData(sTTVoiceItem.getText(), sTTVoiceItem.getTimeStamp());
                    if (playingPosition > 0) {
                        playingPosition--;
                    }
                    STTReplayData sTTReplayData = this.mSTTReplayData;
                    if (sTTReplayData != null && sTTReplayData.isUpdateReplayResult(playingPosition)) {
                        PaintHelper paintHelper = this.mPaintHelper;
                        SpannableStringBuilder recognizeResult = sTTVoiceItem.getMRecognizeResult();
                        STTReplayData sTTReplayData2 = this.mSTTReplayData;
                        Intrinsics.checkNotNull(sTTReplayData2);
                        paintHelper.setPlayPaintedString(recognizeResult, sTTReplayData2.getReplayStartCharIndex());
                    }
                }
            }
            this.floatingController.updateBackgroundColor();
            AppCompatActivity appCompatActivity = (AppCompatActivity) this.mActivity;
            if (appCompatActivity != null) {
                List<Fragment> fragments = appCompatActivity.getSupportFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
                if (fragments.isEmpty()) {
                    return;
                }
                FragmentManager childFragmentManager = fragments.get(0).getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(STT_SETTING_LANGUAGE_DIALOG_TAG);
                if (fragmentFindFragmentByTag instanceof STTSettingLanguageDialogFragment) {
                    Logger.m12710d(TAG, "STTSettingLanguageDialogFragment.setDialogListener when dialog recreated");
                    STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = (STTSettingLanguageDialogFragment) fragmentFindFragmentByTag;
                    this.mSTTSettingLanguageDialogFragment = sTTSettingLanguageDialogFragment;
                    sTTSettingLanguageDialogFragment.setDialogListener(this);
                }
                Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag(STT_SELECT_TRANSCRIBE_TAG);
                if (fragmentFindFragmentByTag2 instanceof STTSelectTranscribeDialogFragment) {
                    STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
                    SpenVoiceData selectedVoice = sTTSelectTranscribeDialogFragment != null ? sTTSelectTranscribeDialogFragment.getSelectedVoice() : null;
                    Logger.m12710d(TAG, "STTSelectTranscribeDialogFragment.setDialogListener when dialog recreated");
                    STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment2 = (STTSelectTranscribeDialogFragment) fragmentFindFragmentByTag2;
                    sTTSelectTranscribeDialogFragment2.setSelectedVoice(selectedVoice);
                    List<SpenVoiceData> voiceDataList3 = getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList3);
                    sTTSelectTranscribeDialogFragment2.setVoiceDataList(voiceDataList3);
                    sTTSelectTranscribeDialogFragment2.setDialogListener(this);
                    sTTSelectTranscribeDialogFragment2.notifyDatasetChanged();
                    this.mSTTSelectTranscribeDialogFragment = sTTSelectTranscribeDialogFragment2;
                }
                Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag(STT_REMOVE_TRANSCRIPT_TAG);
                if (fragmentFindFragmentByTag3 instanceof RemoveTranscriptConfirmDialog) {
                    Logger.m12710d(TAG, "RemoveTranscriptConfirmDialog.setPresenter when dialog recreated");
                    RemoveTranscriptConfirmDialog removeTranscriptConfirmDialog = (RemoveTranscriptConfirmDialog) fragmentFindFragmentByTag3;
                    this.mRemoveTranscribeConfirmDialog = removeTranscriptConfirmDialog;
                    removeTranscriptConfirmDialog.setPresenter(this.mRemoveTranscribeConfirmPresenter);
                }
                Fragment fragmentFindFragmentByTag4 = childFragmentManager.findFragmentByTag(DialogConstant.SPEAKER_RENAME_DIALOG);
                if (fragmentFindFragmentByTag4 instanceof SpeakerRenameDialog) {
                    ((SpeakerRenameDialog) fragmentFindFragmentByTag4).dismiss();
                }
            }
        }
    }

    public void onDestroy() {
        STTDialogFactory.destroyListener();
        releaseSettingDialogFragment();
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
        if (sTTSelectTranscribeDialogFragment != null) {
            sTTSelectTranscribeDialogFragment.setDialogListener(null);
        }
        hideCancelDialog();
        removeSettingLanguageDialog();
        FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        companion.unregisterListener(this);
        ConcurrentHashMap<String, Integer> autoTranscribeList = companion.getAutoTranscribeList();
        Activity activity = this.mActivity;
        if (activity != null) {
            if (autoTranscribeList != null) {
                for (String str : autoTranscribeList.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                    String str2 = str;
                    RecordRecognizer.Companion companion2 = RecordRecognizer.INSTANCE;
                    companion2.getInstance(activity, str2).setSTTRecognizeListener(null);
                    companion2.getInstance(activity, str2).release();
                }
            }
            unregisterReceiver(activity);
        }
        ConcurrentHashMap<String, Integer> autoTranscribeList2 = companion.getAutoTranscribeList();
        if (autoTranscribeList2 != null) {
            autoTranscribeList2.clear();
        }
        if (getVoiceDataList() != null) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            Iterator<SpenVoiceData> it = voiceDataList.iterator();
            while (it.hasNext()) {
                String sessionID = ConvertUtils.getSessionID(it.next());
                if (companion.isConverting(sessionID)) {
                    companion.cancelFastConvert(sessionID);
                }
            }
        }
        List<FastConvertController.FastConvertViewChangedListener> registerListener = companion.getRegisterListener();
        if (registerListener != null) {
            Iterator<FastConvertController.FastConvertViewChangedListener> it2 = registerListener.iterator();
            while (it2.hasNext()) {
                if (it2.next() instanceof STTPresenter) {
                    break;
                }
            }
            FastConvertService.INSTANCE.stopService();
        } else {
            FastConvertService.INSTANCE.stopService();
        }
        STTSearchPresenter sTTSearchPresenter = this.mSTTSearchPresenter;
        if (sTTSearchPresenter != null) {
            sTTSearchPresenter.onDestroy();
        }
        this.mActivity = null;
        this.mLastLanguageTranscribe.clear();
        this.mLastSelectedLanguage = null;
        this.mCurrentTextDataList = null;
        this.mCurrentSpeakerNameMap = null;
        this.mCurrentParagraphInfo = null;
        this.mAiMenuSTTProcessListenerHashMap.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseLanguageDialogListener
    public void onDialogClickAddLanguageButton() {
        AiLanguageHelper.gotoSelectSTTLanguageActivity(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseLanguageDialogListener, com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseVoiceItemDialogListener
    public void onDialogClickCancelButton() {
        if (FastConvertController.INSTANCE.getInstance().isAutoTranscribeConverting(this.mCurrentSessionIDAutoTranscribe)) {
            releaseAutoTranscribe(this.mCurrentSessionIDAutoTranscribe);
        }
        releaseSettingDialogFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseLanguageDialogListener
    public void onDialogClickConvertButton() {
        if (getVoiceDataList() != null && getMItemIndexToShow() >= 0) {
            int mItemIndexToShow = getMItemIndexToShow();
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            if (mItemIndexToShow < voiceDataList.size()) {
                if (!this.voiceDataController.isHaveSTTData(this.mItemIndexToShow)) {
                    proceedDialogClickConvertButton();
                    return;
                } else {
                    Logger.m12710d(TAG, "onDialogClickConvertButton current item have STT Data. Need to remove transcript first to proceed later");
                    removeDataFromFile(true, new C11522a(this, 0));
                    return;
                }
            }
        }
        List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
        Logger.m12711e(TAG, "onDialogClickConvertButton indexItemToShow out of bounds, length " + (voiceDataList2 != null ? Integer.valueOf(voiceDataList2.size()) : null));
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseVoiceItemDialogListener
    public void onDialogClickTranscribeButton() {
        if (this.mSTTSelectTranscribeDialogFragment == null || getVoiceDataList() == null) {
            return;
        }
        STTSelectTranscribeDialogFragment sTTSelectTranscribeDialogFragment = this.mSTTSelectTranscribeDialogFragment;
        Intrinsics.checkNotNull(sTTSelectTranscribeDialogFragment);
        SpenVoiceData selectedVoice = sTTSelectTranscribeDialogFragment.getSelectedVoice();
        if (selectedVoice == null) {
            return;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        int iIndexOf = voiceDataList.indexOf(selectedVoice);
        Logger.m12710d(TAG, "onDialogClickTranscribeButton selected voice " + iIndexOf + " " + selectedVoice.getName());
        showRecordingPlayView();
        showOrExecuteSTTVoiceItem(iIndexOf);
    }

    public abstract void onDialogClickedConvertButton();

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onEditTextChanged(@NotNull String string, int pos) {
        Intrinsics.checkNotNullParameter(string, "string");
        List<AiTextData> list = this.mCurrentTextDataList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.isEmpty()) {
                return;
            }
            List<AiTextData> list2 = this.mCurrentTextDataList;
            Intrinsics.checkNotNull(list2);
            AiTextData aiTextData = list2.get(pos);
            Intrinsics.checkNotNull(aiTextData);
            aiTextData.setText(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLocaleChanged(@Nullable String sessionID, @Nullable Locale locale) {
        boolean z;
        String languageTag;
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it;
        Logger.m12713i(TAG, "onLocaleChanged : " + (locale != null ? locale.getLanguage() : null) + " getDisplayLanguage = " + (locale != null ? locale.getDisplayLanguage() : null));
        STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
        companion.initLanguageData();
        LanguageInfo languageInfo = companion.getLanguageInfo(locale != null ? locale.toLanguageTag() : null);
        if (languageInfo == null || companion.isLangPackInstalled(languageInfo.getLangPackage())) {
            if (languageInfo == null) {
                Logger.m12710d(TAG, "locale " + locale + " not supported STT function, select dialog");
                onNoMatch(sessionID);
                z = false;
            }
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, locale == null ? locale.getDisplayName() : null);
            if (locale != null || (languageTag = locale.toLanguageTag()) == null) {
                languageTag = "";
            }
            this.mLastSelectedLanguage = languageTag;
            if (sessionID != null) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.mLastLanguageTranscribe;
                Intrinsics.checkNotNull(languageTag);
                concurrentHashMap.put(sessionID, languageTag);
            }
            it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
            while (it.hasNext()) {
                AiMenuSTTProcessListener value = it.next().getValue();
                if (value != null) {
                    value.onLanguageDetected(locale != null ? locale.getDisplayLanguage() : null);
                }
            }
            if (z) {
                return;
            }
            NotesSamsungAnalytics.INSTANCE.insertLog("816", STTConstant.EVENT_TRANSCRIBE_AUTO_DETECT_LANGUAGE, locale != null ? locale.toLanguageTag() : null);
            return;
        }
        onNoLangPackInstalled(sessionID, locale);
        z = true;
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, locale == null ? locale.getDisplayName() : null);
        if (locale != null) {
            languageTag = "";
        }
        this.mLastSelectedLanguage = languageTag;
        if (sessionID != null) {
        }
        it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
        }
        if (z) {
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void onNoLangPackInstalled(@Nullable String sessionID, @Nullable Locale locale) {
        Activity activity = this.mActivity;
        if (activity == null || locale == null) {
            return;
        }
        String string = activity != null ? activity.getString(C11493R.string.langpack_is_not_available, locale.getDisplayLanguage()) : null;
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        requestDownloadLanguagePack(languageTag);
        Activity activity2 = this.mActivity;
        String string2 = activity2 != null ? activity2.getString(C11493R.string.ai_stt_transcribe_into_language_button_text, locale.getDisplayLanguage()) : null;
        FastConvertController companion = FastConvertController.INSTANCE.getInstance();
        companion.removeConvertItem(sessionID);
        companion.cancelFastConvert(sessionID);
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value == null) {
                notifyFastConvertStatusChanged(sessionID, 16, string, 3);
            } else if (isEnableAutoDetect()) {
                value.showAutoDetectHelpView(sessionID, getMItemIndexToShow(), string2);
            } else {
                value.showHelpView(getMItemIndexToShow());
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void onNoMatch(@Nullable String sessionID) {
        String string;
        cancelTranscribe(sessionID);
        if (Intrinsics.areEqual(sessionID, this.currentConvertSession)) {
            Activity activity = this.mActivity;
            if (activity == null) {
                Logger.m12711e(TAG, "onNoMatch# : mActivity = null");
                return;
            }
            if (activity == null || (string = activity.getString(C11493R.string.stt_can_not_auto_detect_language)) == null) {
                string = "";
            }
            ToastHandler.show(activity, string, 0);
            Locale localeForLanguageTag = Locale.forLanguageTag("");
            Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
            if (sessionID != null) {
                this.mLastLanguageTranscribe.put(sessionID, localeForLanguageTag.toLanguageTag());
            }
            reConvertCurrentItem(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onParagraphInfoChanged(@Nullable List<AiParagraphInfo> paragraphInfoList) {
        this.mCurrentParagraphInfo = paragraphInfoList;
    }

    public final void onRecordStop(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String strValueOf = String.valueOf(spenVoiceData.getMHandle());
        Logger.m12710d(TAG, "onRecordStop#: " + spenVoiceData.getName() + " sessionID = " + strValueOf);
        RecordRecognizer recordRecognizer = getRecordRecognizer(strValueOf);
        if (recordRecognizer != null) {
            recordRecognizer.stopVoiceRecognition();
        }
    }

    public final void onSTTConfigurationChanged(@Nullable Configuration newConfig, boolean isOrientationChanged) {
        this.floatingController.onConfigurationChanged(newConfig, isOrientationChanged);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onSTTDataChanged(@NotNull ArrayList<TextData> textDataList, @NotNull Map<Integer, String> speakerNameMap, @NotNull int[] speakerIDs, @NotNull long[] startTimes, @NotNull long[] endTimes) {
        Intrinsics.checkNotNullParameter(textDataList, "textDataList");
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        Intrinsics.checkNotNullParameter(speakerIDs, "speakerIDs");
        Intrinsics.checkNotNullParameter(startTimes, "startTimes");
        Intrinsics.checkNotNullParameter(endTimes, "endTimes");
        if (getVoiceDataList() == null) {
            return;
        }
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        this.voiceDataController.editSTTVoiceData(getDocumentPath(), voiceDataList != null ? voiceDataList.get(this.mItemIndexToShow) : null, textDataList, speakerNameMap, speakerIDs, startTimes, endTimes, new STTUpdateDataTask.Callback() { // from class: com.samsung.android.support.senl.nt.stt.presenter.d
            @Override // com.samsung.android.support.senl.nt.stt.presenter.STTUpdateDataTask.Callback
            public final void onFinished(boolean z) {
                STTPresenter.onSTTDataChanged$lambda$0(this.f7893a, z);
            }
        });
    }

    public final void onSTTDataSaved() {
        if (isSelectionMode()) {
            setMode(STTMode.REPLAY);
        }
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onSTTDataSaved();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onSTTItemCheckedChange(int position, boolean isChecked) {
        this.floatingController.onSTTItemCheckedChange(position, isChecked);
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onSTTItemCheckedChange(this.floatingController.getSelectedItemMap());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onSTTItemConvertClick(int voiceItemAdapterIndex) {
        String string;
        if (isAutoTranscribeItemRunning()) {
            onDialogClickedConvertButton();
            return;
        }
        if (FastConvertController.INSTANCE.getInstance().isHasItemConverting()) {
            Logger.m12710d(TAG, "onSTTItemConvertClick# " + voiceItemAdapterIndex + " isHasItemConverting true");
            Activity activity = this.mActivity;
            if (activity != null) {
                if (activity == null || (string = activity.getString(C11493R.string.wait_for_your_other_recordings_to_be_transcribed)) == null) {
                    string = "";
                }
                ToastHandler.show(activity, string, 0);
            }
            showHelpView(voiceItemAdapterIndex);
            return;
        }
        if (getVoiceDataList() != null && getMItemIndexToShow() >= 0) {
            int mItemIndexToShow = getMItemIndexToShow();
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            if (mItemIndexToShow < voiceDataList.size()) {
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                SpenVoiceData spenVoiceData = voiceDataList2.get(getMItemIndexToShow());
                this.mSelectedVoiceToConvertList.clear();
                this.mSelectedVoiceToConvertList.add(spenVoiceData);
                this.mTranscriptToOtherLanguage = false;
                updateLastLanguageTranscribe();
                showSettingLanguageDialog();
                return;
            }
        }
        Logger.m12711e(TAG, "onSTTItemConvertClick# position out of bounds");
    }

    public final void onSearchDone(@Nullable String keyword) {
        if (keyword != null) {
            this.mPaintHelper.setSearchKeyWord(keyword);
            int size = this.mSTTVoiceItemList.size();
            for (int i = 0; i < size; i++) {
                this.mPaintHelper.updateSearchHighLight(this.mSTTVoiceItemList.get(i).getMRecognizeResult());
            }
        }
    }

    public abstract void onSeekToSTTTouchedWord(int voiceIndex, long currentPlayingTime);

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onSpeakerNameMapChanged(@NotNull Map<Integer, String> speakerNameMap) {
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        this.mCurrentSpeakerNameMap = speakerNameMap;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onTextDataListChanged(@Nullable List<AiTextData> textDataList) {
        this.mCurrentTextDataList = textDataList;
    }

    public abstract void onUpdateListVoiceBtnState(boolean isEnabled);

    public abstract void onUpdateMoveBtnState();

    public final void onVoiceDataChanged(@NotNull SpenVoiceData spenVoiceData, int changeType) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        if (changeType == 1) {
            String sessionID = ConvertUtils.getSessionID(spenVoiceData);
            FastConvertController companion = FastConvertController.INSTANCE.getInstance();
            boolean zIsConverting = companion.isConverting(sessionID);
            Logger.m12710d(TAG, "onVoiceDataChanged# removed " + spenVoiceData.getName() + " #isConverting " + zIsConverting);
            if (zIsConverting) {
                companion.cancelFastConvert(sessionID);
            }
        }
        if (changeType == 0) {
            Logger.m12710d(TAG, "onVoiceDataChanged# added new item: " + spenVoiceData.getAttachedFile());
            if (Features.isAutoTranscribeEnable()) {
                String strValueOf = String.valueOf(spenVoiceData.getMHandle());
                RecordRecognizer recordRecognizer = getRecordRecognizer(strValueOf);
                FastConvertController.INSTANCE.getInstance().addAutoTranscribeItem(spenVoiceData);
                this.mCurrentSessionIDAutoTranscribe = strValueOf;
                Logger.m12710d(TAG, "onVoiceDataChanged# sessionID: " + strValueOf + " name = " + spenVoiceData.getName());
                if (recordRecognizer != null) {
                    recordRecognizer.setSTTRecognizeListener(new C115141(recordRecognizer, spenVoiceData));
                }
                Locale realtimeLanguage = getRealtimeLanguage();
                if (realtimeLanguage != null) {
                    if (recordRecognizer != null) {
                        recordRecognizer.setLocale(realtimeLanguage);
                    }
                    if (recordRecognizer != null) {
                        recordRecognizer.startVoiceRecognition();
                    }
                } else {
                    Logger.m12710d(TAG, "getRealtimeLanguage# realtimeLanguage = null");
                    releaseAutoTranscribe(String.valueOf(spenVoiceData.getMHandle()));
                }
            }
        }
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.onVoiceInfoChanged();
            }
        }
    }

    public abstract void onVoiceDataListChange(int voiceIndex);

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onWordTouch(int touchedWordTimestamp) {
        AbstractC11014a.m12327l(touchedWordTimestamp, "onWordTouch = ", TAG);
        updateVoiceSync(this.mItemIndexToShow);
        onSeekToSTTTouchedWord(this.mItemIndexToShow, touchedWordTimestamp);
    }

    public final void reConvertCurrentItem(boolean isTranscriptAgain) {
        String string;
        if (getVoiceDataList() != null && getMItemIndexToShow() >= 0) {
            int mItemIndexToShow = getMItemIndexToShow();
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            if (mItemIndexToShow < voiceDataList.size()) {
                if (FastConvertController.INSTANCE.getInstance().isHasItemConverting()) {
                    Logger.m12710d(TAG, "reConvertCurrentItem#  isHasItemConverting true");
                    Activity activity = this.mActivity;
                    if (activity != null) {
                        if (activity == null || (string = activity.getString(C11493R.string.wait_for_your_other_recordings_to_be_transcribed)) == null) {
                            string = "";
                        }
                        ToastHandler.show(activity, string, 0);
                        return;
                    }
                    return;
                }
                updateLastLanguageTranscribe();
                this.mTranscriptToOtherLanguage = isTranscriptToOtherLanguage();
                Logger.m12710d(TAG, "Transcribe again#reConvertCurrentItem: " + isTranscriptAgain);
                this.mSelectedVoiceToConvertList.clear();
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                SpenVoiceData spenVoiceData = voiceDataList2.get(getMItemIndexToShow());
                this.currentConvertSession = ConvertUtils.getSessionID(spenVoiceData);
                this.mSelectedVoiceToConvertList.add(spenVoiceData);
                if (isTranscriptAgain) {
                    executeTranscribeAgain();
                    return;
                } else {
                    this.mTranscriptToOtherLanguage = true;
                    showSettingLanguageDialog();
                    return;
                }
            }
        }
        Logger.m12711e(TAG, "reConvertCurrentItem# position out of bounds");
    }

    public final void releaseAutoTranscribe(@Nullable String sessionID) {
        Logger.m12710d(TAG, "releaseAutoTranscribe " + sessionID);
        FastConvertController.INSTANCE.getInstance().removeAutoTranscribeConvertItem(sessionID);
        RecordRecognizer recordRecognizer = getRecordRecognizer(sessionID);
        if (recordRecognizer != null) {
            recordRecognizer.stopVoiceRecognition();
        }
        if (recordRecognizer != null) {
            recordRecognizer.release();
        }
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.updateAutoTranscribeView();
            }
        }
    }

    public final void reloadActivity(@Nullable Activity activity) {
        unregisterReceiver(this.mActivity);
        registerReceiver(activity);
        this.mActivity = activity;
    }

    public final void removeAiMenuSTTProcessListener(int index) {
        this.mAiMenuSTTProcessListenerHashMap.remove(Integer.valueOf(index));
    }

    public final void resetSTTViewToDefault() {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.resetSTTViewToDefault();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [T, com.samsung.android.support.senl.nt.stt.base.audio.FastConvertResultData] */
    public final void saveRealtimeData(@Nullable String sessionID) {
        Activity activity;
        if (Feature.INSTANCE.getIS_SUPPORT_AUTO_TRANSCRIBE()) {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            int size = voiceDataList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                if (Intrinsics.areEqual(String.valueOf(voiceDataList2.get(i).getMHandle()), sessionID)) {
                    List<SpenVoiceData> voiceDataList3 = getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList3);
                    StringBuilder sbM16m = AbstractC0000a.m16m("saveRealtimeData# sessionID: ", sessionID, " name = ", voiceDataList3.get(i).getName(), " i = ");
                    sbM16m.append(i);
                    Logger.m12710d(TAG, sbM16m.toString());
                    intRef.element = i;
                    break;
                }
                i++;
            }
            int i2 = intRef.element;
            if (i2 >= 0) {
                List<SpenVoiceData> voiceDataList4 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList4);
                if (i2 < voiceDataList4.size()) {
                    List<SpenVoiceData> voiceDataList5 = getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList5);
                    SpenVoiceData spenVoiceData = voiceDataList5.get(intRef.element);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    RecordRecognizer recordRecognizer = getRecordRecognizer(sessionID);
                    ?? autoTranscribeResultData = recordRecognizer != null ? recordRecognizer.getAutoTranscribeResultData() : 0;
                    objectRef.element = autoTranscribeResultData;
                    if (autoTranscribeResultData == 0) {
                        Logger.m12711e(TAG, "saveRealtimeData# realtimeResultData = null");
                        return;
                    }
                    String textResult = autoTranscribeResultData.getTextResult();
                    int[] timingInfo = ((FastConvertResultData) objectRef.element).getTimingInfo();
                    List<SpeechInfo> speechInfoList = ((FastConvertResultData) objectRef.element).getSpeechInfoList();
                    boolean zIsmIsNeedGetRawText = ((FastConvertResultData) objectRef.element).getMIsNeedGetRawText();
                    STTRecognitionData sTTRecognitionData = new STTRecognitionData();
                    sTTRecognitionData.updateRecognitionData(textResult, timingInfo, speechInfoList, true, zIsmIsNeedGetRawText);
                    Logger.m12710d(TAG, "saveRealtimeData# recognizeText: " + textResult);
                    this.voiceDataController.saveDataToSpenVoice(getDocumentPath(), spenVoiceData, sTTRecognitionData.getListText(), sTTRecognitionData.getListTime(), speechInfoList, new HashMap(), new C2517b(3, spenVoiceData, this, intRef, objectRef));
                    Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        AiMenuSTTProcessListener value = it.next().getValue();
                        if (value != null && (activity = this.mActivity) != null) {
                            Intrinsics.checkNotNull(activity);
                            activity.runOnUiThread(new RunnableC8928b(this, 22, value, intRef));
                        }
                    }
                    return;
                }
            }
            Logger.m12711e(TAG, "saveRealtimeData# currentRecordingIndex : " + intRef.element);
        }
    }

    public final void saveSTTData(boolean isUpdated) {
        this.floatingController.saveSTTData(isUpdated);
    }

    public final void setAutoTranscribeRealtimeData(@Nullable String sessionID, @Nullable FastConvertResultData realTimeResultData) {
        Logger.m12710d(TAG, "setAutoTranscribeRealtimeData# sessionID: " + sessionID + " , realTimeResultData: " + (realTimeResultData != null ? realTimeResultData.getTextResult() : null));
        RecordRecognizer recordRecognizer = getRecordRecognizer(sessionID);
        if (recordRecognizer != null) {
            recordRecognizer.setAutoTranscribeResultData(realTimeResultData);
        }
    }

    public final void setIndexItemToShow(int i) {
        this.mItemIndexToShow = i;
        this.isNeedSummaryAgain = false;
        if (getVoiceDataList() != null) {
            if (i >= 0) {
                List<SpenVoiceData> voiceDataList = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList);
                if (i < voiceDataList.size()) {
                    List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList2);
                    this.currentConvertSession = ConvertUtils.getSessionID(voiceDataList2.get(this.mItemIndexToShow));
                    return;
                }
            }
            Logger.m12711e(TAG, "setIndexItemToShow Index out of bounds, length " + getVoiceDataList());
        }
    }

    public final void setItemIndexPreShowSearch(int i) {
        this.itemIndexPreShowSearch = i;
    }

    public final void setMCurrentParagraphInfo(@Nullable List<AiParagraphInfo> list) {
        this.mCurrentParagraphInfo = list;
    }

    public final void setMCurrentSpeakerNameMap(@Nullable Map<Integer, String> map) {
        this.mCurrentSpeakerNameMap = map;
    }

    public final void setMCurrentTextDataList(@Nullable List<AiTextData> list) {
        this.mCurrentTextDataList = list;
    }

    public final void setMIsTranslateSTTFirstTime(boolean z) {
        this.mIsTranslateSTTFirstTime = z;
    }

    public final void setMIsTranslateSTTSummarizationFirstTime(boolean z) {
        this.mIsTranslateSTTSummarizationFirstTime = z;
    }

    public final void setMRemoveTranscribeConfirmPresenter(@NotNull DialogContract.IRemoveConfirmDialogPresenter iRemoveConfirmDialogPresenter) {
        Intrinsics.checkNotNullParameter(iRemoveConfirmDialogPresenter, "<set-?>");
        this.mRemoveTranscribeConfirmPresenter = iRemoveConfirmDialogPresenter;
    }

    public final void setMode(@NotNull STTMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        STTMode sTTMode = this.currentMode;
        if (mode != sTTMode) {
            this.currentMode = mode;
            if (mode != STTMode.SELECTION_SUMMARY) {
                this.floatingController.onModeChanged(mode);
            }
            Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
            while (it.hasNext()) {
                AiMenuSTTProcessListener value = it.next().getValue();
                if (value != null) {
                    value.onModeChanged(sTTMode);
                }
            }
        }
    }

    public final void setNeedSummaryAgain(boolean z) {
        this.isNeedSummaryAgain = z;
    }

    public final void setSavedInstanceState(boolean onSavedInstanceState) {
        if (isSTTEditMode()) {
            this.mOnSavedInstanceState = onSavedInstanceState;
        }
    }

    public final void setShowSpeakerLabel(boolean isShowSpeakerLabel) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_STT_SHOW_SPEAKER_LABEL, isShowSpeakerLabel);
        this.floatingController.onShowSpeakerLabelChanged();
    }

    public final void setTranscribeFromType(int transcribeFromType) {
        this.mTranscribeFromType = transcribeFromType;
    }

    public final void setTranscriptToOtherLanguage(boolean transcriptToOtherLanguage) {
        this.mTranscriptToOtherLanguage = transcriptToOtherLanguage;
    }

    public abstract void setVoiceDataList(@Nullable List<SpenVoiceData> list);

    public final void showAutoDetectHelpView(@Nullable String messageTranscriptToOtherLanguage) {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.showAutoDetectHelpView(this.currentConvertSession, getMItemIndexToShow(), messageTranscriptToOtherLanguage);
            }
        }
    }

    public final void showHelpView(int position) {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.showHelpView(position);
            }
        }
    }

    public final void showInfoView() {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.showInfoView();
            }
        }
    }

    public final void showLanguageDialog() {
        if (this.mSTTSettingLanguageDialogFragment == null) {
            STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = new STTSettingLanguageDialogFragment();
            this.mSTTSettingLanguageDialogFragment = sTTSettingLanguageDialogFragment;
            sTTSettingLanguageDialogFragment.setDialogListener(this);
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentManager childFragmentManager = supportFragmentManager.getFragments().get(0).getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment2 = this.mSTTSettingLanguageDialogFragment;
            Intrinsics.checkNotNull(sTTSettingLanguageDialogFragment2);
            if (!sTTSettingLanguageDialogFragment2.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment3 = this.mSTTSettingLanguageDialogFragment;
                Intrinsics.checkNotNull(sTTSettingLanguageDialogFragment3);
                fragmentTransactionBeginTransaction.add(sTTSettingLanguageDialogFragment3, STT_SETTING_LANGUAGE_DIALOG_TAG).commitAllowingStateLoss();
            }
            childFragmentManager.executePendingTransactions();
        }
    }

    public final void showOrExecuteSTTVoiceItem(int index) {
        setIndexItemToShow(index);
        if (!this.voiceDataController.isHaveSTTData(index) && !isItemSTTConverting(index)) {
            onSTTItemConvertClick(index);
            if (this.mTranscribeFromType == 1) {
                NotesSamsungAnalytics.INSTANCE.insertLog("815", STTConstant.EVENT_TRANSCRIBE, "c");
                return;
            }
            return;
        }
        Logger.m12710d(TAG, "showOrExecuteSTTVoiceItem show result view");
        onDialogClickedConvertButton();
        if (this.mTranscribeFromType == 1) {
            NotesSamsungAnalytics.INSTANCE.insertLog("815", STTConstant.EVENT_TRANSCRIBE, "d");
        }
    }

    public abstract void showRealtimeTranscribe();

    public abstract void showRecordingPlayView();

    public final void showRemoveTranscribeDialog() {
        RemoveTranscriptConfirmDialog removeTranscriptConfirmDialogCreateRemoveTranscriptConfirmDialog = this.mDialogCreator.createRemoveTranscriptConfirmDialog(this.mRemoveTranscribeConfirmPresenter);
        this.mRemoveTranscribeConfirmDialog = removeTranscriptConfirmDialogCreateRemoveTranscriptConfirmDialog;
        showDialogFragment(removeTranscriptConfirmDialogCreateRemoveTranscriptConfirmDialog, STT_REMOVE_TRANSCRIPT_TAG);
    }

    public final void showSettingLanguageDialog() {
        STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = this.mSTTSettingLanguageDialogFragment;
        if (sTTSettingLanguageDialogFragment != null) {
            sTTSettingLanguageDialogFragment.dismiss();
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, "");
        if (!isEnableAutoDetect() || this.mTranscriptToOtherLanguage) {
            showLanguageDialog();
        } else {
            Logger.m12710d(TAG, "use AutoDetectLanguage feature");
            onDialogClickConvertButton();
        }
    }

    public final void showTabletVoiceList() {
        int i;
        Logger.m12710d(TAG, "showTabletVoiceList");
        if (!isSTTEditMode() && !isSelectionMode() && !isSelectionSummaryMode() && this.currentMode != STTMode.SEARCH_COMPOSER) {
            setMode(STTMode.REPLAY);
        }
        if (getVoiceDataList() != null && (i = this.mItemIndexToShow) >= 0) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Integer numValueOf = voiceDataList != null ? Integer.valueOf(voiceDataList.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (i < numValueOf.intValue()) {
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                if (FastConvertController.INSTANCE.getInstance().isAutoTranscribeConverting(String.valueOf(voiceDataList2.get(this.mItemIndexToShow).getMHandle()))) {
                    List<SpenVoiceData> voiceDataList3 = getVoiceDataList();
                    Intrinsics.checkNotNull(voiceDataList3);
                    updateRealtimeView(voiceDataList3.get(this.mItemIndexToShow));
                    return;
                }
            }
        }
        if (this.mItemIndexToShow >= 0 && !FastConvertController.INSTANCE.getInstance().isConverting(this.currentConvertSession) && this.voiceDataController.isHaveSTTData(this.mItemIndexToShow)) {
            STTVoiceDataController sTTVoiceDataController = this.voiceDataController;
            List<SpenVoiceData> voiceDataList4 = getVoiceDataList();
            if (sTTVoiceDataController.checkEmptyVoiceData(voiceDataList4 != null ? voiceDataList4.get(this.mItemIndexToShow) : null)) {
                showInfoView();
            } else {
                hideInfoView();
            }
        }
        initSTTVoiceList(getVoiceDataList());
        this.mOnSavedInstanceState = false;
    }

    public final void syncSTT(int voiceItemIndex, long timeStamp) {
        if (voiceItemIndex >= 0) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            Intrinsics.checkNotNull(voiceDataList);
            if (voiceItemIndex < voiceDataList.size()) {
                setIndexItemToShow(voiceItemIndex);
                List<SpenVoiceData> voiceDataList2 = getVoiceDataList();
                Intrinsics.checkNotNull(voiceDataList2);
                SpenVoiceData spenVoiceData = voiceDataList2.get(voiceItemIndex);
                updateSTTReplay(spenVoiceData, (int) (timeStamp - spenVoiceData.getCreationTime()));
                onSeekToSTTTouchedWord(voiceItemIndex, timeStamp - spenVoiceData.getCreationTime());
                return;
            }
        }
        List<SpenVoiceData> voiceDataList3 = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList3);
        Logger.m12713i(TAG, "syncSTT can not sync index: " + voiceItemIndex + " size: " + voiceDataList3.size());
    }

    public final void toggleSTTEditMode() {
        if (isSTTRecordMode()) {
            return;
        }
        if (isSTTReplayMode()) {
            setMode(STTMode.EDIT);
        } else if (isSTTEditMode()) {
            setMode(STTMode.REPLAY);
        }
    }

    public final void toggleSTTSearchMode() {
        STTMode sTTMode = STTMode.SEARCH;
        if (sTTMode != this.currentMode) {
            setMode(sTTMode);
            return;
        }
        AiSTTListView sttListView = this.floatingController.getSttListView();
        if (sttListView != null) {
            sttListView.scrollToLastPosition();
        }
        STTSearchPresenter sTTSearchPresenter = this.mSTTSearchPresenter;
        if (sTTSearchPresenter != null) {
            sTTSearchPresenter.clearSearchInfo();
        }
        setMode(STTMode.REPLAY);
    }

    public final void toggleSTTSelectAllItem(boolean isSelectedAll) {
        if (isSelectionMode()) {
            this.floatingController.toggleSTTSelectAllItem(isSelectedAll);
            Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
            while (it.hasNext()) {
                AiMenuSTTProcessListener value = it.next().getValue();
                if (value != null) {
                    value.onSTTItemCheckedChange(this.floatingController.getSelectedItemMap());
                }
            }
        }
    }

    public final void toggleSTTSelectionMode(boolean isTranscriptTab) {
        if (isSelectionMode() || isSelectionSummaryMode()) {
            setMode(STTMode.REPLAY);
        } else {
            setMode(isTranscriptTab ? STTMode.SELECTION : STTMode.SELECTION_SUMMARY);
        }
    }

    public final void updateConvertVoiceList(@NotNull List<String> selectedVoiceList) {
        Intrinsics.checkNotNullParameter(selectedVoiceList, "selectedVoiceList");
        this.mTranscriptToOtherLanguage = false;
        showSettingLanguageDialog();
        this.mSelectedVoiceToConvertList.clear();
        for (String str : selectedVoiceList) {
            List<SpenVoiceData> voiceDataList = getVoiceDataList();
            if (voiceDataList != null) {
                int size = voiceDataList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        SpenVoiceData spenVoiceData = voiceDataList.get(i);
                        if (Intrinsics.areEqual(str, spenVoiceData.getName())) {
                            this.mSelectedVoiceToConvertList.add(spenVoiceData);
                            setIndexItemToShow(i);
                            break;
                        }
                        i++;
                    }
                }
            }
        }
    }

    public final void updateLastLanguageTranscribe() {
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        Intrinsics.checkNotNull(voiceDataList);
        String sessionID = ConvertUtils.getSessionID(voiceDataList.get(getMItemIndexToShow()));
        String str = sessionID != null ? this.mLastLanguageTranscribe.get(sessionID) : null;
        STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
        LanguageInfo languageInfo = companion.getLanguageInfo(str);
        if (languageInfo != null && !companion.isLangPackInstalled(languageInfo.getLangPackage()) && sessionID != null) {
            this.mLastLanguageTranscribe.put(sessionID, " ");
        }
        Logger.m12710d(TAG, "checkLangPackInstalled# language: " + str + ", mTranscribeToOtherLanguage : " + this.mTranscriptToOtherLanguage + ", isTranscribeAgain");
    }

    public final void updateSTTReplay(@NotNull SpenVoiceData voiceData, int position) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mItemIndexToShow == -1 || this.mSTTVoiceItemList.isEmpty() || isSTTEditMode() || isSelectionMode()) {
            return;
        }
        if (Intrinsics.areEqual(this.mSTTVoiceItemList.get(0).getName(), voiceData.getName())) {
            this.floatingController.onSTTReplay(position);
        } else {
            this.floatingController.onSTTReplay(-1);
        }
    }

    public final void updateSTTReplayComplete(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mItemIndexToShow == -1 || this.mSTTVoiceItemList.isEmpty() || isSTTEditMode() || isSelectionMode()) {
            return;
        }
        if (Intrinsics.areEqual(this.mSTTVoiceItemList.get(0).getName(), voiceData.getName())) {
            this.floatingController.onSTTReplayComplete();
        } else {
            this.floatingController.onSTTReplay(-1);
        }
    }

    public final void updateSTTReplayStart(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mItemIndexToShow == -1 || this.mSTTVoiceItemList.isEmpty() || isSTTEditMode() || isSelectionMode()) {
            return;
        }
        if (Intrinsics.areEqual(this.mSTTVoiceItemList.get(0).getName(), voiceData.getName())) {
            this.floatingController.onSTTReplay(0);
        } else {
            this.floatingController.onSTTReplay(-1);
        }
    }

    public final void updateSTTReplayStop(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        if (this.mItemIndexToShow == -1 || this.mSTTVoiceItemList.isEmpty() || isSTTEditMode() || isSelectionMode()) {
            return;
        }
        if (Intrinsics.areEqual(this.mSTTVoiceItemList.get(0).getName(), voiceData.getName())) {
            this.floatingController.onSTTReplayComplete();
        } else {
            this.floatingController.onSTTReplay(-1);
        }
    }

    public abstract void updateVoiceSync(int voiceIndex);

    public final void showHelpView() {
        Iterator<Map.Entry<Integer, AiMenuSTTProcessListener>> it = this.mAiMenuSTTProcessListenerHashMap.entrySet().iterator();
        while (it.hasNext()) {
            AiMenuSTTProcessListener value = it.next().getValue();
            if (value != null) {
                value.showHelpView(getMItemIndexToShow());
            }
        }
    }

    public final void cancelTranscribe(@Nullable String sessionID) {
        if (sessionID == null || Intrinsics.areEqual(sessionID, this.currentConvertSession)) {
            Logger.m12710d(TAG, "cancelTranscribe - current session");
            cancelTranscribe();
            FastConvertService.INSTANCE.stopService();
        } else {
            Logger.m12710d(TAG, "cancelTranscribe ".concat(sessionID));
            FastConvertController companion = FastConvertController.INSTANCE.getInstance();
            companion.setCurrentFastConvertState(17);
            companion.removeConvertItem(sessionID);
            companion.cancelFastConvert(sessionID);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    @NotNull
    public STTPresenter getSTTPresenter() {
        return this;
    }
}
