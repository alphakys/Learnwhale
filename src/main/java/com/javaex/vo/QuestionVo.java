package com.javaex.vo;

public class QuestionVo {

	private int questionNo, examNo, problemNo, point, orderNum;
	private String problemTitle, problemType;

	public QuestionVo() {
	}

	public QuestionVo(int questionNo, int examNo, int problemNo, int point, int orderNum, String problemTitle,
			String problemType) {
		this.questionNo = questionNo;
		this.examNo = examNo;
		this.problemNo = problemNo;
		this.point = point;
		this.orderNum = orderNum;
		this.problemTitle = problemTitle;
		this.problemType = problemType;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public int getProblemNo() {
		return problemNo;
	}

	public void setProblemNo(int problemNo) {
		this.problemNo = problemNo;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	@Override
	public String toString() {
		return "QuestionVo:questionNo=" + questionNo + ", examNo=" + examNo + ", problemNo=" + problemNo + ", point="
				+ point + ", orderNum=" + orderNum + ", problemTitle=" + problemTitle + ", problemType=" + problemType
				+ "]";
	}
	
	

}
