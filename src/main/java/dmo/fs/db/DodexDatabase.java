package dmo.fs.db;

import java.util.List;

import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.NonBlockingConnectionPool;

import io.vertx.core.http.ServerWebSocket;

public interface DodexDatabase {

	public String getAllUsers();

	public Long addUser(ServerWebSocket ws, Database db, MessageUser messageUser) throws InterruptedException;

	public long deleteUser(ServerWebSocket ws, Database db, MessageUser messageUser) throws InterruptedException;

	public long addMessage(ServerWebSocket ws, MessageUser messageUser, String message) throws InterruptedException;

	public int addUndelivered(ServerWebSocket ws, List<String> undelivered, Long messageId);

	public Long getUserIdByName(String name) throws InterruptedException;

	public void addUndelivered(Long userId, Long messageId) throws InterruptedException;

	public int processUserMessages(ServerWebSocket ws, MessageUser messageUser);

	public Database getDatabase();

	public NonBlockingConnectionPool getPool();

	public MessageUser createMessageUser();

	public MessageUser selectUser(MessageUser messageUser, ServerWebSocket ws);

	public StringBuilder buildUsersJson(MessageUser messageUser) throws InterruptedException;

}