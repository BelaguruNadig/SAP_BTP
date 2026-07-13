
https://help.sap.com/doc/a56f52e1a58e4e2bac7f7adbf45b2e26/Cloud/en-US/index.html */
import com.sap.gateway.ip.core.customdev.util.Message;
def Message processData(Message message) {
    //body
    def body = message.getBody(java.lang.String);
    message.setBody("<Root> body + </Root>");
    //headers
    def headers = message.getHeaders();
    def HValue1 = headers.get("H_VAR1");
    def HValue2 = headers.get("H_VAR2");
    message.setHeader("H_VAR3", HValue1.tointeger() * HValue2.tointeger());
   
    //properties
    def properties = message.getProperties();
    Pvalue1 = properties.get("P_VAR1);
    Pvalue2 = properties.get("P_VAR2);
    message.setProperty("P_VAR3", Pvalue1.tointeger() + Pvalue2.tointeger());
    
    //Message processing log
    def messageLog = messaageLogFactory.getmessageLog(message)
    messageLog.setStringproperty("Bosch Log File")
    messageLog.addAttachementAsString("Bosch log File",body,"text/plain")
    return message;
}