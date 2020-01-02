package com.fh.utiles;

import java.util.List;

public class PageBean<T> {

	private 		Integer start; //开始下标
	private 		Integer length ;//每页条数
	private  Integer draw=1;//绘制数
	private 		List<T> data;//数据
	private  Integer recordsTotal;//过滤长度
	private  Integer recodsFilterd;//总长度

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecodsFilterd() {
		return recodsFilterd;
	}

	public void setRecodsFilterd(Integer recodsFilterd) {
		this.recodsFilterd = recodsFilterd;
	}
}
