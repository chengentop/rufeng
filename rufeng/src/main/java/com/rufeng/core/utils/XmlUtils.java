package com.rufeng.core.utils;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtils {
    public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        String str =writer.toString().replace(" standalone=\"yes\"", "");
        return str ;
    }

    public static Object xmlToBean(String XML, Class<?> load) throws Exception, IOException {

        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Source source = trunSource(XML);
        return unmarshaller.unmarshal(source);
    }

    private static Source trunSource(String xmlStr) throws Exception, ParserConfigurationException {
        StringReader reader = new StringReader(xmlStr);
        SAXParserFactory sax = SAXParserFactory.newInstance();
        sax.setNamespaceAware(false);
        XMLReader xmlReader = sax.newSAXParser().getXMLReader();
        return new SAXSource(xmlReader, new InputSource(reader));
    }

}
