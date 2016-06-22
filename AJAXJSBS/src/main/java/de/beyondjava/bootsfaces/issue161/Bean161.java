package de.beyondjava.bootsfaces.issue161;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Bean161 {
	private String text="Original text";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String ok() {
		System.out.println("submit");
		text="You closed the modal dialog again.";
		return null;
	}
}
