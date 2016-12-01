/**
 * 
 */
package com.niit.page;

/**
 * 分页实体类
 * @author Admin
 *
 */
public class Page {

	private int pageSize=5;    // 每页显示5条数据
	private int totalCount=0;  // 总记录数 需要查询
	private int totalPage=0;   // 总的页数 需要计算
	private int currentPage=1; // 当前页的页码 每次单击  翻页超链接（上一页 下一页 页码等） 都需要更新

	private int beginIndex=0;  // 存放起始索引的变量  存放 (currentPage-1)*pageSize
	
	// 生成get set之后 需要 手动计算那些 需要计算的变量+
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(totalCount%pageSize==0){// 能够整除 
			return totalCount/pageSize;
		}else{
			return totalCount/pageSize+1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getBeginIndex() {
		return (currentPage-1)*pageSize;// 计算起始索引
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
}
