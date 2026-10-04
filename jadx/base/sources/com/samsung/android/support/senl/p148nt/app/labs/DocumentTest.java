package com.samsung.android.support.senl.p148nt.app.labs;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ImportSDocTaskListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Summarizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import p001A.AbstractC0000a;
import p084U0.C0312d;
import p107a4.RunnableC0355a;
import p122b2.RunnableC4180c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DocumentTest implements IActivityResultListener {
    private static final String BIG_TEXT_CONTENT = "antonio switzerland translation delay expectations lanes timothy optical sustained polo href treasury mexico provision couples mirror disc reprint investing minutes millennium briefly monaco stadium setup chubby comics nano madonna fixtures color farm brings quilt sys relations ee chinese perfectly pat ala president apartment floppy brunei seek kathy anybody why buses bullet byte corruption relocation vegetable italiano holes agencies statutory exact san periodic periods dpi acute paying strong mattress champagne hungary sr lake suitable bt except facilities clocks young contacts marketplace tripadvisor release bearing ir merge annie js rna people picnic joel with metro mn controls profits manitoba conpromise set band crude sep magazines burden imposed chuck tanks printable kinda corpus assigned reader findlaw defines pages stone phys king myth closely pci configuration proposal gtk eds representing butler govt graphics adware botswana terror british gs ns driven reflect pichunter roll fist continues soon burns sit joins makeup bishdrove advantages chick strain message dakota music brunei cape spokesman stunning prison placement clay mat remembered go that compilation emotional legal lightning badge diego decor butts slim ended isle leslie d ware schedule blonde large access craig commitment professionals mas legislative panels hypothetical academics necessity gbp asset clotmake mild compiler students scenic refugees infection commodity constructed unknown refers leu alarm moved general reject north crawford artistic loved mice elimination automatic arise the cooling backed resist mounting base fundraising grass specialty topic transfer present pad bandwidth valuable dream io matches bukkake moderator artwork allowing atribute makeup politicians inquiries honda word interests bin submitting tag pray shareware constant pix feedback kelly donations handed psychological proceeds tabs qty rational removed continuing shell division tuition archives root apps sisters necessarily scoop rely procedure week washer poll diameter magic brooks strange tent perspectives rates availability chinese alternate academy lan patio mi therapist gradually excellent manitoba gabriel architecture epson hunter tu icon engineer skip ghost tonight walks falling whats dash bloom midlands bone doll interaction myanmar porn problems planet chance re pressing eliminate teams baskets adaptation tribute robust geneexport continuity benefit instance portfolio thereof staying usda biggest ecology align indices weapons recordings program teen means unfortunately theaters ensures constraint msn yard tax perry ins yugoslavia handjob luck then calculated neck leaf enquiries nextel enjoy voters sweden referrals provinces christopher gmbh characters aapplication beat dispatched demanding kansas wisconsin rom newer graduate knights mba bikes elliott marco pierre compiled keyboards mars documentation effectively rotation une powder trend triangle sandwich who judicial toddler loads mature cult nation erp duke ordinary compilation trading affiliates polymer col odd scales treasure cabinet carry west consciousness report childhood stating integral albert phantom neither jennifer toll consist devel summer returns gordon worth wound ic subsidiary bahrain biology colleges jets trap ou evaluate sum orbit bald team explicitly production did formation ka thesis wish noise fill seeing town faces declaration integrate award realisport lol drill div cruz columnists winners abroad mesa scary deposit gym below der chicago communist died howto dock xhtml started metallic predictions hero pre uh chambers strategies enforcement quantum effectiveness malaysia intended cement holmes tba combo g powerpoint earnings checkout dr yamaha implicationsgrenada hiv cars terrorists kills cab adjust confirmed outreach adds practices riverside explaining ignored belly intensity victory ladder opposite miss cod footage normal destruction hindu gospel pointed tender encoding elected vt navigator institutions msie aside bunny newsletters chairman gif mat current proceeding romania chancellor literacy surname basin where nursery josh professionals advance attempted thumb waterproof locking playstation machinery indian spam sample addition ad rca subject expression mt excitement setup cruise supply past move equilibrium deny instance optics mystery bunny scored illustrated announces athletes import reviking television qualifications msn ma ipaq anger toward licensed track occasion ross shown incredible exist noise colleagues preparing aims development directory permitted catch partner mouse un panel acceptance engaged separation lucky shop kit edmonton burn peter brands copied eyes blog nfl style jail lingerie antigua appreciate teeth webster judgment approve seven comics escort parental pot prominent josh eating efficient deutsche tomorrow mandatory invitations please optimum sin includes jar tee turner worried conspiracy impacts produce lat shipped marshall lu nurses african believe colony grows removed detroit vaccine field role boxes ex uri hobbies voting houston treaty tt away workers executed pharmaceutical adolescent cd transform imagine relations rock buying complicated colors sprint rural association great ronald based walk alter dns hearings ln depression quarter design bullet combinations hear bears call asbestos pills buildings ooo burning marc closest treo concerns recorded violations branch descending til elliott horse act sorts still votes ct engage longer stuffed creativity pubmed communities inherited transmitted vt ware leu critics secondary constitutional raising government sacramento government postposted message begins debt choosingassistance removal mars liberal lucky alerts surge teach walnut customized indirect ll reader relief westminster holdings plumbing earl majority gross focused tracker camel committed incorporate statement titten plates uniform sick garbage travels pichunter gui total code listprice hint colour singapore bobestsellers achieve be geometry qatar wife secretary spare size feature eq cn evaluating salvation ships bridge locator oxide increase athens reflection heart rolling duck dominant accommodation launch examinations hint warnings earliest wines longest restore jurisdiction dept beverage media fabrics scsi facartridges silver thesis attending selling database wanted suffered blake indexed mail tied drives disturbed who neo finished stood abu cotton algorithm competing ana depending coordinated wan detector letter royalty hindu peeing household vids jewel decade study ringtones faced gis printing de stations oasucks concentrate valuation inflation enrollment supports controllers dot beaver hired peninsula honors laundry alaska impressive grill disclaimers barbados markers assistance roof listprice workout achieve cove cut user balloon recreation listed undefined expressed fighter coated das geology livestock precedingfuel envelope thunder firewire naturally toe reveal receptor outer inline games heather workplace jonathan andrew mineral howard academic totally programmers vendor montgomery urge crm projects crop again presentation gibson majority webster obligations surgeon antonio switzerland translation delay expectations lanes timothy optical sustained polo href treasury mexico provision couples mirror disc reprint investing minutes millennium briefly monaco stadium setup chubby comics nano madonna fixtures color farm brings quilt sys relations ee chinese perfectly pat ala president apartment floppy brunei seek kathy anybody why buses bullet byte corruption relocation vegetable italiano holes agencies statutory exact san periodic periods dpi acute paying strong mattress champagne hungary sr lake suitable bt except facilities clocks young contacts marketplace tripadvisor release bearing ir merge annie js rna people picnic joel with metro mn controls profits manitoba conpromise set band crude sep magazines burden imposed chuck tanks printable kinda corpus assigned reader findlaw defines pages stone phys king myth closely pci configuration proposal gtk eds representing butler govt graphics adware botswana terror british gs ns driven reflect pichunter roll fist continues soon burns sit joins makeup bishdrove advantages chick strain message dakota music brunei cape spokesman stunning prison placement clay mat remembered go that compilation emotional legal lightning badge diego decor butts slim ended isle leslie d ware schedule blonde large access craig commitment professionals mas legislative panels hypothetical academics necessity gbp asset clotmake mild compiler students scenic refugees infection commodity constructed unknown refers leu alarm moved general reject north crawford artistic loved mice elimination automatic arise the cooling backed resist mounting base fundraising grass specialty topic transfer present pad bandwidth valuable dream io matches bukkake moderator artwork allowing atribute makeup politicians inquiries honda word interests bin submitting tag pray shareware constant pix feedback kelly donations handed psychological proceeds tabs qty rational removed continuing shell division tuition archives root apps sisters necessarily scoop rely procedure week washer poll diameter magic brooks strange tent perspectives rates availability chinese alternate academy lan patio mi therapist gradually excellent manitoba gabriel architecture epson hunter tu icon engineer skip ghost tonight walks falling whats dash bloom midlands bone doll interaction myanmar porn problems planet chance re pressing eliminate teams baskets adaptation tribute robust geneexport continuity benefit instance portfolio thereof staying usda biggest ecology align indices weapons recordings program teen means unfortunately theaters ensures constraint msn yard tax perry ins yugoslavia handjob luck then calculated neck leaf enquiries nextel enjoy voters sweden referrals provinces christopher gmbh characters aapplication beat dispatched demanding kansas wisconsin rom newer graduate knights mba bikes elliott marco pierre compiled keyboards mars documentation effectively rotation une powder trend triangle sandwich who judicial toddler loads mature cult nation erp duke ordinary compilation trading affiliates polymer col odd scales treasure cabinet carry west consciousness report childhood stating integral albert phantom neither jennifer toll consist devel summer returns gordon worth wound ic subsidiary bahrain biology colleges jets trap ou evaluate sum orbit bald team explicitly production did formation ka thesis wish noise fill seeing town faces declaration integrate award realisport lol drill div cruz columnists winners abroad mesa scary deposit gym below der chicago communist died howto dock xhtml started metallic predictions hero pre uh chambers strategies enforcement quantum effectiveness malaysia intended cement holmes tba combo g powerpoint earnings checkout dr yamaha implicationsgrenada hiv cars terrorists kills cab adjust confirmed outreach adds practices riverside explaining ignored belly intensity victory ladder opposite miss cod footage normal destruction hindu gospel pointed tender encoding elected vt navigator institutions msie aside bunny newsletters chairman gif mat current proceeding romania chancellor literacy surname basin where nursery josh professionals advance attempted thumb waterproof locking playstation machinery indian spam sample addition ad rca subject expression mt excitement setup cruise supply past move equilibrium deny instance optics mystery bunny scored illustrated announces athletes import reviking television qualifications msn ma ipaq anger toward licensed track occasion ross shown incredible exist noise colleagues preparing aims development directory permitted catch partner mouse un panel acceptance engaged separation lucky shop kit edmonton burn peter brands copied eyes blog nfl style jail lingerie antigua appreciate teeth webster judgment approve seven comics escort parental pot prominent josh eating efficient deutsche tomorrow mandatory invitations please optimum sin includes jar tee turner worried conspiracy impacts produce lat shipped marshall lu nurses african believe colony grows removed detroit vaccine field role boxes ex uri hobbies voting houston treaty tt away workers executed pharmaceutical adolescent cd transform imagine relations rock buying complicated colors sprint rural association great ronald based walk alter dns hearings ln depression quarter design bullet combinations hear bears call asbestos pills buildings ooo burning marc closest treo concerns recorded violations branch descending til elliott horse act sorts still votes ct engage longer stuffed creativity pubmed communities inherited transmitted vt ware leu critics secondary constitutional raising government sacramento government postposted message begins debt choosingassistance removal mars liberal lucky alerts surge teach walnut customized indirect ll reader relief westminster holdings plumbing earl majority gross focused tracker camel committed incorporate statement titten plates uniform sick garbage travels pichunter gui total code listprice hint colour singapore bobestsellers achieve be geometry qatar wife secretary spare size feature eq cn evaluating salvation ships bridge locator oxide increase athens reflection heart rolling duck dominant accommodation launch examinations hint warnings earliest wines longest restore jurisdiction dept beverage media fabrics scsi facartridges silver thesis attending selling database wanted suffered blake indexed mail tied drives disturbed who neo finished stood abu cotton algorithm competing ana depending coordinated wan detector letter royalty hindu peeing household vids jewel decade study ringtones faced gis printing de stations oasucks concentrate valuation inflation enrollment supports controllers dot beaver hired peninsula honors laundry alaska impressive grill disclaimers barbados markers assistance roof listprice workout achieve cove cut user balloon recreation listed undefined expressed fighter coated das geology livestock precedingfuel envelope thunder firewire naturally toe reveal receptor outer inline games heather workplace jonathan andrew mineral howard academic totally programmers vendor montgomery urge crm projects crop again presentation gibson majority webster obligations surgeon antonio switzerland translation delay expectations lanes timothy optical sustained polo href treasury mexico provision couples mirror disc reprint investing minutes millennium briefly monaco stadium setup chubby comics nano madonna fixtures color farm brings quilt sys relations ee chinese perfectly pat ala president apartment floppy brunei seek kathy anybody why buses bullet byte corruption relocation vegetable italiano holes agencies statutory exact san periodic periods dpi acute paying strong mattress champagne hungary sr lake suitable bt except facilities clocks young contacts marketplace tripadvisor release bearing ir merge annie js rna people picnic joel with metro mn controls profits manitoba conpromise set band crude sep magazines burden imposed chuck tanks printable kinda corpus assigned reader findlaw defines pages stone phys king myth closely pci configuration proposal gtk eds representing butler govt graphics adware botswana terror british gs ns driven reflect pichunter roll fist continues soon burns sit joins makeup bishdrove advantages chick strain message dakota music brunei cape spokesman stunning prison placement clay mat remembered go that compilation emotional legal lightning badge diego decor butts slim ended isle leslie d ware schedule blonde large access craig commitment professionals mas legislative panels hypothetical academics necessity gbp asset clotmake mild compiler students scenic refugees infection commodity constructed unknown refers leu alarm moved general reject north crawford artistic loved mice elimination automatic arise the cooling backed resist mounting base fundraising grass specialty topic transfer present pad bandwidth valuable dream io matches bukkake moderator artwork allowing atribute makeup politicians inquiries honda word interests bin submitting tag pray shareware constant pix feedback kelly donations handed psychological proceeds tabs qty rational removed continuing shell division tuition archives root apps sisters necessarily scoop rely procedure week washer poll diameter magic brooks strange tent perspectives rates availability chinese alternate academy lan patio mi therapist gradually excellent manitoba gabriel architecture epson hunter tu icon engineer skip ghost tonight walks falling whats dash bloom midlands bone doll interaction myanmar porn problems planet chance re pressing eliminate teams baskets adaptation tribute robust geneexport continuity benefit instance portfolio thereof staying usda biggest ecology align indices weapons recordings program teen means unfortunately theaters ensures constraint msn yard tax perry ins yugoslavia handjob luck then calculated neck leaf enquiries nextel enjoy voters sweden referrals provinces christopher gmbh characters aapplication beat dispatched demanding kansas wisconsin rom newer graduate knights mba bikes elliott marco pierre compiled keyboards mars documentation effectively rotation une powder trend triangle sandwich who judicial toddler loads mature cult nation erp duke ordinary compilation trading affiliates polymer col odd scales treasure cabinet carry west consciousness report childhood stating integral albert phantom neither jennifer toll consist devel summer returns gordon worth wound ic subsidiary bahrain biology colleges jets trap ou evaluate sum orbit bald team explicitly production did formation ka thesis wish noise fill seeing town faces declaration integrate award realisport lol drill div cruz columnists winners abroad mesa scary deposit gym below der chicago communist died howto dock xhtml started metallic predictions hero pre uh chambers strategies enforcement quantum effectiveness malaysia intended cement holmes tba combo g powerpoint earnings checkout dr yamaha implicationsgrenada hiv cars terrorists kills cab adjust confirmed outreach adds practices riverside explaining ignored belly intensity victory ladder opposite miss cod footage normal destruction hindu gospel pointed tender encoding elected vt navigator institutions msie aside bunny newsletters chairman gif mat current proceeding romania chancellor literacy surname basin where nursery josh professionals advance attempted thumb waterproof locking playstation machinery indian spam sample addition ad rca subject expression mt excitement setup cruise supply past move equilibrium deny instance optics mystery bunny scored illustrated announces athletes import reviking television qualifications msn ma ipaq anger toward licensed track occasion ross shown incredible exist noise colleagues preparing aims development directory permitted catch partner mouse un panel acceptance engaged separation lucky shop kit edmonton burn peter brands copied eyes blog nfl style jail lingerie antigua appreciate teeth webster judgment approve seven comics escort parental pot prominent josh eating efficient deutsche tomorrow mandatory invitations please optimum sin includes jar tee turner worried conspiracy impacts produce lat shipped marshall lu nurses african believe colony grows removed detroit vaccine field role boxes ex uri hobbies voting houston treaty tt away workers executed pharmaceutical adolescent cd transform imagine relations rock buying complicated colors sprint rural association great ronald based walk alter dns hearings ln depression quarter design bullet combinations hear bears call asbestos pills buildings ooo burning marc closest treo concerns recorded violations branch descending til elliott horse act sorts still votes ct engage longer stuffed creativity pubmed communities inherited transmitted vt ware leu critics secondary constitutional raising government sacramento government postposted message begins debt choosingassistance removal mars liberal lucky alerts surge teach walnut customized indirect ll reader relief westminster holdings plumbing earl majority gross focused tracker camel committed incorporate statement titten plates uniform sick garbage travels pichunter gui total code listprice hint colour singapore bobestsellers achieve be geometry qatar wife secretary spare size feature eq cn evaluating salvation ships bridge locator oxide increase athens reflection heart rolling duck dominant accommodation launch examinations hint warnings earliest wines longest restore jurisdiction dept beverage media fabrics scsi facartridges silver thesis attending selling database wanted suffered blake indexed mail tied drives disturbed who neo finished stood abu cotton algorithm competing ana depending coordinated wan detector letter royalty hindu peeing household vids jewel decade study ringtones faced gis printing de stations oasucks concentrate valuation inflation enrollment supports controllers dot beaver hired peninsula honors laundry alaska impressive grill disclaimers barbados markers assistance roof listprice workout achieve cove cut user balloon recreation listed undefined expressed fighter coated das geology livestock precedingfuel envelope thunder firewire naturally toe reveal receptor outer inline games heather workplace jonathan andrew mineral howard academic totally programmers vendor montgomery urge crm projects crop again presentation gibson majority webster obligations surgeon antonio switzerland translation delay expectations lanes timothy optical sustained polo href treasury mexico provision couples mirror disc reprint investing minutes millennium briefly monaco stadium setup chubby comics nano madonna fixtures color farm brings quilt sys relations ee chinese perfectly pat ala president apartment floppy brunei seek kathy anybody why buses bullet byte corruption relocation vegetable italiano holes agencies statutory exact san periodic periods dpi acute paying strong mattress champagne hungary sr lake suitable bt except facilities clocks young contacts marketplace tripadvisor release bearing ir merge annie js rna people picnic joel with metro mn controls profits manitoba conpromise set band crude sep magazines burden imposed chuck tanks printable kinda corpus assigned reader findlaw defines pages stone phys king myth closely pci configuration proposal gtk eds representing butler govt graphics adware botswana terror british gs ns driven reflect pichunter roll fist continues soon burns sit joins makeup bishdrove advantages chick strain message dakota music brunei cape spokesman stunning prison placement clay mat remembered go that compilation emotional legal lightning badge diego decor butts slim ended isle leslie d ware schedule blonde large access craig commitment professionals mas legislative panels hypothetical academics necessity gbp asset clotmake mild compiler students scenic refugees infection commodity constructed unknown refers leu alarm moved general reject north crawford artistic loved mice elimination automatic arise the cooling backed resist mounting base fundraising grass specialty topic transfer present pad bandwidth valuable dream io matches bukkake moderator artwork allowing atribute makeup politicians inquiries honda word interests bin submitting tag pray shareware constant pix feedback kelly donations handed psychological proceeds tabs qty rational removed continuing shell division tuition archives root apps sisters necessarily scoop rely procedure week washer poll diameter magic brooks strange tent perspectives rates availability chinese alternate academy lan patio mi therapist gradually excellent manitoba gabriel architecture epson hunter tu icon engineer skip ghost tonight walks falling whats dash bloom midlands bone doll interaction myanmar porn problems planet chance re pressing eliminate teams baskets adaptation tribute robust geneexport continuity benefit instance portfolio thereof staying usda biggest ecology align indices weapons recordings program teen means unfortunately theaters ensures constraint msn yard tax perry ins yugoslavia handjob luck then calculated neck leaf enquiries nextel enjoy voters sweden referrals provinces christopher gmbh characters aapplication beat dispatched demanding kansas wisconsin rom newer graduate knights mba bikes elliott marco pierre compiled keyboards mars documentation effectively rotation une powder trend triangle sandwich who judicial toddler loads mature cult nation erp duke ordinary compilation trading affiliates polymer col odd scales treasure cabinet carry west consciousness report childhood stating integral albert phantom neither jennifer toll consist devel summer returns gordon worth wound ic subsidiary bahrain biology colleges jets trap ou evaluate sum orbit bald team explicitly production did formation ka thesis wish noise fill seeing town faces declaration integrate award realisport lol drill div cruz columnists winners abroad mesa scary deposit gym below der chicago communist died howto dock xhtml started metallic predictions hero pre uh chambers strategies enforcement quantum effectiveness malaysia intended cement holmes tba combo g powerpoint earnings checkout dr yamaha implicationsgrenada hiv cars terrorists kills cab adjust confirmed outreach adds practices riverside explaining ignored belly intensity victory ladder opposite miss cod footage normal destruction hindu gospel pointed tender encoding elected vt navigator institutions msie aside bunny newsletters chairman gif mat current proceeding romania chancellor literacy surname basin where nursery josh professionals advance attempted thumb waterproof locking playstation machinery indian spam sample addition ad rca subject expression mt excitement setup cruise supply past move equilibrium deny instance optics mystery bunny scored illustrated announces athletes import reviking television qualifications msn ma ipaq anger toward licensed track occasion ross shown incredible exist noise colleagues preparing aims development directory permitted catch partner mouse un panel acceptance engaged separation lucky shop kit edmonton burn peter brands copied eyes blog nfl style jail lingerie antigua appreciate teeth webster judgment approve seven comics escort parental pot prominent josh eating efficient deutsche tomorrow mandatory invitations please optimum sin includes jar tee turner worried conspiracy impacts produce lat shipped marshall lu nurses african believe colony grows removed detroit vaccine field role boxes ex uri hobbies voting houston treaty tt away workers executed pharmaceutical adolescent cd transform imagine relations rock buying complicated colors sprint rural association great ronald based walk alter dns hearings ln depression quarter design bullet combinations hear bears call asbestos pills buildings ooo burning marc closest treo concerns recorded violations branch descending til elliott horse act sorts still votes ct engage longer stuffed creativity pubmed communities inherited transmitted vt ware leu critics secondary constitutional raising government sacramento government postposted message begins debt choosingassistance removal mars liberal lucky alerts surge teach walnut customized indirect ll reader relief westminster holdings plumbing earl majority gross focused tracker camel committed incorporate statement titten plates uniform sick garbage travels pichunter gui total code listprice hint colour singapore bobestsellers achieve be geometry qatar wife secretary spare size feature eq cn evaluating salvation ships bridge locator oxide increase athens reflection heart rolling duck dominant accommodation launch examinations hint warnings earliest wines longest restore jurisdiction dept beverage media fabrics scsi facartridges silver thesis attending selling database wanted suffered blake indexed mail tied drives disturbed who neo finished stood abu cotton algorithm competing ana depending coordinated wan detector letter royalty hindu peeing household vids jewel decade study ringtones faced gis printing de stations oasucks concentrate valuation inflation enrollment supports controllers dot beaver hired peninsula honors laundry alaska impressive grill disclaimers barbados markers assistance roof listprice workout achieve cove cut user balloon recreation listed undefined expressed fighter coated das geology livestock precedingfuel envelope thunder firewire naturally toe reveal receptor outer inline games heather workplace jonathan andrew mineral howard academic totally programmers vendor montgomery urge crm projects crop again presentation gibson majority webster obligations surgeon antonio switzerland translation delay expectations lanes timothy optical sustained polo href treasury mexico provision couples mirror disc reprint investing minutes millennium briefly monaco stadium setup chubby comics nano madonna fixtures color farm brings quilt sys relations ee chinese perfectly pat ala president apartment floppy brunei seek kathy anybody why buses bullet byte corruption relocation vegetable italiano holes agencies statutory exact san periodic periods dpi acute paying strong mattress champagne hungary sr lake suitable bt except facilities clocks young contacts marketplace tripadvisor release bearing ir merge annie js rna people picnic joel with metro mn controls profits manitoba conpromise set band crude sep magazines burden imposed chuck tanks printable kinda corpus assigned reader findlaw defines pages stone phys king myth closely pci configuration proposal gtk eds representing butler govt graphics adware botswana terror british gs ns driven reflect pichunter roll fist continues soon burns sit joins makeup bishdrove advantages chick strain message dakota music brunei cape spokesman stunning prison placement clay mat remembered go that compilation emotional legal lightning badge diego decor butts slim ended isle leslie d ware schedule blon";
    static final int PICK_DOC_REQUEST_CODE = 1;
    static final int PICK_DOC_TYPE_IMPORT_DOC = 10;
    private static final String TAG = "DocumentTest";
    public static int UPDATE_DAYS_TO_THE_PAST;
    private int mType = 0;
    private final TipCardTaskListener mTipCardTaskListener = new TipCardTaskListener() { // from class: com.samsung.android.support.senl.nt.app.labs.DocumentTest.1
        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
        public void addTipCard(TipCard tipCard) {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
        public void filteredInvalidateOptionsMenu() {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
        public boolean onUnsupportedVersionError() {
            return false;
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
        public void removeTipCard(int i) {
        }

        @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
        public void updateProgress(TipCard tipCard) {
        }
    };

    private ImportSDocTaskListener createImportTaskListener(Activity activity, final DialogUtils.ProgressDialog progressDialog) {
        return new ImportSDocTaskListener(activity, new TipCardProgress(0, 0, 0, 0, 0, 3), this.mTipCardTaskListener) { // from class: com.samsung.android.support.senl.nt.app.labs.DocumentTest.2
            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ImportSDocTaskListener, p084U0.InterfaceC0313e
            public void onFinish(int i, int i2, @NonNull Map<String, Integer> map, int i4) {
                super.onFinish(i, i2, map, i4);
                progressDialog.dismiss();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ImportSDocTaskListener, p084U0.InterfaceC0313e
            public void onProgress(int i, int i2) {
                super.onProgress(i, i2);
                progressDialog.setProgress((int) ((i / i2) * 100.0f));
            }
        };
    }

    private DialogUtils.ProgressDialog createProgress(Activity activity) {
        DialogUtils.ProgressDialog progressDialog = new DialogUtils.ProgressDialog(activity);
        progressDialog.setTitle("Copying Test Documents...");
        progressDialog.setProgressStyle(1);
        progressDialog.show();
        return progressDialog;
    }

    private static SCSRequesterType getAutoTestType() {
        String str = Environment.getExternalStorageDirectory().getPath() + File.separator;
        return new File(AbstractC0541b.m756B(str, "AutoCover.cfg")).exists() ? SCSRequesterType.Cover : new File(AbstractC0541b.m756B(str, "AutoFormatNormal.cfg")).exists() ? SCSRequesterType.StructuredAutoFormat : new File(AbstractC0541b.m756B(str, "AutoFormatMeeting.cfg")).exists() ? SCSRequesterType.MeetingAutoFormat : SCSRequesterType.Summary;
    }

    private List<ImportDocument> getDocumentList(@NonNull Context context, @NonNull Intent intent) throws Throwable {
        ArrayList arrayList = new ArrayList();
        if (intent.getData() == null) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    String pathFromUri = getPathFromUri(context, clipData.getItemAt(i).getUri());
                    if (!TextUtils.isEmpty(pathFromUri)) {
                        arrayList.add(new ImportDocument(pathFromUri, null));
                    }
                }
            }
        } else {
            String pathFromUri2 = getPathFromUri(context, intent.getData());
            if (!TextUtils.isEmpty(pathFromUri2)) {
                arrayList.add(new ImportDocument(pathFromUri2, null));
            }
        }
        return arrayList;
    }

    private String getPathFromUri(Context context, Uri uri) throws Throwable {
        String pathFromUri = UriFileUtils.getPathFromUri(context, uri);
        if (pathFromUri.isEmpty()) {
            pathFromUri = uri.getPath();
        }
        return (TextUtils.isEmpty(pathFromUri) || !pathFromUri.startsWith("/root")) ? pathFromUri : replaceRoot(pathFromUri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createDummy$2(int i, Activity activity) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                DisplayData displayData = new DisplayData();
                String strTrimMaxContentString = DisplayDataConverter.trimMaxContentString(BIG_TEXT_CONTENT);
                displayData.setContent(strTrimMaxContentString);
                notesDocumentEntity.setUuid(UUIDUtils.newUUID(activity));
                notesDocumentEntity.setContent(strTrimMaxContentString);
                notesDocumentEntity.setDisplayContent(DisplayDataHelper.marshall(displayData));
                arrayList.add(notesDocumentEntity);
                NotesDocumentTextSearchEntity notesDocumentTextSearchEntity = new NotesDocumentTextSearchEntity();
                notesDocumentTextSearchEntity.setDocUuid(notesDocumentEntity.getUuid());
                notesDocumentTextSearchEntity.setStrippedContent(BIG_TEXT_CONTENT);
                arrayList2.add(notesDocumentTextSearchEntity);
            }
            NotesDatabaseManager.getInstance().getDocumentDao().upsert((Collection) arrayList);
            NotesDatabaseManager.getInstance().getNotesSearchDao().upsert((Collection) arrayList2);
            return Boolean.TRUE;
        } catch (Exception e) {
            Logger.m8698e(TAG, "importData, e : " + e.getMessage());
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeGenAIAutoTest$3(DialogUtils.ProgressDialog progressDialog) throws Throwable {
        String str;
        SCSLLMRequesterImpl sCSLLMRequesterImpl;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/InputAI";
        String strM1170p = AbstractC0622a.m1170p(File.separator, "outputs", AbstractC1974b.m1324q(str2));
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                Logger.m8698e(TAG, "genAIAutoTest, there is no input txt");
                progressDialog.dismiss();
                return;
            }
            final File file2 = new File(strM1170p);
            if (!file2.exists() && !file2.mkdir()) {
                Logger.m8698e(TAG, "genAIAutoTest, fail to make dir");
                progressDialog.dismiss();
                return;
            }
            int length = fileArrListFiles.length;
            int i = 0;
            while (i < length) {
                final File file3 = fileArrListFiles[i];
                final String path = file3.getPath();
                if (path.endsWith(strM1170p) || !path.endsWith(Constants.TEXT_EXTENSION_WITH_DOT)) {
                    str = strM1170p;
                    Logger.m8698e(TAG, "genAIAutoTest, not txt: " + file3.getPath());
                } else {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    StringBuilder sb = new StringBuilder();
                    final long jElapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file3);
                        try {
                            sb.append(new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8));
                            SCSRequesterType autoTestType = getAutoTestType();
                            if (SCSRequesterType.Summary.equals(autoTestType)) {
                                Summarizer summarizer = new Summarizer(sb.toString(), SummaryStyle.LONG);
                                summarizer.registerCallback(new Operator.Callback() { // from class: com.samsung.android.support.senl.nt.app.labs.DocumentTest.4
                                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                                    public boolean onFailed(@NonNull String str3) {
                                        StringBuilder sbM15l = AbstractC0000a.m15l("genAIAutoSummaryTest, failed: ", str3, ", path: ");
                                        sbM15l.append(file3.getPath());
                                        Logger.m8698e(DocumentTest.TAG, sbM15l.toString());
                                        countDownLatch.countDown();
                                        return true;
                                    }

                                    @Override // com.samsung.android.support.senl.nt.model.assist.llm.Operator.Callback
                                    public void onRetry(Runnable runnable) {
                                        AiCommonUtil.executeRetryAction(runnable);
                                    }

                                    @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                                    public void onSuccess(@NonNull String str3, boolean z) {
                                        DocumentTest.onResult(str3, countDownLatch, file2, path, jElapsedRealtime, "genAIAutoSummaryTest, ");
                                    }
                                });
                                summarizer.execute();
                                str = strM1170p;
                            } else {
                                try {
                                    SCSLLMRequesterImpl sCSLLMRequesterImpl2 = new SCSLLMRequesterImpl();
                                    try {
                                        str = strM1170p;
                                        sCSLLMRequesterImpl = sCSLLMRequesterImpl2;
                                        try {
                                            sCSLLMRequesterImpl.setCallback(new SCSTextResultListener.Callback() { // from class: com.samsung.android.support.senl.nt.app.labs.DocumentTest.5
                                                @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                                                public boolean onFailed(@NonNull String str3) {
                                                    StringBuilder sbM15l = AbstractC0000a.m15l("genAIAutoTest, failed: ", str3, ", path: ");
                                                    sbM15l.append(file3.getPath());
                                                    Logger.m8698e(DocumentTest.TAG, sbM15l.toString());
                                                    countDownLatch.countDown();
                                                    return true;
                                                }

                                                @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
                                                public void onSuccess(@NonNull String str3, boolean z) {
                                                    DocumentTest.onResult(str3, countDownLatch, file2, path, jElapsedRealtime, "getAIAutoTest, ");
                                                }
                                            });
                                            sCSLLMRequesterImpl.requestText(autoTestType, sb.toString());
                                        } catch (Throwable th) {
                                            th = th;
                                            Throwable th2 = th;
                                            try {
                                                sCSLLMRequesterImpl.close();
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str = strM1170p;
                                        sCSLLMRequesterImpl = sCSLLMRequesterImpl2;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    str = strM1170p;
                                }
                                try {
                                    sCSLLMRequesterImpl.close();
                                } catch (Exception e2) {
                                    e = e2;
                                    Logger.m8698e(TAG, "genAIAutoTest, e: " + e.getMessage());
                                    countDownLatch.countDown();
                                }
                            }
                            try {
                                countDownLatch.await();
                                Thread.sleep(10000L);
                            } catch (InterruptedException e3) {
                                try {
                                    Logger.m8698e(TAG, "genAIAutoOutputs, single latch io: " + e3.getMessage());
                                } catch (Throwable th5) {
                                    th = th5;
                                    Throwable th6 = th;
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th7) {
                                        th6.addSuppressed(th7);
                                    }
                                    throw th6;
                                }
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                Logger.m8698e(TAG, "genAIAutoOutputs, io: " + e.getMessage());
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str = strM1170p;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        str = strM1170p;
                    }
                }
                i++;
                strM1170p = str;
            }
        } else {
            Logger.m8698e(TAG, "genAIAutoOutputs, input folder is invalid");
        }
        progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$importData$0(Activity activity, int i, DialogUtils.ProgressDialog progressDialog) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        SecureRandom secureRandom = JavaInstanceConstructor.getSecureRandom();
        try {
            File[] fileArrListFiles = new File(WDocUtils.getNoteFilePath(activity)).listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                int length = fileArrListFiles.length;
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i2 >= i) {
                        C0312d c0312d = new C0312d(activity, arrayList, "tester");
                        c0312d.f808m = createImportTaskListener(activity, progressDialog);
                        c0312d.m664c(false);
                        return;
                    }
                    arrayList.add(new ImportDocument(fileArrListFiles[secureRandom.nextInt(length)].getAbsolutePath(), null));
                    i2 = i4;
                }
            }
            Logger.m8698e(TAG, "importData, documents not exist.");
        } catch (Exception e) {
            Logger.m8698e(TAG, "importData, e : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$importLastData$1(int i, String str, Activity activity, DialogUtils.ProgressDialog progressDialog) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= i) {
                    C0312d c0312d = new C0312d(activity, arrayList, "tester");
                    c0312d.f808m = createImportTaskListener(activity, progressDialog);
                    c0312d.m664c(false);
                    return;
                }
                arrayList.add(new ImportDocument(str, null));
                i2 = i4;
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "importData, e : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onResult(String str, CountDownLatch countDownLatch, File file, String str2, long j, String str3) {
        Logger.m8702i(TAG, str3 + "result: " + str);
        String str4 = File.separator;
        int iLastIndexOf = str2.lastIndexOf(str4);
        if (iLastIndexOf < 0) {
            Logger.m8698e(TAG, str3 + "idx: " + iLastIndexOf);
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder("Performance : ");
        sb.append(jElapsedRealtime / 1000);
        sb.append("s ");
        byte[] bytes = AbstractC2821a.m2224o(sb, "ms\n\n", jElapsedRealtime % 1000).getBytes(StandardCharsets.UTF_8);
        String str5 = file + str4 + ("[OUT]" + str2.substring(iLastIndexOf + 1));
        File file2 = new File(str5);
        try {
            if (!file2.exists() && !file2.createNewFile()) {
                Logger.m8698e(TAG, str3 + "fail to create output File : " + str5);
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str5);
                try {
                    fileOutputStream.write(bytes, 0, bytes.length);
                    for (String str6 : Summarization.splitSentence(str)) {
                        byte[] bytes2 = (str6 + '\n').getBytes(StandardCharsets.UTF_8);
                        fileOutputStream.write(bytes2, 0, bytes2.length);
                    }
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                Logger.m8698e(TAG, str3 + "write: " + e.getMessage());
            } finally {
                countDownLatch.countDown();
            }
        } catch (IOException unused) {
            Logger.m8698e(TAG, str3 + "fail to create output : " + str5);
        }
    }

    private String replaceRoot(String str) {
        return (str == null || !str.startsWith("/root")) ? str : str.replaceFirst("/root", "");
    }

    public static void updateTimeToThePast(@NonNull Context context, int i) {
        UPDATE_DAYS_TO_THE_PAST = i;
        if (i <= 0) {
            ToastHandler.show(context, "updateTimeToThePast: disabled", 0);
            return;
        }
        ToastHandler.show(context, "updateTimeToThePast: " + UPDATE_DAYS_TO_THE_PAST + "days enabled", 0);
    }

    public void createDummy(Activity activity, int i) {
        final DialogUtils.ProgressDialog progressDialog = new DialogUtils.ProgressDialog(activity);
        progressDialog.setTitle("Creating Test Documents...");
        progressDialog.setProgressStyle(1);
        progressDialog.show();
        DataRepositoryScheduler.callable(new CallableC8098c(i, activity)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observe(new OnCompletionListener<Boolean>() { // from class: com.samsung.android.support.senl.nt.app.labs.DocumentTest.3
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                Logger.m8698e(DocumentTest.TAG, "onFail, e : " + exc.getMessage());
                progressDialog.dismiss();
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable Boolean bool) {
                progressDialog.dismiss();
            }
        }).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).execute();
    }

    @RequiresApi(api = 33)
    public void executeGenAIAutoTest(Activity activity) {
        DataRepositoryScheduler.runnable(new RunnableC8097b(this, createProgress(activity), 3)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    public void importData(Activity activity, int i) {
        DataRepositoryScheduler.runnable(new RunnableC0355a(this, activity, i, createProgress(activity), 2)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }

    public void importLastData(Activity activity, int i) {
        DialogUtils.ProgressDialog progressDialogCreateProgress = createProgress(activity);
        Cursor cursorQuery = NotesDataRepositoryFactory.newInstance(activity).createDocumentDataRepository().query("SELECT * FROM sdoc ORDER BY createdAt DESC LIMIT 1", null);
        try {
            int columnIndex = cursorQuery.getColumnIndex("filePath");
            String string = (cursorQuery.getCount() == 1 && cursorQuery.moveToFirst() && columnIndex >= 0) ? cursorQuery.getString(columnIndex) : "";
            cursorQuery.close();
            DataRepositoryScheduler.runnable(new RunnableC4180c(this, i, string, activity, progressDialogCreateProgress, 2)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.labs.IActivityResultListener
    public void onActivityResult(@NonNull Context context, int i, @Nullable Intent intent) throws Throwable {
        if (i != -1 || intent == null) {
            return;
        }
        List<ImportDocument> documentList = getDocumentList(context, intent);
        Logger.m8697d(TAG, "onActivityResult, pathList : " + documentList);
        if (!documentList.isEmpty() && this.mType == 10) {
            new C0312d(context, documentList, TAG).m664c(false);
        }
    }

    public void pick(@NonNull Activity activity) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (activity.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
        }
        intent.addFlags(536870912);
        activity.startActivityForResult(intent, 1);
    }

    public void setType(int i) {
        this.mType = i;
    }
}
