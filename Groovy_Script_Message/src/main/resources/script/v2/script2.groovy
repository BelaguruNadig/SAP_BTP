// Groovy Flowstep Version 2.x, Groovy runtime 4
import com.sap.it.script.v2.api.Message

def Message processData(Message message) {
    // Body
    def body = message.getBody(String)
    message.setBody("<Root>" + body + "</Root>")

    // Headers
    def headers = message.getHeaders()
    def HValue1 = headers.get("H_VAR1")
    def HValue2 = headers.get("H_VAR2")
    message.setHeader("H_VAR3", HValue1.toInteger() * HValue2.toInteger())

    // Properties
    def properties = message.getProperties()
    def Pvalue1 = properties.get("P_VAR1")
    def Pvalue2 = properties.get("P_VAR2")
    message.setProperty("P_VAR3", Pvalue1.toInteger() + Pvalue2.toInteger())

    return message
}
