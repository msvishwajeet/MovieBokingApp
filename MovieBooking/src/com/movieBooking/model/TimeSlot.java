package com.movieBooking.model;

public class TimeSlot {
	public TimeSlot(Time from,Time to) {
	}
	private Time from;
	private Time to;
	
	public Time getFrom() {
		return from;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public Time getTo() {
		return to;
	}

	public void setTo(Time to) {
		this.to = to;
	}

	public static class Time {
		private int hour;
		private int minute;
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getMinute() {
			return minute;
		}
		public void setMinute(int minute) {
			this.minute = minute;
		}
		
	}
}
