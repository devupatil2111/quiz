package com.velocity.quiz;

public class Question {

	private int que_no;
	private String Question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	private String CorrectAns;

	public int getQue_no() {
		return que_no;
	}

	public void setQue_no(int que_no) {
		this.que_no = que_no;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOptionA() {
		return OptionA;
	}

	public void setOptionA(String optionA) {
		OptionA = optionA;
	}

	public String getOptionB() {
		return OptionB;
	}

	public void setOptionB(String optionB) {
		OptionB = optionB;
	}

	public String getOptionC() {
		return OptionC;
	}

	public void setOptionC(String optionC) {
		OptionC = optionC;
	}

	public String getOptionD() {
		return OptionD;
	}

	public void setOptionD(String optionD) {
		OptionD = optionD;
	}

	public String getCorrectAns() {
		return CorrectAns;
	}

	public void setCorrectAns(String correctAns) {
		CorrectAns = correctAns;
	}

	@Override
	public String toString() {
		return "Question [que_no=" + que_no + ", Question=" + Question + ", OptionA=" + OptionA + ", OptionB=" + OptionB
				+ ", OptionC=" + OptionC + ", OptionD=" + OptionD + ", CorrectAns=" + CorrectAns + "]";
	}

}
