package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message_receiver database table.
 * 
 */
@Entity
@Table(name="message_receiver")
@NamedQuery(name="MessageReceiver.findAll", query="SELECT m FROM MessageReceiver m")
public class MessageReceiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="message_id")
	private String messageId;

	private String status;

	@Column(name="to_unit_code")
	private String toUnitCode;

	public MessageReceiver() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToUnitCode() {
		return this.toUnitCode;
	}

	public void setToUnitCode(String toUnitCode) {
		this.toUnitCode = toUnitCode;
	}

}