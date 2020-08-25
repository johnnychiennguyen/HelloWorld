package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message_content database table.
 * 
 */
@Entity
@Table(name="message_content")
@NamedQuery(name="MessageContent.findAll", query="SELECT m FROM MessageContent m")
public class MessageContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="message_id")
	private String messageId;

	@Lob
	private byte[] content;

	public MessageContent() {
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}