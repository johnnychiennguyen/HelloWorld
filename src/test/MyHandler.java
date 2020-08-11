package test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {

	// List to hold Employees object
	private Message emp = null;
	private StringBuilder data = null;


	
	public Message getEmp() {
		return emp;
	}

	public void setEmp(Message emp) {
		this.emp = emp;
	}

	boolean bAge = false;
	boolean bName = false;
	boolean bGender = false;
	boolean bRole = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("message-id")) {
			// create a new Employee and put it in Map
			String id = attributes.getValue("message-id");
			// initialize Employee object and set id attribute
			emp = new Message();
			
			// initialize list
			bAge = true;
		} else if (qName.equalsIgnoreCase("for-message-id")) {
			// set boolean values for fields, will be used in setting Employee variables
			bName = true;
		} 
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAge) {
			// age element, set Employee age
			emp.setMessageId(data.toString());
			bAge = false;
		} 
		
		if (qName.equalsIgnoreCase("message")) {
			// add Employee object to list
			
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}