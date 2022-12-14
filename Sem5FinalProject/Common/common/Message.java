package common;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object content;
	private Command command;
	
	public Message(Object content, Command command) {
		this.content = content;
		this.command = command;
	}
	
	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return "Message of type: " + command;
	}
}
