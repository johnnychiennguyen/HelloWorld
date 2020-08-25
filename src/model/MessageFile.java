package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import java.sql.Timestamp;


/**
 * The persistent class for the message_file database table.
 * 
 */
@Entity
@Table(name="message_file")
@NamedQuery(name="MessageFile.findAll", query="SELECT m FROM MessageFile m")
@XmlRootElement(name = "attach-file")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "attach-file-id")
	@Id
	private String id;

	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@XmlElement(name = "extension")
	@Column(name="file_extension")
	private String fileExtension;

	@XmlElement(name = "file-name")
	@Column(name="file_name")
	private String fileName;

	@XmlElement(name = "mime-type")
	@Column(name="file_path")
	private String filePath;

	@XmlElement(name = "file-size")
	@Column(name="file_size")
	private double fileSize;

	@Column(name="message_id")
	private String messageId;

	@XmlElement(name = "title")
	private String title;

	public MessageFile() {
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

	public String getFileExtension() {
		return this.fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public double getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MessageFile [id=" + id + ", createdAt=" + createdAt + ", fileExtension=" + fileExtension + ", fileName="
				+ fileName + ", filePath=" + filePath + ", fileSize=" + fileSize + ", messageId=" + messageId
				+ ", title=" + title + "]";
	}

}