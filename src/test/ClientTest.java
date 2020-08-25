package test;

import com.nss.gateway.service.http.Plugin_NSSGateway_NSSGatewayServiceSoapBindingStub;

import bean.MessageJpaController;
import bean.exceptions.PreexistingEntityException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import model.Message;
import model.MessageContent;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.axis.AxisFault;
import org.xml.sax.InputSource;

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
//            String[] orgs = stub.getOrganizations("1");
//            for (String orgStr : orgs) {
//            	System.out.println(orgStr);
//			}
            

            //Lấy danh sách văn bản
//            String[] messageIds = stub.getReceivedMessageIdsByDocumentType("2.100.1.1");
//            System.out.println("messageIds length: " + messageIds.length);
//            
//            String[] messageId2s = stub.getMessages();
//            for (String message : messageId2s) {
//            	System.out.println(message);
//			}
            
            String m129413629 =stub.getMessageByMessageId("129413629");
//            
//            System.out.println("messageId2s length: " + messageId2s.length);
            System.out.println("messageIds " + m129413629);
            
         //String organ =   stub.getOrganization("0:30:0:0:49:0:2");
//         String xmlMessage;
            
//            String fileStr = stub.getDownloadFileURL("", "50679751");
//		try {
//			xmlMessage = IOUtil.getFileContenntAsString("H:\\Documents\\VNPT_IT\\TrucVXP\\tmp\\m3.xml","utf-8");
//			String kqsend = stub.sendMessage(xmlMessage);
//			System.out.println(kqsend);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
            String xmlMau = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
            		"<message>\r\n" + 
            		"	<message-id>\r\n" + 
            		"		<![CDATA[129413629]]>\r\n" + 
            		"	</message-id>\r\n" + 
            		"	<for-message-id>\r\n" + 
            		"		<![CDATA[]]>\r\n" + 
            		"	</for-message-id>\r\n" + 
            		"	<required-answer>\r\n" + 
            		"		<![CDATA[0]]>\r\n" + 
            		"	</required-answer>\r\n" + 
            		"	<send-date>\r\n" + 
            		"		<![CDATA[1595911337907]]>\r\n" + "1598237926521\r\n" + 
            		"	</send-date>\r\n" + 
            		"	<sending-system-id>\r\n" + 
            		"		<![CDATA[0:30:0:0:49:0:2]]>\r\n" + 
            		"	</sending-system-id>\r\n" + 
            		"	<receiving-system-id>\r\n" + 
            		"		<![CDATA[0:30:0:0:100:0:2]]>\r\n" + 
            		"	</receiving-system-id>\r\n" + 
            		"	<document-type>\r\n" + 
            		"		<![CDATA[2.100.1.1]]>\r\n" + 
            		"	</document-type>\r\n" + 
            		"	<document-code>\r\n" + 
            		"		<![CDATA[0230012342000001]]>\r\n" + 
            		"	</document-code>\r\n" + 
            		"	<description>\r\n" + 
            		"		<![CDATA[HSMC SoBienNhan = 0230012342000001]]>\r\n" + 
            		"	</description>\r\n" + 
            		"	<content>\r\n" + 
            		"		<![CDATA[eyJ0ZW5Mb2FpSG9TbyI6IkPhuqVwIGdp4bqleSBjaOG7qW5nIG5o4bqtbiBodeG6pW4gbHV54buHbiBuZ2hp4buHcCB24bulIGPhu6l1IG7huqFuLCBj4bupdSBo4buZIiwidGVuUXVvY1RpY2giOiJOZ8aw4budaSBWaeG7h3QgTmFtIiwiZ2lvaVRpbmgiOjEsIm5nYXlIZW5UcmFIb1NvIjoxNTk2NTYwMzk5OTk5LCJzb0dpYXlDaHVuZ1RodWMiOiIiLCJob1NvVGh1b2NUb0NodWMiOmZhbHNlLCJ0ZW5EYW5Ub2MiOiJLaW5oIiwic29UaHVhQmFuRG8iOiIiLCJtYURhblRvYyI6IjAxIiwiaG9Tb0tlbVRoZW9zIjpbeyJzb0JhblBob3RvIjowLCJzb0JhbkNoaW5oIjoxLCJ0ZW4iOiLEkMahbiDEkeG7gSBuZ2jhu4sga2nhu4NtIHRyYSwgY+G6pXAgZ2nhuqV5IGNo4bupbmcgbmjhuq1uIGh14bqlbiBsdXnhu4duIiwic29CYW5TYW8iOjAsImhvU29LZW1UaGVvSG9Tb0lkIjo1MDY3OTc1MSwibW9UYSI6IiJ9LHsic29CYW5QaG90byI6MCwic29CYW5DaGluaCI6MSwidGVuIjoiS+G6vyBob+G6oWNoLCBjaMawxqFuZyB0csOsbmggbuG7mWkgZHVuZyBodeG6pW4gbHV54buHbiIsInNvQmFuU2FvIjowLCJob1NvS2VtVGhlb0hvU29JZCI6NTA2Nzk3NTIsIm1vVGEiOiIifSx7InNvQmFuUGhvdG8iOjAsInNvQmFuQ2hpbmgiOjEsInRlbiI6IkRhbmggc8OhY2ggdHLDrWNoIG5nYW5nIGzDvSBs4buLY2ggY+G7p2EgbmfGsOG7nWkgxJHDoyBk4buxIGzhu5twIGh14bqlbiBsdXnhu4duIiwic29CYW5TYW8iOjAsImhvU29LZW1UaGVvSG9Tb0lkIjo1MDY3OTc1MywibW9UYSI6IiJ9LHsic29CYW5QaG90byI6MCwic29CYW5DaGluaCI6MSwidGVuIjoixJDGoW4gxJHhu4Egbmdo4buLIHThu5UgY2jhu6ljIGh14bqlbiBsdXnhu4duIiwic29CYW5TYW8iOjAsImhvU29LZW1UaGVvSG9Tb0lkIjo1MDY3OTc1NCwibW9UYSI6IiJ9LHsic29CYW5QaG90byI6MCwic29CYW5DaGluaCI6MSwidGVuIjoiRGFuaCBzw6FjaCB0csOtY2ggbmdhbmcgbMO9IGzhu4tjaCBj4bunYSBuZ8aw4budaSDEkcSDbmcga8O9IGThu7EgbOG7m3AgaHXhuqVuIGx1eeG7h24iLCJzb0JhblNhbyI6MCwiaG9Tb0tlbVRoZW9Ib1NvSWQiOjUwNjc5NzU1LCJtb1RhIjoiIn0seyJzb0JhblBob3RvIjowLCJzb0JhbkNoaW5oIjoxLCJ0ZW4iOiJDw6EgbmjDom4gY8OzIG5odSBj4bqndSDEkcaw4bujYyBodeG6pW4gbHV54buHbiB2w6AgeGluIGPhuqVwIGdp4bqleSBjaOG7qW5nIG5o4bqtbiBodeG6pW4gbHV54buHbiBuZ2hp4buHcCB24bulIGPhu6l1IG7huqFuLCBj4bupdSBo4buZIHBo4bqjaSBu4buZcCDEkcahbiDEkcSDbmcga8O9IGThu7EgbOG7m3AgaHXhuqVuIGx1eeG7h24iLCJzb0JhblNhbyI6MCwiaG9Tb0tlbVRoZW9Ib1NvSWQiOjUwNjc5NzU2LCJtb1RhIjoiIn1dLCJ0ZW5LaHVDb25nTmdoaWVwIjoiIiwiaG9WYVRlbktoYWNoSGFuZyI6Ikjhu5MgU8ahIFRlc3QiLCJtYVF1b2NUaWNoIjoiMDE3IiwibG9haUdpYXlDaHVuZ1RodWMiOjEsImd1aU1vaUhvU29RdWFNYW5nIjpmYWxzZSwiZGllblRob2FpIjoiMDk2MjgyOTg0MCIsImdoaUNodSI6IlRo4butIG5naGnhu4dtIGNodXnhu4NuIMSR4buVaS4uLi4iLCJkaWFDaGlEYW5nS3lEYXlEdSI6IlBoxrDhu51uZyBUw6JuIEJpw6puLCBUaMOgbmggcGjhu5EgQmnDqm4gSMOyYSwgVOG7iW5oIMSQ4buTbmcgTmFpIiwidGVuRGVtS2hhY2hIYW5nIjoiIiwid2ViU2l0ZSI6IiIsIm5nYXlTaW5oIjowLCJ0ZW5IZVRob25nR3VpIjoiQ+G6o25oIHPDoXQgcGjDsm5nIGNow6F5IGNo4buvYSBjaMOheSIsImhvS2hhY2hIYW5nIjoiIiwiZGlhQ2hpR2lhb0RpY2giOiJQaMaw4budbmcgVMOibiBCacOqbiwgVGjDoG5oIHBo4buRIEJpw6puIEjDsmEsIFThu4luaCDEkOG7k25nIE5haSIsInNvQmllbk5oYW4iOiIwMjMwMDEyMzQyMDAwMDAxIiwiaG9Tb0lkIjo0MTE4NTQ1NCwic29Ub0JhbkRvIjoiIiwiZmF4IjoiIiwibWFLVkhDIjoiMjU5OTkiLCJzb0ZpbGVEaW5oS2VtIjowLCJ0ZW5MaW5oVnVjIjoiTMSpbmggduG7sWMgUGjDsm5nIGNow6F5IGNo4buvYSBjaMOheSIsImRpYUNoaVRhbVRydSI6IlBoxrDhu51uZyBUw6JuIEJpw6puLCBUaMOgbmggcGjhu5EgQmnDqm4gSMOyYSwgVOG7iW5oIMSQ4buTbmcgTmFpIiwibmdheUNhcEdpYXlDaHVuZ1RodWMiOjAsInRlbktoYWNoSGFuZyI6IiIsIm1hTGluaFZ1YyI6IkxWUENDQyIsImVtYWlsIjoiIiwibWFIZVRob25nR3VpIjoiMDozMDowOjA6NDk6MDoyIiwiZGlhQ2hpVGh1b25nVHJ1IjoiIiwibWFMb2FpSG9TbyI6IkxWUENDQzAxIiwibWFTb1RodWVUb0NodWMiOiIiLCJ0ZW5Ub0NodWMiOiIiLCJuZ2F5VGllcE5oYW5Ib1NvIjoxNTk1OTExMzQ2NDc4LCJ0cmljaFlldSI6IiIsIm5vaUNhcEdpYXlDaHVuZ1RodWMiOiIiLCJob1NvTGllbkNhcCI6eyJlbWFpbE5vaU5oYW4iOiIiLCJzb0RpZW5UaG9haU5vaU5oYW4iOiIiLCJuZ2F5UGhhdEhhbmgiOjE1OTU4NjkyMDAwMDAsImd1aU1vaUhvU29RdWFNYW5nIjpmYWxzZSwidXNlcklkIjoyNDI0MzUyMCwidGlldURlIjoiIiwibmdheUhvYW5UaGFuaExpZW5DYXAiOm51bGwsInVzZXJOYW1lIjoiQuG7mSBwaOG6rW4gdGnhur9wIG5o4bqtbiB2w6AgdHLhuqMga+G6v3QgcXXhuqMgLSBDU1BDQ0MiLCJ0ZW5Eb25WaU5oYW4iOiIgVGjhu60gbmdoaeG7h20gZ+G7rWkgbmjhuq1uIEhTSEMiLCJjcmVhdGVEYXRlIjoxNTk1OTExNDM2OTY1LCJuZ2F5VGllcE5oYW5MaWVuQ2FwIjpudWxsLCJoaW5oVGh1Y1Rob25nQmFvIjowLCJjb25nVmllY0lkIjo1MzI1MjYwMSwic29CaWVuTmhhbkxpZW5DYXAiOiIiLCJoaW5oVGh1YyI6MSwiZHVvbmdDaHV5ZW5JZCI6MTYwMDU1NywiaG9Tb01vdEN1YUlkIjo0MTE4NTQ1NCwibW9kaWZpZWREYXRlIjoxNTk1OTExNDM2OTY1LCJzb1BoYXRIYW5oIjoiIiwiaG9Tb0xpZW5DYXBJZCI6Mjg0OTEwMSwiZ3JvdXBJZCI6MjMzNDYyMzYsIm1hSG9Tb0xpZW5DYXBJZCI6IiIsImx5RG9HdWlMaWVuQ2FwIjoiVGjhu60gbmdoaeG7h20gY2h1eeG7g24gxJHhu5VpLi4uLiIsIm1hRG9uVmlOaGFuIjoiMDozMDowOjA6MTAwOjA6MiIsIm1hRG9uVmlHdWkiOiIwOjMwOjA6MDo0OTowOjIiLCJuZ2F5SGVuVHJhTGllbkNhcCI6bnVsbCwiY29tcGFueUlkIjoyMzMyODEwMH0sImRpYUNoaURhbmdLeSI6eyJ0ZW5EdW9uZyI6IiIsInRlblF1YW5IdXllbiI6IlRow6BuaCBwaOG7kSBCacOqbiBIw7JhIiwiZHVvbmdLaGFjIjoiIiwic29OaGEiOiIiLCJraHVQaG8iOiIiLCJ0ZW5UaGFuaFBobyI6IlThu4luaCDEkOG7k25nIE5haSIsInRlblBodW9uZ1hhIjoiUGjGsOG7nW5nIFTDom4gQmnDqm4ifX0=]]>\r\n" + 
            		"	</content>\r\n" + 
            		"	<title>\r\n" + 
            		"		<![CDATA[]]>\r\n" + 
            		"	</title>\r\n" + 
            		"	<department-id>\r\n" + 
            		"		<![CDATA[]]>\r\n" + 
            		"	</department-id>\r\n" + 
            		"	<department-send-id>\r\n" + 
            		"		<![CDATA[]]>\r\n" + 
            		"	</department-send-id>\r\n" + 
            		"	<attach-files>\r\n" + 
            		"		<attach-file>\r\n" + 
            		"			<attach-file-id>\r\n" + 
            		"				<![CDATA[GW-TUThNTV]]>\r\n" + 
            		"			</attach-file-id>\r\n" + 
            		"			<file-name>\r\n" + 
            		"				<![CDATA[61.signed.pdf]]>\r\n" + 
            		"			</file-name>\r\n" + 
            		"			<extension>\r\n" + 
            		"				<![CDATA[.pdf]]>\r\n" + 
            		"			</extension>\r\n" + 
            		"			<mime-type>\r\n" + 
            		"				<![CDATA[application/octet-stream]]>\r\n" + 
            		"			</mime-type>\r\n" + 
            		"			<title>\r\n" + 
            		"				<![CDATA[61.signed]]>\r\n" + 
            		"			</title>\r\n" + 
            		"			<description>\r\n" + 
            		"				<![CDATA[]]>\r\n" + 
            		"			</description>\r\n" + 
            		"			<extra-settings>\r\n" + 
            		"				<![CDATA[application/octet-stream]]>\r\n" + 
            		"			</extra-settings>\r\n" + 
            		"			<file-size>\r\n" + 
            		"				<![CDATA[1675840]]>\r\n" + 
            		"			</file-size>\r\n" + 
            		"		</attach-file>\r\n" + 
            		"		<attach-file>\r\n" + 
            		"			<attach-file-id>\r\n" + 
            		"				<![CDATA[GW-TUThNTV1234]]>\r\n" + 
            		"			</attach-file-id>\r\n" + 
            		"			<file-name>\r\n" + 
            		"				<![CDATA[62.signed.pdf]]>\r\n" + 
            		"			</file-name>\r\n" + 
            		"			<extension>\r\n" + 
            		"				<![CDATA[.pdf]]>\r\n" + 
            		"			</extension>\r\n" + 
            		"			<mime-type>\r\n" + 
            		"				<![CDATA[application/octet-stream]]>\r\n" + 
            		"			</mime-type>\r\n" + 
            		"			<title>\r\n" + 
            		"				<![CDATA[62.signed]]>\r\n" + 
            		"			</title>\r\n" + 
            		"			<description>\r\n" + 
            		"				<![CDATA[]]>\r\n" + 
            		"			</description>\r\n" + 
            		"			<extra-settings>\r\n" + 
            		"				<![CDATA[application/octet-stream]]>\r\n" + 
            		"			</extra-settings>\r\n" + 
            		"			<file-size>\r\n" + 
            		"				<![CDATA[2675840]]>\r\n" + 
            		"			</file-size>\r\n" + 
            		"		</attach-file>\r\n" + 
            		"	</attach-files>\r\n" + 
            		"	<option>\r\n" + 
            		"		<![CDATA[0]]>\r\n" + 
            		"	</option>\r\n" + 
            		"	<stateProcess>\r\n" + 
            		"		<![CDATA[-999]]>\r\n" + 
            		"	</stateProcess>\r\n" + 
            		"	<signature>\r\n" + 
            		"		<![CDATA[]]>\r\n" + 
            		"	</signature>\r\n" + 
            		"	<edxml>\r\n" + 
            		"		<![CDATA[0]]>\r\n" + 
            		"	</edxml>\r\n" + 
            		"</message>\r\n" + 
            		"";
            
            MessageJpaController mJPAController = new MessageJpaController();
            try {
//                File file = new File("department_jaxb.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
     
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Message message = (Message) jaxbUnmarshaller.unmarshal(new InputSource(new StringReader(m129413629)));
                message.setStatus("1");
//                message.setSendDate(new Date(message.getSendDateXML()));
//                message.setCreatedAt(new Date());
                MessageContent messageContent = new MessageContent();
                messageContent.setMessageId(message.getId());
                messageContent.setContent(message.getContent().getBytes());
                
                System.out.println(message);
                try {
					mJPAController.create(message, messageContent);
				} catch (PreexistingEntityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            
        } catch (AxisFault ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
