package model;

import java.sql.Timestamp;

//todosテーブルのレコードを表示

public class Todo {
	private int id; //ID
	private String title; //title
	private String content;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Todo() {
	}

	public Todo(int id, String title, String content, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;

	}

	public String getContent() {
		return content;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

}
