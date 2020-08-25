package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
	@XmlElement(name = "message-id")
	private String messageId;
	@XmlElement(name = "for-message-id")
	private String forMessageId;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getForMessageId() {
		return forMessageId;
	}
	public void setForMessageId(String forMessageId) {
		this.forMessageId = forMessageId;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", forMessageId=" + forMessageId + "]";
	}
	
	
}
