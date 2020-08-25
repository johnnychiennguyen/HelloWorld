package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement(name = "message-id")
	private String id;

	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "document-code")
	@Column(name="document_code")
	private String documentCode;

	@XmlElement(name = "document-type")
	@Column(name="document_type")
	private String documentType;

	@XmlElement(name = "for-message-id")
	@Column(name="for_message_id")
	private String forMessageId;

	@Column(name="from_unit_code")
	private String fromUnitCode;

	@Column(name="modified_at")
	@Temporal(TemporalType.DATE)
	private Date modifiedAt;

	@Column(name="number_received")
	private int numberReceived;

	@Transient
	private String option;
	
	@Transient
	@XmlElement(name = "content")
	private String content;
	
	@XmlElement(name = "required-answer")
	@Column(name="required_answer")
	private String requiredAnswer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="send_date")
	private Date sendDate;
	
	@XmlElement(name = "send-date")
	@Transient
	private Long sendDateXML;

	private String signature;

	private String status;

	@Transient
	@XmlElementWrapper(name = "attach-files")
	@XmlElement(name = "attach-file")
	private List<MessageFile> attachFileList;
	
	public Message() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MessageFile> getAttachFileList() {
		return attachFileList;
	}

	public void setAttachFileList(List<MessageFile> attachFileList) {
		this.attachFileList = attachFileList;
	}

	public String getDocumentCode() {
		return this.documentCode;
	}

	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getForMessageId() {
		return this.forMessageId;
	}

	public void setForMessageId(String forMessageId) {
		this.forMessageId = forMessageId;
	}

	public String getFromUnitCode() {
		return this.fromUnitCode;
	}

	public void setFromUnitCode(String fromUnitCode) {
		this.fromUnitCode = fromUnitCode;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getNumberReceived() {
		return this.numberReceived;
	}

	public void setNumberReceived(int numberReceived) {
		this.numberReceived = numberReceived;
	}

	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getRequiredAnswer() {
		return this.requiredAnswer;
	}

	public void setRequiredAnswer(String requiredAnswer) {
		this.requiredAnswer = requiredAnswer;
	}

	public Date getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Long getSendDateXML() {
		return sendDateXML;
	}

	public void setSendDateXML(Long sendDateXML) {
		this.sendDateXML = sendDateXML;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", createdAt=" + createdAt + ", description=" + description + ", documentCode="
				+ documentCode + ", documentType=" + documentType + ", forMessageId=" + forMessageId + ", fromUnitCode="
				+ fromUnitCode + ", modifiedAt=" + modifiedAt + ", numberReceived=" + numberReceived + ""
				+ ", option=" + option + ", requiredAnswer=" + requiredAnswer + ", sendDate=" + sendDate 
				+ ", sendDateXML=" + sendDateXML
				+ ", signature=" + signature
				+ ", status=" + status + ", attchFileList = " + attachFileList + "]";
	}

}