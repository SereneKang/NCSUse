package com.ncs.api.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class TestScore {

	@Id
	private int TestId;
	
	private Date Date;
	private String Catogery;
	private String Level;
	@Column(name="TotalScore")
	private int TotalScore;
	@Column(name="Marks")
	private int Total_Marks;
	
	
	
	public TestScore() {
		super();
	}

	public TestScore(int testId, Date date, String catogery, String level, int totalScore, int total_Marks) {
		super();
		TestId = testId;
		Date = date;
		Catogery = catogery;
		Level = level;
		TotalScore = totalScore;
		Total_Marks = total_Marks;
	}


	public int getTestId() {
		return TestId;
	}


	public void setTestId(int testId) {
		TestId = testId;
	}

	

	public Date getDate() {
		return Date;
	}



	public void setDate(Date date) {
		Date = date;
	}



	public String getCatogery() {
		return Catogery;
	}



	public void setCatogery(String catogery) {
		Catogery = catogery;
	}



	public String getLevel() {
		return Level;
	}



	public void setLevel(String level) {
		Level = level;
	}



	public int getTotalScore() {
		return TotalScore;
	}



	public void setTotalScore(int totalScore) {
		TotalScore = totalScore;
	}



	public int getTotal_Marks() {
		return Total_Marks;
	}



	public void setTotal_Marks(int total_Marks) {
		Total_Marks = total_Marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Catogery == null) ? 0 : Catogery.hashCode());
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + ((Level == null) ? 0 : Level.hashCode());
		result = prime * result + TestId;
		result = prime * result + TotalScore;
		result = prime * result + Total_Marks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestScore other = (TestScore) obj;
		if (Catogery == null) {
			if (other.Catogery != null)
				return false;
		} else if (!Catogery.equals(other.Catogery))
			return false;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (Level == null) {
			if (other.Level != null)
				return false;
		} else if (!Level.equals(other.Level))
			return false;
		if (TestId != other.TestId)
			return false;
		if (TotalScore != other.TotalScore)
			return false;
		if (Total_Marks != other.Total_Marks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestScore [TestId=" + TestId + ", Date=" + Date + ", Catogery=" + Catogery + ", Level=" + Level
				+ ", TotalScore=" + TotalScore + ", Total_Marks=" + Total_Marks + "]";
	}




	
	
}