package gestion.producto.mant.consult.utilitarios;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;



public final class JAXBUtilitarios {


  private static final Logger wlLogger = LoggerFactory.getLogger(JAXBUtilitarios.class);

  @SuppressWarnings("rawtypes")
  private static HashMap<Class, JAXBContext> mapContexts = new HashMap<Class, JAXBContext>();

  private JAXBUtilitarios() {
    super();
  }

  @SuppressWarnings("rawtypes")
  public static JAXBContext obtainJaxBContextFromClass(Class clas) {
    JAXBContext context;
    context = mapContexts.get(clas);
    if (context == null) {
      try {
        wlLogger.info("Inicializando jaxcontext... para la clase " + clas.getName());
        context = JAXBContext.newInstance(clas);
        mapContexts.put(clas, context);
      } catch (Exception e) {
        wlLogger.error("Error creando JAXBContext:", e);
      }
    }
    return context;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static String anyObjectToXmlText(Object objJaxB) {

    String commandoRequestEnXml = null;
    JAXBContext context;
    try {
      context = obtainJaxBContextFromClass(objJaxB.getClass());
      if (context != null) {
        Marshaller marshaller = context.createMarshaller();
        StringWriter xmlWriter = new StringWriter();
        marshaller.marshal(new JAXBElement(new QName("", objJaxB.getClass().getName()), objJaxB.getClass(), objJaxB),
          xmlWriter);
        commandoRequestEnXml = prettyFormatXML(xmlWriter.toString());
        if (commandoRequestEnXml != null) {
          commandoRequestEnXml = commandoRequestEnXml.trim();
        }
      }
    } catch (Exception e) {
      wlLogger.error(Constantes.ERROR, e);
    }
    return commandoRequestEnXml;
  }

  public static String prettyFormatXML(String xml) {
    try {
      final InputSource src = new InputSource(new StringReader(xml));
      final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
      final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
      final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
      final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
      final LSSerializer writer = impl.createLSSerializer();

      writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Enviar como TRUE si el XML
      // necesita ser embellecido.
      writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Enviar como TRUE si la salida
      // necesita ser expuesta.
      return writer.writeToString(document);
    } catch (Exception e) {
      wlLogger.error(Constantes.ERROR, e);
    }
    return null;
  }
}
