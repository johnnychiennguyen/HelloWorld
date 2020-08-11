package com.nss.gateway.service.http;

public class NSSGatewayServiceSoapProxy implements com.nss.gateway.service.http.NSSGatewayServiceSoap {
  private String _endpoint = null;
  private com.nss.gateway.service.http.NSSGatewayServiceSoap nSSGatewayServiceSoap = null;
  
  public NSSGatewayServiceSoapProxy() {
    _initNSSGatewayServiceSoapProxy();
  }
  
  public NSSGatewayServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initNSSGatewayServiceSoapProxy();
  }
  
  private void _initNSSGatewayServiceSoapProxy() {
    try {
      nSSGatewayServiceSoap = (new com.nss.gateway.service.http.NSSGatewayServiceSoapServiceLocator()).getPlugin_NSSGateway_NSSGatewayService();
      if (nSSGatewayServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)nSSGatewayServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)nSSGatewayServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (nSSGatewayServiceSoap != null)
      ((javax.xml.rpc.Stub)nSSGatewayServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nss.gateway.service.http.NSSGatewayServiceSoap getNSSGatewayServiceSoap() {
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap;
  }
  
  public java.lang.String checkReceiverMessage(long messageId, java.lang.String receiverOrgId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.checkReceiverMessage(messageId, receiverOrgId);
  }
  
  public int getConnectionStatus(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getConnectionStatus(orgCode);
  }
  
  public java.lang.String getDocumentTypes() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getDocumentTypes();
  }
  
  public java.lang.String getDownloadFileURL(java.lang.String ipAddress, java.lang.String fileId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getDownloadFileURL(ipAddress, fileId);
  }
  
  public java.lang.String[] getEdxmlMessageIdsByDocumentType(java.lang.String documentType) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getEdxmlMessageIdsByDocumentType(documentType);
  }
  
  public java.lang.String[] getEdxmlMessageIds() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getEdxmlMessageIds();
  }
  
  public java.lang.String getEdxmlMessage(java.lang.String messageId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getEdxmlMessage(messageId);
  }
  
  public java.lang.String[] getErrorMessage(java.lang.String sendingSystemId, java.lang.String documentType) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getErrorMessage(sendingSystemId, documentType);
  }
  
  public java.lang.String[] getListDepartmentGW(java.lang.String codeOrganization, java.lang.String systemType) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getListDepartmentGW(codeOrganization, systemType);
  }
  
  public java.lang.String getMessageByMessageId(java.lang.String messageId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getMessageByMessageId(messageId);
  }
  
  public java.lang.String getMessageIdsByPriority(java.lang.String documentType, int offset) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getMessageIdsByPriority(documentType, offset);
  }
  
  public java.lang.String getMessagePriorityByMessageId(long messageId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getMessagePriorityByMessageId(messageId);
  }
  
  public java.lang.String[] getMessages() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getMessages();
  }
  
  public int getNumberOfReceiveMessage() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getNumberOfReceiveMessage();
  }
  
  public java.lang.String getOrgGatewayFromOrgInet(java.lang.String agencyCode) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getOrgGatewayFromOrgInet(agencyCode);
  }
  
  public java.lang.String getOrgInetFromOrgGateway(java.lang.String codeOrganization) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getOrgInetFromOrgGateway(codeOrganization);
  }
  
  public java.lang.String getOrganization(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getOrganization(orgCode);
  }
  
  public java.lang.String[] getOrganizations(java.lang.String systemType) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getOrganizations(systemType);
  }
  
  public java.lang.String[] getReceivedDocumentCodes() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getReceivedDocumentCodes();
  }
  
  public java.lang.String[] getReceivedMessageIdsByDocumentType(java.lang.String documentType) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getReceivedMessageIdsByDocumentType(documentType);
  }
  
  public java.lang.String[] getReceivedMessageIdsByStartDateEndDate(long startDateInMilisecond, long endDateInMilisecond) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getReceivedMessageIdsByStartDateEndDate(startDateInMilisecond, endDateInMilisecond);
  }
  
  public java.lang.String[] getReceivedMessageIds() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getReceivedMessageIds();
  }
  
  public java.lang.String getUploadFileURL(java.lang.String ipAddress) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.getUploadFileURL(ipAddress);
  }
  
  public java.lang.String hasReceiverMessage(java.lang.String msId, java.lang.String receiverOrgId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.hasReceiverMessage(msId, receiverOrgId);
  }
  
  public java.lang.String sendMessageEdxml(java.lang.String edxmlMessage) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.sendMessageEdxml(edxmlMessage);
  }
  
  public java.lang.String sendMessage(java.lang.String xmlMessage) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.sendMessage(xmlMessage);
  }
  
  public java.lang.String[] synchronizationAllDepartmentGW() throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.synchronizationAllDepartmentGW();
  }
  
  public java.lang.String[] synchronizationDepartmentByCodeOrganizationGW(java.lang.String codeOrganization) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.synchronizationDepartmentByCodeOrganizationGW(codeOrganization);
  }
  
  public java.lang.String updateErrorMessage(java.lang.String messageId, java.lang.String errorMessage) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.updateErrorMessage(messageId, errorMessage);
  }
  
  public java.lang.String updateReceiveFinish(java.lang.String messageId) throws java.rmi.RemoteException{
    if (nSSGatewayServiceSoap == null)
      _initNSSGatewayServiceSoapProxy();
    return nSSGatewayServiceSoap.updateReceiveFinish(messageId);
  }
  
  
}