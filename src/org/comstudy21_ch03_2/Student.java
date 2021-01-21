package org.comstudy21_ch03_2;

class Student {
	String name;
	String major;
	double score;
	int rank;

	Student() {
	}

	Student(String name, String major, double score, int rank) {
		this.name = name;
		this.major = major;
		this.score = score;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("성명 = %s, 학과 = %s, 성적 = %.01f, 등수 = %d\n", name, major, score, rank);
	}
}
//성적순에 따라 등수를 자동으로 매기는프로그램
