package bean;

import javax.persistence.EntityManager;

import model.MessageContent;

/**
 *
 * @author NguyenThanhChien
 */
public class MessageContentJpaController extends AbstractBean<MessageContent> {

	public MessageContentJpaController() {
		super(MessageContent.class);
	}
    
}
