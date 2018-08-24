package logofatu.galina.messenger.service;

import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;
import java.util.Map;

import logofatu.galina.messenger.database.DatabaseClass;
import logofatu.galina.messenger.model.Comment;
import logofatu.galina.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
//	public CommentService() {
//		messages.put(1L, new Message(1L,"Hello World!", "galina"));
//		messages.put(2L, new Message(2L,"Hello Jersey!", "galina"));
//	}
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
//	public List<Message> getAllMessagesForYear(int year){
//		List<Message> mesagesForYear = new ArrayList<>();
//		Calendar cal = Calendar.getInstance();
//		for (Message message : messages.values()) {
//			cal.setTime(message.getCreated());
//			if (cal.get(Calendar.YEAR) == year) {
//				mesagesForYear.add(message);
//			}
//		}
//		return mesagesForYear;
//	}
	
//	public List<Message> getAllMessagesPaginated(int start, int size){
//		ArrayList<Message> list = new ArrayList<Message>(messages.values());
//		if (start + size > list.size()) return new ArrayList<Message>();
//		return list.subList(start, start + size);
//	}
	
//	public Message getMessage(long id){
//		return messages.get(id);
//	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
