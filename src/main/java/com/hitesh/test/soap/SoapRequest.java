package com.hitesh.test.soap;


import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SoapRequest {


    public static void main(String[] args)
            throws JAXBException, ParserConfigurationException, SOAPException, IOException
    {

        GetPassword request = new GetPassword();
        ObjectFactory objectFactory = new ObjectFactory();
        request.setUserId(objectFactory.createGetPasswordUserId("3977701"));
        request.setPassKey(objectFactory.createGetPasswordPassKey("HelloWorld"));
        request.setPassword(objectFactory.createGetPasswordPassword("123456"));

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Marshaller marshaller = JAXBContext.newInstance(GetPassword.class).createMarshaller();
        marshaller.marshal(request, document);
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        soapMessage.getSOAPBody().addDocument(document);
        Name action = NameImpl.create("Action","wsa", "http://bsestarmf.in/MFOrderEntry/getPassword");
        soapMessage.getSOAPHeader().addHeaderElement(action);
        Name to = NameImpl.create("To","wsa", "https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure");
        soapMessage.getSOAPHeader().addHeaderElement(to);
        soapMessage.getSOAPBody().setPrefix("bses");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        soapMessage.writeTo(outputStream);
        String output = new String(outputStream.toByteArray());
        System.out.println(output);
    }

}
