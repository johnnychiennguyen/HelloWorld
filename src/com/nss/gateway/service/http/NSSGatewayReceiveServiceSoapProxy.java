package com.nss.gateway.service.http;

public class NSSGatewayReceiveServiceSoapProxy implements com.nss.gateway.service.http.NSSGatewayReceiveServiceSoap {
  private String _endpoint = null;
  private com.nss.gateway.service.http.NSSGatewayReceiveServiceSoap nSSGatewayReceiveServiceSoap = null;
  
  public NSSGatewayReceiveServiceSoapProxy() {
    _initNSSGatewayReceiveServiceSoapProxy();
  }
  
  public NSSGatewayReceiveServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initNSSGatewayReceiveServiceSoapProxy();
  }
  
  private void _initNSSGatewayReceiveServiceSoapProxy() {
    try {
      nSSGatewayReceiveServiceSoap = (new com.nss.gateway.service.http.NSSGatewayReceiveServiceSoapServiceLocator()).getPlugin_NSSGateway_NSSGatewayReceiveService();
      if (nSSGatewayReceiveServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)nSSGatewayReceiveServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)nSSGatewayReceiveServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (nSSGatewayReceiveServiceSoap != null)
      ((javax.xml.rpc.Stub)nSSGatewayReceiveServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nss.gateway.service.http.NSSGatewayReceiveServiceSoap getNSSGatewayReceiveServiceSoap() {
    if (nSSGatewayReceiveServiceSoap == null)
      _initNSSGatewayReceiveServiceSoapProxy();
    return nSSGatewayReceiveServiceSoap;
  }
  
  public java.lang.String[] getListDepartment() throws java.rmi.RemoteException{
    if (nSSGatewayReceiveServiceSoap == null)
      _initNSSGatewayReceiveServiceSoapProxy();
    return nSSGatewayReceiveServiceSoap.getListDepartment();
  }
  
  public java.lang.String receiveMessageJson(java.lang.String xmlMessage) throws java.rmi.RemoteException{
    if (nSSGatewayReceiveServiceSoap == null)
      _initNSSGatewayReceiveServiceSoapProxy();
    return nSSGatewayReceiveServiceSoap.receiveMessageJson(xmlMessage);
  }
  
  public java.lang.String receiveMessage(java.lang.String xmlMessage) throws java.rmi.RemoteException{
    if (nSSGatewayReceiveServiceSoap == null)
      _initNSSGatewayReceiveServiceSoapProxy();
    return nSSGatewayReceiveServiceSoap.receiveMessage(xmlMessage);
  }
  
  
}