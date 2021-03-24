package myapp.exercise;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Student {
	// 필드
	String name, koScore, engScore, mathScore;
	Student[] std = new Student[10];
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKoScore() {
		return koScore;
	}
	public void setKoScore(String koScore) {
		this.koScore = koScore;
	}
	public String getEngScore() {
		return engScore;
	}
	public void setEngScore(String engScore) {
		this.engScore = engScore;
	}
	public String getMathScore() {
		return mathScore;
	}
	public void setMathScore(String mathScore) {
		this.mathScore = mathScore;
	}
	public Student[] getStd() {
		return std;
	}
	public void setStd(Student[] std) {
		this.std = std;
	}

	
	
//-----------------------------------------------------------	
//	SimpleStringProperty name;
//	SimpleIntegerProperty koScore;
//	SimpleIntegerProperty mathScore;
//	SimpleIntegerProperty engScore;
	// 생성자
//	public Student() {
//		name = new SimpleStringProperty();
//		koScore = new SimpleIntegerProperty();
//		mathScore = new SimpleIntegerProperty();
//		engScore = new SimpleIntegerProperty();
//	}

	// 메소드	
//	// 1)이름얻기
//	public void setName(String name) {
//		this.name.set(name);
//	}
//
//	public String getName() {
//		return this.name.get();
//	}
//
//	public SimpleStringProperty nameProperty() {
//		return this.name;
//	}
//
//	// 2)국어점수 얻기
//	public void setKoScore(int koScore) {
//		this.koScore.set(koScore);
//	}
//
//	public int getKoScore() {
//		return this.koScore.get();
//	}
//
//	public SimpleIntegerProperty koscoreProperty() {
//		return this.koScore;
//	}
//
//	// 3)수학점수 얻기
//	public void setMathScore(int mathScore) {
//		this.mathScore.set(mathScore);
//	}
//
//	public int getMathScore() {
//		return this.mathScore.get();
//	}
//
//	public SimpleIntegerProperty mathScoreProperty() {
//		return this.mathScore;
//	}
//
//	// 4)영어점수 얻기
//	public void setEngScore(int engScore) {
//		this.engScore.set(engScore);
//	}
//
//	public int getEngScore() {
//		return this.engScore.get();
//	}
//
//	public SimpleIntegerProperty engScoreProperty() {
//		return this.engScore;
//	}

}
