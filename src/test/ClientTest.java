package test;

import com.nss.gateway.service.http.Plugin_NSSGateway_NSSGatewayServiceSoapBindingStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.axis.AxisFault;

public class ClientTest {

    public static void main(String[] args) {
        try {
        	//123.30.75.135:8079
        	//123.30.75.134
            String url = "http://123.30.75.134:8079/gw-portlet/api/secure/axis/Plugin_NSSGateway_NSSGatewayService?wsdl";
            //String userName = "ketnoi.viettel";
            //String password = "123@viettel";
            	
            String userName = "hshc.thunghiem";
            String password = "hshc@thunghiem";
            
            Plugin_NSSGateway_NSSGatewayServiceSoapBindingStub stub = new Plugin_NSSGateway_NSSGatewayServiceSoapBindingStub(new URL(url), null);
            stub.setUsername(userName);
            stub.setPassword(password);

            //Lấy danh sách tổ chức
            String[] orgs = stub.getOrganizations("1");
            System.out.println("orgs " + orgs.length);

            //Lấy danh sách văn bản
            String[] messageIds = stub.getReceivedMessageIdsByDocumentType("2.100.1.1");
            System.out.println("messageIds " + messageIds.length);
            
            String[] messageId2s = stub.getMessages();
            
            String m129413629 =stub.getMessageByMessageId("129413629");
            
           
            System.out.println("messageIds " + messageId2s.length);
            System.out.println("messageIds " + m129413629);
            
         //String organ =   stub.getOrganization("0:30:0:0:49:0:2");
         String xmlMessage;
		try {
			xmlMessage = IOUtil.getFileContenntAsString("H:\\Documents\\VNPT_IT\\TrucVXP\\tmp\\m3.xml","utf-8");
			String kqsend = stub.sendMessage(xmlMessage);
			System.out.println(kqsend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
       //  System.out.println("organ " + organ);
        } catch (AxisFault ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
