package br.edu.univas.vo;

public class CountNum implements Comparable<CountNum> {
	
	private String id;
	private int count;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] ";
	}

	@Override
	public int compareTo(CountNum numComp) {
		return (numComp.getCount() - this.count);
	}	
}
