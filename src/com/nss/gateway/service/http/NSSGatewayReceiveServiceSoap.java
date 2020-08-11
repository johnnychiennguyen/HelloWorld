/**
 * NSSGatewayReceiveServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nss.gateway.service.http;

public interface NSSGatewayReceiveServiceSoap extends java.rmi.Remote {
    public java.lang.String[] getListDepartment() throws java.rmi.RemoteException;
    public java.lang.String receiveMessageJson(java.lang.String xmlMessage) throws java.rmi.RemoteException;
    public java.lang.String receiveMessage(java.lang.String xmlMessage) throws java.rmi.RemoteException;
}
