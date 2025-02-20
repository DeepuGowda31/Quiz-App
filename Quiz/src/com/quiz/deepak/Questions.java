package com.quiz.deepak;

public class Questions {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private char answer;
	private String difficulty;

	public Questions(String question, String option1, String option2, String option3, String option4, char answer,
			String difficulty) {
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return question;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getOption4() {
		return option4;
	}

	public char getAnswer() {
		return answer;
	}

	public String getDifficulty() {
		return difficulty;
	}
}
