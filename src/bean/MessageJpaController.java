package bean;

import java.util.Date;

import bean.exceptions.PreexistingEntityException;
import model.Message;
import model.MessageContent;
import model.MessageFile;

/**
 *
 * @author NguyenThanhChien
 */
public class MessageJpaController extends AbstractBean<Message> {

	public MessageJpaController() {
		super(Message.class);
	}

	public int create(Message message, MessageContent messageContent) throws PreexistingEntityException {
		try {
            em = getEntityManager();
            em.getTransaction().begin();
            for (MessageFile messageFile : message.getAttachFileList()) {
				messageFile.setMessageId(message.getId());
				messageFile.setCreatedAt(new Date());
				em.persist(messageFile);
			}
            em.persist(messageContent);
            em.persist(message);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (find(message.getId()) != null) {
//            	TODO: gọi tên bảng từ annotation để thông báo rõ ràng hơn trên UI
                throw new PreexistingEntityException("Message ID: " + message.getId() + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
		return 0;
	}

}
