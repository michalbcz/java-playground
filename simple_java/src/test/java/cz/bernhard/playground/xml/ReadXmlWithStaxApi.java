package cz.bernhard.playground.xml;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.InputStream;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class ReadXmlWithStaxApi {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadXmlWithStaxApi.class); 
	
	@Test
	public void should_read_good_names_with_stax() throws XMLStreamException, InterruptedException {
		
		XMLInputFactory factory = XMLInputFactory.newInstance();		
		InputStream xmlStream = getClass().getResourceAsStream("goods.xml");
		XMLStreamReader xml = factory.createXMLStreamReader(xmlStream);
		
		/* now we are on xml declaration */
		checkArgument(xml.hasNext(), "Xml document is empty or not well-formed.");
				
		xml.next();
		checkArgument("records".equals(xml.getName().toString()), "Xml document seems not valid.");
		
		/* <records> */		
		
		/* iterator over each single <record> */
		List<Record> records = Lists.newArrayList();
		while(xml.hasNext()) {
			xml.next();
			
			if (xml.isStartElement()) { /* as we interested only in elements - without this it stops on every newline*/
				if (QName.valueOf("record").equals(xml.getName())) { 
					records.add(parseRecord(xml));					
				}
				else {
					logger.warn("Expected record element but was {}", xml.getName().toString());
				}
			}
		}
		
		/* </records> */
		
		for (Record record : records) {
			System.out.println(ToStringBuilder.reflectionToString(record));
		}
				
		/* assertions */
		
		Record xperiaActiveRecord = new Record();
		xperiaActiveRecord.setName("Xperia Active");
		xperiaActiveRecord.setBrand("Sony Ericsson");
		xperiaActiveRecord.setProductId("7384");
		Assert.assertTrue(records.size() == 3);
		Assert.assertTrue("Doesn't contain Xperia Active product but it should", records.contains(xperiaActiveRecord));
		
	}
	
	private Record parseRecord(XMLStreamReader reader) throws XMLStreamException {
		
		checkArgument(
				QName.valueOf("record").equals(reader.getName()), 
				"Parsing of record assuming that reader stays on <record> element when call this method"); 
		
		if (!reader.hasNext()) {
			return new EmptyRecord();
		}
		else {
			Record record = new Record();
			while(reader.hasNext()) {
				
				reader.next();
				
				if (reader.isStartElement()) { /* skip line endings */
					
					String currentElementName = reader.getName().toString(); 
					String currentElementText = reader.getElementText();
					
					/* this is java 1.7 construction - string switch */
					switch (currentElementName) {
						case "product_id":
							record.setProductId(currentElementText);
							break;
					
						case "brand":
							record.setBrand(currentElementText);
							break;
						
						case "name":
							record.setName(currentElementText);
							break;
	
						default:
							logger.warn("Unknown element '{}'", currentElementName);
							break;
					}
										
				}
				
				if (reader.isEndElement() && reader.getName().equals(QName.valueOf("record"))) {					
					/* when </record> occured we */ break; /* as we are done */
				}
			}
			return record;
		}
		
		
	}

	private void setProductId(Record record, XMLStreamReader reader) {
		
		
	}
	

}
