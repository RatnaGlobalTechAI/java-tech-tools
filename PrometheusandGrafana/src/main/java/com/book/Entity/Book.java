package com.book.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
public class Book {

	// @Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
//	@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_sequence", allocationSize = 2)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
//	@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_sequence", allocationSize = 3)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "book_table_gen")
	@TableGenerator(name = "book_table_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", allocationSize = 3)
	private Integer id;
	private String title;
	private String author;
	private Boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Book() {

	}

}