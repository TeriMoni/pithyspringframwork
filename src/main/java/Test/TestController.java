package Test;

import annotation.Action;
import annotation.Controller;
import bean.Data;
import bean.Param;
import bean.View;

/**
 * @Autor: bin.liu
 * @Desciption:
 * @Date: Created in 17:02 2017/9/8
 */
@Controller
public class TestController {

    @Action("get:/index")
    public View test(Param param){
        Data data = new Data("{'timestamp':'1500953867601','systemInfo':{'brand':'华为','startTime':'1500953867507','android_version':'4.4.4','ramMemory':'1910','model':'Che1-CL10','romSize':4169,'manufacture':'HUAWEI','location':'','cpuName':'ARMv7 Processor rev 0 (v7l)','cpuCoreNum':'4','brand':'Honor','maxCpuFreq':'1209600','timeZone':'GMT+08:00 Timezon id :: Asia///Shanghai','screenResolution':'720 * 1280'},'userId':'10001008','environmentalInfo':{'isRoot':true,'isEmulator':false},'type':'android','networkInfo':{'IMSI':'460037790089279','SimNo':'89860316245126220616','NetworkType':'WIFI','PhoneNumber':'','MAC':'7C:7D:3D:1F:B5:E1','IMEI':'A0000055EE8A7D','NetWorkOperator':'中国电信'},'currentAppInfo':{'brand':'华为','appName':'EnvironmentClearance','pubKey':'OpenSSLRSAPublicKey{modulus=cea28fb909d225276852b7f699acbe6c9c8d7b7415e6464ce6d7e24eb9cc70a37fe03a5563825ff2199c221c881da0919f719f866b3d4b9fd213addc1d8859e6039d39547d649eca0d057242e9d3e937f26b67ff598407046939badc251efc21ed3e4795e8be6366feefefd2ec1dfd5ef31538bf24d11bbfcd742facdb3a16cb,publicExponent=10001}','issuer':'C=US, O=Android, CN=Android Debug','lastModified':'1500953681000','firstInstallTime':'1500948246573','packageName':'com.enviroment.clearance.demo','signName':'SHA1WithRSA','lastUpdateTime':'1500953682166','MD5':'567ddf268cd8fc904770114973a97070','subjectDN':'C=US, O=Android, CN=Android Debug','serialNumber':'1','versionCode':'1','versionName':'1.0'},'attackMonitor':{'dexHook':'@com.enviroment.xposed.demo-1.apk@classes.dex\\\\n','isDebug':true,'soHook':'','rePackage':'ssre sdspack','isHijack':{'appPackage':'com.doubee.mtkmaster','appVersion':'4.3.2'}},'signature':'c113d9bb851714e2b8ace6875fa04d29'}");
        return new View("index.jsp").addModel("name","刘斌");
    }

    @Action("get:/data")
    public Data data(Param param){
        System.out.println(1);
        Data data = new Data("{'timestamp':'1500953867601','systemInfo':{'brand':'华为','startTime':'1500953867507','android_version':'4.4.4','ramMemory':'1910','model':'Che1-CL10','romSize':4169,'manufacture':'HUAWEI','location':'','cpuName':'ARMv7 Processor rev 0 (v7l)','cpuCoreNum':'4','brand':'Honor','maxCpuFreq':'1209600','timeZone':'GMT+08:00 Timezon id :: Asia///Shanghai','screenResolution':'720 * 1280'},'userId':'10001008','environmentalInfo':{'isRoot':true,'isEmulator':false},'type':'android','networkInfo':{'IMSI':'460037790089279','SimNo':'89860316245126220616','NetworkType':'WIFI','PhoneNumber':'','MAC':'7C:7D:3D:1F:B5:E1','IMEI':'A0000055EE8A7D','NetWorkOperator':'中国电信'},'currentAppInfo':{'brand':'华为','appName':'EnvironmentClearance','pubKey':'OpenSSLRSAPublicKey{modulus=cea28fb909d225276852b7f699acbe6c9c8d7b7415e6464ce6d7e24eb9cc70a37fe03a5563825ff2199c221c881da0919f719f866b3d4b9fd213addc1d8859e6039d39547d649eca0d057242e9d3e937f26b67ff598407046939badc251efc21ed3e4795e8be6366feefefd2ec1dfd5ef31538bf24d11bbfcd742facdb3a16cb,publicExponent=10001}','issuer':'C=US, O=Android, CN=Android Debug','lastModified':'1500953681000','firstInstallTime':'1500948246573','packageName':'com.enviroment.clearance.demo','signName':'SHA1WithRSA','lastUpdateTime':'1500953682166','MD5':'567ddf268cd8fc904770114973a97070','subjectDN':'C=US, O=Android, CN=Android Debug','serialNumber':'1','versionCode':'1','versionName':'1.0'},'attackMonitor':{'dexHook':'@com.enviroment.xposed.demo-1.apk@classes.dex\\\\n','isDebug':true,'soHook':'','rePackage':'ssre sdspack','isHijack':{'appPackage':'com.doubee.mtkmaster','appVersion':'4.3.2'}},'signature':'c113d9bb851714e2b8ace6875fa04d29'}");
        return data;
    }
}
