/**
 * NSSGatewayServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nss.gateway.service.http;

public interface NSSGatewayServiceSoap extends java.rmi.Remote {
    public java.lang.String checkReceiverMessage(long messageId, java.lang.String receiverOrgId) throws java.rmi.RemoteException;
    public int getConnectionStatus(java.lang.String orgCode) throws java.rmi.RemoteException;
    public java.lang.String getDocumentTypes() throws java.rmi.RemoteException;
    public java.lang.String getDownloadFileURL(java.lang.String ipAddress, java.lang.String fileId) throws java.rmi.RemoteException;
    public java.lang.String[] getEdxmlMessageIdsByDocumentType(java.lang.String documentType) throws java.rmi.RemoteException;
    public java.lang.String[] getEdxmlMessageIds() throws java.rmi.RemoteException;
    public java.lang.String getEdxmlMessage(java.lang.String messageId) throws java.rmi.RemoteException;
    public java.lang.String[] getErrorMessage(java.lang.String sendingSystemId, java.lang.String documentType) throws java.rmi.RemoteException;
    public java.lang.String[] getListDepartmentGW(java.lang.String codeOrganization, java.lang.String systemType) throws java.rmi.RemoteException;
    public java.lang.String getMessageByMessageId(java.lang.String messageId) throws java.rmi.RemoteException;
    public java.lang.String getMessageIdsByPriority(java.lang.String documentType, int offset) throws java.rmi.RemoteException;
    public java.lang.String getMessagePriorityByMessageId(long messageId) throws java.rmi.RemoteException;
    public java.lang.String[] getMessages() throws java.rmi.RemoteException;
    public int getNumberOfReceiveMessage() throws java.rmi.RemoteException;
    public java.lang.String getOrgGatewayFromOrgInet(java.lang.String agencyCode) throws java.rmi.RemoteException;
    public java.lang.String getOrgInetFromOrgGateway(java.lang.String codeOrganization) throws java.rmi.RemoteException;
    public java.lang.String getOrganization(java.lang.String orgCode) throws java.rmi.RemoteException;
    public java.lang.String[] getOrganizations(java.lang.String systemType) throws java.rmi.RemoteException;
    public java.lang.String[] getReceivedDocumentCodes() throws java.rmi.RemoteException;
    public java.lang.String[] getReceivedMessageIdsByDocumentType(java.lang.String documentType) throws java.rmi.RemoteException;
    public java.lang.String[] getReceivedMessageIdsByStartDateEndDate(long startDateInMilisecond, long endDateInMilisecond) throws java.rmi.RemoteException;
    public java.lang.String[] getReceivedMessageIds() throws java.rmi.RemoteException;
    public java.lang.String getUploadFileURL(java.lang.String ipAddress) throws java.rmi.RemoteException;
    public java.lang.String hasReceiverMessage(java.lang.String msId, java.lang.String receiverOrgId) throws java.rmi.RemoteException;
    public java.lang.String sendMessageEdxml(java.lang.String edxmlMessage) throws java.rmi.RemoteException;
    public java.lang.String sendMessage(java.lang.String xmlMessage) throws java.rmi.RemoteException;
    public java.lang.String[] synchronizationAllDepartmentGW() throws java.rmi.RemoteException;
    public java.lang.String[] synchronizationDepartmentByCodeOrganizationGW(java.lang.String codeOrganization) throws java.rmi.RemoteException;
    public java.lang.String updateErrorMessage(java.lang.String messageId, java.lang.String errorMessage) throws java.rmi.RemoteException;
    public java.lang.String updateReceiveFinish(java.lang.String messageId) throws java.rmi.RemoteException;
}
